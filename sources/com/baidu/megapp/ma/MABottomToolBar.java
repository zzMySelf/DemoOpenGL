package com.baidu.megapp.ma;

public class MABottomToolBar {
    private CommonMenuType mCommonMenuType = CommonMenuType.MENU_STYLE_NO;
    private CommonToolBarType mCommonToolBarType = CommonToolBarType.TOOL_BAR_STYLE_NO;
    private OnCommonToolBarClickListener mOnCommonToolBarClickListener = null;
    private OnCommonToolBarItemClickListener mOnCommonToolBarItemClickListener = null;
    private OnCommonToolMenuClickListener mOnCommonToolMenuClickListener = null;

    @Deprecated
    public enum CommonMenuType {
        MENU_STYLE_NO,
        MENU_STYLE_NS_NA,
        MENU_STYLE_NS_H5,
        MENU_STYLE_AD_IMMERSIVE_LANDING_PAGE
    }

    public enum CommonToolBarType {
        TOOL_BAR_STYLE_NO,
        TOOL_BAR_STYLE_NS,
        TOOL_BAR_STYLE_NEWS,
        TOOL_BAR_STYLE_AD_IMMERSIVE_LANDING_PAGE
    }

    @Deprecated
    public interface OnCommonToolBarClickListener {
        void onBackClick();
    }

    public interface OnCommonToolBarItemClickListener {
        public static final int TOOL_ITEM_BACK = 1;
        public static final int TOOL_ITEM_SHARE = 2;

        boolean onItemClick(int i2);
    }

    @Deprecated
    public interface OnCommonToolMenuClickListener {
        void onRefreshClick();

        void onShareClick();
    }

    public void setToolBarStyle(CommonToolBarType toolBarStyle) {
        this.mCommonToolBarType = toolBarStyle;
    }

    public CommonToolBarType getToolBarStyle() {
        return this.mCommonToolBarType;
    }

    public void setOnToolBarItemClickListener(OnCommonToolBarItemClickListener listener) {
        this.mOnCommonToolBarItemClickListener = listener;
    }

    public OnCommonToolBarItemClickListener getOnToolBarItemClickListener() {
        return this.mOnCommonToolBarItemClickListener;
    }

    @Deprecated
    public void setToolBarMenuStyle(CommonMenuType toolBarMenuStyle) {
        this.mCommonMenuType = toolBarMenuStyle;
    }

    @Deprecated
    public CommonMenuType getToolBarMenuStyle() {
        return this.mCommonMenuType;
    }

    @Deprecated
    public void setOnToolBarClickListener(OnCommonToolBarClickListener listener) {
        this.mOnCommonToolBarClickListener = listener;
    }

    @Deprecated
    public OnCommonToolBarClickListener getOnToolBarClickListener() {
        return this.mOnCommonToolBarClickListener;
    }

    @Deprecated
    public void setOnCommonToolMenuClickListener(OnCommonToolMenuClickListener listener) {
        this.mOnCommonToolMenuClickListener = listener;
    }

    @Deprecated
    public OnCommonToolMenuClickListener getOnCommonToolMenuClickListener() {
        return this.mOnCommonToolMenuClickListener;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("mCommonToolBarType = " + this.mCommonToolBarType + "\n");
        builder.append("mCommonMenuType = " + this.mCommonMenuType + "\n");
        builder.append("mOnCommonToolBarClickListener = " + this.mOnCommonToolBarClickListener + "\n");
        builder.append("mOnCommonToolMenuClickListener = " + this.mOnCommonToolMenuClickListener);
        return builder.toString();
    }
}
