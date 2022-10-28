package org.nathit.cryptocurrency.data.repository

import org.nathit.cryptocurrency.data.model.mapper.CoinsListMapper
import org.nathit.cryptocurrency.data.remote.home.HomeService
import org.nathit.cryptocurrency.domain.model.CommonError
import org.nathit.cryptocurrency.domain.model.CryptoList
import org.nathit.cryptocurrency.domain.model.NetworkResponse
import org.nathit.cryptocurrency.domain.model.mapOnSuccess
import org.nathit.cryptocurrency.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val coinsListMapper: CoinsListMapper,
    private val homeService: HomeService
) : HomeRepository {

    override suspend fun getCoinsList(): NetworkResponse<ArrayList<CryptoList>, CommonError>? {
        return homeService.getCoinList().mapOnSuccess(coinsListMapper::map)
    }


}