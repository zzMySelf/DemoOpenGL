package com.baidu.swan.pms.database.provider;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.database.helper.IPMSDBHelper;
import com.baidu.swan.pms.database.helper.PMSDBHelperAppInfo;
import com.baidu.swan.pms.database.helper.PMSDBHelperExtension;
import com.baidu.swan.pms.database.helper.PMSDBHelperFramework;
import com.baidu.swan.pms.database.helper.PMSDBHelperPkgMain;
import com.baidu.swan.pms.database.helper.PMSDBHelperPkgSub;
import com.baidu.swan.pms.database.helper.PMSDBHelperPlugin;
import com.baidu.swan.pms.database.helper.PMSDBHelperSoLib;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSExtension;
import com.baidu.swan.pms.model.PMSFramework;
import com.baidu.swan.pms.model.PMSPkgMain;
import com.baidu.swan.pms.model.PMSPkgSub;
import com.baidu.swan.pms.model.PMSPlugin;
import com.baidu.swan.pms.model.PMSSoLib;
import java.util.concurrent.ConcurrentHashMap;

public class PMSDBHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 20;
    private static volatile PMSDBHelper mDBHelper;
    private ConcurrentHashMap<Class<?>, IPMSDBHelper> entityMap;

    private void initHelpMap() {
        ConcurrentHashMap<Class<?>, IPMSDBHelper> concurrentHashMap = new ConcurrentHashMap<>();
        this.entityMap = concurrentHashMap;
        concurrentHashMap.put(PMSPkgMain.class, new PMSDBHelperPkgMain());
        this.entityMap.put(PMSPkgSub.class, new PMSDBHelperPkgSub());
        this.entityMap.put(PMSAppInfo.class, new PMSDBHelperAppInfo());
        this.entityMap.put(PMSFramework.class, new PMSDBHelperFramework());
        this.entityMap.put(PMSExtension.class, new PMSDBHelperExtension());
        this.entityMap.put(PMSPlugin.class, new PMSDBHelperPlugin());
        this.entityMap.put(PMSSoLib.class, new PMSDBHelperSoLib());
    }

    private PMSDBHelper() {
        this(PMSConstants.PMS_DB_FILE, DB_VERSION);
        initHelpMap();
    }

    private PMSDBHelper(String name, int version) {
        super(AppRuntime.getAppContext(), name, (SQLiteDatabase.CursorFactory) null, version, (DatabaseErrorHandler) null);
    }

    public static PMSDBHelper get() {
        if (mDBHelper == null) {
            synchronized (PMSDBHelper.class) {
                if (mDBHelper == null) {
                    mDBHelper = new PMSDBHelper();
                }
            }
        }
        return mDBHelper;
    }

    public IPMSDBHelper getHelper(Class<?> cls) {
        return this.entityMap.get(cls);
    }

    public void onCreate(SQLiteDatabase db) {
        for (IPMSDBHelper table : this.entityMap.values()) {
            table.onCreate(db);
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (IPMSDBHelper table : this.entityMap.values()) {
            table.onUpgrade(db, oldVersion, newVersion);
        }
    }

    public void release() {
        mDBHelper = null;
    }
}
