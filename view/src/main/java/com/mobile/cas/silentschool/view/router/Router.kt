package com.mobile.cas.silentschool.view.router

import android.app.Activity
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import java.util.concurrent.ConcurrentLinkedQueue

/*Router for navigation between fragments*/
interface Router : LifecycleObserver

private interface LifecycleAwareRouter<CONTEXT_PROVIDER> : Router {

    fun attachContext(contextProvider: CONTEXT_PROVIDER,
                      fragmentManager: FragmentManager)

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume()

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onDetach()
}

abstract class CoreRouterImpl<CONTEXT_PROVIDER : Any> : LifecycleAwareRouter<CONTEXT_PROVIDER> {

    private val postponedTransaction = ConcurrentLinkedQueue<Transaction<CONTEXT_PROVIDER>>()
    protected var contextProvider: CONTEXT_PROVIDER? = null
    protected var fragmentManager: FragmentManager? = null

    fun runTransaction(action: Action<CONTEXT_PROVIDER>) {
        val transaction = Transaction(action)
        if (contextProvider != null) {
            prepareCommand(transaction)
            transaction.run()
        }
    }

    fun runStickyTransaction(action: Action<CONTEXT_PROVIDER>) {
        val transaction = Transaction(action)
        if (contextProvider != null) {
            prepareCommand(transaction)
            transaction.run()
        } else {
            postponedTransaction.add(transaction)
        }
    }

    private fun prepareCommand(transaction: Transaction<CONTEXT_PROVIDER>): Transaction<CONTEXT_PROVIDER> {
        transaction.contextProvider = contextProvider!!
        transaction.fragmentManager = fragmentManager!!
        return transaction
    }

    override fun attachContext(contextProvider: CONTEXT_PROVIDER,
                               fragmentManager: FragmentManager) {
        this.contextProvider = contextProvider
        this.fragmentManager = fragmentManager
    }

    override fun onResume() {
        while (postponedTransaction.isNotEmpty()) {
            postponedTransaction.poll()?.let {
                prepareCommand(it).run()
            }
        }
    }

    override fun onDetach() {
        contextProvider = null
        fragmentManager = null
    }
}