package fe.when.ad.f.p2;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.pdf.draw.DrawInterface;
import fe.when.ad.fe;
import java.util.ArrayList;
import java.util.List;

public class ad implements DrawInterface, Element {

    /* renamed from: ad  reason: collision with root package name */
    public float f9686ad = 0.0f;

    public List<fe> getChunks() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new fe((DrawInterface) this, true));
        return arrayList;
    }

    public boolean isContent() {
        return true;
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

    public int type() {
        return 55;
    }
}
