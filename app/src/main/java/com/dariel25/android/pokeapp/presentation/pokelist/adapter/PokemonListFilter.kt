package com.dariel25.android.pokeapp.presentation.pokelist.adapter

import android.widget.Filter
import com.dariel25.android.pokeapp.data.model.PokemonSimple

class PokemonListFilter(
    private val adapter: PokeListAdapter
): Filter() {

    override fun performFiltering(constraint: CharSequence?): FilterResults {
        val filterString = constraint.toString()
        val results = FilterResults()
        val list = adapter.dataset
        val filteredList: MutableList<PokemonSimple> = ArrayList()

        if (filterString.isEmpty()) {
            results.values = list
            results.count = list.size
        } else {
            for (item in list) {
                if (item.name.contains(filterString, true)
                    or (item.id == filterString)
                ) {
                    filteredList.add(item)
                }
            }
            results.values = filteredList
            results.count = filteredList.size
        }

        return results
    }

    @Suppress("UNCHECKED_CAST")
    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        adapter.filteredDataset = results?.values as List<PokemonSimple>
        adapter.notifyDataSetChanged()
    }

}
