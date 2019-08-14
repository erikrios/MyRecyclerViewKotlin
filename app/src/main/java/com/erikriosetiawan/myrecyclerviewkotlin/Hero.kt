package com.erikriosetiawan.myrecyclerviewkotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(
    var name: String = "",
    var from: String = "",
    var photo: String = ""): Parcelable