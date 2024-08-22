package com.baidu.searchbox.sport.page.olympic.schedule.filter.panel.list.item;

import com.baidu.searchbox.nacomp.recycler.delegate.IAdapterData;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.search.tab.sortSelect.SearchVideoSubTabParser;
import com.baidu.searchbox.sport.page.olympic.schedule.filter.model.ScheduleFilterModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/sport/page/olympic/schedule/filter/panel/list/item/ScheduleFilterItemModel;", "Lcom/baidu/searchbox/nacomp/recycler/delegate/IAdapterData;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "filterData", "Lcom/baidu/searchbox/sport/page/olympic/schedule/filter/model/ScheduleFilterModel;", "level", "", "inLastFilter", "", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;Lcom/baidu/searchbox/sport/page/olympic/schedule/filter/model/ScheduleFilterModel;IZ)V", "getFilterData", "()Lcom/baidu/searchbox/sport/page/olympic/schedule/filter/model/ScheduleFilterModel;", "getInLastFilter", "()Z", "getLevel", "()I", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getType", "Companion", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScheduleFilterItemModel.kt */
public final class ScheduleFilterItemModel implements IAdapterData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final UniqueId TYPE;
    private final ScheduleFilterModel filterData;
    private final boolean inLastFilter;
    private final int level;
    private final UniqueId token;

    public ScheduleFilterItemModel(UniqueId token2, ScheduleFilterModel filterData2, int level2, boolean inLastFilter2) {
        Intrinsics.checkNotNullParameter(token2, "token");
        Intrinsics.checkNotNullParameter(filterData2, SearchVideoSubTabParser.FILTER_DATA);
        this.token = token2;
        this.filterData = filterData2;
        this.level = level2;
        this.inLastFilter = inLastFilter2;
    }

    public final UniqueId getToken() {
        return this.token;
    }

    public final ScheduleFilterModel getFilterData() {
        return this.filterData;
    }

    public final int getLevel() {
        return this.level;
    }

    public final boolean getInLastFilter() {
        return this.inLastFilter;
    }

    public UniqueId getType() {
        return TYPE;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/sport/page/olympic/schedule/filter/panel/list/item/ScheduleFilterItemModel$Companion;", "", "()V", "TYPE", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getTYPE", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ScheduleFilterItemModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UniqueId getTYPE() {
            return ScheduleFilterItemModel.TYPE;
        }
    }

    static {
        UniqueId gen = UniqueId.gen("ScheduleFilterItemModel");
        Intrinsics.checkNotNullExpressionValue(gen, "gen(\"ScheduleFilterItemModel\")");
        TYPE = gen;
    }
}
