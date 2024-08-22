package com.baidu.searchbox.newpersonalcenter.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.aipersonal.AiVerticalScrollUbcTriggerKt;
import com.baidu.searchbox.aipersonal.activity.PersonalAiCommonManagerActivity;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.newpersonalcenter.adapter.PersonalCommonManagerDragHelperCallback;
import com.baidu.searchbox.newpersonalcenter.viewholder.PersonalAiDragCommonManagerViewHolder;
import com.baidu.searchbox.personalcenter.PersonalConstants;
import com.baidu.searchbox.personalcenter.R;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00012\u00020\u0005B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u001a\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/newpersonalcenter/adapter/PersonalAiCommonManagerAdapter;", "Lcom/baidu/searchbox/newpersonalcenter/adapter/PersonalCommonBaseAdapter;", "Lkotlin/Pair;", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;", "", "Lcom/baidu/searchbox/newpersonalcenter/adapter/PersonalCommonManagerDragHelperCallback$TabDragListener;", "context", "Landroid/content/Context;", "itemsShownHistorySet", "", "", "(Landroid/content/Context;Ljava/util/Set;)V", "onBindViewHolder", "", "holder", "Lcom/baidu/searchbox/newpersonalcenter/viewholder/PersonalAiDragCommonManagerViewHolder;", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onTabsMove", "from", "to", "onTabsMoveOver", "tabId", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalAiCommonManagerAdapter.kt */
public final class PersonalAiCommonManagerAdapter extends PersonalCommonBaseAdapter<Pair<? extends PersonalCenterTabItemModel, ? extends Boolean>> implements PersonalCommonManagerDragHelperCallback.TabDragListener {
    private final Set<String> itemsShownHistorySet;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalAiCommonManagerAdapter(Context context, Set<String> itemsShownHistorySet2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemsShownHistorySet2, "itemsShownHistorySet");
        this.itemsShownHistorySet = itemsShownHistorySet2;
    }

    public PersonalAiDragCommonManagerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.personal_common_manager_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new PersonalAiDragCommonManagerViewHolder(itemView);
    }

    public void onBindViewHolder(PersonalAiDragCommonManagerViewHolder holder, int position) {
        String iconUrl;
        PersonalAiDragCommonManagerViewHolder personalAiDragCommonManagerViewHolder = holder;
        Intrinsics.checkNotNullParameter(personalAiDragCommonManagerViewHolder, "holder");
        if (getDEBUG()) {
            Log.d(getTAG(), "onBindViewHolder adapterPosition " + holder.getAdapterPosition() + " ,  是否为夜间模式？ " + isNightModel() + ' ');
        }
        PersonalCenterTabItemModel data = (PersonalCenterTabItemModel) ((Pair) getMData().get(holder.getAdapterPosition())).getFirst();
        String ubcType = data.getUbcType();
        if (!CollectionsKt.contains(this.itemsShownHistorySet, ubcType)) {
            this.itemsShownHistorySet.add(ubcType == null ? "" : ubcType);
            AiVerticalScrollUbcTriggerKt.ubcCommonManagerItem(data, "show", position, PersonalConstants.SOURCE_COMMON_MGR_PRESENT, (Integer) null);
        } else {
            int i2 = position;
        }
        if (isNightModel()) {
            iconUrl = data.getIconNightUrl();
        } else {
            iconUrl = data.getIcon();
        }
        SimpleDraweeView $this$onBindViewHolder_u24lambda_u2d1 = holder.getMIvLogo();
        FontSizeViewExtKt.setScaledSize$default($this$onBindViewHolder_u24lambda_u2d1, 2, getDp26(), getDp26(), 0, 8, (Object) null);
        GenericDraweeHierarchy $this$onBindViewHolder_u24lambda_u2d1_u24lambda_u2d0 = (GenericDraweeHierarchy) $this$onBindViewHolder_u24lambda_u2d1.getHierarchy();
        if ($this$onBindViewHolder_u24lambda_u2d1_u24lambda_u2d0 != null) {
            Intrinsics.checkNotNullExpressionValue($this$onBindViewHolder_u24lambda_u2d1_u24lambda_u2d0, "hierarchy");
            Drawable tempDrawable = ContextCompat.getDrawable($this$onBindViewHolder_u24lambda_u2d1.getContext(), R.drawable.personal_default_item);
            $this$onBindViewHolder_u24lambda_u2d1_u24lambda_u2d0.setPlaceholderImage(tempDrawable);
            $this$onBindViewHolder_u24lambda_u2d1_u24lambda_u2d0.setFailureImage(tempDrawable);
            $this$onBindViewHolder_u24lambda_u2d1_u24lambda_u2d0.setUseGlobalColorFilter(false);
        }
        $this$onBindViewHolder_u24lambda_u2d1.setImageURI(iconUrl);
        TextView $this$onBindViewHolder_u24lambda_u2d2 = holder.getMTvName();
        $this$onBindViewHolder_u24lambda_u2d2.setText(data.getTitle());
        $this$onBindViewHolder_u24lambda_u2d2.setTextColor(ContextCompat.getColor($this$onBindViewHolder_u24lambda_u2d2.getContext(), R.color.GC1));
        FontSizeTextViewExtKt.setScaledSizeRes$default($this$onBindViewHolder_u24lambda_u2d2, 2, R.dimen.personal_secondpage_sub_title_size, 0, 4, (Object) null);
        ImageView $this$onBindViewHolder_u24lambda_u2d3 = holder.getMIvOperation();
        FontSizeViewExtKt.setScaledSize$default($this$onBindViewHolder_u24lambda_u2d3, 2, getDp7(), getDp7(), 0, 8, (Object) null);
        $this$onBindViewHolder_u24lambda_u2d3.setImageDrawable(ContextCompat.getDrawable($this$onBindViewHolder_u24lambda_u2d3.getContext(), R.drawable.personal_ai_manager_item_close));
        if (holder.getAdapterPosition() < PersonalAiCommonManagerActivity.Companion.getFixSize()) {
            holder.getMIvOperation().setVisibility(8);
        } else {
            holder.getMIvOperation().setVisibility(0);
        }
        holder.getMRootView().setBackground(ContextCompat.getDrawable(getContext(), R.drawable.personal_ai_normal_item_bg));
        holder.getMRootView().setOnClickListener(new PersonalAiCommonManagerAdapter$$ExternalSyntheticLambda0(this, personalAiDragCommonManagerViewHolder));
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-4  reason: not valid java name */
    public static final void m1628onBindViewHolder$lambda4(PersonalAiCommonManagerAdapter this$0, PersonalAiDragCommonManagerViewHolder $holder, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($holder, "$holder");
        if (this$0.getDEBUG()) {
            Log.d(this$0.getTAG(), "整体item点击 position " + $holder.getAdapterPosition());
        }
        CommonManagerCallBack mCallBack = this$0.getMCallBack();
        if (mCallBack != null) {
            mCallBack.onItemClick($holder.getAdapterPosition());
        }
    }

    public void onTabsMove(int from, int to) {
        if (getDEBUG()) {
            Log.d(getTAG(), "onTabsMove from = " + from + " , to = " + to);
        }
        PersonalAiCommonManagerActivity.Companion.setOperation(true);
        if (from <= getMData().size() && to <= getMData().size()) {
            Pair removeItem = (Pair) getMData().remove(from);
            AiVerticalScrollUbcTriggerKt.ubcCommonManagerItem((PersonalCenterTabItemModel) removeItem.getFirst(), "move", to, PersonalConstants.SOURCE_COMMON_MGR_PRESENT, Integer.valueOf(from));
            getMData().add(to, removeItem);
            notifyItemMoved(from, to);
        }
    }

    public void onTabsMoveOver(int position, String tabId) {
        if (getDEBUG()) {
            Log.d(getTAG(), "onTabsMoveOver 拖拽结束 position = " + position + " , tabId = " + tabId);
        }
    }
}
