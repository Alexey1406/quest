package com.mobile.cas.silentschool.view.utils

import android.content.Context
import android.support.annotation.*
import android.support.v4.content.ContextCompat

/**
 * Класс-обертка над ApplicationContext для предоставления ресурсов по id
 */
class ResourceProvider(context: Context) {

    private val mContext = context.applicationContext

    fun getString(@StringRes resId: Int) = mContext.getString(resId)!!

    fun getStringArray(@ArrayRes resId: Int): Array<out String> = mContext.resources.getStringArray(resId)

    fun getColor(@ColorRes resId: Int) = ContextCompat.getColor(mContext, resId)

    fun getDimensionPixelSize(@DimenRes resId: Int) = mContext.resources.getDimensionPixelSize(resId)

    fun getQuantityString(@PluralsRes resId: Int, quantity: Int, vararg formatArgs: Any) = mContext.resources.getQuantityString(resId, quantity, *formatArgs)
}