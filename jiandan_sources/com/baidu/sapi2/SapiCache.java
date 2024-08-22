package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.FileUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.wallet.base.iddetect.utils.StorageUtils;
import fe.fe.ppp.ad.ad;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class SapiCache {
    public static final String TAG = "SapiCache";
    public static final Map<String, SoftReference<String>> cache = new ConcurrentHashMap();
    public Context context;
    public final List<String> newModuleIds = new ArrayList();
    public final List<String> oldModuleIds = new ArrayList();

    public interface LoadModuleEventListener {
        void onFailure(SapiOptions.Cache.Module module);

        void onSuccess(SapiOptions.Cache.Module module, String str);
    }

    /* access modifiers changed from: private */
    public void initSomeSwitch(SapiOptions sapiOptions) {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        new FaceLoginService().syncFaceLoginUID(this.context, (String) null);
        if (sapiConfiguration.syncOneKeyLoginInfo) {
            new OneKeyLoginSdkCall().preGetPhoneInfo(sapiConfiguration, "init");
        }
    }

    /* access modifiers changed from: private */
    public void reportDi() {
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.SAPI_CONFIG_URI);
        if (!TextUtils.isEmpty(deviceInfo)) {
            StatService.onEvent("dvif_interface", Collections.singletonMap("di", deviceInfo));
        }
    }

    public String get(final Context context2, String str) {
        invalidate();
        if (!SapiContext.getInstance().getSapiOptions().getCache().isEnabled()) {
            return null;
        }
        String loadModuleFromMemory = loadModuleFromMemory(str);
        if (!TextUtils.isEmpty(loadModuleFromMemory)) {
            return loadModuleFromMemory;
        }
        SapiOptions.Cache.Module moduleById = getModuleById(str);
        if (moduleById != null) {
            loadModuleFromExternal(moduleById, new LoadModuleEventListener() {
                public void onFailure(SapiOptions.Cache.Module module) {
                    SapiCache.this.loadModuleFromInternal(context2, module);
                }

                public void onSuccess(SapiOptions.Cache.Module module, String str) {
                    SapiCache.this.put(module.id, str);
                }
            });
        }
        return loadModuleFromMemory(str);
    }

    public String getCacheData(Context context2, String str) {
        return get(context2, getCacheModuleId(str));
    }

    public String getCacheModuleId(String str) {
        String str2;
        Uri parse = Uri.parse(str);
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getHost());
        if (parse.getPort() == -1) {
            str2 = "";
        } else {
            str2 = ":" + parse.getPort();
        }
        sb.append(str2);
        sb.append(parse.getPath());
        String sb2 = sb.toString();
        if (sb2.endsWith(".html")) {
            return sb2;
        }
        return sb2 + ".html";
    }

    public SapiOptions.Cache.Module getModuleById(String str) {
        for (SapiOptions.Cache.Module next : SapiContext.getInstance().getSapiOptions().getCache().getModules()) {
            if (next.id.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public void handleCachePage(String str, SapiOptions.Cache.Module module) {
        if (!TextUtils.isEmpty(module.id) && !TextUtils.isEmpty(str) && module.hash.equals(ad.rg(str.getBytes(), false))) {
            put(module.id, str);
            writeInternal(this.context, SapiOptions.Cache.Module.getInternalFile(module.id), str.getBytes());
            if (SapiUtils.checkRequestPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION, this.context)) {
                writeExternal(SapiOptions.Cache.Module.getExternalFile(module.id), str.getBytes());
            }
        }
    }

    public void handleOptions(String str, SapiOptions sapiOptions) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            final SapiOptions fromJSON = SapiOptions.fromJSON(jSONObject);
            SapiContext.getInstance().setSapiOptions(fromJSON);
            Log.d(TAG, "handleOptions response" + str);
            SapiContext.getInstance().setPkgSigns(SapiOptions.PkgSigns.fromJSON(jSONObject));
            SapiOptions.Cache cache2 = fromJSON.getCache();
            final SapiOptions.Cache cache3 = sapiOptions.getCache();
            initSomeSwitch(fromJSON);
            this.newModuleIds.clear();
            if (cache2.isEnabled()) {
                for (SapiOptions.Cache.Module module : cache2.getModules()) {
                    this.newModuleIds.add(module.id);
                }
                for (final SapiOptions.Cache.Module next : cache2.getModules()) {
                    SapiOptions.Cache.Module module2 = null;
                    for (SapiOptions.Cache.Module next2 : cache3.getModules()) {
                        if (next2.id.equals(next.id)) {
                            module2 = next2;
                        }
                    }
                    if (needUpdate(next, module2)) {
                        loadModuleFromExternal(next, new LoadModuleEventListener() {
                            public void onFailure(SapiOptions.Cache.Module module) {
                                new HttpClientWrap().get(next.downloadUrl, ReqPriority.IMMEDIATE, new HttpHashMapWrap(), (List<HttpCookie>) null, (String) null, new HttpHandlerWrap(true) {
                                    public void onFailure(Throwable th2, int i2, String str) {
                                        AnonymousClass4 r1 = AnonymousClass4.this;
                                        fromJSON.setCache(cache3);
                                        SapiContext.getInstance().setSapiOptions(fromJSON);
                                    }

                                    public void onSuccess(int i2, String str) {
                                        AnonymousClass4 r2 = AnonymousClass4.this;
                                        SapiCache.this.handleCachePage(str, next);
                                    }
                                });
                            }

                            public void onSuccess(SapiOptions.Cache.Module module, String str) {
                                if (!TextUtils.isEmpty(next.id) && !TextUtils.isEmpty(str)) {
                                    SapiCache.this.put(next.id, str);
                                    SapiCache sapiCache = SapiCache.this;
                                    sapiCache.writeInternal(sapiCache.context, SapiOptions.Cache.Module.getInternalFile(next.id), str.getBytes());
                                }
                            }
                        });
                    } else {
                        loadModuleFromExternal(next, new LoadModuleEventListener() {
                            public void onFailure(SapiOptions.Cache.Module module) {
                                String internalFile = SapiOptions.Cache.Module.getInternalFile(module.id);
                                String externalFile = SapiOptions.Cache.Module.getExternalFile(module.id);
                                if (new File(SapiCache.this.context.getFilesDir(), internalFile).exists()) {
                                    try {
                                        String loadDataFromInternal = SapiCache.this.loadDataFromInternal(SapiCache.this.context, internalFile);
                                        if (Build.VERSION.SDK_INT >= 30 || SapiUtils.checkRequestPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION, SapiCache.this.context)) {
                                            SapiCache.this.writeExternal(externalFile, loadDataFromInternal.getBytes());
                                        }
                                    } catch (Throwable th2) {
                                        Log.e(th2);
                                    }
                                }
                            }

                            public void onSuccess(SapiOptions.Cache.Module module, String str) {
                            }
                        });
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }

    public void init(Context context2) {
        this.context = context2.getApplicationContext();
        SapiOptions sapiOptions = SapiContext.getInstance().getSapiOptions();
        loadCache(sapiOptions);
        syncCache(sapiOptions);
    }

    public void invalidate() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String next : this.oldModuleIds) {
            if (!this.newModuleIds.contains(next)) {
                arrayList.add(next);
                remove(next);
            }
        }
        for (String str : arrayList) {
            if (this.oldModuleIds.contains(str)) {
                this.oldModuleIds.remove(str);
            }
        }
    }

    public void loadCache(SapiOptions sapiOptions) {
        SapiOptions.Cache cache2 = sapiOptions.getCache();
        if (cache2.isEnabled()) {
            for (SapiOptions.Cache.Module module : cache2.getModules()) {
                this.oldModuleIds.add(module.id);
            }
            this.newModuleIds.addAll(this.oldModuleIds);
            for (SapiOptions.Cache.Module loadModuleFromExternal : cache2.getModules()) {
                loadModuleFromExternal(loadModuleFromExternal, new LoadModuleEventListener() {
                    public void onFailure(SapiOptions.Cache.Module module) {
                        SapiCache sapiCache = SapiCache.this;
                        sapiCache.loadModuleFromInternal(sapiCache.context, module);
                    }

                    public void onSuccess(SapiOptions.Cache.Module module, String str) {
                        SapiCache.this.put(module.id, str);
                    }
                });
            }
        }
    }

    public String loadDataFromExternal(File file) throws IOException {
        return FileUtil.read(file.getAbsolutePath());
    }

    @TargetApi(4)
    public String loadDataFromInternal(Context context2, String str) throws IOException {
        return FileUtil.read(context2.getApplicationInfo().dataDir + File.separator + "files" + File.separator + str);
    }

    public void loadModuleFromExternal(SapiOptions.Cache.Module module, LoadModuleEventListener loadModuleEventListener) {
        File file;
        if (loadModuleEventListener != null) {
            String externalFile = SapiOptions.Cache.Module.getExternalFile(module.id);
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    if (Build.VERSION.SDK_INT >= 30) {
                        file = new File(this.context.getExternalCacheDir(), externalFile);
                    } else {
                        file = new File(Environment.getExternalStorageDirectory(), externalFile);
                    }
                    if (file.exists()) {
                        String loadDataFromExternal = loadDataFromExternal(file);
                        if (ad.rg(loadDataFromExternal.getBytes(), false).equals(module.hash)) {
                            loadModuleEventListener.onSuccess(module, loadDataFromExternal);
                        } else {
                            loadModuleEventListener.onFailure(module);
                        }
                    } else {
                        loadModuleEventListener.onFailure(module);
                    }
                }
            } catch (Throwable unused) {
                loadModuleEventListener.onFailure(module);
            }
        } else {
            throw new IllegalArgumentException(LoadModuleEventListener.class.getName() + "can't be null");
        }
    }

    public void loadModuleFromInternal(Context context2, SapiOptions.Cache.Module module) {
        String internalFile = SapiOptions.Cache.Module.getInternalFile(module.id);
        if (new File(context2.getFilesDir(), internalFile).exists()) {
            try {
                put(module.id, loadDataFromInternal(context2, internalFile));
            } catch (Throwable th2) {
                Log.e(th2);
            }
        }
    }

    public String loadModuleFromMemory(String str) {
        if (!cache.containsKey(str) || cache.get(str) == null) {
            return null;
        }
        String str2 = (String) cache.get(str).get();
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        return null;
    }

    public boolean needUpdate(SapiOptions.Cache.Module module, SapiOptions.Cache.Module module2) {
        return !TextUtils.isEmpty(module.hash) && (module2 == null || !module.hash.equals(module2.hash));
    }

    public void put(String str, String str2) {
        cache.put(str, new SoftReference(str2));
    }

    public void remove(String str) {
        cache.remove(str);
    }

    public void syncCache(final SapiOptions sapiOptions) {
        HashMap hashMap = new HashMap();
        hashMap.put("If-None-Match", SapiContext.getInstance().getString(SapiContext.KEY_CONFIG_FILE_ETAG));
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        try {
            new HttpClientWrap().post(SapiAccountManager.getInstance().getSapiConfiguration().environment.getWap() + SapiEnv.SAPI_CONFIG_HTTPS_URI, ReqPriority.IMMEDIATE, httpHashMapWrap, hashMap, (List<HttpCookie>) null, (String) null, new HttpHandlerWrap(true) {
                public void onFailure(Throwable th2, int i2, String str) {
                    SapiCache.this.initSomeSwitch(sapiOptions);
                    SapiCache.this.reportDi();
                }

                public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
                    if (str != null) {
                        int i3 = -1;
                        String str2 = null;
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            i3 = jSONObject.optInt("errno");
                            str2 = jSONObject.optString("data");
                        } catch (JSONException e) {
                            Log.e(e);
                        }
                        if (i3 == 0 && !TextUtils.isEmpty(str2)) {
                            SapiCache.this.handleOptions(str2, sapiOptions);
                            if (hashMap != null) {
                                SapiContext.getInstance().put(SapiContext.KEY_CONFIG_FILE_ETAG, hashMap.get("ETag"));
                            }
                            SapiCache.this.reportDi();
                        }
                    }
                }
            });
        } catch (Throwable th2) {
            Log.e(th2);
        }
    }

    public void writeExternal(String str, byte[] bArr) {
        File file;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                if (Build.VERSION.SDK_INT >= 30) {
                    file = new File(this.context.getExternalCacheDir(), str);
                } else {
                    file = new File(Environment.getExternalStorageDirectory(), str);
                }
                FileUtil.write(file, bArr, false);
            }
        } catch (Throwable th2) {
            Log.e(th2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeInternal(android.content.Context r2, java.lang.String r3, byte[] r4) {
        /*
            r1 = this;
            r0 = 0
            java.io.FileOutputStream r2 = r2.openFileOutput(r3, r0)     // Catch:{ all -> 0x0010 }
            r2.write(r4)     // Catch:{ all -> 0x000e }
            if (r2 == 0) goto L_0x0014
        L_0x000a:
            r2.close()     // Catch:{ all -> 0x0014 }
            goto L_0x0014
        L_0x000e:
            goto L_0x0011
        L_0x0010:
            r2 = 0
        L_0x0011:
            if (r2 == 0) goto L_0x0014
            goto L_0x000a
        L_0x0014:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiCache.writeInternal(android.content.Context, java.lang.String, byte[]):void");
    }
}
