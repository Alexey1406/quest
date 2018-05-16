package com.mobile.cas.silentschool.view.ui.root

import android.databinding.ObservableField
import com.mobile.cas.silentschool.view.ui.base.BaseVM
import com.mobile.cas.silentschool.view.utils.StateManager

class RootVM(private val stateManager: StateManager) : BaseVM<RootRouterImpl>() {

    val animation: ObservableField<String> = ObservableField()

    val startReading: NavigationAction = object : NavigationAction {
        override fun invoke() {
            animation.set("sxs")
            //router?.startReading()
        }
    }
}