package com.baidu.wallet.personal.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.personal.ui.UnuseCouponListFragment;
import java.util.Arrays;
import java.util.HashMap;

public class CouponTabHostView extends CouponFragmentTabHost {
    public static final String b = CouponTabHostView.class.getSimpleName();
    public View a;
    public String c;
    public boolean d = false;
    public HashMap<Object, View> e;
    public HashMap<Object, ImageView> f;
    public final HashMap<String, TabHost.OnTabChangeListener> g = new HashMap<>();
    public final HashMap<String, b> h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public ImageView f3646i;
    public int j = 0;

    public static class Indicator extends RelativeLayout {
        public a a;

        public Indicator(Context context) {
            super(context);
            a(context);
        }

        public Indicator(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            a(context);
        }

        public Indicator(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            a(context);
        }

        private void a(Context context) {
            a aVar = new a();
            this.a = aVar;
            super.setOnClickListener(aVar);
        }

        public void a(CouponTabHostView couponTabHostView, String str) {
            a aVar = this.a;
            aVar.c = couponTabHostView;
            aVar.b = str;
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.a.a = onClickListener;
        }
    }

    public static class a implements View.OnClickListener {
        public View.OnClickListener a;
        public String b;
        public CouponTabHostView c;

        public void onClick(View view) {
            CouponTabHostView couponTabHostView;
            b bVar;
            if (!(this.b == null || view == null || view.getContext() == null || !this.b.equals(UnuseCouponListFragment.FRAGMENT_ID))) {
                DXMSdkSAUtils.onEventWithValues("CouponTabClick", Arrays.asList(new String[]{"unusedtab"}));
            }
            if (!(this.b == null || (couponTabHostView = this.c) == null || (bVar = (b) couponTabHostView.h.get(this.b)) == null)) {
                bVar.a(view, this.b, this.c.getCurrentTabTag());
            }
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public interface b {
        void a(View view, String str, String str2);
    }

    public CouponTabHostView(Context context) {
        super(context);
        a();
    }

    public CouponTabHostView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private View a(String str, String str2) {
        LayoutInflater from = LayoutInflater.from(getContext());
        Indicator indicator = new Indicator(getContext());
        indicator.a(this, str2);
        indicator.setGravity(17);
        View inflate = from.inflate(ResUtils.layout(getContext(), "wallet_personal_coupon_tabhost_item"), indicator, true);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        if (!TextUtils.isEmpty(str)) {
            ((TextView) inflate.findViewById(ResUtils.id(getContext(), "coupon_tab_item_textview"))).setText(str);
        } else {
            inflate.findViewById(ResUtils.id(getContext(), "coupon_tab_item_textview")).setVisibility(8);
        }
        inflate.setTag(str2);
        this.e.put(str2, inflate);
        ImageView imageView = (ImageView) inflate.findViewById(ResUtils.id(getContext(), "coupon_tab_red_indicator"));
        if (imageView != null) {
            imageView.setTag(str2);
        }
        this.f.put(str2, imageView);
        return inflate;
    }

    private void a(int i2) {
        if (this.f3646i != null) {
            TranslateAnimation translateAnimation = new TranslateAnimation((float) (this.j * (DisplayUtils.getDisplayWidth(getContext()) / 3)), (float) ((DisplayUtils.getDisplayWidth(getContext()) / 3) * i2), 0.0f, 0.0f);
            translateAnimation.setDuration(400);
            translateAnimation.setFillAfter(true);
            this.f3646i.setAnimation(translateAnimation);
            this.f3646i.startAnimation(translateAnimation);
            this.j = i2;
        }
    }

    private void b() {
        ImageView imageView = this.f3646i;
        if (imageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.leftMargin = (DisplayUtils.getDisplayWidth(getContext()) / 6) - (layoutParams.width / 2);
            layoutParams.topMargin = -5;
            this.f3646i.setLayoutParams(layoutParams);
        }
    }

    public Fragment a(FragmentManager fragmentManager, String str) {
        return fragmentManager.findFragmentByTag(str);
    }

    public void a() {
        this.e = new HashMap<>();
        this.f = new HashMap<>();
    }

    public void a(FragmentManager fragmentManager) {
        a(getContext(), fragmentManager, ResUtils.id(getContext(), "coupon_tab_content"));
        a(UnuseCouponListFragment.FRAGMENT_ID, UnuseCouponListFragment.class, 0, "未使用", 0);
        b();
        setCurrentTab(0);
    }

    public void a(String str, Class<?> cls, int i2, String str2, int i3) {
        TabHost.TabSpec newTabSpec = newTabSpec(str);
        newTabSpec.setIndicator(a(str2, str));
        a(newTabSpec, cls, (Bundle) null, i3);
    }

    public boolean a(String str) {
        return TextUtils.equals(getCurrentTabTag(), str);
    }

    public void b(String str) {
        if (!a(str)) {
            setCurrentTabByTag(str);
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.a = findViewById(ResUtils.id(getContext(), "coupon_full_content"));
        if (this.f3646i == null) {
            this.f3646i = (ImageView) findViewById(ResUtils.id(getContext(), "tab_line"));
        }
    }

    public void onTabChanged(String str) {
        super.onTabChanged(str);
        TabHost.OnTabChangeListener onTabChangeListener = this.g.get(str);
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
        View currentTabView = getCurrentTabView();
        if (currentTabView != null) {
            currentTabView.setFocusable(false);
        }
        a(getCurrentTab());
    }

    public void requestChildFocus(View view, View view2) {
        if (getVisibility() == 0) {
            super.requestChildFocus(view, view2);
        }
    }

    public void setNextSelectedTab(String str) {
        if (this.d) {
            b(str);
        } else {
            this.c = str;
        }
    }

    public void setTabByTag(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, getCurrentTabTag())) {
            setCurrentTabByTag(str);
        }
    }
}
