package com.baidu.searchbox.kmm.personalcenter.entities.constants;

import com.baidu.searchbox.config.IncognitoUpdateListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/kmm/personalcenter/entities/constants/ThemesConstants;", "", "themeStr", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getThemeStr$com_baidu_searchbox_kmm_business_personalcenter", "()Ljava/lang/String;", "LIGHT_MODE", "NIGHT_MODE", "INCOGNITO_MODE", "NORMAL_MODE", "com.baidu.searchbox.kmm.business.personalcenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThemesConstants.kt */
public enum ThemesConstants {
    LIGHT_MODE("light"),
    NIGHT_MODE("dark"),
    INCOGNITO_MODE(IncognitoUpdateListener.INCOGNITO_ACTION),
    NORMAL_MODE("normal");
    
    private final String themeStr;

    private ThemesConstants(String themeStr2) {
        this.themeStr = themeStr2;
    }

    public final String getThemeStr$com_baidu_searchbox_kmm_business_personalcenter() {
        return this.themeStr;
    }
}
