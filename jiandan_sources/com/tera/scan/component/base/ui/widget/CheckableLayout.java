package com.tera.scan.component.base.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.baidu.aiscan.R;
import fe.mmm.qw.p030switch.th.de.ad.qw;

public abstract class CheckableLayout extends RelativeLayout implements Checkable {
    public static final int BASE_PADDING = ((int) (qw.ad() * 55.0f));
    public static final int[] CHECKED_STATE_SET = {16842912};
    public static final int CHOICE_MODE_MULTIPLE = 2;
    public static final int CHOICE_MODE_NONE = 0;
    public static final int CHOICE_MODE_SINGLE = 1;
    public static final int HAS_CHECK_RIGHT = 50;
    public static final int NO_CHECK_RIGHT = 8;
    public static final String TAG = "CheckableItemLayout";
    public TextView fileSize;
    public int mBasePaddingRight;
    public Drawable mCheckMarkDrawable;
    public boolean mChecked;
    public int mChoiceMode;
    public int mMultiChoiceRes;
    public boolean mShowCheckMarkDrawable;
    public int mSingleChoiceRes;

    public CheckableLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        boolean dispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        if (!dispatchPopulateAccessibilityEvent) {
            accessibilityEvent.setChecked(this.mChecked);
        }
        return dispatchPopulateAccessibilityEvent;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mCheckMarkDrawable != null) {
            this.mCheckMarkDrawable.setState(getDrawableState());
            invalidate();
        }
    }

    public int getChoiceMode() {
        return this.mChoiceMode;
    }

    @ViewDebug.ExportedProperty
    public boolean isChecked() {
        return this.mChecked;
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            RelativeLayout.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        onDrawCanvas(canvas, (View) null, (View) null);
    }

    public void onDrawCanvas(Canvas canvas, View view, View view2) {
        if (this.mCheckMarkDrawable == null) {
            super.setPadding(getPaddingLeft(), getPaddingTop(), this.mBasePaddingRight, getPaddingBottom());
        } else if (view2 == null || this.mShowCheckMarkDrawable) {
            super.setPadding(getPaddingLeft(), getPaddingTop(), BASE_PADDING, getPaddingBottom());
        } else {
            super.setPadding(getPaddingLeft(), getPaddingTop(), this.mBasePaddingRight, getPaddingBottom());
        }
        if (!(view == null || view2 == null)) {
            if (this.mChoiceMode == 2) {
                view.setVisibility(8);
                if (this.mShowCheckMarkDrawable) {
                    view2.setVisibility(8);
                } else {
                    view2.setVisibility(0);
                }
            } else {
                view.setVisibility(8);
                view2.setVisibility(0);
            }
        }
        Drawable drawable = this.mCheckMarkDrawable;
        if (drawable != null && this.mShowCheckMarkDrawable) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int height = (getHeight() - intrinsicHeight) / 2;
            int i2 = BASE_PADDING;
            int width = (getWidth() - i2) + ((i2 - intrinsicWidth) / 2);
            drawable.setBounds(width, height, intrinsicWidth + width, intrinsicHeight + height);
            drawable.draw(canvas);
            setChecked(this.mChecked);
        }
    }

    public void setCheckMarkDrawable(Drawable drawable, View view, View view2) {
        Drawable drawable2 = this.mCheckMarkDrawable;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.mCheckMarkDrawable);
        }
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(getVisibility() == 0, false);
            drawable.setState(CHECKED_STATE_SET);
            if (view2 == null && view != null) {
                super.setPadding(getPaddingLeft(), getPaddingTop(), BASE_PADDING, getPaddingBottom());
            }
            drawable.setState(getDrawableState());
        } else if (view2 == null && view != null) {
            super.setPadding(getPaddingLeft(), getPaddingTop(), this.mBasePaddingRight, getPaddingBottom());
        }
        this.mCheckMarkDrawable = drawable;
    }

    public void setChecked(boolean z) {
        if (this.mChecked != z) {
            this.mChecked = z;
            refreshDrawableState();
        }
    }

    public void setChoiceMode(int i2) {
        setChoiceMode(i2, (View) null, (View) null);
    }

    public void setMultiChoiceRes(@DrawableRes int i2) {
        this.mMultiChoiceRes = i2;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        if (this.mChoiceMode == 0) {
            this.mBasePaddingRight = getPaddingRight();
        }
    }

    public void setSingleChoiceRes(@DrawableRes int i2) {
        this.mSingleChoiceRes = i2;
    }

    public void showCheckMarkDrawable(boolean z) {
        this.mShowCheckMarkDrawable = z;
    }

    public void toggle() {
        setChecked(!this.mChecked);
    }

    public CheckableLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setChoiceMode(int i2, View view, View view2) {
        if (this.mChoiceMode != i2) {
            this.mChoiceMode = i2;
            Drawable drawable = null;
            if (i2 == 1) {
                drawable = getResources().getDrawable(this.mSingleChoiceRes);
            } else if (i2 == 2) {
                drawable = getResources().getDrawable(this.mMultiChoiceRes);
            } else if (i2 == 0) {
                setChecked(false);
            }
            setCheckMarkDrawable(drawable, view, view2);
            if (view2 == null && view != null) {
                if (i2 == 2) {
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                }
            }
        }
    }

    public CheckableLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mCheckMarkDrawable = null;
        this.mShowCheckMarkDrawable = true;
        this.mChoiceMode = 0;
        this.fileSize = null;
        this.mSingleChoiceRes = R.drawable.rice_btn_radio;
        this.mMultiChoiceRes = R.drawable.rice_btn_check;
        setWillNotDraw(false);
    }
}
