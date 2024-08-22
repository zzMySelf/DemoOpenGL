package com.baidu.android.lbspay.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.android.lbspay.view.LbsPayRadioGroup;
import com.baidu.android.lbspay.view.PayChannelController;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
import java.util.ArrayList;
import java.util.List;

public class ChannelListView extends LinearLayout {
    public List<NewCashierContent.CashierChannel> iBaseChannels = new ArrayList();
    public List<NewCashierContent.CashierChannel> iOfficialChannels = new ArrayList();
    public View mBannerView;
    public ImageView mCommonMarketLine;
    public Context mContext;
    public PayChannelController.GetPayModeListener mGetPayModeListener;
    public PayChannelController.SelectChannelListener mSelectChannelListener;
    public PayChannelController.DoShowAllChannelClick mShowAllChannelClick;
    public LbsPayRadioGroup radioGroupChannels;
    public ViewGroup vgMoreChannels;

    public ChannelListView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private View getNormalGroupView(String str, Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 19;
        TextView textView = new TextView(context);
        textView.setTextSize(0, ResUtils.getDimension(context, "lbspay_textsize_12"));
        textView.setTextColor(ResUtils.getColor(context, "lbspay_color_aaaaaa"));
        textView.setLayoutParams(layoutParams);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(DisplayUtils.dip2px(context, 15.0f), DisplayUtils.dip2px(context, 30.0f), DisplayUtils.dip2px(context, 15.0f), DisplayUtils.dip2px(context, 7.0f));
        textView.setText(str);
        return textView;
    }

    private View getOtherGroupView(String str, boolean z) {
        View inflate = LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_juhe_channel_showall"), (ViewGroup) null);
        final ViewGroup viewGroup = (ViewGroup) inflate.findViewById(ResUtils.id(getContext(), "show_all"));
        ((TextView) inflate.findViewById(ResUtils.id(getContext(), "group_desc"))).setText(str);
        if (z) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
        viewGroup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                viewGroup.setVisibility(4);
                if (ChannelListView.this.radioGroupChannels != null) {
                    ChannelListView.this.radioGroupChannels.showAllChannels();
                }
                PayChannelController.DoShowAllChannelClick doShowAllChannelClick = ChannelListView.this.mShowAllChannelClick;
                if (doShowAllChannelClick != null) {
                    doShowAllChannelClick.doClick();
                }
            }
        });
        return inflate;
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_juhe_customview_channel_list"), this);
        this.vgMoreChannels = (ViewGroup) findViewById(ResUtils.id(getContext(), "pasdk_id_vg_more_channels"));
        LbsPayRadioGroup lbsPayRadioGroup = (LbsPayRadioGroup) findViewById(ResUtils.id(getContext(), "paysdk_id_radiogroup"));
        this.radioGroupChannels = lbsPayRadioGroup;
        lbsPayRadioGroup.setOnCheckedListener(new LbsPayRadioGroup.OnCheckedListener() {
            /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
                r2 = r1.a;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onChecked(com.baidu.android.lbspay.view.ChannelViewBase r2) {
                /*
                    r1 = this;
                    com.baidu.android.lbspay.view.ChannelListView r2 = com.baidu.android.lbspay.view.ChannelListView.this
                    com.baidu.android.lbspay.view.LbsPayRadioGroup r2 = r2.radioGroupChannels
                    com.baidu.android.lbspay.network.NewCashierContent$IBaseChannel r2 = r2.getChannel()
                    if (r2 == 0) goto L_0x0021
                    com.baidu.android.lbspay.view.ChannelListView r2 = com.baidu.android.lbspay.view.ChannelListView.this
                    com.baidu.android.lbspay.view.PayChannelController$SelectChannelListener r0 = r2.mSelectChannelListener
                    if (r0 == 0) goto L_0x0021
                    com.baidu.android.lbspay.view.LbsPayRadioGroup r2 = r2.radioGroupChannels
                    com.baidu.android.lbspay.network.NewCashierContent$IBaseChannel r2 = r2.getChannel()
                    java.lang.String r2 = r2.getPayAmount()
                    r0.onSelectChannel(r2)
                L_0x0021:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.lbspay.view.ChannelListView.AnonymousClass1.onChecked(com.baidu.android.lbspay.view.ChannelViewBase):void");
            }
        });
        setOrientation(1);
    }

    public NewCashierContent.IBaseChannel getChannel() {
        LbsPayRadioGroup lbsPayRadioGroup = this.radioGroupChannels;
        if (lbsPayRadioGroup != null) {
            return lbsPayRadioGroup.getChannel();
        }
        return null;
    }

    public List<NewCashierContent.CashierChannel> getOfficialChannels() {
        return this.iOfficialChannels;
    }

    public void hideCommonMarket() {
        View view = this.mBannerView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void reSetView() {
        LbsPayRadioGroup lbsPayRadioGroup = this.radioGroupChannels;
        if (lbsPayRadioGroup != null) {
            lbsPayRadioGroup.removeAllViews();
            this.radioGroupChannels.setOncheckedView((ChannelViewBase) null);
        }
        this.iBaseChannels.clear();
        this.vgMoreChannels.setVisibility(8);
        this.vgMoreChannels.setOnClickListener((View.OnClickListener) null);
    }

    public boolean selectChannelById(int i2) {
        NewCashierContent.CashierChannel cashierChannel;
        int childCount = this.radioGroupChannels.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.radioGroupChannels.getChildAt(i3);
            if ((childAt instanceof ChannelViewBase) && childAt.getVisibility() == 0) {
                ChannelViewBase channelViewBase = (ChannelViewBase) childAt;
                Object tag = childAt.getTag();
                if ((tag instanceof NewCashierContent.CashierChannel) && (cashierChannel = (NewCashierContent.CashierChannel) tag) != null && i2 == cashierChannel.getChanelId()) {
                    this.radioGroupChannels.onChecked(channelViewBase);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.baidu.android.lbspay.view.ChannelOfficialView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.baidu.android.lbspay.view.ChannelOfficialView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.baidu.android.lbspay.view.ChannelOfficialView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.baidu.android.lbspay.view.ChannelView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.baidu.android.lbspay.view.ChannelOfficialView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.baidu.android.lbspay.view.ChannelOfficialView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: com.baidu.android.lbspay.view.ChannelOfficialView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: com.baidu.android.lbspay.view.ChannelOfficialView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setAdapter(com.baidu.android.lbspay.network.NewCashierContent r13) {
        /*
            r12 = this;
            if (r13 == 0) goto L_0x02fe
            com.baidu.android.lbspay.network.NewCashierContent$CashierPay r0 = r13.pay
            if (r0 != 0) goto L_0x0008
            goto L_0x02fe
        L_0x0008:
            com.baidu.android.lbspay.network.NewCashierContent$CashierChannels r1 = r0.channels
            r2 = 0
            if (r1 == 0) goto L_0x0010
            com.baidu.android.lbspay.network.NewCashierContent$CashierChannel[] r1 = r1.official_platform
            goto L_0x0011
        L_0x0010:
            r1 = r2
        L_0x0011:
            com.baidu.android.lbspay.network.NewCashierContent$CashierChannels r3 = r0.channels
            if (r3 == 0) goto L_0x0018
            com.baidu.android.lbspay.network.NewCashierContent$CashierChannel[] r3 = r3.platform
            goto L_0x0019
        L_0x0018:
            r3 = r2
        L_0x0019:
            java.util.List<com.baidu.android.lbspay.network.NewCashierContent$CashierChannel> r4 = r12.iBaseChannels
            if (r4 != 0) goto L_0x0024
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r12.iBaseChannels = r4
        L_0x0024:
            com.baidu.android.lbspay.view.ChannelListView$2 r4 = new com.baidu.android.lbspay.view.ChannelListView$2
            r4.<init>()
            com.baidu.android.lbspay.view.LbsPayRadioGroup r5 = r12.radioGroupChannels
            if (r5 == 0) goto L_0x0032
            com.baidu.android.lbspay.view.PayChannelController$GetPayModeListener r6 = r12.mGetPayModeListener
            r5.setGetPayModeListener(r6)
        L_0x0032:
            if (r1 == 0) goto L_0x0041
            int r5 = r1.length
            if (r5 <= 0) goto L_0x0041
            java.util.List<com.baidu.android.lbspay.network.NewCashierContent$CashierChannel> r5 = r12.iOfficialChannels
            java.util.Collections.addAll(r5, r1)
            java.util.List<com.baidu.android.lbspay.network.NewCashierContent$CashierChannel> r1 = r12.iOfficialChannels
            java.util.Collections.sort(r1, r4)
        L_0x0041:
            java.util.List<com.baidu.android.lbspay.network.NewCashierContent$CashierChannel> r1 = r12.iOfficialChannels
            java.util.Iterator r1 = r1.iterator()
            r5 = r2
            r6 = r5
        L_0x0049:
            boolean r7 = r1.hasNext()
            r8 = 1
            r9 = 0
            if (r7 == 0) goto L_0x00ce
            java.lang.Object r7 = r1.next()
            com.baidu.android.lbspay.network.NewCashierContent$CashierChannel r7 = (com.baidu.android.lbspay.network.NewCashierContent.CashierChannel) r7
            com.baidu.android.lbspay.view.ChannelOfficialView r10 = new com.baidu.android.lbspay.view.ChannelOfficialView
            android.content.Context r11 = r12.getContext()
            r10.<init>(r11)
            boolean r11 = r7.isAvailable()
            r10.setEnabled(r11, r7)
            boolean r11 = r7.isAvailable()
            if (r11 == 0) goto L_0x007e
            r10.setEnabled(r8, r7)
            if (r5 != 0) goto L_0x0081
            java.lang.String r9 = r7.channel_alias
            java.lang.String r11 = "BAIDU-BAIFUBAO-WISE"
            boolean r9 = r11.equals(r9)
            if (r9 == 0) goto L_0x0081
            r5 = r10
            goto L_0x0081
        L_0x007e:
            r10.setEnabled(r9, r7)
        L_0x0081:
            r10.setTag(r7)
            r10.setChannel(r7)
            com.baidu.android.lbspay.view.LbsPayRadioGroup r9 = r12.radioGroupChannels
            if (r9 == 0) goto L_0x008e
            r9.addView(r10)
        L_0x008e:
            if (r6 != 0) goto L_0x0049
            boolean r9 = r7.isChecked()
            if (r9 == 0) goto L_0x0049
            int r7 = r7.is_available
            if (r8 != r7) goto L_0x0049
            r10.setChecked(r8)
            com.baidu.android.lbspay.view.PayChannelController$GetPayModeListener r6 = r12.mGetPayModeListener
            if (r6 == 0) goto L_0x00c4
            java.lang.Object r6 = r10.getTag()
            boolean r6 = r6 instanceof com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
            if (r6 == 0) goto L_0x00bd
            com.baidu.android.lbspay.view.PayChannelController$GetPayModeListener r6 = r12.mGetPayModeListener
            java.lang.Object r7 = r10.getTag()
            com.baidu.android.lbspay.network.NewCashierContent$IBaseChannel r7 = (com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel) r7
            int r7 = r7.getChanelId()
            com.baidu.android.lbspay.utils.PayMode r7 = com.baidu.android.lbspay.channelpay.ChannelPayUtil.getPayMode(r7)
            r6.getSelectPayMode(r7)
            goto L_0x00c4
        L_0x00bd:
            com.baidu.android.lbspay.view.PayChannelController$GetPayModeListener r6 = r12.mGetPayModeListener
            com.baidu.android.lbspay.utils.PayMode r7 = com.baidu.android.lbspay.utils.PayMode.unknownPay
            r6.getSelectPayMode(r7)
        L_0x00c4:
            com.baidu.android.lbspay.view.LbsPayRadioGroup r6 = r12.radioGroupChannels
            if (r6 == 0) goto L_0x00cb
            r6.setOncheckedView(r10)
        L_0x00cb:
            r6 = r10
            goto L_0x0049
        L_0x00ce:
            r1 = 8
            if (r13 == 0) goto L_0x0161
            com.baidu.android.lbspay.network.NewCashierContent$CommonMarketing[] r13 = r13.common_marketing
            if (r13 == 0) goto L_0x0161
            int r7 = r13.length
            if (r7 <= 0) goto L_0x0161
            r13 = r13[r9]
            java.lang.String r7 = r13.text
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0161
            android.view.View r7 = r12.mBannerView
            if (r7 != 0) goto L_0x011b
            android.content.Context r7 = r12.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            android.content.Context r10 = r12.getContext()
            java.lang.String r11 = "wallet_juhe_banner"
            int r10 = com.dxmpay.apollon.utils.ResUtils.layout(r10, r11)
            android.view.View r2 = r7.inflate(r10, r2)
            r12.mBannerView = r2
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            r7 = -2
            r2.<init>(r7, r7)
            android.content.Context r7 = r12.getContext()
            r10 = 1103626240(0x41c80000, float:25.0)
            int r7 = com.dxmpay.apollon.utils.DisplayUtils.dip2px(r7, r10)
            r2.setMargins(r7, r9, r7, r9)
            com.baidu.android.lbspay.view.LbsPayRadioGroup r7 = r12.radioGroupChannels
            if (r7 == 0) goto L_0x011b
            android.view.View r10 = r12.mBannerView
            r7.addView(r10, r2)
        L_0x011b:
            java.lang.String r2 = com.baidu.android.lbspay.statistics.LbsStatistics.WALLET_LBS_BANNER_SHOW
            java.lang.String r7 = r13.url
            com.dxmpay.wallet.statistics.api.StatisticManager.onEventWithValue(r2, r7)
            r12.showCommonMarket()
            java.lang.String r2 = r13.url
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0140
            android.view.View r2 = r12.mBannerView
            android.content.Context r7 = r12.getContext()
            java.lang.String r10 = "lbspay_promotion_array"
            int r7 = com.dxmpay.apollon.utils.ResUtils.id(r7, r10)
            android.view.View r2 = r2.findViewById(r7)
            r2.setVisibility(r1)
        L_0x0140:
            android.view.View r2 = r12.mBannerView
            android.content.Context r7 = r12.getContext()
            java.lang.String r10 = "lbspay_promotion_text"
            int r7 = com.dxmpay.apollon.utils.ResUtils.id(r7, r10)
            android.view.View r2 = r2.findViewById(r7)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r7 = r13.text
            r2.setText(r7)
            android.view.View r2 = r12.mBannerView
            com.baidu.android.lbspay.view.ChannelListView$3 r7 = new com.baidu.android.lbspay.view.ChannelListView$3
            r7.<init>(r13)
            r2.setOnClickListener(r7)
        L_0x0161:
            android.widget.LinearLayout$LayoutParams r13 = new android.widget.LinearLayout$LayoutParams
            r2 = -1
            android.content.res.Resources r7 = r12.getResources()
            android.content.Context r10 = r12.mContext
            java.lang.String r11 = "lbspay_item_devider_height"
            int r10 = com.dxmpay.apollon.utils.ResUtils.dimen(r10, r11)
            float r7 = r7.getDimension(r10)
            int r7 = (int) r7
            r13.<init>(r2, r7)
            android.content.Context r2 = r12.getContext()
            java.lang.String r7 = "lbspay_cashier_item_marginleft"
            float r2 = com.dxmpay.apollon.utils.ResUtils.getDimension(r2, r7)
            int r2 = (int) r2
            r13.leftMargin = r2
            android.content.Context r2 = r12.getContext()
            float r2 = com.dxmpay.apollon.utils.ResUtils.getDimension(r2, r7)
            int r2 = (int) r2
            r13.rightMargin = r2
            android.content.Context r2 = r12.getContext()
            java.lang.String r7 = "lbspay_divider_margin_top"
            float r2 = com.dxmpay.apollon.utils.ResUtils.getDimension(r2, r7)
            int r2 = (int) r2
            r13.topMargin = r2
            android.widget.ImageView r2 = new android.widget.ImageView
            android.content.Context r7 = r12.mContext
            r2.<init>(r7)
            r12.mCommonMarketLine = r2
            android.content.Context r7 = r12.mContext
            java.lang.String r10 = "lbspay_bg_item_devider_color"
            int r7 = com.dxmpay.apollon.utils.ResUtils.color(r7, r10)
            r2.setImageResource(r7)
            android.widget.ImageView r2 = r12.mCommonMarketLine
            r2.setLayoutParams(r13)
            com.baidu.android.lbspay.view.LbsPayRadioGroup r13 = r12.radioGroupChannels
            if (r13 == 0) goto L_0x01bf
            android.widget.ImageView r2 = r12.mCommonMarketLine
            r13.addView(r2)
        L_0x01bf:
            if (r3 == 0) goto L_0x01c6
            java.util.List<com.baidu.android.lbspay.network.NewCashierContent$CashierChannel> r13 = r12.iBaseChannels
            java.util.Collections.addAll(r13, r3)
        L_0x01c6:
            java.util.List<com.baidu.android.lbspay.network.NewCashierContent$CashierChannel> r13 = r12.iBaseChannels
            java.util.Collections.sort(r13, r4)
            java.util.List<com.baidu.android.lbspay.network.NewCashierContent$CashierChannel> r13 = r12.iBaseChannels
            int r13 = r13.size()
            if (r13 <= 0) goto L_0x0212
            android.content.Context r13 = r12.mContext
            java.lang.String r2 = "lbspay_channel_choose"
            java.lang.String r13 = com.dxmpay.apollon.utils.ResUtils.getString(r13, r2)
            com.baidu.android.lbspay.network.NewCashierContent$CashierChannels r2 = r0.channels
            if (r2 == 0) goto L_0x01eb
            java.lang.String r2 = r2.platform_name
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x01eb
            com.baidu.android.lbspay.network.NewCashierContent$CashierChannels r13 = r0.channels
            java.lang.String r13 = r13.platform_name
        L_0x01eb:
            java.util.List<com.baidu.android.lbspay.network.NewCashierContent$CashierChannel> r0 = r12.iBaseChannels
            java.util.Iterator r0 = r0.iterator()
        L_0x01f1:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0205
            java.lang.Object r2 = r0.next()
            com.baidu.android.lbspay.network.NewCashierContent$IBaseChannel r2 = (com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel) r2
            boolean r2 = r2.isShow()
            if (r2 == 0) goto L_0x01f1
            r0 = 0
            goto L_0x0206
        L_0x0205:
            r0 = 1
        L_0x0206:
            android.view.View r13 = r12.getOtherGroupView(r13, r0)
            com.baidu.android.lbspay.view.LbsPayRadioGroup r2 = r12.radioGroupChannels
            if (r2 == 0) goto L_0x0213
            r2.addView(r13)
            goto L_0x0213
        L_0x0212:
            r0 = 1
        L_0x0213:
            java.util.List<com.baidu.android.lbspay.network.NewCashierContent$CashierChannel> r13 = r12.iBaseChannels
            java.util.Iterator r13 = r13.iterator()
            r2 = 0
        L_0x021a:
            boolean r3 = r13.hasNext()
            if (r3 == 0) goto L_0x0290
            java.lang.Object r3 = r13.next()
            com.baidu.android.lbspay.network.NewCashierContent$CashierChannel r3 = (com.baidu.android.lbspay.network.NewCashierContent.CashierChannel) r3
            com.baidu.android.lbspay.view.ChannelView r4 = new com.baidu.android.lbspay.view.ChannelView
            android.content.Context r7 = r12.getContext()
            r4.<init>(r7)
            boolean r7 = r3.isShow()
            if (r7 == 0) goto L_0x0239
            r4.setVisibility(r9)
            goto L_0x023d
        L_0x0239:
            r4.setVisibility(r1)
            r2 = 1
        L_0x023d:
            boolean r7 = r3.isAvailable()
            r4.setEnabled(r7, r3)
            r4.setTag(r3)
            r4.setChannel(r3)
            com.baidu.android.lbspay.view.LbsPayRadioGroup r7 = r12.radioGroupChannels
            if (r7 == 0) goto L_0x0251
            r7.addView(r4)
        L_0x0251:
            if (r6 != 0) goto L_0x021a
            boolean r7 = r3.isChecked()
            if (r7 == 0) goto L_0x021a
            int r3 = r3.is_available
            if (r8 != r3) goto L_0x021a
            r4.setChecked(r8)
            com.baidu.android.lbspay.view.PayChannelController$GetPayModeListener r3 = r12.mGetPayModeListener
            if (r3 == 0) goto L_0x0287
            java.lang.Object r3 = r4.getTag()
            boolean r3 = r3 instanceof com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
            if (r3 == 0) goto L_0x0280
            com.baidu.android.lbspay.view.PayChannelController$GetPayModeListener r3 = r12.mGetPayModeListener
            java.lang.Object r6 = r4.getTag()
            com.baidu.android.lbspay.network.NewCashierContent$IBaseChannel r6 = (com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel) r6
            int r6 = r6.getChanelId()
            com.baidu.android.lbspay.utils.PayMode r6 = com.baidu.android.lbspay.channelpay.ChannelPayUtil.getPayMode(r6)
            r3.getSelectPayMode(r6)
            goto L_0x0287
        L_0x0280:
            com.baidu.android.lbspay.view.PayChannelController$GetPayModeListener r3 = r12.mGetPayModeListener
            com.baidu.android.lbspay.utils.PayMode r6 = com.baidu.android.lbspay.utils.PayMode.unknownPay
            r3.getSelectPayMode(r6)
        L_0x0287:
            com.baidu.android.lbspay.view.LbsPayRadioGroup r3 = r12.radioGroupChannels
            if (r3 == 0) goto L_0x028e
            r3.setOncheckedView(r4)
        L_0x028e:
            r6 = r4
            goto L_0x021a
        L_0x0290:
            if (r6 != 0) goto L_0x02c5
            if (r5 == 0) goto L_0x02c5
            r5.setChecked(r8)
            com.baidu.android.lbspay.view.PayChannelController$GetPayModeListener r13 = r12.mGetPayModeListener
            if (r13 == 0) goto L_0x02be
            java.lang.Object r13 = r5.getTag()
            boolean r13 = r13 instanceof com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel
            if (r13 == 0) goto L_0x02b7
            com.baidu.android.lbspay.view.PayChannelController$GetPayModeListener r13 = r12.mGetPayModeListener
            java.lang.Object r3 = r5.getTag()
            com.baidu.android.lbspay.network.NewCashierContent$IBaseChannel r3 = (com.baidu.android.lbspay.network.NewCashierContent.IBaseChannel) r3
            int r3 = r3.getChanelId()
            com.baidu.android.lbspay.utils.PayMode r3 = com.baidu.android.lbspay.channelpay.ChannelPayUtil.getPayMode(r3)
            r13.getSelectPayMode(r3)
            goto L_0x02be
        L_0x02b7:
            com.baidu.android.lbspay.view.PayChannelController$GetPayModeListener r13 = r12.mGetPayModeListener
            com.baidu.android.lbspay.utils.PayMode r3 = com.baidu.android.lbspay.utils.PayMode.unknownPay
            r13.getSelectPayMode(r3)
        L_0x02be:
            com.baidu.android.lbspay.view.LbsPayRadioGroup r13 = r12.radioGroupChannels
            if (r13 == 0) goto L_0x02c5
            r13.setOncheckedView(r5)
        L_0x02c5:
            if (r2 == 0) goto L_0x02d9
            if (r0 != 0) goto L_0x02d9
            android.view.ViewGroup r13 = r12.vgMoreChannels
            r13.setVisibility(r9)
            android.view.ViewGroup r13 = r12.vgMoreChannels
            com.baidu.android.lbspay.view.ChannelListView$4 r0 = new com.baidu.android.lbspay.view.ChannelListView$4
            r0.<init>()
            r13.setOnClickListener(r0)
            goto L_0x02de
        L_0x02d9:
            android.view.ViewGroup r13 = r12.vgMoreChannels
            r13.setVisibility(r1)
        L_0x02de:
            com.baidu.android.lbspay.view.LbsPayRadioGroup r13 = r12.radioGroupChannels
            com.baidu.android.lbspay.network.NewCashierContent$IBaseChannel r13 = r13.getChannel()
            if (r13 == 0) goto L_0x02f7
            com.baidu.android.lbspay.view.PayChannelController$SelectChannelListener r13 = r12.mSelectChannelListener
            if (r13 == 0) goto L_0x02f7
            com.baidu.android.lbspay.view.LbsPayRadioGroup r0 = r12.radioGroupChannels
            com.baidu.android.lbspay.network.NewCashierContent$IBaseChannel r0 = r0.getChannel()
            java.lang.String r0 = r0.getPayAmount()
            r13.onSelectChannel(r0)
        L_0x02f7:
            com.baidu.android.lbspay.view.LbsPayRadioGroup r13 = r12.radioGroupChannels
            if (r13 == 0) goto L_0x02fe
            r13.changeChannelDivide()
        L_0x02fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.lbspay.view.ChannelListView.setAdapter(com.baidu.android.lbspay.network.NewCashierContent):void");
    }

    public void setGetSelectedModeListener(PayChannelController.GetPayModeListener getPayModeListener) {
        this.mGetPayModeListener = getPayModeListener;
    }

    public void setSelectChannelListener(PayChannelController.SelectChannelListener selectChannelListener) {
        this.mSelectChannelListener = selectChannelListener;
    }

    public void setShowAllChannelClickListener(PayChannelController.DoShowAllChannelClick doShowAllChannelClick) {
        this.mShowAllChannelClick = doShowAllChannelClick;
    }

    public void showCommonMarket() {
        View view = this.mBannerView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void updateBaiduDesc(NewCashierContent.IBaseChannel iBaseChannel) {
        this.radioGroupChannels.updateBaiduPayDesc(iBaseChannel);
    }

    public ChannelListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    @TargetApi(11)
    public ChannelListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mContext = context;
        initView();
    }
}
