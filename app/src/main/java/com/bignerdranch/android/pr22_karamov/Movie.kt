package com.bignerdranch.android.pr22_karamov

import android.media.Image

data class Movie(val id: Long, val year: Int, val name: String, val rating: Double, val image: Image) {
}