package com.mobile.cas.silentschool.view.ui.root

import android.databinding.ObservableField
import android.support.annotation.IdRes
import com.mobile.cas.silentschool.view.ui.base.BaseVM
import com.mobile.cas.silentschool.view.utils.StateManager

class RootVM(private val stateManager: StateManager) : BaseVM<RootRouterImpl>() {

    val isReading = stateManager.isReading()
    val navigationObservable: ObservableField<Int> = ObservableField()

    val navigation: NavigationAction = object : NavigationAction {
        override fun invoke(@IdRes viewId: Int) = navigationObservable.set(viewId)
    }
}