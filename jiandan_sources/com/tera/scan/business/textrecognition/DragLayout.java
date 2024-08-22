package com.tera.scan.business.textrecognition;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import androidx.customview.widget.ViewDragHelper;
import com.tera.scan.app.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u00017B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\nH\u0002J\u0010\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\nH\u0002J\u0006\u0010\"\u001a\u00020\fJ\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u001cH\u0014J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0016J(\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0010\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020'H\u0016J\u000e\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\fJ\u0010\u00101\u001a\u00020\u001c2\b\u00102\u001a\u0004\u0018\u00010\u0012J\u000e\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\fJ\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\nH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/tera/scan/business/textrecognition/DragLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeRatio", "", "contentDragTouchMode", "", "dragBarId", "dragContent", "Landroid/view/View;", "dragContentId", "dragListener", "Lcom/tera/scan/business/textrecognition/DragLayout$DragListener;", "dragRange", "dragView", "isDragging", "isExpanded", "openRatio", "partialVisibleHeight", "viewDragHelper", "Landroidx/customview/widget/ViewDragHelper;", "close", "", "computeScroll", "expand", "fastClose", "yvel", "fastExpand", "getExpandState", "init", "onFinishInflate", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "setContentDragMode", "mode", "setDragListener", "listener", "setExpandState", "expandState", "shouldExpand", "openThreshold", "DragListener", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DragLayout extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Nullable
    public final AttributeSet attrs;
    public float closeRatio;
    public boolean contentDragTouchMode;
    public int dragBarId;
    @Nullable
    public View dragContent;
    public int dragContentId;
    @Nullable
    public DragListener dragListener;
    public int dragRange;
    @Nullable
    public View dragView;
    public boolean isDragging;
    public boolean isExpanded;
    public float openRatio;
    public int partialVisibleHeight;
    @Nullable
    public ViewDragHelper viewDragHelper;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/tera/scan/business/textrecognition/DragLayout$DragListener;", "", "onClose", "", "onDrag", "percent", "", "onOpen", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface DragListener {
        void ad();

        void onClose();

        void qw(float f);
    }

    @JvmOverloads
    public DragLayout(@Nullable Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public DragLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DragLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this._$_findViewCache = new LinkedHashMap();
        this.attrs = attributeSet;
        this.partialVisibleHeight = 100;
        this.openRatio = 0.8f;
        this.closeRatio = 0.8f;
        init();
    }

    /* access modifiers changed from: private */
    public final void close() {
        View view = this.dragContent;
        if (view != null) {
            ViewDragHelper viewDragHelper2 = this.viewDragHelper;
            boolean z = true;
            if (viewDragHelper2 == null || !viewDragHelper2.smoothSlideViewTo(view, 0, getHeight() - this.partialVisibleHeight)) {
                z = false;
            }
            if (z) {
                postInvalidateOnAnimation();
            }
        }
        this.isExpanded = false;
        DragListener dragListener2 = this.dragListener;
        if (dragListener2 != null) {
            dragListener2.onClose();
        }
    }

    /* access modifiers changed from: private */
    public final void expand() {
        View view = this.dragContent;
        if (view != null) {
            ViewDragHelper viewDragHelper2 = this.viewDragHelper;
            boolean z = false;
            if (viewDragHelper2 != null && viewDragHelper2.smoothSlideViewTo(view, 0, 0)) {
                z = true;
            }
            if (z) {
                postInvalidateOnAnimation();
            }
        }
        this.isExpanded = true;
        DragListener dragListener2 = this.dragListener;
        if (dragListener2 != null) {
            dragListener2.ad();
        }
    }

    /* access modifiers changed from: private */
    public final boolean fastClose(float f) {
        return f >= 2000.0f;
    }

    /* access modifiers changed from: private */
    public final boolean fastExpand(float f) {
        return f < -2000.0f;
    }

    private final void init() {
        Context context = getContext();
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(this.attrs, R$styleable.DragLayout) : null;
        if (obtainStyledAttributes != null) {
            this.partialVisibleHeight = (int) obtainStyledAttributes.getDimension(4, 100.0f);
            this.dragBarId = obtainStyledAttributes.getResourceId(0, 0);
            this.dragContentId = obtainStyledAttributes.getResourceId(2, 0);
            this.closeRatio = obtainStyledAttributes.getFloat(1, 0.8f);
            this.openRatio = obtainStyledAttributes.getFloat(3, 0.8f);
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        this.viewDragHelper = ViewDragHelper.create(this, 1.0f, new DragLayout$init$2(this));
    }

    /* access modifiers changed from: private */
    public final boolean shouldExpand(float f) {
        View view = this.dragContent;
        return ((float) (view != null ? view.getTop() : 0)) < f;
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void computeScroll() {
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        boolean z = false;
        if (viewDragHelper2 != null && viewDragHelper2.continueSettling(true)) {
            z = true;
        }
        if (z) {
            postInvalidateOnAnimation();
        }
    }

    public final boolean getExpandState() {
        return this.isExpanded;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.dragBarId;
        if (i2 > 0) {
            this.dragView = findViewById(i2);
        }
        int i3 = this.dragContentId;
        if (i3 > 0) {
            this.dragContent = findViewById(i3);
        }
    }

    public boolean onInterceptTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (this.contentDragTouchMode) {
            return true;
        }
        if (!(this.dragView == null || this.dragContent == null)) {
            ViewDragHelper viewDragHelper2 = this.viewDragHelper;
            if (viewDragHelper2 != null && viewDragHelper2.shouldInterceptTouchEvent(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View view = this.dragContent;
        this.dragRange = view != null ? view.getMeasuredHeight() : 0;
    }

    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (this.dragView == null || this.dragContent == null) {
            return super.onTouchEvent(motionEvent);
        }
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 == null) {
            return true;
        }
        viewDragHelper2.processTouchEvent(motionEvent);
        return true;
    }

    public final void setContentDragMode(boolean z) {
        this.contentDragTouchMode = z;
    }

    public final void setDragListener(@Nullable DragListener dragListener2) {
        this.dragListener = dragListener2;
    }

    public final void setExpandState(boolean z) {
        if (z) {
            expand();
        } else {
            close();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DragLayout(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
