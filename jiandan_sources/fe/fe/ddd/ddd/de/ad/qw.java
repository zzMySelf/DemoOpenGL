package fe.fe.ddd.ddd.de.ad;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.file.util.AESUtil;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import fe.fe.vvv.ad.ad.ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;

public class qw {
    public static final boolean qw = AppConfig.rg();

    /* renamed from: fe.fe.ddd.ddd.de.ad.qw$qw  reason: collision with other inner class name */
    public static final class C0067qw {

        /* renamed from: ad  reason: collision with root package name */
        public String f1317ad;

        /* renamed from: de  reason: collision with root package name */
        public String f1318de;

        /* renamed from: fe  reason: collision with root package name */
        public long f1319fe;
        public String qw;

        /* renamed from: rg  reason: collision with root package name */
        public long f1320rg;

        /* renamed from: th  reason: collision with root package name */
        public List<String> f1321th = new ArrayList();

        public C0067qw(String str, String str2, String str3, long j, List<String> list, String str4, long j2) {
            this.qw = str;
            this.f1317ad = str2;
            this.f1318de = str3;
            this.f1319fe = j;
            this.f1321th = list;
            this.f1320rg = j2;
        }

        public String toString() {
            return "FetchBean{mJobId='" + this.qw + ExtendedMessageFormat.QUOTE + ", mType='" + this.f1317ad + ExtendedMessageFormat.QUOTE + ", mVersion='" + this.f1318de + ExtendedMessageFormat.QUOTE + ", mExpiredTime=" + this.f1319fe + ", mPathList=" + this.f1321th + ", mMaxFileSize=" + this.f1320rg + ExtendedMessageFormat.END_FE;
        }
    }

    public static void ad(String str, String str2, String str3, JSONObject jSONObject) {
        if (qw) {
            "文件回捞命令校验失败" + jSONObject.toString();
        }
        ((IFetchTask) ad.qw(IFetchTask.qw)).qw(str, str2, str3, jSONObject);
    }

    public static C0067qw qw(JSONObject jSONObject) {
        String str;
        if (jSONObject == null) {
            return null;
        }
        if (qw) {
            "文件回捞收到命令 " + jSONObject.toString();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("info");
        if (optJSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("jobId");
        String optString2 = jSONObject.optString("type");
        String optString3 = jSONObject.optString("version");
        try {
            long longValue = Long.valueOf(jSONObject.optString("expiredTime")).longValue();
            if (longValue < System.currentTimeMillis() / 1000) {
                boolean z = qw;
                ad(optString2, optString, optString, jSONObject);
                return null;
            }
            if ("file".equals(optString2)) {
                try {
                    str = new String(AESUtil.qw("1357902468135246", String.format("aperf_%s", new Object[]{optString3}), Base64.decode(optJSONObject.optString("path"), 0)));
                } catch (Exception e) {
                    if (qw) {
                        e.printStackTrace();
                    }
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    ArrayList arrayList = new ArrayList();
                    if (str.indexOf(",") > 0) {
                        arrayList.addAll(Arrays.asList(str.split(",")));
                    } else {
                        arrayList.add(str);
                    }
                    return new C0067qw(optString, optString2, optString3, longValue, arrayList, str, optJSONObject.optLong("maxTotalFileSize"));
                }
            }
            ad(optString2, optString, optString, jSONObject);
            return null;
        } catch (Exception e2) {
            if (qw) {
                e2.getMessage();
            }
        }
    }
}
