package com.baidu.searchbox.userassetsaggr.container.decoration.divider;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.userassetsaggr.container.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/userassetsaggr/container/decoration/divider/LoadEndPerformer;", "Lcom/baidu/searchbox/userassetsaggr/container/decoration/divider/IDividerPerformer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "hasMeasured", "", "mTextHeight", "", "mTextView", "Landroid/widget/TextView;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "param", "Lcom/baidu/searchbox/userassetsaggr/container/decoration/divider/DividerParam;", "measureTextView", "lib-favorHis-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoadEndPerformer.kt */
public final class LoadEndPerformer implements IDividerPerformer {
    private boolean hasMeasured;
    private int mTextHeight;
    private TextView mTextView;

    public LoadEndPerformer(Context context) {
        if (context != null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.user_assets_load_end_layout, (ViewGroup) null, false);
            if (inflate != null) {
                this.mTextView = (TextView) inflate;
                this.mTextHeight = (int) FontSizeHelper.getScaledSizeRes(0, R.dimen.user_assets_load_end_height);
                TextView textView = this.mTextView;
                if (textView != null) {
                    textView.setLayoutParams(new ViewGroup.LayoutParams(-1, this.mTextHeight));
                }
                TextView textView2 = this.mTextView;
                if (textView2 != null) {
                    textView2.setTextSize(0, FontSizeHelper.getScaledSizeRes(0, R.dimen.user_assets_load_end_font_size));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public void draw(Canvas canvas, DividerParam param) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (param != null) {
            if (!this.hasMeasured) {
                measureTextView(param);
            }
            int count = canvas.save();
            canvas.translate(0.0f, (float) param.getTop$lib_favorHis_base_release());
            TextView $this$draw_u24lambda_u2d0 = this.mTextView;
            if ($this$draw_u24lambda_u2d0 != null) {
                $this$draw_u24lambda_u2d0.setTextColor($this$draw_u24lambda_u2d0.getResources().getColor(R.color.user_assets_load_end_text_color));
                $this$draw_u24lambda_u2d0.draw(canvas);
            }
            canvas.restoreToCount(count);
        }
    }

    private final void measureTextView(DividerParam param) {
        if (param != null) {
            this.hasMeasured = true;
            int widthSpec = View.MeasureSpec.makeMeasureSpec(param.getRight$lib_favorHis_base_release(), 1073741824);
            int heightSpec = View.MeasureSpec.makeMeasureSpec(this.mTextHeight, 1073741824);
            TextView textView = this.mTextView;
            if (textView != null) {
                textView.measure(widthSpec, heightSpec);
                textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
            }
        }
    }
}
