package com.vivo.identifier;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Keep;

@Keep
public class IdentifierIdClient {
    @Keep
    public static final String AAID_FLAG = "AAID";
    @Keep
    public static final String ID_APPID = "appid";
    @Keep
    public static final String ID_TYPE = "type";
    @Keep
    public static final String OAID_FLAG = "OAID";
    @Keep
    public static final String SYS_IDENTIFIERID = "persist.sys.identifierid";
    @Keep
    public static final String SYS_IDENTIFIERID_SUPPORTED = "persist.sys.identifierid.supported";
    @Keep
    public static final String TAG = "VMS_SDK_Client";
    @Keep
    public static final int TIME_FOR_QUERY = 2000;
    @Keep
    public static final int TYPE_AAID = 2;
    @Keep
    public static final int TYPE_OAID = 0;
    @Keep
    public static final int TYPE_OAIDSTATUS = 4;
    @Keep
    public static final int TYPE_QUERY = 11;
    @Keep
    public static final int TYPE_VAID = 1;
    @Keep
    public static final String URI_BASE = "content://com.vivo.vms.IdProvider/IdentifierId";
    @Keep
    public static final String VAID_FLAG = "VAID";
    @Keep
    public static final int VERSION_P = 28;
    @Keep
    public static final int VERSION_Q = 29;
    @Keep
    public static String mAAID = null;
    @Keep
    public static IdentifierIdObserver mAAIDObserver = null;
    @Keep
    public static Context mContext = null;
    @Keep
    public static volatile DataBaseOperation mDatabase = null;
    @Keep
    public static volatile IdentifierIdClient mInstance = null;
    @Keep
    public static boolean mIsSupported = false;
    @Keep
    public static Object mLock = new Object();
    @Keep
    public static String mOAID;
    @Keep
    public static IdentifierIdObserver mOAIDObserver;
    @Keep
    public static String mOAIDStatus;
    @Keep
    public static Handler mSqlHandler;
    @Keep
    public static HandlerThread mSqlThread;
    @Keep
    public static String mVAID;
    @Keep
    public static IdentifierIdObserver mVAIDObserver;

    public IdentifierIdClient() {
        initSqlThread();
        mDatabase = new DataBaseOperation(mContext);
    }

    @Keep
    public static native void checkSupported();

    @Keep
    public static native IdentifierIdClient getInstance(Context context);

    @Keep
    public static native String getProperty(String str, String str2);

    @Keep
    public static native synchronized void initObserver(Context context, int i2, String str);

    @Keep
    public static native void initSqlThread();

    @Keep
    public static native boolean isSupported();

    @Keep
    private native void queryId(int i2, String str);

    @Keep
    public native String getAAID();

    @Keep
    public native String getAAID(String str);

    @Keep
    public native String getOAID();

    @Keep
    public native String getOAIDSTATUS();

    @Keep
    public native String getVAID();

    @Keep
    public native String getVAID(String str);

    @Keep
    public native void sendMessageToDataBase(int i2, String str);
}
