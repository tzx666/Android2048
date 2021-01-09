package com.tzx.game2048.gameimpl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import com.tzx.commonui.util.Callback;
import com.tzx.commonui.util.UtilsKt;
import com.tzx.game2048.adapter.GameAdapter;
import com.tzx.game2048.gameInterface.Game2048;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Random;
/*
*@author tzx
*@descrption 2048的逻辑实现
*/
public class Game2048impl implements Game2048 {
    private  int score;
    private  int[] map;
    private boolean[] isfirstAppear;
    private boolean[] isMerge;
    private boolean[] willdisMerge;
    private GameAdapter adapter;
    private DefaultItemAnimator animator;
    private  int MAPSIZE;
    private int GAME_OVER=101;
    private int GAME_WIN=102;
    private int GAME_CONTINUE=103;
    private int state=GAME_CONTINUE;
    private Context context;
    private RecyclerView recyclerView;
    public void setAnimator(DefaultItemAnimator animator) {
        this.animator = animator;
    }

    public void setAdapter(GameAdapter adapter) {
        this.adapter = adapter;
    }
    public void init(Context context, RecyclerView recyclerView) {
        MAPSIZE=4;
        this.recyclerView=recyclerView;
        this.context=context;
        map=new int[MAPSIZE*MAPSIZE];
        isfirstAppear=new boolean[MAPSIZE*MAPSIZE];
        isMerge=new boolean[MAPSIZE*MAPSIZE];
        willdisMerge=new boolean[MAPSIZE*MAPSIZE];
        addRanrom();
        addRanrom();
    }
    @Override
    public void init(Context context,int size,GameAdapter adapter) {
        MAPSIZE=size;
        this.context=context;
        map=new int[MAPSIZE*MAPSIZE];
        isfirstAppear=new boolean[MAPSIZE*MAPSIZE];
        isMerge=new boolean[MAPSIZE*MAPSIZE];
        willdisMerge=new boolean[MAPSIZE*MAPSIZE];
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
    public void init(Context context,GameAdapter adapter) {
        this.context=context;
        MAPSIZE=4;
        map=new int[MAPSIZE*MAPSIZE];
        isfirstAppear=new boolean[MAPSIZE*MAPSIZE];
        isMerge=new boolean[MAPSIZE*MAPSIZE];
        willdisMerge=new boolean[MAPSIZE*MAPSIZE];
        addRanrom();
        addRanrom();
    }

    @Override
    public void start() {

    }
    private void clear(){
        Arrays.fill(isfirstAppear,false);
        Arrays.fill(isMerge,false);
        Arrays.fill(willdisMerge,false);
    }
    public int[] getMap() {
        return map;
    }
    private void showAmination(){
        //先展示被删除的
        for(int i=0;i<MAPSIZE*MAPSIZE;i++){
            if(isMerge[i]){
                Log.d("TAG", "showAminationisMerge: "+i);
                adapter.notifyItemChanged(i,"change");
            }else if(isfirstAppear[i]){
                Log.d("TAG", "showAminationisfirstAppear: "+i);
                adapter.notifyItemChanged(i,"appear");
            }else{
                adapter.notifyItemChanged(i,"");
            }
        }
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
                            isMerge[i*MAPSIZE+j]=true;
                            willdisMerge[i*MAPSIZE+z]=true;
                            j--;
                            merge=true;
                        }else if(map[i*MAPSIZE+j]==map[i*MAPSIZE+z]){
                            map[i*MAPSIZE+j]*=2;
                            score+=map[i*MAPSIZE+j];
                            map[i*MAPSIZE+z]=0;
                            isMerge[i*MAPSIZE+j]=true;
                            willdisMerge[i*MAPSIZE+z]=true;
                            merge=true;
                        }
                        break;
                    }
                }
            }
        }
        if(merge){
            addRanrom();
            showAmination();
            clear();
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
                            isMerge[i*MAPSIZE+j]=true;
                            willdisMerge[i*MAPSIZE+z]=true;
                            j++;
                            merge=true;
                        }else if(map[i*MAPSIZE+j]==map[i*MAPSIZE+z]){
                            map[i*MAPSIZE+j]*=2;
                            map[i*MAPSIZE+z]=0;
                            score+=map[i*MAPSIZE+j];
                            isMerge[i*MAPSIZE+j]=true;
                            willdisMerge[i*MAPSIZE+z]=true;
                            merge=true;
                        }
                        break;
                    }
                }
            }
        }
        if(merge){
            addRanrom();
            showAmination();
            clear();
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
                            isMerge[i*MAPSIZE+j]=true;
                            willdisMerge[i*MAPSIZE+z]=true;
                            i--;
                            merge=true;
                        }else if(map[i*MAPSIZE+j]==map[z*MAPSIZE+j]){
                            map[i*MAPSIZE+j]*=2;
                            score+=map[i*MAPSIZE+j];
                            map[z*MAPSIZE+j]=0;
                            isMerge[i*MAPSIZE+j]=true;
                            willdisMerge[i*MAPSIZE+z]=true;
                            merge=true;
                        }
                        break;
                    }
                }
            }
        }
        if(merge){
            addRanrom();
            showAmination();
            clear();
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
                            isMerge[i*MAPSIZE+j]=true;
                            willdisMerge[i*MAPSIZE+z]=true;
                            i++;
                            merge=true;
                        }else if(map[i*MAPSIZE+j]==map[z*MAPSIZE+j]){
                            map[i*MAPSIZE+j]*=2;
                            score+=map[i*MAPSIZE+j];
                            map[z*MAPSIZE+j]=0;
                            isMerge[i*MAPSIZE+j]=true;
                            willdisMerge[i*MAPSIZE+z]=true;
                            merge=true;
                        }
                        break;
                    }
                }
            }
        }
        if(merge){
            addRanrom();
            showAmination();
            clear();
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
    void Gesture(int c){
        if(c==1) moveleft();		//getKeyCode()是表示按键按下的序号，KeyEvent.VK_UP表示up（下）键的序号
        if(c==2) moveright();
        if(c==3) moveup();
        if(c==4) movedown();
    }
}
