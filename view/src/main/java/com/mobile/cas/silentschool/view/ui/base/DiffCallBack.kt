package com.mobile.cas.silentschool.view.ui.base

import android.support.v7.util.DiffUtil


class DiffCallBack(private val oldList: List<Any>, private val newList: List<Any>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean = areEqualItems(oldPosition, newPosition)

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean = areEqualItems(oldPosition, newPosition)

    private fun areEqualItems(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        if (!oldItem::class.isData || !newItem::class.isData) {
            throw IllegalArgumentException(oldItem::class.simpleName + " must be instance of class that is a data class")
        }
        return oldItem == newItem
    }
}