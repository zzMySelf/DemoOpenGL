package com.baidu.searchbox.download.center.clearcache.view.funison.download;

import android.app.Activity;
import android.content.Intent;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.searchbox.download.center.ui.autobackup.transcode.TranscodeFileDeleteUtils;
import com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer;
import com.baidu.searchbox.download.center.ui.video.vulcan.VulcanControlLayerCallback;
import com.baidu.searchbox.downloadcenter.service.DownloadCenterFunConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/download/center/clearcache/view/funison/download/ClearCacheDownloadVideoActivity$doPlayVideo$3", "Lcom/baidu/searchbox/download/center/ui/video/vulcan/VulcanControlLayerCallback;", "onBackClick", "", "onFloatingBackClick", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearCacheDownloadVideoActivity.kt */
public final class ClearCacheDownloadVideoActivity$doPlayVideo$3 extends VulcanControlLayerCallback {
    final /* synthetic */ DownloadFileInfo $downloadFileInfo;
    final /* synthetic */ ClearCacheDownloadVideoActivity this$0;

    ClearCacheDownloadVideoActivity$doPlayVideo$3(ClearCacheDownloadVideoActivity $receiver, DownloadFileInfo $downloadFileInfo2) {
        this.this$0 = $receiver;
        this.$downloadFileInfo = $downloadFileInfo2;
    }

    public void onBackClick() {
        super.onBackClick();
        this.this$0.useImmersion(true, true);
        DownloadVulcanVideoPlayer access$getMLocalVideoPlayer$p = this.this$0.mLocalVideoPlayer;
        if (access$getMLocalVideoPlayer$p != null) {
            access$getMLocalVideoPlayer$p.release();
        }
        this.this$0.mLocalVideoPlayer = null;
        TranscodeFileDeleteUtils.INSTANCE.setVideoFilePathPlaying((String) null);
    }

    public void onFloatingBackClick() {
        ClearCacheDownloadVideoActivity.Companion.setSFloatBackPlayData(this.$downloadFileInfo);
        ClearCacheDownloadVideoActivity context = this.this$0;
        Intent gridCategoryIntent = new Intent(context, ClearCacheDownloadVideoActivity.class);
        gridCategoryIntent.putExtra("downloadCategory", 0);
        gridCategoryIntent.putExtra(DownloadCenterFunConstants.LOCAL_PLAYER_FLOAT_CLICK_BACK, true);
        ActivityUtils.startActivitySafely((Activity) context, gridCategoryIntent);
    }
}
