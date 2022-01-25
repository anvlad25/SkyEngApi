package com.example.skyengapi.ui.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.skyengapi.databinding.HistoryWordsFragmentItemBinding
import com.example.repository.room.HistoryWords
import com.example.skyengapi.setPic

class HistoryAdapter: RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    private var words: List<HistoryWords> = mutableListOf()

    inner class ViewHolder(private val viewBinding: HistoryWordsFragmentItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(words: HistoryWords) {
            viewBinding.textHistoryWord.text = words.word
            viewBinding.textHistoryWord.setPic("https:${words.imageUrl}")
        }
    }

    fun setHistoryWords(words: List<HistoryWords>) {
        this.words = words
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            HistoryWordsFragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(words[position])
    }

    override fun getItemCount(): Int = words.size
}