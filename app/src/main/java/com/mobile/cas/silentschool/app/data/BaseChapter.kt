package com.mobile.cas.silentschool.app.data

import android.support.annotation.StringRes

abstract class BaseChapter(@StringRes val name: Int) {
    abstract val pages: List<Page>
}