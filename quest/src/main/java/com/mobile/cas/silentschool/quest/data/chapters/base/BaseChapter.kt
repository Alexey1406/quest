package com.mobile.cas.silentschool.quest.data.chapters.base

import android.support.annotation.StringRes
import com.mobile.cas.silentschool.quest.data.page.Page

interface Chapter {

    fun getName(): Int

    fun getPageCount(): Int

    fun getPage(number: Int): Page?

    fun getAllPages(): List<Page>
}

abstract class BaseChapter(val id: Int, @StringRes private val name: Int) : Chapter {

    protected abstract var pages: List<Page>

    override fun getName(): Int = name

    override fun getPageCount(): Int = pages.size

    override fun getPage(number: Int): Page? = pages.getOrNull(number)

    override fun getAllPages(): List<Page> = pages
}