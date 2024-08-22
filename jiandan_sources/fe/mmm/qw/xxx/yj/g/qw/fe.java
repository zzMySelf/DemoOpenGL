package fe.mmm.qw.xxx.yj.g.qw;

import com.tera.scan.main.home.bean.listholder.AllFileListHolder;
import com.tera.scan.main.viewmodel.MainActivityViewModel;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class fe extends AllFileListHolder {

    public static final class qw<T> implements Comparator {
        public final int compare(T t, T t2) {
            return ComparisonsKt__ComparisonsKt.compareValues(((fe.mmm.qw.xxx.yj.g.ad.qw) t2).ad(), ((fe.mmm.qw.xxx.yj.g.ad.qw) t).ad());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fe(@NotNull MainActivityViewModel mainActivityViewModel) {
        super(mainActivityViewModel);
        Intrinsics.checkNotNullParameter(mainActivityViewModel, "viewModel");
    }

    @NotNull
    public List<fe.mmm.qw.xxx.yj.g.ad.qw> de() {
        List value = i().getAllFileLiveData().getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        List<fe.mmm.qw.xxx.yj.g.ad.qw> sortedWith = CollectionsKt___CollectionsKt.sortedWith(value, new qw());
        return sortedWith.size() > 50 ? sortedWith.subList(0, 50) : sortedWith;
    }

    public int fe() {
        return 0;
    }
}
