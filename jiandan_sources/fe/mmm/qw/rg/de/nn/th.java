package fe.mmm.qw.rg.de.nn;

import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;
import com.mars.kotlin.service.Result;
import com.tera.scan.business.textrecognition.TextRecognitionActivity;
import com.tera.scan.business.textrecognition.translate.AiTranslateTextManager;
import com.tera.scan.business.textrecognition.translate.model.AiTranslateDataItem;
import com.tera.scan.business.textrecognition.translate.model.AiTranslateDataResponseItem;
import com.tera.scan.business.textrecognition.translate.model.AiTranslateResponse;
import com.tera.scan.business.textrecognition.translate.model.AiTranslateResponseData;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import fe.mmm.qw.j.yj;
import fe.mmm.qw.rg.de.ddd.qw;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class th extends fe {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public th(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "from");
    }

    public static final void fe(List list, TextRecognitionActivity textRecognitionActivity, Result result) {
        String str;
        AiTranslateResponseData data;
        List<AiTranslateDataResponseItem> list2;
        AiTranslateDataResponseItem aiTranslateDataResponseItem;
        String afterTranslate;
        Intrinsics.checkNotNullParameter(list, "$list");
        Intrinsics.checkNotNullParameter(textRecognitionActivity, "$activity");
        Intent intent = new Intent();
        qw qwVar = (qw) CollectionsKt___CollectionsKt.firstOrNull(list);
        String str2 = "";
        if (qwVar == null || (str = qwVar.ad()) == null) {
            str = str2;
        }
        intent.putExtra("original_text", str);
        AiTranslateResponse aiTranslateResponse = (AiTranslateResponse) result.getData();
        if (!(aiTranslateResponse == null || (data = aiTranslateResponse.getData()) == null || (list2 = data.getList()) == null || (aiTranslateDataResponseItem = (AiTranslateDataResponseItem) CollectionsKt___CollectionsKt.firstOrNull(list2)) == null || (afterTranslate = aiTranslateDataResponseItem.getAfterTranslate()) == null)) {
            str2 = afterTranslate;
        }
        intent.putExtra("translate_text", str2);
        intent.putExtra("target_lan", Locale.getDefault().getLanguage());
        textRecognitionActivity.setResult(-1, intent);
        textRecognitionActivity.finish();
    }

    public void de() {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "translate_loading_page_show", (List) null, 2, (Object) null);
    }

    public void qw(@NotNull TextRecognitionActivity textRecognitionActivity, @NotNull List<qw> list, @NotNull String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(textRecognitionActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(str, "lanType");
        String displayLanguage = Locale.getDefault().getDisplayLanguage(Locale.ENGLISH);
        try {
            Result.Companion companion = kotlin.Result.Companion;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            int i2 = 0;
            for (T next : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                AiTranslateDataItem aiTranslateDataItem = new AiTranslateDataItem();
                aiTranslateDataItem.setTransKey(String.valueOf(i2));
                aiTranslateDataItem.setContent(((qw) next).ad());
                arrayList.add(aiTranslateDataItem);
                i2 = i3;
            }
            obj = kotlin.Result.m1155constructorimpl(yj.fe(arrayList));
        } catch (Throwable th2) {
            Result.Companion companion2 = kotlin.Result.Companion;
            obj = kotlin.Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (kotlin.Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        String str2 = (String) obj;
        if (str2 == null) {
            str2 = "";
        }
        new AiTranslateTextManager(textRecognitionActivity).qw("SC3IQL", "", displayLanguage, str2).observe(textRecognitionActivity, new qw(list, textRecognitionActivity));
    }
}
