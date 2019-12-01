package com.architect.coders.mu8.data.remote.repository

import com.architect.coders.mu8.data.BuildConfig.TIME_STAMP
import com.architect.coders.mu8.data.comics.ComicRepository
import com.architect.coders.mu8.data.comics.IComicRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException

@RunWith(RobolectricTestRunner::class)
@ExperimentalCoroutinesApi
class ComicRepositoryTest {

    private lateinit var repository: IComicRepository

    private val testCoroutineDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testCoroutineDispatcher)

    @Before
    fun setUp() {
        Dispatchers.setMain(testCoroutineDispatcher)
        repository = ComicRepository()
    }

    @After
    @Throws(IOException::class)
    fun after() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        testScope.cleanupTestCoroutines()
    }

    @Test
    fun getAllComics() = runBlocking {
        val result = repository.getAllComics(TIME_STAMP)
        Assert.assertTrue(result.isSuccessful)
    }
}