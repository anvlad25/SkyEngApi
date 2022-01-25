package com.example.skyengapi.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skyengapi.R
import com.example.skyengapi.databinding.MainFragmentBinding
import com.example.skyengapi.ui.main.adapter.MainAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.repository.network.data.SkyEngWords
import com.example.repository.network.data.WordsRepo
import com.example.skyengapi.ui.viewmodel.MainFragmentViewModel
import kotlinx.coroutines.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : MvpAppCompatFragment(), MainView {
    private val wordsRepo: WordsRepo by inject()
    private val viewModel: MainFragmentViewModel by viewModel()

    private var adapter: MainAdapter? = null

    private val binding: MainFragmentBinding by viewBinding()

    private val presenter: MainPresenter by moxyPresenter {
        MainPresenter(wordsRepo)
    }

    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initAdapter()

        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter?.setWords(it)
            adapter?.notifyDataSetChanged()
        }

        binding.searchBottom.setOnClickListener {
            val searchDialogFragment = SearchDialogFragment.newInstance()
            searchDialogFragment.setOnSearchClickListener(object :
                SearchDialogFragment.OnSearchClickListener {
                override fun onClick(searchWord: String) {
                    //presenter.searchingWords(searchWord)
                    getDataCoroutines(searchWord)
                }
            })
            searchDialogFragment.show(childFragmentManager, "repo")
        }
    }

    private fun getDataCoroutines(searchWord: String) {
        scope.launch {
            delay(5000)
            viewModel.getData(searchWord)
        }

    }

    private fun initAdapter() {
        binding.mainRecyclerview.layoutManager = LinearLayoutManager(context)
        adapter = MainAdapter()
        binding.mainRecyclerview.adapter = adapter
        binding.mainRecyclerview.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showWords(words: List<SkyEngWords>) {
        adapter?.setWords(words)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}