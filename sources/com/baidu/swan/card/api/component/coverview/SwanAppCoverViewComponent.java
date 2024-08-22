package com.baidu.swan.card.api.component.coverview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.swan.card.api.component.SwanAppComponentContainerView;
import com.baidu.swan.card.api.component.diff.DiffResult;
import com.baidu.swan.card.api.component.text.SwanAppTextViewComponent;

public final class SwanAppCoverViewComponent extends SwanAppTextViewComponent<TextView, SwanAppCoverViewComponentModel> {
    private static final String TAG = "Component-CoverView";
    private SwanAppComponentContainerView mContainer;
    private TextView mTextView;

    public SwanAppCoverViewComponent(Context context, SwanAppCoverViewComponentModel model) {
        super(context, model);
        addFlags(4);
        this.mContainer = new SwanAppComponentContainerView(context);
        this.mTextView = new TextView(context);
    }

    /* access modifiers changed from: protected */
    public TextView inflateView(Context context) {
        return this.mTextView;
    }

    /* access modifiers changed from: protected */
    public DiffResult diff(SwanAppCoverViewComponentModel oldModel, SwanAppCoverViewComponentModel newModel) {
        DiffResult diffResult = super.diff(oldModel, newModel);
        if (!TextUtils.equals(oldModel.overflowY, newModel.overflowY) && (TextUtils.equals(oldModel.overflowY, "scroll") || TextUtils.equals(newModel.overflowY, "scroll"))) {
            diffResult.markDiff(7);
        }
        if (!TextUtils.equals(oldModel.overflowY, newModel.overflowY) || (TextUtils.equals(newModel.overflowY, "scroll") && oldModel.scrollTop != newModel.scrollTop)) {
            diffResult.markDiff(8);
        }
        if (!TextUtils.equals(oldModel.overflowX, newModel.overflowX) && (TextUtils.equals(oldModel.overflowX, "scroll") || TextUtils.equals(newModel.overflowX, "scroll"))) {
            diffResult.markDiff(16);
        }
        return diffResult;
    }

    /* access modifiers changed from: protected */
    public void renderBackground(TextView view2, SwanAppCoverViewComponentModel model) {
        if (DEBUG) {
            Log.d(TAG, "renderBackground");
        }
        if (model.styleData != null) {
            SwanAppComponentContainerView containerView = getContainerView();
            if (containerView != null) {
                containerView.setModel(model);
            }
            ViewParent viewParent = view2.getParent();
            if (viewParent instanceof View) {
                GradientDrawable gd = new GradientDrawable();
                gd.setColor(model.backgroundColor);
                gd.setCornerRadius((float) model.borderRadius);
                gd.setStroke(model.borderWidth, model.borderColor);
                ((View) viewParent).setBackground(gd);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void renderAlpha(View view2, SwanAppCoverViewComponentModel model) {
        if (DEBUG) {
            Log.d(TAG, "renderAlpha");
        }
        if (model.styleData != null) {
            ViewParent viewParent = view2.getParent();
            if (viewParent instanceof View) {
                super.renderAlpha((View) viewParent, model);
            }
        }
    }

    /* access modifiers changed from: protected */
    public SwanAppComponentContainerView inflateContainerView(Context context) {
        return this.mContainer;
    }
}
