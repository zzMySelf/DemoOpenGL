package com.baidu.sapi2.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.Log;
import com.dlife.ctaccountapi.w;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {
    public static final String[] b = {"_display_name", "_size"};
    public static final String c = "android.support.FILE_PROVIDER_PATHS";
    public static final String d = "root-path";
    public static final String e = "files-path";
    public static final String f = "cache-path";
    public static final String g = "external-path";
    public static final String h = "name";

    /* renamed from: i  reason: collision with root package name */
    public static final String f960i = "path";
    public static final File j = new File("/");
    public static HashMap<String, a> k = new HashMap<>();
    public a a;

    public interface a {
        Uri a(File file);

        File a(Uri uri);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0014 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.baidu.sapi2.provider.FileProvider.a a(android.content.Context r5, java.lang.String r6) {
        /*
            java.util.HashMap<java.lang.String, com.baidu.sapi2.provider.FileProvider$a> r0 = k
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, com.baidu.sapi2.provider.FileProvider$a> r1 = k     // Catch:{ all -> 0x006a }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x006a }
            com.baidu.sapi2.provider.FileProvider$a r1 = (com.baidu.sapi2.provider.FileProvider.a) r1     // Catch:{ all -> 0x006a }
            if (r1 != 0) goto L_0x0068
            r2 = 0
            com.baidu.sapi2.provider.FileProvider$a r5 = b(r5, r6)     // Catch:{ IOException -> 0x003b, XmlPullParserException -> 0x0014 }
            r1 = r5
            goto L_0x0061
        L_0x0014:
            com.baidu.sapi2.SapiAccountManager r3 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ all -> 0x006a }
            if (r3 == 0) goto L_0x0033
            com.baidu.sapi2.SapiConfiguration r4 = r3.getConfignation()     // Catch:{ all -> 0x006a }
            if (r4 == 0) goto L_0x0033
            com.baidu.sapi2.SapiConfiguration r3 = r3.getConfignation()     // Catch:{ all -> 0x006a }
            boolean r3 = r3.debug     // Catch:{ all -> 0x006a }
            if (r3 != 0) goto L_0x0029
            goto L_0x0033
        L_0x0029:
            java.lang.String r3 = "Failed to parse android.support.FILE_PROVIDER_PATHS meta-data"
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r3, r2)     // Catch:{ all -> 0x006a }
            r5.show()     // Catch:{ all -> 0x006a }
            goto L_0x0061
        L_0x0033:
            java.lang.String r5 = "Failed to parse android.support.FILE_PROVIDER_PATHS meta-data"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x006a }
            com.baidu.sapi2.utils.Log.e((java.lang.String) r5, (java.lang.Object[]) r2)     // Catch:{ all -> 0x006a }
            goto L_0x0061
        L_0x003b:
            com.baidu.sapi2.SapiAccountManager r3 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ all -> 0x006a }
            if (r3 == 0) goto L_0x005a
            com.baidu.sapi2.SapiConfiguration r4 = r3.getConfignation()     // Catch:{ all -> 0x006a }
            if (r4 == 0) goto L_0x005a
            com.baidu.sapi2.SapiConfiguration r3 = r3.getConfignation()     // Catch:{ all -> 0x006a }
            boolean r3 = r3.debug     // Catch:{ all -> 0x006a }
            if (r3 != 0) goto L_0x0050
            goto L_0x005a
        L_0x0050:
            java.lang.String r3 = "Failed to parse android.support.FILE_PROVIDER_PATHS meta-data"
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r3, r2)     // Catch:{ all -> 0x006a }
            r5.show()     // Catch:{ all -> 0x006a }
            goto L_0x0061
        L_0x005a:
            java.lang.String r5 = "Failed to parse android.support.FILE_PROVIDER_PATHS meta-data"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x006a }
            com.baidu.sapi2.utils.Log.e((java.lang.String) r5, (java.lang.Object[]) r2)     // Catch:{ all -> 0x006a }
        L_0x0061:
            if (r1 == 0) goto L_0x0068
            java.util.HashMap<java.lang.String, com.baidu.sapi2.provider.FileProvider$a> r5 = k     // Catch:{ all -> 0x006a }
            r5.put(r6, r1)     // Catch:{ all -> 0x006a }
        L_0x0068:
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            return r1
        L_0x006a:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.provider.FileProvider.a(android.content.Context, java.lang.String):com.baidu.sapi2.provider.FileProvider$a");
    }

    public static a b(Context context, String str) throws IOException, XmlPullParserException {
        b bVar = new b(str);
        XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (loadXmlMetaData != null) {
            while (true) {
                int next = loadXmlMetaData.next();
                if (next == 1) {
                    break;
                } else if (next == 2) {
                    String name = loadXmlMetaData.getName();
                    File file = null;
                    String attributeValue = loadXmlMetaData.getAttributeValue((String) null, "name");
                    String attributeValue2 = loadXmlMetaData.getAttributeValue((String) null, "path");
                    if ("root-path".equals(name)) {
                        file = a(j, attributeValue2);
                    } else if ("files-path".equals(name)) {
                        file = a(context.getFilesDir(), attributeValue2);
                    } else if ("cache-path".equals(name)) {
                        file = a(context.getCacheDir(), attributeValue2);
                    } else if ("external-path".equals(name)) {
                        try {
                            file = a(Environment.getExternalStorageDirectory(), attributeValue2);
                        } catch (Exception e2) {
                            Log.e(e2);
                        }
                    }
                    if (file != null) {
                        bVar.a(attributeValue, file);
                    }
                }
            }
        } else {
            SapiAccountManager instance = SapiAccountManager.getInstance();
            if (instance == null || instance.getConfignation() == null || !instance.getConfignation().debug) {
                Log.e("Missing android.support.FILE_PROVIDER_PATHS meta-data", new Object[0]);
            } else {
                Toast.makeText(context, "Missing android.support.FILE_PROVIDER_PATHS meta-data", 0).show();
            }
        }
        return bVar;
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        return a(context, str).a(file);
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            this.a = a(context, providerInfo.authority);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.a.a(uri).delete() ? 1 : 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r3 = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(r3.getName().substring(r0 + 1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getType(android.net.Uri r3) {
        /*
            r2 = this;
            com.baidu.sapi2.provider.FileProvider$a r0 = r2.a
            java.io.File r3 = r0.a((android.net.Uri) r3)
            java.lang.String r0 = r3.getName()
            r1 = 46
            int r0 = r0.lastIndexOf(r1)
            if (r0 < 0) goto L_0x0027
            java.lang.String r3 = r3.getName()
            int r0 = r0 + 1
            java.lang.String r3 = r3.substring(r0)
            android.webkit.MimeTypeMap r0 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r3 = r0.getMimeTypeFromExtension(r3)
            if (r3 == 0) goto L_0x0027
            return r3
        L_0x0027:
            java.lang.String r3 = "application/octet-stream"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.provider.FileProvider.getType(android.net.Uri):java.lang.String");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.a.a(uri), a(str));
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i2;
        File a2 = this.a.a(uri);
        if (strArr == null) {
            strArr = b;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i3 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i3] = "_display_name";
                i2 = i3 + 1;
                objArr[i3] = a2.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i3] = "_size";
                i2 = i3 + 1;
                objArr[i3] = Long.valueOf(a2.length());
            }
            i3 = i2;
        }
        String[] a3 = a(strArr3, i3);
        Object[] a4 = a(objArr, i3);
        MatrixCursor matrixCursor = new MatrixCursor(a3, 1);
        matrixCursor.addRow(a4);
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public static class b implements a {
        public final String a;
        public final HashMap<String, File> b = new HashMap<>();

        public b(String str) {
            this.a = str;
        }

        public void a(String str, File file) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.b.put(str, file.getCanonicalFile());
                } catch (IOException e) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
                }
            } else {
                throw new IllegalArgumentException("Name must not be empty");
            }
        }

        public Uri a(File file) {
            String str;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry entry = null;
                for (Map.Entry next : this.b.entrySet()) {
                    String path = ((File) next.getValue()).getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = next;
                    }
                }
                if (entry != null) {
                    String path2 = ((File) entry.getValue()).getPath();
                    if (path2.endsWith("/")) {
                        str = canonicalPath.substring(path2.length());
                    } else {
                        str = canonicalPath.substring(path2.length() + 1);
                    }
                    return new Uri.Builder().scheme("content").authority(this.a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(str, "/")).build();
                }
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        public File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.b.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
                }
            } else {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
        }
    }

    public static int a(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if (w.a.equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    public static File a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    public static String[] a(String[] strArr, int i2) {
        String[] strArr2 = new String[i2];
        System.arraycopy(strArr, 0, strArr2, 0, i2);
        return strArr2;
    }

    public static Object[] a(Object[] objArr, int i2) {
        Object[] objArr2 = new Object[i2];
        System.arraycopy(objArr, 0, objArr2, 0, i2);
        return objArr2;
    }
}
