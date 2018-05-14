package com.mobile.cas.silentschool.view.di

import com.mobile.cas.silentschool.view.router.BaseRouterImpl
import com.mobile.cas.silentschool.view.ui.page.PageRouterImpl
import com.mobile.cas.silentschool.view.ui.page.PageVM
import com.mobile.cas.silentschool.view.ui.root.RootRouter
import com.mobile.cas.silentschool.view.ui.root.RootRouterImpl
import com.mobile.cas.silentschool.view.ui.root.RootVM
import com.mobile.cas.silentschool.view.ui.rules.RulesVM
import com.mobile.cas.silentschool.view.utils.ContentManager
import com.mobile.cas.silentschool.view.utils.CustomFactory
import com.mobile.cas.silentschool.view.utils.StateManager
import dagger.Module
import dagger.Provides

@Module
abstract class FragmentModule {

    @Module
    @Suppress("unused")
    companion object {
        @JvmStatic
        @Provides
        internal fun provideRootRouter(): RootRouterImpl = RootRouterImpl()

        @JvmStatic
        @Provides
        internal fun providePageRootRouter(): PageRouterImpl = PageRouterImpl()

        @JvmStatic
        @Provides
        internal fun provideBaseRouterImpl(): BaseRouterImpl = BaseRouterImpl()

        @JvmStatic
        @Provides
        internal fun provideRootVMFactory(stateManager: StateManager): CustomFactory<RootVM> = CustomFactory({ RootVM(stateManager) })

        @JvmStatic
        @Provides
        internal fun providePageVMFactory(contentManager: ContentManager): CustomFactory<PageVM> = CustomFactory({ PageVM(contentManager) })

        @JvmStatic
        @Provides
        internal fun provideRulesVMFactory(contentManager: ContentManager): CustomFactory<RulesVM> = CustomFactory({ RulesVM(contentManager) })
    }
}