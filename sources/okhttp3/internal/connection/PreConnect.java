package okhttp3.internal.connection;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Timeout;

public class PreConnect {
    public static final Call NONE = new Call() {
        public Request request() {
            return null;
        }

        public Response execute() throws IOException {
            return null;
        }

        public void enqueue(Callback callback) {
        }

        public void cancel() {
        }

        public boolean isExecuted() {
            return false;
        }

        public boolean isCanceled() {
            return false;
        }

        public Timeout timeout() {
            return null;
        }

        public Call clone() {
            return null;
        }
    };
    private static Map<String, Integer> preConnectUrlMap;
    private static volatile ScheduledExecutorService scheduledExecutorService;

    public static void startPreConnect(OkHttpClient client) {
        Map<String, Integer> preConnectNoDelayMap;
        PreConnectParams preConnectParams = client.getPreConnectParams();
        List<String> preConnectUrlsAllowlist = preConnectParams.getPreConnectUrlsAllowlist();
        List<String> preConnectNoDelayUrlsWithNum = preConnectParams.getPreConnectNoDelayUrlsWithNum();
        List<String> preConnectDelayUrlsWithNum = preConnectParams.getPreConnectDelayUrlsWithNum();
        int preConnectDelayTimeMs = preConnectParams.getPreConnectDelayTimeMs();
        int preConnectPeriodTimeMs = preConnectParams.getPreConnectPeriodTimeMs();
        if (preConnectParams.getPreConnectEnabled() && preConnectDelayTimeMs > 0 && preConnectPeriodTimeMs > 0 && preConnectUrlsAllowlist != null && preConnectUrlsAllowlist.size() >= 1) {
            if ((preConnectDelayUrlsWithNum != null && preConnectDelayUrlsWithNum.size() >= 1) || (preConnectNoDelayUrlsWithNum != null && preConnectNoDelayUrlsWithNum.size() >= 1)) {
                preConnectUrlMap = getPreConnectUrlMap(preConnectDelayUrlsWithNum);
                if (preConnectNoDelayUrlsWithNum != null && preConnectNoDelayUrlsWithNum.size() > 0 && (preConnectNoDelayMap = getPreConnectUrlMap(preConnectNoDelayUrlsWithNum)) != null && preConnectNoDelayMap.size() > 0) {
                    buildPreConnectWithoutDelay(client, preConnectUrlsAllowlist, preConnectNoDelayMap);
                    for (Map.Entry<String, Integer> entry : preConnectNoDelayMap.entrySet()) {
                        if (preConnectUrlMap.containsKey(entry.getKey())) {
                            int noDelayNum = entry.getValue().intValue();
                            int num = preConnectUrlMap.get(entry.getKey()).intValue();
                            preConnectUrlMap.put(entry.getKey(), Integer.valueOf(noDelayNum > num ? noDelayNum : num));
                        } else {
                            preConnectUrlMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                Map<String, Integer> preConnectNoDelayMap2 = preConnectUrlMap;
                if (preConnectNoDelayMap2 != null && preConnectNoDelayMap2.size() > 0) {
                    scheduledExecutorService().scheduleAtFixedRate(new PreConnectTask(client, preConnectUrlMap), (long) preConnectDelayTimeMs, (long) preConnectPeriodTimeMs, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    private static void buildPreConnectWithoutDelay(OkHttpClient client, List<String> preConnectUrlsAllowlist, Map<String, Integer> preConnectNoDelayMap) {
        if (preConnectNoDelayMap != null && preConnectNoDelayMap.size() >= 1) {
            Map<HttpUrl, Integer> preConnectHttpUrlMap = new HashMap<>();
            for (Map.Entry<String, Integer> entry : preConnectNoDelayMap.entrySet()) {
                if (preConnectUrlsAllowlist.contains(entry.getKey())) {
                    preConnectHttpUrlMap.put(getHttpUrl(entry.getKey()), Integer.valueOf(Math.min(entry.getValue().intValue(), client.getPreConnectParams().getMaxSingleHostPreConnectNum())));
                }
            }
            for (Map.Entry<HttpUrl, Integer> entry2 : preConnectHttpUrlMap.entrySet()) {
                buildPreConnect(client, entry2.getKey(), entry2.getValue().intValue(), preConnectHttpUrlMap);
            }
        }
    }

    private static Map<String, Integer> getPreConnectUrlMap(List<String> preConnectUrlsWithNums) {
        Map<String, Integer> preConnectUrlWithNumsMap = new HashMap<>();
        if (preConnectUrlsWithNums != null && preConnectUrlsWithNums.size() > 0) {
            for (String preConnect : preConnectUrlsWithNums) {
                if (preConnect.contains("|")) {
                    String[] split = preConnect.split("\\|");
                    preConnectUrlWithNumsMap.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
                }
            }
        }
        return preConnectUrlWithNumsMap;
    }

    /* access modifiers changed from: private */
    public static HttpUrl getHttpUrl(String url) {
        if (url != null) {
            if (url.regionMatches(true, 0, "ws:", 0, 3)) {
                url = "http:" + url.substring(3);
            } else if (url.regionMatches(true, 0, "wss:", 0, 4)) {
                url = "https:" + url.substring(4);
            }
            return HttpUrl.parse(url);
        }
        throw new NullPointerException("url == null");
    }

    /* access modifiers changed from: private */
    public static void buildPreConnect(OkHttpClient client, HttpUrl httpUrl, int preConnectNum, Map<HttpUrl, Integer> preConnectHttpUrlMap) {
        client.dispatcher().executorService().execute(new PreConnectRunnable(client, httpUrl, preConnectNum, preConnectHttpUrlMap));
    }

    private static class PreConnectTask implements Runnable {
        private static List<String> mPreConnectAllowlist;
        private OkHttpClient mClient;
        private ConnectionPool mConnectionPool = this.mClient.connectionPool();
        private Map<HttpUrl, Integer> mPreConnectHttpUrlMap;
        private Map<String, Integer> mPreConnectUrlMap;
        private int maxSingleHostPreConnectNum;

        public PreConnectTask(OkHttpClient client, Map<String, Integer> preConnectUrlMap) {
            this.mClient = client;
            this.maxSingleHostPreConnectNum = client.getPreConnectParams().getMaxSingleHostPreConnectNum();
            mPreConnectAllowlist = client.getPreConnectParams().getPreConnectUrlsAllowlist();
            this.mPreConnectUrlMap = preConnectUrlMap;
            this.mPreConnectHttpUrlMap = new HashMap();
            for (Map.Entry<String, Integer> entry : this.mPreConnectUrlMap.entrySet()) {
                if (mPreConnectAllowlist.contains(entry.getKey())) {
                    this.mPreConnectHttpUrlMap.put(PreConnect.getHttpUrl(entry.getKey()), Integer.valueOf(Math.min(entry.getValue().intValue(), this.maxSingleHostPreConnectNum)));
                }
            }
        }

        public void run() {
            if (this.mConnectionPool.getPreConnectAlive(this.mPreConnectHttpUrlMap) < this.mClient.getPreConnectParams().getMaxPreConnectNum()) {
                for (Map.Entry<HttpUrl, Integer> entry : this.mPreConnectHttpUrlMap.entrySet()) {
                    if (this.mConnectionPool.connectionsCount(entry.getKey().host(), false) < entry.getValue().intValue()) {
                        PreConnect.buildPreConnect(this.mClient, entry.getKey(), entry.getValue().intValue(), this.mPreConnectHttpUrlMap);
                    }
                }
            }
        }
    }

    private static ScheduledExecutorService scheduledExecutorService() {
        if (scheduledExecutorService == null) {
            synchronized (PreConnect.class) {
                if (scheduledExecutorService == null) {
                    scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
                }
            }
        }
        return scheduledExecutorService;
    }
}
