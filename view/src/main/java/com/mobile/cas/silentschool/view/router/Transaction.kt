package com.mobile.cas.silentschool.view.router

import android.support.v4.app.FragmentManager

internal class Transaction<CONTEXT_PROVIDER : Any>(private val action: Action<CONTEXT_PROVIDER>) {

    lateinit var contextProvider: CONTEXT_PROVIDER
    lateinit var fragmentManager: FragmentManager

    fun run() {
        action.invoke(contextProvider, fragmentManager)
    }
}