package com.mobile.cas.silentschool.view.ui.root

import android.databinding.Observable
import android.databinding.ObservableField
import android.support.constraint.ConstraintSet
import com.mobile.cas.silentschool.R
import com.mobile.cas.silentschool.databinding.RootFragmentBinding
import com.mobile.cas.silentschool.view.ui.base.BaseFragment

class RootFragment : BaseFragment<RootVM, RootFragmentBinding, RootRouterImpl>() {

    override fun initViews() {
        hideRestartItemIfNeed()
        getViewModel().navigationObservable.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                ((sender as ObservableField<*>).get() as? Int)?.let {
                    when (it) {
                        getDataBinding().start.id ->
                            routWithExplode(getDataBinding().start.menuItem, getDataBinding().menuContainer, { router.startReading() })
                        else -> {

                        }
                    }
                }
            }
        })
    }

    private fun hideRestartItemIfNeed() {
        if (!getViewModel().isReading) {
            val constraintSet = ConstraintSet()
            constraintSet.clone(getDataBinding().menuContainer)
            constraintSet.connect(getDataBinding().restart.root.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)
            constraintSet.connect(getDataBinding().start.root.id, ConstraintSet.RIGHT, getDataBinding().guidelineVerticalMiddle.id, ConstraintSet.LEFT)
            constraintSet.applyTo(getDataBinding().menuContainer)
        }
    }

    override fun getViewModelClass(): Class<RootVM> = RootVM::class.java

    override fun getLayoutId() = R.layout.root_fragment
}
