package com.tzx.game2048.activities

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.tzx.game2048.R
import com.tzx.game2048.util.Callback
import java.lang.Exception


class HistoryMode : BaseActivity() {
    private lateinit var historylist:ListView
    private lateinit var view:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_mode)
        historylist=findViewById(R.id.historylist)
        view=findViewById(R.id.textView4)
        var sf=getSharedPreferences("data", Context.MODE_PRIVATE)
        var list=sf.getStringSet("sheding",mutableSetOf())
        if(list?.size==0){
            view.visibility= View.VISIBLE
            historylist.visibility=View.GONE
        }else{
            view.visibility= View.GONE
            historylist.visibility=View.VISIBLE
            historylist.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list!!.toMutableList())
        }
        historylist.setOnItemClickListener { parent, view, position, id ->
            var mode=list.elementAt(position)
            var playlist=sf.getStringSet(mode,null)
            intent= Intent(this,MainActivity::class.java)
            intent.putExtra("strs",playlist?.toTypedArray())
            if(playlist!=null){
                com.tzx.game2048.util.showNormalDialog(this,"开始游玩","确定开始游玩吗",object:Callback{
                    override fun onConfirm(dialog: DialogInterface) {
                        startActivity(intent)
                    }

                    override fun onCancel(dialog: DialogInterface) {
                        dialog.dismiss()
                    }

                })
            }
        }
        historylist.setOnItemLongClickListener { parent, view, position, id ->
            var mode=list.elementAt(position)
            com.tzx.game2048.util.showNormalDialog(this,"删除","确定删除吗",object:Callback{
                override fun onConfirm(dialog: DialogInterface) {
                    try {
                        sf.edit().remove(mode).apply()
                        list.remove(mode)
                        sf.edit().putStringSet("sheding",list).apply()
                        historylist.adapter=ArrayAdapter<String>(this@HistoryMode,android.R.layout.simple_list_item_1,list!!.toMutableList())
                        if(list.size==0){
                            view.visibility= View.VISIBLE
                            historylist.visibility=View.GONE
                        }
                        Toast.makeText(this@HistoryMode,"删除成功",Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }catch (e:Exception){
                        Log.d("TAG", "onConfirm: "+e)
                    }

                }

                override fun onCancel(dialog: DialogInterface) {
                    dialog.dismiss()
                }

            })
            true
        }
    }
}