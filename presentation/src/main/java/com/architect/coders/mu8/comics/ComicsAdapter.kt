package com.architect.coders.mu8.comics

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.comics.ComicsAdapter.ComicHolder
import com.architect.coders.mu8.utils.inflate
import com.architect.coders.mu8.utils.loadUrl
import com.architect.codes.mu8.comics.Comic
import kotlin.properties.Delegates

class ComicsAdapter(private val listener: (Comic) -> Unit) : RecyclerView.Adapter<ComicHolder>() {

    var comics: List<Comic> by Delegates.observable(
        emptyList(),
        { _, _, _ -> notifyDataSetChanged() }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicHolder {
        return ComicHolder(parent.inflate(R.layout.comic_item_list))
    }

    override fun onBindViewHolder(holder: ComicHolder, position: Int) {
        val comic = comics[position]
        holder.onBindComic(comic)
        holder.itemView.setOnClickListener { listener(comic) }
    }

    override fun getItemCount() = comics.size

    class ComicHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var comicImage: ImageView = itemView.findViewById(R.id.comic_item_image)
        private var comicTitle: TextView = itemView.findViewById(R.id.comic_item_title)

        fun onBindComic(item: Comic) {
            comicImage.loadUrl(item.thumbnailUrl, R.drawable.logo_marvel, R.drawable.error_image)
            comicTitle.text = item.title
        }
    }
}
