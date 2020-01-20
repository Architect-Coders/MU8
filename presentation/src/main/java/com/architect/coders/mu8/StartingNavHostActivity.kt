package com.architect.coders.mu8

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class StartingNavHostActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var toolbarTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_host)

        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        toolbarTitle = toolbar.findViewById(R.id.toolbar_title)
        toolbarTitle.text = getString(R.string.app_name)
    }

    fun setToolbarTitle(title: String) {
        if (::toolbarTitle.isInitialized) toolbarTitle.text = title
    }

    fun hideToolbar() {
        if (::toolbar.isInitialized) toolbar.visibility = GONE
    }

    fun showToolbar() {
        if (::toolbar.isInitialized) toolbar.visibility = VISIBLE
    }
}