package com.example.podcastapp.activities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.podcastapp.R
import com.example.podcastapp.data.vos.PodCastDetailVO
import com.example.podcastapp.data.vos.UpNextVO
import com.example.podcastapp.mvp.presenters.implementations.PodCastDetailPresenterImpl
import com.example.podcastapp.mvp.presenters.interfaces.PodCastDetailPresenter
import com.example.podcastapp.mvp.views.PodCastDetailView
import com.example.podcastapp.utils.PARAM_DOWNLOAD_URI
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_pod_cast_detail.*
import kotlinx.android.synthetic.main.viewpod_detail_media.*


class PodCastDetailActivity : AppCompatActivity(), PodCastDetailView {

    private lateinit var mPresenter: PodCastDetailPresenter
    private lateinit var mMediaPlayer: SimpleExoPlayer
    private var isAudioPlaying : Boolean = false

    companion object {
        const val PODCAST_ID = "PODCAST_ID"
        const val PODCAST_NAME = "PODCAST_NAME"
        const val PODCAST_DESCRIPTION = "PODCAST_DESCRIPTION"
        const val PODCAST_AUDIO = "PODCAST_AUDIO"
        const val PODCAST_AUDIO_LENGTH = "PODCAST_AUDIO_LENGTH"
        const val PODCAST_IMAGE = "PODCAST_IMAGE"
        fun newIntent(context: Context?,id: String,name : String,description: String,audio : String,audioLength : Int,image : String): Intent {
            val intent = Intent(context, PodCastDetailActivity::class.java)
                .putExtra(PODCAST_ID,id)
                .putExtra(PODCAST_NAME,name)
                .putExtra(PODCAST_DESCRIPTION,description)
                .putExtra(PODCAST_AUDIO,audio)
                .putExtra(PODCAST_AUDIO_LENGTH,audioLength)
                .putExtra(PODCAST_IMAGE,image)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pod_cast_detail)
        setUpPresenter()
        showData()
        setTouchAnimationOnButtons()
    }

    private fun showData(){
        val podcastId = intent.getStringExtra(PODCAST_ID)
        val podcastName = intent.getStringExtra(PODCAST_NAME)
        val podcastDescription = intent.getStringExtra(PODCAST_DESCRIPTION)
        val podcastAudio = intent.getStringExtra(PODCAST_AUDIO)
        val podcastAudioLength = intent.getIntExtra(PODCAST_AUDIO_LENGTH,0)
        val podcastImage = intent.getStringExtra(PODCAST_IMAGE)
        Glide.with(this)
            .load(podcastImage)
            .into(imgPodCastPosterDetail)
        tvPodcastTitleDetail.text = podcastName
        tvPodCastDescriptionDetail.text = Html.fromHtml(podcastDescription)
        tvTotalPodCastTime.text = "${convertSecIntoMinute(podcastAudioLength)} m"
        tvPodCastStartTime.text = convertSecIntoMinute(0)
        tvPodCastEndTimeDetail.text = convertSecIntoMinute(podcastAudioLength)
        podcastAudio?.let {
            setUpMediaPlayer(it)
        }
    }

    override fun showPodCastDetailData(data: UpNextVO) {

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(PodCastDetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun convertSecIntoMinute(second: Int): String {
        val secondInMinute = 60
        val minute = second / secondInMinute
        val result = second % secondInMinute
        var totaltime = ""
        if(minute > 9 && result > 9){
            totaltime = "$minute : $result"
        }else if(minute < 10 && result > 9){
            totaltime = "0$minute : $result"
        }else if(minute > 9 && result < 10){
            totaltime = "$minute : 0$result"
        }else {
            totaltime = "0$minute : 0$result"
        }
        return totaltime
    }

    private fun setTouchAnimationOnButtons() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.touch_anim)
        imgPauseDetail.setOnClickListener {
            it.startAnimation(animation)
            if (!isAudioPlaying) {
                mMediaPlayer.playWhenReady = true
                imgPauseDetail.setImageResource(R.drawable.ic_baseline_pause_24)
                isAudioPlaying = true
            } else if (isAudioPlaying) {
                mMediaPlayer.playWhenReady = false
                imgPauseDetail.setImageResource(R.drawable.ic_baseline_play_arrow_24)
                isAudioPlaying = false
            } else {
                mMediaPlayer.playWhenReady = false
                imgPauseDetail.setImageResource(R.drawable.ic_baseline_play_arrow_24)
                isAudioPlaying = false
            }
        }
        imgSkipDetail.setOnClickListener {
            it.startAnimation(animation)
            mMediaPlayer.seekTo(mMediaPlayer.currentPosition + 30000)
        }
        imgPreviousDetail.setOnClickListener {
            it.startAnimation(animation)
            mMediaPlayer.seekTo(mMediaPlayer.currentPosition - 10000)
        }
    }

    private fun setUpMediaPlayer(audio : String) {
        val defaultRenderersFactory = DefaultRenderersFactory(this)
        mMediaPlayer =
            SimpleExoPlayer.Builder(this, defaultRenderersFactory).build()
        val userAgent = Util.getUserAgent(this, "The PodCast App")
//        val mediaSource = ExtractorMediaSource(
//            Uri.parse(PARAM_DOWNLOAD_URI),
//            DefaultDataSourceFactory(this, userAgent),
//            DefaultExtractorsFactory(),
//            null,
//            null
//        )
        val defaultDataSourceFactory = DefaultDataSourceFactory(this,"PodCast")
        val mediaSource = ProgressiveMediaSource.Factory(defaultDataSourceFactory).createMediaSource(Uri.parse(audio))
        mMediaPlayer.addListener(object : Player.EventListener{
            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                super.onPlayerStateChanged(playWhenReady, playbackState)
                if(playbackState == ExoPlayer.STATE_BUFFERING){
                    val result = mMediaPlayer.currentPosition * 100 / mMediaPlayer.duration
                    pbPodCastSeekBar.progress = result.toInt()
                }
            }
        })
        mMediaPlayer.prepare(mediaSource)
    }

    private fun releasePlayer() {
        mMediaPlayer.release()
    }

    override fun onDestroy() {
        releasePlayer()
        super.onDestroy()
    }

}