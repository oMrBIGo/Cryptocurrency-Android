package org.nathit.cryptocurrency.data.repository

import org.nathit.cryptocurrency.data.remote.home.HomeService
import org.nathit.cryptocurrency.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val homeService: HomeService
) : HomeRepository {
}