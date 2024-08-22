package fe.fe.ddd.yj.de;

import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.cloudcontrol.runtime.ICloudControlRegister;
import fe.mmm.qw.e.th.ad;
import java.util.HashMap;

public class qw {
    public HashMap<String, ICloudControlProcessor> qw = new HashMap<>();

    public qw() {
        ad();
    }

    public void ad() {
        ICloudControlRegister fe2 = fe();
        if (fe2 != null) {
            fe2.qw(this);
        }
    }

    public boolean de(String str) {
        return this.qw.containsKey(str);
    }

    public final ICloudControlRegister fe() {
        return ad.qw();
    }

    public void qw(String str, ICloudControlProcessor iCloudControlProcessor) {
        if (iCloudControlProcessor != null && !TextUtils.isEmpty(str)) {
            this.qw.put(str, iCloudControlProcessor);
        }
    }

    public HashMap<String, ICloudControlProcessor> rg() {
        return this.qw;
    }
}
