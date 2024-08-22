package fe.when.ad.g.ad.fe;

import com.itextpdf.text.xml.simpleparser.NewLineHandler;
import java.util.HashSet;
import java.util.Set;

public class qw implements NewLineHandler {
    public final Set<String> qw;

    public qw() {
        HashSet hashSet = new HashSet();
        this.qw = hashSet;
        hashSet.add("p");
        this.qw.add("blockquote");
        this.qw.add("br");
    }

    public boolean qw(String str) {
        return this.qw.contains(str);
    }
}
