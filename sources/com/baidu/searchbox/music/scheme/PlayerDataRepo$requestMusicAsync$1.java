package com.baidu.searchbox.music.scheme;

import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.music.data.AbstractMusicParser;
import com.baidu.searchbox.music.runtime.MusicRuntime;
import java.io.InputStream;
import kotlin.Metadata;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/music/scheme/PlayerDataRepo$requestMusicAsync$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "obj", "p1", "", "parseResponse", "response", "Lokhttp3/Response;", "lib-music_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerDataRepo.kt */
public final class PlayerDataRepo$requestMusicAsync$1 extends ResponseCallback<Object> {
    final /* synthetic */ AbstractMusicParser $parser;
    final /* synthetic */ AbstractMusicParser.DataParserCallback $parserCallback;

    PlayerDataRepo$requestMusicAsync$1(AbstractMusicParser.DataParserCallback $parserCallback2, AbstractMusicParser $parser2) {
        this.$parserCallback = $parserCallback2;
        this.$parser = $parser2;
    }

    public Object parseResponse(Response response, int p1) {
        InputStream inputStream = null;
        if (response == null || !response.isSuccessful()) {
            this.$parserCallback.onFail(-101);
            return null;
        }
        AbstractMusicParser.DataParserCallback dataParserCallback = this.$parserCallback;
        AbstractMusicParser abstractMusicParser = this.$parser;
        Response $this$parseResponse_u24lambda_u2d0 = response;
        ResponseBody body = $this$parseResponse_u24lambda_u2d0.body();
        if ((body != null ? body.byteStream() : null) == null) {
            dataParserCallback.onFail(-101);
            return null;
        }
        ResponseBody body2 = $this$parseResponse_u24lambda_u2d0.body();
        if (body2 != null) {
            inputStream = body2.byteStream();
        }
        abstractMusicParser.parseResponse(inputStream, dataParserCallback);
        return new Object();
    }

    public void onSuccess(Object obj, int p1) {
        MusicRuntime.getRenderStat().updateStatistic("musicfull", "requestEnd");
    }

    public void onFail(Exception e2) {
        MusicRuntime.getRenderStat().updateStatistic("musicfull", "requestEnd");
    }
}
