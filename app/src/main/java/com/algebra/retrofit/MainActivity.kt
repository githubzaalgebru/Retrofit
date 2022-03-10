package com.algebra.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.algebra.retrofit.model.JokeResponse
import com.readystatesoftware.chuck.ChuckInterceptor
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit
import java.lang.StringBuilder

import retrofit2.converter.gson.GsonConverterFactory
// import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : AppCompatActivity( ) {

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        dohvatiSale.setOnClickListener {
            dohvati( )
        }
    }

    private fun dohvati( ) {
        val client = OkHttpClient.Builder( ).addInterceptor( ChuckInterceptor( this ) ).build( )

        val retrofit = Retrofit.Builder( )
            .baseUrl( "https://api.icndb.com/" )
            .addConverterFactory( GsonConverterFactory.create( ) )
            .client( client )
//          .addConverterFactory( MoshiConverterFactory.create( ) )
            .build( )

        val service = retrofit.create( JokeService::class.java )
        val call = service.getRandomJokes( )

        call.enqueue( object : Callback< JokeResponse > {
            override fun onResponse( call : Call< JokeResponse >, response: Response< JokeResponse > ) {
                tvOdgovor.setText( "Dobio sam response (${ response.code( ) })" )
                val jokes : JokeResponse? = response.body( )
                if( jokes!=null ) {
                    var sb = StringBuilder( "" )
                    jokes.value.forEach {
                        sb.append( "${ it.joke } \n\n" )
                    }
                    tvOdgovor.setText( sb.toString( ) )
                }
            }

            override fun onFailure( call: Call< JokeResponse >, t: Throwable ) {
                tvOdgovor.setText( "Greška u pozivu API-a" )
            }
        } )
    }
}