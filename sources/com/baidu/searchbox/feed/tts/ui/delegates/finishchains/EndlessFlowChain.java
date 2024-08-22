package com.baidu.searchbox.feed.tts.ui.delegates.finishchains;

import com.baidu.searchbox.feed.log.OnLineLog;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.feed.tts.interfaces.IFeedTTSContext;
import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;
import com.baidu.searchbox.feed.tts.ui.FeedTTSDispatcher;
import com.baidu.searchbox.feed.tts.utils.FeedTTSPreferenceUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/feed/tts/ui/delegates/finishchains/EndlessFlowChain;", "Lcom/baidu/searchbox/feed/tts/ui/delegates/finishchains/BaseChain;", "next", "Lcom/baidu/searchbox/feed/tts/ui/delegates/finishchains/ITTSModelFinishResponsibility;", "(Lcom/baidu/searchbox/feed/tts/ui/delegates/finishchains/ITTSModelFinishResponsibility;)V", "process", "", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EndlessFlowChain.kt */
public final class EndlessFlowChain extends BaseChain {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EndlessFlowChain(ITTSModelFinishResponsibility next) {
        super(next);
        Intrinsics.checkNotNullParameter(next, "next");
    }

    public int process() {
        IFeedTTSModel ttsModel = TTSEndResponsibilityController.get().getFinishData();
        IFeedTTSModel nextData = FeedTTSDispatcher.getInstance().getNextReadableFeed();
        if (nextData != null && nextData.isEndlessFlowData() && !ttsModel.isMocked() && !ttsModel.isEndlessFlowData()) {
            Intrinsics.checkNotNullExpressionValue(ttsModel, "ttsModel");
            if (!EndlessFlowChainKt.hasPlayTransition(ttsModel)) {
                String transitionText = FeedTTSPreferenceUtil.getString(TTSRuntime.KEY_ENDLESS_FLOW_TRANSITION_TEXT, "");
                CharSequence charSequence = transitionText;
                if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                    FeedTTSDispatcher.getInstance().speakSpecifiedSentence(IFeedTTSContext.Impl.get().createMock(String.valueOf(System.currentTimeMillis()), IFeedTTSModel.Action.CONTINUE_SPEAKING, transitionText));
                    EndlessFlowChainKt.setTransitionPlayed(ttsModel);
                    OnLineLog.get(OnLineLog.TAG_TTS).d("[EndlessFlowChain] process playTransitionText = " + transitionText);
                    return 1;
                }
            }
        }
        return 0;
    }
}
