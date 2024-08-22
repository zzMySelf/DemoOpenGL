package com.baidu.searchbox.video.feedflow.ad.tailframe;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.ad.download.data.AdDownload;
import com.baidu.searchbox.ad.tailframe.ITailActionListener;
import com.baidu.searchbox.feed.ad.model.ExtData;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.ad.detail.AdData;
import com.baidu.searchbox.video.feedflow.ad.detail.AdDataState;
import com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameAction;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016¨\u0006\u001a"}, d2 = {"com/baidu/searchbox/video/feedflow/ad/tailframe/AdTailFrameComponent$createView$2", "Lcom/baidu/searchbox/ad/tailframe/ITailActionListener;", "onAppInfoClick", "", "area", "", "isInvokeCmd", "", "onCommandButtonClick", "onCountDownFinish", "pos", "", "onDownloadButtonClick", "adDownload", "Lcom/baidu/searchbox/ad/download/data/AdDownload;", "onDownloadButtonSendALS", "actionType", "daArea", "download", "onHotAreaClick", "onLandscapeBackBtnClick", "onLeftCommandBtnClick", "onLeftDownloadBtnClick", "onReplayButtonClick", "onRightCommandBtnClick", "onRightDownloadBtnClick", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdTailFrameComponent.kt */
public final class AdTailFrameComponent$createView$2 implements ITailActionListener {
    final /* synthetic */ AdTailFrameComponent this$0;

    AdTailFrameComponent$createView$2(AdTailFrameComponent $receiver) {
        this.this$0 = $receiver;
    }

    public /* bridge */ /* synthetic */ void onAppInfoClick(String area, Boolean isInvokeCmd) {
        onAppInfoClick(area, isInvokeCmd.booleanValue());
    }

    public void onHotAreaClick(String area) {
        this.this$0.removeCountdown();
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(new AdTailFrameAction.HotAreaClickAction(area));
        }
    }

    public void onReplayButtonClick() {
        this.this$0.removeCountdown();
        this.this$0.repeatCount = 0;
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(AdTailFrameAction.ReplayClickAction.INSTANCE);
        }
    }

    public void onAppInfoClick(String area, boolean isInvokeCmd) {
        this.this$0.removeCountdown();
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(new AdTailFrameAction.AppInfoClickAction(area));
        }
    }

    public void onDownloadButtonClick(AdDownload adDownload) {
        AbsState absState;
        AdDataState adDataState;
        MutableLiveData<AdData> data;
        AdData value;
        ExtData extraData;
        Store access$getStore;
        Store access$getStore2 = this.this$0.getStore();
        if (!(access$getStore2 == null || (absState = (AbsState) access$getStore2.getState()) == null || (adDataState = (AdDataState) absState.select(AdDataState.class)) == null || (data = adDataState.getData()) == null || (value = data.getValue()) == null || (extraData = value.getExtraData()) == null || extraData.adDownload == null || (access$getStore = this.this$0.getStore()) == null)) {
            access$getStore.dispatch(AdTailFrameAction.DownloadButtonClickAction.INSTANCE);
        }
        this.this$0.removeCountdown();
    }

    public void onDownloadButtonSendALS(String actionType, String daArea, AdDownload download) {
        Store access$getStore;
        if (actionType != null && download != null && (access$getStore = this.this$0.getStore()) != null) {
            access$getStore.dispatch(new AdTailFrameAction.DownloadAlsSenderAction(actionType, daArea));
        }
    }

    public void onCountDownFinish(int pos) {
    }

    public void onCommandButtonClick(String area) {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(new AdTailFrameAction.CommandButtonClickAction(area));
        }
        this.this$0.removeCountdown();
    }

    public void onLandscapeBackBtnClick() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, AdTailFrameAction.LandscapeBackBtnClick.INSTANCE);
        }
    }

    public void onLeftCommandBtnClick() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, AdTailFrameAction.LeftCommandBtnClickAction.INSTANCE);
        }
    }

    public void onLeftDownloadBtnClick() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, AdTailFrameAction.LeftDownloadBtnClickAction.INSTANCE);
        }
        this.this$0.removeCountdown();
    }

    public void onRightCommandBtnClick() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, AdTailFrameAction.RightCommandBtnClickAction.INSTANCE);
        }
    }

    public void onRightDownloadBtnClick() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, AdTailFrameAction.RightDownloadBtnClickAction.INSTANCE);
        }
        this.this$0.removeCountdown();
    }
}
