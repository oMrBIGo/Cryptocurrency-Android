package org.nathit.cryptocurrency.data.local.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.nathit.cryptocurrency.data.local.sharedpreferences.SecurePreferences

val localModule = module {
    single { SecurePreferences(androidContext()) }
}