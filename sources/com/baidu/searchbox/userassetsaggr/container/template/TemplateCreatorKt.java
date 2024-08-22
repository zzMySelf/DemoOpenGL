package com.baidu.searchbox.userassetsaggr.container.template;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.userassetsaggr.container.template.DefaultTemplateFactory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"TAG", "", "createTemplate", "Lcom/baidu/searchbox/userassetsaggr/container/template/ITemplate;", "templateType", "Lcom/baidu/searchbox/userassetsaggr/container/template/TemplateEnum;", "lib-favorHis-base_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TemplateCreator.kt */
public final class TemplateCreatorKt {
    private static final String TAG = "TemplateCreator";

    public static final ITemplate createTemplate(TemplateEnum templateType) {
        ITemplate template;
        if (templateType == null || !TemplateCreator.INSTANCE.getClassifyTemplateSet$lib_favorHis_base_release().contains(templateType)) {
            template = TemplateCreator.INSTANCE.getDefaultTemplateFactory$lib_favorHis_base_release().createTemplate(templateType);
        } else {
            template = TemplateCreator.INSTANCE.getClassifyTemplateFactory$lib_favorHis_base_release().createTemplate(templateType);
        }
        if (AppConfig.isDebug() && template != null) {
            ITemplate iTemplate = template;
            Log.d(TAG, "createTemplate: " + template.getClass().getSimpleName());
        }
        return template == null ? new DefaultTemplateFactory.FavorHisCommonTextTemplate() : template;
    }
}
