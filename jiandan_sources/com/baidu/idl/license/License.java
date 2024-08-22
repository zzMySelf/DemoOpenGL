package com.baidu.idl.license;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.idl.authority.IDLAuthorityException;
import com.baidu.idl.util.HttpClient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class License {
    public static final int LICENSE_AG_ID = -1;
    public static final String LICENSE_ASSETS_FILE = "idl_license";
    public static final String LICENSE_ASSETS_MULTIPLE_FILE = "license/idl_license_%s";
    public static final String LICENSE_FILE = "license";
    public static final String LICENSE_LICENSE_FILE_NAME = "idl_license_%s";
    public static final String TAG = "IDL-License";
    public static final String URL = "http://sdkss.shitu.baidu.com/cgi-bin/queryLicense.py";
    public static License mInstance;
    public ArrayList<String> mALLicense;
    public int mAlgorithmId = -1;
    public String mAlgorithmIdLicenseName = "";
    public int mAuthorityStatus = 256;

    private ArrayList<String> analyseLicense(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<String> arrayList = new ArrayList<>();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public static native String getAlgorithmVersion();

    private InputStream getAssetsLicenseFileInputStream(AssetManager assetManager) {
        try {
            if (TextUtils.isEmpty(this.mAlgorithmIdLicenseName)) {
                return assetManager.open(LICENSE_ASSETS_FILE);
            }
            return assetManager.open(String.format(LICENSE_ASSETS_MULTIPLE_FILE, new Object[]{this.mAlgorithmIdLicenseName}));
        } catch (IOException unused) {
            return null;
        }
    }

    public static native String getAuthorityVersion();

    private File getDataLicenseFile(Context context) {
        if (TextUtils.isEmpty(this.mAlgorithmIdLicenseName)) {
            return context.getDir(LICENSE_FILE, 0);
        }
        File dir = context.getDir(LICENSE_FILE, 0);
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();
        }
        return new File(dir.getAbsolutePath() + File.separator + String.format(LICENSE_LICENSE_FILE_NAME, new Object[]{this.mAlgorithmIdLicenseName}));
    }

    public static synchronized License getInstance() {
        License license;
        synchronized (License.class) {
            if (mInstance == null) {
                mInstance = new License();
            }
            license = mInstance;
        }
        return license;
    }

    /* access modifiers changed from: private */
    public void getLatestLicense(Context context, String str) {
        ArrayList<String> licenseByNetwork = getLicenseByNetwork(context, str);
        if (licenseByNetwork != null && licenseByNetwork.size() > 0 && initLicense(context, str, (String[]) licenseByNetwork.toArray(new String[licenseByNetwork.size()])) < 48) {
            WriteLicense(context, licenseByNetwork);
            "LatestLicense " + licenseByNetwork;
        }
    }

    private ArrayList<String> getLicenseByNetwork(Context context, String str) {
        JSONObject jSONObject;
        ArrayList<String> arrayList;
        String postData = getPostData(context, str);
        "Network Request " + postData;
        String post = HttpClient.post(URL, postData);
        if (post != null && post.length() > 0) {
            "Network Response " + post;
        }
        if (post == null) {
            return null;
        }
        try {
            jSONObject = new JSONObject(post);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        int i2 = -1;
        int optInt = jSONObject.optInt("errno", -1);
        jSONObject.optString("msg");
        JSONArray optJSONArray = jSONObject.optJSONArray(LICENSE_FILE);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            arrayList = null;
        } else {
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                String optString = optJSONArray.optString(i3);
                if (optString != null) {
                    arrayList2.add(optString);
                }
            }
            ArrayList<String> arrayList3 = arrayList2;
            i2 = optInt;
            arrayList = arrayList3;
        }
        if (i2 != 0 || optJSONArray == null || optJSONArray.length() <= 0) {
            return null;
        }
        return arrayList;
    }

    private ArrayList<String> getLocalLicense(Context context) {
        ArrayList<String> ReadLicenseFromData = ReadLicenseFromData(context);
        return (ReadLicenseFromData == null || ReadLicenseFromData.size() < 1) ? ReadLicenseFromAsset(context) : ReadLicenseFromData;
    }

    private int initWithAlgorithmId(Context context, String str) {
        int i2 = this.mAuthorityStatus;
        if (272 == i2) {
            return i2;
        }
        this.mAuthorityStatus = AuthorityState.STATE_INIT_ING;
        this.mAuthorityStatus = verifyByLocalData(context, str);
        "Local License Authority State Is :" + AuthorityState.getStateName(this.mAuthorityStatus);
        if (this.mAuthorityStatus > 48) {
            this.mAuthorityStatus = verifyByNetworkData(context, str);
            "Net License Authority State Is :" + AuthorityState.getStateName(this.mAuthorityStatus);
        }
        int i3 = this.mAuthorityStatus;
        if (i3 <= 48) {
            return i3;
        }
        throw new IDLAuthorityException(AuthorityState.getStateName(this.mAuthorityStatus));
    }

    private int verifyByLocalData(final Context context, final String str) {
        ArrayList<String> localLicense = getLocalLicense(context);
        this.mALLicense = localLicense;
        if (localLicense == null || localLicense.size() <= 0) {
            return 49;
        }
        ArrayList<String> arrayList = this.mALLicense;
        int initLicense = initLicense(context, str, (String[]) arrayList.toArray(new String[arrayList.size()]));
        if (initLicense == 0) {
            return initLicense;
        }
        if (initLicense == 16) {
            new Thread(new Runnable() {
                public void run() {
                    License.this.getLatestLicense(context, str);
                }
            }).start();
            return initLicense;
        }
        deleteErrorLicense(context);
        return initLicense;
    }

    private int verifyByNetworkData(Context context, String str) {
        this.mALLicense = getLicenseByNetwork(context, str);
        "Net License:" + this.mALLicense;
        ArrayList<String> arrayList = this.mALLicense;
        if (arrayList == null || arrayList.size() <= 0) {
            deleteErrorLicense(context);
            return 49;
        }
        ArrayList<String> arrayList2 = this.mALLicense;
        int initLicense = initLicense(context, str, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
        if (initLicense >= 48) {
            return initLicense;
        }
        WriteLicense(context, this.mALLicense);
        return initLicense;
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.util.ArrayList<java.lang.String>, java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0026 A[SYNTHETIC, Splitter:B:18:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0039 A[SYNTHETIC, Splitter:B:28:0x0039] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.lang.String> ReadLicenseFromAsset(android.content.Context r4) {
        /*
            r3 = this;
            android.content.res.AssetManager r0 = r4.getAssets()
            r1 = 0
            java.io.InputStream r0 = r3.getAssetsLicenseFileInputStream(r0)     // Catch:{ IOException -> 0x001f, all -> 0x001d }
            if (r0 == 0) goto L_0x0012
            java.util.ArrayList r1 = r3.analyseLicense(r0)     // Catch:{ IOException -> 0x0010 }
            goto L_0x0012
        L_0x0010:
            r2 = move-exception
            goto L_0x0021
        L_0x0012:
            if (r0 == 0) goto L_0x0029
            r0.close()     // Catch:{ IOException -> 0x0018 }
            goto L_0x0029
        L_0x0018:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0029
        L_0x001d:
            r4 = move-exception
            goto L_0x0037
        L_0x001f:
            r2 = move-exception
            r0 = r1
        L_0x0021:
            r2.printStackTrace()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0029
            r0.close()     // Catch:{ IOException -> 0x0018 }
        L_0x0029:
            if (r1 == 0) goto L_0x0034
            int r0 = r1.size()
            if (r0 <= 0) goto L_0x0034
            r3.WriteLicense(r4, r1)
        L_0x0034:
            return r1
        L_0x0035:
            r4 = move-exception
            r1 = r0
        L_0x0037:
            if (r1 == 0) goto L_0x0041
            r1.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0041
        L_0x003d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0041:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.license.License.ReadLicenseFromAsset(android.content.Context):java.util.ArrayList");
    }

    public ArrayList<String> ReadLicenseFromData(Context context) {
        if (context == null) {
            return null;
        }
        File dataLicenseFile = getDataLicenseFile(context);
        if (dataLicenseFile != null) {
            "ReadLicenseFromData file type " + dataLicenseFile.isDirectory() + dataLicenseFile.getAbsolutePath();
        }
        try {
            return analyseLicense(new FileInputStream(dataLicenseFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0074 A[SYNTHETIC, Splitter:B:37:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e A[SYNTHETIC, Splitter:B:43:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0089 A[SYNTHETIC, Splitter:B:48:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x0079=Splitter:B:40:0x0079, B:34:0x006f=Splitter:B:34:0x006f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean WriteLicense(android.content.Context r6, java.util.ArrayList<java.lang.String> r7) {
        /*
            r5 = this;
            r0 = 0
            if (r7 == 0) goto L_0x0092
            int r1 = r7.size()
            if (r1 == 0) goto L_0x0092
            if (r6 != 0) goto L_0x000d
            goto L_0x0092
        L_0x000d:
            r1 = 1
            java.io.File r6 = r5.getDataLicenseFile(r6)
            if (r6 == 0) goto L_0x0017
            r6.delete()
        L_0x0017:
            if (r6 != 0) goto L_0x001f
            boolean r2 = r6.exists()
            if (r2 != 0) goto L_0x0027
        L_0x001f:
            r6.createNewFile()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0027:
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x006e }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x006e }
            java.lang.String r4 = "WriteLicense path "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x006e }
            java.lang.String r4 = r6.getAbsolutePath()     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x006e }
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x006e }
            r3.toString()     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x006e }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x006e }
            r3.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x006e }
            java.util.Iterator r6 = r7.iterator()     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0063 }
        L_0x0045:
            boolean r7 = r6.hasNext()     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0063 }
            if (r7 == 0) goto L_0x005e
            java.lang.Object r7 = r6.next()     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0063 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0063 }
            byte[] r7 = r7.getBytes()     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0063 }
            r3.write(r7)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0063 }
            r7 = 10
            r3.write(r7)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0063 }
            goto L_0x0045
        L_0x005e:
            r3.close()     // Catch:{ IOException -> 0x0082 }
            r0 = 1
            goto L_0x0086
        L_0x0063:
            r6 = move-exception
            r2 = r3
            goto L_0x0087
        L_0x0066:
            r6 = move-exception
            r2 = r3
            goto L_0x006f
        L_0x0069:
            r6 = move-exception
            r2 = r3
            goto L_0x0079
        L_0x006c:
            r6 = move-exception
            goto L_0x0087
        L_0x006e:
            r6 = move-exception
        L_0x006f:
            r6.printStackTrace()     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x0086
            r2.close()     // Catch:{ IOException -> 0x0082 }
            goto L_0x0086
        L_0x0078:
            r6 = move-exception
        L_0x0079:
            r6.printStackTrace()     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x0086
            r2.close()     // Catch:{ IOException -> 0x0082 }
            goto L_0x0086
        L_0x0082:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0086:
            return r0
        L_0x0087:
            if (r2 == 0) goto L_0x0091
            r2.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0091:
            throw r6
        L_0x0092:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.license.License.WriteLicense(android.content.Context, java.util.ArrayList):boolean");
    }

    public void deleteErrorLicense(Context context) {
        if (context != null) {
            File dir = context.getDir(LICENSE_FILE, 0);
            if (dir.exists()) {
                dir.delete();
            }
        }
    }

    public native long getLicenseRemnant(int i2);

    public native int getLicenseState(int i2);

    public int getLicenseStateWithAlgorithmId(int i2) {
        return getLicenseState(i2);
    }

    public native String getPostData(Context context, String str);

    @Deprecated
    public int init(Context context, String str) {
        this.mAlgorithmId = -1;
        this.mAlgorithmIdLicenseName = "";
        int i2 = this.mAuthorityStatus;
        if (272 == i2) {
            return i2;
        }
        this.mAuthorityStatus = AuthorityState.STATE_INIT_ING;
        this.mAuthorityStatus = verifyByLocalData(context, str);
        "Local License Authority State Is :" + AuthorityState.getStateName(this.mAuthorityStatus);
        if (this.mAuthorityStatus > 48) {
            this.mAuthorityStatus = verifyByNetworkData(context, str);
            "Net License Authority State Is :" + AuthorityState.getStateName(this.mAuthorityStatus);
        }
        if (this.mAuthorityStatus > 48) {
            "IDLAuthorityException :" + AuthorityState.getStateName(this.mAuthorityStatus);
        }
        return this.mAuthorityStatus;
    }

    public native int initLicense(Context context, String str, String[] strArr);

    public native int initLicenseWithToken(String str);

    public int init(String str) {
        int i2 = this.mAuthorityStatus;
        if (272 == i2) {
            return i2;
        }
        this.mAuthorityStatus = AuthorityState.STATE_INIT_ING;
        if (str == null || str.length() <= 0) {
            this.mAuthorityStatus = 51;
        } else {
            int initLicenseWithToken = initLicenseWithToken(str);
            this.mAuthorityStatus = initLicenseWithToken;
            if (initLicenseWithToken != 0) {
                this.mAuthorityStatus = 51;
            }
        }
        return this.mAuthorityStatus;
    }

    public int init(Context context, String str, int i2, String str2) {
        this.mAlgorithmId = i2;
        this.mAlgorithmIdLicenseName = str2;
        return initWithAlgorithmId(context, str);
    }
}
