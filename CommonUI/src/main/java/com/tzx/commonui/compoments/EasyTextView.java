package com.tzx.commonui.compoments;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EasyTextView extends androidx.appcompat.widget.AppCompatTextView {
    public EasyTextView(@NonNull Context context) {
        super(context);
    }

    public EasyTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EasyTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int length() {
        return super.length();
    }

    @Override
    public float getTextSize() {
        return super.getTextSize();
    }
}
