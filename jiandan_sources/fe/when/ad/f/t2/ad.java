package fe.when.ad.f.t2;

import fe.when.ad.f.xxx;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ad extends fe {

    /* renamed from: de  reason: collision with root package name */
    public static final String[] f9774de = {"ি", "ে", "ৈ"};

    /* renamed from: ad  reason: collision with root package name */
    public final Map<String, xxx> f9775ad;
    public final Map<Integer, int[]> qw;

    public ad(Map<Integer, int[]> map, Map<String, xxx> map2) {
        this.qw = map;
        this.f9775ad = map2;
    }

    public List<String> ad() {
        return Arrays.asList(f9774de);
    }

    public final xxx fe(char c) {
        xxx xxx = this.f9775ad.get(String.valueOf(c));
        if (xxx != null) {
            return xxx;
        }
        int[] iArr = this.qw.get(Integer.valueOf(c));
        return new xxx(iArr[0], iArr[1], String.valueOf(c));
    }

    public void qw(List<xxx> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            xxx xxx = list.get(i2);
            if (xxx.f9841de.equals("ো")) {
                rg(i2, list, 2503, 2494);
            } else if (xxx.f9841de.equals("ৌ")) {
                rg(i2, list, 2503, 2519);
            }
        }
        super.qw(list);
    }

    public final void rg(int i2, List<xxx> list, char c, char c2) {
        xxx fe2 = fe(c);
        xxx fe3 = fe(c2);
        list.set(i2, fe2);
        list.add(i2 + 1, fe3);
    }
}
