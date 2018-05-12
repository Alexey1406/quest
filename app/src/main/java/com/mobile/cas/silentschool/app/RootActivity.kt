package com.mobile.cas.silentschool.app

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.mobile.cas.silentschool.view.ui.root.RootFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class RootActivity : AppCompatActivity(), HasSupportFragmentInjector {

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)

        showFragment(RootFragment::class.java.simpleName)
    }

    private fun showFragment(tag: String) {

        var transaction = supportFragmentManager.beginTransaction()
        supportFragmentManager.fragments.filter { it.tag != tag }.forEach {
            transaction = transaction.hide(it)
        }
        val restoredFragment = supportFragmentManager.findFragmentByTag(tag)
        if (restoredFragment != null) {
            transaction.show(restoredFragment)
        } else {
            transaction.add(R.id.root_container, RootFragment(), tag)
        }
        transaction.commit()
    }
}
