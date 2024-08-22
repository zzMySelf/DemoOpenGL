package com.google.android.gms.internal.play_billing;

import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;

public enum zza {
    RESPONSE_CODE_UNSPECIFIED(BannerFocusImageViewGroup.f),
    SERVICE_TIMEOUT(-3),
    FEATURE_NOT_SUPPORTED(-2),
    SERVICE_DISCONNECTED(-1),
    zze(0),
    USER_CANCELED(1),
    SERVICE_UNAVAILABLE(2),
    BILLING_UNAVAILABLE(3),
    ITEM_UNAVAILABLE(4),
    DEVELOPER_ERROR(5),
    ERROR(6),
    ITEM_ALREADY_OWNED(7),
    ITEM_NOT_OWNED(8),
    EXPIRED_OFFER_TOKEN(11);
    
    public static final zzx zzo = null;
    public final int zzq;

    /* access modifiers changed from: public */
    static {
        int i2;
        zzw zzw = new zzw();
        for (zza zza : values()) {
            zzw.zza(Integer.valueOf(zza.zzq), zza);
        }
        zzo = zzw.zzb();
    }

    /* access modifiers changed from: public */
    zza(int i2) {
        this.zzq = i2;
    }

    public static zza zza(int i2) {
        zzx zzx = zzo;
        Integer valueOf = Integer.valueOf(i2);
        if (!zzx.containsKey(valueOf)) {
            return RESPONSE_CODE_UNSPECIFIED;
        }
        return (zza) zzo.get(valueOf);
    }
}
