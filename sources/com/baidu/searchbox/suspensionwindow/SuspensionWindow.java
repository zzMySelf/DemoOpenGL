package com.baidu.searchbox.suspensionwindow;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.baidu.searchbox.exclusion.util.DeviceUtil;
import java.util.HashMap;
import java.util.Map;

public class SuspensionWindow {
    private static Builder mBuilder;
    /* access modifiers changed from: private */
    public static Map<String, IFloatWindow> mFloatWindowMap;

    private SuspensionWindow() {
    }

    public static IFloatWindow get(String tag) {
        Map<String, IFloatWindow> map = mFloatWindowMap;
        if (map == null) {
            return null;
        }
        return map.get(tag);
    }

    public static Builder with(Context applicationContext, String tag) {
        Builder builder = new Builder(applicationContext, tag);
        mBuilder = builder;
        return builder;
    }

    public static void destroy(String tag) {
        Map<String, IFloatWindow> map = mFloatWindowMap;
        if (map != null && map.containsKey(tag)) {
            mFloatWindowMap.get(tag).dismiss();
            mFloatWindowMap.remove(tag);
            Builder builder = mBuilder;
            if (builder != null && builder.mSuspensionListener != null) {
                mBuilder.mSuspensionListener.onStateChange(tag, 4);
            }
        }
    }

    public static void destroyAll() {
        Map<String, IFloatWindow> map = mFloatWindowMap;
        if (map != null && !map.isEmpty()) {
            for (String tag : mFloatWindowMap.keySet()) {
                destroy(tag);
            }
        }
    }

    public static class Builder {
        Context mApplicationContext;
        View[] mBarriers;
        int mBottomPadding;
        long mDuration = 200;
        int mGravity = 8388659;
        int mHeight = -2;
        TimeInterpolator mInterpolator = new DecelerateInterpolator();
        int mLeftPadding;
        int mRightPadding;
        int mSpacing;
        SuspensionListener mSuspensionListener;
        String mTag;
        int mTopPadding;
        View mView;
        int mWidth = -2;
        float mXOffset;
        float mYOffset;

        Builder(Context applicationContext, String tag) {
            this.mApplicationContext = applicationContext;
            this.mTag = tag;
        }

        public Builder setView(View view2) {
            this.mView = view2;
            return this;
        }

        public Builder setWidth(int width) {
            this.mWidth = width;
            return this;
        }

        public Builder setWidth(int screenType, float ratio) {
            int i2;
            if (screenType == 0) {
                i2 = DeviceUtil.getScreenWidth(this.mApplicationContext);
            } else {
                i2 = DeviceUtil.getScreenHeight(this.mApplicationContext);
            }
            this.mWidth = (int) (((float) i2) * ratio);
            return this;
        }

        public Builder setHeight(int height) {
            this.mHeight = height;
            return this;
        }

        public Builder setHeight(int screenType, float ratio) {
            int i2;
            if (screenType == 0) {
                i2 = DeviceUtil.getScreenWidth(this.mApplicationContext);
            } else {
                i2 = DeviceUtil.getScreenHeight(this.mApplicationContext);
            }
            this.mHeight = (int) (((float) i2) * ratio);
            return this;
        }

        public Builder setX(int x) {
            this.mXOffset = (float) x;
            return this;
        }

        public Builder setX(int screenType, float ratio) {
            int i2;
            if (screenType == 0) {
                i2 = DeviceUtil.getScreenWidth(this.mApplicationContext);
            } else {
                i2 = DeviceUtil.getScreenHeight(this.mApplicationContext);
            }
            this.mXOffset = (float) ((int) (((float) i2) * ratio));
            return this;
        }

        public Builder setY(int y) {
            this.mYOffset = (float) y;
            return this;
        }

        public Builder setY(int screenType, float ratio) {
            int i2;
            if (screenType == 0) {
                i2 = DeviceUtil.getScreenWidth(this.mApplicationContext);
            } else {
                i2 = DeviceUtil.getScreenHeight(this.mApplicationContext);
            }
            this.mYOffset = (float) ((int) (((float) i2) * ratio));
            return this;
        }

        public Builder setSpacing(int spacing) {
            this.mSpacing = Math.max(spacing, 0);
            return this;
        }

        public Builder setPadding(int left, int top, int right, int bottom) {
            this.mLeftPadding = left;
            this.mTopPadding = top;
            this.mRightPadding = right;
            this.mBottomPadding = bottom;
            return this;
        }

        public Builder setMoveStyle(long duration, TimeInterpolator interpolator) {
            this.mDuration = duration;
            this.mInterpolator = interpolator;
            return this;
        }

        public Builder setBarriers(View... vs) {
            this.mBarriers = vs;
            return this;
        }

        public Builder setSuspensionListener(SuspensionListener listener) {
            this.mSuspensionListener = listener;
            return this;
        }

        public void build() {
            if (SuspensionWindow.mFloatWindowMap == null) {
                Map unused = SuspensionWindow.mFloatWindowMap = new HashMap();
            }
            if (!SuspensionWindow.mFloatWindowMap.containsKey(this.mTag) && this.mView != null) {
                SuspensionWindow.mFloatWindowMap.put(this.mTag, new IFloatWindowImpl(this));
                SuspensionListener suspensionListener = this.mSuspensionListener;
                if (suspensionListener != null) {
                    suspensionListener.onStateChange(this.mTag, 3);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setTag(String newTag) {
            if (SuspensionWindow.mFloatWindowMap != null && !TextUtils.equals(newTag, this.mTag)) {
                IFloatWindow iFloatWindow = (IFloatWindow) SuspensionWindow.mFloatWindowMap.get(this.mTag);
                IFloatWindow floatWindowImpl = iFloatWindow;
                if (iFloatWindow != null) {
                    SuspensionWindow.mFloatWindowMap.remove(this.mTag);
                    SuspensionWindow.mFloatWindowMap.put(newTag, floatWindowImpl);
                    this.mTag = newTag;
                }
            }
        }
    }
}
