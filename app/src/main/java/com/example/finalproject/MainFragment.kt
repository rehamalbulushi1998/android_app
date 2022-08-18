package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.finalproject.ui.main.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    @Override
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout = requireActivity().findViewById<TabLayout>(R.id.tablayout)
        tabLayout.addTab(tabLayout.newTab().setText("Login"))
        tabLayout.addTab(tabLayout.newTab().setText("Signup"))

        val viewPager2= requireActivity().findViewById<ViewPager2>(R.id.view_pager_2)

        val adapter= ViewPagerAdapter(childFragmentManager,lifecycle)

        viewPager2.adapter=adapter

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                tabLayout.getTabAt(position)?.select()
            }
        })

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager2.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                //Do nothing
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                //Do nothing
            }
        })


//        TabLayoutMediator(tabLayout,viewPager2){tab,position->
//            when(position){
//                0->{
//                    tab.text="Login"
//                }
//                1->{
//                    tab.text="Signup"
//                }
//
//            }
//        }.attach()

//        tabLayout.addTab(tabLayout.newTab().setText("Login"))
//        tabLayout.addTab(tabLayout.newTab().setText("Signup"))
    }


}