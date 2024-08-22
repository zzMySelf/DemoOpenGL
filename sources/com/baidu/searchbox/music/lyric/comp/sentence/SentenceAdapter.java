package com.baidu.searchbox.music.lyric.comp.sentence;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.android.common.ui.style.R;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import com.baidu.searchbox.nacomp.recycler.base.item.ItemAdapter;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/music/lyric/comp/sentence/SentenceAdapter;", "Lcom/baidu/searchbox/nacomp/recycler/base/item/ItemAdapter;", "Lcom/baidu/searchbox/music/lyric/comp/sentence/SentenceAdapterData;", "Lcom/baidu/searchbox/music/lyric/comp/sentence/SentenceComp;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "createHolderView", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "getType", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "lib-music-lyric_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SentenceAdapter.kt */
public final class SentenceAdapter extends ItemAdapter<SentenceAdapterData, SentenceComp> {
    private final LifecycleOwner owner;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SentenceAdapter(LifecycleOwner owner2) {
        super(owner2);
        Intrinsics.checkNotNullParameter(owner2, "owner");
        this.owner = owner2;
    }

    public final LifecycleOwner getOwner() {
        return this.owner;
    }

    public SentenceComp onCreateViewHolder(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        LifecycleOwner lifecycleOwner = this.owner;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new SentenceComp(lifecycleOwner, createHolderView(context));
    }

    public UniqueId getType() {
        return SentenceAdapterData.Companion.getTYPE();
    }

    private final TextView createHolderView(Context context) {
        TextView textView = new TextView(context);
        TextView $this$createHolderView_u24lambda_u2d0 = textView;
        $this$createHolderView_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(-1, ViewExKt.getDp(36)));
        $this$createHolderView_u24lambda_u2d0.setMaxLines(1);
        $this$createHolderView_u24lambda_u2d0.setGravity(17);
        $this$createHolderView_u24lambda_u2d0.setEllipsize(TextUtils.TruncateAt.END);
        $this$createHolderView_u24lambda_u2d0.setTextSize(1, 15.0f);
        $this$createHolderView_u24lambda_u2d0.setTextColor(ResWrapper.getColor(context, R.color.GC6));
        return textView;
    }
}
