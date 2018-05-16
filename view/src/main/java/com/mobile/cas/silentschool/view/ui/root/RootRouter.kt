package com.mobile.cas.silentschool.view.ui.root;

import android.graphics.Rect
import android.support.transition.Explode
import android.support.transition.Transition
import android.support.transition.TransitionManager
import android.view.ViewGroup
import com.mobile.cas.silentschool.view.router.BaseRouterImpl
import com.mobile.cas.silentschool.view.ui.page.PageFragment

interface RootRouter {

    fun startReading()

    fun showRules()
}

public class RootRouterImpl : RootRouter, BaseRouterImpl() {
    override fun startReading() {
        showFragment(PageFragment::class.java.simpleName,
                { PageFragment() })
    }

    override fun showRules() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

