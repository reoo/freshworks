package com.raulomana.freshworks

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.raulomana.freshworks.databinding.ActivityMainBinding
import com.raulomana.freshworks.favs.FavsFragment
import com.raulomana.freshworks.search.SearchFragment

private const val PAGES = 2;

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainTabs.setupWithViewPager(binding.mainViewpager.apply {
            adapter = MainPagerAdapter(supportFragmentManager, this@MainActivity)
        })


    }

    private inner class MainPagerAdapter(fm: FragmentManager, val context: Context) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int) = when(position) {
            0 -> SearchFragment.newInstance()
            else -> FavsFragment.newInstance()
        }

        override fun getCount() = PAGES

        override fun getPageTitle(position: Int): CharSequence? = when(position) {
            0 -> context.getString(R.string.page_title_trending)
            else -> context.getString(R.string.page_title_favs)
        }

    }

}