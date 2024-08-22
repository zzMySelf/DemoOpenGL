package com.baidu.searchbox.favor.sync.business.favor.db;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.util.android.PkgUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.favor.data.FavorTable;
import com.baidu.searchbox.favor.sync.business.favor.util.SqlWhereClause;
import com.baidu.searchbox.favor.sync.util.FavorAccountUtil;
import com.baidu.searchbox.favor.sync.util.LogUtil;
import com.baidu.swan.apps.textarea.info.TextAreaCallbackInfo;
import java.util.ArrayList;
import org.json.JSONObject;

public class FavorProvider {
    public static final String AUTHORITY;
    public static final Uri FAVORS_ALL_URI;
    public static final Uri FAVORS_ID_URI;
    public static final String MATCHER_TAG_DATA = "favors/data";
    public static final String MATCHER_TAG_DATA_ITEM = "favors/data/item/*";
    public static final String MATCHER_TAG_DB_CLOSE = "favors/db/close";
    public static final String MATCHER_TAG_DIR = "favors/dir";
    public static final String MATCHER_TAG_DIR_ITEM = "favors/dir/item/*";
    public static final String MATCHER_TAG_DIR_ROOT = "favors/dir/root";
    public static final String MATCHER_TAG_FAVORS = "favors";
    public static final String MATCHER_TAG_FAVORS_ID = "favors/favor/#";
    private static final int MIN_OPERATION_TO_SLEEP = 10;
    private static final long SLEEP_LONG = 200;
    private static final long SLEEP_SHORT = 10;
    public static final String TAG = "FavorProvider";
    private static final UriMatcher URI_MATCHER;
    public static final int URI_MATCHER_TYPE_ALL = 1;
    public static final int URI_MATCHER_TYPE_ALL_ID = 2;
    public static final int URI_MATCHER_TYPE_DATA = 20;
    public static final int URI_MATCHER_TYPE_DATA_ITEM = 21;
    public static final int URI_MATCHER_TYPE_DB_CLOSE = 30;
    public static final int URI_MATCHER_TYPE_DIR = 10;
    public static final int URI_MATCHER_TYPE_DIR_ITEM = 12;
    public static final int URI_MATCHER_TYPE_DIR_ROOT = 11;
    private Context mContext;
    private int mProcesUid = Process.myUid();
    private ContentProvider mProvider;
    private String mWritePermission;

    static {
        String str = AppRuntime.getApplication().getPackageName() + ".baidusearch_favors";
        AUTHORITY = str;
        FAVORS_ALL_URI = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + str + "/" + MATCHER_TAG_FAVORS);
        FAVORS_ID_URI = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + str + "/favors/favor");
        UriMatcher uriMatcher = new UriMatcher(-1);
        URI_MATCHER = uriMatcher;
        uriMatcher.addURI(str, MATCHER_TAG_FAVORS, 1);
        uriMatcher.addURI(str, MATCHER_TAG_FAVORS_ID, 2);
        uriMatcher.addURI(str, MATCHER_TAG_DIR, 10);
        uriMatcher.addURI(str, MATCHER_TAG_DIR_ROOT, 11);
        uriMatcher.addURI(str, MATCHER_TAG_DIR_ITEM, 12);
        uriMatcher.addURI(str, MATCHER_TAG_DATA, 20);
        uriMatcher.addURI(str, MATCHER_TAG_DATA_ITEM, 21);
        uriMatcher.addURI(str, MATCHER_TAG_DB_CLOSE, 30);
    }

    FavorProvider(ContentProvider provider, String writePermission) {
        this.mProvider = provider;
        this.mContext = provider.getContext();
        this.mWritePermission = writePermission;
    }

    private Context getContext() {
        return this.mContext;
    }

    private String getWritePermission() {
        return this.mWritePermission;
    }

    /* access modifiers changed from: package-private */
    public String getType(Uri uri) {
        switch (URI_MATCHER.match(uri)) {
            case 1:
                return "vnd.android.cursor.dir/favors";
            case 2:
                return "vnd.android.cursor.item/favors";
            case 10:
                return "vnd.android.cursor.dir/favors_dir";
            case 11:
                return "vnd.android.cursor.dir/favors_root_dir";
            case 12:
                return "vnd.android.cursor.item/favors_dir";
            case 20:
                return "vnd.android.cursor.dir/favors_data";
            case 21:
                return "vnd.android.cursor.item/favors_data";
            case 30:
                return "vnd.android.cursor.item/favors";
            default:
                if (!AppConfig.isDebug()) {
                    return null;
                }
                throw new IllegalArgumentException("Unknown URL");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0368  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor query(android.net.Uri r25, java.lang.String[] r26, java.lang.String r27, java.lang.String[] r28, java.lang.String r29) {
        /*
            r24 = this;
            r1 = r26
            r2 = r27
            r3 = r28
            java.lang.String r4 = com.baidu.searchbox.favor.sync.business.favor.db.FavorUriHelper.getUid(r25)
            boolean r5 = com.baidu.searchbox.favor.sync.business.favor.db.FavorUriHelper.needCheckUid(r25)
            java.lang.String r6 = com.baidu.searchbox.favor.sync.business.favor.db.FavorUriHelper.getSelectStatus(r25)
            java.lang.String r16 = com.baidu.searchbox.favor.sync.business.favor.db.FavorUriHelper.getLimit(r25)
            java.lang.String r15 = com.baidu.searchbox.favor.sync.util.FavorAccountUtil.getUid()
            java.lang.String r14 = "FavorProvider"
            if (r5 == 0) goto L_0x004d
            boolean r0 = android.text.TextUtils.equals(r15, r4)
            if (r0 != 0) goto L_0x004d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r7 = "uid="
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r7 = ", cur uid="
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.StringBuilder r0 = r0.append(r15)
            java.lang.String r7 = "; NOT MATCH!!!"
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.baidu.searchbox.favor.sync.util.LogUtil.w(r14, r0)
            r0 = 0
            return r0
        L_0x004d:
            com.baidu.searchbox.favor.sync.business.favor.util.SqlWhereClause r13 = com.baidu.searchbox.favor.sync.business.favor.util.SqlWhereClause.buildWhereClause(r27, r28)
            android.content.UriMatcher r0 = URI_MATCHER
            r12 = r25
            int r11 = r0.match(r12)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r7 = "Query: uri type="
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.String r0 = r0.toString()
            com.baidu.searchbox.favor.sync.util.LogUtil.d(r14, r0)
            java.lang.String r7 = " = ? "
            java.lang.String r9 = ")"
            java.lang.String r10 = " IN ("
            switch(r11) {
                case 1: goto L_0x02bf;
                case 2: goto L_0x026c;
                case 10: goto L_0x0211;
                case 11: goto L_0x01a7;
                case 12: goto L_0x0148;
                case 20: goto L_0x00eb;
                case 21: goto L_0x0084;
                default: goto L_0x0078;
            }
        L_0x0078:
            r19 = r5
            boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r0 != 0) goto L_0x03e5
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0332 }
            goto L_0x02f8
        L_0x0084:
            java.lang.String r17 = com.baidu.searchbox.favor.sync.business.favor.db.FavorUriHelper.getUkey(r25)
            boolean r18 = android.text.TextUtils.isEmpty(r17)
            if (r18 != 0) goto L_0x00ae
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            com.baidu.searchbox.favor.data.FavorTable r19 = com.baidu.searchbox.favor.data.FavorTable.ukey
            java.lang.String r0 = r19.name()
            java.lang.StringBuilder r0 = r8.append(r0)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            r7 = 1
            java.lang.String[] r7 = new java.lang.String[r7]
            r8 = 0
            r7[r8] = r17
            r13.appendClause(r0, r7)
        L_0x00ae:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x00e5
            java.lang.String[] r0 = com.baidu.searchbox.favor.sync.business.favor.db.FavorUriHelper.getSelectStatusArray(r6)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            com.baidu.searchbox.favor.data.FavorTable r8 = com.baidu.searchbox.favor.data.FavorTable.status
            java.lang.String r8 = r8.name()
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r7 = r7.append(r10)
            int r8 = r0.length
            java.lang.String r8 = com.baidu.searchbox.favor.sync.business.favor.util.SqlWhereClause.joinInWhereClause(r8)
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r7 = r7.append(r9)
            java.lang.String r7 = r7.toString()
            r13.appendClause(r7, r0)
            r7 = r29
            r19 = r5
            goto L_0x0338
        L_0x00e5:
            r7 = r29
            r19 = r5
            goto L_0x0338
        L_0x00eb:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.baidu.searchbox.favor.data.FavorTable r8 = com.baidu.searchbox.favor.data.FavorTable.datatype
            java.lang.String r8 = r8.name()
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r7 = "1"
            java.lang.String[] r7 = new java.lang.String[]{r7}
            r13.appendClause(r0, r7)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x0142
            java.lang.String[] r0 = com.baidu.searchbox.favor.sync.business.favor.db.FavorUriHelper.getSelectStatusArray(r6)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            com.baidu.searchbox.favor.data.FavorTable r8 = com.baidu.searchbox.favor.data.FavorTable.status
            java.lang.String r8 = r8.name()
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r7 = r7.append(r10)
            int r8 = r0.length
            java.lang.String r8 = com.baidu.searchbox.favor.sync.business.favor.util.SqlWhereClause.joinInWhereClause(r8)
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r7 = r7.append(r9)
            java.lang.String r7 = r7.toString()
            r13.appendClause(r7, r0)
            r7 = r29
            r19 = r5
            goto L_0x0338
        L_0x0142:
            r7 = r29
            r19 = r5
            goto L_0x0338
        L_0x0148:
            java.lang.String r0 = com.baidu.searchbox.favor.sync.business.favor.db.FavorUriHelper.getUkey(r25)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            com.baidu.searchbox.favor.data.FavorTable r17 = com.baidu.searchbox.favor.data.FavorTable.parent
            r19 = r5
            java.lang.String r5 = r17.name()
            java.lang.StringBuilder r5 = r8.append(r5)
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r5 = r5.toString()
            r7 = 1
            java.lang.String[] r7 = new java.lang.String[r7]
            r8 = 0
            r7[r8] = r0
            r13.appendClause(r5, r7)
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto L_0x01a3
            java.lang.String[] r5 = com.baidu.searchbox.favor.sync.business.favor.db.FavorUriHelper.getSelectStatusArray(r6)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            com.baidu.searchbox.favor.data.FavorTable r8 = com.baidu.searchbox.favor.data.FavorTable.status
            java.lang.String r8 = r8.name()
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r7 = r7.append(r10)
            int r8 = r5.length
            java.lang.String r8 = com.baidu.searchbox.favor.sync.business.favor.util.SqlWhereClause.joinInWhereClause(r8)
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r7 = r7.append(r9)
            java.lang.String r7 = r7.toString()
            r13.appendClause(r7, r5)
            r7 = r29
            goto L_0x0338
        L_0x01a3:
            r7 = r29
            goto L_0x0338
        L_0x01a7:
            r19 = r5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.baidu.searchbox.favor.data.FavorTable r5 = com.baidu.searchbox.favor.data.FavorTable.parent
            java.lang.String r5 = r5.name()
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r5 = " IS NULL OR "
            java.lang.StringBuilder r0 = r0.append(r5)
            com.baidu.searchbox.favor.data.FavorTable r5 = com.baidu.searchbox.favor.data.FavorTable.parent
            java.lang.String r5 = r5.name()
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r5 = " = \"\""
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r0 = r0.toString()
            r5 = 0
            java.lang.Object[] r7 = new java.lang.Object[r5]
            r13.appendClause(r0, r7)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x020d
            java.lang.String[] r0 = com.baidu.searchbox.favor.sync.business.favor.db.FavorUriHelper.getSelectStatusArray(r6)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.baidu.searchbox.favor.data.FavorTable r7 = com.baidu.searchbox.favor.data.FavorTable.status
            java.lang.String r7 = r7.name()
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.StringBuilder r5 = r5.append(r10)
            int r7 = r0.length
            java.lang.String r7 = com.baidu.searchbox.favor.sync.business.favor.util.SqlWhereClause.joinInWhereClause(r7)
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.StringBuilder r5 = r5.append(r9)
            java.lang.String r5 = r5.toString()
            r13.appendClause(r5, r0)
            r7 = r29
            goto L_0x0338
        L_0x020d:
            r7 = r29
            goto L_0x0338
        L_0x0211:
            r19 = r5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.baidu.searchbox.favor.data.FavorTable r5 = com.baidu.searchbox.favor.data.FavorTable.datatype
            java.lang.String r5 = r5.name()
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "2"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r13.appendClause(r0, r5)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x0268
            java.lang.String[] r0 = com.baidu.searchbox.favor.sync.business.favor.db.FavorUriHelper.getSelectStatusArray(r6)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.baidu.searchbox.favor.data.FavorTable r7 = com.baidu.searchbox.favor.data.FavorTable.status
            java.lang.String r7 = r7.name()
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.StringBuilder r5 = r5.append(r10)
            int r7 = r0.length
            java.lang.String r7 = com.baidu.searchbox.favor.sync.business.favor.util.SqlWhereClause.joinInWhereClause(r7)
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.StringBuilder r5 = r5.append(r9)
            java.lang.String r5 = r5.toString()
            r13.appendClause(r5, r0)
            r7 = r29
            goto L_0x0338
        L_0x0268:
            r7 = r29
            goto L_0x0338
        L_0x026c:
            r19 = r5
            long r7 = android.content.ContentUris.parseId(r25)
            r0 = 1
            java.lang.Long[] r0 = new java.lang.Long[r0]
            java.lang.Long r5 = java.lang.Long.valueOf(r7)
            r17 = 0
            r0[r17] = r5
            java.lang.String r5 = "_id = ? "
            r13.appendClause(r5, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x02b9
            java.lang.String[] r0 = com.baidu.searchbox.favor.sync.business.favor.db.FavorUriHelper.getSelectStatusArray(r6)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.baidu.searchbox.favor.data.FavorTable r17 = com.baidu.searchbox.favor.data.FavorTable.status
            r20 = r7
            java.lang.String r7 = r17.name()
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.StringBuilder r5 = r5.append(r10)
            int r7 = r0.length
            java.lang.String r7 = com.baidu.searchbox.favor.sync.business.favor.util.SqlWhereClause.joinInWhereClause(r7)
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.StringBuilder r5 = r5.append(r9)
            java.lang.String r5 = r5.toString()
            r13.appendClause(r5, r0)
            r7 = r29
            goto L_0x0338
        L_0x02b9:
            r20 = r7
            r7 = r29
            goto L_0x0338
        L_0x02bf:
            r19 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x02f5
            java.lang.String[] r0 = com.baidu.searchbox.favor.sync.business.favor.db.FavorUriHelper.getSelectStatusArray(r6)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.baidu.searchbox.favor.data.FavorTable r7 = com.baidu.searchbox.favor.data.FavorTable.status
            java.lang.String r7 = r7.name()
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.StringBuilder r5 = r5.append(r10)
            int r7 = r0.length
            java.lang.String r7 = com.baidu.searchbox.favor.sync.business.favor.util.SqlWhereClause.joinInWhereClause(r7)
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.StringBuilder r5 = r5.append(r9)
            java.lang.String r5 = r5.toString()
            r13.appendClause(r5, r0)
            r7 = r29
            goto L_0x0338
        L_0x02f5:
            r7 = r29
            goto L_0x0338
        L_0x02f8:
            r0.<init>()     // Catch:{ Exception -> 0x0332 }
            java.lang.String r5 = "operation"
            java.lang.String r7 = "query"
            r0.put(r5, r7)     // Catch:{ Exception -> 0x0332 }
            java.lang.String r5 = "uri"
            java.lang.String r7 = r25.toString()     // Catch:{ Exception -> 0x0332 }
            r0.put(r5, r7)     // Catch:{ Exception -> 0x0332 }
            java.lang.String r5 = "projection"
            r0.put(r5, r1)     // Catch:{ Exception -> 0x0332 }
            java.lang.String r5 = "selection"
            r0.put(r5, r2)     // Catch:{ Exception -> 0x0332 }
            java.lang.String r5 = "selectionArgs"
            r0.put(r5, r3)     // Catch:{ Exception -> 0x0332 }
            java.lang.String r5 = "sortOrder"
            r7 = r29
            r0.put(r5, r7)     // Catch:{ Exception -> 0x0330 }
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x0330 }
            sendExpInfoToUBC(r5)     // Catch:{ Exception -> 0x0330 }
            goto L_0x0338
        L_0x0330:
            r0 = move-exception
            goto L_0x0335
        L_0x0332:
            r0 = move-exception
            r7 = r29
        L_0x0335:
            r0.printStackTrace()
        L_0x0338:
            boolean r0 = android.text.TextUtils.isEmpty(r29)
            if (r0 == 0) goto L_0x0368
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.baidu.searchbox.favor.data.FavorTable r5 = com.baidu.searchbox.favor.data.FavorTable.datatype
            java.lang.String r5 = r5.name()
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r5 = " desc, "
            java.lang.StringBuilder r0 = r0.append(r5)
            com.baidu.searchbox.favor.data.FavorTable r5 = com.baidu.searchbox.favor.data.FavorTable.createtime
            java.lang.String r5 = r5.name()
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r5 = " desc"
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r0 = r0.toString()
            goto L_0x0369
        L_0x0368:
            r0 = r7
        L_0x0369:
            r5 = 0
            if (r1 == 0) goto L_0x0377
            int r7 = r1.length
            if (r7 <= 0) goto L_0x0377
            int r7 = r1.length
            java.lang.String[] r5 = new java.lang.String[r7]
            int r7 = r1.length
            r8 = 0
            java.lang.System.arraycopy(r1, r8, r5, r8, r7)
        L_0x0377:
            android.database.sqlite.SQLiteDatabase r17 = getReadableDatabase(r4)
            java.lang.String r10 = r13.getWhereClause()
            java.lang.String[] r18 = r13.getWhereArgs()
            r20 = 0
            r21 = 0
            java.lang.String r8 = "favor"
            r7 = r17
            r9 = r5
            r22 = r11
            r11 = r18
            r12 = r20
            r18 = r13
            r13 = r21
            r23 = r14
            r14 = r0
            r20 = r15
            r15 = r16
            android.database.Cursor r7 = r7.query(r8, r9, r10, r11, r12, r13, r14, r15)
            android.content.Context r8 = r24.getContext()
            android.content.ContentResolver r8 = r8.getContentResolver()
            android.net.Uri r9 = FAVORS_ALL_URI
            r7.setNotificationUri(r8, r9)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Query:\n projection: "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r5)
            java.lang.String r9 = "\n selection: "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r2)
            java.lang.String r9 = ";\t selectionArgs: "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r3)
            java.lang.String r9 = "\n sortorder: "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r0)
            java.lang.String r8 = r8.toString()
            r9 = r23
            com.baidu.searchbox.favor.sync.util.LogUtil.d(r9, r8)
            return r7
        L_0x03e5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Unknown URI"
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.favor.sync.business.favor.db.FavorProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* access modifiers changed from: package-private */
    public Uri insert(Uri uri, ContentValues values) {
        checkWritePermission();
        String uid = FavorUriHelper.getUid(uri);
        boolean needCheckUid = FavorUriHelper.needCheckUid(uri);
        String curUid = FavorAccountUtil.getUid();
        if (!needCheckUid || TextUtils.equals(curUid, uid)) {
            int match = URI_MATCHER.match(uri);
            if (match == -1) {
                LogUtil.d(TAG, "Insert: uri match = " + match);
                if (!AppConfig.isDebug()) {
                    try {
                        JSONObject expInfo = new JSONObject();
                        expInfo.put("operation", "insert");
                        expInfo.put("uri", uri.toString());
                        expInfo.put("contentValues", values.toString());
                        sendExpInfoToUBC(expInfo.toString());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    throw new IllegalArgumentException("Unknown URI");
                }
            }
            Uri newUri = null;
            long rowId = getWritableDatabase(uid).insertWithOnConflict("favor", FavorTable.ukey.name(), values, FavorUriHelper.getConflict(uri));
            if (rowId > 0) {
                newUri = ContentUris.withAppendedId(FAVORS_ID_URI, rowId);
            }
            LogUtil.d(TAG, "Insert: rowid = " + rowId + ", uri = " + newUri);
            if (newUri != null) {
                getContext().getContentResolver().notifyChange(FAVORS_ALL_URI, (ContentObserver) null);
            }
            return newUri;
        }
        LogUtil.w(TAG, "uid=" + uid + ", cur uid=" + curUid + "; NOT MATCH!!!");
        return null;
    }

    /* access modifiers changed from: package-private */
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        checkWritePermission();
        String uid = FavorUriHelper.getUid(uri);
        boolean needCheckUid = FavorUriHelper.needCheckUid(uri);
        String curUid = FavorAccountUtil.getUid();
        if (!needCheckUid || TextUtils.equals(curUid, uid)) {
            int match = URI_MATCHER.match(uri);
            LogUtil.d(TAG, "Delete: uri type=" + match);
            if (match == -1) {
                if (!AppConfig.isDebug()) {
                    try {
                        JSONObject expInfo = new JSONObject();
                        expInfo.put("operation", "delete");
                        expInfo.put("uri", uri.toString());
                        expInfo.put(TextAreaCallbackInfo.EVENT_NAME_SELECTION, selection);
                        expInfo.put("selectionArgs", selectionArgs);
                        sendExpInfoToUBC(expInfo.toString());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    throw new IllegalArgumentException("Unknown URI");
                }
            }
            SqlWhereClause sqlWhereClause = SqlWhereClause.buildWhereClause(selection, selectionArgs);
            switch (match) {
                case 2:
                    sqlWhereClause.appendClause("_id = ? ", Long.valueOf(ContentUris.parseId(uri)));
                    break;
                case 12:
                    String dirKey = FavorUriHelper.getUkey(uri);
                    if (!TextUtils.isEmpty(dirKey)) {
                        sqlWhereClause.appendClause(FavorTable.ukey.name() + " = ? OR " + FavorTable.parent.name() + " = ? ", dirKey, dirKey);
                        break;
                    }
                    break;
                case 21:
                    String dataKey = FavorUriHelper.getUkey(uri);
                    if (!TextUtils.isEmpty(dataKey)) {
                        sqlWhereClause.appendClause(FavorTable.ukey.name() + " = ? ", dataKey);
                        break;
                    }
                    break;
            }
            SQLiteDatabase database = getWritableDatabase(uid);
            ContentResolver cr = getContext().getContentResolver();
            int count = database.delete("favor", sqlWhereClause.getWhereClause(), sqlWhereClause.getWhereArgs());
            if (count > 0) {
                cr.notifyChange(FAVORS_ALL_URI, (ContentObserver) null);
            }
            return count;
        }
        LogUtil.w(TAG, "uid=" + uid + ", cur uid=" + curUid + "; NOT MATCH!!!");
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        checkWritePermission();
        String uid = FavorUriHelper.getUid(uri);
        boolean needCheckUid = FavorUriHelper.needCheckUid(uri);
        String curUid = FavorAccountUtil.getUid();
        if (!needCheckUid || TextUtils.equals(curUid, uid)) {
            int match = URI_MATCHER.match(uri);
            LogUtil.d(TAG, "Update: uri type=" + match);
            if (match == -1) {
                if (!AppConfig.isDebug()) {
                    try {
                        JSONObject expInfo = new JSONObject();
                        expInfo.put("operation", "update");
                        expInfo.put("uri", uri.toString());
                        expInfo.put(TextAreaCallbackInfo.EVENT_NAME_SELECTION, selection);
                        expInfo.put("selectionArgs", selectionArgs);
                        sendExpInfoToUBC(expInfo.toString());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    throw new IllegalArgumentException("Unknown URI");
                }
            }
            if (match == 30) {
                FavorDbControl.getInstance(uid).close();
                LogUtil.d(TAG, "Close DB by Uri, uid=" + uid);
                return 0;
            }
            SqlWhereClause sqlWhereClause = SqlWhereClause.buildWhereClause(selection, selectionArgs);
            switch (match) {
                case 2:
                    sqlWhereClause.appendClause("_id = ? ", Long.valueOf(ContentUris.parseId(uri)));
                    break;
                case 12:
                    String dirKey = FavorUriHelper.getUkey(uri);
                    if (!TextUtils.isEmpty(dirKey)) {
                        sqlWhereClause.appendClause(FavorTable.ukey.name() + " = ? OR " + FavorTable.parent.name() + " = ? ", dirKey, dirKey);
                        break;
                    }
                    break;
                case 21:
                    String dataKey = FavorUriHelper.getUkey(uri);
                    if (!TextUtils.isEmpty(dataKey)) {
                        sqlWhereClause.appendClause(FavorTable.ukey.name() + " = ? ", dataKey);
                        break;
                    }
                    break;
            }
            SQLiteDatabase database = getWritableDatabase(uid);
            ContentResolver cr = getContext().getContentResolver();
            int count = database.update("favor", values, sqlWhereClause.getWhereClause(), sqlWhereClause.getWhereArgs());
            if (count > 0) {
                cr.notifyChange(FAVORS_ALL_URI, (ContentObserver) null);
            }
            return count;
        }
        LogUtil.w(TAG, "uid=" + uid + ", cur uid=" + curUid + "; NOT MATCH!!!");
        return 0;
    }

    /* access modifiers changed from: package-private */
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
        ContentProviderOperation contentProviderOperation;
        boolean shouldSleep;
        boolean isYield;
        long sleepTime;
        FavorDbControl favorDB;
        int operationNum;
        checkWritePermission();
        int operationNum2 = operations.size();
        ContentProviderResult[] results = new ContentProviderResult[operationNum2];
        FavorDbControl favorDB2 = FavorDbControl.getInstance();
        SQLiteDatabase db = favorDB2.getWritableDatabase();
        boolean isYield2 = false;
        try {
            db.beginTransaction();
            int i2 = 0;
            while (i2 < operationNum2) {
                try {
                    contentProviderOperation = operations.get(i2);
                    Uri uri = contentProviderOperation.getUri();
                    String uid = FavorUriHelper.getUid(uri);
                    String curUid = FavorAccountUtil.getUid();
                    if (FavorUriHelper.needCheckUid(uri)) {
                        try {
                            if (!TextUtils.equals(uid, curUid)) {
                                LogUtil.w(TAG, "applyBatch: uid and cur uid is NOT MATCH!!!");
                                db.endTransaction();
                                db.endTransaction();
                                return results;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            int i3 = operationNum2;
                            FavorDbControl favorDbControl = favorDB2;
                            db.endTransaction();
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    int i4 = operationNum2;
                    FavorDbControl favorDbControl2 = favorDB2;
                    boolean z = isYield2;
                    db.endTransaction();
                    throw th;
                }
                try {
                    results[i2] = contentProviderOperation.apply(this.mProvider, results, i2);
                    shouldSleep = !isYield2 && i2 >= 10;
                    if (shouldSleep) {
                        isYield = isYield2;
                        sleepTime = 200;
                    } else {
                        isYield = isYield2;
                        sleepTime = 10;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    int i42 = operationNum2;
                    FavorDbControl favorDbControl22 = favorDB2;
                    boolean z2 = isYield2;
                    db.endTransaction();
                    throw th;
                }
                try {
                    if (!db.yieldIfContendedSafely(sleepTime) || !shouldSleep) {
                        operationNum = operationNum2;
                        favorDB = favorDB2;
                        isYield2 = isYield;
                    } else {
                        operationNum = operationNum2;
                        try {
                            favorDB = favorDB2;
                        } catch (Throwable th5) {
                            th = th5;
                            FavorDbControl favorDbControl3 = favorDB2;
                            db.endTransaction();
                            throw th;
                        }
                        try {
                            LogUtil.d(TAG, "applyBatch: isYield, sleep: " + sleepTime);
                            isYield2 = true;
                        } catch (Throwable th6) {
                            th = th6;
                            db.endTransaction();
                            throw th;
                        }
                    }
                    i2++;
                    operationNum2 = operationNum;
                    favorDB2 = favorDB;
                } catch (Throwable th7) {
                    th = th7;
                    int i5 = operationNum2;
                    FavorDbControl favorDbControl4 = favorDB2;
                    boolean z3 = isYield;
                    db.endTransaction();
                    throw th;
                }
            }
            int i6 = operationNum2;
            FavorDbControl favorDbControl5 = favorDB2;
            boolean isYield3 = isYield2;
            try {
                db.setTransactionSuccessful();
                db.endTransaction();
                return results;
            } catch (Throwable th8) {
                th = th8;
                boolean z4 = isYield3;
                db.endTransaction();
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            int i7 = operationNum2;
            FavorDbControl favorDbControl6 = favorDB2;
            db.endTransaction();
            throw th;
        }
    }

    private void checkWritePermission() {
        if (Binder.getCallingUid() != this.mProcesUid) {
            String permission = getWritePermission();
            if (!TextUtils.isEmpty(permission)) {
                Context context = getContext();
                if (!TextUtils.equals(PkgUtils.getSign(context, context.getPackageName()), PkgUtils.getSignByPermission(context, permission))) {
                    throw new SecurityException("Permission Denial: requires permission " + permission);
                }
            }
        }
    }

    private static SQLiteDatabase getReadableDatabase(String uid) {
        if (TextUtils.isEmpty(uid)) {
            uid = FavorAccountUtil.getUid();
        }
        return FavorDbControl.getInstance(uid).getReadableDatabase();
    }

    private static SQLiteDatabase getWritableDatabase(String uid) {
        if (TextUtils.isEmpty(uid)) {
            uid = FavorAccountUtil.getUid();
        }
        return FavorDbControl.getInstance(uid).getWritableDatabase();
    }

    private static void sendExpInfoToUBC(String msg) {
    }
}
