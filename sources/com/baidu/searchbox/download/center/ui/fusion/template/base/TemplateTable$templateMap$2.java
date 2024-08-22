package com.baidu.searchbox.download.center.ui.fusion.template.base;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/baidu/searchbox/download/center/ui/fusion/template/base/TemplateType;", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TemplateTable.kt */
final class TemplateTable$templateMap$2 extends Lambda implements Function0<HashMap<String, TemplateType>> {
    public static final TemplateTable$templateMap$2 INSTANCE = new TemplateTable$templateMap$2();

    TemplateTable$templateMap$2() {
        super(0);
    }

    public final HashMap<String, TemplateType> invoke() {
        return MapsKt.hashMapOf(TuplesKt.to("0", TemplateType.UN_KNOW), TuplesKt.to("1000", TemplateType.CLASSIFICATION_TEMPLATE), TuplesKt.to(TemplateTypeKt.TEMPLATE_ID_RECENT, TemplateType.RECENT_TEMPLATE), TuplesKt.to(TemplateTypeKt.TEMPLATE_ID_GARBAGE_CLEAN_TEMPLATE, TemplateType.GARBAGE_CLEAN_TEMPLATE), TuplesKt.to(TemplateTypeKt.TEMPLATE_ID_PAN_TEMPLATE, TemplateType.TEMPLATE_PAN), TuplesKt.to(TemplateTypeKt.TEMPLATE_ID_BANNER_TEMPLATE, TemplateType.BANNER_TEMPLATE), TuplesKt.to("1400", TemplateType.TEMPLATE_HEAD), TuplesKt.to(TemplateTypeKt.TEMPLATE_ID_STRESS_TEMPLATE, TemplateType.STRESS_TEMPLATE), TuplesKt.to(TemplateTypeKt.TEMPLATE_ID_COMMON_TEMPLATE, TemplateType.COMMON_TEMPLATE), TuplesKt.to("document", TemplateType.DOCUMENT_TEMPLATE), TuplesKt.to("space", TemplateType.SPACE_TEMPLATE), TuplesKt.to(TemplateTypeKt.TEMPLATE_ID_SEARCH_FILE, TemplateType.SEARCH_FILE_TEMPLATE));
    }
}
