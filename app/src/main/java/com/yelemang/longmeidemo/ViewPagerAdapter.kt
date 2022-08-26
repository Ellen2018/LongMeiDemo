package com.yelemang.longmeidemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStatePagerAdapter(fragmentActivity.supportFragmentManager) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return TestFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return position.toString()
    }

}