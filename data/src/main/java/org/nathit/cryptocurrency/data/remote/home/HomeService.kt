package org.nathit.cryptocurrency.data.remote.home

import org.nathit.cryptocurrency.data.model.CryptoListEntity
import org.nathit.cryptocurrency.domain.model.CommonError
import org.nathit.cryptocurrency.domain.model.NetworkResponse
import retrofit2.http.GET


interface HomeService {

    @GET("v3/ticker/24hr")
    suspend fun getCoinList(): NetworkResponse<ArrayList<CryptoListEntity>, CommonError>

}