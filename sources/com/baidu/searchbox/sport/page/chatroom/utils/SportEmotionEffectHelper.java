package com.baidu.searchbox.sport.page.chatroom.utils;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.boxshare.bean.ShareContent;
import com.baidu.searchbox.sport.debug.SportDebugConfigKt;
import com.baidu.spswitch.emotion.bean.EmotionEffectConfig;
import com.baidu.spswitch.emotion.bean.SurpriseLoopConfig;
import com.baidu.spswitch.emotion.view.EmotionEffectView;
import com.baidu.spswitch.utils.EmotionEffectUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/sport/page/chatroom/utils/SportEmotionEffectHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "play", "", "text", "", "release", "", "Companion", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SportEmotionEffectHelper.kt */
public final class SportEmotionEffectHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Map<String, String> EMOTION_MAP;
    private final Context context;

    public SportEmotionEffectHelper(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/sport/page/chatroom/utils/SportEmotionEffectHelper$Companion;", "", "()V", "EMOTION_MAP", "", "", "getEMOTION_MAP", "()Ljava/util/Map;", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SportEmotionEffectHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, String> getEMOTION_MAP() {
            return SportEmotionEffectHelper.EMOTION_MAP;
        }
    }

    static {
        Map<String, String> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("[奥运加油]", "aoyunjiayou"), TuplesKt.to("[圆梦巴黎]", "yuanmengbali"), TuplesKt.to("[勇夺金牌]", "yongduojinpai"), TuplesKt.to("[中国队加油]", "zhongguoduijiayou"));
        EMOTION_MAP = mutableMapOf;
        if (SportDebugConfigKt.getDEBUG()) {
            mutableMapOf.put("[武功]", "jinyongpinglun");
        }
    }

    public final boolean play(String text) {
        String str = text;
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        Map<String, String> map = EMOTION_MAP;
        if (!map.containsKey(str)) {
            return false;
        }
        EmotionEffectConfig emotionEffectConfig = new EmotionEffectConfig((String) null, (String) null, (String) null, 0, 0, (SurpriseLoopConfig) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (ShareContent) null, (String) null, 65535, (DefaultConstructorMarker) null);
        emotionEffectConfig.emoName = map.get(str);
        Context context2 = this.context;
        Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
        if (activity == null) {
            return false;
        }
        EmotionEffectUtils.releaseRetriever();
        return EmotionEffectUtils.play(activity, emotionEffectConfig, (EmotionEffectView.OnEmotionEffectListener) null);
    }

    public final void release() {
        EmotionEffectUtils.releaseRetriever();
    }
}
