package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.content.res.AppCompatResources;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.swan.apps.R;

public class NetworkErrorView extends CommonEmptyView {
    public static final int THEME_CLASIC = 0;
    public static final int THEME_NIGHT = 2;
    private int mMode;

    public NetworkErrorView(Context context) {
        super(context);
        init();
    }

    public NetworkErrorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NetworkErrorView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        this.mRefreshTextBtn.setVisibility(0);
        setTitle(getContext().getString(R.string.swanapp_tip_net_unavailable));
        setIcon(com.baidu.swan.apps.ui.R.drawable.swanapp_error_page_network_error);
    }

    public void updateUI(int mode) {
        this.mMode = mode;
        if (mode == 2) {
            setBackgroundColor(-16777216);
            this.mIcon.setAlpha(0.5f);
            this.mTitle.setTextColor(getResources().getColor(R.color.aiapps_emptyview_title_text_color_night));
            this.mSubTitle.setTextColor(getResources().getColor(R.color.aiapps_emptyview_subtitle_text_color_night));
            this.mRefreshTextBtn.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.swan_app_emptyview_btn_text_color_night));
        } else {
            setBackgroundColor(-1);
            this.mIcon.setAlpha(1.0f);
            this.mTitle.setTextColor(getResources().getColor(R.color.aiapps_emptyview_title_text_color));
            this.mSubTitle.setTextColor(getResources().getColor(R.color.aiapps_emptyview_subtitle_text_color));
            this.mRefreshTextBtn.setTextColor(AppCompatResources.getColorStateList(getContext(), com.baidu.swan.apps.ui.R.color.swan_app_emptyview_btn_text_color));
        }
        this.mIcon.setImageDrawable(getContext().getResources().getDrawable(com.baidu.swan.apps.ui.R.drawable.swanapp_error_page_network_error));
        this.mRefreshTextBtn.setBackground(getContext().getResources().getDrawable(com.baidu.swan.apps.ui.R.drawable.aiapps_emptyview_btn_bg));
    }

    public void setReloadClickListener(View.OnClickListener listener) {
        setTextButtonClickListener(listener);
    }

    public void setEmptyViewVisiblity(int visibility) {
        this.mIcon.setVisibility(visibility);
    }

    public void setEmptyButtonVisiblity(int visibility) {
        this.mRefreshTextBtn.setVisibility(visibility);
    }

    public void setNetworkButtonShow(boolean isShow) {
        if (this.mLinkText != null) {
            this.mLinkText.setVisibility(isShow ? 0 : 4);
        }
    }

    public void setBottomLayout(View.OnClickListener listener, View child, RelativeLayout.LayoutParams params) {
        if (this.mBottomLayout != null && child != null) {
            this.mBottomLayout.setVisibility(0);
            this.mBottomLayout.addView(child);
            if (params != null) {
                this.mBottomLayout.setLayoutParams(params);
            }
            this.mBottomLayout.setOnClickListener(listener);
        }
    }

    public void setVisibility(int visibility) {
        if (visibility == 0) {
            postErrorViewShowEvent(this);
        }
        super.setVisibility(visibility);
    }

    public boolean isNight() {
        return this.mMode == 2;
    }

    public static void postErrorViewShowEvent(View errorView) {
        ErrorViewEvent event = new ErrorViewEvent(1);
        event.arg0 = 1;
        event.obj = errorView;
        BdEventBus.Companion.getDefault().post(event);
    }

    public static class ErrorViewEvent {
        public static final int MESSAGE_ID_SHOW = 1;
        public static final int MESSAGE_SHOW_ARG0_NA = 1;
        public int arg0;
        public int arg1;
        public int messageId;
        public Object obj;

        public ErrorViewEvent(int messageId2) {
            this.messageId = messageId2;
        }
    }
}
