package com.baidu.searchbox.ng.errorview.rec.view;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.ng.errorview.R;
import com.baidu.searchbox.ng.errorview.rec.model.RsrgData;
import com.baidu.searchbox.ng.errorview.rec.model.RsrgItemData;
import com.baidu.searchbox.ng.errorview.utils.JumpToResultKt;
import com.baidu.searchbox.ng.errorview.utils.ViewPressStateUtilsKt;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR9\u0010\u0010\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/ng/errorview/rec/view/RecViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/searchbox/ng/errorview/rec/view/RecViewAdapter$GridItemViewHolder;", "()V", "data", "Lcom/baidu/searchbox/ng/errorview/rec/model/RsrgData;", "getData", "()Lcom/baidu/searchbox/ng/errorview/rec/model/RsrgData;", "setData", "(Lcom/baidu/searchbox/ng/errorview/rec/model/RsrgData;)V", "itemBg", "", "getItemBg", "()I", "setItemBg", "(I)V", "jumpCallBack", "Lkotlin/Function1;", "Lcom/baidu/searchbox/ng/errorview/rec/model/RsrgItemData;", "Lkotlin/ParameterName;", "name", "index", "", "getJumpCallBack", "()Lkotlin/jvm/functions/Function1;", "setJumpCallBack", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "GridItemViewHolder", "lib-errorview_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecViewAdapter.kt */
public final class RecViewAdapter extends RecyclerView.Adapter<GridItemViewHolder> {
    private RsrgData data;
    private int itemBg = R.drawable.webview_rec_errorview_rsrg_item_bg;
    private Function1<? super RsrgItemData, Unit> jumpCallBack;

    public final RsrgData getData() {
        return this.data;
    }

    public final void setData(RsrgData rsrgData) {
        this.data = rsrgData;
    }

    public final int getItemBg() {
        return this.itemBg;
    }

    public final void setItemBg(int i2) {
        this.itemBg = i2;
    }

    public final Function1<RsrgItemData, Unit> getJumpCallBack() {
        return this.jumpCallBack;
    }

    public final void setJumpCallBack(Function1<? super RsrgItemData, Unit> function1) {
        this.jumpCallBack = function1;
    }

    public GridItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.browser_webview_errorv_rsrg_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …  false\n                )");
        return new GridItemViewHolder(inflate, this.itemBg);
    }

    public int getItemCount() {
        List<RsrgItemData> itemList;
        RsrgData rsrgData = this.data;
        if (rsrgData == null || (itemList = rsrgData.getItemList()) == null) {
            return 0;
        }
        return itemList.size();
    }

    public void onBindViewHolder(GridItemViewHolder holder, int position) {
        List<RsrgItemData> itemList;
        RsrgItemData itemData;
        Intrinsics.checkNotNullParameter(holder, "holder");
        RsrgData rsrgData = this.data;
        if (rsrgData != null && (itemList = rsrgData.getItemList()) != null && (itemData = itemList.get(position)) != null) {
            holder.setData(itemData);
            holder.setJumpCallBack(this.jumpCallBack);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR9\u0010\r\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/ng/errorview/rec/view/RecViewAdapter$GridItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "itemBg", "", "(Landroid/view/View;I)V", "icon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getItemBg", "()I", "setItemBg", "(I)V", "jumpCallBack", "Lkotlin/Function1;", "Lcom/baidu/searchbox/ng/errorview/rec/model/RsrgItemData;", "Lkotlin/ParameterName;", "name", "index", "", "getJumpCallBack", "()Lkotlin/jvm/functions/Function1;", "setJumpCallBack", "(Lkotlin/jvm/functions/Function1;)V", "tv", "Landroid/widget/TextView;", "setData", "itemData", "lib-errorview_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RecViewAdapter.kt */
    public static final class GridItemViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView icon;
        private int itemBg;
        private Function1<? super RsrgItemData, Unit> jumpCallBack;
        private TextView tv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GridItemViewHolder(View itemView, int itemBg2) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.itemBg = itemBg2;
            View findViewById = itemView.findViewById(R.id.webview_errorview_rsrg_item_tv);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.…w_errorview_rsrg_item_tv)");
            this.tv = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.webview_errorview_rsrg_item_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.…errorview_rsrg_item_icon)");
            this.icon = (SimpleDraweeView) findViewById2;
            ViewPressStateUtilsKt.addPressedState$default(itemView, 0.0f, 1, (Object) null);
        }

        public final int getItemBg() {
            return this.itemBg;
        }

        public final void setItemBg(int i2) {
            this.itemBg = i2;
        }

        public final Function1<RsrgItemData, Unit> getJumpCallBack() {
            return this.jumpCallBack;
        }

        public final void setJumpCallBack(Function1<? super RsrgItemData, Unit> function1) {
            this.jumpCallBack = function1;
        }

        public final void setData(RsrgItemData itemData) {
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            this.tv.setText(itemData.getQuery());
            this.tv.setTextColor(this.itemView.getContext().getResources().getColor(R.color.search_rec_item_tv));
            FontSizeTextViewExtKt.setScaledSizeRes$default(this.tv, 0, R.dimen.webview_rec_errorview_rsrg_query_size, 0, 4, (Object) null);
            this.itemView.setBackground(ResourcesCompat.getDrawable(this.itemView.getContext().getResources(), this.itemBg, (Resources.Theme) null));
            this.itemView.setOnClickListener(new RecViewAdapter$GridItemViewHolder$$ExternalSyntheticLambda0(this, itemData));
            if (!TextUtils.isEmpty(itemData.getIconUrl())) {
                int iconWH = (int) (((float) this.itemView.getContext().getResources().getDimensionPixelOffset(R.dimen.webview_errorview_rsrg_item_icon_h_w)) * FontSizeHelper.getScaledRatio(0));
                ViewGroup.LayoutParams iconLp = this.icon.getLayoutParams();
                if (iconLp != null) {
                    iconLp.width = iconWH;
                    iconLp.height = iconWH;
                } else {
                    iconLp = new ViewGroup.LayoutParams(iconWH, iconWH);
                }
                this.icon.setLayoutParams(iconLp);
                this.icon.setVisibility(0);
                SimpleDraweeView $this$setData_u24lambda_u2d2 = this.icon;
                $this$setData_u24lambda_u2d2.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(Uri.parse(itemData.getIconUrl())).setTapToRetryEnabled(false)).setOldController($this$setData_u24lambda_u2d2.getController())).build());
                return;
            }
            this.icon.setVisibility(8);
        }

        /* access modifiers changed from: private */
        /* renamed from: setData$lambda-0  reason: not valid java name */
        public static final void m18932setData$lambda0(GridItemViewHolder this$0, RsrgItemData $itemData, View it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter($itemData, "$itemData");
            Function1<? super RsrgItemData, Unit> function1 = this$0.jumpCallBack;
            if (function1 != null) {
                function1.invoke($itemData);
            }
            Context context = this$0.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            String query = $itemData.getQuery();
            String str = "";
            if (query == null) {
                query = str;
            }
            String sa = $itemData.getSa();
            if (sa != null) {
                str = sa;
            }
            JumpToResultKt.jumpToResult(context, query, str);
        }
    }
}
