package com.baidu.fsg.base.restnet.beans.business;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.a.a;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.RestResponseEntity;
import com.baidu.fsg.base.restnet.RestRuntimeException;
import com.baidu.fsg.base.restnet.RestTemplate;
import com.baidu.fsg.base.restnet.a.c;
import com.baidu.fsg.base.restnet.beans.BeanResponseBase;
import com.baidu.fsg.base.restnet.beans.IBeanResponse;
import com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.fsg.base.utils.BussinessUtils;
import com.baidu.fsg.base.utils.FileCopyUtils;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.Md5Utils;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class UploadBean extends NetworkBean {
    public static final int COMET_BEAN = 1;
    private static final String TAG = UploadBean.class.getSimpleName();
    private static final String UPLOAD_BEAN_TASK_MGR_KEY = "UploadBeanTask";
    private static final String UPLOAD_BEAN_TASK_MGR_TASK_KEY = "UploadBean";
    private int beanType = -1;
    protected List<UploadFileModel> files = new ArrayList();
    public RestMultipartEntity.ProgressListener listener;
    private String mTskKey = "";
    private Class<?> rspClass;

    public static class UploadFileModel {
        public String contentType;
        public String fileName;
        public byte[] filedata;
        public String name;
    }

    public UploadBean(Context context) {
        super(context);
    }

    public UploadBean(Context context, int i2) {
        super(context);
        this.beanType = i2;
    }

    private void checkSign(BeanResponseBase beanResponseBase) throws Exception {
        if (needCheckClientSign() && beanResponseBase != null) {
            String str = beanResponseBase.csign;
            JSONObject jSONObject = beanResponseBase.result;
            if (jSONObject != null) {
                String mds = Md5Utils.toMds(jSONObject, this.reqId, "&");
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(mds) || !str.equals(mds)) {
                    throw new Exception(BeanConstants.ERROR_MSG_CHECKSIGN);
                }
            }
        }
    }

    private <T> T extractRealResponse(String str, Class<T> cls) {
        try {
            return JsonUtils.fromJson(str, cls);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private RestMultipartEntity generateMultipartEntity() throws Exception {
        RestMultipartEntity restMultipartEntity = new RestMultipartEntity();
        List<RestNameValuePair> requestParams = getRequestParams();
        if (requestParams != null) {
            for (RestNameValuePair next : requestParams) {
                restMultipartEntity.addPart(next.getName(), next.getValue());
            }
        }
        boolean z = false;
        int i2 = 0;
        while (i2 < this.files.size()) {
            boolean z2 = i2 == this.files.size() - 1 ? true : z;
            UploadFileModel uploadFileModel = this.files.get(i2);
            if (!(uploadFileModel == null || uploadFileModel.filedata == null)) {
                restMultipartEntity.addPart(uploadFileModel.name, uploadFileModel.fileName, new ByteArrayInputStream(uploadFileModel.filedata), uploadFileModel.contentType, z2);
            }
            i2++;
            z = z2;
        }
        restMultipartEntity.setProgressListener(this.listener);
        return restMultipartEntity;
    }

    public void addFile(UploadFileModel uploadFileModel) {
        if (uploadFileModel != null) {
            this.files.add(uploadFileModel);
        }
    }

    public void destroyBean() {
        this.mRspCallback = null;
        a.a(UPLOAD_BEAN_TASK_MGR_KEY).a(UPLOAD_BEAN_TASK_MGR_TASK_KEY, this.mTskKey);
        if (this.mRestTemplate != null) {
            this.mRestTemplate.setRequestInterceptor((List<RestHttpRequestInterceptor>) null);
        }
        this.files.clear();
    }

    public <T> void execBean(Class<T> cls) {
        this.rspClass = cls;
        super.execBean(cls);
    }

    /* access modifiers changed from: protected */
    public <T1, E> void executeAndHandleResponse(Class<T1> cls, Class<E> cls2) {
        try {
            RestMultipartEntity generateMultipartEntity = generateMultipartEntity();
            RestResponseEntity<BeanResponseBase> postMultipartForEntity = this.mRestTemplate.postMultipartForEntity(getUrl(), generateMultipartEntity, getEncode(), BeanResponseBase.class);
            generateMultipartEntity.closeOutStream();
            handleResponse(cls, (Class) null, postMultipartForEntity);
        } catch (Exception e2) {
            if (!(e2 instanceof RestRuntimeException) || !((RestRuntimeException) e2).contains(SocketTimeoutException.class)) {
                handleResponse(cls, (Class) null, (RestResponseEntity<? extends BeanResponseBase>) null);
            } else if (this.mRspCallback != null) {
                this.mRspCallback.onBeanExecFailure(getBeanId(), -5, BeanConstants.rim_timeout_error);
            }
            e2.printStackTrace();
        }
    }

    public <T1, E> void handleResponse(Class<T1> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        if (this.mRspCallback != null) {
            if (restResponseEntity != null) {
                handleResponseHeaders(restResponseEntity);
                BeanResponseBase beanResponseBase = (BeanResponseBase) restResponseEntity.getBody();
                if (beanResponseBase != null) {
                    try {
                        checkSign(beanResponseBase);
                        int serverReturnValue = beanResponseBase.getServerReturnValue(cls);
                        if (serverReturnValue != 0) {
                            this.mRspCallback.onBeanExecFailure(getBeanId(), serverReturnValue, beanResponseBase.retMsg);
                            return;
                        }
                        String str = TAG;
                        LogUtil.d(str, "execBean. ret       . rsp class = " + cls);
                        if (cls == null) {
                            this.mRspCallback.onBeanExecSuccess(getBeanId(), (Object) null, beanResponseBase.getRealResponseContent(), beanResponseBase.sign);
                            return;
                        } else if (JsonUtils.DataType.isString(cls)) {
                            this.mRspCallback.onBeanExecSuccess(getBeanId(), (Object) null, beanResponseBase.getRealResponseContent(), beanResponseBase.sign);
                            return;
                        } else {
                            T1 extractRealResponse = extractRealResponse(beanResponseBase.getRealResponseContent(), cls);
                            LogUtil.d(str, "execBean. ret ok. real response = " + extractRealResponse);
                            if (extractRealResponse != null) {
                                IBeanResponse iBeanResponse = (IBeanResponse) extractRealResponse;
                                if (iBeanResponse.checkResponseValidity()) {
                                    iBeanResponse.storeResponse(this.mContext);
                                    this.mRspCallback.onBeanExecSuccess(getBeanId(), extractRealResponse, beanResponseBase.retMsg, beanResponseBase.sign);
                                    return;
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -1, BeanConstants.ERROR_MSG_CHECKSIGN);
                        return;
                    }
                }
            } else if (this.mRspCallback == null) {
                return;
            }
            this.mRspCallback.onBeanExecFailure(getBeanId(), -4, BeanConstants.rim_resolve_error);
        }
    }

    public boolean needCheckClientSign() {
        return false;
    }

    public boolean needNonce() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void prepareRestTemplate() {
        this.mRestTemplate = new RestTemplate(this.mContext, BussinessUtils.getUA(this.mContext), BeanConstants.HTTP_REQUEST_TYPE_UPLOAD_BEAN);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.beanType == 1 ? new CometHttpRequestInterceptor() : new EbpayHttpRequestInterceptor());
        this.mRestTemplate.setRequestInterceptor(arrayList);
        this.mRestTemplate.setMessageConverter(new c());
    }

    public void setProgressListener(RestMultipartEntity.ProgressListener progressListener) {
        this.listener = progressListener;
    }

    public Object uploadUrlConnection(Class<?> cls) throws Exception {
        RestMultipartEntity generateMultipartEntity = generateMultipartEntity();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(getUrl()).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + generateMultipartEntity.getBoundary());
        generateMultipartEntity.writeTo(httpURLConnection.getOutputStream());
        generateMultipartEntity.getOutputStream().close();
        httpURLConnection.getOutputStream().flush();
        InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
        try {
            Object fromJson = JsonUtils.fromJson(FileCopyUtils.copyToString(inputStreamReader), cls);
            inputStreamReader.close();
            generateMultipartEntity.closeOutStream();
            return fromJson;
        } catch (JSONException e2) {
            return null;
        }
    }
}
