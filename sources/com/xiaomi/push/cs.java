package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cq;

class cs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6812a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ cq.a f217a;

    cs(cq.a aVar, Context context) {
        this.f217a = aVar;
        this.f6812a = context;
    }

    public void run() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a2 = this.f217a.a();
            if (a2 != null && a2.isOpen()) {
                a2.beginTransaction();
                this.f217a.a(this.f6812a, a2);
                a2.setTransactionSuccessful();
            }
            if (a2 != null) {
                try {
                    a2.endTransaction();
                } catch (Exception e2) {
                    e = e2;
                    b.a((Throwable) e);
                    this.f217a.a(this.f6812a);
                }
            }
            if (this.f217a.f208a != null) {
                this.f217a.f208a.close();
            }
        } catch (Exception e3) {
            b.a((Throwable) e3);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e4) {
                    e = e4;
                    b.a((Throwable) e);
                    this.f217a.a(this.f6812a);
                }
            }
            if (this.f217a.f208a != null) {
                this.f217a.f208a.close();
            }
        } catch (Throwable th2) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e5) {
                    b.a((Throwable) e5);
                    this.f217a.a(this.f6812a);
                    throw th2;
                }
            }
            if (this.f217a.f208a != null) {
                this.f217a.f208a.close();
            }
            this.f217a.a(this.f6812a);
            throw th2;
        }
        this.f217a.a(this.f6812a);
    }
}
