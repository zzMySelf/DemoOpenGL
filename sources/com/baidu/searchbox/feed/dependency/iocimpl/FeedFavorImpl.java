package com.baidu.searchbox.feed.dependency.iocimpl;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.bookmark.BookMarkLoginUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.favor.IFavorManager;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.ioc.IFeedFavor;
import com.baidu.searchbox.history.api.IHistoryManager;
import com.baidu.searchbox.history.api.callback.HistoryDataCallback;
import com.baidu.searchbox.history.api.data.HistoryFeature;
import com.baidu.searchbox.history.api.data.HistoryModel;
import com.baidu.searchbox.introduction.model.FavorIntroductionUtils;
import com.baidu.searchbox.sync.FavorUIOperator;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class FeedFavorImpl implements IFeedFavor {
    public boolean isFavor(String nid) {
        return ((IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE)).isFavored(nid);
    }

    public void favorFeed(Context context, IFeedFavor.FavorParams params, JSONObject ubcJo, IFeedFavor.FavorQueryResult callback) {
        if (params != null) {
            final IFeedFavor.FavorParams favorParams = params;
            final JSONObject jSONObject = ubcJo;
            final Context context2 = context;
            final IFeedFavor.FavorQueryResult favorQueryResult = callback;
            BookMarkLoginUtils.addBookMark(context, 5, new BookMarkLoginUtils.OnAllowBookMarkListener() {
                public void allowUseBookMark() {
                    JSONObject extraObj;
                    Context appContext = AppRuntime.getAppContext();
                    final FavorModel favor = FavorModel.toFavorModel(favorParams.rawData, favorParams.uKey, favorParams.sid);
                    if (favor == null || favor.shouldFilterUrl()) {
                        UniversalToast.makeText(appContext, (CharSequence) appContext.getString(R.string.feed_save_fail)).showToast();
                        return;
                    }
                    if (TextUtils.equals(favor.tplId, "video")) {
                        favor.tplId = "feed_video";
                    }
                    if (jSONObject != null) {
                        try {
                            if (!TextUtils.isEmpty(favor.getExtData())) {
                                extraObj = new JSONObject(favor.getExtData());
                            } else {
                                extraObj = new JSONObject();
                            }
                            extraObj.putOpt("ubcjson", jSONObject);
                            favor.extra1 = new FavorModel.ExtraBuilder().setExtData(extraObj.toString()).build();
                        } catch (JSONException e2) {
                            if (FeedRuntime.GLOBAL_DEBUG) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    Observable.just("").subscribeOn(Schedulers.io()).map(new Func1<String, Boolean>() {
                        public Boolean call(String s) {
                            IFavorManager manager = (IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE);
                            FavorModel existFavor = manager.queryFavor(favor.uKey);
                            if (existFavor != null) {
                                favor.serverId = existFavor.serverId;
                            }
                            FavorUIOperator.addOrRemoveFavor(context2, favor);
                            return Boolean.valueOf(manager.isFavored(favor.uKey));
                        }
                    }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Boolean>() {
                        public void call(Boolean isFavored) {
                            if (favorQueryResult != null) {
                                favorQueryResult.isFavor(isFavored.booleanValue());
                            }
                        }
                    });
                }

                public void loginFail() {
                }
            });
        }
    }

    public void addHistory(IFeedFavor.FavorParams model) {
        if (model != null && !TextUtils.isEmpty(model.uKey) && !model.uKey.startsWith(FavorModel.FILTER_URL_SCHEME) && !TextUtils.isEmpty(model.rawData)) {
            try {
                JSONObject favoriteJo = new JSONObject(model.rawData);
                String title = favoriteJo.optString("title");
                String img = favoriteJo.optString("img");
                String url = favoriteJo.optString("url");
                String cmd = favoriteJo.optString("command");
                HistoryModel historyModel = new HistoryModel();
                historyModel.setUkey(model.uKey);
                historyModel.setTplId("feed_video");
                historyModel.setTitle(title);
                historyModel.setImg(img);
                historyModel.setUrl(url);
                historyModel.setCmd(cmd);
                historyModel.setCreateTime(System.currentTimeMillis());
                JSONObject featureJo = favoriteJo.optJSONObject("feature");
                if (featureJo != null) {
                    HistoryFeature feature = new HistoryFeature();
                    feature.setSource(featureJo.optString("source"));
                    feature.setDuration(Long.parseLong(featureJo.optString("duration")));
                    historyModel.setFeature(feature);
                }
                JSONObject extra = new JSONObject();
                JSONObject ubcJson = new JSONObject();
                ubcJson.putOpt("source", "read_video");
                ubcJson.putOpt("value", "feed");
                extra.putOpt("ubcjson", ubcJson);
                historyModel.setExtra(extra.toString());
                ((IHistoryManager) ServiceManager.getService(IHistoryManager.SERVICE_REFERENCE)).addHistory(historyModel, (HistoryDataCallback<Boolean>) null);
            } catch (Exception e2) {
                if (FeedRuntime.GLOBAL_DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void registryFavorListener(Object objTag) {
        FavorIntroductionUtils.registerFavorSuccessListener(this);
    }
}
