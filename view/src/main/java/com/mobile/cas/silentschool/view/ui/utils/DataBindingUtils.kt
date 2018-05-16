package com.mobile.cas.silentschool.view.ui.utils

import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.graphics.Rect
import android.support.transition.Explode
import android.support.transition.Transition
import android.support.transition.TransitionManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.mobile.cas.silentschool.view.ui.base.ViewModelAdapter
import com.mobile.cas.silentschool.view.ui.root.NavigationAction

@BindingAdapter("list")
fun setContent(view: RecyclerView, content: List<BaseObservable>) {
    val adapter = view.adapter as ViewModelAdapter
    adapter.reload(content)
    view.visibility = if (content.isNotEmpty()) View.VISIBLE else View.INVISIBLE
}