package com.baidu.searchbox.follow.redpacket;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.follow.FollowConstant;
import com.baidu.searchbox.follow.FollowUtils;
import com.baidu.searchbox.follow.R;
import com.baidu.searchbox.follow.redpacket.data.RedPacket;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;

public class RedPacketBannerInfoView extends FrameLayout implements View.OnClickListener {
    public static final int BANNERS_MAX = 2;
    public RedPacket.BannerInfo mBannerInfo;
    private TextView mBannerInfoTitle;
    private LinearLayout mBannerListImage;
    private ArrayList<RedPacket.CardInfo> mCardInfos;
    private Context mContext;
    private RelativeLayout mRlBannerInfoTitle;
    private RelativeLayout mRootView;
    private int showIconNum;

    public RedPacketBannerInfoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RedPacketBannerInfoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RedPacketBannerInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.activity_red_packet_detail_banner_info, this);
        this.mRlBannerInfoTitle = (RelativeLayout) findViewById(R.id.rl_banner_info_title);
        this.mBannerInfoTitle = (TextView) findViewById(R.id.tv_bannerinfo_title);
        this.mBannerListImage = (LinearLayout) findViewById(R.id.ll_bannerinfo_imgs);
        this.mRootView = (RelativeLayout) findViewById(R.id.rl_banner_info);
    }

    public void updateData(RedPacket redPacketData) {
        if (redPacketData != null && redPacketData.bannerInfo != null) {
            this.mBannerInfoTitle.setText(redPacketData.bannerInfo.title);
            this.mBannerInfo = redPacketData.bannerInfo;
            initBannerImage(redPacketData.bannerInfo);
            FollowUtils.followRedPacketEvent(redPacketData.bannerInfo.type, FollowConstant.UBC_TYPE_BANNER_SHOW);
        }
    }

    private void initBannerImage(RedPacket.BannerInfo bannerInfo) {
        if (bannerInfo != null && bannerInfo.cardInfos != null) {
            this.mCardInfos = bannerInfo.cardInfos;
            this.showIconNum = bannerInfo.cardInfos.size();
            if (bannerInfo.cardInfos.size() >= 2) {
                this.showIconNum = 2;
            }
            for (int i2 = 0; i2 < this.showIconNum; i2++) {
                SimpleDraweeView imageView = new SimpleDraweeView(this.mContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
                ((GenericDraweeHierarchy) imageView.getHierarchy()).setRoundingParams(RoundingParams.fromCornersRadius((float) DeviceUtil.ScreenInfo.dp2px(this.mContext, 3.0f)));
                imageView.setLayoutParams(layoutParams);
                imageView.setImageURI(bannerInfo.cardInfos.get(i2).picUrl);
                imageView.setOnClickListener(this);
                imageView.setBackgroundColor(0);
                this.mBannerListImage.addView(imageView);
            }
        }
    }

    public void updateUi() {
        this.mRootView.setBackgroundColor(getResources().getColor(R.color.follow_redpacketdetail_bg));
        this.mRlBannerInfoTitle.setBackgroundColor(getResources().getColor(R.color.follow_redpacketdetail_bg));
        this.mBannerInfoTitle.setBackgroundColor(getResources().getColor(R.color.follow_redpacketdetail_bg));
        this.mBannerListImage.setBackgroundColor(getResources().getColor(R.color.follow_redpacketdetail_bg));
    }

    public void onClick(View view2) {
        ArrayList<RedPacket.CardInfo> arrayList;
        if (this.mBannerListImage != null && (arrayList = this.mCardInfos) != null && arrayList.size() >= this.mBannerListImage.getChildCount()) {
            for (int i2 = 0; i2 < this.mBannerListImage.getChildCount(); i2++) {
                if (view2 == this.mBannerListImage.getChildAt(i2)) {
                    Router.invoke(this.mContext, this.mCardInfos.get(i2).scheme);
                    FollowUtils.followRedPacketEvent(this.mBannerInfo.type, FollowConstant.UBC_TYPE_BANNER_CLICK);
                    return;
                }
            }
        }
    }
}
