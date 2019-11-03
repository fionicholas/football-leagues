package com.fionicholas.footballleague.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Football (
    val name: String,
    val id: String,
    val description: String,
    val image: Int
) : Parcelable