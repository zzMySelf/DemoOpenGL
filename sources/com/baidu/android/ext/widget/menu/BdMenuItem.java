package com.baidu.android.ext.widget.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class BdMenuItem {
    private static final int NO_ICON = 0;
    protected boolean mChecked = false;
    protected Context mContext;
    protected long mDismissDelayTime = 0;
    protected boolean mEnabled = true;
    protected Drawable mIconDrawable;
    protected int mIconResId = 0;
    protected final int mId;
    protected boolean mIsAutoDismiss = true;
    private BdMenu mMenu;
    protected OnItemClickListener mOnClickListener;
    protected boolean mShowTip = false;
    protected CharSequence mTitle;

    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    BdMenuItem(Context context, int id, CharSequence title) {
        this.mContext = context;
        this.mId = id;
        this.mTitle = title;
    }

    BdMenuItem(Context context, int id, CharSequence title, int iconResId) {
        this.mContext = context;
        this.mId = id;
        this.mTitle = title;
        this.mIconResId = iconResId;
    }

    BdMenuItem(Context context, int id, CharSequence title, Drawable icon) {
        this.mContext = context;
        this.mId = id;
        this.mTitle = title;
        this.mIconDrawable = icon;
    }

    public BdMenu getMenu() {
        return this.mMenu;
    }

    public void setMenu(BdMenu menu) {
        this.mMenu = menu;
    }

    public int getItemId() {
        return this.mId;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean enabled) {
        this.mEnabled = enabled;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setChecked(boolean checked) {
        this.mChecked = checked;
    }

    public boolean showTip() {
        return this.mShowTip;
    }

    public void setShowTip(boolean showTip) {
        this.mShowTip = showTip;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public BdMenuItem setTitle(CharSequence title) {
        this.mTitle = title;
        return this;
    }

    public BdMenuItem setTitle(int titleResId) {
        this.mTitle = this.mContext.getResources().getText(titleResId, this.mTitle);
        return this;
    }

    public boolean isAutoDismiss() {
        return this.mIsAutoDismiss;
    }

    public void setIsAutoDismiss(boolean isAutoDismiss) {
        this.mIsAutoDismiss = isAutoDismiss;
    }

    public Drawable getIcon() {
        Drawable drawable = this.mIconDrawable;
        if (drawable != null) {
            return drawable;
        }
        if (this.mIconResId == 0) {
            return null;
        }
        Drawable icon = this.mContext.getResources().getDrawable(this.mIconResId);
        this.mIconResId = 0;
        this.mIconDrawable = icon;
        return icon;
    }

    public BdMenuItem setIcon(Drawable icon) {
        this.mIconResId = 0;
        this.mIconDrawable = icon;
        return this;
    }

    public BdMenuItem setIcon(int iconResId) {
        this.mIconDrawable = null;
        this.mIconResId = iconResId;
        return this;
    }

    public long getDismissDelayTime() {
        return this.mDismissDelayTime;
    }

    public void setDismissDelayTime(long delayTime) {
        this.mDismissDelayTime = delayTime;
    }

    public OnItemClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.mOnClickListener = listener;
    }
}
