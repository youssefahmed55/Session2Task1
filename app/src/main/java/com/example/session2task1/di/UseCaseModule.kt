package com.example.session2task1.di


import com.example.domain.repo.MainRepo
import com.example.domain.usecase.GetDataFromRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetDataFromRemoteUseCase(mainRepo: MainRepo): GetDataFromRemote {
        return GetDataFromRemote(mainRepo)
    }


}