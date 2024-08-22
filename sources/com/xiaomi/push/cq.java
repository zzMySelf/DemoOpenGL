package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.push.service.az;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class cq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile cq f6800a;

    /* renamed from: a  reason: collision with other field name */
    private Context f203a;

    /* renamed from: a  reason: collision with other field name */
    private cp f204a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<a> f205a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, co> f206a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f207a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private cq(Context context) {
        this.f203a = context;
    }

    public static cq a(Context context) {
        if (f6800a == null) {
            synchronized (cq.class) {
                if (f6800a == null) {
                    f6800a = new cq(context);
                }
            }
        }
        return f6800a;
    }

    private void a() {
        ag.a(this.f203a).b(new cr(this), az.a(this.f203a).a(ir.StatDataProcessFrequency.a(), 5));
    }

    public void a(a aVar) {
        co coVar;
        if (aVar != null) {
            if (this.f204a != null) {
                String a2 = aVar.a();
                synchronized (this.f206a) {
                    coVar = this.f206a.get(a2);
                    if (coVar == null) {
                        coVar = this.f204a.a(this.f203a, a2);
                        this.f206a.put(a2, coVar);
                    }
                }
                if (!this.f207a.isShutdown()) {
                    aVar.a(coVar, this.f203a);
                    synchronized (this.f205a) {
                        this.f205a.add(aVar);
                        a();
                    }
                    return;
                }
                return;
            }
            throw new IllegalStateException("should exec init method first!");
        }
    }

    public void b(a aVar) {
        co coVar;
        if (aVar != null) {
            if (this.f204a != null) {
                String a2 = aVar.a();
                synchronized (this.f206a) {
                    coVar = this.f206a.get(a2);
                    if (coVar == null) {
                        coVar = this.f204a.a(this.f203a, a2);
                        this.f206a.put(a2, coVar);
                    }
                }
                if (!this.f207a.isShutdown()) {
                    aVar.a(coVar, this.f203a);
                    a((Runnable) aVar);
                    return;
                }
                return;
            }
            throw new IllegalStateException("should exec init method first!");
        }
    }

    public void a(Runnable runnable) {
        if (!this.f207a.isShutdown()) {
            this.f207a.execute(runnable);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8360a(String str) {
        return a(str).a();
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f204a != null) {
            HashMap hashMap = new HashMap();
            if (!this.f207a.isShutdown()) {
                Iterator<a> it = arrayList.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.a()) {
                        next.a(a(next.a()), this.f203a);
                    }
                    ArrayList arrayList2 = (ArrayList) hashMap.get(next.a());
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        hashMap.put(next.a(), arrayList2);
                    }
                    arrayList2.add(next);
                }
                for (String str : hashMap.keySet()) {
                    ArrayList arrayList3 = (ArrayList) hashMap.get(str);
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        c cVar = new c(str, arrayList3);
                        cVar.a(((a) arrayList3.get(0)).f208a, this.f203a);
                        this.f207a.execute(cVar);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    private co a(String str) {
        co coVar = this.f206a.get(str);
        if (coVar == null) {
            synchronized (this.f206a) {
                if (coVar == null) {
                    coVar = this.f204a.a(this.f203a, str);
                    this.f206a.put(str, coVar);
                }
            }
        }
        return coVar;
    }

    public static class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<a> f6808a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.f6808a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.f6808a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context, sQLiteDatabase);
                }
            }
        }

        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.f6808a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }
    }

    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private int f6801a = 0;

        /* renamed from: a  reason: collision with other field name */
        protected co f208a = null;

        /* renamed from: a  reason: collision with other field name */
        private a f209a;

        /* renamed from: a  reason: collision with other field name */
        private String f210a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f211a;

        /* renamed from: a  reason: collision with other field name */
        private Random f212a = new Random();

        /* renamed from: b  reason: collision with root package name */
        protected String f6802b;

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public a(String str) {
            this.f210a = str;
        }

        /* access modifiers changed from: package-private */
        public void a(co coVar, Context context) {
            this.f208a = coVar;
            this.f6802b = coVar.a();
            this.f211a = new WeakReference<>(context);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m8363a() {
            return this.f208a == null || TextUtils.isEmpty(this.f6802b) || this.f211a == null;
        }

        public void a(a aVar) {
            this.f209a = aVar;
        }

        public void a(Context context, Object obj) {
            cq.a(context).a(this);
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m8361a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m8362a() {
            return this.f210a;
        }

        public final void run() {
            Context context;
            WeakReference<Context> weakReference = this.f211a;
            if (weakReference != null && (context = (Context) weakReference.get()) != null && context.getFilesDir() != null && this.f208a != null && !TextUtils.isEmpty(this.f210a)) {
                File file = new File(this.f210a);
                u.a(context, new File(file.getParentFile(), bn.b(file.getAbsolutePath())), new cs(this, context));
            }
        }

        public SQLiteDatabase a() {
            return this.f208a.getWritableDatabase();
        }

        /* access modifiers changed from: package-private */
        public void a(Context context) {
            a aVar = this.f209a;
            if (aVar != null) {
                aVar.a(context, a());
            }
            b(context);
        }

        public void b(Context context) {
        }
    }

    public static abstract class b<T> extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f6803a;

        /* renamed from: a  reason: collision with other field name */
        private String f213a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f214a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f215a;

        /* renamed from: b  reason: collision with root package name */
        private List<T> f6804b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private String f6805c;

        /* renamed from: d  reason: collision with root package name */
        private String f6806d;

        /* renamed from: e  reason: collision with root package name */
        private String f6807e;

        public abstract T a(Context context, Cursor cursor);

        public abstract void a(Context context, List<T> list);

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i2) {
            super(str);
            this.f214a = list;
            this.f213a = str2;
            this.f215a = strArr;
            this.f6805c = str3;
            this.f6806d = str4;
            this.f6807e = str5;
            this.f6803a = i2;
        }

        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.f6804b.clear();
            List<String> list = this.f214a;
            String str = null;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f214a.size()];
                this.f214a.toArray(strArr2);
                strArr = strArr2;
            }
            int i2 = this.f6803a;
            if (i2 > 0) {
                str = String.valueOf(i2);
            }
            Cursor query = sQLiteDatabase.query(this.f6802b, strArr, this.f213a, this.f215a, this.f6805c, this.f6806d, this.f6807e, str);
            if (query != null && query.moveToFirst()) {
                do {
                    Object a2 = a(context, query);
                    if (a2 != null) {
                        this.f6804b.add(a2);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, this.f6804b);
        }

        public SQLiteDatabase a() {
            return this.f208a.getReadableDatabase();
        }
    }

    public static class e extends a {

        /* renamed from: a  reason: collision with root package name */
        private ContentValues f6810a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f6810a = contentValues;
        }

        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f6802b, (String) null, this.f6810a);
        }
    }

    public static class d extends a {

        /* renamed from: a  reason: collision with root package name */
        private String f6809a;

        /* renamed from: a  reason: collision with other field name */
        protected String[] f216a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f6809a = str2;
            this.f216a = strArr;
        }

        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f6802b, this.f6809a, this.f216a);
        }
    }
}
