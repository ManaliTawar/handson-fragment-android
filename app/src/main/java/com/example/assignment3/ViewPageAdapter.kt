package com.example.assignment3

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

import androidx.lifecycle.Lifecycle


class ViewPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        return MovieFragment( position )
    }

    override fun getItemCount(): Int {
        return 3
    }
}