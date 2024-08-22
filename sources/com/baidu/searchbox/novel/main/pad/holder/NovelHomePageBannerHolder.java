package com.baidu.searchbox.novel.main.pad.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.novel.R;
import com.baidu.searchbox.novel.main.pad.bean.NovelHomePageRecommendBannerData;
import com.baidu.searchbox.novel.main.pad.bean.NovelHomePageRecommendBaseData;
import com.baidu.searchbox.novel.main.pad.manager.NovelHomePageRecommendTabManager;
import com.baidu.searchbox.novel.main.pad.view.NovelHomePageBannerView;
import com.baidu.searchbox.novel.stat.ubc.NovelUbcStatUtils;
import com.baidu.searchbox.novel.view.NovelPullToRefreshAndLoadMoreRecyclerView;
import org.json.JSONObject;

public class NovelHomePageBannerHolder extends NovelHomePageBaseHolder<NovelHomePageRecommendBaseData> {
    private NovelHomePageRecommendBannerData mBannerData;
    private NovelHomePageBannerView mBannerView;
    /* access modifiers changed from: private */
    public NovelPullToRefreshAndLoadMoreRecyclerView.InterceptTouchEventEnableCallback mInterceptCallback;

    public NovelHomePageBannerHolder(NovelHomePageRecommendTabManager manager, View itemView) {
        super(manager, itemView);
        if (itemView != null) {
            this.mBannerView = (NovelHomePageBannerView) itemView.findViewById(R.id.novel_recommend_banner_view);
        }
    }

    public static View getView(Context context) {
        if (context == null) {
            return null;
        }
        return LayoutInflater.from(context).inflate(R.layout.novel_home_page_recommend_banner_pad, (ViewGroup) null);
    }

    public void bindData(NovelHomePageRecommendBaseData baseData) {
        if (baseData != null) {
            if (baseData instanceof NovelHomePageRecommendBannerData) {
                this.mBannerData = (NovelHomePageRecommendBannerData) baseData;
            }
            if (this.mBannerData != null && this.mBannerView != null) {
                initBannerHeight();
                if (this.mBannerData.novelList != null && this.mBannerData.novelList.size() > 0) {
                    this.mBannerView.setData(this.mBannerData.novelList);
                    this.mBannerView.setInterceptCallback(new NovelHomePageBannerView.BannerInterceptTouchEventEnableCallback() {
                        public void setInterceptTouchEventEnable(boolean enable) {
                            if (NovelHomePageBannerHolder.this.mInterceptCallback != null) {
                                NovelHomePageBannerHolder.this.mInterceptCallback.setInterceptTouchEventEnable(enable);
                            }
                        }
                    });
                }
            }
        }
    }

    private void initBannerHeight() {
        int displayWidth;
        if (this.mBannerView != null && this.itemView != null && (displayWidth = DeviceUtils.ScreenInfo.getDisplayWidth(this.itemView.getContext())) > 0) {
            int height = (displayWidth * 398) / 1242;
            ViewGroup.LayoutParams layoutParams = this.mBannerView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = height;
                this.mBannerView.setLayoutParams(layoutParams);
            }
        }
    }

    public void ubcShow() {
        JSONObject ext = new JSONObject();
        try {
            ext.put("name", getBannerNames());
        } catch (Exception e2) {
        }
        NovelUbcStatUtils.ubc5958("novel", "show", "select", "operate_module", "feedtabnovel_new", ext);
    }

    private String getBannerNames() {
        NovelHomePageRecommendBannerData novelHomePageRecommendBannerData = this.mBannerData;
        if (novelHomePageRecommendBannerData == null || novelHomePageRecommendBannerData.novelList == null || this.mBannerData.novelList.size() <= 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i2 = 0; i2 < this.mBannerData.novelList.size(); i2++) {
            if (i2 > 0) {
                builder.append("_");
            }
            NovelHomePageRecommendBannerData.BannerInfo info = this.mBannerData.novelList.get(i2);
            if (info != null) {
                builder.append(info.picName);
            }
        }
        return builder.toString();
    }

    public void setInterceptTouchEventEnableCallback(NovelPullToRefreshAndLoadMoreRecyclerView.InterceptTouchEventEnableCallback callback) {
        this.mInterceptCallback = callback;
    }
}
