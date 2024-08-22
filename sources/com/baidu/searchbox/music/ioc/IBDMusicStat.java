package com.baidu.searchbox.music.ioc;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import org.json.JSONObject;

@StableApi
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/music/ioc/IBDMusicStat;", "", "endFullBack", "", "mode", "", "endFullFront", "getMusicPlayExt", "Lorg/json/JSONObject;", "startFullBack", "startFullFront", "Companion", "lib-bdmedia-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IBDMusicStat.kt */
public interface IBDMusicStat {
    public static final Companion Companion = Companion.$$INSTANCE;

    void endFullBack(int i2);

    void endFullFront(int i2);

    JSONObject getMusicPlayExt();

    void startFullBack(int i2);

    void startFullFront(int i2);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/music/ioc/IBDMusicStat$Companion;", "", "()V", "Empty", "Lcom/baidu/searchbox/music/ioc/IBDMusicStat;", "getEmpty", "()Lcom/baidu/searchbox/music/ioc/IBDMusicStat;", "lib-bdmedia-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IBDMusicStat.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final IBDMusicStat Empty = new IBDMusicStat$Companion$Empty$1();

        private Companion() {
        }

        public final IBDMusicStat getEmpty() {
            return Empty;
        }
    }
}
