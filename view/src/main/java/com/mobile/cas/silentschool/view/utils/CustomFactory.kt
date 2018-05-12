package com.mobile.cas.silentschool.view.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class CustomFactory<VIEW_MODEL : ViewModel>(private val createAction: () -> VIEW_MODEL) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return createAction() as T
    }
}