package com.baidu.wallet.core.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.converter.GsonHttpMessageConverter;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.baidu.wallet.core.lollipop.json.JSONObject;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.VerSig;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.utils.BdWalletUtils;
import java.util.ArrayList;
import java.util.Objects;
import org.json.JSONException;

public abstract class BaseBean<T> extends NetworkBean<T> {
    public static final int COMET_BEAN = 1;
    public static final int COMET_TIMEOUT = 2;
    public static final String TAG = "BeasBean";
    public int beanType = -1;
    public String mHttpContent;
    public int mTimeout;

    public BaseBean(Context context) {
        super(context);
    }

    private <T> T extractRealResponse(String str, Class<T> cls) {
        try {
            return JsonUtils.fromJson(str, cls);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getHttpRealContent() {
        return this.mHttpContent;
    }

    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        String str;
        String str2;
        boolean z = false;
        if (TextUtils.equals("1", SdkInitResponse.getInstance().enableNetworkStatForHttp2)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(getUrl());
            arrayList.add(getClass().getSimpleName());
            arrayList.add("handleResponse");
            StringBuilder sb = new StringBuilder();
            sb.append("rsp != null:: ");
            sb.append(restResponseEntity != null);
            sb.append("   mRspCallback != null::");
            sb.append(this.mRspCallback != null);
            arrayList.add(sb.toString());
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.NETWORK_STAT_HTTP2, arrayList);
        }
        if (restResponseEntity == null || this.mRspCallback == null) {
            IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
            if (iBeanResponseCallback != null) {
                iBeanResponseCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                return;
            }
            return;
        }
        handleResponseHeaders(restResponseEntity);
        BeanResponseBase beanResponseBase = (BeanResponseBase) restResponseEntity.getBody();
        if (TextUtils.equals("1", SdkInitResponse.getInstance().enableNetworkStatForHttp2)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(getUrl());
            arrayList2.add(getClass().getSimpleName());
            arrayList2.add("handleResponse");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("response != null:: ");
            sb2.append(beanResponseBase != null);
            arrayList2.add(sb2.toString());
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.NETWORK_STAT_HTTP2, arrayList2);
        }
        if (beanResponseBase != null) {
            handleSession(beanResponseBase.cashdesk);
            int serverReturnValue = beanResponseBase.getServerReturnValue(cls);
            if (serverReturnValue != 0) {
                if (serverReturnValue == 5003) {
                    DXMSdkSAUtils.onEvent("#invalidLoginStatus");
                }
                String realResponseErrContent = beanResponseBase.getRealResponseErrContent();
                this.mHttpContent = realResponseErrContent;
                if (TextUtils.isEmpty(realResponseErrContent) || cls2 == null) {
                    this.mRspCallback.onBeanExecFailure(getBeanId(), serverReturnValue, beanResponseBase.getRealResponseMsg());
                } else {
                    EventBus instance = EventBus.getInstance();
                    Objects.requireNonNull(instance);
                    instance.postStickyEvent(new EventBus.Event("ev_bean_execut_err_content", new BeanErrorContent(getBeanId(), serverReturnValue, beanResponseBase.getRealResponseMsg(), extractRealResponse(beanResponseBase.getRealResponseErrContent(), cls2))));
                }
                if (TextUtils.equals("1", SdkInitResponse.getInstance().enableNetworkStatForHttp2)) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(getUrl());
                    arrayList3.add(getClass().getSimpleName());
                    arrayList3.add("handleResponse");
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("!TextUtils.isEmpty(mHttpContent):: ");
                    sb3.append(!TextUtils.isEmpty(this.mHttpContent));
                    sb3.append("   errContentClass != null::");
                    if (cls2 != null) {
                        z = true;
                    }
                    sb3.append(z);
                    arrayList3.add(sb3.toString());
                    DXMSdkSAUtils.onEventWithValues(StatServiceEvent.NETWORK_STAT_HTTP2, arrayList3);
                    return;
                }
                return;
            }
            String token = beanResponseBase.getToken();
            if (!TextUtils.isEmpty(token)) {
                AccountManager.getInstance(this.mContext).setBfbToken(token);
            }
            LogUtil.d(TAG, "execBean. ret       . rsp class = " + cls);
            this.mHttpContent = beanResponseBase.getRealResponseContent();
            if (checkSignSame(beanResponseBase.contentSign)) {
                this.mRspCallback.onBeanExecSuccess(getBeanId(), (Object) null, beanResponseBase.getRealResponseMsg());
                LogUtil.i(TAG, "checkSignSame is true,call onBeanExecSuccess directly!!");
                return;
            }
            try {
                str = new JSONObject(restResponseEntity.b()).getString(beanResponseBase.getNameOfRealResponseContent());
                if ((needVerifySignature() || beanResponseBase.needVerifySignature()) && !VerSig.verify(beanResponseBase.signature, str, beanResponseBase.mdAlgorithm)) {
                    DXMSdkSAUtils.onEvent("#verify_sign_failed");
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                    return;
                }
            } catch (com.baidu.wallet.core.lollipop.json.JSONException e) {
                LogUtil.e(TAG, e.getMessage(), e);
                str = "";
            }
            if (beanResponseBase.needDecryption() && !TextUtils.isEmpty(str)) {
                this.mHttpContent = SafePay.getInstance().decryptProxy(str);
            }
            LogUtil.d(TAG, "execBean. ret ok. after  mHttpContent text = " + this.mHttpContent);
            if (cls == null) {
                this.mRspCallback.onBeanExecSuccess(getBeanId(), (Object) null, beanResponseBase.getRealResponseMsg());
                str2 = BannerBaseItemInfo.TYPE_LOGIN;
            } else if (JsonUtils.DataType.isString(cls)) {
                this.mRspCallback.onBeanExecSuccess(getBeanId(), (Object) null, this.mHttpContent);
                return;
            } else {
                LogUtil.d(TAG, "execBean. ret ok. real response  text = " + this.mHttpContent);
                T extractRealResponse = extractRealResponse(this.mHttpContent, cls);
                LogUtil.d(TAG, "execBean. ret ok. real response = " + extractRealResponse);
                if (extractRealResponse != null) {
                    IBeanResponse iBeanResponse = (IBeanResponse) extractRealResponse;
                    if (iBeanResponse.checkResponseValidity()) {
                        iBeanResponse.storeResponse(this.mContext);
                        if (needContentStr()) {
                            this.mRspCallback.onBeanExecSuccess(getBeanId(), extractRealResponse, this.mHttpContent);
                            str2 = "1";
                        } else {
                            this.mRspCallback.onBeanExecSuccess(getBeanId(), extractRealResponse, beanResponseBase.getRealResponseMsg());
                            str2 = "2";
                        }
                    } else {
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                        str2 = "3";
                    }
                } else {
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                    str2 = "4";
                }
            }
            if (TextUtils.equals("1", SdkInitResponse.getInstance().enableNetworkStatForHttp2)) {
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(getUrl());
                arrayList4.add(getClass().getSimpleName());
                arrayList4.add("handleResponse");
                StringBuilder sb4 = new StringBuilder();
                sb4.append("!TextUtils.isEmpty(originContent):: ");
                sb4.append(!TextUtils.isEmpty(str));
                sb4.append("   callbackDesc::");
                sb4.append(str2);
                arrayList4.add(sb4.toString());
                DXMSdkSAUtils.onEventWithValues(StatServiceEvent.NETWORK_STAT_HTTP2, arrayList4);
                return;
            }
            return;
        }
        this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
    }

    public void handleSession(BeanResponseBase.Session session) {
        BdWalletUtils.dealCashDesk(session);
    }

    public boolean needContentStr() {
        return false;
    }

    public boolean needNonce() {
        return false;
    }

    public void prepareRestTemplate() {
        Object obj;
        Context context = this.mContext;
        this.mRestTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "pay bean http request");
        ArrayList arrayList = new ArrayList();
        LogUtil.d(TAG, "beanType:" + this.beanType);
        int i2 = this.beanType;
        if (i2 == 2) {
            LogUtil.d(TAG, "beanType, 有超时拦截器");
            obj = new CometHttpTimeoutRequestInterceptor(this.mTimeout);
        } else if (i2 == 1) {
            obj = new CometHttpRequestInterceptor();
        } else {
            obj = new EbpayHttpRequestInterceptor();
        }
        arrayList.add(obj);
        arrayList.add(new a(this.tag[0].booleanValue()));
        this.mRestTemplate.setRequestInterceptor(arrayList);
        this.mRestTemplate.setMessageConverter(new GsonHttpMessageConverter());
    }

    public void setBeanParams(String... strArr) {
    }

    public BaseBean(Context context, int i2) {
        super(context);
        this.beanType = i2;
    }

    public BaseBean(Context context, int i2, int i3) {
        super(context);
        this.beanType = i2;
        this.mTimeout = i3;
    }
}
