package com.bignerdranch.android.pr22_karamov

data class User(var login: String, var password: String, var visibleName: String, var favMovies: MutableList<Movie>)
{
}