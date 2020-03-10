package com.architect.codes.mu8.di

import com.architect.codes.mu8.di.internal.UseCaseModule
import dagger.Module

@Module(includes = [UseCaseModule::class])
class DomainModule