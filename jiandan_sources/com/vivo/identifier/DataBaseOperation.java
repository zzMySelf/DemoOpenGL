package com.vivo.identifier;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
public class DataBaseOperation {
    @Keep
    public static final String AAID_FLAG = "AAID";
    @Keep
    public static final String ID_VALUE = "value";
    @Keep
    public static final String OAIDSTATUS_FLAG = "OAIDSTATUS";
    @Keep
    public static final String OAID_FLAG = "OAID";
    @Keep
    public static final String TAG = "VMS_SDK_DB";
    @Keep
    public static final int TYPE_AAID = 2;
    @Keep
    public static final int TYPE_OAID = 0;
    @Keep
    public static final int TYPE_OAIDSTATUS = 4;
    @Keep
    public static final int TYPE_VAID = 1;
    @Keep
    public static final String URI_BASE = "content://com.vivo.vms.IdProvider/IdentifierId";
    @Keep
    public static final String VAID_FLAG = "VAID";
    @Keep
    public Context mContext;

    public DataBaseOperation(Context context) {
        this.mContext = context;
    }

    @Keep
    public native String query(int i2, String str);
}
