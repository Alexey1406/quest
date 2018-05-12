package com.mobile.cas.silentschool.view.ui.rules

import android.arch.lifecycle.ViewModel
import com.mobile.cas.silentschool.view.utils.ContentManager
import com.mobile.cas.silentschool.view.utils.StateManager

class RulesVM(private val contentManager: ContentManager): ViewModel(){

    fun getRulesText(): String{
        return contentManager.aboutQuest()
    }
}