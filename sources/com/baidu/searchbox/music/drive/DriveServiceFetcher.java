package com.baidu.searchbox.music.drive;

import com.baidu.pyramid.annotation.ServiceProvider;
import com.baidu.pyramid.runtime.service.ServiceFetcher;
import com.baidu.searchbox.music.IDriveManager;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/music/drive/DriveServiceFetcher;", "Lcom/baidu/pyramid/runtime/service/ServiceFetcher;", "Lcom/baidu/searchbox/music/IDriveManager;", "()V", "iDriveService", "getService", "lib-music-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ServiceProvider(module = "music", name = "IDriveService")
/* compiled from: IDriveServiceFetcher.kt */
public final class DriveServiceFetcher implements ServiceFetcher<IDriveManager> {
    private IDriveManager iDriveService;

    public IDriveManager getService() {
        synchronized (this) {
            if (this.iDriveService == null) {
                this.iDriveService = new DriveManagerImpl();
            }
            Unit unit = Unit.INSTANCE;
        }
        IDriveManager iDriveManager = this.iDriveService;
        if (iDriveManager != null) {
            return iDriveManager;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.music.IDriveManager");
    }
}
