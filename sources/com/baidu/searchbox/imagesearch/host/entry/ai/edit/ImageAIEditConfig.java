package com.baidu.searchbox.imagesearch.host.entry.ai.edit;

import com.baidu.searchbox.account.im.GroupMemberAdapter;
import com.baidu.searchbox.imagesearch.common.common.config.UpdateConfigManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010\u0017\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0001J\u0006\u0010\u001a\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/imagesearch/host/entry/ai/edit/ImageAIEditConfig;", "", "()V", "KEY_AI_HOST", "", "KEY_COMPRESS_QUALITY", "KEY_MAX_LENGTH", "KEY_MAX_SIZE", "KEY_MAX_SIZE_PER_REQUEST", "KEY_PARALLEL_REQUEST", "KEY_RETRY_COUNT", "aiEditHost", "maxByteSize", "", "maxByteSizePerRequest", "maxCompressQuality", "maxLength", "parallelRequest", "retryCount", "getImageAIEditHost", "getImageCompressQuality", "getMaxByteSizePerRequest", "getMaxImageByteSize", "getMaxImageLength", "getMockLocalFileName", "any", "getParallelRequest", "getRetryCount", "lib-entry_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageAIEditConfig.kt */
public final class ImageAIEditConfig {
    public static final ImageAIEditConfig INSTANCE = new ImageAIEditConfig();
    private static final String KEY_AI_HOST = "host";
    private static final String KEY_COMPRESS_QUALITY = "compress_quality";
    private static final String KEY_MAX_LENGTH = "max_length";
    private static final String KEY_MAX_SIZE = "max_size";
    private static final String KEY_MAX_SIZE_PER_REQUEST = "max_request_size";
    private static final String KEY_PARALLEL_REQUEST = "parallel_request";
    private static final String KEY_RETRY_COUNT = "retry_count";
    private static String aiEditHost;
    private static int maxByteSize;
    private static int maxByteSizePerRequest;
    private static int maxCompressQuality;
    private static int maxLength;
    private static int parallelRequest;
    private static int retryCount;

    private ImageAIEditConfig() {
    }

    public final String getImageAIEditHost() {
        return aiEditHost;
    }

    public final int getMaxImageByteSize() {
        return maxByteSize;
    }

    public final int getMaxImageLength() {
        return maxLength;
    }

    public final int getImageCompressQuality() {
        return maxCompressQuality;
    }

    public final int getRetryCount() {
        return retryCount;
    }

    public final String getMockLocalFileName(Object any) {
        Intrinsics.checkNotNullParameter(any, "any");
        return any.hashCode() + GroupMemberAdapter.MANAGER_CHAR + System.currentTimeMillis() + ".jpg";
    }

    public final int getMaxByteSizePerRequest() {
        return maxByteSizePerRequest;
    }

    public final int getParallelRequest() {
        return parallelRequest;
    }

    static {
        aiEditHost = "https://m.baidu.com/sf/vsearch/image/aigc/pic_upload";
        maxByteSize = 1048576;
        maxByteSizePerRequest = 786432;
        maxLength = 2000;
        maxCompressQuality = 80;
        retryCount = 2;
        parallelRequest = 10;
        try {
            Result.Companion companion = Result.Companion;
            JSONObject config = new JSONObject(UpdateConfigManager.INSTANCE.getUpdateConfig(UpdateConfigManager.KEY_IMAGE_SEARCH_AI_EDIT_CONFIG)).optJSONObject(UpdateConfigManager.KEY_IMAGE_SEARCH_AI_EDIT_CONFIG);
            if (config != null) {
                String optString = config.optString("host");
                Intrinsics.checkNotNullExpressionValue(optString, "config.optString(KEY_AI_HOST)");
                aiEditHost = optString;
                maxByteSize = config.optInt(KEY_MAX_SIZE);
                maxLength = config.optInt(KEY_MAX_LENGTH);
                maxCompressQuality = config.optInt(KEY_COMPRESS_QUALITY);
                retryCount = config.optInt("retry_count");
                maxByteSizePerRequest = config.optInt(KEY_MAX_SIZE_PER_REQUEST);
                parallelRequest = config.optInt(KEY_PARALLEL_REQUEST);
            }
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }
}
