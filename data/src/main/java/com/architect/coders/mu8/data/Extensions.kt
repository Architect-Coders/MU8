package com.architect.coders.mu8.data

import java.math.BigInteger
import java.security.MessageDigest

private const val HTTP = "http"
private const val HTTPS = "https"
private const val ALGORITHM_MD5 = "MD5"
private const val SIG_NUM = 1
private const val RADIX = 16
private const val LENGTH = 32
private const val PAD_CHAR = '0'

/**
 * The MD5 message-digest algorithm is a widely used hash function producing a 128-bit hash value.
 * It remains suitable for other non-cryptographic purposes, for example for determining the
 * partition for a particular key in a partitioned database or service
 */
fun String.md5(): String {
    val md = MessageDigest.getInstance(ALGORITHM_MD5)
    return BigInteger(SIG_NUM, md.digest(toByteArray())).toString(RADIX).padStart(LENGTH, PAD_CHAR)
}

fun String.replaceHttps(): String {
    if (this.contains(HTTP)) {
        return this.replace(HTTP, HTTPS)
    }
    return this
}