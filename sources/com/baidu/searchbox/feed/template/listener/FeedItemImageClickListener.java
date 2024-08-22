package com.baidu.searchbox.feed.template.listener;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.controller.FeedDataReportUtils;
import com.baidu.searchbox.feed.event.FeedToDetailEvent;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemDataNews;
import com.baidu.searchbox.feed.model.FeedItemForwardUgcDtModel;
import com.baidu.searchbox.feed.model.FeedQuoteDtModel;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.feed.template.constant.FeedTplNameCenter;
import com.baidu.searchbox.feed.template.statistic.FeedChannelConstants;
import com.baidu.searchbox.feed.template.statistic.FeedTemplateStatTable;
import com.baidu.searchbox.feed.template.statistic.IFeedTemplateStatistics;
import com.baidu.searchbox.feed.template.utils.FeedHotTemplateUtils;
import com.baidu.searchbox.feed.template.utils.FeedItemImgClickListenerTable;
import com.baidu.searchbox.feed.template.utils.TemplateAreaClickHelper;
import com.baidu.searchbox.feed.util.FeedRouter;
import com.baidu.searchbox.feed.util.ReadingRecord;
import com.baidu.searchbox.lightbrowser.model.SubTagItem;
import com.baidu.searchbox.picture.PictureBrowserManager;
import com.baidu.searchbox.picture.model.LightPictureUgcModel;
import com.baidu.searchbox.picture.params.LaunchParams;
import com.baidu.ubc.bussiness.UBCDurationSearchSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedItemImageClickListener implements View.OnClickListener {
    private boolean isRepost;
    private Context mContext;
    private int mIndex;
    private FeedItemDataNews mItemData;
    private View.OnClickListener mListener;
    private FeedBaseModel mModel;

    public FeedItemImageClickListener(Context context) {
        this.isRepost = false;
        this.mContext = context;
    }

    public FeedItemImageClickListener(Context context, FeedItemDataNews itemData, FeedBaseModel model, int index) {
        this(context, itemData, model, index, (View.OnClickListener) null);
    }

    public FeedItemImageClickListener(Context context, FeedItemDataNews itemData, FeedBaseModel model, int index, View.OnClickListener listener) {
        this.isRepost = false;
        this.mContext = context;
        this.mItemData = itemData;
        this.mModel = model;
        this.mIndex = index;
        this.mListener = listener;
    }

    public void setIsRepost(boolean isRepost2) {
        this.isRepost = isRepost2;
    }

    public void setData(FeedItemDataNews itemData, FeedBaseModel model, int index) {
        this.mItemData = itemData;
        this.mModel = model;
        this.mIndex = index;
    }

    public void onClick(View view2) {
        FeedBaseModel feedBaseModel;
        if (this.mModel != null && this.mItemData != null) {
            ArrayList<Integer> animData = new ArrayList<>();
            if (DeviceUtil.ScreenInfo.isScreenPortrait()) {
                int[] viewLoc = new int[2];
                view2.getLocationInWindow(viewLoc);
                animData.add(Integer.valueOf(viewLoc[1]));
                animData.add(Integer.valueOf(viewLoc[0]));
                animData.add(Integer.valueOf(viewLoc[0] + ((int) (((float) view2.getWidth()) * view2.getScaleX()))));
                animData.add(Integer.valueOf(viewLoc[1] + ((int) (((float) view2.getHeight()) * view2.getScaleY()))));
            }
            String channelId = this.mModel.runtimeStatus.channelId;
            IFeedTemplateStatistics feedTempStat = FeedTemplateStatTable.getInstance().get(channelId);
            FeedItemImgClickListenerItem listener = FeedItemImgClickListenerTable.getInstance().get(channelId);
            if (listener != null) {
                listener.onClick(view2, this.mModel, this.mIndex, false);
            }
            if (this.mItemData.isShowHDImages()) {
                BdEventBus.Companion.getDefault().post(new FeedToDetailEvent());
                FeedBaseModel feedBaseModel2 = this.mModel;
                FeedDataReportUtils.reportFeedbackAction(feedBaseModel2, (HashMap<String, String>) null, "clk", feedBaseModel2.runtimeStatus.viewPosition, (List<SubTagItem>) null);
                TemplateAreaClickHelper.recordClickArea(this.mModel, 1);
                if (this.mItemData.isUgcTextImmersive || isForwardDtUGCImmersive(this.mModel)) {
                    BdEventBus.Companion.getDefault().post(new FeedToDetailEvent());
                    if (feedTempStat != null) {
                        feedTempStat.picClick(this.mModel, "new_ugc_img_click", "picture", this.mIndex, this.isRepost);
                    }
                    ReadingRecord.add(this.mModel);
                    LightPictureUgcModel ugcModel = FeedHotTemplateUtils.convert2UgcModel(this.mModel);
                    if (ugcModel != null) {
                        if (!FeedHotTemplateUtils.isExpandBanner(this.mModel)) {
                            PictureBrowserManager manager = (PictureBrowserManager) ServiceManager.getService(PictureBrowserManager.SERVICE_REFERENCE);
                            LaunchParams.Builder builder = new LaunchParams.Builder();
                            if (!FeedChannelConstants.isDynamicImmersiveChannel(channelId)) {
                                builder.setSource("feed");
                            } else {
                                try {
                                    JSONObject extObject = new JSONObject(this.mItemData.extlog);
                                    String from = extObject.optString("from");
                                    String page = extObject.optString("page");
                                    builder.setSource(extObject.optString("source")).setFrom(from).setPage(page).setValue(extObject.optString("value"));
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            manager.initPictureInstanceFlow(ugcModel.nid);
                            builder.setUgcModel(ugcModel).setIndex(this.mIndex).setPictureInfoList(ugcModel.lightPicInfoList).setType(LaunchParams.TYPE_UGC_IMMERSIVE).setExtLog(handleExtLogIfNeed(this.mItemData.extlog)).setShowRecommend(false);
                            manager.open(this.mContext, builder.build());
                        }
                    } else {
                        return;
                    }
                } else {
                    BdEventBus.Companion.getDefault().post(new FeedToDetailEvent());
                    if (feedTempStat != null) {
                        feedTempStat.picClick(this.mModel, FeedStatisticConstants.UBC_FEED_ITEM_IMAGE_CLICK_TYPE_VALUE, "picture", this.mIndex, this.isRepost);
                    }
                    PictureBrowserManager manager2 = (PictureBrowserManager) ServiceManager.getService(PictureBrowserManager.SERVICE_REFERENCE);
                    if (this.mItemData.hdImagesList != null && this.mItemData.hdImagesList.length() > 0) {
                        ArrayList<String> urls = new ArrayList<>();
                        for (int i2 = 0; i2 < this.mItemData.hdImagesList.length(); i2++) {
                            Object obj = this.mItemData.hdImagesList.opt(i2);
                            if (obj instanceof String) {
                                urls.add((String) obj);
                            } else if (obj instanceof JSONObject) {
                                urls.add(((JSONObject) obj).optString("url"));
                            }
                        }
                        manager2.open(this.mContext, new LaunchParams.Builder().setUris(urls).setIndex(this.mIndex).setAnimaData(animData).setExtLog(handleExtLogIfNeed(this.mItemData.extlog)).build());
                    }
                }
            } else if (!this.isRepost || (feedBaseModel = this.mModel) == null || !(feedBaseModel.data instanceof FeedItemForwardUgcDtModel)) {
                String cmd = this.mItemData.cmd.get();
                if (!TextUtils.isEmpty(cmd)) {
                    FeedRouter.invoke(this.mContext, cmd, true);
                    FeedBaseModel feedBaseModel3 = this.mModel;
                    FeedDataReportUtils.reportFeedbackAction(feedBaseModel3, (HashMap<String, String>) null, "clk", feedBaseModel3.runtimeStatus.viewPosition, (List<SubTagItem>) null);
                    TemplateAreaClickHelper.recordClickArea(this.mModel, 1);
                    if (!this.mModel.runtimeStatus.isRead) {
                        this.mModel.runtimeStatus.isRead = true;
                    }
                }
            } else {
                FeedItemForwardUgcDtModel itemData = (FeedItemForwardUgcDtModel) this.mModel.data;
                if (!(itemData == null || itemData.quoteModel == null || TextUtils.isEmpty(itemData.quoteModel.cmd))) {
                    FeedRouter.invoke(this.mContext, itemData.quoteModel.cmd, true);
                }
            }
            View.OnClickListener onClickListener = this.mListener;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    private String handleExtLogIfNeed(String extLog) {
        JSONObject extObject;
        if (UBCDurationSearchSession.isInSearchSession()) {
            try {
                if (!TextUtils.isEmpty(extLog)) {
                    extObject = new JSONObject(extLog);
                } else {
                    extObject = new JSONObject();
                }
                extObject.put("s_session", UBCDurationSearchSession.getSSession());
                return extObject.toString();
            } catch (JSONException e2) {
            }
        }
        return extLog;
    }

    private boolean isForwardDtUGCImmersive(FeedBaseModel model) {
        FeedQuoteDtModel quoteModel;
        FeedBaseModel feedBaseModel = this.mModel;
        if (feedBaseModel == null || !TextUtils.equals(feedBaseModel.layout, FeedTplNameCenter.FORWARD_UGC_DT) || (quoteModel = ((FeedItemForwardUgcDtModel) this.mModel.data).quoteModel) == null || !quoteModel.isUgcTextImmersive) {
            return false;
        }
        return true;
    }
}
