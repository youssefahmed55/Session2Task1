package com.example.data.repo

import com.example.data.remote.MainApi
import com.example.domain.entity.PostModelItem
import com.example.domain.repo.MainRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepoImpl(private val mainApiService: MainApi) : MainRepo {

    override suspend fun getDataFromRemote() = withContext(Dispatchers.IO) {
        return@withContext mainApiService.getPosts()
    }

}