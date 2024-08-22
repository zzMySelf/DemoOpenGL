package com.baidu.searchbox.aisearch.config.resources;

import android.os.MessageQueue;
import android.util.Log;
import com.baidu.searchbox.aisearch.utils.resutils.CloundFileManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/MessageQueue$IdleHandler;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AISearchResConfig.kt */
final class AISearchResConfig$clearFileIdleHandler$2 extends Lambda implements Function0<MessageQueue.IdleHandler> {
    public static final AISearchResConfig$clearFileIdleHandler$2 INSTANCE = new AISearchResConfig$clearFileIdleHandler$2();

    AISearchResConfig$clearFileIdleHandler$2() {
        super(0);
    }

    public final MessageQueue.IdleHandler invoke() {
        return new AISearchResConfig$clearFileIdleHandler$2$$ExternalSyntheticLambda0();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final boolean m15904invoke$lambda2() {
        List<ResItemModel> afxList;
        try {
            Result.Companion companion = Result.Companion;
            AISearchResModel resModel = AISearchResConfig.INSTANCE.getAISearchResModel();
            List list = null;
            if (AISearchResConfigKt.DEBUG) {
                Log.d("AISearchResConfig", "clearFileIdleHandler: " + (resModel != null ? resModel.toString() : null));
            }
            CloundFileManager cloundFileManager = CloundFileManager.INSTANCE;
            if (!(resModel == null || (afxList = resModel.getAfxList()) == null)) {
                Iterable<ResItemModel> $this$map$iv = afxList;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (ResItemModel it : $this$map$iv) {
                    destination$iv$iv.add(it.getFileName());
                }
                list = (List) destination$iv$iv;
            }
            cloundFileManager.handleOfflineRes$lib_aisearch_impl_release(list);
            Result.m8971constructorimpl(Unit.INSTANCE);
            return false;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
            return false;
        }
    }
}
