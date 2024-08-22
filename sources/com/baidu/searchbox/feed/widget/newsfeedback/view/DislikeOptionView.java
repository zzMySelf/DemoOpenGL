package com.baidu.searchbox.feed.widget.newsfeedback.view;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.statistic.FeedStatisticCenter;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.feed.widget.newsfeedback.Callback;
import com.baidu.searchbox.feed.widget.newsfeedback.DislikeRequestManager;
import com.baidu.searchbox.feed.widget.newsfeedback.OnClickDislikeListener;
import com.baidu.searchbox.lightbrowser.model.FeedItemTag;
import com.baidu.searchbox.lightbrowser.model.SubTagItem;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020+H\u0002J\u0012\u0010-\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010/\u001a\u00020+2\u0006\u0010\u0007\u001a\u00020\u0012J\u0016\u00100\u001a\u00020+2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000202J\b\u00104\u001a\u00020+H\u0002J\u001a\u00105\u001a\u00020+2\b\u00106\u001a\u0004\u0018\u00010\u00192\b\u00107\u001a\u0004\u0018\u00010\u0019J\b\u00108\u001a\u00020+H\u0002J\b\u00109\u001a\u00020+H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b \u0010\u0016R\u0010\u0010\"\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b%\u0010&R\u0010\u0010(\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/feed/widget/newsfeedback/view/DislikeOptionView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "itemInfo", "Lcom/baidu/searchbox/lightbrowser/model/FeedItemTag;", "listener", "Lcom/baidu/searchbox/feed/widget/newsfeedback/OnClickDislikeListener;", "(Landroid/content/Context;Lcom/baidu/searchbox/lightbrowser/model/FeedItemTag;Lcom/baidu/searchbox/feed/widget/newsfeedback/OnClickDislikeListener;)V", "activity", "arrowImg", "Landroid/widget/ImageView;", "getArrowImg", "()Landroid/widget/ImageView;", "arrowImg$delegate", "Lkotlin/Lazy;", "callback", "Lcom/baidu/searchbox/feed/widget/newsfeedback/Callback;", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "descTv$delegate", "itemId", "", "line", "Landroid/view/View;", "getLine", "()Landroid/view/View;", "line$delegate", "nameTv", "getNameTv", "nameTv$delegate", "onClickListener", "optionIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getOptionIcon", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "optionIcon$delegate", "optionItemInfo", "page", "handleBlacklistRequest", "", "initView", "onClick", "v", "setCallback", "setLineStatus", "index", "", "num", "setOptionIcon", "setStatisticsParams", "source", "nid", "showBlackListDialog", "updateUi", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DislikeOptionView.kt */
public final class DislikeOptionView extends LinearLayout implements View.OnClickListener {
    private Context activity;
    private final Lazy arrowImg$delegate = LazyKt.lazy(new DislikeOptionView$arrowImg$2(this));
    private Callback callback;
    private final Lazy descTv$delegate = LazyKt.lazy(new DislikeOptionView$descTv$2(this));
    private String itemId;
    private final Lazy line$delegate = LazyKt.lazy(new DislikeOptionView$line$2(this));
    private final Lazy nameTv$delegate = LazyKt.lazy(new DislikeOptionView$nameTv$2(this));
    private OnClickDislikeListener onClickListener;
    private final Lazy optionIcon$delegate = LazyKt.lazy(new DislikeOptionView$optionIcon$2(this));
    private FeedItemTag optionItemInfo;
    private String page;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DislikeOptionView(Context context, FeedItemTag itemInfo, OnClickDislikeListener listener) {
        super(context);
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        this.activity = context;
        this.optionItemInfo = itemInfo;
        this.onClickListener = listener;
        setOrientation(1);
        initView();
    }

    private final SimpleDraweeView getOptionIcon() {
        Object value = this.optionIcon$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-optionIcon>(...)");
        return (SimpleDraweeView) value;
    }

    private final TextView getNameTv() {
        Object value = this.nameTv$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-nameTv>(...)");
        return (TextView) value;
    }

    private final TextView getDescTv() {
        Object value = this.descTv$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-descTv>(...)");
        return (TextView) value;
    }

    private final ImageView getArrowImg() {
        Object value = this.arrowImg$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-arrowImg>(...)");
        return (ImageView) value;
    }

    private final View getLine() {
        Object value = this.line$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-line>(...)");
        return (View) value;
    }

    private final void initView() {
        LayoutInflater.from(this.activity).inflate(R.layout.feed_dislike_option_layout, this);
        updateUi();
    }

    private final void updateUi() {
        List<SubTagItem> list;
        TextView nameTv = getNameTv();
        Integer num = null;
        if (nameTv != null) {
            FeedItemTag feedItemTag = this.optionItemInfo;
            nameTv.setText(feedItemTag != null ? feedItemTag.name : null);
        }
        TextView nameTv2 = getNameTv();
        if (nameTv2 != null) {
            nameTv2.setTextColor(getResources().getColor(com.baidu.searchbox.feed.styles.R.color.FC1));
        }
        TextView nameTv3 = getNameTv();
        TextPaint paint = nameTv3 != null ? nameTv3.getPaint() : null;
        if (paint != null) {
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        TextView nameTv4 = getNameTv();
        TextPaint paint2 = nameTv4 != null ? nameTv4.getPaint() : null;
        if (paint2 != null) {
            paint2.setStrokeWidth(0.3f);
        }
        FeedItemTag feedItemTag2 = this.optionItemInfo;
        CharSequence charSequence = feedItemTag2 != null ? feedItemTag2.nameDesc : null;
        if (!(charSequence == null || charSequence.length() == 0)) {
            TextView descTv = getDescTv();
            if (descTv != null) {
                descTv.setVisibility(0);
            }
            TextView descTv2 = getDescTv();
            if (descTv2 != null) {
                FeedItemTag feedItemTag3 = this.optionItemInfo;
                descTv2.setText(feedItemTag3 != null ? feedItemTag3.nameDesc : null);
            }
            TextView descTv3 = getDescTv();
            if (descTv3 != null) {
                descTv3.setTextColor(getResources().getColor(com.baidu.searchbox.feed.styles.R.color.FC2));
            }
        }
        setOptionIcon();
        FeedItemTag feedItemTag4 = this.optionItemInfo;
        if ((feedItemTag4 != null ? feedItemTag4.subTagList : null) != null) {
            FeedItemTag feedItemTag5 = this.optionItemInfo;
            if (!(feedItemTag5 == null || (list = feedItemTag5.subTagList) == null)) {
                num = Integer.valueOf(list.size());
            }
            Intrinsics.checkNotNull(num);
            if (num.intValue() > 0) {
                ImageView arrowImg = getArrowImg();
                if (arrowImg != null) {
                    arrowImg.setVisibility(0);
                }
                getArrowImg().setImageDrawable(getResources().getDrawable(R.drawable.feed_dislike_arrow));
            }
        }
        getLine().setBackgroundColor(getResources().getColor(com.baidu.searchbox.feed.styles.R.color.FC21));
        setOnClickListener(this);
    }

    public final void setLineStatus(int index, int num) {
        View line;
        if (index == num - 1 && (line = getLine()) != null) {
            line.setVisibility(8);
        }
    }

    public final void setStatisticsParams(String source, String nid) {
        this.page = source;
        this.itemId = nid;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setOptionIcon() {
        /*
            r6 = this;
            android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
            r0.<init>()
            r1 = r0
            r2 = 0
            android.content.Context r3 = r6.getContext()
            android.content.res.Resources r3 = r3.getResources()
            int r4 = com.baidu.android.common.ui.style.R.color.GC57
            int r3 = r3.getColor(r4)
            r1.setColor(r3)
            com.facebook.drawee.view.SimpleDraweeView r1 = r6.getOptionIcon()
            com.facebook.drawee.interfaces.DraweeHierarchy r1 = r1.getHierarchy()
            com.facebook.drawee.generic.GenericDraweeHierarchy r1 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r1
            if (r1 == 0) goto L_0x002c
            r2 = r0
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2
            r1.setFailureImage((android.graphics.drawable.Drawable) r2)
        L_0x002c:
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r1 = r6.optionItemInfo
            r2 = 0
            if (r1 == 0) goto L_0x0034
            java.lang.String r1 = r1.itemType
            goto L_0x0035
        L_0x0034:
            r1 = r2
        L_0x0035:
            r3 = 0
            boolean r4 = com.baidu.searchbox.skin.NightModeHelper.isNightMode()
            if (r4 == 0) goto L_0x005b
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r4 = r6.optionItemInfo
            if (r4 == 0) goto L_0x0043
            java.lang.String r4 = r4.iconNight
            goto L_0x0044
        L_0x0043:
            r4 = r2
        L_0x0044:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0079
            com.facebook.drawee.view.SimpleDraweeView r4 = r6.getOptionIcon()
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r5 = r6.optionItemInfo
            if (r5 == 0) goto L_0x0056
            java.lang.String r2 = r5.iconNight
        L_0x0056:
            r4.setImageURI((java.lang.String) r2)
            r3 = 1
            goto L_0x0079
        L_0x005b:
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r4 = r6.optionItemInfo
            if (r4 == 0) goto L_0x0062
            java.lang.String r4 = r4.icon
            goto L_0x0063
        L_0x0062:
            r4 = r2
        L_0x0063:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0079
            com.facebook.drawee.view.SimpleDraweeView r4 = r6.getOptionIcon()
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r5 = r6.optionItemInfo
            if (r5 == 0) goto L_0x0075
            java.lang.String r2 = r5.icon
        L_0x0075:
            r4.setImageURI((java.lang.String) r2)
            r3 = 1
        L_0x0079:
            if (r3 != 0) goto L_0x00f1
            if (r1 == 0) goto L_0x00dd
            int r2 = r1.hashCode()
            switch(r2) {
                case -1406328437: goto L_0x00d1;
                case -1079589895: goto L_0x00c4;
                case -964168620: goto L_0x00b8;
                case -934521548: goto L_0x00ab;
                case 432376400: goto L_0x009e;
                case 522712226: goto L_0x0091;
                case 1069862467: goto L_0x0085;
                default: goto L_0x0084;
            }
        L_0x0084:
            goto L_0x00dd
        L_0x0085:
            java.lang.String r2 = "ad_comment"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x008e
            goto L_0x00dd
        L_0x008e:
            int r2 = com.baidu.searchbox.feed.core.R.drawable.feed_dislike_ad_comment
            goto L_0x00df
        L_0x0091:
            java.lang.String r2 = "uninterested"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x009b
            goto L_0x00dd
        L_0x009b:
            int r2 = com.baidu.searchbox.feed.core.R.drawable.feed_dislike_no_interest
            goto L_0x00df
        L_0x009e:
            java.lang.String r2 = "too_many_similar_content"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x00a8
            goto L_0x00dd
        L_0x00a8:
            int r2 = com.baidu.searchbox.feed.core.R.drawable.feed_dislike_too_many_similar
            goto L_0x00df
        L_0x00ab:
            java.lang.String r2 = "report"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x00b5
            goto L_0x00dd
        L_0x00b5:
            int r2 = com.baidu.searchbox.feed.core.R.drawable.feed_dislike_report
            goto L_0x00df
        L_0x00b8:
            java.lang.String r2 = "action_control"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x00c1
            goto L_0x00dd
        L_0x00c1:
            int r2 = com.baidu.searchbox.feed.core.R.drawable.feed_dislike_control_action
            goto L_0x00df
        L_0x00c4:
            java.lang.String r2 = "not_want_read"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x00ce
            goto L_0x00dd
        L_0x00ce:
            int r2 = com.baidu.searchbox.feed.core.R.drawable.feed_dislike_not_read_such_content
            goto L_0x00df
        L_0x00d1:
            java.lang.String r2 = "author"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x00da
            goto L_0x00dd
        L_0x00da:
            int r2 = com.baidu.searchbox.feed.core.R.drawable.feed_dislike_blocklist_author
            goto L_0x00df
        L_0x00dd:
            int r2 = com.baidu.searchbox.feed.core.R.drawable.feed_dislike_no_interest
        L_0x00df:
            com.facebook.drawee.view.SimpleDraweeView r4 = r6.getOptionIcon()
            if (r4 == 0) goto L_0x00f1
            android.content.res.Resources r5 = r6.getResources()
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r2)
            r4.setImageDrawable(r5)
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.widget.newsfeedback.view.DislikeOptionView.setOptionIcon():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00fc, code lost:
        if (android.text.TextUtils.equals(r0 != null ? r0.itemType : null, com.baidu.searchbox.feed.widget.newsfeedback.DislikeType.NOT_READ_SUCH_CONTENT) != false) goto L_0x00fe;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r5) {
        /*
            r4 = this;
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r0 = r4.optionItemInfo
            r1 = 0
            if (r0 == 0) goto L_0x0008
            java.util.List<com.baidu.searchbox.lightbrowser.model.SubTagItem> r0 = r0.subTagList
            goto L_0x0009
        L_0x0008:
            r0 = r1
        L_0x0009:
            if (r0 == 0) goto L_0x0031
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r0 = r4.optionItemInfo
            if (r0 == 0) goto L_0x001c
            java.util.List<com.baidu.searchbox.lightbrowser.model.SubTagItem> r0 = r0.subTagList
            if (r0 == 0) goto L_0x001c
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x001d
        L_0x001c:
            r0 = r1
        L_0x001d:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.intValue()
            if (r0 <= 0) goto L_0x0031
            com.baidu.searchbox.feed.widget.newsfeedback.OnClickDislikeListener r0 = r4.onClickListener
            if (r0 == 0) goto L_0x013a
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r2 = r4.optionItemInfo
            r0.onClickIntoSubOption(r2)
            goto L_0x013a
        L_0x0031:
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r0 = r4.optionItemInfo
            if (r0 == 0) goto L_0x0038
            java.lang.String r0 = r0.itemType
            goto L_0x0039
        L_0x0038:
            r0 = r1
        L_0x0039:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r2 = "author"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L_0x0051
            com.baidu.searchbox.feed.widget.newsfeedback.OnClickDislikeListener r0 = r4.onClickListener
            if (r0 == 0) goto L_0x004c
            r0.onDislikeDismiss()
        L_0x004c:
            r4.showBlackListDialog()
            goto L_0x013a
        L_0x0051:
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r0 = r4.optionItemInfo
            if (r0 == 0) goto L_0x0058
            java.lang.String r0 = r0.itemType
            goto L_0x0059
        L_0x0058:
            r0 = r1
        L_0x0059:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r2 = "uninterested"
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r0 = android.text.TextUtils.equals(r0, r3)
            if (r0 == 0) goto L_0x0090
            com.baidu.searchbox.lightbrowser.model.SubTagItem r0 = new com.baidu.searchbox.lightbrowser.model.SubTagItem
            r0.<init>()
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r3 = r4.optionItemInfo
            if (r3 == 0) goto L_0x0073
            java.lang.String r3 = r3.id
            goto L_0x0074
        L_0x0073:
            r3 = r1
        L_0x0074:
            r0.id = r3
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r3 = r4.optionItemInfo
            if (r3 == 0) goto L_0x007d
            java.lang.String r3 = r3.name
            goto L_0x007e
        L_0x007d:
            r3 = r1
        L_0x007e:
            r0.name = r3
            com.baidu.searchbox.feed.widget.newsfeedback.Callback r3 = r4.callback
            if (r3 == 0) goto L_0x0087
            r3.onUnInterest(r2, r0)
        L_0x0087:
            com.baidu.searchbox.feed.widget.newsfeedback.OnClickDislikeListener r2 = r4.onClickListener
            if (r2 == 0) goto L_0x013a
            r2.onDislikeDismiss()
            goto L_0x013a
        L_0x0090:
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r0 = r4.optionItemInfo
            if (r0 == 0) goto L_0x0097
            java.lang.String r0 = r0.scheme
            goto L_0x0098
        L_0x0097:
            r0 = r1
        L_0x0098:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00d4
            android.content.Context r0 = r4.activity
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r2 = r4.optionItemInfo
            if (r2 == 0) goto L_0x00a9
            java.lang.String r2 = r2.scheme
            goto L_0x00aa
        L_0x00a9:
            r2 = r1
        L_0x00aa:
            r3 = 0
            com.baidu.searchbox.feed.util.FeedRouter.invoke(r0, r2, r3)
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r0 = r4.optionItemInfo
            if (r0 == 0) goto L_0x00b5
            java.lang.String r0 = r0.itemType
            goto L_0x00b6
        L_0x00b5:
            r0 = r1
        L_0x00b6:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r2 = "report"
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r0 = android.text.TextUtils.equals(r0, r3)
            if (r0 == 0) goto L_0x00cb
            com.baidu.searchbox.feed.widget.newsfeedback.Callback r0 = r4.callback
            if (r0 == 0) goto L_0x00cb
            r0.onUnInterest(r2, r1)
        L_0x00cb:
            com.baidu.searchbox.feed.widget.newsfeedback.OnClickDislikeListener r0 = r4.onClickListener
            if (r0 == 0) goto L_0x013a
            r0.onDislikeDismiss()
            goto L_0x013a
        L_0x00d4:
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r0 = r4.optionItemInfo
            if (r0 == 0) goto L_0x00db
            java.lang.String r0 = r0.itemType
            goto L_0x00dc
        L_0x00db:
            r0 = r1
        L_0x00dc:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r2 = "too_many_similar_content"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 != 0) goto L_0x00fe
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r0 = r4.optionItemInfo
            if (r0 == 0) goto L_0x00f0
            java.lang.String r0 = r0.itemType
            goto L_0x00f1
        L_0x00f0:
            r0 = r1
        L_0x00f1:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r2 = "not_want_read"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L_0x013a
        L_0x00fe:
            com.baidu.searchbox.lightbrowser.model.SubTagItem r0 = new com.baidu.searchbox.lightbrowser.model.SubTagItem
            r0.<init>()
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r2 = r4.optionItemInfo
            if (r2 == 0) goto L_0x010a
            java.lang.String r2 = r2.id
            goto L_0x010b
        L_0x010a:
            r2 = r1
        L_0x010b:
            r0.id = r2
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r2 = r4.optionItemInfo
            if (r2 == 0) goto L_0x0114
            java.lang.String r2 = r2.name
            goto L_0x0115
        L_0x0114:
            r2 = r1
        L_0x0115:
            r0.name = r2
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r2 = r4.optionItemInfo
            if (r2 == 0) goto L_0x011e
            java.lang.String r2 = r2.extInfo
            goto L_0x011f
        L_0x011e:
            r2 = r1
        L_0x011f:
            r0.extInfo = r2
            com.baidu.searchbox.feed.widget.newsfeedback.Callback r2 = r4.callback
            if (r2 == 0) goto L_0x0133
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r3 = r4.optionItemInfo
            if (r3 == 0) goto L_0x012c
            java.lang.String r3 = r3.itemType
            goto L_0x012d
        L_0x012c:
            r3 = r1
        L_0x012d:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r2.onUnInterest(r3, r0)
        L_0x0133:
            com.baidu.searchbox.feed.widget.newsfeedback.OnClickDislikeListener r2 = r4.onClickListener
            if (r2 == 0) goto L_0x013a
            r2.onDislikeDismiss()
        L_0x013a:
            java.lang.String r0 = r4.page
            java.lang.String r2 = r4.itemId
            com.baidu.searchbox.lightbrowser.model.FeedItemTag r3 = r4.optionItemInfo
            if (r3 == 0) goto L_0x0144
            java.lang.String r1 = r3.name
        L_0x0144:
            java.lang.String r3 = "first_click"
            com.baidu.searchbox.feed.statistic.FeedStatisticCenter.dislikeClickStatistics(r3, r0, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.widget.newsfeedback.view.DislikeOptionView.onClick(android.view.View):void");
    }

    public final void setCallback(Callback listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.callback = listener;
    }

    private final void showBlackListDialog() {
        if (this.activity != null) {
            int message = R.string.feed_dislike_blacklist_desc;
            FeedItemTag feedItemTag = this.optionItemInfo;
            if (TextUtils.equals(feedItemTag != null ? feedItemTag.state : null, "1")) {
                message = R.string.feed_dislike_blacklist_desc;
            }
            Context context = this.activity;
            Intrinsics.checkNotNull(context);
            BdAlertDialog.Builder message2 = new BdAlertDialog.Builder(context).setTitle(R.string.feed_dislike_blacklist_author).setMessage(message);
            String string = getResources().getString(R.string.feed_dislike_blacklist_cancel);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…dislike_blacklist_cancel)");
            BdAlertDialog.Builder button = message2.setButton(new BdAlertDialog.ButtonItem(string, new DislikeOptionView$showBlackListDialog$1()));
            String string2 = getResources().getString(R.string.feed_dislike_blacklist_ok);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…eed_dislike_blacklist_ok)");
            button.setButton(new BdAlertDialog.ButtonItem(string2, new DislikeOptionView$showBlackListDialog$2(this))).create().show();
            FeedStatisticCenter.dislikeShowStatistics(FeedStatisticConstants.UBC_VALUE_DISLIKE_SECOND_SHOW, this.page, this.itemId);
        }
    }

    public final void handleBlacklistRequest() {
        SubTagItem subOption = new SubTagItem();
        FeedItemTag feedItemTag = this.optionItemInfo;
        String str = null;
        subOption.id = feedItemTag != null ? feedItemTag.id : null;
        FeedItemTag feedItemTag2 = this.optionItemInfo;
        subOption.name = feedItemTag2 != null ? feedItemTag2.name : null;
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onUnInterest("author", subOption);
        }
        FeedItemTag feedItemTag3 = this.optionItemInfo;
        if (feedItemTag3 != null) {
            str = feedItemTag3.state;
        }
        if (TextUtils.equals(str, "1")) {
            DislikeRequestManager.requestCancelFollow(this.optionItemInfo);
        }
    }
}
