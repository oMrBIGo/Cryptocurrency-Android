package org.nathit.cryptocurrency.data.repository

import org.nathit.cryptocurrency.data.local.sharedpreferences.SecurePreferences
import org.nathit.cryptocurrency.domain.repository.SecurePreferenceRepository

class SecurePreferenceRepositoryImpl(private val prefs: SecurePreferences) :
    SecurePreferenceRepository {

    companion object {
        const val language = "a4ef304ba42a200bafd78b046e0869af9183f6eee5524aead5dcb3a5ab5f8f3f"
        const val theme = "3cb8201e7ff1e7777446032ef1bf4338535aadbabe464c15411cdce8c2317590"
    }

    override fun commitIntSharedPreference(prefKey: String, value: Int) {
        prefs.commitIntSharedPreference(prefKey, value)
    }

    override fun getIntSharedPreference(prefKey: String): Int? {
        return prefs.getIntSharedPreference(prefKey)
    }

    override fun commitBooleanSharedPreference(prefKey: String, value: Boolean) {
        prefs.commitBooleanSharedPreference(prefKey, value)
    }

    override fun getBooleanSharedPreference(prefKey: String): Boolean? {
        return prefs.getBooleanSharedPreference(prefKey)
    }

    override fun commitStringSharedPreference(prefKey: String, value: String?) {
        prefs.commitStringSharedPreference(prefKey, value)
    }

    override fun getStringSharedPreference(prefKey: String): String? {
        return prefs.getStringSharedPreference(prefKey)
    }

    override fun commitLongSharedPreference(prefKey: String, value: Long) {
        prefs.commitLongSharedPreference(prefKey, value)
    }

    override fun getLongSharedPreference(prefKey: String): Long? {
        return prefs.getLongSharedPreference(prefKey)
    }

    override fun commitArrayStringSharedPreference(prefKey: String, value: ArrayList<*>) {
        prefs.commitArrayStringSharedPreference(prefKey, value)
    }

    override fun getArrayStringSharedPreference(prefKey: String): ArrayList<*>? {
        return prefs.getArrayStringSharedPreference(prefKey)
    }

    override fun removeSharePreferenceByPrefKey(prefKey: String) {
        prefs.removeSharePreferenceByPrefKey(prefKey)
    }

    override fun getAllKeyPreference(): MutableMap<String, *>? {
        return prefs.getAllKeyPreference()
    }

    override fun getKeyLanguage(): String {
        return language
    }

    override fun getKeyTheme(): String {
        return theme
    }

}