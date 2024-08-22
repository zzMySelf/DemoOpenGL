package com.baidu.searchbox.aps.base.db;

import android.content.Context;
import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import com.baidu.searchbox.aps.base.Plugin;
import com.baidu.searchbox.aps.base.utils.BaseConfiger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginCache {
    private static Map<String, PluginCache> sMap;
    private LongSparseArray<List<Dependence>> mDependenceArray;
    private boolean mDownloadBroken = false;
    private boolean mDownloadEnable = true;
    private boolean mDownloadNeedRemove = false;
    private long mDownloadVersion = -1;
    private boolean mHasSync = false;
    private boolean mInstallBroken = false;
    private boolean mInstallEnable = true;
    private Set<String> mInstallInvokeMethods;
    private boolean mInstallNeedRemove = false;
    private String mInstallTip;
    private long mInstallVersion = -1;
    private String mName;
    private String mPackageName;
    private boolean mSilentEnable = false;
    private boolean mUpdateBroken = false;
    private boolean mUpdateEnable = true;
    private boolean mUpdateNeedRemove = false;
    private long mUpdateVersion = -1;

    public static class Dependence {
        public static final String DEPENDENCE_PACKAGE_NAME = "package_name";
        public static final String DEPENDENCE_PLUGIN_NAME = "plugin_name";
        public static final String DEPENDENCE_TIPS = "tips";
        public static final String DEPENDENCE_VERSION = "version";
        public String name;
        public String packageName;
        public String tips;
        public long version;
    }

    public static synchronized PluginCache getInstance(String packageName) {
        PluginCache cache;
        synchronized (PluginCache.class) {
            if (sMap == null) {
                sMap = new HashMap();
            }
            cache = sMap.get(packageName);
            if (cache == null) {
                cache = new PluginCache(packageName);
                sMap.put(packageName, cache);
            }
        }
        return cache;
    }

    private PluginCache(String packageName) {
        this.mPackageName = packageName;
        this.mDependenceArray = new LongSparseArray<>();
        this.mInstallInvokeMethods = new HashSet();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        reset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        if (r0 == null) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        if (r0.installPlugin == null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        r4.mInstallVersion = r0.installPlugin.version;
        r4.mInstallEnable = r0.installPlugin.enable;
        r4.mInstallBroken = r0.installPlugin.broken;
        r4.mInstallNeedRemove = r0.installPlugin.needRemove;
        refreshInstallInvokeMethods(r0.installPlugin.invokeMethods);
        updateDependence(r0.installPlugin.version, r0.installPlugin.dependence);
        updateCommonValueWithoutLock(r0.installPlugin);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r0.downloadPlugin == null) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004b, code lost:
        r4.mDownloadVersion = r0.downloadPlugin.version;
        r4.mDownloadEnable = r0.downloadPlugin.enable;
        r4.mDownloadBroken = r0.downloadPlugin.broken;
        r4.mDownloadNeedRemove = r0.downloadPlugin.needRemove;
        updateDependence(r0.downloadPlugin.version, r0.downloadPlugin.dependence);
        updateCommonValueWithoutLock(r0.downloadPlugin);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0075, code lost:
        if (r0.updatePlugin == null) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0077, code lost:
        r4.mUpdateVersion = r0.updatePlugin.version;
        r4.mUpdateEnable = r0.updatePlugin.enable;
        r4.mUpdateBroken = r0.updatePlugin.broken;
        r4.mUpdateNeedRemove = r0.updatePlugin.needRemove;
        updateDependence(r0.updatePlugin.version, r0.updatePlugin.dependence);
        updateCommonValueWithoutLock(r0.updatePlugin);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009f, code lost:
        r4.mHasSync = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a2, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a3, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0008, code lost:
        r0 = com.baidu.searchbox.aps.base.manager.PluginGroupManager.getPluginGroup(r5, r4.mPackageName);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000e, code lost:
        monitor-enter(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sync(android.content.Context r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.mHasSync     // Catch:{ all -> 0x00a7 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r4)     // Catch:{ all -> 0x00a7 }
            return
        L_0x0007:
            monitor-exit(r4)     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = r4.mPackageName
            com.baidu.searchbox.aps.base.manager.PluginGroupManager$PluginGroup r0 = com.baidu.searchbox.aps.base.manager.PluginGroupManager.getPluginGroup(r5, r0)
            monitor-enter(r4)
            r4.reset()     // Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x009f
            com.baidu.searchbox.aps.base.Plugin r1 = r0.installPlugin     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x0047
            com.baidu.searchbox.aps.base.Plugin r1 = r0.installPlugin     // Catch:{ all -> 0x00a4 }
            long r1 = r1.version     // Catch:{ all -> 0x00a4 }
            r4.mInstallVersion = r1     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.installPlugin     // Catch:{ all -> 0x00a4 }
            boolean r1 = r1.enable     // Catch:{ all -> 0x00a4 }
            r4.mInstallEnable = r1     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.installPlugin     // Catch:{ all -> 0x00a4 }
            boolean r1 = r1.broken     // Catch:{ all -> 0x00a4 }
            r4.mInstallBroken = r1     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.installPlugin     // Catch:{ all -> 0x00a4 }
            boolean r1 = r1.needRemove     // Catch:{ all -> 0x00a4 }
            r4.mInstallNeedRemove = r1     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.installPlugin     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r1.invokeMethods     // Catch:{ all -> 0x00a4 }
            r4.refreshInstallInvokeMethods(r1)     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.installPlugin     // Catch:{ all -> 0x00a4 }
            long r1 = r1.version     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r3 = r0.installPlugin     // Catch:{ all -> 0x00a4 }
            java.lang.String r3 = r3.dependence     // Catch:{ all -> 0x00a4 }
            r4.updateDependence(r1, r3)     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.installPlugin     // Catch:{ all -> 0x00a4 }
            r4.updateCommonValueWithoutLock(r1)     // Catch:{ all -> 0x00a4 }
        L_0x0047:
            com.baidu.searchbox.aps.base.Plugin r1 = r0.downloadPlugin     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x0073
            com.baidu.searchbox.aps.base.Plugin r1 = r0.downloadPlugin     // Catch:{ all -> 0x00a4 }
            long r1 = r1.version     // Catch:{ all -> 0x00a4 }
            r4.mDownloadVersion = r1     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.downloadPlugin     // Catch:{ all -> 0x00a4 }
            boolean r1 = r1.enable     // Catch:{ all -> 0x00a4 }
            r4.mDownloadEnable = r1     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.downloadPlugin     // Catch:{ all -> 0x00a4 }
            boolean r1 = r1.broken     // Catch:{ all -> 0x00a4 }
            r4.mDownloadBroken = r1     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.downloadPlugin     // Catch:{ all -> 0x00a4 }
            boolean r1 = r1.needRemove     // Catch:{ all -> 0x00a4 }
            r4.mDownloadNeedRemove = r1     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.downloadPlugin     // Catch:{ all -> 0x00a4 }
            long r1 = r1.version     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r3 = r0.downloadPlugin     // Catch:{ all -> 0x00a4 }
            java.lang.String r3 = r3.dependence     // Catch:{ all -> 0x00a4 }
            r4.updateDependence(r1, r3)     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.downloadPlugin     // Catch:{ all -> 0x00a4 }
            r4.updateCommonValueWithoutLock(r1)     // Catch:{ all -> 0x00a4 }
        L_0x0073:
            com.baidu.searchbox.aps.base.Plugin r1 = r0.updatePlugin     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x009f
            com.baidu.searchbox.aps.base.Plugin r1 = r0.updatePlugin     // Catch:{ all -> 0x00a4 }
            long r1 = r1.version     // Catch:{ all -> 0x00a4 }
            r4.mUpdateVersion = r1     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.updatePlugin     // Catch:{ all -> 0x00a4 }
            boolean r1 = r1.enable     // Catch:{ all -> 0x00a4 }
            r4.mUpdateEnable = r1     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.updatePlugin     // Catch:{ all -> 0x00a4 }
            boolean r1 = r1.broken     // Catch:{ all -> 0x00a4 }
            r4.mUpdateBroken = r1     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.updatePlugin     // Catch:{ all -> 0x00a4 }
            boolean r1 = r1.needRemove     // Catch:{ all -> 0x00a4 }
            r4.mUpdateNeedRemove = r1     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.updatePlugin     // Catch:{ all -> 0x00a4 }
            long r1 = r1.version     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r3 = r0.updatePlugin     // Catch:{ all -> 0x00a4 }
            java.lang.String r3 = r3.dependence     // Catch:{ all -> 0x00a4 }
            r4.updateDependence(r1, r3)     // Catch:{ all -> 0x00a4 }
            com.baidu.searchbox.aps.base.Plugin r1 = r0.updatePlugin     // Catch:{ all -> 0x00a4 }
            r4.updateCommonValueWithoutLock(r1)     // Catch:{ all -> 0x00a4 }
        L_0x009f:
            r1 = 1
            r4.mHasSync = r1     // Catch:{ all -> 0x00a4 }
            monitor-exit(r4)     // Catch:{ all -> 0x00a4 }
            return
        L_0x00a4:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00a4 }
            throw r1
        L_0x00a7:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00a7 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.aps.base.db.PluginCache.sync(android.content.Context):void");
    }

    public synchronized void update(Plugin plugin) {
        if (this.mHasSync) {
            if (plugin.type == 1) {
                this.mInstallVersion = plugin.version;
                this.mInstallEnable = plugin.enable;
                this.mInstallBroken = plugin.broken;
                this.mInstallNeedRemove = plugin.needRemove;
                refreshInstallInvokeMethods(plugin.invokeMethods);
            } else if (plugin.type == 2) {
                this.mDownloadVersion = plugin.version;
                this.mDownloadEnable = plugin.enable;
                this.mDownloadBroken = plugin.broken;
                this.mDownloadNeedRemove = plugin.needRemove;
            } else if (plugin.type == 3) {
                this.mUpdateVersion = plugin.version;
                this.mUpdateEnable = plugin.enable;
                this.mUpdateBroken = plugin.broken;
                this.mUpdateNeedRemove = plugin.needRemove;
            }
            updateCommonValueWithoutLock(plugin);
            updateDependence(plugin.version, plugin.dependence);
        }
    }

    public synchronized void updateCommonValue(Plugin plugin) {
        if (this.mHasSync) {
            updateCommonValueWithoutLock(plugin);
        }
    }

    private void updateCommonValueWithoutLock(Plugin plugin) {
        this.mName = plugin.name;
        this.mInstallTip = plugin.installTip;
        this.mSilentEnable = isSilentEnable(plugin.behavior);
    }

    public synchronized void update(int oldType, int newType) {
        if (this.mHasSync) {
            this.mHasSync = false;
        }
    }

    private synchronized void reset() {
        resetInstallDataWithoutLock();
        resetDownloadDataWithoutLock();
        resetUpdateDataWithoutLock();
        resetCommonValueWithoutLock();
        resetWholeDataWithoutLock();
    }

    private void resetInstallDataWithoutLock() {
        this.mInstallVersion = -1;
        this.mInstallEnable = true;
        this.mInstallBroken = false;
        this.mInstallNeedRemove = false;
        this.mInstallInvokeMethods.clear();
    }

    private void resetDownloadDataWithoutLock() {
        this.mDownloadVersion = -1;
        this.mDownloadEnable = true;
        this.mDownloadBroken = false;
        this.mDownloadNeedRemove = false;
    }

    private void resetUpdateDataWithoutLock() {
        this.mUpdateVersion = -1;
        this.mUpdateEnable = true;
        this.mUpdateBroken = false;
        this.mUpdateNeedRemove = false;
    }

    private void resetCommonValueWithoutLock() {
        this.mName = null;
        this.mInstallTip = null;
        this.mSilentEnable = false;
    }

    private void resetWholeDataWithoutLock() {
        this.mDependenceArray.clear();
    }

    public synchronized void delete() {
        if (this.mHasSync) {
            reset();
        }
    }

    public synchronized void delete(int type) {
        if (this.mHasSync) {
            this.mHasSync = false;
        }
    }

    public long getInstallVersion(Context context) {
        sync(context);
        synchronized (this) {
            if (!this.mInstallEnable || this.mInstallNeedRemove) {
                return -1;
            }
            long j2 = this.mInstallVersion;
            return j2;
        }
    }

    public long getDBInstallVersion(Context context) {
        long j2;
        sync(context);
        synchronized (this) {
            j2 = this.mInstallVersion;
        }
        return j2;
    }

    public boolean isInstallBroken(Context context) {
        boolean z;
        sync(context);
        synchronized (this) {
            z = this.mInstallBroken;
        }
        return z;
    }

    public boolean isInstallEnable(Context context) {
        boolean z;
        sync(context);
        synchronized (this) {
            z = this.mInstallEnable;
        }
        return z;
    }

    public boolean isInstallNeedRemove(Context context) {
        boolean z;
        sync(context);
        synchronized (this) {
            z = this.mInstallNeedRemove;
        }
        return z;
    }

    public boolean isInstallInvokeMethod(Context context, String methodName) {
        boolean contains;
        sync(context);
        synchronized (this) {
            contains = this.mInstallInvokeMethods.contains(methodName);
        }
        return contains;
    }

    public Dependence findDependenceVersion(Context context, long oVersion, String dPackageName) {
        sync(context);
        synchronized (this) {
            List<Dependence> list = this.mDependenceArray.get(oVersion);
            if (list == null) {
                return null;
            }
            for (Dependence d2 : list) {
                if (d2 != null) {
                    if (TextUtils.equals(d2.packageName, dPackageName)) {
                        return d2;
                    }
                }
            }
            return null;
        }
    }

    public List<Dependence> getDependence(Context context) {
        sync(context);
        synchronized (this) {
            int size = this.mDependenceArray.size();
            long version = -1;
            boolean hasList = false;
            for (int i2 = 0; i2 < size; i2++) {
                long key = this.mDependenceArray.keyAt(i2);
                if (version < key) {
                    version = key;
                    hasList = true;
                }
            }
            if (!hasList) {
                return null;
            }
            List<Dependence> list = this.mDependenceArray.get(version);
            return list;
        }
    }

    public List<Dependence> getDependence(Context context, long oVersion) {
        List<Dependence> list;
        sync(context);
        synchronized (this) {
            list = this.mDependenceArray.get(oVersion);
        }
        return list;
    }

    private void refreshInstallInvokeMethods(String invokeMethods) {
        this.mInstallInvokeMethods.clear();
        if (!TextUtils.isEmpty(invokeMethods)) {
            try {
                JSONArray jArray = new JSONArray(invokeMethods);
                for (int i2 = 0; i2 < jArray.length(); i2++) {
                    String method = jArray.getString(i2);
                    if (!TextUtils.isEmpty(method)) {
                        this.mInstallInvokeMethods.add(method);
                    }
                }
            } catch (JSONException e2) {
                if (BaseConfiger.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void updateDependence(long version, String dependence) {
        this.mDependenceArray.remove(version);
        if (!TextUtils.isEmpty(dependence)) {
            List<Dependence> list = new ArrayList<>();
            try {
                JSONArray jArray = new JSONArray(dependence);
                for (int i2 = 0; i2 < jArray.length(); i2++) {
                    Dependence d2 = getDependence(jArray.getJSONObject(i2));
                    if (d2 != null) {
                        list.add(d2);
                    }
                }
            } catch (JSONException e2) {
                if (BaseConfiger.isDebug()) {
                    e2.printStackTrace();
                }
            }
            this.mDependenceArray.put(version, list);
        }
    }

    private Dependence getDependence(JSONObject jObject) {
        if (jObject == null) {
            return null;
        }
        Dependence d2 = new Dependence();
        d2.name = jObject.optString(Dependence.DEPENDENCE_PLUGIN_NAME);
        d2.tips = jObject.optString("tips");
        try {
            d2.packageName = jObject.getString("package_name");
            d2.version = Long.valueOf(jObject.getString("version")).longValue();
            return d2;
        } catch (JSONException e2) {
            if (BaseConfiger.isDebug()) {
                e2.printStackTrace();
            }
            return null;
        } catch (NumberFormatException e3) {
            if (BaseConfiger.isDebug()) {
                e3.printStackTrace();
            }
            return null;
        }
    }

    public String getInstallTip(Context context) {
        String str;
        sync(context);
        synchronized (this) {
            str = this.mInstallTip;
        }
        return str;
    }

    public String getName(Context context) {
        String str;
        sync(context);
        synchronized (this) {
            str = this.mName;
        }
        return str;
    }

    public long getDownloadVersion(Context context) {
        sync(context);
        synchronized (this) {
            if (!this.mDownloadEnable || this.mDownloadNeedRemove) {
                return -1;
            }
            long j2 = this.mDownloadVersion;
            return j2;
        }
    }

    public long getUpdateVersion(Context context) {
        sync(context);
        synchronized (this) {
            if (!this.mUpdateEnable || this.mUpdateNeedRemove) {
                return -1;
            }
            long j2 = this.mUpdateVersion;
            return j2;
        }
    }

    private boolean isSilentEnable(String behavior) {
        if (TextUtils.isEmpty(behavior)) {
            return false;
        }
        try {
            JSONObject jObject = new JSONObject(behavior);
            boolean isSilence = "1".equals(jObject.optString("issilence"));
            boolean isWifi = "1".equals(jObject.optString("wifi"));
            if (!isSilence || !isWifi) {
                return false;
            }
            return true;
        } catch (JSONException e2) {
            if (BaseConfiger.isDebug()) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public boolean isSilentEnable(Context context) {
        boolean z;
        sync(context);
        synchronized (this) {
            z = this.mSilentEnable;
        }
        return z;
    }

    public boolean isUpdateBroken(Context context) {
        boolean z;
        sync(context);
        synchronized (this) {
            z = this.mUpdateBroken;
        }
        return z;
    }

    public boolean isDownloadBroken(Context context) {
        boolean z;
        sync(context);
        synchronized (this) {
            z = this.mDownloadBroken;
        }
        return z;
    }
}
