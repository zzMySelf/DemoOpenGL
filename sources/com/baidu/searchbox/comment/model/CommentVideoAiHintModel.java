package com.baidu.searchbox.comment.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u0000 62\u00020\u0001:\u00043456B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J3\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001cJ\u0013\u0010*\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010,\u001a\u00020\u0016J\t\u0010-\u001a\u00020\u001cHÖ\u0001J,\u0010.\u001a\u0004\u0018\u00010\u00032\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u00100\u001a\u0004\u0018\u000101J\t\u00102\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012¨\u00067"}, d2 = {"Lcom/baidu/searchbox/comment/model/CommentVideoAiHintModel;", "", "nid", "", "topicId", "commentList", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCommentList", "()Ljava/util/List;", "setCommentList", "(Ljava/util/List;)V", "commentListModels", "Lcom/baidu/searchbox/comment/model/CommentVideoAiHintModel$AiHintModel;", "getCommentListModels", "setCommentListModels", "currentShowAiHint", "getCurrentShowAiHint", "()Ljava/lang/String;", "setCurrentShowAiHint", "(Ljava/lang/String;)V", "isPublishAfterFlag", "", "()Z", "setPublishAfterFlag", "(Z)V", "getNid", "source", "", "getSource", "()I", "setSource", "(I)V", "getTopicId", "component1", "component2", "component3", "copy", "copyCommentListModels", "coverCommentListModels", "", "type", "equals", "other", "hasAllPublished", "hashCode", "toCommentJsonString", "secondCommentList", "extraJSONObject", "Lorg/json/JSONObject;", "toString", "AiHintModel", "CommentAiHintSource", "CommentAiHintType", "Companion", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentVideoAiHintModel.kt */
public final class CommentVideoAiHintModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private List<String> commentList;
    private List<AiHintModel> commentListModels;
    private String currentShowAiHint;
    private boolean isPublishAfterFlag;
    private final String nid;
    private int source;
    private final String topicId;

    public CommentVideoAiHintModel() {
        this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CommentVideoAiHintModel copy$default(CommentVideoAiHintModel commentVideoAiHintModel, String str, String str2, List<String> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = commentVideoAiHintModel.nid;
        }
        if ((i2 & 2) != 0) {
            str2 = commentVideoAiHintModel.topicId;
        }
        if ((i2 & 4) != 0) {
            list = commentVideoAiHintModel.commentList;
        }
        return commentVideoAiHintModel.copy(str, str2, list);
    }

    @JvmStatic
    public static final CommentVideoAiHintModel parse(String str) {
        return Companion.parse(str);
    }

    @JvmStatic
    public static final BaseRequestResult<List<CommentVideoAiHintModel>> responseParse(String str) {
        return Companion.responseParse(str);
    }

    public final String component1() {
        return this.nid;
    }

    public final String component2() {
        return this.topicId;
    }

    public final List<String> component3() {
        return this.commentList;
    }

    public final CommentVideoAiHintModel copy(String str, String str2, List<String> list) {
        return new CommentVideoAiHintModel(str, str2, list);
    }

    public int hashCode() {
        String str = this.nid;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.topicId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.commentList;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "CommentVideoAiHintModel(nid=" + this.nid + ", topicId=" + this.topicId + ", commentList=" + this.commentList + ')';
    }

    public CommentVideoAiHintModel(String nid2, String topicId2, List<String> commentList2) {
        this.nid = nid2;
        this.topicId = topicId2;
        this.commentList = commentList2;
        this.source = 1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommentVideoAiHintModel(String str, String str2, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : list);
    }

    public final String getNid() {
        return this.nid;
    }

    public final String getTopicId() {
        return this.topicId;
    }

    public final List<String> getCommentList() {
        return this.commentList;
    }

    public final void setCommentList(List<String> list) {
        this.commentList = list;
    }

    public final String getCurrentShowAiHint() {
        return this.currentShowAiHint;
    }

    public final void setCurrentShowAiHint(String str) {
        this.currentShowAiHint = str;
    }

    public final boolean isPublishAfterFlag() {
        return this.isPublishAfterFlag;
    }

    public final void setPublishAfterFlag(boolean z) {
        this.isPublishAfterFlag = z;
    }

    public final List<AiHintModel> getCommentListModels() {
        return this.commentListModels;
    }

    public final void setCommentListModels(List<AiHintModel> list) {
        this.commentListModels = list;
    }

    public final int getSource() {
        return this.source;
    }

    public final void setSource(int i2) {
        this.source = i2;
    }

    public final void coverCommentListModels(int type) {
        List<AiHintModel> list;
        List<String> list2 = this.commentList;
        if (list2 != null) {
            Iterable $this$mapIndexed$iv = list2;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexed$iv) {
                int index$iv$iv2 = index$iv$iv + 1;
                if (index$iv$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                destination$iv$iv.add(new AiHintModel((String) item$iv$iv, type, false, index$iv$iv));
                index$iv$iv = index$iv$iv2;
            }
            list = (List) destination$iv$iv;
        } else {
            list = null;
        }
        this.commentListModels = list;
    }

    public final List<AiHintModel> copyCommentListModels() {
        ArrayList copes = new ArrayList();
        List<AiHintModel> $this$forEach$iv = this.commentListModels;
        if ($this$forEach$iv != null) {
            for (AiHintModel aiHintModel : $this$forEach$iv) {
                copes.add(new AiHintModel(aiHintModel.getComment(), aiHintModel.getType(), aiHintModel.getPublished(), aiHintModel.getIndex()));
            }
        }
        return copes;
    }

    public final boolean hasAllPublished() {
        List<AiHintModel> list = this.commentListModels;
        if (list == null) {
            return true;
        }
        Iterable<AiHintModel> $this$all$iv = list;
        if (($this$all$iv instanceof Collection) && ((Collection) $this$all$iv).isEmpty()) {
            return true;
        }
        for (AiHintModel it : $this$all$iv) {
            if (!it.getPublished()) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object other) {
        return (other instanceof CommentVideoAiHintModel) && Intrinsics.areEqual((Object) ((CommentVideoAiHintModel) other).nid, (Object) this.nid);
    }

    @Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/comment/model/CommentVideoAiHintModel$CommentAiHintType;", "", "Companion", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* compiled from: CommentVideoAiHintModel.kt */
    public @interface CommentAiHintType {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int OFFLINE = 1;
        public static final int ON_LINE = 2;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/comment/model/CommentVideoAiHintModel$CommentAiHintType$Companion;", "", "()V", "OFFLINE", "", "ON_LINE", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: CommentVideoAiHintModel.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int OFFLINE = 1;
            public static final int ON_LINE = 2;

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/comment/model/CommentVideoAiHintModel$CommentAiHintSource;", "", "Companion", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* compiled from: CommentVideoAiHintModel.kt */
    public @interface CommentAiHintSource {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int SOURCE_OFFLINE = 1;
        public static final int SOURCE_ONLINE = 2;
        public static final int SOURCE_PUBLISH = 5;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/comment/model/CommentVideoAiHintModel$CommentAiHintSource$Companion;", "", "()V", "SOURCE_OFFLINE", "", "SOURCE_ONLINE", "SOURCE_PUBLISH", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: CommentVideoAiHintModel.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int SOURCE_OFFLINE = 1;
            public static final int SOURCE_ONLINE = 2;
            public static final int SOURCE_PUBLISH = 5;

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0002J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/comment/model/CommentVideoAiHintModel$AiHintModel;", "", "comment", "", "type", "", "published", "", "index", "(Ljava/lang/String;IZI)V", "getComment", "()Ljava/lang/String;", "getIndex", "()I", "getPublished", "()Z", "setPublished", "(Z)V", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toJsonObject", "Lorg/json/JSONObject;", "toString", "Companion", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CommentVideoAiHintModel.kt */
    public static final class AiHintModel {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String comment;
        private final int index;
        private boolean published;
        private final int type;

        public static /* synthetic */ AiHintModel copy$default(AiHintModel aiHintModel, String str, int i2, boolean z, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = aiHintModel.comment;
            }
            if ((i4 & 2) != 0) {
                i2 = aiHintModel.type;
            }
            if ((i4 & 4) != 0) {
                z = aiHintModel.published;
            }
            if ((i4 & 8) != 0) {
                i3 = aiHintModel.index;
            }
            return aiHintModel.copy(str, i2, z, i3);
        }

        public final String component1() {
            return this.comment;
        }

        public final int component2() {
            return this.type;
        }

        public final boolean component3() {
            return this.published;
        }

        public final int component4() {
            return this.index;
        }

        public final AiHintModel copy(String str, int i2, boolean z, int i3) {
            return new AiHintModel(str, i2, z, i3);
        }

        public int hashCode() {
            String str = this.comment;
            int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.type)) * 31;
            boolean z = this.published;
            if (z) {
                z = true;
            }
            return ((hashCode + (z ? 1 : 0)) * 31) + Integer.hashCode(this.index);
        }

        public String toString() {
            return "AiHintModel(comment=" + this.comment + ", type=" + this.type + ", published=" + this.published + ", index=" + this.index + ')';
        }

        public AiHintModel(String comment2, int type2, boolean published2, int index2) {
            this.comment = comment2;
            this.type = type2;
            this.published = published2;
            this.index = index2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AiHintModel(String str, int i2, boolean z, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? null : str, (i4 & 2) != 0 ? 1 : i2, (i4 & 4) != 0 ? false : z, i3);
        }

        public final String getComment() {
            return this.comment;
        }

        public final int getIndex() {
            return this.index;
        }

        public final boolean getPublished() {
            return this.published;
        }

        public final int getType() {
            return this.type;
        }

        public final void setPublished(boolean z) {
            this.published = z;
        }

        public final JSONObject toJsonObject() {
            try {
                Result.Companion companion = Result.Companion;
                AiHintModel $this$toJsonObject_u24lambda_u2d0 = this;
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("comment", $this$toJsonObject_u24lambda_u2d0.comment);
                jsonObject.put("type", $this$toJsonObject_u24lambda_u2d0.type);
                jsonObject.put("published", $this$toJsonObject_u24lambda_u2d0.published);
                jsonObject.put("index", $this$toJsonObject_u24lambda_u2d0.index);
                return jsonObject;
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
                return null;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/comment/model/CommentVideoAiHintModel$AiHintModel$Companion;", "", "()V", "jsonToModel", "Lcom/baidu/searchbox/comment/model/CommentVideoAiHintModel$AiHintModel;", "jsonObject", "Lorg/json/JSONObject;", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: CommentVideoAiHintModel.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final AiHintModel jsonToModel(JSONObject jsonObject) {
                try {
                    Result.Companion companion = Result.Companion;
                    Companion companion2 = this;
                    if (jsonObject != null) {
                        JSONObject it = jsonObject;
                        return new AiHintModel(it.optString("comment"), it.optInt("type"), it.optBoolean("published"), it.optInt("index"));
                    }
                    Result.m8971constructorimpl((Object) null);
                    return null;
                } catch (Throwable th2) {
                    Result.Companion companion3 = Result.Companion;
                    Result.m8971constructorimpl(ResultKt.createFailure(th2));
                }
            }
        }

        public boolean equals(Object other) {
            return (other instanceof AiHintModel) && Intrinsics.areEqual((Object) ((AiHintModel) other).comment, (Object) this.comment);
        }
    }

    public final String toCommentJsonString(List<String> secondCommentList, String currentShowAiHint2, JSONObject extraJSONObject) {
        try {
            Result.Companion companion = Result.Companion;
            CommentVideoAiHintModel $this$toCommentJsonString_u24lambda_u2d7 = this;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nid", $this$toCommentJsonString_u24lambda_u2d7.nid);
            JSONArray jsonArray = new JSONArray();
            List<String> $this$forEach$iv = $this$toCommentJsonString_u24lambda_u2d7.commentList;
            if ($this$forEach$iv != null) {
                for (String comment : $this$forEach$iv) {
                    jsonArray.put(comment);
                    jsonObject.put("comment_list", jsonArray);
                }
            }
            JSONArray listModelsJsonArray = new JSONArray();
            List<AiHintModel> $this$forEach$iv2 = $this$toCommentJsonString_u24lambda_u2d7.commentListModels;
            if ($this$forEach$iv2 != null) {
                for (AiHintModel model : $this$forEach$iv2) {
                    listModelsJsonArray.put(model.toJsonObject());
                    jsonObject.put("comment_list_models", listModelsJsonArray);
                }
            }
            if (currentShowAiHint2 != null) {
                jsonObject.put("current_comment", currentShowAiHint2);
            }
            if (extraJSONObject != null) {
                jsonObject.put("ext", extraJSONObject);
            }
            return jsonObject.toString();
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/comment/model/CommentVideoAiHintModel$Companion;", "", "()V", "parse", "Lcom/baidu/searchbox/comment/model/CommentVideoAiHintModel;", "response", "", "responseParse", "Lcom/baidu/searchbox/comment/model/BaseRequestResult;", "", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CommentVideoAiHintModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BaseRequestResult<List<CommentVideoAiHintModel>> responseParse(String response) {
            Companion $this$responseParse_u24lambda_u2d2;
            JSONArray jsonArray;
            String str = response;
            Intrinsics.checkNotNullParameter(str, "response");
            BaseRequestResult requestResult = new BaseRequestResult();
            try {
                Result.Companion companion = Result.Companion;
                Companion $this$responseParse_u24lambda_u2d22 = this;
                JSONObject jsonObject = new JSONObject(str);
                requestResult.parseBaseFiled(jsonObject);
                JSONObject it = jsonObject.optJSONObject("data");
                if (it != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "optJSONObject(\"data\")");
                    if (it.has("list")) {
                        ArrayList hintModels = new ArrayList();
                        JSONArray jsonArray2 = it.optJSONArray("list");
                        if (jsonArray2 != null) {
                            int i2 = 0;
                            int length = jsonArray2.length();
                            while (i2 < length) {
                                JSONObject imageObject = jsonArray2.optJSONObject(i2);
                                if (imageObject != null) {
                                    String nid = imageObject.optString("nid");
                                    String topicId = imageObject.optString("topic_id");
                                    JSONArray commentListJsonArray = imageObject.optJSONArray("comment_list");
                                    ArrayList commentList = new ArrayList();
                                    if (commentListJsonArray != null) {
                                        jsonArray = jsonArray2;
                                        Intrinsics.checkNotNullExpressionValue(commentListJsonArray, "commentListJsonArray");
                                        JSONArray arr = commentListJsonArray;
                                        $this$responseParse_u24lambda_u2d2 = $this$responseParse_u24lambda_u2d22;
                                        int j2 = 0;
                                        for (int length2 = arr.length(); j2 < length2; length2 = length2) {
                                            commentList.add(arr.optString(j2));
                                            j2++;
                                        }
                                    } else {
                                        jsonArray = jsonArray2;
                                        $this$responseParse_u24lambda_u2d2 = $this$responseParse_u24lambda_u2d22;
                                    }
                                    hintModels.add(new CommentVideoAiHintModel(nid, topicId, commentList));
                                } else {
                                    jsonArray = jsonArray2;
                                    $this$responseParse_u24lambda_u2d2 = $this$responseParse_u24lambda_u2d22;
                                }
                                i2++;
                                String str2 = response;
                                jsonArray2 = jsonArray;
                                $this$responseParse_u24lambda_u2d22 = $this$responseParse_u24lambda_u2d2;
                            }
                            Companion companion2 = $this$responseParse_u24lambda_u2d22;
                        } else {
                            Companion companion3 = $this$responseParse_u24lambda_u2d22;
                        }
                        requestResult.setData(hintModels);
                    }
                }
                return requestResult;
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
                return requestResult;
            }
        }

        @JvmStatic
        public final CommentVideoAiHintModel parse(String response) {
            String str = response;
            Intrinsics.checkNotNullParameter(str, "response");
            try {
                Result.Companion companion = Result.Companion;
                Companion $this$parse_u24lambda_u2d7 = this;
                JSONObject jsonObject = new JSONObject(str);
                String nid = jsonObject.optString("nid");
                String topicId = jsonObject.optString("topic_id");
                String currentHint = jsonObject.optString("current_comment");
                JSONArray commentListJsonArray = jsonObject.optJSONArray("comment_list");
                ArrayList commentList = new ArrayList();
                if (commentListJsonArray != null) {
                    Intrinsics.checkNotNullExpressionValue(commentListJsonArray, "commentListJsonArray");
                    JSONArray arr = commentListJsonArray;
                    int length = arr.length();
                    for (int j2 = 0; j2 < length; j2++) {
                        commentList.add(arr.optString(j2));
                    }
                }
                JSONArray commentListModelStr = jsonObject.optJSONArray("comment_list_models");
                ArrayList commentModels = new ArrayList();
                if (commentListModelStr != null) {
                    Intrinsics.checkNotNullExpressionValue(commentListModelStr, "commentListModelStr");
                    JSONArray listModels = commentListModelStr;
                    int j3 = 0;
                    int length2 = listModels.length();
                    while (j3 < length2) {
                        Companion $this$parse_u24lambda_u2d72 = $this$parse_u24lambda_u2d7;
                        AiHintModel it = AiHintModel.Companion.jsonToModel(listModels.optJSONObject(j3));
                        if (it != null) {
                            commentModels.add(it);
                        }
                        j3++;
                        $this$parse_u24lambda_u2d7 = $this$parse_u24lambda_u2d72;
                    }
                }
                CommentVideoAiHintModel commentVideoAiHintModel = new CommentVideoAiHintModel(nid, topicId, commentList);
                CommentVideoAiHintModel $this$parse_u24lambda_u2d7_u24lambda_u2d6 = commentVideoAiHintModel;
                $this$parse_u24lambda_u2d7_u24lambda_u2d6.setCurrentShowAiHint(currentHint);
                $this$parse_u24lambda_u2d7_u24lambda_u2d6.setCommentListModels(commentModels);
                return commentVideoAiHintModel;
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
                return null;
            }
        }
    }
}
