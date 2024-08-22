package com.dxmpay.wallet.core.beans;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.BeanResponseBase;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.RestResponseEntity;
import com.dxmpay.apollon.restnet.http.HttpStatus;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.utils.VerSig;
import com.dxmpay.wallet.statistics.NetStepStatManager;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.List;
import org.json.JSONException;

public abstract class StringBean extends OtherBean<String> {
    public List<RestNameValuePair> mParam;

    public StringBean(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean(String.class);
    }

    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> restResponseEntity;
        long currentTimeMillis = System.currentTimeMillis();
        List<RestNameValuePair> requestParams = getRequestParams();
        NetStepStatManager.getInstance().recordBuildParamsCost(Uri.parse(getUrl()).getPath(), this.mStartTime, System.currentTimeMillis() - currentTimeMillis);
        HttpStatus httpStatus = null;
        if (getHttpMethod() == 0) {
            restResponseEntity = this.mRestTemplate.getForEntity(getUrl(), requestParams, getEncode(), cls);
        } else {
            restResponseEntity = getHttpMethod() == 1 ? this.mRestTemplate.postForEntity(getUrl(), requestParams, getEncode(), cls) : null;
        }
        this.mRetCode = -4;
        this.mRetMsg = ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error");
        if (restResponseEntity != null && this.mRspCallback != null) {
            handleResponseHeaders(restResponseEntity);
            String str = (String) restResponseEntity.getBody();
            HttpStatus statusCode = restResponseEntity.getStatusCode();
            if (str == null) {
                addOnEventWithValues(-103, "Callback not null,rsp.getBody() is null", statusCode);
                this.mRspCallback.onBeanExecFailure(getBeanId(), this.mRetCode, this.mRetMsg);
                return;
            }
            String str2 = "";
            try {
                BeanResponseBase beanResponseBase = (BeanResponseBase) JsonUtils.fromJson(str, BeanResponseBase.class);
                if (beanResponseBase != null) {
                    this.mRetCode = beanResponseBase.ret;
                    this.mRetMsg = beanResponseBase.msg;
                }
                if (beanResponseBase != null && beanResponseBase.ret == 0) {
                    str2 = beanResponseBase.getRealResponseContent();
                    if (beanResponseBase.needVerifySignature() || needVerifySignature()) {
                        if (!VerSig.verify(beanResponseBase.signature, str2, beanResponseBase.mdAlgorithm)) {
                            if (!TextUtils.isEmpty(getUrl())) {
                                StatisticManager.onEvent("#verify_sign_failed");
                            }
                            this.mRetCode = -4;
                            this.mRetMsg = ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error");
                        } else if (beanResponseBase.needDecryption() && !TextUtils.isEmpty(str2)) {
                            str2 = SecurePay.getInstance().decryptProxy(str2);
                        }
                    }
                }
            } catch (JSONException e) {
                this.mRetCode = -4;
                this.mRetMsg = e.toString();
            }
            addOnEventWithValues(this.mRetCode, this.mRetMsg, statusCode);
            if (this.mRetCode == 0) {
                this.mRspCallback.onBeanExecSuccess(getBeanId(), (Object) null, str2);
            } else {
                this.mRspCallback.onBeanExecFailure(getBeanId(), this.mRetCode, this.mRetMsg);
            }
        } else if (this.mRspCallback != null) {
            addOnEventWithValues(-100, "Callback not null, response null", (HttpStatus) null);
            this.mRspCallback.onBeanExecFailure(getBeanId(), this.mRetCode, this.mRetMsg);
        } else {
            if (restResponseEntity != null) {
                httpStatus = restResponseEntity.getStatusCode();
            }
            addOnEventWithValues(-101, "Callback null, response null", httpStatus);
        }
    }

    public List<RestNameValuePair> generateRequestParam() {
        return this.mParam;
    }

    public boolean needNonce() {
        return false;
    }
}
