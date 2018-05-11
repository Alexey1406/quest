package com.mobile.cas.silentschool.view.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.cas.silentschool.R
import com.mobile.cas.silentschool.databinding.RootFragmentBinding

class RootFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val databinding = DataBindingUtil.inflate<RootFragmentBinding>(inflater, R.layout.root_fragment, container, false)
        return databinding.root
    }
}