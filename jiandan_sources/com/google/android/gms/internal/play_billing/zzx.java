package com.google.android.gms.internal.play_billing;

import com.alipay.sdk.m.n.a;
import com.baidu.android.common.others.lang.StringUtil;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public abstract class zzx implements Map, Serializable {
    public transient zzy zza;
    public transient zzy zzb;
    public transient zzr zzc;

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    public abstract Object get(Object obj);

    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public final int hashCode() {
        return zzag.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzy zzy = this.zzb;
        if (zzy != null) {
            return zzy;
        }
        zzy zzd = zzd();
        this.zzb = zzd;
        return zzd;
    }

    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824));
            sb.append(ExtendedMessageFormat.START_FE);
            boolean z = true;
            for (Map.Entry entry : entrySet()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(entry.getKey());
                sb.append(a.h);
                sb.append(entry.getValue());
                z = false;
            }
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        throw new IllegalArgumentException("size cannot be negative but was: " + size);
    }

    public abstract zzr zza();

    /* renamed from: zzb */
    public final zzr values() {
        zzr zzr = this.zzc;
        if (zzr != null) {
            return zzr;
        }
        zzr zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    public abstract zzy zzc();

    public abstract zzy zzd();

    /* renamed from: zze */
    public final zzy entrySet() {
        zzy zzy = this.zza;
        if (zzy != null) {
            return zzy;
        }
        zzy zzc2 = zzc();
        this.zza = zzc2;
        return zzc2;
    }
}
