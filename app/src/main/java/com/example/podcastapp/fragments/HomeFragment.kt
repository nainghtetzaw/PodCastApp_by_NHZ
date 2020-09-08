package com.example.podcastapp.fragments

import android.Manifest
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.SeekBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.podcastapp.R
import com.example.podcastapp.activities.PodCastDetailActivity
import com.example.podcastapp.adapters.UpNextAdapter
import com.example.podcastapp.data.vos.RandomPodCastVO
import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.example.podcastapp.data.vos.UpNextVO
import com.example.podcastapp.mvp.presenters.implementations.HomePresenterImpl
import com.example.podcastapp.mvp.presenters.interfaces.HomePresenter
import com.example.podcastapp.mvp.views.HomeView
import com.example.podcastapp.utils.PARAM_DOWNLOAD_URI
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.viewpod_media.*

private lateinit var linearLayoutManager: LinearLayoutManager
private lateinit var upNextAdapter: UpNextAdapter
private lateinit var mPresenter: HomePresenter

class HomeFragment : Fragment(), HomeView {

    private val REQUEST_CODE = 100
    private var isAudioPlaying: Boolean = false
    private var myDownloadId : Long = 0
    private var mDownloadedData : UpNextVO = UpNextVO()

    private val br = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            val id = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 1)
            if(id == myDownloadId){
                activity?.let {
                    Toast.makeText(it.applicationContext, "Download Complete", Toast.LENGTH_SHORT).show()
                    mPresenter.saveDownloadData(mDownloadedData)
                }
            }
        }
    }

    private lateinit var mMediaPlayer: SimpleExoPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpPresenter()
        setUpRecyclerView()
        setUpTouchAnimationAndButtonEventsAndSeekbar()
        initBroadCastReceiver()
        activity?.let {
            mPresenter.onUiReady(it.applicationContext, this)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun showRandomPodCastData(data: RandomPodCastVO) {
        Glide.with(this)
            .load(data.image)
            .into(imgPodCastPosterMedia)
        tvPodcastTitle.text = data.title
        tvPodCastDescription.text = data.description
        tvPodcastAbout.text = data.podcast.podcastTitle
        tvPodCastDescription
        setUpMediaPlayer(data.audio)
    }

    override fun showUpNextPodCastData(data: List<UpNextPodCastVO>) {
        upNextAdapter.setNewData(data.toMutableList())
    }

    override fun makeDownloadProgress(data: UpNextPodCastVO) {
        mDownloadedData = data.data
        activity?.let {
            if (ContextCompat.checkSelfPermission(it.applicationContext,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_CODE
                )
            } else {
                download(data.data)
            }
        }
    }

    override fun navigateToDetail(id: String) {
        startActivity(PodCastDetailActivity.newIntent(activity, id))
    }

    private fun initBroadCastReceiver(){
        context?.registerReceiver(br, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpTouchAnimationAndButtonEventsAndSeekbar() {
        val animation = AnimationUtils.loadAnimation(activity, R.anim.touch_anim)
        imgPause.setOnClickListener {
            imgPause.startAnimation(animation)
            if (!isAudioPlaying) {
                mMediaPlayer.playWhenReady = true
                imgPause.setImageResource(R.drawable.ic_baseline_pause_24)
                isAudioPlaying = true
            } else {
                mMediaPlayer.playWhenReady = false
                imgPause.setImageResource(R.drawable.ic_baseline_play_arrow_24)
                isAudioPlaying = false
            }
        }
        imgNoti.setOnClickListener {
            imgNoti.startAnimation(animation)
        }
        imgOption.setOnClickListener {
            imgOption.startAnimation(animation)
        }
        imgSkip.setOnClickListener {
            it.startAnimation(animation)
            mMediaPlayer.seekTo(mMediaPlayer.currentPosition + 30000)
        }
        imgPrevious.setOnClickListener {
            it.startAnimation(animation)
            mMediaPlayer.seekTo(mMediaPlayer.currentPosition - 10000)
        }
    }

    private fun setUpRecyclerView() {
        linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        upNextAdapter = UpNextAdapter(mPresenter)
        rviewUpNext.layoutManager = linearLayoutManager
        rviewUpNext.adapter = upNextAdapter
    }

    private fun setUpMediaPlayer(audio: String) {
        activity?.let {
            val defaultRenderersFactory = DefaultRenderersFactory(it.applicationContext)
            mMediaPlayer =
                SimpleExoPlayer.Builder(it.applicationContext, defaultRenderersFactory).build()
            val userAgent = Util.getUserAgent(it.applicationContext, "The PodCast App")
            val mediaSource = ExtractorMediaSource(
                Uri.parse(audio),
                DefaultDataSourceFactory(it.applicationContext, userAgent),
                DefaultExtractorsFactory(),
                null,
                null
            )
            mMediaPlayer.prepare(mediaSource)
        }
    }

    private fun download(data: UpNextVO){
        val request = DownloadManager.Request(
            Uri.parse(PARAM_DOWNLOAD_URI)
        )
            .setTitle("Downing Audio")
            .setDestinationInExternalFilesDir(context,Environment.DIRECTORY_DOWNLOADS,"PodCastAudio.mp3")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
            .setAllowedOverMetered(true)
            .setAllowedOverRoaming(true)
        val dm = activity?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        myDownloadId = dm.enqueue(request)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE -> if (grantResults.isNotEmpty() &&
                grantResults[0] === PackageManager.PERMISSION_GRANTED) {
                download(mDownloadedData)
            }
        }
    }

    private fun releasePlayer() {
        mMediaPlayer.release()
    }

    override fun onDestroy() {
        releasePlayer()
        super.onDestroy()
    }

}