package fe.i.ad.rg.qw;

import android.content.Context;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.ArrayList;
import java.util.List;

public class qw extends BaseBean<SdkInitResponse> {
    public qw(Context context) {
        super(context);
    }

    public final String a() {
        return PhoneUtils.CPU_API_ARM_V8A.equals(PhoneUtils.getCpuAbi()) ? "2" : "1";
    }

    public void execBean() {
        super.execBean(SdkInitResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("cpu_abi", a()));
        return arrayList;
    }

    public int getBeanId() {
        return BeanConstants.BEAN_ID_FOR_SPARE_INIT;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getSpareInitHost() + BeanConstants.API_AIF_GET_FP;
    }

    public boolean needNonce() {
        return true;
    }
}
