package com.mobile.cas.silentschool.view.di

import javax.inject.Scope

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class PerActivity

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerHost

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFragment
