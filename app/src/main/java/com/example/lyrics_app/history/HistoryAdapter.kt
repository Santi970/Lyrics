package com.example.lyrics_app.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lyrics_app.LyricsViewModel
import com.example.lyrics_app.R

class HistoryVH(view: View): RecyclerView.ViewHolder(view){
    val tvTitle: TextView = view.findViewById(R.id.tvTitle)
    val tvArtists: TextView = view.findViewById(R.id.tvArtist)
}

class HistoryAdapter(private var searchHistoryList: ArrayList<SearchHistory>,private val lyricsViewModel: LyricsViewModel): RecyclerView.Adapter<HistoryVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryVH {
        return HistoryVH(LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false))
    }

    override fun onBindViewHolder(holder: HistoryVH, position: Int) {
        val searchHistory = searchHistoryList[position]

        holder.tvTitle.text = searchHistory.title
        holder.tvArtists.text = searchHistory.artist

        holder.itemView.setOnClickListener {
            lyricsViewModel.searchLyrics(searchHistory.artist, searchHistory.title)
        }
    }

    override fun getItemCount(): Int {
        return searchHistoryList.size
    }

    fun setData(searchHistoryList: ArrayList<SearchHistory>) {
        this.searchHistoryList = searchHistoryList
        notifyDataSetChanged()
    }

}