package com.architect.coders.mu8

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.architect.coders.mu8.events.EventsViewModel
import com.architect.coders.mu8.events.EventsViewModel.EventsUiModel
import com.architect.coders.mu8.events.EventsViewModel.EventsUiModel.Content
import com.architect.coders.mu8.events.EventsViewModel.EventsUiModel.Loading
import com.architect.coders.mu8.events.EventsViewModel.EventsUiModel.Navigation
import com.architect.codes.mu8.events.Event
import com.architect.codes.mu8.events.EventsUseCase
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class EventsViewModelTest {

    @get: Rule val rule = InstantTaskExecutorRule()
    @Mock lateinit var observer: Observer<EventsUiModel>
    @Mock lateinit var eventsUseCase: EventsUseCase

    private lateinit var viewModel: EventsViewModel
    private lateinit var events: List<Event>
    private lateinit var event: Event

    @Before
    fun setUp() {
        viewModel = EventsViewModel(eventsUseCase, Dispatchers.Unconfined)
        event = Event(1, "My Event", "Desc", "")
        events = listOf(event)
    }

    @Test
    fun `Observing liveData loader is shown`() {
        runBlocking {
            viewModel.model.observeForever(observer)
            verify(observer).onChanged(Loading)
        }
    }

    @Test
    fun `After loading, EventsUseCase invoke is called`() {
        runBlocking {
            whenever(eventsUseCase()).thenReturn(events)
            viewModel.model.observeForever(observer)
            verify(observer).onChanged(Content(events))
        }
    }

    @Test
    fun `Click on Event calls Navigation`() {
        viewModel.onEventClick(event)
        viewModel.model.observeForever(observer)
        verify(observer).onChanged(Navigation(event))
    }

    @After
    fun tearDown() {
        viewModel.model.removeObserver(observer)
    }
}