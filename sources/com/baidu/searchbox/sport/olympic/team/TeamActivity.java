package com.baidu.searchbox.sport.olympic.team;

import android.view.View;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.olympic.base.BaseOlympicSportActivity;
import com.baidu.searchbox.sport.olympic.team.header.TeamHeaderComp;
import com.baidu.searchbox.sport.olympic.team.model.TeamSchemeModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/sport/olympic/team/TeamActivity;", "Lcom/baidu/searchbox/sport/olympic/base/BaseOlympicSportActivity;", "Lcom/baidu/searchbox/sport/olympic/team/model/TeamSchemeModel;", "Lcom/baidu/searchbox/sport/olympic/team/header/TeamHeaderComp;", "Lcom/baidu/searchbox/sport/olympic/team/TeamViewModel;", "()V", "createComp", "Lcom/baidu/searchbox/sport/olympic/team/TeamComp;", "view", "Landroid/view/View;", "schemeModel", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "get1013PageName", "", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeamActivity.kt */
public final class TeamActivity extends BaseOlympicSportActivity<TeamSchemeModel, TeamHeaderComp, TeamViewModel> {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public TeamComp createComp(View view2, TeamSchemeModel schemeModel, UniqueId token) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(schemeModel, "schemeModel");
        Intrinsics.checkNotNullParameter(token, "token");
        return new TeamComp(this, view2, token, schemeModel);
    }

    public String get1013PageName() {
        return "olympicteampage";
    }
}
