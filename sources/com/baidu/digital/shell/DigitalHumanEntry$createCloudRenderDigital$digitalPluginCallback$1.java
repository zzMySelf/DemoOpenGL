package com.baidu.digital.shell;

import com.baidu.digital.shell.DigitalHumanEntry;
import com.baidu.digital.shell.DigitalPluginManager;
import com.baidu.searchbox.components.digitalhuman.entry.IDigitalPluginEntry;
import com.baidu.searchbox.components.digitalhuman.service.error.ErrorData;
import com.baidu.searchbox.components.digitalhuman.service.error.ErrorType;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/baidu/digital/shell/DigitalHumanEntry$createCloudRenderDigital$digitalPluginCallback$1", "Lcom/baidu/digital/shell/DigitalPluginManager$IDigitalPluginLoadCallback;", "onLoadFail", "", "retCode", "", "retMsg", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "onLoadProgress", "downloadedSize", "", "totalSize", "onLoadSuccess", "digitalPluginEntry", "Lcom/baidu/searchbox/components/digitalhuman/entry/IDigitalPluginEntry;", "baidu-shell_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DigitalHumanEntry.kt */
public final class DigitalHumanEntry$createCloudRenderDigital$digitalPluginCallback$1 implements DigitalPluginManager.IDigitalPluginLoadCallback {
    final /* synthetic */ DigitalHumanEntry.DigitalHumanCreateCallback $createDigitalHumanCallback;
    final /* synthetic */ DigitalHumanEntry$createCloudRenderDigital$createRtcRoomCallback$1 $createRtcRoomCallback;
    final /* synthetic */ Ref.ObjectRef<IDigitalPluginEntry> $localPluginEntry;

    DigitalHumanEntry$createCloudRenderDigital$digitalPluginCallback$1(Ref.ObjectRef<IDigitalPluginEntry> $localPluginEntry2, DigitalHumanEntry$createCloudRenderDigital$createRtcRoomCallback$1 $createRtcRoomCallback2, DigitalHumanEntry.DigitalHumanCreateCallback $createDigitalHumanCallback2) {
        this.$localPluginEntry = $localPluginEntry2;
        this.$createRtcRoomCallback = $createRtcRoomCallback2;
        this.$createDigitalHumanCallback = $createDigitalHumanCallback2;
    }

    public void onLoadSuccess(IDigitalPluginEntry digitalPluginEntry) {
        DigitalHumanEntry.INSTANCE.log("onCreate onLoadSuccess");
        this.$localPluginEntry.element = digitalPluginEntry;
        if (digitalPluginEntry != null) {
            digitalPluginEntry.createDigitalRtcRoomEntry(this.$createRtcRoomCallback);
        }
    }

    public void onLoadProgress(long downloadedSize, long totalSize) {
        DigitalHumanEntry.INSTANCE.log("onCreate onLoadProgress " + downloadedSize + ", " + totalSize);
    }

    public void onLoadFail(Integer retCode, String retMsg) {
        DigitalHumanEntry.INSTANCE.log("onCreate onLoadFail " + retCode + ", " + retMsg);
        this.$createDigitalHumanCallback.onError(new ErrorData(ErrorType.DIGITAL_PLUGIN, retCode != null ? retCode.toString() : null, retMsg, true));
    }
}
