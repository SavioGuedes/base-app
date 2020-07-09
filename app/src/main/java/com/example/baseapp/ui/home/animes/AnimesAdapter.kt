package com.example.baseapp.ui.home.animes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseapp.R
import com.example.baseapp.data.model.Data
import kotlinx.android.synthetic.main.animes_item_list.view.*

class AnimesAdapter(
    private val animes: List<Data>
) : RecyclerView.Adapter<AnimesAdapter.AnimesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimesViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.animes_item_list, parent, false)
        return AnimesViewHolder(itemView)
    }

    override fun getItemCount() = animes.count()

    override fun onBindViewHolder(holder: AnimesViewHolder, position: Int) {
        holder.bindView(animes[position])
    }

    class AnimesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(anime: Data){
            val attributes = anime.attributes
            itemView.anime_title_item_list.text = attributes.canonicalTitle
        }
    }
}