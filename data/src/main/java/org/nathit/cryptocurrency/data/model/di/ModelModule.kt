package org.nathit.cryptocurrency.data.model.di

import org.koin.dsl.module
import org.nathit.cryptocurrency.data.model.mapper.CoinsListMapper

val modelModule = module {

    single { CoinsListMapper() }

}