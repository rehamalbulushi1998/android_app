package com.example.finalproject

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.finalproject.ui.main.QuotesListAdapter
import kotlinx.android.synthetic.main.activity_main2.*

/**
 * Loads [MainFragment2].
 */
class MainActivity2() : FragmentActivity(), Parcelable {
    var dialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_browse_fragment, MainFragment2())
                .commitNow()
        }
        RequestManager(this@MainActivity2).GetAllQuotes(listener)
        dialog = ProgressDialog(this@MainActivity2)
        dialog?.setTitle("Loading...")
        dialog?.show()

    }
    private val listener: QuotesResponseListner = object : QuotesResponseListner {
        override fun didFetch(response: List<QuotesResponse>, message: String) {
            dialog?.dismiss()
            qouterecyclerview.setHasFixedSize(true)
            qouterecyclerview.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            val adapter = QuotesListAdapter(this@MainActivity2, response)
            qouterecyclerview. adapter = adapter
        }

        override fun didError(message: String) {
            dialog?.dismiss()
            Toast.makeText(this@MainActivity2, message, Toast.LENGTH_LONG).show()

        }

    }

    constructor(parcel: Parcel) : this() {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity2> {
        override fun createFromParcel(parcel: Parcel): MainActivity2 {
            return MainActivity2(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity2?> {
            return arrayOfNulls(size)
        }
    }


}