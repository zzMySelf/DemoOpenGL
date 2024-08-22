package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.dynamic.RemoteCreator;
import com.tera.scan.app.R$styleable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout implements View.OnClickListener {
    public static final int COLOR_AUTO = 2;
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    public int mColor;
    public int mSize;
    public View zaau;
    public View.OnClickListener zaav;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    public SignInButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.zaav;
        if (onClickListener != null && view == this.zaau) {
            onClickListener.onClick(this);
        }
    }

    public final void setColorScheme(int i2) {
        setStyle(this.mSize, i2);
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.zaau.setEnabled(z);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zaav = onClickListener;
        View view = this.zaau;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        setStyle(this.mSize, this.mColor);
    }

    public final void setSize(int i2) {
        setStyle(i2, this.mColor);
    }

    public final void setStyle(int i2, int i3) {
        this.mSize = i2;
        this.mColor = i3;
        Context context = getContext();
        View view = this.zaau;
        if (view != null) {
            removeView(view);
        }
        try {
            this.zaau = SignInButtonCreator.createView(context, this.mSize, this.mColor);
        } catch (RemoteCreator.RemoteCreatorException unused) {
            int i4 = this.mSize;
            int i5 = this.mColor;
            SignInButtonImpl signInButtonImpl = new SignInButtonImpl(context);
            signInButtonImpl.configure(context.getResources(), i4, i5);
            this.zaau = signInButtonImpl;
        }
        addView(this.zaau);
        this.zaau.setEnabled(isEnabled());
        this.zaau.setOnClickListener(this);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public SignInButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.zaav = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SignInButton, 0, 0);
        try {
            this.mSize = obtainStyledAttributes.getInt(0, 0);
            this.mColor = obtainStyledAttributes.getInt(1, 2);
            obtainStyledAttributes.recycle();
            setStyle(this.mSize, this.mColor);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Deprecated
    public final void setStyle(int i2, int i3, Scope[] scopeArr) {
        setStyle(i2, i3);
    }
}
