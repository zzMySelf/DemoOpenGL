package com.baidu.searchbox.feed.template;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.ui.UnifyTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J)\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u001b\"\u00020\rH\u0007¢\u0006\u0002\u0010\u001cR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/feed/template/FeedTagTextView;", "Lcom/baidu/searchbox/ui/UnifyTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tagList", "", "Lcom/baidu/searchbox/feed/template/FeedTagTextView$TagData;", "generateViewBitmap", "Landroid/graphics/Bitmap;", "view", "Landroid/view/View;", "isTag", "", "tag", "", "setTextAndTag", "", "text", "", "tags", "", "(Ljava/lang/String;[Lcom/baidu/searchbox/feed/template/FeedTagTextView$TagData;)V", "CenterImageSpan", "TagData", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTagTextView.kt */
public final class FeedTagTextView extends UnifyTextView {
    private final List<TagData> tagList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedTagTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.tagList = new ArrayList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedTagTextView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedTagTextView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setTextAndTag(String text, TagData... tags) {
        String str = text;
        TagData[] tagDataArr = tags;
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(tagDataArr, "tags");
        boolean z = false;
        if (tagDataArr.length == 0) {
            setTextWithUnifiedPadding(str, TextView.BufferType.NORMAL);
            return;
        }
        this.tagList.clear();
        StringBuilder sb = new StringBuilder(str);
        for (TagData tag : tagDataArr) {
            this.tagList.add(tag);
            sb.append(tag.getText());
        }
        SpannableString spannableString = new SpannableString(sb);
        int tagLength = 0;
        int index = 0;
        int length = tagDataArr.length;
        while (index < length) {
            TagData tag2 = tagDataArr[index];
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.feed_hot_tag_layout, (ViewGroup) null, z);
            if (inflate != null) {
                TextView tagView = (TextView) inflate;
                Drawable background = tagView.getBackground();
                if (background != null) {
                    ((GradientDrawable) background).setColor(tag2.getBgColor());
                    tagView.setTextColor(tag2.getTextColor());
                    tagView.setText(tag2.getText());
                    Bitmap bmp = generateViewBitmap(tagView);
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    CenterImageSpan imageSpan = new CenterImageSpan(this, context, bmp);
                    int startIndex = text.length() + tagLength;
                    tagLength += tag2.getText().length();
                    spannableString.setSpan(imageSpan, startIndex, tag2.getText().length() + startIndex, 33);
                    index++;
                    z = false;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
        }
        setText(spannableString);
        setTextWithUnifiedPadding(spannableString, TextView.BufferType.NORMAL);
    }

    public final boolean isTag(CharSequence tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        for (TagData data : this.tagList) {
            if (TextUtils.equals(tag, data.getText())) {
                return true;
            }
        }
        return false;
    }

    private final Bitmap generateViewBitmap(View view2) {
        view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view2.layout(0, 0, view2.getMeasuredWidth(), view2.getMeasuredHeight());
        view2.buildDrawingCache();
        Bitmap drawingCache = view2.getDrawingCache();
        Intrinsics.checkNotNullExpressionValue(drawingCache, "view.drawingCache");
        return drawingCache;
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JR\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J4\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/feed/template/FeedTagTextView$CenterImageSpan;", "Landroid/text/style/ImageSpan;", "context", "Landroid/content/Context;", "bmp", "Landroid/graphics/Bitmap;", "(Lcom/baidu/searchbox/feed/template/FeedTagTextView;Landroid/content/Context;Landroid/graphics/Bitmap;)V", "tagMargin", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedTagTextView.kt */
    public final class CenterImageSpan extends ImageSpan {
        private int tagMargin;
        final /* synthetic */ FeedTagTextView this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CenterImageSpan(FeedTagTextView this$02, Context context, Bitmap bmp) {
            super(context, bmp);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(bmp, "bmp");
            this.this$0 = this$02;
            this.tagMargin = this$02.getResources().getDimensionPixelSize(R.dimen.F_M_W_X052);
        }

        public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
            Intrinsics.checkNotNullParameter(paint, "paint");
            Rect rect = getDrawable().getBounds();
            Intrinsics.checkNotNullExpressionValue(rect, "drawable.bounds");
            if (fm != null && fm.top == 0 && fm.ascent == 0 && fm.descent == 0 && fm.bottom == 0) {
                paint.getFontMetricsInt(fm);
            }
            return rect.right + this.tagMargin;
        }

        public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fm = paint.getFontMetricsInt();
            int transY = ((((fm.descent + y) + y) + fm.ascent) / 2) - (drawable.getBounds().bottom / 2);
            canvas.save();
            canvas.translate(((float) this.tagMargin) + x, (float) transY);
            if (!(x == 0.0f)) {
                drawable.draw(canvas);
            }
            canvas.restore();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/feed/template/FeedTagTextView$TagData;", "", "text", "", "textColor", "", "bgColor", "(Ljava/lang/String;II)V", "getBgColor", "()I", "getText", "()Ljava/lang/String;", "getTextColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedTagTextView.kt */
    public static final class TagData {
        private final int bgColor;
        private final String text;
        private final int textColor;

        public static /* synthetic */ TagData copy$default(TagData tagData, String str, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = tagData.text;
            }
            if ((i4 & 2) != 0) {
                i2 = tagData.textColor;
            }
            if ((i4 & 4) != 0) {
                i3 = tagData.bgColor;
            }
            return tagData.copy(str, i2, i3);
        }

        public final String component1() {
            return this.text;
        }

        public final int component2() {
            return this.textColor;
        }

        public final int component3() {
            return this.bgColor;
        }

        public final TagData copy(String str, int i2, int i3) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new TagData(str, i2, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TagData)) {
                return false;
            }
            TagData tagData = (TagData) obj;
            return Intrinsics.areEqual((Object) this.text, (Object) tagData.text) && this.textColor == tagData.textColor && this.bgColor == tagData.bgColor;
        }

        public int hashCode() {
            return (((this.text.hashCode() * 31) + Integer.hashCode(this.textColor)) * 31) + Integer.hashCode(this.bgColor);
        }

        public String toString() {
            return "TagData(text=" + this.text + ", textColor=" + this.textColor + ", bgColor=" + this.bgColor + ')';
        }

        public TagData(String text2, int textColor2, int bgColor2) {
            Intrinsics.checkNotNullParameter(text2, "text");
            this.text = text2;
            this.textColor = textColor2;
            this.bgColor = bgColor2;
        }

        public final int getBgColor() {
            return this.bgColor;
        }

        public final String getText() {
            return this.text;
        }

        public final int getTextColor() {
            return this.textColor;
        }
    }
}
