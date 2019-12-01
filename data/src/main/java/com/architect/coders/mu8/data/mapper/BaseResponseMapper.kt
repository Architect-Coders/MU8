package com.architect.coders.mu8.data.mapper

abstract class BaseResponseMapper<I, O> {
    abstract fun transform(input: I): O
}