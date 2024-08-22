package com.baidu.searchbox.youthhome.tools.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.kmm.home.youth.YouthHomeToolsGroupModel;
import com.baidu.searchbox.kmm.home.youth.YouthHomeToolsItemModel;
import com.baidu.searchbox.youthhome.tools.R;
import com.baidu.searchbox.youthhome.tools.adapter.holder.YouthHomeV1ToolAICollectionViewHolder;
import com.baidu.searchbox.youthhome.tools.adapter.holder.YouthHomeV1ToolDiamondViewHolder;
import com.baidu.searchbox.youthhome.tools.adapter.holder.YouthHomeV1ToolFourthColumnsViewHolder;
import com.baidu.searchbox.youthhome.tools.adapter.holder.YouthHomeV1ToolLifeViewHolder;
import com.baidu.searchbox.youthhome.tools.adapter.holder.YouthHomeV1ToolTranslateViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001e\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0016\u0010\u0017\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/youthhome/tools/adapter/YouthHomeV1ToolParentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/searchbox/youthhome/tools/adapter/YouthHomeV1ToolBaseViewHolder;", "Lcom/baidu/searchbox/kmm/home/youth/YouthHomeToolsGroupModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dataSet", "", "inflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "groups", "", "DefaultViewHolder", "youth-home-tools_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: YouthHomeV1ToolParentAdapter.kt */
public final class YouthHomeV1ToolParentAdapter extends RecyclerView.Adapter<YouthHomeV1ToolBaseViewHolder<YouthHomeToolsGroupModel>> {
    private final Context context;
    private List<YouthHomeToolsGroupModel> dataSet = new ArrayList();
    private final LayoutInflater inflater;

    public YouthHomeV1ToolParentAdapter(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.inflater = LayoutInflater.from(context2);
    }

    public YouthHomeV1ToolBaseViewHolder<YouthHomeToolsGroupModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        YouthHomeV1ToolBaseViewHolder holder;
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        switch (viewType) {
            case 10001:
                View view2 = this.inflater.inflate(R.layout.youth_home_item_translate_layout, parent, false);
                Intrinsics.checkNotNullExpressionValue(view2, "view");
                holder = new YouthHomeV1ToolTranslateViewHolder(view2);
                break;
            case 10002:
                View view3 = this.inflater.inflate(R.layout.youth_home_item_diamond_layout, parent, false);
                Intrinsics.checkNotNullExpressionValue(view3, "view");
                holder = new YouthHomeV1ToolDiamondViewHolder(view3);
                break;
            case 10003:
                View view4 = this.inflater.inflate(R.layout.youth_home_item_fourth_columns_layout, parent, false);
                Intrinsics.checkNotNullExpressionValue(view4, "view");
                holder = new YouthHomeV1ToolFourthColumnsViewHolder(view4);
                break;
            case 10004:
                View view5 = this.inflater.inflate(R.layout.youth_home_item_life_layout, parent, false);
                Intrinsics.checkNotNullExpressionValue(view5, "view");
                holder = new YouthHomeV1ToolLifeViewHolder(view5);
                break;
            case 10005:
                View view6 = this.inflater.inflate(R.layout.youth_home_item_ai_layout, parent, false);
                Intrinsics.checkNotNullExpressionValue(view6, "view");
                holder = new YouthHomeV1ToolAICollectionViewHolder(view6);
                break;
            default:
                if (AppConfig.isDebug()) {
                    UniversalToast.makeText(this.context, R.string.youth_home_view_type_error).show();
                }
                View view7 = this.inflater.inflate(R.layout.youth_home_item_default_error_view, parent, false);
                Intrinsics.checkNotNullExpressionValue(view7, "view");
                holder = new DefaultViewHolder(this, view7);
                break;
        }
        return holder;
    }

    public void onBindViewHolder(YouthHomeV1ToolBaseViewHolder<YouthHomeToolsGroupModel> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        YouthHomeToolsGroupModel groupModel = (YouthHomeToolsGroupModel) CollectionsKt.getOrNull(this.dataSet, position);
        if (groupModel != null && !(holder instanceof DefaultViewHolder)) {
            holder.onBindView(groupModel);
        }
    }

    public int getItemCount() {
        return this.dataSet.size();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getItemViewType(int r4) {
        /*
            r3 = this;
            java.util.List<com.baidu.searchbox.kmm.home.youth.YouthHomeToolsGroupModel> r0 = r3.dataSet
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x000d
            int r0 = super.getItemViewType(r4)
            return r0
        L_0x000d:
            java.util.List<com.baidu.searchbox.kmm.home.youth.YouthHomeToolsGroupModel> r0 = r3.dataSet
            java.lang.Object r0 = r0.get(r4)
            com.baidu.searchbox.kmm.home.youth.YouthHomeToolsGroupModel r0 = (com.baidu.searchbox.kmm.home.youth.YouthHomeToolsGroupModel) r0
            java.lang.String r1 = r0.getGroupCategory()
            int r2 = r1.hashCode()
            switch(r2) {
                case 46730162: goto L_0x0051;
                case 46730163: goto L_0x0045;
                case 46730164: goto L_0x0039;
                case 46730165: goto L_0x002d;
                case 46730166: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x005d
        L_0x0021:
            java.lang.String r2 = "10005"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x002a
            goto L_0x0020
        L_0x002a:
            r1 = 10005(0x2715, float:1.402E-41)
            goto L_0x005e
        L_0x002d:
            java.lang.String r2 = "10004"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0036
            goto L_0x0020
        L_0x0036:
            r1 = 10004(0x2714, float:1.4019E-41)
            goto L_0x005e
        L_0x0039:
            java.lang.String r2 = "10003"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0042
            goto L_0x0020
        L_0x0042:
            r1 = 10003(0x2713, float:1.4017E-41)
            goto L_0x005e
        L_0x0045:
            java.lang.String r2 = "10002"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x004e
            goto L_0x0020
        L_0x004e:
            r1 = 10002(0x2712, float:1.4016E-41)
            goto L_0x005e
        L_0x0051:
            java.lang.String r2 = "10001"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x005a
            goto L_0x0020
        L_0x005a:
            r1 = 10001(0x2711, float:1.4014E-41)
            goto L_0x005e
        L_0x005d:
            r1 = -1
        L_0x005e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.youthhome.tools.adapter.YouthHomeV1ToolParentAdapter.getItemViewType(int):int");
    }

    public final void setData(List<YouthHomeToolsGroupModel> groups) {
        List list;
        Object obj;
        YouthHomeToolsItemModel youthHomeToolsItemModel;
        Intrinsics.checkNotNullParameter(groups, "groups");
        if (!groups.isEmpty()) {
            boolean isFirstAiToolRecentlyUsed = true;
            if (!this.dataSet.isEmpty()) {
                if (Intrinsics.areEqual((Object) this.dataSet, (Object) groups)) {
                    Iterator it = groups.iterator();
                    while (true) {
                        list = null;
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (Intrinsics.areEqual((Object) ((YouthHomeToolsGroupModel) obj).getGroupCategory(), (Object) "10005")) {
                            break;
                        }
                    }
                    YouthHomeToolsGroupModel youthHomeToolsGroupModel = (YouthHomeToolsGroupModel) obj;
                    if (youthHomeToolsGroupModel != null) {
                        list = youthHomeToolsGroupModel.getItems();
                    }
                    List aiTools = list;
                    if (aiTools == null || (youthHomeToolsItemModel = (YouthHomeToolsItemModel) CollectionsKt.firstOrNull(aiTools)) == null || !youthHomeToolsItemModel.isRecentlySelected()) {
                        isFirstAiToolRecentlyUsed = false;
                    }
                    if (isFirstAiToolRecentlyUsed) {
                        notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                this.dataSet.clear();
            }
            this.dataSet.addAll(groups);
            notifyDataSetChanged();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/youthhome/tools/adapter/YouthHomeV1ToolParentAdapter$DefaultViewHolder;", "Lcom/baidu/searchbox/youthhome/tools/adapter/YouthHomeV1ToolBaseViewHolder;", "Lcom/baidu/searchbox/kmm/home/youth/YouthHomeToolsGroupModel;", "itemView", "Landroid/view/View;", "(Lcom/baidu/searchbox/youthhome/tools/adapter/YouthHomeV1ToolParentAdapter;Landroid/view/View;)V", "onBindView", "", "data", "youth-home-tools_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: YouthHomeV1ToolParentAdapter.kt */
    public final class DefaultViewHolder extends YouthHomeV1ToolBaseViewHolder<YouthHomeToolsGroupModel> {
        final /* synthetic */ YouthHomeV1ToolParentAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DefaultViewHolder(YouthHomeV1ToolParentAdapter this$02, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = this$02;
        }

        public void onBindView(YouthHomeToolsGroupModel data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }
    }
}
