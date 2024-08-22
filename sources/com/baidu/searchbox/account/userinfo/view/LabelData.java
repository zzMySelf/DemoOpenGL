package com.baidu.searchbox.account.userinfo.view;

import android.view.View;
import com.baidu.android.common.ui.style.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010$\u001a\u00020%R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0016\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u001e\u0010!\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u001a¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/view/LabelData;", "", "text", "", "leftIconRes", "", "(Ljava/lang/String;I)V", "clickListener", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "forceCapsule", "", "getForceCapsule", "()Z", "setForceCapsule", "(Z)V", "<set-?>", "isCapsule", "getLeftIconRes", "()I", "plainLeftIconRes", "getPlainLeftIconRes", "setPlainLeftIconRes", "(I)V", "plainText", "getPlainText", "()Ljava/lang/String;", "setPlainText", "(Ljava/lang/String;)V", "getText", "textColor", "getTextColor", "setTextColor", "tryDisableCapsule", "", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserInfoDescView.kt */
final class LabelData {
    private View.OnClickListener clickListener;
    private boolean forceCapsule;
    private boolean isCapsule;
    private final int leftIconRes;
    private int plainLeftIconRes;
    private String plainText;
    private final String text;
    private int textColor;

    public LabelData(String text2, int leftIconRes2) {
        Intrinsics.checkNotNullParameter(text2, "text");
        this.text = text2;
        this.leftIconRes = leftIconRes2;
        this.isCapsule = true;
        this.textColor = R.color.GC4;
        this.plainText = text2;
        this.plainLeftIconRes = leftIconRes2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LabelData(String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 0 : i2);
    }

    public final String getText() {
        return this.text;
    }

    public final int getLeftIconRes() {
        return this.leftIconRes;
    }

    public final boolean isCapsule() {
        return this.isCapsule;
    }

    public final boolean getForceCapsule() {
        return this.forceCapsule;
    }

    public final void setForceCapsule(boolean z) {
        this.forceCapsule = z;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(int i2) {
        this.textColor = i2;
    }

    public final String getPlainText() {
        return this.plainText;
    }

    public final void setPlainText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.plainText = str;
    }

    public final int getPlainLeftIconRes() {
        return this.plainLeftIconRes;
    }

    public final void setPlainLeftIconRes(int i2) {
        this.plainLeftIconRes = i2;
    }

    public final View.OnClickListener getClickListener() {
        return this.clickListener;
    }

    public final void setClickListener(View.OnClickListener onClickListener) {
        this.clickListener = onClickListener;
    }

    public final void tryDisableCapsule() {
        if (!this.forceCapsule) {
            this.isCapsule = false;
        }
    }
}
