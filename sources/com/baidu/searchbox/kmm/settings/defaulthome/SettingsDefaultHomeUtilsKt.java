package com.baidu.searchbox.kmm.settings.defaulthome;

import co.touchlab.stately.concurrency.AtomicReferenceKt;
import com.baidu.searchbox.kmm.foundation.io.AssetsFileUtilsKt;
import com.baidu.searchbox.kmm.foundation.kelson.JsonArray;
import com.baidu.searchbox.kmm.foundation.kelson.JsonElement;
import com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt;
import com.baidu.searchbox.kmm.home.tab.HomeFourthTabTypeUtils;
import com.baidu.searchbox.kmm.home.tab.HomeSecondTabTypeUtils;
import com.baidu.searchbox.kmm.home.youth.YouthHomeSwitchMgr;
import com.baidu.searchbox.kmm.services.abtest.ABTestKt;
import com.baidu.searchbox.kmm.updateprocessor.SettingsDefaultHomeUpdateListenerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001a$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0013\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001a\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0001\u001a\n\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"6\u0010\u0004\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006`\b8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\n\"\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u001c"}, d2 = {"DEFAULT_HOME_CONFIGS_PRESET_FILE", "", "FEED_VIDEO_CHANNEL_ID", "PERSIST_KEY_HAS_SET_VIDEO_DEFAULT", "cachedDefaultHomeConfigs", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Lcom/baidu/searchbox/kmm/settings/defaulthome/SettingsDefaultHomeModel;", "Lco/touchlab/stately/concurrency/AtomicReference;", "getCachedDefaultHomeConfigs$annotations", "()V", "defaultHomeConfigs", "getDefaultHomeConfigs", "()Ljava/util/List;", "isHitVideoBarExperiment", "", "()Z", "fetchDefaultHomeConfigs", "getProcessedDefaultHomeConfigs", "selectedChannelId", "config", "isConfigExpired", "cloudData", "isDefaultHomeSettingsShowOutside", "readPresetDefaultHomeConfigs", "setUserIsSetVideoIsDefault", "", "isVideoBar", "com.baidu.searchbox.kmm.business.settings"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingsDefaultHomeUtils.kt */
public final class SettingsDefaultHomeUtilsKt {
    private static final String DEFAULT_HOME_CONFIGS_PRESET_FILE = "settings_default_home_config_preset.json";
    private static final String FEED_VIDEO_CHANNEL_ID = "2";
    private static final String PERSIST_KEY_HAS_SET_VIDEO_DEFAULT = "settings_default_home_has_set_video";
    private static final AtomicReference<List<SettingsDefaultHomeModel>> cachedDefaultHomeConfigs = new AtomicReference<>((Object) null);
    private static final boolean isHitVideoBarExperiment;

    private static /* synthetic */ void getCachedDefaultHomeConfigs$annotations() {
    }

    static {
        boolean z = false;
        if (ABTestKt.getABTestSwitch("feed_video_flow_cold_enter_channel", 0) == 1) {
            z = true;
        }
        isHitVideoBarExperiment = z;
    }

    private static final List<SettingsDefaultHomeModel> fetchDefaultHomeConfigs() {
        String str;
        String cloudConfig = SettingsDefaultHomeUpdateListenerKt.getSettingsDefaultHomeKVInstance().getString(SettingsDefaultHomeUpdateListenerKt.SETTINGS_DEFAULT_HOME_PERSIST_KEY_DATA, "");
        CharSequence charSequence = cloudConfig;
        boolean $this$fetchDefaultHomeConfigs_u24lambda_u2d0 = true;
        if (!(charSequence == null || charSequence.length() == 0)) {
            $this$fetchDefaultHomeConfigs_u24lambda_u2d0 = isConfigExpired(cloudConfig);
            if ($this$fetchDefaultHomeConfigs_u24lambda_u2d0) {
                SettingsDefaultHomeUpdateListenerKt.getSettingsDefaultHomeKVInstance().set(SettingsDefaultHomeUpdateListenerKt.SETTINGS_DEFAULT_HOME_PERSIST_KEY_DATA, "");
                SettingsDefaultHomeUpdateListenerKt.getSettingsDefaultHomeKVInstance().set(SettingsDefaultHomeUpdateListenerKt.SETTINGS_DEFAULT_HOME_PERSIST_KEY_VERSION, "-1");
            }
        }
        if ($this$fetchDefaultHomeConfigs_u24lambda_u2d0) {
            str = readPresetDefaultHomeConfigs();
        } else {
            str = cloudConfig;
        }
        JsonArray<JsonElement> list = str != null ? JsonUtilKt.toJsonArray(str) : null;
        List result = new ArrayList();
        if (list != null) {
            for (JsonElement it : list) {
                SettingsDefaultHomeModel i2 = new SettingsDefaultHomeModel();
                i2.decode(it);
                if ((Intrinsics.areEqual((Object) HomeSecondTabTypeUtils.INSTANCE.getNewHomeSecondTabCurrentType(), (Object) "1002") || Intrinsics.areEqual((Object) HomeFourthTabTypeUtils.INSTANCE.getNewHomeFourthTabCurrentType(), (Object) "1002") || !Intrinsics.areEqual((Object) i2.getDefaultBottomBar(), (Object) "video")) && (!YouthHomeSwitchMgr.INSTANCE.shouldBlockYouthOptionSettings() || !i2.isYouthType())) {
                    result.add(i2);
                }
            }
        }
        return result;
    }

    private static final boolean isConfigExpired(String cloudData) {
        Iterable $this$all$iv;
        Iterable $this$any$iv;
        JsonElement it;
        JsonElement it2;
        JsonArray jsonArray = JsonUtilKt.toJsonArray(cloudData);
        if (jsonArray == null || jsonArray.getSize() == 0) {
            return true;
        }
        Iterable $this$all$iv2 = jsonArray;
        if (!($this$all$iv2 instanceof Collection) || !((Collection) $this$all$iv2).isEmpty()) {
            Iterator it3 = $this$all$iv2.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    $this$all$iv = 1;
                    break;
                }
                if (JsonUtilKt.getJsonObject((JsonElement) it3.next(), "brief_image") == null) {
                    it2 = 1;
                    continue;
                } else {
                    it2 = null;
                    continue;
                }
                if (it2 == null) {
                    $this$all$iv = null;
                    break;
                }
            }
        } else {
            $this$all$iv = 1;
        }
        if ($this$all$iv != null) {
            return true;
        }
        if (YouthHomeSwitchMgr.INSTANCE.isSupportYouthHome() && YouthHomeSwitchMgr.INSTANCE.getBottomBarStyle() == 2) {
            Iterable $this$any$iv2 = jsonArray;
            if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                Iterator it4 = $this$any$iv2.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        $this$any$iv = null;
                        break;
                    }
                    if (JsonUtilKt.getInt$default((JsonElement) it4.next(), "type", 0, 2, (Object) null) == 2) {
                        it = 1;
                        continue;
                    } else {
                        it = null;
                        continue;
                    }
                    if (it != null) {
                        $this$any$iv = 1;
                        break;
                    }
                }
            } else {
                $this$any$iv = null;
            }
            if ($this$any$iv == null) {
                return true;
            }
        }
        return false;
    }

    private static final String readPresetDefaultHomeConfigs() {
        return AssetsFileUtilsKt.readAssetContent(DEFAULT_HOME_CONFIGS_PRESET_FILE);
    }

    public static final boolean isHitVideoBarExperiment() {
        return isHitVideoBarExperiment;
    }

    public static final boolean isDefaultHomeSettingsShowOutside(String selectedChannelId) {
        Intrinsics.checkNotNullParameter(selectedChannelId, "selectedChannelId");
        List processedConfigs = getProcessedDefaultHomeConfigs(selectedChannelId, fetchDefaultHomeConfigs());
        AtomicReferenceKt.setValue(cachedDefaultHomeConfigs, processedConfigs);
        if (processedConfigs.isEmpty()) {
            return false;
        }
        if (Intrinsics.areEqual((Object) SettingsDefaultHomeUpdateListenerKt.getSettingsDefaultHomeKVInstance().getBoolean(PERSIST_KEY_HAS_SET_VIDEO_DEFAULT, false), (Object) true) || !Intrinsics.areEqual((Object) selectedChannelId, (Object) "2")) {
            return true;
        }
        return false;
    }

    public static final List<SettingsDefaultHomeModel> getDefaultHomeConfigs() {
        return (List) AtomicReferenceKt.getValue(cachedDefaultHomeConfigs);
    }

    public static final void setUserIsSetVideoIsDefault(boolean isVideoBar) {
        SettingsDefaultHomeUpdateListenerKt.getSettingsDefaultHomeKVInstance().set(PERSIST_KEY_HAS_SET_VIDEO_DEFAULT, Boolean.valueOf(isVideoBar));
    }

    private static final List<SettingsDefaultHomeModel> getProcessedDefaultHomeConfigs(String selectedChannelId, List<SettingsDefaultHomeModel> config) {
        Function1 excludeFilter = new SettingsDefaultHomeUtilsKt$getProcessedDefaultHomeConfigs$excludeFilter$1(Intrinsics.areEqual((Object) SettingsDefaultHomeUpdateListenerKt.getSettingsDefaultHomeKVInstance().getBoolean(PERSIST_KEY_HAS_SET_VIDEO_DEFAULT, false), (Object) true), selectedChannelId);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : config) {
            if (!((Boolean) excludeFilter.invoke((SettingsDefaultHomeModel) element$iv$iv)).booleanValue()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }
}
