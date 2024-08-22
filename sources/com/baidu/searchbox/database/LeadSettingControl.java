package com.baidu.searchbox.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.database.DBControl;
import com.baidu.searchbox.messagedepositorydb.MessageDepositoryDBControl;
import com.baidu.searchbox.push.notification.LeadSettingInfo;
import com.baidu.searchbox.returnvisit.ReturnVisitCommandListener;
import com.baidu.searchbox.util.Utility;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LeadSettingControl extends DBControl {
    private static volatile LeadSettingControl sInstance;

    public enum LeadSettingColumn {
        _id,
        lastTime,
        source,
        title,
        message,
        imageUrl,
        intervalTime,
        btnText,
        device;
        
        static final String TABLE_NAME = "leadsetting";
    }

    protected LeadSettingControl(Context context, SQLiteOpenHelper openHelper) {
        super(context, openHelper);
    }

    public static LeadSettingControl getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LeadSettingControl.class) {
                if (sInstance == null) {
                    Context context2 = context.getApplicationContext();
                    sInstance = new LeadSettingControl(context2, DBControl.DbOpenHelper.getInstance(context2, "SearchBox.db", DBControl.DB_VERSION));
                }
            }
        }
        return sInstance;
    }

    public void updateLeadSettingInfoByJsonArray(JSONArray jsonArray) {
        long lastTime;
        JSONArray jSONArray = jsonArray;
        if (jSONArray != null) {
            int length = jsonArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    JSONObject jsonObject = jSONArray.getJSONObject(i2);
                    String title = jsonObject.getString("title");
                    String message = jsonObject.getString("message");
                    String imageUrl = jsonObject.getString("image_url");
                    long intervalTime = Long.valueOf(jsonObject.getString("interval")).longValue();
                    String btnText = jsonObject.getString(ReturnVisitCommandListener.KEY_BTN_TEXT);
                    String source = jsonObject.getString("source");
                    String device = jsonObject.getString("device");
                    LeadSettingInfo temp = getLeadSettingInfoBySource(source, device);
                    long lastTime2 = (System.currentTimeMillis() / 1000) - intervalTime;
                    if (temp != null) {
                        lastTime = temp.getLastTime();
                    } else {
                        lastTime = lastTime2;
                    }
                    String str = device;
                    insertLeadSettingInfo(new LeadSettingInfo(source, device, title, message, imageUrl, intervalTime, btnText, lastTime, ""));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public boolean insertLeadSettingInfo(final LeadSettingInfo leadSettingInfo) {
        final ContentValues values = new ContentValues();
        values.put(LeadSettingColumn.source.name(), leadSettingInfo.getSource());
        values.put(LeadSettingColumn.title.name(), leadSettingInfo.getTitle());
        values.put(LeadSettingColumn.message.name(), leadSettingInfo.getMessage());
        values.put(LeadSettingColumn.imageUrl.name(), leadSettingInfo.getImageUrl());
        values.put(LeadSettingColumn.intervalTime.name(), Long.valueOf(leadSettingInfo.getIntervalTime()));
        values.put(LeadSettingColumn.lastTime.name(), Long.valueOf(leadSettingInfo.getLastTime()));
        values.put(LeadSettingColumn.btnText.name(), leadSettingInfo.getBtnText());
        values.put(LeadSettingColumn.device.name(), leadSettingInfo.getDevice());
        SQLiteTransaction transaction = new SQLiteTransaction() {
            /* access modifiers changed from: protected */
            public boolean performTransaction(SQLiteDatabase db) {
                if (LeadSettingControl.this.getLeadSettingInfoBySource(leadSettingInfo.getSource(), leadSettingInfo.getDevice()) != null) {
                    db.update(MessageDepositoryDBControl.LEAD_SETTING_OLD_TABLE_NAME, values, "source=? and device=?", new String[]{leadSettingInfo.getSource(), leadSettingInfo.getDevice()});
                } else {
                    db.insertOrThrow(MessageDepositoryDBControl.LEAD_SETTING_OLD_TABLE_NAME, (String) null, values);
                }
                return true;
            }
        };
        if (TextUtils.isEmpty(leadSettingInfo.getSource()) || TextUtils.isEmpty(leadSettingInfo.getDevice())) {
            return false;
        }
        runTransactionAsync(transaction);
        return false;
    }

    public LeadSettingInfo getLeadSettingInfoBySource(String source, String device) {
        LeadSettingInfo leadSettingInfo = null;
        Cursor cursor = null;
        try {
            cursor = this.mOpenHelper.getReadableDatabase().query(MessageDepositoryDBControl.LEAD_SETTING_OLD_TABLE_NAME, (String[]) null, "source=? and device=?", new String[]{source, device}, (String) null, (String) null, (String) null);
            if (cursor != null && cursor.moveToFirst()) {
                String title = cursor.getString(cursor.getColumnIndex(LeadSettingColumn.title.name()));
                String imageUrl = cursor.getString(cursor.getColumnIndex(LeadSettingColumn.imageUrl.name()));
                leadSettingInfo = new LeadSettingInfo(source, device, title, cursor.getString(cursor.getColumnIndex(LeadSettingColumn.message.name())), imageUrl, cursor.getLong(cursor.getColumnIndex(LeadSettingColumn.intervalTime.name())), cursor.getString(cursor.getColumnIndex(LeadSettingColumn.btnText.name())), cursor.getLong(cursor.getColumnIndex(LeadSettingColumn.lastTime.name())), "");
            }
        } catch (SQLException e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            Utility.closeSafely((Cursor) null);
            throw th2;
        }
        Utility.closeSafely(cursor);
        return leadSettingInfo;
    }

    public static String getLeadSettingInfoSql() {
        StringBuffer sb = new StringBuffer();
        sb.append("CREATE TABLE IF NOT EXISTS ").append(MessageDepositoryDBControl.LEAD_SETTING_OLD_TABLE_NAME).append(" (").append(LeadSettingColumn._id.name()).append(" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,").append(LeadSettingColumn.lastTime.name()).append(" LONG,").append(LeadSettingColumn.source.name()).append(" TEXT NOT NULL,").append(LeadSettingColumn.title.name()).append(" TEXT,").append(LeadSettingColumn.message.name()).append(" TEXT,").append(LeadSettingColumn.imageUrl.name()).append(" TEXT,").append(LeadSettingColumn.intervalTime.name()).append(" LONG,").append(LeadSettingColumn.btnText.name()).append(" TEXT,").append(LeadSettingColumn.device.name()).append(" TEXT NOT NULL").append(");");
        return sb.toString();
    }

    public static String getDeleteLeadSettingTableSqlString() {
        StringBuffer sb = new StringBuffer();
        sb.append("DROP TABLE ");
        sb.append(MessageDepositoryDBControl.LEAD_SETTING_OLD_TABLE_NAME);
        sb.append(";");
        return sb.toString();
    }

    public void updateLastTimeBySource(String source, String device, long lastTime) {
        try {
            SQLiteDatabase db = this.mOpenHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("lastTime", Long.valueOf(lastTime));
            db.update(MessageDepositoryDBControl.LEAD_SETTING_OLD_TABLE_NAME, values, "source=? and device=?", new String[]{source, device});
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean oldLeadSettingTableExist() {
        if (DEBUG) {
            Log.d(DBControl.TAG, "进入判断原leadSetting数据表是否存在逻辑");
        }
        boolean result = false;
        Cursor cursor = null;
        try {
            cursor = DBControl.DbOpenHelper.getInstance(AppRuntime.getAppContext(), "SearchBox.db", DBControl.DB_VERSION).getReadableDatabase().rawQuery("select count(*) from sqlite_master where type ='table' and name = 'leadsetting' ", (String[]) null);
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        if (cursor != null && cursor.moveToNext() && cursor.getInt(0) > 0) {
            result = true;
        }
        if (cursor != null) {
            cursor.close();
        }
        if (DEBUG) {
            Log.d(DBControl.TAG, "原LeadSetting数据表是否存在：" + result);
        }
        return result;
    }
}
