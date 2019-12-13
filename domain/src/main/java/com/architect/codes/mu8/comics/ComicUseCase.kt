package com.architect.codes.mu8.comics

interface ComicUseCase {
    suspend operator fun invoke(): List<Comic>
}