package com.baidu.webkit.engine;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.webkit.engine.ZeusEngineInfo;
import com.baidu.webkit.internal.cloudsetting.CloudSettingFetcher;
import com.baidu.webkit.internal.cloudsetting.CloudSettingSDK;
import com.baidu.webkit.internal.cloudsetting.a;
import com.baidu.webkit.internal.utils.ProcessUtils;
import com.baidu.webkit.internal.utils.b;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.abtest.ABTestSDK;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

public class ZeusEngineRetrieval {

    /* renamed from: a  reason: collision with root package name */
    private static ZeusEngineList f3872a;

    private ZeusEngineRetrieval() {
    }

    public static ZeusEngineList retrieve(Context context) {
        String str;
        synchronized (ZeusEngineList.class) {
            if (f3872a != null) {
                Log.i("ZeusEngineRetrieval", "[sdk-zeus][" + ProcessUtils.getProcessName(context) + "] engines just be retrieved once, return the cache");
                ZeusEngineList zeusEngineList = f3872a;
                return zeusEngineList;
            }
            try {
                f3872a = new ZeusEngineList(new Version("11.56.2.2").business);
                try {
                    if (!TextUtils.isEmpty("11.56.2.2")) {
                        ZeusEngineInfo zeusEngineInfo = new ZeusEngineInfo();
                        zeusEngineInfo.zeusVersion = new Version("11.56.2.2");
                        zeusEngineInfo.minSdkVersion = new Version("11.56.2.2");
                        zeusEngineInfo.type = ZeusEngineInfo.ZeusEngineType.BUILD_IN;
                        f3872a.push(zeusEngineInfo);
                    }
                } catch (InvalidZeusVersionException e2) {
                    Log.w("ZeusEngineRetrieval", "[sdk-zeus] build in version is invalid: {sdk_version: 11.56.2.2, zeus_version: 11.56.2.2} => " + e2.getMessage());
                }
                if (!CloudSettingSDK.isReady()) {
                    if (!ABTestSDK.isCloudSettingFromGcpEnabled()) {
                        str = CloudSettingFetcher.instance().local(context);
                    } else {
                        a.a();
                        str = a.a(context);
                    }
                    CloudSettingSDK.init(str);
                    Log.i("ZeusEngineRetrieval", "[sdk-zeus] init local cloud settings when retrieving engines");
                }
                boolean isShouldResetDownloadZeusEnabled = CloudSettingSDK.isShouldResetDownloadZeusEnabled();
                Log.i("ZeusEngineRetrieval", "[sdk-zeus] reset zeus: cloud setting => ".concat(String.valueOf(isShouldResetDownloadZeusEnabled)));
                if (!isShouldResetDownloadZeusEnabled) {
                    a(context, context.getFilesDir().getAbsolutePath() + File.separator + "zeus" + File.separator + "engines" + File.separator, f3872a);
                }
                Log.i("ZeusEngineRetrieval", "[sdk-zeus][" + ProcessUtils.getProcessName(context) + "] engines has been retrieved");
                f3872a.print();
                ZeusEngineList zeusEngineList2 = f3872a;
                return zeusEngineList2;
            } catch (InvalidZeusVersionException e3) {
                Log.w("ZeusEngineRetrieval", "Global ZEUS_VERSION is invalid: " + e3.getMessage());
                return null;
            }
        }
    }

    public static ZeusEngineInfo getSuitableEngine(Context context) {
        ZeusEngineList retrieve = retrieve(context);
        if (retrieve == null) {
            return null;
        }
        return retrieve.peek();
    }

    public static ZeusEngineInfo getOriginalEngine(Context context) {
        ZeusEngineList retrieve = retrieve(context);
        if (retrieve == null) {
            return null;
        }
        return retrieve.original();
    }

    public static ZeusEngineInfo getLastExternalEngine(Context context) {
        ZeusEngineInfo suitableEngine = getSuitableEngine(context);
        if (suitableEngine == null || suitableEngine.type != ZeusEngineInfo.ZeusEngineType.EXTERNAL) {
            return null;
        }
        return suitableEngine;
    }

    public static File[] retrieveExternalEngineDirs(String str) {
        File[] listFiles = new File(str).listFiles(new FileFilter() {
            public boolean accept(File file) {
                if (!file.isDirectory()) {
                    return false;
                }
                return file.getName().matches("^\\d+\\.\\d+\\.\\d+\\.\\d+$");
            }
        });
        if (listFiles != null) {
            try {
                Arrays.sort(listFiles, new Comparator<File>() {
                    public int compare(File file, File file2) {
                        try {
                            return new Version(file.getName()).compare(new Version(file2.getName()));
                        } catch (InvalidZeusVersionException e2) {
                            Log.i("ZeusEngineRetrieval", "[sdk-zeus] not valid dir name: " + e2.getMessage());
                            return -1;
                        }
                    }
                });
            } catch (Exception e2) {
                Log.w("ZeusEngineRetrieval", "[sdk-zeus] sort dir failed: " + e2.getMessage());
            }
        }
        return listFiles;
    }

    private static void a(Context context, String str, ZeusEngineList zeusEngineList) {
        try {
            Version version = new Version("11.56.2.2");
            Version version2 = new Version("11.56.2.2");
            File[] retrieveExternalEngineDirs = retrieveExternalEngineDirs(str);
            if (retrieveExternalEngineDirs != null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("zeus_installed_engines", 0);
                for (File file : retrieveExternalEngineDirs) {
                    Log.i("ZeusEngineRetrieval", "[sdk-zeus] version dir: ".concat(String.valueOf(file)));
                    File file2 = new File(file + File.separator + "version");
                    if (file2.isFile() || file2.exists()) {
                        ZeusEngineInfo zeusEngineInfo = new ZeusEngineInfo();
                        try {
                            FileInputStream fileInputStream = new FileInputStream(file2);
                            try {
                                b bVar = new b();
                                bVar.a((InputStream) fileInputStream);
                                zeusEngineInfo.zeusVersion = bVar.f4029b;
                                zeusEngineInfo.minSdkVersion = bVar.f4028a;
                                zeusEngineInfo.abi = bVar.f4030c;
                                if (zeusEngineInfo.zeusVersion == null || zeusEngineInfo.minSdkVersion == null) {
                                    fileInputStream.close();
                                } else if (zeusEngineInfo.zeusVersion.compare(new Version(file.getName())) != 0) {
                                    Log.i("ZeusEngineRetrieval", "[sdk-zeus] the dir name not matching version in version file: " + file.getName() + " != " + zeusEngineInfo.zeusVersion);
                                    fileInputStream.close();
                                } else {
                                    String string = sharedPreferences.getString(file.getName(), (String) null);
                                    if (!"11.56.2.2".equals(string)) {
                                        Log.i("ZeusEngineRetrieval", "[sdk-zeus] sdk has been updated: " + string + " => 11.56.2.2");
                                        fileInputStream.close();
                                    } else if (!version.compatibleWith(zeusEngineInfo.minSdkVersion)) {
                                        Log.i("ZeusEngineRetrieval", "[sdk-zeus] the engine's min sdk is not compatible with current sdk: " + version + " <> " + zeusEngineInfo.minSdkVersion);
                                        fileInputStream.close();
                                    } else if (version2.compare(zeusEngineInfo.zeusVersion) > 0) {
                                        Log.i("ZeusEngineRetrieval", "[sdk-zeus] the engine's zeus version is smaller than current build-in engine: " + zeusEngineInfo.zeusVersion + " <= " + version2);
                                        fileInputStream.close();
                                    } else if (TextUtils.isEmpty(zeusEngineInfo.abi) || !zeusEngineInfo.abi.equals(Build.CPU_ABI)) {
                                        Log.i("ZeusEngineRetrieval", "[sdk-zeus] the engine's abi does not match with Build.CPU_ABI: " + zeusEngineInfo.abi + " != " + Build.CPU_ABI);
                                        fileInputStream.close();
                                    } else {
                                        zeusEngineInfo.installPath = file.getAbsolutePath();
                                        zeusEngineInfo.type = ZeusEngineInfo.ZeusEngineType.EXTERNAL;
                                        zeusEngineList.push(zeusEngineInfo);
                                        fileInputStream.close();
                                    }
                                }
                            } catch (InvalidZeusVersionException e2) {
                                Log.i("ZeusEngineRetrieval", "[sdk-zeus] the dir name is not version format: " + e2.getMessage());
                                fileInputStream.close();
                            } catch (Throwable th2) {
                                fileInputStream.close();
                                throw th2;
                            }
                        } catch (Exception e3) {
                            Log.w("ZeusEngineRetrieval", "[sdk-zeus] read version file failed when restoring engine: " + file2.getAbsolutePath() + " => " + e3.getMessage());
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                }
            }
        } catch (InvalidZeusVersionException e4) {
            Log.w("ZeusEngineRetrieval", "[sdk-zeus] invalid build-in sdk and zeus version: " + e4.getMessage());
        }
    }

    public static ZeusEngineInfo getLastExternalEngineDynamically(Context context) {
        ZeusEngineInfo peek;
        synchronized (ZeusEngineList.class) {
            try {
                ZeusEngineList zeusEngineList = new ZeusEngineList(new Version("11.56.2.2").business);
                a(context, context.getFilesDir().getAbsolutePath() + File.separator + "zeus" + File.separator + "engines" + File.separator, zeusEngineList);
                peek = zeusEngineList.peek();
            } catch (InvalidZeusVersionException e2) {
                Log.w("ZeusEngineRetrieval", "Global ZEUS_VERSION is invalid: " + e2.getMessage());
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return peek;
    }
}
