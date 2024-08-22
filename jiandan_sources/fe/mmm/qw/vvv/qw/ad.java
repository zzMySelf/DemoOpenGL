package fe.mmm.qw.vvv.qw;

import android.webkit.MimeTypeMap;
import java.util.HashMap;
import java.util.Map;

public class ad {
    public Map<String, String> qw = new HashMap();

    public void ad(String str, String str2) {
        this.qw.put(str, str2.toLowerCase());
    }

    public String qw(String str) {
        String mimeTypeFromExtension;
        String lowerCase = fe.mmm.qw.j.xxx.ad.uk(str).toLowerCase();
        if (lowerCase.length() <= 0 || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase.substring(1).toLowerCase())) == null) {
            return this.qw.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }
}
