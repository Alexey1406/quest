package com.mobile.cas.silentschool.view.ui.page

import android.databinding.BaseObservable
import android.databinding.ObservableField
import com.mobile.cas.silentschool.quest.data.Bookmark
import com.mobile.cas.silentschool.quest.data.page.Page
import com.mobile.cas.silentschool.view.ui.base.BaseVM
import com.mobile.cas.silentschool.view.utils.ContentManager
import java.util.*

class PageVM(private val contentManager: ContentManager) : BaseVM<PageRouterImpl>() {

    var bookmark: Bookmark = Bookmark()
    val content = ObservableField<List<BaseObservable>>(LinkedList())

    override fun initialize() {
        val page: Page = when (bookmark.isEmpty()) {
            true -> contentManager.prologue().getAllPages().first()
            false -> contentManager.getPage(bookmark)
        }
    }
}

