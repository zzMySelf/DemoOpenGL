package com.tera.scan.main.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.tera.scan.vip.network.model.PrivilegeInfoData;
import com.tera.scan.vip.network.model.RightIconData;
import fe.rg.qw.ad;
import fe.rg.qw.th;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/tera/scan/main/view/UserCenterPrivilegeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tera/scan/main/view/UserCenterPrivilegeAdapter$ViewHolder;", "context", "Landroid/content/Context;", "data", "", "Lcom/tera/scan/vip/network/model/PrivilegeInfoData;", "(Landroid/content/Context;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserCenterPrivilegeAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final List<PrivilegeInfoData> f7001ad;
    @NotNull
    public final Context qw;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/tera/scan/main/view/UserCenterPrivilegeAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "desc", "Landroid/widget/TextView;", "getDesc", "()Landroid/widget/TextView;", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final TextView f7002ad;
        @NotNull
        public final ImageView qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.icon)");
            this.qw = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.desc);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.desc)");
            this.f7002ad = (TextView) findViewById2;
        }

        @NotNull
        public final TextView getDesc() {
            return this.f7002ad;
        }

        @NotNull
        public final ImageView getIcon() {
            return this.qw;
        }
    }

    public UserCenterPrivilegeAdapter(@NotNull Context context, @NotNull List<PrivilegeInfoData> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "data");
        this.qw = context;
        this.f7001ad = list;
    }

    public int getItemCount() {
        return this.f7001ad.size();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i2) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        PrivilegeInfoData privilegeInfoData = (PrivilegeInfoData) CollectionsKt___CollectionsKt.getOrNull(this.f7001ad, i2);
        if (privilegeInfoData != null) {
            th mmm = ad.mmm(this.qw);
            RightIconData button = privilegeInfoData.getButton();
            mmm.vvv(button != null ? button.getIconUrl() : null).m317switch(viewHolder.getIcon());
            viewHolder.getDesc().setText(privilegeInfoData.getRightName());
            if (fe.mmm.qw.k.fe.ad.qw.qw()) {
                viewHolder.getDesc().setTextColor(this.qw.getResources().getColor(R.color.white_70p_transparent));
            } else {
                viewHolder.getDesc().setTextColor(this.qw.getResources().getColor(R.color.color_495366));
            }
        }
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.qw).inflate(R.layout.item_user_privilege, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new ViewHolder(inflate);
    }
}
