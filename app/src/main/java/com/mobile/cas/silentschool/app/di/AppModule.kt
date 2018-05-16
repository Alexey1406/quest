package com.mobile.cas.silentschool.app.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.mobile.cas.silentschool.app.MainActivity
import com.mobile.cas.silentschool.app.RootActivity
import com.mobile.cas.silentschool.app.utils.ContentManagerImpl
import com.mobile.cas.silentschool.app.utils.StateManagerImpl
import com.mobile.cas.silentschool.quest.data.Scenario
import com.mobile.cas.silentschool.view.di.PerActivity
import com.mobile.cas.silentschool.view.utils.ContentManager
import com.mobile.cas.silentschool.view.utils.ResourceProvider
import com.mobile.cas.silentschool.view.utils.StateManager
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton


@Module
abstract class AppModule {

    @PerActivity
    /* modules to install into the subcomponent */
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    internal abstract fun contributeMainActivityInjector(): MainActivity

    @PerActivity
    /* modules to install into the subcomponent */
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    internal abstract fun contributeRootActivityInjector(): RootActivity

    @Module
    companion object {
        @JvmStatic
        @Provides
        internal fun provideContext(application: Application): Context = application

        @Singleton
        @JvmStatic
        @Provides
        internal fun provideResourceProvider(context: Application): ResourceProvider = ResourceProvider(context)

        @Singleton
        @JvmStatic
        @Provides
        internal fun provideSharedPreferences(context: Context): SharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(context)

        @Singleton
        @JvmStatic
        @Provides
        internal fun provideStateManager(sharedPreferences: SharedPreferences): StateManager =
                StateManagerImpl(sharedPreferences)

        @Singleton
        @JvmStatic
        @Provides
        internal fun provideContentManager(scenario: Scenario,
                                           provider: ResourceProvider): ContentManager =
                ContentManagerImpl(scenario, provider)

        @Singleton
        @JvmStatic
        @Provides
        internal fun provideScenario(): Scenario = Scenario(0, 0)
    }
}