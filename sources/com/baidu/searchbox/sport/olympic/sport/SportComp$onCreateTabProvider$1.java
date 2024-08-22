package com.baidu.searchbox.sport.olympic.sport;

import android.os.Bundle;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.model.TabInfo;
import com.baidu.searchbox.sport.olympic.sport.model.SportSchemeModel;
import com.baidu.searchbox.sport.page.base.BaseSportTabFragment;
import com.baidu.searchbox.sport.page.base.DefaultTabProvider;
import com.baidu.searchbox.sport.page.olympic.schedule.OlympicScheduleFragment;
import com.baidu.searchbox.sport.page.olympic.schedule.comp.OlympicScheduleConfig;
import com.baidu.searchbox.sport.page.olympic.schedule.model.repo.OlympicScheduleParams;
import com.baidu.searchbox.sport.statistic.SportStats;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/sport/olympic/sport/SportComp$onCreateTabProvider$1", "Lcom/baidu/searchbox/sport/page/base/DefaultTabProvider;", "onCreateTabFragment", "Lcom/baidu/searchbox/sport/page/base/BaseSportTabFragment;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "tab", "Lcom/baidu/searchbox/sport/model/TabInfo;", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SportComp.kt */
public final class SportComp$onCreateTabProvider$1 extends DefaultTabProvider {
    final /* synthetic */ SportComp this$0;

    SportComp$onCreateTabProvider$1(SportComp $receiver) {
        this.this$0 = $receiver;
    }

    public BaseSportTabFragment onCreateTabFragment(UniqueId token, TabInfo tab) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(tab, "tab");
        if (Intrinsics.areEqual((Object) tab.getId(), (Object) TabInfo.ID_OLYMPIC_SPORT_SCHEDULE)) {
            OlympicScheduleFragment olympicScheduleFragment = new OlympicScheduleFragment();
            SportComp sportComp = this.this$0;
            OlympicScheduleFragment $this$onCreateTabFragment_u24lambda_u2d2 = olympicScheduleFragment;
            sportComp.olympicScheduleFragment = $this$onCreateTabFragment_u24lambda_u2d2;
            Bundle bundle = new Bundle();
            Bundle $this$onCreateTabFragment_u24lambda_u2d2_u24lambda_u2d1 = bundle;
            $this$onCreateTabFragment_u24lambda_u2d2_u24lambda_u2d1.putParcelable(BaseSportTabFragment.EXTRA_TOKEN, token);
            $this$onCreateTabFragment_u24lambda_u2d2_u24lambda_u2d1.putParcelable(BaseSportTabFragment.EXTRA_TAB_INFO, tab);
            String disciplineId = ((SportSchemeModel) sportComp.getSchemeModel()).getDisciplineId();
            CharSequence charSequence = disciplineId;
            if (!(charSequence == null || charSequence.length() == 0)) {
                OlympicScheduleParams $this$onCreateTabFragment_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0 = OlympicScheduleParams.Companion.ofDiscipline(disciplineId, ((SportSchemeModel) sportComp.getSchemeModel()).getDate(), ((SportSchemeModel) sportComp.getSchemeModel()).getAnchorScheduleFilters(), ((SportSchemeModel) sportComp.getSchemeModel()).getMatch());
                Map<String, String> scheduleRequestParams = ((SportSchemeModel) sportComp.getSchemeModel()).getScheduleRequestParams();
                Intrinsics.checkNotNullExpressionValue(scheduleRequestParams, "schemeModel.scheduleRequestParams");
                $this$onCreateTabFragment_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.setScheduleRequestParams(scheduleRequestParams);
                Unit unit = Unit.INSTANCE;
                String sid = ((SportSchemeModel) sportComp.getSchemeModel()).getSid();
                String id = tab.getId();
                Intrinsics.checkNotNullExpressionValue(id, "tab.id");
                $this$onCreateTabFragment_u24lambda_u2d2_u24lambda_u2d1.putParcelable(OlympicScheduleConfig.KEY, new OlympicScheduleConfig($this$onCreateTabFragment_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0, sid, SportStats.SPORT_STAT_OLYMPIC_DISCIPLINE_PAGE, id));
            }
            $this$onCreateTabFragment_u24lambda_u2d2.setArguments(bundle);
            return olympicScheduleFragment;
        }
        BaseSportTabFragment onCreateTabFragment = super.onCreateTabFragment(token, tab);
        Intrinsics.checkNotNullExpressionValue(onCreateTabFragment, "{\n                super.…token, tab)\n            }");
        return onCreateTabFragment;
    }
}
