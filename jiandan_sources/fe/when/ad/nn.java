package fe.when.ad;

import androidx.core.app.NotificationCompat;
import androidx.core.net.MailTo;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import java.util.ArrayList;
import java.util.List;

public class nn implements Element {

    /* renamed from: ad  reason: collision with root package name */
    public final int f9875ad;

    /* renamed from: th  reason: collision with root package name */
    public final StringBuffer f9876th;

    public nn(int i2, String str) {
        this.f9875ad = i2;
        this.f9876th = new StringBuffer(str);
    }

    public String ad() {
        switch (this.f9875ad) {
            case 1:
                return "title";
            case 2:
                return MailTo.SUBJECT;
            case 3:
                return "keywords";
            case 4:
                return NotificationCompat.CarExtender.KEY_AUTHOR;
            case 5:
                return "producer";
            case 6:
                return "creationdate";
            default:
                return "unknown";
        }
    }

    public List<fe> getChunks() {
        return new ArrayList();
    }

    public boolean isContent() {
        return false;
    }

    public boolean isNestable() {
        return false;
    }

    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.ad(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public String qw() {
        return this.f9876th.toString();
    }

    public int type() {
        return this.f9875ad;
    }
}
