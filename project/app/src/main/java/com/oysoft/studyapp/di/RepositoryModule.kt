package com.oysoft.studyapp.di

import com.oysoft.studyapp.data.remote.FlashCardRepository
import com.oysoft.studyapp.data.repository.FlashCardRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindFlashCardRepository(
        flashCardRepositoryImpl: FlashCardRepositoryImpl
    ): FlashCardRepository
}