package com.mobile.cas.silentschool.app.utils

import com.mobile.cas.silentschool.app.R
import com.mobile.cas.silentschool.quest.data.Scenario
import com.mobile.cas.silentschool.quest.data.chapters.base.Chapter
import com.mobile.cas.silentschool.view.utils.ContentManager
import com.mobile.cas.silentschool.view.utils.ResourceProvider

class ContentManagerImpl(private val scenario: Scenario, private val provider: ResourceProvider): ContentManager {

    override fun prolog(): Chapter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun aboutQuest(): String {
        return provider.getString(R.string.about_story)
    }

}