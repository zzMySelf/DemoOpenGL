package com.baidu.wallet.lightapp.business.presenter;

import android.app.Activity;
import android.view.View;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.lightapp.business.datamodel.ContactInfo;
import com.baidu.wallet.lightapp.business.view.PhoneNumberSelectDialog;
import java.util.List;

public class ContactInfoPresenter {
    public Activity a;
    public b b;
    public int c;
    public String d = "";

    public ContactInfoPresenter(Activity activity, b bVar) {
        this.a = activity;
        this.b = bVar;
        this.c = a();
    }

    /* access modifiers changed from: private */
    public void c() {
        this.a = null;
        this.b = null;
    }

    public String b() {
        return ResUtils.getString(this.a, "wallet_base_select_phone_fail");
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null && "read_contact".equals(event.mEventKey)) {
            String str = (String) event.mEventObj;
            b bVar = this.b;
            if (bVar != null) {
                String[] strArr = {StringUtils.trimAll(this.d), StringUtils.trimAll(str)};
                bVar.onContactsSelected("", 0, strArr, "", this.c + "");
                c();
            }
        }
    }

    public int a() {
        if (this.a == null) {
            return 0;
        }
        return ContactManager.getIContactsImpl().countOfContacts(this.a);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|14|(1:16)|17|(1:26)) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        if (r11.b != null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005e, code lost:
        r5 = r11.b;
        r9 = b();
        r5.onContactsSelected("", 1, (java.lang.String[]) null, r9, r11.c + "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007e, code lost:
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0087, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0088, code lost:
        if (r4 != null) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008a, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008d, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.net.Uri r12) {
        /*
            r11 = this;
            java.lang.String r0 = "data2"
            java.lang.String r1 = "display_name"
            java.lang.String r2 = "data1"
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            android.app.Activity r4 = r11.a
            if (r4 != 0) goto L_0x0013
            r11.c()
            return
        L_0x0013:
            android.content.ContentResolver r5 = r4.getContentResolver()
            r4 = 0
            java.lang.String[] r7 = new java.lang.String[]{r2, r1, r0}     // Catch:{ Exception -> 0x005a }
            r8 = 0
            r9 = 0
            r10 = 0
            r6 = r12
            android.database.Cursor r4 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x005a }
            if (r4 == 0) goto L_0x0052
            boolean r12 = r4.moveToFirst()     // Catch:{ Exception -> 0x005a }
            if (r12 == 0) goto L_0x0052
            int r12 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x005a }
            java.lang.String r12 = r4.getString(r12)     // Catch:{ Exception -> 0x005a }
            int r1 = r4.getColumnIndex(r1)     // Catch:{ Exception -> 0x005a }
            java.lang.String r1 = r4.getString(r1)     // Catch:{ Exception -> 0x005a }
            r11.d = r1     // Catch:{ Exception -> 0x005a }
            int r0 = r4.getColumnIndex(r0)     // Catch:{ Exception -> 0x005a }
            int r0 = r4.getInt(r0)     // Catch:{ Exception -> 0x005a }
            com.baidu.wallet.lightapp.business.datamodel.ContactInfo$Phone r1 = new com.baidu.wallet.lightapp.business.datamodel.ContactInfo$Phone     // Catch:{ Exception -> 0x005a }
            r1.<init>()     // Catch:{ Exception -> 0x005a }
            r1.number = r12     // Catch:{ Exception -> 0x005a }
            r1.type = r0     // Catch:{ Exception -> 0x005a }
            r3.add(r1)     // Catch:{ Exception -> 0x005a }
        L_0x0052:
            java.lang.String r12 = r11.d     // Catch:{ Exception -> 0x005a }
            r11.a(r12, r3)     // Catch:{ Exception -> 0x005a }
            if (r4 == 0) goto L_0x0086
            goto L_0x0083
        L_0x005a:
            com.baidu.wallet.lightapp.business.presenter.b r12 = r11.b     // Catch:{ all -> 0x0087 }
            if (r12 == 0) goto L_0x007e
            com.baidu.wallet.lightapp.business.presenter.b r5 = r11.b     // Catch:{ all -> 0x0087 }
            java.lang.String r6 = ""
            r7 = 1
            r8 = 0
            java.lang.String r9 = r11.b()     // Catch:{ all -> 0x0087 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r12.<init>()     // Catch:{ all -> 0x0087 }
            int r0 = r11.c     // Catch:{ all -> 0x0087 }
            r12.append(r0)     // Catch:{ all -> 0x0087 }
            java.lang.String r0 = ""
            r12.append(r0)     // Catch:{ all -> 0x0087 }
            java.lang.String r10 = r12.toString()     // Catch:{ all -> 0x0087 }
            r5.onContactsSelected(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0087 }
        L_0x007e:
            r11.c()     // Catch:{ all -> 0x0087 }
            if (r4 == 0) goto L_0x0086
        L_0x0083:
            r4.close()
        L_0x0086:
            return
        L_0x0087:
            r12 = move-exception
            if (r4 == 0) goto L_0x008d
            r4.close()
        L_0x008d:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.business.presenter.ContactInfoPresenter.a(android.net.Uri):void");
    }

    private void a(String str, List<ContactInfo.Phone> list) {
        final PhoneNumberSelectDialog phoneNumberSelectDialog = new PhoneNumberSelectDialog(this.a);
        if (list == null || list.size() == 0) {
            b bVar = this.b;
            if (bVar != null) {
                String b2 = b();
                bVar.onContactsSelected("", 1, (String[]) null, b2, this.c + "");
            }
            c();
        } else if (list.size() == 1) {
            b bVar2 = this.b;
            if (bVar2 != null) {
                String[] strArr = {StringUtils.trimAll(str), StringUtils.trimAll(list.get(0).number)};
                bVar2.onContactsSelected("", 0, strArr, "", this.c + "");
            }
            c();
        } else {
            phoneNumberSelectDialog.setPhones(list);
            EventBus.getInstance().register((Object) this, "read_contact", 0, EventBus.ThreadMode.MainThread);
            phoneNumberSelectDialog.setNegativeBtn(new View.OnClickListener() {
                public void onClick(View view) {
                    phoneNumberSelectDialog.dismiss();
                    ContactInfoPresenter.this.c();
                }
            });
            phoneNumberSelectDialog.hidePositiveButton();
            phoneNumberSelectDialog.show();
        }
    }
}
