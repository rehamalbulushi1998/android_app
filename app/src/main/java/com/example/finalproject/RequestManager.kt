package com.example.finalproject

import android.content.Context
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RequestManager(mathContext: Context) {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://api.quotable.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private interface CallQuotes {
        @GET("quotes")
        fun callQuotes(): Call<List<QuotesResponse>>
    }


}