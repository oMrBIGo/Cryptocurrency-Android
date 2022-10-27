package org.nathit.cryptocurrency.domain.di

import org.koin.dsl.module
import org.nathit.cryptocurrency.domain.utils.BuildConfigManager

fun createBuildConfigModule(
    versionName: String,
    buildType: String,
    versionCode: Int
) = module {
    single { BuildConfigManager(versionName, buildType, versionCode) }
}