package com.dariel25.android.pokeapp.presentation.pokelist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dariel25.android.pokeapp.R
import com.dariel25.android.pokeapp.domain.model.PokemonSimple
import com.dariel25.android.pokeapp.utils.PokemonTypeUtils

class PokeListAdapter(
    private val context: Context,
    private val dataset: List<PokemonSimple>
) :
    RecyclerView.Adapter<PokeListAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int): PokemonViewHolder =
        PokemonViewHolder(LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_pokemon, viewGroup, false))

    override fun onBindViewHolder(viewHolder: PokemonViewHolder, i: Int) {
        val p = dataset[i]
        viewHolder.name.text = p.name
        viewHolder.card.setCardBackgroundColor(PokemonTypeUtils.getTypeColor(p.types))
        Glide.with(context)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + p.id + ".png")
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(viewHolder.icon)

        //viewHolder.fotoImagenView.setOnClickListener( );
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById<View>(R.id.iv_icon) as ImageView
        val name: TextView = itemView.findViewById<View>(R.id.tv_name) as TextView
        val card: CardView = itemView.findViewById<View>(R.id.card) as CardView
    }
}
