package com.mobile.cas.silentschool.view.ui.root

import android.databinding.Observable
import android.databinding.ObservableField
import android.support.constraint.ConstraintSet
import android.view.View
import com.mobile.cas.silentschool.R
import com.mobile.cas.silentschool.databinding.RootFragmentBinding
import com.mobile.cas.silentschool.view.ui.base.BaseFragment

class RootFragment : BaseFragment<RootVM, RootFragmentBinding, RootRouterImpl>() {

    override fun initViews() {
        hideRestartItemIfNeed()
        vm.navigationObservable.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                ((sender as ObservableField<*>).get() as? Int)?.let {
                    when (it) {
                        dataBinding.start.id ->
                            routWithExplode(dataBinding.start.menuItem, dataBinding.menuContainer,
                                    { router.startReading(vm.lastBookmark()) })
                        else -> {

                        }
                    }
                }
            }
        })
    }

    private fun hideRestartItemIfNeed() {
        if (!vm.isReading) {
            dataBinding.restart.root.visibility = View.GONE
            val constraintSet = ConstraintSet()
            constraintSet.clone(dataBinding.menuContainer)
            constraintSet.connect(dataBinding.restart.root.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)
            constraintSet.applyTo(dataBinding.menuContainer)
        }
    }

    override fun getViewModelClass(): Class<RootVM> = RootVM::class.java

    override fun getLayoutId() = R.layout.root_fragment
}
