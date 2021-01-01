package com.tzx.game2048.gameInterface

import android.content.Context
import com.tzx.game2048.adapter.GameAdapter

interface Game2048 {
    fun init(context:Context, adapter: GameAdapter);
    fun init(context:Context,size:Int, adapter: GameAdapter);
    fun start();
    fun moveleft();
    fun moveright();
    fun moveup();
    fun movedown();
    fun addRanrom();
    fun isEnd();
    fun isFirstVisiable(position:Int):Boolean;
}