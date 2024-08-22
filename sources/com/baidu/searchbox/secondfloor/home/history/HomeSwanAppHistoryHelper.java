package com.baidu.searchbox.secondfloor.home.history;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.searchbox.secondfloor.home.model.HistoryItemInfo;
import java.util.ArrayList;

public class HomeSwanAppHistoryHelper {
    public static ArrayList<HistoryItemInfo> queryHistoryListFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        }
        ArrayList<HistoryItemInfo> itemInfoList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                HistoryItemInfo info = queryHistoryItemFromCursor(cursor);
                if (info != null && !TextUtils.isEmpty(info.img) && !TextUtils.isEmpty(info.title) && !TextUtils.isEmpty(info.uKey)) {
                    itemInfoList.add(info);
                }
            } while (cursor.moveToNext());
        }
        return itemInfoList;
    }

    private static HistoryItemInfo queryHistoryItemFromCursor(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        HistoryItemInfo history = new HistoryItemInfo();
        try {
            history.uKey = cursor.getString(cursor.getColumnIndex("app_id"));
            history.title = cursor.getString(cursor.getColumnIndex("name"));
            history.img = cursor.getString(cursor.getColumnIndex("icon_url"));
            String appInfoType = "1";
            switch (cursor.getInt(cursor.getColumnIndex("type"))) {
                case 1:
                    appInfoType = "0";
                    break;
                case 2:
                    appInfoType = "2";
                    break;
                case 3:
                    appInfoType = "3";
                    break;
            }
            history.dataType = appInfoType;
            history.extra1 = "";
            history.appendSwanExtra2Value("app_frame_type", cursor.getString(cursor.getColumnIndex("app_category")));
            return history;
        } catch (Exception e2) {
            return null;
        }
    }
}
