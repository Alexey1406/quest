package com.mobile.cas.silentschool.view.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.util.DiffUtil
import android.support.v7.util.ListUpdateCallback
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.cas.silentschool.BR
import java.util.*
import kotlin.collections.LinkedHashMap

open class ViewModelAdapter : RecyclerView.Adapter<ViewModelAdapter.ViewHolder>() {

    private val items = LinkedList<Any>()
    private val cellMap = LinkedHashMap<Class<out Any>, CellInfo>()
    private val sharedObjects = LinkedHashMap<Int, Any>()

    @JvmOverloads
    open fun reload(newItems: List<Any>, refreshLayout: SwipeRefreshLayout? = null) {
        val diffCallback: DiffUtil.Callback = DiffCallBack(items, newItems)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(diffCallback)
        setData(newItems)
        diffResult.dispatchUpdatesTo(object : ListUpdateCallback {
            override fun onChanged(position: Int, count: Int, payload: Any?) {
                notifyItemRangeChanged(position, count, payload)
            }

            override fun onMoved(fromPosition: Int, toPosition: Int) {
                notifyItemMoved(fromPosition, toPosition)
            }

            override fun onInserted(position: Int, count: Int) {
                notifyItemRangeInserted(position, count)
            }

            override fun onRemoved(position: Int, count: Int) {
                notifyItemRangeRemoved(position, count)
            }
        })
        refreshLayout?.isRefreshing = false
    }

    private fun setData(newData: List<Any>) {
        items.clear()
        items.addAll(newData)
    }

    fun registerCells(register: () -> Unit) {
        register()
    }

    @JvmOverloads
    fun cell(clazz: Class<out Any>, @LayoutRes layoutId: Int, bindingId: Int = BR.viewModel) {
        cellMap[clazz] = CellInfo(layoutId, bindingId)
    }

    fun getCellItemType(clazz: Class<out Any>) = cellMap[clazz]?.layoutId ?: 0

    private fun getViewModel(position: Int) = items[position]

    private fun getCellInfo(viewModel: Any): CellInfo {
        cellMap.entries
                .find { it.key == viewModel.javaClass }
                ?.apply { return value }
        cellMap.entries
                .find { it.key.isInstance(viewModel) }
                ?.apply {
                    cellMap[viewModel.javaClass] = value
                    return value
                }

        throw Exception("Cell info for class ${viewModel.javaClass.name} not found.")
    }

    private fun onBind(binding: ViewDataBinding,
                       cellInfo: CellInfo,
                       position: Int) {
        val viewModel = getViewModel(position)
        if (cellInfo.bindingId != 0) {
            binding.setVariable(cellInfo.bindingId, viewModel)
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return getCellInfo(getViewModel(position)).layoutId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(viewType, parent, false)
        val viewHolder = ViewHolder(view.rootView)

        sharedObjects.forEach { viewHolder.binding.setVariable(it.key, it.value) }

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cellInfo = getCellInfo(getViewModel(position))
        onBind(holder.binding, cellInfo, position)
    }

    data class CellInfo(val layoutId: Int, val bindingId: Int)

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ViewDataBinding = DataBindingUtil.bind(view)!!
    }

}