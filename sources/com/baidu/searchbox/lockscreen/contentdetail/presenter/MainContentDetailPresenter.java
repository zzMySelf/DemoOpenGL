package com.baidu.searchbox.lockscreen.contentdetail.presenter;

import android.text.TextUtils;
import com.baidu.searchbox.lockscreen.LockScreenActionBar;
import com.baidu.searchbox.lockscreen.LockScreenContentDetail;
import com.baidu.searchbox.lockscreen.bridge.ILockScreenFavor;
import com.baidu.searchbox.lockscreen.bridge.LockScreenRuntime;
import com.baidu.searchbox.lockscreen.controller.LockScreenLinkageUtils;
import com.baidu.searchbox.lockscreen.statistics.DisplayClickUbcBean;
import com.baidu.searchbox.lockscreen.statistics.LockScreenHome;
import com.baidu.searchbox.lockscreen.statistics.LockScreenStatisticConstants;
import com.baidu.searchbox.lockscreen.util.LockScreenUtil;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;

public class MainContentDetailPresenter extends BaseContentDetailPresenter {
    private JSONObject mFavorJson;
    private Flow mFlow;

    public MainContentDetailPresenter(LockScreenContentDetail activity) {
        super(activity);
    }

    public void onResume() {
        super.onResume();
        this.mFlow = UBC.beginFlow(LockScreenStatisticConstants.DURATION_ID_LANDING);
    }

    public void onPause() {
        super.onPause();
        if (this.mFlow != null) {
            JSONObject object = new JSONObject();
            try {
                object.put("page", "page_landing");
                object.put("type", LockScreenStatisticConstants.CARD_RICHTEXT);
                object.put(LockScreenStatisticConstants.RES_ID, this.mContentID);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.mFlow.setValueWithDuration(object.toString());
            this.mFlow.end();
            if (this.mIsLoadSuccess) {
                LockScreenLinkageUtils.recordLinkageDuration(this.mContentID, this.mFlow.getStartTime());
            }
            this.mFlow = null;
        }
    }

    public void updateStarUI(String options) {
        ILockScreenFavor lockScreenFavor;
        super.updateStarUI(options);
        if (!TextUtils.isEmpty(options)) {
            try {
                this.mFavorJson = new JSONObject(options);
                if (this.mActivity.getLockScreenActionBar() != null && (lockScreenFavor = LockScreenRuntime.getLockScreenFavor()) != null) {
                    lockScreenFavor.checkFavored(LockScreenUtil.getUkey(this.mFavorJson), new ILockScreenFavor.FavorCallBack() {
                        public void onFavored(boolean isFavored) {
                            LockScreenActionBar actionBar = MainContentDetailPresenter.this.mActivity.getLockScreenActionBar();
                            if (actionBar != null) {
                                actionBar.updateFavorImageView(isFavored);
                                actionBar.setFavorButtonEnabled(true);
                            }
                            LockScreenLinkageUtils.recordLinkageFavor(MainContentDetailPresenter.this.mContentID, isFavored);
                        }
                    });
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onFavorClick() {
        super.onFavorClick();
        doFavor();
    }

    public void showJumpFeedButtonStatistic() {
        LockScreenHome.reportDisplayClickByUbc(new DisplayClickUbcBean(LockScreenStatisticConstants.PAGE_LANDING__BUTTON, "display", LockScreenStatisticConstants.NEWS, this.mContentID));
    }

    public void clickJumpFeedButtonStatistic() {
        LockScreenHome.reportDisplayClickByUbc(new DisplayClickUbcBean(LockScreenStatisticConstants.PAGE_LANDING__BUTTON, "clk", LockScreenStatisticConstants.NEWS, this.mContentID));
    }

    private void doFavor() {
        ILockScreenFavor lockScreenFavor = LockScreenRuntime.getLockScreenFavor();
        if (lockScreenFavor != null) {
            lockScreenFavor.addOrCancelFavorToLogin(this.mActivity, this.mFavorJson, new ILockScreenFavor.FavorCallBack() {
                public void onFavored(boolean isFavored) {
                    LockScreenActionBar actionBar = MainContentDetailPresenter.this.mActivity.getLockScreenActionBar();
                    if (actionBar != null) {
                        actionBar.updateFavorImageView(isFavored);
                    }
                    LockScreenLinkageUtils.recordLinkageFavor(MainContentDetailPresenter.this.mContentID, isFavored);
                }
            }, "rich_text");
        }
    }
}
