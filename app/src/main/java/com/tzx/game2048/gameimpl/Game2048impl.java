package com.tzx.game2048.gameimpl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.tzx.game2048.R;
import com.tzx.game2048.activities.MainActivity;
import com.tzx.game2048.adapter.GameAdapter;
import com.tzx.game2048.gameInterface.Game2048;
import com.tzx.game2048.util.Callback;
import com.tzx.game2048.util.UtilsKt;

import org.jetbrains.annotations.NotNull;

import java.util.Random;
/*
*@author tzx
*@descrption 2048的逻辑实现
*/
public class Game2048impl implements Game2048 {
    private  int score;
    private  int[] map;
    private boolean[] isfirstAppear;
    private boolean[] ismerged;
    private  int MAPSIZE;
    private int GAME_OVER=101;
    private int GAME_WIN=102;
    private int GAME_CONTINUE=103;
    private int state=GAME_CONTINUE;
    private GameAdapter adapter;
    private Context context;

    public void setAdapter(GameAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void init(Context context,int size) {
        MAPSIZE=size;
        this.context=context;
        map=new int[MAPSIZE*MAPSIZE];
        ismerged=new boolean[MAPSIZE*MAPSIZE];
        isfirstAppear=new boolean[MAPSIZE*MAPSIZE];
        addRanrom();
        addRanrom();
    }

    @Override
    public boolean isFirstVisiable(int positon) {
        return isfirstAppear[positon];
    }

    private enum state{
        GAME_OVER,GAME_CONTINUE,GAME_WIN
    };
    @Override
    public void init(Context context) {
        this.context=context;
        MAPSIZE=4;
        map=new int[MAPSIZE*MAPSIZE];
        ismerged=new boolean[MAPSIZE*MAPSIZE];
        isfirstAppear=new boolean[MAPSIZE*MAPSIZE];
        addRanrom();
        addRanrom();
    }

    @Override
    public void start() {

    }
    private boolean updateDataset(){
        if(adapter==null){
            throw new IllegalStateException();
        }
        try{
            //检测新合并的播放合并动画
            for(int i=0;i<isfirstAppear.length;i++){
                /*if(isfirstAppear[i]){
                   // adapter.notifyItemChanged(i, "share");
                    adapter.notifyItemChanged(i);
                }
                if(ismerged[i]){
                   // adapter.notifyItemChanged(i, "share");
                    adapter.notifyItemChanged(i);
                }*/
                adapter.notifyItemChanged(i);
            }
            // 播放结束，开始清屏
            for(int i=0;i<isfirstAppear.length;i++) {
                isfirstAppear[i] = false;
                isfirstAppear[i]=false;
                // 全部动画播放完毕后，更新棋盘
               // adapter.notifyDataSetChanged();
            }
        }catch (Exception e){

        }
        return true;
    }
    public int[] getMap() {
        return map;
    }

    @Override
    public void moveleft() {
        boolean merge=false;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                for(int z=j+1;z<4;z++){
                    if(map[i*MAPSIZE+z]>0){
                        if(map[i*MAPSIZE+j]==0){
                            map[i*MAPSIZE+j]=map[i*MAPSIZE+z];
                            map[i*MAPSIZE+z]=0;
                            ismerged[i*MAPSIZE+j]=true;
                            j--;
                            merge=true;
                        }else if(map[i*MAPSIZE+j]==map[i*MAPSIZE+z]){
                            map[i*MAPSIZE+j]*=2;
                            score+=map[i*MAPSIZE+j];
                            map[i*MAPSIZE+z]=0;
                            ismerged[i*MAPSIZE+j]=true;
                            merge=true;
                        }
                        break;
                    }
                }
            }
        }
        if(merge){
            /*开始走合并动画播放流程*/
            addRanrom();
            updateDataset();
            isEnd();
        }
    }

    @Override
    public void moveright() {
        boolean merge=false;
        for(int i=0;i<4;i++){
            for(int j=3;j>0;j--){
                for(int z=j-1;z>=0;z--){
                    if(map[i*MAPSIZE+z]>0){
                        if(map[i*MAPSIZE+j]==0){
                            map[i*MAPSIZE+j]=map[i*MAPSIZE+z];
                            map[i*MAPSIZE+z]=0;
                            ismerged[i*MAPSIZE+j]=true;
                            j++;
                            merge=true;
                        }else if(map[i*MAPSIZE+j]==map[i*MAPSIZE+z]){
                            map[i*MAPSIZE+j]*=2;
                            map[i*MAPSIZE+z]=0;
                            score+=map[i*MAPSIZE+j];
                            ismerged[i*MAPSIZE+j]=true;
                            merge=true;
                        }
                        break;
                    }
                }
            }
        }
        if(merge){
            addRanrom();
            updateDataset();
            isEnd();
        }
    }

    @Override
    public void moveup() {
        boolean merge=false;
        for(int j=0;j<4;j++){
            for(int i=0;i<4;i++){
                for(int z=i+1;z<4;z++){
                    if(map[z*MAPSIZE+j]>0){
                        if(map[i*MAPSIZE+j]==0){
                            map[i*MAPSIZE+j]=map[z*MAPSIZE+j];
                            map[z*MAPSIZE+j]=0;
                            ismerged[i*MAPSIZE+j]=true;
                            i--;
                            merge=true;
                        }else if(map[i*MAPSIZE+j]==map[z*MAPSIZE+j]){
                            map[i*MAPSIZE+j]*=2;
                            score+=map[i*MAPSIZE+j];
                            map[z*MAPSIZE+j]=0;
                            ismerged[i*MAPSIZE+j]=true;
                            merge=true;
                        }
                        break;
                    }
                }
            }
        }
        if(merge){
            addRanrom();
            updateDataset();
            isEnd();
        }
    }

    @Override
    public void movedown() {
        boolean merge=false;
        for(int j=0;j<4;j++){
            for(int i=3;i>0;i--){
                for(int z=i-1;z>=0;z--){
                    if(map[z*MAPSIZE+j]>0){
                        if(map[i*MAPSIZE+j]==0){
                            map[i*MAPSIZE+j]=map[z*MAPSIZE+j];
                            map[z*MAPSIZE+j]=0;
                            ismerged[i*MAPSIZE+j]=true;
                            i++;
                            merge=true;
                        }else if(map[i*MAPSIZE+j]==map[z*MAPSIZE+j]){
                            map[i*MAPSIZE+j]*=2;
                            score+=map[i*MAPSIZE+j];
                            map[z*MAPSIZE+j]=0;
                            ismerged[i*MAPSIZE+j]=true;
                            merge=true;
                        }
                        break;
                    }
                }
            }
        }
        if(merge){
            addRanrom();
            updateDataset();
            isEnd();
        }
    }

    @Override
    public void addRanrom() {
        Random rand=new Random();
        int x=rand.nextInt(4);
        int y=rand.nextInt(4);
        do{
            x=rand.nextInt(4);
            y=rand.nextInt(4);
        }while(map[x*MAPSIZE+y]!=0);
        isfirstAppear[x*MAPSIZE+y]=true;
        map[x*MAPSIZE+y]=Math.random()>0.1?2:4;
    }

    @Override
    public void isEnd() {
        int state=this.GAME_OVER;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(map[i*MAPSIZE+j]==2048){
                    state=GAME_WIN;
                    return;
                }else if(map[i*MAPSIZE+j]==0||(i>0&&map[i*MAPSIZE+j]==map[(i-1)*MAPSIZE+j])||(i<3&&map[i*MAPSIZE+j]==map[(i+1)*MAPSIZE+j])||(j>0&&map[i*MAPSIZE+j]==map[i*MAPSIZE+(j-1)])||(j<3&&map[i*MAPSIZE+j]==map[i*MAPSIZE+(j+1)])){
                    state=this.GAME_CONTINUE;
                    return;
                }
            }
        }
        if(state==GAME_OVER){
            UtilsKt.showDialog(context, "游戏结束", "", new Callback() {
                @Override
                public void onConfirm(@NotNull DialogInterface dialog) {
                    ((Activity)context).finish();
                }

                @Override
                public void onCancel(@NotNull DialogInterface dialog) {

                }
            });
        }else if(state==GAME_WIN){
            UtilsKt.showDialog(context, "游戏胜利", "", new Callback() {
                @Override
                public void onConfirm(@NotNull DialogInterface dialog) {
                    ((Activity)context).finish();
                }

                @Override
                public void onCancel(@NotNull DialogInterface dialog) {

                }
            });
        }
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    /*
    void Gesture(int c){
        if(c==1) moveleft();		//getKeyCode()是表示按键按下的序号，KeyEvent.VK_UP表示up（下）键的序号
        if(c==2) moveright();
        if(c==3) moveup();
        if(c==4) movedown();
    }*/
}
