package com.tzx.game2048.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.tzx.commonui.util.dp2px
import com.tzx.game2048.R
import com.tzx.game2048.View.ScoreHighestView
import com.tzx.game2048.View.ScoreView
import com.tzx.game2048.adapter.GameAdapter
import com.tzx.game2048.customView.CustomGridManager
import com.tzx.game2048.customView.RecyclerItemDecoration
import com.tzx.game2048.gameimpl.Game2048impl
import org.json.JSONArray
import java.util.*


/*
* 通过拿到的参去判断是否是经典模式,共用游戏规则
* */
class MainActivity : com.tzx.commonui.activity.BaseActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var score:ScoreView
    private lateinit var  game: Game2048impl
    private lateinit var highestScoreHighestView: ScoreHighestView
    private lateinit var back:Button
    private lateinit var restart:Button
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
        score=findViewById(R.id.scoreView)
        back=findViewById(R.id.button)
        restart=findViewById(R.id.button2)
        back.setOnClickListener {
            finish()
        }
        restart.setOnClickListener {
            restartActivity(this)
        }
        highestScoreHighestView=findViewById(R.id.scoreHighestView)
        highestScoreHighestView.setScore("0")
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
        recyclerView.addItemDecoration(RecyclerItemDecoration((dp2px(this,10f)).toInt(), (dp2px(this,10f)).toInt(), 4,game.map.size))
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
                            score.setScore(game.score.toString())
                        }else if (offsetX>5) {
                            Log.d("TAG", "右滑")
                            game.moveright();
                            score.setScore(game.score.toString())
                        }
                    }else{
                        if (offsetY<-5) {
                            Log.d("TAG", "上滑")
                            game.moveup();
                            score.setScore(game.score.toString())
                        }else if (offsetY>5) {
                            Log.d("TAG", "下滑")
                            game.movedown();
                            score.setScore(game.score.toString())
                        }
                    }
                    true
                }
                else -> false
            }

        }
    }
    fun restartActivity(activity: Activity) {
        val intent = Intent()
        intent.setClass(activity, activity.javaClass)
        activity.startActivity(intent)
        activity.overridePendingTransition(0, 0)
        activity.finish()
    }
}