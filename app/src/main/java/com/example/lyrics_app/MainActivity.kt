package com.example.lyrics_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.example.lyrics_app.databinding.ActivityMainBinding
import com.example.lyrics_app.network.AppConstants
import com.example.lyrics_app.network.model.Lyrics
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<LyricsViewModel> ()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val pbSearching: ProgressBar = findViewById(R.id.pbSearching)

        viewModel.searchingSong.observe(this) { isSearching ->
            if (isSearching){
                pbSearching.visibility = View.VISIBLE

            }else{

                pbSearching.visibility = View.GONE

            }
        }

    }
}
