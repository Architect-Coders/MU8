package com.architect.coders.mu8.data.di

import com.architect.coders.mu8.data.di.internal.RepositoryModule
import dagger.Module

@Module(includes = [RepositoryModule::class])
class DataModule