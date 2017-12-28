package com.james.weatherapp.ui.activity

import android.support.v7.widget.Toolbar
import com.james.weatherapp.R
import com.james.weatherapp.Util.App
import org.jetbrains.anko.toast

/**
 * Created by 80575749 on 2017/12/28.
 */
interface ToolbarManager {
    val toolbar: Toolbar

    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun initToolbar(){
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_settings -> App.instance.toast("Settings"
                )
                else -> App.instance.toast("Unknown option")
            }
            true
        }
    }
}

