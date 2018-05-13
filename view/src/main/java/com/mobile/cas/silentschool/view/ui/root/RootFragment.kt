package com.mobile.cas.silentschool.view.ui.root

import com.mobile.cas.silentschool.R
import com.mobile.cas.silentschool.databinding.RootFragmentBinding
import com.mobile.cas.silentschool.view.ui.base.BaseFragment

class RootFragment : BaseFragment<RootVM, RootFragmentBinding, RootRouterImpl>() {

    override fun getViewModelClass(): Class<RootVM> = RootVM::class.java

    override fun getLayoutId() = R.layout.root_fragment
}
