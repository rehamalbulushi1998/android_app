package com.example.finalproject

import retrofit2.Call
import retrofit2.http.GET

interface QuoteApiInterface {
    @GET("/quotes")
    fun getQuoteList(): Call<QuotesResponse>
}