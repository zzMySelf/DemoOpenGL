package com.pichillilorenzo.flutter_inappwebview.credential_database;

import android.content.ContentValues;
import android.database.Cursor;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLCredentialContract;
import com.pichillilorenzo.flutter_inappwebview.types.URLCredential;
import java.util.ArrayList;
import java.util.List;

public class URLCredentialDao {
    public CredentialDatabaseHelper credentialDatabaseHelper;
    public String[] projection = {"_id", "username", "password", URLCredentialContract.FeedEntry.COLUMN_NAME_PROTECTION_SPACE_ID};

    public URLCredentialDao(CredentialDatabaseHelper credentialDatabaseHelper2) {
        this.credentialDatabaseHelper = credentialDatabaseHelper2;
    }

    public long delete(URLCredential uRLCredential) {
        return (long) this.credentialDatabaseHelper.getWritableDatabase().delete(URLCredentialContract.FeedEntry.TABLE_NAME, "_id = ?", new String[]{uRLCredential.getId().toString()});
    }

    public URLCredential find(String str, String str2, Long l) {
        Cursor query = this.credentialDatabaseHelper.getReadableDatabase().query(URLCredentialContract.FeedEntry.TABLE_NAME, this.projection, "username = ? AND password = ? AND protection_space_id = ?", new String[]{str, str2, l.toString()}, (String) null, (String) null, (String) null);
        URLCredential uRLCredential = query.moveToNext() ? new URLCredential(Long.valueOf(query.getLong(query.getColumnIndexOrThrow("_id"))), query.getString(query.getColumnIndexOrThrow("username")), query.getString(query.getColumnIndexOrThrow("password")), l) : null;
        query.close();
        return uRLCredential;
    }

    public List<URLCredential> getAllByProtectionSpaceId(Long l) {
        Cursor query = this.credentialDatabaseHelper.getReadableDatabase().query(URLCredentialContract.FeedEntry.TABLE_NAME, this.projection, "protection_space_id = ?", new String[]{l.toString()}, (String) null, (String) null, (String) null);
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            arrayList.add(new URLCredential(Long.valueOf(query.getLong(query.getColumnIndexOrThrow("_id"))), query.getString(query.getColumnIndexOrThrow("username")), query.getString(query.getColumnIndexOrThrow("password")), l));
        }
        query.close();
        return arrayList;
    }

    public long insert(URLCredential uRLCredential) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", uRLCredential.getUsername());
        contentValues.put("password", uRLCredential.getPassword());
        contentValues.put(URLCredentialContract.FeedEntry.COLUMN_NAME_PROTECTION_SPACE_ID, uRLCredential.getProtectionSpaceId());
        return this.credentialDatabaseHelper.getWritableDatabase().insert(URLCredentialContract.FeedEntry.TABLE_NAME, (String) null, contentValues);
    }

    public long update(URLCredential uRLCredential) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", uRLCredential.getUsername());
        contentValues.put("password", uRLCredential.getPassword());
        return (long) this.credentialDatabaseHelper.getWritableDatabase().update(URLCredentialContract.FeedEntry.TABLE_NAME, contentValues, "protection_space_id = ?", new String[]{uRLCredential.getProtectionSpaceId().toString()});
    }
}
