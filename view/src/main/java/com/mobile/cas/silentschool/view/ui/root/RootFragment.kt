package com.mobile.cas.silentschool.view.ui.root

import android.databinding.Observable
import android.graphics.Rect
import android.support.transition.Explode
import android.support.transition.Transition
import android.support.transition.TransitionManager
import android.view.ViewGroup
import com.mobile.cas.silentschool.R
import com.mobile.cas.silentschool.databinding.RootFragmentBinding
import com.mobile.cas.silentschool.view.ui.base.BaseFragment

class RootFragment : BaseFragment<RootVM, RootFragmentBinding, RootRouterImpl>() {

    override fun initViews() {
        getViewModel().animation.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                val viewRect = Rect()
                getDataBinding().start.menuItem.getGlobalVisibleRect(viewRect)
                // create Explode transition with epicenter
                val explode = Explode()
                explode.epicenterCallback = object : Transition.EpicenterCallback() {
                    override fun onGetEpicenter(transition: Transition): Rect {
                        return viewRect
                    }
                }
                explode.addListener(object : android.support.transition.TransitionListenerAdapter() {
                    override fun onTransitionEnd(transition: Transition) {
                        router?.startReading()                    }

                })
                TransitionManager.beginDelayedTransition(getDataBinding().menuContainer as ViewGroup, explode)
                getDataBinding().menuContainer.removeAllViews()

            }
        })
    }

    override fun getViewModelClass(): Class<RootVM> = RootVM::class.java

    override fun getLayoutId() = R.layout.root_fragment
}
