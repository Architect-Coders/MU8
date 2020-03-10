package com.architect.coders.mu8.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.architect.coders.mu8.MU8Application
import com.architect.coders.mu8.R
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.snackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}

fun ImageView.loadUrl(
    url: String,
    placeHolder: Int = R.drawable.ic_placeholder,
    errorImage: Int = R.drawable.ic_not_found
) {
    Glide.with(context).load(url)
        .placeholder(placeHolder)
        .error(errorImage)
        .centerCrop()
        .into(this)
}

fun <T : ViewDataBinding> ViewGroup.bindingInflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): T =
    DataBindingUtil.inflate(LayoutInflater.from(context), layoutRes, this, attachToRoot)

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
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

@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> FragmentActivity.getViewModel(crossinline factory: () -> T): T {
    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }
    return ViewModelProviders.of(this, vmFactory)[T::class.java]
}

val Context.app: MU8Application
    get() = applicationContext as MU8Application
