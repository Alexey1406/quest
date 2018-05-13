package com.mobile.cas.silentschool.view.router

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

interface BaseRouter {

    fun showAd()

    fun goBack()
}

open class BaseRouterImpl : BaseRouter, FragmentRouter() {
    override fun goBack() {
        runStickyTransaction(object : Action<Fragment> {
            override fun invoke(context_provider: Fragment, fragmentManager: FragmentManager) {
                context_provider.parentFragment?.childFragmentManager?.run {
                    if (backStackEntryCount > 0) {
                        popBackStack()
                        return@invoke
                    }
                }
                context_provider.activity?.fragmentManager?.run {
                    if (backStackEntryCount > 0) {
                        popBackStack()
                    }
                }
            }
        })
    }

    override fun showAd() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}