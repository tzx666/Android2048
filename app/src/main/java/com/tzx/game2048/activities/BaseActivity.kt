package com.tzx.game2048.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ktx.immersionBar

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide();
        immersionBar {
            transparentStatusBar()
            transparentNavigationBar()
            transparentBar()
        }
    }
}