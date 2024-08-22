package fe.mmm.qw.rg.de.nn;

import androidx.appcompat.widget.ActivityChooserModel;
import com.tera.scan.business.textrecognition.TextRecognitionActivity;
import com.tera.scan.business.textrecognition.translate.AiTranslateTextManager;
import com.tera.scan.business.textrecognition.translate.model.AiTranslateDataItem;
import com.tera.scan.business.textrecognition.translate.model.AiTranslateDataResponseItem;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import fe.mmm.qw.j.yj;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class rg extends fe {

    public static final class qw<T> implements Comparator {
        public final int compare(T t, T t2) {
            return ComparisonsKt__ComparisonsKt.compareValues(((AiTranslateDataResponseItem) t).getTransKey(), ((AiTranslateDataResponseItem) t2).getTransKey());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rg(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "from");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0022, code lost:
        r11 = (r11 = r11.getData()).getList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void fe(com.tera.scan.business.textrecognition.TextRecognitionActivity r9, java.util.List r10, com.mars.kotlin.service.Result r11) {
        /*
            java.lang.String r0 = "$activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "$list"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.Object r11 = r11.getData()
            com.tera.scan.business.textrecognition.translate.model.AiTranslateResponse r11 = (com.tera.scan.business.textrecognition.translate.model.AiTranslateResponse) r11
            if (r11 == 0) goto L_0x0032
            com.tera.scan.business.textrecognition.translate.model.AiTranslateResponseData r11 = r11.getData()
            if (r11 == 0) goto L_0x0032
            java.util.List r11 = r11.getList()
            if (r11 == 0) goto L_0x0032
            fe.mmm.qw.rg.de.nn.rg$qw r2 = new fe.mmm.qw.rg.de.nn.rg$qw
            r2.<init>()
            java.util.List r11 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r11, r2)
            goto L_0x0033
        L_0x0032:
            r11 = 0
        L_0x0033:
            if (r11 == 0) goto L_0x0086
            r2 = 0
            java.util.Iterator r11 = r11.iterator()
        L_0x003a:
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto L_0x0086
            java.lang.Object r3 = r11.next()
            int r4 = r2 + 1
            if (r2 >= 0) goto L_0x004b
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x004b:
            com.tera.scan.business.textrecognition.translate.model.AiTranslateDataResponseItem r3 = (com.tera.scan.business.textrecognition.translate.model.AiTranslateDataResponseItem) r3
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r6 = r3.getTransKey()
            java.lang.String r7 = ""
            if (r6 != 0) goto L_0x005b
            r6 = r7
        L_0x005b:
            java.lang.String r8 = "trans_key"
            r5.put(r8, r6)
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r10, r2)
            fe.mmm.qw.rg.de.ddd.qw r2 = (fe.mmm.qw.rg.de.ddd.qw) r2
            if (r2 == 0) goto L_0x006e
            java.lang.String r2 = r2.ad()
            if (r2 != 0) goto L_0x006f
        L_0x006e:
            r2 = r7
        L_0x006f:
            java.lang.String r6 = "original_text"
            r5.put(r6, r2)
            java.lang.String r2 = r3.getAfterTranslate()
            if (r2 != 0) goto L_0x007b
            goto L_0x007c
        L_0x007b:
            r7 = r2
        L_0x007c:
            java.lang.String r2 = "translate_text"
            r5.put(r2, r7)
            r1.add(r5)
            r2 = r4
            goto L_0x003a
        L_0x0086:
            java.util.Locale r10 = java.util.Locale.getDefault()
            java.lang.String r10 = r10.getLanguage()
            java.lang.String r11 = "target_lan"
            r0.putString(r11, r10)
            java.lang.String r10 = "page_info"
            r0.putSerializable(r10, r1)
            r10 = -1
            android.content.Intent r11 = new android.content.Intent
            r11.<init>()
            r11.putExtras(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r9.setResult(r10, r11)
            r9.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.rg.de.nn.rg.fe(com.tera.scan.business.textrecognition.TextRecognitionActivity, java.util.List, com.mars.kotlin.service.Result):void");
    }

    public void ad() {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "photo_translate_loading_fail_popup_show", (List) null, 2, (Object) null);
    }

    public void de() {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "photo_translate_loading_page_show", (List) null, 2, (Object) null);
    }

    public void qw(@NotNull TextRecognitionActivity textRecognitionActivity, @NotNull List<fe.mmm.qw.rg.de.ddd.qw> list, @NotNull String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(textRecognitionActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(str, "lanType");
        String displayLanguage = Locale.getDefault().getDisplayLanguage(Locale.ENGLISH);
        try {
            Result.Companion companion = Result.Companion;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            int i2 = 0;
            for (T next : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                AiTranslateDataItem aiTranslateDataItem = new AiTranslateDataItem();
                aiTranslateDataItem.setTransKey(String.valueOf(i2));
                aiTranslateDataItem.setContent(((fe.mmm.qw.rg.de.ddd.qw) next).ad());
                arrayList.add(aiTranslateDataItem);
                i2 = i3;
            }
            obj = Result.m1155constructorimpl(yj.fe(arrayList));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        String str2 = (String) obj;
        if (str2 == null) {
            str2 = "";
        }
        new AiTranslateTextManager(textRecognitionActivity).qw("SC3IQL", "", displayLanguage, str2).observe(textRecognitionActivity, new ad(textRecognitionActivity, list));
    }
}
