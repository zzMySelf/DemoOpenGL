package fe.mmm.qw.xxx.p032if.ad;

import androidx.recyclerview.widget.RecyclerView;
import com.tera.scan.main.ui.adapter.AllToolsAdapter;

/* renamed from: fe.mmm.qw.xxx.if.ad.de  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class de implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ AllToolsAdapter f8582ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f8583th;

    public /* synthetic */ de(AllToolsAdapter allToolsAdapter, RecyclerView.ViewHolder viewHolder) {
        this.f8582ad = allToolsAdapter;
        this.f8583th = viewHolder;
    }

    public final void run() {
        AllToolsAdapter.qw(this.f8582ad, this.f8583th);
    }
}
