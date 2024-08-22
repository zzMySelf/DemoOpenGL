package com.baidu.searchbox.feed.payment.column;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.payment.FeedpayKt;
import com.baidu.searchbox.feed.payment.R;
import com.baidu.searchbox.feed.payment.column.facets.SpColumnContext;
import com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel;
import com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnListViewModel;
import com.baidu.searchbox.feed.payment.model.SpColumnBaseItemData;
import com.baidu.searchbox.feed.payment.model.SpColumnListDataKt;
import com.baidu.searchbox.feed.payment.model.SpColumnTextItemData;
import com.baidu.searchbox.feed.payment.model.SpColumnVideoItemData;
import com.baidu.searchbox.feed.payment.utils.SerialClickListener;
import com.baidu.searchbox.feed.tab.view.FeedThinDividerPolicy;
import com.baidu.searchbox.feed.template.FeedRelativeLayout;
import com.baidu.searchbox.feed.util.FeedUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010 H\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0012\u0010(\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\u0012\u0010-\u001a\u00020\u001c2\b\u0010.\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u000201H\u0002J\u0012\u00102\u001a\u00020\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u001aH\u0016J\b\u00108\u001a\u00020\u001cH\u0016J(\u00109\u001a\u00020\u001c2\b\u0010:\u001a\u0004\u0018\u00010;2\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020>\u0018\u00010=H\u0016J\u0012\u0010?\u001a\u00020\u001c2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u001aH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/baidu/searchbox/feed/payment/column/SpColumnTextImageView;", "Lcom/baidu/searchbox/feed/template/FeedRelativeLayout;", "Lcom/baidu/searchbox/feed/payment/column/ITplReceiveLastRead;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "listViewModel", "Lcom/baidu/searchbox/feed/payment/column/viewmodel/SpColumnListViewModel;", "mDesc", "Landroid/widget/TextView;", "mIcon", "Landroid/widget/ImageView;", "mLabel", "mProgress", "Landroid/view/ViewGroup;", "mProgressIcon", "mReadProgressText", "mSeqNumber", "mState", "mStateIcon", "mStateText", "mTitle", "mTypeIcon", "", "bindViewsById", "", "parent", "Landroid/view/View;", "calcTimeLength", "", "from", "extractViewModel", "getFeedDividerPolicy", "Lcom/baidu/searchbox/feed/base/FeedTemplate$FeedDividerPolicy;", "handleDescription", "data", "Lcom/baidu/searchbox/feed/payment/model/SpColumnBaseItemData;", "handleReadCount", "handleReadDesc", "progressPercent", "handleReadProgress", "handleReadStateUI", "handleState", "state", "initInflate", "inflater", "Landroid/view/LayoutInflater;", "initialize", "onFeedNightModeChanged", "isNightMode", "", "onFontSizeChanged", "fontSizeInPx", "onViewDestroy", "update", "feedModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "options", "", "", "updateLastRead", "lastReadInfo", "Lcom/baidu/searchbox/feed/payment/model/SpColumnLastReadData;", "updateReadProgressVisibility", "visibility", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnTextImageView.kt */
public final class SpColumnTextImageView extends FeedRelativeLayout implements ITplReceiveLastRead {
    /* access modifiers changed from: private */
    public SpColumnListViewModel listViewModel;
    private TextView mDesc;
    private ImageView mIcon;
    private TextView mLabel;
    private ViewGroup mProgress;
    private ImageView mProgressIcon;
    private TextView mReadProgressText;
    /* access modifiers changed from: private */
    public TextView mSeqNumber;
    private ViewGroup mState;
    private ImageView mStateIcon;
    private TextView mStateText;
    /* access modifiers changed from: private */
    public TextView mTitle;
    private int mTypeIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpColumnTextImageView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpColumnTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
    }

    public void initialize(Context context) {
        super.initialize(context);
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        bindViewsById(initInflate(from));
        int padding = getResources().getDimensionPixelSize(R.dimen.spcolumn_item_padding);
        setPadding(padding, padding, padding, padding);
        setClickable(true);
        setOnClickListener(new SerialClickListener(new SpColumnTextImageView$initialize$1(this, context)));
        setOnTouchListener(new SpColumnTextImageView$$ExternalSyntheticLambda0());
    }

    /* access modifiers changed from: private */
    /* renamed from: initialize$lambda-0  reason: not valid java name */
    public static final boolean m18998initialize$lambda0(View v, MotionEvent event) {
        switch (event.getAction()) {
            case 0:
                v.setAlpha(0.2f);
                return false;
            case 1:
            case 3:
                v.setAlpha(1.0f);
                return false;
            default:
                return false;
        }
    }

    private final View initInflate(LayoutInflater inflater) {
        View inflate = inflater.inflate(R.layout.feed_spcolumn_tpl_text, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…_spcolumn_tpl_text, this)");
        return inflate;
    }

    private final void bindViewsById(View parent) {
        View findViewById = findViewById(R.id.spcolumn_tpl_seq_num);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.spcolumn_tpl_seq_num)");
        this.mSeqNumber = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.spcolumn_tpl_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.spcolumn_tpl_title)");
        this.mTitle = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.spcolumn_tpl_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.spcolumn_tpl_icon)");
        this.mIcon = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.spcolumn_tpl_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.spcolumn_tpl_desc)");
        this.mDesc = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.spcolumn_tpl_label);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.spcolumn_tpl_label)");
        this.mLabel = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.spcolumn_tpl_state);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.spcolumn_tpl_state)");
        this.mState = (ViewGroup) findViewById6;
        View findViewById7 = findViewById(R.id.spcolumn_tpl_state_text);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.spcolumn_tpl_state_text)");
        this.mStateText = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.spcolumn_tpl_state_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.spcolumn_tpl_state_icon)");
        this.mStateIcon = (ImageView) findViewById8;
        View findViewById9 = findViewById(R.id.spcolumn_tpl_progress);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.spcolumn_tpl_progress)");
        this.mProgress = (ViewGroup) findViewById9;
        View findViewById10 = findViewById(R.id.spcolumn_tpl_read_progress_text);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.spcolumn_tpl_read_progress_text)");
        this.mReadProgressText = (TextView) findViewById10;
        View findViewById11 = findViewById(R.id.spcolumn_progress_locate);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.spcolumn_progress_locate)");
        this.mProgressIcon = (ImageView) findViewById11;
    }

    private final void extractViewModel() {
        if (this.listViewModel == null && (getContext() instanceof SpColumnContext)) {
            Context context = getContext();
            if (context != null) {
                this.listViewModel = ((SpColumnContext) context).getListViewModel();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.payment.column.facets.SpColumnContext");
        }
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> options) {
        int textSize;
        super.update(feedModel, options);
        extractViewModel();
        TextView textView = null;
        if ((feedModel != null ? feedModel.data : null) instanceof SpColumnBaseItemData) {
            FeedItemData feedItemData = feedModel.data;
            if (feedItemData != null) {
                SpColumnBaseItemData data = (SpColumnBaseItemData) feedItemData;
                TextView textView2 = this.mSeqNumber;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSeqNumber");
                    textView2 = null;
                }
                textView2.setText(data.seqNumber + ". ");
                TextView textView3 = this.mSeqNumber;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSeqNumber");
                    textView3 = null;
                }
                if (textView3.getText().length() <= 4) {
                    textSize = getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_15dp);
                } else {
                    textSize = getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_12dp);
                }
                TextView textView4 = this.mSeqNumber;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSeqNumber");
                    textView4 = null;
                }
                textView4.setTextSize(0, (float) textSize);
                String[] valid_states = SpColumnListDataKt.getVALID_STATES();
                String str = feedModel.state;
                if (ArraysKt.contains((T[]) valid_states, str != null ? StringsKt.trim((CharSequence) str).toString() : null)) {
                    TextView textView5 = this.mTitle;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitle");
                    } else {
                        textView = textView5;
                    }
                    textView.setText(data.title);
                    handleDescription(data);
                    handleReadCount(data);
                } else {
                    String invalidTitle = getContext().getString(R.string.spcolumn_tpl_invalid_title);
                    Intrinsics.checkNotNullExpressionValue(invalidTitle, "context.getString(com.ba…column_tpl_invalid_title)");
                    CharSequence charSequence = data.title;
                    if (charSequence == null || StringsKt.isBlank(charSequence)) {
                        data.title = invalidTitle;
                        feedModel.runtimeStatus.isRead = true;
                    }
                    TextView textView6 = this.mTitle;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitle");
                        textView6 = null;
                    }
                    textView6.setText(invalidTitle);
                    setEnabled(false);
                    handleDescription((SpColumnBaseItemData) null);
                    handleReadCount((SpColumnBaseItemData) null);
                }
                handleState(feedModel.state);
                handleReadProgress();
                handleReadStateUI();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.payment.model.SpColumnBaseItemData");
        }
    }

    private final void handleReadStateUI() {
        Context context = getContext();
        TextView textView = this.mTitle;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            textView = null;
        }
        SpColumnTextImageViewKt.processText(context, textView, getFeedModel(), false);
        TextView textView3 = this.mSeqNumber;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeqNumber");
            textView3 = null;
        }
        TextView textView4 = this.mTitle;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
        } else {
            textView2 = textView4;
        }
        textView3.setTextColor(textView2.getTextColors());
    }

    public void onViewDestroy() {
    }

    private final void handleReadProgress() {
        Context context = getContext();
        if (context != null) {
            Function0<Boolean> progressLocateEnable = ((SpColumnContext) context).getProgressLocateEnable();
            boolean z = true;
            if (progressLocateEnable == null || !progressLocateEnable.invoke().booleanValue()) {
                z = false;
            }
            if (z) {
                FeedBaseModel feedModel = getFeedModel();
                String str = feedModel != null ? feedModel.id : null;
                Context context2 = getContext();
                if (context2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.payment.column.facets.SpColumnContext");
                } else if (StringsKt.equals$default(str, ((SpColumnContext) context2).getListViewModel().getLastReadId(), false, 2, (Object) null)) {
                    Context context3 = getContext();
                    if (context3 != null) {
                        handleReadDesc(((SpColumnContext) context3).getListViewModel().getLastReadProgressPercent());
                        updateReadProgressVisibility(0);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.payment.column.facets.SpColumnContext");
                }
            }
            updateReadProgressVisibility(8);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.payment.column.facets.SpColumnContext");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ee, code lost:
        r1 = r8.mReadProgressText;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f4, code lost:
        if (r1 != null) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00f6, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mReadProgressText");
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00fa, code lost:
        r1.setText(r0);
        r1 = r8.mReadProgressText;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0102, code lost:
        if (r1 != null) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0104, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mReadProgressText");
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0108, code lost:
        r1.setTextColor(getResources().getColor(com.baidu.searchbox.feed.styles.R.color.FC133));
        r1 = r8.mProgress;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0117, code lost:
        if (r1 != null) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0119, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mProgress");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0120, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0121, code lost:
        r3.setBackground(getContext().getResources().getDrawable(com.baidu.searchbox.feed.payment.column.R.drawable.feed_spcolumn_progress_hint_bg));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0132, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0024, code lost:
        r1.equals(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleReadDesc(int r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            android.content.Context r1 = r8.getContext()
            if (r1 == 0) goto L_0x0134
            com.baidu.searchbox.feed.payment.column.facets.SpColumnContext r1 = (com.baidu.searchbox.feed.payment.column.facets.SpColumnContext) r1
            com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel r1 = r1.getDetailViewModel()
            java.lang.String r1 = r1.getColumnType()
            int r2 = r1.hashCode()
            r3 = 37
            r4 = 1
            r5 = 100
            r6 = -1
            r7 = 0
            switch(r2) {
                case 3377875: goto L_0x008d;
                case 93166550: goto L_0x008a;
                case 112202875: goto L_0x0028;
                case 1548953909: goto L_0x0022;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x0133
        L_0x0022:
            java.lang.String r2 = "audio_free"
        L_0x0024:
            r1.equals(r2)
            goto L_0x0020
        L_0x0028:
            java.lang.String r2 = "video"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0032
            goto L_0x0020
        L_0x0032:
            if (r9 != r6) goto L_0x0049
            android.content.Context r1 = r8.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r2 = com.baidu.searchbox.feed.payment.column.R.string.feed_spcolumn_locate_panel_video_desc
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "context.resources.getStr…_locate_panel_video_desc)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            goto L_0x0088
        L_0x0049:
            if (r9 < 0) goto L_0x004e
            if (r9 >= r5) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r4 = r7
        L_0x004f:
            if (r4 == 0) goto L_0x0075
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r2 = r8.getContext()
            android.content.res.Resources r2 = r2.getResources()
            int r4 = com.baidu.searchbox.feed.payment.column.R.string.feed_spcolumn_video_read_ing_desc
            java.lang.String r2 = r2.getString(r4)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            goto L_0x0088
        L_0x0075:
            android.content.Context r1 = r8.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r2 = com.baidu.searchbox.feed.payment.column.R.string.feed_spcolumn_video_read_complete_desc
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "context.resources.getStr…video_read_complete_desc)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x0088:
            r0 = r1
            goto L_0x00ee
        L_0x008a:
            java.lang.String r2 = "audio"
            goto L_0x0024
        L_0x008d:
            java.lang.String r2 = "news"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0097
            goto L_0x0020
        L_0x0097:
            if (r9 != r6) goto L_0x00ae
            android.content.Context r1 = r8.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r2 = com.baidu.searchbox.feed.payment.column.R.string.feed_spcolumn_locate_panel_text_image_desc
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "context.resources.getStr…te_panel_text_image_desc)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            goto L_0x00ed
        L_0x00ae:
            if (r9 < 0) goto L_0x00b3
            if (r9 >= r5) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            r4 = r7
        L_0x00b4:
            if (r4 == 0) goto L_0x00da
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r2 = r8.getContext()
            android.content.res.Resources r2 = r2.getResources()
            int r4 = com.baidu.searchbox.feed.payment.column.R.string.feed_spcolumn_text_image_read_ing_desc
            java.lang.String r2 = r2.getString(r4)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            goto L_0x00ed
        L_0x00da:
            android.content.Context r1 = r8.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r2 = com.baidu.searchbox.feed.payment.column.R.string.feed_spcolumn_text_image_read_complete_desc
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "context.resources.getStr…image_read_complete_desc)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x00ed:
            r0 = r1
        L_0x00ee:
            android.widget.TextView r1 = r8.mReadProgressText
            java.lang.String r2 = "mReadProgressText"
            r3 = 0
            if (r1 != 0) goto L_0x00fa
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r3
        L_0x00fa:
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
            android.widget.TextView r1 = r8.mReadProgressText
            if (r1 != 0) goto L_0x0108
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r3
        L_0x0108:
            android.content.res.Resources r2 = r8.getResources()
            int r4 = com.baidu.searchbox.feed.styles.R.color.FC133
            int r2 = r2.getColor(r4)
            r1.setTextColor(r2)
            android.view.ViewGroup r1 = r8.mProgress
            if (r1 != 0) goto L_0x0120
            java.lang.String r1 = "mProgress"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x0121
        L_0x0120:
            r3 = r1
        L_0x0121:
            android.content.Context r1 = r8.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r2 = com.baidu.searchbox.feed.payment.column.R.drawable.feed_spcolumn_progress_hint_bg
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            r3.setBackground(r1)
            return
        L_0x0133:
            return
        L_0x0134:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "null cannot be cast to non-null type com.baidu.searchbox.feed.payment.column.facets.SpColumnContext"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.SpColumnTextImageView.handleReadDesc(int):void");
    }

    private final void updateReadProgressVisibility(int visibility) {
        int progressVisibility = visibility;
        ViewGroup viewGroup = this.mState;
        ImageView imageView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mState");
            viewGroup = null;
        }
        if (viewGroup.getVisibility() == 0) {
            progressVisibility = 8;
        }
        ViewGroup viewGroup2 = this.mProgress;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
            viewGroup2 = null;
        }
        viewGroup2.setVisibility(progressVisibility);
        TextView textView = this.mReadProgressText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReadProgressText");
            textView = null;
        }
        textView.setVisibility(progressVisibility);
        ImageView imageView2 = this.mProgressIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgressIcon");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(progressVisibility);
    }

    private final void handleState(String state) {
        CharSequence charSequence;
        SpColumnDetailViewModel detailViewModel;
        ViewGroup viewGroup = null;
        if (state != null) {
            switch (state.hashCode()) {
                case 50:
                    if (state.equals("2")) {
                        ImageView imageView = this.mStateIcon;
                        if (imageView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mStateIcon");
                            imageView = null;
                        }
                        imageView.setVisibility(0);
                        TextView textView = this.mStateText;
                        if (textView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mStateText");
                            textView = null;
                        }
                        textView.setVisibility(8);
                        ViewGroup viewGroup2 = this.mState;
                        if (viewGroup2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mState");
                        } else {
                            viewGroup = viewGroup2;
                        }
                        viewGroup.setVisibility(0);
                        return;
                    }
                    break;
                case 51:
                    if (state.equals("3")) {
                        TextView textView2 = this.mStateText;
                        if (textView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mStateText");
                            textView2 = null;
                        }
                        Context context = getContext();
                        SpColumnContext spColumnContext = context instanceof SpColumnContext ? (SpColumnContext) context : null;
                        String columnType = (spColumnContext == null || (detailViewModel = spColumnContext.getDetailViewModel()) == null) ? null : detailViewModel.getColumnType();
                        if (Intrinsics.areEqual((Object) columnType, (Object) "audio_free") ? true : Intrinsics.areEqual((Object) columnType, (Object) "audio")) {
                            charSequence = FeedpayKt.appContext().getString(R.string.feed_spcolumn_tpl_state_audio);
                        } else {
                            charSequence = FeedpayKt.appContext().getString(R.string.feed_spcolumn_tpl_state_text);
                        }
                        textView2.setText(charSequence);
                        TextView textView3 = this.mStateText;
                        if (textView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mStateText");
                            textView3 = null;
                        }
                        textView3.setVisibility(0);
                        ImageView imageView2 = this.mStateIcon;
                        if (imageView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mStateIcon");
                            imageView2 = null;
                        }
                        imageView2.setVisibility(8);
                        ViewGroup viewGroup3 = this.mState;
                        if (viewGroup3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mState");
                        } else {
                            viewGroup = viewGroup3;
                        }
                        viewGroup.setVisibility(0);
                        return;
                    }
                    break;
                case 52:
                    if (state.equals("4")) {
                        TextView textView4 = this.mStateText;
                        if (textView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mStateText");
                            textView4 = null;
                        }
                        textView4.setText(FeedpayKt.appContext().getString(R.string.feed_spcolumn_tpl_state_text_purchased));
                        TextView textView5 = this.mStateText;
                        if (textView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mStateText");
                            textView5 = null;
                        }
                        textView5.setVisibility(0);
                        ImageView imageView3 = this.mStateIcon;
                        if (imageView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mStateIcon");
                            imageView3 = null;
                        }
                        imageView3.setVisibility(8);
                        ViewGroup viewGroup4 = this.mState;
                        if (viewGroup4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mState");
                        } else {
                            viewGroup = viewGroup4;
                        }
                        viewGroup.setVisibility(0);
                        return;
                    }
                    break;
            }
        }
        ImageView imageView4 = this.mStateIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateIcon");
            imageView4 = null;
        }
        imageView4.setVisibility(8);
        TextView textView6 = this.mStateText;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateText");
            textView6 = null;
        }
        textView6.setVisibility(8);
        ViewGroup viewGroup5 = this.mState;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mState");
        } else {
            viewGroup = viewGroup5;
        }
        viewGroup.setVisibility(8);
    }

    private final void handleDescription(SpColumnBaseItemData data) {
        TextView textView = null;
        if (data instanceof SpColumnTextItemData) {
            this.mTypeIcon = R.drawable.feed_spcolumn_tpl_txt;
            TextView textView2 = this.mDesc;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDesc");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
        } else if (data instanceof SpColumnVideoItemData) {
            this.mTypeIcon = R.drawable.feed_spcolumn_tpl_video;
            String text = calcTimeLength(((SpColumnVideoItemData) data).duration);
            if (!StringsKt.isBlank(text)) {
                TextView textView3 = this.mDesc;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDesc");
                    textView3 = null;
                }
                textView3.setText(text);
                TextView textView4 = this.mDesc;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDesc");
                } else {
                    textView = textView4;
                }
                textView.setVisibility(0);
                return;
            }
            TextView textView5 = this.mDesc;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDesc");
                textView5 = null;
            }
            textView5.setText("00:00");
            TextView textView6 = this.mDesc;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDesc");
            } else {
                textView = textView6;
            }
            textView.setVisibility(0);
        } else {
            this.mTypeIcon = 0;
            TextView textView7 = this.mDesc;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDesc");
            } else {
                textView = textView7;
            }
            textView.setVisibility(8);
        }
    }

    private final String calcTimeLength(String from) {
        StringBuilder sb;
        Integer duration = from != null ? StringsKt.toIntOrNull(from) : null;
        String timeLength = "";
        if (duration == null || duration.intValue() < 0) {
            return timeLength;
        }
        int hour = duration.intValue() / 3600;
        int minuteInSecond = duration.intValue() % 3600;
        int minute = minuteInSecond / 60;
        int second = minuteInSecond % 60;
        boolean z = true;
        if (1 <= hour && hour < 10) {
            timeLength = new StringBuilder().append('0').append(hour).append(AbstractJsonLexerKt.COLON).toString();
        } else {
            if (10 > hour || hour > Integer.MAX_VALUE) {
                z = false;
            }
            if (z) {
                timeLength = new StringBuilder().append(hour).append(AbstractJsonLexerKt.COLON).toString();
            }
        }
        StringBuilder append = new StringBuilder().append(timeLength);
        if (minute < 10) {
            sb = new StringBuilder();
            sb = sb.append('0');
        }
        return append.append(sb.append(minute).append(AbstractJsonLexerKt.COLON).toString()).toString() + (second >= 10 ? String.valueOf(second) : new StringBuilder().append('0').append(second).toString());
    }

    private final void handleReadCount(SpColumnBaseItemData data) {
        Pair pair;
        Long count;
        if (data instanceof SpColumnTextItemData) {
            pair = TuplesKt.to(((SpColumnTextItemData) data).readCount, "阅读");
        } else if (data instanceof SpColumnVideoItemData) {
            pair = TuplesKt.to(((SpColumnVideoItemData) data).playCount, "播放");
        } else {
            pair = TuplesKt.to("", "");
        }
        String countString = (String) pair.component1();
        String countUnit = (String) pair.component2();
        TextView textView = null;
        if (countString != null) {
            boolean z = true;
            if ((!StringsKt.isBlank(countString)) && (count = StringsKt.toLongOrNull(StringsKt.trim((CharSequence) countString).toString())) != null && count.longValue() >= 0) {
                String countText = FeedUtil.convertNumber(FeedpayKt.appContext(), count.longValue());
                CharSequence charSequence = countText;
                if (charSequence != null && !StringsKt.isBlank(charSequence)) {
                    z = false;
                }
                if (z) {
                    TextView textView2 = this.mLabel;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLabel");
                        textView2 = null;
                    }
                    textView2.setText('0' + countUnit);
                } else {
                    TextView textView3 = this.mLabel;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLabel");
                        textView3 = null;
                    }
                    textView3.setText(countText + countUnit);
                }
                TextView textView4 = this.mLabel;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLabel");
                } else {
                    textView = textView4;
                }
                textView.setVisibility(0);
                return;
            }
        }
        TextView textView5 = this.mLabel;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLabel");
            textView5 = null;
        }
        textView5.setText('0' + countUnit);
        TextView textView6 = this.mLabel;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLabel");
        } else {
            textView = textView6;
        }
        textView.setVisibility(0);
    }

    public void onFeedNightModeChanged(boolean isNightMode) {
        super.onFeedNightModeChanged(isNightMode);
        ImageView imageView = null;
        if (this.mTypeIcon != 0) {
            ImageView imageView2 = this.mIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIcon");
                imageView2 = null;
            }
            imageView2.setImageDrawable(getResources().getDrawable(this.mTypeIcon));
        } else {
            ImageView imageView3 = this.mIcon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIcon");
                imageView3 = null;
            }
            imageView3.setVisibility(8);
        }
        TextView textView = this.mDesc;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDesc");
            textView = null;
        }
        textView.setTextColor(getResources().getColor(R.color.grey_999));
        TextView textView2 = this.mLabel;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLabel");
            textView2 = null;
        }
        textView2.setTextColor(getResources().getColor(R.color.grey_999));
        TextView textView3 = this.mStateText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateText");
            textView3 = null;
        }
        textView3.setTextColor(getResources().getColor(R.color.feed_spcolumn_GC62));
        TextView textView4 = this.mStateText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateText");
            textView4 = null;
        }
        textView4.setBackground(getResources().getDrawable(R.drawable.feed_spcolumn_tpl_state_bg));
        ImageView imageView4 = this.mStateIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateIcon");
            imageView4 = null;
        }
        imageView4.setImageDrawable(getResources().getDrawable(R.drawable.feed_spcolumn_tpl_lock));
        TextView textView5 = this.mTitle;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            textView5 = null;
        }
        textView5.setTextColor(getResources().getColor(R.color.black_000));
        Context context = getContext();
        TextView textView6 = this.mTitle;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            textView6 = null;
        }
        SpColumnTextImageViewKt.processText(context, textView6, getFeedModel(), false);
        TextView textView7 = this.mSeqNumber;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeqNumber");
            textView7 = null;
        }
        TextView textView8 = this.mTitle;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            textView8 = null;
        }
        textView7.setTextColor(textView8.getTextColors());
        ImageView imageView5 = this.mProgressIcon;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgressIcon");
        } else {
            imageView = imageView5;
        }
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.feed_spcolumn_progress_locate));
    }

    public void onFontSizeChanged(int fontSizeInPx) {
        super.onFontSizeChanged(fontSizeInPx);
    }

    public FeedTemplate.FeedDividerPolicy getFeedDividerPolicy() {
        return FeedThinDividerPolicy.getDefault();
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateLastRead(com.baidu.searchbox.feed.payment.model.SpColumnLastReadData r12) {
        /*
            r11 = this;
            android.content.Context r0 = r11.getContext()
            if (r0 == 0) goto L_0x00e0
            com.baidu.searchbox.feed.payment.column.facets.SpColumnContext r0 = (com.baidu.searchbox.feed.payment.column.facets.SpColumnContext) r0
            kotlin.jvm.functions.Function0 r0 = r0.getProgressLocateEnable()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001e
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != r1) goto L_0x001e
            r0 = r1
            goto L_0x001f
        L_0x001e:
            r0 = r2
        L_0x001f:
            if (r0 == 0) goto L_0x00da
            com.baidu.searchbox.feed.model.FeedBaseModel r0 = r11.getFeedModel()
            r3 = 0
            if (r0 == 0) goto L_0x002b
            java.lang.String r0 = r0.id
            goto L_0x002c
        L_0x002b:
            r0 = r3
        L_0x002c:
            if (r12 == 0) goto L_0x0033
            java.lang.String r4 = r12.getLastReadId()
            goto L_0x0034
        L_0x0033:
            r4 = r3
        L_0x0034:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x00da
            if (r12 == 0) goto L_0x0041
            java.lang.String r0 = r12.getLastReadProgress()
            goto L_0x0042
        L_0x0041:
            r0 = r3
        L_0x0042:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x004f
            int r0 = r0.length()
            if (r0 != 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r0 = r2
            goto L_0x0050
        L_0x004f:
            r0 = r1
        L_0x0050:
            if (r0 != 0) goto L_0x0097
            if (r12 == 0) goto L_0x0059
            java.lang.String r0 = r12.getLastReadDuration()
            goto L_0x005a
        L_0x0059:
            r0 = r3
        L_0x005a:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0067
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r0 = r2
            goto L_0x0068
        L_0x0067:
            r0 = r1
        L_0x0068:
            if (r0 != 0) goto L_0x0097
            if (r12 == 0) goto L_0x0078
            java.lang.String r0 = r12.getLastReadDuration()
            if (r0 == 0) goto L_0x0078
            double r4 = java.lang.Double.parseDouble(r0)
            int r0 = (int) r4
            goto L_0x0079
        L_0x0078:
            r0 = r2
        L_0x0079:
            if (r0 > 0) goto L_0x007c
            goto L_0x0097
        L_0x007c:
            if (r12 == 0) goto L_0x0082
            java.lang.String r3 = r12.getLastReadProgress()
        L_0x0082:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            double r3 = java.lang.Double.parseDouble(r3)
            int r0 = (int) r3
            int r0 = r0 * 100
            java.lang.String r3 = r12.getLastReadDuration()
            double r3 = java.lang.Double.parseDouble(r3)
            int r3 = (int) r3
            int r0 = r0 / r3
            goto L_0x0098
        L_0x0097:
            r0 = -1
        L_0x0098:
            r11.handleReadDesc(r0)
            r11.updateReadProgressVisibility(r2)
            com.baidu.searchbox.feed.model.FeedBaseModel r3 = r11.getFeedModel()
            if (r3 == 0) goto L_0x00ae
            com.baidu.searchbox.feed.model.FeedRuntimeStatus r3 = r3.runtimeStatus
            if (r3 == 0) goto L_0x00ae
            boolean r3 = r3.isRead
            if (r3 != 0) goto L_0x00ae
            r2 = r1
        L_0x00ae:
            if (r2 == 0) goto L_0x00d6
            com.baidu.searchbox.feed.model.FeedBaseModel r2 = r11.getFeedModel()
            com.baidu.searchbox.feed.model.FeedRuntimeStatus r2 = r2.runtimeStatus
            r2.isRead = r1
            if (r12 == 0) goto L_0x00d6
            r1 = r12
            r2 = 0
            com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnListViewModel r3 = r11.listViewModel
            if (r3 == 0) goto L_0x00d6
            java.lang.String r4 = r1.getLastReadId()
            r5 = 0
            java.lang.String r6 = r1.getLastReadProgress()
            java.lang.String r7 = r1.getLastReadDuration()
            java.lang.String r8 = r1.getTs()
            r9 = 2
            r10 = 0
            com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnListViewModel.saveState$default(r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x00d6:
            r11.handleReadStateUI()
            goto L_0x00df
        L_0x00da:
            r0 = 8
            r11.updateReadProgressVisibility(r0)
        L_0x00df:
            return
        L_0x00e0:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type com.baidu.searchbox.feed.payment.column.facets.SpColumnContext"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.SpColumnTextImageView.updateLastRead(com.baidu.searchbox.feed.payment.model.SpColumnLastReadData):void");
    }
}
