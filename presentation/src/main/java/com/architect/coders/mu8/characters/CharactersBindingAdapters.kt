package com.architect.coders.mu8.characters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.architect.codes.mu8.characters.Character

@BindingAdapter("items")
fun RecyclerView.setItems(characters: List<Character>?) {
    (adapter as? CharactersAdapter)?.let {
        it.characters = characters ?: emptyList()
    }
}