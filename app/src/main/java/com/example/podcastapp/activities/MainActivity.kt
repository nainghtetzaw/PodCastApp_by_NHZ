package com.example.podcastapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.podcastapp.R
import com.example.podcastapp.fragments.DownloadedShowsFragment
import com.example.podcastapp.fragments.HomeFragment
import com.example.podcastapp.fragments.SearchFragment
import com.example.podcastapp.mvp.presenters.implementations.MainPresenterImpl
import com.example.podcastapp.mvp.presenters.interfaces.MainPresenter
import com.example.podcastapp.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val fragment1: HomeFragment = HomeFragment()
    private val fragment2: DownloadedShowsFragment = DownloadedShowsFragment()
    private val fragment3: SearchFragment = SearchFragment()
    private lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpPresenter()
        identifyFragments()
        bottomNaviEventListener()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun identifyFragments() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment1)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment2)
            .hide(fragment2)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment3)
            .hide(fragment3)
            .commit()
    }

    private fun bottomNaviEventListener() {

        var activeFragment: Fragment = fragment1

        btnNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menuHome -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(fragment1)
                        .commit()
                    activeFragment = fragment1
                    true
                }
                R.id.menuDownload -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(fragment2)
                        .commit()
                    activeFragment = fragment2
                    true
                }
                else -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(fragment3)
                        .commit()
                    activeFragment = fragment3
                    true
                }
            }
        }
    }
}