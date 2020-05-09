package com.architect.coders.mu8.comics

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.architect.coders.mu8.utils.Event
import com.architect.codes.mu8.comics.Comic
import com.architect.codes.mu8.comics.ComicUseCase
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ComicsViewModelTest {

    @get: Rule val rule = InstantTaskExecutorRule()
    @Mock var observerComic: Observer<List<Comic>> = mock()
    @Mock lateinit var observerLoading: Observer<Boolean>
    @Mock lateinit var observerNavigation: Observer<Event<Comic>>
    @Mock lateinit var comicUseCase: ComicUseCase

    private lateinit var viewModel: ComicsViewModel
    private lateinit var comics: List<Comic>
    private lateinit var comic: Comic

    @Before
    fun setUp() {
        viewModel = ComicsViewModel(comicUseCase, Dispatchers.Unconfined)
        comic = Comic(
            1090,
            "Wolverine Vol. II (Trade Paperback)",
            "This volume collects the second story arc of the series which strips Wolverine down to his essentials and pits him against an array of unsavory underworld characters.  Society's dark underbelly is about to get gutted, courtesy of his razor-sharp claws.",
            "https://i.annihil.us/u/prod/marvel/i/mg/9/60/4bc668630fe3a.jpg",
            emptyList()
        )
        comics = listOf(comic)
    }

    @Test
    fun `Observing get Comics`() {
        runBlocking {
            whenever(comicUseCase()).thenReturn(comics)
            viewModel.comics.observeForever(observerComic)
            viewModel.initComics()
            verify(observerComic).onChanged(comics)
        }
    }

    @Test
    fun `Observing loading`() {
        runBlocking {
            whenever(comicUseCase()).thenReturn(comics)
            viewModel.loading.observeForever(observerLoading)
            viewModel.initComics()
            verify(observerLoading).onChanged(true)
            verify(observerLoading).onChanged(false)
        }
    }

    @Test
    fun `Click on Event calls Navigation`() {
        viewModel.navigateTo.observeForever(observerNavigation)
        viewModel.onComicClicked(comic)
        verify(observerNavigation).onChanged(ArgumentMatchers.refEq(Event(comic)))
    }

    @After
    fun tearDown() {
        viewModel.loading.removeObserver(observerLoading)
        viewModel.comics.removeObserver(observerComic)
        viewModel.navigateTo.removeObserver(observerNavigation)
    }
}