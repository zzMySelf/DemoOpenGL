package com.baidu.searchbox.gamecore.list.viewholder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.gamecore.GameCenterRuntime;
import com.baidu.searchbox.gamecore.R;
import com.baidu.searchbox.gamecore.base.datasource.GameDataManager;
import com.baidu.searchbox.gamecore.image.GameImageView;
import com.baidu.searchbox.gamecore.list.model.GameAppItemData;
import com.baidu.searchbox.gamecore.list.model.GameModules;
import com.baidu.searchbox.gamecore.list.model.GameTopItemData;
import com.baidu.searchbox.gamecore.player.GameIMAXPlayer;
import com.baidu.searchbox.gamecore.player.IGameVideoPlayerHolder;
import com.baidu.searchbox.gamecore.router.GameRouter;
import com.baidu.searchbox.gamecore.ubc.GameCenterUBCUtil;
import com.baidu.searchbox.gamecore.ubc.GameUBCConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class GameBigBannerViewHolder extends GameBaseSimpleCardHolder implements IGameVideoPlayerHolder {
    private static final boolean DEBUG = false;
    private static final float RATIO = 5.0f;
    private static final String TAG = "GameBigBannerViewHolder";
    private View mRootView = getView(R.id.header_view);
    private GameImageView mSmallBanner = ((GameImageView) getView(R.id.small_banner));
    private View mVideoClickArea = getView(R.id.small_banner_click_area);
    private FrameLayout mVideoContainer = ((FrameLayout) getView(R.id.game_video_container));
    private HashMap<Integer, String> mVideoInfo;

    public GameBigBannerViewHolder(ViewGroup parentView) {
        super(LayoutInflater.from(parentView.getContext()).inflate(R.layout.game_item_view_big_banner, parentView, false));
        adjustHeight();
    }

    private void adjustHeight() {
        int width = GameCenterRuntime.getResources().getDisplayMetrics().widthPixels - (((int) GameCenterRuntime.getResources().getDimension(R.dimen.game_banner_margin_horizontal)) << 1);
        int height = (int) (((float) width) / 5.0f);
        ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
        layoutParams.height = height;
        this.itemView.setLayoutParams(layoutParams);
        GameImageView gameImageView = this.mSmallBanner;
        if (gameImageView != null) {
            FrameLayout.LayoutParams smallLayoutParams = (FrameLayout.LayoutParams) gameImageView.getLayoutParams();
            smallLayoutParams.height = height;
            smallLayoutParams.width = width;
            this.mSmallBanner.setLayoutParams(smallLayoutParams);
        }
        FrameLayout frameLayout = this.mVideoContainer;
        if (frameLayout != null) {
            FrameLayout.LayoutParams videoLayoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            videoLayoutParams.height = height;
            videoLayoutParams.width = width;
            this.mVideoContainer.setLayoutParams(videoLayoutParams);
        }
    }

    public void bindData(GameModules data, int position) {
        super.bindData(data, position);
        if (!(data == null || data.itemList == null || data.itemList.size() <= 0 || data.itemList.get(0) == null || this.mSmallBanner == null)) {
            GameTopItemData itemData = (GameTopItemData) data.itemList.get(0);
            final String scheme = itemData.scheme;
            String imageUrl = itemData.closeStatic;
            if (!TextUtils.isEmpty(imageUrl)) {
                this.mSmallBanner.setUrl(imageUrl);
            }
            View view2 = this.mVideoClickArea;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (GameBigBannerViewHolder.this.itemView != null && GameBigBannerViewHolder.this.itemView.getContext() != null && !TextUtils.isEmpty(scheme)) {
                            GameRouter.routerInvoke(GameBigBannerViewHolder.this.itemView.getContext(), scheme);
                            GameBigBannerViewHolder.this.onBtnClicked();
                        }
                    }
                });
            }
            if (itemData.closeDynamicType == 0) {
                bindVideoInfo(itemData);
                return;
            }
        }
        HashMap<Integer, String> hashMap = this.mVideoInfo;
        if (hashMap != null) {
            hashMap.clear();
            this.mVideoInfo = null;
        }
    }

    private void bindVideoInfo(GameTopItemData item) {
        if (!TextUtils.isEmpty(item.closeDynamic)) {
            String videoUrl = item.closeDynamic;
            HashMap<Integer, String> hashMap = new HashMap<>();
            this.mVideoInfo = hashMap;
            hashMap.put(0, videoUrl);
        }
    }

    /* access modifiers changed from: protected */
    public HashMap<String, String> buildGamesDisplayExt() {
        if (this.mModule == null || getItemData() == null || ((GameModules) getItemData()).itemList == null || ((GameModules) getItemData()).itemList.isEmpty()) {
            return null;
        }
        List<String> displayExtStrs = new ArrayList<>();
        if (GameCenterUBCUtil.isDisplayEventRecorded(generateDisplayId()) || ((GameModules) getItemData()).itemList.get(0) == null || !(((GameModules) getItemData()).itemList.get(0) instanceof GameAppItemData)) {
            return null;
        }
        GameAppItemData itemData = (GameAppItemData) ((GameModules) getItemData()).itemList.get(0);
        displayExtStrs.add(GameCenterUBCUtil.buildSingleGameDisplayStr(this.mModule.moduleName, getPositionInParent() + 1, 1, itemData.resourceKey, itemData.type, 1, this.mModule.moduleId, this.mModule.moduleType, itemData.appId));
        GameCenterUBCUtil.markDisplayEventRecorded(generateDisplayId());
        return GameCenterUBCUtil.buildGameDisplayExt(displayExtStrs);
    }

    private String generateDisplayId() {
        if (this.mModule == null || getItemData() == null || ((GameModules) getItemData()).itemList == null || ((GameModules) getItemData()).itemList.isEmpty() || ((GameModules) getItemData()).itemList.get(0) == null || !(((GameModules) getItemData()).itemList.get(0) instanceof GameAppItemData)) {
            return null;
        }
        return this.mModule.moduleId + "_" + ((GameAppItemData) ((GameModules) getItemData()).itemList.get(0)).resourceKey;
    }

    public void bindHolderAndStartPlay(GameIMAXPlayer videoPlayer) {
        HashMap<Integer, String> hashMap = this.mVideoInfo;
        if (hashMap != null && !hashMap.isEmpty() && this.mVideoContainer != null) {
            videoPlayer.setVideoInfo(this.mVideoInfo);
            videoPlayer.changeToMiniMode();
            videoPlayer.attachToContainer(this.mVideoContainer);
            videoPlayer.setMuteMode(true);
            videoPlayer.startAutoPlay(true);
        }
    }

    public boolean shouldAutoPlay() {
        return true;
    }

    public View getShowedViewForAutoPlaying() {
        return this.mVideoContainer;
    }

    public boolean autoPlayNeedWifi() {
        return false;
    }

    public void onVideoPlayError() {
        showSmallBannerImage();
    }

    public void onVideoPlayStart() {
        hideSmallBannerImage();
    }

    public void onVideoPlayStop() {
        showSmallBannerImage();
    }

    public void onVideoPlayResume() {
        hideSmallBannerImage();
    }

    private void hideSmallBannerImage() {
        GameImageView gameImageView = this.mSmallBanner;
        if (gameImageView != null) {
            gameImageView.setVisibility(8);
        }
    }

    private void showSmallBannerImage() {
        GameImageView gameImageView = this.mSmallBanner;
        if (gameImageView != null) {
            gameImageView.setVisibility(0);
        }
    }

    public void onDisplayStatistic(int position) {
        String bannerType;
        if (this.mModule != null && this.itemView.getVisibility() == 0) {
            if (!GameCenterUBCUtil.isDisplayEventRecorded(this.mModule.moduleId)) {
                HashMap<String, String> ext = GameCenterUBCUtil.buildModuleDisplayExt(this.mModule.moduleId, getUbcModuleTitle(), (position + 1) + "", this.mModule.moduleType);
                ext.put("logid", GameCenterUBCUtil.getLogId(this.mModule));
                if (!(this.mModule == null || this.mModule.itemList == null || this.mModule.itemList.size() <= 0 || this.mModule.itemList.get(0) == null || !(this.mModule.itemList.get(0) instanceof GameTopItemData))) {
                    ext.put(GameUBCConst.EXT_KEY_BANNER_SIZE, GameUBCConst.EXT_VALUE_BANNER_SIZE_LITTLE);
                    if (((GameTopItemData) this.mModule.itemList.get(0)).closeDynamicType == 0) {
                        bannerType = "mp4";
                    } else {
                        bannerType = "pic";
                    }
                    ext.put(GameUBCConst.EXT_KEY_BANNER_TYPE, bannerType);
                }
                if (this.mModule != null && !this.mModule.isNetData) {
                    ext.put("cache", GameDataManager.getInstance().getCurrentDataCacheType());
                }
                ubcGameShow(GameUBCConst.TYPE_SHOW_PARTS, "banner", GameUBCConst.PAGE_FIND_PAGE, ext);
                GameCenterUBCUtil.markDisplayEventRecorded(this.mModule.moduleId);
            }
            HashMap<String, String> itemsExt = buildGamesDisplayExt();
            if (itemsExt != null && !itemsExt.isEmpty()) {
                itemsExt.put("logid", GameCenterUBCUtil.getLogId(this.mModule));
                if (this.mModule != null && !this.mModule.isNetData) {
                    itemsExt.put("cache", GameDataManager.getInstance().getCurrentDataCacheType());
                }
                ubcGameShow("show_items", (String) null, GameUBCConst.PAGE_FIND_PAGE, itemsExt);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onBtnClicked() {
        Object object;
        String bannerType;
        if (this.mModule != null && this.mModule.itemList != null && this.mModule.itemList.size() > 0 && (object = this.mModule.itemList.get(0)) != null && (object instanceof GameTopItemData)) {
            GameTopItemData itemData = (GameTopItemData) this.mModule.itemList.get(0);
            JSONObject ext = new JSONObject();
            try {
                ext.put("id", itemData.resourceKey);
                ext.put("game_id", itemData.appId);
                ext.put(GameUBCConst.EXT_KEY_GAME_TYPE, itemData.type);
                ext.put(GameUBCConst.EXT_KEY_BANNER_CLICK, itemData.dataType);
                ext.put(GameUBCConst.EXT_KEY_BANNER_SIZE, GameUBCConst.EXT_VALUE_BANNER_SIZE_LITTLE);
                if (itemData.closeDynamicType == 0) {
                    bannerType = "mp4";
                } else {
                    bannerType = "pic";
                }
                ext.put(GameUBCConst.EXT_KEY_BANNER_TYPE, bannerType);
                ubcItemClick(this.mModule, 1, -1, ext);
                saveCloudGame();
            } catch (JSONException e2) {
            }
        }
    }

    public void changeAlpha(float startAlpha, float endAlpha) {
        if (this.mRootView != null && this.itemView.getHeight() > 0) {
            this.mRootView.setAlpha(1.0f - ((startAlpha - endAlpha) / ((float) this.itemView.getHeight())));
        }
    }
}
