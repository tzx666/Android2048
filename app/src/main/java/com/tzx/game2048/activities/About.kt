package com.tzx.game2048.activities

import android.os.Bundle
import android.view.View
import mehdi.sakout.aboutpage.AboutPage


class About : com.tzx.commonui.activity.BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val aboutPage: View = AboutPage(this)
            .enableDarkMode(false)
            .setDescription("2048小游戏，添加自定义功能")
            .addGroup("2048游戏")
            .addGitHub("https://github.com/tzx666")
            .create()
        setContentView(aboutPage)
    }
}