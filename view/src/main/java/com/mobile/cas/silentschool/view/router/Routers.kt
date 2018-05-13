package com.mobile.cas.silentschool.view.router

import android.app.Activity
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment

class Routers : Router

open class ActivityRouter : CoreRouterImpl<Activity>()

open class FragmentRouter : CoreRouterImpl<Fragment>()

open class DialogFragmentRouter : CoreRouterImpl<DialogFragment>()