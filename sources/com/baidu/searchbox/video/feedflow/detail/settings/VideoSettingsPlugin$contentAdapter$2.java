package com.baidu.searchbox.video.feedflow.detail.settings;

import android.content.Context;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.FlowComponentConstantManifestKt;
import com.baidu.searchbox.video.feedflow.detail.banner.videolabel.VideoLabelPanelPluginKt;
import com.baidu.searchbox.video.feedflow.detail.settings.gesturalpanel.VideoSettingGesturalPanelAdapter;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/detail/settings/gesturalpanel/VideoSettingGesturalPanelAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoSettingsPlugin.kt */
final class VideoSettingsPlugin$contentAdapter$2 extends Lambda implements Function0<VideoSettingGesturalPanelAdapter> {
    final /* synthetic */ VideoSettingsPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoSettingsPlugin$contentAdapter$2(VideoSettingsPlugin videoSettingsPlugin) {
        super(0);
        this.this$0 = videoSettingsPlugin;
    }

    public final VideoSettingGesturalPanelAdapter invoke() {
        int style;
        Context access$getContext = this.this$0.getContext();
        Store access$getStore = this.this$0.getStore();
        VideoSettingsPlugin videoSettingsPlugin = this.this$0;
        VideoSettingGesturalPanelAdapter videoSettingGesturalPanelAdapter = new VideoSettingGesturalPanelAdapter(access$getContext, access$getStore, videoSettingsPlugin, videoSettingsPlugin.getManager());
        VideoSettingsPlugin videoSettingsPlugin2 = this.this$0;
        VideoSettingGesturalPanelAdapter adapter = videoSettingGesturalPanelAdapter;
        if (DIFactory.INSTANCE.isPadPanelConfigSwitch()) {
            style = 6;
        } else {
            style = VideoLabelPanelPluginKt.getCommonListPanelItemStyle(videoSettingsPlugin2.getStore());
        }
        adapter.switchStyle(style);
        adapter.setLandscapeMode(new VideoSettingsPlugin$contentAdapter$2$$ExternalSyntheticLambda0());
        adapter.setPanelType(FlowComponentConstantManifestKt.PANEL_TYPE_VIDEO_SETTING_PANEL);
        adapter.setPanelShowListener(new VideoSettingsPlugin$contentAdapter$2$1$2(videoSettingsPlugin2));
        adapter.setIMoreVideoSettingWindowListener(videoSettingsPlugin2.windowListener);
        return videoSettingGesturalPanelAdapter;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
    public static final boolean m13463invoke$lambda1$lambda0() {
        return false;
    }
}
