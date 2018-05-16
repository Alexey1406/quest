package com.mobile.cas.silentschool.view.ui.base

import android.arch.lifecycle.ViewModel
import com.mobile.cas.silentschool.view.router.Router

abstract class BaseVM<ROUTER : Router> : ViewModel() {

    var router: ROUTER? = null

    open fun initialize(){

    }
}