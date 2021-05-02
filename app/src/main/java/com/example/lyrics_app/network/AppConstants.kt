package com.example.lyrics_app.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppConstants {

    private const val BASE_URL = "https://api.lyrics.ovh/v1/"

    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val api: Api by lazy { retrofit().create(Api::class.java) }
}