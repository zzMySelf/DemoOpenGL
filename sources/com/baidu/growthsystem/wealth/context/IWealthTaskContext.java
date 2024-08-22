package com.baidu.growthsystem.wealth.context;

import android.view.ViewGroup;
import com.baidu.growthsystem.wealth.context.player.VideoPlayerController;
import com.baidu.growthsystem.wealth.context.popupinterceptor.DialogPopupInterceptor;
import com.baidu.growthsystem.wealth.context.statistics.IVideoStatisticsProcessor;
import com.baidu.growthsystem.wealth.dialog.scrollguide.IWealthTaskScrollGuideCreator;
import com.baidu.growthsystem.wealth.dialog.seq.IWealthTaskDialogSeqExecutor;
import com.baidu.growthsystem.wealth.dialog.seq.WealthTaskDialogSeqConfig;
import com.baidu.growthsystem.wealth.payment.component.IWealthPaymentComponent;
import com.baidu.growthsystem.wealth.scenes.SceneModel;
import com.baidu.growthsystem.wealth.video.component.IWealthVideoComponent;
import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0005H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0003H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0014H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0014H&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0005H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\fH&J\u0012\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010+H&J\u0012\u0010,\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u000200H&J\u0010\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0005H&¨\u00063"}, d2 = {"Lcom/baidu/growthsystem/wealth/context/IWealthTaskContext;", "", "closeWealthTaskDialog", "", "type", "", "createWealthTaskDialogSeqExecutor", "Lcom/baidu/growthsystem/wealth/dialog/seq/IWealthTaskDialogSeqExecutor;", "config", "Lcom/baidu/growthsystem/wealth/dialog/seq/WealthTaskDialogSeqConfig;", "getPageTag", "getSceneModel", "Lcom/baidu/growthsystem/wealth/scenes/SceneModel;", "getTalosContainer", "Landroid/view/ViewGroup;", "getWealthPaymentComponent", "Lcom/baidu/growthsystem/wealth/payment/component/IWealthPaymentComponent;", "getWealthVideoComponent", "Lcom/baidu/growthsystem/wealth/video/component/IWealthVideoComponent;", "isPrevWealthTaskDialogSeqUnfinished", "", "isWealthTaskDialogShowing", "onDestroy", "onPause", "onResume", "onVideoPlayerPause", "isUserActive", "onVideoPlayerResume", "onVideoStatisticsReported", "onWindowFocusChanged", "hasWindowFocus", "setDialogPopupInterceptor", "interceptor", "Lcom/baidu/growthsystem/wealth/context/popupinterceptor/DialogPopupInterceptor;", "setPageTag", "tag", "setPlayerController", "playerController", "Lcom/baidu/growthsystem/wealth/context/player/VideoPlayerController;", "setSceneModel", "sceneModel", "setScrollGuideCreator", "creator", "Lcom/baidu/growthsystem/wealth/dialog/scrollguide/IWealthTaskScrollGuideCreator;", "setTalosContainer", "container", "setVideoStatisticsProcessor", "processor", "Lcom/baidu/growthsystem/wealth/context/statistics/IVideoStatisticsProcessor;", "setVideoTemplateType", "tplType", "wealth-task-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IWealthTaskContext.kt */
public interface IWealthTaskContext {
    void closeWealthTaskDialog();

    void closeWealthTaskDialog(String str);

    IWealthTaskDialogSeqExecutor createWealthTaskDialogSeqExecutor(WealthTaskDialogSeqConfig wealthTaskDialogSeqConfig);

    String getPageTag();

    SceneModel getSceneModel();

    ViewGroup getTalosContainer();

    IWealthPaymentComponent getWealthPaymentComponent();

    IWealthVideoComponent getWealthVideoComponent();

    boolean isPrevWealthTaskDialogSeqUnfinished();

    boolean isWealthTaskDialogShowing();

    boolean isWealthTaskDialogShowing(String str);

    void onDestroy();

    void onPause();

    void onResume();

    void onVideoPlayerPause(boolean z);

    void onVideoPlayerResume();

    void onVideoStatisticsReported();

    void onWindowFocusChanged(boolean z);

    void setDialogPopupInterceptor(DialogPopupInterceptor dialogPopupInterceptor);

    void setPageTag(String str);

    void setPlayerController(VideoPlayerController videoPlayerController);

    void setSceneModel(SceneModel sceneModel);

    void setScrollGuideCreator(IWealthTaskScrollGuideCreator iWealthTaskScrollGuideCreator);

    void setTalosContainer(ViewGroup viewGroup);

    void setVideoStatisticsProcessor(IVideoStatisticsProcessor iVideoStatisticsProcessor);

    void setVideoTemplateType(String str);
}
