package com.example.domain.repo

import com.example.domain.entity.PostModelItem

interface MainRepo {
    suspend fun getDataFromRemote() : List<PostModelItem>
}