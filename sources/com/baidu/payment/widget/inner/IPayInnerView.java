package com.baidu.payment.widget.inner;

import com.baidu.payment.model.PolyParamWrapper;
import org.json.JSONObject;

public interface IPayInnerView {
    JSONObject getInlinePayParams();

    void onDestroy();

    void refreshLoad(PolyParamWrapper polyParamWrapper, PayInnerViewRefreshResult payInnerViewRefreshResult);

    void registerActionListener(PayInnerViewActionCallback payInnerViewActionCallback);

    void startLoad(PolyParamWrapper polyParamWrapper, PayInnerViewLoadResult payInnerViewLoadResult);
}
