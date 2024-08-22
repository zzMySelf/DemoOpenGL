package com.baidu.wallet.utils;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.apollon.NoProguard;

public class ContactUtils implements NoProguard {
    public static void createNewPhoneNum(Activity activity, String str, String str2, int i2) {
        Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        intent.putExtra("name", str);
        intent.putExtra("phone", str2);
        activity.startActivityForResult(intent, i2);
    }

    public static void insertPhoneNumToAddressBook(Activity activity, String str, String str2, int i2) {
        createNewPhoneNum(activity, str, str2, i2);
    }

    public static boolean isIncludeTargetPhoneNumInfo(@NonNull Activity activity, String str, String str2, int i2) {
        Cursor cursor = null;
        try {
            Cursor query = activity.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"display_name", "data1"}, (String) null, (String[]) null, (String) null);
            if (query != null) {
                while (query.moveToNext()) {
                    String string = query.getString(0);
                    query.getString(1);
                    if (TextUtils.equals(string, str)) {
                        if (query != null) {
                            query.close();
                        }
                        return true;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return false;
            }
            if (query != null) {
                query.close();
            }
            return false;
        } catch (Exception unused) {
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public static void saveExistsPhoneNum(Activity activity, String str, String str2, int i2) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
        intent.setType("vnd.android.cursor.item/person");
        intent.setType("vnd.android.cursor.item/contact");
        intent.setType("vnd.android.cursor.item/raw_contact");
        intent.putExtra("name", str);
        intent.putExtra("phone", str2);
        intent.putExtra("phone_type", 3);
        activity.startActivityForResult(intent, i2);
    }
}
