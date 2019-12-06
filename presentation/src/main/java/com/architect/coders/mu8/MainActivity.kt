package com.architect.coders.mu8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.architect.codes.mu8.interactor.CharactersUseCase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val charactersUseCase = CharactersUseCase()
    }
}
