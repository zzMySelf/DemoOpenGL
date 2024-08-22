package com.baidu.sapi2;

import android.graphics.drawable.Drawable;
import com.baidu.aiscan.R;
import com.baidu.sapi2.callback.TitleBtnCallback;

public class PassportViewManager implements NoProguard {
    public static SapiConfiguration c;
    public static PassportViewManager d;
    public TitleBtnCallback a;
    public TitleViewModule b = null;

    public static class TitleViewModule implements NoProguard {
        public static final int DEFAULT_TEXT_COLOR = PassportViewManager.c.context.getResources().getColor(R.color.sapi_sdk_edit_text_color);
        public int bgColor = Integer.MAX_VALUE;
        public int bgHeight = Integer.MAX_VALUE;
        public int dividerLineVisible = 0;
        public Drawable leftBtnDrawableBottom = null;
        public Drawable leftBtnDrawableLeft = null;
        public Drawable leftBtnDrawableRight = null;
        public Drawable leftBtnDrawableTop = null;
        public int leftBtnImgResId = Integer.MAX_VALUE;
        public int leftBtnImgVisible = 0;
        public String leftBtnText = null;
        public int leftBtnTextColor = DEFAULT_TEXT_COLOR;
        public float leftBtnTextSize = PassportViewManager.c.context.getResources().getDimension(R.dimen.sapi_sdk_title_left_btn_text_size);
        public int leftBtnTextVisible = 4;
        public String rightBtnText = null;
        public int rightBtnTextColor = DEFAULT_TEXT_COLOR;
        public float rightBtnTextSize = PassportViewManager.c.context.getResources().getDimension(R.dimen.sapi_sdk_title_right_btn_text_size);
        public int rightBtnVisible = 4;
        public Drawable titleDrawableBottom = null;
        public Drawable titleDrawableLeft = null;
        public Drawable titleDrawableRight = null;
        public Drawable titleDrawableTop = null;
        public String titleText = null;
        public boolean titleTextBold = false;
        public int titleTextColor = DEFAULT_TEXT_COLOR;
        public float titleTextSize = PassportViewManager.c.context.getResources().getDimension(R.dimen.sapi_sdk_title_text_size);
        public int titleVisible = 0;
        public boolean useWebviewTitle = true;
    }

    public PassportViewManager() {
        c = SapiAccountManager.getInstance().getSapiConfiguration();
    }

    public static synchronized PassportViewManager getInstance() {
        PassportViewManager passportViewManager;
        synchronized (PassportViewManager.class) {
            if (d == null) {
                d = new PassportViewManager();
            }
            passportViewManager = d;
        }
        return passportViewManager;
    }

    public void configTitle(TitleViewModule titleViewModule) {
        this.b = titleViewModule;
        if (titleViewModule.bgColor == Integer.MAX_VALUE) {
            titleViewModule.bgColor = -1;
        }
        if (titleViewModule.leftBtnImgResId == Integer.MAX_VALUE) {
            titleViewModule.leftBtnImgResId = R.drawable.sapi_sdk_btn_back;
        }
    }

    public TitleBtnCallback getTitleBtnCallback() {
        return this.a;
    }

    public TitleViewModule getTitleViewModule() {
        return this.b;
    }

    public void release() {
        this.a = null;
        this.b = null;
        SapiWebView.statLoadLogin = null;
    }

    public void setTitleBtnCallback(TitleBtnCallback titleBtnCallback) {
        this.a = titleBtnCallback;
    }
}
