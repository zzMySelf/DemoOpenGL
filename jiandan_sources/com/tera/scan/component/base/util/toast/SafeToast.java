package com.tera.scan.component.base.util.toast;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.widget.Toast;
import fe.mmm.qw.th.qw.th.when.qw;
import java.lang.reflect.Field;

public final class SafeToast extends Toast {
    public final Toast toast;

    public SafeToast(Context context, Toast toast2) {
        super(context);
        this.toast = toast2;
    }

    public static SafeToast makeText(Context context, CharSequence charSequence, int i2) {
        Toast makeText = Toast.makeText(context, charSequence, i2);
        setContextCompat(makeText.getView(), new qw(context, makeText));
        return new SafeToast(context, makeText);
    }

    public static void setContextCompat(View view, Context context) {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                declaredField.setAccessible(true);
                declaredField.set(view, context);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public Toast getBaseToast() {
        return this.toast;
    }

    public int getDuration() {
        return this.toast.getDuration();
    }

    public int getGravity() {
        return this.toast.getGravity();
    }

    public float getHorizontalMargin() {
        return this.toast.getHorizontalMargin();
    }

    public float getVerticalMargin() {
        return this.toast.getVerticalMargin();
    }

    public View getView() {
        return this.toast.getView();
    }

    public int getXOffset() {
        return this.toast.getXOffset();
    }

    public int getYOffset() {
        return this.toast.getYOffset();
    }

    public SafeToast setBadTokenListener(BadTokenListener badTokenListener) {
        Context context = getView().getContext();
        if (context instanceof qw) {
            ((qw) context).de(badTokenListener);
        }
        return this;
    }

    public void setDuration(int i2) {
        this.toast.setDuration(i2);
    }

    public void setGravity(int i2, int i3, int i4) {
        this.toast.setGravity(i2, i3, i4);
    }

    public void setMargin(float f, float f2) {
        this.toast.setMargin(f, f2);
    }

    public void setText(int i2) {
        this.toast.setText(i2);
    }

    public void setView(View view) {
        this.toast.setView(view);
        setContextCompat(view, new qw(view.getContext(), this));
    }

    public void show() {
        this.toast.show();
    }

    public void setText(CharSequence charSequence) {
        this.toast.setText(charSequence);
    }

    public static Toast makeText(Context context, int i2, int i3) throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(i2), i3);
    }
}
