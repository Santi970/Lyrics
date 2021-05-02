package com.example.lyrics_app

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lyrics_app.history.SearchHistory
import com.example.lyrics_app.network.AppConstants
import com.example.lyrics_app.network.model.Lyrics
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LyricsViewModel: ViewModel() {

    val lyrics = MutableLiveData<Lyrics>()
    val searchHistoryList = MutableLiveData<ArrayList<SearchHistory>>(arrayListOf())
    val searchingSong = MutableLiveData<Boolean>(false)
    val currentSearch = MutableLiveData<SearchHistory>()



    fun searchLyrics(artist: Editable, title: Editable){
        searchingSong.postValue(true)

        AppConstants.api.search(artist, title).enqueue(object: Callback<Lyrics> {
            override fun onResponse(call: Call<Lyrics>, response: Response<Lyrics>) {
                searchingSong.postValue(false)

                if (response.isSuccessful && response.body() != null){
                    lyrics.postValue(response.body())


                    val list = searchHistoryList.value!!
                    val searchHistory = SearchHistory(artist, title)
                    currentSearch.postValue(searchHistory)

                    list.remove(searchHistory)
                    list.add(0,searchHistory)
                    searchHistoryList.postValue(list)

                }else{
                    val errorLyrics = Gson().fromJson(response.errorBody()?.string(), Lyrics::class.java)
                    lyrics.postValue(errorLyrics)

                }

            }
            override fun onFailure(call: Call<Lyrics>, t: Throwable) {
                searchingSong.postValue(false)
                lyrics.postValue(Lyrics(null, "error, not found"))
            }
        })

    }
}