package com.baidu.searchbox.noveladapter.http;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.noveladapter.http.INovelContainerBuildInter;
import java.io.IOException;
import okhttp3.Response;

public class NovelHttpGetWrapper implements INovelContainerBuildInter.NovelGetRequest, INovelContainerBuildInter.NovelRequestBuilder, INovelContainerBuildInter.ExecuteRequest, NoProGuard {
    /* access modifiers changed from: private */
    public GetRequest getRequest;
    private GetRequest.GetRequestBuilder getRequestBuilder;
    private String url;

    public INovelContainerBuildInter.NovelRequestBuilder getRequest(Context context) {
        this.getRequestBuilder = HttpManager.getDefault(context).getRequest();
        return this;
    }

    public INovelContainerBuildInter.NovelRequestBuilder addHeader(String key, String value) {
        GetRequest.GetRequestBuilder getRequestBuilder2 = this.getRequestBuilder;
        if (getRequestBuilder2 != null) {
            getRequestBuilder2.addHeader(key, value);
        }
        return this;
    }

    public INovelContainerBuildInter.NovelRequestBuilder addUrlParam(String key, String value) {
        GetRequest.GetRequestBuilder getRequestBuilder2 = this.getRequestBuilder;
        if (getRequestBuilder2 != null) {
            getRequestBuilder2.addUrlParam(key, value);
        }
        return this;
    }

    public INovelContainerBuildInter.NovelRequestBuilder addParam(String key, String value) {
        return this;
    }

    public INovelContainerBuildInter.NovelRequestBuilder cookieManager(Object cookieManager) {
        GetRequest.GetRequestBuilder getRequestBuilder2;
        if (!(cookieManager == null || !(cookieManager instanceof CookieManager) || (getRequestBuilder2 = this.getRequestBuilder) == null)) {
            getRequestBuilder2.cookieManager((CookieManager) cookieManager);
        }
        return this;
    }

    public INovelContainerBuildInter.NovelRequestBuilder enableStat(boolean enable) {
        GetRequest.GetRequestBuilder getRequestBuilder2 = this.getRequestBuilder;
        if (getRequestBuilder2 != null) {
            getRequestBuilder2.enableStat(enable);
        }
        return this;
    }

    public INovelContainerBuildInter.NovelRequestBuilder requestFrom(int from) {
        GetRequest.GetRequestBuilder getRequestBuilder2 = this.getRequestBuilder;
        if (getRequestBuilder2 != null) {
            getRequestBuilder2.requestFrom(from);
        }
        return this;
    }

    public INovelContainerBuildInter.NovelRequestBuilder requestSubFrom(int httpStatSubFromId) {
        GetRequest.GetRequestBuilder getRequestBuilder2 = this.getRequestBuilder;
        if (getRequestBuilder2 != null) {
            getRequestBuilder2.requestSubFrom(httpStatSubFromId);
        }
        return this;
    }

    public INovelContainerBuildInter.NovelRequestBuilder connectionTimeout(int time) {
        GetRequest.GetRequestBuilder getRequestBuilder2 = this.getRequestBuilder;
        if (getRequestBuilder2 != null) {
            getRequestBuilder2.connectionTimeout(time);
        }
        return this;
    }

    public INovelContainerBuildInter.NovelRequestBuilder readTimeout(int time) {
        GetRequest.GetRequestBuilder getRequestBuilder2 = this.getRequestBuilder;
        if (getRequestBuilder2 != null) {
            getRequestBuilder2.readTimeout(time);
        }
        return this;
    }

    public INovelContainerBuildInter.NovelRequestBuilder writeTimeout(int time) {
        GetRequest.GetRequestBuilder getRequestBuilder2 = this.getRequestBuilder;
        if (getRequestBuilder2 != null) {
            getRequestBuilder2.writeTimeout(time);
        }
        return this;
    }

    public INovelContainerBuildInter.NovelRequestBuilder followRedirects(boolean follow) {
        GetRequest.GetRequestBuilder getRequestBuilder2 = this.getRequestBuilder;
        if (getRequestBuilder2 != null) {
            getRequestBuilder2.followRedirects(follow);
        }
        return this;
    }

    public INovelContainerBuildInter.NovelRequestBuilder url(String url2) {
        GetRequest.GetRequestBuilder getRequestBuilder2 = this.getRequestBuilder;
        if (getRequestBuilder2 != null) {
            this.url = url2;
            getRequestBuilder2.url(url2);
        }
        return this;
    }

    public INovelContainerBuildInter.ExecuteRequest build() {
        GetRequest.GetRequestBuilder getRequestBuilder2;
        if (!TextUtils.isEmpty(this.url) && (getRequestBuilder2 = this.getRequestBuilder) != null) {
            this.getRequest = getRequestBuilder2.build();
        }
        return this;
    }

    public void executeAsync(final INovelRequestCallBack novelRequestCallBack) throws RuntimeException {
        GetRequest getRequest2 = this.getRequest;
        if (getRequest2 != null) {
            getRequest2.executeAsync(new ResponseCallback<String>() {
                public String parseResponse(Response response, int i2) {
                    if (response == null) {
                        return null;
                    }
                    novelRequestCallBack.parseResponse(new NovelResponseWrapper(response));
                    return null;
                }

                public void onSuccess(String s, int i2) {
                    novelRequestCallBack.onSuccess(s, i2);
                }

                public void onFail(Exception e2) {
                    int i2;
                    int errorCode = 0;
                    if (NovelHttpGetWrapper.this.getRequest != null) {
                        if (NovelHttpGetWrapper.this.getRequest.getRequestNetStat() == null) {
                            i2 = 0;
                        } else {
                            i2 = NovelHttpGetWrapper.this.getRequest.getRequestNetStat().statusCode;
                        }
                        errorCode = i2;
                    }
                    novelRequestCallBack.onFail(errorCode, e2);
                }
            });
            return;
        }
        throw new RuntimeException("调用executeAsync方法前必须通过build方法构建Request对象");
    }

    public NovelResponseWrapper executeSync() throws RuntimeException, IOException {
        GetRequest getRequest2 = this.getRequest;
        if (getRequest2 != null) {
            Response response = getRequest2.executeSync();
            if (response != null) {
                return new NovelResponseWrapper(response);
            }
            return null;
        }
        throw new RuntimeException("调用executeSync方法前必须通过build方法构建Request对象");
    }
}
