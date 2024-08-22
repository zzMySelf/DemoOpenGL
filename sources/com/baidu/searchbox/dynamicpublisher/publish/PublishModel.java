package com.baidu.searchbox.dynamicpublisher.publish;

import com.baidu.searchbox.ugc.category.model.CategoryLabelValue;
import com.baidu.searchbox.ugc.model.HttpRequestPublishModule;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.model.ImageUploadModel;
import com.baidu.searchbox.ugc.model.ProgressBarConfigModel;
import com.baidu.searchbox.ugc.model.ReferenceDt;
import com.baidu.searchbox.ugc.model.TopicItem;
import com.baidu.searchbox.ugc.model.UGCTarget;
import com.baidu.ugc.position.model.LocationModel;
import com.baidu.ugc.position.model.PoiModel;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010·\u0001\u001a\u00020\u0003HÆ\u0003J\u0014\u0010¸\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0015\u0010¹\u0001\u001a\u00020U2\t\u0010º\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010»\u0001\u001a\u00020\u0013HÖ\u0001J\n\u0010¼\u0001\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\u0004R\u001c\u0010-\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\u0004R\u001c\u00100\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\u0004R\u001c\u00103\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\u0004R\u001c\u00106\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\u0004R\u001c\u00109\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u0010\u0004R\u001c\u0010<\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0007\"\u0004\b>\u0010\u0004R\u001c\u0010?\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\u0004R(\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010D0CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR*\u0010I\u001a\u0012\u0012\u0004\u0012\u00020K0Jj\b\u0012\u0004\u0012\u00020K`LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0007\"\u0004\bS\u0010\u0004R\u001a\u0010T\u001a\u00020UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010V\"\u0004\bZ\u0010XR\u001a\u0010[\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0015\"\u0004\b\\\u0010\u0017R\u001c\u0010]\u001a\u0004\u0018\u00010^X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001c\u0010c\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0007\"\u0004\be\u0010\u0004R*\u0010f\u001a\u0012\u0012\u0004\u0012\u00020g0Jj\b\u0012\u0004\u0012\u00020g`LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010N\"\u0004\bi\u0010PR\u001c\u0010j\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0007\"\u0004\bl\u0010\u0004R\u001c\u0010m\u001a\u0004\u0018\u00010nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001c\u0010s\u001a\u0004\u0018\u00010tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001c\u0010y\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u0007\"\u0004\b{\u0010\u0004R\u001c\u0010|\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010!\"\u0004\b~\u0010#R\u001e\u0010\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0007\"\u0005\b\u0001\u0010\u0004R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020UX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010V\"\u0005\b\u0001\u0010XR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010!\"\u0005\b\u0001\u0010#R\u001d\u0010\u0001\u001a\u00020\u0013X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0015\"\u0005\b\u0001\u0010\u0017R\u0012\u0010\u0002\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\u0007R\u001d\u0010\u0001\u001a\u00020\u0013X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0015\"\u0005\b\u0001\u0010\u0017R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0007\"\u0005\b\u0001\u0010\u0004R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010!\"\u0005\b \u0001\u0010#R\u001f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010\u0007\"\u0005\b£\u0001\u0010\u0004R\u001d\u0010¤\u0001\u001a\u00020\u0013X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010\u0015\"\u0005\b¦\u0001\u0010\u0017R\u001f\u0010§\u0001\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010\u0007\"\u0005\b©\u0001\u0010\u0004R\u001f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010\u0007\"\u0005\b¬\u0001\u0010\u0004R\u001f\u0010­\u0001\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010\u0007\"\u0005\b¯\u0001\u0010\u0004R\u0015\u0010°\u0001\u001a\u00030±\u0001¢\u0006\n\n\u0000\u001a\u0006\b²\u0001\u0010³\u0001R\u001f\u0010´\u0001\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010\u0007\"\u0005\b¶\u0001\u0010\u0004¨\u0006½\u0001"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/publish/PublishModel;", "", "sourceFrom", "", "(Ljava/lang/String;)V", "aiCreationCardId", "getAiCreationCardId", "()Ljava/lang/String;", "setAiCreationCardId", "aiCreationCardType", "getAiCreationCardType", "setAiCreationCardType", "aiPublisherSuccessGuide", "getAiPublisherSuccessGuide", "setAiPublisherSuccessGuide", "aiStatement", "getAiStatement", "setAiStatement", "asyncUpload", "", "getAsyncUpload", "()I", "setAsyncUpload", "(I)V", "businessId", "getBusinessId", "setBusinessId", "callback", "getCallback", "setCallback", "campaign", "Lorg/json/JSONObject;", "getCampaign", "()Lorg/json/JSONObject;", "setCampaign", "(Lorg/json/JSONObject;)V", "category", "Lcom/baidu/searchbox/ugc/category/model/CategoryLabelValue;", "getCategory", "()Lcom/baidu/searchbox/ugc/category/model/CategoryLabelValue;", "setCategory", "(Lcom/baidu/searchbox/ugc/category/model/CategoryLabelValue;)V", "centerInfo", "getCenterInfo", "setCenterInfo", "content", "getContent", "setContent", "displayScene", "getDisplayScene", "setDisplayScene", "draftKey", "getDraftKey", "setDraftKey", "dynamicTitle", "getDynamicTitle", "setDynamicTitle", "extInfo", "getExtInfo", "setExtInfo", "forwardIsComment", "getForwardIsComment", "setForwardIsComment", "forwardSource", "getForwardSource", "setForwardSource", "imageUrls", "", "Lcom/baidu/searchbox/ugc/model/ImageUploadModel;", "getImageUrls", "()Ljava/util/Map;", "setImageUrls", "(Ljava/util/Map;)V", "images", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "Lkotlin/collections/ArrayList;", "getImages", "()Ljava/util/ArrayList;", "setImages", "(Ljava/util/ArrayList;)V", "imgGenTxtAiAnchorPointId", "getImgGenTxtAiAnchorPointId", "setImgGenTxtAiAnchorPointId", "isAiPublisher", "", "()Z", "setAiPublisher", "(Z)V", "isFromAiCard", "setFromAiCard", "isUgcTextTemplate", "setUgcTextTemplate", "locationModel", "Lcom/baidu/ugc/position/model/LocationModel;", "getLocationModel", "()Lcom/baidu/ugc/position/model/LocationModel;", "setLocationModel", "(Lcom/baidu/ugc/position/model/LocationModel;)V", "meddleGroupId", "getMeddleGroupId", "setMeddleGroupId", "newTopics", "Lcom/baidu/searchbox/ugc/model/TopicItem;", "getNewTopics", "setNewTopics", "nid", "getNid", "setNid", "poiModel", "Lcom/baidu/ugc/position/model/PoiModel;", "getPoiModel", "()Lcom/baidu/ugc/position/model/PoiModel;", "setPoiModel", "(Lcom/baidu/ugc/position/model/PoiModel;)V", "progressBarConfigModel", "Lcom/baidu/searchbox/ugc/model/ProgressBarConfigModel;", "getProgressBarConfigModel", "()Lcom/baidu/searchbox/ugc/model/ProgressBarConfigModel;", "setProgressBarConfigModel", "(Lcom/baidu/searchbox/ugc/model/ProgressBarConfigModel;)V", "publishType", "getPublishType", "setPublishType", "questionReply", "getQuestionReply", "setQuestionReply", "questionText", "getQuestionText", "setQuestionText", "referenceDt", "Lcom/baidu/searchbox/ugc/model/ReferenceDt;", "getReferenceDt", "()Lcom/baidu/searchbox/ugc/model/ReferenceDt;", "setReferenceDt", "(Lcom/baidu/searchbox/ugc/model/ReferenceDt;)V", "secondEdit", "getSecondEdit", "setSecondEdit", "shop", "getShop", "setShop", "showToastType", "getShowToastType", "setShowToastType", "getSourceFrom", "sourceType", "getSourceType", "setSourceType", "target", "Lcom/baidu/searchbox/ugc/model/UGCTarget;", "getTarget", "()Lcom/baidu/searchbox/ugc/model/UGCTarget;", "setTarget", "(Lcom/baidu/searchbox/ugc/model/UGCTarget;)V", "taskOrigin", "getTaskOrigin", "setTaskOrigin", "tiaozhanInfo", "getTiaozhanInfo", "setTiaozhanInfo", "title", "getTitle", "setTitle", "topicsRule", "getTopicsRule", "setTopicsRule", "userType", "getUserType", "setUserType", "videoCover", "getVideoCover", "setVideoCover", "videoPath", "getVideoPath", "setVideoPath", "videoUploadModel", "Lcom/baidu/searchbox/ugc/model/HttpRequestPublishModule$VideoUploadModel;", "getVideoUploadModel", "()Lcom/baidu/searchbox/ugc/model/HttpRequestPublishModule$VideoUploadModel;", "ymgToken", "getYmgToken", "setYmgToken", "component1", "copy", "equals", "other", "hashCode", "toString", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PublishModel.kt */
public final class PublishModel {
    private String aiCreationCardId;
    private String aiCreationCardType;
    private String aiPublisherSuccessGuide;
    private String aiStatement;
    private int asyncUpload;
    private String businessId;
    private String callback;
    private JSONObject campaign;
    private CategoryLabelValue category;
    private String centerInfo;
    private String content;
    private String displayScene;
    private String draftKey;
    private String dynamicTitle;
    private String extInfo;
    private String forwardIsComment;
    private String forwardSource;
    private Map<String, ? extends ImageUploadModel> imageUrls = MapsKt.emptyMap();
    private ArrayList<ImageStruct> images = new ArrayList<>();
    private String imgGenTxtAiAnchorPointId;
    private boolean isAiPublisher;
    private boolean isFromAiCard;
    private int isUgcTextTemplate;
    private LocationModel locationModel;
    private String meddleGroupId;
    private ArrayList<TopicItem> newTopics = new ArrayList<>();
    private String nid;
    private PoiModel poiModel;
    private ProgressBarConfigModel progressBarConfigModel;
    private String publishType;
    private JSONObject questionReply;
    private String questionText;
    private ReferenceDt referenceDt;
    private boolean secondEdit;
    private JSONObject shop;
    private int showToastType;
    private final String sourceFrom;
    private int sourceType;
    private UGCTarget target = new UGCTarget();
    private String taskOrigin;
    private JSONObject tiaozhanInfo;
    private String title;
    private int topicsRule;
    private String userType;
    private String videoCover;
    private String videoPath;
    private final HttpRequestPublishModule.VideoUploadModel videoUploadModel = new HttpRequestPublishModule.VideoUploadModel();
    private String ymgToken;

    public static /* synthetic */ PublishModel copy$default(PublishModel publishModel, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = publishModel.sourceFrom;
        }
        return publishModel.copy(str);
    }

    public final String component1() {
        return this.sourceFrom;
    }

    public final PublishModel copy(String str) {
        Intrinsics.checkNotNullParameter(str, "sourceFrom");
        return new PublishModel(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PublishModel) && Intrinsics.areEqual((Object) this.sourceFrom, (Object) ((PublishModel) obj).sourceFrom);
    }

    public int hashCode() {
        return this.sourceFrom.hashCode();
    }

    public String toString() {
        return "PublishModel(sourceFrom=" + this.sourceFrom + ')';
    }

    public PublishModel(String sourceFrom2) {
        Intrinsics.checkNotNullParameter(sourceFrom2, "sourceFrom");
        this.sourceFrom = sourceFrom2;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final int getSourceType() {
        return this.sourceType;
    }

    public final void setSourceType(int i2) {
        this.sourceType = i2;
    }

    public final int getAsyncUpload() {
        return this.asyncUpload;
    }

    public final void setAsyncUpload(int i2) {
        this.asyncUpload = i2;
    }

    public final String getPublishType() {
        return this.publishType;
    }

    public final void setPublishType(String str) {
        this.publishType = str;
    }

    public final String getDisplayScene() {
        return this.displayScene;
    }

    public final void setDisplayScene(String str) {
        this.displayScene = str;
    }

    public final String getCallback() {
        return this.callback;
    }

    public final void setCallback(String str) {
        this.callback = str;
    }

    public final int getShowToastType() {
        return this.showToastType;
    }

    public final void setShowToastType(int i2) {
        this.showToastType = i2;
    }

    public final String getDraftKey() {
        return this.draftKey;
    }

    public final void setDraftKey(String str) {
        this.draftKey = str;
    }

    public final String getUserType() {
        return this.userType;
    }

    public final void setUserType(String str) {
        this.userType = str;
    }

    public final String getMeddleGroupId() {
        return this.meddleGroupId;
    }

    public final void setMeddleGroupId(String str) {
        this.meddleGroupId = str;
    }

    public final String getDynamicTitle() {
        return this.dynamicTitle;
    }

    public final void setDynamicTitle(String str) {
        this.dynamicTitle = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final int isUgcTextTemplate() {
        return this.isUgcTextTemplate;
    }

    public final void setUgcTextTemplate(int i2) {
        this.isUgcTextTemplate = i2;
    }

    public final UGCTarget getTarget() {
        return this.target;
    }

    public final void setTarget(UGCTarget uGCTarget) {
        Intrinsics.checkNotNullParameter(uGCTarget, "<set-?>");
        this.target = uGCTarget;
    }

    public final ArrayList<TopicItem> getNewTopics() {
        return this.newTopics;
    }

    public final void setNewTopics(ArrayList<TopicItem> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.newTopics = arrayList;
    }

    public final int getTopicsRule() {
        return this.topicsRule;
    }

    public final void setTopicsRule(int i2) {
        this.topicsRule = i2;
    }

    public final ArrayList<ImageStruct> getImages() {
        return this.images;
    }

    public final void setImages(ArrayList<ImageStruct> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.images = arrayList;
    }

    public final Map<String, ImageUploadModel> getImageUrls() {
        return this.imageUrls;
    }

    public final void setImageUrls(Map<String, ? extends ImageUploadModel> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.imageUrls = map;
    }

    public final String getVideoPath() {
        return this.videoPath;
    }

    public final void setVideoPath(String str) {
        this.videoPath = str;
    }

    public final String getVideoCover() {
        return this.videoCover;
    }

    public final void setVideoCover(String str) {
        this.videoCover = str;
    }

    public final HttpRequestPublishModule.VideoUploadModel getVideoUploadModel() {
        return this.videoUploadModel;
    }

    public final ReferenceDt getReferenceDt() {
        return this.referenceDt;
    }

    public final void setReferenceDt(ReferenceDt referenceDt2) {
        this.referenceDt = referenceDt2;
    }

    public final String getForwardIsComment() {
        return this.forwardIsComment;
    }

    public final void setForwardIsComment(String str) {
        this.forwardIsComment = str;
    }

    public final String getForwardSource() {
        return this.forwardSource;
    }

    public final void setForwardSource(String str) {
        this.forwardSource = str;
    }

    public final LocationModel getLocationModel() {
        return this.locationModel;
    }

    public final void setLocationModel(LocationModel locationModel2) {
        this.locationModel = locationModel2;
    }

    public final PoiModel getPoiModel() {
        return this.poiModel;
    }

    public final void setPoiModel(PoiModel poiModel2) {
        this.poiModel = poiModel2;
    }

    public final JSONObject getShop() {
        return this.shop;
    }

    public final void setShop(JSONObject jSONObject) {
        this.shop = jSONObject;
    }

    public final CategoryLabelValue getCategory() {
        return this.category;
    }

    public final void setCategory(CategoryLabelValue categoryLabelValue) {
        this.category = categoryLabelValue;
    }

    public final String getExtInfo() {
        return this.extInfo;
    }

    public final void setExtInfo(String str) {
        this.extInfo = str;
    }

    public final String getQuestionText() {
        return this.questionText;
    }

    public final void setQuestionText(String str) {
        this.questionText = str;
    }

    public final JSONObject getQuestionReply() {
        return this.questionReply;
    }

    public final void setQuestionReply(JSONObject jSONObject) {
        this.questionReply = jSONObject;
    }

    public final JSONObject getCampaign() {
        return this.campaign;
    }

    public final void setCampaign(JSONObject jSONObject) {
        this.campaign = jSONObject;
    }

    public final String getTaskOrigin() {
        return this.taskOrigin;
    }

    public final void setTaskOrigin(String str) {
        this.taskOrigin = str;
    }

    public final ProgressBarConfigModel getProgressBarConfigModel() {
        return this.progressBarConfigModel;
    }

    public final void setProgressBarConfigModel(ProgressBarConfigModel progressBarConfigModel2) {
        this.progressBarConfigModel = progressBarConfigModel2;
    }

    public final boolean getSecondEdit() {
        return this.secondEdit;
    }

    public final void setSecondEdit(boolean z) {
        this.secondEdit = z;
    }

    public final String getNid() {
        return this.nid;
    }

    public final void setNid(String str) {
        this.nid = str;
    }

    public final String getAiStatement() {
        return this.aiStatement;
    }

    public final void setAiStatement(String str) {
        this.aiStatement = str;
    }

    public final String getYmgToken() {
        return this.ymgToken;
    }

    public final void setYmgToken(String str) {
        this.ymgToken = str;
    }

    public final String getImgGenTxtAiAnchorPointId() {
        return this.imgGenTxtAiAnchorPointId;
    }

    public final void setImgGenTxtAiAnchorPointId(String str) {
        this.imgGenTxtAiAnchorPointId = str;
    }

    public final JSONObject getTiaozhanInfo() {
        return this.tiaozhanInfo;
    }

    public final void setTiaozhanInfo(JSONObject jSONObject) {
        this.tiaozhanInfo = jSONObject;
    }

    public final String getCenterInfo() {
        return this.centerInfo;
    }

    public final void setCenterInfo(String str) {
        this.centerInfo = str;
    }

    public final String getBusinessId() {
        return this.businessId;
    }

    public final void setBusinessId(String str) {
        this.businessId = str;
    }

    public final boolean isFromAiCard() {
        return this.isFromAiCard;
    }

    public final void setFromAiCard(boolean z) {
        this.isFromAiCard = z;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final boolean isAiPublisher() {
        return this.isAiPublisher;
    }

    public final void setAiPublisher(boolean z) {
        this.isAiPublisher = z;
    }

    public final String getAiPublisherSuccessGuide() {
        return this.aiPublisherSuccessGuide;
    }

    public final void setAiPublisherSuccessGuide(String str) {
        this.aiPublisherSuccessGuide = str;
    }

    public final String getAiCreationCardType() {
        return this.aiCreationCardType;
    }

    public final void setAiCreationCardType(String str) {
        this.aiCreationCardType = str;
    }

    public final String getAiCreationCardId() {
        return this.aiCreationCardId;
    }

    public final void setAiCreationCardId(String str) {
        this.aiCreationCardId = str;
    }
}
