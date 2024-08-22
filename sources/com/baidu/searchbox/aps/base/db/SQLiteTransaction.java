package com.baidu.searchbox.aps.base.db;

import android.database.sqlite.SQLiteDatabase;

public abstract class SQLiteTransaction {
    private boolean mIsSuccess = false;

    /* access modifiers changed from: protected */
    public abstract boolean performTransaction(SQLiteDatabase sQLiteDatabase);

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run(android.database.sqlite.SQLiteDatabase r4) {
        /*
            r3 = this;
            r0 = 0
            r3.mIsSuccess = r0
            r4.beginTransaction()     // Catch:{ Exception -> 0x0023 }
            boolean r0 = r3.performTransaction(r4)     // Catch:{ Exception -> 0x0023 }
            if (r0 == 0) goto L_0x0012
            r4.setTransactionSuccessful()     // Catch:{ Exception -> 0x0023 }
            r0 = 1
            r3.mIsSuccess = r0     // Catch:{ Exception -> 0x0023 }
        L_0x0012:
            r4.endTransaction()     // Catch:{ Exception -> 0x0016 }
        L_0x0015:
            goto L_0x0039
        L_0x0016:
            r0 = move-exception
            boolean r1 = com.baidu.searchbox.aps.base.utils.BaseConfiger.isDebug()
            if (r1 == 0) goto L_0x0020
        L_0x001d:
            r0.printStackTrace()
        L_0x0020:
            goto L_0x0039
        L_0x0021:
            r0 = move-exception
            goto L_0x003a
        L_0x0023:
            r0 = move-exception
            boolean r1 = com.baidu.searchbox.aps.base.utils.BaseConfiger.isDebug()     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x002d
            r0.printStackTrace()     // Catch:{ all -> 0x0021 }
        L_0x002d:
            r4.endTransaction()     // Catch:{ Exception -> 0x0031 }
            goto L_0x0015
        L_0x0031:
            r0 = move-exception
            boolean r1 = com.baidu.searchbox.aps.base.utils.BaseConfiger.isDebug()
            if (r1 == 0) goto L_0x0020
            goto L_0x001d
        L_0x0039:
            return
        L_0x003a:
            r4.endTransaction()     // Catch:{ Exception -> 0x003e }
            goto L_0x0048
        L_0x003e:
            r1 = move-exception
            boolean r2 = com.baidu.searchbox.aps.base.utils.BaseConfiger.isDebug()
            if (r2 == 0) goto L_0x0048
            r1.printStackTrace()
        L_0x0048:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.aps.base.db.SQLiteTransaction.run(android.database.sqlite.SQLiteDatabase):void");
    }

    /* access modifiers changed from: protected */
    public boolean isTransactionSuccess() {
        return this.mIsSuccess;
    }
}
