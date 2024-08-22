package com.mars.kotlin.extension;

import android.database.ContentObserver;
import android.os.Handler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/mars/kotlin/extension/UriKt$observe$1", "Landroid/database/ContentObserver;", "", "selfChange", "", "onChange", "(Z)V", "x_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class UriKt$observe$1 extends ContentObserver {
    public final /* synthetic */ Function1 $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UriKt$observe$1(Function1 function1, Handler handler) {
        super(handler);
        this.$callback = function1;
    }

    public void onChange(boolean z) {
        super.onChange(z);
        this.$callback.invoke(this);
    }
}
