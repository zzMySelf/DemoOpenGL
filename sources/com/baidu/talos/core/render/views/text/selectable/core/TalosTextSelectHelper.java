package com.baidu.talos.core.render.views.text.selectable.core;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.baidu.talos.TalosAdapterManager;
import com.baidu.talos.adapter.TokenizorInterface;
import com.baidu.talos.core.render.views.text.ReactTextView;
import com.baidu.talos.core.render.views.text.frescosupport.FrescoBasedReactTextInlineImageSpan;
import com.baidu.talos.core.render.views.text.selectable.listener.LimitRegionProvider;
import com.baidu.talos.core.render.views.text.selectable.listener.SelectableTextLongClickListener;
import com.baidu.talos.core.render.views.text.selectable.listener.SelectableTextTouchListener;
import com.baidu.talos.core.render.views.text.selectable.listener.TextSelectStateChangedListener;
import com.baidu.talos.core.render.views.text.selectable.menu.ITextSelectMenu;
import com.baidu.talos.util.DeviceUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0016\b\u0007\u0018\u0000 Ï\u00012\u00020\u0001:\u0002Ï\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\n\u0010«\u0001\u001a\u00030¬\u0001H\u0002J\u001b\u0010­\u0001\u001a\u00020f2\u0007\u0010®\u0001\u001a\u00020\u00052\u0007\u0010¯\u0001\u001a\u00020\u0005H\u0002J\b\u0010°\u0001\u001a\u00030¬\u0001J\b\u0010±\u0001\u001a\u00030¬\u0001J\u0012\u0010²\u0001\u001a\u00020\u00052\u0007\u0010³\u0001\u001a\u00020\u0005H\u0002J\u0012\u0010´\u0001\u001a\u00020\u00052\u0007\u0010µ\u0001\u001a\u00020\u0005H\u0002J\b\u0010¶\u0001\u001a\u00030¬\u0001J\u0012\u0010·\u0001\u001a\u0004\u0018\u00010N2\u0007\u0010¸\u0001\u001a\u00020\rJ\b\u0010¹\u0001\u001a\u00030º\u0001J\b\u0010»\u0001\u001a\u00030º\u0001J\u0007\u0010¼\u0001\u001a\u00020\u0005J\u0007\u0010½\u0001\u001a\u00020\u0005J\u0013\u0010¾\u0001\u001a\u00030¬\u00012\t\b\u0002\u0010¿\u0001\u001a\u00020\rJ\n\u0010À\u0001\u001a\u00030¬\u0001H\u0002J\u0011\u0010Á\u0001\u001a\u00030¬\u00012\u0007\u0010Â\u0001\u001a\u00020\u0005J\b\u0010Ã\u0001\u001a\u00030¬\u0001J\b\u0010Ä\u0001\u001a\u00030¬\u0001J$\u0010Å\u0001\u001a\u00030¬\u00012\u0007\u0010µ\u0001\u001a\u00020\u00052\u0007\u0010³\u0001\u001a\u00020\u00052\b\b\u0002\u00109\u001a\u00020\rJ\u0013\u0010Æ\u0001\u001a\u00030¬\u00012\t\u0010Ç\u0001\u001a\u0004\u0018\u00010~J\u0014\u0010È\u0001\u001a\u00030¬\u00012\n\u0010Ç\u0001\u001a\u0005\u0018\u00010\u0001J\b\u0010É\u0001\u001a\u00030¬\u0001J\u0013\u0010Ê\u0001\u001a\u00030¬\u00012\t\u0010Ë\u0001\u001a\u0004\u0018\u00010NJ%\u0010Ì\u0001\u001a\u00030¬\u00012\u0007\u0010®\u0001\u001a\u00020\u00052\u0007\u0010¯\u0001\u001a\u00020\u00052\t\b\u0002\u0010Í\u0001\u001a\u00020\rJ\u0013\u0010Î\u0001\u001a\u00030¬\u00012\t\b\u0002\u0010Í\u0001\u001a\u00020\rR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015R\u001a\u00100\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0013\"\u0004\b1\u0010\u0015R\u001a\u00102\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0013\"\u0004\b3\u0010\u0015R\u001a\u00104\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0013\"\u0004\b5\u0010\u0015R$\u00107\u001a\u00020\r2\u0006\u00106\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u0010\u0015R\u001a\u00109\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0013\"\u0004\b:\u0010\u0015R(\u0010<\u001a\u0004\u0018\u00010;2\b\u00106\u001a\u0004\u0018\u00010;8F@FX\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R*\u0010B\u001a\u0004\u0018\u00010A2\b\u00106\u001a\u0004\u0018\u00010A8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u0010_\u001a\u0004\u0018\u00010`X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001c\u0010k\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010P\"\u0004\bm\u0010RR\u001a\u0010n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\"\"\u0004\bp\u0010$R\u001a\u0010q\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\"\"\u0004\bs\u0010$R\u001a\u0010t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\"\"\u0004\bv\u0010$R*\u0010x\u001a\u0004\u0018\u00010w2\b\u00106\u001a\u0004\u0018\u00010w8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0010\u0010}\u001a\u0004\u0018\u00010~X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\"\"\u0005\b\u0001\u0010$R\u001c\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\"\"\u0005\b\u0001\u0010$R\u001d\u0010\u0001\u001a\u00020\u001cX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001e\"\u0005\b\u0001\u0010 R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\rX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0013\"\u0005\b\u0001\u0010\u0015R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010 \u0001R \u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R\"\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001¨\u0006Ð\u0001"}, d2 = {"Lcom/baidu/talos/core/render/views/text/selectable/core/TalosTextSelectHelper;", "", "textView", "Lcom/baidu/talos/core/render/views/text/ReactTextView;", "cursorHandleColor", "", "selectedBgColor", "(Lcom/baidu/talos/core/render/views/text/ReactTextView;II)V", "selectedColor", "selectedColorNight", "cursorHandleSizeInDp", "", "autoHookLongClick", "", "canSlideHorizontalWhenSelect", "tokenView", "Landroid/view/View;", "(Lcom/baidu/talos/core/render/views/text/ReactTextView;IIIFZZLandroid/view/View;)V", "getAutoHookLongClick", "()Z", "setAutoHookLongClick", "(Z)V", "getCanSlideHorizontalWhenSelect", "setCanSlideHorizontalWhenSelect", "canTextScroll", "getCanTextScroll", "setCanTextScroll", "clearSessionStartRunable", "Ljava/lang/Runnable;", "getClearSessionStartRunable", "()Ljava/lang/Runnable;", "setClearSessionStartRunable", "(Ljava/lang/Runnable;)V", "getCursorHandleColor", "()I", "setCursorHandleColor", "(I)V", "cursorHandleSize", "getCursorHandleSize", "setCursorHandleSize", "getCursorHandleSizeInDp", "()F", "setCursorHandleSizeInDp", "(F)V", "hasBeyondSlopWhenMove", "hasLongClickTriggered", "isDefaultAllSelecting", "setDefaultAllSelecting", "isHide", "setHide", "isHideWhenScroll", "setHideWhenScroll", "isSelectTextWhenLongClick", "setSelectTextWhenLongClick", "value", "isSelecting", "setSelecting", "isSessionStart", "setSessionStart", "Landroid/graphics/Rect;", "limitRect", "getLimitRect", "()Landroid/graphics/Rect;", "setLimitRect", "(Landroid/graphics/Rect;)V", "Lcom/baidu/talos/core/render/views/text/selectable/listener/LimitRegionProvider;", "limitRegionProvider", "getLimitRegionProvider", "()Lcom/baidu/talos/core/render/views/text/selectable/listener/LimitRegionProvider;", "setLimitRegionProvider", "(Lcom/baidu/talos/core/render/views/text/selectable/listener/LimitRegionProvider;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mEndHandle", "Lcom/baidu/talos/core/render/views/text/selectable/core/CursorHandle;", "getMEndHandle", "()Lcom/baidu/talos/core/render/views/text/selectable/core/CursorHandle;", "setMEndHandle", "(Lcom/baidu/talos/core/render/views/text/selectable/core/CursorHandle;)V", "mOnPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "getMOnPreDrawListener", "()Landroid/view/ViewTreeObserver$OnPreDrawListener;", "setMOnPreDrawListener", "(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V", "mOnScrollChangeListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "getMOnScrollChangeListener", "()Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "setMOnScrollChangeListener", "(Landroid/view/ViewTreeObserver$OnScrollChangedListener;)V", "mOperateMenu", "Lcom/baidu/talos/core/render/views/text/selectable/core/TextOperateMenu;", "getMOperateMenu", "()Lcom/baidu/talos/core/render/views/text/selectable/core/TextOperateMenu;", "setMOperateMenu", "(Lcom/baidu/talos/core/render/views/text/selectable/core/TextOperateMenu;)V", "mSelectionInfo", "Lcom/baidu/talos/core/render/views/text/selectable/core/SelectionInfo;", "getMSelectionInfo", "()Lcom/baidu/talos/core/render/views/text/selectable/core/SelectionInfo;", "setMSelectionInfo", "(Lcom/baidu/talos/core/render/views/text/selectable/core/SelectionInfo;)V", "mStartHandle", "getMStartHandle", "setMStartHandle", "mTouchX", "getMTouchX", "setMTouchX", "mTouchY", "getMTouchY", "setMTouchY", "originalHighlightColor", "getOriginalHighlightColor", "setOriginalHighlightColor", "Lcom/baidu/talos/core/render/views/text/selectable/listener/TextSelectStateChangedListener;", "selectStateChangeListener", "getSelectStateChangeListener", "()Lcom/baidu/talos/core/render/views/text/selectable/listener/TextSelectStateChangedListener;", "setSelectStateChangeListener", "(Lcom/baidu/talos/core/render/views/text/selectable/listener/TextSelectStateChangedListener;)V", "selectableTextLongClickListener", "Lcom/baidu/talos/core/render/views/text/selectable/listener/SelectableTextLongClickListener;", "selectableTextTouchListener", "Lcom/baidu/talos/core/render/views/text/selectable/listener/SelectableTextTouchListener;", "getSelectedColor", "setSelectedColor", "getSelectedColorNight", "setSelectedColorNight", "showSelectViewRunable", "getShowSelectViewRunable", "setShowSelectViewRunable", "span", "Lcom/baidu/talos/core/render/views/text/selectable/core/TalosTextBackgroundSpan;", "getSpan", "()Lcom/baidu/talos/core/render/views/text/selectable/core/TalosTextBackgroundSpan;", "setSpan", "(Lcom/baidu/talos/core/render/views/text/selectable/core/TalosTextBackgroundSpan;)V", "spannable", "Landroid/text/Spannable;", "getSpannable", "()Landroid/text/Spannable;", "setSpannable", "(Landroid/text/Spannable;)V", "startListenScroll", "getStartListenScroll", "setStartListenScroll", "textCoords", "", "getTextCoords", "()[I", "setTextCoords", "([I)V", "getTextView", "()Lcom/baidu/talos/core/render/views/text/ReactTextView;", "setTextView", "(Lcom/baidu/talos/core/render/views/text/ReactTextView;)V", "getTokenView", "()Landroid/view/View;", "setTokenView", "(Landroid/view/View;)V", "tokenizor", "Lcom/baidu/talos/adapter/TokenizorInterface;", "getTokenizor", "()Lcom/baidu/talos/adapter/TokenizorInterface;", "setTokenizor", "(Lcom/baidu/talos/adapter/TokenizorInterface;)V", "adjustSelection", "", "caculateSelectRange", "touchX", "touchY", "cancelSelect", "changeCursorDirection", "checkStartEnd", "end", "checkStartIndex", "start", "destroy", "getCursorHandle", "isLeft", "getEmojiTextSelected", "", "getTextSelected", "getTextSelectedEnd", "getTextSelectedStart", "hideSelectView", "showAnimator", "postClearSessionStartTask", "postShowSelectView", "duration", "removeCustomMenu", "resetSelectionInfo", "selectText", "setSelectableTextLongClickListener", "listener", "setSelectableTextTouchListener", "showBackgroundWindow", "showCursorHandle", "cursorHandle", "showSelectView", "isAllSelect", "startSelect", "Companion", "lib-talos-modules_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosTextSelectHelper.kt */
public final class TalosTextSelectHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_CLEAR_SESSIONSTART_DURATION = 80;
    public static final int DEFAULT_CURSORHANDLE_COLOR = -448956929;
    public static final int DEFAULT_CURSORHANDLE_COLOR_NIGHT = -14272904;
    public static final float DEFAULT_CURSOR_HANDLE_SIZE_DP = 10.0f;
    public static final int DEFAULT_SELECTED_COLOR = 855675359;
    public static final int DEFAULT_SELECTED_COLOR_NIGHT = 857233008;
    public static final int DEFAULT_SELECTION_LENGTH = 1;
    public static final int DEFAULT_SHOW_DURATION = 200;
    private static final String TAG = "BdTextSelectHelper";
    public static final char TOKENIZOR_SPLIT = '\u0001';
    public static final String TOKENIZOR_SYMBOL_TAG = "w";
    private boolean autoHookLongClick;
    private boolean canSlideHorizontalWhenSelect;
    private boolean canTextScroll;
    private Runnable clearSessionStartRunable;
    private int cursorHandleColor;
    private int cursorHandleSize;
    private float cursorHandleSizeInDp;
    private boolean hasBeyondSlopWhenMove;
    private boolean hasLongClickTriggered;
    private boolean isDefaultAllSelecting;
    private boolean isHide;
    private boolean isHideWhenScroll;
    private boolean isSelectTextWhenLongClick;
    private boolean isSessionStart;
    private LimitRegionProvider limitRegionProvider;
    private Context mContext;
    private CursorHandle mEndHandle;
    private ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    private ViewTreeObserver.OnScrollChangedListener mOnScrollChangeListener;
    private TextOperateMenu mOperateMenu;
    private SelectionInfo mSelectionInfo;
    private CursorHandle mStartHandle;
    private int mTouchX;
    private int mTouchY;
    private int originalHighlightColor;
    private TextSelectStateChangedListener selectStateChangeListener;
    private SelectableTextLongClickListener selectableTextLongClickListener;
    private SelectableTextTouchListener selectableTextTouchListener;
    private int selectedColor;
    private int selectedColorNight;
    private Runnable showSelectViewRunable;
    private TalosTextBackgroundSpan span;
    private Spannable spannable;
    private boolean startListenScroll;
    private int[] textCoords;
    private ReactTextView textView;
    private View tokenView;
    private TokenizorInterface tokenizor;

    public TalosTextSelectHelper(ReactTextView textView2, int cursorHandleColor2, int selectedColor2, int selectedColorNight2, float cursorHandleSizeInDp2, boolean autoHookLongClick2, boolean canSlideHorizontalWhenSelect2, View tokenView2) {
        ReactTextView reactTextView = textView2;
        Intrinsics.checkNotNullParameter(reactTextView, "textView");
        this.textView = reactTextView;
        this.cursorHandleColor = cursorHandleColor2;
        this.selectedColor = selectedColor2;
        this.selectedColorNight = selectedColorNight2;
        this.cursorHandleSizeInDp = cursorHandleSizeInDp2;
        this.autoHookLongClick = autoHookLongClick2;
        this.canSlideHorizontalWhenSelect = canSlideHorizontalWhenSelect2;
        this.tokenView = tokenView2;
        SelectionInfo selectionInfo = r9;
        SelectionInfo selectionInfo2 = new SelectionInfo(0, 0, 0, (CharSequence) null, 15, (DefaultConstructorMarker) null);
        this.mSelectionInfo = selectionInfo;
        this.isHide = true;
        this.isSelectTextWhenLongClick = true;
        this.textCoords = new int[2];
        this.mOnPreDrawListener = new TalosTextSelectHelper$mOnPreDrawListener$1(this);
        this.showSelectViewRunable = new TalosTextSelectHelper$$ExternalSyntheticLambda1(this);
        this.clearSessionStartRunable = new TalosTextSelectHelper$$ExternalSyntheticLambda2(this);
        this.mOnScrollChangeListener = new TalosTextSelectHelper$mOnScrollChangeListener$1(this);
        Context context = this.textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "textView.context");
        this.mContext = context;
        this.cursorHandleSize = DeviceUtils.ScreenInfo.dp2px(context, this.cursorHandleSizeInDp);
        ReactTextView $this$_init__u24lambda_u2d8 = this.textView;
        $this$_init__u24lambda_u2d8.setText(this.textView.getText(), TextView.BufferType.SPANNABLE);
        this.originalHighlightColor = this.textView.getHighlightColor();
        if (this.autoHookLongClick) {
            $this$_init__u24lambda_u2d8.setOnLongClickListener(new TalosTextSelectHelper$$ExternalSyntheticLambda3(this));
        }
        $this$_init__u24lambda_u2d8.setOnTouchListener(new TalosTextSelectHelper$$ExternalSyntheticLambda4(this));
        $this$_init__u24lambda_u2d8.addOnAttachStateChangeListener(new TalosTextSelectHelper$1$3(this, $this$_init__u24lambda_u2d8));
        this.mOperateMenu = new TextOperateMenu(this.mContext, this);
        this.tokenizor = TalosAdapterManager.getTokenizorAdapter();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TalosTextSelectHelper(com.baidu.talos.core.render.views.text.ReactTextView r8, int r9, int r10, int r11, float r12, boolean r13, boolean r14, android.view.View r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r7 = this;
            r0 = r16
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            r1 = -448956929(0xffffffffe53d75ff, float:-5.5918994E22)
            goto L_0x000b
        L_0x000a:
            r1 = r9
        L_0x000b:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0013
            r2 = 855675359(0x330091df, float:2.993499E-8)
            goto L_0x0014
        L_0x0013:
            r2 = r10
        L_0x0014:
            r3 = r0 & 8
            if (r3 == 0) goto L_0x001c
            r3 = 857233008(0x33185670, float:3.5468872E-8)
            goto L_0x001d
        L_0x001c:
            r3 = r11
        L_0x001d:
            r4 = r0 & 16
            if (r4 == 0) goto L_0x0024
            r4 = 1092616192(0x41200000, float:10.0)
            goto L_0x0025
        L_0x0024:
            r4 = r12
        L_0x0025:
            r5 = r0 & 32
            if (r5 == 0) goto L_0x002b
            r5 = 1
            goto L_0x002c
        L_0x002b:
            r5 = r13
        L_0x002c:
            r6 = r0 & 64
            if (r6 == 0) goto L_0x0032
            r6 = 0
            goto L_0x0033
        L_0x0032:
            r6 = r14
        L_0x0033:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0039
            r0 = 0
            goto L_0x003a
        L_0x0039:
            r0 = r15
        L_0x003a:
            r9 = r7
            r10 = r8
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.talos.core.render.views.text.selectable.core.TalosTextSelectHelper.<init>(com.baidu.talos.core.render.views.text.ReactTextView, int, int, int, float, boolean, boolean, android.view.View, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ReactTextView getTextView() {
        return this.textView;
    }

    public final void setTextView(ReactTextView reactTextView) {
        Intrinsics.checkNotNullParameter(reactTextView, "<set-?>");
        this.textView = reactTextView;
    }

    public final int getCursorHandleColor() {
        return this.cursorHandleColor;
    }

    public final void setCursorHandleColor(int i2) {
        this.cursorHandleColor = i2;
    }

    public final int getSelectedColor() {
        return this.selectedColor;
    }

    public final void setSelectedColor(int i2) {
        this.selectedColor = i2;
    }

    public final int getSelectedColorNight() {
        return this.selectedColorNight;
    }

    public final void setSelectedColorNight(int i2) {
        this.selectedColorNight = i2;
    }

    public final float getCursorHandleSizeInDp() {
        return this.cursorHandleSizeInDp;
    }

    public final void setCursorHandleSizeInDp(float f2) {
        this.cursorHandleSizeInDp = f2;
    }

    public final boolean getAutoHookLongClick() {
        return this.autoHookLongClick;
    }

    public final void setAutoHookLongClick(boolean z) {
        this.autoHookLongClick = z;
    }

    public final boolean getCanSlideHorizontalWhenSelect() {
        return this.canSlideHorizontalWhenSelect;
    }

    public final void setCanSlideHorizontalWhenSelect(boolean z) {
        this.canSlideHorizontalWhenSelect = z;
    }

    public final View getTokenView() {
        return this.tokenView;
    }

    public final void setTokenView(View view2) {
        this.tokenView = view2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TalosTextSelectHelper(ReactTextView textView2, int cursorHandleColor2, int selectedBgColor) {
        this(textView2, cursorHandleColor2, selectedBgColor, 857233008, 10.0f, true, false, (View) null);
        Intrinsics.checkNotNullParameter(textView2, "textView");
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/talos/core/render/views/text/selectable/core/TalosTextSelectHelper$Companion;", "", "()V", "DEFAULT_CLEAR_SESSIONSTART_DURATION", "", "DEFAULT_CURSORHANDLE_COLOR", "DEFAULT_CURSORHANDLE_COLOR_NIGHT", "DEFAULT_CURSOR_HANDLE_SIZE_DP", "", "DEFAULT_SELECTED_COLOR", "DEFAULT_SELECTED_COLOR_NIGHT", "DEFAULT_SELECTION_LENGTH", "DEFAULT_SHOW_DURATION", "TAG", "", "TOKENIZOR_SPLIT", "", "TOKENIZOR_SYMBOL_TAG", "isDebug", "", "context", "Landroid/content/Context;", "lib-talos-modules_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TalosTextSelectHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean isDebug(Context context) {
            try {
                if ((context.getApplicationInfo().flags & 2) != 0) {
                    return true;
                }
                return false;
            } catch (Exception e2) {
                return false;
            }
        }
    }

    public final int getCursorHandleSize() {
        return this.cursorHandleSize;
    }

    public final void setCursorHandleSize(int i2) {
        this.cursorHandleSize = i2;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    public final int getMTouchX() {
        return this.mTouchX;
    }

    public final void setMTouchX(int i2) {
        this.mTouchX = i2;
    }

    public final int getMTouchY() {
        return this.mTouchY;
    }

    public final void setMTouchY(int i2) {
        this.mTouchY = i2;
    }

    public final CursorHandle getMStartHandle() {
        return this.mStartHandle;
    }

    public final void setMStartHandle(CursorHandle cursorHandle) {
        this.mStartHandle = cursorHandle;
    }

    public final CursorHandle getMEndHandle() {
        return this.mEndHandle;
    }

    public final void setMEndHandle(CursorHandle cursorHandle) {
        this.mEndHandle = cursorHandle;
    }

    public final TextOperateMenu getMOperateMenu() {
        return this.mOperateMenu;
    }

    public final void setMOperateMenu(TextOperateMenu textOperateMenu) {
        this.mOperateMenu = textOperateMenu;
    }

    public final SelectionInfo getMSelectionInfo() {
        return this.mSelectionInfo;
    }

    public final void setMSelectionInfo(SelectionInfo selectionInfo) {
        Intrinsics.checkNotNullParameter(selectionInfo, "<set-?>");
        this.mSelectionInfo = selectionInfo;
    }

    public final Spannable getSpannable() {
        return this.spannable;
    }

    public final void setSpannable(Spannable spannable2) {
        this.spannable = spannable2;
    }

    public final TalosTextBackgroundSpan getSpan() {
        return this.span;
    }

    public final void setSpan(TalosTextBackgroundSpan talosTextBackgroundSpan) {
        this.span = talosTextBackgroundSpan;
    }

    public final boolean isHideWhenScroll() {
        return this.isHideWhenScroll;
    }

    public final void setHideWhenScroll(boolean z) {
        this.isHideWhenScroll = z;
    }

    public final boolean isHide() {
        return this.isHide;
    }

    public final void setHide(boolean z) {
        this.isHide = z;
    }

    public final boolean isSelectTextWhenLongClick() {
        return this.isSelectTextWhenLongClick;
    }

    public final void setSelectTextWhenLongClick(boolean z) {
        this.isSelectTextWhenLongClick = z;
    }

    public final boolean isSelecting() {
        return !this.isHide;
    }

    public final void setSelecting(boolean value) {
    }

    public final TextSelectStateChangedListener getSelectStateChangeListener() {
        return this.selectStateChangeListener;
    }

    public final void setSelectStateChangeListener(TextSelectStateChangedListener value) {
        this.selectStateChangeListener = value;
    }

    public final boolean isDefaultAllSelecting() {
        return this.isDefaultAllSelecting;
    }

    public final void setDefaultAllSelecting(boolean z) {
        this.isDefaultAllSelecting = z;
    }

    public final int getOriginalHighlightColor() {
        return this.originalHighlightColor;
    }

    public final void setOriginalHighlightColor(int i2) {
        this.originalHighlightColor = i2;
    }

    public final int[] getTextCoords() {
        return this.textCoords;
    }

    public final void setTextCoords(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.textCoords = iArr;
    }

    public final boolean getStartListenScroll() {
        return this.startListenScroll;
    }

    public final void setStartListenScroll(boolean z) {
        this.startListenScroll = z;
    }

    public final LimitRegionProvider getLimitRegionProvider() {
        return this.limitRegionProvider;
    }

    public final void setLimitRegionProvider(LimitRegionProvider value) {
        this.limitRegionProvider = value;
    }

    public final Rect getLimitRect() {
        LimitRegionProvider provider = getLimitRegionProvider();
        if (provider != null) {
            return provider.getLimitRegion(this.textView);
        }
        return null;
    }

    public final void setLimitRect(Rect value) {
    }

    public final boolean getCanTextScroll() {
        return this.canTextScroll;
    }

    public final void setCanTextScroll(boolean z) {
        this.canTextScroll = z;
    }

    public final ViewTreeObserver.OnPreDrawListener getMOnPreDrawListener() {
        return this.mOnPreDrawListener;
    }

    public final void setMOnPreDrawListener(ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
        Intrinsics.checkNotNullParameter(onPreDrawListener, "<set-?>");
        this.mOnPreDrawListener = onPreDrawListener;
    }

    public final Runnable getShowSelectViewRunable() {
        return this.showSelectViewRunable;
    }

    public final void setShowSelectViewRunable(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "<set-?>");
        this.showSelectViewRunable = runnable;
    }

    /* access modifiers changed from: private */
    /* renamed from: showSelectViewRunable$lambda-1  reason: not valid java name */
    public static final void m8144showSelectViewRunable$lambda1(TalosTextSelectHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean isAttached = this$0.textView.getWindowToken() != null;
        if (!this$0.isHide) {
            if (isAttached) {
                TextOperateMenu textOperateMenu = this$0.mOperateMenu;
                if (textOperateMenu != null) {
                    textOperateMenu.showMenu();
                }
                TextOperateMenu textOperateMenu2 = this$0.mOperateMenu;
                if (textOperateMenu2 != null) {
                    textOperateMenu2.showMenuEvent();
                }
                CursorHandle cursorHandle = this$0.mStartHandle;
                if (cursorHandle != null) {
                    this$0.showCursorHandle(cursorHandle);
                }
                CursorHandle cursorHandle2 = this$0.mEndHandle;
                if (cursorHandle2 != null) {
                    this$0.showCursorHandle(cursorHandle2);
                }
            } else {
                this$0.resetSelectionInfo();
                this$0.hideSelectView(false);
            }
            this$0.startListenScroll = false;
        }
    }

    public final Runnable getClearSessionStartRunable() {
        return this.clearSessionStartRunable;
    }

    public final void setClearSessionStartRunable(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "<set-?>");
        this.clearSessionStartRunable = runnable;
    }

    /* access modifiers changed from: private */
    /* renamed from: clearSessionStartRunable$lambda-2  reason: not valid java name */
    public static final void m8139clearSessionStartRunable$lambda2(TalosTextSelectHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isSessionStart = false;
    }

    public final ViewTreeObserver.OnScrollChangedListener getMOnScrollChangeListener() {
        return this.mOnScrollChangeListener;
    }

    public final void setMOnScrollChangeListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Intrinsics.checkNotNullParameter(onScrollChangedListener, "<set-?>");
        this.mOnScrollChangeListener = onScrollChangedListener;
    }

    public final boolean isSessionStart() {
        return this.isSessionStart;
    }

    public final void setSessionStart(boolean z) {
        this.isSessionStart = z;
    }

    public final TokenizorInterface getTokenizor() {
        return this.tokenizor;
    }

    public final void setTokenizor(TokenizorInterface tokenizorInterface) {
        this.tokenizor = tokenizorInterface;
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-8$lambda-5  reason: not valid java name */
    public static final boolean m8140lambda8$lambda5(TalosTextSelectHelper this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isSelectTextWhenLongClick) {
            this$0.textView.setHighlightColor(0);
            showSelectView$default(this$0, this$0.mTouchX, this$0.mTouchY, false, 4, (Object) null);
            this$0.hasLongClickTriggered = true;
            this$0.textView.getRootView().setOnTouchListener(new TalosTextSelectHelper$$ExternalSyntheticLambda5(this$0));
        }
        SelectableTextLongClickListener longClickListener = this$0.selectableTextLongClickListener;
        if (longClickListener != null) {
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            longClickListener.onLongClick(view2);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-8$lambda-5$lambda-3  reason: not valid java name */
    public static final boolean m8141lambda8$lambda5$lambda3(TalosTextSelectHelper this$0, View v, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cancelSelect();
        this$0.textView.getRootView().setOnTouchListener((View.OnTouchListener) null);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-8$lambda-7  reason: not valid java name */
    public static final boolean m8142lambda8$lambda7(TalosTextSelectHelper this$0, View v, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mTouchX = (int) event.getX();
        this$0.mTouchY = (int) event.getY();
        SelectableTextTouchListener touchListener = this$0.selectableTextTouchListener;
        if (touchListener != null) {
            Intrinsics.checkNotNullExpressionValue(v, "v");
            Intrinsics.checkNotNullExpressionValue(event, "event");
            touchListener.onTouch(v, event);
        }
        if (BackgroundManager.INSTANCE.isShowing()) {
            return true;
        }
        return false;
    }

    public final void postShowSelectView(int duration) {
        this.textView.removeCallbacks(this.showSelectViewRunable);
        if (duration <= 0) {
            this.showSelectViewRunable.run();
        } else {
            this.textView.postDelayed(this.showSelectViewRunable, 200);
        }
    }

    /* access modifiers changed from: private */
    public final void postClearSessionStartTask() {
        this.textView.removeCallbacks(this.clearSessionStartRunable);
        this.textView.postDelayed(this.clearSessionStartRunable, 80);
    }

    public static /* synthetic */ void hideSelectView$default(TalosTextSelectHelper talosTextSelectHelper, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        talosTextSelectHelper.hideSelectView(z);
    }

    public final void hideSelectView(boolean showAnimator) {
        ViewParent parent;
        this.isHide = true;
        BackgroundManager.INSTANCE.dismissBackgroundWindow();
        CursorHandle cursorHandle = this.mStartHandle;
        if (cursorHandle != null) {
            cursorHandle.dismiss(showAnimator);
        }
        CursorHandle cursorHandle2 = this.mEndHandle;
        if (cursorHandle2 != null) {
            cursorHandle2.dismiss(showAnimator);
        }
        TextOperateMenu textOperateMenu = this.mOperateMenu;
        if (textOperateMenu != null) {
            textOperateMenu.dismissMenu(showAnimator);
        }
        TextOperateMenu textOperateMenu2 = this.mOperateMenu;
        if (textOperateMenu2 != null) {
            textOperateMenu2.dismissMenuEvent();
        }
        this.textView.setHighlightColor(this.originalHighlightColor);
        TextSelectStateChangedListener stateListener = getSelectStateChangeListener();
        if (stateListener != null) {
            stateListener.onSelectStateChanged(this.textView, false);
        }
        ReactTextView reactTextView = this.textView;
        if (reactTextView != null && (parent = reactTextView.getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public static /* synthetic */ void showSelectView$default(TalosTextSelectHelper talosTextSelectHelper, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z = false;
        }
        talosTextSelectHelper.showSelectView(i2, i3, z);
    }

    public final void showSelectView(int touchX, int touchY, boolean isAllSelect) {
        ViewParent parent;
        if (this.textView.getText() instanceof Spannable) {
            CharSequence text = this.textView.getText();
            if (text != null) {
                this.spannable = (Spannable) text;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.text.Spannable");
            }
        }
        if (this.spannable != null) {
            if (this.mStartHandle == null) {
                this.mStartHandle = new CursorHandle(this.mContext, this, true);
            }
            if (this.mEndHandle == null) {
                this.mEndHandle = new CursorHandle(this.mContext, this, false);
            }
            int startOffset = 0;
            int endOffset = this.textView.getText().length();
            if (!isAllSelect) {
                SelectionInfo range = caculateSelectRange((this.canTextScroll ? this.textView.getScrollX() : 0) + touchX, (this.canTextScroll ? this.textView.getScrollY() : 0) + touchY);
                startOffset = range.getStart();
                endOffset = range.getEnd();
            }
            if (startOffset >= this.textView.getText().length()) {
                startOffset = this.textView.getText().length() - 1;
            }
            if (endOffset > this.textView.getText().length()) {
                endOffset = this.textView.getText().length();
            }
            this.isHide = false;
            this.isSessionStart = true;
            TextSelectStateChangedListener stateListener = getSelectStateChangeListener();
            if (stateListener != null) {
                stateListener.onSelectStateChanged(this.textView, true);
            }
            showBackgroundWindow();
            selectText(startOffset, endOffset, true);
            showCursorHandle(this.mStartHandle);
            showCursorHandle(this.mEndHandle);
            TextOperateMenu textOperateMenu = this.mOperateMenu;
            if (textOperateMenu != null) {
                textOperateMenu.showMenuEvent();
            }
            TextOperateMenu textOperateMenu2 = this.mOperateMenu;
            if (textOperateMenu2 != null) {
                textOperateMenu2.showMenu();
            }
            ReactTextView reactTextView = this.textView;
            if (reactTextView != null && (parent = reactTextView.getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r14v0 */
    /* JADX WARNING: type inference failed for: r14v17 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r14v1, types: [int, char] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x03b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.baidu.talos.core.render.views.text.selectable.core.SelectionInfo caculateSelectRange(int r33, int r34) {
        /*
            r32 = this;
            r0 = r32
            com.baidu.talos.core.render.views.text.selectable.core.LayoutUtil r1 = com.baidu.talos.core.render.views.text.selectable.core.LayoutUtil.INSTANCE
            com.baidu.talos.core.render.views.text.ReactTextView r2 = r0.textView
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = r33
            r4 = r34
            int r1 = r1.getPreciseOffset(r2, r3, r4)
            com.baidu.talos.core.render.views.text.selectable.core.SelectionInfo r2 = new com.baidu.talos.core.render.views.text.selectable.core.SelectionInfo
            int r7 = r1 + 1
            r8 = 0
            r9 = 0
            r10 = 12
            r11 = 0
            r5 = r2
            r6 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11)
            int r5 = r1 + -10
            int r6 = r1 + 10
            if (r5 >= 0) goto L_0x0026
            int r6 = r6 - r5
            r5 = 0
        L_0x0026:
            com.baidu.talos.core.render.views.text.ReactTextView r7 = r0.textView
            java.lang.CharSequence r7 = r7.getText()
            int r7 = r7.length()
            if (r6 <= r7) goto L_0x003c
            com.baidu.talos.core.render.views.text.ReactTextView r7 = r0.textView
            java.lang.CharSequence r7 = r7.getText()
            int r6 = r7.length()
        L_0x003c:
            com.baidu.talos.core.render.views.text.ReactTextView r7 = r0.textView
            java.lang.CharSequence r7 = r7.getText()
            java.lang.CharSequence r7 = r7.subSequence(r5, r6)
            com.baidu.talos.adapter.TokenizorInterface r8 = r0.tokenizor
            if (r8 == 0) goto L_0x0053
            java.lang.String r9 = r7.toString()
            java.lang.String r8 = r8.cutString(r9)
            goto L_0x0054
        L_0x0053:
            r8 = 0
        L_0x0054:
            com.baidu.talos.core.render.views.text.ReactTextView r9 = r0.textView
            android.content.Context r9 = r9.getContext()
            com.baidu.talos.core.render.views.text.selectable.core.TalosTextSelectHelper$Companion r10 = Companion
            java.lang.String r11 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r11)
            boolean r10 = r10.isDebug(r9)
            java.lang.String r12 = "BdTextSelectHelper"
            if (r10 == 0) goto L_0x00cd
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r13 = "stringCut -- textLength="
            java.lang.StringBuilder r10 = r10.append(r13)
            com.baidu.talos.core.render.views.text.ReactTextView r13 = r0.textView
            java.lang.CharSequence r13 = r13.getText()
            int r13 = r13.length()
            java.lang.StringBuilder r10 = r10.append(r13)
            java.lang.String r13 = ", touchOffset="
            java.lang.StringBuilder r10 = r10.append(r13)
            java.lang.StringBuilder r10 = r10.append(r1)
            java.lang.String r13 = ", targetStart="
            java.lang.StringBuilder r10 = r10.append(r13)
            java.lang.StringBuilder r10 = r10.append(r5)
            java.lang.String r13 = ", targetEnd="
            java.lang.StringBuilder r10 = r10.append(r13)
            java.lang.StringBuilder r10 = r10.append(r6)
            java.lang.String r10 = r10.toString()
            android.util.Log.d(r12, r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r13 = "stringCut -- input="
            java.lang.StringBuilder r10 = r10.append(r13)
            java.lang.StringBuilder r10 = r10.append(r7)
            java.lang.String r13 = ", output="
            java.lang.StringBuilder r10 = r10.append(r13)
            java.lang.StringBuilder r10 = r10.append(r8)
            java.lang.String r10 = r10.toString()
            android.util.Log.d(r12, r10)
        L_0x00cd:
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r14 = 1
            if (r10 == 0) goto L_0x00dc
            boolean r10 = kotlin.text.StringsKt.isBlank(r10)
            if (r10 == 0) goto L_0x00da
            goto L_0x00dc
        L_0x00da:
            r10 = 0
            goto L_0x00dd
        L_0x00dc:
            r10 = r14
        L_0x00dd:
            if (r10 != 0) goto L_0x03e5
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
            r15 = r8
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            java.lang.String r16 = " "
            java.lang.String[] r16 = new java.lang.String[]{r16}
            r17 = 0
            r18 = 0
            r19 = 6
            r20 = 0
            java.util.List r15 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r15, (java.lang.String[]) r16, (boolean) r17, (int) r18, (int) r19, (java.lang.Object) r20)
            java.util.Collection r15 = (java.util.Collection) r15
            r10.addAll(r15)
            r15 = r10
            java.util.Collection r15 = (java.util.Collection) r15
            boolean r15 = r15.isEmpty()
            if (r15 != 0) goto L_0x03da
            r15 = r5
            r16 = -1
            r17 = -1
            r18 = -1
            r19 = -1
            int r13 = r7.length()
            java.util.Iterator r21 = r10.iterator()
            r22 = r16
            r23 = r17
            r24 = r18
            r25 = r19
            r16 = 0
        L_0x0124:
            boolean r17 = r21.hasNext()
            if (r17 == 0) goto L_0x035f
            r17 = r16
            int r16 = r16 + 1
            java.lang.Object r18 = r21.next()
            java.lang.String r18 = (java.lang.String) r18
            r26 = r18
            java.lang.CharSequence r26 = (java.lang.CharSequence) r26
            char[] r3 = new char[r14]
            r19 = 0
            r3[r19] = r14
            r28 = 0
            r29 = 0
            r30 = 6
            r31 = 0
            r27 = r3
            java.util.List r3 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r26, (char[]) r27, (boolean) r28, (int) r29, (int) r30, (java.lang.Object) r31)
            boolean r19 = r3.isEmpty()
            if (r19 == 0) goto L_0x0155
            r26 = r5
            goto L_0x0192
        L_0x0155:
            int r4 = r3.size()
            if (r4 != r14) goto L_0x019a
            int r4 = r17 + 1
            int r14 = r10.size()
            if (r4 >= r14) goto L_0x018f
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r26 = r5
            r5 = 0
            java.lang.Object r27 = r3.get(r5)
            r5 = r27
            java.lang.String r5 = (java.lang.String) r5
            java.lang.StringBuilder r5 = r14.append(r5)
            r14 = 32
            java.lang.StringBuilder r5 = r5.append(r14)
            java.lang.Object r14 = r10.get(r4)
            java.lang.String r14 = (java.lang.String) r14
            java.lang.StringBuilder r5 = r5.append(r14)
            java.lang.String r5 = r5.toString()
            r10.set(r4, r5)
            goto L_0x0191
        L_0x018f:
            r26 = r5
        L_0x0191:
        L_0x0192:
            r3 = r33
            r4 = r34
            r5 = r26
            r14 = 1
            goto L_0x0124
        L_0x019a:
            r26 = r5
            r4 = 1
            java.lang.Object r5 = r3.get(r4)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x01ae
            boolean r4 = kotlin.text.StringsKt.isBlank(r5)
            if (r4 == 0) goto L_0x01ac
            goto L_0x01ae
        L_0x01ac:
            r4 = 0
            goto L_0x01af
        L_0x01ae:
            r4 = 1
        L_0x01af:
            if (r4 == 0) goto L_0x01c6
            r4 = 0
            java.lang.Object r5 = r3.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            int r5 = r5.length()
            int r15 = r15 + r5
            r3 = r33
            r4 = r34
            r5 = r26
            r14 = 1
            goto L_0x0124
        L_0x01c6:
            r4 = 0
            r5 = r15
            java.lang.Object r14 = r3.get(r4)
            java.lang.String r14 = (java.lang.String) r14
            int r14 = r14.length()
            int r14 = r14 + r15
            java.lang.Object r27 = r3.get(r4)
            java.lang.String r27 = (java.lang.String) r27
            int r4 = r27.length()
            int r15 = r15 + r4
            com.baidu.talos.core.render.views.text.selectable.core.TalosTextSelectHelper$Companion r4 = Companion
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r11)
            boolean r27 = r4.isDebug(r9)
            r28 = r6
            java.lang.String r6 = ", wordTag="
            if (r27 == 0) goto L_0x0239
            r27 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r29 = r8
            java.lang.String r8 = "cutString - wordText="
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = 0
            java.lang.Object r30 = r3.get(r8)
            r8 = r30
            java.lang.String r8 = (java.lang.String) r8
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r7 = r7.append(r6)
            r8 = 1
            java.lang.Object r30 = r3.get(r8)
            r8 = r30
            java.lang.String r8 = (java.lang.String) r8
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = ", start="
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r7 = r7.append(r5)
            java.lang.String r8 = ", end="
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r7 = r7.append(r14)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r12, r7)
            goto L_0x023d
        L_0x0239:
            r27 = r7
            r29 = r8
        L_0x023d:
            java.lang.String r7 = ", wordText="
            if (r1 < r5) goto L_0x02bc
            if (r1 >= r14) goto L_0x02bc
            r8 = r5
            r22 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r11)
            boolean r4 = r4.isDebug(r9)
            if (r4 == 0) goto L_0x02a3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r30 = r10
            java.lang.String r10 = "indexShotin -- touchOffset="
            java.lang.StringBuilder r4 = r4.append(r10)
            java.lang.StringBuilder r4 = r4.append(r1)
            java.lang.String r10 = ", shotInStart="
            java.lang.StringBuilder r4 = r4.append(r10)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r10 = ", shotInEnd="
            java.lang.StringBuilder r4 = r4.append(r10)
            r10 = r22
            java.lang.StringBuilder r4 = r4.append(r10)
            java.lang.StringBuilder r4 = r4.append(r7)
            r7 = 0
            java.lang.Object r22 = r3.get(r7)
            r7 = r22
            java.lang.String r7 = (java.lang.String) r7
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.StringBuilder r4 = r4.append(r6)
            r6 = 1
            java.lang.Object r7 = r3.get(r6)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r12, r4)
            goto L_0x02a7
        L_0x02a3:
            r30 = r10
            r10 = r22
        L_0x02a7:
            r3 = r33
            r4 = r34
            r22 = r8
            r23 = r10
            r5 = r26
            r7 = r27
            r6 = r28
            r8 = r29
            r10 = r30
            r14 = 1
            goto L_0x0124
        L_0x02bc:
            r30 = r10
            int r8 = r1 - r5
            int r8 = java.lang.Math.abs(r8)
            int r10 = r1 - r14
            int r10 = java.lang.Math.abs(r10)
            int r8 = java.lang.Math.min(r8, r10)
            if (r8 >= r13) goto L_0x034b
            r10 = r5
            r24 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r11)
            boolean r4 = r4.isDebug(r9)
            if (r4 == 0) goto L_0x0331
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r31 = r5
            java.lang.String r5 = "neareastGet -- touchOffset="
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r1)
            java.lang.String r5 = ", neareastStart="
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r10)
            java.lang.String r5 = ", neareastEnd="
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r24
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r7)
            r7 = 0
            java.lang.Object r20 = r3.get(r7)
            r7 = r20
            java.lang.String r7 = (java.lang.String) r7
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.StringBuilder r4 = r4.append(r6)
            r6 = 1
            java.lang.Object r7 = r3.get(r6)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r12, r4)
            goto L_0x0336
        L_0x0331:
            r31 = r5
            r5 = r24
            r6 = 1
        L_0x0336:
            r3 = r33
            r4 = r34
            r25 = r5
            r14 = r6
            r24 = r10
            r5 = r26
            r7 = r27
            r6 = r28
            r8 = r29
            r10 = r30
            goto L_0x0124
        L_0x034b:
            r31 = r5
            r6 = 1
            r3 = r33
            r4 = r34
            r14 = r6
            r5 = r26
            r7 = r27
            r6 = r28
            r8 = r29
            r10 = r30
            goto L_0x0124
        L_0x035f:
            r26 = r5
            r28 = r6
            r27 = r7
            r29 = r8
            r30 = r10
            r8 = r22
            if (r8 < 0) goto L_0x037c
            r10 = r23
            if (r10 < 0) goto L_0x037e
            r2.setStart(r8)
            r2.setEnd(r10)
            r3 = r24
            r5 = r25
            goto L_0x038f
        L_0x037c:
            r10 = r23
        L_0x037e:
            r3 = r24
            if (r3 < 0) goto L_0x038d
            r5 = r25
            if (r5 < 0) goto L_0x038f
            r2.setStart(r3)
            r2.setEnd(r5)
            goto L_0x038f
        L_0x038d:
            r5 = r25
        L_0x038f:
            int r4 = r2.getStart()
            int r4 = r0.checkStartIndex(r4)
            r2.setStart(r4)
            int r4 = r2.getEnd()
            int r4 = r0.checkStartEnd(r4)
            r2.setEnd(r4)
            com.baidu.talos.core.render.views.text.selectable.core.TalosTextSelectHelper$Companion r4 = Companion
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r11)
            boolean r4 = r4.isDebug(r9)
            if (r4 == 0) goto L_0x03ed
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "caculate-finished: result.start = "
            java.lang.StringBuilder r4 = r4.append(r6)
            int r6 = r2.getStart()
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r6 = ", result.end = "
            java.lang.StringBuilder r4 = r4.append(r6)
            int r6 = r2.getEnd()
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r12, r4)
            goto L_0x03ed
        L_0x03da:
            r26 = r5
            r28 = r6
            r27 = r7
            r29 = r8
            r30 = r10
            goto L_0x03ed
        L_0x03e5:
            r26 = r5
            r28 = r6
            r27 = r7
            r29 = r8
        L_0x03ed:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.talos.core.render.views.text.selectable.core.TalosTextSelectHelper.caculateSelectRange(int, int):com.baidu.talos.core.render.views.text.selectable.core.SelectionInfo");
    }

    private final int checkStartEnd(int end) {
        if (end < 0 || end > this.textView.getText().length()) {
            return this.textView.getText().length();
        }
        int ret = end;
        Layout textLayout = this.textView.getLayout();
        if (textLayout == null) {
            return ret;
        }
        return textLayout.getOffsetForHorizontal(textLayout.getLineForOffset(end), textLayout.getPrimaryHorizontal(end));
    }

    private final int checkStartIndex(int start) {
        if (start <= 0) {
            return start;
        }
        int ret = start;
        Layout textLayout = this.textView.getLayout();
        if (textLayout == null) {
            return ret;
        }
        int targetStart = start - 1;
        float startXPos = textLayout.getPrimaryHorizontal(start);
        float targetXPos = textLayout.getPrimaryHorizontal(targetStart);
        if (!(startXPos == targetXPos)) {
            return start;
        }
        while (true) {
            if ((startXPos == targetXPos) && targetStart >= 0) {
                targetStart--;
                if (targetStart >= 0) {
                    targetXPos = textLayout.getPrimaryHorizontal(targetStart);
                }
            }
        }
        return targetStart + 1;
    }

    public final void showBackgroundWindow() {
        BackgroundManager.INSTANCE.showBackGroundWindow(this);
    }

    public final void showCursorHandle(CursorHandle cursorHandle) {
        Layout layout = this.textView.getLayout();
        boolean z = true;
        if (cursorHandle == null || !cursorHandle.isLeft()) {
            z = false;
        }
        int offset = z ? this.mSelectionInfo.getStart() : this.mSelectionInfo.getEnd();
        int bottom = (int) (((float) layout.getLineBaseline(layout.getLineForOffset(offset))) + layout.getPaint().descent());
        if (cursorHandle != null) {
            LayoutUtil layoutUtil = LayoutUtil.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(layout, "layout");
            cursorHandle.show((int) layoutUtil.getPrimaryHorizontal(layout, offset), bottom);
        }
    }

    public final void resetSelectionInfo() {
        this.mSelectionInfo.setSelectionContent((CharSequence) null);
        this.mSelectionInfo.setStart(0);
        this.mSelectionInfo.setEnd(0);
        Spannable spannable2 = this.spannable;
        if (spannable2 != null) {
            TalosTextBackgroundSpan talosTextBackgroundSpan = this.span;
            if (talosTextBackgroundSpan != null) {
                if (spannable2 != null) {
                    spannable2.removeSpan(talosTextBackgroundSpan);
                }
                this.span = null;
            }
            Spannable spannable3 = this.spannable;
            if (spannable3 != null) {
                spannable3.removeSpan(Selection.SELECTION_START);
            }
            Spannable spannable4 = this.spannable;
            if (spannable4 != null) {
                spannable4.removeSpan(Selection.SELECTION_END);
            }
        }
    }

    public final CursorHandle getCursorHandle(boolean isLeft) {
        if (isLeft) {
            return this.mStartHandle;
        }
        return this.mEndHandle;
    }

    public static /* synthetic */ void selectText$default(TalosTextSelectHelper talosTextSelectHelper, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z = false;
        }
        talosTextSelectHelper.selectText(i2, i3, z);
    }

    public final void selectText(int start, int end, boolean isSessionStart2) {
        if (start >= 0) {
            this.mSelectionInfo.setStart(start);
        }
        if (end > 0) {
            this.mSelectionInfo.setEnd(end);
        }
        this.mSelectionInfo.checkPos();
        if (this.spannable != null) {
            adjustSelection();
            Spannable spannable2 = this.spannable;
            int spanLength = spannable2 != null ? spannable2.length() : 0;
            if (this.mSelectionInfo.getEnd() > spanLength) {
                this.mSelectionInfo.setEnd(spanLength);
            }
            SelectionInfo selectionInfo = this.mSelectionInfo;
            Spannable spannable3 = this.spannable;
            selectionInfo.setSelectionContent(spannable3 != null ? spannable3.subSequence(selectionInfo.getStart(), this.mSelectionInfo.getEnd()) : null);
            Selection.setSelection(this.spannable, this.mSelectionInfo.getStart(), this.mSelectionInfo.getEnd());
            if (this.span == null) {
                this.span = new TalosTextBackgroundSpan(this);
            }
            Spannable spannable4 = this.spannable;
            if (spannable4 != null) {
                spannable4.setSpan(this.span, 0, this.textView.getText().length(), 17);
            }
            TextSelectStateChangedListener stateListener = getSelectStateChangeListener();
            if (stateListener != null) {
                stateListener.onSelectionChanged(this.textView, this.mSelectionInfo.getStart(), this.mSelectionInfo.getEnd(), this.mSelectionInfo.getSelectionContent());
            }
            if (!isSessionStart2) {
                this.isDefaultAllSelecting = false;
            }
        }
    }

    private final void adjustSelection() {
        Layout textLayout = this.textView.getLayout();
        if (textLayout != null) {
            Layout layout = textLayout;
            float startX = layout.getPrimaryHorizontal(this.mSelectionInfo.getStart());
            int startLine = layout.getLineForOffset(this.mSelectionInfo.getStart());
            this.mSelectionInfo.setStart(layout.getOffsetForHorizontal(startLine, startX));
            float endX = layout.getPrimaryHorizontal(this.mSelectionInfo.getEnd());
            int endLine = layout.getLineForOffset(this.mSelectionInfo.getEnd());
            this.mSelectionInfo.setEnd(layout.getOffsetForHorizontal(endLine, endX));
            this.mSelectionInfo.setSelectionLine((endLine - startLine) + 1);
        }
    }

    public final void changeCursorDirection() {
        CursorHandle temp = this.mStartHandle;
        this.mStartHandle = this.mEndHandle;
        this.mEndHandle = temp;
    }

    public final void setSelectableTextTouchListener(SelectableTextTouchListener listener) {
        this.selectableTextTouchListener = listener;
    }

    public final void setSelectableTextLongClickListener(SelectableTextLongClickListener listener) {
        this.selectableTextLongClickListener = listener;
        if (listener != null) {
            SelectableTextLongClickListener selectableTextLongClickListener2 = listener;
            if (!this.autoHookLongClick) {
                this.textView.setOnLongClickListener(new TalosTextSelectHelper$$ExternalSyntheticLambda0(this));
                this.autoHookLongClick = true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setSelectableTextLongClickListener$lambda-17$lambda-16  reason: not valid java name */
    public static final boolean m8143setSelectableTextLongClickListener$lambda17$lambda16(TalosTextSelectHelper this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isSelectTextWhenLongClick) {
            showSelectView$default(this$0, this$0.mTouchX, this$0.mTouchY, false, 4, (Object) null);
        }
        SelectableTextLongClickListener longClickListener = this$0.selectableTextLongClickListener;
        if (longClickListener == null) {
            return true;
        }
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        longClickListener.onLongClick(view2);
        return true;
    }

    public static /* synthetic */ void startSelect$default(TalosTextSelectHelper talosTextSelectHelper, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        talosTextSelectHelper.startSelect(z);
    }

    public final void startSelect(boolean isAllSelect) {
        boolean innerIsAllSelect = isAllSelect;
        TokenizorInterface it = this.tokenizor;
        if (it != null && it.isForceStringCutMode()) {
            innerIsAllSelect = false;
        }
        showSelectView(this.mTouchX, this.mTouchY, innerIsAllSelect);
        if (innerIsAllSelect) {
            this.isDefaultAllSelecting = true;
        }
    }

    public final void cancelSelect() {
        resetSelectionInfo();
        hideSelectView$default(this, false, 1, (Object) null);
        this.isDefaultAllSelecting = false;
    }

    public final void destroy() {
        resetSelectionInfo();
        hideSelectView$default(this, false, 1, (Object) null);
        this.mStartHandle = null;
        this.mEndHandle = null;
    }

    public final CharSequence getTextSelected() {
        CharSequence selectionContent = this.mSelectionInfo.getSelectionContent();
        if (selectionContent == null || StringsKt.isBlank(selectionContent)) {
            return "";
        }
        CharSequence selectionContent2 = this.mSelectionInfo.getSelectionContent();
        Intrinsics.checkNotNull(selectionContent2);
        return selectionContent2;
    }

    public final CharSequence getEmojiTextSelected() {
        CharSequence charSequence;
        CharSequence selectionContent = this.mSelectionInfo.getSelectionContent();
        boolean z = false;
        if (!(selectionContent == null || StringsKt.isBlank(selectionContent))) {
            charSequence = this.mSelectionInfo.getSelectionContent();
            Intrinsics.checkNotNull(charSequence);
        }
        CharSequence selection = charSequence;
        if (!(selection instanceof Spannable)) {
            return selection;
        }
        Spannable spannable2 = (Spannable) selection;
        Object[] spans = spannable2.getSpans(0, spannable2.length(), FrescoBasedReactTextInlineImageSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "selection.getSpans<Fresc…ss.java\n                )");
        FrescoBasedReactTextInlineImageSpan[] imageSpans = (FrescoBasedReactTextInlineImageSpan[]) spans;
        StringBuilder sb = new StringBuilder();
        if (imageSpans.length == 0) {
            z = true;
        }
        if (!z) {
            int count = 0;
            try {
                for (int index = ArraysKt.getLastIndex((T[]) imageSpans); -1 < index; index--) {
                    String des = imageSpans[index].getDescription();
                    if (des != null) {
                        selection = StringsKt.replaceRange(selection, (spannable2.getSpanStart(imageSpans[index]) + sb.length()) - count, (spannable2.getSpanEnd(imageSpans[index]) + sb.length()) - count, (CharSequence) des);
                        sb.append(des);
                        count++;
                    }
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
        return selection;
    }

    public final int getTextSelectedStart() {
        return this.mSelectionInfo.getStart();
    }

    public final int getTextSelectedEnd() {
        return this.mSelectionInfo.getEnd();
    }

    public final void removeCustomMenu() {
        TextOperateMenu textOperateMenu = this.mOperateMenu;
        if (textOperateMenu != null) {
            textOperateMenu.setMCustomMenu((ITextSelectMenu) null);
        }
    }
}
