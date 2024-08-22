package com.baidu.searchbox.sport.olympic.sport.sportspanel.item;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.nacomp.extension.base.BaseExtItemViewModel;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.page.olympic.schedule.model.OlympicSport;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/sport/olympic/sport/sportspanel/item/SubSportsViewModel;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtItemViewModel;", "Lcom/baidu/searchbox/sport/olympic/sport/sportspanel/item/SubSportsData;", "()V", "anchorCenterX", "Landroidx/lifecycle/MutableLiveData;", "", "getAnchorCenterX", "()Landroidx/lifecycle/MutableLiveData;", "subSports", "", "Lcom/baidu/searchbox/sport/page/olympic/schedule/model/OlympicSport;", "getSubSports", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getToken", "setModel", "", "data", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubSportsComp.kt */
public final class SubSportsViewModel extends BaseExtItemViewModel<SubSportsData> {
    private final MutableLiveData<Integer> anchorCenterX = new MutableLiveData<>();
    private final MutableLiveData<List<OlympicSport>> subSports = new MutableLiveData<>();
    private final MutableLiveData<UniqueId> token = new MutableLiveData<>();

    public final MutableLiveData<Integer> getAnchorCenterX() {
        return this.anchorCenterX;
    }

    public final MutableLiveData<UniqueId> getToken() {
        return this.token;
    }

    public final MutableLiveData<List<OlympicSport>> getSubSports() {
        return this.subSports;
    }

    public void setModel(SubSportsData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.setModel(data);
        this.anchorCenterX.setValue(Integer.valueOf(data.getAnchorViewCenterX() - ViewExKt.getDp(15)));
        this.token.setValue(data.getToken());
        this.subSports.setValue(data.getSubSports());
    }
}
