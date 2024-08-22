package com.baidu.searchbox.feed.controller;

import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.searchbox.feed.base.DefaultViewContext;
import com.baidu.searchbox.feed.base.FeedSpecialTemplates;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.IFeedTemplate;
import com.baidu.searchbox.feed.core.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u0010\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"OPEN", "", "attach", "", "context", "Landroid/content/Context;", "detach", "fontSettingView", "Landroid/view/View;", "wrapperView", "view", "lib-feed-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedFontSettingFloat.kt */
public final class FeedFontSettingFloat {
    private static final boolean OPEN = false;

    public static final void attach(Context context) {
        View fontView;
        if (OPEN && (context instanceof Activity) && (fontView = fontSettingView(context)) != null) {
            ((FrameLayout) ((Activity) context).getWindow().getDecorView()).addView(wrapperView(context, fontView));
        }
    }

    private static final View fontSettingView(Context context) {
        View view2;
        IFeedTemplate tpl = FeedSpecialTemplates.SERVICE.getFeedFontSettingView();
        Intrinsics.checkNotNullExpressionValue(tpl, "SERVICE.feedFontSettingView");
        FeedTemplate tplView = (FeedTemplate) tpl.createItemView(new DefaultViewContext("XP").setContext(context));
        if (tplView == null || (view2 = tplView.getRootView()) == null) {
            return null;
        }
        View $this$makeGone$iv = view2.findViewById(R.id.font_tip);
        if ($this$makeGone$iv != null) {
            $this$makeGone$iv.setVisibility(8);
        }
        return view2;
    }

    private static final View wrapperView(Context context, View view2) {
        FrameLayout wrapper = new FrameLayout(context);
        wrapper.addView(view2);
        wrapper.setTag("AAAAA");
        wrapper.setBackgroundColor(-1);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-1, -2);
        lp.gravity = 80;
        lp.bottomMargin = (int) TypedValue.applyDimension(1, 65.0f, context.getResources().getDisplayMetrics());
        wrapper.setLayoutParams(lp);
        return wrapper;
    }

    public static final void detach(Context context) {
        if (OPEN && (context instanceof Activity)) {
            FrameLayout view2 = (FrameLayout) ((Activity) context).getWindow().getDecorView();
            int childCount = view2.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View child = view2.getChildAt(i2);
                if (Intrinsics.areEqual(child != null ? child.getTag() : null, (Object) "AAAAA")) {
                    view2.removeView(child);
                }
            }
        }
    }
}
