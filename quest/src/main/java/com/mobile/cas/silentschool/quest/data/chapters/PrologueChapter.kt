package com.mobile.cas.silentschool.quest.data.chapters

import com.mobile.cas.silentschool.quest.R
import com.mobile.cas.silentschool.quest.data.chapters.base.BaseChapter
import com.mobile.cas.silentschool.quest.data.page.Page
import com.mobile.cas.silentschool.quest.data.page.PageAction
import com.mobile.cas.silentschool.quest.data.page.PageContent

class PrologueChapter : BaseChapter(0, R.string.prologue) {

    override var pages: List<Page> = buildChapter()

    private fun buildChapter(): List<Page> {
        val scenario = mutableListOf<Page>()
        scenario.add(
                Page(listOf(PageContent(R.string.prologue_page_01)),
                        listOf(PageAction(0, R.array.prologue_next_step))))
        scenario.add(
                Page(listOf(PageContent(R.string.prologue_page_02)),
                        listOf(PageAction(0, R.array.prologue_end))))
        return scenario
    }
}