package com.example.finalproject
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuotesResponse (
    @SerializedName("results")
    val quotes : List<Quote>

) : Parcelable {
    constructor() : this(mutableListOf())

}