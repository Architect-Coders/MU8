package com.architect.coders.mu8.data.utils

import com.architect.coders.mu8.data.BuildConfig

internal const val TIME_STAMP = BuildConfig.TIME_STAMP
internal const val MARVEL_PUBLIC_KEY = BuildConfig.MARVEL_PUBLIC_KEY
internal const val MARVEL_PRIVATE_KEY = BuildConfig.MARVEL_PRIVATE_KEY
internal const val DEFAULT_OFFSET = 0
internal const val LIMIT = 100

/**
 * Create hash required to any request to Marvel API
 * @return md5(ts+privateKey+publicKey)
 */
fun createHashCode() = (TIME_STAMP + MARVEL_PRIVATE_KEY + MARVEL_PUBLIC_KEY).md5()
