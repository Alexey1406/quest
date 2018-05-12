package com.mobile.cas.silentschool.app.di

import com.mobile.cas.silentschool.view.di.FragmentModule
import com.mobile.cas.silentschool.view.di.PerHost
import com.mobile.cas.silentschool.view.ui.root.RootFragment
import com.mobile.cas.silentschool.view.ui.rules.RulesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @PerHost
    /* modules to install into the subcomponent */
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    internal abstract fun contributeRootFragmentInjector(): RootFragment

    @PerHost
    /* modules to install into the subcomponent */
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    internal abstract fun contributeRulesFragmentInjector(): RulesFragment
}