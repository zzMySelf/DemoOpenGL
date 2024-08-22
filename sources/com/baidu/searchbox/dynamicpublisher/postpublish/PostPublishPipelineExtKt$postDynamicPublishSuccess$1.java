package com.baidu.searchbox.dynamicpublisher.postpublish;

import android.content.Context;
import com.baidu.searchbox.dynamicpublisher.publish.PublishModel;
import com.baidu.searchbox.publishercomponent.R;
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
final class PostPublishPipelineExtKt$postDynamicPublishSuccess$1 extends Lambda implements Function1<PostPublishPipeline, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ PublishModel $publishModel;
    final /* synthetic */ PublishModels.PublishResultInfo $publishResultInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostPublishPipelineExtKt$postDynamicPublishSuccess$1(PublishModels.PublishResultInfo publishResultInfo, PublishModel publishModel, Context context) {
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

            public final void invoke(PostPublishParams $this$params) {
                PublishModels.PublishData publishData;
                Intrinsics.checkNotNullParameter($this$params, "$this$params");
                $this$params.setPublishResult(publishResultInfo);
                $this$params.setUgcCallback(publishModel.getCallback());
                $this$params.setPublishType(publishModel.getPublishType());
                $this$params.setShowToast(publishModel.getShowToastType());
                $this$params.setSourceFrom(publishModel.getSourceFrom());
                $this$params.setDraftKey(publishModel.getDraftKey());
                $this$params.setForwardSource(publishModel.getForwardSource());
                $this$params.setDraftKey(publishModel.getDraftKey());
                CharSequence videoPath = publishModel.getVideoPath();
                boolean z = false;
                $this$params.setVideoPublish(!(videoPath == null || videoPath.length() == 0));
                PublishModels.PublishResultInfo publishResult = $this$params.getPublishResult();
                $this$params.setToastContent((publishResult == null || (publishData = publishResult.data) == null) ? null : publishData.errmsg);
                CharSequence toastContent = $this$params.getToastContent();
                if (toastContent == null || toastContent.length() == 0) {
                    z = true;
                }
                if (z) {
                    $this$params.setToastContent(context.getString(R.string.dynamic_publisher_dynamic_success));
                }
                $this$params.setQuestionReply(String.valueOf(publishModel.getQuestionReply()));
            }
        });
        PostPublishDSLKt.tasks($this$postPublishPipeline, new Function1<PostPublishTaskList, PostPublishTaskList>() {
            public final PostPublishTaskList invoke(PostPublishTaskList $this$tasks) {
                Intrinsics.checkNotNullParameter($this$tasks, "$this$tasks");
                final PostPublishPipeline postPublishPipeline = $this$postPublishPipeline;
                PostPublishDSLKt.task($this$tasks, new Function0<PostPublishTask>() {
                    public final PostPublishTask invoke() {
                        return PostPublishTaskKt.notifyVideoPublishSuccess(postPublishPipeline);
                    }
                });
                final PostPublishPipeline postPublishPipeline2 = $this$postPublishPipeline;
                PostPublishDSLKt.task($this$tasks, new Function0<PostPublishTask>() {
                    public final PostPublishTask invoke() {
                        return PostPublishTaskKt.showGuideDialog(postPublishPipeline2);
                    }
                });
                final PostPublishPipeline postPublishPipeline3 = $this$postPublishPipeline;
                PostPublishDSLKt.task($this$tasks, new Function0<PostPublishTask>() {
                    public final PostPublishTask invoke() {
                        return PostPublishTaskKt.handleSuccessCallback(postPublishPipeline3);
                    }
                });
                final PostPublishPipeline postPublishPipeline4 = $this$postPublishPipeline;
                PostPublishDSLKt.task($this$tasks, new Function0<PostPublishTask>() {
                    public final PostPublishTask invoke() {
                        return PostPublishTaskKt.showPublishSuccessToast(postPublishPipeline4);
                    }
                });
                final PostPublishPipeline postPublishPipeline5 = $this$postPublishPipeline;
                PostPublishDSLKt.task($this$tasks, new Function0<PostPublishTask>() {
                    public final PostPublishTask invoke() {
                        return PostPublishTaskKt.deleteDraft(postPublishPipeline5);
                    }
                });
                final PostPublishPipeline postPublishPipeline6 = $this$postPublishPipeline;
                PostPublishDSLKt.task($this$tasks, new Function0<PostPublishTask>() {
                    public final PostPublishTask invoke() {
                        return PostPublishTaskKt.clearCacheDir(postPublishPipeline6);
                    }
                });
                final PostPublishPipeline postPublishPipeline7 = $this$postPublishPipeline;
                return PostPublishDSLKt.task($this$tasks, new Function0<PostPublishTask>() {
                    public final PostPublishTask invoke() {
                        return PostPublishTaskKt.checkAccountMedal(postPublishPipeline7, true);
                    }
                });
            }
        });
    }
}
