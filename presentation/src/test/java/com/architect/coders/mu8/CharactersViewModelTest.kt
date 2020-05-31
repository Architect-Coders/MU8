package com.architect.coders.mu8

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.architect.coders.mu8.characters.CharactersViewModel
import com.architect.coders.mu8.utils.Event
import com.architect.codes.mu8.characters.Character
import com.architect.codes.mu8.characters.CharactersUseCase
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
class CharactersViewModelTest {

    @get: Rule val rule = InstantTaskExecutorRule()
    @Mock lateinit var observerCharacterLoading: Observer<Boolean>
    @Mock lateinit var observerCharacters: Observer<List<Character>>
    @Mock lateinit var observerCharactersItem: Observer<Event<Long>>
    @Mock lateinit var characterUseCase: CharactersUseCase

    private lateinit var characterViewModel: CharactersViewModel
    private lateinit var character: Character
    private lateinit var characters: List<Character>

    @Before
    fun setUp() {
        characterViewModel = CharactersViewModel(characterUseCase, Dispatchers.Unconfined)
        character = Character(
            1,
            "Spider-man",
            "Test",
            "https://cronicaglobal.elespanol.com/uploads/s1/61/11/51/3/main-700b9bff30_11_1000x528.jpeg"
        )
        characters = listOf(character)
    }

    @Test
    fun `Observing Live loading`() {
        runBlocking {
            characterViewModel.loading.observeForever(observerCharacterLoading)
            characterViewModel.getCharacters()
            verify(observerCharacterLoading).onChanged(false)
        }
    }

    @Test
    fun `get All characters`() {
        runBlocking {
            whenever(characterUseCase()).thenReturn(characters)
            characterViewModel.characters.observeForever(observerCharacters)
            characterViewModel.getCharacters()
            verify(observerCharacters).onChanged(characters)
        }
    }

    @Test
    fun `Click on Character calls`() {
        // Given
        characterViewModel.navigateToCharacter.observeForever(observerCharactersItem)

        // When
        characterViewModel.onCharacterClicked(character)

        // Then
        verify(observerCharactersItem).onChanged(ArgumentMatchers.refEq(Event(1.toLong())))
    }

    @After
    fun tearDown() {
        characterViewModel.loading.removeObserver(observerCharacterLoading)
        characterViewModel.navigateToCharacter.removeObserver(observerCharactersItem)
        characterViewModel.characters.removeObserver(observerCharacters)
    }
}

