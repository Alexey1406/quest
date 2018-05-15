package com.mobile.cas.school.data

import android.support.annotation.StringRes
import com.mobile.cas.school.data.Page

abstract class BaseChapter(@StringRes val name: Int) {
    abstract val pages: List<Page>
}