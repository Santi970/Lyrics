package com.example.lyrics_app.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import com.example.lyrics_app.LyricsViewModel
import com.example.lyrics_app.R
import com.example.lyrics_app.commons.hideKeyboard
import com.example.lyrics_app.databinding.FragmentSearchBinding


class SearchFragment : Fragment(R.layout.fragment_search) {

    private val lyricsViewModel: LyricsViewModel by activityViewModels()
    lateinit var binding: FragmentSearchBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)



        binding.ibSearch.setOnClickListener{
            hideKeyboard()
            val artist = binding.etArtist.text
            val song = binding.etSongTitle.text

            if (artist.isEmpty() || song.isEmpty()){
                Toast.makeText(activity, "The song or artist field cannot be emtpy", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            lyricsViewModel.searchLyrics(artist,song)
        }

        lyricsViewModel.currentSearch.observe(viewLifecycleOwner) {
            binding.etArtist.text = it.artist
            binding.etSongTitle.text = it.title
        }

    }
}