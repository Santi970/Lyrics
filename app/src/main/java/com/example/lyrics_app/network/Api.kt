package com.example.lyrics_app.network


import android.text.Editable
import com.example.lyrics_app.network.model.Lyrics
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("{artist}/{title}")
    fun search(
        @Path("artist") artist: Editable,
        @Path("title") title: Editable
    ): Call<Lyrics>
}