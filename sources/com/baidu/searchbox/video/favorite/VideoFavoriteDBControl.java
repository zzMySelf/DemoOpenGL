package com.baidu.searchbox.video.favorite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.database.DBControl;
import com.baidu.searchbox.database.SQLiteTransaction;
import com.baidu.searchbox.util.Utility;
import com.baidu.searchbox.video.favorite.VideoLiveFavoriteActivity;
import java.util.ArrayList;
import java.util.List;

public class VideoFavoriteDBControl extends DBControl {
    private static volatile VideoFavoriteDBControl sInstance;

    public enum VideoFavoriteTable {
        _id,
        videoid,
        title,
        url,
        sourcetype,
        playprogress,
        videocurlength,
        videototallength,
        isfinish,
        endplaytime,
        videoActors,
        updateEpisodes,
        playerEpisodes,
        updateTimer,
        iconUrl,
        totalEpisodes,
        isUpdate,
        favoriteType;
        
        public static final String TABLE_NAME = "videoplayfavorite";
    }

    protected VideoFavoriteDBControl(Context context, SQLiteOpenHelper openHelper) {
        super(context, openHelper);
    }

    public static VideoFavoriteDBControl getInstance(Context context) {
        if (sInstance == null) {
            synchronized (VideoFavoriteDBControl.class) {
                if (sInstance == null) {
                    Context context2 = context.getApplicationContext();
                    sInstance = new VideoFavoriteDBControl(context2, DBControl.DbOpenHelper.getInstance(context2, "SearchBox.db", DBControl.DB_VERSION));
                }
            }
        }
        return sInstance;
    }

    public void addFavoriteItem(final VideoFavoriteItemInfo info, boolean sync) {
        Cursor cursor = null;
        try {
            cursor = getFavoriteCursorById(info.getId());
            if (cursor == null || cursor.getCount() == 0) {
                SQLiteTransaction transaction = new SQLiteTransaction() {
                    /* access modifiers changed from: protected */
                    public boolean performTransaction(SQLiteDatabase db) {
                        try {
                            db.insert("videoplayfavorite", (String) null, VideoFavoriteDBControl.this.createContentValuesFromFavoriteItem(info));
                            return true;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return true;
                        }
                    }
                };
                if (sync) {
                    runTransactionSync(transaction);
                } else {
                    runTransactionAsync(transaction);
                }
            } else {
                updateVideoFavoriteItem(info);
            }
        } finally {
            Utility.closeSafely(cursor);
        }
    }

    /* access modifiers changed from: private */
    public ContentValues createContentValuesFromFavoriteItem(VideoFavoriteItemInfo info) {
        ContentValues cv = new ContentValues();
        if (!TextUtils.isEmpty(info.getId())) {
            cv.put(VideoFavoriteTable.videoid.name(), info.getId());
        }
        if (!TextUtils.isEmpty(info.getPlayProgress())) {
            cv.put(VideoFavoriteTable.playprogress.name(), info.getPlayProgress());
        }
        if (info.getSourceType() > 0) {
            cv.put(VideoFavoriteTable.sourcetype.name(), Integer.valueOf(info.getSourceType()));
        }
        if (!TextUtils.isEmpty(info.getUrl())) {
            cv.put(VideoFavoriteTable.url.name(), info.getUrl());
        }
        if (!TextUtils.isEmpty(info.getTitle())) {
            cv.put(VideoFavoriteTable.title.name(), info.getTitle());
        }
        if (info.getEndPlayTime() > 0) {
            cv.put(VideoFavoriteTable.endplaytime.name(), Long.valueOf(info.getEndPlayTime()));
        }
        if (!TextUtils.isEmpty(info.getVideoCurLength())) {
            cv.put(VideoFavoriteTable.videocurlength.name(), info.getVideoCurLength());
        }
        if (!TextUtils.isEmpty(info.getVideoTotalLength())) {
            cv.put(VideoFavoriteTable.videototallength.name(), info.getVideoTotalLength());
        }
        if (info.getTotalEpisodes() > 0) {
            cv.put(VideoFavoriteTable.totalEpisodes.name(), Integer.valueOf(info.getTotalEpisodes()));
        }
        if (info.getUpdateEpisodes() > 0) {
            cv.put(VideoFavoriteTable.updateEpisodes.name(), Integer.valueOf(info.getUpdateEpisodes()));
        }
        if (info.getPlayerEpisodes() > 0) {
            cv.put(VideoFavoriteTable.playerEpisodes.name(), Integer.valueOf(info.getPlayerEpisodes()));
        }
        if (info.getUpdateTimer() > 0) {
            cv.put(VideoFavoriteTable.updateTimer.name(), Long.valueOf(info.getUpdateTimer()));
        }
        if (!TextUtils.isEmpty(info.getVideoActors())) {
            cv.put(VideoFavoriteTable.videoActors.name(), info.getVideoActors());
        }
        if (!TextUtils.isEmpty(info.getIconUrl())) {
            cv.put(VideoFavoriteTable.iconUrl.name(), info.getIconUrl());
        }
        cv.put(VideoFavoriteTable.isUpdate.name(), Integer.valueOf(info.getIsUpdate()));
        cv.put(VideoFavoriteTable.favoriteType.name(), Integer.valueOf(info.getFavoriteType()));
        cv.put(VideoFavoriteTable.isfinish.name(), Integer.valueOf(info.getIsFinish()));
        return cv;
    }

    public VideoFavoriteItemInfo getFavoriteById(String id) {
        Cursor cursor = null;
        VideoFavoriteItemInfo info = null;
        try {
            cursor = getFavoriteCursorById(id);
            List<VideoFavoriteItemInfo> items = VideoFavoriteItemInfo.getVideoFavoriteItemsFromCursor(cursor);
            if (items != null && items.size() > 0) {
                info = items.get(0);
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th2) {
            Utility.closeSafely((Cursor) null);
            throw th2;
        }
        Utility.closeSafely(cursor);
        return info;
    }

    public List<VideoFavoriteItemInfo> getFavoriteByIds(String... ids) {
        Cursor cursor = null;
        List<VideoFavoriteItemInfo> items = null;
        try {
            cursor = getFavoriteCursorById(ids);
            items = VideoFavoriteItemInfo.getVideoFavoriteItemsFromCursor(cursor);
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th2) {
            Utility.closeSafely((Cursor) null);
            throw th2;
        }
        Utility.closeSafely(cursor);
        return items;
    }

    public List<VideoFavoriteItemInfo> getAllVideoFavoriteInfos() {
        List<VideoFavoriteItemInfo> resultList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = getAllVideoFavorite();
            addFavoriteCursorDataToList(cursor, resultList);
        } catch (SQLiteFullException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th2) {
            Closeables.closeSafely(cursor);
            throw th2;
        }
        Closeables.closeSafely(cursor);
        return resultList;
    }

    public List<VideoFavoriteItemInfo> getAllLiveFavoriteInfos() {
        List<VideoFavoriteItemInfo> resultList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = getAllLiveFavorite();
            addFavoriteCursorDataToList(cursor, resultList);
        } catch (SQLiteFullException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th2) {
            Closeables.closeSafely(cursor);
            throw th2;
        }
        Closeables.closeSafely(cursor);
        return resultList;
    }

    private void addFavoriteCursorDataToList(Cursor cursor, List<VideoFavoriteItemInfo> resultList) {
        try {
            List<VideoFavoriteItemInfo> items = VideoFavoriteItemInfo.getVideoFavoriteItemsFromCursor(cursor);
            if (items != null) {
                resultList.addAll(items);
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private Cursor getFavoriteCursorById(String... ids) {
        try {
            return this.mOpenHelper.getReadableDatabase().rawQuery("select * from videoplayfavorite where " + VideoFavoriteTable.videoid.name() + " in (" + getInArgs(ids) + ")", (String[]) null);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getInArgs(String... ids) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < ids.length; i2++) {
            if (i2 > 0) {
                sb.append(",");
            }
            sb.append(ids[i2]);
        }
        return sb.toString();
    }

    public Cursor getAllVideoFavorite() {
        try {
            return this.mOpenHelper.getReadableDatabase().rawQuery(createSelectAllFavoriteTypeSql(VideoFavoriteType.VIDEO.value()), (String[]) null);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Cursor getAllLiveFavorite() {
        try {
            return this.mOpenHelper.getReadableDatabase().rawQuery(createSelectAllFavoriteTypeSql(VideoFavoriteType.LIVE.value()), (String[]) null);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private String createSelectAllFavoriteTypeSql(int type) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ");
        sb.append("videoplayfavorite");
        sb.append(" WHERE ");
        sb.append(VideoFavoriteTable.favoriteType.name());
        sb.append("='");
        sb.append(type);
        sb.append("'");
        return sb.toString();
    }

    public void updateVideoFavoriteItem(final VideoFavoriteItemInfo info) {
        runTransactionAsync(new SQLiteTransaction() {
            /* access modifiers changed from: protected */
            public boolean performTransaction(SQLiteDatabase db) {
                try {
                    db.update("videoplayfavorite", VideoFavoriteDBControl.this.createContentValuesFromFavoriteItem(info), VideoFavoriteTable.videoid.name() + " =? ", new String[]{String.valueOf(info.getId())});
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return true;
            }
        });
    }

    public void delFavoriteItem(String... ids) {
        delFavoriteItem((VideoLiveFavoriteActivity.TransFinishedListener) null, ids);
    }

    public void delFavoriteItem(final VideoLiveFavoriteActivity.TransFinishedListener listener, final String... ids) {
        runTransactionAsync(new SQLiteTransaction() {
            /* access modifiers changed from: protected */
            public boolean performTransaction(SQLiteDatabase db) {
                try {
                    db.delete("videoplayfavorite", VideoFavoriteTable.videoid.name() + " in (" + VideoFavoriteDBControl.this.getInArgs(ids) + ")", (String[]) null);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return true;
                }
            }
        }, new DBControl.OnTransactionFinishedListener() {
            public void onFinished() {
                VideoLiveFavoriteActivity.TransFinishedListener transFinishedListener = listener;
                if (transFinishedListener != null) {
                    transFinishedListener.onFinished();
                }
            }
        });
    }

    public void delAllFavoriteItems() {
        runTransactionAsync(new SQLiteTransaction() {
            /* access modifiers changed from: protected */
            public boolean performTransaction(SQLiteDatabase db) {
                try {
                    db.delete("videoplayfavorite", (String) null, (String[]) null);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return true;
                }
            }
        });
    }

    public enum VideoFavoriteType {
        VIDEO(0),
        LIVE(1);
        
        private int mValue;

        private VideoFavoriteType(int value) {
            this.mValue = value;
        }

        public int value() {
            return this.mValue;
        }
    }

    public String getCreateVideoFavoriteTableSql() {
        return "CREATE TABLE videoplayfavorite (" + VideoFavoriteTable._id + " INTEGER PRIMARY KEY," + VideoFavoriteTable.videoid + " TEXT," + VideoFavoriteTable.playprogress + " TEXT," + VideoFavoriteTable.sourcetype + " INTEGER," + VideoFavoriteTable.endplaytime + " LONG," + VideoFavoriteTable.title + " TEXT," + VideoFavoriteTable.url + " TEXT," + VideoFavoriteTable.videocurlength + " TEXT," + VideoFavoriteTable.videototallength + " TEXT," + VideoFavoriteTable.isfinish + " INTEGER DEFAULT 0," + VideoFavoriteTable.videoActors + " TEXT," + VideoFavoriteTable.updateEpisodes + " INTEGER," + VideoFavoriteTable.playerEpisodes + " INTEGER," + VideoFavoriteTable.updateTimer + " LONG," + VideoFavoriteTable.iconUrl + " TEXT," + VideoFavoriteTable.totalEpisodes + " INTEGER," + VideoFavoriteTable.isUpdate + " INTEGER," + VideoFavoriteTable.favoriteType + " INTEGER DEFAULT 0);";
    }

    public String getVideoFavoriteAddColumnSql(String column, String type, String defaultValue) {
        StringBuffer sb = new StringBuffer();
        sb.append("ALTER TABLE ");
        sb.append("videoplayfavorite");
        sb.append(" ADD ");
        sb.append(column);
        sb.append(" ");
        sb.append(type);
        if (!TextUtils.isEmpty(defaultValue)) {
            sb.append("  DEFAULT  ").append(defaultValue);
        }
        return sb.toString();
    }

    public String getAddFavoriteTypeColumnSql() {
        return getVideoFavoriteAddColumnSql(VideoFavoriteTable.favoriteType.name(), "INTEGER", "0");
    }

    public String getisFinishColumnSql() {
        return getVideoFavoriteAddColumnSql(VideoFavoriteTable.isfinish.name(), "INTEGER", "0");
    }
}
