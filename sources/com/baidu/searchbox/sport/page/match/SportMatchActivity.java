package com.baidu.searchbox.sport.page.match;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.R;
import com.baidu.searchbox.sport.ioc.ISportRenderStat;
import com.baidu.searchbox.sport.page.base.BaseSportActivity;
import com.baidu.searchbox.sport.page.chatroom.comp.item.audio.AudioPermissionEvent;
import com.baidu.searchbox.sport.page.match.model.MatchPageSchemeModel;
import com.baidu.searchbox.sport.services.SportServices;
import com.baidu.searchbox.sport.statistic.SportStatService;
import com.baidu.searchbox.sport.statistic.SportStats;

public class SportMatchActivity extends BaseSportActivity<MatchPageSchemeModel> {
    private static final int REQUEST_CODE_PERMISSION_RECORD = 2108;
    private UniqueId token;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        String page = get1013PageName();
        ISportRenderStat.Companion.getImpl().updateStatistic(page, "onCreate");
        super.onCreate(savedInstanceState);
        MatchPageSchemeModel schemeModel = (MatchPageSchemeModel) getSchemeModel();
        if (schemeModel == null || schemeModel.getToken() == null) {
            finish();
            return;
        }
        UniqueId token2 = schemeModel.getToken();
        this.token = token2;
        if (SportServices.get(token2, SportStats.SERVICE_STAT) == null) {
            SportServices.register(this.token, SportStats.SERVICE_STAT, new SportStatService(page));
        }
        View view2 = LayoutInflater.from(this).inflate(R.layout.sport_page_common, (ViewGroup) null);
        setContentView(view2);
        setPageComponent(new MatchPageComp(this, view2, schemeModel.getToken(), schemeModel));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        UniqueId uniqueId = this.token;
        if (uniqueId != null) {
            SportServices.unregister(uniqueId, SportStats.SERVICE_STAT);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 2108 && grantResults != null && grantResults.length >= 1 && grantResults[0] == 0 && this.token != null) {
            BdEventBus.Companion.getDefault().post(new AudioPermissionEvent(this.token));
        }
    }

    public String get1013PageName() {
        return "matchdetail";
    }
}
