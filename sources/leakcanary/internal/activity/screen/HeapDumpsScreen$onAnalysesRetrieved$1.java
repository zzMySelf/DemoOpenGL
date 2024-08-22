package leakcanary.internal.activity.screen;

import android.view.View;
import android.widget.AdapterView;
import java.util.List;
import kotlin.Metadata;
import leakcanary.internal.activity.db.HeapAnalysisTable;
import leakcanary.internal.navigation.Screen;
import leakcanary.internal.navigation.ViewsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "position", "", "<anonymous parameter 3>", "", "onItemClick"}, k = 3, mv = {1, 4, 1})
/* compiled from: HeapDumpsScreen.kt */
final class HeapDumpsScreen$onAnalysesRetrieved$1 implements AdapterView.OnItemClickListener {
    final /* synthetic */ List $projections;
    final /* synthetic */ View $this_onAnalysesRetrieved;

    HeapDumpsScreen$onAnalysesRetrieved$1(View view2, List list) {
        this.$this_onAnalysesRetrieved = view2;
        this.$projections = list;
    }

    public final void onItemClick(AdapterView<?> $noName_0, View $noName_1, int position, long $noName_3) {
        Screen analysisScreen;
        HeapAnalysisTable.Projection projection = (HeapAnalysisTable.Projection) this.$projections.get(position);
        if (projection.getExceptionSummary() != null) {
            analysisScreen = new HeapAnalysisFailureScreen(projection.getId());
        } else {
            analysisScreen = new HeapDumpScreen(projection.getId());
        }
        ViewsKt.goTo(this.$this_onAnalysesRetrieved, analysisScreen);
    }
}
