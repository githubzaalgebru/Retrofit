package com.algebra.retrofit.model

import com.google.gson.annotations.SerializedName
// import com.squareup.moshi.Json

/*
// Anotacije za Moshi
class Joke( @field:Json( name="id" )         val id : Int,
            @field:Json( name="joke" )       val joke : String,
            @field:Json( name="categories" ) val categories : List< String > )

class JokeResponse( @field:Json( name="type" )   val type : String,
                    @field:Json( name ="value" ) val value : List< Joke > )

*/

// Anotacije za GSON
class Joke( @SerializedName( "id" )         val id : Int,
            @SerializedName( "joke" )       val joke : String,
            @SerializedName( "categories" ) val categories : List< String > )

class JokeResponse( @SerializedName( "type" )   val type : String,
                    @SerializedName( "value" )  val value : List< Joke > )