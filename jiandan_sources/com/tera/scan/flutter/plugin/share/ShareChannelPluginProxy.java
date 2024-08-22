package com.tera.scan.flutter.plugin.share;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.ubc.UBCManager;
import com.tera.scan.flutter.plugin.BaseFlutterPlugin;
import fe.mmm.qw.p024if.pf.de.rg;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/tera/scan/flutter/plugin/share/ShareChannelPluginProxy;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tera/scan/flutter/plugin/BaseFlutterPlugin;", "()V", "channelName", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "flutter-plugin-proxy_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ShareChannelPluginProxy extends BaseFlutterPlugin implements FlutterPlugin {
    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        return false;
    }

    public void onMethodCall(@NotNull @NonNull MethodCall methodCall, @NotNull @NonNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) "shareMixImages")) {
            ArrayList arrayList = (ArrayList) methodCall.argument("filesList");
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            boolean areEqual = Intrinsics.areEqual(methodCall.argument("shouldReplyPDFShare"), (Object) Boolean.TRUE);
            rg.qw(ad(), arrayList, Intrinsics.areEqual(methodCall.argument("isUploaded"), (Object) Boolean.TRUE), (String) methodCall.argument("fileName"), (String) methodCall.argument(UBCManager.CONTENT_KEY_SOURCE), Boolean.valueOf(areEqual));
            return;
        }
        result.notImplemented();
    }

    @NotNull
    public String qw() {
        return "share_channel";
    }
}
