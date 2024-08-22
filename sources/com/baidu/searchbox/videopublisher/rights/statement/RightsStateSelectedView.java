package com.baidu.searchbox.videopublisher.rights.statement;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.videopublisher.R;
import com.baidu.searchbox.videopublisher.rights.OriginType;
import com.baidu.searchbox.videopublisher.utils.ViewExtensionsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\bJ\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\rJ\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/videopublisher/rights/statement/RightsStateSelectedView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkedType", "Lcom/baidu/searchbox/videopublisher/rights/OriginType;", "exclusiveView", "Lcom/baidu/searchbox/videopublisher/rights/statement/SelectedItemView;", "firstExclusiveView", "onSelectedListener", "Lcom/baidu/searchbox/videopublisher/rights/statement/RightsStateSelectedView$OnSelectedListener;", "splitViewBelow", "Landroid/view/View;", "splitViewUp", "getCheckedViewType", "setChecked", "", "type", "setListener", "setOnSelectedListener", "listener", "updateUI", "OnSelectedListener", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RightsStateSelectedView.kt */
public final class RightsStateSelectedView extends LinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private OriginType checkedType;
    private final SelectedItemView exclusiveView;
    private final SelectedItemView firstExclusiveView;
    private OnSelectedListener onSelectedListener;
    private final View splitViewBelow;
    private final View splitViewUp;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/videopublisher/rights/statement/RightsStateSelectedView$OnSelectedListener;", "", "onSelected", "", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RightsStateSelectedView.kt */
    public interface OnSelectedListener {
        void onSelected();
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RightsStateSelectedView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OriginType.values().length];
            iArr[OriginType.EXCLUSIVE.ordinal()] = 1;
            iArr[OriginType.FIRST_PUBLISH.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RightsStateSelectedView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RightsStateSelectedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        setOrientation(1);
        this.splitViewUp = ViewExtensionsKt.addSplitView$default(this, 0.0f, 1, (Object) null);
        SelectedItemView selectedItemView = new SelectedItemView(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        SelectedItemView $this$_init__u24lambda_u2d0 = selectedItemView;
        String string = $this$_init__u24lambda_u2d0.getResources().getString(R.string.video_publisher_right_original_type_exclusive);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…_original_type_exclusive)");
        String string2 = $this$_init__u24lambda_u2d0.getResources().getString(R.string.video_publisher_right_original_type_exclusive_content);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…l_type_exclusive_content)");
        $this$_init__u24lambda_u2d0.initView(string, string2, false);
        this.exclusiveView = selectedItemView;
        addView(selectedItemView);
        this.splitViewBelow = ViewExtensionsKt.addSplitView$default(this, 0.0f, 1, (Object) null);
        SelectedItemView selectedItemView2 = new SelectedItemView(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        SelectedItemView $this$_init__u24lambda_u2d1 = selectedItemView2;
        String string3 = $this$_init__u24lambda_u2d1.getResources().getString(R.string.video_publisher_right_original_type_first);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…ight_original_type_first)");
        String string4 = $this$_init__u24lambda_u2d1.getResources().getString(R.string.video_publisher_right_original_type_first_content);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…ginal_type_first_content)");
        $this$_init__u24lambda_u2d1.initView(string3, string4, false);
        this.firstExclusiveView = selectedItemView2;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
        params.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.video_publisher_dimens_13dp);
        addView(selectedItemView2, params);
        setListener();
        updateUI();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RightsStateSelectedView(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    private final void updateUI() {
        this.splitViewUp.setBackgroundColor(ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.GC34));
        this.splitViewBelow.setBackgroundColor(ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.GC34));
    }

    private final void setListener() {
        this.exclusiveView.setOnCheckedChangeListener(new RightsStateSelectedView$$ExternalSyntheticLambda0(this));
        this.firstExclusiveView.setOnCheckedChangeListener(new RightsStateSelectedView$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setListener$lambda-2  reason: not valid java name */
    public static final void m7292setListener$lambda2(RightsStateSelectedView this$0, CompoundButton compoundButton, boolean isChecked) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (isChecked) {
            this$0.checkedType = OriginType.EXCLUSIVE;
            this$0.exclusiveView.setChecked(true);
            this$0.firstExclusiveView.setChecked(false);
            OnSelectedListener onSelectedListener2 = this$0.onSelectedListener;
            if (onSelectedListener2 != null) {
                onSelectedListener2.onSelected();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setListener$lambda-3  reason: not valid java name */
    public static final void m7293setListener$lambda3(RightsStateSelectedView this$0, CompoundButton compoundButton, boolean isChecked) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (isChecked) {
            this$0.checkedType = OriginType.FIRST_PUBLISH;
            this$0.exclusiveView.setChecked(false);
            this$0.firstExclusiveView.setChecked(true);
            OnSelectedListener onSelectedListener2 = this$0.onSelectedListener;
            if (onSelectedListener2 != null) {
                onSelectedListener2.onSelected();
            }
        }
    }

    public final void setOnSelectedListener(OnSelectedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onSelectedListener = listener;
    }

    public final void setChecked(OriginType type) {
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                this.exclusiveView.setChecked(true);
                return;
            case 2:
                this.firstExclusiveView.setChecked(true);
                return;
            default:
                return;
        }
    }

    public final OriginType getCheckedViewType() {
        return this.checkedType;
    }
}
