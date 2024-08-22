package com.baidu.wallet.personal.ui.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;
import com.baidu.wallet.personal.a.a;
import com.baidu.wallet.personal.datamodel.BannerList;
import com.baidu.wallet.personal.datamodel.CouponList;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class e implements a.b<CouponList.Coupon> {
    public View a;
    public BannerFocusImageViewGroup b;
    public LinearLayout c;

    public void a(int i2, CouponList.Coupon coupon) {
        BannerList[] bannerListArr;
        if (!(coupon == null || (bannerListArr = coupon.bannerLists) == null || bannerListArr.length <= 0)) {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            int i3 = 0;
            while (true) {
                BannerList[] bannerListArr2 = coupon.bannerLists;
                if (i3 >= bannerListArr2.length) {
                    break;
                }
                try {
                    arrayList.add(bannerListArr2[i3].getBanner_no());
                    jSONObject.put("bannerids", arrayList.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i3++;
            }
            DXMSdkSAUtils.onEventWithValues("CouponList_show_Banner", Arrays.asList(new String[]{jSONObject.toString()}));
        }
        this.b.setMaiDianDataKey("CouponList_clickBanner");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("");
        this.b.setMaindian_public_value(arrayList2);
        this.b.setFocusConfigInfo(coupon.bannerLists, "");
        int drawable = ResUtils.drawable(this.a.getContext(), "wallet_personal_banner_indicators");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dip2px(this.a.getContext(), 9.0f), DisplayUtils.dip2px(this.a.getContext(), 2.0f));
        if (coupon.bannerLists.length > 1) {
            int i4 = 0;
            while (i4 < coupon.bannerLists.length) {
                View view = new View(this.a.getContext());
                view.setBackgroundResource(drawable);
                view.setSelected(i4 == 0);
                this.c.addView(view, layoutParams);
                layoutParams.leftMargin = DisplayUtils.dip2px(this.a.getContext(), 4.0f);
                i4++;
            }
            this.c.setVisibility(0);
            return;
        }
        this.c.setVisibility(8);
    }

    public void a(View view) {
        this.a = view;
        BannerFocusImageViewGroup bannerFocusImageViewGroup = (BannerFocusImageViewGroup) view.findViewById(ResUtils.id(view.getContext(), "wallet_banner_gallery"));
        this.b = bannerFocusImageViewGroup;
        bannerFocusImageViewGroup.setDelayTimer(5000);
        View view2 = this.a;
        this.c = (LinearLayout) view2.findViewById(ResUtils.id(view2.getContext(), "wallet_banner_indicators"));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        int displayWidth = DisplayUtils.getDisplayWidth(this.a.getContext());
        int i2 = (displayWidth * 150) / 750;
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(displayWidth, i2);
        } else {
            layoutParams.width = displayWidth;
            layoutParams.height = i2;
        }
        this.b.setLayoutParams(layoutParams);
        this.b.setCurrFocusImagePos(new BannerFocusImageViewGroup.CurrFocusImagePos() {
            public void setCurrPos(int i2, int i3) {
                int i4 = 0;
                while (i4 < i3) {
                    if (e.this.c.getChildAt(i4) != null) {
                        e.this.c.getChildAt(i4).setSelected(i4 == i2);
                    }
                    i4++;
                }
            }
        });
    }

    public void a(boolean z) {
    }

    public void b(boolean z) {
    }

    public void c(boolean z) {
    }
}
