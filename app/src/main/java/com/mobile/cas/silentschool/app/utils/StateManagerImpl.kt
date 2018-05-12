package com.mobile.cas.silentschool.app.utils

import android.content.SharedPreferences
import com.mobile.cas.silentschool.view.utils.StateManager

class StateManagerImpl(private val preferences: SharedPreferences): StateManager {

    override fun markStartReading() {
        preferences.edit()
                .putBoolean(PREF_IS_READING, true)
                .apply()
    }

    override fun isReading(): Boolean {
        return preferences.getBoolean(PREF_IS_READING, false)
    }

    companion object {
        private const val PREF_IS_READING = "PREF_IS_READING"
    }
}