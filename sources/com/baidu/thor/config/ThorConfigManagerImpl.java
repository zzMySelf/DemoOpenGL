package com.baidu.thor.config;

import android.text.TextUtils;
import com.baidu.thor.base.ThorConfig;
import com.baidu.thor.base.ThorKV;
import com.baidu.thor.common.ThorContext;
import com.baidu.thor.common.ThorLog;
import com.baidu.thor.common.ThorPaths;
import com.baidu.thor.downloader.PMSManagerHelper;
import com.baidu.thor.sdk.manager.ioc.IThorConfig;
import com.baidu.thor.sdk.manager.ioc.IThorConfigManager;
import com.baidu.thor.sdk.manager.ioc.PluginFuncInfo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThorConfigManagerImpl implements IThorConfigManager {
    private static final String CLOUD_CONFIG_FILENAME = "cloud-config.list";
    private static final String CLOUD_RETRIEVE_FILENAME = "retrieve-config.list";
    private static final String GLOBAL_IDLE_CACHE_FILENAME = "idle-config.cache";
    private static final String GLOBAL_NOW_CACHE_FILENAME = "now-config.cache";
    private static final String TAG = "ThorConfigManagerImpl";
    private static ConcurrentHashMap<Integer, IThorConfig> thorConfigMap = new ConcurrentHashMap<>();

    public void updateConfig(IThorConfig config) {
        if (config != null) {
            ThorLog.i(TAG, "<<< Start update config.");
            HashMap<String, PluginFuncInfo> pluginFuncInfos = config.getPluginFuncInfos();
            if (pluginFuncInfos == null || pluginFuncInfos.isEmpty()) {
                ThorLog.i(TAG, ">>> End update config. update infos is empty.");
                return;
            }
            IThorConfig oldConfig = getConfig(config.getType());
            if (oldConfig == null || oldConfig.getPluginFuncInfos() == null || oldConfig.getPluginFuncInfos().isEmpty()) {
                oldConfig = new ThorConfig(config.getType(), config.getEnable(), pluginFuncInfos);
            } else if (pluginFuncInfos != null && !pluginFuncInfos.isEmpty()) {
                HashMap<String, PluginFuncInfo> oldInfos = oldConfig.getPluginFuncInfos();
                for (PluginFuncInfo info : pluginFuncInfos.values()) {
                    if (info != null) {
                        String pluginFuncName = info.getPluginFuncName();
                        if (!TextUtils.isEmpty(pluginFuncName)) {
                            PluginFuncInfo oldInfo = oldInfos.get(pluginFuncName);
                            if (oldInfo != null) {
                                String versionTime = info.getVersionTime();
                                String oldVersionTime = oldInfo.getVersionTime();
                                if (!TextUtils.isEmpty(versionTime) && !TextUtils.isEmpty(oldVersionTime) && Long.valueOf(versionTime) != Long.valueOf(oldVersionTime)) {
                                    oldInfos.put(pluginFuncName, info);
                                }
                            } else {
                                oldInfos.put(pluginFuncName, info);
                            }
                        }
                    }
                }
            }
            oldConfig.setEnable(config.getEnable());
            saveConfig(oldConfig);
            ThorLog.i(TAG, ">>> End update config.");
        }
    }

    public synchronized void saveConfig(IThorConfig config) {
        if (config != null) {
            ThorLog.i(TAG, "<<< Start save config: " + config.toString());
            HashMap<String, PluginFuncInfo> infos = config.getPluginFuncInfos();
            if (infos != null) {
                String configFileName = getConfigFileName(config.getType());
                if (!TextUtils.isEmpty(configFileName)) {
                    File configFile = new File(ThorPaths.THOR_DIR + "/" + configFileName);
                    try {
                        if (configFile.exists() || configFile.createNewFile()) {
                            JSONObject obj = new JSONObject();
                            obj.put("thor_enable", config.getEnable());
                            JSONArray jsonArray = new JSONArray();
                            for (PluginFuncInfo info : infos.values()) {
                                if (info != null) {
                                    jsonArray.put(info.toJSONObject());
                                }
                            }
                            obj.put("thor_plugin_funcs", jsonArray);
                            BufferedWriter bw = new BufferedWriter(new FileWriter(configFile));
                            bw.write(obj.toString());
                            bw.flush();
                            closeSilently(bw);
                            thorConfigMap.put(Integer.valueOf(config.getType()), config);
                            ThorLog.i(TAG, ">>> End save config.");
                            return;
                        }
                        closeSilently((Closeable) null);
                        return;
                    } catch (IOException e2) {
                        ThorLog.e(TAG, "Create file exception.", e2);
                        closeSilently((Closeable) null);
                    } catch (JSONException e3) {
                        try {
                            ThorLog.e(TAG, "Json exception.", e3);
                        } finally {
                            closeSilently((Closeable) null);
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            return;
        }
    }

    public IThorConfig getConfig(int type) {
        ThorLog.i(TAG, "<<< Start get config. type: " + type);
        IThorConfig cachedConfig = thorConfigMap.get(Integer.valueOf(type));
        if (cachedConfig != null) {
            ThorLog.i(TAG, ">>> End get config. get config from cached.");
            return cachedConfig;
        }
        String configFileName = getConfigFileName(type);
        if (TextUtils.isEmpty(configFileName)) {
            ThorLog.i(TAG, ">>> End get config. config file name is empty.");
            return null;
        }
        IThorConfig thorConfig = getConfig(ThorPaths.THOR_DIR + "/" + configFileName);
        if (thorConfig != null) {
            thorConfig.setType(type);
            thorConfigMap.put(Integer.valueOf(type), thorConfig);
        }
        ThorLog.i(TAG, ">>> End get config.");
        return thorConfig;
    }

    private IThorConfig getConfig(String configPath) {
        if (TextUtils.isEmpty(configPath)) {
            ThorLog.i(TAG, ">>> End get config. config path is empty.");
            return null;
        }
        File configFile = new File(configPath);
        if (!configFile.exists()) {
            ThorLog.i(TAG, ">>> End get config. config file isn't exists.");
            return null;
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(configFile));
            return getConfig(br);
        } catch (FileNotFoundException e2) {
            ThorLog.e(TAG, "", e2);
            return null;
        } finally {
            closeSilently(br);
        }
    }

    private IThorConfig getConfig(BufferedReader br) {
        if (br == null) {
            return null;
        }
        boolean thorEnable = false;
        HashMap<String, PluginFuncInfo> infos = new HashMap<>();
        StringBuilder buffer = new StringBuilder();
        while (true) {
            try {
                String readLine = br.readLine();
                String line = readLine;
                if (readLine == null) {
                    break;
                } else if (!line.startsWith("#")) {
                    buffer.append(line);
                }
            } catch (Exception e2) {
                ThorLog.e(TAG, "", e2);
            } finally {
                closeSilently(br);
            }
        }
        JSONObject obj = new JSONObject(buffer.toString());
        thorEnable = obj.optBoolean("thor_enable");
        JSONArray jsonArray = obj.optJSONArray("thor_plugin_funcs");
        for (int i2 = 0; i2 < jsonArray.length(); i2++) {
            JSONObject jo = null;
            try {
                jo = jsonArray.getJSONObject(i2);
                if (jo == null) {
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            PluginFuncInfo pluginFuncInfo = new PluginFuncInfo(jo);
            String pluginFuncName = pluginFuncInfo.getPluginFuncName();
            if (!TextUtils.isEmpty(pluginFuncName)) {
                infos.put(pluginFuncName, pluginFuncInfo);
            }
        }
        return new ThorConfig(-1, thorEnable, infos);
    }

    public IThorConfig getBuiltInConfig(String builtInConfig) {
        if (TextUtils.isEmpty(builtInConfig)) {
            return null;
        }
        InputStream is = null;
        BufferedReader br = null;
        try {
            is = ThorContext.getAppContext().getAssets().open(builtInConfig);
            br = new BufferedReader(new InputStreamReader(is));
            return getConfig(br);
        } catch (IOException e2) {
            ThorLog.e(TAG, "", e2);
            return null;
        } finally {
            closeSilently(br);
            closeSilently(is);
        }
    }

    public synchronized void refreshConfig() {
        Iterator<String> it;
        HashMap<String, PluginFuncInfo> funcInfos;
        synchronized (this) {
            IThorConfig retrieveConfig = getConfig(2);
            IThorConfig cloudConfig = getConfig(1);
            IThorConfig nowCacheConfig = getConfig(3);
            IThorConfig idleCacheConfig = getConfig(4);
            if (retrieveConfig != null && ((funcInfos = retrieveConfig.getPluginFuncInfos()) == null || funcInfos.isEmpty())) {
                retrieveConfig.setEnable(false);
            }
            if (cloudConfig != null) {
                cloudConfig.setEnable(ThorKV.getInstance().getBooleanWrapper("thor_config", "thor_enable", false));
            }
            ConfigHandler retrieveConfigHandler = new ConfigHandler(retrieveConfig);
            retrieveConfigHandler.setNextHandler(new ConfigHandler(cloudConfig));
            ThorKV.getInstance().putBoolean(ThorKV.Constants.THOR_MAIN_ENABLE, retrieveConfigHandler.getEnable());
            Set<String> allPkgNames = new HashSet<>();
            HashMap<String, PluginFuncInfo> retrieveInfos = null;
            HashMap<String, PluginFuncInfo> cloudInfos = null;
            if (!(retrieveConfig == null || (retrieveInfos = retrieveConfig.getPluginFuncInfos()) == null || retrieveInfos.isEmpty())) {
                for (PluginFuncInfo info : retrieveInfos.values()) {
                    if (info != null) {
                        if (!TextUtils.isEmpty(info.getPluginPackageName())) {
                            allPkgNames.add(info.getPluginPackageName());
                        }
                    }
                }
            }
            if (!(cloudConfig == null || (cloudInfos = cloudConfig.getPluginFuncInfos()) == null || cloudInfos.isEmpty())) {
                for (PluginFuncInfo info2 : cloudInfos.values()) {
                    if (info2 != null) {
                        if (!TextUtils.isEmpty(info2.getPluginPackageName())) {
                            allPkgNames.add(info2.getPluginPackageName());
                        }
                    }
                }
            }
            Iterator<String> it2 = allPkgNames.iterator();
            while (it2.hasNext()) {
                String pkgName = it2.next();
                if (!TextUtils.isEmpty(pkgName)) {
                    if (retrieveConfigHandler.isExpired(pkgName)) {
                        it = it2;
                        ThorLog.i(TAG, "Plugin: " + pkgName + "is expired.");
                        PMSManagerHelper.getInstance().uninstall(pkgName);
                    } else {
                        it = it2;
                    }
                    it2 = it;
                }
            }
            Set<String> hashSet = new HashSet<>();
            if (retrieveInfos != null && !retrieveInfos.isEmpty()) {
                hashSet.addAll(retrieveInfos.keySet());
            }
            if (cloudInfos != null && !cloudInfos.isEmpty()) {
                hashSet.addAll(cloudInfos.keySet());
            }
            HashMap<String, PluginFuncInfo> nowInfos = new HashMap<>();
            HashMap<String, PluginFuncInfo> idleInfos = new HashMap<>();
            for (String funcName : hashSet) {
                Set<String> allFuncNames = hashSet;
                PluginFuncInfo funcInfo = syncCache(retrieveConfigHandler.getFuncInfo("now", funcName), nowCacheConfig);
                if (funcInfo != null) {
                    nowInfos.put(funcName, funcInfo);
                }
                PluginFuncInfo pluginFuncInfo = funcInfo;
                PluginFuncInfo funcInfo2 = syncCache(retrieveConfigHandler.getFuncInfo(PluginFuncInfo.TAKE_EFFECT_RESTART_NOW, funcName), nowCacheConfig);
                if (funcInfo2 != null) {
                    nowInfos.put(funcName, funcInfo2);
                }
                PluginFuncInfo pluginFuncInfo2 = funcInfo2;
                PluginFuncInfo funcInfo3 = syncCache(retrieveConfigHandler.getFuncInfo(PluginFuncInfo.TAKE_EFFECT_RESTART_IDLE, funcName), idleCacheConfig);
                if (funcInfo3 != null) {
                    idleInfos.put(funcName, funcInfo3);
                }
                hashSet = allFuncNames;
            }
            Set<String> allFuncNames2 = hashSet;
            IThorConfig nowCacheConfig2 = new ThorConfig(3, !nowInfos.isEmpty(), nowInfos);
            IThorConfig idleCacheConfig2 = new ThorConfig(4, !idleInfos.isEmpty(), idleInfos);
            saveConfig(retrieveConfig);
            saveConfig(cloudConfig);
            saveConfig(nowCacheConfig2);
            saveConfig(idleCacheConfig2);
        }
    }

    private PluginFuncInfo syncCache(PluginFuncInfo originalFuncInfo, IThorConfig cacheConfig) {
        PluginFuncInfo cacheFuncInfo;
        if (originalFuncInfo == null || cacheConfig == null) {
            return originalFuncInfo;
        }
        String originalFuncName = originalFuncInfo.getPluginFuncName();
        String originalVersionTime = originalFuncInfo.getVersionTime();
        HashMap<String, PluginFuncInfo> infos = cacheConfig.getPluginFuncInfos();
        if (TextUtils.isEmpty(originalFuncName) || TextUtils.isEmpty(originalVersionTime) || infos == null || infos.isEmpty() || (cacheFuncInfo = infos.get(originalFuncName)) == null) {
            return originalFuncInfo;
        }
        String cacheVersionTime = cacheFuncInfo.getVersionTime();
        if (TextUtils.isEmpty(cacheVersionTime) || Long.valueOf(cacheVersionTime).longValue() != Long.valueOf(originalVersionTime).longValue()) {
            return originalFuncInfo;
        }
        originalFuncInfo.setTakeEffectTimes(cacheFuncInfo.getTakeEffectTimes());
        return cacheFuncInfo;
    }

    private String getConfigFileName(int type) {
        switch (type) {
            case 1:
                return CLOUD_CONFIG_FILENAME;
            case 2:
                return CLOUD_RETRIEVE_FILENAME;
            case 3:
                return GLOBAL_NOW_CACHE_FILENAME;
            case 4:
                return GLOBAL_IDLE_CACHE_FILENAME;
            default:
                return null;
        }
    }

    private void closeSilently(Closeable c2) {
        if (c2 != null) {
            try {
                c2.close();
            } catch (IOException e2) {
            }
        }
    }

    private static class ConfigHandler {
        private ConfigHandler mNextHandler;
        private IThorConfig mThorConfig;

        public ConfigHandler(IThorConfig thorConfig) {
            this.mThorConfig = thorConfig;
        }

        /* access modifiers changed from: package-private */
        public boolean getEnable() {
            boolean isEnable = false;
            IThorConfig iThorConfig = this.mThorConfig;
            if (iThorConfig != null) {
                isEnable = iThorConfig.getEnable();
            }
            ConfigHandler configHandler = this.mNextHandler;
            if (configHandler != null) {
                return isEnable || configHandler.getEnable();
            }
            return isEnable;
        }

        /* access modifiers changed from: package-private */
        public boolean isExpired(String packageName) {
            HashMap<String, PluginFuncInfo> pluginFuncInfos;
            boolean isExpired = true;
            if (TextUtils.isEmpty(packageName)) {
                return true;
            }
            IThorConfig iThorConfig = this.mThorConfig;
            if (iThorConfig != null && iThorConfig.getEnable() && (pluginFuncInfos = this.mThorConfig.getPluginFuncInfos()) != null && !pluginFuncInfos.isEmpty()) {
                Iterator<PluginFuncInfo> iterator = pluginFuncInfos.values().iterator();
                long now = System.currentTimeMillis() / 1000;
                while (iterator.hasNext()) {
                    PluginFuncInfo next = iterator.next();
                    if (now > Long.valueOf(next.getExpiredTime()).longValue() || !next.getPluginFuncEnable() || next.getTakeEffectTimes() == 0) {
                        iterator.remove();
                    } else if (packageName.equals(next.getPluginPackageName())) {
                        isExpired = false;
                    }
                }
            }
            ConfigHandler configHandler = this.mNextHandler;
            if (configHandler != null) {
                return isExpired && configHandler.isExpired(packageName);
            }
            return isExpired;
        }

        /* access modifiers changed from: package-private */
        public PluginFuncInfo getFuncInfo(String type, String funcName) {
            HashMap<String, PluginFuncInfo> pluginFuncInfos;
            PluginFuncInfo funcInfo;
            IThorConfig iThorConfig = this.mThorConfig;
            if (!(iThorConfig == null || !iThorConfig.getEnable() || (pluginFuncInfos = this.mThorConfig.getPluginFuncInfos()) == null || pluginFuncInfos.isEmpty() || (funcInfo = pluginFuncInfos.get(funcName)) == null)) {
                String takeEffectType = funcInfo.getTakeEffectType();
                if (!TextUtils.isEmpty(takeEffectType) && takeEffectType.equals(type)) {
                    return funcInfo;
                }
            }
            ConfigHandler configHandler = this.mNextHandler;
            if (configHandler != null) {
                return configHandler.getFuncInfo(type, funcName);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void setNextHandler(ConfigHandler nextHandler) {
            this.mNextHandler = nextHandler;
        }
    }
}
