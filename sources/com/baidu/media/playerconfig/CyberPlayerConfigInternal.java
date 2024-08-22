package com.baidu.media.playerconfig;

public class CyberPlayerConfigInternal implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private String f15332a = null;
    public CdnConfig cdnConfig = new CdnConfig();
    public String cntlId = null;
    public String[] hosts;
    public PCDNConfig pcdnConfig = new PCDNConfig();
    public PrefetchConfig prefetchConfig = new PrefetchConfig();

    public static class CdnConfig implements Cloneable {
        public String key = null;
        public int level = 0;
        public int quicEnable = 1;
        public float sl_rate = 0.0f;
        public int sle = 0;
        public float split_rate = 0.0f;

        /* access modifiers changed from: package-private */
        public boolean a() {
            int i2 = this.sle;
            if (i2 < 0 || i2 > 1) {
                return false;
            }
            float f2 = this.sl_rate;
            if (f2 < 0.0f || f2 > 16.0f) {
                return false;
            }
            float f3 = this.split_rate;
            return f3 >= 0.0f && f3 <= 24.0f;
        }

        public CdnConfig clone() {
            CdnConfig cdnConfig = (CdnConfig) super.clone();
            cdnConfig.sle = this.sle;
            cdnConfig.sl_rate = this.sl_rate;
            cdnConfig.split_rate = this.split_rate;
            cdnConfig.level = this.level;
            cdnConfig.key = new String(this.key);
            cdnConfig.quicEnable = this.quicEnable;
            return cdnConfig;
        }
    }

    public static class PCDNConfig implements Cloneable {
        public int p2pEnable = 0;
        public int pcdnEnable = 0;
        public int xcdnEnable = 0;

        public PCDNConfig clone() {
            PCDNConfig pCDNConfig = (PCDNConfig) super.clone();
            pCDNConfig.pcdnEnable = this.pcdnEnable;
            pCDNConfig.p2pEnable = this.p2pEnable;
            pCDNConfig.xcdnEnable = this.xcdnEnable;
            return pCDNConfig;
        }
    }

    public static class PrefetchConfig implements Cloneable {
        public int duration;
        public String key = null;
        public int level = 0;
        public int p2pEnable;
        public int pcdnEnable;
        public float sl_rate = 0.0f;
        public int sle = 0;
        public float split_rate = 0.0f;
        public int xcdnEnable;

        public PrefetchConfig clone() {
            PrefetchConfig prefetchConfig = (PrefetchConfig) super.clone();
            prefetchConfig.duration = this.duration;
            prefetchConfig.pcdnEnable = this.pcdnEnable;
            prefetchConfig.p2pEnable = this.p2pEnable;
            prefetchConfig.xcdnEnable = this.xcdnEnable;
            prefetchConfig.sle = this.sle;
            prefetchConfig.sl_rate = this.sl_rate;
            prefetchConfig.split_rate = this.split_rate;
            prefetchConfig.level = this.level;
            prefetchConfig.key = new String(this.key);
            return prefetchConfig;
        }
    }

    public CyberPlayerConfigInternal(String str) {
        this.f15332a = str;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        CdnConfig cdnConfig2 = this.cdnConfig;
        return (cdnConfig2 != null ? Boolean.valueOf(cdnConfig2.a()) : null).booleanValue();
    }

    public CyberPlayerConfigInternal clone() {
        CyberPlayerConfigInternal cyberPlayerConfigInternal = (CyberPlayerConfigInternal) super.clone();
        String[] strArr = this.hosts;
        cyberPlayerConfigInternal.hosts = strArr != null ? (String[]) strArr.clone() : null;
        cyberPlayerConfigInternal.cntlId = new String(this.cntlId);
        cyberPlayerConfigInternal.pcdnConfig = this.pcdnConfig.clone();
        cyberPlayerConfigInternal.cdnConfig = this.cdnConfig.clone();
        cyberPlayerConfigInternal.prefetchConfig = this.prefetchConfig.clone();
        return cyberPlayerConfigInternal;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n======================");
        sb.append(this.f15332a);
        sb.append(" Player Server config information====================== \n");
        sb.append("host : \n");
        int i2 = 0;
        while (true) {
            String[] strArr = this.hosts;
            if (strArr == null || i2 >= strArr.length) {
                sb.append("cntlId : \n    " + this.cntlId + ";\n");
                sb.append("PCDNConfig : \n    ");
                sb.append(" pcdnEnable : " + this.pcdnConfig.pcdnEnable + " p2pEnable : " + this.pcdnConfig.p2pEnable + ";\n");
                sb.append("CdnConfig : \n    ");
                sb.append("key : " + this.cdnConfig.key + ", level : " + this.cdnConfig.level + ", sle : " + this.cdnConfig.sle + ", sl_rate : " + this.cdnConfig.sl_rate + ", split_rate : " + this.cdnConfig.split_rate + ", quicEnable :" + this.cdnConfig.quicEnable + ";\n");
                sb.append("PrefetchConfig : \n    ");
                sb.append("duration : " + this.prefetchConfig.duration + " pcdnEnable : " + this.prefetchConfig.pcdnEnable + " p2pEnable : " + this.prefetchConfig.p2pEnable + " key : " + this.prefetchConfig.key + " level : " + this.prefetchConfig.level + " sle : " + this.prefetchConfig.sle + " sl_rate : " + this.prefetchConfig.sl_rate + " split_rate : " + this.prefetchConfig.split_rate + ";\n");
            } else {
                sb.append("    " + this.hosts[i2] + "\n");
                i2++;
            }
        }
        sb.append("cntlId : \n    " + this.cntlId + ";\n");
        sb.append("PCDNConfig : \n    ");
        sb.append(" pcdnEnable : " + this.pcdnConfig.pcdnEnable + " p2pEnable : " + this.pcdnConfig.p2pEnable + ";\n");
        sb.append("CdnConfig : \n    ");
        sb.append("key : " + this.cdnConfig.key + ", level : " + this.cdnConfig.level + ", sle : " + this.cdnConfig.sle + ", sl_rate : " + this.cdnConfig.sl_rate + ", split_rate : " + this.cdnConfig.split_rate + ", quicEnable :" + this.cdnConfig.quicEnable + ";\n");
        sb.append("PrefetchConfig : \n    ");
        sb.append("duration : " + this.prefetchConfig.duration + " pcdnEnable : " + this.prefetchConfig.pcdnEnable + " p2pEnable : " + this.prefetchConfig.p2pEnable + " key : " + this.prefetchConfig.key + " level : " + this.prefetchConfig.level + " sle : " + this.prefetchConfig.sle + " sl_rate : " + this.prefetchConfig.sl_rate + " split_rate : " + this.prefetchConfig.split_rate + ";\n");
        return sb.toString();
    }
}
