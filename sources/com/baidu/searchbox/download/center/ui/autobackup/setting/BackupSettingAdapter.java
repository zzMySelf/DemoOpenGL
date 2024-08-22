package com.baidu.searchbox.download.center.ui.autobackup.setting;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.download.center.ui.autobackup.setting.model.AutoBackupSettingBaseModel;
import com.baidu.searchbox.download.center.ui.autobackup.setting.template.AbsAutoBackupSettingHolder;
import com.baidu.searchbox.download.center.ui.autobackup.setting.template.click.IAutoBackupSettingItemClickListener;
import com.baidu.searchbox.favor.data.FavorModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\u0016\u0010\u001c\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001eH\u0007R+\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0005¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/autobackup/setting/BackupSettingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/searchbox/download/center/ui/autobackup/setting/template/AbsAutoBackupSettingHolder;", "itemClickListener", "Lcom/baidu/searchbox/download/center/ui/autobackup/setting/template/click/IAutoBackupSettingItemClickListener;", "(Lcom/baidu/searchbox/download/center/ui/autobackup/setting/template/click/IAutoBackupSettingItemClickListener;)V", "backupSettingModelList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/download/center/ui/autobackup/setting/model/AutoBackupSettingBaseModel;", "Lkotlin/collections/ArrayList;", "getBackupSettingModelList", "()Ljava/util/ArrayList;", "backupSettingModelList$delegate", "Lkotlin/Lazy;", "getItemClickListener", "()Lcom/baidu/searchbox/download/center/ui/autobackup/setting/template/click/IAutoBackupSettingItemClickListener;", "setItemClickListener", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "dataList", "", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackupSettingAdapter.kt */
public final class BackupSettingAdapter extends RecyclerView.Adapter<AbsAutoBackupSettingHolder> {
    private final Lazy backupSettingModelList$delegate;
    private IAutoBackupSettingItemClickListener itemClickListener;

    public BackupSettingAdapter() {
        this((IAutoBackupSettingItemClickListener) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BackupSettingAdapter(IAutoBackupSettingItemClickListener iAutoBackupSettingItemClickListener, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : iAutoBackupSettingItemClickListener);
    }

    public final IAutoBackupSettingItemClickListener getItemClickListener() {
        return this.itemClickListener;
    }

    public final void setItemClickListener(IAutoBackupSettingItemClickListener iAutoBackupSettingItemClickListener) {
        this.itemClickListener = iAutoBackupSettingItemClickListener;
    }

    public BackupSettingAdapter(IAutoBackupSettingItemClickListener itemClickListener2) {
        this.itemClickListener = itemClickListener2;
        this.backupSettingModelList$delegate = LazyKt.lazy(BackupSettingAdapter$backupSettingModelList$2.INSTANCE);
    }

    private final ArrayList<AutoBackupSettingBaseModel> getBackupSettingModelList() {
        return (ArrayList) this.backupSettingModelList$delegate.getValue();
    }

    public final void setData(List<? extends AutoBackupSettingBaseModel> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        getBackupSettingModelList().clear();
        getBackupSettingModelList().addAll(dataList);
        notifyDataSetChanged();
    }

    public AbsAutoBackupSettingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        return AutoBackupSettingTemplateHelperKt.getTemplateViewHolder(new AutoBackupViewTypeWrapper(viewType), parent, this.itemClickListener);
    }

    public void onBindViewHolder(AbsAutoBackupSettingHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        AutoBackupSettingBaseModel backupSettingModel = (AutoBackupSettingBaseModel) CollectionsKt.getOrNull(getBackupSettingModelList(), position);
        if (backupSettingModel != null) {
            holder.update(backupSettingModel);
        }
    }

    public int getItemViewType(int position) {
        return AutoBackupSettingTemplateHelperKt.getTemplateType((AutoBackupSettingBaseModel) CollectionsKt.getOrNull(getBackupSettingModelList(), position));
    }

    public int getItemCount() {
        return getBackupSettingModelList().size();
    }
}
