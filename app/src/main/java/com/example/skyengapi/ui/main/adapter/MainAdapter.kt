package com.example.skyengapi.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.repository.network.data.SkyEngWords
import com.example.skyengapi.databinding.MainFragmentItemBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var words: List<SkyEngWords> = mutableListOf()

    inner class ViewHolder(private val viewBinding: MainFragmentItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(words: SkyEngWords) {
            viewBinding.itemText.text = words.text
            viewBinding.itemTextDesc.text = words.meanings[0].translation.text
        }
    }

    fun setWords(words: List<SkyEngWords>) {
        this.words = words
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            MainFragmentItemBinding.inflate(
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