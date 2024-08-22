package com.baidu.netdisk.transfer.transmitter.statistics;

import android.os.Handler;
import android.os.Looper;
import com.baidu.netdisk.kernel.architecture.debug.LogKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ4\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/netdisk/transfer/transmitter/statistics/UploadBlockTotalReporter;", "", "()V", "currentBucket", "Lcom/baidu/netdisk/transfer/transmitter/statistics/UploadTotalSizeBucket;", "addDataSize", "", "sizeByte", "", "allTaskEnd", "blockEnd", "blockIsSuccess", "", "blockStart", "taskIdentity", "", "fileSize", "blockIndex", "", "uploadId", "hostAddress", "getUploadBucket", "component_transmitter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UploadBlockTotalReporter.kt */
public final class UploadBlockTotalReporter {
    public static final UploadBlockTotalReporter INSTANCE = new UploadBlockTotalReporter();
    private static UploadTotalSizeBucket currentBucket;

    private UploadBlockTotalReporter() {
    }

    public final synchronized void blockStart(String taskIdentity, long fileSize, int blockIndex, String uploadId, String hostAddress) {
        if (taskIdentity != null) {
            UploadTotalSizeBucket current = getUploadBucket();
            if (current != null) {
                current.addBlockInfo(taskIdentity, fileSize, blockIndex, uploadId, hostAddress);
            }
        }
    }

    public final synchronized void blockEnd(boolean blockIsSuccess) {
        UploadTotalSizeBucket uploadTotalSizeBucket = currentBucket;
        if (uploadTotalSizeBucket != null) {
            uploadTotalSizeBucket.report(blockIsSuccess);
        }
        currentBucket = null;
    }

    public final synchronized void allTaskEnd() {
        if (currentBucket != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new UploadBlockTotalReporter$$ExternalSyntheticLambda0(), 500);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: allTaskEnd$lambda-0  reason: not valid java name */
    public static final void m14281allTaskEnd$lambda0() {
        currentBucket = null;
    }

    public final void addDataSize(long sizeByte) {
        LogKt.d("Add data size: " + sizeByte);
        UploadTotalSizeBucket uploadTotalSizeBucket = currentBucket;
        if (uploadTotalSizeBucket != null) {
            uploadTotalSizeBucket.addDataSize(sizeByte);
        }
    }

    private final UploadTotalSizeBucket getUploadBucket() {
        if (currentBucket == null) {
            currentBucket = new UploadTotalSizeBucket();
        }
        return currentBucket;
    }
}
