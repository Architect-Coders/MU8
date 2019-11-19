package com.architect.coders.mu8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.domain.DummyClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dummy = DummyClass("Santiago")
    }
}
