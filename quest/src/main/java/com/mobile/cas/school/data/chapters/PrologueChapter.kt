package com.mobile.cas.school.data.chapters

import com.mobile.cas.school.R
import com.mobile.cas.school.data.BaseChapter
import com.mobile.cas.school.data.Page

class PrologueChapter() : BaseChapter(R.string.prologue) {

    override val pages: List<Page> = mutableListOf(
            Page(R.string.prologue_page_01, R.array.prologue_next_step),
            Page(R.string.prologue_page_02, R.array.prologue_end)
    )
}