package com.baidu.nadcore.model;

import android.text.TextUtils;
import com.baidu.appsearch.lite.AppsearchNetService;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.safe.CollectionUtils;
import com.baidu.nadcore.safe.JSONUtils;
import com.baidu.swan.apps.adlanding.OpenAdMaxViewAction;
import com.facebook.common.util.UriUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdResponseParser {
    private static final String TAG = "AdResponseParser";

    public static AdBaseModel[] parseFromAfd(String result, String[] pids) throws ParseError {
        if (!TextUtils.isEmpty(result)) {
            JSONObject adJson = JSONUtils.newJSONObject(result).optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
            if (adJson == null) {
                throw ParseError.parseError(31, "");
            } else if (adJson.optInt("status", 0) == 0) {
                JSONArray adArr = adJson.optJSONArray("ad");
                if (adArr != null) {
                    int length = adArr.length();
                    List<AdBaseModel> m = new ArrayList<>();
                    for (int i2 = 0; i2 < length; i2++) {
                        try {
                            CollectionUtils.addAll(m, parseAd(adArr.optJSONObject(i2), pids));
                        } catch (ParseError error) {
                            reportDiscard(error, 0, (String) null);
                        }
                    }
                    return (AdBaseModel[]) m.toArray(new AdBaseModel[0]);
                }
                throw ParseError.parseError(44, "");
            } else {
                throw ParseError.parseError(42, "");
            }
        } else {
            throw ParseError.parseError(29, "");
        }
    }

    private static List<AdBaseModel> parseAd(JSONObject first, String[] pids) throws ParseError {
        if (first != null) {
            String locCode = first.optString("locCode");
            if (!TextUtils.isEmpty(locCode)) {
                String pid = "";
                int length = pids.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    String i3 = pids[i2];
                    if (!TextUtils.isEmpty(i3) && locCode.startsWith(i3)) {
                        pid = i3;
                        break;
                    }
                    i2++;
                }
                if (!TextUtils.isEmpty(pid)) {
                    JSONArray adInfoArray = first.optJSONArray(OpenAdMaxViewAction.AD_PARAMS_KEY);
                    if (adInfoArray == null || adInfoArray.length() == 0) {
                        throw ParseError.parseError(34, "", pid);
                    }
                    List<AdBaseModel> result = new ArrayList<>();
                    for (int i4 = 0; i4 < adInfoArray.length(); i4++) {
                        try {
                            AdBaseModel model = parseAdInfo(pid, adInfoArray.optJSONObject(i4));
                            if (model.error == null) {
                                CollectionUtils.add(result, model);
                            }
                        } catch (ParseError error) {
                            reportDiscard(error, 0, (String) null);
                        }
                    }
                    return result;
                }
                throw ParseError.parseError(46, "", locCode + "#" + TextUtils.join("#", pids));
            }
            throw ParseError.parseError(33, "");
        }
        throw ParseError.parseError(32, "");
    }

    private static AdBaseModel parseAdInfo(String pid, JSONObject adInfo) throws ParseError {
        if (adInfo != null) {
            boolean z = true;
            if (adInfo.optInt("advisible", 1) != 0) {
                z = false;
            }
            boolean isEmpty = z;
            String extraParam = null;
            if (isEmpty) {
                String str = null;
                if (adInfo.has("ext_info")) {
                    str = adInfo.optString("ext_info", (String) null);
                }
                extraParam = str;
            }
            if (extraParam == null) {
                JSONArray extraArray = adInfo.optJSONArray("extra");
                if (extraArray == null || extraArray.length() == 0) {
                    throw ParseError.parseError(36, "", pid);
                }
                int extraArrayLength = extraArray.length();
                int i2 = 0;
                while (true) {
                    if (i2 >= extraArrayLength) {
                        break;
                    }
                    JSONObject object = extraArray.optJSONObject(i2);
                    if (object != null) {
                        String k = object.optString("k");
                        String v = object.optString("v");
                        if (!TextUtils.isEmpty(v) && TextUtils.equals("extraParam", k)) {
                            extraParam = v;
                            break;
                        }
                    }
                    i2++;
                }
            }
            if (extraParam != null) {
                JSONArray materialArray = adInfo.optJSONArray("material");
                if (materialArray == null || materialArray.length() == 0) {
                    throw ParseError.parseError(38, extraParam, pid);
                }
                JSONObject material = materialArray.optJSONObject(0);
                if (material != null) {
                    try {
                        JSONArray infoArray = new JSONArray(material.optString("info"));
                        if (infoArray.length() != 0) {
                            JSONObject info = infoArray.optJSONObject(0);
                            if (info != null) {
                                int floor = adInfo.optInt("floor");
                                AdBaseModel model = parseSingleAd(pid, floor, info, extraParam);
                                if (model != null) {
                                    model.imTimeSign = material.optInt(AppsearchNetService.IM_TIME_SIGN_NAME, -1);
                                    if (model.error == null) {
                                        return model;
                                    }
                                    reportDiscard(model.error, adInfo.optInt("floor"), model.common.extraParam);
                                    return model;
                                } else if (isEmpty) {
                                    return new AdBaseModel(AdModelCommon.create(pid, floor, new JSONObject(), new JSONObject(), extraParam), new JSONObject());
                                } else {
                                    throw ParseError.contentError(24, "", extraParam);
                                }
                            } else {
                                throw ParseError.parseError(41, extraParam, pid);
                            }
                        } else {
                            throw ParseError.parseError(40, extraParam, pid);
                        }
                    } catch (JSONException e2) {
                        throw ParseError.parseError(40, extraParam, pid);
                    }
                } else {
                    throw ParseError.parseError(39, extraParam, pid);
                }
            } else {
                throw ParseError.parseError(37, "", pid);
            }
        } else {
            throw ParseError.parseError(35, "", pid);
        }
    }

    public static AdBaseModel parseSingleAd(String pid, int floor, JSONObject root, String extParam) throws ParseError {
        JSONObject co2 = root.optJSONObject("ad_common");
        if (co2 == null) {
            return null;
        }
        AdModelCommon common = AdModelCommon.create(pid, floor, root, co2, extParam);
        switch (AnonymousClass1.$SwitchMap$com$baidu$nadcore$model$AdBaseModel$STYLE[common.style.ordinal()]) {
            case 1:
            case 2:
                return new AdBigImageModel(common, root);
            case 3:
                return new AdPortraitVideoModel(common, root);
            case 4:
                return new AdVideoModel(common, root);
            case 5:
                return new AdThreeImageModel(common, root);
            case 6:
            case 7:
            case 8:
                return new AdBaseModel(common, root);
            case 9:
                return new AdRewardVideoLpModel(common, root);
            default:
                throw ParseError.contentError(23, common.style.value);
        }
    }

    /* renamed from: com.baidu.nadcore.model.AdResponseParser$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$nadcore$model$AdBaseModel$STYLE;

        static {
            int[] iArr = new int[AdBaseModel.STYLE.values().length];
            $SwitchMap$com$baidu$nadcore$model$AdBaseModel$STYLE = iArr;
            try {
                iArr[AdBaseModel.STYLE.SMALL_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$model$AdBaseModel$STYLE[AdBaseModel.STYLE.BIG_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$model$AdBaseModel$STYLE[AdBaseModel.STYLE.PORTRAIT_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$model$AdBaseModel$STYLE[AdBaseModel.STYLE.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$model$AdBaseModel$STYLE[AdBaseModel.STYLE.THREE_IMAGE.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$model$AdBaseModel$STYLE[AdBaseModel.STYLE.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$model$AdBaseModel$STYLE[AdBaseModel.STYLE.MAX.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$model$AdBaseModel$STYLE[AdBaseModel.STYLE.REWARD_VIDEO_LP.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$model$AdBaseModel$STYLE[AdBaseModel.STYLE.REWARD_VIDEO_LP_IMPL.ordinal()] = 9;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    private static void reportDiscard(ParseError error, int floor, String extraParam) {
        reportDiscard(error.mType, error.mReason, error.mTplName, error.mPid, floor, !TextUtils.isEmpty(extraParam) ? extraParam : error.mExtraParam);
    }

    private static void reportDiscard(int type, int reason, String layout, String placeId, int floor, String extraParam) {
    }
}
