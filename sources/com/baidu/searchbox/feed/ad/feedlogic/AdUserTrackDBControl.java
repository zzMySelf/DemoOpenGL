package com.baidu.searchbox.feed.ad.feedlogic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.ad.download.ioc.IFileDownloader;
import com.baidu.searchbox.ad.download.utils.AdDownloadUtils;
import com.baidu.searchbox.ad.util.CollectionUtils;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.ad.AdUtil;
import com.baidu.searchbox.feed.ad.model.AdDownloadApkInfo;
import com.baidu.searchbox.feed.ad.model.AdInfo;
import com.baidu.searchbox.feed.db.FeedBaseDBControl;
import com.baidu.searchbox.feed.db.SQLiteTransaction;
import com.baidu.searchbox.ugc.media.annotations.MediaQueryParam;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AdUserTrackDBControl extends FeedBaseDBControl {
    public static final String[] DB_BUSINESS_SELECT_ARGS_FOR_AD_APPEND = {AdUtil.BUSINESS_FOR_FEED_APPEND, "feedna", "jmy"};
    public static final String DB_FEED_CMATCH = "545";
    private static final String DB_NAME = "AdUserTrack.db";
    private static final int DB_VERSION = 101;
    private static final int DB_VERSION_11_16 = 100;
    private static final int DB_VERSION_11_24 = 101;
    public static final long SEVEN_DAY = 604800000;
    private static final String TAG = "AdUserTrackDBControl";
    private static volatile AdUserTrackDBControl mInstance;

    public static final class AdDownloadApkDb {
        static final String TABLE_NAME = "ad_download_apk_list";
        public static String apkBusiness = "business";
        public static String apkDownloadUri = "uri";
        public static String apkExt1 = "ext1";
        public static String apkExt2 = "ext2";
        public static String apkExt3 = "ext3";
        public static String apkExtraParam = "extraParam";
        public static String apkFinishedDownloadTime = "finishedDownloadTime";
        public static String apkIcon = "icon";
        public static String apkName = "name";
        public static String apkPackageName = "packageName";
        public static String apkState = "state";
        public static String appDownloadUrl = "downloadUrl";
        public static String appKey = "key";
        public static String keyId = "_id";
    }

    public static final class UserTrackList {
        static final String TABLE_NAME = "tracklist";
        static String cmatch = AdUtil.KEY_AD_CMATCH;
        static String id = "id";
        static String keyId = "_id";
        static String ts = "ts";
    }

    private AdUserTrackDBControl(Executor executor, SQLiteOpenHelper openHelper) {
        super(executor, openHelper);
    }

    public static AdUserTrackDBControl getInstance() {
        if (mInstance == null) {
            synchronized (AdUserTrackDBControl.class) {
                if (mInstance == null) {
                    mInstance = new AdUserTrackDBControl(Executors.newSingleThreadExecutor(Executors.defaultThreadFactory()), DbOpenHelper.getInstance(FeedRuntime.getAppContext(), DB_NAME, DB_VERSION));
                }
            }
        }
        return mInstance;
    }

    public void deleteExpirationData(final long expirationTime) {
        runTransactionAsync(new SQLiteTransaction() {
            /* access modifiers changed from: protected */
            public boolean performTransaction(SQLiteDatabase db) {
                long currentTimeMillis = System.currentTimeMillis();
                boolean committed = true;
                try {
                    db.execSQL("DELETE FROM tracklist WHERE " + UserTrackList.ts + "<=?", new Object[]{Long.valueOf(expirationTime)});
                } catch (SQLException e2) {
                    committed = false;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                return committed;
            }
        });
    }

    public HashMap<String, AdInfo> selectAllData(long expirationTime) {
        String querySql = "select * from tracklist where " + UserTrackList.ts + ">=?";
        SQLiteDatabase db = this.mOpenHelper.getReadableDatabase();
        Cursor cursor = null;
        HashMap<String, AdInfo> dataList = new HashMap<>();
        try {
            cursor = db.rawQuery(querySql, new String[]{String.valueOf(expirationTime)});
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String key = cursor.getString(1);
                    String cmatch = cursor.getString(2);
                    long timeStamp = cursor.getLong(3);
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(cmatch) && timeStamp > 0) {
                        dataList.put(key, new AdInfo(cmatch, key, timeStamp));
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e2) {
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cursor);
        return dataList;
    }

    public void insertAllData(final HashMap<String, AdInfo> hashMap) {
        if (hashMap != null && !hashMap.isEmpty()) {
            runTransactionAsync(new SQLiteTransaction() {
                /* access modifiers changed from: protected */
                public boolean performTransaction(SQLiteDatabase db) {
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean committed = true;
                    try {
                        StringBuilder insertAllSql = new StringBuilder("REPLACE INTO tracklist(" + UserTrackList.id + ", " + UserTrackList.cmatch + ", " + UserTrackList.ts + ") VALUES ");
                        for (Map.Entry<String, AdInfo> entry : hashMap.entrySet()) {
                            AdInfo info = entry.getValue();
                            insertAllSql.append("('").append(info.mIdeaId).append("','").append(info.mCMatch).append("',").append(info.mTimeStamp).append("),");
                        }
                        db.execSQL(insertAllSql.substring(0, insertAllSql.length() - 1));
                    } catch (SQLException e2) {
                        committed = false;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    return committed;
                }
            });
        }
    }

    public void deleteAllData() {
        runTransactionAsync(new SQLiteTransaction() {
            /* access modifiers changed from: protected */
            public boolean performTransaction(SQLiteDatabase db) {
                long currentTimeMillis = System.currentTimeMillis();
                boolean committed = true;
                try {
                    db.execSQL("DELETE FROM tracklist");
                } catch (SQLException e2) {
                    committed = false;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                return committed;
            }
        });
    }

    public static String getCreateAdUserTrackListTableSql() {
        return "CREATE TABLE tracklist ( " + UserTrackList.keyId + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + UserTrackList.id + " TEXT UNIQUE NOT NULL," + UserTrackList.cmatch + " TEXT NOT NULL," + UserTrackList.ts + " INTEGER NOT NULL);";
    }

    public static final class DbOpenHelper extends SQLiteOpenHelper {
        private static volatile DbOpenHelper mDbOpenHelper;

        private DbOpenHelper(Context context, String name, int version) {
            super(context, name, (SQLiteDatabase.CursorFactory) null, version);
        }

        public static DbOpenHelper getInstance(Context context, String name, int version) {
            if (mDbOpenHelper == null) {
                synchronized (DbOpenHelper.class) {
                    if (mDbOpenHelper == null) {
                        mDbOpenHelper = new DbOpenHelper(context, name, version);
                    }
                }
            }
            return mDbOpenHelper;
        }

        public void onOpen(SQLiteDatabase db) {
            super.onOpen(db);
        }

        public void onCreate(SQLiteDatabase db) {
            createAdUserTrackListTable(db);
            createAdDownloadApksListTable(db);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            createAdDownloadApksListTable(db);
        }

        private void createAdUserTrackListTable(SQLiteDatabase db) {
            AdUserTrackDBControl.getInstance();
            db.execSQL(AdUserTrackDBControl.getCreateAdUserTrackListTableSql());
        }

        private void createAdDownloadApksListTable(SQLiteDatabase db) {
            AdUserTrackDBControl.getInstance();
            db.execSQL(AdUserTrackDBControl.getCreateAdDownloadApkListTableSql());
        }
    }

    public static String getCreateAdDownloadApkListTableSql() {
        return "CREATE TABLE ad_download_apk_list ( " + AdDownloadApkDb.keyId + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + AdDownloadApkDb.appKey + " TEXT," + AdDownloadApkDb.appDownloadUrl + " TEXT," + AdDownloadApkDb.apkIcon + " TEXT," + AdDownloadApkDb.apkPackageName + " TEXT NOT NULL," + AdDownloadApkDb.apkDownloadUri + " TEXT NOT NULL," + AdDownloadApkDb.apkName + " TEXT NOT NULL," + AdDownloadApkDb.apkFinishedDownloadTime + " INTEGER NOT NULL," + AdDownloadApkDb.apkBusiness + " TEXT NOT NULL," + AdDownloadApkDb.apkExtraParam + " TEXT NOT NULL," + AdDownloadApkDb.apkState + " TEXT," + AdDownloadApkDb.apkExt1 + " TEXT ," + AdDownloadApkDb.apkExt2 + " TEXT ," + AdDownloadApkDb.apkExt3 + " TEXT );";
    }

    public void deleteExpirationApkList(final long expirationTime) {
        runTransactionAsync(new SQLiteTransaction() {
            /* access modifiers changed from: protected */
            public boolean performTransaction(SQLiteDatabase db) {
                try {
                    db.execSQL("DELETE FROM ad_download_apk_list WHERE " + AdDownloadApkDb.apkFinishedDownloadTime + "<=?", new Object[]{Long.valueOf(expirationTime)});
                    return true;
                } catch (SQLException e2) {
                    return false;
                }
            }
        });
    }

    public ArrayList<AdDownloadApkInfo> selectSuccessDownloadApkList(String business, long startTime, long endTime) {
        String querySql = "select * from ad_download_apk_list where " + AdDownloadApkDb.apkBusiness + "=? and " + AdDownloadApkDb.apkFinishedDownloadTime + ">=? and " + AdDownloadApkDb.apkFinishedDownloadTime + "<=? ORDER BY " + AdDownloadApkDb.apkFinishedDownloadTime + MediaQueryParam.SORT_DESC;
        Cursor cursor = null;
        ArrayList<AdDownloadApkInfo> selectDataList = new ArrayList<>();
        try {
            cursor = this.mOpenHelper.getReadableDatabase().rawQuery(querySql, new String[]{business, String.valueOf(startTime), String.valueOf(endTime)});
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    generateApkList(cursor, selectDataList);
                } while (cursor.moveToNext());
            }
        } catch (Exception e2) {
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cursor);
        ArrayList<AdDownloadApkInfo> availableList = new ArrayList<>();
        Iterator<AdDownloadApkInfo> it = selectDataList.iterator();
        while (it.hasNext()) {
            AdDownloadApkInfo info = it.next();
            File file = IFileDownloader.Impl.get().uriToFile(FeedRuntime.getAppContext(), Uri.parse(info.uri));
            if (file != null && AdDownloadUtils.isValidApk(file.getAbsolutePath()) && !AdDownloadUtils.isAppAvailable(FeedRuntime.getAppContext(), info.packageName)) {
                CollectionUtils.add(availableList, info);
            }
        }
        return availableList;
    }

    public ArrayList<AdDownloadApkInfo> selectSuccessDownloadApkListByAppend(long startTime, long endTime) {
        String querySql = "select * from ad_download_apk_list where " + AdDownloadApkDb.apkFinishedDownloadTime + ">=? and " + AdDownloadApkDb.apkFinishedDownloadTime + "<=? ORDER BY " + AdDownloadApkDb.apkFinishedDownloadTime + MediaQueryParam.SORT_DESC;
        Cursor cursor = null;
        ArrayList<AdDownloadApkInfo> selectDataList = new ArrayList<>();
        try {
            cursor = this.mOpenHelper.getReadableDatabase().rawQuery(querySql, new String[]{String.valueOf(startTime), String.valueOf(endTime)});
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    generateApkList(cursor, selectDataList);
                } while (cursor.moveToNext());
            }
        } catch (Exception e2) {
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cursor);
        return selectDataList;
    }

    private void generateApkList(Cursor cursor, ArrayList<AdDownloadApkInfo> dataList) {
        Cursor cursor2 = cursor;
        int id = cursor2.getInt(0);
        String key = cursor2.getString(1);
        String downloadUrl = cursor2.getString(2);
        String icon = cursor2.getString(3);
        String packageName = cursor2.getString(4);
        String uri = cursor2.getString(5);
        String name = cursor2.getString(6);
        long finishedDownloadTime = cursor2.getLong(7);
        String businessType = cursor2.getString(8);
        String extraParam = cursor2.getString(9);
        String state = cursor2.getString(10);
        String ext1 = cursor2.getString(11);
        String ext2 = cursor2.getString(12);
        String ext3 = cursor2.getString(13);
        AdDownloadApkInfo apkInfo = new AdDownloadApkInfo();
        apkInfo.id = id;
        apkInfo.key = key;
        apkInfo.downloadUrl = downloadUrl;
        apkInfo.icon = icon;
        apkInfo.packageName = packageName;
        apkInfo.uri = uri;
        apkInfo.name = name;
        apkInfo.finishedDownloadTime = finishedDownloadTime;
        apkInfo.business = businessType;
        apkInfo.extraParam = extraParam;
        apkInfo.state = state;
        apkInfo.ext1 = ext1;
        apkInfo.ext2 = ext2;
        apkInfo.ext3 = ext3;
        int i2 = id;
        CollectionUtils.add(dataList, apkInfo);
    }

    public void addApkInfo(final AdDownloadApkInfo info) {
        runTransactionAsync(new SQLiteTransaction() {
            /* access modifiers changed from: protected */
            public boolean performTransaction(SQLiteDatabase db) {
                try {
                    return db.insert("ad_download_apk_list", (String) null, AdUserTrackDBControl.this.createContentValuesFromApkItem(info)) != -1;
                } catch (Exception e2) {
                    return false;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public ContentValues createContentValuesFromApkItem(AdDownloadApkInfo info) {
        ContentValues cv = new ContentValues();
        cv.put(AdDownloadApkDb.appKey, info.key);
        cv.put(AdDownloadApkDb.appDownloadUrl, info.downloadUrl);
        cv.put(AdDownloadApkDb.apkIcon, info.icon);
        if (!TextUtils.isEmpty(info.packageName)) {
            cv.put(AdDownloadApkDb.apkPackageName, info.packageName);
        }
        if (!TextUtils.isEmpty(info.uri)) {
            cv.put(AdDownloadApkDb.apkDownloadUri, info.uri);
        }
        if (!TextUtils.isEmpty(info.name)) {
            cv.put(AdDownloadApkDb.apkName, info.name);
        }
        if (info.finishedDownloadTime > 0) {
            cv.put(AdDownloadApkDb.apkFinishedDownloadTime, Long.valueOf(info.finishedDownloadTime));
        }
        if (!TextUtils.isEmpty(info.business)) {
            cv.put(AdDownloadApkDb.apkBusiness, info.business);
        } else {
            cv.put(AdDownloadApkDb.apkBusiness, "");
        }
        if (!TextUtils.isEmpty(info.extraParam)) {
            cv.put(AdDownloadApkDb.apkExtraParam, info.extraParam);
        }
        cv.put(AdDownloadApkDb.apkState, info.state);
        cv.put(AdDownloadApkDb.apkExt1, info.ext1);
        cv.put(AdDownloadApkDb.apkExt2, info.ext2);
        cv.put(AdDownloadApkDb.apkExt3, info.ext3);
        return cv;
    }

    public void updateApkInfo(int id, String ext1, String ext2, String ext3) {
        final String str = ext1;
        final String str2 = ext2;
        final String str3 = ext3;
        final int i2 = id;
        runTransactionAsync(new SQLiteTransaction() {
            /* access modifiers changed from: protected */
            public boolean performTransaction(SQLiteDatabase db) {
                try {
                    db.update("ad_download_apk_list", AdUserTrackDBControl.this.updateContentValuesApkItem(str, str2, str3), AdDownloadApkDb.keyId + " =? ", new String[]{String.valueOf(i2)});
                    return true;
                } catch (Exception e2) {
                    return false;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public ContentValues updateContentValuesApkItem(String ext1, String ext2, String ext3) {
        ContentValues cv = new ContentValues();
        cv.put(AdDownloadApkDb.apkExt1, ext1);
        cv.put(AdDownloadApkDb.apkExt2, ext2);
        cv.put(AdDownloadApkDb.apkExt3, ext3);
        return cv;
    }
}
