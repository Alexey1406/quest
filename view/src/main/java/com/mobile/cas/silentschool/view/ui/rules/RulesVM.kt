package com.mobile.cas.silentschool.view.ui.rules

import android.arch.lifecycle.ViewModel
import com.mobile.cas.silentschool.view.router.BaseRouterImpl
import com.mobile.cas.silentschool.view.ui.base.BaseVM
import com.mobile.cas.silentschool.view.utils.ContentManager
import com.mobile.cas.silentschool.view.utils.StateManager

class RulesVM(private val contentManager: ContentManager): BaseVM<BaseRouterImpl>(){

    fun getRulesText(): String{
        return contentManager.aboutQuest()
    }
}