package com.baidu.browser.tablayout;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.browser.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/browser/tablayout/MoreItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Landroid/view/View;)V", "searchTab", "Landroid/widget/TextView;", "getSearchTab", "()Landroid/widget/TextView;", "setSearchTab", "(Landroid/widget/TextView;)V", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabMoreAdapter.kt */
public class MoreItemViewHolder extends RecyclerView.ViewHolder {
    private TextView searchTab;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MoreItemViewHolder(View item) {
        super(item);
        Intrinsics.checkNotNullParameter(item, "item");
        this.searchTab = (TextView) item.findViewById(R.id.item_txt);
    }

    public final TextView getSearchTab() {
        return this.searchTab;
    }

    public final void setSearchTab(TextView textView) {
        this.searchTab = textView;
    }
}
