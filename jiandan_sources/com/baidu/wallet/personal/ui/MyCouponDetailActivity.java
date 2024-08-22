package com.baidu.wallet.personal.ui;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.WalletBaseEmptyView;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.personal.b.a;
import com.baidu.wallet.personal.beans.b;
import com.baidu.wallet.personal.beans.c;
import com.baidu.wallet.personal.datamodel.CouponDetailResponse;
import com.baidu.wallet.personal.ui.view.DiscolorScrollView;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class MyCouponDetailActivity extends CouponBaseActivity implements View.OnClickListener, DiscolorScrollView.a {
    public static final String BEAN_TAG = "MyCouponDetailActivity";
    public static long mCreateTime;
    public BdActionBar actionBar;
    public int cardType;
    public TextView copyBtn;
    public String couponNum;
    public ImageView invalidCouponImg;
    public ClipData mClipData;
    public ClipboardManager mClipboardManager;
    public RelativeLayout mCouponBgDown;
    public RelativeLayout mCouponBgUp;
    public NetImageView mCouponDetailBgpic;
    public TextView mCouponName;
    public TextView mCouponTitleDesc;
    public TextView mCouponTitleHead;
    public ImageView mDateDot;
    public TextView mDateMsg;
    public TextView mDateTips;
    public CouponDetailResponse mDetail;
    public LinearLayout mExchangeAScenceLayout;
    public TextView mMarketLabel;
    public WalletBaseEmptyView mReloadView;
    public TextView mScenceServiceView;
    public RelativeLayout mSceneServiceLayout;
    public DiscolorScrollView mScrollView;
    public TextView mSubTitile;
    public TextView mSubTitle1;
    public LinearLayout mSubTitleLayout1;
    public ImageView mTermDot;
    public ImageView mTermDot1;
    public TextView mTermTips;
    public LinearLayout mUseInfos;
    public boolean needRefresh = false;
    public String templateNum;

    private void configMarketLabel() {
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mMarketLabel.getLayoutParams();
        layoutParams.height = DisplayUtils.dip2px(this.mAct, 20.0f);
        this.mMarketLabel.setLayoutParams(layoutParams);
        int dip2px = DisplayUtils.dip2px(this.mAct, 4.0f);
        if (!TextUtils.isEmpty(this.mDetail.marketing_label)) {
            this.mMarketLabel.setText(this.mDetail.marketing_label.length() > 6 ? this.mDetail.marketing_label.substring(0, 6) : this.mDetail.marketing_label);
            this.mMarketLabel.setPadding(dip2px, 0, dip2px, 0);
            this.mMarketLabel.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.mDetail.marketing_label_bgpic)) {
            ImageLoader.getInstance(this.mAct).getBitmap(this.mDetail.marketing_label_bgpic, new ImageLoader.OnGetBitmapListener() {
                public boolean needCancel(String str, Object obj) {
                    return false;
                }

                public void onError(String str, Object obj) {
                }

                public void onGetBitmap(String str, Object obj, final Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    if (TextUtils.isEmpty(MyCouponDetailActivity.this.mDetail.marketing_label)) {
                        MyCouponDetailActivity.this.mMarketLabel.post(new Runnable() {
                            public void run() {
                                AnonymousClass5 r0 = AnonymousClass5.this;
                                layoutParams.width = DisplayUtils.dip2px(MyCouponDetailActivity.this.mAct, 65.0f);
                                AnonymousClass5 r02 = AnonymousClass5.this;
                                layoutParams.height = DisplayUtils.dip2px(MyCouponDetailActivity.this.mAct, 16.55f);
                                MyCouponDetailActivity.this.mMarketLabel.setLayoutParams(layoutParams);
                                MyCouponDetailActivity.this.mMarketLabel.setBackgroundDrawable(new BitmapDrawable(bitmap));
                                MyCouponDetailActivity.this.mMarketLabel.setVisibility(0);
                            }
                        });
                        return;
                    }
                    a aVar = new a(MyCouponDetailActivity.this.getResources(), bitmap);
                    aVar.a(bitmap.getWidth() / 2, 1).b(bitmap.getHeight() / 2, 1);
                    final NinePatchDrawable c = aVar.c();
                    if (c != null) {
                        MyCouponDetailActivity.this.mMarketLabel.post(new Runnable() {
                            public void run() {
                                MyCouponDetailActivity.this.mMarketLabel.setBackgroundDrawable(c);
                                MyCouponDetailActivity.this.mMarketLabel.setLayoutParams(layoutParams);
                                if (MyCouponDetailActivity.this.mMarketLabel.getVisibility() == 8) {
                                    MyCouponDetailActivity.this.mMarketLabel.setVisibility(0);
                                }
                            }
                        });
                    }
                }
            }, (Object) null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
        }
    }

    private GradientDrawable getDefaultGradientBg(int i2, int i3, GradientDrawable.Orientation orientation) {
        int[] iArr = {i2, i3};
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setOrientation(orientation);
            gradientDrawable.setColors(iArr);
            gradientDrawable.setSize(DisplayUtils.getDisplayWidth(this.mAct), DisplayUtils.dip2px(this.mAct, 195.0f));
        }
        return gradientDrawable;
    }

    private int getStatus(int i2) {
        switch (i2) {
            case 3:
            case 8:
            case 9:
            case 10:
                return 1;
            case 4:
                return 0;
            case 5:
            case 6:
            case 7:
                return 2;
            default:
                return -1;
        }
    }

    /* access modifiers changed from: private */
    public void queryDetail(boolean z) {
        DXMSdkSAUtils.onEventStart("CouponDetailRequest");
        if (getActivity() != null) {
            if (z) {
                WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
            }
            c cVar = (c) b.a().getBean(this.mAct, 516, BEAN_TAG);
            cVar.a(this.cardType);
            cVar.a(this.couponNum);
            cVar.b(this.templateNum);
            cVar.setResponseCallback(this);
            cVar.execBean();
        }
    }

    private void setDatas() {
        String str;
        TextView textView;
        String str2;
        TextView textView2;
        this.mScrollView.setVisibility(0);
        int a = com.baidu.wallet.personal.b.b.a((Context) this.mAct, this.mDetail.coupon_detail_btn_bg, "coupon_base_black_394259");
        if (!TextUtils.isEmpty(this.mDetail.coupon_detail_btn_bg)) {
            updateTitleBarColor(true);
        } else {
            updateTitleBarColor(false);
        }
        setDetailBgDefault();
        if (!TextUtils.isEmpty(this.mDetail.coupon_detail_bgpic)) {
            ImageLoader.getInstance(this.mAct).getBitmap(this.mDetail.coupon_detail_bgpic, new ImageLoader.OnGetBitmapListener() {
                public boolean needCancel(String str, Object obj) {
                    return false;
                }

                public void onError(String str, Object obj) {
                }

                public void onGetBitmap(String str, Object obj, final Bitmap bitmap) {
                    if (bitmap != null) {
                        MyCouponDetailActivity.this.mCouponDetailBgpic.post(new Runnable() {
                            public void run() {
                                MyCouponDetailActivity.this.mCouponDetailBgpic.setImageDrawable(new BitmapDrawable(bitmap));
                            }
                        });
                    }
                }
            }, (Object) null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCouponName.getLayoutParams();
        layoutParams.topMargin = DisplayUtils.dip2px(this.mAct, 37.0f);
        this.mCouponName.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(this.mDetail.coupon_name)) {
            textView = this.mCouponName;
            str = this.mDetail.coupon_name;
        } else {
            textView = this.mCouponName;
            str = ResUtils.getString(this.mAct, "wallet_personal_coupon_logo_title");
        }
        textView.setText(str);
        if (Build.VERSION.SDK_INT >= 16) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mCouponBgUp.getLayoutParams();
            layoutParams2.topMargin = DisplayUtils.dip2px(this.mAct, 77.0f);
            layoutParams2.height = DisplayUtils.dip2px(this.mAct, 100.5f);
            this.mCouponBgUp.setLayoutParams(layoutParams2);
        }
        if (!TextUtils.isEmpty(this.mDetail.coupon_detail_bgpic_up)) {
            ImageLoader.getInstance(this.mAct).getBitmap(this.mDetail.coupon_detail_bgpic_up, new ImageLoader.OnGetBitmapListener() {
                public boolean needCancel(String str, Object obj) {
                    return false;
                }

                public void onError(String str, Object obj) {
                }

                public void onGetBitmap(String str, Object obj, final Bitmap bitmap) {
                    if (bitmap != null) {
                        MyCouponDetailActivity.this.mCouponBgUp.post(new Runnable() {
                            public void run() {
                                MyCouponDetailActivity.this.mCouponBgUp.setBackgroundDrawable(new BitmapDrawable(MyCouponDetailActivity.this.getResources(), bitmap));
                            }
                        });
                    }
                }
            }, (Object) null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
        }
        if (!TextUtils.isEmpty(this.mDetail.coupon_detail_bgpic_down)) {
            ImageLoader.getInstance(this.mAct).getBitmap(this.mDetail.coupon_detail_bgpic_down, new ImageLoader.OnGetBitmapListener() {
                public boolean needCancel(String str, Object obj) {
                    return false;
                }

                public void onError(String str, Object obj) {
                }

                public void onGetBitmap(String str, Object obj, Bitmap bitmap) {
                    if (bitmap != null) {
                        a aVar = new a(MyCouponDetailActivity.this.getResources(), bitmap);
                        aVar.b(13, 1);
                        final NinePatchDrawable c = aVar.c();
                        MyCouponDetailActivity.this.mCouponBgDown.post(new Runnable() {
                            public void run() {
                                if (Build.VERSION.SDK_INT >= 16) {
                                    MyCouponDetailActivity.this.mCouponBgDown.setBackground(c);
                                } else {
                                    MyCouponDetailActivity.this.mCouponBgDown.setBackgroundDrawable(c);
                                }
                            }
                        });
                    }
                }
            }, (Object) null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
        }
        configMarketLabel();
        if (!TextUtils.isEmpty(this.mDetail.coupon_title_head)) {
            this.mCouponTitleHead.setText(this.mDetail.coupon_title_head);
            this.mCouponTitleHead.setVisibility(0);
            this.mCouponTitleHead.setTextColor(com.baidu.wallet.personal.b.b.a((Context) this.mAct, this.mDetail.coupon_list_show_formwork));
        } else {
            this.mCouponTitleHead.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mDetail.coupon_title_desc)) {
            this.mCouponTitleDesc.setText(this.mDetail.coupon_title_desc);
            this.mCouponTitleDesc.setVisibility(0);
        } else {
            this.mCouponTitleDesc.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mDetail.date_message)) {
            Drawable[] compoundDrawables = this.mDateTips.getCompoundDrawables();
            if (!TextUtils.isEmpty(this.mDetail.coupon_detail_btn_bg)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.mDateDot.getDrawable().setTint(a);
                    if (!(compoundDrawables == null || compoundDrawables[0] == null)) {
                        compoundDrawables[0].setTint(a);
                    }
                }
                this.mDateTips.setTextColor(a);
            }
            this.mDateTips.setVisibility(0);
            this.mDateDot.setVisibility(0);
            this.mDateMsg.setText(this.mDetail.date_message);
        } else {
            this.mDateTips.setVisibility(8);
            this.mDateDot.setVisibility(8);
            this.mDateMsg.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mDetail.sub_title)) {
            Drawable[] compoundDrawables2 = this.mTermTips.getCompoundDrawables();
            if (!TextUtils.isEmpty(this.mDetail.coupon_detail_btn_bg)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.mTermDot.getDrawable().setTint(a);
                    if (!(compoundDrawables2 == null || compoundDrawables2[0] == null)) {
                        compoundDrawables2[0].setTint(a);
                    }
                }
                this.mTermTips.setTextColor(a);
            }
            this.mTermTips.setVisibility(0);
            this.mTermDot.setVisibility(0);
            this.mSubTitile.setVisibility(0);
            this.mSubTitile.setText(this.mDetail.sub_title);
        } else {
            this.mTermTips.setVisibility(8);
            this.mTermDot.setVisibility(8);
            this.mSubTitile.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mDetail.sub_title2)) {
            if (!TextUtils.isEmpty(this.mDetail.coupon_detail_btn_bg) && Build.VERSION.SDK_INT >= 21) {
                this.mTermDot1.getDrawable().setTint(a);
            }
            this.mTermDot1.setVisibility(0);
            this.mSubTitle1.setText(this.mDetail.sub_title2);
            this.mSubTitle1.setVisibility(0);
        } else {
            this.mSubTitleLayout1.setVisibility(8);
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "coupon_detail_exchange"));
        if (!TextUtils.isEmpty(this.mDetail.display_coupon_num)) {
            relativeLayout.setVisibility(0);
            ((TextView) findViewById(ResUtils.id(this.mAct, "other_coupon_detail_scene_service_label"))).setText(this.mDetail.display_coupon_num);
            TextView textView3 = (TextView) findViewById(ResUtils.id(this.mAct, "other_coupon_detail_btn_copy"));
            this.copyBtn = textView3;
            if (this.mDetail.status != 2) {
                textView3.setTextColor(ResUtils.getColor(this.mAct, "wallet_invalid_coupon_detail_D7D7D7"));
                this.copyBtn.setClickable(false);
            } else {
                textView3.setOnClickListener(this);
            }
        } else {
            relativeLayout.setVisibility(8);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("coupon_name", this.mDetail.coupon_name);
            jSONObject.put("template_num", this.mDetail.template_num);
            jSONObject.put("coupon_num", this.mDetail.coupon_num);
            jSONObject.put(StatHelper.CARD_TYPE, this.cardType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        DXMSdkSAUtils.onEventWithValues("CouponDetailPageShow", Arrays.asList(new String[]{jSONObject.toString()}));
        this.mSceneServiceLayout = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "coupon_detail_btn"));
        this.mScenceServiceView = (TextView) findViewById(ResUtils.id(this.mAct, "coupon_detail_scene_service_label1"));
        if (!TextUtils.isEmpty(this.mDetail.scene_service) || this.mDetail.app_scene_service != null) {
            this.mSceneServiceLayout.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 21) {
                RelativeLayout relativeLayout2 = this.mSceneServiceLayout;
                BeanActivity beanActivity = this.mAct;
                relativeLayout2.setBackground(com.baidu.wallet.personal.b.b.a(beanActivity, a, 0, (float) DisplayUtils.dip2px(beanActivity, 100.0f)));
            }
            if (!TextUtils.isEmpty(this.mDetail.scene_service_label)) {
                textView2 = this.mScenceServiceView;
                str2 = this.mDetail.scene_service_label;
            } else {
                textView2 = this.mScenceServiceView;
                str2 = ResUtils.getString(this.mAct, "wallet_personal_coupon_detail_btn_txt");
            }
            textView2.setText(str2);
            this.mScenceServiceView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    BaiduWalletDelegate baiduWalletDelegate;
                    BeanActivity beanActivity;
                    String str;
                    if (!CheckUtils.isFastDoubleClick()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("coupon_name", MyCouponDetailActivity.this.mDetail.coupon_name);
                            jSONObject.put("template_num", MyCouponDetailActivity.this.mDetail.template_num);
                            jSONObject.put("coupon_num", MyCouponDetailActivity.this.mDetail.coupon_num);
                            jSONObject.put(StatHelper.CARD_TYPE, MyCouponDetailActivity.this.cardType);
                            jSONObject.put("coupon_touse_clicktime", System.currentTimeMillis() - MyCouponDetailActivity.mCreateTime);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        DXMSdkSAUtils.onEventWithValues("CouponDetailToUseBtnClick", Arrays.asList(new String[]{jSONObject.toString(), MyCouponDetailActivity.this.mDetail.template_coupon_type + "", MyCouponDetailActivity.this.mDetail.status + ""}));
                        if (MyCouponDetailActivity.this.mDetail.app_scene_service != null) {
                            if (MyCouponDetailActivity.this.mDetail.app_scene_service.f3643android > 0) {
                                boolean unused = MyCouponDetailActivity.this.needRefresh = true;
                                BaiduWalletServiceController instance = BaiduWalletServiceController.getInstance();
                                MyCouponDetailActivity myCouponDetailActivity = MyCouponDetailActivity.this;
                                instance.gotoWalletService((Context) myCouponDetailActivity.mAct, (long) myCouponDetailActivity.mDetail.app_scene_service.f3643android, "");
                                return;
                            } else if (!TextUtils.isEmpty(MyCouponDetailActivity.this.mDetail.app_scene_service.url)) {
                                boolean unused2 = MyCouponDetailActivity.this.needRefresh = true;
                                baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                                MyCouponDetailActivity myCouponDetailActivity2 = MyCouponDetailActivity.this;
                                beanActivity = myCouponDetailActivity2.mAct;
                                str = myCouponDetailActivity2.mDetail.app_scene_service.url;
                            } else {
                                return;
                            }
                        } else if (!TextUtils.isEmpty(MyCouponDetailActivity.this.mDetail.scene_service)) {
                            boolean unused3 = MyCouponDetailActivity.this.needRefresh = true;
                            baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                            MyCouponDetailActivity myCouponDetailActivity3 = MyCouponDetailActivity.this;
                            beanActivity = myCouponDetailActivity3.mAct;
                            str = myCouponDetailActivity3.mDetail.scene_service;
                        } else {
                            return;
                        }
                        baiduWalletDelegate.openH5Module(beanActivity, str, true);
                    }
                }
            });
        } else {
            this.mSceneServiceLayout.setVisibility(8);
        }
        if (relativeLayout.getVisibility() == 0 || this.mSceneServiceLayout.getVisibility() == 0) {
            this.mExchangeAScenceLayout.setVisibility(0);
        }
        this.invalidCouponImg = (ImageView) findViewById(ResUtils.id(this.mAct, "coupocoupon_use_imgn_use_img"));
        setStatusImage(getStatus(this.mDetail.status));
        showDetails();
        showDxmLogo();
    }

    private void setDetailBgDefault() {
        if (!TextUtils.isEmpty(this.mDetail.coupon_detail_btn_bg) && Build.VERSION.SDK_INT >= 16) {
            this.mCouponDetailBgpic.setImageDrawable(getDefaultGradientBg(com.baidu.wallet.personal.b.b.a((Context) this.mAct, this.mDetail.coupon_detail_btn_bg, "coupon_base_black_394259"), ResUtils.getColor(this.mAct, "coupon_base_white_f7f8fa"), GradientDrawable.Orientation.TOP_BOTTOM));
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCouponDetailBgpic.getLayoutParams();
        layoutParams.height = DisplayUtils.dip2px(this.mAct, 195.0f);
        this.mCouponDetailBgpic.setLayoutParams(layoutParams);
    }

    private void setStatusImage(int i2) {
        ImageView imageView;
        ImageView imageView2;
        String str;
        BeanActivity beanActivity;
        int i3 = 0;
        if (i2 != 0) {
            if (i2 == 1) {
                imageView2 = this.invalidCouponImg;
                beanActivity = this.mAct;
                str = "wallet_personal_coupon_used";
                imageView2.setImageDrawable(ResUtils.getDrawable(beanActivity, str));
                imageView = this.invalidCouponImg;
                imageView.setVisibility(i3);
            } else if (i2 != 2) {
                imageView = this.invalidCouponImg;
                i3 = 8;
                imageView.setVisibility(i3);
            }
        }
        imageView2 = this.invalidCouponImg;
        beanActivity = this.mAct;
        str = "wallet_personal_coupon_expired";
        imageView2.setImageDrawable(ResUtils.getDrawable(beanActivity, str));
        imageView = this.invalidCouponImg;
        imageView.setVisibility(i3);
    }

    private void showDetails() {
        LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(this.mAct, "coupon_detail_use_limit_detail"));
        this.mUseInfos = linearLayout;
        linearLayout.removeAllViews();
        CouponDetailResponse couponDetailResponse = this.mDetail;
        if (couponDetailResponse != null && couponDetailResponse.detail.length > 0) {
            int i2 = 0;
            while (true) {
                CouponDetailResponse.Detail[] detailArr = this.mDetail.detail;
                if (i2 < detailArr.length) {
                    CouponDetailResponse.Detail detail = detailArr[i2];
                    if (detail != null && !TextUtils.isEmpty(detail.name) && !TextUtils.isEmpty(detail.value)) {
                        BeanActivity beanActivity = this.mAct;
                        View inflate = View.inflate(beanActivity, ResUtils.layout(beanActivity, "wallet_personal_coupon_detail_use_info_layout"), (ViewGroup) null);
                        if (i2 == 0) {
                            inflate.findViewById(ResUtils.id(this.mAct, "use_info_margin")).setVisibility(8);
                        }
                        TextView textView = (TextView) inflate.findViewById(ResUtils.id(this.mAct, "detail_name"));
                        if (textView != null) {
                            textView.setText(detail.name);
                        }
                        TextView textView2 = (TextView) inflate.findViewById(ResUtils.id(this.mAct, "detail_infos"));
                        if (textView2 != null) {
                            textView2.setText(Html.fromHtml(detail.value));
                        }
                        this.mUseInfos.addView(inflate);
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    private void showDxmLogo() {
        final ImageView imageView = (ImageView) findViewById(ResUtils.id(this.mAct, "detail_dxm_logo"));
        imageView.post(new Runnable() {
            public void run() {
                int dip2px = DisplayUtils.dip2px(MyCouponDetailActivity.this.mAct, 30.0f);
                DisplayUtils.getDisplayHeight(MyCouponDetailActivity.this.mAct);
                int height = imageView.getHeight();
                int dip2px2 = DisplayUtils.dip2px(MyCouponDetailActivity.this.mAct, 60.0f);
                int height2 = MyCouponDetailActivity.this.mScrollView.getHeight();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams.topMargin = ((height2 - MyCouponDetailActivity.this.mUseInfos.getBottom()) - dip2px) - height > dip2px2 ? (height2 - height) - dip2px : MyCouponDetailActivity.this.mUseInfos.getBottom() + dip2px2;
                layoutParams.bottomMargin = dip2px;
                imageView.setLayoutParams(layoutParams);
            }
        });
    }

    private void showEmptyView() {
        this.mReloadView.setVisibility(0);
        this.mReloadView.showTip1_Tip2_NextBtn(ResUtils.drawable(this.mAct, "wallet_base_no_net"), ResUtils.getString(this.mAct, "wallet_base_no_network"), ResUtils.getString(this.mAct, "wallet_base_no_network_reason"), ResUtils.getString(getActivity(), "bd_wallet_reload"), new WalletBaseEmptyView.EmptyBtnClickListener() {
            public void onBtnClick() {
                MyCouponDetailActivity.this.queryDetail(true);
            }
        });
    }

    private void updateTitleBarColor(boolean z) {
        BdActionBar bdActionBar;
        Drawable drawable;
        if (z) {
            try {
                this.actionBar.setTitlebgColor(Color.parseColor(this.mDetail.coupon_detail_btn_bg));
                this.actionBar.setTitleColor(-1);
                bdActionBar = this.actionBar;
                drawable = ResUtils.getDrawable(this.mAct, "wallet_base_actionbar_white_back_arrow");
            } catch (Exception unused) {
                this.actionBar.setTitlebgColor(-1);
                this.actionBar.setTitleColor(ResUtils.getColor(this.mAct, "bd_wallet_black3"));
                this.actionBar.setLeftZoneImageSrc(ResUtils.getDrawable(this.mAct, "wallet_base_actionbar_back_arrow"));
                return;
            }
        } else {
            this.actionBar.setTitlebgColor(-1);
            this.actionBar.setTitleColor(ResUtils.getColor(this.mAct, "bd_wallet_black3"));
            bdActionBar = this.actionBar;
            drawable = ResUtils.getDrawable(this.mAct, "wallet_base_actionbar_back_arrow");
        }
        bdActionBar.setLeftZoneImageSrc(drawable);
    }

    public void handleFailure(int i2, int i3, String str) {
        DXMSdkSAUtils.onEventEnd("CouponDetailRequest", 1);
        BeanActivity beanActivity = this.mAct;
        if (beanActivity != null) {
            WalletGlobalUtils.safeDismissDialog(beanActivity, -1);
            if (i3 == 5003) {
                LogUtil.d(BEAN_TAG, "没有登陆");
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "wallet_base_please_login"));
                WalletLoginHelper.getInstance().logout(false);
                finish();
                return;
            }
            showEmptyView();
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        DXMSdkSAUtils.onEventEnd("CouponDetailRequest", 0);
        BeanActivity beanActivity = this.mAct;
        if (beanActivity != null) {
            WalletGlobalUtils.safeDismissDialog(beanActivity, -1);
            if (i2 == 516) {
                this.mReloadView.setVisibility(8);
                CouponDetailResponse couponDetailResponse = (CouponDetailResponse) obj;
                this.mDetail = couponDetailResponse;
                if (couponDetailResponse != null) {
                    initView();
                    setDatas();
                    return;
                }
                GlobalUtils.toast(this.mAct, ResUtils.getString(this.mAct, "bd_wallet_coupon_detail_fail"));
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void initView() {
        DiscolorScrollView discolorScrollView = (DiscolorScrollView) findViewById(ResUtils.id(this.mAct, "coupon_detail_scroolview"));
        this.mScrollView = discolorScrollView;
        discolorScrollView.setScrollViewListener(this);
        this.mCouponName = (TextView) findViewById(ResUtils.id(this.mAct, "coupon_name"));
        this.mCouponDetailBgpic = (NetImageView) findViewById(ResUtils.id(this.mAct, "coupon_detail_bgpic"));
        this.mCouponBgUp = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "coupon_detail_bgpic_up"));
        this.mMarketLabel = (TextView) findViewById(ResUtils.id(this.mAct, "detail_marketing_label"));
        this.mCouponTitleHead = (TextView) findViewById(ResUtils.id(this.mAct, "detail_coupon_title_head"));
        this.mCouponTitleDesc = (TextView) findViewById(ResUtils.id(this.mAct, "detail_coupon_title_desc"));
        this.mCouponBgDown = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "coupon_detail_bgpic_down"));
        this.mDateMsg = (TextView) findViewById(ResUtils.id(this.mAct, "detail_date_message"));
        this.mDateTips = (TextView) findViewById(ResUtils.id(this.mAct, "date_tip_title"));
        this.mDateDot = (ImageView) findViewById(ResUtils.id(this.mAct, "date_tip_dot"));
        this.mTermTips = (TextView) findViewById(ResUtils.id(this.mAct, "sub_title_tip_title"));
        this.mTermDot = (ImageView) findViewById(ResUtils.id(this.mAct, "sub_title_tip_dot"));
        this.mSubTitile = (TextView) findViewById(ResUtils.id(this.mAct, "sub_title"));
        this.mTermDot1 = (ImageView) findViewById(ResUtils.id(this.mAct, "sub_title_tip_dot2"));
        this.mSubTitle1 = (TextView) findViewById(ResUtils.id(this.mAct, "sub_title2"));
        this.mExchangeAScenceLayout = (LinearLayout) findViewById(ResUtils.id(this.mAct, "exchange_and_scence_layout"));
        this.mSubTitleLayout1 = (LinearLayout) findViewById(ResUtils.id(this.mAct, "sub_title2_layout"));
    }

    public void onBackPressed() {
        finish();
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mDetail != null) {
                jSONObject.put("coupon_name", this.mDetail.coupon_name);
                jSONObject.put("template_num", this.mDetail.template_num);
                jSONObject.put("coupon_num", this.mDetail.coupon_num);
            }
            jSONObject.put(StatHelper.CARD_TYPE, this.cardType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        DXMSdkSAUtils.onEventWithValues(DXMSdkSAUtils.SDK_EVENT_CLICK, "CouponDetailPageBack", Arrays.asList(new String[]{jSONObject.toString()}));
        super.onBackPressed();
    }

    public void onClick(View view) {
        if (view == this.copyBtn && Build.VERSION.SDK_INT >= 11) {
            this.mClipboardManager = (ClipboardManager) getSystemService("clipboard");
            ClipData newPlainText = ClipData.newPlainText(ResUtils.getString(this.mAct, "wallet_personal_coupon_detail_copy_lable"), this.mDetail.display_coupon_num);
            this.mClipData = newPlainText;
            this.mClipboardManager.setPrimaryClip(newPlainText);
            BeanActivity beanActivity = this.mAct;
            GlobalUtils.toast(beanActivity, ResUtils.getString(beanActivity, "wallet_personal_coupon_detail_copy_success"));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(this.mAct, "wallet_personal_coupon_detail1"));
        Intent intent = getIntent();
        if (intent != null) {
            this.cardType = intent.getIntExtra("cardType", 0);
            this.couponNum = intent.getStringExtra("couponNum");
            this.templateNum = intent.getStringExtra("templateNum");
        }
        initActionBar("bd_wallet_coupon_detail");
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(this.mAct, "bdactionbar"));
        this.actionBar = bdActionBar;
        bdActionBar.setBottomSeperatorvisible(false);
        this.mReloadView = (WalletBaseEmptyView) findViewById(ResUtils.id(this.mAct, "wallet_personal_reload_view"));
        queryDetail(true);
        mCreateTime = System.currentTimeMillis();
        setResult(0);
    }

    public void onDestroy() {
        BeanManager.getInstance().removeAllBeans(BEAN_TAG);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.needRefresh) {
            queryDetail(true);
            this.needRefresh = false;
        }
    }

    public void onScrollChanged(DiscolorScrollView discolorScrollView, int i2, int i3, int i4, int i5) {
        BdActionBar bdActionBar = this.actionBar;
        if (i3 - (bdActionBar != null ? bdActionBar.getBottom() : 0) > DisplayUtils.dip2px(this.mAct, 30.0f)) {
            updateTitleBarColor(false);
        } else {
            updateTitleBarColor(true);
        }
    }
}
