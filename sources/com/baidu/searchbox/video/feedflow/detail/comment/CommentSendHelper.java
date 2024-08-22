package com.baidu.searchbox.video.feedflow.detail.comment;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.comment.CommentModuleManager;
import com.baidu.searchbox.comment.CrossLayerAccessRuntime;
import com.baidu.searchbox.comment.model.CommentBaseData;
import com.baidu.searchbox.comment.net.IBDCommentExectorInterface;
import com.baidu.searchbox.comment.utils.CommentLoginUtils;
import com.baidu.searchbox.video.component.comment.CommonCommentDataModel;
import com.baidu.searchbox.video.detail.export.IVideoUiThreadUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.spswitch.emotion.Emoticons;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/comment/CommentSendHelper;", "", "()V", "Companion", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentSendHelper.kt */
public final class CommentSendHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004j\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J{\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052O\u0010\u0016\u001aK\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u000f0\u0017J,\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u0005J}\u0010#\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\n2Q\b\u0002\u0010\u0016\u001aK\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u000f0\u0017J\u0006\u0010$\u001a\u00020\u000fJ­\u0001\u0010%\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00052&\u0010'\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u00062\b\b\u0001\u0010(\u001a\u00020\u00132\b\b\u0001\u0010)\u001a\u00020\u00132O\u0010\u0016\u001aK\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u000f0\u0017H\u0002J{\u0010*\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052O\u0010\u0016\u001aK\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u000f0\u0017J}\u0010+\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\n2O\u0010\u0016\u001aK\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u000f0\u0017H\u0002J\u0018\u0010,\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010-\u001a\u00020\u0013¨\u0006."}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/comment/CommentSendHelper$Companion;", "", "()V", "buildTextCommentParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "content", "commentType", "model", "Lcom/baidu/searchbox/video/component/comment/CommonCommentDataModel;", "getRequestTag", "makeMemeImageInfo", "url", "prepareDynamicEmoji", "", "context", "Landroid/content/Context;", "sendType", "", "commentModel", "imageUrl", "callback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/baidu/searchbox/comment/model/CommentBaseData;", "result", "errMsg", "prepareImageInfo", "width", "height", "type", "prepareSendTextComment", "removeHttpRequest", "sendCommentRequest", "nid", "params", "failToastRes", "successToastRes", "sendDynamicEmoji", "sendTextComment", "showToast", "toastRes", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CommentSendHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void prepareSendTextComment$default(Companion companion, Context context, String str, int i2, CommonCommentDataModel commonCommentDataModel, Function3 function3, int i3, Object obj) {
            Function3 function32;
            if ((i3 & 16) != 0) {
                function32 = CommentSendHelper$Companion$prepareSendTextComment$1.INSTANCE;
            } else {
                function32 = function3;
            }
            companion.prepareSendTextComment(context, str, i2, commonCommentDataModel, function32);
        }

        public final void prepareSendTextComment(Context context, String content, int sendType, CommonCommentDataModel commentModel, Function3<? super Boolean, ? super CommentBaseData, ? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, "callback");
            CommentLoginUtils.loginStatusEvent(context, new CommentSendHelper$Companion$prepareSendTextComment$2(context, content, sendType, commentModel, callback), 0, sendType);
        }

        /* access modifiers changed from: private */
        public final void sendTextComment(Context context, String content, int sendType, CommonCommentDataModel commentModel, Function3<? super Boolean, ? super CommentBaseData, ? super String, Unit> callback) {
            Context context2 = context;
            Function3<? super Boolean, ? super CommentBaseData, ? super String, Unit> function3 = callback;
            boolean z = false;
            if (commentModel == null) {
                showToast(context, R.string.video_flow_send_error_tip);
                function3.invoke(false, null, "");
                return;
            }
            HashMap params = buildTextCommentParams$default(this, content, (String) null, commentModel, 2, (Object) null);
            Map map = params;
            if (map == null || map.isEmpty()) {
                z = true;
            }
            if (z) {
                showToast(context, R.string.video_flow_send_error_tip);
                function3.invoke(false, null, "");
                return;
            }
            sendCommentRequest(context, sendType, commentModel.getNid(), params, R.string.video_flow_send_error_tip, R.string.video_flow_thank_yours_comment_emoji, callback);
        }

        private final void sendCommentRequest(Context context, int type, String nid, HashMap<String, String> params, int failToastRes, int successToastRes, Function3<? super Boolean, ? super CommentBaseData, ? super String, Unit> callback) {
            if (CommentSendHelperKt.mRequestTagList == null) {
                CommentSendHelperKt.mRequestTagList = new ArrayList();
            }
            String requestTag = getRequestTag();
            ArrayList access$getMRequestTagList$p = CommentSendHelperKt.mRequestTagList;
            if (access$getMRequestTagList$p != null) {
                access$getMRequestTagList$p.add(requestTag);
            }
            int i2 = type;
            IBDCommentExectorInterface sendCommentExecutor = CrossLayerAccessRuntime.getCrossLayerAccess().getCommentExector(type);
            if (sendCommentExecutor != null) {
                Context context2 = context;
                sendCommentExecutor.send(context, true, params, new CommentSendHelper$Companion$$ExternalSyntheticLambda0(requestTag, context, successToastRes, callback, failToastRes));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: sendCommentRequest$lambda-1  reason: not valid java name */
        public static final void m11080sendCommentRequest$lambda1(String $requestTag, Context $context, int $successToastRes, Function3 $callback, int $failToastRes, int status, Object result, String errMsg) {
            String str = $requestTag;
            Intrinsics.checkNotNullParameter($requestTag, "$requestTag");
            Context context = $context;
            Intrinsics.checkNotNullParameter($context, "$context");
            Intrinsics.checkNotNullParameter($callback, "$callback");
            IVideoUiThreadUtils.Impl.get().runOnUiThread(new CommentSendHelper$Companion$$ExternalSyntheticLambda1($requestTag, status, $context, $successToastRes, $callback, result, errMsg, $failToastRes));
        }

        /* access modifiers changed from: private */
        /* renamed from: sendCommentRequest$lambda-1$lambda-0  reason: not valid java name */
        public static final void m11081sendCommentRequest$lambda1$lambda0(String $requestTag, int $status, Context $context, int $successToastRes, Function3 $callback, Object $result, String $errMsg, int $failToastRes) {
            Intrinsics.checkNotNullParameter($requestTag, "$requestTag");
            Intrinsics.checkNotNullParameter($context, "$context");
            Intrinsics.checkNotNullParameter($callback, "$callback");
            ArrayList access$getMRequestTagList$p = CommentSendHelperKt.mRequestTagList;
            if (access$getMRequestTagList$p != null) {
                access$getMRequestTagList$p.remove($requestTag);
            }
            CommentBaseData commentBaseData = null;
            if ($status == 0) {
                CommentSendHelper.Companion.showToast($context, $successToastRes);
                if ($result instanceof CommentBaseData) {
                    commentBaseData = (CommentBaseData) $result;
                }
                $callback.invoke(true, commentBaseData, $errMsg);
                return;
            }
            CommentSendHelper.Companion.showToast($context, $failToastRes);
            if ($result instanceof CommentBaseData) {
                commentBaseData = (CommentBaseData) $result;
            }
            $callback.invoke(false, commentBaseData, $errMsg);
        }

        static /* synthetic */ HashMap buildTextCommentParams$default(Companion companion, String str, String str2, CommonCommentDataModel commonCommentDataModel, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                str2 = "0";
            }
            return companion.buildTextCommentParams(str, str2, commonCommentDataModel);
        }

        private final HashMap<String, String> buildTextCommentParams(String content, String commentType, CommonCommentDataModel model) {
            if (content == null || model == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("source", model.getSource());
            hashMap.put("topic_id", model.getTopicId());
            hashMap.put("content", content);
            hashMap.put("source_type", model.getSourceType());
            hashMap.put("key", CommentUtils.INSTANCE.aeEncyptString(model.getKey()));
            String emoticons = Emoticons.getInstance().find(content);
            if (!TextUtils.isEmpty(emoticons)) {
                hashMap.put("content_rich", emoticons);
            }
            hashMap.put("type", commentType);
            hashMap.put("nid", model.getNid());
            hashMap.put("client_logid", model.getLogId());
            hashMap.put("strategy_info", model.getVideoInfoExtLog());
            return hashMap;
        }

        public final String prepareImageInfo(String url, int width, int height, String type) {
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                JSONObject json = new JSONObject();
                json.put("url", url);
                json.put("width", width);
                json.put("height", height);
                json.put("type", type);
                return json.toString();
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                Object r0 = Result.m8971constructorimpl(ResultKt.createFailure(th2));
                if (Result.m8977isFailureimpl(r0)) {
                    r0 = null;
                }
                return (String) r0;
            }
        }

        public final void showToast(Context context, int toastRes) {
            Intrinsics.checkNotNullParameter(context, "context");
            UniversalToast.makeText(context, (CharSequence) context.getString(toastRes)).show();
        }

        private final String getRequestTag() {
            StringBuilder append = new StringBuilder().append("comment_request_stimulate_comment_send");
            CommentSendHelperKt.autoAdd = CommentSendHelperKt.autoAdd + 1;
            return append.append(CommentSendHelperKt.autoAdd).toString();
        }

        public final void removeHttpRequest() {
            ArrayList requestTags = CommentSendHelperKt.mRequestTagList;
            if (requestTags != null) {
                Iterator it = requestTags.iterator();
                while (it.hasNext()) {
                    CommentModuleManager.getCommentRequest().cancelCommentRequest((String) it.next());
                }
            }
            CommentSendHelperKt.mRequestTagList = null;
            CommentSendHelperKt.autoAdd = 0;
        }

        private final String makeMemeImageInfo(String url) {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                JSONObject json = new JSONObject();
                json.put("url", url);
                json.put("auth", CommentSendHelperKt.COMMENT_IMAGE_URL_AUTH);
                json.put("regular", CommentSendHelperKt.COMMENT_IMAGE_URL_REGULAR);
                json.put("type", CommentSendHelperKt.COMMENT_IMAGE_URL_TYPE);
                obj = Result.m8971constructorimpl(json.toString());
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m8977isFailureimpl(obj)) {
                obj = null;
            }
            return prepareImageInfo((String) obj, CommentSendHelperKt.COMMENT_IMAGE_INFO_SIZE, CommentSendHelperKt.COMMENT_IMAGE_INFO_SIZE, CommentSendHelperKt.COMMENT_IMAGE_INFO_TYPE);
        }

        public final void prepareDynamicEmoji(Context context, int sendType, CommonCommentDataModel commentModel, String imageUrl, Function3<? super Boolean, ? super CommentBaseData, ? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, "callback");
            CommentLoginUtils.loginStatusEvent(context, new CommentSendHelper$Companion$prepareDynamicEmoji$1(context, sendType, commentModel, imageUrl, callback), 0, sendType);
        }

        public final void sendDynamicEmoji(Context context, int sendType, CommonCommentDataModel commentModel, String imageUrl, Function3<? super Boolean, ? super CommentBaseData, ? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, "callback");
            boolean z = false;
            if (commentModel == null) {
                showToast(context, R.string.video_flow_send_error_tip);
                callback.invoke(false, null, "");
                return;
            }
            CharSequence charSequence = imageUrl;
            if (charSequence == null || charSequence.length() == 0) {
                z = true;
            }
            if (z) {
                showToast(context, R.string.video_flow_send_error_tip);
                callback.invoke(false, null, "");
                return;
            }
            HashMap params = new HashMap();
            params.put("source", commentModel.getSource());
            params.put("topic_id", commentModel.getTopicId());
            params.put("source_type", commentModel.getSourceType());
            params.put("key", CommentUtils.INSTANCE.aeEncyptString(commentModel.getKey()));
            params.put("type", CommentSendHelperKt.COMMENT_TYPE_DYNAMIC_EXPRESSION);
            params.put("nid", commentModel.getNid());
            params.put("client_logid", commentModel.getLogId());
            params.put("image_info", makeMemeImageInfo(imageUrl));
            sendCommentRequest(context, sendType, commentModel.getNid(), params, R.string.video_flow_send_error_tip, R.string.video_flow_thank_yours_comment, new CommentSendHelper$Companion$sendDynamicEmoji$1(callback));
        }
    }
}
