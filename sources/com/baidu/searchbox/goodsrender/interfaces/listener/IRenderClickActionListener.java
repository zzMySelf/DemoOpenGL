package com.baidu.searchbox.goodsrender.interfaces.listener;

import android.view.View;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/goodsrender/interfaces/listener/IRenderClickActionListener;", "", "onViewActionDispatch", "", "businessId", "", "view", "Landroid/view/View;", "jsonObject", "Lorg/json/JSONObject;", "lib_render_sdk_interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IRenderClickActionListener.kt */
public interface IRenderClickActionListener {
    void onViewActionDispatch(String str, View view2, JSONObject jSONObject);
}
