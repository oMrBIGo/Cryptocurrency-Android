package org.nathit.cryptocurrency.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.nathit.cryptocurrency.domain.usecase.SecurePreferencesUseCase
import org.nathit.cryptocurrency.domain.utils.BuildConfigManager
import java.util.*

class HeaderInterceptor(
    private val pref: SecurePreferencesUseCase,
    private val builderConfigManager: BuildConfigManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
    return chain.proceed(request)
    }

}