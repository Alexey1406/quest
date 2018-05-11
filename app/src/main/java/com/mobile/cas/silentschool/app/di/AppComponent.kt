package com.mobile.cas.silentschool.app.di

import com.mobile.cas.silentschool.app.QuestApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class])
interface AppComponent : AndroidInjector<QuestApplication> {

}