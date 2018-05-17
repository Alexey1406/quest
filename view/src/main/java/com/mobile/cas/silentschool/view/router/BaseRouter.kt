package com.mobile.cas.silentschool.view.router

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import com.mobile.cas.silentschool.R

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

    protected fun showFragment(tag: String,
                               getInstanceAction: () -> Fragment,
                               sharedTransaction: Pair<View, String>? = null) {
        runStickyTransaction(object : Action<Fragment> {
            override fun invoke(context_provider: Fragment, fragmentManager: FragmentManager) {
                var transaction = fragmentManager.beginTransaction()
                sharedTransaction?.let {
                    transaction.addSharedElement(sharedTransaction.first, sharedTransaction.second)
                }
                fragmentManager.fragments.filter { it.tag != tag }.forEach {
                    transaction = transaction.hide(it)
                }
                val restoredFragment = fragmentManager.findFragmentByTag(tag)
                if (restoredFragment != null) {
                    transaction.show(restoredFragment)
                } else {
                    transaction.add(R.id.root_container, getInstanceAction(), tag)
                }
                transaction.commit()
            }
        })
    }
}