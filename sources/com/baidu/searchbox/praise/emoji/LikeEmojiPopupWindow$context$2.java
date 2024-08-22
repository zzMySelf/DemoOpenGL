package com.baidu.searchbox.praise.emoji;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LikeEmojiPopupWindow.kt */
final class LikeEmojiPopupWindow$context$2 extends Lambda implements Function0<Context> {
    public static final LikeEmojiPopupWindow$context$2 INSTANCE = new LikeEmojiPopupWindow$context$2();

    LikeEmojiPopupWindow$context$2() {
        super(0);
    }

    public final Context invoke() {
        return AppRuntime.getAppContext();
    }
}
