package com.baidu.searchbox.download.center.ui.fusion.manager;

import com.baidu.searchbox.download.center.ui.fusion.manager.remote.FileTemplateDataServerFetcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/download/center/ui/fusion/manager/remote/FileTemplateDataServerFetcher;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileTemplateDataManager.kt */
final class FileTemplateDataManager$fileTemplateDataServerFetcher$2 extends Lambda implements Function0<FileTemplateDataServerFetcher> {
    public static final FileTemplateDataManager$fileTemplateDataServerFetcher$2 INSTANCE = new FileTemplateDataManager$fileTemplateDataServerFetcher$2();

    FileTemplateDataManager$fileTemplateDataServerFetcher$2() {
        super(0);
    }

    public final FileTemplateDataServerFetcher invoke() {
        return new FileTemplateDataServerFetcher();
    }
}
