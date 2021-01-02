package com.tzx.game2048.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.tzx.game2048.R;

public class ScoreView extends ConstraintLayout {
    private TextView score;
    public ScoreView(Context context) {
        super(context);
        init();
    }

    public ScoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    void init(){
        View view = (View) View.inflate(getContext(), R.layout.scoreitem, this);
        score=view.findViewById(R.id.textView6);
        score.setText("0");
    }
    public void setScore(String s){
        score.setText(s);
        invalidate();
    }
}
