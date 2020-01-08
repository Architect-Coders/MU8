package com.architect.coders.mu8.characters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.databinding.ViewCharacterBinding
import com.architect.coders.mu8.utils.bindingInflate
import com.architect.coders.mu8.utils.inflate
import com.architect.coders.mu8.utils.loadUrl
import com.architect.codes.mu8.characters.Character
import kotlin.properties.Delegates

class CharactersAdapter(private val listener: (Character) -> Unit) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    var characters: List<Character> by Delegates.observable(
        emptyList(),
        { _, _, _ -> notifyDataSetChanged() }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
         ViewHolder(parent.bindingInflate(R.layout.view_character, false))

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        holder.dataBinding.character = character
        holder.bind(character)
        holder.itemView.setOnClickListener { listener(character) }
    }

    class ViewHolder(val dataBinding: ViewCharacterBinding) : RecyclerView.ViewHolder(dataBinding.root) {

        fun bind(character: Character) {
            dataBinding.imageCharacterPicture.loadUrl(character.thumbnailUrl)
        }
    }
}
