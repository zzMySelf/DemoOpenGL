package com.baidu.searchbox.imagesearch.storage.db.goodcase;

import android.provider.BaseColumns;

public class BarcodeGoodcaseColumns implements BaseColumns {
    public static final String COMMAND = "command";
    public static final String IMAGEDOWNURL = "imagedownurl";
    public static final String IMAGEHEIGHT = "imageheight";
    public static final String IMAGESAVEURL = "imagesaveurl";
    public static final String IMAGEWIDTH = "imagewidth";
    public static final String ISNEW = "isnew";
    public static final String ISVISIBLE = "isvisible";
    public static final String KEY = "key";
    public static final String TABLE_NAME = "barcode_goodcase";
    public static final String WHERE_KEY = "key=?";
}
