package com.architect.coders.mu8.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.architect.coders.mu8.R
import com.architect.codes.mu8.interactor.CharactersUseCaseImpl

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val charactersUseCase = CharactersUseCaseImpl()
    }
}
