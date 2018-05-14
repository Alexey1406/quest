package com.mobile.cas.silentschool.view.ui.page

import android.databinding.BaseObservable
import android.databinding.ObservableField
import com.mobile.cas.silentschool.view.ui.base.BaseVM
import com.mobile.cas.silentschool.view.utils.ContentManager
import com.mobile.cas.silentschool.view.utils.StateManager
import java.util.*

class PageVM(private val contentManager: ContentManager): BaseVM<PageRouterImpl>() {

    val content = ObservableField<List<BaseObservable>>(LinkedList())

}

