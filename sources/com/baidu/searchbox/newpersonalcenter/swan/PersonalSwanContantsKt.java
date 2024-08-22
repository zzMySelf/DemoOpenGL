package com.baidu.searchbox.newpersonalcenter.swan;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u001a\u0006\u0010\u0012\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001b\u0010\r\u001a\u00020\u00018@X\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"FAVORITE_SWAN_MAX_COUNT", "", "LAUNCH_FROM_PERSONAL_FAVORITE", "", "LAUNCH_FROM_PERSONAL_TOPPING", "MAX_TEXT_LENGTH", "SCHEME_CONSTANT_CONNECT", "SCHEME_CONSTANT_START", "SWAN_ADD_TITLE", "SWAN_GAME_SCHEME_TEMPLET", "SWAN_MAX_COUNT_LINE_1", "SWAN_MAX_COUNT_LINE_2", "TOPPING_SWAN_COUNT", "swanTemplateMaxLines", "getSwanTemplateMaxLines", "()I", "swanTemplateMaxLines$delegate", "Lkotlin/Lazy;", "getCtrlSwanMaxCount", "lib-personal-center_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalSwanContants.kt */
public final class PersonalSwanContantsKt {
    public static final int FAVORITE_SWAN_MAX_COUNT = 4;
    public static final String LAUNCH_FROM_PERSONAL_FAVORITE = "1201001000000000";
    public static final String LAUNCH_FROM_PERSONAL_TOPPING = "1201004410074000";
    public static final int MAX_TEXT_LENGTH = 5;
    public static final String SCHEME_CONSTANT_CONNECT = "\"}&from=";
    public static final String SCHEME_CONSTANT_START = "baiduboxapp://v19/swan/launch?params={\"appid\":\"";
    public static final String SWAN_ADD_TITLE = "添加";
    public static final String SWAN_GAME_SCHEME_TEMPLET = "baiduboxapp://swangame/%s?_baiduboxapp={\"from\":\"%s\"}";
    public static final int SWAN_MAX_COUNT_LINE_1 = 5;
    public static final int SWAN_MAX_COUNT_LINE_2 = 10;
    public static final int TOPPING_SWAN_COUNT = 2;
    private static final Lazy swanTemplateMaxLines$delegate = LazyKt.lazy(PersonalSwanContantsKt$swanTemplateMaxLines$2.INSTANCE);

    public static final int getSwanTemplateMaxLines() {
        return ((Number) swanTemplateMaxLines$delegate.getValue()).intValue();
    }

    public static final int getCtrlSwanMaxCount() {
        if (getSwanTemplateMaxLines() == 2) {
            return 10;
        }
        return 5;
    }
}
