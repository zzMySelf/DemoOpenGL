package fe.when.ad.f.t2;

import com.itextpdf.text.pdf.languages.GlyphRepositioner;
import fe.when.ad.f.xxx;
import java.util.List;

public abstract class fe implements GlyphRepositioner {
    public abstract List<String> ad();

    public final xxx de(List<xxx> list, int i2) {
        int i3 = i2 + 1;
        if (i3 < list.size()) {
            return list.get(i3);
        }
        return null;
    }

    public void qw(List<xxx> list) {
        int i2 = 0;
        while (i2 < list.size()) {
            xxx xxx = list.get(i2);
            xxx de2 = de(list, i2);
            if (de2 != null && ad().contains(de2.f9841de)) {
                list.set(i2, de2);
                i2++;
                list.set(i2, xxx);
            }
            i2++;
        }
    }
}
