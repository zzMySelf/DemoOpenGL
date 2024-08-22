package th.na.na.th;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import th.na.th.na.na;
import th.na.th.th.li;
import th.na.th.th.na.re;
import th.na.th.th.th.mo;

/* compiled from: EtnDownSoHelper */
public class ma implements na {
    public Map<String, Integer> li = new HashMap();
    public Context na;

    /* renamed from: th  reason: collision with root package name */
    public List<th.na.th.na.th> f7812th;

    /* compiled from: EtnDownSoHelper */
    private static class th {

        /* renamed from: th  reason: collision with root package name */
        public static ma f7813th = new ma((na) null);
    }

    public /* synthetic */ ma(na naVar) {
    }

    public static ma th(Context context) {
        th.f7813th.na = context.getApplicationContext();
        return th.f7813th;
    }

    public void li(String str) {
        th.mo(str);
    }

    public boolean na(String str) {
        boolean z;
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        Context context = this.na;
        if (context == null) {
            z = false;
        } else {
            z = th.na.th.th.ma.th.na().na(context, file);
        }
        if (z) {
            return true;
        }
        try {
            th.na.th.th.ma.th.na().th(this.na, file);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Context context2 = this.na;
        if (context2 == null) {
            return false;
        }
        return th.na.th.th.ma.th.na().na(context2, file);
    }

    public void th(th.na.th.na.th thVar) {
        if (thVar != null) {
            List<th.na.th.na.th> list = this.f7812th;
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                this.f7812th = arrayList;
                arrayList.add(thVar);
            } else if (!list.contains(thVar)) {
                this.f7812th.add(thVar);
            }
        }
    }

    public void th(String str, boolean z, th.na.th.na.th thVar) {
        String th2 = th.th(this.na);
        if (TextUtils.isEmpty(str)) {
            thVar.onDownloadFail(str, 108, "download url is empty.");
        } else if (th.na(this.na, str, th2)) {
            if (thVar != null) {
                thVar.onDownloadSuccess(str, th.th(this.na, str, th2));
            }
        } else if (!z) {
            th(str, th2, Looper.getMainLooper(), thVar);
        } else if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            Log.d("EtnDownSo", "start down so main thread");
            th(str, th2, Looper.getMainLooper(), thVar);
        } else {
            Looper.prepare();
            Log.d("EtnDownSo", "start down so sub thread");
            th(str, th2, Looper.myLooper(), thVar);
            Looper.loop();
        }
    }

    public void th(String str, String str2, String str3, boolean z, th.na.th.na.th thVar) {
        if (TextUtils.isEmpty(str)) {
            thVar.onDownloadFail(str, 108, "download url is empty.");
        } else if (!th.na(this.na, str, str2)) {
            if (!th(str)) {
                th.na.th.th.ma.th.th(new File(str2));
            }
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!z) {
                th(str, str2, str3, Looper.getMainLooper(), thVar);
            } else if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                Log.d("EtnDownSo", "start down so main thread");
                th(str, str2, str3, Looper.getMainLooper(), thVar);
            } else {
                Looper.prepare();
                Log.d("EtnDownSo", "start down so sub thread");
                th(str, str2, str3, Looper.myLooper(), thVar);
                Looper.loop();
            }
        } else if (thVar != null) {
            thVar.onDownloadSuccess(str, th.th(this.na, str, str2));
        }
    }

    public final void th(String str, String str2, Looper looper, th.na.th.na.th thVar) {
        String str3 = str;
        String str4 = str2;
        if (!th(str)) {
            th.na.th.th.ma.th.th(new File(str2));
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.li.put(str, 1);
        String th2 = th.th(this.na, str, str2);
        File file2 = new File(th2 + ".temp");
        File file3 = new File(th2 + ".zip");
        Log.d("EtnDownSo", "start down folder=" + str2 + " name=" + file2.getName());
        li.th().th(str, str2, file2.getName(), looper, new na(this, thVar, str, file2, file3, th2));
    }

    public final void th(String str, String str2, String str3, Looper looper, th.na.th.na.th thVar) {
        String str4 = str;
        this.li.put(str, 1);
        String str5 = str2;
        String th2 = th.th(this.na, str, str2);
        File file = new File(th2 + ".temp");
        File file2 = new File(th2 + ".zip");
        li.th().th(str, str2, file.getName(), looper, new li(this, thVar, str, file, file2, str3));
    }

    public final boolean th(String str) {
        mo moVar;
        li th2 = li.th();
        String th3 = th2.th(str);
        if (!th2.na.containsKey(th3) || (moVar = th2.na.get(th3)) == null) {
            return false;
        }
        return ((re) moVar).th();
    }

    public final void th(th.na.th.na.th thVar, String str) {
        if (thVar != null) {
            thVar.onDownloadStart(str);
        }
        if (this.f7812th != null) {
            for (int i2 = 0; i2 < this.f7812th.size(); i2++) {
                this.f7812th.get(i2).onDownloadStart(str);
            }
        }
    }

    public final void th(th.na.th.na.th thVar, String str, float f2) {
        if (thVar != null) {
            thVar.onDownloadProgress(f2);
        }
        if (this.f7812th != null) {
            for (int i2 = 0; i2 < this.f7812th.size(); i2++) {
                this.f7812th.get(i2).onDownloadProgress(f2);
            }
        }
    }

    public static /* synthetic */ void th(ma maVar, th.na.th.na.th thVar, String str, String str2) {
        maVar.li.put(str, 3);
        if (thVar != null) {
            thVar.onDownloadSuccess(str, str2);
        }
        if (maVar.f7812th != null) {
            for (int i2 = 0; i2 < maVar.f7812th.size(); i2++) {
                maVar.f7812th.get(i2).onDownloadSuccess(str, str2);
            }
        }
    }

    public static /* synthetic */ void th(ma maVar, th.na.th.na.th thVar, String str, int i2, String str2) {
        maVar.li.put(str, 2);
        if (thVar != null) {
            thVar.onDownloadFail(str, i2, str2);
        }
        if (maVar.f7812th != null) {
            for (int i3 = 0; i3 < maVar.f7812th.size(); i3++) {
                maVar.f7812th.get(i3).onDownloadFail(str, i2, str2);
            }
        }
    }
}
