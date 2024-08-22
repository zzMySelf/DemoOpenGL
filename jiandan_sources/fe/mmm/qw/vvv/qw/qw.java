package fe.mmm.qw.vvv.qw;

import android.content.res.XmlResourceParser;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public ad f8574ad;
    public XmlPullParser qw;

    public ad ad(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        this.qw = xmlResourceParser;
        return de();
    }

    public ad de() throws XmlPullParserException, IOException {
        this.f8574ad = new ad();
        int eventType = this.qw.getEventType();
        while (eventType != 1) {
            String name = this.qw.getName();
            if (eventType == 2 && name.equals("type")) {
                qw();
            }
            eventType = this.qw.next();
        }
        return this.f8574ad;
    }

    public final void qw() {
        this.f8574ad.ad(this.qw.getAttributeValue((String) null, "extension"), this.qw.getAttributeValue((String) null, "mimetype"));
    }
}
