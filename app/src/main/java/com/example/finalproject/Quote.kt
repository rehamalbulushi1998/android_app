package com.example.finalproject

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize

data class Quote (

    @SerializedName("author")
    val author : String?,

    @SerializedName("content")
    val content : String?

    ) : Parcelable{
        constructor() : this("", "")
    }
