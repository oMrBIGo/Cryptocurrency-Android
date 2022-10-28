package org.nathit.cryptocurrency.home.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.nathit.cryptocurrency.home.HomeViewModel

val featureHome = module {
    viewModel { HomeViewModel(get(), get()) }
}