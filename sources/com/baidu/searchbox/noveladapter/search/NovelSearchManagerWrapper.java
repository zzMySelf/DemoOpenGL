package com.baidu.searchbox.noveladapter.search;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.browser.utils.IncognitoModeInterface;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.history.api.IHistoryManager;
import com.baidu.searchbox.history.api.callback.HistoryDataCallback;
import com.baidu.searchbox.history.api.data.HistoryFeature;
import com.baidu.searchbox.history.api.data.HistoryModel;
import com.baidu.searchbox.history.data.TplEnum;
import com.baidu.searchbox.noveladapter.ubc.NovelUBCDurationSearchSessionWrapper;
import org.json.JSONException;
import org.json.JSONObject;

public class NovelSearchManagerWrapper implements NoProGuard {
    public static void addToSearchHistory(JSONObject jsonObj) {
        IncognitoModeInterface modeInterface = (IncognitoModeInterface) ServiceManager.getService(IncognitoModeInterface.SERVICE_REFERENCE);
        if ((modeInterface == null || !modeInterface.isIncognitoSwitchOn()) && jsonObj != null) {
            String ukey = jsonObj.optString("ukey");
            String source = jsonObj.optString("source");
            String ubcjson = jsonObj.optString("ubcjson");
            String url = jsonObj.optString("url");
            String scheme = jsonObj.optString("scheme");
            String title = jsonObj.optString("title");
            HistoryModel historyModel = new HistoryModel();
            historyModel.setCreateTime(System.currentTimeMillis());
            historyModel.setUrl(url);
            historyModel.setTitle(title);
            historyModel.setUkey(ukey);
            historyModel.setTplId("search_text_url");
            historyModel.setCmd(Uri.decode(scheme));
            historyModel.setExtra(Uri.decode(ubcjson));
            HistoryFeature feature = new HistoryFeature();
            feature.setSource(source);
            historyModel.setFeature(feature);
            IHistoryManager historyManager = (IHistoryManager) ServiceManager.getService(IHistoryManager.SERVICE_REFERENCE);
            if (historyManager != null) {
                historyManager.addHistory(historyModel, (HistoryDataCallback<Boolean>) null);
            }
        }
    }

    public static void addNovelReadHistory(JSONObject jsonObj) {
        if (jsonObj != null) {
            String ukey = jsonObj.optString("ukey");
            String imageurl = jsonObj.optString("imageurl");
            String title = jsonObj.optString("title");
            String subtitle = jsonObj.optString("subtitle");
            String source = jsonObj.optString("source");
            String iconlabel = jsonObj.optString("iconlabel");
            String scheme = jsonObj.optString("scheme");
            String url = jsonObj.optString("url");
            String optString = jsonObj.optString("ubcjson");
            final HistoryModel historyModel = new HistoryModel();
            historyModel.setUkey(ukey);
            historyModel.setImg(imageurl);
            historyModel.setTitle(title);
            historyModel.setUrl(url);
            historyModel.setTplId(TplEnum.TPL_NOVEL);
            historyModel.setCmd(Uri.decode(scheme));
            HistoryFeature feature = new HistoryFeature();
            feature.setSubTitle(subtitle);
            feature.setIconLabel(iconlabel);
            feature.setSource(source);
            historyModel.setFeature(feature);
            final IHistoryManager historyManager = (IHistoryManager) ServiceManager.getService(IHistoryManager.SERVICE_REFERENCE);
            if (historyManager != null) {
                historyManager.queryHistory(historyModel.getUkey(), new HistoryDataCallback<HistoryModel>() {
                    public void onResult(HistoryModel data) {
                        if (data != null) {
                            try {
                                JSONObject extra = new JSONObject();
                                if (!TextUtils.isEmpty(data.getUkey())) {
                                    if (!TextUtils.isEmpty(data.getExtra())) {
                                        extra.put("rootSource", new JSONObject(data.getExtra()).optString("rootSource", "other"));
                                    }
                                } else if (NovelUBCDurationSearchSessionWrapper.isInSearchSession()) {
                                    extra.put("rootSource", "search");
                                } else {
                                    extra.put("rootSource", "other");
                                }
                                HistoryModel.this.setExtra(extra.toString());
                            } catch (JSONException e2) {
                                if (AppConfig.isDebug()) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        historyManager.addHistory(HistoryModel.this, (HistoryDataCallback<Boolean>) null);
                    }
                });
            }
        }
    }
}
