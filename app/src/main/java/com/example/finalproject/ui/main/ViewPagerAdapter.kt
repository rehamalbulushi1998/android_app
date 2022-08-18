package com.example.finalproject.ui.main


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.finalproject.RegisterFragment
import com.example.finalproject.SecondFragment

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return   when(position){
            0->{
                SecondFragment()
            }

            else->{
                RegisterFragment()
            }

        }
    }
}
