package com.mobile.cas.silentschool.view.ui.root;

import android.view.View
import com.mobile.cas.silentschool.view.router.BaseRouterImpl
import com.mobile.cas.silentschool.view.ui.page.PageFragment

interface RootRouter {

    fun startReading(shared: Pair<View, String>? = null)

    fun showRules()
}

class RootRouterImpl : RootRouter, BaseRouterImpl() {
    override fun startReading(shared: Pair<View, String>?) {
        showFragment(
                PageFragment::class.java.simpleName,
                { PageFragment() },
                shared)
    }

    override fun showRules() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

