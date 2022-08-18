package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

/**
 * Loads [MainFragment2].
 */
class MainActivity2 : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_browse_fragment, MainFragment2())
                .commitNow()
        }
    }
}