package com.tzx.game2048.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.tzx.game2048.R
import org.json.JSONArray

class GuanFangMode : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guan_fang_mode)
        button1=findViewById(R.id.classmode)
        button1.setOnClickListener {
            var json= JSONArray()
            var list= arrayListOf<String>("斗者","斗师","大斗师","斗灵","斗王","斗皇","斗宗","斗尊","斗圣","斗帝","斗神")
            for(s in list){
                json.put(s)
            }
            var intent= Intent(this,MainActivity::class.java)
            intent.putExtra("strs",json.toString())
            startActivity(intent)
        }
        button2=findViewById(R.id.button3)
        button2.setOnClickListener {
            var json= JSONArray()
            var list= arrayListOf<String>("凡人","炼气","辟谷","筑基","金丹","元婴","化神","洞虚","渡劫","合体","大乘")
            for(s in list){
                json.put(s)
            }
            var intent= Intent(this,MainActivity::class.java)
            intent.putExtra("strs",json.toString())
            startActivity(intent)
        }
        button3=findViewById(R.id.selfmode)
        button3.setOnClickListener {
            var json= JSONArray()
            var list= arrayListOf<String>("魂士","魂师","大魂师","魂尊","魂宗","魂王","魂帝","魂圣","斗罗","封号斗罗","巅峰斗罗")
            for(s in list){
                json.put(s)
            }
            var intent= Intent(this,MainActivity::class.java)
            intent.putExtra("strs",json.toString())
            startActivity(intent)
        }
        button4=findViewById(R.id.savedmode)
        button4.setOnClickListener {
            var json= JSONArray()
            var list= arrayListOf<String>("男爵","子爵","伯爵","侯爵","公爵","大公爵","亲王","圣山","神将","天王","大天王")
            for(s in list){
                json.put(s)
            }
            var intent= Intent(this,MainActivity::class.java)
            intent.putExtra("strs",json.toString())
            startActivity(intent)
        }
        button5=findViewById(R.id.aboutgame)
        button5.setOnClickListener {
            var json= JSONArray()
            var list= arrayListOf<String>("白玉","火麟","翡翠","弘蓝","紫罗","赤金","乌金","神将","穹窿","百魁","唐小镖")
            for(s in list){
                json.put(s)
            }
            var intent= Intent(this,MainActivity::class.java)
            intent.putExtra("strs",json.toString())
            startActivity(intent)
        }
    }
}