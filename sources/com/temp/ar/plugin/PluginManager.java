package com.temp.ar.plugin;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.temp.ar.plugin.helper.ActivityThreadCompat;
import com.temp.ar.plugin.helper.NativeLibraryHelperCompat;
import com.temp.ar.plugin.helper.Utils;
import com.temp.ar.plugin.reflect.FieldUtils;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class PluginManager {
    private static Map<String, ClassLoader> sPluginClassLoaderCache = new WeakHashMap(1);
    private static Map<String, Object> sPluginLoadedApkCache = new WeakHashMap(1);
    private static PluginManager sPluginManager = null;
    private Context mContext;
    private Map<String, PluginPackageParser> mPluginCache = Collections.synchronizedMap(new HashMap(1));

    PluginManager(Context ctx) {
        this.mContext = ctx;
    }

    public static PluginManager getPluginManagerInstance(Context ctx) {
        if (sPluginManager == null) {
            sPluginManager = new PluginManager(ctx);
        }
        return sPluginManager;
    }

    private int copyNativeLibs(Context context, String apkfile, ApplicationInfo applicationInfo) throws Exception {
        String nativeLibraryDir = PluginDirHelper.getPluginNativeLibraryDir(context, applicationInfo.packageName);
        if (new File(nativeLibraryDir).list().length > 1) {
            return 1;
        }
        return NativeLibraryHelperCompat.copyNativeBinaries(new File(apkfile), new File(nativeLibraryDir));
    }

    private void saveSignatures(PackageInfo pkgInfo) {
        if (pkgInfo != null && pkgInfo.signatures != null) {
            int i2 = 0;
            Signature[] signatureArr = pkgInfo.signatures;
            int length = signatureArr.length;
            int i3 = 0;
            while (i3 < length) {
                Signature signature = signatureArr[i3];
                File file = new File(PluginDirHelper.getPluginSignatureFile(this.mContext, pkgInfo.packageName, i2));
                try {
                    Utils.writeToFile(file, signature.toByteArray());
                    i2++;
                    i3++;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    file.delete();
                    Utils.deleteDir(PluginDirHelper.getPluginSignatureDir(this.mContext, pkgInfo.packageName));
                    return;
                }
            }
        }
    }

    private void hookPackageManager(PluginPackageParser pi) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Object currentActivityThread = ActivityThreadCompat.currentActivityThread();
        Object sPackageManage = FieldUtils.readField(currentActivityThread, "sPackageManager");
        Class<?> iPackageManagerInterface = Class.forName("android.content.pm.IPackageManager");
        FieldUtils.writeField(currentActivityThread, "sPackageManager", Proxy.newProxyInstance(iPackageManagerInterface.getClassLoader(), new Class[]{iPackageManagerInterface}, new PackageManagerHookHandler(sPackageManage, pi)));
    }

    /* Debug info: failed to restart local var, previous not found, register: 19 */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d2  */
    private void preLoadAPK(java.lang.String r20, android.content.pm.ApplicationInfo r21) throws java.lang.NoSuchMethodException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.ClassNotFoundException {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r3 = r21
            java.util.Map<java.lang.String, java.lang.Object> r4 = sPluginLoadedApkCache
            monitor-enter(r4)
            java.lang.Object r0 = com.temp.ar.plugin.helper.ActivityThreadCompat.currentActivityThread()     // Catch:{ all -> 0x00fe }
            r5 = r0
            if (r5 == 0) goto L_0x00fa
            java.lang.String r0 = "mPackages"
            java.lang.Object r0 = com.temp.ar.plugin.reflect.FieldUtils.readField((java.lang.Object) r5, (java.lang.String) r0)     // Catch:{ all -> 0x00fe }
            r6 = r0
            java.lang.Class r0 = com.temp.ar.plugin.helper.ActivityThreadCompat.activityThreadClass()     // Catch:{ all -> 0x00fe }
            java.lang.String r7 = "mPackages"
            java.lang.reflect.Field r0 = com.temp.ar.plugin.reflect.FieldUtils.getField(r0, r7)     // Catch:{ all -> 0x00fe }
            r7 = r0
            java.lang.Object r0 = r7.get(r5)     // Catch:{ all -> 0x00fe }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x00fe }
            r8 = r0
            java.lang.Class r0 = com.temp.ar.plugin.helper.ActivityThreadCompat.activityThreadClass()     // Catch:{ all -> 0x00fe }
            java.lang.String r9 = "mResourcePackages"
            java.lang.reflect.Field r0 = com.temp.ar.plugin.reflect.FieldUtils.getField(r0, r9)     // Catch:{ all -> 0x00fe }
            r9 = r0
            java.lang.Object r0 = r9.get(r5)     // Catch:{ all -> 0x00fe }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x00fe }
            r10 = r0
            java.lang.String r0 = "containsKey"
            r11 = 1
            java.lang.Object[] r12 = new java.lang.Object[r11]     // Catch:{ all -> 0x00fe }
            r13 = 0
            r12[r13] = r2     // Catch:{ all -> 0x00fe }
            java.lang.Object r0 = com.temp.ar.plugin.reflect.MethodUtils.invokeMethod(r6, r0, r12)     // Catch:{ all -> 0x00fe }
            r12 = r0
            boolean r0 = r12 instanceof java.lang.Boolean     // Catch:{ all -> 0x00fe }
            if (r0 == 0) goto L_0x00f7
            r0 = r12
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00fe }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00fe }
            if (r0 != 0) goto L_0x00f7
            java.lang.String r0 = "getPackageInfoNoCheck"
            r14 = 2
            java.lang.Object[] r14 = new java.lang.Object[r14]     // Catch:{ all -> 0x00fe }
            r14[r13] = r3     // Catch:{ all -> 0x00fe }
            java.lang.Object r13 = com.temp.ar.plugin.helper.CompatibilityInfoCompat.getDefaultCompatibilityInfo()     // Catch:{ all -> 0x00fe }
            r14[r11] = r13     // Catch:{ all -> 0x00fe }
            java.lang.Object r0 = com.temp.ar.plugin.reflect.MethodUtils.invokeMethod(r5, r0, r14)     // Catch:{ all -> 0x00fe }
            r11 = r0
            java.util.Map<java.lang.String, java.lang.Object> r0 = sPluginLoadedApkCache     // Catch:{ all -> 0x00fe }
            r0.put(r2, r11)     // Catch:{ all -> 0x00fe }
            android.content.Context r0 = r1.mContext     // Catch:{ all -> 0x00fe }
            java.lang.String r0 = com.temp.ar.plugin.PluginDirHelper.getPluginDalvikCacheDir(r0, r2)     // Catch:{ all -> 0x00fe }
            r13 = r0
            android.content.Context r0 = r1.mContext     // Catch:{ all -> 0x00fe }
            java.lang.String r0 = com.temp.ar.plugin.PluginDirHelper.getPluginNativeLibraryDir(r0, r2)     // Catch:{ all -> 0x00fe }
            r14 = r0
            java.lang.String r0 = r3.publicSourceDir     // Catch:{ all -> 0x00fe }
            boolean r15 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00fe }
            if (r15 == 0) goto L_0x0091
            android.content.Context r15 = r1.mContext     // Catch:{ all -> 0x00fe }
            java.lang.String r15 = com.temp.ar.plugin.PluginDirHelper.getPluginApkFile(r15, r2)     // Catch:{ all -> 0x00fe }
            r3.publicSourceDir = r15     // Catch:{ all -> 0x00fe }
            java.lang.String r15 = r3.publicSourceDir     // Catch:{ all -> 0x00fe }
            r0 = r15
            goto L_0x0092
        L_0x0091:
            r15 = r0
        L_0x0092:
            if (r15 == 0) goto L_0x00f4
            r16 = 0
            dalvik.system.DexClassLoader r0 = new dalvik.system.DexClassLoader     // Catch:{ Exception -> 0x00ac }
            r17 = r5
            android.content.Context r5 = r1.mContext     // Catch:{ Exception -> 0x00aa }
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch:{ Exception -> 0x00aa }
            java.lang.ClassLoader r5 = r5.getParent()     // Catch:{ Exception -> 0x00aa }
            r0.<init>(r15, r13, r14, r5)     // Catch:{ Exception -> 0x00aa }
            r16 = r0
            goto L_0x00b9
        L_0x00aa:
            r0 = move-exception
            goto L_0x00af
        L_0x00ac:
            r0 = move-exception
            r17 = r5
        L_0x00af:
            java.lang.String r5 = "andrew"
            r18 = r0
            java.lang.String r0 = "load classloader exeception!!!!"
            android.util.Log.e(r5, r0)     // Catch:{ all -> 0x00fe }
        L_0x00b9:
            if (r16 != 0) goto L_0x00d2
            com.temp.ar.plugin.PluginDirHelper.cleanOptimizedDirectory(r13)     // Catch:{ all -> 0x00fe }
            dalvik.system.DexClassLoader r0 = new dalvik.system.DexClassLoader     // Catch:{ all -> 0x00fe }
            android.content.Context r5 = r1.mContext     // Catch:{ all -> 0x00fe }
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch:{ all -> 0x00fe }
            java.lang.ClassLoader r5 = r5.getParent()     // Catch:{ all -> 0x00fe }
            r0.<init>(r15, r13, r14, r5)     // Catch:{ all -> 0x00fe }
            r16 = r0
            r5 = r16
            goto L_0x00d4
        L_0x00d2:
            r5 = r16
        L_0x00d4:
            monitor-enter(r11)     // Catch:{ all -> 0x00fe }
            java.lang.String r0 = "mClassLoader"
            com.temp.ar.plugin.reflect.FieldUtils.writeDeclaredField(r11, r0, r5)     // Catch:{ all -> 0x00f1 }
            monitor-exit(r11)     // Catch:{ all -> 0x00f1 }
            java.util.Map<java.lang.String, java.lang.ClassLoader> r0 = sPluginClassLoaderCache     // Catch:{ all -> 0x00fe }
            r0.put(r2, r5)     // Catch:{ all -> 0x00fe }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x00fe }
            r0.<init>(r11)     // Catch:{ all -> 0x00fe }
            java.lang.String r1 = r3.packageName     // Catch:{ all -> 0x00fe }
            r8.put(r1, r0)     // Catch:{ all -> 0x00fe }
            java.lang.String r1 = r3.packageName     // Catch:{ all -> 0x00fe }
            r10.put(r1, r0)     // Catch:{ all -> 0x00fe }
            goto L_0x00fc
        L_0x00f1:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x00f1 }
            throw r0     // Catch:{ all -> 0x00fe }
        L_0x00f4:
            r17 = r5
            goto L_0x00fc
        L_0x00f7:
            r17 = r5
            goto L_0x00fc
        L_0x00fa:
            r17 = r5
        L_0x00fc:
            monitor-exit(r4)     // Catch:{ all -> 0x00fe }
            return
        L_0x00fe:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00fe }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.temp.ar.plugin.PluginManager.preLoadAPK(java.lang.String, android.content.pm.ApplicationInfo):void");
    }

    public int installPackage(String filepath, boolean fromAssert) {
        String apkfile;
        if (!fromAssert) {
            try {
                PackageInfo info = this.mContext.getPackageManager().getPackageArchiveInfo(filepath, 0);
                if (info == null) {
                    return -2;
                }
                if (this.mPluginCache.containsKey(info.packageName)) {
                    return -1;
                }
                apkfile = PluginDirHelper.getPluginApkFile(this.mContext, info.packageName);
            } catch (Exception e2) {
                if (0 != 0) {
                    new File((String) null).delete();
                }
                e2.printStackTrace();
                return -110;
            }
        } else if (this.mPluginCache.containsKey("com.google.ar.core")) {
            return -1;
        } else {
            apkfile = PluginDirHelper.getPluginApkFile(this.mContext, "com.google.ar.core");
        }
        if (!new File(apkfile).exists()) {
            Utils.copyFile(filepath, apkfile, fromAssert, this.mContext);
        }
        PluginPackageParser parser = new PluginPackageParser(this.mContext, new File(apkfile));
        ApplicationInfo appInfo = parser.getApplicationInfo(0);
        if (copyNativeLibs(this.mContext, apkfile, appInfo) < 0) {
            new File(apkfile).delete();
            return -3;
        }
        preLoadAPK(parser.getPackageName(), appInfo);
        hookPackageManager(parser);
        this.mPluginCache.put(parser.getPackageName(), parser);
        return 1;
    }
}
