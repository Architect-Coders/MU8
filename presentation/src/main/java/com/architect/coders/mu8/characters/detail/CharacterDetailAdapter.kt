package com.architect.coders.mu8.characters.detail

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.databinding.ViewComicBinding
import com.architect.coders.mu8.utils.bindingInflate
import com.architect.coders.mu8.utils.loadUrl
import com.architect.codes.mu8.comics.Comic
import kotlin.properties.Delegates

class CharacterDetailAdapter(private val listener: (Comic) -> Unit) : RecyclerView.Adapter<CharacterDetailAdapter.ViewHolder>() {

    var comics: List<Comic> by Delegates.observable(
        emptyList(),
        { _, _, _ -> notifyDataSetChanged() }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.bindingInflate(R.layout.view_comic, false))

    override fun getItemCount(): Int = comics.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comic = comics[position]
        holder.dataBinding.comic = comic
        holder.bind(comic)
    }

    class ViewHolder(val dataBinding: ViewComicBinding) : RecyclerView.ViewHolder(dataBinding.root) {
        fun bind(comic: Comic) {
            dataBinding.comicItemImage.loadUrl(comic.thumbnailUrl)
        }
    }
}