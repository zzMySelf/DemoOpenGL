package com.baidu.lcp.sdk.connect;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.lcp.sdk.action.BehaviorConstant;
import com.baidu.lcp.sdk.action.BehaviorProcess;
import com.baidu.lcp.sdk.request.HttpExecutor;
import com.baidu.lcp.sdk.request.LCPHttpDnsUrlRequest;
import com.baidu.lcp.sdk.utils.LCPConstants;
import com.baidu.lcp.sdk.utils.LogUtils;
import com.baidu.lcp.sdk.utils.SpUtils;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.searchbox.dns.statistics.HttpDNSStat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class DNSUrlProvider {
    private static final String TAG = "DNSUrlProvider";
    public static List<String> bdDnsIpList = Collections.synchronizedList(new ArrayList());
    public static int curBdDNSIpIndex = 0;
    private static int currentPolicy = 0;

    public interface DNSUrlProviderInternal {
        void getUrlAsync(String str, IGetUrlAsyncListener iGetUrlAsyncListener);

        void onConnectSuccess(String str, boolean z);
    }

    public interface IGetUrlAsyncListener {
        void onGetUrlAsyncResult(int i2, String str, String str2);
    }

    public static DNSUrlProviderInternal getProvide(Context context) {
        int i2;
        Context applicationContext = context.getApplicationContext();
        int env = LCPConstants.getLcpDebugEnv(applicationContext);
        if (env == 1 || env == 2) {
            currentPolicy = 3;
            return DefaultUrlProvider.getUrlProvider(applicationContext);
        }
        if (LCPConstants.LOG_DEBUG) {
            LogUtils.d(TAG, "DNSUrlProviderInternal " + currentPolicy);
        }
        if (!TextUtils.isEmpty(SpUtils.getLocalCache(applicationContext)) && currentPolicy == 0) {
            if (LCPConstants.LOG_DEBUG) {
                LogUtils.d(TAG, "LocalCacheProvider ");
            }
            return LocalCacheProvider.getUrlProvider(applicationContext);
        } else if (SpUtils.getBdDnsEnable(applicationContext) && ((i2 = currentPolicy) == 1 || i2 == 0)) {
            if (LCPConstants.LOG_DEBUG) {
                LogUtils.d(TAG, "BDHttpDNSUrlProvider ");
            }
            return BDHttpDNSUrlProvider.getUrlProvider(applicationContext);
        } else if (currentPolicy == 2) {
            if (LCPConstants.LOG_DEBUG) {
                LogUtils.d(TAG, "LCPHttpDNSUrlProvider ");
            }
            return LCPHttpDNSUrlProvider.getUrlProvider(applicationContext);
        } else {
            if (LCPConstants.LOG_DEBUG) {
                LogUtils.d(TAG, "DefaultUrlProvider ");
            }
            return DefaultUrlProvider.getUrlProvider(applicationContext);
        }
    }

    static class LocalCacheProvider implements DNSUrlProviderInternal {
        private static LocalCacheProvider mInstance;
        private Context mContext;

        private LocalCacheProvider(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public static synchronized DNSUrlProviderInternal getUrlProvider(Context context) {
            LocalCacheProvider localCacheProvider;
            synchronized (LocalCacheProvider.class) {
                if (mInstance == null) {
                    mInstance = new LocalCacheProvider(context);
                }
                localCacheProvider = mInstance;
            }
            return localCacheProvider;
        }

        public void getUrlAsync(String host, IGetUrlAsyncListener listener) {
            if (listener != null) {
                String ip = SpUtils.getLocalCache(this.mContext);
                if (!TextUtils.isEmpty(ip)) {
                    if (LCPConstants.LOG_DEBUG) {
                        LogUtils.d(DNSUrlProvider.TAG, "LocalCacheProvider " + ip);
                    }
                    listener.onGetUrlAsyncResult(0, "ok", ip);
                    return;
                }
                if (LCPConstants.LOG_DEBUG) {
                    LogUtils.d(DNSUrlProvider.TAG, "else POLICY_BDHTTPDNS " + ip);
                }
                DNSUrlProvider.setNextPolicy(1, this.mContext);
                DNSUrlProvider.getProvide(this.mContext).getUrlAsync(host, listener);
            }
        }

        public void onConnectSuccess(String ip, boolean refreshCache) {
        }
    }

    static class DefaultUrlProvider implements DNSUrlProviderInternal {
        private static DefaultUrlProvider mInstance;
        private Context mContext;

        private DefaultUrlProvider(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public static synchronized DNSUrlProviderInternal getUrlProvider(Context context) {
            DefaultUrlProvider defaultUrlProvider;
            synchronized (DefaultUrlProvider.class) {
                if (mInstance == null) {
                    mInstance = new DefaultUrlProvider(context);
                }
                defaultUrlProvider = mInstance;
            }
            return defaultUrlProvider;
        }

        public void getUrlAsync(String host, IGetUrlAsyncListener listener) {
            Context context;
            if (LCPConstants.LOG_DEBUG) {
                LogUtils.i(DNSUrlProvider.TAG, "DefaultUrlProvider try to getUrlAsync");
            }
            if (listener != null && (context = this.mContext) != null) {
                DNSUrlProvider.resetBdDns(context);
                listener.onGetUrlAsyncResult(0, "ok", host);
            }
        }

        public void onConnectSuccess(String ip, boolean refreshCache) {
        }
    }

    static class LCPHttpDNSUrlProvider implements DNSUrlProviderInternal {
        private static LCPHttpDNSUrlProvider mInstance;
        private Context mContext;

        private LCPHttpDNSUrlProvider(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public static synchronized LCPHttpDNSUrlProvider getUrlProvider(Context ct) {
            LCPHttpDNSUrlProvider lCPHttpDNSUrlProvider;
            synchronized (LCPHttpDNSUrlProvider.class) {
                if (mInstance == null) {
                    mInstance = new LCPHttpDNSUrlProvider(ct);
                }
                lCPHttpDNSUrlProvider = mInstance;
            }
            return lCPHttpDNSUrlProvider;
        }

        public void getUrlAsync(String host, IGetUrlAsyncListener listener) {
            if (LCPConstants.LOG_DEBUG) {
                LogUtils.d(DNSUrlProvider.TAG, "will getLCPHttpDnsAddress......");
            }
            try {
                LCPHttpDnsUrlRequest request = new LCPHttpDnsUrlRequest(this.mContext);
                request.setListener(listener);
                HttpExecutor.getInstance().requestExecute(request, request);
            } catch (Exception e2) {
                DNSUrlProvider.setNextPolicy(3, this.mContext);
                DNSUrlProvider.getProvide(this.mContext).getUrlAsync(host, listener);
            }
        }

        public void onConnectSuccess(String ip, boolean refreshCache) {
        }
    }

    static class BDHttpDNSUrlProvider implements DNSUrlProviderInternal {
        private static BDHttpDNSUrlProvider mInstance;
        /* access modifiers changed from: private */
        public Context mContext;

        public static synchronized BDHttpDNSUrlProvider getUrlProvider(Context context) {
            BDHttpDNSUrlProvider bDHttpDNSUrlProvider;
            synchronized (BDHttpDNSUrlProvider.class) {
                if (mInstance == null) {
                    mInstance = new BDHttpDNSUrlProvider(context);
                }
                bDHttpDNSUrlProvider = mInstance;
            }
            return bDHttpDNSUrlProvider;
        }

        private BDHttpDNSUrlProvider(Context context) {
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            DNSUrlProvider.resetBdDns(applicationContext);
        }

        public void getUrlAsync(final String host, final IGetUrlAsyncListener listener) {
            Timer timer;
            try {
                if (LCPConstants.LOG_DEBUG) {
                    LogUtils.i(DNSUrlProvider.TAG, "BDHttpDNSUrlProvider try to getUrlAsync");
                }
                if (DNSUrlProvider.bdDnsIpList != null) {
                    if (DNSUrlProvider.bdDnsIpList.size() > 0) {
                        if (DNSUrlProvider.curBdDNSIpIndex < DNSUrlProvider.bdDnsIpList.size()) {
                            if (listener != null) {
                                listener.onGetUrlAsyncResult(0, "ok", DNSUrlProvider.bdDnsIpList.get(DNSUrlProvider.curBdDNSIpIndex));
                                if (LCPConstants.LOG_DEBUG) {
                                    LogUtils.d(DNSUrlProvider.TAG, "retry bddns > return ip = " + DNSUrlProvider.bdDnsIpList.get(DNSUrlProvider.curBdDNSIpIndex));
                                }
                            }
                            DNSUrlProvider.curBdDNSIpIndex++;
                        } else {
                            DNSUrlProvider.setNextPolicy(3, this.mContext);
                            DNSUrlProvider.getProvide(this.mContext).getUrlAsync(host, listener);
                        }
                    }
                }
                timer = new Timer();
                if (LCPConstants.LOG_DEBUG) {
                    LogUtils.d(DNSUrlProvider.TAG, "bddns > getUrlAsync in... host is " + host);
                }
                final AtomicBoolean isTimeout = new AtomicBoolean(false);
                timer.schedule(new TimerTask() {
                    public void run() {
                        if (LCPConstants.LOG_DEBUG) {
                            LogUtils.d(DNSUrlProvider.TAG, "bddns > get IPs too long, bdDnsIps is null");
                        }
                        isTimeout.set(true);
                        BehaviorProcess.getInstance(BDHttpDNSUrlProvider.this.mContext).getFlow(BehaviorConstant.CONNECTION_ALIAS_ID).addEvent(BehaviorConstant.P9, BehaviorConstant.P9_VALUE).addEvent(BehaviorConstant.ERROR_CODE_KEY, BehaviorConstant.P9);
                        DNSUrlProvider.setNextPolicy(3, BDHttpDNSUrlProvider.this.mContext);
                        DNSUrlProvider.getProvide(BDHttpDNSUrlProvider.this.mContext).getUrlAsync(host, listener);
                    }
                }, 10000);
                DnsHelper dnsHelper = new DnsHelper(this.mContext);
                dnsHelper.setHttpDnsState(false, (HttpDNSStat) null, false, true);
                DNSUrlProvider.sortPriority(dnsHelper.getIpList(host), this.mContext);
                if (DNSUrlProvider.bdDnsIpList != null && DNSUrlProvider.bdDnsIpList.size() > 0) {
                    if (LCPConstants.LOG_DEBUG) {
                        LogUtils.d(DNSUrlProvider.TAG, "bddns > resolve ips end, bdDnsIps = " + DNSUrlProvider.bdDnsIpList);
                    }
                    String dnsIpReturn = DNSUrlProvider.bdDnsIpList.get(0);
                    if (listener != null && !isTimeout.get()) {
                        timer.cancel();
                        if (DNSUrlProvider.bdDnsIpList.size() > 1) {
                            DNSUrlProvider.curBdDNSIpIndex++;
                            DNSUrlProvider.setNextPolicy(1, this.mContext);
                        }
                        if (LCPConstants.LOG_DEBUG) {
                            LogUtils.d(DNSUrlProvider.TAG, "bddns > resolve ips end, return ip = " + dnsIpReturn);
                        }
                        listener.onGetUrlAsyncResult(0, "ok", dnsIpReturn);
                    } else if (LCPConstants.LOG_DEBUG) {
                        LogUtils.d(DNSUrlProvider.TAG, "bddns > resolve ips end, but out of time, do nothing");
                    }
                    timer.cancel();
                }
            } catch (Throwable th2) {
                if (LCPConstants.LOG_DEBUG) {
                    LogUtils.d(DNSUrlProvider.TAG, "bddns > bdDnsIps get exception ");
                }
                DNSUrlProvider.setNextPolicy(3, this.mContext);
                DNSUrlProvider.getProvide(this.mContext).getUrlAsync(host, listener);
            }
        }

        public void onConnectSuccess(String ip, boolean refreshCache) {
        }
    }

    public static void sortPriority(List<String> ips, Context context) {
        bdDnsIpList.clear();
        List<String> ipv4List = new ArrayList<>();
        List<String> ipv6List = new ArrayList<>();
        if (ips != null && !ips.isEmpty()) {
            for (int i2 = 0; i2 < ips.size(); i2++) {
                if (isIpv4(ips.get(i2))) {
                    ipv4List.add(ips.get(i2));
                } else {
                    ipv6List.add(ips.get(i2));
                }
            }
        }
        if (ipv4List.size() + ipv6List.size() > 0) {
            int vipType = SpUtils.getIpPriority(context);
            if (LCPConstants.LOG_DEBUG) {
                LogUtils.e(TAG, "getIpPriority :" + vipType + ", ipv4 :" + ipv4List.toString() + ", ipv6 :" + ipv6List.toString());
            }
            switch (vipType) {
                case 1:
                    bdDnsIpList.addAll(ipv6List);
                    return;
                case 2:
                    bdDnsIpList.addAll(ipv6List);
                    bdDnsIpList.addAll(ipv4List);
                    return;
                case 4:
                    bdDnsIpList.addAll(ipv4List);
                    return;
                default:
                    bdDnsIpList.addAll(ipv4List);
                    bdDnsIpList.addAll(ipv6List);
                    return;
            }
        }
    }

    public static void onConnectSuccess(Context context, String ip) {
        if (LCPConstants.LOG_DEBUG) {
            LogUtils.d(TAG, "onConnectSuccess currentPolicy：" + currentPolicy);
        }
        refresh(context, ip, true);
        int i2 = currentPolicy;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            if (LCPConstants.LOG_DEBUG) {
                LogUtils.d(TAG, "localcache cached: " + ip);
            }
            SpUtils.setLocalCache(context, ip);
        }
    }

    static void resetBdDns(Context context) {
        if (LCPConstants.LOG_DEBUG) {
            LogUtils.d(TAG, "resetBdDns");
        }
        try {
            curBdDNSIpIndex = 0;
            bdDnsIpList.clear();
            SpUtils.setLocalCache(context, "");
            currentPolicy = 0;
        } catch (Exception e2) {
            if (LCPConstants.LOG_DEBUG) {
                LogUtils.e(TAG, "resetBdDns exception", e2);
            }
        }
    }

    static boolean isDirectConnect() {
        List<String> list = bdDnsIpList;
        return list != null && curBdDNSIpIndex <= list.size();
    }

    static void refresh(Context context, String ip, boolean refreshCache) {
        resetBdDns(context);
        DefaultUrlProvider.getUrlProvider(context).onConnectSuccess(ip, true);
    }

    public static int setNextPolicy(int policy, Context context) {
        int env = LCPConstants.getLcpDebugEnv(context);
        if (env != 1 && env != 2) {
            currentPolicy = policy;
            switch (policy) {
                case 0:
                    currentPolicy = 0;
                    break;
                case 1:
                    currentPolicy = 1;
                    break;
                case 2:
                    currentPolicy = 2;
                    break;
                case 3:
                    currentPolicy = 3;
                    break;
                default:
                    currentPolicy = 3;
                    break;
            }
        } else {
            currentPolicy = 3;
        }
        if (LCPConstants.LOG_DEBUG) {
            LogUtils.d(TAG, "try to connect ip, now policy =" + currentPolicy);
        }
        return currentPolicy;
    }

    public static boolean isIpv4(String ip) {
        if (ip == null || ip.isEmpty()) {
            return false;
        }
        return ip.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
    }

    public static int getCurrentPolicy() {
        return currentPolicy;
    }
}
