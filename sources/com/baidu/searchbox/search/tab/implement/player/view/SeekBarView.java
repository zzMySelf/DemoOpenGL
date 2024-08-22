package com.baidu.searchbox.search.tab.implement.player.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\bH\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0002J\"\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020\nH\u0002J\u0018\u0010)\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010*\u001a\u00020\u0019H\u0002J\b\u0010+\u001a\u00020\nH\u0007J\b\u0010,\u001a\u00020-H\u0002J7\u0010.\u001a\u00020-2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020%002\b\b\u0001\u0010\t\u001a\u00020\n2\u0006\u00101\u001a\u00020%2\b\u00102\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0014J\u0018\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u0019H\u0014J\u0012\u00108\u001a\u00020\u001f2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007J\u0010\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\fH\u0007J\u0010\u0010;\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\u0017H\u0002J\b\u0010>\u001a\u00020\u001fH\u0002J\b\u0010?\u001a\u00020\u001fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/player/view/SeekBarView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "barRect", "Landroid/graphics/Rect;", "bgPaint", "Landroid/graphics/Paint;", "dragPercent", "", "maxDuration", "", "nodeData", "Lcom/baidu/searchbox/search/tab/implement/player/view/NodeData;", "nodePaint", "getNodePaint", "()Landroid/graphics/Paint;", "nodePaint$delegate", "Lkotlin/Lazy;", "progressPaint", "progressRect", "seekBarStyle", "Lcom/baidu/searchbox/search/tab/implement/player/view/SeekBarStyle;", "shadow", "", "thumbPaint", "thumbRect", "Landroid/graphics/RectF;", "createDefaultPaint", "drawBgLayer", "", "canvas", "Landroid/graphics/Canvas;", "drawDefaultBgLayer", "drawNode", "node", "", "drawNodeBgLayer", "drawProgress", "percent", "drawThumb", "xOffset", "getDragPercent", "hasValidNodeList", "", "isPlayingNode", "nodeList", "", "currNodePer", "nextNodePer", "(Ljava/util/List;FDLjava/lang/Double;)Z", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setDragPercent", "setMaxDuration", "durationMS", "setNodeData", "setStyle", "style", "updateBarRect", "updatePaints", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DragSeekBarView.kt */
final class SeekBarView extends View {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Rect barRect;
    private final Paint bgPaint;
    private float dragPercent;
    private long maxDuration;
    private NodeData nodeData;
    private final Lazy nodePaint$delegate;
    private final Paint progressPaint;
    private final Rect progressRect;
    private SeekBarStyle seekBarStyle;
    private final int shadow;
    private final Paint thumbPaint;
    private final RectF thumbRect;

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
    public SeekBarView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.bgPaint = createDefaultPaint();
        this.progressPaint = createDefaultPaint();
        this.shadow = -872415232;
        Paint $this$thumbPaint_u24lambda_u2d0 = createDefaultPaint();
        $this$thumbPaint_u24lambda_u2d0.setShadowLayer(3.0f, 0.0f, 0.0f, -872415232);
        this.thumbPaint = $this$thumbPaint_u24lambda_u2d0;
        this.nodePaint$delegate = LazyKt.lazy(new SeekBarView$nodePaint$2(this));
        this.seekBarStyle = new SeekBarStyle(0, 0, 0, 0.0f, 0.0f, 0.0f, 0, 127, (DefaultConstructorMarker) null);
        this.barRect = new Rect();
        this.progressRect = new Rect();
        this.thumbRect = new RectF();
        updatePaints();
    }

    private final Paint getNodePaint() {
        return (Paint) this.nodePaint$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Paint createDefaultPaint() {
        Paint $this$createDefaultPaint_u24lambda_u2d1 = new Paint();
        $this$createDefaultPaint_u24lambda_u2d1.setAntiAlias(true);
        return $this$createDefaultPaint_u24lambda_u2d1;
    }

    private final void updatePaints() {
        this.bgPaint.setColor(this.seekBarStyle.getBgColor());
        this.progressPaint.setColor(this.seekBarStyle.getProgressBgColor());
        this.thumbPaint.setColor(this.seekBarStyle.getThumbColor());
    }

    private final void setStyle(SeekBarStyle style) {
        this.seekBarStyle = style;
        updatePaints();
    }

    public final void setNodeData(NodeData nodeData2) {
        Intrinsics.checkNotNullParameter(nodeData2, "nodeData");
        this.nodeData = nodeData2;
        invalidate();
    }

    public final void setMaxDuration(long durationMS) {
        this.maxDuration = durationMS;
    }

    public final void setDragPercent(float dragPercent2) {
        this.dragPercent = dragPercent2;
        invalidate();
    }

    public final float getDragPercent() {
        return this.dragPercent;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        updateBarRect();
    }

    private final void updateBarRect() {
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.barRect.left = getPaddingLeft();
            this.barRect.right = getMeasuredWidth() - getPaddingRight();
            this.barRect.top = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) / 2) - (this.seekBarStyle.getHeight() / 2);
            Rect rect = this.barRect;
            rect.bottom = rect.top + this.seekBarStyle.getHeight();
            this.progressRect.set(this.barRect);
            this.thumbRect.top = (((float) ((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom())) / 2.0f) - (this.seekBarStyle.getThumbHeight() / ((float) 2));
            RectF rectF = this.thumbRect;
            rectF.bottom = rectF.top + this.seekBarStyle.getThumbHeight();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Canvas $this$onDraw_u24lambda_u2d2 = canvas;
        drawBgLayer($this$onDraw_u24lambda_u2d2, this.dragPercent);
        drawProgress($this$onDraw_u24lambda_u2d2, this.dragPercent);
    }

    private final void drawProgress(Canvas canvas, float percent) {
        this.progressRect.right = (int) (((float) this.barRect.right) * percent);
        DragSeekBarViewKt.format(this.progressRect);
        if (!this.progressRect.isEmpty()) {
            canvas.drawRect(this.progressRect, this.progressPaint);
        }
        drawThumb(canvas, this.progressRect.right);
    }

    private final void drawThumb(Canvas canvas, int xOffset) {
        this.thumbRect.left = Math.min((float) xOffset, ((float) this.barRect.width()) - this.seekBarStyle.getThumbWidth());
        RectF rectF = this.thumbRect;
        rectF.right = rectF.left + this.seekBarStyle.getThumbWidth();
        DragSeekBarViewKt.format(this.thumbRect);
        if (!this.thumbRect.isEmpty()) {
            canvas.drawRoundRect(this.thumbRect, this.seekBarStyle.getThumbRoundRadius(), this.seekBarStyle.getThumbRoundRadius(), this.thumbPaint);
        }
    }

    private final void drawBgLayer(Canvas canvas, float dragPercent2) {
        NodeData $this$drawBgLayer_u24lambda_u2d3;
        drawDefaultBgLayer(canvas);
        if (hasValidNodeList() && ($this$drawBgLayer_u24lambda_u2d3 = this.nodeData) != null) {
            drawNodeBgLayer(canvas, dragPercent2, $this$drawBgLayer_u24lambda_u2d3);
        }
    }

    private final void drawDefaultBgLayer(Canvas canvas) {
        canvas.drawRect(this.barRect, this.bgPaint);
    }

    private final void drawNodeBgLayer(Canvas canvas, float dragPercent2, NodeData nodeData2) {
        List<Double> nodeList = nodeData2.getNodeList();
        int nodeListSize = nodeList.size();
        for (int i2 = 0; i2 < nodeListSize; i2++) {
            if (isPlayingNode(nodeList, dragPercent2, nodeList.get(i2).doubleValue(), (Double) CollectionsKt.getOrNull(nodeList, i2 + 1))) {
                getNodePaint().setColor(nodeData2.getHighlightBgColor());
            } else {
                getNodePaint().setColor(nodeData2.getNormalBgColor());
            }
            drawNode(canvas, nodeList.get(i2).doubleValue());
        }
    }

    private final void drawNode(Canvas canvas, double node) {
        float sx = (float) (((double) this.barRect.width()) * node);
        float sy = ((float) this.barRect.top) + ((float) (this.barRect.height() / 2));
        NodeData nodeData2 = this.nodeData;
        canvas.drawCircle(sx, sy, (float) (nodeData2 != null ? nodeData2.getRadius() : ViewExKt.getDp(3)), getNodePaint());
    }

    private final boolean isPlayingNode(List<Double> nodeList, float dragPercent2, double currNodePer, Double nextNodePer) {
        if (((double) dragPercent2) < currNodePer) {
            return false;
        }
        if (Intrinsics.areEqual(currNodePer, (Double) CollectionsKt.lastOrNull(nodeList))) {
            return true;
        }
        if (nextNodePer == null || ((double) dragPercent2) >= nextNodePer.doubleValue()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r0.getNodeList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean hasValidNodeList() {
        /*
            r3 = this;
            com.baidu.searchbox.search.tab.implement.player.view.NodeData r0 = r3.nodeData
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001a
            if (r0 == 0) goto L_0x0016
            java.util.List r0 = r0.getNodeList()
            if (r0 == 0) goto L_0x0016
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r1
            goto L_0x0017
        L_0x0016:
            r0 = r2
        L_0x0017:
            if (r0 == 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r1 = r2
        L_0x001b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.tab.implement.player.view.SeekBarView.hasValidNodeList():boolean");
    }
}
