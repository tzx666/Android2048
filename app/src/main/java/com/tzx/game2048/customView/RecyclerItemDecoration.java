package com.tzx.game2048.customView;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemDecoration extends RecyclerView.ItemDecoration {

    private int itemSpaceLeft;
    private int itemSpaceCenter;
    private int itemNum;
    private int totalNum;
    public RecyclerItemDecoration(int itemSpaceLeft, int itemSpaceCenter, int itemNum,int totalNum) {
        this.itemSpaceLeft = itemSpaceLeft;
        this.itemSpaceCenter = itemSpaceCenter;
        this.itemNum = itemNum;
        this.totalNum=totalNum;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getResources().getDisplayMetrics().widthPixels;
        if (parent.getChildCount() > 0) {
            if(position<itemNum){
                outRect.top=0;
                outRect.bottom=itemSpaceCenter /3;
            }
            else if(position>=totalNum-itemNum){
                outRect.top=itemSpaceCenter /3;
                outRect.bottom=0;
            }
            else{
                outRect.top=itemSpaceCenter /3;
                outRect.bottom=itemSpaceCenter /3;
            }
            if (position % itemNum == 0) {                  //最左边Item
                outRect.left = 0;
                outRect.right = itemSpaceCenter /3;
            } else if (position % itemNum == itemNum - 1) { //最右边Item
                outRect.left = itemSpaceCenter / 3;
                outRect.right = 0;
            } else {                                        //中间Item
                outRect.left = itemSpaceCenter / 3;
                outRect.right = itemSpaceCenter / 3;
            }
        }
    }
}

