package com.baidu.searchbox.audio.model.remote;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.audio.AudioConfig;
import com.baidu.searchbox.audio.model.Album;
import com.baidu.searchbox.audio.model.AlbumAddToShelfCallback;
import com.baidu.searchbox.audio.model.AlbumDataSource;
import com.baidu.searchbox.audio.model.AlbumLoadCallback;
import com.baidu.searchbox.audio.model.AlbumSubscribeCallback;
import com.baidu.searchbox.audio.model.Episode;
import com.baidu.searchbox.audio.model.EpisodeLanding;
import com.baidu.searchbox.audio.model.EpisodeLandingLoadCallback;
import com.baidu.searchbox.audio.model.EpisodeListLoadCallback;
import com.baidu.searchbox.audio.model.EpisodeLoadCallback;
import com.baidu.searchbox.audio.presenter.CommonPresenter;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.model.FeedItemDataHotStripe;
import com.baidu.searchbox.feed.model.FeedProtocolEntity;
import com.baidu.searchbox.feed.payment.FeedPayManager;
import com.baidu.searchbox.feed.payment.PayRequestAspect;
import com.baidu.searchbox.feed.payment.SpDetailUpdateEvent;
import com.baidu.searchbox.feed.payment.model.PayServerTransit;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.paywall.database.PaywallDbControl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AlbumRemoteDataSource implements AlbumDataSource {
    private static AlbumRemoteDataSource INSTANCE = null;
    public static final String SHELF_FAIL_MSG = "添加失败，请稍后重试";
    private static final String SHELF_SUCCESS_MSG = "添加成功";
    private static final String TAG = "AlbumRemoteDataSource";

    public static AlbumRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AlbumRemoteDataSource();
        }
        return INSTANCE;
    }

    private AlbumRemoteDataSource() {
    }

    public void getAlbum(String albumId, AlbumLoadCallback callback, String... args) {
        if (!NetWorkUtils.isNetworkConnected()) {
            callback.onAlbumNotAvailable();
        } else {
            requestAlbumAsyncV2(albumId, callback, args);
        }
    }

    private void requestAlbumAsyncV2(String albumId, final AlbumLoadCallback callback, String... args) {
        if (!TextUtils.isEmpty(albumId) && callback != null) {
            PayServerTransit payServerTransit = new PayServerTransit();
            payServerTransit.fillFrom(albumId, CommonPresenter.separateTraceSource(args), CommonPresenter.separateTraceSExt(args), "");
            FeedPayManager.setRequestAspect((PayRequestAspect) null);
            BdEventBus.Companion.getDefault().post(new SpDetailUpdateEvent(albumId, payServerTransit));
            String url = AudioConfig.getAlbumUrl();
            Map<String, String> paramsMap = new HashMap<>();
            JSONObject paramsJson = new JSONObject();
            try {
                paramsJson.put("id", albumId);
                paramsJson.put("pass_through", CommonPresenter.separateTraceSExt(args));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            paramsMap.put("data", paramsJson.toString());
            ResponseCallback<String> responseCallback = new ResponseCallback<String>() {
                public String parseResponse(Response response, int i2) throws Exception {
                    if (response == null || response.body() == null) {
                        return null;
                    }
                    return response.body().string();
                }

                public void onSuccess(String responseJson, int i2) {
                    if (TextUtils.isEmpty(responseJson)) {
                        callback.onAlbumNotAvailable();
                        return;
                    }
                    try {
                        JSONObject response = new JSONObject(responseJson);
                        if (!TextUtils.equals(response.optString("errno"), "0")) {
                            callback.onAlbumNotAvailable();
                            return;
                        }
                        JSONObject data = response.optJSONObject("data");
                        if (data == null) {
                            callback.onAlbumNotAvailable();
                            return;
                        }
                        String cmdStr = data.getString("266");
                        if (TextUtils.isEmpty(cmdStr)) {
                            callback.onAlbumNotAvailable();
                            return;
                        }
                        callback.onAlbumLoaded((Album) new GsonBuilder().registerTypeAdapter(List.class, new JsonDeserializer<List<?>>() {
                            public List<?> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                                if (json == null || !json.isJsonArray()) {
                                    return new ArrayList();
                                }
                                return (List) new Gson().fromJson(json, typeOfT);
                            }
                        }).create().fromJson(cmdStr, Album.class));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        callback.onAlbumNotAvailable();
                    }
                }

                public void onFail(Exception e2) {
                    callback.onAlbumNotAvailable();
                }
            };
            String url2 = TTSRuntime.getInstance().addBasicParams(url);
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getApplication()).postFormRequest().url(url2)).params(paramsMap)).cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(true, false))).connectionTimeout(3000)).build().executeAsyncOnUIBack(responseCallback);
        }
    }

    public void getEpisodeList(String albumId, String audioId, List<String> flags, List<String> list, EpisodeListLoadCallback callback, String... args) {
        String type = "down";
        if (flags.contains("back")) {
            type = "up";
        }
        requestEpisodeListAsyncV2(albumId, audioId, type, callback, args);
    }

    private void requestEpisodeListAsyncV2(String albumId, String audioId, String type, final EpisodeListLoadCallback callback, String... args) {
        String url = AudioConfig.getEpisodesUrl();
        ResponseCallback<String> responseCallback = new ResponseCallback<String>() {
            public String parseResponse(Response response, int i2) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return response.body().string();
            }

            public void onSuccess(String responseJson, int code) {
                if (TextUtils.isEmpty(responseJson)) {
                    callback.onDataNotAvailable();
                    return;
                }
                List<Episode> episodeList = new ArrayList<>();
                try {
                    try {
                        JSONObject data = new JSONObject(responseJson).optJSONObject("data");
                        if (data == null) {
                            callback.onDataNotAvailable();
                            return;
                        }
                        JSONObject cmd = data.optJSONObject("267");
                        if (cmd == null) {
                            callback.onDataNotAvailable();
                            return;
                        }
                        JSONObject listObj = cmd.optJSONObject("itemlist");
                        String optString = listObj.optString("type");
                        String optString2 = listObj.optString(FeedProtocolEntity.FEED_DATASIGN);
                        JSONArray list = listObj.optJSONArray("items");
                        if (list == null) {
                            callback.onDataNotAvailable();
                            return;
                        }
                        int size = list.length();
                        Gson gson = new Gson();
                        for (int i2 = 0; i2 < size; i2++) {
                            episodeList.add((Episode) gson.fromJson(list.optJSONObject(i2).toString(), Episode.class));
                        }
                        callback.onEpisodesLoaded(episodeList);
                    } catch (Exception e2) {
                        e = e2;
                        callback.onDataNotAvailable();
                        e.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    String str = responseJson;
                    callback.onDataNotAvailable();
                    e.printStackTrace();
                }
            }

            public void onFail(Exception e2) {
                callback.onDataNotAvailable();
            }
        };
        String url2 = TTSRuntime.getInstance().addBasicParams(url);
        String sExt = "";
        if (args != null && args.length > 0) {
            sExt = args[0];
        }
        Map<String, String> paramsMap = new HashMap<>();
        try {
            JSONObject paramsJson = new JSONObject();
            paramsJson.put("id", albumId);
            paramsJson.put("sourceid", audioId);
            paramsJson.put("quantity", 15);
            paramsJson.put("type", type);
            paramsJson.put("pass_through", sExt);
            paramsMap.put("data", paramsJson.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getApplication()).postFormRequest().url(url2)).params(paramsMap)).cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(true, false))).connectionTimeout(3000)).build().executeAsyncOnUIBack(responseCallback);
    }

    public void refreshEpisodes() {
    }

    public void subscribeAlbum(Album album, final String operation, final AlbumSubscribeCallback callback) {
        String url = AudioConfig.getFollowActionUrl();
        ResponseCallback<String> responseCallback = new ResponseCallback<String>() {
            public String parseResponse(Response response, int i2) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return response.body().string();
            }

            public void onSuccess(String responseJson, int code) {
                if (responseJson == null || TextUtils.isEmpty(responseJson)) {
                    callback.onDataNotAvailable();
                    return;
                }
                int errorNum = -1;
                try {
                    errorNum = new JSONObject(responseJson).optInt("errno");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (errorNum == 0) {
                    callback.onAlbumSubscribe((int) TextUtils.equals("add", operation));
                    return;
                }
                callback.onDataNotAvailable();
            }

            public void onFail(Exception e2) {
                callback.onDataNotAvailable();
            }
        };
        String url2 = TTSRuntime.getInstance().addBasicParams(url);
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("type", album.getFollowContentType());
        paramsMap.put("third_id", album.getFollowContentThirdId());
        paramsMap.put("sfrom", album.getFollowContentSfrom());
        paramsMap.put("source", album.getFollowContentSource());
        paramsMap.put("ext", album.getFollowContentExt());
        paramsMap.put("op_type", operation);
        paramsMap.put("store", "uid_cuid");
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getApplication()).postFormRequest().url(url2)).params(paramsMap)).cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(true, false))).build().executeAsyncOnUIBack(responseCallback);
        if (AudioConfig.AUDIO_DEBUG) {
            Log.d(TAG, "subscribeAlbum() " + paramsMap);
        }
    }

    public void fetchRealPlayURL(String albumID, String episodeID, String ext, EpisodeLoadCallback callback) {
        requestRealURLAsync(albumID, episodeID, ext, callback);
    }

    private void requestRealURLAsync(String albumID, String episodeID, String ext, final EpisodeLoadCallback callback) {
        String url = AudioConfig.getRealAudioUrl();
        ResponseCallback<String> responseCallback = new ResponseCallback<String>() {
            public String parseResponse(Response response, int i2) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return response.body().string();
            }

            public void onSuccess(String responseJson, int code) {
                if (TextUtils.isEmpty(responseJson)) {
                    callback.onEpisodeNotAvailable();
                    return;
                }
                try {
                    JSONObject data = new JSONObject(responseJson).optJSONObject("data");
                    if (data == null) {
                        callback.onEpisodeNotAvailable();
                        return;
                    }
                    JSONObject cmd = data.getJSONObject("259");
                    if (cmd == null) {
                        callback.onEpisodeNotAvailable();
                        return;
                    }
                    callback.onRealURLLoaded(cmd.optString("url"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }

            public void onFail(Exception e2) {
                callback.onEpisodeNotAvailable();
            }
        };
        Map<String, String> paramsMap = new HashMap<>();
        JSONObject paramsJson = new JSONObject();
        try {
            paramsJson.put("albumId", albumID);
            paramsJson.put("audioId", episodeID);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            paramsJson.put("audioExt", new JSONObject(ext));
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        paramsMap.put("data", paramsJson.toString());
        String url2 = TTSRuntime.getInstance().addBasicParams(url);
        ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(AppRuntime.getApplication()).postRequest().url(url2)).addUrlParams(paramsMap)).cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(true, false))).build().executeAsyncOnUIBack(responseCallback);
    }

    public void addToBookshelf(Album album, String tplid, AlbumAddToShelfCallback callback) {
        String id = "";
        String url = AudioConfig.getAddToBookshelfUrl();
        final Album album2 = album;
        final AlbumAddToShelfCallback albumAddToShelfCallback = callback;
        ResponseCallback<String> responseCallback = new ResponseCallback<String>() {
            public String parseResponse(Response response, int i2) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return response.body().string();
            }

            public void onSuccess(String responseJson, int code) {
                if (TextUtils.isEmpty(responseJson)) {
                    albumAddToShelfCallback.onAddToBookshelfFail(AlbumRemoteDataSource.SHELF_FAIL_MSG);
                    return;
                }
                try {
                    JSONObject response = new JSONObject(responseJson);
                    String errmsg = response.optString("errmsg");
                    JSONObject data = response.optJSONObject("data");
                    if (data == null) {
                        albumAddToShelfCallback.onAddToBookshelfFail(errmsg);
                    } else if (TextUtils.equals("0", data.optString(album2.getFollowContentThirdId()))) {
                        albumAddToShelfCallback.onAddToBookShelfSuccess(AlbumRemoteDataSource.SHELF_SUCCESS_MSG);
                    } else {
                        albumAddToShelfCallback.onAddToBookshelfFail(errmsg);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    albumAddToShelfCallback.onAddToBookshelfFail(AlbumRemoteDataSource.SHELF_FAIL_MSG);
                }
            }

            public void onFail(Exception e2) {
                albumAddToShelfCallback.onAddToBookshelfFail(AlbumRemoteDataSource.SHELF_FAIL_MSG);
            }
        };
        Map<String, String> paramsMap = new HashMap<>();
        JSONObject paramsJson = new JSONObject();
        try {
            String ext = album.getFollowContentExt();
            String last = id;
            if (!TextUtils.isEmpty(ext)) {
                JSONObject extObject = new JSONObject(ext);
                id = extObject.optString("id");
                last = extObject.optString(FeedItemDataHotStripe.POSITION_LAST);
            }
            JSONArray items = new JSONArray();
            JSONObject item = new JSONObject();
            try {
                item.put("tplid", tplid);
                String str = id;
                item.put("third_id", album.getFollowContentThirdId());
                item.put("type", album.getFollowContentType());
                item.put("time", last);
                JSONObject itemData = new JSONObject();
                itemData.put("source", album.getFollowContentSource());
                itemData.put(PaywallDbControl.COLUMN_OWN_TYPE, album.getPayState());
                itemData.put(PaywallDbControl.COLUMN_READ_TIME, last);
                itemData.put(FeedItemDataHotStripe.POSITION_LAST, last);
                item.put("data", itemData);
                items.put(item);
                paramsJson.put("items", items);
                paramsJson.put("cate", "shelf");
            } catch (JSONException e2) {
                e = e2;
            }
        } catch (JSONException e3) {
            e = e3;
            String str2 = tplid;
            e.printStackTrace();
            paramsMap.put("data", paramsJson.toString());
            String url2 = TTSRuntime.getInstance().addBasicParams(url);
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(AppRuntime.getApplication()).postRequest().url(url2)).addUrlParams(paramsMap)).cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(true, false))).build().executeAsyncOnUIBack(responseCallback);
        }
        paramsMap.put("data", paramsJson.toString());
        String url22 = TTSRuntime.getInstance().addBasicParams(url);
        ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(AppRuntime.getApplication()).postRequest().url(url22)).addUrlParams(paramsMap)).cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(true, false))).build().executeAsyncOnUIBack(responseCallback);
    }

    public void getEpisodeLandingData(String albumId, String audioId, final EpisodeLandingLoadCallback callback) {
        String url = AudioConfig.getEpisodeLandingUrl();
        ResponseCallback<String> responseCallback = new ResponseCallback<String>() {
            public String parseResponse(Response response, int i2) throws Exception {
                if (response == null || response.body() == null || callback == null) {
                    return null;
                }
                return response.body().string();
            }

            public void onSuccess(String responseJson, int code) {
                if (callback != null) {
                    if (TextUtils.isEmpty(responseJson)) {
                        callback.onDataNotAvailable();
                        return;
                    }
                    try {
                        JSONObject response = new JSONObject(responseJson);
                        if (response.optInt("errno", -1) != 0) {
                            callback.onDataNotAvailable();
                            return;
                        }
                        JSONObject data = response.optJSONObject("data");
                        if (data == null) {
                            callback.onDataNotAvailable();
                            return;
                        }
                        String cmdStr = data.getString(AudioConfig.CMD_EPISODE_LANDING);
                        if (TextUtils.isEmpty(cmdStr)) {
                            callback.onDataNotAvailable();
                            return;
                        }
                        callback.onLandingDataLoaded((EpisodeLanding) new GsonBuilder().registerTypeAdapter(List.class, new JsonDeserializer<List<?>>() {
                            public List<?> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                                if (json == null || !json.isJsonArray()) {
                                    return new ArrayList();
                                }
                                return (List) new Gson().fromJson(json, typeOfT);
                            }
                        }).create().fromJson(cmdStr, EpisodeLanding.class));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }

            public void onFail(Exception e2) {
                EpisodeLandingLoadCallback episodeLandingLoadCallback = callback;
                if (episodeLandingLoadCallback != null) {
                    episodeLandingLoadCallback.onDataNotAvailable();
                }
            }
        };
        String url2 = TTSRuntime.getInstance().addBasicParams(url);
        Map<String, String> paramsMap = new HashMap<>();
        try {
            JSONObject paramsJson = new JSONObject();
            paramsJson.put("id", audioId);
            paramsMap.put("data", paramsJson.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getApplication()).postFormRequest().url(url2)).params(paramsMap)).cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(true, false))).connectionTimeout(3000)).build().executeAsyncOnUIBack(responseCallback);
    }
}
