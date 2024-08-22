package com.baidu.searchbox.iminteract.imrichtext;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import com.baidu.validation.result.ValidationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/iminteract/imrichtext/PressedClickableSpan;", "Landroid/text/style/ClickableSpan;", "mNormalColor", "", "mPressedColor", "isCanPress", "", "(IIZ)V", "isPressed", "()Z", "setPressed", "(Z)V", "updateDrawState", "", "ds", "Landroid/text/TextPaint;", "lib-message_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PressedClickableSpan.kt */
public abstract class PressedClickableSpan extends ClickableSpan {
    private final boolean isCanPress;
    private boolean isPressed;
    private final int mNormalColor;
    private final int mPressedColor;

    public PressedClickableSpan(int mNormalColor2, int mPressedColor2, boolean isCanPress2) {
        this.mNormalColor = mNormalColor2;
        this.mPressedColor = mPressedColor2;
        this.isCanPress = isCanPress2;
    }

    public final boolean isPressed() {
        return this.isPressed;
    }

    public final void setPressed(boolean z) {
        this.isPressed = z;
    }

    public void updateDrawState(TextPaint ds) {
        boolean z;
        Intrinsics.checkNotNullParameter(ds, ValidationResult.KEY_DATA_DS);
        if (!this.isCanPress || !(z = this.isPressed)) {
            ds.setColor(this.mNormalColor);
        } else if (z) {
            ds.setColor(this.mPressedColor);
        }
    }
}
