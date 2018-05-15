package com.mobile.cas.silentschool.view.ui.root;

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

