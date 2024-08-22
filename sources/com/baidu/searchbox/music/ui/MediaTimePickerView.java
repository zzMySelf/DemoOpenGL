package com.baidu.searchbox.music.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.bdmedia.interfaces.R;
import com.baidu.searchbox.ui.BdTimePicker;

public class MediaTimePickerView extends LinearLayout implements BdTimePicker.OnTimeChangedListener {
    private Context mContext;
    private BdTimePicker mTimePicker;
    private TextView mTvPickerCancel;
    private TextView mTvPickerConfirm;

    public MediaTimePickerView(Context context) {
        super(context);
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.media_time_picker_view, this);
        initView();
    }

    private void initView() {
        Resources res = getResources();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        setLayoutParams(layoutParams);
        setClickable(true);
        setOrientation(1);
        setBackground(res.getDrawable(R.drawable.mini_setting_corner_bg));
        setPadding(0, res.getDimensionPixelOffset(R.dimen.tts_setting_view_padding_top), 0, 0);
        TextView textView = (TextView) findViewById(R.id.tv_picker_confirm);
        this.mTvPickerConfirm = textView;
        textView.setTextColor(res.getColor(R.color.music_setting_subtitle));
        TextView textView2 = (TextView) findViewById(R.id.tv_picker_cancel);
        this.mTvPickerCancel = textView2;
        textView2.setTextColor(res.getColor(R.color.music_setting_subtitle));
        findViewById(R.id.divider_time_picker).setBackgroundColor(res.getColor(R.color.music_divider_color));
        BdTimePicker bdTimePicker = (BdTimePicker) findViewById(R.id.media_time_picker);
        this.mTimePicker = bdTimePicker;
        bdTimePicker.setMargins(res.getDimensionPixelSize(R.dimen.media_time_picker_margin_horizontal), res.getDimensionPixelSize(R.dimen.media_time_picker_margin_vertical), res.getDimensionPixelSize(R.dimen.media_time_picker_margin_horizontal), res.getDimensionPixelSize(R.dimen.media_time_picker_margin_vertical));
        this.mTimePicker.setWheelsHeight(res.getDimensionPixelSize(R.dimen.media_time_picker_wheels_height));
        this.mTimePicker.setWheelsSpacing(res.getDimensionPixelSize(R.dimen.media_time_picker_wheels_spacing));
        this.mTimePicker.setItemsSpacing(res.getDimensionPixelSize(R.dimen.media_time_picker_items_spacing));
        this.mTimePicker.setTextSizeInDp(14);
        this.mTimePicker.setOnTimeChangeListener(this);
    }

    public void onTimeChanged(BdTimePicker view2, int hour, int minute) {
        if (hour == 0 && minute == 0) {
            view2.setMinute(1);
        }
    }

    public int getPickerHour() {
        return this.mTimePicker.getHour();
    }

    public int getPickerMinute() {
        return this.mTimePicker.getMinute();
    }

    public void setOnConfirmClickListener(View.OnClickListener confirmClickListener) {
        this.mTvPickerConfirm.setOnClickListener(confirmClickListener);
    }

    public void setOnCancelClickListener(View.OnClickListener cancelClickListener) {
        this.mTvPickerCancel.setOnClickListener(cancelClickListener);
    }
}
