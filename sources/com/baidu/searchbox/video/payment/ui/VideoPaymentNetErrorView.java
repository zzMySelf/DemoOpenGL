package com.baidu.searchbox.video.payment.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.video.detail.business.R;

public class VideoPaymentNetErrorView extends RelativeLayout implements View.OnClickListener {
    private Button mErrorRetry;
    private TextView mErrorTips;
    OnClickEvent mEvent;

    public interface OnClickEvent {
        void onClickRetry();
    }

    public VideoPaymentNetErrorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public VideoPaymentNetErrorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VideoPaymentNetErrorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setOnClickEvent(OnClickEvent event) {
        this.mEvent = event;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.video_payment_net_error, this, true);
        this.mErrorTips = (TextView) findViewById(R.id.tv_error);
        Button button = (Button) findViewById(R.id.bt_retry);
        this.mErrorRetry = button;
        button.setOnClickListener(this);
    }

    public void onClick(View v) {
        OnClickEvent onClickEvent;
        if (v.equals(this.mErrorRetry) && (onClickEvent = this.mEvent) != null) {
            onClickEvent.onClickRetry();
        }
    }
}
