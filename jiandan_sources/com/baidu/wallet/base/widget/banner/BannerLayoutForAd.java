package com.baidu.wallet.base.widget.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;
import com.google.common.math.DoubleMath;
import java.util.List;

public class BannerLayoutForAd extends RelativeLayout {
    public BannerFocusImageViewGroup a;
    public LinearLayout b;
    public BannerBaseItemInfo[] c;
    public int d;
    public int e;

    public BannerLayoutForAd(Context context) {
        super(context);
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_banner_vip"), this);
        this.a = (BannerFocusImageViewGroup) findViewById(ResUtils.id(getContext(), "wallet_banner_gallery"));
        this.b = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_banner_indicators"));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
        int displayWidth = (DisplayUtils.getDisplayWidth(getContext()) - this.d) - this.e;
        int i2 = (displayWidth * DoubleMath.MAX_FACTORIAL) / 750;
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(displayWidth, i2);
        } else {
            layoutParams.width = displayWidth;
            layoutParams.height = i2;
        }
        this.a.setChildLeft(getPaddingLeft());
        this.a.setLayoutParams(layoutParams);
        this.a.setChildLeft(this.d);
        this.a.setCurrFocusImagePos(new BannerFocusImageViewGroup.CurrFocusImagePos() {
            public void setCurrPos(int i2, int i3) {
                int i4 = 0;
                while (i4 < i3) {
                    if (BannerLayoutForAd.this.b.getChildAt(i4) != null) {
                        BannerLayoutForAd.this.b.getChildAt(i4).setSelected(i4 == i2);
                    }
                    i4++;
                }
            }
        });
    }

    public boolean isDataValide() {
        BannerBaseItemInfo[] bannerBaseItemInfoArr = this.c;
        return bannerBaseItemInfoArr != null && bannerBaseItemInfoArr.length > 0;
    }

    public void refreshData() {
        this.a.setFocusConfigInfo(this.c, "");
        int drawable = ResUtils.drawable(getContext(), "wallet_base_indicators");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 7.0f), DisplayUtils.dip2px(getContext(), 2.0f));
        if (this.c.length > 1) {
            int i2 = 0;
            while (i2 < this.c.length) {
                View view = new View(getContext());
                view.setBackgroundResource(drawable);
                view.setSelected(i2 == 0);
                this.b.addView(view, layoutParams);
                layoutParams.leftMargin = DisplayUtils.dip2px(getContext(), 6.0f);
                i2++;
            }
            this.b.setVisibility(0);
            return;
        }
        this.b.setVisibility(8);
    }

    public void setConfigData(BannerBaseItemInfo[] bannerBaseItemInfoArr) {
        this.c = bannerBaseItemInfoArr;
        if (isDataValide()) {
            removeAllViews();
            initView();
            refreshData();
        }
    }

    public void setMaiDianData(String str, List<String> list) {
        BannerFocusImageViewGroup bannerFocusImageViewGroup = this.a;
        if (bannerFocusImageViewGroup != null) {
            bannerFocusImageViewGroup.setMaiDianDataKey(str);
        }
        if (list != null && list.size() > 0) {
            this.a.setMaindian_public_value(list);
        }
    }

    public void setMarginLeftAndRight(int i2, int i3) {
        this.d = i2;
        this.e = i3;
    }

    public BannerLayoutForAd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
