package com.algebra.retrofit

import com.algebra.retrofit.model.JokeResponse
import retrofit2.Call
import retrofit2.http.GET

interface JokeService {
    @GET( "jokes/random/3" )
    fun getRandomJokes( ) : Call< JokeResponse >
}