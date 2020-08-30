package com.example.podcastapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.podcastapp.R
import com.example.podcastapp.fragments.Downloaded_Shows_fragment
import com.example.podcastapp.fragments.HomeFragment
import com.example.podcastapp.fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragment1 : HomeFragment = HomeFragment.newInstance("a","b")
    private val fragment2 : Downloaded_Shows_fragment = Downloaded_Shows_fragment.newInstance("a","b")
    private val fragment3 : SearchFragment = SearchFragment.newInstance("a","b")

    override fun onCreate(savedInstanceState: Bundle?) {
        var activeFragment : Fragment = fragment1
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        identifyFragments()

        btnNavigation.setOnNavigationItemSelectedListener {item ->
            when(item.itemId){
                R.id.menuHome -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(fragment1).commit()
                    activeFragment = fragment1
                    true
                }
                R.id.menuDownload -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(fragment2).commit()
                    activeFragment = fragment2
                    true
                }
                else -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(fragment3).commit()
                    activeFragment = fragment3
                    true
                }
            }
        }
    }

    private fun identifyFragments(){
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment1)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment2)
            .hide(fragment2)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container,fragment3)
            .hide(fragment3)
            .commit()
    }
}