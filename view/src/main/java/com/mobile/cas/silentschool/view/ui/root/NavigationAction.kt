package com.mobile.cas.silentschool.view.ui.root

import android.support.annotation.IdRes

interface NavigationAction {
    fun invoke(@IdRes viewId: Int)
}