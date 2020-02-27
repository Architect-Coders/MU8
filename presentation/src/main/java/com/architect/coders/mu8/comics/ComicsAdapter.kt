package com.architect.coders.mu8.comics

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.comics.ComicsAdapter.ComicHolder
import com.architect.coders.mu8.databinding.ComicItemListBinding
import com.architect.coders.mu8.utils.bindingInflate
import com.architect.codes.mu8.comics.Comic
import kotlin.properties.Delegates

class ComicsAdapter(private val listener: (Comic) -> Unit) : RecyclerView.Adapter<ComicHolder>() {

    var comics: List<Comic> by Delegates.observable(
        emptyList(),
        { _, _, _ -> notifyDataSetChanged() }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicHolder {
        return  ComicHolder(parent.bindingInflate(R.layout.comic_item_list))
    }

    override fun onBindViewHolder(holder: ComicHolder, position: Int) {
        val comic = comics[position]
        holder.dataBinding.comic = comic
        holder.itemView.setOnClickListener { listener(comic) }
    }

    override fun getItemCount() = comics.size

    class ComicHolder(val dataBinding: ComicItemListBinding) : RecyclerView.ViewHolder(dataBinding.root)
}
