package com.baidu.awareness.impl;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.awareness.state.StorageState;

class StorageCollector extends BaseCollector<StorageState> {
    private static final long KILOBYTE = 1024;
    private StatFs mExternalStatFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
    private StatFs mInternalStatFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());

    StorageCollector(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void start() {
        super.start();
        L.d("StorageCollector start");
        this.mOnCollectFinishListener.onCollectFinish(10, tryToGetInstantData());
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        super.stop();
        L.d("StorageCollector stop");
        this.mInternalStatFs = null;
        this.mExternalStatFs = null;
        this.mOnCollectFinishListener.onCollectFinish(10, (BaseState) null);
    }

    /* access modifiers changed from: package-private */
    public long autoDestoryTime() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public StorageState tryToGetInstantData() {
        StorageState storageState = new StorageState();
        storageState.updateTime = System.currentTimeMillis();
        storageState.avaiableStorage = ((this.mInternalStatFs.getAvailableBlocksLong() * this.mInternalStatFs.getBlockSizeLong()) / 1048576) + ((this.mExternalStatFs.getAvailableBlocksLong() * this.mExternalStatFs.getBlockSizeLong()) / 1048576);
        storageState.totalStorage = ((this.mInternalStatFs.getBlockCountLong() * this.mInternalStatFs.getBlockSizeLong()) / 1048576) + ((this.mExternalStatFs.getBlockCountLong() * this.mExternalStatFs.getBlockSizeLong()) / 1048576);
        return storageState;
    }
}
