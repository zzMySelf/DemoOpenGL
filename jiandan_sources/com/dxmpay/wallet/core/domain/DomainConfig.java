package com.dxmpay.wallet.core.domain;

import android.content.Context;

public class DomainConfig implements a {

    /* renamed from: ad  reason: collision with root package name */
    public a f4259ad;

    /* renamed from: de  reason: collision with root package name */
    public a f4260de;
    public a qw;

    public enum DomainStrategyType {
        ONLINE,
        QA
    }

    public static class ad {
        public static final DomainConfig qw = new DomainConfig((qw) null);
    }

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.dxmpay.wallet.core.domain.DomainConfig$DomainStrategyType[] r0 = com.dxmpay.wallet.core.domain.DomainConfig.DomainStrategyType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.dxmpay.wallet.core.domain.DomainConfig$DomainStrategyType r1 = com.dxmpay.wallet.core.domain.DomainConfig.DomainStrategyType.QA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.dxmpay.wallet.core.domain.DomainConfig$DomainStrategyType r1 = com.dxmpay.wallet.core.domain.DomainConfig.DomainStrategyType.ONLINE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.wallet.core.domain.DomainConfig.qw.<clinit>():void");
        }
    }

    public /* synthetic */ DomainConfig(qw qwVar) {
        this();
    }

    public static DomainConfig getInstance() {
        return ad.qw;
    }

    public String getAppHost() {
        return this.qw.getAppHost();
    }

    public String getAppPayHost() {
        return this.qw.getAppPayHost();
    }

    public String getBackSensorHost() {
        return this.qw.getBackSensorHost();
    }

    public String getInitHost() {
        return this.qw.getInitHost();
    }

    public String getRecordHost() {
        return this.qw.getRecordHost();
    }

    public String getRtcHost() {
        return this.qw.getRtcHost();
    }

    public String getSensortHost() {
        return this.qw.getSensortHost();
    }

    public String getSpareInitHost() {
        return this.qw.getSpareInitHost();
    }

    public String getZhiFuHost() {
        return this.qw.getZhiFuHost();
    }

    public void setDomainConfig(String str) {
        a aVar = this.qw;
        if (aVar != null) {
            aVar.setDomainConfig(str);
        }
    }

    public void setDxmPayContext(Context context) {
        a aVar = this.qw;
        if (aVar != null) {
            aVar.setDxmPayContext(context);
        }
    }

    public void setStrategy(DomainStrategyType domainStrategyType) {
        int i2 = qw.qw[domainStrategyType.ordinal()];
        if (i2 == 1) {
            this.qw = this.f4260de;
        } else if (i2 == 2) {
            this.qw = this.f4259ad;
        }
    }

    public DomainConfig() {
        this.f4259ad = new fe.i.ad.ad.ad.qw();
        this.f4260de = fe.i.ad.ad.ad.ad.qw();
        this.qw = this.f4259ad;
    }

    public void setStrategy(DomainStrategyType domainStrategyType, String str) {
        int i2 = qw.qw[domainStrategyType.ordinal()];
        if (i2 == 1) {
            this.qw = this.f4260de;
        } else if (i2 == 2) {
            this.qw = this.f4259ad;
        }
        this.qw.setDomainConfig(str);
    }
}
