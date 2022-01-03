package com.example.skyengapi.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skyengapi.R
import com.example.skyengapi.databinding.MainFragmentBinding
import com.example.skyengapi.ui.main.adapter.MainAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.skyengapi.abs.AbsFragment
import com.example.skyengapi.data.SkyEngWords
import com.example.skyengapi.data.WordsRepo
import com.example.skyengapi.ui.viewmodel.MainFragmentViewModel
import dagger.android.HasAndroidInjector
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainFragment : AbsFragment(R.layout.main_fragment), MainView {

    @Inject
    lateinit var wordsRepo: WordsRepo

    private var adapter: MainAdapter? = null
    private val binding: MainFragmentBinding by viewBinding()
    private val presenter: MainPresenter by moxyPresenter {
        MainPresenter(wordsRepo)
    }
    private val viewModel: MainFragmentViewModel by lazy {
        ViewModelProvider(this).get(MainFragmentViewModel::class.java)
    }

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
                    viewModel.getData(searchWord)
                }
            })
            searchDialogFragment.show(childFragmentManager, "repo")
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

    companion object {
        fun newInstance() = MainFragment()
    }
}