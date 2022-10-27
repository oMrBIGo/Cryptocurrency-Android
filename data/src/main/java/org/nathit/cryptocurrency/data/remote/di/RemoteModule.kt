package org.nathit.cryptocurrency.data.remote.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.nathit.cryptocurrency.data.utils.NetworkResponseAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRemoteModule(baseApiUrl: String) = module {
    single(named("retrofit")) {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseApiUrl)
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}