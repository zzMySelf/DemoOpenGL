package com.baidu.searchbox.feed.template;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.feed.ad.AdUtil;
import com.baidu.searchbox.feed.ad.Als;
import com.baidu.searchbox.feed.ad.model.AdExt;
import com.baidu.searchbox.feed.ad.util.FeedAdUtil;
import com.baidu.searchbox.feed.controller.FeedDataReportUtils;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemDataAdOnePullThree;
import com.baidu.searchbox.feed.net.ADRequester;
import com.baidu.searchbox.feed.net.ParallelCharge;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.feed.util.FeedUtil;
import java.util.List;
import org.json.JSONObject;

public class FeedAdOnePullThreeView extends FeedAdBaseView {
    private FeedDraweeView mBigImage;
    private float[] mClickXY;
    private ConstraintLayout mImgParentLayout;
    private FeedDraweeView mSmallImageOne;
    private FeedDraweeView mSmallImageThree;
    private FeedDraweeView mSmallImageTwo;

    public FeedAdOnePullThreeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FeedAdOnePullThreeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FeedAdOnePullThreeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mClickXY = new float[]{-1.0f, -1.0f};
    }

    /* access modifiers changed from: protected */
    public View initInflate(LayoutInflater inflater) {
        return inflater.inflate(asyncInflateId(), this);
    }

    /* access modifiers changed from: protected */
    public int asyncInflateId() {
        return R.layout.feed_ad_one_pull_three;
    }

    /* access modifiers changed from: protected */
    public void initLayout(Context context) {
        ViewGroup.LayoutParams lp;
        this.mTitle.setMaxLines(2);
        this.mImgParentLayout = (ConstraintLayout) findViewById(R.id.feed_ad_img_layout);
        if (FeedUtil.isTablet(context) && (lp = this.mImgParentLayout.getLayoutParams()) != null) {
            lp.width = FeedTemplateUtil.getPadBigImageWidth(context, FeedTemplateUtil.getCalculateWidth(context) - (getResources().getDimensionPixelSize(R.dimen.F_M_W_X001) * 2));
        }
        this.mBigImage = (FeedDraweeView) findViewById(R.id.feed_ad_pull_big_img);
        this.mSmallImageOne = (FeedDraweeView) findViewById(R.id.feed_ad_pull_smalll_img_one);
        this.mSmallImageTwo = (FeedDraweeView) findViewById(R.id.feed_ad_pull_smalll_img_two);
        this.mSmallImageThree = (FeedDraweeView) findViewById(R.id.feed_ad_pull_smalll_img_three);
    }

    /* access modifiers changed from: protected */
    public void updateSubViewData(FeedBaseModel model) {
    }

    /* access modifiers changed from: protected */
    public void updateSubViewUi(FeedBaseModel model) {
        if (model != null) {
            FeedItemDataAdOnePullThree itemData = initData(model);
            if (itemData == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            updateAdView(itemData, model);
        }
    }

    private void updateAdView(FeedItemDataAdOnePullThree itemData, FeedBaseModel model) {
        String bigUrl = itemData.image;
        List<FeedItemDataAdOnePullThree.SmallPictureItem> smallPictureItems = itemData.smallPicItems;
        String smallUrl1 = smallPictureItems.get(0).image;
        String smallUrl2 = smallPictureItems.get(1).image;
        String smallUrl3 = smallPictureItems.get(2).image;
        FeedDraweeView feedDraweeView = this.mBigImage;
        if (feedDraweeView != null) {
            feedDraweeView.setPlaceHolderWithSelfFlag().loadImage(bigUrl, model);
        }
        FeedDraweeView feedDraweeView2 = this.mSmallImageOne;
        if (feedDraweeView2 != null) {
            feedDraweeView2.setPlaceHolderWithSelfFlag().loadImage(smallUrl1, model);
            this.mSmallImageOne.setOnClickListener(this);
        }
        FeedDraweeView feedDraweeView3 = this.mSmallImageTwo;
        if (feedDraweeView3 != null) {
            feedDraweeView3.setPlaceHolderWithSelfFlag().loadImage(smallUrl2, model);
            this.mSmallImageTwo.setOnClickListener(this);
        }
        FeedDraweeView feedDraweeView4 = this.mSmallImageThree;
        if (feedDraweeView4 != null) {
            feedDraweeView4.setPlaceHolderWithSelfFlag().loadImage(smallUrl3, model);
            this.mSmallImageThree.setOnClickListener(this);
        }
    }

    private FeedItemDataAdOnePullThree initData(FeedBaseModel model) {
        if (!(model.data instanceof FeedItemDataAdOnePullThree)) {
            return null;
        }
        FeedItemDataAdOnePullThree data = (FeedItemDataAdOnePullThree) model.data;
        if (data.image == null || data.smallPicItems.size() != 3) {
            return null;
        }
        return data;
    }

    public void onClick(View v) {
        FeedBaseModel model;
        FeedItemDataAdOnePullThree itemData;
        if (v.getId() == R.id.feed_template_base_delete_id) {
            super.onClick(v);
        } else if (FeedAdUtil.isAdClickAreaValid(getContext(), this.mClickXY[0]) && (model = getFeedModel()) != null && (model.data instanceof FeedItemDataAdOnePullThree) && (itemData = (FeedItemDataAdOnePullThree) model.data) != null && itemData.smallPicItems != null && itemData.smallPicItems.size() == 3) {
            if (!model.runtimeStatus.isCmdJointed) {
                FeedItemDataAdOnePullThree.replacePullCmdExt(model);
            }
            String cmd = "";
            String pid = "";
            int id = v.getId();
            if (id == R.id.feed_ad_pull_smalll_img_one) {
                FeedItemDataAdOnePullThree.SmallPictureItem smallPictureItemOne = itemData.smallPicItems.get(0);
                if (smallPictureItemOne != null && !TextUtils.isEmpty(smallPictureItemOne.pid)) {
                    cmd = itemData.smallPicItems.get(0).cmd;
                    pid = itemData.smallPicItems.get(0).pid;
                } else {
                    return;
                }
            } else if (id == R.id.feed_ad_pull_smalll_img_two) {
                FeedItemDataAdOnePullThree.SmallPictureItem smallPictureItemTwo = itemData.smallPicItems.get(1);
                if (smallPictureItemTwo != null && !TextUtils.isEmpty(smallPictureItemTwo.pid)) {
                    cmd = itemData.smallPicItems.get(1).cmd;
                    pid = itemData.smallPicItems.get(1).pid;
                } else {
                    return;
                }
            } else if (id == R.id.feed_ad_pull_smalll_img_three) {
                FeedItemDataAdOnePullThree.SmallPictureItem smallPictureItemThree = itemData.smallPicItems.get(2);
                if (smallPictureItemThree != null && !TextUtils.isEmpty(smallPictureItemThree.pid)) {
                    cmd = itemData.smallPicItems.get(2).cmd;
                    pid = itemData.smallPicItems.get(2).pid;
                } else {
                    return;
                }
            }
            FeedAdUtil.feedAdInvokeCommand(model, getContext(), cmd, true);
            if (!model.runtimeStatus.isRead) {
                model.runtimeStatus.isRead = true;
                updateTitleColor(model);
            }
            if (NetWorkUtils.isNetworkConnected()) {
                postAlsLog(model, Als.LogType.CLICK, Als.Area.CARD.value, pid);
                if (FeedAdUtil.checkFeedAdDataValid(model)) {
                    ADRequester.adThirdPartyMonitor(model.data.ad.feed.mExtData, Als.ADActionType.CLICK);
                    ParallelCharge.chargeMain(model.data.ad.feed);
                    recordUBS(model);
                }
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == 0) {
            this.mClickXY[0] = ev.getRawX();
            this.mClickXY[1] = ev.getRawY();
        }
        return super.dispatchTouchEvent(ev);
    }

    private void postAlsLog(FeedBaseModel model, Als.LogType type, String area, String pid) {
        Als.Builder builder = new Als.Builder();
        builder.setType(type);
        builder.setPage(ADRequester.getAdPageByBusiness(model.runtimeStatus.business));
        builder.setArea(area);
        builder.setExt1(pid);
        if (type == Als.LogType.CLICK) {
            float[] fArr = this.mClickXY;
            builder.setExt3(AdUtil.createHotParams(this, (int) fArr[0], (int) fArr[1]));
        }
        builder.setSboxExtraParam(model.data.ad.ext);
        Als.postADRealTimeLog(builder);
    }

    private void recordUBS(FeedBaseModel model) {
        JSONObject jsonObject;
        String id = model.id;
        String ext = "";
        if (FeedAdUtil.checkModelDataExtValid(model) && (jsonObject = AdExt.toJson(model.data.ad.ext)) != null && jsonObject.length() > 0) {
            ext = jsonObject.toString();
        }
        FeedDataReportUtils.reportAdChildItemClick(id, model.runtimeStatus.viewPosition, ext, "clk", "index");
    }
}
