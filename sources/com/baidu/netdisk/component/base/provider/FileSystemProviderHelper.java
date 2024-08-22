package com.baidu.netdisk.component.base.provider;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import com.baidu.netdisk.component.base.provider.FileSystemContract;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import java.util.ArrayList;

public class FileSystemProviderHelper {
    private static final String TAG = "SystemProviderHelper";
    private String mBduss;

    public FileSystemProviderHelper(String bduss) {
        this.mBduss = bduss;
    }

    public void closeDatabase(Context context) {
        ArrayList<ContentProviderOperation> batch = new ArrayList<>(1);
        batch.add(ContentProviderOperation.newUpdate(FileSystemContract.Databases.buildDatabasesUri(this.mBduss)).withValue("fid", "empty").build());
        try {
            context.getContentResolver().applyBatch(FileSystemContract.CONTENT_AUTHORITY, batch);
        } catch (RemoteException e2) {
            NetDiskLog.e(TAG, "", e2);
        } catch (OperationApplicationException e3) {
            NetDiskLog.e(TAG, "", e3);
        } catch (Exception e4) {
            NetDiskLog.e(TAG, "closeDatabase", e4);
        }
    }

    public int getPid(Context context) {
        Cursor cursor = context.getContentResolver().query(FileSystemContract.PidInfo.CONTENT_URI, (String[]) null, (String) null, (String[]) null, (String) null);
        if (cursor == null) {
            return -1;
        }
        int pid = -1;
        if (cursor.moveToFirst()) {
            pid = cursor.getInt(cursor.getColumnIndex("pid"));
        }
        cursor.close();
        return pid;
    }
}
