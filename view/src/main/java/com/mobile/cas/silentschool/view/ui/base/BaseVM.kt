package com.mobile.cas.silentschool.view.ui.base

import android.arch.lifecycle.ViewModel
import com.mobile.cas.silentschool.view.router.Router

abstract class BaseVM : RoutingVM() {
}

abstract class RoutingVM : ViewModel() {

    lateinit var router: Router
}