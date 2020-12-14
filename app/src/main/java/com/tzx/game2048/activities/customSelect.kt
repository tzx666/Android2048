package com.tzx.game2048.activities

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.tzx.game2048.R
import com.tzx.game2048.util.Callback
import com.tzx.game2048.util.showNormalDialog
import org.json.JSONArray

class customSelect : BaseActivity() {
    private lateinit var s2:EditText
    private lateinit var s4:EditText
    private lateinit var s8:EditText
    private lateinit var s16:EditText
    private lateinit var s32:EditText
    private lateinit var s64:EditText
    private lateinit var s128:EditText
    private lateinit var s256:EditText
    private lateinit var s512:EditText
    private lateinit var s1024:EditText
    private lateinit var s2048:EditText
    private lateinit var button: Button
    private fun check():Boolean{
        if(s2.text.toString().length>0&&
            s4.text.toString().length>0&&
            s8.text.toString().length>0&&
            s16.text.toString().length>0&&
            s32.text.toString().length>0&&
            s64.text.toString().length>0&&
            s128.text.toString().length>0&&
            s256.text.toString().length>0&&
            s512.text.toString().length>0&&
            s1024.text.toString().length>0&&
            s2048.text.toString().length>0)return true
        return false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_select)
        s2=findViewById(R.id.s2)
        s4=findViewById(R.id.s4)
        s8=findViewById(R.id.s8)
        s16=findViewById(R.id.s16)
        s32=findViewById(R.id.s32)
        s64=findViewById(R.id.s64)
        s128=findViewById(R.id.s128)
        s256=findViewById(R.id.s256)
        s512=findViewById(R.id.s512)
        s1024=findViewById(R.id.s1024)
        s2048=findViewById(R.id.s2048)
        button=findViewById(R.id.commit)
        var json=JSONArray()
        button.setOnClickListener {
            if(check()){
                json.put(s2.text.toString())
                json.put(s4.text.toString())
                json.put(s8.text.toString())
                json.put(s16.text.toString())
                json.put(s32.text.toString())
                json.put(s64.text.toString())
                json.put(s128.text.toString())
                json.put(s256.text.toString())
                json.put(s512.text.toString())
                json.put(s1024.text.toString())
                json.put(s2048.text.toString())
                Log.d("TAG6", "onCreate: "+json.toString())
                var intent=Intent(this,MainActivity::class.java)
                intent.putExtra("strs",json.toString())
                showNormalDialog(this,"提示","是否保存此项设定？", object:Callback{
                    override fun onConfirm(dialog: DialogInterface) {
                        var sf=getSharedPreferences("data", Context.MODE_PRIVATE)
                        var list1=sf.getStringSet("sheding",null)
                        if(list1==null){
                            Log.d("TAG6", "onConfirm: 777")
                            list1= mutableSetOf(s2.text.toString())
                            sf.edit().putString(s2.text.toString(),json.toString()).apply()
                            sf.edit().putStringSet("sheding",list1).apply()
                        }else{
                            Log.d("TAG6", "onConfirm: 666")
                            list1.add(s2.text.toString())
                            sf.edit().putString(s2.text.toString(),json.toString()).apply()
                            sf.edit().putStringSet("sheding",list1).apply()
                        }
                        startActivity(intent)
                    }

                    override fun onCancel(dialog: DialogInterface) {
                        startActivity(intent)
                    }
                })
            }else{
                Toast.makeText(this,"输入格式错误",Toast.LENGTH_SHORT).show()
            }

        }
    }
}