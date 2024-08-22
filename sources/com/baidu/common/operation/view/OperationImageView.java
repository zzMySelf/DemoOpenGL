package com.baidu.common.operation.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.common.operation.CommonOperationModel;
import com.baidu.common.operation.CommonOperationUtilsKt;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;

public class OperationImageView extends AppCompatImageView {
    /* access modifiers changed from: private */
    public int mNightColorColorRes = -1;

    public interface UpdateDataCallback {
        void onResult(int i2);
    }

    public OperationImageView(Context context) {
        super(context);
    }

    public OperationImageView(Context context, AttributeSet attr) {
        super(context, attr);
    }

    public OperationImageView(Context context, CommonOperationModel.UIModel model) {
        super(context);
        updateData(model);
    }

    public void setNightColorColorRes(int nightColorColorRes) {
        this.mNightColorColorRes = nightColorColorRes;
    }

    public void updateData(CommonOperationModel.UIModel model) {
        setImageDrawable(CommonOperationUtilsKt.getDrawable(model, this.mNightColorColorRes));
        setVisibility(getDrawable() != null ? 0 : 8);
    }

    public void updateDataAsync(final CommonOperationModel.UIModel model, final UpdateDataCallback callback) {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                final Drawable drawable = CommonOperationUtilsKt.getDrawable(model, OperationImageView.this.mNightColorColorRes);
                UiThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            OperationImageView.this.setImageDrawable(drawable);
                            int visibility = OperationImageView.this.getDrawable() != null ? 0 : 8;
                            OperationImageView.this.setVisibility(visibility);
                            if (callback != null) {
                                callback.onResult(visibility);
                            }
                        } catch (Exception e2) {
                            if (AppConfig.isDebug()) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            }
        }, "updateDataAsync", 0);
    }
}
