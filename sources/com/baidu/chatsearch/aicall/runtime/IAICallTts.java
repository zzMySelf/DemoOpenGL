package com.baidu.chatsearch.aicall.runtime;

import com.baidu.chatsearch.aicall.comps.tts.bdtts.listener.SpeechListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0005\u001a\u00020\u0003H'J\u001c\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H'J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH'J\b\u0010\r\u001a\u00020\u0003H'J&\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012H'¨\u0006\u0014"}, d2 = {"Lcom/baidu/chatsearch/aicall/runtime/IAICallTts;", "", "destroy", "", "pause", "resume", "setConfig", "key", "", "value", "speak", "listener", "Lcom/baidu/chatsearch/aicall/comps/tts/bdtts/listener/SpeechListener;", "stop", "tryInstallTTS", "isSilence", "", "onInitEnd", "Lkotlin/Function1;", "Companion", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IAICallTts.kt */
public interface IAICallTts {
    public static final Companion Companion = Companion.$$INSTANCE;

    void destroy();

    void pause();

    void resume();

    void setConfig(String str, Object obj);

    void speak(SpeechListener speechListener);

    void stop();

    void tryInstallTTS(boolean z, Function1<? super Boolean, Unit> function1);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/chatsearch/aicall/runtime/IAICallTts$Companion;", "", "()V", "Empty", "Lcom/baidu/chatsearch/aicall/runtime/IAICallTts;", "getEmpty", "()Lcom/baidu/chatsearch/aicall/runtime/IAICallTts;", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IAICallTts.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final IAICallTts Empty = new IAICallTts$Companion$Empty$1();

        private Companion() {
        }

        public final IAICallTts getEmpty() {
            return Empty;
        }
    }
}
