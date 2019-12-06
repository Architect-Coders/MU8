package com.architect.coders.mu8

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_list_marvel.view.*

class MarvelListAdapter(private val listCategories: List<Category> = listOf()): RecyclerView.Adapter<MarvelListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_marvel, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listCategories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.showData(listCategories[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun showData(category: Category) {
            itemView.category_title.text = category.title
        }

    }
}