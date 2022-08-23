package com.example.finalproject

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.finalproject.ui.main.QuotesListAdapter
import com.google.android.gms.common.api.Response
import kotlinx.android.synthetic.main.activity_main2.*
import retrofit2.Call
import retrofit2.Callback
import java.util.Calendar.getInstance
import java.util.Currency.getInstance

/**
 * Loads [MainFragment2].
 */
class MainActivity2() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rv_quotes_list.layoutManager = LinearLayoutManager(this)
        rv_quotes_list.setHasFixedSize(true)
        getMovieData { quotes : List<Quote> ->
            rv_quotes_list.adapter = QuotesListAdapter(quotes)
        }

    }

    private fun getMovieData(callback: (List<Quote>) -> Unit){
        val apiService = QuoteApiService.getInstance().create(QuoteApiInterface::class.java)
        apiService.getQuoteList().enqueue(object : Callback<QuotesResponse> {
            override fun onFailure(call: Call<QuotesResponse>, t: Throwable) {

            }


            override fun onResponse(
                call: Call<QuotesResponse>,
                response: retrofit2.Response<QuotesResponse>
            ) {
                return callback(response.body()!!.quotes)
            }

        })
    }
}