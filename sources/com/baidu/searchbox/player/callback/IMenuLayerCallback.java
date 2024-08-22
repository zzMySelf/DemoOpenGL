package com.baidu.searchbox.player.callback;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/player/callback/IMenuLayerCallback;", "", "onBarrageSettingClick", "", "onBarrageSettingEntryShow", "onBrightDrags", "onDownloadClick", "onMirrorClick", "onVolumeDrags", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IMenuLayerCallback.kt */
public interface IMenuLayerCallback {
    void onBarrageSettingClick();

    void onBarrageSettingEntryShow();

    void onBrightDrags();

    void onDownloadClick();

    void onMirrorClick();

    void onVolumeDrags();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IMenuLayerCallback.kt */
    public static final class DefaultImpls {
        public static void onDownloadClick(IMenuLayerCallback iMenuLayerCallback) {
        }

        public static void onVolumeDrags(IMenuLayerCallback iMenuLayerCallback) {
        }

        public static void onBrightDrags(IMenuLayerCallback iMenuLayerCallback) {
        }

        public static void onBarrageSettingEntryShow(IMenuLayerCallback iMenuLayerCallback) {
        }

        public static void onBarrageSettingClick(IMenuLayerCallback iMenuLayerCallback) {
        }
    }
}
