package org.nathit.cryptocurrency.domain.usecase

import org.nathit.cryptocurrency.domain.repository.HomeRepository


class HomeUseCase(private val repo: HomeRepository) {

    suspend fun getCoinsList() = repo.getCoinsList()

}