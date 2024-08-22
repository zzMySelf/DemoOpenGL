package com.baidu.searchbox.aisearch.comps.conversation.preload;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import com.baidu.searchbox.aisearch.comps.conversation.ConversationWebComponent;
import com.baidu.searchbox.aisearch.comps.conversation.SimpleConversationStateCallback;
import com.baidu.searchbox.aisearch.comps.conversation.event.StreamReady;
import com.baidu.searchbox.aisearch.yalog.AISearchYalog;
import com.baidu.searchbox.nacomp.extension.lifecycle.LifecycleKt;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\b"}, d2 = {"com/baidu/searchbox/aisearch/comps/conversation/preload/ConversationWebCompPreloadHost$stateCallback$1", "Lcom/baidu/searchbox/aisearch/comps/conversation/SimpleConversationStateCallback;", "onStreamReady", "", "data", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/StreamReady;", "onStreamReady-s_rIclU", "(Lorg/json/JSONObject;)V", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationWebCompPreloadHost.kt */
public final class ConversationWebCompPreloadHost$stateCallback$1 extends SimpleConversationStateCallback {
    final /* synthetic */ ConversationWebCompPreloadHost this$0;

    ConversationWebCompPreloadHost$stateCallback$1(ConversationWebCompPreloadHost $receiver) {
        this.this$0 = $receiver;
    }

    /* renamed from: onStreamReady-s_rIclU  reason: not valid java name */
    public void m15640onStreamReadys_rIclU(JSONObject data) {
        super.m15271onStreamReadys_rIclU(data);
        this.this$0.streamReady = StreamReady.m15584boximpl(data);
        if (ConversationWebCompPreloadHostKt.DEBUG) {
            Log.i("ConversationPreload", "PreloadHost recv onStreamReady, data=" + StreamReady.m15591toStringimpl(data) + ", now pause WebComp");
        }
        AISearchYalog.INSTANCE.i("ConversationPreload", "PreloadHost recv onStreamReady, data=" + StreamReady.m15591toStringimpl(data) + ", now pause WebComp");
        ConversationWebComponent $this$onStreamReady_s_rIclU_u24lambda_u2d0 = this.this$0.webComp;
        if ($this$onStreamReady_s_rIclU_u24lambda_u2d0 != null) {
            LifecycleKt.setMinLifecycle($this$onStreamReady_s_rIclU_u24lambda_u2d0, Lifecycle.State.CREATED);
            LifecycleKt.setMaxLifecycle($this$onStreamReady_s_rIclU_u24lambda_u2d0, Lifecycle.State.CREATED);
        }
    }
}
