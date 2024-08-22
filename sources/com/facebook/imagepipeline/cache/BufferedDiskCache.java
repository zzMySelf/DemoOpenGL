package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u00010B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010 \u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"H\u0002J\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0002J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0002J\u0006\u0010(\u001a\u00020\u000fJ\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010*\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\"J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010/\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010+\u001a\u0004\u0018\u00010\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/facebook/imagepipeline/cache/BufferedDiskCache;", "", "fileCache", "Lcom/facebook/cache/disk/FileCache;", "pooledByteBufferFactory", "Lcom/facebook/common/memory/PooledByteBufferFactory;", "pooledByteStreams", "Lcom/facebook/common/memory/PooledByteStreams;", "readExecutor", "Ljava/util/concurrent/Executor;", "writeExecutor", "imageCacheStatsTracker", "Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "(Lcom/facebook/cache/disk/FileCache;Lcom/facebook/common/memory/PooledByteBufferFactory;Lcom/facebook/common/memory/PooledByteStreams;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;)V", "size", "", "getSize", "()J", "stagingArea", "Lcom/facebook/imagepipeline/cache/StagingArea;", "addKeyForAsyncProbing", "", "key", "Lcom/facebook/cache/common/CacheKey;", "checkInStagingAreaAndFileCache", "", "clearAll", "Lbolts/Task;", "Ljava/lang/Void;", "contains", "containsAsync", "containsSync", "diskCheckSync", "foundPinnedImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "pinnedImage", "get", "isCancelled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getAsync", "getCount", "probe", "put", "encodedImage", "readFromDiskCache", "Lcom/facebook/common/memory/PooledByteBuffer;", "remove", "writeToDiskCache", "Companion", "imagepipeline_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BufferedDiskCache.kt */
public final class BufferedDiskCache {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Class<?> TAG = BufferedDiskCache.class;
    private final FileCache fileCache;
    private final ImageCacheStatsTracker imageCacheStatsTracker;
    private final PooledByteBufferFactory pooledByteBufferFactory;
    private final PooledByteStreams pooledByteStreams;
    private final Executor readExecutor;
    private final StagingArea stagingArea;
    private final Executor writeExecutor;

    public BufferedDiskCache(FileCache fileCache2, PooledByteBufferFactory pooledByteBufferFactory2, PooledByteStreams pooledByteStreams2, Executor readExecutor2, Executor writeExecutor2, ImageCacheStatsTracker imageCacheStatsTracker2) {
        Intrinsics.checkNotNullParameter(fileCache2, "fileCache");
        Intrinsics.checkNotNullParameter(pooledByteBufferFactory2, "pooledByteBufferFactory");
        Intrinsics.checkNotNullParameter(pooledByteStreams2, "pooledByteStreams");
        Intrinsics.checkNotNullParameter(readExecutor2, "readExecutor");
        Intrinsics.checkNotNullParameter(writeExecutor2, "writeExecutor");
        Intrinsics.checkNotNullParameter(imageCacheStatsTracker2, "imageCacheStatsTracker");
        this.fileCache = fileCache2;
        this.pooledByteBufferFactory = pooledByteBufferFactory2;
        this.pooledByteStreams = pooledByteStreams2;
        this.readExecutor = readExecutor2;
        this.writeExecutor = writeExecutor2;
        this.imageCacheStatsTracker = imageCacheStatsTracker2;
        StagingArea instance = StagingArea.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        this.stagingArea = instance;
    }

    public final boolean containsSync(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.stagingArea.containsKey(key) || this.fileCache.hasKeySync(key);
    }

    public final Task<Boolean> contains(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!containsSync(key)) {
            return containsAsync(key);
        }
        Task<Boolean> forResult = Task.forResult(true);
        Intrinsics.checkNotNullExpressionValue(forResult, "{\n        Task.forResult(true)\n      }");
        return forResult;
    }

    private final Task<Boolean> containsAsync(CacheKey key) {
        try {
            Task<Boolean> call = Task.call(new BufferedDiskCache$$ExternalSyntheticLambda5(FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_containsAsync"), this, key), this.readExecutor);
            Intrinsics.checkNotNullExpressionValue(call, "{\n      val token = Fres…      readExecutor)\n    }");
            return call;
        } catch (Exception exception) {
            FLog.w(TAG, (Throwable) exception, "Failed to schedule disk-cache read for %s", key.getUriString());
            Task<Boolean> forError = Task.forError(exception);
            Intrinsics.checkNotNullExpressionValue(forError, "{\n      // Log failure\n …forError(exception)\n    }");
            return forError;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: containsAsync$lambda-0  reason: not valid java name */
    public static final Boolean m8186containsAsync$lambda0(Object $token, BufferedDiskCache this$0, CacheKey $key) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($key, "$key");
        Object currentToken = FrescoInstrumenter.onBeginWork($token, (String) null);
        try {
            Boolean valueOf = Boolean.valueOf(this$0.checkInStagingAreaAndFileCache($key));
            FrescoInstrumenter.onEndWork(currentToken);
            return valueOf;
        } catch (Throwable th2) {
            FrescoInstrumenter.onEndWork(currentToken);
            throw th2;
        }
    }

    public final boolean diskCheckSync(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (containsSync(key)) {
            return true;
        }
        return checkInStagingAreaAndFileCache(key);
    }

    public final Task<EncodedImage> get(CacheKey key, AtomicBoolean isCancelled) {
        Task<EncodedImage> task;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(isCancelled, "isCancelled");
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BufferedDiskCache#get");
            }
            EncodedImage pinnedImage = this.stagingArea.get(key);
            if (pinnedImage == null || (task = foundPinnedImage(key, pinnedImage)) == null) {
                task = getAsync(key, isCancelled);
            }
            return task;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public final Task<Void> probe(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Task<Void> call = Task.call(new BufferedDiskCache$$ExternalSyntheticLambda6(FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_probe"), this, key), this.writeExecutor);
            Intrinsics.checkNotNullExpressionValue(call, "{\n      val token = Fres…     writeExecutor)\n    }");
            return call;
        } catch (Exception exception) {
            FLog.w(TAG, (Throwable) exception, "Failed to schedule disk-cache probe for %s", key.getUriString());
            Task<Void> forError = Task.forError(exception);
            Intrinsics.checkNotNullExpressionValue(forError, "{\n      FLog.w(TAG, exce…forError(exception)\n    }");
            return forError;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: probe$lambda-2  reason: not valid java name */
    public static final Void m8188probe$lambda2(Object $token, BufferedDiskCache this$0, CacheKey $key) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($key, "$key");
        Object currentToken = FrescoInstrumenter.onBeginWork($token, (String) null);
        try {
            this$0.fileCache.probe($key);
            return null;
        } finally {
            FrescoInstrumenter.onEndWork(currentToken);
        }
    }

    public final void addKeyForAsyncProbing(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.fileCache.probe(key);
    }

    private final boolean checkInStagingAreaAndFileCache(CacheKey key) {
        EncodedImage result = this.stagingArea.get(key);
        if (result != null) {
            result.close();
            FLog.v(TAG, "Found image for %s in staging area", (Object) key.getUriString());
            this.imageCacheStatsTracker.onStagingAreaHit(key);
            return true;
        }
        FLog.v(TAG, "Did not find image for %s in staging area", (Object) key.getUriString());
        this.imageCacheStatsTracker.onStagingAreaMiss(key);
        try {
            return this.fileCache.hasKey(key);
        } catch (Exception e2) {
            return false;
        }
    }

    private final Task<EncodedImage> getAsync(CacheKey key, AtomicBoolean isCancelled) {
        try {
            Task<EncodedImage> call = Task.call(new BufferedDiskCache$$ExternalSyntheticLambda0(FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_getAsync"), isCancelled, this, key), this.readExecutor);
            Intrinsics.checkNotNullExpressionValue(call, "{\n      val token = Fres…      readExecutor)\n    }");
            return call;
        } catch (Exception exception) {
            FLog.w(TAG, (Throwable) exception, "Failed to schedule disk-cache read for %s", key.getUriString());
            Task<EncodedImage> forError = Task.forError(exception);
            Intrinsics.checkNotNullExpressionValue(forError, "{\n      // Log failure\n …forError(exception)\n    }");
            return forError;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getAsync$lambda-3  reason: not valid java name */
    public static final EncodedImage m8187getAsync$lambda3(Object $token, AtomicBoolean $isCancelled, BufferedDiskCache this$0, CacheKey $key) {
        CloseableReference ref;
        Intrinsics.checkNotNullParameter($isCancelled, "$isCancelled");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($key, "$key");
        Object currentToken = FrescoInstrumenter.onBeginWork($token, (String) null);
        try {
            if (!$isCancelled.get()) {
                EncodedImage result = this$0.stagingArea.get($key);
                if (result != null) {
                    FLog.v(TAG, "Found image for %s in staging area", (Object) $key.getUriString());
                    this$0.imageCacheStatsTracker.onStagingAreaHit($key);
                } else {
                    FLog.v(TAG, "Did not find image for %s in staging area", (Object) $key.getUriString());
                    this$0.imageCacheStatsTracker.onStagingAreaMiss($key);
                    try {
                        PooledByteBuffer buffer = this$0.readFromDiskCache($key);
                        if (buffer == null) {
                            FrescoInstrumenter.onEndWork(currentToken);
                            return null;
                        }
                        ref = CloseableReference.of(buffer);
                        Intrinsics.checkNotNullExpressionValue(ref, "of(buffer)");
                        EncodedImage encodedImage = new EncodedImage((CloseableReference<PooledByteBuffer>) ref);
                        CloseableReference.closeSafely((CloseableReference<?>) ref);
                        result = encodedImage;
                    } catch (Exception e2) {
                        FrescoInstrumenter.onEndWork(currentToken);
                        return null;
                    } catch (Throwable th2) {
                        CloseableReference.closeSafely((CloseableReference<?>) ref);
                        throw th2;
                    }
                }
                if (!Thread.interrupted()) {
                    FrescoInstrumenter.onEndWork(currentToken);
                    EncodedImage encodedImage2 = result;
                    return result;
                }
                FLog.v(TAG, "Host thread was interrupted, decreasing reference count");
                result.close();
                throw new InterruptedException();
            }
            throw new CancellationException();
        } catch (Throwable th3) {
            FrescoInstrumenter.onEndWork(currentToken);
            throw th3;
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 8 */
    public final void put(CacheKey key, EncodedImage encodedImage) {
        EncodedImage finalEncodedImage;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BufferedDiskCache#put");
            }
            if (EncodedImage.isValid(encodedImage)) {
                this.stagingArea.put(key, encodedImage);
                finalEncodedImage = EncodedImage.cloneOrNull(encodedImage);
                this.writeExecutor.execute(new BufferedDiskCache$$ExternalSyntheticLambda4(FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_putAsync"), this, key, finalEncodedImage));
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        } catch (Exception exception) {
            FLog.w(TAG, (Throwable) exception, "Failed to schedule disk-cache write for %s", key.getUriString());
            this.stagingArea.remove(key, encodedImage);
            EncodedImage.closeSafely(finalEncodedImage);
        } catch (Throwable th2) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            throw th2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: put$lambda-4  reason: not valid java name */
    public static final void m8189put$lambda4(Object $token, BufferedDiskCache this$0, CacheKey $key, EncodedImage $finalEncodedImage) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($key, "$key");
        Object currentToken = FrescoInstrumenter.onBeginWork($token, (String) null);
        try {
            this$0.writeToDiskCache($key, $finalEncodedImage);
            StagingArea stagingArea2 = this$0.stagingArea;
            Intrinsics.checkNotNull($finalEncodedImage);
            stagingArea2.remove($key, $finalEncodedImage);
            EncodedImage.closeSafely($finalEncodedImage);
            FrescoInstrumenter.onEndWork(currentToken);
        } catch (Throwable th2) {
            StagingArea stagingArea3 = this$0.stagingArea;
            Intrinsics.checkNotNull($finalEncodedImage);
            stagingArea3.remove($key, $finalEncodedImage);
            EncodedImage.closeSafely($finalEncodedImage);
            FrescoInstrumenter.onEndWork(currentToken);
            throw th2;
        }
    }

    public final Task<Void> remove(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.stagingArea.remove(key);
        try {
            Task<Void> call = Task.call(new BufferedDiskCache$$ExternalSyntheticLambda2(FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_remove"), this, key), this.writeExecutor);
            Intrinsics.checkNotNullExpressionValue(call, "{\n      val token = Fres…     writeExecutor)\n    }");
            return call;
        } catch (Exception exception) {
            FLog.w(TAG, (Throwable) exception, "Failed to schedule disk-cache remove for %s", key.getUriString());
            Task<Void> forError = Task.forError(exception);
            Intrinsics.checkNotNullExpressionValue(forError, "{\n      // Log failure\n …forError(exception)\n    }");
            return forError;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: remove$lambda-5  reason: not valid java name */
    public static final Void m8190remove$lambda5(Object $token, BufferedDiskCache this$0, CacheKey $key) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($key, "$key");
        Object currentToken = FrescoInstrumenter.onBeginWork($token, (String) null);
        try {
            this$0.stagingArea.remove($key);
            this$0.fileCache.remove($key);
            FrescoInstrumenter.onEndWork(currentToken);
            return null;
        } catch (Throwable th2) {
            FrescoInstrumenter.onEndWork(currentToken);
            throw th2;
        }
    }

    public final Task<Void> clearAll() {
        this.stagingArea.clearAll();
        try {
            Task<Void> call = Task.call(new BufferedDiskCache$$ExternalSyntheticLambda1(FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_clearAll"), this), this.writeExecutor);
            Intrinsics.checkNotNullExpressionValue(call, "{\n      Task.call(\n     …     writeExecutor)\n    }");
            return call;
        } catch (Exception exception) {
            FLog.w(TAG, (Throwable) exception, "Failed to schedule disk-cache clear", new Object[0]);
            Task<Void> forError = Task.forError(exception);
            Intrinsics.checkNotNullExpressionValue(forError, "{\n      // Log failure\n …forError(exception)\n    }");
            return forError;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: clearAll$lambda-6  reason: not valid java name */
    public static final Void m8185clearAll$lambda6(Object $token, BufferedDiskCache this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object currentToken = FrescoInstrumenter.onBeginWork($token, (String) null);
        try {
            this$0.stagingArea.clearAll();
            this$0.fileCache.clearAll();
            FrescoInstrumenter.onEndWork(currentToken);
            return null;
        } catch (Throwable th2) {
            FrescoInstrumenter.onEndWork(currentToken);
            throw th2;
        }
    }

    public final long getSize() {
        FileCache fileCache2 = this.fileCache;
        if (fileCache2 != null) {
            return fileCache2.getSize();
        }
        return -1;
    }

    private final Task<EncodedImage> foundPinnedImage(CacheKey key, EncodedImage pinnedImage) {
        FLog.v(TAG, "Found image for %s in staging area", (Object) key.getUriString());
        this.imageCacheStatsTracker.onStagingAreaHit(key);
        Task<EncodedImage> forResult = Task.forResult(pinnedImage);
        Intrinsics.checkNotNullExpressionValue(forResult, "forResult(pinnedImage)");
        return forResult;
    }

    /* Debug info: failed to restart local var, previous not found, register: 6 */
    private final PooledByteBuffer readFromDiskCache(CacheKey key) throws IOException {
        InputStream is;
        try {
            Class<?> cls = TAG;
            FLog.v(cls, "Disk cache read for %s", (Object) key.getUriString());
            BinaryResource diskCacheResource = this.fileCache.getResource(key);
            if (diskCacheResource == null) {
                FLog.v(cls, "Disk cache miss for %s", (Object) key.getUriString());
                this.imageCacheStatsTracker.onDiskCacheMiss(key);
                return null;
            }
            FLog.v(cls, "Found entry in disk cache for %s", (Object) key.getUriString());
            this.imageCacheStatsTracker.onDiskCacheHit(key);
            is = diskCacheResource.openStream();
            PooledByteBuffer byteBuffer = this.pooledByteBufferFactory.newByteBuffer(is, (int) diskCacheResource.size());
            is.close();
            FLog.v(cls, "Successful read from disk cache for %s", (Object) key.getUriString());
            return byteBuffer;
        } catch (IOException ioe) {
            FLog.w(TAG, (Throwable) ioe, "Exception reading from cache for %s", key.getUriString());
            this.imageCacheStatsTracker.onDiskCacheGetFail(key);
            throw ioe;
        } catch (Throwable th2) {
            is.close();
            throw th2;
        }
    }

    private final void writeToDiskCache(CacheKey key, EncodedImage encodedImage) {
        Class<?> cls = TAG;
        FLog.v(cls, "About to write to disk-cache for key %s", (Object) key.getUriString());
        try {
            this.fileCache.insert(key, new BufferedDiskCache$$ExternalSyntheticLambda3(encodedImage, this));
            this.imageCacheStatsTracker.onDiskCachePut(key);
            FLog.v(cls, "Successful disk-cache write for key %s", (Object) key.getUriString());
        } catch (IOException ioe) {
            FLog.w(TAG, (Throwable) ioe, "Failed to write to disk-cache for key %s", key.getUriString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: writeToDiskCache$lambda-7  reason: not valid java name */
    public static final void m8191writeToDiskCache$lambda7(EncodedImage $encodedImage, BufferedDiskCache this$0, OutputStream os) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNull($encodedImage);
        InputStream inputStream = $encodedImage.getInputStream();
        if (inputStream != null) {
            this$0.pooledByteStreams.copy(inputStream, os);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/imagepipeline/cache/BufferedDiskCache$Companion;", "", "()V", "TAG", "Ljava/lang/Class;", "imagepipeline_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BufferedDiskCache.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final long getCount() {
        FileCache fileCache2 = this.fileCache;
        if (fileCache2 != null) {
            return fileCache2.getCount();
        }
        return -1;
    }
}
