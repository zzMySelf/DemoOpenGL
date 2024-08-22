package fe.fe.mmm;

import org.json.JSONArray;
import org.json.JSONException;

public class rrr {
    public static void ad(String str) {
    }

    public static void qw(l lVar) {
        if (lVar != null && !lVar.h()) {
            JSONArray ppp = lVar.ppp();
            int length = ppp.length();
            boolean l = lVar.l();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    if (l != i.vvv().rg(ppp.getJSONObject(i2).getString("id"))) {
                        " data is " + l + "  content " + lVar.tt().toString();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
