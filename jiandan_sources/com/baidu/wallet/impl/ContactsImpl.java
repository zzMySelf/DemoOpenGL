package com.baidu.wallet.impl;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import com.baidu.wallet.api.internal.IContacts;

public class ContactsImpl implements IContacts {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (r0 == null) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r0 != null) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int countOfContacts(@androidx.annotation.NonNull android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = "android.permission.READ_CONTACTS"
            boolean r0 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r9, r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.String r0 = "_id"
            java.lang.String[] r4 = new java.lang.String[]{r0}
            r0 = 0
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch:{ Exception -> 0x0036, all -> 0x002f }
            java.lang.String r9 = "content://com.android.contacts/contacts"
            android.net.Uri r3 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x0036, all -> 0x002f }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0036, all -> 0x002f }
            if (r0 == 0) goto L_0x0029
            int r9 = r0.getCount()     // Catch:{ Exception -> 0x0036, all -> 0x002f }
            r1 = r9
        L_0x0029:
            if (r0 == 0) goto L_0x003a
        L_0x002b:
            r0.close()
            goto L_0x003a
        L_0x002f:
            r9 = move-exception
            if (r0 == 0) goto L_0x0035
            r0.close()
        L_0x0035:
            throw r9
        L_0x0036:
            if (r0 == 0) goto L_0x003a
            goto L_0x002b
        L_0x003a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.impl.ContactsImpl.countOfContacts(android.content.Context):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
        if (r6 != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
        if (r6 == null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.baidu.wallet.core.utils.contacts.ContractInfo> loadAllPhone(@androidx.annotation.NonNull android.content.Context r8) {
        /*
            r7 = this;
            java.lang.String r0 = "android.permission.READ_CONTACTS"
            boolean r0 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r8, r0)
            if (r0 != 0) goto L_0x000d
            java.util.List r8 = java.util.Collections.emptyList()
            return r8
        L_0x000d:
            android.content.ContentResolver r0 = r8.getContentResolver()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r6 = 0
            android.net.Uri r1 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            java.lang.String r2 = "display_name"
            java.lang.String r3 = "data1"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r6 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            if (r6 == 0) goto L_0x005d
        L_0x002a:
            boolean r0 = r6.moveToNext()     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            if (r0 == 0) goto L_0x005d
            r0 = 0
            java.lang.String r0 = r6.getString(r0)     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            r1 = 1
            java.lang.String r1 = r6.getString(r1)     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            if (r2 != 0) goto L_0x002a
            java.lang.String r2 = "[ |-]+"
            java.lang.String r3 = ""
            java.lang.String r1 = r1.replaceAll(r2, r3)     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            if (r2 != 0) goto L_0x002a
            com.baidu.wallet.core.utils.contacts.ContractInfo r2 = new com.baidu.wallet.core.utils.contacts.ContractInfo     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            r2.<init>()     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            r2.setName(r0)     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            r2.setMobile(r1)     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            r8.add(r2)     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            goto L_0x002a
        L_0x005d:
            if (r6 == 0) goto L_0x006d
            goto L_0x006a
        L_0x0060:
            r8 = move-exception
            if (r6 == 0) goto L_0x0066
            r6.close()
        L_0x0066:
            throw r8
        L_0x0067:
            if (r6 == 0) goto L_0x006d
        L_0x006a:
            r6.close()
        L_0x006d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.impl.ContactsImpl.loadAllPhone(android.content.Context):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> loadPhoneContactsForChargeFragment(@androidx.annotation.NonNull android.net.Uri r9, @androidx.annotation.NonNull android.content.Context r10) {
        /*
            r8 = this;
            java.lang.String r0 = "android.permission.READ_CONTACTS"
            boolean r0 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r10, r0)
            if (r0 != 0) goto L_0x000d
            java.util.List r9 = java.util.Collections.emptyList()
            return r9
        L_0x000d:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.ContentResolver r10 = r10.getContentResolver()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r1 = r10
            r2 = r9
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x00be, all -> 0x00b1 }
            if (r9 == 0) goto L_0x00ab
            r9.moveToFirst()     // Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            java.lang.String r1 = "display_name"
            int r1 = r9.getColumnIndex(r1)     // Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            r0.add(r1)     // Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            java.lang.String r1 = "_id"
            int r1 = r9.getColumnIndex(r1)     // Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            android.net.Uri r2 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI     // Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            r4.<init>()     // Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            java.lang.String r5 = "contact_id="
            r4.append(r5)     // Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            r4.append(r1)     // Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            r5 = 0
            r6 = 0
            r1 = r10
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            if (r10 == 0) goto L_0x009a
            int r1 = r10.getCount()     // Catch:{ Exception -> 0x0098, all -> 0x0096 }
            if (r1 <= 0) goto L_0x008b
            r10.moveToFirst()     // Catch:{ Exception -> 0x0098, all -> 0x0096 }
        L_0x0063:
            java.lang.String r1 = "data1"
            int r1 = r10.getColumnIndex(r1)     // Catch:{ Exception -> 0x0098, all -> 0x0096 }
            java.lang.String r1 = r10.getString(r1)     // Catch:{ Exception -> 0x0098, all -> 0x0096 }
            java.lang.String r1 = com.baidu.apollon.utils.StringUtils.formatPhoneNumber(r1)     // Catch:{ Exception -> 0x0098, all -> 0x0096 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0098, all -> 0x0096 }
            if (r2 != 0) goto L_0x007a
            r0.add(r1)     // Catch:{ Exception -> 0x0098, all -> 0x0096 }
        L_0x007a:
            boolean r1 = r10.moveToNext()     // Catch:{ Exception -> 0x0098, all -> 0x0096 }
            if (r1 != 0) goto L_0x0063
            if (r9 == 0) goto L_0x0085
            r9.close()
        L_0x0085:
            if (r10 == 0) goto L_0x008a
            r10.close()
        L_0x008a:
            return r0
        L_0x008b:
            if (r9 == 0) goto L_0x0090
            r9.close()
        L_0x0090:
            if (r10 == 0) goto L_0x0095
            r10.close()
        L_0x0095:
            return r7
        L_0x0096:
            r0 = move-exception
            goto L_0x00a7
        L_0x0098:
            goto L_0x00c0
        L_0x009a:
            if (r9 == 0) goto L_0x009f
            r9.close()
        L_0x009f:
            if (r10 == 0) goto L_0x00a4
            r10.close()
        L_0x00a4:
            return r7
        L_0x00a5:
            r0 = move-exception
            r10 = r7
        L_0x00a7:
            r7 = r9
            goto L_0x00b3
        L_0x00a9:
            r10 = r7
            goto L_0x00c0
        L_0x00ab:
            if (r9 == 0) goto L_0x00b0
            r9.close()
        L_0x00b0:
            return r7
        L_0x00b1:
            r0 = move-exception
            r10 = r7
        L_0x00b3:
            if (r7 == 0) goto L_0x00b8
            r7.close()
        L_0x00b8:
            if (r10 == 0) goto L_0x00bd
            r10.close()
        L_0x00bd:
            throw r0
        L_0x00be:
            r9 = r7
            r10 = r9
        L_0x00c0:
            if (r9 == 0) goto L_0x00c5
            r9.close()
        L_0x00c5:
            if (r10 == 0) goto L_0x00ca
            r10.close()
        L_0x00ca:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.impl.ContactsImpl.loadPhoneContactsForChargeFragment(android.net.Uri, android.content.Context):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        if (r7 != null) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
        if (r7 == null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0078, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
        return r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.concurrent.ConcurrentHashMap<java.lang.String, com.baidu.wallet.core.utils.contacts.ContractInfo> loadPhoneContracts(@androidx.annotation.NonNull android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "android.permission.READ_CONTACTS"
            boolean r1 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r9, r1)
            if (r1 != 0) goto L_0x0010
            java.util.concurrent.ConcurrentHashMap r9 = new java.util.concurrent.ConcurrentHashMap
            r9.<init>()
            return r9
        L_0x0010:
            android.content.ContentResolver r1 = r9.getContentResolver()
            java.util.concurrent.ConcurrentHashMap r9 = new java.util.concurrent.ConcurrentHashMap
            r9.<init>()
            r7 = 0
            android.net.Uri r2 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            if (r7 == 0) goto L_0x006b
        L_0x0026:
            boolean r1 = r7.moveToNext()     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            if (r1 == 0) goto L_0x006b
            java.lang.String r1 = "display_name"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            java.lang.String r1 = r7.getString(r1)     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            java.lang.String r2 = "data1"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            if (r3 != 0) goto L_0x0026
            java.lang.String r3 = " "
            java.lang.String r2 = r2.replaceAll(r3, r0)     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            java.lang.String r3 = "-"
            java.lang.String r2 = r2.replaceAll(r3, r0)     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            java.lang.String r2 = com.baidu.apollon.utils.StringUtils.formatPhoneNumber(r2)     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            if (r3 != 0) goto L_0x0026
            com.baidu.wallet.core.utils.contacts.ContractInfo r3 = new com.baidu.wallet.core.utils.contacts.ContractInfo     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            r3.<init>()     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            r3.setName(r1)     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            r3.setMobile(r2)     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            r9.put(r2, r3)     // Catch:{ Exception -> 0x0075, all -> 0x006e }
            goto L_0x0026
        L_0x006b:
            if (r7 == 0) goto L_0x007b
            goto L_0x0078
        L_0x006e:
            r9 = move-exception
            if (r7 == 0) goto L_0x0074
            r7.close()
        L_0x0074:
            throw r9
        L_0x0075:
            if (r7 == 0) goto L_0x007b
        L_0x0078:
            r7.close()
        L_0x007b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.impl.ContactsImpl.loadPhoneContracts(android.content.Context):java.util.concurrent.ConcurrentHashMap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> loadRawPhone(@androidx.annotation.NonNull android.net.Uri r11, @androidx.annotation.NonNull android.content.Context r12) {
        /*
            r10 = this;
            java.lang.String r0 = "android.permission.READ_CONTACTS"
            boolean r0 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r12, r0)
            if (r0 != 0) goto L_0x000d
            java.util.List r11 = java.util.Collections.emptyList()
            return r11
        L_0x000d:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.ContentResolver r12 = r12.getContentResolver()
            r7 = 0
            java.lang.String r1 = "lookup"
            java.lang.String[] r3 = new java.lang.String[]{r1}     // Catch:{ all -> 0x0092 }
            r4 = 0
            r5 = 0
            r6 = 0
            r1 = r12
            r2 = r11
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0092 }
            if (r11 == 0) goto L_0x007b
            boolean r1 = r11.moveToNext()     // Catch:{ all -> 0x0079 }
            if (r1 == 0) goto L_0x007b
            r8 = 0
            java.lang.String r1 = r11.getString(r8)     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = "display_name"
            java.lang.String r3 = "data1"
            java.lang.String[] r3 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x0079 }
            java.lang.String r4 = "lookup=?"
            android.net.Uri r2 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI     // Catch:{ all -> 0x0079 }
            r9 = 1
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch:{ all -> 0x0079 }
            r5[r8] = r1     // Catch:{ all -> 0x0079 }
            r6 = 0
            r1 = r12
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0079 }
            r1 = 1
        L_0x004b:
            if (r12 == 0) goto L_0x007c
            boolean r2 = r12.moveToNext()     // Catch:{ all -> 0x0090 }
            if (r2 == 0) goto L_0x007c
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = r12.getString(r8)     // Catch:{ all -> 0x0090 }
            r0.add(r1)     // Catch:{ all -> 0x0090 }
            r1 = 0
        L_0x005d:
            java.lang.String r2 = r12.getString(r9)     // Catch:{ all -> 0x0090 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0090 }
            if (r3 != 0) goto L_0x004b
            java.lang.String r3 = "[ |-]+"
            java.lang.String r4 = ""
            java.lang.String r2 = r2.replaceAll(r3, r4)     // Catch:{ all -> 0x0090 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0090 }
            if (r3 != 0) goto L_0x004b
            r0.add(r2)     // Catch:{ all -> 0x0090 }
            goto L_0x004b
        L_0x0079:
            r12 = r7
            goto L_0x0094
        L_0x007b:
            r12 = r7
        L_0x007c:
            int r1 = r0.size()     // Catch:{ all -> 0x0090 }
            r2 = 2
            if (r1 >= r2) goto L_0x0084
            r0 = r7
        L_0x0084:
            if (r12 == 0) goto L_0x0089
            r12.close()
        L_0x0089:
            if (r11 == 0) goto L_0x008e
            r11.close()
        L_0x008e:
            r7 = r0
            goto L_0x009e
        L_0x0090:
            goto L_0x0094
        L_0x0092:
            r11 = r7
            r12 = r11
        L_0x0094:
            if (r12 == 0) goto L_0x0099
            r12.close()
        L_0x0099:
            if (r11 == 0) goto L_0x009e
            r11.close()
        L_0x009e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.impl.ContactsImpl.loadRawPhone(android.net.Uri, android.content.Context):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0069, code lost:
        if (r8 != null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0074, code lost:
        if (r8 == null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0076, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0079, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.concurrent.ConcurrentHashMap<java.lang.String, com.baidu.wallet.core.utils.contacts.ContractInfo> loadSimContracts(@androidx.annotation.NonNull android.content.Context r8) {
        /*
            r7 = this;
            java.lang.String r0 = "android.permission.READ_CONTACTS"
            boolean r0 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r8, r0)
            if (r0 != 0) goto L_0x000e
            java.util.concurrent.ConcurrentHashMap r8 = new java.util.concurrent.ConcurrentHashMap
            r8.<init>()
            return r8
        L_0x000e:
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            android.content.ContentResolver r1 = r8.getContentResolver()
            java.lang.String r8 = "content://icc/adn"
            android.net.Uri r2 = android.net.Uri.parse(r8)
            r8 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0073, all -> 0x006c }
            if (r8 == 0) goto L_0x0069
        L_0x0028:
            boolean r1 = r8.moveToNext()     // Catch:{ Exception -> 0x0073, all -> 0x006c }
            if (r1 == 0) goto L_0x0069
            java.lang.String r1 = "name"
            int r1 = r8.getColumnIndex(r1)     // Catch:{ Exception -> 0x0073, all -> 0x006c }
            java.lang.String r1 = r8.getString(r1)     // Catch:{ Exception -> 0x0073, all -> 0x006c }
            java.lang.String r2 = "number"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ Exception -> 0x0073, all -> 0x006c }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0073, all -> 0x006c }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0073, all -> 0x006c }
            if (r3 != 0) goto L_0x0028
            java.lang.String r3 = " "
            java.lang.String r4 = ""
            java.lang.String r2 = r2.replaceAll(r3, r4)     // Catch:{ Exception -> 0x0073, all -> 0x006c }
            java.lang.String r2 = com.baidu.apollon.utils.StringUtils.formatPhoneNumber(r2)     // Catch:{ Exception -> 0x0073, all -> 0x006c }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0073, all -> 0x006c }
            if (r3 != 0) goto L_0x0028
            com.baidu.wallet.core.utils.contacts.ContractInfo r3 = new com.baidu.wallet.core.utils.contacts.ContractInfo     // Catch:{ Exception -> 0x0073, all -> 0x006c }
            r3.<init>()     // Catch:{ Exception -> 0x0073, all -> 0x006c }
            r3.setName(r1)     // Catch:{ Exception -> 0x0073, all -> 0x006c }
            r3.setMobile(r2)     // Catch:{ Exception -> 0x0073, all -> 0x006c }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0073, all -> 0x006c }
            goto L_0x0028
        L_0x0069:
            if (r8 == 0) goto L_0x0079
            goto L_0x0076
        L_0x006c:
            r0 = move-exception
            if (r8 == 0) goto L_0x0072
            r8.close()
        L_0x0072:
            throw r0
        L_0x0073:
            if (r8 == 0) goto L_0x0079
        L_0x0076:
            r8.close()
        L_0x0079:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.impl.ContactsImpl.loadSimContracts(android.content.Context):java.util.concurrent.ConcurrentHashMap");
    }

    public boolean pickContactsByContactsContentUri(@NonNull Activity activity, int i2) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setData(ContactsContract.Contacts.CONTENT_URI);
        if (activity != null) {
            try {
                activity.startActivityForResult(intent, i2);
                return true;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean pickContactsByPhoneContentType(@NonNull Activity activity, int i2) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("vnd.android.cursor.dir/phone_v2");
        if (activity != null) {
            try {
                activity.startActivityForResult(intent, i2);
                return true;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
