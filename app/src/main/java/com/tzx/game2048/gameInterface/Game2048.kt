package com.tzx.game2048.gameInterface

interface Game2048 {
    fun init();
    fun init(size:Int);
    fun start();
    fun moveleft();
    fun moveright();
    fun moveup();
    fun movedown();
    fun addRanrom();
    fun isEnd();
    fun isFirstVisiable(position:Int):Boolean;
}