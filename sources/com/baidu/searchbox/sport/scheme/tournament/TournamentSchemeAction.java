package com.baidu.searchbox.sport.scheme.tournament;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.searchbox.nacomp.extension.util.JSONUtil;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.ioc.ISportRenderStat;
import com.baidu.searchbox.sport.model.TabInfo;
import com.baidu.searchbox.sport.page.base.BaseSportActivity;
import com.baidu.searchbox.sport.page.schedule.model.ScheduleListModel;
import com.baidu.searchbox.sport.page.schedule.repo.ScheduleRepo;
import com.baidu.searchbox.sport.page.tournament.TournamentActivity;
import com.baidu.searchbox.sport.page.tournament.model.TournamentPageModel;
import com.baidu.searchbox.sport.page.tournament.model.TournamentSchemeModel;
import com.baidu.searchbox.sport.page.tournament.repo.TournamentRepo;
import com.baidu.searchbox.sport.scheme.BaseSportSchemeAction;
import com.baidu.searchbox.sport.scheme.SportSchemeRouterKt;
import com.baidu.searchbox.sport.scheme.UnitedSchemeSportDispatcher;
import com.baidu.searchbox.sport.statistic.SportStats;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.util.Map;
import org.json.JSONObject;
import rx.SingleSubscriber;

public class TournamentSchemeAction extends BaseSportSchemeAction<TournamentSchemeModel> {
    public TournamentSchemeAction(UnitedSchemeSportDispatcher dispatcher) {
        super(dispatcher);
    }

    /* access modifiers changed from: protected */
    public void startSportPage(Context context, TournamentSchemeModel model, UnitedSchemeEntity entity, CallbackHandler handler) {
        String name = model.getName();
        UniqueId token = model.getToken();
        if (!TextUtils.isEmpty(name) && token != null) {
            TabInfo tabInfo = model.getTabInfo();
            preloadTournament(name, tabInfo == null ? "" : tabInfo.getTitle(), model.getRequestParams());
            if (tabInfo != null && "50".equals(tabInfo.getId())) {
                preloadTabSchedule(name, model.getDate(), token);
            }
        }
        Intent intent = new Intent(context, TournamentActivity.class);
        intent.putExtra(BaseSportActivity.EXTRA_SCHEME_MODEL, model);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        invokeCallback(entity, handler, 0);
    }

    private void preloadTournament(String matchName, String tabName, Map<String, String> requestParams) {
        ISportRenderStat.Companion.getImpl().updateStatistic(getPage(), SportStats.HEAD_REQUEST_START);
        TournamentRepo.preCreate(matchName).preloadTournamentPageModel(tabName, requestParams, new SingleSubscriber<TournamentPageModel>() {
            public void onSuccess(TournamentPageModel model) {
                ISportRenderStat.Companion.getImpl().updateStatistic(TournamentSchemeAction.this.getPage(), SportStats.HEAD_REQUEST_END);
            }

            public void onError(Throwable throwable) {
                ISportRenderStat.Companion.getImpl().updateStatistic(TournamentSchemeAction.this.getPage(), SportStats.HEAD_REQUEST_END);
            }
        });
    }

    private void preloadTabSchedule(String matchName, String date, final UniqueId token) {
        SportStats.of(token).setNaTabPrefetchStartTime(ISportRenderStat.Companion.getImpl().getTime());
        ScheduleRepo.preCreate(matchName, (String) null, false).preloadSchedules(date, new SingleSubscriber<ScheduleListModel>() {
            public void onSuccess(ScheduleListModel model) {
                SportStats.of(token).setNaTabPrefetchEndTime(ISportRenderStat.Companion.getImpl().getTime());
            }

            public void onError(Throwable throwable) {
            }
        });
    }

    /* access modifiers changed from: protected */
    public TournamentSchemeModel parseSchemeModel(JSONObject json) {
        String name = JSONUtil.optStringIgnoreNull(json, "matchName");
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        TournamentSchemeModel model = new TournamentSchemeModel();
        model.setName(name);
        model.setDate(JSONUtil.optStringIgnoreNull(json, "date"));
        parseBaseSchemeContent(model, json);
        return model;
    }

    public String getActionName() {
        return SportSchemeRouterKt.ACTION_INVOKE_TOURNAMENT;
    }

    /* access modifiers changed from: protected */
    public String getPage() {
        return "tournament";
    }
}
