package com.tera.scan.component.base.ui.widget.titlebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import fe.mmm.qw.d.de.de;
import java.util.LinkedList;
import org.apache.commons.lang3.StringUtils;

public class CustomizedTitleBar extends ViewGroup implements View.OnClickListener {
    public static final int ACTION_PADDING = 8;
    public static final int DEFAULT_ACTION_TEXT_SIZE = 15;
    public static final int DEFAULT_MAIN_TEXT_SIZE = 18;
    public static final int DEFAULT_SUB_TEXT_SIZE = 12;
    public static final int DEFAULT_TITLE_BAR_HEIGHT = 48;
    public static final int OUT_PADDING = 10;
    public int mActionPadding;
    public int mActionTextColor;
    public LinearLayout mCenterLayout;
    public TextView mCenterText;
    public View mCustomCenterView;
    public View mDividerView;
    public int mHeight;
    public TextView mLeftText;
    public int mOutPadding;
    public LinearLayout mRightLayout;
    public int mScreenWidth;
    public TextView mSubTitleText;

    public interface Action {
        String ad();

        int de();

        void qw(View view);
    }

    public static class ActionList extends LinkedList<Action> {
    }

    public static abstract class qw implements Action {
        public int qw;

        public qw(int i2) {
            this.qw = i2;
        }

        public String ad() {
            return null;
        }

        public int de() {
            return this.qw;
        }
    }

    public CustomizedTitleBar(Context context) {
        super(context);
        init(context);
    }

    public static int getInternalDimensionSize(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, ResUtils.f719i, SapiDeviceInfo.OS_TYPE);
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.widget.TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.widget.ImageView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.widget.TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.widget.TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: android.widget.TextView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View inflateAction(com.tera.scan.component.base.ui.widget.titlebar.CustomizedTitleBar.Action r4) {
        /*
            r3 = this;
            java.lang.String r0 = r4.ad()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x001b
            android.widget.ImageView r0 = new android.widget.ImageView
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            int r1 = r4.de()
            r0.setImageResource(r1)
            goto L_0x003c
        L_0x001b:
            android.widget.TextView r0 = new android.widget.TextView
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            r1 = 17
            r0.setGravity(r1)
            java.lang.String r1 = r4.ad()
            r0.setText(r1)
            r1 = 1097859072(0x41700000, float:15.0)
            r0.setTextSize(r1)
            int r1 = r3.mActionTextColor
            if (r1 == 0) goto L_0x003c
            r0.setTextColor(r1)
        L_0x003c:
            int r1 = r3.mActionPadding
            r2 = 0
            r0.setPadding(r1, r2, r1, r2)
            r0.setTag(r4)
            r0.setOnClickListener(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.component.base.ui.widget.titlebar.CustomizedTitleBar.inflateAction(com.tera.scan.component.base.ui.widget.titlebar.CustomizedTitleBar$Action):android.view.View");
    }

    private void init(Context context) {
        this.mActionPadding = fe.mmm.qw.p030switch.th.de.ad.qw.qw(context, 8.0f);
        this.mOutPadding = fe.mmm.qw.p030switch.th.de.ad.qw.qw(context, 10.0f);
        this.mHeight = fe.mmm.qw.p030switch.th.de.ad.qw.qw(context, 48.0f);
        initView(context);
    }

    private void initView(Context context) {
        this.mLeftText = new TextView(context);
        this.mCenterLayout = new LinearLayout(context);
        this.mRightLayout = new LinearLayout(context);
        this.mDividerView = new View(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        this.mLeftText.setTextSize(15.0f);
        this.mLeftText.setSingleLine();
        this.mLeftText.setGravity(16);
        TextView textView = this.mLeftText;
        int i2 = this.mOutPadding;
        textView.setPadding(this.mActionPadding + i2, 0, i2, 0);
        this.mCenterText = new TextView(context);
        this.mSubTitleText = new TextView(context);
        this.mCenterLayout.addView(this.mCenterText);
        this.mCenterLayout.addView(this.mSubTitleText);
        this.mCenterLayout.setGravity(17);
        this.mCenterText.setTextSize(18.0f);
        this.mCenterText.setSingleLine();
        this.mCenterText.setGravity(17);
        this.mCenterText.setEllipsize(TextUtils.TruncateAt.END);
        this.mSubTitleText.setTextSize(12.0f);
        this.mSubTitleText.setSingleLine();
        this.mSubTitleText.setGravity(17);
        this.mSubTitleText.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout linearLayout = this.mRightLayout;
        int i3 = this.mOutPadding;
        linearLayout.setPadding(i3, 0, i3, 0);
        addView(this.mLeftText, layoutParams);
        addView(this.mCenterLayout);
        addView(this.mRightLayout, layoutParams);
        addView(this.mDividerView, new ViewGroup.LayoutParams(-1, 1));
    }

    public View addAction(Action action) {
        return addAction(action, this.mRightLayout.getChildCount());
    }

    public void addActions(ActionList actionList) {
        int size = actionList.size();
        for (int i2 = 0; i2 < size; i2++) {
            addAction((Action) actionList.get(i2));
        }
    }

    public int getActionCount() {
        return this.mRightLayout.getChildCount();
    }

    public View getViewByAction(Action action) {
        return findViewWithTag(action);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof Action) {
            ((Action) tag).qw(view);
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        TextView textView = this.mLeftText;
        textView.layout(0, 0, textView.getMeasuredWidth(), this.mLeftText.getMeasuredHeight());
        LinearLayout linearLayout = this.mRightLayout;
        linearLayout.layout(this.mScreenWidth - linearLayout.getMeasuredWidth(), 0, this.mScreenWidth, this.mRightLayout.getMeasuredHeight());
        if (this.mLeftText.getMeasuredWidth() > this.mRightLayout.getMeasuredWidth()) {
            this.mCenterLayout.layout(this.mLeftText.getMeasuredWidth(), 0, this.mScreenWidth - this.mLeftText.getMeasuredWidth(), getMeasuredHeight());
        } else {
            this.mCenterLayout.layout(this.mRightLayout.getMeasuredWidth(), 0, this.mScreenWidth - this.mRightLayout.getMeasuredWidth(), getMeasuredHeight());
        }
        this.mDividerView.layout(0, getMeasuredHeight() - this.mDividerView.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        if (View.MeasureSpec.getMode(i3) != 1073741824) {
            int i5 = this.mHeight;
            i4 = i5;
            i3 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        } else {
            i4 = View.MeasureSpec.getSize(i3);
        }
        this.mScreenWidth = View.MeasureSpec.getSize(i2);
        measureChild(this.mLeftText, i2, i3);
        measureChild(this.mRightLayout, i2, i3);
        if (this.mLeftText.getMeasuredWidth() > this.mRightLayout.getMeasuredWidth()) {
            this.mCenterLayout.measure(View.MeasureSpec.makeMeasureSpec(this.mScreenWidth - (this.mLeftText.getMeasuredWidth() * 2), 1073741824), i3);
        } else {
            this.mCenterLayout.measure(View.MeasureSpec.makeMeasureSpec(this.mScreenWidth - (this.mRightLayout.getMeasuredWidth() * 2), 1073741824), i3);
        }
        measureChild(this.mDividerView, i2, i3);
        setMeasuredDimension(View.MeasureSpec.getSize(i2), i4);
    }

    public void removeAction(Action action) {
        int childCount = this.mRightLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.mRightLayout.getChildAt(i2);
            if (childAt != null) {
                Object tag = childAt.getTag();
                if ((tag instanceof Action) && tag.equals(action)) {
                    this.mRightLayout.removeView(childAt);
                }
            }
        }
    }

    public void removeActionAt(int i2) {
        this.mRightLayout.removeViewAt(i2);
    }

    public void removeAllActions() {
        this.mRightLayout.removeAllViews();
    }

    public void setActionTextColor(int i2) {
        this.mActionTextColor = i2;
    }

    public void setCenterClickListener(View.OnClickListener onClickListener) {
        this.mCenterLayout.setOnClickListener(onClickListener);
    }

    public void setCustomTitle(View view) {
        if (view == null) {
            this.mCenterText.setVisibility(0);
            View view2 = this.mCustomCenterView;
            if (view2 != null) {
                this.mCenterLayout.removeView(view2);
                return;
            }
            return;
        }
        View view3 = this.mCustomCenterView;
        if (view3 != null) {
            this.mCenterLayout.removeView(view3);
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.mCustomCenterView = view;
        this.mCenterLayout.addView(view, layoutParams);
        this.mCenterText.setVisibility(8);
    }

    public void setDivider(Drawable drawable) {
        this.mDividerView.setBackgroundDrawable(drawable);
    }

    public void setDividerColor(int i2) {
        this.mDividerView.setBackgroundColor(i2);
    }

    public void setDividerHeight(int i2) {
        this.mDividerView.getLayoutParams().height = i2;
    }

    public void setHeight(int i2) {
        this.mHeight = i2;
        setMeasuredDimension(getMeasuredWidth(), this.mHeight);
    }

    public void setLeftClickListener(View.OnClickListener onClickListener) {
        this.mLeftText.setOnClickListener(onClickListener);
    }

    public void setLeftImageResource(int i2) {
        this.mLeftText.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
    }

    public void setLeftText(CharSequence charSequence) {
        this.mLeftText.setText(charSequence);
    }

    public void setLeftTextColor(int i2) {
        this.mLeftText.setTextColor(i2);
    }

    public void setLeftTextSize(float f) {
        this.mLeftText.setTextSize(f);
    }

    public void setLeftVisible(boolean z) {
        this.mLeftText.setVisibility(z ? 0 : 8);
    }

    public void setOnTitleClickListener(View.OnClickListener onClickListener) {
        this.mCenterText.setOnClickListener(onClickListener);
    }

    public void setSubTitleColor(int i2) {
        this.mSubTitleText.setTextColor(i2);
    }

    public void setSubTitleSize(float f) {
        this.mSubTitleText.setTextSize(f);
    }

    public void setTitle(CharSequence charSequence) {
        int indexOf = charSequence.toString().indexOf(StringUtils.LF);
        if (indexOf > 0) {
            setTitle(charSequence.subSequence(0, indexOf), charSequence.subSequence(indexOf + 1, charSequence.length()), 1);
            return;
        }
        int indexOf2 = charSequence.toString().indexOf("\t");
        if (indexOf2 > 0) {
            CharSequence subSequence = charSequence.subSequence(0, indexOf2);
            setTitle(subSequence, "  " + charSequence.subSequence(indexOf2 + 1, charSequence.length()), 0);
            return;
        }
        this.mCenterText.setText(charSequence);
        this.mSubTitleText.setVisibility(8);
    }

    public void setTitleBackground(int i2) {
        this.mCenterText.setBackgroundResource(i2);
    }

    public void setTitleBarBackgroundColor(int i2) {
        setBackgroundColor(de.when().i(i2));
    }

    public void setTitleColor(int i2) {
        this.mCenterText.setTextColor(i2);
    }

    public void setTitleSize(float f) {
        this.mCenterText.setTextSize(f);
    }

    public void setLeftText(int i2) {
        this.mLeftText.setText(i2);
    }

    public CustomizedTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public View addAction(Action action, int i2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        View inflateAction = inflateAction(action);
        this.mRightLayout.addView(inflateAction, i2, layoutParams);
        return inflateAction;
    }

    public CustomizedTitleBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }

    private void setTitle(CharSequence charSequence, CharSequence charSequence2, int i2) {
        this.mCenterLayout.setOrientation(i2);
        this.mCenterText.setText(charSequence);
        this.mSubTitleText.setText(charSequence2);
        this.mSubTitleText.setVisibility(0);
    }

    public void setTitle(int i2) {
        setTitle((CharSequence) getResources().getString(i2));
    }
}
