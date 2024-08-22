package fe.when.ad;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import java.util.List;
import java.util.Properties;

public class xxx implements Element {

    /* renamed from: ad  reason: collision with root package name */
    public Element f9901ad;

    /* renamed from: th  reason: collision with root package name */
    public Properties f9902th;

    public xxx() {
        this.f9902th = new Properties();
        this.f9901ad = null;
    }

    public List<fe> getChunks() {
        return this.f9901ad.getChunks();
    }

    public boolean isContent() {
        return true;
    }

    public boolean isNestable() {
        return true;
    }

    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.ad(this.f9901ad);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public int type() {
        return 50;
    }

    public xxx(Element element) {
        this.f9902th = new Properties();
        this.f9901ad = element;
    }
}
