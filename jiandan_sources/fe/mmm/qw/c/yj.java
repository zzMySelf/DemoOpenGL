package fe.mmm.qw.c;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class yj {
    public static Comparator<th> qw = new qw();

    public class qw implements Comparator<th> {
        /* renamed from: qw */
        public int compare(th thVar, th thVar2) {
            return thVar.uk() - thVar2.uk();
        }
    }

    public static void qw(List<th> list) {
        if (list.size() > 1) {
            Collections.sort(list, qw);
        }
    }
}
