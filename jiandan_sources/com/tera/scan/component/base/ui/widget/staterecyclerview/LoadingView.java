package com.tera.scan.component.base.ui.widget.staterecyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.tera.scan.app.R$styleable;
import fe.mmm.qw.th.qw.rg.fe.de.qw;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tera/scan/component/base/ui/widget/staterecyclerview/LoadingView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "text", "Landroid/widget/TextView;", "showWith", "", "condition", "", "view", "Landroid/view/View;", "component-base_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoadingView extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    public final TextView text;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LoadingView(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void showWith(boolean z, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        qw.ad(this, !z);
        qw.ad(view, z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.state_recycle_view_loading, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LoadingView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr… R.styleable.LoadingView)");
        CharSequence text2 = obtainStyledAttributes.getText(1);
        obtainStyledAttributes.recycle();
        View findViewById = findViewById(R.id.loading_info_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.loading_info_text)");
        TextView textView = (TextView) findViewById;
        this.text = textView;
        if (text2 != null) {
            textView.setText(text2);
        }
    }
}
