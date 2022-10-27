package org.nathit.cryptocurrency.splashscreen.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.nathit.cryptocurrency.splashscreen.SplashScreenViewModel

val featureSplashScreen = module {
    viewModel { SplashScreenViewModel() }
}