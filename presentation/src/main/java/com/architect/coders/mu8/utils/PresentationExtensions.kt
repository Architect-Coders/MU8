package com.architect.coders.mu8.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide

fun ImageView.loadUrl(url: String, placeHolder: Int, errorImage: Int) {
    Glide.with(context).load(url)
        .placeholder(placeHolder)
        .error(errorImage)
        .into(this)
}

fun ImageView.loadUrl(url: String) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .into(this)
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = true): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

inline fun <reified T : Activity> Context.intentFor(body: Intent.() -> Unit): Intent {
    return Intent(this, T::class.java).apply(body)
}

inline fun <reified T : Activity> Context.startActivity(body: Intent.() -> Unit) {
    startActivity(intentFor<T>(body))
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(): T {
    return ViewModelProviders.of(this)[T::class.java]
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(crossinline factory: () -> T): T {
    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }
    return ViewModelProviders.of(this, vmFactory)[T::class.java]
}
