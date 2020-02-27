package com.architect.coders.mu8.utils

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("url")
fun ImageView.bindUrl(url: String?) {
    if (url != null) loadUrl(url)
}

@BindingAdapter("visible")
fun View.setVisible(visible: Boolean?) {
    visibility = visible?.let {
        if (visible) VISIBLE else GONE
    } ?: GONE
}