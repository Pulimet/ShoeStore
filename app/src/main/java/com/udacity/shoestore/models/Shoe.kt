package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    val name: String,
    val size: Double,
    val company: String,
    val description: String,
    val images: List<String> = mutableListOf()
) : Parcelable