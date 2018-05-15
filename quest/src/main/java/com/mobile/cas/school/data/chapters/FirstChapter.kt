package com.mobile.cas.school.data.chapters

import com.mobile.cas.school.R
import com.mobile.cas.school.data.BaseChapter
import com.mobile.cas.school.data.Page

class FirstChapter : BaseChapter(R.string.chapter_caption_01) {

    override val pages: List<Page> = mutableListOf(
            Page(R.string.first_page_01, R.array.first_page_01_passages),
            Page(R.string.first_page_02, R.array.first_page_02_passages)
    )
}