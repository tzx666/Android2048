package com.tzx.game2048.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.tzx.game2048.R;

import java.util.HashMap;
import java.util.List;

public class GameAdapter extends RecyclerView.Adapter <GameAdapter.ViewHolder>{
    int []map=new int[0];
    int []arr={2,4,8,16,32,64,128,256,512,1024,2048};
    private Context context;
    private HashMap<Integer,String>hashMap=new HashMap<>();
    /*经典模式默认显示*/
    public GameAdapter(Context context,int []map){
        this.map=map;
        this.context=context;
        for(int i=0;i<arr.length;i++){
            hashMap.put(arr[i],String.valueOf(arr[i]));
        }
    }
    public GameAdapter(Context context,int []map,String[] strings){
        this.map=map;
        this.context=context;
        if(strings.length!=arr.length){
            return;
        }
        for(int i=0;i<arr.length;i++){
            hashMap.put(arr[i],String.valueOf(strings[i]));
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardnum, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.num.setBackgroundColor(Color.YELLOW);
        int numpos=map[position];
        final ViewHolder recViewHolderLeft = (ViewHolder) holder;

        switch (numpos){
            case 0: {
                holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_0));break;
            }
            case 2: {
                holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_2));break;
            }
            case 4:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_4));break;
            case 8:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_8));break;
            case 16:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_16));break;
            case 32:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_32));break;
            case 64:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_64));break;
            case 256:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_256));break;
            case 512:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_512));break;
            case 1024:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_1024));break;
            case 2048:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_2048));break;
            case 128:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_128));break;
            default:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_d));break;
        }
        holder.num.setText(map[position]!=0?String.valueOf(hashMap.get(map[position])):"");
    }

    @Override
    public void onBindViewHolder(@NonNull GameAdapter.ViewHolder holder, int position, @NonNull List<Object> payloads) {
        if (payloads == null || payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {
            int numpos=map[position];
            final ViewHolder recViewHolderLeft = (ViewHolder) holder;

            switch (numpos){
                case 0: {
                    holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_0));break;
                }
                case 2: {
                    holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_2));break;
                }
                case 4:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_4));break;
                case 8:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_8));break;
                case 16:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_16));break;
                case 32:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_32));break;
                case 64:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_64));break;
                case 256:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_256));break;
                case 512:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_512));break;
                case 1024:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_1024));break;
                case 2048:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_2048));break;
                case 128:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_128));break;
                default:holder.num.setBackground(context.getResources().getDrawable(R.drawable.border_d));break;
            }
            holder.num.setText(map[position]!=0?String.valueOf(hashMap.get(map[position])):"");
            //change item
        }
    }

    @Override
    public int getItemCount() {
        return map.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView num;
        private ConstraintLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            num=itemView.findViewById(R.id.textView);
            layout=itemView.findViewById(R.id.numbackground);
        }
    }
}
