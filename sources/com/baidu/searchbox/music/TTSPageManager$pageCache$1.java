package com.baidu.searchbox.music;

import android.app.Activity;
import android.util.Log;
import androidx.collection.LruCache;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.swan.apps.display.SwanDisplayChangeEvent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001J6\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0014¨\u0006\f"}, d2 = {"com/baidu/searchbox/music/TTSPageManager$pageCache$1", "Landroidx/collection/LruCache;", "", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "entryRemoved", "", "evicted", "", "key", "oldValue", "newValue", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TTSPageManager.kt */
public final class TTSPageManager$pageCache$1 extends LruCache<String, WeakReference<Activity>> {
    TTSPageManager$pageCache$1() {
        super(5);
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean evicted, String key, WeakReference<Activity> oldValue, WeakReference<Activity> newValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(oldValue, SwanDisplayChangeEvent.KEY_OLD_VALUE);
        super.entryRemoved(evicted, key, oldValue, newValue);
        Activity $this$entryRemoved_u24lambda_u2d0 = (Activity) oldValue.get();
        if ($this$entryRemoved_u24lambda_u2d0 != null && !ActivityUtils.isDestroyed($this$entryRemoved_u24lambda_u2d0)) {
            $this$entryRemoved_u24lambda_u2d0.finish();
            if (TTSPageManagerKt.DEBUG) {
                Log.i("TTSPageManager", "remove activity cache " + $this$entryRemoved_u24lambda_u2d0 + " and do finish! and evicted: " + evicted + " and key: " + key + " and newActivity: " + (newValue != null ? (Activity) newValue.get() : null));
            }
        }
    }
}
