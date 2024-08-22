package com.baidu.searchbox.personal.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel;
import com.baidu.searchbox.newpersonalcenter.ViewHolderFactory;
import com.baidu.searchbox.newpersonalcenter.listener.ModuleActionListener;
import com.baidu.searchbox.newpersonalcenter.viewholder.BaseHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0016\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/personal/adapter/PersonalSelectedGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/searchbox/newpersonalcenter/viewholder/BaseHolder;", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterGroupModel;", "mContext", "Landroid/content/Context;", "mModuleActionListener", "Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;", "(Landroid/content/Context;Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;)V", "mData", "", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "data", "", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalSelectedGroupAdapter.kt */
public final class PersonalSelectedGroupAdapter extends RecyclerView.Adapter<BaseHolder<PersonalCenterGroupModel>> {
    private final Context mContext;
    private final List<PersonalCenterGroupModel> mData = new ArrayList();
    private final ModuleActionListener mModuleActionListener;

    public PersonalSelectedGroupAdapter(Context mContext2, ModuleActionListener mModuleActionListener2) {
        Intrinsics.checkNotNullParameter(mContext2, "mContext");
        Intrinsics.checkNotNullParameter(mModuleActionListener2, "mModuleActionListener");
        this.mContext = mContext2;
        this.mModuleActionListener = mModuleActionListener2;
    }

    public final void updateData(List<? extends PersonalCenterGroupModel> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mData.clear();
        this.mData.addAll(data);
        notifyDataSetChanged();
    }

    public BaseHolder<PersonalCenterGroupModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        BaseHolder<PersonalCenterGroupModel> createViewHolder = new ViewHolderFactory().createViewHolder(this.mContext, parent, viewType, this.mModuleActionListener);
        Intrinsics.checkNotNullExpressionValue(createViewHolder, "ViewHolderFactory().crea…eActionListener\n        )");
        return createViewHolder;
    }

    public void onBindViewHolder(BaseHolder<PersonalCenterGroupModel> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PersonalCenterGroupModel personalCenterGroupModel = (PersonalCenterGroupModel) CollectionsKt.getOrNull(this.mData, position);
        if (personalCenterGroupModel != null) {
            holder.populate(personalCenterGroupModel);
        }
    }

    public int getItemViewType(int position) {
        int tplCategory;
        PersonalCenterGroupModel personalCenterGroupModel = (PersonalCenterGroupModel) CollectionsKt.getOrNull(this.mData, position);
        if (personalCenterGroupModel != null && personalCenterGroupModel.getPersonalCenterTabs().size() > 0 && (tplCategory = personalCenterGroupModel.getPersonalCenterTabs().get(0).getTempCategory()) > 0) {
            return tplCategory;
        }
        return position;
    }

    public int getItemCount() {
        return this.mData.size();
    }
}
