package com.oysoft.studyapp.di

import com.oysoft.studyapp.domain.repository.FlashCardsApiService
import com.oysoft.studyapp.utils.NetworkModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{
    @Provides
    @Singleton
    fun provideApiService(): FlashCardsApiService{
        return NetworkModule.retrofit.create(FlashCardsApiService::class.java)
    }
}