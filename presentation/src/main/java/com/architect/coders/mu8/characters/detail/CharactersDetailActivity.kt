package com.architect.coders.mu8.characters.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.architect.coders.mu8.R

class CharactersDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CharactersDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters_detail)
    }

    companion object {
        const val CHARACTER = "DetailActivity:Character"
    }
}
