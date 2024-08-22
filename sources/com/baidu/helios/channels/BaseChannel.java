package com.baidu.helios.channels;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.helios.common.storage.HeliosStorageManager;
import com.baidu.helios.ids.IdProviderFactory;
import java.util.Comparator;
import org.json.JSONObject;

public abstract class BaseChannel {
    public static Comparator<BaseChannel> CHANNEL_PRIORITY_COMPARATOR = new Comparator<BaseChannel>() {
        /* renamed from: a */
        public int compare(BaseChannel baseChannel, BaseChannel baseChannel2) {
            int i2 = ((baseChannel.getPriority() - baseChannel2.getPriority()) > 0 ? 1 : ((baseChannel.getPriority() - baseChannel2.getPriority()) == 0 ? 0 : -1));
            return i2 != 0 ? i2 > 0 ? -1 : 1 : baseChannel.getName().compareTo(baseChannel2.getName());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    static final String f12758a = "cs";
    protected AttachInfo attachInfo;

    /* renamed from: b  reason: collision with root package name */
    private final String f12759b;

    /* renamed from: c  reason: collision with root package name */
    private long f12760c;
    protected HeliosStorageManager.StorageSession storageSessionBase;

    public static class AttachInfo {
        public Context applicationContext;
        public IdProviderFactory idProviderFactory;
        public HeliosStorageManager storageManager;
    }

    public static abstract class BaseTargetIdCacheData {

        /* renamed from: e  reason: collision with root package name */
        private static final String f12761e = "target-pkg-";

        /* renamed from: f  reason: collision with root package name */
        private static final int f12762f = 3;

        /* renamed from: a  reason: collision with root package name */
        private HeliosStorageManager.StorageSession f12763a;

        /* renamed from: b  reason: collision with root package name */
        private String f12764b;

        /* renamed from: c  reason: collision with root package name */
        private String f12765c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f12766d = true;

        public BaseTargetIdCacheData(HeliosStorageManager.StorageSession storageSession, String str) {
            this.f12763a = storageSession;
            this.f12764b = str;
            this.f12765c = f12761e + Base64.encodeToString(str.getBytes(), 3);
        }

        public void markDirty(boolean z) {
            this.f12766d = z;
        }

        public boolean persist() {
            if (this.f12766d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    writeToJson(jSONObject);
                    this.f12763a.writeStringToFile(this.f12765c, jSONObject.toString(), true);
                    markDirty(false);
                    return true;
                } catch (Exception e2) {
                }
            }
            return false;
        }

        public abstract void readFromJson(JSONObject jSONObject);

        public boolean resetFromCache() {
            String readFileAsString = this.f12763a.readFileAsString(this.f12765c, true);
            if (!TextUtils.isEmpty(readFileAsString)) {
                try {
                    readFromJson(new JSONObject(readFileAsString));
                    markDirty(false);
                    return true;
                } catch (Exception e2) {
                }
            }
            return false;
        }

        public abstract void writeToJson(JSONObject jSONObject);
    }

    public static class InitOptions {
    }

    public static class PublishOptions {
        public boolean savePublishErrorLog;
    }

    public static class PublishResult {
        public static final int PUBLISH_COMMON_RESULT_CODE_ERROR = -1;
        public static final int PUBLISH_COMMON_RESULT_CODE_SUCCESS = 0;
        public static final int PUBLISH_SPECIFIC_RESULT_CODE_CUSTOM_BASE = -100;
        public static final int PUBLISH_SPECIFIC_RESULT_CODE_UNKNOWN = 0;

        /* renamed from: a  reason: collision with root package name */
        private int f12767a;

        /* renamed from: b  reason: collision with root package name */
        private int f12768b;
        public Exception exception;

        public PublishResult(int i2, int i3, Exception exc) {
            this.f12767a = i2;
            this.f12768b = i3;
            this.exception = exc;
        }

        public static PublishResult errorOf() {
            return errorOf(0);
        }

        public static PublishResult errorOf(int i2) {
            return new PublishResult(-1, i2, (Exception) null);
        }

        public static PublishResult errorOf(Exception exc) {
            return new PublishResult(-1, 0, exc);
        }

        public static PublishResult successOf() {
            return new PublishResult(0, 0, (Exception) null);
        }

        public int getCommonResultCode() {
            return this.f12767a;
        }

        public int getSpecificResultCode() {
            return this.f12768b;
        }
    }

    public static class TargetIdOptions {
        public boolean useCache;
        public boolean useDebugInfo;
    }

    public static class TargetIdResult {
        public static final int ERROR_CODE_ERROR_CUSTOM_BASE = -100;
        public static final int ERROR_CODE_ERROR_INACCESSIABLE = -2;
        public static final int ERROR_CODE_ERROR_UNKNOWN = -1;
        public static final int ERROR_CODE_SUCCESS = 0;
        public int errCode;
        public Exception exception;
        public Object extra;
        public String id;

        public TargetIdResult(int i2, String str, Exception exc) {
            this.errCode = i2;
            this.id = str;
            this.exception = exc;
        }

        public static TargetIdResult errorOf() {
            return errorOf(-1);
        }

        public static TargetIdResult errorOf(int i2) {
            return new TargetIdResult(i2, (String) null, (Exception) null);
        }

        public static TargetIdResult errorOf(int i2, Exception exc) {
            return new TargetIdResult(i2, (String) null, exc);
        }

        public static TargetIdResult errorOf(Exception exc) {
            return new TargetIdResult(-1, (String) null, exc);
        }

        public static TargetIdResult successOf(String str) {
            return new TargetIdResult(0, str, (Exception) null);
        }

        public boolean isSuccess() {
            return this.errCode == 0;
        }
    }

    public BaseChannel(String str, long j2) {
        this.f12759b = str;
        this.f12760c = j2;
    }

    public final void attach(AttachInfo attachInfo2) {
        this.attachInfo = attachInfo2;
        this.storageSessionBase = attachInfo2.storageManager.getHeliosStorageSession().nextSession("cs");
    }

    public abstract TargetIdResult getIdForPackage(String str, TargetIdOptions targetIdOptions);

    public String getName() {
        return this.f12759b;
    }

    public long getPriority() {
        return this.f12760c;
    }

    public abstract void init(InitOptions initOptions);

    public abstract PublishResult publish(PublishOptions publishOptions);

    public void setPriority(long j2) {
        this.f12760c = j2;
    }
}
