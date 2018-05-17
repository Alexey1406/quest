package com.mobile.cas.silentschool.view.utils

import com.mobile.cas.silentschool.quest.data.Bookmark
import com.mobile.cas.silentschool.quest.data.chapters.base.Chapter
import com.mobile.cas.silentschool.quest.data.page.Page

interface ContentManager {
    fun aboutQuest(): String

    fun prologue(): Chapter

    fun getPage(bookmark: Bookmark): Page
}