package fe.mmm.qw.xxx.yj;

import android.view.View;
import com.tera.scan.main.home.BaseViewHolder;
import com.tera.scan.main.home.MainFileListAdapter;

/* compiled from: lambda */
public final /* synthetic */ class yj implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ MainFileListAdapter f8713ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f8714th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ BaseViewHolder f8715yj;

    public /* synthetic */ yj(MainFileListAdapter mainFileListAdapter, int i2, BaseViewHolder baseViewHolder) {
        this.f8713ad = mainFileListAdapter;
        this.f8714th = i2;
        this.f8715yj = baseViewHolder;
    }

    public final void onClick(View view) {
        MainFileListAdapter.de(this.f8713ad, this.f8714th, this.f8715yj, view);
    }
}
