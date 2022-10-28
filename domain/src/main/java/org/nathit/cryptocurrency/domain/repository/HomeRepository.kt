package org.nathit.cryptocurrency.domain.repository

import org.nathit.cryptocurrency.domain.model.CommonError
import org.nathit.cryptocurrency.domain.model.CryptoList
import org.nathit.cryptocurrency.domain.model.NetworkResponse


interface HomeRepository {

    suspend fun getCoinsList(): NetworkResponse<ArrayList<CryptoList>, CommonError>?

}