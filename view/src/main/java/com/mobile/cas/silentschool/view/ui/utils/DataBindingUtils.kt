package com.mobile.cas.silentschool.view.ui.utils

import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import com.mobile.cas.silentschool.view.ui.base.ViewModelAdapter

@BindingAdapter("list")
fun setContent(view: RecyclerView, content: List<BaseObservable>) {
    val adapter = view.adapter as ViewModelAdapter
    adapter.reload(content)
    view.visibility = if (content.isNotEmpty()) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("visibility")
fun isVisible(view: View,
              visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("gone")
fun isGone(view: View,
              visible: Boolean = true) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}