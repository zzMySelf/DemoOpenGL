package com.baidu.searchbox.comment.input;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.comment.CommentRuntime;
import com.baidu.searchbox.comment.R;
import com.baidu.searchbox.comment.event.TextChangeEvent;
import com.baidu.searchbox.comment.input.aiimage.AiGeneratePicModule;
import com.baidu.searchbox.comment.input.aiimage.AiPicButton;
import com.baidu.searchbox.comment.input.aiimage.AiPicViewModel;
import com.baidu.searchbox.comment.input.aiimage.CommentInputAiImageLayout;
import com.baidu.searchbox.comment.recommend.VideoCommentBarrageModel;
import com.baidu.searchbox.comment.recommend.VideoCommentManager;
import com.baidu.searchbox.comment.sp.CommentSpWrapper;
import com.baidu.searchbox.comment.view.AiHintButtonView;
import com.baidu.searchbox.interaction.cloudcontrol.abtest.switcher.CommentAtSwitch;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import com.baidu.searchbox.ugc.utils.UgcUriUtils;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.ui.UnifyTextView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u001b\n\u0002\u0010\t\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0016J\u0010\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u000205H\u0014J\u0018\u0010?\u001a\u00020;2\u0006\u0010@\u001a\u0002052\u0006\u0010A\u001a\u000205H\u0016J\u0010\u0010B\u001a\u00020;2\u0006\u0010C\u001a\u000205H\u0016J\n\u0010D\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010E\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010F\u001a\u00020GH\u0014J\b\u0010H\u001a\u00020\u0006H\u0016J\n\u0010I\u001a\u0004\u0018\u000100H\u0016J\b\u0010J\u001a\u00020KH\u0014J\u0010\u0010L\u001a\u00020;2\u0006\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u000205H\u0016J\b\u0010P\u001a\u000205H\u0016J\b\u0010Q\u001a\u000205H\u0016J\b\u0010R\u001a\u00020;H\u0016J\b\u0010S\u001a\u00020;H\u0002J\b\u0010T\u001a\u00020;H\u0002J\b\u0010U\u001a\u00020;H\u0014J\b\u0010V\u001a\u00020;H\u0014J\b\u0010W\u001a\u00020;H\u0014J\n\u0010X\u001a\u0004\u0018\u000100H\u0014J\u0012\u0010Y\u001a\u00020;2\b\u0010Z\u001a\u0004\u0018\u000100H\u0016J\u0010\u0010[\u001a\u00020;2\u0006\u0010M\u001a\u00020NH\u0014J\u0012\u0010\\\u001a\u00020;2\b\u0010]\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010^\u001a\u00020;2\u0006\u0010_\u001a\u00020\u0006H\u0016J\b\u0010`\u001a\u00020;H\u0002J\u001a\u0010a\u001a\u00020;2\b\u0010b\u001a\u0004\u0018\u00010\u00062\u0006\u0010c\u001a\u000205H\u0002J\u001a\u0010d\u001a\u00020;2\b\u0010e\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u000205H\u0016J\u001a\u0010g\u001a\u00020;2\b\u0010h\u001a\u0004\u0018\u00010\u00062\u0006\u0010i\u001a\u00020jH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158DX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u000e\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u000e\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0002¢\u0006\f\n\u0004\b.\u0010\u000e\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0002¢\u0006\f\n\u0004\b3\u0010\u000e\u001a\u0004\b1\u00102R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u000207X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109¨\u0006k"}, d2 = {"Lcom/baidu/searchbox/comment/input/CommentVideoCommentInputLayout;", "Lcom/baidu/searchbox/comment/input/CommentBaseInputLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "aiGtHolderText", "", "aiHintButtonView", "Lcom/baidu/searchbox/comment/view/AiHintButtonView;", "aiImageGuideView", "Lcom/baidu/searchbox/comment/input/aiimage/CommentInputAiImageLayout;", "getAiImageGuideView", "()Lcom/baidu/searchbox/comment/input/aiimage/CommentInputAiImageLayout;", "aiImageGuideView$delegate", "Lkotlin/Lazy;", "atBtn", "Landroid/widget/ImageView;", "getAtBtn", "()Landroid/widget/ImageView;", "atBtn$delegate", "changeWidthView", "Lcom/baidu/searchbox/comment/input/ChangeWidthLinearLayout;", "getChangeWidthView", "()Lcom/baidu/searchbox/comment/input/ChangeWidthLinearLayout;", "changeWidthView$delegate", "inputAiHintDesc", "Landroid/widget/TextView;", "inputThumbnail", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getInputThumbnail", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "inputThumbnail$delegate", "inputThumbnailClose", "Lcom/baidu/searchbox/ui/BdBaseImageView;", "getInputThumbnailClose", "()Lcom/baidu/searchbox/ui/BdBaseImageView;", "inputThumbnailClose$delegate", "inputThumbnailLayout", "Landroid/widget/FrameLayout;", "getInputThumbnailLayout", "()Landroid/widget/FrameLayout;", "inputThumbnailLayout$delegate", "inputVideoDuration", "Lcom/baidu/searchbox/ui/UnifyTextView;", "getInputVideoDuration", "()Lcom/baidu/searchbox/ui/UnifyTextView;", "inputVideoDuration$delegate", "interruptMaskView", "Landroid/view/View;", "getInterruptMaskView", "()Landroid/view/View;", "interruptMaskView$delegate", "isSupportAiGtPic", "", "templateType", "Lcom/baidu/searchbox/comment/input/CommentInputTemplateType;", "getTemplateType", "()Lcom/baidu/searchbox/comment/input/CommentInputTemplateType;", "addLayoutForThumbnail", "", "changeInputLayoutRadius", "changeSendBtnEnabled", "enabled", "changeSendContainerVisibility", "show", "needAnim", "changedOutEmojiPanelVisible", "visible", "getAiImageContainer", "getAnimView", "getLayoutId", "", "getPlaceholder", "getThumbnailLayout", "getThumbnailRoundingParams", "Lcom/facebook/drawee/generic/RoundingParams;", "hasAiPicTextChanged", "word", "", "hasBarrageIcon", "hasInputPicture", "hasInputVideo", "hideInputThumbnail", "initAiHintButtonView", "initAiHintDescView", "initInputContainer", "initPictureAndGif", "initSendContainer", "obtainInterruptMaskView", "onClick", "v", "onTextChanged", "parseCommentConf", "commentConf", "setAiHintStyle", "aiHint", "setInputDescVisible", "showInputPicOrVideo", "pic", "isVideo", "showInputPicture", "picUrl", "needShowAnimation", "showInputVideo", "coverUrl", "duration", "", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentVideoCommentInputLayout.kt */
public class CommentVideoCommentInputLayout extends CommentBaseInputLayout {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private String aiGtHolderText;
    private AiHintButtonView aiHintButtonView;
    private final Lazy aiImageGuideView$delegate;
    private final Lazy atBtn$delegate;
    private final Lazy changeWidthView$delegate;
    private TextView inputAiHintDesc;
    private final Lazy inputThumbnail$delegate;
    private final Lazy inputThumbnailClose$delegate;
    private final Lazy inputThumbnailLayout$delegate;
    private final Lazy inputVideoDuration$delegate;
    private final Lazy interruptMaskView$delegate;
    private boolean isSupportAiGtPic;
    private final CommentInputTemplateType templateType;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentVideoCommentInputLayout(Context context) {
        super(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.inputThumbnailLayout$delegate = LazyKt.lazy(new CommentVideoCommentInputLayout$inputThumbnailLayout$2(this));
        this.inputThumbnail$delegate = LazyKt.lazy(new CommentVideoCommentInputLayout$inputThumbnail$2(this));
        this.inputThumbnailClose$delegate = LazyKt.lazy(new CommentVideoCommentInputLayout$inputThumbnailClose$2(this));
        this.changeWidthView$delegate = LazyKt.lazy(new CommentVideoCommentInputLayout$changeWidthView$2(this));
        this.interruptMaskView$delegate = LazyKt.lazy(new CommentVideoCommentInputLayout$interruptMaskView$2(this));
        this.atBtn$delegate = LazyKt.lazy(new CommentVideoCommentInputLayout$atBtn$2(this));
        this.aiImageGuideView$delegate = LazyKt.lazy(new CommentVideoCommentInputLayout$aiImageGuideView$2(this));
        this.aiGtHolderText = "";
        this.inputVideoDuration$delegate = LazyKt.lazy(new CommentVideoCommentInputLayout$inputVideoDuration$2(this));
        this.templateType = CommentInputTemplateType.VIDEO_COMMENT;
    }

    private final FrameLayout getInputThumbnailLayout() {
        Object value = this.inputThumbnailLayout$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-inputThumbnailLayout>(...)");
        return (FrameLayout) value;
    }

    private final SimpleDraweeView getInputThumbnail() {
        Object value = this.inputThumbnail$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-inputThumbnail>(...)");
        return (SimpleDraweeView) value;
    }

    private final BdBaseImageView getInputThumbnailClose() {
        Object value = this.inputThumbnailClose$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-inputThumbnailClose>(...)");
        return (BdBaseImageView) value;
    }

    /* access modifiers changed from: protected */
    public final ChangeWidthLinearLayout getChangeWidthView() {
        Object value = this.changeWidthView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-changeWidthView>(...)");
        return (ChangeWidthLinearLayout) value;
    }

    private final View getInterruptMaskView() {
        return (View) this.interruptMaskView$delegate.getValue();
    }

    private final ImageView getAtBtn() {
        Object value = this.atBtn$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-atBtn>(...)");
        return (ImageView) value;
    }

    private final CommentInputAiImageLayout getAiImageGuideView() {
        return (CommentInputAiImageLayout) this.aiImageGuideView$delegate.getValue();
    }

    private final UnifyTextView getInputVideoDuration() {
        Object value = this.inputVideoDuration$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-inputVideoDuration>(...)");
        return (UnifyTextView) value;
    }

    public CommentInputTemplateType getTemplateType() {
        return this.templateType;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.comment_video_comment_input_layout;
    }

    /* access modifiers changed from: protected */
    public View obtainInterruptMaskView() {
        return getInterruptMaskView();
    }

    public void showInputPicture(String picUrl, boolean needShowAnimation) {
        CharSequence charSequence = picUrl;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            getInputThumbnailLayout().setVisibility(8);
            return;
        }
        CommentInputCallback callback = getCallback();
        if (callback != null) {
            callback.onInputPictureShow(picUrl);
        }
        showInputPicOrVideo(picUrl, false);
    }

    public void showInputVideo(String coverUrl, long duration) {
        CharSequence charSequence = coverUrl;
        if (charSequence == null || charSequence.length() == 0) {
            getInputThumbnailLayout().setVisibility(8);
            getInputVideoDuration().setVisibility(8);
            return;
        }
        CommentInputCallback callback = getCallback();
        if (callback != null) {
            callback.onInputVideoShow(true);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss", Locale.getDefault());
        Date data = new Date(duration);
        UnifyTextView $this$showInputVideo_u24lambda_u2d0 = getInputVideoDuration();
        $this$showInputVideo_u24lambda_u2d0.setText(sdf.format(data));
        ViewExtensionsKt.setTextColorRes($this$showInputVideo_u24lambda_u2d0, com.baidu.searchbox.interaction.styles.R.color.IC196);
        showInputPicOrVideo(coverUrl, true);
    }

    private final void showInputPicOrVideo(String pic, boolean isVideo) {
        int i2 = 0;
        getInputThumbnailLayout().setVisibility(0);
        UnifyTextView inputVideoDuration = getInputVideoDuration();
        if (!isVideo) {
            i2 = 8;
        }
        inputVideoDuration.setVisibility(i2);
        SimpleDraweeView $this$showInputPicOrVideo_u24lambda_u2d1 = getInputThumbnail();
        $this$showInputPicOrVideo_u24lambda_u2d1.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true)).setOldController($this$showInputPicOrVideo_u24lambda_u2d1.getController())).setImageRequest(ImageRequestBuilder.newBuilderWithSource(UgcUriUtils.getUri(pic)).setResizeOptions(new ResizeOptions(DeviceUtils.ScreenInfo.getDisplayWidth(CommentRuntime.getAppContext()), DeviceUtils.ScreenInfo.getDisplayHeight(CommentRuntime.getAppContext()), 0.0f, 0.0f, 12, (DefaultConstructorMarker) null)).build())).build());
        changeSendContainerVisibility(true, true);
        changeInputLayoutRadius();
        if (hasOtherInput()) {
            setAiHintStyle(getPlaceholder());
        }
    }

    public void changeSendContainerVisibility(boolean show, boolean needAnim) {
        if (!needAnim || show == getLastShowState()) {
            super.changeSendContainerVisibility(show, needAnim);
        } else {
            startChangeAnim(show);
        }
        setLastShowState(show);
    }

    /* access modifiers changed from: protected */
    public ChangeWidthLinearLayout getAnimView() {
        return getChangeWidthView();
    }

    /* access modifiers changed from: protected */
    public void initSendContainer() {
        ViewGroup $this$initSendContainer_u24lambda_u2d2 = getSendContainer();
        ViewExtensionsKt.setBackgroundRes($this$initSendContainer_u24lambda_u2d2, R.drawable.comment_input_box_vertical_video_send_bg);
        $this$initSendContainer_u24lambda_u2d2.setOnClickListener(this);
        changeSendContainerVisibility(hasInputText() || hasInputPicture() || hasAiHintText(), false);
        ViewExtensionsKt.setTextColorRes(getSendBtn(), com.baidu.searchbox.interaction.styles.R.color.IC196);
    }

    /* access modifiers changed from: protected */
    public void initInputContainer() {
        ViewExtensionsKt.setBackgroundRes(getInputContainer(), R.drawable.comment_input_box_video_background);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initAiHintDescView() {
        /*
            r9 = this;
            com.baidu.searchbox.comment.template.fluency.TemplateViewUtil r0 = com.baidu.searchbox.comment.template.fluency.TemplateViewUtil.INSTANCE
            int r1 = com.baidu.searchbox.comment.R.id.ai_hint_view_desc
            java.lang.Class<android.widget.TextView> r2 = android.widget.TextView.class
            android.widget.TextView r3 = r9.inputAiHintDesc
            android.view.View r3 = (android.view.View) r3
            r4 = 0
            r5 = 0
            if (r3 != 0) goto L_0x003d
            r6 = r9
            android.view.View r6 = (android.view.View) r6
            android.view.View r6 = r6.findViewById(r1)
            if (r6 != 0) goto L_0x0019
            goto L_0x0047
        L_0x0019:
            java.lang.String r7 = "rootView?.findViewById<T?>(viewId) ?: return null"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            boolean r7 = r6 instanceof android.view.ViewStub
            if (r7 == 0) goto L_0x0035
            r7 = r6
            android.view.ViewStub r7 = (android.view.ViewStub) r7
            android.view.View r7 = r7.inflate()
            boolean r8 = r7 instanceof android.widget.TextView
            if (r8 != 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r5 = r7
        L_0x0030:
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.view.View r5 = (android.view.View) r5
            goto L_0x0047
        L_0x0035:
            boolean r7 = r2.isInstance(r6)
            if (r7 == 0) goto L_0x003d
            r5 = r6
            goto L_0x0047
        L_0x003d:
            boolean r6 = r3 instanceof android.widget.TextView
            if (r6 != 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r5 = r3
        L_0x0043:
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.view.View r5 = (android.view.View) r5
        L_0x0047:
            android.widget.TextView r5 = (android.widget.TextView) r5
            r9.inputAiHintDesc = r5
            if (r5 == 0) goto L_0x005a
            android.content.Context r0 = com.baidu.searchbox.comment.CommentRuntime.getAppContext()
            int r1 = com.baidu.searchbox.interaction.styles.R.color.IC253
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
            r5.setTextColor(r0)
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.comment.input.CommentVideoCommentInputLayout.initAiHintDescView():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initAiHintButtonView() {
        /*
            r9 = this;
            com.baidu.searchbox.comment.video.IVideoCommentService r0 = com.baidu.searchbox.comment.CommentModuleManager.getVideoCommentService()
            boolean r0 = r0.getAiHintSecondOptSwitch()
            if (r0 == 0) goto L_0x0066
            com.baidu.searchbox.comment.view.AiHintButtonView r0 = r9.aiHintButtonView
            if (r0 != 0) goto L_0x0066
            com.baidu.searchbox.comment.template.fluency.TemplateViewUtil r0 = com.baidu.searchbox.comment.template.fluency.TemplateViewUtil.INSTANCE
            int r1 = com.baidu.searchbox.comment.R.id.ai_hint_button_view
            java.lang.Class<com.baidu.searchbox.comment.view.AiHintButtonView> r2 = com.baidu.searchbox.comment.view.AiHintButtonView.class
            com.baidu.searchbox.comment.view.AiHintButtonView r3 = r9.aiHintButtonView
            android.view.View r3 = (android.view.View) r3
            r4 = 0
            r5 = 0
            if (r3 != 0) goto L_0x004b
            r6 = r9
            android.view.View r6 = (android.view.View) r6
            android.view.View r6 = r6.findViewById(r1)
            if (r6 != 0) goto L_0x0027
            goto L_0x0055
        L_0x0027:
            java.lang.String r7 = "rootView?.findViewById<T?>(viewId) ?: return null"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            boolean r7 = r6 instanceof android.view.ViewStub
            if (r7 == 0) goto L_0x0043
            r7 = r6
            android.view.ViewStub r7 = (android.view.ViewStub) r7
            android.view.View r7 = r7.inflate()
            boolean r8 = r7 instanceof com.baidu.searchbox.comment.view.AiHintButtonView
            if (r8 != 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r5 = r7
        L_0x003e:
            com.baidu.searchbox.comment.view.AiHintButtonView r5 = (com.baidu.searchbox.comment.view.AiHintButtonView) r5
            android.view.View r5 = (android.view.View) r5
            goto L_0x0055
        L_0x0043:
            boolean r7 = r2.isInstance(r6)
            if (r7 == 0) goto L_0x004b
            r5 = r6
            goto L_0x0055
        L_0x004b:
            boolean r6 = r3 instanceof com.baidu.searchbox.comment.view.AiHintButtonView
            if (r6 != 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r5 = r3
        L_0x0051:
            com.baidu.searchbox.comment.view.AiHintButtonView r5 = (com.baidu.searchbox.comment.view.AiHintButtonView) r5
            android.view.View r5 = (android.view.View) r5
        L_0x0055:
            com.baidu.searchbox.comment.view.AiHintButtonView r5 = (com.baidu.searchbox.comment.view.AiHintButtonView) r5
            r9.aiHintButtonView = r5
            if (r5 != 0) goto L_0x005c
            goto L_0x0066
        L_0x005c:
            com.baidu.searchbox.comment.input.CommentVideoCommentInputLayout$initAiHintButtonView$1 r0 = new com.baidu.searchbox.comment.input.CommentVideoCommentInputLayout$initAiHintButtonView$1
            r0.<init>(r9)
            com.baidu.searchbox.comment.view.AiHintButtonView$AiHintButtonClickListener r0 = (com.baidu.searchbox.comment.view.AiHintButtonView.AiHintButtonClickListener) r0
            r5.setAiHintButtonClickListener(r0)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.comment.input.CommentVideoCommentInputLayout.initAiHintButtonView():void");
    }

    public boolean hasBarrageIcon() {
        VideoCommentBarrageModel videoBarrageModel = getVideoBarrageModel();
        return videoBarrageModel != null && videoBarrageModel.showBarrageIcon();
    }

    public String getPlaceholder() {
        Pair pair = AiGeneratePicModule.Companion.needShowAiInputPlaceHolder();
        if (this.isSupportAiGtPic && pair.getFirst().booleanValue()) {
            if (this.aiGtHolderText.length() > 0) {
                CommentSpWrapper.setCommentAiInputPlaceShowTimes(pair.getSecond().intValue() + 1);
                return this.aiGtHolderText;
            }
        }
        return super.getPlaceholder();
    }

    /* access modifiers changed from: protected */
    public void parseCommentConf(String commentConf) {
        JSONObject jSONObject;
        super.parseCommentConf(commentConf);
        try {
            Result.Companion companion = Result.Companion;
            CommentVideoCommentInputLayout commentVideoCommentInputLayout = this;
            jSONObject = Result.m8971constructorimpl(new JSONObject(commentConf));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            jSONObject = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        JSONObject jSONObject2 = new JSONObject();
        if (Result.m8977isFailureimpl(jSONObject)) {
            jSONObject = jSONObject2;
        }
        JSONObject it = ((JSONObject) jSONObject).optJSONObject("ai_gt_image_conf");
        if (it != null) {
            this.isSupportAiGtPic = true;
            String optString = it.optString("preset_content", "");
            Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"preset_content\", \"\")");
            this.aiGtHolderText = optString;
        }
    }

    public View getThumbnailLayout() {
        return getInputThumbnailLayout();
    }

    /* access modifiers changed from: protected */
    public void initPictureAndGif() {
        super.initPictureAndGif();
        ImageView $this$initPictureAndGif_u24lambda_u2d5 = getAtBtn();
        $this$initPictureAndGif_u24lambda_u2d5.setImageResource(R.drawable.comment_input_box_at_icon);
        $this$initPictureAndGif_u24lambda_u2d5.setOnClickListener(this);
        if (CommentAtSwitch.getCommentAtSwitch()) {
            $this$initPictureAndGif_u24lambda_u2d5.setVisibility(0);
            View $this$makeVisible$iv = getGifBtn();
            if ($this$makeVisible$iv != null) {
                $this$makeVisible$iv.setVisibility(8);
                return;
            }
            return;
        }
        $this$initPictureAndGif_u24lambda_u2d5.setVisibility(8);
    }

    public CommentInputAiImageLayout getAiImageContainer() {
        return getAiImageGuideView();
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence word) {
        Intrinsics.checkNotNullParameter(word, "word");
        super.onTextChanged(word);
        hasAiPicTextChanged(word);
        setInputDescVisible();
    }

    private final void hasAiPicTextChanged(CharSequence word) {
        if (!this.isSupportAiGtPic || !AiGeneratePicModule.Companion.isValidPrompt(word) || !AiGeneratePicModule.Companion.isValidPromptSize(word.toString(), AiPicViewModel.Companion.getGUIDE_SHOW_CHAR_COUNT())) {
            BdEventBus.Companion.getDefault().post(new TextChangeEvent(AiPicButton.ButtonType.DEFAULT));
            return;
        }
        BdEventBus.Companion.getDefault().post(new TextChangeEvent(AiPicButton.ButtonType.ENABLED));
        BdEventBus.Companion.getDefault().post(new TextChangeEvent(AiPicButton.ButtonType.ENABLED_GUIDE));
    }

    public void changeInputLayoutRadius() {
        ViewGroup inputContainer = getInputContainer();
        Drawable background = getInputContainer().getBackground();
        GradientDrawable gradientDrawable = null;
        GradientDrawable $this$changeInputLayoutRadius_u24lambda_u2d6 = background instanceof GradientDrawable ? (GradientDrawable) background : null;
        if ($this$changeInputLayoutRadius_u24lambda_u2d6 != null) {
            $this$changeInputLayoutRadius_u24lambda_u2d6.setCornerRadius(ViewExtensionsKt.getDimension(this, R.dimen.comment_dimen_13dp));
            gradientDrawable = $this$changeInputLayoutRadius_u24lambda_u2d6;
        }
        inputContainer.setBackground(gradientDrawable);
    }

    public boolean hasInputPicture() {
        if ((getInputThumbnailLayout().getVisibility() == 0 ? 1 : null) == null || getInputVideoDuration().getVisibility() == 0) {
            return false;
        }
        return true;
    }

    public boolean hasInputVideo() {
        if ((getInputThumbnailLayout().getVisibility() == 0 ? 1 : null) == null || getInputVideoDuration().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void addLayoutForThumbnail() {
        SimpleDraweeView $this$addLayoutForThumbnail_u24lambda_u2d7 = getInputThumbnail();
        $this$addLayoutForThumbnail_u24lambda_u2d7.setHierarchy(getThumbnailHierarchy());
        $this$addLayoutForThumbnail_u24lambda_u2d7.setOnClickListener(this);
        getInputThumbnailClose().setOnClickListener(this);
    }

    public void hideInputThumbnail() {
        super.hideInputThumbnail();
        getInputThumbnailLayout().setVisibility(8);
        getInputVideoDuration().setVisibility(8);
        CommentInputCallback callback = getCallback();
        if (callback != null) {
            callback.onInputPictureShow("");
        }
        CommentInputCallback callback2 = getCallback();
        if (callback2 != null) {
            callback2.onInputVideoShow(false);
        }
    }

    public void onClick(View v) {
        CommentInputCallback callback;
        CommentInputCallback callback2;
        super.onClick(v);
        if (Intrinsics.areEqual((Object) v, (Object) getInputThumbnail())) {
            CommentInputCallback callback3 = getCallback();
            if (callback3 != null) {
                callback3.onThumbnailClick();
            }
        } else if (Intrinsics.areEqual((Object) v, (Object) getInputThumbnailClose())) {
            CommentInputCallback callback4 = getCallback();
            if (callback4 != null) {
                callback4.onThumbnailCloseClick();
            }
            hideInputThumbnail();
            setInputPictureType(-1);
            Editable text = getCommentEditText().getText();
            Intrinsics.checkNotNullExpressionValue(text, "commentEditText.text");
            commentNumOfWords(text);
        } else if (Intrinsics.areEqual((Object) v, (Object) getSendContainer())) {
            if (getSendBtn().isEnabled()) {
                if ((getSendBtn().getVisibility() == 0) && (callback2 = getCallback()) != null) {
                    callback2.onSendBtnClick();
                }
            }
        } else if (Intrinsics.areEqual((Object) v, (Object) getAtBtn()) && (callback = getCallback()) != null) {
            callback.onAtClick();
        }
    }

    /* access modifiers changed from: protected */
    public void changeSendBtnEnabled(boolean enabled) {
        super.changeSendBtnEnabled(enabled);
        getSendContainer().setAlpha(enabled ? 1.0f : 0.4f);
    }

    /* access modifiers changed from: protected */
    public RoundingParams getThumbnailRoundingParams() {
        RoundingParams roundingParams = new RoundingParams();
        RoundingParams $this$getThumbnailRoundingParams_u24lambda_u2d8 = roundingParams;
        $this$getThumbnailRoundingParams_u24lambda_u2d8.setOverlayColor(ContextCompat.getColor(getContext(), R.color.comment_input_img_corner));
        $this$getThumbnailRoundingParams_u24lambda_u2d8.setCornersRadius(DeviceUtils.ScreenInfo.dp2pxf(getContext(), 8.0f));
        return roundingParams;
    }

    public void changedOutEmojiPanelVisible(boolean visible) {
        int i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        if (!visible) {
            i2 = ViewExtensionsKt.getDimensionPixelSize(this, R.dimen.comment_dimen_7_5dp);
        } else {
            i2 = ViewExtensionsKt.getDimensionPixelSize(this, R.dimen.comment_dimen_3_5dp);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, i2);
    }

    public void setAiHintStyle(String aiHint) {
        Intrinsics.checkNotNullParameter(aiHint, "aiHint");
        initAiHintDescView();
        initAiHintButtonView();
        setInputDescVisible();
        super.setAiHintStyle(aiHint);
    }

    private final void setInputDescVisible() {
        AiHintButtonView aiHintButtonView2;
        boolean noInputText = !hasInputText() && !hasOtherInput();
        if (!hasAiHintText() || !noInputText) {
            TextView $this$makeGone$iv = this.inputAiHintDesc;
            if ($this$makeGone$iv != null) {
                $this$makeGone$iv.setVisibility(8);
            }
            View $this$makeGone$iv2 = this.aiHintButtonView;
            if ($this$makeGone$iv2 != null) {
                $this$makeGone$iv2.setVisibility(8);
            }
        } else if (this.aiHintButtonView != null) {
            VideoCommentManager it = getVideoCommentManager();
            if (!(it == null || (aiHintButtonView2 = this.aiHintButtonView) == null)) {
                aiHintButtonView2.visibleWithAnimator(it.getAvailableHintSize());
            }
            TextView $this$makeGone$iv3 = this.inputAiHintDesc;
            if ($this$makeGone$iv3 != null) {
                $this$makeGone$iv3.setVisibility(8);
            }
        } else {
            TextView $this$makeVisible$iv = this.inputAiHintDesc;
            if ($this$makeVisible$iv != null) {
                $this$makeVisible$iv.setVisibility(0);
            }
        }
    }
}
