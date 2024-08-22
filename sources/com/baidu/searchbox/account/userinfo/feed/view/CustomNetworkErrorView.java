package com.baidu.searchbox.account.userinfo.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.baidu.android.common.ui.style.R;
import com.baidu.searchbox.ng.errorview.view.NetworkErrorView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0016R&\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/feed/view/CustomNetworkErrorView;", "Lcom/baidu/searchbox/ng/errorview/view/NetworkErrorView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "customBgColorRes", "getCustomBgColorRes", "()I", "setCustomBgColorRes", "(I)V", "updateUI", "", "mode", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomNetworkErrorView.kt */
public final class CustomNetworkErrorView extends NetworkErrorView {
    public Map<Integer, View> _$_findViewCache;
    private int customBgColorRes;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomNetworkErrorView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomNetworkErrorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomNetworkErrorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.customBgColorRes = R.color.GC9;
    }

    public final int getCustomBgColorRes() {
        return this.customBgColorRes;
    }

    public final void setCustomBgColorRes(int value) {
        this.customBgColorRes = value;
        if (value > 0) {
            try {
                Result.Companion companion = Result.Companion;
                CustomNetworkErrorView $this$_set_customBgColorRes__u24lambda_u2d0 = this;
                $this$_set_customBgColorRes__u24lambda_u2d0.setBackgroundColor(ContextCompat.getColor($this$_set_customBgColorRes__u24lambda_u2d0.getContext(), value));
                Result.m8971constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    public void updateUI(int mode) {
        super.updateUI(mode);
        setBackgroundColor(ContextCompat.getColor(getContext(), this.customBgColorRes));
    }
}
