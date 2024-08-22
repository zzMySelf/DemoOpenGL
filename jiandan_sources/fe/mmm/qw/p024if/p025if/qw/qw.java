package fe.mmm.qw.p024if.p025if.qw;

import android.app.Activity;
import android.app.Application;
import com.tera.scan.flutter.documentscan.OCRRectifyActivity;
import fe.mmm.qw.p024if.fe.de;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: fe.mmm.qw.if.if.qw.qw  reason: invalid package */
public class qw {
    public void ad(Activity activity, String str, int i2, int i3, int i4, String str2, String str3) {
        Activity activity2 = activity;
        if (activity2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            OCRRectifyActivity.startActivityForResult(activity2, (String) null, new fe.mmm.qw.p024if.yj.qw.qw(arrayList, i2, i3, new ArrayList(), 0, 0, new HashMap(), "from_shot", new ArrayList(), str2, "", str3), i4);
        }
    }

    public void de(Activity activity, ArrayList<String> arrayList, int i2, Boolean bool, String str, String str2, String str3) {
        ArrayList<String> arrayList2 = arrayList;
        if (arrayList2 != null && !arrayList.isEmpty()) {
            int i3 = bool.booleanValue() ^ true ? 1 : 0;
            Activity activity2 = activity;
            OCRRectifyActivity.startActivity(activity2, new fe.mmm.qw.p024if.yj.qw.qw(new ArrayList(arrayList2), i2, 12, new ArrayList(), i3, 0, new HashMap(), str, new ArrayList(), str2, "", str3));
        }
    }

    public void fe(Activity activity, ArrayList<HashMap<String, Object>> arrayList, int i2, int i3, int i4, int i5, String str, String str2, String str3) {
        Activity activity2 = activity;
        if (activity2 != null && !activity.isFinishing() && arrayList != null && !arrayList.isEmpty()) {
            OCRRectifyActivity.startActivity(activity2, new fe.mmm.qw.p024if.yj.qw.qw(new ArrayList(), i2, i3, new ArrayList(), i4, i5, new HashMap(), str, arrayList, str2, "", str3));
        }
    }

    public void qw(Application application, List<Map<String, Object>> list, int i2) {
        new de(application).fe(list, i2);
    }

    public void rg(Activity activity, ArrayList<String> arrayList, int i2, int i3, ArrayList<String> arrayList2, int i4, int i5, String str, String str2, String str3) {
        if (arrayList != null && !arrayList.isEmpty()) {
            th(activity, arrayList, i2, i3, arrayList2, i4, i5, str, str2, "", str3);
        }
    }

    public void th(Activity activity, ArrayList<String> arrayList, int i2, int i3, ArrayList<String> arrayList2, int i4, int i5, String str, String str2, String str3, String str4) {
        ArrayList<String> arrayList3 = arrayList;
        if (arrayList3 != null && !arrayList.isEmpty()) {
            Activity activity2 = activity;
            OCRRectifyActivity.startActivity(activity2, new fe.mmm.qw.p024if.yj.qw.qw(new ArrayList(arrayList3), i2, i3, arrayList2, i4, i5, new HashMap(), str, new ArrayList(), str2, str3, str4));
        }
    }

    public void uk(Application application, List<Map<String, Object>> list) {
        new de(application).th(list);
    }

    public void yj(Activity activity, ArrayList<String> arrayList, int i2, int i3, String str) {
        rg(activity, arrayList, i2, i3, new ArrayList(), 1, 3, "", "", str);
    }
}
