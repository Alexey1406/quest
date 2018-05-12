package com.mobile.cas.silentschool.app.utils

import android.content.SharedPreferences
import com.mobile.cas.silentschool.app.R
import com.mobile.cas.silentschool.view.utils.ContentManager
import com.mobile.cas.silentschool.view.utils.ResourceProvider

class ContentManagerImpl(private val preferences: SharedPreferences, private val provider: ResourceProvider): ContentManager {

    override fun aboutQuest(): String {
        return provider.getString(R.string.about_story)
    }

}