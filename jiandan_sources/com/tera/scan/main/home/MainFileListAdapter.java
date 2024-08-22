package com.tera.scan.main.home;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.tera.scan.main.home.bean.recordwrapper.RecordWrapper;
import fe.mmm.qw.j.th;
import fe.mmm.qw.xxx.yj.f;
import fe.mmm.qw.xxx.yj.g.qw.qw;
import fe.mmm.qw.xxx.yj.ggg;
import fe.mmm.qw.xxx.yj.qqq;
import fe.mmm.qw.xxx.yj.uk;
import fe.mmm.qw.xxx.yj.yj;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0014\u0010.\u001a\u00020/2\n\u00100\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002J\b\u00101\u001a\u00020\u0013H\u0016J\u0018\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0013H\u0016J\u0018\u00104\u001a\u00020\u00022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0013H\u0016J)\u00108\u001a\u00020\u001f2!\u00109\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0\u001bJ\b\u0010:\u001a\u00020\u001fH\u0002J\u0006\u0010;\u001a\u00020\u001fR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R+\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R7\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%RL\u0010&\u001a4\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130-X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/tera/scan/main/home/MainFileListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tera/scan/main/home/BaseViewHolder;", "context", "Landroid/content/Context;", "listHolder", "Lcom/tera/scan/main/home/bean/listholder/BaseMainListHolder;", "lifecycle", "Landroidx/lifecycle/LifecycleOwner;", "canSelect", "", "(Landroid/content/Context;Lcom/tera/scan/main/home/bean/listholder/BaseMainListHolder;Landroidx/lifecycle/LifecycleOwner;Z)V", "dataList", "", "Lcom/tera/scan/main/home/bean/recordwrapper/RecordWrapper;", "dateFormat", "Ljava/text/SimpleDateFormat;", "haveScroll", "indexPosition", "", "getIndexPosition", "()I", "setIndexPosition", "(I)V", "getListHolder", "()Lcom/tera/scan/main/home/bean/listholder/BaseMainListHolder;", "onFirstBindPositionItem", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "y", "", "onItemClick", "position", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onItemSelect", "Lkotlin/Function2;", "getOnItemSelect", "()Lkotlin/jvm/functions/Function2;", "setOnItemSelect", "(Lkotlin/jvm/functions/Function2;)V", "selectItemList", "", "getFileDesTitle", "", "recordData", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateAndScroll", "onBindView", "updateData", "updateListData", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MainFileListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final qw<?> f6959ad;

    /* renamed from: de  reason: collision with root package name */
    public final boolean f6960de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public List<? extends RecordWrapper<?>> f6961fe;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public Function1<? super Integer, Unit> f6962i;

    /* renamed from: o  reason: collision with root package name */
    public int f6963o;
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public Function1<? super Integer, Unit> f6964pf;
    @NotNull
    public final Context qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final Set<Integer> f6965rg;

    /* renamed from: th  reason: collision with root package name */
    public boolean f6966th;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public Function2<? super Integer, ? super Integer, Unit> f6967uk;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final SimpleDateFormat f6968yj;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MainFileListAdapter(Context context, qw qwVar, LifecycleOwner lifecycleOwner, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, qwVar, lifecycleOwner, (i2 & 8) != 0 ? false : z);
    }

    public static final void de(MainFileListAdapter mainFileListAdapter, int i2, BaseViewHolder baseViewHolder, View view) {
        Intrinsics.checkNotNullParameter(mainFileListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseViewHolder, "$holder");
        int[] iArr = {0, 0};
        baseViewHolder.itemView.getLocationOnScreen(iArr);
        int i3 = iArr[1];
        Function2<? super Integer, ? super Integer, Unit> function2 = mainFileListAdapter.f6967uk;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public static final void fe(MainFileListAdapter mainFileListAdapter, int i2, View view) {
        Intrinsics.checkNotNullParameter(mainFileListAdapter, "this$0");
        Function1<? super Integer, Unit> function1 = mainFileListAdapter.f6962i;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    public static final void qw(MainFileListAdapter mainFileListAdapter, List list) {
        Intrinsics.checkNotNullParameter(mainFileListAdapter, "this$0");
        mainFileListAdapter.th();
    }

    public static final void rg(MainFileListAdapter mainFileListAdapter, BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNullParameter(mainFileListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseViewHolder, "$holder");
        int[] iArr = {0, 0};
        baseViewHolder.itemView.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        Function1<? super Integer, Unit> function1 = mainFileListAdapter.f6964pf;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    public final String ad(RecordWrapper<?> recordWrapper) {
        Object obj;
        long j = 0;
        try {
            Result.Companion companion = Result.Companion;
            Long ad2 = recordWrapper.ad();
            obj = Result.m1155constructorimpl(this.f6968yj.format(new Date(ad2 != null ? ad2.longValue() : 0)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        if (str == null) {
            str = "";
        }
        Long qw2 = recordWrapper.qw();
        if (qw2 != null) {
            j = qw2.longValue();
        }
        String qw3 = th.qw(j);
        return str + "  " + qw3;
    }

    public final int getIndexPosition() {
        return this.f6963o;
    }

    public int getItemCount() {
        return this.f6961fe.size();
    }

    @NotNull
    public final qw<?> getListHolder() {
        return this.f6959ad;
    }

    @Nullable
    public final Function1<Integer, Unit> getOnItemClick() {
        return this.f6962i;
    }

    @Nullable
    public final Function2<Integer, Integer, Unit> getOnItemSelect() {
        return this.f6967uk;
    }

    public final void setIndexPosition(int i2) {
        this.f6963o = i2;
    }

    public final void setOnItemClick(@Nullable Function1<? super Integer, Unit> function1) {
        this.f6962i = function1;
    }

    public final void setOnItemSelect(@Nullable Function2<? super Integer, ? super Integer, Unit> function2) {
        this.f6967uk = function2;
    }

    public final void th() {
        updateListData();
        notifyDataSetChanged();
    }

    public final void updateAndScroll(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onBindView");
        this.f6966th = false;
        this.f6964pf = function1;
    }

    public final void updateListData() {
        this.f6961fe = this.f6959ad.de();
    }

    public MainFileListAdapter(@NotNull Context context, @NotNull qw<?> qwVar, @NotNull LifecycleOwner lifecycleOwner, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(qwVar, "listHolder");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycle");
        this.qw = context;
        this.f6959ad = qwVar;
        this.f6960de = z;
        this.f6961fe = qwVar.de();
        this.f6959ad.rg().observe(lifecycleOwner, new qqq(this));
        this.f6965rg = this.f6959ad.i().getSelectItemList();
        this.f6968yj = fe.mmm.qw.rg.qw.qw.qw.qw.qw();
        this.f6963o = -1;
    }

    public void onBindViewHolder(@NotNull BaseViewHolder baseViewHolder, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        RecordWrapper recordWrapper = (RecordWrapper) this.f6961fe.get(i2);
        TextView textView = (TextView) baseViewHolder.findViewWithId(R.id.tv_item_file_name);
        TextView textView2 = (TextView) baseViewHolder.findViewWithId(R.id.tv_item_file_des);
        ImageView imageView = (ImageView) baseViewHolder.findViewWithId(R.id.iv_file_item_select);
        TextView textView3 = (TextView) baseViewHolder.findViewWithId(R.id.tv_file_item_count);
        boolean z = this.f6960de && this.f6965rg.contains(Integer.valueOf(i2));
        Integer fileCount = recordWrapper.getFileCount();
        if (textView != null) {
            textView.setText(recordWrapper.getFileName());
        }
        if (textView != null) {
            textView.setEllipsize(f.qw());
        }
        if (textView2 != null) {
            textView2.setText(ad(recordWrapper));
        }
        if (imageView != null) {
            imageView.setSelected(z);
        }
        if (!this.f6960de && imageView != null) {
            imageView.setImageResource(R.drawable.icon_item_file_perview);
        }
        Resources resources = baseViewHolder.itemView.getResources();
        View view = baseViewHolder.itemView;
        if (z) {
            i3 = resources.getColor(R.color.file_item_selected_background_color);
        } else {
            i3 = resources.getColor(R.color.file_item_not_selected_background_color);
        }
        view.setBackgroundColor(i3);
        this.f6959ad.when(baseViewHolder, recordWrapper);
        if (imageView != null) {
            imageView.setOnClickListener(new yj(this, i2, baseViewHolder));
        }
        baseViewHolder.itemView.setOnClickListener(new uk(this, i2));
        if (!this.f6966th && this.f6963o == i2) {
            this.f6966th = true;
            baseViewHolder.itemView.post(new ggg(this, baseViewHolder));
        }
        if (fileCount != null) {
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            if (textView3 != null) {
                textView3.setText(String.valueOf(fileCount));
            }
        } else if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    @NotNull
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.qw).inflate(R.layout.item_common_file_list, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new BaseViewHolder(inflate);
    }
}
