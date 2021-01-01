package com.tzx.game2048.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.tzx.game2048.R

class BaseMenu : com.tzx.commonui.activity.BaseActivity() {
    private lateinit var button_classic:Button
    private lateinit var button_self:Button
    private lateinit var button_history:Button
    private lateinit var button_about:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_menu)
        button_classic=findViewById(R.id.classmode)
        button_self=findViewById(R.id.selfmode)
        button_history=findViewById(R.id.savedmode)
        button_about=findViewById(R.id.aboutgame)
        button_classic.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        button_history.setOnClickListener {
            val intent= Intent(this,HistoryMode::class.java)
            startActivity(intent)
        }
        button_self.setOnClickListener {
            val intent= Intent(this,customSelect::class.java)
            startActivity(intent)
        }
        button_about.setOnClickListener {
            val intent= Intent(this,About::class.java)
            startActivity(intent)
        }
    }
}