package com.baidu.searchbox.layout;

import android.graphics.Canvas;
import android.view.View;
import com.baidu.searchbox.favor.data.FavorModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u00042345B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u0016\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"J6\u0010&\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bJ8\u0010-\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0018\u00100\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c01R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/baidu/searchbox/layout/HorizontalLayoutManager;", "", "()V", "endItems", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/layout/HorizontalLayoutManager$Item;", "Lkotlin/collections/ArrayList;", "gapOfStartToEnd", "", "getGapOfStartToEnd", "()I", "setGapOfStartToEnd", "(I)V", "items", "marginMerger", "Lcom/baidu/searchbox/layout/HorizontalLayoutManager$MarginMerger;", "getMarginMerger", "()Lcom/baidu/searchbox/layout/HorizontalLayoutManager$MarginMerger;", "setMarginMerger", "(Lcom/baidu/searchbox/layout/HorizontalLayoutManager$MarginMerger;)V", "overflowStrategy", "Lcom/baidu/searchbox/layout/HorizontalLayoutManager$OverflowStrategy;", "getOverflowStrategy", "()Lcom/baidu/searchbox/layout/HorizontalLayoutManager$OverflowStrategy;", "setOverflowStrategy", "(Lcom/baidu/searchbox/layout/HorizontalLayoutManager$OverflowStrategy;)V", "startItems", "addPuddingView", "", "puddingView", "Lcom/baidu/searchbox/layout/PuddingView;", "onConstraint", "onDraw", "view", "Landroid/view/View;", "canvas", "Landroid/graphics/Canvas;", "onInit", "onLayout", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setMeasuredDimension", "Lkotlin/Function2;", "Companion", "Item", "MarginMerger", "OverflowStrategy", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: pudding.kt */
public final class HorizontalLayoutManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final PuddingConstraint flowEnd = new PuddingConstraint("", 1);
    /* access modifiers changed from: private */
    public static final PuddingConstraint flowStart = new PuddingConstraint("", 0);
    /* access modifiers changed from: private */
    public static final PuddingConstraint parentEnd = new PuddingConstraint(FavorModel.KEY_PARENT, 1);
    /* access modifiers changed from: private */
    public static final PuddingConstraint parentStart = new PuddingConstraint(FavorModel.KEY_PARENT, 0);
    private ArrayList<Item> endItems = new ArrayList<>();
    private int gapOfStartToEnd;
    private final ArrayList<Item> items = new ArrayList<>();
    private MarginMerger marginMerger = SimpleMarginMerger.INSTANCE;
    private OverflowStrategy overflowStrategy = new ConsumeOrGone();
    private ArrayList<Item> startItems = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/layout/HorizontalLayoutManager$MarginMerger;", "", "mergeMargin", "", "startLastMargin", "endLastMargin", "gapOfStartToEnd", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: pudding.kt */
    public interface MarginMerger {
        int mergeMargin(int i2, int i3, int i4);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/layout/HorizontalLayoutManager$OverflowStrategy;", "", "onOverflow", "", "puddingViews", "", "Lcom/baidu/searchbox/layout/PuddingViewHolder;", "actualWidth", "expectWidth", "([Lcom/baidu/searchbox/layout/PuddingViewHolder;II)I", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: pudding.kt */
    public interface OverflowStrategy {
        int onOverflow(PuddingViewHolder[] puddingViewHolderArr, int i2, int i3);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/layout/HorizontalLayoutManager$Companion;", "", "()V", "flowEnd", "Lcom/baidu/searchbox/layout/PuddingConstraint;", "getFlowEnd", "()Lcom/baidu/searchbox/layout/PuddingConstraint;", "flowStart", "getFlowStart", "parentEnd", "getParentEnd", "parentStart", "getParentStart", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: pudding.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PuddingConstraint getParentStart() {
            return HorizontalLayoutManager.parentStart;
        }

        public final PuddingConstraint getParentEnd() {
            return HorizontalLayoutManager.parentEnd;
        }

        public final PuddingConstraint getFlowStart() {
            return HorizontalLayoutManager.flowStart;
        }

        public final PuddingConstraint getFlowEnd() {
            return HorizontalLayoutManager.flowEnd;
        }
    }

    public final int getGapOfStartToEnd() {
        return this.gapOfStartToEnd;
    }

    public final void setGapOfStartToEnd(int i2) {
        this.gapOfStartToEnd = i2;
    }

    public final MarginMerger getMarginMerger() {
        return this.marginMerger;
    }

    public final void setMarginMerger(MarginMerger marginMerger2) {
        this.marginMerger = marginMerger2;
    }

    public final OverflowStrategy getOverflowStrategy() {
        return this.overflowStrategy;
    }

    public final void setOverflowStrategy(OverflowStrategy overflowStrategy2) {
        this.overflowStrategy = overflowStrategy2;
    }

    public final void addPuddingView(PuddingView puddingView) {
        Intrinsics.checkNotNullParameter(puddingView, "puddingView");
        this.items.add(new Item(puddingView));
    }

    public final void onInit(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.setWillNotDraw(false);
    }

    public final void onConstraint() {
        HashMap map = new HashMap();
        Iterator<Item> it = this.items.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            PuddingConstraint constraint = item.getPuddingView().getConstraint();
            List found = (List) map.get(constraint);
            if (found == null) {
                found = new ArrayList();
                map.put(constraint, found);
            }
            Intrinsics.checkNotNullExpressionValue(item, "item");
            found.add(item);
        }
        for (List<Item> value : map.values()) {
            if (value.size() > 1) {
                Item selected = null;
                int high = Integer.MIN_VALUE;
                for (Item item2 : value) {
                    PuddingView puddingView = item2.getPuddingView();
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    puddingView.onConflict(value);
                    if (item2.getUser().getVisibility() != 8) {
                        int priority = item2.getUser().getPriority();
                        if (high == Integer.MIN_VALUE || priority > high) {
                            high = priority;
                            selected = item2;
                        }
                    }
                }
                if (selected != null) {
                    Item it2 = selected;
                    for (Item item3 : value) {
                        if (!Intrinsics.areEqual((Object) item3, (Object) it2)) {
                            item3.getPuddingView().setVisibility(8);
                        }
                    }
                }
            }
        }
    }

    public final void onMeasure(View view2, int widthMeasureSpec, int heightMeasureSpec, Function2<? super Integer, ? super Integer, Unit> setMeasuredDimension) {
        int i2;
        int width;
        int height;
        int hideIndex;
        ArrayList<Item> arrayList;
        PuddingView user;
        PuddingView user2;
        Function2<? super Integer, ? super Integer, Unit> function2 = setMeasuredDimension;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(function2, "setMeasuredDimension");
        int totalWidth = 0;
        int maxHeight = 0;
        this.startItems.clear();
        this.endItems.clear();
        Iterator<Item> it = this.items.iterator();
        while (true) {
            i2 = 8;
            if (!it.hasNext()) {
                break;
            }
            Item item = it.next();
            if (item.getUser().getVisibility() != 8) {
                (item.isPlaceFromEnd() ? this.endItems : this.startItems).add(item);
                item.getUser().doMeasure(PuddingKt.getUNSPECIFIED(), PuddingKt.getUNSPECIFIED());
                totalWidth += item.getUser().getMeasuredWidth() + item.getUser().getMargin();
                maxHeight = Math.max(item.getUser().getMeasuredHeight(), maxHeight);
            }
        }
        Item item2 = (Item) CollectionsKt.lastOrNull(this.startItems);
        int startLastMargin = (item2 == null || (user2 = item2.getUser()) == null) ? 0 : user2.getMargin();
        Item item3 = (Item) CollectionsKt.lastOrNull(this.endItems);
        int endLastMargin = (item3 == null || (user = item3.getUser()) == null) ? 0 : user.getMargin();
        int totalWidth2 = totalWidth - (startLastMargin + endLastMargin);
        MarginMerger marginMerger2 = this.marginMerger;
        int totalWidth3 = totalWidth2 + (marginMerger2 != null ? marginMerger2.mergeMargin(startLastMargin, endLastMargin, this.gapOfStartToEnd) : 0);
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int expectWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        int expectHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        int actualWidth = view2.getPaddingLeft() + totalWidth3 + view2.getPaddingRight();
        if (widthMode == 1073741824 && actualWidth > expectWidth) {
            Iterator<Item> it2 = this.items.iterator();
            while (it2.hasNext()) {
                Item item4 = it2.next();
                if (item4.getUser().getVisibility() != i2) {
                    int originW = item4.getUser().getMeasuredWidth();
                    if (item4.getUser().toTrimMode()) {
                        item4.getUser().doMeasure(PuddingKt.getUNSPECIFIED(), PuddingKt.getUNSPECIFIED());
                        actualWidth -= originW - item4.getUser().getMeasuredWidth();
                        View view3 = view2;
                        i2 = 8;
                    }
                }
                View view4 = view2;
                i2 = 8;
            }
            if (actualWidth > expectWidth) {
                Object[] array = CollectionsKt.plus(this.startItems, this.endItems).toArray(new Item[0]);
                if (array != null) {
                    ArraysKt.sortWith((Item[]) array, new HorizontalLayoutManager$$ExternalSyntheticLambda0());
                    Item[] priorityItemArray = (Item[]) array;
                    OverflowStrategy overflowStrategy2 = this.overflowStrategy;
                    if (overflowStrategy2 != null) {
                        hideIndex = overflowStrategy2.onOverflow((PuddingViewHolder[]) priorityItemArray, actualWidth, expectWidth);
                    } else {
                        hideIndex = -1;
                    }
                    for (int i3 = 0; i3 < hideIndex; i3++) {
                        if (priorityItemArray[i3].isPlaceFromEnd()) {
                            arrayList = this.endItems;
                        } else {
                            arrayList = this.startItems;
                        }
                        arrayList.remove(priorityItemArray[i3]);
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
            }
        }
        if (widthMode == 1073741824) {
            width = expectWidth;
        } else {
            width = view2.getPaddingLeft() + totalWidth3 + view2.getPaddingRight();
        }
        if (heightMode == 1073741824) {
            height = expectHeight;
        } else {
            height = view2.getPaddingTop() + maxHeight + view2.getPaddingBottom();
        }
        function2.invoke(Integer.valueOf(width), Integer.valueOf(height));
    }

    /* access modifiers changed from: private */
    /* renamed from: onMeasure$lambda-2$lambda-1  reason: not valid java name */
    public static final int m20683onMeasure$lambda2$lambda1(Item l, Item r) {
        return Intrinsics.compare(l.getUser().getPriority(), r.getUser().getPriority());
    }

    public final void onLayout(View view2, boolean changed, int l, int t, int r, int b2) {
        View view3 = view2;
        Intrinsics.checkNotNullParameter(view2, "view");
        int left = l + view2.getPaddingLeft();
        Iterator<Item> it = this.startItems.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            int w = item.getUser().getMeasuredWidth();
            int h2 = item.getUser().getMeasuredHeight();
            int top = t + ((int) (((float) ((b2 - t) - h2)) / 2.0f));
            item.getUser().doLayout(left, top, left + w, top + h2);
            item.setLeft(left - view2.getLeft());
            item.setTop(top - view2.getTop());
            left += item.getUser().getMargin() + w;
        }
        int right = r - view2.getPaddingRight();
        Iterator<Item> it2 = this.endItems.iterator();
        while (it2.hasNext()) {
            Item item2 = it2.next();
            int w2 = item2.getUser().getMeasuredWidth();
            int h3 = item2.getUser().getMeasuredHeight();
            int top2 = t + ((int) (((float) ((b2 - t) - h3)) / 2.0f));
            item2.getUser().doLayout(right - w2, top2, right, top2 + h3);
            item2.setLeft((right - w2) - view2.getLeft());
            item2.setTop(top2 - view2.getTop());
            right -= item2.getUser().getMargin() + w2;
        }
    }

    public final void onDraw(View view2, Canvas canvas) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Iterator<Item> it = this.items.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            if (item.getUser().getVisibility() == 0) {
                int count = canvas.save();
                canvas.clipRect(item.getLeft(), item.getTop(), item.getLeft() + item.getUser().getMeasuredWidth(), item.getTop() + item.getUser().getMeasuredHeight());
                canvas.translate((float) item.getLeft(), (float) item.getTop());
                item.getUser().doDraw(canvas);
                canvas.restoreToCount(count);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/layout/HorizontalLayoutManager$Item;", "Lcom/baidu/searchbox/layout/PuddingViewHolder;", "user", "Lcom/baidu/searchbox/layout/PuddingView;", "(Lcom/baidu/searchbox/layout/PuddingView;)V", "left", "", "getLeft", "()I", "setLeft", "(I)V", "top", "getTop", "setTop", "getUser", "()Lcom/baidu/searchbox/layout/PuddingView;", "getPuddingView", "isPlaceFromEnd", "", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: pudding.kt */
    private static final class Item implements PuddingViewHolder {
        private int left;
        private int top;
        private final PuddingView user;

        public Item(PuddingView user2) {
            Intrinsics.checkNotNullParameter(user2, "user");
            this.user = user2;
        }

        public final PuddingView getUser() {
            return this.user;
        }

        public final int getLeft() {
            return this.left;
        }

        public final void setLeft(int i2) {
            this.left = i2;
        }

        public final int getTop() {
            return this.top;
        }

        public final void setTop(int i2) {
            this.top = i2;
        }

        public PuddingView getPuddingView() {
            return this.user;
        }

        public final boolean isPlaceFromEnd() {
            return this.user.getConstraint().getRelativePosition() == 1;
        }
    }
}
