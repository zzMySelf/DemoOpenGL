package com.baidu.searchbox.kmm.home.tab;

import com.baidu.searchbox.kmm.foundation.utils.KmmLog;
import com.baidu.searchbox.kmm.foundation.utils.PlatformUtils;
import com.baidu.searchbox.kmm.home.abtest.HomeSwitchMgrKt;
import com.baidu.searchbox.kmm.home.pad.PadHomeSwitchMgr;
import com.baidu.searchbox.kmm.home.youth.YouthHomeSwitchMgr;
import com.baidu.searchbox.kmm.updateprocessor.HomeDynamicBottomBarUpdateListener;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0006\u0010\f\u001a\u00020\u0004J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u001c\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u0003\u0018\u00010\u0013H\u0007R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/kmm/home/tab/HomeFourthTabTypeUtils;", "", "()V", "currentTabTag", "", "getCurrentTabTag", "()Ljava/lang/String;", "fourthTabCurrentType", "getFourthTabCurrentType$com_baidu_searchbox_kmm_business_home", "setFourthTabCurrentType$com_baidu_searchbox_kmm_business_home", "(Ljava/lang/String;)V", "getDefaultFourthTabType", "getNewHomeFourthTabCurrentType", "initCachedFourthTabType", "isFourthTabTypeMessage", "", "parseExperimentConfigFromUpdate", "", "config", "", "com.baidu.searchbox.kmm.business.home"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeFourthTabTypeUtils.kt */
public final class HomeFourthTabTypeUtils {
    public static final HomeFourthTabTypeUtils INSTANCE;
    private static String fourthTabCurrentType;

    private HomeFourthTabTypeUtils() {
    }

    public final String getFourthTabCurrentType$com_baidu_searchbox_kmm_business_home() {
        return fourthTabCurrentType;
    }

    public final void setFourthTabCurrentType$com_baidu_searchbox_kmm_business_home(String str) {
        fourthTabCurrentType = str;
    }

    public final String getCurrentTabTag() {
        if (!YouthHomeSwitchMgr.INSTANCE.isYouthHome()) {
            String str = fourthTabCurrentType;
            return str == null ? getDefaultFourthTabType() : str;
        } else if (YouthHomeSwitchMgr.INSTANCE.getBottomBarStyle() == 2) {
            return "1014";
        } else {
            return "";
        }
    }

    public final String getNewHomeFourthTabCurrentType() {
        String str = fourthTabCurrentType;
        return str == null ? "1013" : str;
    }

    public final boolean isFourthTabTypeMessage() {
        if (YouthHomeSwitchMgr.INSTANCE.isYouthHome()) {
            return false;
        }
        return Intrinsics.areEqual((Object) fourthTabCurrentType, (Object) "1013");
    }

    @Deprecated(message = "使用新节点，并在 KMM 中处理 Update，此方法废弃")
    public final void parseExperimentConfigFromUpdate(Map<String, ?> config) {
    }

    private final String initCachedFourthTabType() {
        if (!PadHomeSwitchMgr.INSTANCE.getSideBarStyleSwitchOn()) {
            String tag = HomeDynamicBottomBarUpdateListener.Companion.getCachedFourthTab();
            if (tag.length() == 0) {
                tag = getDefaultFourthTabType();
            }
            if (!ArraysKt.contains((T[]) HomeDynamicBottomBarUpdateListener.Companion.getAvailableFourthTags(), tag) || !HomeFourthTabTypeUtilsKt.checkTagAvailable(tag)) {
                return getDefaultFourthTabType();
            }
            return tag;
        } else if (!PlatformUtils.isDebug()) {
            return "1014";
        } else {
            KmmLog.printLog("KMM-BottomBar", "Pad 版");
            return "1014";
        }
    }

    private final String getDefaultFourthTabType() {
        if (HomeSwitchMgrKt.isBriefHomeSwitch()) {
            return "1012";
        }
        return "1013";
    }

    static {
        String secondTabTag;
        HomeFourthTabTypeUtils homeFourthTabTypeUtils = new HomeFourthTabTypeUtils();
        INSTANCE = homeFourthTabTypeUtils;
        HomeDynamicBottomBarMgr homeDynamicBottomBarMgr = HomeDynamicBottomBarMgr.INSTANCE;
        String initCachedFourthTabType = homeFourthTabTypeUtils.initCachedFourthTabType();
        fourthTabCurrentType = initCachedFourthTabType;
        if (Intrinsics.areEqual((Object) initCachedFourthTabType, (Object) "1002")) {
            if (YouthHomeSwitchMgr.INSTANCE.isYouthHome()) {
                secondTabTag = HomeSecondTabTypeUtils.INSTANCE.getNewHomeSecondTabCurrentType();
            } else {
                secondTabTag = HomeSecondTabTypeUtils.INSTANCE.getCurrentTabTag();
            }
            if (Intrinsics.areEqual((Object) secondTabTag, (Object) fourthTabCurrentType)) {
                fourthTabCurrentType = homeFourthTabTypeUtils.getDefaultFourthTabType();
            }
        }
        if (PlatformUtils.isDebug()) {
            KmmLog.printLog("KMM-BottomBar", "初始化第四 Bar 为：" + fourthTabCurrentType);
        }
    }
}
