package com.tzx.game2048.activities

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.tzx.game2048.R
import com.tzx.game2048.adapter.GameAdapter
import com.tzx.game2048.customView.CustomGridManager
import com.tzx.game2048.gameimpl.Game2048impl
import org.json.JSONArray
import java.util.*

/*
* 通过拿到的参去判断是否是经典模式,共用游戏规则
* */
class MainActivity : com.tzx.commonui.activity.BaseActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var score:TextView
    private lateinit var  game: Game2048impl
    var str= Arrays.asList("2","4","8","16","32","64","128","256","512","1024","2048")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        game= Game2048impl()

        var list=intent.getStringExtra("strs")
        if(list!=null&&!list.equals("")){
            var json=JSONArray(list)
            for(i in 0 until json.length()){
                str[i]=json.getString(i)
            }
        }
        recyclerView=findViewById(R.id.recycleview)
        score=findViewById(R.id.score)
        val layoutManager: CustomGridManager =
            CustomGridManager(this, 4)
        layoutManager.setScrollEnabled(false)
        recyclerView.setLayoutManager(layoutManager)
        game.init(this)
        var adapter= GameAdapter(
            this,
            game.map,
            str.toTypedArray()
        )

        Log.d("TAG", "onCreate: "+game.map.size)
        var animator=DefaultItemAnimator()
        animator.addDuration=10
        animator.changeDuration=200
        animator.moveDuration=200
        animator.removeDuration=10
        recyclerView.itemAnimator = animator
        recyclerView.adapter=adapter
        game.setAdapter(adapter)
        game.setAnimator(animator)
        var startX=0f
        var startY=0f
        var offsetX=0f
        var offsetY=0f
        recyclerView.setOnTouchListener { v, event ->
            if(animator.isRunning()) {
                true
            }
            when(event.action){
                MotionEvent.ACTION_DOWN ->{
                    startX = event.getX();
                    startY = event.getY();
                    true
                }
                MotionEvent.ACTION_UP ->{
                    offsetX = event.getX()-startX;
                    offsetY = event.getY()-startY;


                    if (Math.abs(offsetX)>Math.abs(offsetY)) {
                        if (offsetX<-5) {
                            Log.d("TAG", "左滑")
                            game.moveleft();
                            score.text="分数"+game.score.toString()
                        }else if (offsetX>5) {
                            Log.d("TAG", "右滑")
                            game.moveright();
                            score.text="分数"+game.score.toString()
                        }
                    }else{
                        if (offsetY<-5) {
                            Log.d("TAG", "上滑")
                            game.moveup();
                            score.text="分数"+game.score.toString()
                        }else if (offsetY>5) {
                            Log.d("TAG", "下滑")
                            game.movedown();
                            score.text="分数"+game.score.toString()
                        }
                    }
                    true
                }
                else -> false
            }

        }
    }
}