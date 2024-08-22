package fe.mmm.qw.xxx.p032if.qw;

import android.view.View;
import com.tera.scan.main.view.SettingItemView;

/* renamed from: fe.mmm.qw.xxx.if.qw.qw  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class qw implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Cswitch f8609ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ SettingItemView f8610th;

    public /* synthetic */ qw(Cswitch switchR, SettingItemView settingItemView) {
        this.f8609ad = switchR;
        this.f8610th = settingItemView;
    }

    public final void onClick(View view) {
        Cswitch.i(this.f8609ad, this.f8610th, view);
    }
}
