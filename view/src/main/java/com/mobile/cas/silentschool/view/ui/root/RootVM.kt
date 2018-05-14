package com.mobile.cas.silentschool.view.ui.root

import com.mobile.cas.silentschool.view.ui.base.BaseVM
import com.mobile.cas.silentschool.view.utils.StateManager

class RootVM(private val stateManager: StateManager) : BaseVM<RootRouterImpl>() {

    val startReading: NavigationAction = object : NavigationAction {
        override fun invoke() {
            router?.startReading()
        }
    }
}