package com.baidu.searchbox.personal.sidebar;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.TipsType;
import com.baidu.searchbox.newpersonalcenter.CompleteGridView;
import com.baidu.searchbox.newpersonalcenter.adapter.TemplateContentAdapter;
import com.baidu.searchbox.personal.sidebar.SideBarBaseHolder;
import com.baidu.searchbox.personalcenter.R;
import com.baidu.searchbox.utils.PersonCenterUBCStatistic;
import com.baidu.searchbox.utils.PersonalCenterStats;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\"H\u0002J\u0012\u0010&\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010(\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010\u0002H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/personal/sidebar/SidebarHotSportHolder;", "Lcom/baidu/searchbox/personal/sidebar/SideBarBaseHolder;", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabModel;", "itemView", "Landroid/view/View;", "listener", "Lcom/baidu/searchbox/personal/sidebar/SideBarBaseHolder$ActionListener;", "mainMenuViewWidth", "", "scaleParam", "", "(Landroid/view/View;Lcom/baidu/searchbox/personal/sidebar/SideBarBaseHolder$ActionListener;IF)V", "getListener", "()Lcom/baidu/searchbox/personal/sidebar/SideBarBaseHolder$ActionListener;", "setListener", "(Lcom/baidu/searchbox/personal/sidebar/SideBarBaseHolder$ActionListener;)V", "mAdapter", "Lcom/baidu/searchbox/personal/sidebar/SidebarHotSportAdapter;", "mContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "mGridView", "Lcom/baidu/searchbox/newpersonalcenter/CompleteGridView;", "mTitle", "Landroid/widget/TextView;", "getMainMenuViewWidth", "()I", "setMainMenuViewWidth", "(I)V", "getScaleParam", "()F", "getTipsSource", "", "item", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;", "onItemClick", "", "info", "populate", "data", "ubcShow", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SidebarHotSportHolder.kt */
public final class SidebarHotSportHolder extends SideBarBaseHolder<PersonalCenterTabModel> {
    private SideBarBaseHolder.ActionListener listener;
    private final SidebarHotSportAdapter mAdapter;
    private final Context mContext;
    private final CompleteGridView mGridView;
    private final TextView mTitle;
    private int mainMenuViewWidth;
    private final float scaleParam;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SidebarHotSportHolder.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TipsType.values().length];
            iArr[TipsType.NONE.ordinal()] = 1;
            iArr[TipsType.DOT_TIP.ordinal()] = 2;
            iArr[TipsType.NUMBER_TIP.ordinal()] = 3;
            iArr[TipsType.TEXT_TIP.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SidebarHotSportHolder(View view2, SideBarBaseHolder.ActionListener actionListener, int i2, float f2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(view2, actionListener, i2, (i3 & 8) != 0 ? 1.0f : f2);
    }

    public final SideBarBaseHolder.ActionListener getListener() {
        return this.listener;
    }

    public final void setListener(SideBarBaseHolder.ActionListener actionListener) {
        this.listener = actionListener;
    }

    public final int getMainMenuViewWidth() {
        return this.mainMenuViewWidth;
    }

    public final void setMainMenuViewWidth(int i2) {
        this.mainMenuViewWidth = i2;
    }

    public final float getScaleParam() {
        return this.scaleParam;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SidebarHotSportHolder(View itemView, SideBarBaseHolder.ActionListener listener2, int mainMenuViewWidth2, float scaleParam2) {
        super(itemView, listener2);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.listener = listener2;
        this.mainMenuViewWidth = mainMenuViewWidth2;
        this.scaleParam = scaleParam2;
        Context context = itemView.getContext();
        this.mContext = context;
        View findViewById = itemView.findViewById(R.id.grid_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.grid_view)");
        this.mGridView = (CompleteGridView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.title)");
        this.mTitle = (TextView) findViewById2;
        Intrinsics.checkNotNullExpressionValue(context, "mContext");
        this.mAdapter = new SidebarHotSportAdapter(context, this.mainMenuViewWidth, scaleParam2);
    }

    public void populate(PersonalCenterTabModel data) {
        String str;
        List itemList = data != null ? data.getBody() : null;
        TextView textView = this.mTitle;
        if (data == null || (str = data.getTitle()) == null) {
            str = this.mContext.getResources().getString(R.string.sidebar_hot_sport_tittle);
        }
        textView.setText(str);
        if (itemList != null) {
            this.mAdapter.setHotSportData(itemList);
            this.mGridView.setAdapter(this.mAdapter);
            this.mAdapter.setOnItemClickListener(new SidebarHotSportHolder$populate$1(itemList, this));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.GC1));
            FontSizeTextViewExtKt.setScaledSize$default(this.mTitle, 2, 1, this.scaleParam * 14.0f, 0, 8, (Object) null);
        }
        this.itemView.setBackground(this.mContext.getResources().getDrawable(R.drawable.templae_background_corner));
    }

    public void ubcShow(PersonalCenterTabModel data) {
        List<PersonalCenterTabItemModel> $this$forEachIndexed$iv;
        if (data != null && ($this$forEachIndexed$iv = data.getBody()) != null) {
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                PersonalCenterTabItemModel item = (PersonalCenterTabItemModel) item$iv;
                PersonCenterUBCStatistic.statisticUBC(item.getUbcType(), getTipsSource(item), "show", (JSONObject) null, item.getUbcFrom(), item.getUbcEventId(), String.valueOf(index + 1));
                index = index$iv;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void onItemClick(PersonalCenterTabItemModel info) {
        if (TextUtils.equals(info.getForceLogin(), "1")) {
            TemplateContentAdapter.checkoutLogin(this.mContext, info);
            return;
        }
        Router.invoke(this.itemView.getContext(), info.getScheme());
        PersonalCenterStats.doArrivalStats(info.getScheme());
    }

    public final String getTipsSource(PersonalCenterTabItemModel item) {
        Intrinsics.checkNotNullParameter(item, "item");
        switch (WhenMappings.$EnumSwitchMapping$0[item.getTipsType().ordinal()]) {
            case 1:
                return "0";
            case 2:
                return "1";
            case 3:
                return "2";
            case 4:
                return "3";
            default:
                return "0";
        }
    }
}
