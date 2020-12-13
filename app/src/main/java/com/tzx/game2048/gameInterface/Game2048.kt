package com.tzx.game2048.gameInterface

import android.content.Context

interface Game2048 {
    fun init(context:Context);
    fun init(context:Context,size:Int);
    fun start();
    fun moveleft();
    fun moveright();
    fun moveup();
    fun movedown();
    fun addRanrom();
    fun isEnd();
    fun isFirstVisiable(position:Int):Boolean;
}