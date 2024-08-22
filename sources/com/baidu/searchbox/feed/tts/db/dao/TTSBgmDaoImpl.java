package com.baidu.searchbox.feed.tts.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.feed.tts.db.contract.TTSBgmTable;
import com.baidu.searchbox.feed.tts.entity.TTSBgmEntity;
import com.baidu.searchbox.feed.tts.model.TTSBgm;
import java.util.ArrayList;
import java.util.List;

public class TTSBgmDaoImpl extends TTSDbDaoAbs<TTSBgm> {
    public long insertItem(TTSBgm item) {
        ContentValues values = new ContentValues();
        values.put("md5", item.getMd5());
        values.put("url", item.getUrl());
        values.put("name", item.getName());
        values.put("position", Integer.valueOf(item.getIndex()));
        values.put("state", Integer.valueOf(item.getState()));
        values.put("local_path", item.getLocalPath());
        values.put("version", Integer.valueOf(item.getVersion()));
        return this.database.insert(TTSBgmTable.TABLE_NAME, (String) null, values);
    }

    public List<TTSBgm> getAllItems() {
        List<TTSBgm> ttsBgmList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = this.database.rawQuery(TTSBgmTable.SQL_SELECT_ALL_BGM, (String[]) null);
            if (cursor.moveToFirst()) {
                do {
                    TTSBgmEntity bgmEntity = new TTSBgmEntity();
                    bgmEntity.setUrl(cursor.getString(cursor.getColumnIndex("url")));
                    bgmEntity.setMd5(cursor.getString(cursor.getColumnIndex("md5")));
                    bgmEntity.setName(cursor.getString(cursor.getColumnIndex("name")));
                    bgmEntity.setIndex(cursor.getInt(cursor.getColumnIndex("position")));
                    bgmEntity.setLocalPath(cursor.getString(cursor.getColumnIndex("local_path")));
                    bgmEntity.setState(cursor.getInt(cursor.getColumnIndex("state")));
                    bgmEntity.setVersion(cursor.getInt(cursor.getColumnIndex("version")));
                    ttsBgmList.add(bgmEntity);
                } while (cursor.moveToNext());
            }
        } catch (Exception e2) {
            if (TTSRuntime.DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cursor);
        return ttsBgmList;
    }

    public int updateItem(TTSBgm item) {
        ContentValues values = new ContentValues();
        values.put("state", Integer.valueOf(item.getState()));
        values.put("local_path", item.getLocalPath());
        return this.database.update(TTSBgmTable.TABLE_NAME, values, "md5 = ?", new String[]{item.getMd5()});
    }

    public void clearTTSBgmTable() {
        this.database.execSQL(TTSBgmTable.SQL_CLEAR_TABLE);
    }
}
