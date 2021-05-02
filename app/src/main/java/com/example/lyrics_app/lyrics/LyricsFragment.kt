package com.example.lyrics_app.lyrics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.lyrics_app.LyricsViewModel
import com.example.lyrics_app.R
import com.example.lyrics_app.databinding.FragmentLyricsBinding
import com.example.lyrics_app.databinding.FragmentSearchBinding

class LyricsFragment : Fragment(R.layout.fragment_lyrics) {

    private val viewModel: LyricsViewModel by activityViewModels()


    lateinit var binding: FragmentLyricsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLyricsBinding.bind(view)



        viewModel.lyrics.observe(viewLifecycleOwner, Observer {
            binding.tvLyrics.text = it.lyrics

        })
    }
}