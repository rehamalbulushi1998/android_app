package com.example.finalproject

import android.content.Context
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RequestManager(mathContext: Context) {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://api.quotable.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun GetAllQuotes(listner: QuotesResponseListner){
    val call = retrofit.create(CallQuotes::class.java).callQuotes()
    call.enqueue(object : Callback<List<QuotesResponse>> {
        override fun onResponse(
            call: Call<List<QuotesResponse>>,
            response: Response<List<QuotesResponse>>
        ) {
            if (!response.isSuccessful) {
                listner.didError(response.message())
            }
            response.body()?.let { listner.didFetch(it, response.message()) }

        }

        override fun onFailure(call: Call<List<QuotesResponse>>, t: Throwable) {
           t.message.let {
               if (it != null) {
                   listner.didError(it)
               }
           }
        }

    })

}

    private interface CallQuotes {
        @GET("quotes")
        fun callQuotes(): Call<List<QuotesResponse>>
    }


}