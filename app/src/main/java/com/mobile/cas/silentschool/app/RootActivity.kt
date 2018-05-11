package com.mobile.cas.silentschool.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mobile.cas.silentschool.view.ui.RootFragment
import dagger.android.AndroidInjection

class RootActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.root_container, RootFragment())
        transaction.commit()

        /*private fun showFragment(tag: String, getInstanceAction: () -> Fragment) {
            runCommandSticky { _, fragmentManager ->
                run {
                    var transaction = fragmentManager.beginTransaction()
                    fragmentManager.fragments.filter { it.tag != tag }.forEach {
                        transaction = transaction.hide(it)
                    }
                    val restoredFragment = fragmentManager.findFragmentByTag(tag)
                    if (restoredFragment != null) {
                        transaction.show(restoredFragment)
                    } else {
                        transaction.add(R.id.container, getInstanceAction(), tag)
                    }
                    transaction.commit()
                }
            }
        }
*/

    }
}
