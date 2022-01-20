package com.example.skyengapi.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.skyengapi.R
import com.example.skyengapi.databinding.HistoryWordsFragmentBinding
import com.example.skyengapi.ui.history.adapter.HistoryAdapter
import com.example.skyengapi.ui.viewmodel.HistoryFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : Fragment() {
    private val viewModel: HistoryFragmentViewModel by viewModel()
    private val binding: HistoryWordsFragmentBinding by viewBinding()
    private var adapter: HistoryAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.history_words_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initAdapter()

        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter?.setHistoryWords(it)
            adapter?.notifyDataSetChanged()
        }
    }

    private fun initAdapter() {
        binding.historyRecyclerview.layoutManager = LinearLayoutManager(context)
        adapter = HistoryAdapter()
        binding.historyRecyclerview.adapter = adapter
        binding.historyRecyclerview.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
    }
}