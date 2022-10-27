package org.nathit.cryptocurrency.domain.di

import org.nathit.cryptocurrency.domain.usecase.HomeUseCase
import org.nathit.cryptocurrency.domain.usecase.SecurePreferencesUseCase
import org.koin.dsl.module

val domainModule = module {
    single { SecurePreferencesUseCase(get()) }
    single { HomeUseCase(get()) }
}