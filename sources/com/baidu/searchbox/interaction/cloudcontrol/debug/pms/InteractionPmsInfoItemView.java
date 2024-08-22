package com.baidu.searchbox.interaction.cloudcontrol.debug.pms;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.interaction.cloudcontrol.R;
import com.baidu.searchbox.interaction.cloudcontrol.pms.InteractionPmsUtils;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.init.PmsManager;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u0019\u001a\u00020\u0018H\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/interaction/cloudcontrol/debug/pms/InteractionPmsInfoItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "packageName", "", "size", "Landroid/widget/TextView;", "getSize", "()Landroid/widget/TextView;", "size$delegate", "Lkotlin/Lazy;", "title", "getTitle", "title$delegate", "version", "getVersion", "version$delegate", "onBind", "", "showError", "lib-interaction-cloudcontrol_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InteractionPmsInfoDebugActivity.kt */
public final class InteractionPmsInfoItemView extends LinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private String packageName;
    private final Lazy size$delegate;
    private final Lazy title$delegate;
    private final Lazy version$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InteractionPmsInfoItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InteractionPmsInfoItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
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
    public InteractionPmsInfoItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.title$delegate = LazyKt.lazy(new InteractionPmsInfoItemView$title$2(this));
        this.version$delegate = LazyKt.lazy(new InteractionPmsInfoItemView$version$2(this));
        this.size$delegate = LazyKt.lazy(new InteractionPmsInfoItemView$size$2(this));
        this.packageName = "";
        LayoutInflater.from(context).inflate(R.layout.interaction_pms_info_item_view, this, true);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        setOrientation(1);
        setOnLongClickListener(new InteractionPmsInfoItemView$$ExternalSyntheticLambda1(context, this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InteractionPmsInfoItemView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final TextView getTitle() {
        Object value = this.title$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-title>(...)");
        return (TextView) value;
    }

    private final TextView getVersion() {
        Object value = this.version$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-version>(...)");
        return (TextView) value;
    }

    private final TextView getSize() {
        Object value = this.size$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-size>(...)");
        return (TextView) value;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final boolean m20421_init_$lambda1(Context $context, InteractionPmsInfoItemView this$0, View it) {
        Intrinsics.checkNotNullParameter($context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new BoxAlertDialog.Builder($context).setTitle(this$0.getTitle().getText()).setMessage("是否删除包信息，触发下次冷启重新拉包").setPositiveButton((CharSequence) "确定", (DialogInterface.OnClickListener) new InteractionPmsInfoItemView$$ExternalSyntheticLambda0(this$0)).setNegativeButton((CharSequence) AccountConstants.PROFESSION_APPROVE_DIALOG_CANCEL_TITLE_DEFAULT, (DialogInterface.OnClickListener) null).create().show();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-1$lambda-0  reason: not valid java name */
    public static final void m20422lambda1$lambda0(InteractionPmsInfoItemView this$0, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PmsManager.getInstance().deletePackageInfo("240", this$0.packageName);
        this$0.showError();
    }

    public final void onBind(String packageName2) {
        Unit unit;
        Intrinsics.checkNotNullParameter(packageName2, "packageName");
        this.packageName = packageName2;
        TextView title = getTitle();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getContext().getString(R.string.interaction_pms_info_item_title);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…tion_pms_info_item_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{packageName2}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        title.setText(format);
        PackageInfo it = InteractionPmsUtils.getCurrentPackageInfo(packageName2);
        if (it != null) {
            TextView $this$onBind_u24lambda_u2d4_u24lambda_u2d2 = getVersion();
            TextView version = getVersion();
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = $this$onBind_u24lambda_u2d4_u24lambda_u2d2.getContext().getString(R.string.interaction_pms_info_item_version);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…on_pms_info_item_version)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{String.valueOf(it.version)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            version.setText(format2);
            $this$onBind_u24lambda_u2d4_u24lambda_u2d2.setTextColor(-16777216);
            TextView $this$onBind_u24lambda_u2d4_u24lambda_u2d3 = getSize();
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String string3 = $this$onBind_u24lambda_u2d4_u24lambda_u2d3.getContext().getString(R.string.interaction_pms_info_item_size);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…ction_pms_info_item_size)");
            String format3 = String.format(string3, Arrays.copyOf(new Object[]{it.size}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            $this$onBind_u24lambda_u2d4_u24lambda_u2d3.setText(format3);
            $this$onBind_u24lambda_u2d4_u24lambda_u2d3.setVisibility(0);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            showError();
        }
    }

    private final void showError() {
        TextView $this$showError_u24lambda_u2d6 = getVersion();
        getVersion().setText($this$showError_u24lambda_u2d6.getContext().getString(R.string.interaction_pms_info_item_fail));
        $this$showError_u24lambda_u2d6.setTextColor(SupportMenu.CATEGORY_MASK);
        getSize().setVisibility(8);
    }
}
