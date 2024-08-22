package com.baidu.searchbox.feed.template.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.util.media.PreloadUIResUtil;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeImageViewExtKt;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.abtest.FeedAbtestManager;
import com.baidu.searchbox.feed.controller.FeedPolicy;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.feed.tab.utils.FeedOrderStyleUtils;
import com.baidu.searchbox.feed.template.FeedTemplateUtil;
import com.baidu.searchbox.feed.util.FeedUtil;

public class FeedOrderSenseUtil {
    public static final float DYNAMIC_MORE_IMAGES_RATIO = 1.5f;
    public static final float DYNAMIC_ONE_IMAGE_RATIO = 1.7777778f;
    private static final String TYPE_ONE = "1";
    private static final String TYPE_THREE = "3";
    private static final String TYPE_TWO = "2";
    private static Integer mEdgeBlankWidth = null;
    private static Boolean mIsPad = null;

    public static boolean isSenseOfOrderOneMode(FeedBaseModel feedModel) {
        if (feedModel == null) {
            return false;
        }
        return isSenseOfOrderOneMode(feedModel.runtimeStatus.channelId);
    }

    public static boolean isSenseOfOrderOneMode(String tabId) {
        return TextUtils.equals(tabId, "1") && (isType(Type.ONE) || isType(Type.THREE));
    }

    public static boolean isSenseOfOrderTwoMode(FeedBaseModel feedModel) {
        return isChannelIdMatch(feedModel) && (isType(Type.TWO) || isType(Type.THREE));
    }

    public static void setTextOrderStyle(TextView textView) {
        if (textView != null && textView.getLayoutParams() != null && (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            textView.setBackground((Drawable) null);
            textView.setTextSize(0, FontSizeHelper.getScaledSize(0, (float) textView.getResources().getDimensionPixelSize(R.dimen.F_T_X056)));
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getResources().getDimensionPixelSize(R.dimen.F_M_W_X010), textView.getResources().getDimensionPixelSize(R.dimen.F_M_H_X012));
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            params.rightMargin = 0;
            params.bottomMargin = 0;
            textView.setLayoutParams(params);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setShadowLayer(4.0f, 0.0f, 0.0f, com.baidu.searchbox.feed.core.R.color.feed_mini_video_user_bg_color);
        }
    }

    public static void setViewMargin(View view2, int left, int top, int right, int bottom) {
        if (view2 != null && view2.getLayoutParams() != null && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            params.setMargins(left, top, right, bottom);
            view2.setLayoutParams(params);
        }
    }

    public static void setViewOrderStyle(View view2) {
        if (view2 != null && view2.getLayoutParams() != null && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            view2.setBackground((Drawable) null);
            view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), 0, 0);
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            params.rightMargin = 0;
            params.bottomMargin = 0;
            view2.setLayoutParams(params);
        }
    }

    public static int getDividerWidth(FeedBaseModel feedModel) {
        if (isSenseOfOrderOneMode(feedModel)) {
            return FeedRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.F_M_W_X504);
        }
        return FeedRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.F_M_W_X024);
    }

    public static void setDislikePicture(ImageView view2, int model, FeedBaseModel baseModel) {
        int res;
        if (view2 != null && view2.getContext() != null && baseModel != null && view2.getLayoutParams() != null) {
            if (isSenseOfOrderOneMode(baseModel)) {
                res = com.baidu.searchbox.feed.core.R.drawable.feed_unlike_btn_icon_order_cu;
                int padding = FeedRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.F_M_H_X070);
                view2.setPadding(padding, 0, padding, 0);
            } else {
                res = com.baidu.searchbox.feed.core.R.drawable.feed_unlike_btn_icon_cu;
                view2.setPadding(0, 0, 0, 0);
            }
            Drawable drawable = PreloadUIResUtil.getPreloadedDrawable(res);
            if (drawable == null) {
                drawable = view2.getContext().getResources().getDrawable(res);
            }
            if (FeedAbtestManager.isFluencyOptOpen()) {
                int size = (int) FontSizeHelper.getScaledSize(0, (float) view2.getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_15dp));
                ViewGroup.LayoutParams params = view2.getLayoutParams();
                params.width = size;
                params.height = size;
                if (drawable != null) {
                    view2.setImageDrawable(drawable);
                }
                view2.setLayoutParams(params);
                return;
            }
            FontSizeImageViewExtKt.setScaledImageDrawable(view2, 0, drawable, model);
        }
    }

    private static boolean isChannelIdMatch(FeedBaseModel feedModel) {
        if (feedModel == null) {
            return false;
        }
        return TextUtils.equals(feedModel.runtimeStatus.channelId, "1");
    }

    public static boolean isType(Type type) {
        String orderType = FeedOrderStyleUtils.getOrderType();
        if (FeedUtil.isTabletBasic()) {
            orderType = Type.THREE.getValue();
        }
        return TextUtils.equals(orderType, type.getValue());
    }

    public static boolean isOderSenseDynamicExperimentOne(FeedBaseModel feedModel) {
        if (feedModel != null && isChannelIdMatch(feedModel) && TextUtils.equals(FeedPolicy.getOrderSenseSwitch(), "1")) {
            return true;
        }
        return false;
    }

    public static boolean isOderSenseDynamicExperimentTwo(FeedBaseModel feedModel) {
        if (feedModel != null && isChannelIdMatch(feedModel) && TextUtils.equals(FeedPolicy.getOrderSenseSwitch(), "2")) {
            return true;
        }
        return false;
    }

    public static int getEdgeBlankWidthOld(Context context) {
        int width = FeedRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.F_M_W_X001);
        if (isType(Type.ONE) || isType(Type.THREE)) {
            width = FeedRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.F_M_W_X505);
        }
        if (FeedUtil.isPadHomeBasic(context)) {
            return FeedTemplateUtil.getPadEdgeBlankWidth(context);
        }
        return width;
    }

    public static int getEdgeBlankWidthFluency(Context context) {
        if (mIsPad == null) {
            mIsPad = Boolean.valueOf(FeedUtil.isPadHomeBasic(context));
        }
        if (mIsPad.booleanValue()) {
            return FeedTemplateUtil.getPadEdgeBlankWidth(context);
        }
        if (mEdgeBlankWidth == null) {
            mEdgeBlankWidth = Integer.valueOf(FeedRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.F_M_W_X001));
            if (isType(Type.ONE) || isType(Type.THREE)) {
                mEdgeBlankWidth = Integer.valueOf(FeedRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.F_M_W_X505));
            }
        }
        return mEdgeBlankWidth.intValue();
    }

    public enum Type {
        ONE("1"),
        TWO("2"),
        THREE("3");
        
        private final String value;

        private Type(String value2) {
            this.value = value2;
        }

        public String getValue() {
            return this.value;
        }
    }
}
