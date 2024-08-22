package com.baidu.searchbox.aisearch.comps.page;

import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.aisearch.comps.common.IOnSelectChangeListenerKt;
import com.baidu.searchbox.aisearch.statistic.AISearchStats;
import com.baidu.searchbox.nacomp.mvvm.IComponent;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/baidu/searchbox/aisearch/comps/page/AISearchPageComp$viewPager$1$2", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageScrollStateChanged", "", "scrollState", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AISearchPageComp.kt */
public final class AISearchPageComp$viewPager$1$2 extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ AISearchPageComp this$0;

    AISearchPageComp$viewPager$1$2(AISearchPageComp $receiver) {
        this.this$0 = $receiver;
    }

    public void onPageSelected(int position) {
        boolean newSelState;
        Map $this$forEach$iv = this.this$0.tabComps;
        AISearchPageComp aISearchPageComp = this.this$0;
        Iterator it = $this$forEach$iv.entrySet().iterator();
        while (true) {
            newSelState = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry it2 = (Map.Entry) it.next();
            boolean oldSelState = aISearchPageComp.lastSelPos == ((Number) it2.getKey()).intValue();
            if (position != ((Number) it2.getKey()).intValue()) {
                newSelState = false;
            }
            if (oldSelState != newSelState) {
                IOnSelectChangeListenerKt.dispatchSelectChange((IComponent) it2.getValue(), oldSelState, newSelState);
            }
        }
        AISearchTab $this$onPageSelected_u24lambda_u2d1 = this.this$0.pagerAdapter.findDataForPosition(position);
        if ($this$onPageSelected_u24lambda_u2d1 != null) {
            AISearchPageComp aISearchPageComp2 = this.this$0;
            AISearchPageComp.Companion.setCurrentTab($this$onPageSelected_u24lambda_u2d1);
            if ($this$onPageSelected_u24lambda_u2d1 == AISearchTab.INSPIRATION) {
                aISearchPageComp2.getTopBarComp$lib_aisearch_impl_release().dismissBotsTabGuide();
            }
        }
        if (this.this$0.lastSelPos == -1) {
            newSelState = false;
        }
        boolean isManualChange = newSelState;
        this.this$0.lastSelPos = position;
        this.this$0.getAiSearchStats().endDuration();
        this.this$0.updateStatsExtTab(AISearchPageComp.Companion.getCurrentTab().getTabId());
        this.this$0.getAiSearchStats().beginDuration();
        if (isManualChange) {
            AISearchStats.onModuleClick$default(this.this$0.getAiSearchStats(), "home", "tab_change", (Map) null, 4, (Object) null);
        }
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        for (Map.Entry it : this.this$0.tabComps.entrySet()) {
            boolean visibleState = true;
            if (((Number) it.getKey()).intValue() != position && (((Number) it.getKey()).intValue() != position + 1 || positionOffset <= 0.0f)) {
                visibleState = false;
            }
            IOnSelectChangeListenerKt.dispatchScrollVisibleChange((IComponent) it.getValue(), visibleState);
        }
    }

    public void onPageScrollStateChanged(int scrollState) {
        Map $this$forEach$iv = this.this$0.tabComps;
        AISearchPageComp aISearchPageComp = this.this$0;
        for (Map.Entry it : $this$forEach$iv.entrySet()) {
            IOnSelectChangeListenerKt.dispatchScrollStateChange((IComponent) it.getValue(), aISearchPageComp.lastSelPos == ((Number) it.getKey()).intValue(), scrollState);
        }
    }
}
