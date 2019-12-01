package com.architect.coders.mu8.data.utils

import com.architect.coders.mu8.data.BuildConfig

const val TIME_STAMP = BuildConfig.TIME_STAMP
const val MARVEL_PUBLIC_KEY = BuildConfig.MARVEL_PUBLIC_KEY
const val MARVEL_PRIVATE_KEY = BuildConfig.MARVEL_PRIVATE_KEY

/**
 * Create hash required to any request to Marvel API
 * @return md5(ts+privateKey+publicKey)
 */
fun createHashCode(timeStamp: String = TIME_STAMP) = (timeStamp + MARVEL_PRIVATE_KEY + MARVEL_PUBLIC_KEY).md5()
