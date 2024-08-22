package com.baidu.swan.pms.database;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.database.PMSDBTable;
import com.baidu.swan.pms.database.dao.PMSBaseDao;
import com.baidu.swan.pms.database.dao.PMSDaoMap;
import com.baidu.swan.pms.database.provider.PMSDBProvider;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSExtension;
import com.baidu.swan.pms.model.PMSFramework;
import com.baidu.swan.pms.model.PMSPackage;
import com.baidu.swan.pms.model.PMSPkgMain;
import com.baidu.swan.pms.model.PMSPkgSub;
import com.baidu.swan.pms.model.PMSPlugin;
import com.baidu.swan.pms.model.PMSSoLib;
import com.baidu.swan.pms.utils.AbsPMSLog;
import com.baidu.swan.pms.utils.PMSDaoUtil;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PMSDBImpl extends PMSDB {
    private static final AbsPMSLog LOG = AbsPMSLog.getPMSDBLog();
    private static final String TAG = "PMSDBImpl";
    private PMSDaoMap mDBDao = new PMSDaoMap();

    PMSDBImpl() {
    }

    public <T extends PMSPackage> boolean insertPkg(T pkg) {
        LOG.logInfo(TAG, "#insertPkg");
        return addPackage(pkg);
    }

    public <T extends PMSPackage> boolean updatePkg(T pkg) {
        LOG.logInfo(TAG, "#updatePkg");
        return updateItem(pkg);
    }

    public <T extends PMSPackage> T queryPkg(Class<T> cls, String bundleId) {
        return (PMSPackage) queryPackage(cls, bundleId);
    }

    public <T extends PMSPackage> boolean deletePkg(T pkg) {
        LOG.logInfo(TAG, "#deletePkg");
        return deleteItem(pkg);
    }

    public <T extends PMSPackage> boolean deletePkg(Class<T> cls, String bundleId) {
        try {
            LOG.logInfo(TAG, "#deletePkg bundleId=" + bundleId);
            if (AppRuntime.getAppContext().getContentResolver().delete(this.mDBDao.getUri(cls), "bundle_id =? ", new String[]{bundleId}) > 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            LOG.logError(TAG, "#deletePkg error", e2);
        }
    }

    public boolean updateSwanApp(PMSAppInfo appInfo) {
        try {
            LOG.logInfo(TAG, "#updateSwanApp appId=" + appInfo.appId);
            PMSBaseDao dao = this.mDBDao.getDao(appInfo.getClass());
            if (AppRuntime.getAppContext().getContentResolver().update(this.mDBDao.getUri(appInfo.getClass()), dao.getContentValues(appInfo), "app_id =? ", new String[]{appInfo.appId}) > 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            LOG.logError(TAG, "#updateSwanApp error", e2);
        }
    }

    public boolean updateSwanAppPendingErrCode(String appId, int errCode) {
        LOG.logInfo(TAG, "#updateSwanAppPendingErrCode appId=" + appId + " errCode=" + errCode);
        if (TextUtils.isEmpty(appId)) {
            return false;
        }
        try {
            Uri contentUri = this.mDBDao.getUri(PMSAppInfo.class);
            ContentValues contentValues = new ContentValues();
            contentValues.put(PMSDBTable.AppInfo.PENDING_ERR_CODE, Integer.valueOf(errCode));
            if (AppRuntime.getAppContext().getContentResolver().update(contentUri, contentValues, "app_id =? ", new String[]{appId}) > 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            LOG.logError(TAG, "#updateSwanAppPendingErrCode error", e2);
        }
    }

    public boolean deleteSwanApp(String appId) {
        LOG.logInfo(TAG, "#deleteSwanApp appId=" + appId);
        try {
            if (AppRuntime.getAppContext().getContentResolver().delete(this.mDBDao.getUri(PMSAppInfo.class), "app_id =? ", new String[]{appId}) > 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            LOG.logError(TAG, "#deleteSwanApp error", e2);
        }
    }

    public boolean insertOrUpdateSwanApp(PMSAppInfo appInfo) {
        try {
            LOG.logInfo(TAG, "#insertOrUpdateSwanApp appId=" + appInfo.appId);
            Class<?> appInfoClass = appInfo.getClass();
            PMSBaseDao dao = this.mDBDao.getDao(appInfoClass);
            Uri result = AppRuntime.getAppContext().getContentResolver().insert(this.mDBDao.getUri(appInfoClass), dao.getContentValues(appInfo));
            if (result == null || ContentUris.parseId(result) <= 0) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            LOG.logError(TAG, "#insertOrUpdateSwanApp error", e2);
            return false;
        }
    }

    public Map<String, PMSPkgMain> queryPkgMain() {
        Map<String, PMSPkgMain> resultMap = new HashMap<>();
        List<PMSPkgMain> list = queryPackageList(PMSPkgMain.class, "state =? ", new String[]{"10"}, "version_code ASC");
        if (list != null && list.size() > 0) {
            for (PMSPkgMain pkgMain : list) {
                if (pkgMain != null) {
                    resultMap.put(pkgMain.bundleId, pkgMain);
                }
            }
        }
        return resultMap;
    }

    public PMSAppInfo querySwanApp(String appId) {
        return queryAppInfo(appId);
    }

    public Map<String, PMSAppInfo> querySwanApp() {
        Map<String, PMSAppInfo> resultMap = new HashMap<>();
        List<PMSAppInfo> list = queryAppInfoList(PMSAppInfo.class, (String) null, (String[]) null, (String) null);
        if (list != null && list.size() > 0) {
            for (PMSAppInfo appInfo : list) {
                if (appInfo != null && !TextUtils.isEmpty(appInfo.appId)) {
                    resultMap.put(appInfo.appId, appInfo);
                }
            }
        }
        return resultMap;
    }

    public boolean isSubPackageExist(String appId, String versionCode, String subPkgName) {
        Cursor cursor = null;
        boolean z = false;
        try {
            Uri uri = this.mDBDao.getUri(PMSPkgSub.class);
            PMSBaseDao<PMSPkgSub> dao = this.mDBDao.getDao(PMSPkgSub.class);
            cursor = AppRuntime.getAppContext().getContentResolver().query(uri, (String[]) null, "app_id=? AND version_code=? AND sub_pkg_name=?", new String[]{appId, versionCode, subPkgName}, (String) null);
            if (cursor != null) {
                if (dao.getEntity(cursor) != null) {
                    z = true;
                }
                PMSDaoUtil.closeSafely(cursor);
                return z;
            }
        } catch (Exception e2) {
            LOG.logError(TAG, "#isSubPackageExist error", e2);
        } catch (Throwable th2) {
            PMSDaoUtil.closeSafely((Closeable) null);
            throw th2;
        }
        PMSDaoUtil.closeSafely(cursor);
        return false;
    }

    public List<PMSPkgSub> getSubPackageByAppId(String appId, int version) {
        String selection;
        Cursor cursor = null;
        List<PMSPkgSub> result = null;
        if (version >= 0) {
            try {
                selection = "app_id=? and version_code" + "=?";
            } catch (Exception e2) {
                LOG.logError(TAG, "#getSubPackageByAppId fail", e2);
            } catch (Throwable th2) {
                PMSDaoUtil.closeSafely((Closeable) null);
                throw th2;
            }
        } else {
            selection = "app_id=? and version_code" + ">?";
        }
        Uri uri = this.mDBDao.getUri(PMSPkgSub.class);
        PMSBaseDao<PMSPkgSub> dao = this.mDBDao.getDao(PMSPkgSub.class);
        cursor = AppRuntime.getAppContext().getContentResolver().query(uri, (String[]) null, selection, new String[]{appId, String.valueOf(version)}, (String) null);
        if (!(cursor == null || dao == null)) {
            result = dao.getEntityList(cursor);
        }
        PMSDaoUtil.closeSafely(cursor);
        if (result == null) {
            return Collections.emptyList();
        }
        return result;
    }

    public int getNewestSubPkgVersion(String appId) {
        Cursor cursor = null;
        int version = -1;
        try {
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.mDBDao.getUri(PMSPkgSub.class), new String[]{"version_code"}, "app_id=?", new String[]{appId}, "version_code DESC limit 1");
            if (cursor != null && cursor.moveToFirst()) {
                version = cursor.getInt(0);
            }
        } catch (Exception e2) {
            LOG.logError(TAG, "#getNewestSubPkgVersion fail", e2);
        } catch (Throwable th2) {
            PMSDaoUtil.closeSafely((Closeable) null);
            throw th2;
        }
        PMSDaoUtil.closeSafely(cursor);
        return version;
    }

    public void clearSubPackage(String appId, String versionCode) {
        LOG.logInfo(TAG, "#clearSubPackage appId=" + appId + " versionCode=" + versionCode);
        if (!TextUtils.isEmpty(appId) && !TextUtils.isEmpty(versionCode)) {
            try {
                Uri uri = this.mDBDao.getUri(PMSPkgSub.class);
                AppRuntime.getAppContext().getContentResolver().delete(uri, "app_id=? AND version_code=?", new String[]{appId, versionCode});
            } catch (Exception e2) {
                LOG.logError(TAG, "#clearSubPackage error", e2);
            }
        }
    }

    public void clearSubPackage(String appId) {
        LOG.logInfo(TAG, "#clearSubPackage appId=" + appId);
        if (!TextUtils.isEmpty(appId)) {
            try {
                Uri uri = this.mDBDao.getUri(PMSPkgSub.class);
                AppRuntime.getAppContext().getContentResolver().delete(uri, "app_id=?", new String[]{appId});
            } catch (Exception e2) {
                LOG.logError(TAG, "#clearSubPackage error", e2);
            }
        }
    }

    public boolean bulkInsert(PMSPkgMain main, PMSAppInfo appInfo) {
        return bulkInsert(main, (List<PMSPkgSub>) null, (PMSFramework) null, (PMSExtension) null, appInfo);
    }

    public boolean bulkInsert(PMSPkgMain main, List<PMSPkgSub> subList, PMSFramework framework, PMSExtension extension, PMSAppInfo appInfo) {
        LOG.logInfo(TAG, "#bulkInsert");
        ArrayList<ContentProviderOperation> operationList = new ArrayList<>();
        if (main != null) {
            operationList.add(ContentProviderOperation.newInsert(this.mDBDao.getUri(PMSPkgMain.class)).withValues(this.mDBDao.getDao(PMSPkgMain.class).getContentValues(main)).build());
        }
        if (subList != null && !subList.isEmpty()) {
            PMSBaseDao dao = this.mDBDao.getDao(PMSPkgSub.class);
            for (PMSPkgSub sub : subList) {
                operationList.add(ContentProviderOperation.newInsert(this.mDBDao.getUri(PMSPkgSub.class)).withValues(dao.getContentValues(sub)).build());
            }
        }
        if (framework != null) {
            operationList.add(ContentProviderOperation.newInsert(this.mDBDao.getUri(PMSFramework.class)).withValues(this.mDBDao.getDao(PMSFramework.class).getContentValues(framework)).build());
        }
        if (extension != null) {
            operationList.add(ContentProviderOperation.newInsert(this.mDBDao.getUri(PMSExtension.class)).withValues(this.mDBDao.getDao(PMSExtension.class).getContentValues(extension)).build());
        }
        if (appInfo != null) {
            operationList.add(ContentProviderOperation.newInsert(this.mDBDao.getUri(PMSAppInfo.class)).withValues(this.mDBDao.getDao(PMSAppInfo.class).getContentValues(appInfo)).build());
        }
        try {
            for (ContentProviderResult result : AppRuntime.getAppContext().getContentResolver().applyBatch(PMSDBProvider.AUTHORITY, operationList)) {
                if (result == null || (result.uri == null && result.count == null)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            LOG.logError(TAG, "#bulkInsert error", e2);
            return false;
        }
    }

    private <T extends PMSPackage> boolean addPackage(T pkg) {
        try {
            LOG.logInfo(TAG, "#addPackage bundleId=" + pkg);
            PMSBaseDao dao = this.mDBDao.getDao(pkg.getClass());
            Uri result = AppRuntime.getAppContext().getContentResolver().insert(this.mDBDao.getUri(pkg.getClass()), dao.getContentValues(pkg));
            if (result == null || ContentUris.parseId(result) <= 0) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            LOG.logError(TAG, "#addPackage error", e2);
            return false;
        }
    }

    private <T extends PMSPackage> boolean updateItem(T pkg) {
        try {
            LOG.logInfo(TAG, "#updateItem bundleId=" + pkg.bundleId);
            PMSBaseDao dao = this.mDBDao.getDao(pkg.getClass());
            if (AppRuntime.getAppContext().getContentResolver().update(this.mDBDao.getUri(pkg.getClass()), dao.getContentValues(pkg), "bundle_id =? ", new String[]{pkg.bundleId}) > 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            LOG.logError(TAG, "#updateItem error", e2);
        }
    }

    private <T extends PMSPackage> boolean deleteItem(T pkg) {
        try {
            LOG.logInfo(TAG, "#deleteItem bundleId=" + pkg.bundleId);
            if (AppRuntime.getAppContext().getContentResolver().delete(this.mDBDao.getUri(pkg.getClass()), "bundle_id =? ", new String[]{pkg.bundleId}) > 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            LOG.logError(TAG, "#deleteItem error", e2);
        }
    }

    private <T> T queryPackage(Class<T> cls, String bundleId) {
        Cursor cursor = null;
        try {
            PMSBaseDao<T> dao = this.mDBDao.getDao(cls);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.mDBDao.getUri(cls), (String[]) null, "bundle_id =? ", new String[]{bundleId}, "version_code DESC");
            if (cursor != null) {
                T entity = dao.getEntity(cursor);
                PMSDaoUtil.closeSafely(cursor);
                return entity;
            }
        } catch (Exception e2) {
            LOG.logError(TAG, "#queryPackage error", e2);
        } catch (Throwable th2) {
            PMSDaoUtil.closeSafely((Closeable) null);
            throw th2;
        }
        PMSDaoUtil.closeSafely(cursor);
        return null;
    }

    public PMSSoLib querySoLib(String libName) {
        Cursor cursor = null;
        try {
            PMSBaseDao<PMSSoLib> dao = this.mDBDao.getDao(PMSSoLib.class);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.mDBDao.getUri(PMSSoLib.class), (String[]) null, "lib_name =? ", new String[]{libName}, "version_code DESC");
            if (cursor != null) {
                PMSSoLib entity = dao.getEntity(cursor);
                PMSDaoUtil.closeSafely(cursor);
                return entity;
            }
        } catch (Exception e2) {
            LOG.logError(TAG, "#querySoLib error", e2);
        } catch (Throwable th2) {
            PMSDaoUtil.closeSafely((Closeable) null);
            throw th2;
        }
        PMSDaoUtil.closeSafely(cursor);
        return null;
    }

    public Collection<PMSSoLib> querySoLibs() {
        Collection<PMSSoLib> soLibs = new ArrayList<>();
        Cursor cursor = null;
        try {
            PMSBaseDao<PMSSoLib> dao = this.mDBDao.getDao(PMSSoLib.class);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.mDBDao.getUri(PMSSoLib.class), (String[]) null, (String) null, (String[]) null, (String) null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    PMSSoLib soLib = dao.getEntity(cursor);
                    if (soLib != null) {
                        soLibs.add(soLib);
                    }
                }
            }
        } catch (Exception e2) {
            LOG.logError(TAG, "#querySoLibs error", e2);
        } catch (Throwable th2) {
            PMSDaoUtil.closeSafely((Closeable) null);
            throw th2;
        }
        PMSDaoUtil.closeSafely(cursor);
        return soLibs;
    }

    private PMSAppInfo queryAppInfo(String appId) {
        Cursor cursor = null;
        try {
            PMSBaseDao<PMSAppInfo> dao = this.mDBDao.getDao(PMSAppInfo.class);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.mDBDao.getUri(PMSAppInfo.class), (String[]) null, "app_id =? ", new String[]{appId}, "version_code DESC");
            if (cursor != null) {
                PMSAppInfo entity = dao.getEntity(cursor);
                PMSDaoUtil.closeSafely(cursor);
                return entity;
            }
        } catch (Exception e2) {
            LOG.logError(TAG, "#queryAppInfo error", e2);
        } catch (Throwable th2) {
            PMSDaoUtil.closeSafely((Closeable) null);
            throw th2;
        }
        PMSDaoUtil.closeSafely(cursor);
        return null;
    }

    private <T> List<T> queryPackageList(Class<T> cls, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = null;
        try {
            PMSBaseDao<T> dao = this.mDBDao.getDao(cls);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.mDBDao.getUri(cls), (String[]) null, selection, selectionArgs, sortOrder);
            if (cursor != null) {
                List<T> entityList = dao.getEntityList(cursor);
                PMSDaoUtil.closeSafely(cursor);
                return entityList;
            }
        } catch (Exception e2) {
            LOG.logError(TAG, "#queryPackageList error", e2);
        } catch (Throwable th2) {
            PMSDaoUtil.closeSafely((Closeable) null);
            throw th2;
        }
        PMSDaoUtil.closeSafely(cursor);
        return null;
    }

    private <T> List<T> queryAppInfoList(Class<T> cls, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = null;
        try {
            PMSBaseDao<T> dao = this.mDBDao.getDao(cls);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.mDBDao.getUri(cls), (String[]) null, selection, selectionArgs, sortOrder);
            if (cursor != null) {
                List<T> entityList = dao.getEntityList(cursor);
                PMSDaoUtil.closeSafely(cursor);
                return entityList;
            }
        } catch (Exception e2) {
            LOG.logError(TAG, "#queryAppInfoList error", e2);
        } catch (Throwable th2) {
            PMSDaoUtil.closeSafely((Closeable) null);
            throw th2;
        }
        PMSDaoUtil.closeSafely(cursor);
        return null;
    }

    public boolean deletePlugin(PMSPlugin pkg) {
        String[] whereArgs;
        String whereClause;
        try {
            LOG.logInfo(TAG, "#deletePlugin bundleId=" + pkg.bundleId + " versionCode=" + pkg.versionCode);
            Uri contentUri = this.mDBDao.getUri(pkg.getClass());
            if (pkg.versionCode >= 0) {
                whereClause = "bundle_id = ?  and version_code < ? ";
                whereArgs = new String[]{pkg.bundleId, String.valueOf(pkg.versionCode)};
            } else {
                whereClause = "bundle_id = ? ";
                whereArgs = new String[]{pkg.bundleId};
            }
            if (AppRuntime.getAppContext().getContentResolver().delete(contentUri, whereClause, whereArgs) > 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            LOG.logError(TAG, "#deletePlugin error", e2);
        }
    }

    public boolean deletePlugins(List<PMSPlugin> plugins) {
        if (plugins == null || plugins.isEmpty()) {
            return false;
        }
        try {
            Uri contentUri = this.mDBDao.getUri(PMSPlugin.class);
            StringBuilder whereBuilder = new StringBuilder();
            ArrayList<String> whereArgs = new ArrayList<>();
            boolean isFirstElement = true;
            for (PMSPlugin plugin : plugins) {
                if (isFirstElement) {
                    isFirstElement = false;
                } else {
                    whereBuilder.append(" or ");
                }
                whereBuilder.append("( ");
                whereBuilder.append("bundle_id");
                whereBuilder.append(" = ? and ");
                whereBuilder.append("version_code");
                whereBuilder.append(" = ?");
                whereBuilder.append(" )");
                whereArgs.add(plugin.bundleId);
                whereArgs.add(String.valueOf(plugin.versionCode));
            }
            if (AppRuntime.getAppContext().getContentResolver().delete(contentUri, whereBuilder.toString(), (String[]) whereArgs.toArray(new String[0])) > 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
        }
    }

    public boolean updatePlugin(PMSPlugin pkg) {
        String[] whereArgs;
        String whereClause;
        try {
            LOG.logInfo(TAG, "#deletePlugin bundleId=" + pkg.bundleId + " versionCode=" + pkg.versionCode);
            PMSBaseDao dao = this.mDBDao.getDao(pkg.getClass());
            Uri contentUri = this.mDBDao.getUri(pkg.getClass());
            ContentValues contentValues = dao.getContentValues(pkg);
            if (pkg.versionCode >= 0) {
                whereClause = "bundle_id = ?  and version_code = ? ";
                whereArgs = new String[]{pkg.bundleId, String.valueOf(pkg.versionCode)};
            } else {
                whereClause = "bundle_id = ?  and version_name = ? ";
                whereArgs = new String[]{pkg.bundleId, pkg.versionName};
            }
            if (AppRuntime.getAppContext().getContentResolver().update(contentUri, contentValues, whereClause, whereArgs) > 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            LOG.logError(TAG, "#updatePlugin error", e2);
        }
    }

    public List<PMSPlugin> queryPlugins(String bundleId, long minVersionCode, long maxVersionCode, boolean onlyOneResult) {
        Cursor cursor = null;
        try {
            PMSBaseDao<PMSPlugin> dao = this.mDBDao.getDao(PMSPlugin.class);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.mDBDao.getUri(PMSPlugin.class), (String[]) null, "bundle_id = ? AND version_code >= ? AND version_code <= ? ", new String[]{bundleId, String.valueOf(minVersionCode), String.valueOf(maxVersionCode)}, "version_code DESC");
            if (cursor != null) {
                List<PMSPlugin> singletonList = onlyOneResult ? Collections.singletonList(dao.getEntity(cursor)) : dao.getEntityList(cursor);
                PMSDaoUtil.closeSafely(cursor);
                return singletonList;
            }
        } catch (Exception e2) {
        } catch (Throwable th2) {
            PMSDaoUtil.closeSafely((Closeable) null);
            throw th2;
        }
        PMSDaoUtil.closeSafely(cursor);
        return null;
    }

    public List<PMSPlugin> queryPlugins(String bundleId, long minVersionCode, long maxVersionCode) {
        return queryPlugins(bundleId, minVersionCode, maxVersionCode, false);
    }

    public PMSPlugin queryPlugin(String bundleId, long minVersionCode, long maxVersionCode) {
        List<PMSPlugin> plugins = queryPlugins(bundleId, minVersionCode, maxVersionCode, true);
        if (plugins == null || plugins.isEmpty()) {
            return null;
        }
        return plugins.get(0);
    }

    public List<PMSPlugin> queryPlugin(String whereClause, String[] whereArgs) {
        Cursor cursor = null;
        try {
            PMSBaseDao<PMSPlugin> dao = this.mDBDao.getDao(PMSPlugin.class);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.mDBDao.getUri(PMSPlugin.class), (String[]) null, whereClause, whereArgs, "update_time DESC");
            if (cursor != null) {
                List<PMSPlugin> entityList = dao.getEntityList(cursor);
                PMSDaoUtil.closeSafely(cursor);
                return entityList;
            }
        } catch (Exception e2) {
            LOG.logError(TAG, "#queryPlugin error", e2);
        } catch (Throwable th2) {
            PMSDaoUtil.closeSafely((Closeable) null);
            throw th2;
        }
        PMSDaoUtil.closeSafely(cursor);
        return null;
    }

    public List<PMSPlugin> rawQueryPlugins(String sql) {
        Cursor cursor = null;
        try {
            PMSBaseDao<PMSPlugin> dao = this.mDBDao.getDao(PMSPlugin.class);
            Uri.Builder builder = this.mDBDao.getUri(PMSPlugin.class).buildUpon();
            builder.appendQueryParameter(PMSDBProvider.RAW_QUERY_PARAMETER, "");
            cursor = AppRuntime.getAppContext().getContentResolver().query(builder.build(), (String[]) null, sql, (String[]) null, (String) null);
            if (cursor != null) {
                List<PMSPlugin> entityList = dao.getEntityList(cursor);
                PMSDaoUtil.closeSafely(cursor);
                return entityList;
            }
        } catch (Exception e2) {
            LOG.logError(TAG, "#rawQueryPlugins error", e2);
        } catch (Throwable th2) {
            PMSDaoUtil.closeSafely((Closeable) null);
            throw th2;
        }
        PMSDaoUtil.closeSafely(cursor);
        return null;
    }

    public List<PMSPlugin> queryBatchDynamicLib(int querySize) {
        Cursor cursor = null;
        try {
            PMSDaoMap pMSDaoMap = this.mDBDao;
            if (pMSDaoMap == null) {
                LOG.logError(TAG, "#queryBatchDynamicLib mDBDao=null", (Throwable) null);
                PMSDaoUtil.closeSafely((Closeable) null);
                return null;
            }
            PMSBaseDao<PMSPlugin> dao = pMSDaoMap.getDao(PMSPlugin.class);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.mDBDao.getUri(PMSPlugin.class), (String[]) null, (String) null, (String[]) null, "update_time ASC limit 0," + querySize);
            if (cursor != null) {
                List<PMSPlugin> entityList = dao.getEntityList(cursor);
                PMSDaoUtil.closeSafely(cursor);
                return entityList;
            }
            PMSDaoUtil.closeSafely(cursor);
            return null;
        } catch (Exception e2) {
            LOG.logError(TAG, "#queryBatchDynamicLib error", e2);
        } catch (Throwable th2) {
            PMSDaoUtil.closeSafely((Closeable) null);
            throw th2;
        }
    }
}
