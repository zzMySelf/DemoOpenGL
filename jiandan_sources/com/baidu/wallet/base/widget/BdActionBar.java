package com.baidu.wallet.base.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.baidu.aiscan.R;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.utils.AccessibilityUtils;
import com.baidu.wallet.utils.ViewUtils;
import java.util.Arrays;

public class BdActionBar extends RelativeLayout {
    public static final String TAG = BdActionBar.class.getSimpleName();
    public static final int TEXT_ALIGN_CENTER = 1;
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int TEXT_ALIGN_RIGHT = 2;
    public static final float a = 0.5f;
    public static final float b = 1.0f;
    public String c = "";
    public ViewGroup d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public TextView h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f1138i;
    public View j;
    public View k;
    public NetImageView l;
    public View m;
    public View mClose;
    public View mLeftImgZone2;
    public TextView mTitleCenterText;
    public NetImageView n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f1139o;
    public View p;
    public TextView q;
    public ImageView r;
    public View s;
    public TextView t;
    public ImageView u;
    public ImageView v;
    public BubbleForSubMenu w;
    public boolean x = false;
    public boolean y;

    public BdActionBar(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), getLayoutId()), this);
        this.j = findViewById(ResUtils.id(getContext(), "actionbar_statusbar_top"));
        setTop((Activity) null);
        this.d = (ViewGroup) findViewById(ResUtils.id(getContext(), "title"));
        this.mLeftImgZone2 = findViewById(ResUtils.id(getContext(), "title_left_imgzone2"));
        this.e = (ImageView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_img"));
        this.h = (TextView) findViewById(ResUtils.id(getContext(), "wallet_titlebar_left_imgzone2_close"));
        this.f1138i = (ImageView) findViewById(ResUtils.id(getContext(), "bd_ab_ic_close"));
        this.g = (TextView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_notify"));
        this.f = (TextView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_notify"));
        this.mLeftImgZone2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    ViewHelper.setAlpha(BdActionBar.this.mLeftImgZone2, 0.5f);
                    return false;
                }
                ViewHelper.setAlpha(BdActionBar.this.mLeftImgZone2, 1.0f);
                return false;
            }
        });
        View findViewById = findViewById(ResUtils.id(getContext(), "title_close"));
        this.mClose = findViewById;
        findViewById.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    ViewHelper.setAlpha(BdActionBar.this.mClose, 0.5f);
                    return false;
                }
                ViewHelper.setAlpha(BdActionBar.this.mClose, 1.0f);
                return false;
            }
        });
        this.mTitleCenterText = (TextView) findViewById(ResUtils.id(getContext(), "title_center_text"));
        this.s = findViewById(ResUtils.id(getContext(), "title_center_safe_layout"));
        this.t = (TextView) findViewById(ResUtils.id(getContext(), "title_center_safe_tip"));
        this.u = (ImageView) findViewById(ResUtils.id(getContext(), "safe_icon"));
        this.k = findViewById(ResUtils.id(getContext(), "title_right_imgzone1"));
        this.l = (NetImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img1"));
        this.m = findViewById(ResUtils.id(getContext(), "title_right_imgzone2"));
        this.n = (NetImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img"));
        this.f1139o = (TextView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify"));
        this.p = findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify_zone"));
        this.q = (TextView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify1"));
        this.r = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify_triangle"));
        if (!TextUtils.isEmpty(this.c)) {
            setTitle(this.c);
        }
        this.v = (ImageView) findViewById(ResUtils.id(getContext(), "title_bottom_seperator"));
    }

    private BdActionBar b(int i2) {
        if (i2 == 0 || 8 == i2) {
            if (this.f1138i.getVisibility() != i2) {
                a((View) this.h);
            }
            this.f1138i.setVisibility(i2);
        }
        return this;
    }

    public int getActionBarHeight() {
        return this.d.getHeight() - this.j.getHeight();
    }

    public String getLayoutId() {
        return "wallet_base_action_bar";
    }

    public int getMainTitleViewWidth() {
        this.mTitleCenterText.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mTitleCenterText.getMeasuredWidth();
    }

    public View getRightImgZone1ImgView() {
        return this.l;
    }

    public View getRightImgZone2ImgView() {
        return this.n;
    }

    public View getRightImgZone2NotifyView() {
        return this.f1139o;
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.f1139o.getVisibility();
    }

    public View getRightNotifyZone1() {
        return this.p;
    }

    public View getRightZone1View() {
        return this.k;
    }

    public View getRightZoneView() {
        return this.m;
    }

    public int getStatusBarHeight() {
        return this.j.getHeight();
    }

    public String getTitle() {
        return this.c;
    }

    public int getTitleHeight() {
        if (this.d == null) {
            return 0;
        }
        this.d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.d.getMeasuredHeight();
    }

    public int[] getTitleSizeRange() {
        return new int[]{DisplayUtils.dip2px(getContext(), 18.0f), Math.round(this.g.getTextSize())};
    }

    @RequiresApi(api = 11)
    public void hideBubble(boolean z) {
        BubbleForSubMenu bubbleForSubMenu = this.w;
        if (bubbleForSubMenu != null) {
            if (this.y || bubbleForSubMenu.isShowingBubble()) {
                this.w.hideBubble(z);
            }
        }
    }

    public void hideLeftZone() {
        this.mLeftImgZone2.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mClose.getLayoutParams();
        layoutParams.width = DisplayUtils.dip2px(getContext(), 50.0f);
        this.mClose.setLayoutParams(layoutParams);
        this.mClose.setPadding(DisplayUtils.dip2px(getContext(), 12.0f), 0, 0, 0);
    }

    public boolean isIconWhite() {
        return this.x;
    }

    public boolean isLeftZoneImageSelected() {
        return this.mLeftImgZone2.isSelected();
    }

    public void removeTitleFloatView() {
        View findViewById;
        try {
            if (this.d != null && (findViewById = this.d.findViewById(R.id.view_click_able)) != null) {
                this.d.removeView(findViewById);
            }
        } catch (Exception e2) {
            String str = TAG;
            LogUtil.d(str, "removeTitleFloatView Exception ::" + e2.toString());
        }
    }

    public void resetFullScreenTextColor() {
        TextView textView = this.f;
        if (textView != null) {
            textView.setTextColor(ResUtils.getColor(getContext(), "wallet_base_click_text1_color_selector"));
        }
        TextView textView2 = this.h;
        if (textView2 != null) {
            textView2.setTextColor(ResUtils.getColor(getContext(), "wallet_base_click_text1_color_selector"));
        }
        TextView textView3 = this.g;
        if (textView3 != null) {
            textView3.setTextColor(ResUtils.getColor(getContext(), "wallet_base_click_text1_color_selector"));
        }
        TextView textView4 = this.mTitleCenterText;
        if (textView4 != null) {
            textView4.setTextColor(ResUtils.getColor(getContext(), "bd_wallet_black3"));
        }
        TextView textView5 = this.f1139o;
        if (textView5 != null) {
            textView5.setTextColor(ResUtils.getColor(getContext(), "wallet_base_click_text2color_selector"));
        }
        TextView textView6 = this.t;
        if (textView6 != null) {
            textView6.setTextColor(ResUtils.getColor(getContext(), "bd_wallet_text_999999"));
        }
    }

    public void setBottomSeperatorvisible(boolean z) {
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void setBubbleImageOnClickListener(View.OnClickListener onClickListener) {
        BubbleForSubMenu bubbleForSubMenu = this.w;
        if (bubbleForSubMenu != null) {
            bubbleForSubMenu.setOnClickListener(onClickListener);
        }
    }

    public int setCloseButtonVisibility(int i2) {
        int visibility = this.mClose.getVisibility();
        if (i2 == 0 || 8 == i2 || 4 == i2) {
            this.mClose.setVisibility(i2);
            if (i2 == 0) {
                this.mTitleCenterText.setMaxEms(ResUtils.getInteger(getContext(), "wallet_base_titlebar_centertext_maxems_1"));
            }
        }
        return visibility;
    }

    public void setCloseOnClickListener(View.OnClickListener onClickListener) {
        this.mClose.setOnClickListener(onClickListener);
    }

    public void setFullScreenTextColor(int i2) {
        TextView textView = this.f;
        if (textView != null) {
            textView.setTextColor(i2);
        }
        TextView textView2 = this.h;
        if (textView2 != null) {
            textView2.setTextColor(i2);
        }
        TextView textView3 = this.g;
        if (textView3 != null) {
            textView3.setTextColor(i2);
        }
        TextView textView4 = this.mTitleCenterText;
        if (textView4 != null) {
            textView4.setTextColor(i2);
        }
        TextView textView5 = this.f1139o;
        if (textView5 != null) {
            textView5.setTextColor(i2);
        }
        TextView textView6 = this.t;
        if (textView6 != null) {
            textView6.setTextColor(i2);
        }
    }

    public void setIconFlag(boolean z, boolean z2) {
        NetImageView netImageView;
        this.x = z;
        if (z) {
            setLeftZoneImageSrc(ResUtils.drawable(getContext(), "wallet_base_actionbar_white_back_arrow"));
            if (this.n.getVisibility() == 0) {
                setRightImgZone2Src(ResUtils.drawable(getContext(), "wallet_base_actionbar_white_more"));
            }
            this.f1138i.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_base_actionbar_clear_white_normal"));
            if (this.l.getVisibility() != 0 || z2) {
                NetImageView netImageView2 = this.l;
                if (!(netImageView2 == null || netImageView2.getDrawable() == null)) {
                    this.l.getDrawable().clearColorFilter();
                }
            } else {
                this.l.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
            }
        } else {
            setLeftZoneImageSrc(ResUtils.drawable(getContext(), "wallet_base_actionbar_back_arrow"));
            if (this.n.getVisibility() == 0) {
                setRightImgZone2Src(ResUtils.drawable(getContext(), "wallet_base_actionbar_more"));
            }
            this.f1138i.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_base_actionbar_clear_normal"));
            if (!(this.l.getVisibility() != 0 || (netImageView = this.l) == null || netImageView.getDrawable() == null)) {
                this.l.getDrawable().clearColorFilter();
            }
        }
        setTopStatusWhite(z);
    }

    public void setImgZoneBackgroundResource(int i2) {
        this.k.setBackgroundResource(i2);
        this.m.setBackgroundResource(i2);
    }

    public void setLeftImgZone2NotifyText(String str, float f2) {
        this.f.setVisibility(8);
        if (f2 >= 0.0f) {
            this.f.setText(str);
            this.f.setTextSize(1, f2);
        }
    }

    public void setLeftImgZone2NotifyTextColor(int i2) {
        this.f.setTextColor(i2);
    }

    public void setLeftImgZone2NotifyTextColorStateList(ColorStateList colorStateList) {
        this.f.setTextColor(colorStateList);
    }

    public void setLeftZoneImageSelected(boolean z) {
    }

    public void setLeftZoneImageSrc(int i2) {
        Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        this.e.setImageDrawable(drawable);
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.mLeftImgZone2.setOnClickListener(onClickListener);
    }

    public BdActionBar setOnlyIcons(boolean z) {
        return a(z ? 8 : 0);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.l.setEnabled(z);
        this.k.setEnabled(z);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.k.setOnClickListener(onClickListener);
    }

    public void setRightImgZone1Src(int i2) {
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.l.setImageResource(i2);
    }

    public void setRightImgZone1Visibility(int i2) {
        this.k.setVisibility(i2);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.n.setEnabled(z);
        this.m.setEnabled(z);
    }

    public void setRightImgZone2NotifyClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f1139o.setVisibility(0);
        }
        this.f1139o.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2NotifyText(String str) {
        if (!TextUtils.isEmpty(str)) {
            setRightImgZone2NotifyVisibility(0);
        }
        this.f1139o.setText(str);
    }

    public void setRightImgZone2NotifyTextBg(int i2) {
        this.f1139o.setBackgroundResource(i2);
        this.f1139o.setPadding(12, 6, 12, 6);
    }

    public void setRightImgZone2NotifyTextColor(int i2) {
        this.f1139o.setTextColor(i2);
    }

    public void setRightImgZone2NotifyTextSize(float f2) {
        this.f1139o.setTextSize(1, f2);
    }

    public void setRightImgZone2NotifyTextViewPadding(int i2, int i3, int i4, int i5) {
        this.f1139o.setPadding(i2, i3, i4, i5);
    }

    public void setRightImgZone2NotifyVisibility(int i2) {
        this.f1139o.setVisibility(i2);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.m.setVisibility(0);
        }
        this.m.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Src(int i2) {
        this.n.setVisibility(0);
        this.n.setImageResource(i2);
    }

    public void setRightImgZone2Visibility(int i2) {
        this.m.setVisibility(i2);
    }

    public void setRightNotifyImg(Drawable drawable) {
        this.r.setImageDrawable(drawable);
    }

    public void setRightNotifyText(String str) {
        this.q.setText(str);
    }

    public void setRightNotifyTextColor(int i2) {
        this.q.setTextColor(i2);
    }

    public void setRightNotifyTextSize(int i2) {
        this.q.setTextSize(1, (float) i2);
    }

    public void setRightNotifyZone1Bg(Drawable drawable) {
        this.p.setBackgroundDrawable(drawable);
    }

    public void setRightNotifyZone1ClickListener(View.OnClickListener onClickListener) {
        this.p.setOnClickListener(onClickListener);
    }

    public void setRightNotifyZone1Visibility(int i2) {
        this.p.setVisibility(i2);
    }

    public void setSafeIconVisible(boolean z) {
        if (z) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
    }

    public void setTitle(String str) {
        this.c = str;
        this.mTitleCenterText.setText(str);
        setTitleSize(getTitleSizeRange()[0]);
    }

    public void setTitleCenterSafeTipColor(int i2) {
        this.t.setTextColor(i2);
    }

    public void setTitleCenterSafeTipText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.s.setVisibility(8);
            return;
        }
        this.s.setVisibility(0);
        this.t.setText(str);
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
            int currentTextColor2 = this.t.getCurrentTextColor();
            this.t.setTextColor(Color.argb(i2, Color.red(currentTextColor2), Color.green(currentTextColor2), Color.blue(currentTextColor2)));
        } catch (Throwable unused) {
        }
    }

    public void setTitlebgColor(int i2) {
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(i2);
        }
    }

    public void setTop(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            if (activity == null) {
                activity = getContext() instanceof Activity ? (Activity) getContext() : null;
            }
            if (activity != null) {
                this.j.setLayoutParams(new RelativeLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(activity)));
                ImmersiveStatusBarManager.setTopBar(activity, this.j, true);
            }
        }
    }

    public void setTopStatusWhite(boolean z) {
        View view;
        if (Build.VERSION.SDK_INT >= 19) {
            Activity activity = null;
            if (getContext() instanceof Activity) {
                activity = (Activity) getContext();
            }
            if (activity != null && (view = this.j) != null) {
                ImmersiveStatusBarManager.setTopBar(activity, view, !z);
            }
        }
    }

    public void setbackBg(Drawable drawable) {
        this.mLeftImgZone2.setBackgroundDrawable(drawable);
    }

    public void showBubble(String str, int i2, boolean z, String str2) {
        this.y = z;
        if (this.w != null || TextUtils.isEmpty(str)) {
            LogUtil.d("bubble", "不展示气泡");
        } else {
            this.w = new BubbleForSubMenu(getContext(), z);
            ((RelativeLayout) findViewById(ResUtils.id(getContext(), "title_bar_content"))).addView(this.w);
        }
        BubbleForSubMenu bubbleForSubMenu = this.w;
        if (bubbleForSubMenu != null) {
            bubbleForSubMenu.showBubble(str, i2, z);
            DXMSdkSAUtils.onShowEvent(StatServiceEvent.EVENT_KEY_SET_SUBMENU_BUBBLE, Arrays.asList(new String[]{z ? "新样式" : "老样式", str2}));
        }
    }

    public void showLeftZone() {
        ViewUtils.visibleView(this.mLeftImgZone2);
    }

    public void showTitleFloatView(boolean z, boolean z2, String str) {
        if (!z) {
            try {
                removeTitleFloatView();
            } catch (Exception e2) {
                String str2 = TAG;
                LogUtil.d(str2, "Exception::" + e2);
            }
        } else {
            removeTitleFloatView();
            UnableClickView unableClickView = new UnableClickView(getContext());
            unableClickView.setId(ResUtils.id(getContext(), "view_click_able"));
            int titleHeight = getTitleHeight();
            this.d.addView(unableClickView, new RelativeLayout.LayoutParams(-1, getTitleHeight()));
            unableClickView.setViewClickable(z2);
            unableClickView.setBgColor(str);
            String str3 = TAG;
            LogUtil.d(str3, "titleHeight::" + titleHeight + "::clickable:: " + z2 + "::titleFloatViewColor" + str + "::allChild::" + this.d.getChildCount());
        }
    }

    public void setRightImgZone2Src(int i2, CharSequence charSequence) {
        setRightImgZone2Src(i2);
        AccessibilityUtils.setContentDescription(this.n, charSequence);
    }

    public void setLeftZoneImageSrc(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        this.e.setImageDrawable(drawable);
    }

    public void setRightImgZone1Src(String str) {
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.l.setImageUrl(str);
    }

    public void setTitle(int i2) {
        setTitle(getResources().getString(i2));
    }

    public BdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void setRightImgZone2Src(String str) {
        this.n.setVisibility(0);
        this.n.setImageUrl(str);
    }

    public BdActionBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private BdActionBar a(int i2) {
        if (i2 == 0 || 8 == i2) {
            this.f.setVisibility(8);
        }
        return this;
    }

    private void a(View view) {
        view.setVisibility(view.getVisibility() == 0 ? 8 : 0);
    }
}
