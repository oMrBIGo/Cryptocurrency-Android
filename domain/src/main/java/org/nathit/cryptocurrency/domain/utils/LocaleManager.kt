package org.nathit.cryptocurrency.domain.utils

import android.content.Context
import org.koin.java.KoinJavaComponent
import org.nathit.cryptocurrency.domain.usecase.SecurePreferencesUseCase
import java.util.*

class LocaleManager{
    companion object{
        fun setLocale(context: Context): Context? {
            return updateResources(context,getLanguage(context))
        }

        private fun getLanguage(context: Context): String {
            val pref: SecurePreferencesUseCase by KoinJavaComponent.inject(SecurePreferencesUseCase::class.java)
            return pref.getStringSharedPreference(pref.getKeyLanguage())?:""
        }

        private fun updateResources(context: Context, language:String): Context? {
            val locale = Locale(if(language.isEmpty()) Locale.getDefault().language else language)
            Locale.setDefault(locale)
            val configuration = context.resources.configuration
            configuration?.setLocale(locale)
            configuration?.setLayoutDirection(locale)
            return context.createConfigurationContext(configuration)
        }
    }
}