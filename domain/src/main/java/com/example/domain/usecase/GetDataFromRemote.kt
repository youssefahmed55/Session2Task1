package com.example.domain.usecase

import com.example.domain.repo.MainRepo

class GetDataFromRemote (private val mainRepo: MainRepo) {
    suspend operator fun invoke() = mainRepo.getDataFromRemote()

}
