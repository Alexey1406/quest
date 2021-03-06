package com.mobile.cas.silentschool.view.ui.base

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.graphics.Rect
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.transition.Explode
import android.support.transition.Transition
import android.support.transition.TransitionListenerAdapter
import android.support.transition.TransitionManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.cas.silentschool.BR
import com.mobile.cas.silentschool.view.router.FragmentRouter
import com.mobile.cas.silentschool.view.utils.CustomFactory
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseFragment<VIEW_MODEL : BaseVM<ROUTER>, BINDING : ViewDataBinding, ROUTER : FragmentRouter>
    : Fragment(), HasSupportFragmentInjector {

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = childFragmentInjector

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var factoryInjector: CustomFactory<VIEW_MODEL>

    @Inject
    lateinit var router: ROUTER
    lateinit var vm: VIEW_MODEL
    lateinit var dataBinding: BINDING

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProviders.of(activity!!, factoryInjector).get(getViewModelClass())
        router.attachContext(this, fragmentManager!!)
        lifecycle.addObserver(router)
        vm.router = router
        extractInitialArguments(arguments)
        vm.initialize()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        if (!dataBinding.setVariable(BR.viewModel, vm)) {
            throw RuntimeException("Layout XML resource should contain data variable with name=\"viewModel\"")
        }
        initViews()
        return dataBinding.root
    }

    protected open fun extractInitialArguments(arguments: Bundle?) {}

    protected open fun initViews() {}

    abstract fun getViewModelClass(): Class<VIEW_MODEL>

    @LayoutRes
    abstract fun getLayoutId(): Int

    // Run navigation with explode transition with epicenter
    protected fun routWithExplode(view: View, parent: ViewGroup, routAction: () -> Unit) {
        val viewRect = Rect()
        view.getGlobalVisibleRect(viewRect)
        val explode = Explode()
        explode.epicenterCallback = object : Transition.EpicenterCallback() {
            override fun onGetEpicenter(transition: Transition): Rect {
                return viewRect
            }
        }
        explode.addListener(object : TransitionListenerAdapter() {
            override fun onTransitionEnd(transition: Transition) {
                routAction.invoke()
            }
        })
        TransitionManager.beginDelayedTransition(parent, explode)
        parent.removeAllViews()
    }
}