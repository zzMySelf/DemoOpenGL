package fe.mmm.qw.d.de;

import android.app.Activity;
import android.widget.TextView;
import fe.mmm.qw.d.fe.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fe {
    public static Map<String, List<TextView>> qw = new HashMap();

    public static void ad(Activity activity) {
        qw.remove(activity.getLocalClassName());
    }

    public static void de(Activity activity, TextView textView) {
        if (qw.containsKey(activity.getLocalClassName())) {
            qw.get(activity.getLocalClassName()).remove(textView);
        }
    }

    public static void qw(Activity activity, TextView textView) {
        String localClassName = activity.getLocalClassName();
        if (qw.containsKey(localClassName)) {
            qw.get(localClassName).add(textView);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(textView);
            qw.put(localClassName, arrayList);
        }
        textView.setTypeface(i.qw);
    }
}
