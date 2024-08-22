package com.dxmpay.wallet.base.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.statusbar.ImmersiveStatusBarManager;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.utils.AccessibilityUtils;

public class BdActionBar extends RelativeLayout {
    public static final int TEXT_ALIGN_CENTER = 1;
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int TEXT_ALIGN_RIGHT = 2;
    public String a = "";
    public View b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public View g;
    public View h;

    /* renamed from: i  reason: collision with root package name */
    public View f4138i;
    public NetImageView j;
    public View k;
    public NetImageView l;
    public TextView m;
    public View mLeftImgZone2;
    public TextView mTitleCenterText;
    public View n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f4139o;
    public ImageView p;
    public ImageView q;
    public ImageView r;
    public View s;
    public TextView t;
    public ImageView u;

    public class ad implements View.OnTouchListener {
        public ad() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                ViewHelper.setAlpha(BdActionBar.this.h, 0.5f);
                return false;
            }
            ViewHelper.setAlpha(BdActionBar.this.h, 1.0f);
            return false;
        }
    }

    public class qw implements View.OnTouchListener {
        public qw() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                ViewHelper.setAlpha(BdActionBar.this.mLeftImgZone2, 0.5f);
                return false;
            }
            ViewHelper.setAlpha(BdActionBar.this.mLeftImgZone2, 1.0f);
            return false;
        }
    }

    public BdActionBar(Context context) {
        super(context);
        a();
    }

    public int getActionBarHeight() {
        return this.b.getHeight() - this.g.getHeight();
    }

    public String getLayoutId() {
        return "dxm_wallet_base_action_bar";
    }

    public int getMainTitleViewWidth() {
        this.mTitleCenterText.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mTitleCenterText.getMeasuredWidth();
    }

    public View getRightImgZone1ImgView() {
        return this.j;
    }

    public View getRightImgZone2ImgView() {
        return this.l;
    }

    public View getRightImgZone2NotifyView() {
        return this.m;
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.m.getVisibility();
    }

    public View getRightNotifyZone1() {
        return this.s;
    }

    public View getRightZone1View() {
        return this.f4138i;
    }

    public View getRightZoneView() {
        return this.k;
    }

    public int getStatusBarHeight() {
        return this.g.getHeight();
    }

    public String getTitle() {
        return this.a;
    }

    public int[] getTitleSizeRange() {
        return new int[]{DisplayUtils.dip2px(getContext(), 18.0f), Math.round(this.f.getTextSize())};
    }

    public void hideLeftZone() {
        this.mLeftImgZone2.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams.width = DisplayUtils.dip2px(getContext(), 50.0f);
        this.h.setLayoutParams(layoutParams);
        this.h.setPadding(DisplayUtils.dip2px(getContext(), 12.0f), 0, 0, 0);
    }

    public boolean isLeftZoneImageSelected() {
        return this.mLeftImgZone2.isSelected();
    }

    public void resetFullScreenTextColor() {
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_click_text1_color_selector"));
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_click_text1_color_selector"));
        }
        TextView textView3 = this.f;
        if (textView3 != null) {
            textView3.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_click_text1_color_selector"));
        }
        TextView textView4 = this.mTitleCenterText;
        if (textView4 != null) {
            textView4.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_black3"));
        }
        TextView textView5 = this.m;
        if (textView5 != null) {
            textView5.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_click_text2color_selector"));
        }
        TextView textView6 = this.f4139o;
        if (textView6 != null) {
            textView6.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_text_999999"));
        }
    }

    public void setBottomSeperatorvisible(boolean z) {
        ImageView imageView = this.q;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public int setCloseButtonVisibility(int i2) {
        int visibility = this.h.getVisibility();
        if (i2 == 0 || 8 == i2 || 4 == i2) {
            this.h.setVisibility(i2);
            if (i2 == 0) {
                this.mTitleCenterText.setMaxEms(ResUtils.getInteger(getContext(), "dxm_wallet_base_titlebar_centertext_maxems_1"));
            }
        }
        return visibility;
    }

    public void setCloseOnClickListener(View.OnClickListener onClickListener) {
        this.h.setOnClickListener(onClickListener);
    }

    public void setFullScreenTextColor(int i2) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextColor(i2);
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setTextColor(i2);
        }
        TextView textView3 = this.f;
        if (textView3 != null) {
            textView3.setTextColor(i2);
        }
        TextView textView4 = this.mTitleCenterText;
        if (textView4 != null) {
            textView4.setTextColor(i2);
        }
        TextView textView5 = this.m;
        if (textView5 != null) {
            textView5.setTextColor(i2);
        }
        TextView textView6 = this.f4139o;
        if (textView6 != null) {
            textView6.setTextColor(i2);
        }
    }

    public void setIconFlag(boolean z) {
        View view;
        if (z) {
            setLeftZoneImageSrc(ResUtils.drawable(getContext(), "dxm_wallet_base_actionbar_back_selector_white"));
            if (this.l.getVisibility() == 0) {
                setRightImgZone2Src(ResUtils.drawable(getContext(), "dxm_wallet_base_actionbar_more_selector_white"));
            }
            this.r.setImageDrawable(ResUtils.getDrawable(getContext(), "dxm_wallet_base_actionbar_close_selector_white"));
        } else {
            setLeftZoneImageSrc(ResUtils.drawable(getContext(), "dxm_wallet_base_actionbar_back_selector"));
            if (this.l.getVisibility() == 0) {
                setRightImgZone2Src(ResUtils.drawable(getContext(), "dxm_wallet_base_actionbar_more_selector"));
            }
            this.r.setImageDrawable(ResUtils.getDrawable(getContext(), "dxm_wallet_base_actionbar_close_selector"));
        }
        if (Build.VERSION.SDK_INT >= 19) {
            Activity activity = null;
            if (getContext() instanceof Activity) {
                activity = (Activity) getContext();
            }
            if (activity != null && (view = this.g) != null) {
                ImmersiveStatusBarManager.setTopBar(activity, view, !z);
            }
        }
    }

    public void setImgZoneBackgroundResource(int i2) {
        this.f4138i.setBackgroundResource(i2);
        this.k.setBackgroundResource(i2);
    }

    public void setLeftImgZone2NotifyText(String str, float f2) {
        this.d.setVisibility(8);
        if (f2 >= 0.0f) {
            this.d.setText(str);
            this.d.setTextSize(1, f2);
        }
    }

    public void setLeftImgZone2NotifyTextColor(int i2) {
        this.d.setTextColor(i2);
    }

    public void setLeftImgZone2NotifyTextColorStateList(ColorStateList colorStateList) {
        this.d.setTextColor(colorStateList);
    }

    public void setLeftZoneImageSelected(boolean z) {
    }

    public void setLeftZoneImageSrc(int i2) {
        Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        this.c.setImageDrawable(drawable);
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.mLeftImgZone2.setOnClickListener(onClickListener);
    }

    public BdActionBar setOnlyIcons(boolean z) {
        int i2 = z ? 8 : 0;
        return a(i2).b(i2);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.j.setEnabled(z);
        this.f4138i.setEnabled(z);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.f4138i.setOnClickListener(onClickListener);
    }

    public void setRightImgZone1Src(int i2) {
        this.f4138i.setVisibility(0);
        this.j.setVisibility(0);
        this.j.setImageResource(i2);
    }

    public void setRightImgZone1Visibility(int i2) {
        this.f4138i.setVisibility(i2);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.l.setEnabled(z);
        this.k.setEnabled(z);
    }

    public void setRightImgZone2NotifyClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.m.setVisibility(0);
        }
        this.m.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2NotifyText(String str) {
        if (!TextUtils.isEmpty(str)) {
            setRightImgZone2NotifyVisibility(0);
        }
        this.m.setText(str);
    }

    public void setRightImgZone2NotifyTextBg(int i2) {
        this.m.setBackgroundResource(i2);
        this.m.setPadding(12, 6, 12, 6);
    }

    public void setRightImgZone2NotifyTextColor(int i2) {
        this.m.setTextColor(i2);
    }

    public void setRightImgZone2NotifyTextSize(float f2) {
        this.m.setTextSize(1, f2);
    }

    public void setRightImgZone2NotifyTextViewPadding(int i2, int i3, int i4, int i5) {
        this.m.setPadding(i2, i3, i4, i5);
    }

    public void setRightImgZone2NotifyVisibility(int i2) {
        this.m.setVisibility(i2);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.k.setVisibility(0);
        }
        this.k.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Src(int i2) {
        this.l.setVisibility(0);
        this.l.setImageResource(i2);
    }

    public void setRightImgZone2Visibility(int i2) {
        this.k.setVisibility(i2);
    }

    public void setRightNotifyImg(Drawable drawable) {
        this.u.setImageDrawable(drawable);
    }

    public void setRightNotifyText(String str) {
        this.t.setText(str);
    }

    public void setRightNotifyTextColor(int i2) {
        this.t.setTextColor(i2);
    }

    public void setRightNotifyTextSize(int i2) {
        this.t.setTextSize(1, (float) i2);
    }

    public void setRightNotifyZone1Bg(Drawable drawable) {
        this.s.setBackgroundDrawable(drawable);
    }

    public void setRightNotifyZone1ClickListener(View.OnClickListener onClickListener) {
        this.s.setOnClickListener(onClickListener);
    }

    public void setRightNotifyZone1Visibility(int i2) {
        this.s.setVisibility(i2);
    }

    public void setSafeIconVisible(boolean z) {
        if (z) {
            this.p.setVisibility(0);
        } else {
            this.p.setVisibility(8);
        }
    }

    public void setTitle(String str) {
        this.a = str;
        this.mTitleCenterText.setText(str);
    }

    public void setTitleCenterSafeTipColor(int i2) {
        this.f4139o.setTextColor(i2);
    }

    public void setTitleCenterSafeTipText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.n.setVisibility(8);
            return;
        }
        this.n.setVisibility(0);
        this.f4139o.setText(str);
    }

    public void setTitleColor(int i2) {
        this.mTitleCenterText.setTextColor(i2);
    }

    public void setTitleEllipsize(TextUtils.TruncateAt truncateAt) {
        if (truncateAt != null) {
            this.mTitleCenterText.setSingleLine();
            this.mTitleCenterText.setEllipsize(truncateAt);
        }
    }

    public void setTitleShadowLayer(float f2, float f3, float f4, int i2) {
        this.mTitleCenterText.setShadowLayer(f2, f3, f4, i2);
    }

    public void setTitleSize(int i2) {
        this.mTitleCenterText.setTextSize(0, (float) i2);
    }

    public void setTitleTextColorAlpha(int i2) {
        try {
            int currentTextColor = this.mTitleCenterText.getCurrentTextColor();
            this.mTitleCenterText.setTextColor(Color.argb(i2, Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
            int currentTextColor2 = this.f4139o.getCurrentTextColor();
            this.f4139o.setTextColor(Color.argb(i2, Color.red(currentTextColor2), Color.green(currentTextColor2), Color.blue(currentTextColor2)));
        } catch (Throwable unused) {
        }
    }

    public void setTitlebgColor(int i2) {
        View view = this.b;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    public void setTop(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            if (activity == null) {
                activity = getContext() instanceof Activity ? (Activity) getContext() : null;
            }
            if (activity != null) {
                this.g.setLayoutParams(new RelativeLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(activity)));
                ImmersiveStatusBarManager.setTopBar(activity, this.g, true);
            }
        }
    }

    public void setbackBg(Drawable drawable) {
        this.mLeftImgZone2.setBackgroundDrawable(drawable);
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), getLayoutId()), this);
        this.g = findViewById(ResUtils.id(getContext(), "actionbar_statusbar_top"));
        setTop((Activity) null);
        this.b = findViewById(ResUtils.id(getContext(), "title"));
        View findViewById = findViewById(ResUtils.id(getContext(), "title_left_imgzone2"));
        this.mLeftImgZone2 = findViewById;
        AccessibilityUtils.changeRoleDescription(findViewById, ResUtils.getString(getContext(), "wallet_access_button"));
        this.c = (ImageView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_img"));
        this.e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_titlebar_left_imgzone2_close"));
        this.r = (ImageView) findViewById(ResUtils.id(getContext(), "bd_ab_ic_close"));
        this.f = (TextView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_notify"));
        this.d = (TextView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_notify"));
        this.mLeftImgZone2.setOnTouchListener(new qw());
        View findViewById2 = findViewById(ResUtils.id(getContext(), "title_close"));
        this.h = findViewById2;
        findViewById2.setOnTouchListener(new ad());
        this.mTitleCenterText = (TextView) findViewById(ResUtils.id(getContext(), "title_center_text"));
        this.n = findViewById(ResUtils.id(getContext(), "title_center_safe_layout"));
        this.f4139o = (TextView) findViewById(ResUtils.id(getContext(), "title_center_safe_tip"));
        this.p = (ImageView) findViewById(ResUtils.id(getContext(), "safe_icon"));
        this.f4138i = findViewById(ResUtils.id(getContext(), "title_right_imgzone1"));
        this.j = (NetImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img1"));
        this.k = findViewById(ResUtils.id(getContext(), "title_right_imgzone2"));
        this.l = (NetImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img"));
        this.m = (TextView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify"));
        this.s = findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify_zone"));
        this.t = (TextView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify1"));
        this.u = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify_triangle"));
        if (!TextUtils.isEmpty(this.a)) {
            setTitle(this.a);
        }
        this.q = (ImageView) findViewById(ResUtils.id(getContext(), "title_bottom_seperator"));
    }

    private BdActionBar b(int i2) {
        if (i2 == 0 || 8 == i2) {
            if (this.e.getVisibility() != i2) {
                a((View) this.r);
            }
            this.e.setVisibility(i2);
        }
        return this;
    }

    public void setRightImgZone2Src(int i2, CharSequence charSequence) {
        setRightImgZone2Src(i2);
        AccessibilityUtils.setContentDescription(this.l, charSequence);
    }

    public void setTitle(int i2) {
        setTitle(getResources().getString(i2));
    }

    public BdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void setLeftZoneImageSrc(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        this.c.setImageDrawable(drawable);
    }

    public void setRightImgZone1Src(String str) {
        this.f4138i.setVisibility(0);
        this.j.setVisibility(0);
        this.j.setImageUrl(str);
    }

    public void setRightImgZone2Src(String str) {
        this.l.setVisibility(0);
        this.l.setImageUrl(str);
    }

    public BdActionBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private BdActionBar a(int i2) {
        if (i2 == 0 || 8 == i2) {
            this.d.setVisibility(8);
        }
        return this;
    }

    private void a(View view) {
        view.setVisibility(view.getVisibility() == 0 ? 8 : 0);
    }
}
