package com.mars.kotlin.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.android.common.others.IStringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SelectionBuilder {
    public HashMap<String, String> mProjectionMap;
    public StringBuilder mSelection;
    public ArrayList<String> mSelectionArgs;
    public Table mTable = null;
    public View mView = null;

    private void assertTableView() {
        if (this.mTable == null && this.mView == null) {
            throw new IllegalStateException("Table or View both not specified");
        }
    }

    private void ensureProjectionMap() {
        if (this.mProjectionMap == null) {
            this.mProjectionMap = new HashMap<>();
        }
    }

    private void ensureSelection(int i2) {
        if (this.mSelection == null) {
            this.mSelection = new StringBuilder(i2 + 8);
        }
    }

    private void ensureSelectionArgs() {
        if (this.mSelectionArgs == null) {
            this.mSelectionArgs = new ArrayList<>();
        }
    }

    private void mapColumns(String[] strArr) {
        if (this.mProjectionMap != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = this.mProjectionMap.get(strArr[i2]);
                if (str != null) {
                    strArr[i2] = str;
                }
            }
        }
    }

    public int delete(SQLiteDatabase sQLiteDatabase) {
        assertTableView();
        Table table = this.mTable;
        if (table != null) {
            return sQLiteDatabase.delete(table.toString(), getSelection(), getSelectionArgs());
        }
        return sQLiteDatabase.delete(this.mView.toString(), getSelection(), getSelectionArgs());
    }

    public String getSelection() {
        StringBuilder sb = this.mSelection;
        if (sb != null) {
            return sb.toString();
        }
        return null;
    }

    public String[] getSelectionArgs() {
        ArrayList<String> arrayList = this.mSelectionArgs;
        if (arrayList != null) {
            return (String[]) arrayList.toArray(new String[0]);
        }
        return null;
    }

    public SelectionBuilder map(String str, String str2) {
        ensureProjectionMap();
        HashMap<String, String> hashMap = this.mProjectionMap;
        hashMap.put(str, str2 + " AS " + str);
        return this;
    }

    public SelectionBuilder mapToTable(String str, String str2) {
        ensureProjectionMap();
        HashMap<String, String> hashMap = this.mProjectionMap;
        hashMap.put(str, str2 + IStringUtil.CURRENT_PATH + str);
        return this;
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str) {
        return query(sQLiteDatabase, strArr, (String) null, (String) null, str, (String) null);
    }

    public SelectionBuilder reset() {
        this.mTable = null;
        this.mView = null;
        HashMap<String, String> hashMap = this.mProjectionMap;
        if (hashMap != null) {
            hashMap.clear();
        }
        StringBuilder sb = this.mSelection;
        if (sb != null) {
            sb.setLength(0);
        }
        ArrayList<String> arrayList = this.mSelectionArgs;
        if (arrayList != null) {
            arrayList.clear();
        }
        return this;
    }

    public SelectionBuilder table(Table table) {
        this.mTable = table;
        return this;
    }

    public String toString() {
        if (this.mTable != null) {
            return "SelectionBuilder[table=" + this.mTable + ", selection=" + getSelection() + ", selectionArgs=" + Arrays.toString(getSelectionArgs()) + "]";
        }
        return "SelectionBuilder[view=" + this.mView + ", selection=" + getSelection() + ", selectionArgs=" + Arrays.toString(getSelectionArgs()) + "]";
    }

    public int update(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        assertTableView();
        Table table = this.mTable;
        if (table != null) {
            return sQLiteDatabase.update(table.toString(), contentValues, getSelection(), getSelectionArgs());
        }
        return sQLiteDatabase.update(this.mView.toString(), contentValues, getSelection(), getSelectionArgs());
    }

    public SelectionBuilder view(View view) {
        this.mView = view;
        return this;
    }

    public SelectionBuilder where(String str, String... strArr) {
        if (!TextUtils.isEmpty(str)) {
            ensureSelection(str.length());
            if (this.mSelection.length() > 0) {
                this.mSelection.append(" AND ");
            }
            StringBuilder sb = this.mSelection;
            sb.append("(");
            sb.append(str);
            sb.append(")");
            if (strArr != null) {
                ensureSelectionArgs();
                Collections.addAll(this.mSelectionArgs, strArr);
            }
            return this;
        } else if (strArr == null || strArr.length <= 0) {
            return this;
        } else {
            throw new IllegalArgumentException("Valid selection required when including arguments=");
        }
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String str2, String str3, String str4) {
        String[] strArr2 = strArr;
        assertTableView();
        if (strArr2 != null) {
            mapColumns(strArr);
        }
        Table table = this.mTable;
        if (table != null) {
            return sQLiteDatabase.query(table.toString(), strArr, getSelection(), getSelectionArgs(), str, str2, str3, str4);
        }
        return sQLiteDatabase.query(this.mView.toString(), strArr, getSelection(), getSelectionArgs(), str, str2, str3, str4);
    }
}
