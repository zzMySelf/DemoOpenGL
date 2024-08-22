package com.baidu.chatsearch.aisearch.resultpage.bottom.agent;

import com.baidu.chatsearch.aisearch.resultpage.tabcontainer.SSAiSearchTabContainer;
import com.baidu.chatsearch.logger.AppLogger;
import com.baidu.chatsearch.model.sug.model.SSAgentSugModel;
import com.baidu.chatsearch.model.ubc.AgentStatus;
import com.baidu.chatsearch.utils.CoroutinesUtilKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "inputText", "", "Throwable", "", "agentSugModel", "Lcom/baidu/chatsearch/model/sug/model/SSAgentSugModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SSAiAgentView.kt */
final class SSAiAgentView$setAgentQuery$1 extends Lambda implements Function3<String, Throwable, SSAgentSugModel, Unit> {
    final /* synthetic */ String $inputQuery;
    final /* synthetic */ String $originQuery;
    final /* synthetic */ Function0<Unit> $showCallBack;
    final /* synthetic */ SSAiAgentView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SSAiAgentView$setAgentQuery$1(String str, SSAiAgentView sSAiAgentView, String str2, Function0<Unit> function0) {
        super(3);
        this.$inputQuery = str;
        this.this$0 = sSAiAgentView;
        this.$originQuery = str2;
        this.$showCallBack = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((String) p1, (Throwable) p2, (SSAgentSugModel) p3);
        return Unit.INSTANCE;
    }

    public final void invoke(String inputText, Throwable Throwable, final SSAgentSugModel agentSugModel) {
        Intrinsics.checkNotNullParameter(inputText, "inputText");
        StringBuilder append = new StringBuilder().append("syncAgentSugList: inputText").append(inputText).append(",inputQuery:").append(this.$inputQuery).append(" , curEditText:");
        Function0<String> curEditText = this.this$0.getCurEditText();
        String str = null;
        StringBuilder append2 = append.append(curEditText != null ? curEditText.invoke() : null).append(", originQuery:").append(this.$originQuery);
        if (Throwable != null) {
            str = Throwable.getMessage();
        }
        AppLogger.i(SSAiSearchTabContainer.TAG, append2.append(str).append(", ").append(agentSugModel).toString());
        final SSAiAgentView sSAiAgentView = this.this$0;
        final String str2 = this.$originQuery;
        final Function0<Unit> function0 = this.$showCallBack;
        CoroutinesUtilKt.doInUi(new Function0<Unit>() {
            public final void invoke() {
                String invoke;
                SSAgentSugModel sSAgentSugModel = agentSugModel;
                List<SSAgentSugModel.AgentSug> agentSugList = sSAgentSugModel != null ? sSAgentSugModel.getAgentSugList() : null;
                Function0<String> curEditText = sSAiAgentView.getCurEditText();
                if ((curEditText == null || (invoke = curEditText.invoke()) == null || !invoke.equals(str2)) ? false : true) {
                    Collection collection = agentSugList;
                    if (!(collection == null || collection.isEmpty())) {
                        sSAiAgentView.agentAdapterModels.clear();
                        if (agentSugList.size() > 4) {
                            sSAiAgentView.agentAdapterModels.addAll(CollectionsKt.take(agentSugList, 4));
                        } else {
                            sSAiAgentView.agentAdapterModels.addAll(agentSugList);
                        }
                        CollectionsKt.reverse(sSAiAgentView.agentAdapterModels);
                        SSAiAgentView sSAiAgentView = sSAiAgentView;
                        int index = 0;
                        for (Object item$iv : sSAiAgentView.agentAdapterModels) {
                            int index$iv = index + 1;
                            if (index < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            SSAgentSugModel.AgentSug ssSugModel = (SSAgentSugModel.AgentSug) item$iv;
                            Function1<AgentStatus, Unit> onGetAgentStatus = sSAiAgentView.getOnGetAgentStatus();
                            if (onGetAgentStatus != null) {
                                String id = ssSugModel.getId();
                                String str = "";
                                if (id == null) {
                                    id = str;
                                }
                                String sourceName = ssSugModel.getSourceName();
                                if (sourceName != null) {
                                    str = sourceName;
                                }
                                onGetAgentStatus.invoke(new AgentStatus(id, str, index + 1));
                            }
                            index = index$iv;
                        }
                        SSAiResultAgentAdapter access$getAgentAdapter$p = sSAiAgentView.agentAdapter;
                        if (access$getAgentAdapter$p != null) {
                            access$getAgentAdapter$p.changeDataList(sSAiAgentView.agentAdapterModels);
                        }
                        sSAiAgentView.needVisible = true;
                        function0.invoke();
                        return;
                    }
                }
                sSAiAgentView.needVisible = false;
                sSAiAgentView.setVisibility(8);
            }
        });
    }
}
