package com.mobile.cas.silentschool.view.utils

import com.mobile.cas.silentschool.quest.data.Bookmark

interface StateManager {
    fun markStartReading()

    fun isReading(): Boolean

    fun getBookmark(): Bookmark

    fun setBookmark(bookmark: Bookmark)
}