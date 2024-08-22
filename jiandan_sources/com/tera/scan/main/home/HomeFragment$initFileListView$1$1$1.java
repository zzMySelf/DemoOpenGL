package com.tera.scan.main.home;

import com.tera.scan.main.MainActivity;
import fe.mmm.qw.xxx.pf.de;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "position", "", "y", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment$initFileListView$1$1$1 extends Lambda implements Function2<Integer, Integer, Unit> {
    public final /* synthetic */ MainActivity $act;
    public final /* synthetic */ MainFileListAdapter $this_apply;
    public final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$initFileListView$1$1$1(HomeFragment homeFragment, MainActivity mainActivity, MainFileListAdapter mainFileListAdapter) {
        super(2);
        this.this$0 = homeFragment;
        this.$act = mainActivity;
        this.$this_apply = mainFileListAdapter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2, int i3) {
        this.this$0.getMainActivityViewModel().onFileItemSelect(this.$act, this.$this_apply.getListHolder(), i2, i3);
        de.ad("Rec_clk", "Homepage", (String) null, (Map) null, 12, (Object) null);
    }
}
