package com.dxmpay.wallet.statistics;

import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;

public class NetStepStatManager {
    public ConcurrentHashMap<String, ad> qw;

    public class ad {

        /* renamed from: ad  reason: collision with root package name */
        public long f4356ad = -1;

        /* renamed from: de  reason: collision with root package name */
        public long f4357de = -1;

        /* renamed from: fe  reason: collision with root package name */
        public long f4358fe = -1;

        /* renamed from: i  reason: collision with root package name */
        public long f4359i = -1;
        public long qw = -1;

        /* renamed from: rg  reason: collision with root package name */
        public long f4360rg = -1;

        /* renamed from: th  reason: collision with root package name */
        public long f4361th = -1;

        /* renamed from: uk  reason: collision with root package name */
        public String f4362uk = "";

        /* renamed from: yj  reason: collision with root package name */
        public int f4363yj = 0;

        public ad(NetStepStatManager netStepStatManager, long j) {
        }
    }

    public static class de {
        public static final NetStepStatManager qw = new NetStepStatManager();
    }

    public static NetStepStatManager getInstance() {
        return de.qw;
    }

    public void increaseRetryCount(String str, long j, String str2) {
        if (isInWhiteList(str)) {
            ad adVar = this.qw.get(str + j);
            if (adVar != null) {
                adVar.f4363yj++;
                adVar.f4362uk += StringUtils.LF + adVar.f4363yj + " reason：" + str2;
            }
        }
    }

    public boolean isInWhiteList(String str) {
        String[] sdkNetStatPathList = SdkInitResponse.getInstance().getSdkNetStatPathList();
        for (String equals : sdkNetStatPathList) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void recordBuildParamsCost(String str, long j, long j2) {
        if (isInWhiteList(str)) {
            ConcurrentHashMap<String, ad> concurrentHashMap = this.qw;
            ad adVar = concurrentHashMap.get(str + j);
            if (adVar != null) {
                adVar.qw = j2;
            }
        }
    }

    public void recordReadCost(String str, long j, long j2, long j3) {
        if (isInWhiteList(str)) {
            ConcurrentHashMap<String, ad> concurrentHashMap = this.qw;
            ad adVar = concurrentHashMap.get(str + j);
            if (adVar != null) {
                adVar.f4361th = j3;
                adVar.f4360rg = j2;
            }
        }
    }

    public void recordSMDecryptCost(String str, long j, long j2) {
        if (isInWhiteList(str)) {
            ConcurrentHashMap<String, ad> concurrentHashMap = this.qw;
            ad adVar = concurrentHashMap.get(str + j);
            if (adVar != null) {
                adVar.f4359i = j2;
            }
        }
    }

    public void recordSMEncryptCost(String str, long j, long j2) {
        if (isInWhiteList(str)) {
            ConcurrentHashMap<String, ad> concurrentHashMap = this.qw;
            ad adVar = concurrentHashMap.get(str + j);
            if (adVar != null) {
                adVar.f4356ad = j2;
            }
        }
    }

    public void recordStartTime(String str, long j) {
        if (isInWhiteList(str)) {
            ConcurrentHashMap<String, ad> concurrentHashMap = this.qw;
            concurrentHashMap.put(str + j, new ad(this, j));
        }
    }

    public void recordWriteCost(String str, long j, long j2, long j3) {
        if (isInWhiteList(str)) {
            ConcurrentHashMap<String, ad> concurrentHashMap = this.qw;
            ad adVar = concurrentHashMap.get(str + j);
            if (adVar != null) {
                adVar.f4358fe = j3;
                adVar.f4357de = j2;
            }
        }
    }

    public void removeKey(String str, long j) {
        if (isInWhiteList(str)) {
            ConcurrentHashMap<String, ad> concurrentHashMap = this.qw;
            concurrentHashMap.remove(str + j);
        }
    }

    public void statist(String str, long j, long j2, List<String> list) {
        if (isInWhiteList(str)) {
            if (j2 >= SdkInitResponse.getInstance().sdk_net_stat_threshold) {
                ConcurrentHashMap<String, ad> concurrentHashMap = this.qw;
                ad adVar = concurrentHashMap.get(str + j);
                if (adVar != null) {
                    list.add(String.valueOf(adVar.qw));
                    list.add(String.valueOf(adVar.f4356ad));
                    list.add(String.valueOf(adVar.f4359i));
                    list.add(adVar.f4357de + "," + adVar.f4360rg);
                    list.add(String.valueOf(adVar.f4358fe));
                    list.add(String.valueOf(adVar.f4361th));
                    list.add(String.valueOf(adVar.f4363yj));
                    list.add(adVar.f4362uk);
                }
            }
            ConcurrentHashMap<String, ad> concurrentHashMap2 = this.qw;
            concurrentHashMap2.remove(str + j);
        }
    }

    public NetStepStatManager() {
        this.qw = new ConcurrentHashMap<>();
    }
}
