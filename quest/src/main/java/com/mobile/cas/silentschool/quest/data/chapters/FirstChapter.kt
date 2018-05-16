package com.mobile.cas.silentschool.quest.data.chapters

import com.mobile.cas.silentschool.quest.R
import com.mobile.cas.silentschool.quest.data.chapters.base.BaseChapter
import com.mobile.cas.silentschool.quest.data.page.Page

class FirstChapter : BaseChapter(R.string.chapter_caption_01) {

    override var pages: List<Page> = buildChapter()

    private fun buildChapter(): List<Page> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /*override val pages: List<Page> = mutableListOf(
            Page(R.string.first_page_01, R.array.first_page_01_passages),
            Page(R.string.first_page_02, R.array.first_page_02_passages)
    )*/
}