package com.architect.coders.mu8.characters.integrationTest.main

import com.architect.coders.mu8.data.di.DataModule
import com.architect.coders.mu8.data.di.internal.ServerModule
import com.architect.coders.mu8.di.ApplicationComponent
import com.architect.codes.mu8.characters.Character
import com.architect.codes.mu8.characters.CharactersRepository
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        TestAppModule::class,
        DataModule::class
    ]
)
interface TestComponent : ApplicationComponent {

    val charactersRepository: CharactersRepository

    @Component.Factory
    interface FactoryTest {
        fun create(): TestComponent
    }
}

@Module
class TestAppModule {

    @Provides
    @Singleton
    fun provideCharactersRepositoryTest(): CharactersRepository = FakeCharacterer()
}

class FakeCharacterer : CharactersRepository {

    var characters = defaultFakeCharacters

    override suspend fun invoke(): List<Character> = characters

    override suspend fun findCharacter(id: Long): Character = characters.first { it.id == id }
}

val defaultFakeCharacters = listOf(
    mockedCharacter.copy(1),
    mockedCharacter.copy(2),
    mockedCharacter.copy(3),
    mockedCharacter.copy(4),
    mockedCharacter.copy(5)
)