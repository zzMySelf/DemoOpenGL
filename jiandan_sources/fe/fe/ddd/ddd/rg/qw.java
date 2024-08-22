package fe.fe.ddd.ddd.rg;

import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.upload.IUploadTask;
import fe.fe.ddd.ddd.rg.ad.ad;
import org.json.JSONObject;

public class qw extends fe.fe.ddd.ddd.fe.qw {
    public static final boolean qw = AppConfig.rg();

    public String ad() {
        return "flow";
    }

    public void qw(JSONObject jSONObject) {
        ad qw2 = fe.fe.ddd.ddd.rg.ad.qw.qw(jSONObject);
        if (qw2 != null) {
            if (qw) {
                "日志回捞收到命令 " + jSONObject;
            }
            if (!"1".equals(qw2.fe()) || NetWorkUtils.NetType.WIFI.equals(NetWorkUtils.getNetworkType())) {
                ((IUploadTask) fe.fe.vvv.ad.ad.ad.qw(IUploadTask.qw)).qw(qw2.yj(), qw2.ad(), qw2.uk(), qw2.de(), qw2.th(), qw2.qw(), qw2.rg());
            }
        }
    }
}
