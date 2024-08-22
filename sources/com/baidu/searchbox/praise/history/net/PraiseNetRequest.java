package com.baidu.searchbox.praise.history.net;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.interaction.cloudcontrol.InteractionIdentityManager;
import com.baidu.searchbox.parise.R;
import com.baidu.searchbox.praise.history.data.PraiseDeleteData;
import com.baidu.searchbox.praise.history.data.PraiseListData;
import com.baidu.searchbox.praise.runtime.PraiseRuntime;
import java.util.Set;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class PraiseNetRequest {
    private static final String JSONMEDIATYPE = "application/json";
    private static final String KEY_DATA = "data";
    private static final String NETSFROM = "history";
    private static final String NETSOURCE = "history_like";
    private static final String NETTYPE = "feed";
    public static final String PRAISE_LIST_REQUEST_TAG = "praise_list_request_tag";
    private static final String TAG = PraiseNetRequest.class.getName();

    public static void requestPraiseList(String id, String rtype, String from, String source, final OnRequestCompletedListener<PraiseListData> listener) {
        String id2;
        String url = InteractionIdentityManager.processUrl(PraiseUrlConfig.getPraiseList());
        if (TextUtils.isEmpty(id)) {
            id2 = "";
        } else {
            id2 = id.trim();
        }
        JSONObject postJson = new JSONObject();
        JSONObject extJson = new JSONObject();
        try {
            extJson.put("sfrom", TextUtils.isEmpty(from) ? "history" : from);
            extJson.put("source", TextUtils.isEmpty(source) ? NETSOURCE : source);
            extJson.put("type", "feed");
            postJson.put("ext", extJson.toString());
            postJson.put("id", id2);
            postJson.put(GameCenterUtils.KEY_PAGE_SIZE, 20);
            postJson.put("rtype", rtype);
        } catch (Exception e2) {
            if (PraiseRuntime.DEBUG) {
                e2.printStackTrace();
            }
        }
        HttpManager httpManager = HttpManager.getDefault(AppRuntime.getAppContext());
        if (httpManager.isNetWorkConnected()) {
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) httpManager.postFormRequest().requestFrom(13)).requestSubFrom(104)).url(url)).tag(PRAISE_LIST_REQUEST_TAG)).addParam("data", postJson.toString())).cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(true, false))).build().executeAsync(new ResponseCallback<PraiseListData>() {
                public PraiseListData parseResponse(Response response, int i2) throws Exception {
                    if (response.body() != null) {
                        return PraiseListData.parse(response.body().string(), "360");
                    }
                    return null;
                }

                public void onSuccess(PraiseListData praiseListData, int statusCode) {
                    if (OnRequestCompletedListener.this == null) {
                        return;
                    }
                    if (praiseListData == null || praiseListData.getErrNo() != 0) {
                        OnRequestCompletedListener.this.onCompleted(-1, null, "");
                    } else {
                        OnRequestCompletedListener.this.onCompleted(0, praiseListData, "");
                    }
                }

                public void onFail(Exception e2) {
                    OnRequestCompletedListener onRequestCompletedListener = OnRequestCompletedListener.this;
                    if (onRequestCompletedListener != null) {
                        onRequestCompletedListener.onCompleted(-1, null, PraiseRuntime.getAppContext().getResources().getString(R.string.praise_network_error));
                    }
                }
            });
        } else if (listener != null) {
            listener.onCompleted(-1, null, PraiseRuntime.getAppContext().getResources().getString(R.string.praise_network_error));
        }
    }

    public static void requestPraiseSearch(String query, String[] templates, final OnRequestCompletedListener<PraiseListData> listener, Object tag) {
        String url = InteractionIdentityManager.processUrl(PraiseUrlConfig.getPraiseSearch());
        JSONObject postJson = new JSONObject();
        JSONObject extJson = new JSONObject();
        try {
            extJson.put("sfrom", "history");
            extJson.put("source", NETSOURCE);
            extJson.put("type", "feed");
            postJson.put("ext", extJson.toString());
            postJson.put("query", query);
            if (templates != null) {
                postJson.put("templates", new JSONArray(templates).toString());
            } else {
                postJson.put("templates", "");
            }
        } catch (Exception e2) {
            if (PraiseRuntime.DEBUG) {
                e2.printStackTrace();
            }
        }
        HttpManager httpManager = HttpManager.getDefault(AppRuntime.getAppContext());
        if (httpManager.isNetWorkConnected()) {
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) httpManager.postFormRequest().requestFrom(13)).requestSubFrom(104)).url(url)).tag(tag)).addParam("data", postJson.toString())).cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(true, false))).build().executeAsync(new ResponseCallback<PraiseListData>() {
                public PraiseListData parseResponse(Response response, int i2) throws Exception {
                    if (response.body() != null) {
                        return PraiseListData.parse(response.body().string(), "361");
                    }
                    return null;
                }

                public void onSuccess(PraiseListData praiseListData, int statusCode) {
                    if (OnRequestCompletedListener.this == null) {
                        return;
                    }
                    if (praiseListData == null || praiseListData.getErrNo() != 0) {
                        OnRequestCompletedListener.this.onCompleted(-1, null, "");
                    } else {
                        OnRequestCompletedListener.this.onCompleted(0, praiseListData, "");
                    }
                }

                public void onFail(Exception e2) {
                    OnRequestCompletedListener onRequestCompletedListener = OnRequestCompletedListener.this;
                    if (onRequestCompletedListener != null) {
                        onRequestCompletedListener.onCompleted(-1, null, PraiseRuntime.getAppContext().getResources().getString(R.string.praise_network_error));
                    }
                }
            });
        } else if (listener != null) {
            listener.onCompleted(-1, null, PraiseRuntime.getAppContext().getResources().getString(R.string.praise_network_error));
        }
    }

    public static void deletePraise(Set<String> nids, final OnRequestCompletedListener<PraiseDeleteData> listener) {
        String url = InteractionIdentityManager.processUrl(PraiseUrlConfig.deletePraise());
        JSONObject postJson = new JSONObject();
        JSONObject extJson = new JSONObject();
        try {
            extJson.put("sfrom", "history");
            extJson.put("source", NETSOURCE);
            extJson.put("type", "feed");
            postJson.put("ext", extJson.toString());
            JSONArray jsonArray = new JSONArray();
            for (String nid : nids) {
                jsonArray.put(nid);
            }
            postJson.put("nids", jsonArray.toString());
        } catch (Exception e2) {
            if (PraiseRuntime.DEBUG) {
                e2.printStackTrace();
            }
        }
        HttpManager httpManager = HttpManager.getDefault(AppRuntime.getAppContext());
        if (httpManager.isNetWorkConnected()) {
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) httpManager.postFormRequest().requestFrom(13)).requestSubFrom(104)).url(url)).addParam("data", postJson.toString())).cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(true, false))).build().executeAsync(new ResponseCallback<PraiseDeleteData>() {
                public PraiseDeleteData parseResponse(Response response, int i2) throws Exception {
                    if (response.body() != null) {
                        return PraiseDeleteData.parse(response.body().string(), "362");
                    }
                    return null;
                }

                public void onSuccess(PraiseDeleteData praiseDeleteData, int statusCode) {
                    OnRequestCompletedListener onRequestCompletedListener = OnRequestCompletedListener.this;
                    if (onRequestCompletedListener != null) {
                        onRequestCompletedListener.onCompleted(0, praiseDeleteData, "");
                    }
                }

                public void onFail(Exception e2) {
                    OnRequestCompletedListener onRequestCompletedListener = OnRequestCompletedListener.this;
                    if (onRequestCompletedListener != null) {
                        onRequestCompletedListener.onCompleted(-1, null, PraiseRuntime.getAppContext().getResources().getString(R.string.praise_network_error));
                    }
                }
            });
        } else if (listener != null) {
            listener.onCompleted(-1, null, PraiseRuntime.getAppContext().getResources().getString(R.string.praise_network_error));
        }
    }
}
