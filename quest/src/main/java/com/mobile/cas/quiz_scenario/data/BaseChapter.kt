package com.mobile.cas.silentschool.app.data

import android.support.annotation.StringRes
import com.mobile.cas.quiz_scenario.data.Page

abstract class BaseChapter(@StringRes val name: Int) {
    abstract val pages: List<Page>
}