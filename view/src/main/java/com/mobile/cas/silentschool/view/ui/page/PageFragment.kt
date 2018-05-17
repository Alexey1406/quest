package com.mobile.cas.silentschool.view.ui.page

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.mobile.cas.silentschool.R
import com.mobile.cas.silentschool.databinding.PageFragmentBinding
import com.mobile.cas.silentschool.quest.data.Bookmark
import com.mobile.cas.silentschool.view.ui.base.BaseFragment
import com.mobile.cas.silentschool.view.ui.base.ViewModelAdapter
import com.mobile.cas.silentschool.view.vm.ContentVM

class PageFragment : BaseFragment<PageVM, PageFragmentBinding, PageRouterImpl>() {

    private val adapter: ViewModelAdapter = ViewModelAdapter()
    private lateinit var recyclerView: RecyclerView

    override fun getViewModelClass(): Class<PageVM> = PageVM::class.java

    override fun getLayoutId() = R.layout.page_fragment

    override fun initViews() {
        super.initViews()
        recyclerView = dataBinding.list
        adapter.registerCells(::registerCells)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    private fun registerCells() {
        registerCell(ContentVM::class.java, R.layout.item_page)
    }

    private fun registerCell(clazz: Class<out Any>, @LayoutRes layoutId: Int) {
        adapter.cell(clazz, layoutId)
    }

    override fun extractInitialArguments(arguments: Bundle?) {
        arguments?.let {
            vm.bookmark = arguments.getInt(ARG_BOOKMARK)
        }
    }

    companion object {

        private const val ARG_BOOKMARK = "ARG_BOOKMARK"

        fun newInstance(bookmark: Bookmark): PageFragment {
            val fragment = PageFragment()
            val args = Bundle().apply {
                putParcelable(ARG_BOOKMARK, bookmark)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
