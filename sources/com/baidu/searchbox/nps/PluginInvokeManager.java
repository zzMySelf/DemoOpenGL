package com.baidu.searchbox.nps;

import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.environment.dinovel.pluginentrance.IPluginLoadCallback;
import com.baidu.searchbox.novel.stat.ubc.NovelCustomUbc;
import com.baidu.searchbox.noveladapter.novelcore.INovelPluginInit;
import com.baidu.searchbox.noveladapter.pyramid.NovelServiceManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.security.auth.callback.Callback;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginInvokeManager {
    public static final String PLUGIN_IMPL_CLASS = "com.baidu.searchbox.newreader.novel.router.externalimpl.NovelPluginInitImpl";
    public static final String PLUGIN_PKG_NAME = "com.baidu.searchbox.newreader";
    private static final int TOAST_DRUNCTION = 6;
    public Callback callback;
    /* access modifiers changed from: private */
    public final List<IInvokeCallback> invokeCallbacks;
    /* access modifiers changed from: private */
    public boolean isCanShowErrorToast;
    /* access modifiers changed from: private */
    public volatile boolean mLoadingNPSPlugin;
    public INovelPluginInit mNovelNpsPlugin;
    private long mStartLoadingTime;
    private long prepareStartTime;
    private volatile boolean reportedPrepare;

    private PluginInvokeManager() {
        this.isCanShowErrorToast = true;
        this.mStartLoadingTime = -1;
        this.invokeCallbacks = new CopyOnWriteArrayList();
        this.prepareStartTime = 0;
    }

    private static class PluginInvokeManagerHolder {
        /* access modifiers changed from: private */
        public static final PluginInvokeManager INSTANCE = new PluginInvokeManager();

        private PluginInvokeManagerHolder() {
        }
    }

    public static PluginInvokeManager getInstance() {
        return PluginInvokeManagerHolder.INSTANCE;
    }

    public void prepareNovelPlugin() {
        this.prepareStartTime = System.currentTimeMillis();
        invokeNovel(false, (IPluginLoadCallback) null);
    }

    public void invokeNovel(boolean showLoading, final IPluginLoadCallback callback2) {
        if (this.mNovelNpsPlugin == null) {
            loadNPSPluginImpl(showLoading, new IInvokeCallback() {
                public void onResult(int retCode, String retMsg, Object retObject) {
                    if (retCode == 14) {
                        try {
                            PluginInvokeManager.this.mNovelNpsPlugin = (INovelPluginInit) ((Class) retObject).newInstance();
                            PluginInvokeManager.this.mNovelNpsPlugin.init();
                            IPluginLoadCallback iPluginLoadCallback = callback2;
                            if (iPluginLoadCallback != null) {
                                iPluginLoadCallback.loadSuccess();
                            }
                        } catch (Throwable e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        IPluginLoadCallback iPluginLoadCallback2 = callback2;
                        if (iPluginLoadCallback2 != null) {
                            iPluginLoadCallback2.loadError();
                        }
                    }
                }
            });
        } else if (callback2 != null) {
            callback2.loadSuccess();
        }
    }

    public void invokeNovel(boolean isFirst, boolean showLoading, final IPluginLoadCallback callback2) {
        if (this.mNovelNpsPlugin == null) {
            loadNPSPluginImpl(isFirst, showLoading, new IInvokeCallback() {
                public void onResult(int retCode, String retMsg, Object retObject) {
                    if (retCode == 14) {
                        try {
                            PluginInvokeManager.this.mNovelNpsPlugin = (INovelPluginInit) ((Class) retObject).newInstance();
                            PluginInvokeManager.this.mNovelNpsPlugin.init();
                            IPluginLoadCallback iPluginLoadCallback = callback2;
                            if (iPluginLoadCallback != null) {
                                iPluginLoadCallback.loadSuccess();
                            }
                        } catch (Throwable e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        IPluginLoadCallback iPluginLoadCallback2 = callback2;
                        if (iPluginLoadCallback2 != null) {
                            iPluginLoadCallback2.loadError();
                        }
                    }
                }
            });
        } else if (callback2 != null) {
            callback2.loadSuccess();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        r0 = com.baidu.searchbox.noveladapter.abtest.NovelAbTest.isMonitorOpen(com.baidu.searchbox.noveladapter.abtest.NovelAbTest.KEY_NOVEL_NEW_READER_LOAD_NOVEL_PLUGIN_SWITCH);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r11 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r21 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        if (r10.mStartLoadingTime == -1) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        if ((java.lang.System.currentTimeMillis() - r10.mStartLoadingTime) <= 6000) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        r10.mStartLoadingTime = java.lang.System.currentTimeMillis();
        com.baidu.bdtask.framework.utils.UiThreadUtil.runOnUiThread(new com.baidu.searchbox.nps.PluginInvokeManager.AnonymousClass3(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadNPSPluginImpl(boolean r20, boolean r21, com.baidu.nps.main.invoke.IInvokeCallback r22) {
        /*
            r19 = this;
            r10 = r19
            boolean r11 = r19.isAvailable()
            boolean r0 = r10.mLoadingNPSPlugin
            if (r0 == 0) goto L_0x004d
            java.util.List<com.baidu.nps.main.invoke.IInvokeCallback> r1 = r10.invokeCallbacks
            monitor-enter(r1)
            java.util.List<com.baidu.nps.main.invoke.IInvokeCallback> r0 = r10.invokeCallbacks     // Catch:{ all -> 0x0048 }
            r12 = r22
            r0.add(r12)     // Catch:{ all -> 0x0046 }
            monitor-exit(r1)     // Catch:{ all -> 0x0046 }
            java.lang.String r0 = "newreader_load_novel_plugin_loading_switch"
            boolean r0 = com.baidu.searchbox.noveladapter.abtest.NovelAbTest.isMonitorOpen(r0)
            if (r11 != 0) goto L_0x0045
            if (r0 == 0) goto L_0x0045
            if (r21 == 0) goto L_0x0045
            long r1 = r10.mStartLoadingTime
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0037
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r10.mStartLoadingTime
            long r1 = r1 - r3
            r3 = 6000(0x1770, double:2.9644E-320)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0045
        L_0x0037:
            long r1 = java.lang.System.currentTimeMillis()
            r10.mStartLoadingTime = r1
            com.baidu.searchbox.nps.PluginInvokeManager$3 r1 = new com.baidu.searchbox.nps.PluginInvokeManager$3
            r1.<init>()
            com.baidu.bdtask.framework.utils.UiThreadUtil.runOnUiThread(r1)
        L_0x0045:
            return
        L_0x0046:
            r0 = move-exception
            goto L_0x004b
        L_0x0048:
            r0 = move-exception
            r12 = r22
        L_0x004b:
            monitor-exit(r1)     // Catch:{ all -> 0x0046 }
            throw r0
        L_0x004d:
            r12 = r22
            r0 = 1
            r10.mLoadingNPSPlugin = r0
            long r13 = java.lang.System.currentTimeMillis()
            if (r11 == 0) goto L_0x0083
            com.baidu.nps.main.manager.NPSManager r0 = com.baidu.nps.main.manager.NPSManager.getInstance()
            java.lang.String r15 = "com.baidu.searchbox.newreader"
            java.lang.String r9 = "com.baidu.searchbox.newreader.novel.router.externalimpl.NovelPluginInitImpl"
            java.lang.Class<com.baidu.searchbox.noveladapter.novelcore.INovelPluginInit> r8 = com.baidu.searchbox.noveladapter.novelcore.INovelPluginInit.class
            com.baidu.searchbox.nps.PluginInvokeManager$NovelInvokeCallback r7 = new com.baidu.searchbox.nps.PluginInvokeManager$NovelInvokeCallback
            r4 = 1
            java.lang.String r16 = "0"
            r1 = r7
            r2 = r19
            r3 = r20
            r5 = r13
            r17 = r7
            r7 = r16
            r18 = r8
            r8 = r21
            r10 = r9
            r9 = r22
            r1.<init>(r3, r4, r5, r7, r8, r9)
            r2 = r17
            r1 = r18
            r0.loadClazz(r15, r10, r1, r2)
            goto L_0x008f
        L_0x0083:
            r1 = r19
            r2 = r20
            r3 = r13
            r5 = r21
            r6 = r22
            r1.installNovelPlugin(r2, r3, r5, r6)
        L_0x008f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.nps.PluginInvokeManager.loadNPSPluginImpl(boolean, boolean, com.baidu.nps.main.invoke.IInvokeCallback):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        r0 = com.baidu.searchbox.noveladapter.abtest.NovelAbTest.isMonitorOpen(com.baidu.searchbox.noveladapter.abtest.NovelAbTest.KEY_NOVEL_NEW_READER_LOAD_NOVEL_PLUGIN_SWITCH);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r11 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r20 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        if (r10.mStartLoadingTime == -1) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        if ((java.lang.System.currentTimeMillis() - r10.mStartLoadingTime) <= 6000) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        r10.mStartLoadingTime = java.lang.System.currentTimeMillis();
        com.baidu.bdtask.framework.utils.UiThreadUtil.runOnUiThread(new com.baidu.searchbox.nps.PluginInvokeManager.AnonymousClass4(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadNPSPluginImpl(boolean r20, com.baidu.nps.main.invoke.IInvokeCallback r21) {
        /*
            r19 = this;
            r10 = r19
            boolean r11 = r19.isAvailable()
            boolean r0 = r10.mLoadingNPSPlugin
            if (r0 == 0) goto L_0x004d
            java.util.List<com.baidu.nps.main.invoke.IInvokeCallback> r1 = r10.invokeCallbacks
            monitor-enter(r1)
            java.util.List<com.baidu.nps.main.invoke.IInvokeCallback> r0 = r10.invokeCallbacks     // Catch:{ all -> 0x0048 }
            r12 = r21
            r0.add(r12)     // Catch:{ all -> 0x0046 }
            monitor-exit(r1)     // Catch:{ all -> 0x0046 }
            java.lang.String r0 = "newreader_load_novel_plugin_loading_switch"
            boolean r0 = com.baidu.searchbox.noveladapter.abtest.NovelAbTest.isMonitorOpen(r0)
            if (r11 != 0) goto L_0x0045
            if (r0 == 0) goto L_0x0045
            if (r20 == 0) goto L_0x0045
            long r1 = r10.mStartLoadingTime
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0037
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r10.mStartLoadingTime
            long r1 = r1 - r3
            r3 = 6000(0x1770, double:2.9644E-320)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0045
        L_0x0037:
            long r1 = java.lang.System.currentTimeMillis()
            r10.mStartLoadingTime = r1
            com.baidu.searchbox.nps.PluginInvokeManager$4 r1 = new com.baidu.searchbox.nps.PluginInvokeManager$4
            r1.<init>()
            com.baidu.bdtask.framework.utils.UiThreadUtil.runOnUiThread(r1)
        L_0x0045:
            return
        L_0x0046:
            r0 = move-exception
            goto L_0x004b
        L_0x0048:
            r0 = move-exception
            r12 = r21
        L_0x004b:
            monitor-exit(r1)     // Catch:{ all -> 0x0046 }
            throw r0
        L_0x004d:
            r12 = r21
            r0 = 1
            r10.mLoadingNPSPlugin = r0
            long r13 = java.lang.System.currentTimeMillis()
            if (r11 == 0) goto L_0x0082
            com.baidu.nps.main.manager.NPSManager r0 = com.baidu.nps.main.manager.NPSManager.getInstance()
            java.lang.String r15 = "com.baidu.searchbox.newreader"
            java.lang.String r9 = "com.baidu.searchbox.newreader.novel.router.externalimpl.NovelPluginInitImpl"
            java.lang.Class<com.baidu.searchbox.noveladapter.novelcore.INovelPluginInit> r8 = com.baidu.searchbox.noveladapter.novelcore.INovelPluginInit.class
            com.baidu.searchbox.nps.PluginInvokeManager$NovelInvokeCallback r7 = new com.baidu.searchbox.nps.PluginInvokeManager$NovelInvokeCallback
            r3 = 0
            r4 = 1
            java.lang.String r16 = "0"
            r1 = r7
            r2 = r19
            r5 = r13
            r17 = r7
            r7 = r16
            r18 = r8
            r8 = r20
            r10 = r9
            r9 = r21
            r1.<init>(r3, r4, r5, r7, r8, r9)
            r2 = r17
            r1 = r18
            r0.loadClazz(r15, r10, r1, r2)
            goto L_0x008d
        L_0x0082:
            r2 = 0
            r1 = r19
            r3 = r13
            r5 = r20
            r6 = r21
            r1.installNovelPlugin(r2, r3, r5, r6)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.nps.PluginInvokeManager.loadNPSPluginImpl(boolean, com.baidu.nps.main.invoke.IInvokeCallback):void");
    }

    /* access modifiers changed from: private */
    public void installNovelPlugin(boolean isFirst, long startTime, boolean showLoading, IInvokeCallback callback2) {
        if (showLoading) {
            UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) "正在加载...").setDuration(6).showHighLoadingToast();
        }
        final boolean z = showLoading;
        final boolean z2 = isFirst;
        final long j2 = startTime;
        final IInvokeCallback iInvokeCallback = callback2;
        NPSPackageManager.getInstance().installBundle("com.baidu.searchbox.newreader", new IInstallCallback() {
            public void onResult(int retCode, String retMsg) {
                if (z) {
                    UniversalToast.cancelToast();
                }
                if (retCode == 13) {
                    boolean unused = PluginInvokeManager.this.isCanShowErrorToast = false;
                    NPSManager.getInstance().loadClazz("com.baidu.searchbox.newreader", PluginInvokeManager.PLUGIN_IMPL_CLASS, INovelPluginInit.class, new NovelInvokeCallback(z2, false, j2, "1", z, iInvokeCallback));
                } else if (retCode != 34) {
                    boolean unused2 = PluginInvokeManager.this.mLoadingNPSPlugin = false;
                    if (z && PluginInvokeManager.this.isCanShowErrorToast) {
                        UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) "加载失败，请稍候重试").showToast();
                    }
                    PluginInvokeManager.this.reportPluginLoadDuration(j2, "2");
                } else if (z && PluginInvokeManager.this.isCanShowErrorToast) {
                    UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) "正在安装中").showToast();
                }
            }

            public void onProgress(long l, long l1) {
            }
        });
    }

    public boolean isAvailable() {
        return NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.newreader") == 43;
    }

    public boolean isNeedUpdate() {
        return NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.newreader") == 44;
    }

    public boolean isPluginInit() {
        if (!this.reportedPrepare) {
            this.reportedPrepare = true;
            reportRepareNovelPlugin();
        }
        if (this.mNovelNpsPlugin != null) {
            return true;
        }
        return false;
    }

    private void reportRepareNovelPlugin() {
        BundleInfoGroup bundleGroup;
        BundleInfo bundleInfo;
        try {
            JSONObject extJsonObject = new JSONObject();
            if (this.prepareStartTime == 0) {
                extJsonObject.put("prepareState", "1");
            } else if (this.mNovelNpsPlugin == null) {
                extJsonObject.put("prepareState", "2");
            } else {
                extJsonObject.put("prepareState", "0");
            }
            int version = NPSPackageManager.getInstance().getBundleVersion("com.baidu.searchbox.newreader");
            if (!(version != -1 || (bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.newreader")) == null || (bundleInfo = bundleGroup.getBundleByType(1)) == null)) {
                version = bundleInfo.getVersionCode();
            }
            extJsonObject.put("version", version);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("source", "novelpluginprepareload");
            jsonObject.put("ext", extJsonObject);
            NovelServiceManager.getNovelUBCManager().onEvent(NovelCustomUbc.EventId.UBC_EVENT_ID_580, jsonObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void reportPluginLoadDuration(long startTime, String status) {
        BundleInfoGroup bundleGroup;
        BundleInfo bundleInfo;
        long endTime = System.currentTimeMillis();
        int version = NPSPackageManager.getInstance().getBundleVersion("com.baidu.searchbox.newreader");
        if (!(version != -1 || (bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.newreader")) == null || (bundleInfo = bundleGroup.getBundleByType(1)) == null)) {
            version = bundleInfo.getVersionCode();
        }
        try {
            JSONObject extJsonObject = new JSONObject();
            extJsonObject.put("isNewReader", "1");
            extJsonObject.put("startTime", startTime);
            extJsonObject.put("endTime", endTime);
            extJsonObject.put("status", status);
            extJsonObject.put("version", version);
            long j2 = this.prepareStartTime;
            if (j2 != 0) {
                extJsonObject.put("prepareStartTime", j2);
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("source", "novelpluginload");
            jsonObject.put("ext", extJsonObject.toString());
            NovelServiceManager.getNovelUBCManager().onEvent(NovelCustomUbc.EventId.UBC_EVENT_ID_580, jsonObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    class NovelInvokeCallback implements IInvokeCallback {
        boolean available;
        IInvokeCallback callback;
        boolean isFirst;
        boolean showLoading;
        long startTime;
        String status;

        public NovelInvokeCallback(PluginInvokeManager this$02, long startTime2, String status2, boolean showLoading2, IInvokeCallback callback2) {
            this(false, false, startTime2, status2, showLoading2, callback2);
        }

        public NovelInvokeCallback(boolean isFirst2, boolean available2, long startTime2, String status2, boolean showLoading2, IInvokeCallback callback2) {
            this.isFirst = isFirst2;
            this.available = available2;
            this.startTime = startTime2;
            this.status = status2;
            this.showLoading = showLoading2;
            this.callback = callback2;
        }

        public void onResult(int retCode, String retMsg, Object retObject) {
            boolean unused = PluginInvokeManager.this.mLoadingNPSPlugin = false;
            if (!this.available || retCode == 14) {
                IInvokeCallback iInvokeCallback = this.callback;
                if (iInvokeCallback != null) {
                    iInvokeCallback.onResult(retCode, retMsg, retObject);
                }
                synchronized (PluginInvokeManager.this.invokeCallbacks) {
                    for (int i2 = PluginInvokeManager.this.invokeCallbacks.size() - 1; i2 >= 0; i2--) {
                        IInvokeCallback iInvokeCallback2 = (IInvokeCallback) PluginInvokeManager.this.invokeCallbacks.get(i2);
                        if (iInvokeCallback2 != null) {
                            iInvokeCallback2.onResult(retCode, retMsg, retObject);
                        }
                    }
                    PluginInvokeManager.this.invokeCallbacks.clear();
                }
                PluginInvokeManager.this.reportPluginLoadDuration(this.startTime, this.status);
                return;
            }
            PluginInvokeManager.this.installNovelPlugin(this.isFirst, this.startTime, this.showLoading, this.callback);
        }
    }
}
