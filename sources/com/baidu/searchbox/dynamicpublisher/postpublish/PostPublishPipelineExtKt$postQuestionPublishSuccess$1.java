package com.baidu.searchbox.dynamicpublisher.postpublish;

import android.content.Context;
import com.baidu.searchbox.dynamicpublisher.publish.PublishModel;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.postpublish.PostPublishDSLKt;
import com.baidu.searchbox.ugc.postpublish.PostPublishParams;
import com.baidu.searchbox.ugc.postpublish.PostPublishPipeline;
import com.baidu.searchbox.ugc.postpublish.PostPublishTask;
import com.baidu.searchbox.ugc.postpublish.PostPublishTaskKt;
import com.baidu.searchbox.ugc.postpublish.PostPublishTaskList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/ugc/postpublish/PostPublishPipeline;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PostPublishPipelineExt.kt */
final class PostPublishPipelineExtKt$postQuestionPublishSuccess$1 extends Lambda implements Function1<PostPublishPipeline, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ PublishModel $publishModel;
    final /* synthetic */ PublishModels.PublishResultInfo $publishResultInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostPublishPipelineExtKt$postQuestionPublishSuccess$1(PublishModels.PublishResultInfo publishResultInfo, PublishModel publishModel, Context context) {
        super(1);
        this.$publishResultInfo = publishResultInfo;
        this.$publishModel = publishModel;
        this.$context = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((PostPublishPipeline) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(final PostPublishPipeline $this$postPublishPipeline) {
        Intrinsics.checkNotNullParameter($this$postPublishPipeline, "$this$postPublishPipeline");
        final PublishModels.PublishResultInfo publishResultInfo = this.$publishResultInfo;
        final PublishModel publishModel = this.$publishModel;
        final Context context = this.$context;
        PostPublishDSLKt.params($this$postPublishPipeline, new Function1<PostPublishParams, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((PostPublishParams) p1);
                return Unit.INSTANCE;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x003d, code lost:
                r0 = r0.data;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(com.baidu.searchbox.ugc.postpublish.PostPublishParams r3) {
                /*
                    r2 = this;
                    java.lang.String r0 = "$this$params"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    com.baidu.searchbox.ugc.model.PublishModels$PublishResultInfo r0 = r1
                    r3.setPublishResult(r0)
                    com.baidu.searchbox.dynamicpublisher.publish.PublishModel r0 = r2
                    java.lang.String r0 = r0.getCallback()
                    r3.setUgcCallback(r0)
                    com.baidu.searchbox.dynamicpublisher.publish.PublishModel r0 = r2
                    java.lang.String r0 = r0.getPublishType()
                    r3.setPublishType(r0)
                    com.baidu.searchbox.dynamicpublisher.publish.PublishModel r0 = r2
                    int r0 = r0.getShowToastType()
                    r3.setShowToast(r0)
                    com.baidu.searchbox.dynamicpublisher.publish.PublishModel r0 = r2
                    java.lang.String r0 = r0.getSourceFrom()
                    r3.setSourceFrom(r0)
                    com.baidu.searchbox.dynamicpublisher.publish.PublishModel r0 = r2
                    java.lang.String r0 = r0.getDraftKey()
                    r3.setDraftKey(r0)
                    com.baidu.searchbox.ugc.model.PublishModels$PublishResultInfo r0 = r3.getPublishResult()
                    if (r0 == 0) goto L_0x0044
                    com.baidu.searchbox.ugc.model.PublishModels$PublishData r0 = r0.data
                    if (r0 == 0) goto L_0x0044
                    java.lang.String r0 = r0.errmsg
                    goto L_0x0045
                L_0x0044:
                    r0 = 0
                L_0x0045:
                    r3.setToastContent(r0)
                    java.lang.String r0 = r3.getToastContent()
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    if (r0 == 0) goto L_0x0059
                    int r0 = r0.length()
                    if (r0 != 0) goto L_0x0057
                    goto L_0x0059
                L_0x0057:
                    r0 = 0
                    goto L_0x005a
                L_0x0059:
                    r0 = 1
                L_0x005a:
                    if (r0 == 0) goto L_0x0067
                    android.content.Context r0 = r3
                    int r1 = com.baidu.searchbox.publishercomponent.R.string.dynamic_publisher_dynamic_success
                    java.lang.String r0 = r0.getString(r1)
                    r3.setToastContent(r0)
                L_0x0067:
                    com.baidu.searchbox.dynamicpublisher.publish.PublishModel r0 = r2
                    org.json.JSONObject r0 = r0.getQuestionReply()
                    java.lang.String r0 = java.lang.String.valueOf(r0)
                    r3.setQuestionReply(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.dynamicpublisher.postpublish.PostPublishPipelineExtKt$postQuestionPublishSuccess$1.AnonymousClass1.invoke(com.baidu.searchbox.ugc.postpublish.PostPublishParams):void");
            }
        });
        PostPublishDSLKt.tasks($this$postPublishPipeline, new Function1<PostPublishTaskList, PostPublishTaskList>() {
            public final PostPublishTaskList invoke(PostPublishTaskList $this$tasks) {
                Intrinsics.checkNotNullParameter($this$tasks, "$this$tasks");
                final PostPublishPipeline postPublishPipeline = $this$postPublishPipeline;
                PostPublishDSLKt.task($this$tasks, new Function0<PostPublishTask>() {
                    public final PostPublishTask invoke() {
                        return PostPublishTaskKt.notifyQuestionPage(postPublishPipeline);
                    }
                });
                final PostPublishPipeline postPublishPipeline2 = $this$postPublishPipeline;
                PostPublishDSLKt.task($this$tasks, new Function0<PostPublishTask>() {
                    public final PostPublishTask invoke() {
                        return PostPublishTaskKt.showPublishSuccessToast(postPublishPipeline2);
                    }
                });
                final PostPublishPipeline postPublishPipeline3 = $this$postPublishPipeline;
                PostPublishDSLKt.task($this$tasks, new Function0<PostPublishTask>() {
                    public final PostPublishTask invoke() {
                        return PostPublishTaskKt.deleteDraft(postPublishPipeline3);
                    }
                });
                final PostPublishPipeline postPublishPipeline4 = $this$postPublishPipeline;
                return PostPublishDSLKt.task($this$tasks, new Function0<PostPublishTask>() {
                    public final PostPublishTask invoke() {
                        return PostPublishTaskKt.clearCacheDir(postPublishPipeline4);
                    }
                });
            }
        });
    }
}
