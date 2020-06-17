package com.architect.coders.mu8.characters.integrationTest.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.architect.coders.mu8.characters.CharactersViewModel
import com.architect.coders.mu8.di.internal.ViewModelModule
import com.architect.codes.mu8.characters.Character
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainIntegrationTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val observer: Observer<List<Character>> = mock()
    private val component: TestComponent = DaggerTestComponent.factory().create()
    private lateinit var dataSourceCharacters: FakeCharacterer
    private lateinit var characterViewModel: CharactersViewModel

    @Before
    fun setUp() {
        characterViewModel = component.plus(ViewModelModule()).charactersViewModel
        dataSourceCharacters = component.charactersRepository as FakeCharacterer
        dataSourceCharacters.characters = defaultFakeCharacters
    }
}