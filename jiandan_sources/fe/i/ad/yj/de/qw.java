package fe.i.ad.yj.de;

import android.content.Context;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import java.util.List;

public class qw extends BaseBean<String> {
    public String qw = "";

    public qw(Context context, String str) {
        super(context);
        this.qw = str;
    }

    public void execBean() {
        super.execBean(String.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        return null;
    }

    public int getBeanId() {
        return 17;
    }

    public int getHttpMethod() {
        return 0;
    }

    public String getUrl() {
        return this.qw;
    }
}
