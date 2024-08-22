package com.baidu.thor.memory;

import android.app.Service;
import android.content.Intent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&¨\u0006\r"}, d2 = {"Lcom/baidu/thor/memory/IMemoryService;", "", "onCreate", "", "onDestroy", "onStartCommand", "", "service", "Landroid/app/Service;", "intent", "Landroid/content/Intent;", "flags", "StartId", "lib-memory-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IMemoryService.kt */
public interface IMemoryService {
    void onCreate();

    void onDestroy();

    int onStartCommand(Service service, Intent intent, int i2, int i3);
}
