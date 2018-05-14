package com.mobile.cas.silentschool.view.ui.rules

import android.os.Bundle
import android.view.View
import com.mobile.cas.silentschool.R
import com.mobile.cas.silentschool.databinding.RulesFragmentBinding
import com.mobile.cas.silentschool.view.router.BaseRouterImpl
import com.mobile.cas.silentschool.view.ui.base.BaseFragment
import com.mobile.cas.silentschool.view.ui.root.RootRouter
import com.mobile.cas.silentschool.view.ui.root.RootRouterImpl

class RulesFragment : BaseFragment<RulesVM, RulesFragmentBinding, BaseRouterImpl>() {

    override fun getViewModelClass(): Class<RulesVM> = RulesVM::class.java

    override fun getLayoutId() = R.layout.rules_fragment
}