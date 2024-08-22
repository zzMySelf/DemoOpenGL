package fe.mmm.qw.xxx.yj;

import com.tera.scan.main.home.BaseViewHolder;
import com.tera.scan.main.home.MainFileListAdapter;

/* compiled from: lambda */
public final /* synthetic */ class ggg implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MainFileListAdapter f8691ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ BaseViewHolder f8692th;

    public /* synthetic */ ggg(MainFileListAdapter mainFileListAdapter, BaseViewHolder baseViewHolder) {
        this.f8691ad = mainFileListAdapter;
        this.f8692th = baseViewHolder;
    }

    public final void run() {
        MainFileListAdapter.rg(this.f8691ad, this.f8692th);
    }
}
