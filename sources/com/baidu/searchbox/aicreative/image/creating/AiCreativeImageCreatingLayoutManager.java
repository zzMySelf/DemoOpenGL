package com.baidu.searchbox.aicreative.image.creating;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.searchbox.dynamicpublisher.R;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.api.AbsLayoutManager;
import com.baidu.searchbox.ugc.utils.DisplayExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/aicreative/image/creating/AiCreativeImageCreatingLayoutManager;", "Lcom/baidu/searchbox/feed/detail/arch/api/AbsLayoutManager;", "Landroid/view/ViewGroup;", "()V", "addView", "", "view", "Landroid/view/View;", "type", "", "inflate", "initManager", "componentManager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "context", "Landroid/content/Context;", "lib-publisher-dynamic_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiCreativeImageCreatingLayoutManager.kt */
public final class AiCreativeImageCreatingLayoutManager extends AbsLayoutManager<ViewGroup> {
    public void initManager(ComponentArchManager componentManager, Context context) {
        Intrinsics.checkNotNullParameter(componentManager, "componentManager");
        Intrinsics.checkNotNullParameter(context, "context");
        super.initManager(componentManager, context);
        ViewGroup it = null;
        View view2 = View.inflate(context, R.layout.activity_ai_creative_image_creating, (ViewGroup) null);
        view2.setBackgroundResource(R.drawable.dynamic_publisher_ai_creative_creating_bg);
        if (view2 instanceof ViewGroup) {
            it = view2;
        }
        if (it != null) {
            setContainer(it);
        }
    }

    public void inflate() {
        inflateComponentView("dynamic_publisher_topbar_cmp", R.id.dynamic_publisher_topbar_cmp_id);
        inflateComponentView("ai_creative_image_creating_image", R.id.dynamic_publisher_ai_creative_image_creating_image_id);
        inflateComponentView("ai_creative_image_bottom_bar", R.id.dynamic_publisher_ai_creative_image_creating_bottom_bar_id);
        inflateComponentView("ai_creative_image_creating_progress", R.id.dynamic_publisher_ai_creative_image_creating_progress_id);
    }

    public void addView(View view2, int type) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.addView(view2, type);
        if (type == R.id.dynamic_publisher_topbar_cmp_id) {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, (int) DisplayExtKt.getDp(38));
            ConstraintLayout.LayoutParams $this$addView_u24lambda_u2d2 = layoutParams;
            $this$addView_u24lambda_u2d2.startToStart = 0;
            $this$addView_u24lambda_u2d2.endToEnd = 0;
            $this$addView_u24lambda_u2d2.topToTop = 0;
            view2.setLayoutParams(layoutParams);
            getContainer().addView(view2);
        } else if (type == R.id.dynamic_publisher_ai_creative_image_creating_image_id) {
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-1, 0);
            ConstraintLayout.LayoutParams $this$addView_u24lambda_u2d3 = layoutParams2;
            $this$addView_u24lambda_u2d3.dimensionRatio = "332:443";
            $this$addView_u24lambda_u2d3.startToStart = 0;
            $this$addView_u24lambda_u2d3.endToEnd = 0;
            $this$addView_u24lambda_u2d3.topToBottom = R.id.dynamic_publisher_topbar_cmp_id;
            $this$addView_u24lambda_u2d3.leftMargin = (int) DisplayExtKt.getDp(13);
            $this$addView_u24lambda_u2d3.rightMargin = (int) DisplayExtKt.getDp(13);
            $this$addView_u24lambda_u2d3.topMargin = (int) DisplayExtKt.getDp(13);
            view2.setLayoutParams(layoutParams2);
            getContainer().addView(view2);
        } else if (type == R.id.dynamic_publisher_ai_creative_image_creating_progress_id) {
            ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams((int) DisplayExtKt.getDp(140), (int) DisplayExtKt.getDp(104));
            ConstraintLayout.LayoutParams $this$addView_u24lambda_u2d4 = layoutParams3;
            $this$addView_u24lambda_u2d4.startToStart = R.id.dynamic_publisher_ai_creative_image_creating_image_id;
            $this$addView_u24lambda_u2d4.endToEnd = R.id.dynamic_publisher_ai_creative_image_creating_image_id;
            $this$addView_u24lambda_u2d4.topToTop = R.id.dynamic_publisher_ai_creative_image_creating_image_id;
            $this$addView_u24lambda_u2d4.bottomToBottom = R.id.dynamic_publisher_ai_creative_image_creating_image_id;
            view2.setLayoutParams(layoutParams3);
            view2.setVisibility(8);
            getContainer().addView(view2);
        } else if (type == R.id.dynamic_publisher_ai_creative_image_creating_bottom_bar_id) {
            ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-1, -2);
            layoutParams4.bottomToBottom = 0;
            view2.setLayoutParams(layoutParams4);
            getContainer().addView(view2);
        }
    }
}
