package com.baidu.nadcore.net.util;

import android.text.TextUtils;
import com.baidu.nadcore.safe.CollectionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public class NetworkQuality {
    public static final int BAD_NETWORK_QUALITY = 2;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_NETWORK_QUALITY = 1;
    public static final int GOOD_NETWORK_QUALITY = 1;
    private static final List<NetworkQualityListener> NETWORK_QUALITY_LISTENERS = new ArrayList(2);
    public static final int NET_QUALITY_UPDATE_FROM_NQE = 2;
    public static final int NET_QUALITY_UPDATE_FROM_SDT = 1;
    public static final int OFFLINE_NETWORK_QUALITY = 3;
    public static final String TAG = "NetworkQualityLog";
    public static final int UNKNOWN_NETWORK_QUALITY = -1;
    private static int sLastNetworkQualityQuality = 1;
    private static Map<String, List<Integer>> sLastSdtProbeErrorCodeMap;
    /* access modifiers changed from: private */
    public static int sNetworkQuality = 1;
    private static volatile int sNetworkQualityUpdateFrom = -1;
    private static WeakNetCheckConfig sWeakNetCheckConfig = new WeakNetCheckConfig();

    public static abstract class NetworkQualityListener {
        private final Executor mExecutor;

        public abstract void onNetworkQualityChanged(int i2);

        public NetworkQualityListener(Executor executor) {
            if (executor != null) {
                this.mExecutor = executor;
                return;
            }
            throw new IllegalStateException("Executor must not be null");
        }

        /* access modifiers changed from: private */
        public Executor getExecutor() {
            return this.mExecutor;
        }
    }

    public static boolean isEnable() {
        return getWeakNetCheckConfig().enableNqe || getWeakNetCheckConfig().enableSdt;
    }

    public static void addNetworkQualityListener(NetworkQualityListener listener) {
        List<NetworkQualityListener> list = NETWORK_QUALITY_LISTENERS;
        synchronized (list) {
            if (!list.contains(listener)) {
                list.add(listener);
            }
        }
    }

    public static void removeNetworkQualityListener(NetworkQualityListener listener) {
        List<NetworkQualityListener> list = NETWORK_QUALITY_LISTENERS;
        synchronized (list) {
            list.remove(listener);
        }
    }

    public static int getNetworkQuality() {
        return sNetworkQuality;
    }

    public static boolean isWeakNet() {
        int i2 = sNetworkQuality;
        return i2 == 2 || i2 == 3;
    }

    public static int getNetworkQualityUpdateFrom() {
        return sNetworkQualityUpdateFrom;
    }

    public static void updateNetworkQuality(int networkQuality, int from) {
        if (networkQuality != sLastNetworkQualityQuality) {
            List<NetworkQualityListener> list = NETWORK_QUALITY_LISTENERS;
            synchronized (list) {
                sNetworkQuality = networkQuality;
                sNetworkQualityUpdateFrom = from;
                for (final NetworkQualityListener listener : list) {
                    try {
                        listener.getExecutor().execute(new Runnable() {
                            public void run() {
                                NetworkQualityListener networkQualityListener = NetworkQualityListener.this;
                                if (networkQualityListener != null) {
                                    networkQualityListener.onNetworkQualityChanged(NetworkQuality.sNetworkQuality);
                                }
                            }
                        });
                    } catch (Exception e2) {
                    }
                }
                sLastNetworkQualityQuality = networkQuality;
            }
        }
    }

    public static String getNameOfQuality(int quality) {
        switch (quality) {
            case -1:
                return "Unknown";
            case 1:
                return "Good";
            case 2:
                return "Bad";
            case 3:
                return "Offline";
            default:
                return String.valueOf(quality);
        }
    }

    public static void setWeakNetCheckConfig(WeakNetCheckConfig weakNetCheckConfig) {
        sWeakNetCheckConfig = weakNetCheckConfig;
    }

    public static WeakNetCheckConfig getWeakNetCheckConfig() {
        return sWeakNetCheckConfig;
    }

    public static JSONObject getLastSdtProbeErrorCode() {
        synchronized (NetworkQuality.class) {
            if (sLastSdtProbeErrorCodeMap == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(sLastSdtProbeErrorCodeMap);
            return jSONObject;
        }
    }

    protected static void updateLastSdtProbeErrCode(Map<String, List<Integer>> errCodeMap) {
        synchronized (NetworkQuality.class) {
            if (sLastSdtProbeErrorCodeMap == null) {
                sLastSdtProbeErrorCodeMap = new HashMap();
            }
            sLastSdtProbeErrorCodeMap = errCodeMap;
        }
    }

    public static class WeakNetCheckConfig {
        static final long DEFAULT_TTFB_EXPIRE_TIME = 1000;
        static final long DEFAULT_TTFB_GOOD_THRESHOLD = 590;
        public boolean enableNqe;
        public boolean enableSdt;
        public long goodTtfbThresholdMillis = DEFAULT_TTFB_GOOD_THRESHOLD;
        public long nqeWeakTtfbThresholdMillis = 1000;
        public List<String> sdtProbeDomains = new ArrayList();
        public long weakTtfbThresholdMillis = 1000;

        WeakNetCheckConfig() {
        }

        public WeakNetCheckConfig(long goodTtfbThresholdMs, long weakTtfbThresholdMs, long nqeWeakTtfbThresholdMs, List<String> probeDomains, boolean enableSdt2, boolean enableNqe2) {
            if (goodTtfbThresholdMs > 0) {
                this.goodTtfbThresholdMillis = goodTtfbThresholdMs;
            }
            if (weakTtfbThresholdMs > 0) {
                this.weakTtfbThresholdMillis = weakTtfbThresholdMs;
            }
            if (nqeWeakTtfbThresholdMs > 0) {
                this.nqeWeakTtfbThresholdMillis = nqeWeakTtfbThresholdMs;
            }
            if (!CollectionUtils.isNullOrEmpty(probeDomains)) {
                List<String> newSdtDomains = new ArrayList<>();
                for (String domain : probeDomains) {
                    if (!TextUtils.isEmpty(domain)) {
                        CollectionUtils.add(newSdtDomains, domain);
                    }
                }
                if (!CollectionUtils.isNullOrEmpty(newSdtDomains)) {
                    this.sdtProbeDomains = Collections.unmodifiableList(newSdtDomains);
                }
            }
            if (CollectionUtils.isNullOrEmpty(this.sdtProbeDomains)) {
                this.sdtProbeDomains = Arrays.asList(new String[]{"www.baidu.com"});
            }
            this.enableSdt = enableSdt2;
            this.enableNqe = enableNqe2;
        }
    }
}
