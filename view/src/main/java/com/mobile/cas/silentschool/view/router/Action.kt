package com.mobile.cas.silentschool.view.router

import android.support.v4.app.FragmentManager

interface Action<CONTEXT_PROVIDER> {
    fun invoke(context_provider: CONTEXT_PROVIDER,
               fragmentManager: FragmentManager)
}