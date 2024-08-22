package com.baidu.searchbox.weather.db;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.baidu.searchbox.weather.WeatherLocationConfig;
import com.baidu.searchbox.weather.util.SQLiteExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/weather/db/LocationConfigDaoImpl;", "Lcom/baidu/searchbox/weather/db/LocationConfigDao;", "()V", "helper", "Lcom/baidu/searchbox/weather/db/LocationConfigDbHelper;", "getHelper", "()Lcom/baidu/searchbox/weather/db/LocationConfigDbHelper;", "helper$delegate", "Lkotlin/Lazy;", "addConfig", "", "config", "Lcom/baidu/searchbox/weather/WeatherLocationConfig;", "close", "deleteConfig", "getConfigs", "", "swapConfig", "config1", "config2", "lib-weather-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocationConfigDao.kt */
public final class LocationConfigDaoImpl implements LocationConfigDao {
    private final Lazy helper$delegate = LazyKt.lazy(LocationConfigDaoImpl$helper$2.INSTANCE);

    private final LocationConfigDbHelper getHelper() {
        return (LocationConfigDbHelper) this.helper$delegate.getValue();
    }

    /* Debug info: failed to restart local var, previous not found, register: 14 */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.baidu.searchbox.weather.WeatherLocationConfig> getConfigs() {
        /*
            r14 = this;
            monitor-enter(r14)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x008e }
            r0.<init>()     // Catch:{ all -> 0x008e }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x008e }
            com.baidu.searchbox.weather.db.LocationConfigDbHelper r1 = r14.getHelper()     // Catch:{ all -> 0x0069 }
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = "SELECT * FROM weather_user_add_cities ORDER BY sort_index"
            r3 = 0
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ all -> 0x0069 }
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ all -> 0x0069 }
            r2 = r1
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x0062 }
            r4 = 0
            java.lang.String r5 = "country"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x0062 }
            java.lang.String r6 = "city"
            int r6 = r2.getColumnIndex(r6)     // Catch:{ all -> 0x0062 }
            java.lang.String r7 = "sort_index"
            int r7 = r2.getColumnIndex(r7)     // Catch:{ all -> 0x0062 }
            java.lang.String r8 = "add_time"
            int r8 = r2.getColumnIndex(r8)     // Catch:{ all -> 0x0062 }
            boolean r9 = r2.moveToFirst()     // Catch:{ all -> 0x0062 }
            if (r9 == 0) goto L_0x005b
        L_0x003d:
            java.lang.String r9 = r2.getString(r5)     // Catch:{ all -> 0x0062 }
            java.lang.String r10 = r2.getString(r6)     // Catch:{ all -> 0x0062 }
            int r11 = r2.getInt(r7)     // Catch:{ all -> 0x0062 }
            long r12 = r2.getLong(r8)     // Catch:{ all -> 0x0062 }
            com.baidu.searchbox.weather.WeatherLocationConfig r9 = com.baidu.searchbox.weather.LocationConfigExtKt.createManualConfig(r9, r10, r11, r12)     // Catch:{ all -> 0x0062 }
            r0.add(r9)     // Catch:{ all -> 0x0062 }
            boolean r9 = r2.moveToNext()     // Catch:{ all -> 0x0062 }
            if (r9 != 0) goto L_0x003d
        L_0x005b:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0062 }
            kotlin.io.CloseableKt.closeFinally(r1, r3)     // Catch:{ all -> 0x0069 }
            goto L_0x008c
        L_0x0062:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)     // Catch:{ all -> 0x0069 }
            throw r3     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r1 = move-exception
            boolean r2 = com.baidu.searchbox.weather.db.LocationConfigDaoKt.DEBUG     // Catch:{ all -> 0x008e }
            if (r2 == 0) goto L_0x008c
            java.lang.String r2 = "WeatherLocationDB"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r3.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r4 = "error in getConfigs: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x008e }
            java.lang.String r4 = r1.getMessage()     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x008e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x008e }
            android.util.Log.w(r2, r3)     // Catch:{ all -> 0x008e }
        L_0x008c:
            monitor-exit(r14)
            return r0
        L_0x008e:
            r0 = move-exception
            monitor-exit(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.weather.db.LocationConfigDaoImpl.getConfigs():java.util.List");
    }

    public synchronized void deleteConfig(WeatherLocationConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        try {
            SQLiteDatabase writableDatabase = getHelper().getWritableDatabase();
            Intrinsics.checkNotNullExpressionValue(writableDatabase, "helper.writableDatabase");
            SQLiteExtKt.transaction(writableDatabase, new LocationConfigDaoImpl$deleteConfig$1(config));
        } catch (Throwable t) {
            if (LocationConfigDaoKt.DEBUG) {
                Log.w("WeatherLocationDB", "error in deleteConfig: " + t.getMessage());
            }
        }
    }

    public synchronized void swapConfig(WeatherLocationConfig config1, WeatherLocationConfig config2) {
        Intrinsics.checkNotNullParameter(config1, "config1");
        Intrinsics.checkNotNullParameter(config2, "config2");
        try {
            int i1 = config1.getSortIndex();
            int i2 = config2.getSortIndex();
            SQLiteDatabase writableDatabase = getHelper().getWritableDatabase();
            Intrinsics.checkNotNullExpressionValue(writableDatabase, "helper.writableDatabase");
            SQLiteExtKt.transaction(writableDatabase, new LocationConfigDaoImpl$swapConfig$1("UPDATE weather_user_add_cities \nSET sort_index = (CASE \n    WHEN sort_index = ? THEN ? \n    WHEN sort_index = ? THEN ?\nEND)\nWHERE sort_index IN (?, ?)", i1, i2, config1, config2));
        } catch (Throwable t) {
            if (LocationConfigDaoKt.DEBUG) {
                Log.w("WeatherLocationDB", "error in swapConfig: " + t.getMessage());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addConfig(com.baidu.searchbox.weather.WeatherLocationConfig r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "config"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)     // Catch:{ all -> 0x0052 }
            java.util.List r0 = r4.getConfigs()     // Catch:{ all -> 0x002d }
            int r0 = r0.size()     // Catch:{ all -> 0x002d }
            r1 = 9
            if (r0 < r1) goto L_0x0015
            monitor-exit(r4)
            return
        L_0x0015:
            com.baidu.searchbox.weather.db.LocationConfigDbHelper r0 = r4.getHelper()     // Catch:{ all -> 0x002d }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x002d }
            java.lang.String r1 = "helper.writableDatabase"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ all -> 0x002d }
            com.baidu.searchbox.weather.db.LocationConfigDaoImpl$addConfig$1 r1 = new com.baidu.searchbox.weather.db.LocationConfigDaoImpl$addConfig$1     // Catch:{ all -> 0x002d }
            r1.<init>(r5)     // Catch:{ all -> 0x002d }
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1     // Catch:{ all -> 0x002d }
            com.baidu.searchbox.weather.util.SQLiteExtKt.transaction(r0, r1)     // Catch:{ all -> 0x002d }
            goto L_0x0050
        L_0x002d:
            r0 = move-exception
            boolean r1 = com.baidu.searchbox.weather.db.LocationConfigDaoKt.DEBUG     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x0050
            java.lang.String r1 = "WeatherLocationDB"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0052 }
            r2.<init>()     // Catch:{ all -> 0x0052 }
            java.lang.String r3 = "error in addConfig: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0052 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x0052 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0052 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0052 }
            android.util.Log.w(r1, r2)     // Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r4)
            return
        L_0x0052:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.weather.db.LocationConfigDaoImpl.addConfig(com.baidu.searchbox.weather.WeatherLocationConfig):void");
    }

    public void close() {
        try {
            getHelper().close();
        } catch (Throwable t) {
            if (LocationConfigDaoKt.DEBUG) {
                Log.w("WeatherLocationDB", "error in close: " + t.getMessage());
            }
        }
    }
}
