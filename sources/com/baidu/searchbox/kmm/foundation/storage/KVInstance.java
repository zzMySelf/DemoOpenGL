package com.baidu.searchbox.kmm.foundation.storage;

import com.baidu.searchbox.kmm.foundation.kelson.JsonModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J!\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\nH&¢\u0006\u0002\u0010\rJ!\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000fH&¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u0012H&¢\u0006\u0002\u0010\u0013J!\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u0015H&¢\u0006\u0002\u0010\u0016J3\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00192\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\bø\u0001\u0000¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u001eH&¢\u0006\u0002\u0010\u001fJ\u001c\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH&J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH&J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\bH&J\u0018\u0010$\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0001H&J\u0018\u0010&\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u0019R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0002\u0007\n\u0005\b20\u0001¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/kmm/foundation/storage/KVInstance;", "", "kvImpl", "(Ljava/lang/Object;)V", "getKvImpl", "()Ljava/lang/Object;", "allKeys", "", "", "getBoolean", "", "key", "default", "(Ljava/lang/String;Z)Ljava/lang/Boolean;", "getDouble", "", "(Ljava/lang/String;D)Ljava/lang/Double;", "getFloat", "", "(Ljava/lang/String;F)Ljava/lang/Float;", "getInt", "", "(Ljava/lang/String;I)Ljava/lang/Integer;", "getJsonModel", "T", "Lcom/baidu/searchbox/kmm/foundation/kelson/JsonModel;", "factory", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lcom/baidu/searchbox/kmm/foundation/kelson/JsonModel;", "getLong", "", "(Ljava/lang/String;J)Ljava/lang/Long;", "getString", "hasKey", "remove", "", "set", "value", "setJsonModel", "com.baidu.searchbox.kmm.foundation.storage"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KVInstance.kt */
public abstract class KVInstance {
    private final Object kvImpl;

    public abstract Iterable<String> allKeys();

    public abstract Boolean getBoolean(String str, boolean z);

    public abstract Double getDouble(String str, double d2);

    public abstract Float getFloat(String str, float f2);

    public abstract Integer getInt(String str, int i2);

    public abstract Long getLong(String str, long j2);

    public abstract String getString(String str, String str2);

    public abstract boolean hasKey(String str);

    public abstract void remove(String str);

    public abstract void set(String str, Object obj);

    public KVInstance(Object kvImpl2) {
        Intrinsics.checkNotNullParameter(kvImpl2, "kvImpl");
        this.kvImpl = kvImpl2;
    }

    public final Object getKvImpl() {
        return this.kvImpl;
    }

    public static /* synthetic */ String getString$default(KVInstance kVInstance, String str, String str2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                str2 = "";
            }
            return kVInstance.getString(str, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
    }

    public static /* synthetic */ Integer getInt$default(KVInstance kVInstance, String str, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return kVInstance.getInt(str, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInt");
    }

    public static /* synthetic */ Long getLong$default(KVInstance kVInstance, String str, long j2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                j2 = 0;
            }
            return kVInstance.getLong(str, j2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLong");
    }

    public static /* synthetic */ Double getDouble$default(KVInstance kVInstance, String str, double d2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                d2 = 0.0d;
            }
            return kVInstance.getDouble(str, d2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDouble");
    }

    public static /* synthetic */ Float getFloat$default(KVInstance kVInstance, String str, float f2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                f2 = 0.0f;
            }
            return kVInstance.getFloat(str, f2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFloat");
    }

    public static /* synthetic */ Boolean getBoolean$default(KVInstance kVInstance, String str, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return kVInstance.getBoolean(str, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBoolean");
    }

    public final void setJsonModel(String key, JsonModel value) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        if (value != null) {
            try {
                Result.Companion companion = Result.Companion;
                set(key, value.toString());
                obj = Result.m8971constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable r0 = Result.m8974exceptionOrNullimpl(obj);
            if (r0 != null) {
                r0.printStackTrace();
            }
        }
    }

    public final <T extends JsonModel> T getJsonModel(String key, Function0<? extends T> factory) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(factory, "factory");
        String string$default = getString$default(this, key, (String) null, 2, (Object) null);
        if (string$default == null) {
            return null;
        }
        String json = string$default;
        T invoke = factory.invoke();
        JsonModel $this$getJsonModel_u24lambda_u2d2 = (JsonModel) invoke;
        try {
            Result.Companion companion = Result.Companion;
            $this$getJsonModel_u24lambda_u2d2.decodeFromString(json);
            obj = Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r5 = Result.m8974exceptionOrNullimpl(obj);
        if (r5 != null) {
            r5.printStackTrace();
        }
        return (JsonModel) invoke;
    }
}
