package fe.fe.ddd.ddd.ad.fe;

import com.baidu.searchbox.retrieve.inter.IFetchTask;
import fe.fe.ddd.ddd.th.i;
import fe.fe.ddd.ddd.th.uk;
import org.json.JSONObject;

public class qw implements IFetchTask {
    public void ad(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        i.qw().ad(new uk(str, "-1", str2, str3, str4, jSONObject == null ? "" : jSONObject.toString(), ""));
    }

    public void de(String str, String str2, String str3, String str4, String str5, String str6) {
        uk ukVar = new uk(str, "4", str2, str3, str4, "", str6);
        ukVar.i(str5);
        i.qw().ad(ukVar);
    }

    public void fe(String str, String str2, String str3, JSONObject jSONObject, String str4) {
        i.qw().ad(new uk(str, "1", str2, str3, str4, jSONObject == null ? "" : jSONObject.toString(), ""));
    }

    public void qw(String str, String str2, String str3, JSONObject jSONObject) {
        i.qw().ad(new uk(str, "2", str2, str3, "", jSONObject == null ? "" : jSONObject.toString(), ""));
    }
}
