package com.mobile.cas.silentschool.view.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.cas.silentschool.BR
import com.mobile.cas.silentschool.view.router.FragmentRouter
import com.mobile.cas.silentschool.view.router.Router
import com.mobile.cas.silentschool.view.utils.CustomFactory
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseFragment<VIEW_MODEL : RoutingVM, BINDING : ViewDataBinding, ROUTER : FragmentRouter>
    : Fragment(), HasSupportFragmentInjector {

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = childFragmentInjector

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var factoryInjector: CustomFactory<VIEW_MODEL>

    @Inject
    lateinit var router: ROUTER

    private var viewDataBinding: ViewDataBinding? = null

    private var vm: VIEW_MODEL? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        router.attachContext(this, fragmentManager!!)
        vm = ViewModelProviders.of(activity!!, factoryInjector).get(getViewModelClass())
        lifecycle.addObserver(router)
        getViewModel().router = router
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate<BINDING>(inflater, getLayoutId(), container, false)
        if (!getDataBinding().setVariable(BR.viewModel, vm)) {
            throw RuntimeException("Layout XML resource should contain data variable with name=\"viewModel\"")
        }
        return getDataBinding().root
    }

    protected fun getDataBinding(): ViewDataBinding {
        return viewDataBinding!!
    }

    protected fun getViewModel(): VIEW_MODEL {
        if (vm == null) {
            throw NullPointerException("ViewModel did not create")
        }
        return vm!!
    }

    abstract fun getViewModelClass(): Class<VIEW_MODEL>

    @LayoutRes
    abstract fun getLayoutId(): Int
}