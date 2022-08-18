package com.example.finalproject

interface QuotesResponseListner {
    fun didFetch(response: List<QuotesResponse>, message: String)
    fun didError(message: String)
}