package com.tera.scan.main.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import fe.mmm.qw.xxx.yj.g.ad.ad;
import fe.mmm.qw.xxx.yj.g.ad.de;
import fe.mmm.qw.xxx.yj.g.ad.qw;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MainActivityViewModel$_allFileListLiveData$1$updateValue$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ MediatorLiveData<List<qw>> $this_apply;
    public final /* synthetic */ MainActivityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainActivityViewModel$_allFileListLiveData$1$updateValue$1(MainActivityViewModel mainActivityViewModel, MediatorLiveData<List<qw>> mediatorLiveData) {
        super(0);
        this.this$0 = mainActivityViewModel;
        this.$this_apply = mediatorLiveData;
    }

    public final void invoke() {
        ArrayList arrayList = new ArrayList();
        List<de> value = this.this$0.getScanRecordList().getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        List<ad> value2 = this.this$0.getFileExportList().getValue();
        if (value2 == null) {
            value2 = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(value, 10));
        for (de de2 : value) {
            arrayList2.add(new qw(de2.getData()));
        }
        if (!arrayList2.isEmpty()) {
            arrayList.addAll(arrayList2);
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(value2, 10));
        for (ad de3 : value2) {
            arrayList3.add(new qw(de3.getData()));
        }
        if (!arrayList3.isEmpty()) {
            arrayList.addAll(arrayList3);
        }
        this.$this_apply.setValue(arrayList);
    }
}
