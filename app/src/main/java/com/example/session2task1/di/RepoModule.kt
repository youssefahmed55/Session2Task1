package com.weatheraanalyzerrrr.weatheranalyzer.di


import com.example.data.remote.MainApi
import com.example.data.repo.MainRepoImpl
import com.example.domain.repo.MainRepo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun providedMainRepo(
        mainApiService: MainApi,
    ): MainRepo {
        return MainRepoImpl(mainApiService)
    }
}