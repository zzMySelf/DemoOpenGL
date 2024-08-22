package com.baidu.wallet.core.domain;

import androidx.annotation.NonNull;

public class DomainConfig implements a {

    /* renamed from: o  reason: collision with root package name */
    public a f3551o;
    public a p;
    public a q;

    /* renamed from: com.baidu.wallet.core.domain.DomainConfig$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.baidu.wallet.core.domain.DomainConfig$DomainStrategyType[] r0 = com.baidu.wallet.core.domain.DomainConfig.DomainStrategyType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.baidu.wallet.core.domain.DomainConfig$DomainStrategyType r1 = com.baidu.wallet.core.domain.DomainConfig.DomainStrategyType.QA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.wallet.core.domain.DomainConfig$DomainStrategyType r1 = com.baidu.wallet.core.domain.DomainConfig.DomainStrategyType.ONLINE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.core.domain.DomainConfig.AnonymousClass1.<clinit>():void");
        }
    }

    public enum DomainStrategyType {
        ONLINE,
        QA
    }

    public static class a {
        public static final DomainConfig a = new DomainConfig((AnonymousClass1) null);
    }

    public /* synthetic */ DomainConfig(AnonymousClass1 r1) {
        this();
    }

    public static DomainConfig getInstance() {
        return a.a;
    }

    public String getAppHost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getAppHost(boolArr);
    }

    public String getAppPayHost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getAppPayHost(boolArr);
    }

    public String getCOHost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getCOHost(boolArr);
    }

    public String getCometHost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getCometHost(boolArr);
    }

    public String getCreditCardHost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getCreditCardHost(boolArr);
    }

    public String getHawkinghost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getHawkinghost(boolArr);
    }

    public String getInitHost(int i2, @NonNull Boolean[] boolArr) {
        return this.f3551o.getInitHost(i2, boolArr);
    }

    public String getLifeHost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getLifeHost(boolArr);
    }

    public String getMHost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getMHost(boolArr);
    }

    public String getMyHost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getMyHost(boolArr);
    }

    public String getNetcheckhost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getNetcheckhost(boolArr);
    }

    public String getNfcHost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getNfcHost(boolArr);
    }

    public String getQianbaoHost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getQianbaoHost(boolArr);
    }

    public String getRecordHost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getRecordHost(boolArr);
    }

    public String getRtcHost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getRtcHost(boolArr);
    }

    public String getSensorhost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getSensorhost(boolArr);
    }

    public String getWebCacheHost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getWebCacheHost(boolArr);
    }

    public String getZhiFuHost(@NonNull Boolean[] boolArr) {
        return this.f3551o.getZhiFuHost(boolArr);
    }

    public void setDomainConfig(String str) {
        a aVar = this.f3551o;
        if (aVar != null) {
            aVar.setDomainConfig(str);
        }
    }

    public void setRtcConfig(String str) {
        a aVar = this.f3551o;
        if (aVar != null) {
            aVar.setRtcConfig(str);
        }
    }

    public void setRtcStrategy(DomainStrategyType domainStrategyType, String str) {
        int i2 = AnonymousClass1.a[domainStrategyType.ordinal()];
        if (i2 == 1) {
            this.f3551o = this.q;
        } else if (i2 == 2) {
            this.f3551o = this.p;
        }
        this.f3551o.setRtcConfig(str);
    }

    public void setStrategy(DomainStrategyType domainStrategyType) {
        int i2 = AnonymousClass1.a[domainStrategyType.ordinal()];
        if (i2 == 1) {
            this.f3551o = this.q;
        } else if (i2 == 2) {
            this.f3551o = this.p;
        }
    }

    public DomainConfig() {
        this.p = new b();
        this.q = c.a();
        this.f3551o = this.p;
    }

    public void setStrategy(DomainStrategyType domainStrategyType, String str) {
        int i2 = AnonymousClass1.a[domainStrategyType.ordinal()];
        if (i2 == 1) {
            this.f3551o = this.q;
        } else if (i2 == 2) {
            this.f3551o = this.p;
        }
        this.f3551o.setDomainConfig(str);
    }
}
