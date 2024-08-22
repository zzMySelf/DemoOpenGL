package fe.when.ad;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.api.Indentable;
import java.util.Iterator;

public class ddd extends xxx implements Indentable {

    /* renamed from: yj  reason: collision with root package name */
    public xxx f9334yj = null;

    public ddd(Section section) {
        Paragraph paragraph = section.title;
        if (paragraph != null) {
            this.f9334yj = new xxx(paragraph);
            section.setTitle((Paragraph) null);
        }
        this.f9901ad = section;
    }

    public boolean process(ElementListener elementListener) {
        try {
            Iterator it = ((Section) this.f9901ad).iterator();
            while (it.hasNext()) {
                elementListener.ad((Element) it.next());
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    public xxx qw() {
        Element element = this.f9901ad;
        xxx xxx = new xxx(Section.constructTitle((Paragraph) this.f9334yj.f9901ad, ((Section) element).numbers, ((Section) element).numberDepth, ((Section) element).numberStyle));
        xxx.f9902th = this.f9334yj.f9902th;
        return xxx;
    }
}
