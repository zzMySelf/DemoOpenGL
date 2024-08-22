package com.baidu.searchbox.comment.input.aiimage;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.searchbox.comment.CommentRuntime;
import com.baidu.searchbox.comment.R;
import com.baidu.searchbox.comment.model.AiGtImageResultMode;
import com.baidu.searchbox.comment.model.BaseRequestResult;
import com.baidu.searchbox.comment.model.CommentAiPicConfModel;
import com.baidu.searchbox.comment.net.BDCommentRequestUtils;
import com.baidu.searchbox.comment.sp.CommentSpUtils;
import com.baidu.searchbox.comment.update.listener.CommentInputCommandListenerKt;
import com.baidu.searchbox.comment.util.CommentUtilsExtensionsKt;
import com.baidu.searchbox.comment.utils.CommentLoginUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 [2\u00020\u0001:\u0001[B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CJ&\u0010D\u001a\u00020A2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\u0018J\u0006\u0010J\u001a\u00020AJ&\u0010K\u001a\u00020A2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\u0018J&\u0010L\u001a\u00020A2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\u0018J\u000e\u0010M\u001a\u00020A2\u0006\u0010N\u001a\u00020CJ\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190*J \u0010P\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020\u00122\u000e\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010SH\u0002J\u0006\u0010T\u001a\u00020AJ\u000e\u0010U\u001a\u00020A2\u0006\u0010V\u001a\u00020\u001fJ\b\u0010W\u001a\u00020AH\u0014J\u0018\u0010X\u001a\u00020A2\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010SH\u0002J\u0010\u0010Z\u001a\u00020A2\u0006\u0010N\u001a\u00020CH\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR0\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00130\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR2\u0010\u0016\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00170\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u000e\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R,\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190*0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR&\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R \u00108\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0007\"\u0004\b:\u0010\tR\u001c\u0010;\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006\\"}, d2 = {"Lcom/baidu/searchbox/comment/input/aiimage/AiPicViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "aiGtButtonStatusData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/comment/model/AiGtImageResultMode$AiGtPicPanelButtonModel;", "getAiGtButtonStatusData", "()Landroidx/lifecycle/MutableLiveData;", "setAiGtButtonStatusData", "(Landroidx/lifecycle/MutableLiveData;)V", "aiGtImageResultMode", "Lcom/baidu/searchbox/comment/model/AiGtImageResultMode;", "getAiGtImageResultMode", "()Lcom/baidu/searchbox/comment/model/AiGtImageResultMode;", "setAiGtImageResultMode", "(Lcom/baidu/searchbox/comment/model/AiGtImageResultMode;)V", "aiPicData", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/comment/model/AiGtImageResultMode$AiGtImageModel;", "Lkotlin/collections/ArrayList;", "getAiPicData", "setAiPicData", "aiPicPreviewData", "Lkotlin/Triple;", "", "", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getAiPicPreviewData", "setAiPicPreviewData", "httpTag", "isLoading", "", "()Z", "setLoading", "(Z)V", "mCommentAiPicConfModel", "Lcom/baidu/searchbox/comment/model/CommentAiPicConfModel;", "getMCommentAiPicConfModel", "()Lcom/baidu/searchbox/comment/model/CommentAiPicConfModel;", "setMCommentAiPicConfModel", "(Lcom/baidu/searchbox/comment/model/CommentAiPicConfModel;)V", "remainedTimesData", "Lkotlin/Pair;", "getRemainedTimesData", "setRemainedTimesData", "requestCommonParams", "", "getRequestCommonParams", "()Ljava/util/Map;", "setRequestCommonParams", "(Ljava/util/Map;)V", "selectAiGtImageModel", "getSelectAiGtImageModel", "()Lcom/baidu/searchbox/comment/model/AiGtImageResultMode$AiGtImageModel;", "setSelectAiGtImageModel", "(Lcom/baidu/searchbox/comment/model/AiGtImageResultMode$AiGtImageModel;)V", "showStatusData", "getShowStatusData", "setShowStatusData", "textPromptContent", "getTextPromptContent", "()Ljava/lang/String;", "setTextPromptContent", "(Ljava/lang/String;)V", "cancelRequest", "", "status", "Lcom/baidu/searchbox/comment/model/AiGtImageResultMode$AIPanelType;", "checkAiPicRemainedTimes", "context", "Landroid/content/Context;", "prompt", "opType", "isH5", "clearKeepData", "getAfterLoginAiPic", "getAiPic", "getFillData", "type", "getLastSubPosition", "hasFillDataInRequest", "fillModel", "requestData", "", "justShowPanel", "notifyShowStatus", "isShow", "onCleared", "processRequestImageData", "images", "processRequestImageDataStatus", "Companion", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiPicViewModel.kt */
public final class AiPicViewModel extends ViewModel {
    public static final String AI_PIC_PREVIEW = "1702";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static int GUIDE_SHOW_CHAR_COUNT = 8;
    /* access modifiers changed from: private */
    public static int INPUT_PLACE_HOLDER_TIMES = 3;
    public static final int POSITION_INVAILD = -1;
    public static final String successCode = "0";
    private MutableLiveData<AiGtImageResultMode.AiGtPicPanelButtonModel> aiGtButtonStatusData = new MutableLiveData<>();
    private AiGtImageResultMode aiGtImageResultMode;
    private MutableLiveData<ArrayList<AiGtImageResultMode.AiGtImageModel>> aiPicData = new MutableLiveData<>();
    private MutableLiveData<Triple<String, Integer, SimpleDraweeView>> aiPicPreviewData = new MutableLiveData<>();
    private String httpTag = "AiPicViewModel";
    private boolean isLoading;
    private CommentAiPicConfModel mCommentAiPicConfModel;
    private MutableLiveData<Pair<String, Integer>> remainedTimesData = new MutableLiveData<>();
    private Map<String, String> requestCommonParams = new HashMap();
    private AiGtImageResultMode.AiGtImageModel selectAiGtImageModel;
    private MutableLiveData<Boolean> showStatusData = new MutableLiveData<>();
    private String textPromptContent;

    @JvmStatic
    public static final String appendAiPicParams(String str, AiPicViewModel aiPicViewModel) {
        return Companion.appendAiPicParams(str, aiPicViewModel);
    }

    @JvmStatic
    public static final boolean positionInvalid(int i2) {
        return Companion.positionInvalid(i2);
    }

    public AiPicViewModel() {
        INPUT_PLACE_HOLDER_TIMES = CommentSpUtils.getIntPreference(CommentInputCommandListenerKt.KEY_COMMENT_AI_GT_INPUT_PLACEHOLDER, INPUT_PLACE_HOLDER_TIMES);
        GUIDE_SHOW_CHAR_COUNT = CommentSpUtils.getIntPreference(CommentInputCommandListenerKt.KEY_COMMENT_AI_GT_INPUT_GUIDE_SIZE, GUIDE_SHOW_CHAR_COUNT);
    }

    public final CommentAiPicConfModel getMCommentAiPicConfModel() {
        return this.mCommentAiPicConfModel;
    }

    public final void setMCommentAiPicConfModel(CommentAiPicConfModel commentAiPicConfModel) {
        this.mCommentAiPicConfModel = commentAiPicConfModel;
    }

    public final MutableLiveData<AiGtImageResultMode.AiGtPicPanelButtonModel> getAiGtButtonStatusData() {
        return this.aiGtButtonStatusData;
    }

    public final void setAiGtButtonStatusData(MutableLiveData<AiGtImageResultMode.AiGtPicPanelButtonModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.aiGtButtonStatusData = mutableLiveData;
    }

    public final MutableLiveData<ArrayList<AiGtImageResultMode.AiGtImageModel>> getAiPicData() {
        return this.aiPicData;
    }

    public final void setAiPicData(MutableLiveData<ArrayList<AiGtImageResultMode.AiGtImageModel>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.aiPicData = mutableLiveData;
    }

    public final MutableLiveData<Triple<String, Integer, SimpleDraweeView>> getAiPicPreviewData() {
        return this.aiPicPreviewData;
    }

    public final void setAiPicPreviewData(MutableLiveData<Triple<String, Integer, SimpleDraweeView>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.aiPicPreviewData = mutableLiveData;
    }

    public final MutableLiveData<Pair<String, Integer>> getRemainedTimesData() {
        return this.remainedTimesData;
    }

    public final void setRemainedTimesData(MutableLiveData<Pair<String, Integer>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.remainedTimesData = mutableLiveData;
    }

    public final MutableLiveData<Boolean> getShowStatusData() {
        return this.showStatusData;
    }

    public final void setShowStatusData(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.showStatusData = mutableLiveData;
    }

    public final AiGtImageResultMode getAiGtImageResultMode() {
        return this.aiGtImageResultMode;
    }

    public final void setAiGtImageResultMode(AiGtImageResultMode aiGtImageResultMode2) {
        this.aiGtImageResultMode = aiGtImageResultMode2;
    }

    public final String getTextPromptContent() {
        return this.textPromptContent;
    }

    public final void setTextPromptContent(String str) {
        this.textPromptContent = str;
    }

    public final Map<String, String> getRequestCommonParams() {
        return this.requestCommonParams;
    }

    public final void setRequestCommonParams(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.requestCommonParams = map;
    }

    public final AiGtImageResultMode.AiGtImageModel getSelectAiGtImageModel() {
        return this.selectAiGtImageModel;
    }

    public final void setSelectAiGtImageModel(AiGtImageResultMode.AiGtImageModel aiGtImageModel) {
        this.selectAiGtImageModel = aiGtImageModel;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final void setLoading(boolean z) {
        this.isLoading = z;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/comment/input/aiimage/AiPicViewModel$Companion;", "", "()V", "AI_PIC_PREVIEW", "", "GUIDE_SHOW_CHAR_COUNT", "", "getGUIDE_SHOW_CHAR_COUNT", "()I", "setGUIDE_SHOW_CHAR_COUNT", "(I)V", "INPUT_PLACE_HOLDER_TIMES", "getINPUT_PLACE_HOLDER_TIMES", "setINPUT_PLACE_HOLDER_TIMES", "POSITION_INVAILD", "successCode", "appendAiPicParams", "ext", "viewModel", "Lcom/baidu/searchbox/comment/input/aiimage/AiPicViewModel;", "positionInvalid", "", "position", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AiPicViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getGUIDE_SHOW_CHAR_COUNT() {
            return AiPicViewModel.GUIDE_SHOW_CHAR_COUNT;
        }

        public final void setGUIDE_SHOW_CHAR_COUNT(int i2) {
            AiPicViewModel.GUIDE_SHOW_CHAR_COUNT = i2;
        }

        public final int getINPUT_PLACE_HOLDER_TIMES() {
            return AiPicViewModel.INPUT_PLACE_HOLDER_TIMES;
        }

        public final void setINPUT_PLACE_HOLDER_TIMES(int i2) {
            AiPicViewModel.INPUT_PLACE_HOLDER_TIMES = i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0032 A[Catch:{ all -> 0x0066 }] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0038 A[Catch:{ all -> 0x0066 }] */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String appendAiPicParams(java.lang.String r7, com.baidu.searchbox.comment.input.aiimage.AiPicViewModel r8) {
            /*
                r6 = this;
                r0 = 0
                if (r8 == 0) goto L_0x0008
                com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel r1 = r8.getSelectAiGtImageModel()
                goto L_0x0009
            L_0x0008:
                r1 = r0
            L_0x0009:
                if (r1 == 0) goto L_0x0070
                com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel r1 = r8.getSelectAiGtImageModel()
                if (r1 == 0) goto L_0x0015
                java.lang.String r0 = r1.getTaskId()
            L_0x0015:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0070
                kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0066 }
                r0 = 0
                r1 = 0
                r2 = r7
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x0066 }
                if (r2 == 0) goto L_0x002f
                boolean r2 = kotlin.text.StringsKt.isBlank(r2)     // Catch:{ all -> 0x0066 }
                if (r2 == 0) goto L_0x002d
                goto L_0x002f
            L_0x002d:
                r2 = 0
                goto L_0x0030
            L_0x002f:
                r2 = 1
            L_0x0030:
                if (r2 == 0) goto L_0x0038
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0066 }
                r2.<init>()     // Catch:{ all -> 0x0066 }
                goto L_0x003d
            L_0x0038:
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0066 }
                r2.<init>(r7)     // Catch:{ all -> 0x0066 }
            L_0x003d:
                r1 = r2
                com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel r2 = r8.getSelectAiGtImageModel()     // Catch:{ all -> 0x0066 }
                if (r2 == 0) goto L_0x005b
                java.lang.String r2 = r2.getTaskId()     // Catch:{ all -> 0x0066 }
                if (r2 == 0) goto L_0x005b
                r3 = 0
                java.lang.String r4 = "ai_image"
                java.lang.String r5 = "1"
                r1.put(r4, r5)     // Catch:{ all -> 0x0066 }
                java.lang.String r4 = "cmt_chat_id"
                r1.put(r4, r2)     // Catch:{ all -> 0x0066 }
            L_0x005b:
                java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x0066 }
                java.lang.String r3 = "jsonObject.toString()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x0066 }
                return r2
            L_0x0066:
                r0 = move-exception
                kotlin.Result$Companion r1 = kotlin.Result.Companion
                java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
                kotlin.Result.m8971constructorimpl(r0)
            L_0x0070:
                java.lang.String r0 = ""
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.comment.input.aiimage.AiPicViewModel.Companion.appendAiPicParams(java.lang.String, com.baidu.searchbox.comment.input.aiimage.AiPicViewModel):java.lang.String");
        }

        @JvmStatic
        public final boolean positionInvalid(int position) {
            return position != -1;
        }
    }

    public final void getAiPic(Context context, String prompt, String opType, String isH5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(opType, "opType");
        Intrinsics.checkNotNullParameter(isH5, "isH5");
        CommentLoginUtils.loginStatusEvent(CommentRuntime.getAppContext(), new AiPicViewModel$getAiPic$1(opType, this, context, prompt, isH5), 6, 0);
    }

    public final void getAfterLoginAiPic(Context context, String prompt, String opType, String isH5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(opType, "opType");
        Intrinsics.checkNotNullParameter(isH5, "isH5");
        if (!this.isLoading) {
            this.textPromptContent = prompt;
            this.isLoading = true;
            this.httpTag = prompt;
            BDCommentRequestUtils.aiGtPic(context, prompt, opType, isH5, this.requestCommonParams, new AiPicViewModel$$ExternalSyntheticLambda0(this), this.httpTag);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getAfterLoginAiPic$lambda-1  reason: not valid java name */
    public static final void m16807getAfterLoginAiPic$lambda1(AiPicViewModel this$0, int status, BaseRequestResult result, String errMsg) {
        Integer remainTimes;
        String toast;
        AiGtImageResultMode.AIPanelType status2;
        Integer remainTimes2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = null;
        int i2 = 0;
        if (status != 0 || result == null) {
            this$0.isLoading = false;
            CharSequence charSequence = errMsg;
            if (!(charSequence == null || charSequence.length() == 0)) {
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                if (StringsKt.contains$default((CharSequence) errMsg, (CharSequence) "Canceled", false, 2, (Object) null)) {
                    return;
                }
            }
            this$0.processRequestImageDataStatus(AiGtImageResultMode.AIPanelType.FAIL_RETRY);
            MutableLiveData<AiGtImageResultMode.AiGtPicPanelButtonModel> mutableLiveData = this$0.aiGtButtonStatusData;
            AiGtImageResultMode.AIPanelType aIPanelType = AiGtImageResultMode.AIPanelType.FAIL_RETRY;
            AiGtImageResultMode aiGtImageResultMode2 = this$0.aiGtImageResultMode;
            if (!(aiGtImageResultMode2 == null || (remainTimes = aiGtImageResultMode2.getRemainTimes()) == null)) {
                i2 = remainTimes.intValue();
            }
            String string = CommentRuntime.getAppContext().getString(R.string.comment_ai_panel_button_fail_text);
            Intrinsics.checkNotNullExpressionValue(string, "getAppContext()\n        …i_panel_button_fail_text)");
            mutableLiveData.postValue(new AiGtImageResultMode.AiGtPicPanelButtonModel(aIPanelType, i2, string));
            return;
        }
        this$0.isLoading = false;
        AiGtImageResultMode aiGtImageResultMode3 = (AiGtImageResultMode) result.getData();
        if ((aiGtImageResultMode3 != null ? aiGtImageResultMode3.getImages() : null) != null) {
            AiGtImageResultMode it = (AiGtImageResultMode) result.getData();
            if (it != null) {
                this$0.aiGtImageResultMode = it;
                this$0.processRequestImageData(it.getImages());
                return;
            }
            return;
        }
        AiGtImageResultMode.AIPanelType aIPanelType2 = AiGtImageResultMode.AIPanelType.NONE;
        AiGtImageResultMode aiGtImageResultMode4 = (AiGtImageResultMode) result.getData();
        if (aiGtImageResultMode4 == null || (toast = aiGtImageResultMode4.getToast()) == null) {
            toast = "";
        }
        AiGtImageResultMode aiGtImageResultMode5 = (AiGtImageResultMode) result.getData();
        if (aiGtImageResultMode5 != null) {
            str = aiGtImageResultMode5.getCode();
        }
        if (Intrinsics.areEqual((Object) str, (Object) AI_PIC_PREVIEW)) {
            status2 = AiGtImageResultMode.AIPanelType.PROMPT_DISABLED;
            String string2 = CommentRuntime.getAppContext().getString(R.string.comment_ai_panel_toast_disable_prompt);
            Intrinsics.checkNotNullExpressionValue(string2, "getAppContext()\n        …nel_toast_disable_prompt)");
            toast = string2;
        } else {
            status2 = AiGtImageResultMode.AIPanelType.FAIL_RETRY;
        }
        this$0.processRequestImageDataStatus(status2);
        MutableLiveData<AiGtImageResultMode.AiGtPicPanelButtonModel> mutableLiveData2 = this$0.aiGtButtonStatusData;
        AiGtImageResultMode aiGtImageResultMode6 = this$0.aiGtImageResultMode;
        if (!(aiGtImageResultMode6 == null || (remainTimes2 = aiGtImageResultMode6.getRemainTimes()) == null)) {
            i2 = remainTimes2.intValue();
        }
        mutableLiveData2.postValue(new AiGtImageResultMode.AiGtPicPanelButtonModel(status2, i2, toast));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        r4 = r4.getRemainTimes();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void justShowPanel() {
        /*
            r6 = this;
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel>> r0 = r6.aiPicData
            java.lang.Object r0 = r0.getValue()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            if (r0 == 0) goto L_0x0013
            r1 = r0
            r2 = 0
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel>> r3 = r6.aiPicData
            r3.postValue(r0)
        L_0x0013:
            androidx.lifecycle.MutableLiveData<com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtPicPanelButtonModel> r1 = r6.aiGtButtonStatusData
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtPicPanelButtonModel r2 = new com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtPicPanelButtonModel
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType r3 = com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType.ENABLED
            com.baidu.searchbox.comment.model.AiGtImageResultMode r4 = r6.aiGtImageResultMode
            if (r4 == 0) goto L_0x0028
            java.lang.Integer r4 = r4.getRemainTimes()
            if (r4 == 0) goto L_0x0028
            int r4 = r4.intValue()
            goto L_0x0029
        L_0x0028:
            r4 = 0
        L_0x0029:
            java.lang.String r5 = ""
            r2.<init>(r3, r4, r5)
            r1.postValue(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.comment.input.aiimage.AiPicViewModel.justShowPanel():void");
    }

    public final void checkAiPicRemainedTimes(Context context, String prompt, String opType, String isH5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(opType, "opType");
        Intrinsics.checkNotNullParameter(isH5, "isH5");
        if (!NetWorkUtils.isConnected(context)) {
            String string = context.getString(R.string.update_toast_bad_net);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.update_toast_bad_net)");
            CommentUtilsExtensionsKt.showToast(this, string, 0);
        } else if (!this.isLoading) {
            this.isLoading = true;
            BDCommentRequestUtils.aiGtPic(context, prompt, opType, isH5, this.requestCommonParams, new AiPicViewModel$$ExternalSyntheticLambda1(this, prompt), this.httpTag);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: checkAiPicRemainedTimes$lambda-3  reason: not valid java name */
    public static final void m16806checkAiPicRemainedTimes$lambda3(AiPicViewModel this$0, String $prompt, int status, BaseRequestResult result, String errMsg) {
        Integer remainTimes;
        Integer remainTimes2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($prompt, "$prompt");
        int i2 = 0;
        if (!(status != 0 || result == null || result.getData() == null)) {
            AiGtImageResultMode aiGtImageResultMode2 = (AiGtImageResultMode) result.getData();
            if (TextUtils.equals(aiGtImageResultMode2 != null ? aiGtImageResultMode2.getCode() : null, "0")) {
                this$0.isLoading = false;
                MutableLiveData<Pair<String, Integer>> mutableLiveData = this$0.remainedTimesData;
                AiGtImageResultMode aiGtImageResultMode3 = (AiGtImageResultMode) result.getData();
                if (!(aiGtImageResultMode3 == null || (remainTimes2 = aiGtImageResultMode3.getRemainTimes()) == null)) {
                    i2 = remainTimes2.intValue();
                }
                mutableLiveData.postValue(new Pair($prompt, Integer.valueOf(i2)));
                return;
            }
        }
        this$0.isLoading = false;
        MutableLiveData<AiGtImageResultMode.AiGtPicPanelButtonModel> mutableLiveData2 = this$0.aiGtButtonStatusData;
        AiGtImageResultMode.AIPanelType aIPanelType = AiGtImageResultMode.AIPanelType.NONE;
        AiGtImageResultMode aiGtImageResultMode4 = this$0.aiGtImageResultMode;
        if (!(aiGtImageResultMode4 == null || (remainTimes = aiGtImageResultMode4.getRemainTimes()) == null)) {
            i2 = remainTimes.intValue();
        }
        String string = CommentRuntime.getAppContext().getString(R.string.comment_ai_panel_button_fail_text);
        Intrinsics.checkNotNullExpressionValue(string, "getAppContext()\n        …i_panel_button_fail_text)");
        mutableLiveData2.postValue(new AiGtImageResultMode.AiGtPicPanelButtonModel(aIPanelType, i2, string));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getStyleMap();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void processRequestImageDataStatus(com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType r9) {
        /*
            r8 = this;
            com.baidu.searchbox.comment.model.CommentAiPicConfModel r0 = r8.mCommentAiPicConfModel
            if (r0 == 0) goto L_0x000f
            java.util.LinkedHashMap r0 = r0.getStyleMap()
            if (r0 == 0) goto L_0x000f
            int r0 = r0.size()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel>> r1 = r8.aiPicData
            java.lang.Object r1 = r1.getValue()
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            if (r1 == 0) goto L_0x0042
            int r2 = r1.size()
            r3 = 0
            int r4 = r0 + 1
            if (r2 < r4) goto L_0x0040
            int r4 = r2 + -1
            int r4 = r4 + -1
            int r5 = r2 - r0
            int r5 = r5 + -1
            if (r5 > r4) goto L_0x0040
        L_0x002d:
            java.lang.Object r6 = r1.get(r4)
            java.lang.String r7 = "dataSource[i]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel r6 = (com.baidu.searchbox.comment.model.AiGtImageResultMode.AiGtImageModel) r6
            r6.setAiPromptType(r9)
            if (r4 == r5) goto L_0x0040
            int r4 = r4 + -1
            goto L_0x002d
        L_0x0040:
        L_0x0042:
            if (r1 == 0) goto L_0x0049
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel>> r2 = r8.aiPicData
            r2.postValue(r1)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.comment.input.aiimage.AiPicViewModel.processRequestImageDataStatus(com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType):void");
    }

    public final void notifyShowStatus(boolean isShow) {
        this.showStatusData.setValue(Boolean.valueOf(isShow));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getStyleMap();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void processRequestImageData(java.util.List<com.baidu.searchbox.comment.model.AiGtImageResultMode.AiGtImageModel> r11) {
        /*
            r10 = this;
            com.baidu.searchbox.comment.model.CommentAiPicConfModel r0 = r10.mCommentAiPicConfModel
            r1 = 0
            if (r0 == 0) goto L_0x0010
            java.util.LinkedHashMap r0 = r0.getStyleMap()
            if (r0 == 0) goto L_0x0010
            int r0 = r0.size()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel>> r2 = r10.aiPicData
            java.lang.Object r2 = r2.getValue()
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r3 = 1
            if (r2 == 0) goto L_0x004a
            int r4 = r2.size()
            r5 = 0
            int r6 = r0 + 1
            if (r4 < r6) goto L_0x0048
            int r6 = r4 + -1
            int r6 = r6 - r3
            int r7 = r4 - r0
            int r7 = r7 - r3
            if (r7 > r6) goto L_0x0048
        L_0x002d:
            java.lang.Object r8 = r2.get(r6)
            java.lang.String r9 = "dataSource[i]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel r8 = (com.baidu.searchbox.comment.model.AiGtImageResultMode.AiGtImageModel) r8
            boolean r9 = r10.hasFillDataInRequest(r8, r11)
            if (r9 != 0) goto L_0x0043
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType r9 = com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType.FAIL_RETRY
            r8.setAiPromptType(r9)
        L_0x0043:
            if (r6 == r7) goto L_0x0048
            int r6 = r6 + -1
            goto L_0x002d
        L_0x0048:
        L_0x004a:
            if (r2 == 0) goto L_0x0055
            r4 = r2
            r5 = 0
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel>> r6 = r10.aiPicData
            r6.postValue(r2)
        L_0x0055:
            com.baidu.searchbox.comment.model.AiGtImageResultMode r4 = r10.aiGtImageResultMode
            if (r4 == 0) goto L_0x0067
            java.lang.Integer r4 = r4.getRemainTimes()
            if (r4 != 0) goto L_0x0060
            goto L_0x0067
        L_0x0060:
            int r4 = r4.intValue()
            if (r4 != 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r3 = r1
        L_0x0068:
            if (r3 == 0) goto L_0x006d
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType r3 = com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType.DISABLED
            goto L_0x006f
        L_0x006d:
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType r3 = com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType.ENABLED
        L_0x006f:
            androidx.lifecycle.MutableLiveData<com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtPicPanelButtonModel> r4 = r10.aiGtButtonStatusData
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtPicPanelButtonModel r5 = new com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtPicPanelButtonModel
            com.baidu.searchbox.comment.model.AiGtImageResultMode r6 = r10.aiGtImageResultMode
            if (r6 == 0) goto L_0x0083
            java.lang.Integer r6 = r6.getRemainTimes()
            if (r6 == 0) goto L_0x0083
            int r1 = r6.intValue()
        L_0x0083:
            java.lang.String r6 = ""
            r5.<init>(r3, r1, r6)
            r4.postValue(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.comment.input.aiimage.AiPicViewModel.processRequestImageData(java.util.List):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0009 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean hasFillDataInRequest(com.baidu.searchbox.comment.model.AiGtImageResultMode.AiGtImageModel r8, java.util.List<com.baidu.searchbox.comment.model.AiGtImageResultMode.AiGtImageModel> r9) {
        /*
            r7 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0060
            r1 = r9
            r2 = 0
            java.util.Iterator r3 = r1.iterator()
        L_0x0009:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x005e
            java.lang.Object r4 = r3.next()
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel r4 = (com.baidu.searchbox.comment.model.AiGtImageResultMode.AiGtImageModel) r4
            java.lang.String r5 = r4.getStyle()
            java.lang.String r6 = r8.getStyle()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x0009
            java.lang.String r5 = r4.getImage()
            r6 = 1
            if (r5 == 0) goto L_0x0039
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0034
            r5 = r6
            goto L_0x0035
        L_0x0034:
            r5 = r0
        L_0x0035:
            if (r5 != r6) goto L_0x0039
            r5 = r6
            goto L_0x003a
        L_0x0039:
            r5 = r0
        L_0x003a:
            if (r5 == 0) goto L_0x0009
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType r0 = com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType.ENABLED
            r8.setAiPromptType(r0)
            java.lang.Integer r0 = r4.getWidth()
            r8.setWidth(r0)
            java.lang.Integer r0 = r4.getHeight()
            r8.setHeight(r0)
            java.lang.String r0 = r4.getImage()
            r8.setImage(r0)
            java.lang.String r0 = r4.getTaskId()
            r8.setTaskId(r0)
            return r6
        L_0x005e:
        L_0x0060:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.comment.input.aiimage.AiPicViewModel.hasFillDataInRequest(com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel, java.util.List):boolean");
    }

    /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
        java.lang.NullPointerException
        */
    public final void getFillData(com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            java.lang.String r2 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = 0
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel>> r3 = r0.aiPicData
            java.lang.Object r2 = r3.getValue()
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType r3 = com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType.NONE
            r4 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r4)
            if (r1 == r3) goto L_0x006d
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType r3 = com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType.ENABLED
            if (r1 == r3) goto L_0x006d
            if (r2 != 0) goto L_0x0021
            goto L_0x006d
        L_0x0021:
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType r3 = com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType.LOADING
            if (r1 == r3) goto L_0x0106
            r3 = 0
            com.baidu.searchbox.comment.model.CommentAiPicConfModel r5 = r0.mCommentAiPicConfModel
            if (r5 == 0) goto L_0x0035
            java.util.LinkedHashMap r5 = r5.getStyleMap()
            if (r5 == 0) goto L_0x0035
            int r5 = r5.size()
            goto L_0x0036
        L_0x0035:
            r5 = r4
        L_0x0036:
            r3 = r5
            r5 = r2
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            r6 = 0
            int r7 = r5.size()
            int r8 = r3 + 1
            if (r7 < r8) goto L_0x006a
            int r7 = r5.size()
            int r7 = r7 + -1
            int r8 = r5.size()
            int r8 = r8 - r3
            int r8 = r8 + -1
            if (r8 > r7) goto L_0x006a
        L_0x0052:
            r9 = r2
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            java.lang.Object r9 = r9.get(r7)
            java.lang.String r10 = "cacheData[i]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel r9 = (com.baidu.searchbox.comment.model.AiGtImageResultMode.AiGtImageModel) r9
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType r10 = com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType.LOADING
            r9.setAiPromptType(r10)
            if (r7 == r8) goto L_0x006a
            int r7 = r7 + -1
            goto L_0x0052
        L_0x006a:
            goto L_0x0106
        L_0x006d:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.baidu.searchbox.comment.model.CommentAiPicConfModel r5 = r0.mCommentAiPicConfModel
            if (r5 == 0) goto L_0x00c7
            r12 = r5
            r13 = 0
            java.util.LinkedHashMap r5 = r12.getStyleMap()
            if (r5 == 0) goto L_0x00c7
            r14 = r5
            r15 = 0
            r5 = r14
            java.util.Map r5 = (java.util.Map) r5
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r16 = r5.iterator()
        L_0x008b:
            boolean r5 = r16.hasNext()
            if (r5 == 0) goto L_0x00c5
            java.lang.Object r5 = r16.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getKey()
            r17 = r6
            java.lang.String r17 = (java.lang.String) r17
            java.lang.Object r5 = r5.getValue()
            r10 = r5
            java.lang.String r10 = (java.lang.String) r10
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel r18 = new com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel
            java.lang.String r7 = ""
            java.lang.String r19 = ""
            r5 = r18
            r6 = r17
            r8 = r11
            r9 = r11
            r4 = r10
            r10 = r19
            r5.<init>(r6, r7, r8, r9, r10)
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType r6 = com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType.LOADING
            r5.setAiPromptType(r6)
            r5.setName(r4)
            r3.add(r5)
            r4 = 0
            goto L_0x008b
        L_0x00c5:
        L_0x00c7:
            r4 = r2
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            if (r4 == 0) goto L_0x00d2
            int r4 = r4.size()
            goto L_0x00d3
        L_0x00d2:
            r4 = 0
        L_0x00d3:
            if (r2 == 0) goto L_0x00e5
            r5 = 5
            if (r4 >= r5) goto L_0x00d9
            goto L_0x00e5
        L_0x00d9:
            r5 = r2
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r6 = r4 + -1
            r7 = r3
            java.util.Collection r7 = (java.util.Collection) r7
            r5.addAll(r6, r7)
            goto L_0x00e6
        L_0x00e5:
            r2 = r3
        L_0x00e6:
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType r5 = com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType.NONE
            if (r1 != r5) goto L_0x0106
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel r12 = new com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            java.lang.String r10 = ""
            r5 = r12
            r8 = r11
            r9 = r11
            r5.<init>(r6, r7, r8, r9, r10)
            r6 = 0
            r7 = 2
            r5.setViewType(r7)
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType r7 = com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType.LOADING
            r5.setAiPromptType(r7)
            r3.add(r12)
        L_0x0106:
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel>> r3 = r0.aiPicData
            r3.setValue(r2)
            androidx.lifecycle.MutableLiveData<com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtPicPanelButtonModel> r3 = r0.aiGtButtonStatusData
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtPicPanelButtonModel r4 = new com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtPicPanelButtonModel
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType r5 = com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType.LOADING
            com.baidu.searchbox.comment.model.AiGtImageResultMode r6 = r0.aiGtImageResultMode
            if (r6 == 0) goto L_0x0120
            java.lang.Integer r6 = r6.getRemainTimes()
            if (r6 == 0) goto L_0x0120
            int r6 = r6.intValue()
            goto L_0x0121
        L_0x0120:
            r6 = 0
        L_0x0121:
            java.lang.String r7 = ""
            r4.<init>(r5, r6, r7)
            r3.setValue(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.comment.input.aiimage.AiPicViewModel.getFillData(com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r2 = r2.getStyleMap();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Pair<java.lang.Integer, java.lang.Integer> getLastSubPosition() {
        /*
            r7 = this;
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtImageModel>> r0 = r7.aiPicData
            java.lang.Object r0 = r0.getValue()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            r1 = 0
            com.baidu.searchbox.comment.model.CommentAiPicConfModel r2 = r7.mCommentAiPicConfModel
            if (r2 == 0) goto L_0x0018
            java.util.LinkedHashMap r2 = r2.getStyleMap()
            if (r2 == 0) goto L_0x0018
            int r2 = r2.size()
            goto L_0x0019
        L_0x0018:
            r2 = 0
        L_0x0019:
            r1 = r2
            if (r0 == 0) goto L_0x0039
            int r2 = r0.size()
            r3 = 0
            if (r2 <= r1) goto L_0x0037
            kotlin.Pair r4 = new kotlin.Pair
            int r5 = r2 - r1
            int r5 = r5 + -1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            int r6 = r2 + -2
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r4.<init>(r5, r6)
            return r4
        L_0x0037:
        L_0x0039:
            kotlin.Pair r2 = new kotlin.Pair
            r3 = -1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.<init>(r4, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.comment.input.aiimage.AiPicViewModel.getLastSubPosition():kotlin.Pair");
    }

    public final void clearKeepData() {
        this.selectAiGtImageModel = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r4 = r4.getRemainTimes();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cancelRequest(com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType r7) {
        /*
            r6 = this;
            java.lang.String r0 = "status"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType r0 = com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType.LOADING
            r1 = 0
            if (r7 != r0) goto L_0x002a
            androidx.lifecycle.MutableLiveData<com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtPicPanelButtonModel> r0 = r6.aiGtButtonStatusData
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtPicPanelButtonModel r2 = new com.baidu.searchbox.comment.model.AiGtImageResultMode$AiGtPicPanelButtonModel
            com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType r3 = com.baidu.searchbox.comment.model.AiGtImageResultMode.AIPanelType.CANCLED
            com.baidu.searchbox.comment.model.AiGtImageResultMode r4 = r6.aiGtImageResultMode
            if (r4 == 0) goto L_0x0020
            java.lang.Integer r4 = r4.getRemainTimes()
            if (r4 == 0) goto L_0x0020
            int r4 = r4.intValue()
            goto L_0x0021
        L_0x0020:
            r4 = r1
        L_0x0021:
            java.lang.String r5 = ""
            r2.<init>(r3, r4, r5)
            r0.postValue(r2)
        L_0x002a:
            r6.isLoading = r1
            java.lang.String r0 = r6.httpTag
            com.baidu.searchbox.comment.net.BDCommentRequestUtils.cancelCommentRequest((java.lang.String) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.comment.input.aiimage.AiPicViewModel.cancelRequest(com.baidu.searchbox.comment.model.AiGtImageResultMode$AIPanelType):void");
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        BDCommentRequestUtils.cancelCommentRequest(this.httpTag);
        this.isLoading = false;
    }
}
