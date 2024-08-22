package com.tera.scan.main.home;

import com.tera.scan.main.MainActivity;
import fe.mmm.qw.xxx.pf.de;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "position", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment$initFileListView$1$1$2 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ MainActivity $act;
    public final /* synthetic */ MainFileListAdapter $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$initFileListView$1$1$2(MainFileListAdapter mainFileListAdapter, MainActivity mainActivity) {
        super(1);
        this.$this_apply = mainFileListAdapter;
        this.$act = mainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        this.$this_apply.getListHolder().o(this.$act, i2);
        de.ad("Rec2FileV", "Homepage", (String) null, (Map) null, 12, (Object) null);
    }
}
