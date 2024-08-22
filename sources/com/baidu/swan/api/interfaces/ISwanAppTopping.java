package com.baidu.swan.api.interfaces;

import android.database.Cursor;
import android.net.Uri;
import com.baidu.swan.apps.toppingdata.SwanToppingItemData;

public interface ISwanAppTopping {

    public interface Columns {
        public static final String APP_FRAME_TYPE = "frame_type";
        public static final String APP_ICON = "app_icon";
        public static final String APP_ID = "app_id";
        public static final String APP_NAME = "app_name";
        public static final String LIVE_SCHEME = "live_scheme";
        public static final String LIVE_START_TIME = "live_start_time";
        public static final String PAY_PROTECTED = "pay_protected";
        public static final String ROOT_SOURCE = "root_source";
        public static final String SORT_INDEX = "sort_index";
        public static final String TOPPING_TIME = "topping_time";
        public static final String _ID = "_id";
    }

    Uri buildSwanToppingDataUri();

    SwanToppingItemData obtainToppingItemFromCursor(Cursor cursor);

    void updateToppingDataFromServerAsync();
}
