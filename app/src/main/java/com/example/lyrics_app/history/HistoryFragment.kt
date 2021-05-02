package com.example.lyrics_app.history

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import com.example.lyrics_app.LyricsViewModel
import com.example.lyrics_app.R
import com.example.lyrics_app.databinding.FragmentHistoryBinding

class HistoryFragment: Fragment(R.layout.fragment_history) {

    private val viewModel: LyricsViewModel by activityViewModels()

    lateinit var binding: FragmentHistoryBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHistoryBinding.bind(view)




        val adapter = HistoryAdapter(arrayListOf(), viewModel)
        binding.rvHistory.adapter = adapter

        viewModel.searchHistoryList.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }
}
