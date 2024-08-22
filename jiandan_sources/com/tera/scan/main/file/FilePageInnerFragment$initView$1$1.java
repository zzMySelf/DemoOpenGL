package com.tera.scan.main.file;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.tera.scan.main.MainActivity;
import com.tera.scan.main.home.MainFileListAdapter;
import fe.mmm.qw.xxx.pf.de;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "position", "", "y", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FilePageInnerFragment$initView$1$1 extends Lambda implements Function2<Integer, Integer, Unit> {
    public final /* synthetic */ FragmentActivity $activity;
    public final /* synthetic */ MainFileListAdapter $this_apply;
    public final /* synthetic */ FilePageInnerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilePageInnerFragment$initView$1$1(FilePageInnerFragment filePageInnerFragment, FragmentActivity fragmentActivity, MainFileListAdapter mainFileListAdapter) {
        super(2);
        this.this$0 = filePageInnerFragment;
        this.$activity = fragmentActivity;
        this.$this_apply = mainFileListAdapter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2, int i3) {
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(R.id.rcv_file_list_inner);
        boolean z = false;
        if (recyclerView != null && !recyclerView.isNestedScrollingEnabled()) {
            z = true;
        }
        if (!z) {
            this.this$0.getMainActivityViewModel().onFileItemSelect((MainActivity) this.$activity, this.$this_apply.getListHolder(), i2, i3);
            de.ad("FileSel_clk", "Homepage", (String) null, (Map) null, 12, (Object) null);
        }
    }
}
