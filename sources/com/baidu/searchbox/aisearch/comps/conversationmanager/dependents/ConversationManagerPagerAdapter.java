package com.baidu.searchbox.aisearch.comps.conversationmanager.dependents;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.aisearch.comps.conversationmanager.ConversationManagerTab;
import com.baidu.searchbox.nacomp.extension.widget.LifecyclePagerAdapter;
import com.baidu.searchbox.nacomp.mvvm.IComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversationmanager/dependents/ConversationManagerPagerAdapter;", "Lcom/baidu/searchbox/nacomp/extension/widget/LifecyclePagerAdapter;", "conversationRecyclerComp", "Lcom/baidu/searchbox/aisearch/comps/conversationmanager/dependents/ConversationRecyclerComp;", "aiBotRecyclerComp", "Lcom/baidu/searchbox/aisearch/comps/conversationmanager/dependents/AIBotRecyclerComp;", "(Lcom/baidu/searchbox/aisearch/comps/conversationmanager/dependents/ConversationRecyclerComp;Lcom/baidu/searchbox/aisearch/comps/conversationmanager/dependents/AIBotRecyclerComp;)V", "tabs", "", "Lcom/baidu/searchbox/aisearch/comps/conversationmanager/ConversationManagerTab;", "getCount", "", "getPageTitle", "", "position", "instantiateItem", "", "container", "Landroid/view/ViewGroup;", "isViewFromObject", "", "view", "Landroid/view/View;", "obj", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationManagerPagerAdapter.kt */
public class ConversationManagerPagerAdapter extends LifecyclePagerAdapter {
    private final AIBotRecyclerComp aiBotRecyclerComp;
    private final ConversationRecyclerComp conversationRecyclerComp;
    private final List<ConversationManagerTab> tabs = CollectionsKt.listOf(ConversationManagerTab.CONVERSATION_LIST, ConversationManagerTab.AI_BOT);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationManagerPagerAdapter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ConversationManagerTab.values().length];
            iArr[ConversationManagerTab.CONVERSATION_LIST.ordinal()] = 1;
            iArr[ConversationManagerTab.AI_BOT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ConversationManagerPagerAdapter(ConversationRecyclerComp conversationRecyclerComp2, AIBotRecyclerComp aiBotRecyclerComp2) {
        Intrinsics.checkNotNullParameter(conversationRecyclerComp2, "conversationRecyclerComp");
        Intrinsics.checkNotNullParameter(aiBotRecyclerComp2, "aiBotRecyclerComp");
        this.conversationRecyclerComp = conversationRecyclerComp2;
        this.aiBotRecyclerComp = aiBotRecyclerComp2;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        ConversationManagerTab conversationManagerTab = (ConversationManagerTab) CollectionsKt.getOrNull(this.tabs, position);
        switch (conversationManagerTab == null ? -1 : WhenMappings.$EnumSwitchMapping$0[conversationManagerTab.ordinal()]) {
            case 1:
                container.addView(this.conversationRecyclerComp.getView());
                return this.conversationRecyclerComp;
            case 2:
                container.addView(this.aiBotRecyclerComp.getView());
                return this.aiBotRecyclerComp;
            default:
                return new Object();
        }
    }

    public int getCount() {
        return this.tabs.size();
    }

    public boolean isViewFromObject(View view2, Object obj) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(obj, "obj");
        View view3 = null;
        IComponent iComponent = obj instanceof IComponent ? (IComponent) obj : null;
        if (iComponent != null) {
            view3 = iComponent.getView();
        }
        return Intrinsics.areEqual((Object) view3, (Object) view2);
    }

    public CharSequence getPageTitle(int position) {
        ConversationManagerTab conversationManagerTab = (ConversationManagerTab) CollectionsKt.getOrNull(this.tabs, position);
        return conversationManagerTab != null ? conversationManagerTab.getTabName() : null;
    }
}
