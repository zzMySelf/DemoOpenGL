package com.baidu.searchbox.introduction.ioc;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.homepage.extend.IHomeIntroductionView;
import com.baidu.searchbox.introduction.data.CommonTplData;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/introduction/ioc/HomeIntroductionRuntime$EMPTY$1", "Lcom/baidu/searchbox/introduction/ioc/IHomeIntroduction;", "setSupportedIntroductionType", "", "map", "Ljava/util/LinkedHashMap;", "", "Lcom/baidu/searchbox/homepage/extend/IHomeIntroductionView;", "lib-home-introduction_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeIntroductionRuntime.kt */
public final class HomeIntroductionRuntime$EMPTY$1 implements IHomeIntroduction {
    HomeIntroductionRuntime$EMPTY$1() {
    }

    public void setSupportedIntroductionType(LinkedHashMap<Integer, IHomeIntroductionView> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        if (AppConfig.isDebug()) {
            Log.d(CommonTplData.TAG, "No Impl To Home Introduction");
        }
    }
}
