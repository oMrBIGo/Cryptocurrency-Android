package org.nathit.cryptocurrency.di

import okhttp3.Interceptor
import org.nathit.cryptocurrency.BuildConfig
import org.nathit.cryptocurrency.data.local.di.localModule
import org.nathit.cryptocurrency.data.model.di.modelModule
import org.nathit.cryptocurrency.data.remote.di.createHttpClient
import org.nathit.cryptocurrency.data.remote.di.createRemoteModule
import org.nathit.cryptocurrency.data.repository.di.repositoryModule
import org.nathit.cryptocurrency.domain.di.createBuildConfigModule
import org.nathit.cryptocurrency.domain.di.domainModule
import org.nathit.cryptocurrency.home.di.featureHome
import org.nathit.cryptocurrency.splashscreen.di.featureSplashScreen

fun createAppModule(interceptor: Interceptor) = listOf(
    createHttpClient(interceptor),
    createRemoteModule(BuildConfig.BASE_API_URL),
    createBuildConfigModule(
        BuildConfig.VERSION_NAME,
        BuildConfig.BUILD_TYPE,
        BuildConfig.VERSION_CODE
    ),
    repositoryModule,
    domainModule,
    modelModule,
    localModule,
    featureSplashScreen,
    featureHome,
)

