package com.baidu.wallet.paysdk.precashier;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.paysdk.datamodel.PrecashierModifyPayTypeResponse;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData;
import com.baidu.wallet.paysdk.precashier.beans.PrecashierModifyPayTypeBean;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.wallet.base.widget.LoadingDialog;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Map;

public class PrecashierModifyPayTypeManager implements IBeanResponseCallback {
    public LoadingDialog a;
    public WeakReference<Activity> b;
    public PrecashierModifyPayTypeBean c;
    public TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> d;
    public String e;

    public static class TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> implements Serializable {
        public final PrecashierModifyPayTypeDefaultData datas;
        public final Boolean isFromChange;

        public TwoTupleForPrecashier(Boolean booleanR, PrecashierModifyPayTypeDefaultData precashiermodifypaytypedefaultdata) {
            this.isFromChange = booleanR;
            this.datas = precashiermodifypaytypedefaultdata;
        }

        public Boolean isFromChange() {
            return this.isFromChange;
        }
    }

    public static class a {
        public static PrecashierModifyPayTypeManager a = new PrecashierModifyPayTypeManager();
    }

    public static PrecashierModifyPayTypeManager getInstance() {
        return a.a;
    }

    public void dismissLoadingDialog() {
        LoadingDialog loadingDialog = this.a;
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            this.a = null;
        }
    }

    public TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> generateTwoTupleForPrecashier(boolean z, PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
        return new TwoTupleForPrecashier<>(Boolean.valueOf(z), precashierModifyPayTypeDefaultData);
    }

    public void getModifyPayType(Activity activity, Map<String, String> map) {
        setTwoTupleForPrecashier(new TwoTupleForPrecashier(Boolean.TRUE, a((Map) map)));
        this.b = new WeakReference<>(activity);
        showLoadingDialog();
        if (this.c == null) {
            this.c = new PrecashierModifyPayTypeBean(activity);
        }
        PrecashierModifyPayTypeBean precashierModifyPayTypeBean = this.c;
        precashierModifyPayTypeBean.rec_params = map;
        precashierModifyPayTypeBean.setResponseCallback(this);
        this.c.execBean();
    }

    public String getSpNo() {
        return this.e;
    }

    public void onBeanExecFailure(int i2, int i3, final String str) {
        this.c = null;
        dismissLoadingDialog();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (!(PrecashierModifyPayTypeManager.this.b == null || PrecashierModifyPayTypeManager.this.b.get() == null)) {
                    GlobalUtils.toast((Context) PrecashierModifyPayTypeManager.this.b.get(), str);
                }
                PayController.getInstance().clearPreModifiedCallBack();
            }
        });
    }

    public void onBeanExecSuccess(final int i2, final Object obj, String str) {
        dismissLoadingDialog();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                Object obj = obj;
                if (obj == null) {
                    PrecashierModifyPayTypeBean unused = PrecashierModifyPayTypeManager.this.c = null;
                } else if (i2 == 2) {
                    PrecashierModifyPayTypeResponse precashierModifyPayTypeResponse = (PrecashierModifyPayTypeResponse) obj;
                    if (PrecashierModifyPayTypeManager.this.c != null) {
                        precashierModifyPayTypeResponse.setOriginHttpResponse(PrecashierModifyPayTypeManager.this.c.getHttpRealContent());
                    }
                    if (!precashierModifyPayTypeResponse.checkResponseValidity()) {
                        PrecashierModifyPayTypeBean unused2 = PrecashierModifyPayTypeManager.this.c = null;
                    } else if (PrecashierModifyPayTypeManager.this.b == null || PrecashierModifyPayTypeManager.this.b.get() == null) {
                        PrecashierModifyPayTypeBean unused3 = PrecashierModifyPayTypeManager.this.c = null;
                    } else {
                        PayController.getInstance().modifyPayType((Context) PrecashierModifyPayTypeManager.this.b.get(), PrecashierModifyPayTypeManager.this.d);
                    }
                } else {
                    PrecashierModifyPayTypeBean unused4 = PrecashierModifyPayTypeManager.this.c = null;
                }
            }
        });
    }

    public void setSpNo(String str) {
        this.e = str;
    }

    public void setTwoTupleForPrecashier(TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> twoTupleForPrecashier) {
        this.d = twoTupleForPrecashier;
    }

    public void showLoadingDialog() {
        WeakReference<Activity> weakReference;
        if (this.a == null && (weakReference = this.b) != null && weakReference.get() != null && (this.b.get() instanceof Activity) && !((Activity) this.b.get()).isFinishing()) {
            this.a = new LoadingDialog((Context) this.b.get());
        }
        LoadingDialog loadingDialog = this.a;
        if (loadingDialog != null) {
            loadingDialog.show();
        }
    }

    public PrecashierModifyPayTypeManager() {
    }

    private PrecashierModifyPayTypeDefaultData a(Map map) {
        PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData = new PrecashierModifyPayTypeDefaultData();
        if (map != null && !map.isEmpty()) {
            Object obj = map.get(StatHelper.SP_NO);
            if (obj != null && (obj instanceof String)) {
                setSpNo((String) obj);
            }
            Object obj2 = map.get("pay_type");
            String str = (obj2 == null || !(obj2 instanceof String)) ? null : (String) obj2;
            if (TextUtils.isEmpty(str)) {
                return precashierModifyPayTypeDefaultData;
            }
            if ("balance".equals(str)) {
                precashierModifyPayTypeDefaultData.setDatas(str, "", (PrecashierModifyPayTypeDefaultData.Card) null);
            } else if ("easypay".equals(str)) {
                Object obj3 = map.get("account_no");
                String str2 = (obj3 == null || !(obj3 instanceof String)) ? null : (String) obj3;
                PrecashierModifyPayTypeDefaultData.Card card = new PrecashierModifyPayTypeDefaultData.Card();
                card.account_no = str2;
                precashierModifyPayTypeDefaultData.setDatas(str, (String) null, card);
            }
            map.remove("pay_type");
            map.remove("account_no");
        }
        return precashierModifyPayTypeDefaultData;
    }
}
