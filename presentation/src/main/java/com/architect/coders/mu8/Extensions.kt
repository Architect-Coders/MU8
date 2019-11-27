package com.architect.coders.mu8

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(url: String, placeHolder: Int, errorImage: Int) {
    Glide.with(context).load(url)
        .placeholder(placeHolder)
        .error(errorImage)
        .into(this)
}