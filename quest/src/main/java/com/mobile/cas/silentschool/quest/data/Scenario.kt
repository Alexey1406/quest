package com.mobile.cas.silentschool.quest.data

import com.mobile.cas.silentschool.quest.data.chapters.FirstChapter
import com.mobile.cas.silentschool.quest.data.chapters.PrologueChapter
import com.mobile.cas.silentschool.quest.data.chapters.base.Chapter

class Scenario(val currentChapter: Int = 0, val currentPage: Int = 0) {

    private fun buildScenario(): List<Chapter> {
        val scenario = mutableListOf<Chapter>()
        scenario.add(PrologueChapter())
        scenario.add(FirstChapter())
        return scenario
    }
}