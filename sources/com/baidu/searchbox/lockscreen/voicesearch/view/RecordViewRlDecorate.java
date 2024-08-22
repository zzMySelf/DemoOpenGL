package com.baidu.searchbox.lockscreen.voicesearch.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.searchbox.lockscreen.statistics.LifeCycle;
import com.baidu.searchbox.lockscreen.util.LockScreenUtil;
import com.baidu.searchbox.lockscreen.voicesearch.R;
import com.baidu.searchbox.lockscreen.voicesearch.widget.RecordButtonView;

public class RecordViewRlDecorate {
    private static final String TAG = RecordViewRlDecorate.class.getSimpleName();
    private Context mContext;
    private RecordButtonView mRecordBtnRl;
    private ImageView mRecordIv;
    private TextView mRecordTv = ((TextView) this.mRecordBtnRl.findViewById(R.id.recordBtn));

    public RecordViewRlDecorate(RecordButtonView recordBtnRl) {
        this.mRecordBtnRl = recordBtnRl;
        this.mRecordIv = (ImageView) recordBtnRl.findViewById(R.id.recordIv);
        this.mContext = recordBtnRl.getContext();
        initShowType();
    }

    public void setText(int strId) {
        setText(this.mContext.getResources().getString(strId));
    }

    public void setText(String text) {
        TextView textView = this.mRecordTv;
        if (textView != null) {
            textView.setText(text);
        }
    }

    public void setEnabled(boolean isEnabled) {
        RecordButtonView recordButtonView = this.mRecordBtnRl;
        if (recordButtonView != null) {
            recordButtonView.setEnabled(isEnabled);
        }
        ImageView imageView = this.mRecordIv;
        if (imageView != null) {
            imageView.setEnabled(isEnabled);
        }
        TextView textView = this.mRecordTv;
        if (textView != null) {
            textView.setEnabled(isEnabled);
        }
    }

    private void initShowType() {
        RecordButtonView recordButtonView = this.mRecordBtnRl;
        if (recordButtonView != null) {
            recordButtonView.setBackground(createRecordViewBgDrawable());
        }
        if (this.mRecordIv != null) {
            Drawable normal = ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.lockscreen_voice_search_mic_normal, (Resources.Theme) null);
            Drawable pressed = ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.lockscreen_voice_search_mic_pressed, (Resources.Theme) null);
            Drawable unEnabled = ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.lockscreen_voice_search_mic_grey, (Resources.Theme) null);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919, 16842910}, pressed);
            stateListDrawable.addState(new int[]{16842910}, normal);
            stateListDrawable.addState(new int[]{-16842910}, unEnabled);
            this.mRecordIv.setBackground(stateListDrawable);
        }
        if (this.mRecordTv != null) {
            this.mRecordTv.setTextColor(createColorState(R.color.lockscreen_voice_search_recognize_text_pressed, R.color.lockscreen_voice_search_recognize_text_normal, R.color.lockscreen_voice_search_recognize_text_unclickable));
        }
    }

    private ColorStateList createColorState(int pressedId, int normalId, int unEnabledId) {
        return new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[]{16842910}, new int[]{-16842910}}, new int[]{this.mContext.getResources().getColor(pressedId), this.mContext.getResources().getColor(normalId), this.mContext.getResources().getColor(unEnabledId)});
    }

    private StateListDrawable createRecordViewBgDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        int strokeColor = Color.parseColor("#59ffffff");
        int fillColor = Color.parseColor("#26ffffff");
        GradientDrawable normal = new GradientDrawable();
        normal.setColor(fillColor);
        normal.setCornerRadius((float) 100);
        normal.setStroke(1, strokeColor);
        int strokeColor2 = Color.parseColor("#1affffff");
        int fillColor2 = Color.parseColor("#1affffff");
        GradientDrawable pressed = new GradientDrawable();
        pressed.setColor(fillColor2);
        pressed.setCornerRadius((float) 100);
        pressed.setStroke(1, strokeColor2);
        int strokeColor3 = Color.parseColor("#0dffffff");
        int fillColor3 = Color.parseColor("#1affffff");
        GradientDrawable unEnable = new GradientDrawable();
        unEnable.setColor(fillColor3);
        unEnable.setCornerRadius((float) 100);
        unEnable.setStroke(1, strokeColor3);
        stateListDrawable.addState(new int[]{16842919, 16842910}, pressed);
        stateListDrawable.addState(new int[]{16842910}, normal);
        stateListDrawable.addState(new int[]{-16842910}, unEnable);
        return stateListDrawable;
    }

    public void setPressState(boolean pressed) {
        if (LockScreenUtil.GLOBAL_DEBUG) {
            Log.e(TAG, LifeCycle.getCurrentMethodName() + " pressed:" + pressed);
        }
        this.mRecordBtnRl.setPressed(pressed);
        this.mRecordIv.setPressed(pressed);
        this.mRecordTv.setPressed(pressed);
    }
}
