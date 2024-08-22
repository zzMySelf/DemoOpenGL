package com.baidu.searchbox.interaction.encourage.update;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.interaction.encourage.model.EasterEggConfigModel;
import com.baidu.searchbox.interaction.encourage.model.EncourageConfigModel;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.schemedispatch.monitor.AutoplayCheck;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J6\u0010\u0014\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J(\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0018H\u0002J\u001e\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001d0!2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0018H\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/interaction/encourage/update/EasterEggConfigListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/interaction/encourage/model/EncourageConfigModel;", "Lkotlin/collections/ArrayList;", "sourceDataMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "addPostData", "", "context", "Landroid/content/Context;", "module", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "parseConfigData", "data", "parseEasterEggConfig", "Lcom/baidu/searchbox/interaction/encourage/model/EasterEggConfigModel;", "lowDays", "jsonObject", "parseSingleActionConfig", "", "lib-interaction-encourage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EasterEggConfigListener.kt */
public final class EasterEggConfigListener extends JSONObjectCommandListener {
    private ArrayList<EncourageConfigModel> dataList = new ArrayList<>();
    private HashMap<String, Integer> sourceDataMap = new HashMap<>();

    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        CharSequence charSequence = module;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = action;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z && postData != null) {
                postData.getVersion().put(EasterEggConfigListenerKt.EASTER_EGG_ACTION, getLocalVersion(context, module, action));
            }
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        CharSequence charSequence = module;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = action;
            if ((charSequence2 == null || charSequence2.length() == 0) || !TextUtils.equals(EasterEggConfigListenerKt.EASTER_EGG_ACTION, action) || value == null || value.data == null || TextUtils.equals(getLocalVersion(context, module, action), value.version)) {
                return false;
            }
            DefaultSharedPrefsWrapper.getInstance().putString(EasterEggConfigListenerKt.KEY_EASTER_EGG_VERSION, value.version);
            T t = value.data;
            Intrinsics.checkNotNullExpressionValue(t, "value.data");
            parseConfigData((JSONObject) t);
            DefaultSharedPrefsWrapper.getInstance().putString(EasterEggConfigListenerKt.EASTER_EGG_SOURCE_DATA_MAP, new Gson().toJson((Object) this.sourceDataMap));
            DefaultSharedPrefsWrapper.getInstance().putString(EasterEggConfigListenerKt.EASTER_EGG_CONFIG_MODEL_LIST, new Gson().toJson((Object) this.dataList));
            return true;
        }
        return false;
    }

    private final void parseConfigData(JSONObject data) {
        Unit unit;
        JSONArray configs;
        JSONObject jSONObject = data;
        DefaultSharedPrefsWrapper.getInstance().putInt("normal_show_max_times", jSONObject.optInt("normal_times", 0));
        DefaultSharedPrefsWrapper.getInstance().putInt("hot_show_max_times", jSONObject.optInt("hot_times", 0));
        JSONArray configs2 = jSONObject.optJSONArray("config");
        EncourageConfigModel encourageConfigModel = new EncourageConfigModel((Map) null, (Map) null, (Map) null, 7, (DefaultConstructorMarker) null);
        try {
            Result.Companion companion = Result.Companion;
            EasterEggConfigListener $this$parseConfigData_u24lambda_u2d4 = this;
            if (configs2 != null) {
                JSONArray $this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3 = configs2;
                int i2 = 0;
                int length = $this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3.length();
                while (i2 < length) {
                    JSONObject $this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2 = $this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3.getJSONObject(i2);
                    JSONArray $this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d0 = $this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.optJSONArray(AutoplayCheck.AUTOPLAY_WHITE_LIST);
                    if ($this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d0 != null) {
                        Intrinsics.checkNotNullExpressionValue($this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d0, "optJSONArray(\"white_list\")");
                        int j2 = 0;
                        int length2 = $this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d0.length();
                        while (j2 < length2) {
                            Map map = $this$parseConfigData_u24lambda_u2d4.sourceDataMap;
                            String string = $this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d0.getString(j2);
                            JSONArray configs3 = configs2;
                            try {
                                Intrinsics.checkNotNullExpressionValue(string, "getString(j)");
                                map.put(string, Integer.valueOf(i2));
                                j2++;
                                JSONObject jSONObject2 = data;
                                configs2 = configs3;
                            } catch (Throwable th2) {
                                th = th2;
                                Result.Companion companion2 = Result.Companion;
                                Result.m8971constructorimpl(ResultKt.createFailure(th));
                            }
                        }
                        configs = configs2;
                    } else {
                        configs = configs2;
                    }
                    EncourageConfigModel $this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1 = encourageConfigModel;
                    $this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.setCommentConfig($this$parseConfigData_u24lambda_u2d4.parseSingleActionConfig($this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.optJSONObject("comment")));
                    $this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.setPraiseConfig($this$parseConfigData_u24lambda_u2d4.parseSingleActionConfig($this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.optJSONObject("like")));
                    $this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.setShareConfig($this$parseConfigData_u24lambda_u2d4.parseSingleActionConfig($this$parseConfigData_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.optJSONObject("share")));
                    $this$parseConfigData_u24lambda_u2d4.dataList.add(encourageConfigModel);
                    i2++;
                    JSONObject jSONObject3 = data;
                    configs2 = configs;
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m8971constructorimpl(unit);
        } catch (Throwable th3) {
            th = th3;
            JSONArray jSONArray = configs2;
            Result.Companion companion22 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final Map<String, EasterEggConfigModel> parseSingleActionConfig(JSONObject jsonObject) {
        boolean z;
        HashMap configMap = new HashMap();
        int days = jsonObject != null ? jsonObject.optInt("low_day") : 0;
        JSONArray data = null;
        JSONArray conditions = jsonObject != null ? jsonObject.optJSONArray("all_keys") : null;
        if (jsonObject != null) {
            data = jsonObject.optJSONArray("material");
        }
        try {
            Result.Companion companion = Result.Companion;
            EasterEggConfigListener $this$parseSingleActionConfig_u24lambda_u2d5 = this;
            if (!(conditions == null || data == null || conditions.length() != data.length())) {
                int length = conditions.length();
                for (int i2 = 0; i2 < length; i2++) {
                    String key = conditions.getString(i2);
                    EasterEggConfigModel model = $this$parseSingleActionConfig_u24lambda_u2d5.parseEasterEggConfig(days, data.optJSONObject(i2));
                    CharSequence charSequence = key;
                    if (charSequence != null) {
                        if (charSequence.length() != 0) {
                            z = false;
                            if (!z && model != null) {
                                Intrinsics.checkNotNullExpressionValue(key, "key");
                                configMap.put(key, model);
                            }
                        }
                    }
                    z = true;
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    configMap.put(key, model);
                }
            }
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        return configMap;
    }

    private final EasterEggConfigModel parseEasterEggConfig(int lowDays, JSONObject jsonObject) {
        try {
            Result.Companion companion = Result.Companion;
            EasterEggConfigListener easterEggConfigListener = this;
            if (jsonObject != null) {
                JSONObject $this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7 = jsonObject;
                EasterEggConfigModel $this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d6 = new EasterEggConfigModel((String) null, (String) null, (String) null, (String) null, 0, (String) null, 0, 0, 0, 511, (DefaultConstructorMarker) null);
                EasterEggConfigModel $this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d62 = $this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d6;
                $this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d62.setDynamicName($this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7.optString("dynamic_pic"));
                $this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d62.setImage($this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7.optString("static_pic"));
                $this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d62.setText($this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7.optString("text"));
                $this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d62.setLandText($this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7.optString("landscape_text"));
                $this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d62.setTextColor($this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7.optString("text_color"));
                $this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d62.setTextFontSize($this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7.optInt("text_font_size"));
                $this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d62.setLandTextFontSize($this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7.optInt("landscape_text_font_size"));
                try {
                    $this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d62.setDays(lowDays);
                    return $this$parseEasterEggConfig_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d6;
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion2 = Result.Companion;
                    Result.m8971constructorimpl(ResultKt.createFailure(th));
                    return null;
                }
            } else {
                int i2 = lowDays;
                Result.m8971constructorimpl((Object) null);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            int i3 = lowDays;
            Result.Companion companion22 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th));
            return null;
        }
    }

    public String getLocalVersion(Context context, String module, String action) {
        return DefaultSharedPrefsWrapper.getInstance().getString(EasterEggConfigListenerKt.KEY_EASTER_EGG_VERSION, "0");
    }
}
