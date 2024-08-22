package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/imagepipeline/memory/DefaultByteArrayPoolParams;", "", "()V", "DEFAULT_BUCKET_SIZE", "", "DEFAULT_IO_BUFFER_SIZE", "MAX_SIZE_HARD_CAP", "MAX_SIZE_SOFT_CAP", "get", "Lcom/facebook/imagepipeline/memory/PoolParams;", "imagepipeline_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultByteArrayPoolParams.kt */
public final class DefaultByteArrayPoolParams {
    private static final int DEFAULT_BUCKET_SIZE = 5;
    private static final int DEFAULT_IO_BUFFER_SIZE = 16384;
    public static final DefaultByteArrayPoolParams INSTANCE = new DefaultByteArrayPoolParams();
    private static final int MAX_SIZE_HARD_CAP = 1048576;
    private static final int MAX_SIZE_SOFT_CAP = 81920;

    private DefaultByteArrayPoolParams() {
    }

    @JvmStatic
    public static final PoolParams get() {
        SparseIntArray defaultBuckets = new SparseIntArray();
        defaultBuckets.put(16384, 5);
        return new PoolParams(81920, 1048576, defaultBuckets);
    }
}
