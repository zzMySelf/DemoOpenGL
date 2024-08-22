package com.baidu.searchbox.newpersonalcenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.newpersonalcenter.listener.ModuleActionListener;
import com.baidu.searchbox.newpersonalcenter.swan.PersonalSwanDataManager;
import com.baidu.searchbox.newpersonalcenter.viewholder.FunctionAdvisoryHolder;
import com.baidu.searchbox.newpersonalcenter.viewholder.FunctionBaseHolder;
import com.baidu.searchbox.newpersonalcenter.viewholder.FunctionCreateCenterHolder;
import com.baidu.searchbox.newpersonalcenter.viewholder.FunctionSwanHolder;
import com.baidu.searchbox.newpersonalcenter.viewholder.FunctionWalletHolder;
import com.baidu.searchbox.personalcenter.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\tJ\b\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/newpersonalcenter/adapter/FunctionContentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/searchbox/newpersonalcenter/viewholder/FunctionBaseHolder;", "context", "Landroid/content/Context;", "isGridTypeItem", "", "(Landroid/content/Context;Z)V", "mItemCount", "", "mModuleActionListener", "Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;", "tabModel", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabModel;", "getItem", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;", "position", "getItemCount", "getItemViewType", "getSwanMaxCount", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "personalCenterTabModel", "setModuleActionListener", "moduleActionListener", "Companion", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FunctionContentAdapter.kt */
public final class FunctionContentAdapter extends RecyclerView.Adapter<FunctionBaseHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FORCE_LOGIN_VALUE = "1";
    private final Context context;
    private final boolean isGridTypeItem;
    private int mItemCount;
    private ModuleActionListener mModuleActionListener;
    private PersonalCenterTabModel tabModel;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FunctionContentAdapter(Context context2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i2 & 2) != 0 ? false : z);
    }

    public FunctionContentAdapter(Context context2, boolean isGridTypeItem2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.isGridTypeItem = isGridTypeItem2;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/newpersonalcenter/adapter/FunctionContentAdapter$Companion;", "", "()V", "FORCE_LOGIN_VALUE", "", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FunctionContentAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void setData(PersonalCenterTabModel personalCenterTabModel) {
        if ((personalCenterTabModel != null ? personalCenterTabModel.getBody() : null) != null && personalCenterTabModel.getBody().size() >= 4) {
            this.tabModel = personalCenterTabModel;
            this.mItemCount = getSwanMaxCount();
        }
    }

    public FunctionBaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FunctionBaseHolder viewHolder;
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        PersonalCenterTabModel personalCenterTabModel = null;
        switch (viewType) {
            case 1016:
                View itemView = LayoutInflater.from(this.context).inflate(R.layout.layout_personal_function_advisory, parent, false);
                Context context2 = this.context;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                viewHolder = new FunctionAdvisoryHolder(context2, itemView, this.mModuleActionListener);
                break;
            case 1017:
                View itemView2 = LayoutInflater.from(this.context).inflate(R.layout.layout_personal_function_wallet, parent, false);
                Context context3 = this.context;
                Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
                viewHolder = new FunctionWalletHolder(context3, itemView2, this.mModuleActionListener);
                break;
            case 1019:
                View itemView3 = LayoutInflater.from(this.context).inflate(R.layout.layout_personal_function_swan, parent, false);
                if (this.isGridTypeItem) {
                    ViewGroup.LayoutParams lp = itemView3.getLayoutParams();
                    if (lp == null) {
                        itemView3.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    } else {
                        lp.width = -1;
                    }
                    ViewGroup.MarginLayoutParams $this$onCreateViewHolder_u24lambda_u2d0 = lp instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) lp : null;
                    if ($this$onCreateViewHolder_u24lambda_u2d0 != null) {
                        $this$onCreateViewHolder_u24lambda_u2d0.topMargin = 0;
                        $this$onCreateViewHolder_u24lambda_u2d0.bottomMargin = 0;
                    }
                }
                Context context4 = this.context;
                Intrinsics.checkNotNullExpressionValue(itemView3, "itemView");
                viewHolder = new FunctionSwanHolder(context4, itemView3, this.mModuleActionListener, this.isGridTypeItem);
                break;
            default:
                View itemView4 = LayoutInflater.from(this.context).inflate(R.layout.layout_personal_function_create, parent, false);
                Context context5 = this.context;
                Intrinsics.checkNotNullExpressionValue(itemView4, "itemView");
                viewHolder = new FunctionCreateCenterHolder(context5, itemView4, this.mModuleActionListener);
                break;
        }
        if (!this.isGridTypeItem) {
            PersonalCenterTabModel personalCenterTabModel2 = this.tabModel;
            if (personalCenterTabModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabModel");
            } else {
                personalCenterTabModel = personalCenterTabModel2;
            }
            viewHolder.adjustLayoutParam(personalCenterTabModel.getTempCategory());
        }
        return viewHolder;
    }

    public void onBindViewHolder(FunctionBaseHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PersonalCenterTabModel personalCenterTabModel = this.tabModel;
        PersonalCenterTabModel personalCenterTabModel2 = null;
        if (personalCenterTabModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabModel");
            personalCenterTabModel = null;
        }
        holder.adjustLayoutParam(personalCenterTabModel.getTempCategory());
        holder.setPosition(position);
        if (holder instanceof FunctionSwanHolder) {
            ((FunctionSwanHolder) holder).setHideTitleDivider(getItemCount() > 5);
        }
        PersonalCenterTabModel personalCenterTabModel3 = this.tabModel;
        if (personalCenterTabModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabModel");
        } else {
            personalCenterTabModel2 = personalCenterTabModel3;
        }
        holder.populate(personalCenterTabModel2);
    }

    public int getItemViewType(int position) {
        PersonalCenterTabModel personalCenterTabModel = this.tabModel;
        if (personalCenterTabModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabModel");
            personalCenterTabModel = null;
        }
        return personalCenterTabModel.getTempCategory();
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public final PersonalCenterTabItemModel getItem(int position) {
        PersonalCenterTabModel personalCenterTabModel = this.tabModel;
        PersonalCenterTabModel personalCenterTabModel2 = null;
        if (personalCenterTabModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabModel");
            personalCenterTabModel = null;
        }
        if (position >= personalCenterTabModel.getBody().size()) {
            return null;
        }
        PersonalCenterTabModel personalCenterTabModel3 = this.tabModel;
        if (personalCenterTabModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabModel");
        } else {
            personalCenterTabModel2 = personalCenterTabModel3;
        }
        return personalCenterTabModel2.getBody().get(position);
    }

    public final void setModuleActionListener(ModuleActionListener moduleActionListener) {
        this.mModuleActionListener = moduleActionListener;
    }

    private final int getSwanMaxCount() {
        if (!this.isGridTypeItem) {
            return 5;
        }
        if (this.tabModel == null) {
            return 0;
        }
        PersonalSwanDataManager personalSwanDataManager = PersonalSwanDataManager.INSTANCE;
        PersonalCenterTabModel personalCenterTabModel = this.tabModel;
        if (personalCenterTabModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabModel");
            personalCenterTabModel = null;
        }
        return personalSwanDataManager.getSwanMaxCountByCurCount(personalCenterTabModel.getBody().size());
    }
}
