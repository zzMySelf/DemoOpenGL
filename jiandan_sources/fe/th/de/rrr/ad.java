package fe.th.de.rrr;

import fe.th.de.pf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class ad {
    public static final Comparator<String> qw = new qw();

    public class qw implements Comparator<String> {
        /* renamed from: qw */
        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    }

    public static Map<String, List<String>> qw(pf pfVar, String str) {
        TreeMap treeMap = new TreeMap(qw);
        int yj2 = pfVar.yj();
        for (int i2 = 0; i2 < yj2; i2++) {
            String rg2 = pfVar.rg(i2);
            String uk2 = pfVar.uk(i2);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(rg2);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(uk2);
            treeMap.put(rg2, Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put((Object) null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }
}
