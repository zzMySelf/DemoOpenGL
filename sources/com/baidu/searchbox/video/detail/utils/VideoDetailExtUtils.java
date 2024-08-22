package com.baidu.searchbox.video.detail.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.feed.model.FeedBackData;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemDataNews;
import com.baidu.searchbox.feed.util.FeedLoginUtils;
import com.baidu.searchbox.video.detail.business.R;
import com.baidu.searchbox.video.detail.core.exception.IntentDataException;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.detail.export.IVideoAppConfig;
import com.baidu.searchbox.video.detail.export.IVideoPaymentUtils;
import com.baidu.searchbox.video.detail.export.IVideoUnitedSchemeUtility;
import com.baidu.searchbox.video.detail.model.VideoPaymentEpisodes;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoDetailExtUtils {
    private static final boolean DEBUG = IVideoAppConfig.Impl.get().isDebug();
    public static final Object EVENT_REGISTER_OBJ = new Object();
    public static final String KEY_DATA = "data";
    public static final String KEY_EXT = "ext";
    public static final String KEY_NEXT_MODEL = "KEY_NEXT_MODEL";
    public static final String KEY_NEXT_MODEL_EXT = "KEY_NEXT_MODEL_EXT";
    public static final String KEY_NID = "nid";
    public static final String KEY_TYPE = "type";
    public static final String TYPE_CELEBRITY = "celebrity";
    public static final String URL_JUMP_CHANNEL = "baiduboxapp://v11/appTab/select?item=video&upgrade=0&params={\"channel\":\"recommend\", \"refresh\":\"1\", \"pd\":\"landing_page\"}";
    public static final int VIDEO_ERROR_CODE_ERROR_PAGE = 303;
    public static final int VIDEO_ERROR_CODE_POSTER_ERROR = 305;
    public static final int VIDEO_ERROR_CODE_RECOMMEND_FAIL = 304;
    public static final int VIDEO_ERROR_CODE_SWITCH_FULL_FAIL = 399;
    public static final int VIDEO_ERROR_CODE_WIFI = 302;

    public static String convertNumber(Context context, long number) {
        return NumberUtils.INSTANCE.convertNumber(context, number);
    }

    public static String convertNumberDown(Context context, long number) {
        return NumberUtils.INSTANCE.convertNumberDown(context, number);
    }

    public static boolean isNull(Object o) {
        return o == null;
    }

    public static boolean isNotNull(Object o) {
        return o != null;
    }

    public static JSONArray getHistoryVid(ArrayList<FeedBaseModel> feedList) {
        JSONArray ja = new JSONArray();
        if (feedList != null) {
            int i2 = 0;
            int size = feedList.size();
            while (i2 < size) {
                FeedBaseModel model = feedList.get(i2);
                try {
                    if (TextUtils.isEmpty(model.id) || !model.id.startsWith("ad")) {
                        JSONObject jo = new JSONObject();
                        jo.put("clk", 0);
                        jo.put("clk_ts", 0);
                        jo.put("id", model.id);
                        jo.put("show", 1);
                        jo.put("show_ts", System.currentTimeMillis() / 1000);
                        ja.put(jo);
                        i2++;
                    } else {
                        i2++;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return ja;
    }

    public static void showErrorTip(Context context) {
        if (DEBUG) {
            UniversalToast.makeText(context, R.string.video_detail_scheme_error).showToast();
        }
    }

    public static void addExtLog(BdVideoSeries series, String ext) {
        try {
            JSONObject oldExtLogObj = new JSONObject(series.getExtLog());
            JSONObject newExtLogObj = new JSONObject(ext);
            Iterator iterator = newExtLogObj.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                oldExtLogObj.put(key, newExtLogObj.getString(key));
            }
            series.setExtLog(oldExtLogObj.toString());
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean isFewDaysAgo(long lastDay, int days) {
        return (System.currentTimeMillis() / 86400000) - (lastDay / 86400000) >= ((long) days);
    }

    public static void addNextPlayNeedType(Map<String, String> postParams, String nextPlayType) {
        if (!TextUtils.isEmpty(nextPlayType)) {
            try {
                JSONObject dataOj = new JSONObject(postParams.get("data"));
                dataOj.put(IntentData.KEY_COLLECTION_MODE, nextPlayType);
                postParams.put("data", dataOj.toString());
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void transformRecommendItemModeToFeedBaseModel(FeedBaseModel feedBaseModel, VideoPaymentEpisodes nextColumnInfo) {
        feedBaseModel.data = new FeedItemDataNews();
        ((FeedItemDataNews) feedBaseModel.data).title = nextColumnInfo.title;
        ((FeedItemDataNews) feedBaseModel.data).cmd.set(nextColumnInfo.cmd);
        ((FeedItemDataNews) feedBaseModel.data).images = new ArrayList();
        FeedItemDataNews.Image image = new FeedItemDataNews.Image();
        image.image = nextColumnInfo.posterImage;
        ((FeedItemDataNews) feedBaseModel.data).images.add(image);
        feedBaseModel.feedback = new FeedBackData();
    }

    public static void setTextStrikeLine(TextView textView) {
        textView.getPaint().setFlags(17);
    }

    public static boolean needSwitchToHalf(boolean isFull, boolean isLimitFree) {
        return isFull && (!isLimitFree || !FeedLoginUtils.isLoginNotGuest() || IVideoPaymentUtils.Impl.get().needShowGuideDialog(IVideoPaymentUtils.TYPE_AUDIO));
    }

    public static String getIntentParams(FeedBaseModel feedBaseModel) {
        if (feedBaseModel.data == null) {
            return "";
        }
        String cmd = feedBaseModel.data.cmd.get();
        if (IVideoUnitedSchemeUtility.Impl.get().isUnitedScheme(cmd)) {
            return IVideoUnitedSchemeUtility.Impl.get().getParams(cmd).get("params");
        }
        return "";
    }

    public static IntentData createIntent(String params) {
        if (TextUtils.isEmpty(params)) {
            return null;
        }
        try {
            return IntentData.create(params, false);
        } catch (IntentDataException e2) {
            if (!DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }
}
