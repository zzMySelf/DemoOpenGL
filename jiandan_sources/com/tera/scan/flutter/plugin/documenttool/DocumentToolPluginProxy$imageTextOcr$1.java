package com.tera.scan.flutter.plugin.documenttool;

import com.google.common.net.MediaType;
import fe.mmm.qw.rg.de.qqq.qw;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DocumentToolPluginProxy$imageTextOcr$1 extends Lambda implements Function1<List<? extends String>, Unit> {
    public final /* synthetic */ List<String> $imageList;
    public final /* synthetic */ qw $recognizer;
    public final /* synthetic */ MethodChannel.Result $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DocumentToolPluginProxy$imageTextOcr$1(MethodChannel.Result result, qw qwVar, List<String> list) {
        super(1);
        this.$result = result;
        this.$recognizer = qwVar;
        this.$imageList = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<String>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        ArrayList arrayList = new ArrayList();
        List<String> list2 = this.$imageList;
        int i2 = 0;
        for (T next : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(MediaType.IMAGE_TYPE, list2.get(i2));
            linkedHashMap.put("ocr_result", CollectionsKt__CollectionsJVMKt.listOf(MapsKt__MapsJVMKt.mapOf(TuplesKt.to("text", (String) next))));
            arrayList.add(linkedHashMap);
            i2 = i3;
        }
        this.$result.success(arrayList);
        this.$recognizer.qw();
    }
}
