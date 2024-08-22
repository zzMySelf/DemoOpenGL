package com.mars.united.core.os.storage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mars.united.core.os.storage.SdCardObservable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/mars/united/core/os/storage/SdCardObservable$sdcardReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SdCardObservable$sdcardReceiver$1 extends BroadcastReceiver {
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (Intrinsics.areEqual((Object) intent == null ? null : intent.getAction(), (Object) "android.intent.action.MEDIA_MOUNTED")) {
            for (Map.Entry value : SdCardObservable.f6659ad.entrySet()) {
                ((SdCardObservable.IObserver) value.getValue()).qw();
            }
        }
    }
}
