package com.dariel25.android.pokeapp.presentation.pokelist.view

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dariel25.android.pokeapp.R
import com.dariel25.android.pokeapp.databinding.ActivityPokelistBinding
import com.dariel25.android.pokeapp.domain.model.PokemonSimple
import com.dariel25.android.pokeapp.presentation.pokelist.viewmodel.ViewModelFactory
import com.dariel25.android.pokeapp.presentation.pokelist.adapter.PokeListAdapter
import com.dariel25.android.pokeapp.presentation.pokelist.viewmodel.PokeListViewModel
import com.dariel25.android.pokeapp.presentation.models.ViewState

class PokeListActivity : AppCompatActivity() {

    private lateinit var pokeListViewModel: PokeListViewModel
    private lateinit var binding: ActivityPokelistBinding
    private var pokeListAdapter: PokeListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokelistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.layoutManager = layoutManager

        setupViewModel()
        setupObserver()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        // Associate searchable configuration with the SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        return true
    }

    private fun setupViewModel() {
        pokeListViewModel = ViewModelProvider(this, ViewModelFactory())
            .get(PokeListViewModel::class.java)
    }

    private fun setupObserver() {
        pokeListViewModel.getViewStateLiveData()
            .observe(this, Observer { updateViewStatus(it) })
    }

    private fun updateViewStatus(networkState: ViewState<List<PokemonSimple>?>) {
        when (networkState) {
            is ViewState.Loading -> showLoadingView()
            is ViewState.Success -> loadList(networkState.data)
            is ViewState.Error -> showErrorView(networkState.message)
        }
    }

    private fun loadList(list: List<PokemonSimple>?) {
        list?.let {
            pokeListAdapter = PokeListAdapter(this, it)
            binding.recyclerView.adapter = pokeListAdapter
        }
    }

    private fun showErrorView(error: String) {
        // Show toast
    }

    private fun showLoadingView() {

    }
}
