package com.mobile.cas.silentschool.app.utils

import android.content.SharedPreferences
import com.mobile.cas.silentschool.quest.data.Bookmark
import com.mobile.cas.silentschool.view.utils.StateManager

class StateManagerImpl(private val preferences: SharedPreferences) : StateManager {

    override fun getBookmark(): Bookmark {
        return preferences.getString(PREF_BOOKMARK, null)
                ?.let {
                    Bookmark(it.substringBefore(DELIMITER).toInt(),
                            it.substringAfter(DELIMITER).toInt())
                } ?: Bookmark()
    }

    override fun setBookmark(bookmark: Bookmark) {
        preferences.edit()
                .putString(PREF_BOOKMARK, "${bookmark.chapter}$DELIMITER${bookmark.page}")
                .apply()
    }

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
        private const val PREF_BOOKMARK = "PREF_BOOKMARK"

        const val DELIMITER = "|"
    }
}