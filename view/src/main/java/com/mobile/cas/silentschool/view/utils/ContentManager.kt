package com.mobile.cas.silentschool.view.utils

import com.mobile.cas.silentschool.quest.data.chapters.base.Chapter

interface ContentManager {
    fun aboutQuest(): String

    fun prolog(): Chapter
}