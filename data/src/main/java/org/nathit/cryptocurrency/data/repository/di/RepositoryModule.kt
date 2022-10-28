package org.nathit.cryptocurrency.data.repository.di

import org.nathit.cryptocurrency.domain.repository.HomeRepository
import org.nathit.cryptocurrency.domain.repository.SecurePreferenceRepository
import org.koin.dsl.module
import org.nathit.cryptocurrency.data.repository.HomeRepositoryImpl
import org.nathit.cryptocurrency.data.repository.SecurePreferenceRepositoryImpl

val repositoryModule = module {
    single<SecurePreferenceRepository> { SecurePreferenceRepositoryImpl(get()) }
    single<HomeRepository> { HomeRepositoryImpl(get(), get()) }
}