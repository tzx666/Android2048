package com.tzx.game2048.activities

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.gyf.immersionbar.ImmersionBar
import com.gyf.immersionbar.ktx.immersionBar
import com.tzx.game2048.customView.CustomGridManager
import com.tzx.game2048.gameimpl.Game2048impl
import com.tzx.game2048.adapter.GameAdapter
import com.tzx.game2048.R
import it.gmariotti.recyclerview.itemanimator.SlideInOutLeftItemAnimator
import java.util.*

/*
* 通过拿到的参去判断是否是经典模式,共用游戏规则
* */
class MainActivity : BaseActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var score:TextView
    private lateinit var  game: Game2048impl
    var str= Arrays.asList("2","4","8","16","32","64","128","256","512","1024","2048")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        game= Game2048impl()
        game.init(this)
        recyclerView=findViewById(R.id.recycleview)
        score=findViewById(R.id.score)
        val layoutManager: CustomGridManager =
            CustomGridManager(this, 4)
        layoutManager.setScrollEnabled(false)
        recyclerView.setLayoutManager(layoutManager)
        Log.d("TAG", "onCreate: "+game.map.size)
        var adapter= GameAdapter(
            this,
            game.map,
            str.toTypedArray()
        )
        recyclerView.adapter=adapter
        recyclerView.itemAnimator = SlideInOutLeftItemAnimator(recyclerView)
        var startX=0f
        var startY=0f
        var offsetX=0f
        var offsetY=0f
        recyclerView.setOnTouchListener { v, event ->

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
                            adapter.notifyDataSetChanged()
                            score.text="分数"+game.score.toString()
                        }else if (offsetX>5) {
                            Log.d("TAG", "右滑")
                            game.moveright();
                            adapter.notifyDataSetChanged()
                            score.text="分数"+game.score.toString()
                        }
                    }else{
                        if (offsetY<-5) {
                            Log.d("TAG", "上滑")
                            game.moveup();
                            adapter.notifyDataSetChanged()
                            score.text="分数"+game.score.toString()
                        }else if (offsetY>5) {
                            Log.d("TAG", "下滑")
                            game.movedown();
                            adapter.notifyDataSetChanged()
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