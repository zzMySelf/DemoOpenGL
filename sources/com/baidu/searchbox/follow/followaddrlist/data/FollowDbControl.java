package com.baidu.searchbox.follow.followaddrlist.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.util.HanziToPinyin;
import com.baidu.android.util.io.Closeables;
import com.baidu.netdisk.account.storage.AccountContract;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.follow.Relation;
import com.baidu.searchbox.follow.database.BaseAccountDbControl;
import com.baidu.searchbox.follow.database.SQLiteTransaction;
import com.baidu.searchbox.follow.followaddrlist.FollowCenterUBCStaticHelper;
import com.baidu.searchbox.follow.runtime.FollowRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;

public class FollowDbControl extends BaseAccountDbControl {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int SORT_BY_LAST_UGC_TIME = 2;
    public static final int SORT_BY_PINYIN = 0;
    public static final int SORT_BY_TIME = 1;
    public static final int SORT_DEFAULT = -1;
    private QueryHandler mCompleteQueryHandler = new QueryHandler() {
        /* access modifiers changed from: package-private */
        public String[] getSelectColumns() {
            return null;
        }

        /* access modifiers changed from: package-private */
        public List<FollowItem> parseCursor(Cursor cursor) {
            Cursor cursor2 = cursor;
            List<FollowItem> followItems = new ArrayList<>();
            if (cursor2 != null) {
                try {
                    if (cursor.moveToFirst()) {
                        int idIndex = cursor2.getColumnIndex("_id");
                        int updateTypeIndex = cursor2.getColumnIndex("type");
                        int thirdIdIndex = cursor2.getColumnIndex("third_id");
                        int ukIndex = cursor2.getColumnIndex("uk");
                        int titleIndex = cursor2.getColumnIndex("title");
                        int introIndex = cursor2.getColumnIndex(AccountContract.InfosColumns.CLOUD_INTRO);
                        int logoIndex = cursor2.getColumnIndex("logo");
                        int cmdIndex = cursor2.getColumnIndex("cmd");
                        int remarkIndex = cursor2.getColumnIndex("remark");
                        int vipTypeIndex = cursor2.getColumnIndex("vipType");
                        int relationIndex = cursor2.getColumnIndex("relation");
                        int timeIndex = cursor2.getColumnIndex("time");
                        int lastUgcTimeIndex = cursor2.getColumnIndex("lastUgcTime");
                        int lastUgcContentIndex = cursor2.getColumnIndex("lastUgcContent");
                        List<FollowItem> followItems2 = followItems;
                        try {
                            int hasNewIndex = cursor2.getColumnIndex("hasNew");
                            int dataSignIndex = cursor2.getColumnIndex("dataSign");
                            int pinyinIndex = cursor2.getColumnIndex("pinyin");
                            int imStatusIndex = cursor2.getColumnIndex("imStatus");
                            int clickTimeIndex = cursor2.getColumnIndex("lastClickTime");
                            int intelligentSortIndex = cursor2.getColumnIndex(FollowCenterUBCStaticHelper.VALUE_SOURCE_INTELLIGENCE_ORDER);
                            int updateInfoIndex = cursor2.getColumnIndex("content_update_info");
                            int updateTypeIndex2 = cursor2.getColumnIndex("content_update_type");
                            while (true) {
                                FollowItem followItem = new FollowItem();
                                int updateTypeIndex3 = updateTypeIndex2;
                                String string = cursor2.getString(idIndex);
                                int idIndex2 = idIndex;
                                FollowItem followItem2 = followItem;
                                followItem2.setId(string);
                                followItem2.setType(cursor2.getString(updateTypeIndex));
                                followItem2.setThirdId(cursor2.getString(thirdIdIndex));
                                followItem2.setUk(cursor2.getString(ukIndex));
                                followItem2.setTitle(cursor2.getString(titleIndex));
                                followItem2.setIntro(cursor2.getString(introIndex));
                                followItem2.setLogo(cursor2.getString(logoIndex));
                                followItem2.setCmd(cursor2.getString(cmdIndex));
                                followItem2.setRemark(cursor2.getString(remarkIndex));
                                followItem2.setVipType(cursor2.getString(vipTypeIndex));
                                followItem2.setRelation(cursor2.getString(relationIndex));
                                int typeIndex = updateTypeIndex;
                                followItem2.setTime(cursor2.getLong(timeIndex));
                                followItem2.setLastUgcTime(cursor2.getLong(lastUgcTimeIndex));
                                followItem2.setLastUgcContent(cursor2.getString(lastUgcContentIndex));
                                int hasNewIndex2 = hasNewIndex;
                                followItem2.setHasNew(cursor2.getString(hasNewIndex2));
                                hasNewIndex = hasNewIndex2;
                                int dataSignIndex2 = dataSignIndex;
                                followItem2.setDataSign(cursor2.getString(dataSignIndex2));
                                dataSignIndex = dataSignIndex2;
                                int pinyinIndex2 = pinyinIndex;
                                followItem2.setPinyin(cursor2.getString(pinyinIndex2));
                                pinyinIndex = pinyinIndex2;
                                int imStatusIndex2 = imStatusIndex;
                                followItem2.setIMStatus(cursor2.getString(imStatusIndex2));
                                imStatusIndex = imStatusIndex2;
                                int clickTimeIndex2 = clickTimeIndex;
                                followItem2.setLastClickTime(cursor2.getString(clickTimeIndex2));
                                clickTimeIndex = clickTimeIndex2;
                                int intelligentSortIndex2 = intelligentSortIndex;
                                followItem2.setIntelligentSort(cursor2.getInt(intelligentSortIndex2));
                                intelligentSortIndex = intelligentSortIndex2;
                                int updateInfoIndex2 = updateInfoIndex;
                                followItem2.setUpdateInfo(cursor2.getString(updateInfoIndex2));
                                updateInfoIndex = updateInfoIndex2;
                                int updateTypeIndex4 = updateTypeIndex3;
                                followItem2.setUpdateType(cursor2.getString(updateTypeIndex4));
                                followItems = followItems2;
                                followItems.add(followItem2);
                                if (!cursor.moveToNext()) {
                                    break;
                                }
                                followItems2 = followItems;
                                updateTypeIndex2 = updateTypeIndex4;
                                updateTypeIndex = typeIndex;
                                idIndex = idIndex2;
                            }
                        } catch (SQLiteException e2) {
                            e = e2;
                            followItems = followItems2;
                            try {
                                Log.e("Follow_DbControl", "mCompleteQueryHandler parseCursor", e);
                                Closeables.closeSafely(cursor);
                                return followItems;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            List<FollowItem> list = followItems2;
                            Closeables.closeSafely(cursor);
                            throw th;
                        }
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    Log.e("Follow_DbControl", "mCompleteQueryHandler parseCursor", e);
                    Closeables.closeSafely(cursor);
                    return followItems;
                }
            }
            Closeables.closeSafely(cursor);
            return followItems;
        }
    };
    private QueryHandler mFetchRequestQueryHandler = new QueryHandler() {
        /* access modifiers changed from: package-private */
        public String[] getSelectColumns() {
            return new String[]{"_id", "dataSign", "lastClickTime"};
        }

        /* access modifiers changed from: package-private */
        public List<FollowItem> parseCursor(Cursor cursor) {
            List<FollowItem> followItems = new ArrayList<>();
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        int idIndex = cursor.getColumnIndex("_id");
                        int dataSignIndex = cursor.getColumnIndex("dataSign");
                        int lastClickTimeIndex = cursor.getColumnIndex("lastClickTime");
                        do {
                            FollowItem followItem = new FollowItem();
                            followItem.setId(cursor.getString(idIndex));
                            followItem.setDataSign(cursor.getString(dataSignIndex));
                            followItem.setLastClickTime(cursor.getString(lastClickTimeIndex));
                            followItems.add(followItem);
                        } while (cursor.moveToNext());
                    }
                } catch (SQLiteException e2) {
                    Log.e("Follow_DbControl", "mIMGroupSelectQueryHandler parseCursor", e2);
                } catch (Throwable th2) {
                    Closeables.closeSafely(cursor);
                    throw th2;
                }
            }
            Closeables.closeSafely(cursor);
            return followItems;
        }
    };
    private QueryHandler mIMGroupSelectQueryHandler = new QueryHandler() {
        /* access modifiers changed from: package-private */
        public String[] getSelectColumns() {
            return new String[]{"_id", "uk", "title", "logo", "remark", "vipType", "pinyin"};
        }

        /* access modifiers changed from: package-private */
        public List<FollowItem> parseCursor(Cursor cursor) {
            List<FollowItem> followItems = new ArrayList<>();
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        int idIndex = cursor.getColumnIndex("_id");
                        int ukIndex = cursor.getColumnIndex("uk");
                        int titleIndex = cursor.getColumnIndex("title");
                        int logoIndex = cursor.getColumnIndex("logo");
                        int remarkIndex = cursor.getColumnIndex("remark");
                        int vipTypeIndex = cursor.getColumnIndex("vipType");
                        int pinyinIndex = cursor.getColumnIndex("pinyin");
                        do {
                            FollowItem followItem = new FollowItem();
                            followItem.setId(cursor.getString(idIndex));
                            followItem.setUk(cursor.getString(ukIndex));
                            followItem.setTitle(cursor.getString(titleIndex));
                            followItem.setLogo(cursor.getString(logoIndex));
                            followItem.setRemark(cursor.getString(remarkIndex));
                            followItem.setVipType(cursor.getString(vipTypeIndex));
                            followItem.setPinyin(cursor.getString(pinyinIndex));
                            followItems.add(followItem);
                        } while (cursor.moveToNext());
                    }
                } catch (SQLiteException e2) {
                    Log.e("Follow_DbControl", "mIMGroupSelectQueryHandler parseCursor", e2);
                } catch (Throwable th2) {
                    Closeables.closeSafely(cursor);
                    throw th2;
                }
            }
            Closeables.closeSafely(cursor);
            return followItems;
        }
    };

    public FollowDbControl(Context context, String uid) {
        super(context, (Executor) null, uid);
    }

    public static FollowDbControl getInstance(Context context) {
        if (context == null) {
            context = FollowRuntime.getAppContext();
        }
        return new FollowDbControl(context, ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).getSession("BoxAccount_uid"));
    }

    public List<FollowItem> queryCompleteFollowItems() {
        return queryFollowItems(this.mCompleteQueryHandler, (String) null, (String[]) null, 0);
    }

    public List<FollowItem> queryFollowEachOtherItems(boolean sortByPinyin) {
        return queryFollowItems(this.mIMGroupSelectQueryHandler, "relation='" + Relation.FOLLOW_EACH_OTHER.getRelation() + "'", (String[]) null, sortByPinyin ? 0 : -1);
    }

    public List<FollowItem> queryFollowEachOtherItemsByLikeName(String name, boolean sortByPinyin) {
        String where = ("relation='" + Relation.FOLLOW_EACH_OTHER.getRelation() + "'") + " AND (" + "title like ?" + " OR " + "remark like ?" + ")";
        int i2 = 0;
        String[] selectionArgs = {"%" + name + "%", "%" + name + "%"};
        QueryHandler queryHandler = this.mIMGroupSelectQueryHandler;
        if (!sortByPinyin) {
            i2 = -1;
        }
        return queryFollowItems(queryHandler, where, selectionArgs, i2);
    }

    public List<FollowItem> queryFetchRequestFollowItems() {
        return queryFollowItems(this.mFetchRequestQueryHandler, (String) null, (String[]) null, -1);
    }

    public List<FollowItem> queryHasUkFollowItems(boolean sortByPinyin) {
        return queryHasUkFollowItems(sortByPinyin, false);
    }

    public List<FollowItem> queryHasUkFollowItems(boolean sortByPinyin, boolean queryIMEnabled) {
        String where = "uk is not null AND uk<>''";
        if (queryIMEnabled) {
            where = where + " AND " + "imStatus='1'";
        }
        return queryFollowItems(this.mCompleteQueryHandler, where, (String[]) null, sortByPinyin ? 0 : -1);
    }

    public FollowItem getFollowItemByUk(String uk) {
        List<FollowItem> followItems = queryFollowItems(this.mCompleteQueryHandler, "uk='" + uk + "'", (String[]) null, -1);
        if (followItems == null || followItems.size() <= 0) {
            return null;
        }
        return followItems.get(0);
    }

    private List<FollowItem> queryFollowItems(QueryHandler queryHandler, String selection, String[] selectionArgs, int sortType) {
        String sortBy;
        switch (sortType) {
            case -1:
                sortBy = null;
                break;
            case 1:
                sortBy = "time DESC";
                break;
            case 2:
                sortBy = "lastUgcTime DESC";
                break;
            default:
                sortBy = "pinyin ASC, time DESC";
                break;
        }
        try {
            return queryHandler.parseCursor(this.mOpenHelper.getReadableDatabase().query("follow_list", queryHandler.getSelectColumns(), selection, selectionArgs, (String) null, (String) null, sortBy));
        } catch (Exception e2) {
            if (!DEBUG) {
                return null;
            }
            Log.e("Follow_DbControl", "queryFollowItems exception", e2);
            return null;
        }
    }

    public boolean updateFollowDb(final String syncMethod, final List<FollowItem> modifyList, final List<String> deleteList) {
        return runTransactionSyncWithReturn(new SQLiteTransaction() {
            /* access modifiers changed from: protected */
            public boolean performTransaction(SQLiteDatabase db) {
                String str;
                String str2;
                String str3;
                long j2;
                String str4;
                long j3;
                FollowItem followItem;
                SQLiteDatabase sQLiteDatabase = db;
                if ("all".equalsIgnoreCase(syncMethod)) {
                    int count = 0;
                    List list = modifyList;
                    if (list == null || list.size() <= 0) {
                        sQLiteDatabase.delete("follow_list", (String) null, (String[]) null);
                    } else {
                        Map<String, String> id2ClickTime = FollowDbControl.this.getId2ClickTimeMap(sQLiteDatabase);
                        sQLiteDatabase.delete("follow_list", (String) null, (String[]) null);
                        for (FollowItem followItem2 : modifyList) {
                            String lastClickTime = id2ClickTime.get(followItem2.getId());
                            if (!TextUtils.isEmpty(lastClickTime)) {
                                followItem2.setLastClickTime(lastClickTime);
                            }
                            if (sQLiteDatabase.insert("follow_list", (String) null, FollowDbControl.this.getContentValues(followItem2)) != -1) {
                                count++;
                            }
                        }
                    }
                    List list2 = modifyList;
                    if (list2 == null || count == list2.size()) {
                        return true;
                    }
                    return false;
                } else if (!FollowListData.SYNC_METHOD_DELTA.equalsIgnoreCase(syncMethod)) {
                    return false;
                } else {
                    int count2 = 0;
                    boolean success = true;
                    List list3 = modifyList;
                    String str5 = "Follow_DbControl";
                    String str6 = "'";
                    String str7 = "_id='";
                    if (list3 == null || list3.size() <= 0) {
                        str2 = str7;
                        str = str6;
                        str3 = str5;
                    } else {
                        Map<String, String> id2ClickTime2 = FollowDbControl.this.getId2ClickTimeMap(sQLiteDatabase);
                        int count3 = 0;
                        for (FollowItem followItem3 : modifyList) {
                            String where = str7 + followItem3.getId() + str6;
                            FollowItem followItem4 = followItem3;
                            Map<String, String> id2ClickTime3 = id2ClickTime2;
                            String str8 = str7;
                            String str9 = str6;
                            String str10 = str5;
                            Cursor cursor = db.query("follow_list", new String[]{"_id"}, where, (String[]) null, (String) null, (String) null, (String) null);
                            if (cursor != null) {
                                try {
                                    if (cursor.getCount() > 0) {
                                        String lastClickTime2 = id2ClickTime3.get(followItem4.getId());
                                        if (!TextUtils.isEmpty(lastClickTime2)) {
                                            followItem = followItem4;
                                            try {
                                                followItem.setLastClickTime(lastClickTime2);
                                            } catch (SQLiteException e2) {
                                                e = e2;
                                                String str11 = where;
                                                j2 = -1;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                String str12 = where;
                                                Closeables.closeSafely(cursor);
                                                throw th;
                                            }
                                        } else {
                                            followItem = followItem4;
                                        }
                                        try {
                                            try {
                                                if (sQLiteDatabase.update("follow_list", FollowDbControl.this.getContentValues(followItem), where, (String[]) null) > 0) {
                                                    count3++;
                                                }
                                                j3 = -1;
                                                Closeables.closeSafely(cursor);
                                                str4 = str10;
                                            } catch (SQLiteException e3) {
                                                e = e3;
                                                j2 = -1;
                                                str4 = str10;
                                                try {
                                                    Log.e(str4, "updateFollowDb", e);
                                                    Closeables.closeSafely(cursor);
                                                    str7 = str8;
                                                    long j4 = j2;
                                                    str5 = str4;
                                                    id2ClickTime2 = id2ClickTime3;
                                                    str6 = str9;
                                                    long j5 = j4;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    Closeables.closeSafely(cursor);
                                                    throw th;
                                                }
                                            }
                                        } catch (SQLiteException e4) {
                                            e = e4;
                                            String str13 = where;
                                            j2 = -1;
                                            str4 = str10;
                                            Log.e(str4, "updateFollowDb", e);
                                            Closeables.closeSafely(cursor);
                                            str7 = str8;
                                            long j42 = j2;
                                            str5 = str4;
                                            id2ClickTime2 = id2ClickTime3;
                                            str6 = str9;
                                            long j52 = j42;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            String str14 = where;
                                            Closeables.closeSafely(cursor);
                                            throw th;
                                        }
                                        str7 = str8;
                                        long j422 = j2;
                                        str5 = str4;
                                        id2ClickTime2 = id2ClickTime3;
                                        str6 = str9;
                                        long j522 = j422;
                                    }
                                } catch (SQLiteException e5) {
                                    e = e5;
                                    String str15 = where;
                                    FollowItem followItem5 = followItem4;
                                    j2 = -1;
                                    str4 = str10;
                                    Log.e(str4, "updateFollowDb", e);
                                    Closeables.closeSafely(cursor);
                                    str7 = str8;
                                    long j4222 = j2;
                                    str5 = str4;
                                    id2ClickTime2 = id2ClickTime3;
                                    str6 = str9;
                                    long j5222 = j4222;
                                } catch (Throwable th5) {
                                    th = th5;
                                    String str16 = where;
                                    FollowItem followItem6 = followItem4;
                                    Closeables.closeSafely(cursor);
                                    throw th;
                                }
                            }
                            j3 = -1;
                            if (sQLiteDatabase.insert("follow_list", (String) null, FollowDbControl.this.getContentValues(followItem4)) != -1) {
                                count3++;
                            }
                            Closeables.closeSafely(cursor);
                            str4 = str10;
                            str7 = str8;
                            long j42222 = j2;
                            str5 = str4;
                            id2ClickTime2 = id2ClickTime3;
                            str6 = str9;
                            long j52222 = j42222;
                        }
                        str2 = str7;
                        str = str6;
                        str3 = str5;
                        count2 = count3;
                    }
                    List list4 = modifyList;
                    if (list4 != null && count2 < list4.size()) {
                        success = false;
                    }
                    List<String> list5 = deleteList;
                    if (list5 != null) {
                        for (String id : list5) {
                            String str17 = str;
                            int deleteRet = sQLiteDatabase.delete("follow_list", str2 + id + str17, (String[]) null);
                            if (FollowDbControl.DEBUG) {
                                Log.d(str3, "deleteRet: " + deleteRet);
                            }
                            str = str17;
                        }
                    }
                    return success;
                }
            }
        });
    }

    public void updateItemByUk(final ContentValues cv, final String uk, boolean sync) {
        SQLiteTransaction transaction = new SQLiteTransaction() {
            /* access modifiers changed from: protected */
            public boolean performTransaction(SQLiteDatabase db) {
                if (((long) db.update("follow_list", cv, "uk = ? ", new String[]{uk})) > 0) {
                    return true;
                }
                return false;
            }
        };
        if (sync) {
            runTransactionSync(transaction);
        } else {
            runTransactionAsync(transaction);
        }
    }

    public void updateItemById(final ContentValues cv, final String id, boolean sync) {
        SQLiteTransaction transaction = new SQLiteTransaction() {
            /* access modifiers changed from: protected */
            public boolean performTransaction(SQLiteDatabase db) {
                if (((long) db.update("follow_list", cv, "_id = ? ", new String[]{id})) > 0) {
                    return true;
                }
                return false;
            }
        };
        if (sync) {
            runTransactionSync(transaction);
        } else {
            runTransactionAsync(transaction);
        }
    }

    public void updateRemarkByUk(String uk, String remark, boolean sync) {
        FollowItem followItem;
        if (!TextUtils.isEmpty(uk) && !TextUtils.isEmpty(uk) && (followItem = getFollowItemByUk(uk)) != null) {
            String pinyin = getPinyinFromName(remark, followItem.getTitle());
            ContentValues cv = new ContentValues();
            cv.put("remark", remark);
            cv.put("pinyin", pinyin);
            updateItemByUk(cv, uk, sync);
        }
    }

    public void updateRelationByUk(String uk, Relation relation, boolean sync) {
        if (!TextUtils.isEmpty(uk) && !TextUtils.isEmpty(uk)) {
            ContentValues cv = new ContentValues();
            cv.put("relation", relation.getRelation());
            updateItemByUk(cv, uk, sync);
        }
    }

    public void clickItem(String id, long lastClickTime) {
        if (!TextUtils.isEmpty(id)) {
            ContentValues cv = new ContentValues();
            cv.put("lastClickTime", lastClickTime + "");
            cv.put("hasNew", "0");
            updateItemById(cv, id, false);
        }
    }

    public void deleteItem(final FollowItem followItem) {
        runTransactionAsync(new SQLiteTransaction() {
            /* access modifiers changed from: protected */
            public boolean performTransaction(SQLiteDatabase db) {
                db.delete("follow_list", "_id='" + followItem.getId() + "'", (String[]) null);
                return true;
            }
        });
    }

    public void insertItem(final FollowItem followItem) {
        runTransactionAsync(new SQLiteTransaction() {
            /* access modifiers changed from: protected */
            public boolean performTransaction(SQLiteDatabase db) {
                db.insert("follow_list", (String) null, FollowDbControl.this.getContentValues(followItem));
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public ContentValues getContentValues(FollowItem followItem) {
        ContentValues cv = new ContentValues();
        cv.put("_id", followItem.getId());
        cv.put("type", followItem.getType());
        cv.put("third_id", followItem.getThirdId());
        cv.put("uk", followItem.getUk());
        cv.put("title", followItem.getTitle());
        cv.put(AccountContract.InfosColumns.CLOUD_INTRO, followItem.getIntro());
        cv.put("logo", followItem.getLogo());
        cv.put("cmd", followItem.getCmd());
        cv.put("remark", followItem.getRemark());
        cv.put("vipType", followItem.getVipType());
        cv.put("relation", followItem.getRelation());
        cv.put("time", Long.valueOf(followItem.getTime()));
        cv.put("lastUgcTime", Long.valueOf(followItem.getLastUgcTime()));
        cv.put("lastUgcContent", followItem.getLastUgcContent());
        cv.put("hasNew", followItem.getHasNew());
        cv.put("dataSign", followItem.getDataSign());
        String pinyin = followItem.getPinyin();
        if (TextUtils.isEmpty(pinyin)) {
            pinyin = getPinyinFromName(followItem.getRemark(), followItem.getTitle());
        }
        cv.put("pinyin", pinyin);
        cv.put("imStatus", followItem.getIMStatus());
        String lastClickTime = followItem.getLastClickTime();
        if (TextUtils.isEmpty(lastClickTime)) {
            cv.put("lastClickTime", "0");
        } else {
            cv.put("lastClickTime", lastClickTime);
        }
        cv.put(FollowCenterUBCStaticHelper.VALUE_SOURCE_INTELLIGENCE_ORDER, Integer.valueOf(followItem.getIntelligentSort()));
        cv.put("content_update_info", followItem.getUpdateInfo());
        cv.put("content_update_type", followItem.getUpdateType());
        return cv;
    }

    abstract class QueryHandler {
        /* access modifiers changed from: package-private */
        public abstract String[] getSelectColumns();

        /* access modifiers changed from: package-private */
        public abstract List<FollowItem> parseCursor(Cursor cursor);

        QueryHandler() {
        }
    }

    /* access modifiers changed from: private */
    public Map<String, String> getId2ClickTimeMap(SQLiteDatabase db) {
        Map<String, String> result = new HashMap<>();
        Cursor cursor = null;
        try {
            cursor = db.query("follow_list", new String[]{"_id", "lastClickTime"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (cursor != null && cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex("_id");
                int lastClickTimeIndex = cursor.getColumnIndex("lastClickTime");
                do {
                    result.put(cursor.getString(idIndex), cursor.getString(lastClickTimeIndex));
                } while (cursor.moveToNext());
            }
        } catch (SQLiteException e2) {
            Log.e("Follow_DbControl", "getId2ClickTimeMap parseCursor", e2);
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cursor);
        return result;
    }

    public static String getCreateTableSql() {
        return "CREATE TABLE IF NOT EXISTS follow_list (_id TEXT PRIMARY KEY,type TEXT,third_id TEXT,uk TEXT,title TEXT,intro TEXT,logo TEXT,cmd TEXT,remark TEXT,vipType TEXT,relation TEXT,time INTEGER,lastUgcTime INTEGER,lastUgcContent TEXT,hasNew TEXT,dataSign TEXT,imStatus TEXT,pinyin TEXT,lastClickTime TEXT,intelligent_sort INTEGER,content_update_info TEXT,content_update_type TEXT)";
    }

    public static void alterTableForIMStatus(SQLiteDatabase db) {
        try {
            db.execSQL(getTableAddColumnSql("follow_list", "imStatus", "TEXT", (String) null));
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e("Follow_DbControl", "alterTableForVipType exception:" + e2);
            }
        }
    }

    public static void alterTableForIntelligenceSort(SQLiteDatabase db) {
        if (db != null) {
            try {
                db.execSQL(getTableAddColumnSql("follow_list", FollowCenterUBCStaticHelper.VALUE_SOURCE_INTELLIGENCE_ORDER, "INTEGER", (String) null));
                db.execSQL(getTableAddColumnSql("follow_list", "content_update_info", "TEXT", (String) null));
                db.execSQL(getTableAddColumnSql("follow_list", "content_update_type", "TEXT", (String) null));
            } catch (Exception e2) {
                if (DEBUG) {
                    Log.e("Follow_DbControl", "alterTableForIntelligenceSort exception:" + e2);
                }
            }
        }
    }

    class Table {
        private static final String COLUMN_CMD = "cmd";
        private static final String COLUMN_CONTENT_UPDATE_INFO = "content_update_info";
        private static final String COLUMN_CONTENT_UPDATE_TYPE = "content_update_type";
        private static final String COLUMN_DATA_SIGN = "dataSign";
        private static final String COLUMN_HAS_NEW = "hasNew";
        private static final String COLUMN_ID = "_id";
        private static final String COLUMN_IM_STATUS = "imStatus";
        private static final String COLUMN_INTELLIGENT_SORT = "intelligent_sort";
        private static final String COLUMN_INTRO = "intro";
        private static final String COLUMN_LAST_CLICK_TIME = "lastClickTime";
        private static final String COLUMN_LAST_UGC_CONTENT = "lastUgcContent";
        private static final String COLUMN_LAST_UGC_TIME = "lastUgcTime";
        private static final String COLUMN_LOGO = "logo";
        private static final String COLUMN_PINYIN = "pinyin";
        private static final String COLUMN_RELATION = "relation";
        private static final String COLUMN_REMARK = "remark";
        private static final String COLUMN_THIRD_ID = "third_id";
        private static final String COLUMN_TIME = "time";
        private static final String COLUMN_TITLE = "title";
        private static final String COLUMN_TYPE = "type";
        private static final String COLUMN_UK = "uk";
        private static final String COLUMN_VIP_TYPE = "vipType";
        private static final String TABLE_NAME = "follow_list";

        Table() {
        }
    }

    private String getPinyinFromName(String remark, String title) {
        String pinyin = "";
        Iterator<HanziToPinyin.Token> it = HanziToPinyin.getInstance().get(!TextUtils.isEmpty(remark) ? remark : title).iterator();
        while (it.hasNext()) {
            pinyin = pinyin + it.next().target.charAt(0);
        }
        String pinyin2 = pinyin.toUpperCase(Locale.getDefault());
        if (DEBUG) {
            Log.d("Follow_DbControl", "pinyin is :" + pinyin2);
        }
        return pinyin2;
    }
}
