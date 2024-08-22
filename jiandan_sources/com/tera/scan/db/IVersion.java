package com.tera.scan.db;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;

public interface IVersion {
    void qw(@NonNull SQLiteDatabase sQLiteDatabase);
}
