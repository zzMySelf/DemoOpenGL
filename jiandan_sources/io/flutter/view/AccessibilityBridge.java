package io.flutter.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.google.android.material.chip.Chip;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate;
import io.flutter.util.Predicate;
import io.flutter.util.ViewUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import th.qw.fe.ad;
import th.qw.fe.qw;

public class AccessibilityBridge extends AccessibilityNodeProvider {
    public static final int ACTION_SHOW_ON_SCREEN = 16908342;
    public static int FIRST_RESOURCE_ID = 267386881;
    public static final int FOCUSABLE_FLAGS = (((((((((((Flag.HAS_CHECKED_STATE.value | Flag.IS_CHECKED.value) | Flag.IS_SELECTED.value) | Flag.IS_TEXT_FIELD.value) | Flag.IS_FOCUSED.value) | Flag.HAS_ENABLED_STATE.value) | Flag.IS_ENABLED.value) | Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP.value) | Flag.HAS_TOGGLED_STATE.value) | Flag.IS_TOGGLED.value) | Flag.IS_FOCUSABLE.value) | Flag.IS_SLIDER.value);
    public static final int MIN_ENGINE_GENERATED_NODE_ID = 65536;
    public static final int ROOT_NODE_ID = 0;
    public static final int SCROLLABLE_ACTIONS = (((Action.SCROLL_RIGHT.value | Action.SCROLL_LEFT.value) | Action.SCROLL_UP.value) | Action.SCROLL_DOWN.value);
    public static final float SCROLL_EXTENT_FOR_INFINITY = 100000.0f;
    public static final float SCROLL_POSITION_CAP_FOR_INFINITY = 70000.0f;
    public static final String TAG = "AccessibilityBridge";
    @NonNull
    public final AccessibilityChannel accessibilityChannel;
    public int accessibilityFeatureFlags;
    @Nullable
    public SemanticsNode accessibilityFocusedSemanticsNode;
    @NonNull
    public final AccessibilityManager accessibilityManager;
    public final AccessibilityChannel.AccessibilityMessageHandler accessibilityMessageHandler;
    public final AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener;
    @NonNull
    public final AccessibilityViewEmbedder accessibilityViewEmbedder;
    public final ContentObserver animationScaleObserver;
    @NonNull
    public final ContentResolver contentResolver;
    @NonNull
    public final Map<Integer, CustomAccessibilityAction> customAccessibilityActions;
    public Integer embeddedAccessibilityFocusedNodeId;
    public Integer embeddedInputFocusedNodeId;
    @NonNull
    public final List<Integer> flutterNavigationStack;
    @NonNull
    public final Map<Integer, SemanticsNode> flutterSemanticsTree;
    @Nullable
    public SemanticsNode hoveredObject;
    @Nullable
    public SemanticsNode inputFocusedSemanticsNode;
    public boolean isReleased;
    @Nullable
    public SemanticsNode lastInputFocusedSemanticsNode;
    @NonNull
    public Integer lastLeftFrameInset;
    @Nullable
    public OnAccessibilityChangeListener onAccessibilityChangeListener;
    @NonNull
    public final PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate;
    public int previousRouteId;
    @NonNull
    public final View rootAccessibilityView;
    @RequiresApi(19)
    @TargetApi(19)
    public final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    /* renamed from: io.flutter.view.AccessibilityBridge$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.flutter.view.AccessibilityBridge$StringAttributeType[] r0 = io.flutter.view.AccessibilityBridge.StringAttributeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType = r0
                io.flutter.view.AccessibilityBridge$StringAttributeType r1 = io.flutter.view.AccessibilityBridge.StringAttributeType.SPELLOUT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.view.AccessibilityBridge$StringAttributeType r1 = io.flutter.view.AccessibilityBridge.StringAttributeType.LOCALE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityBridge.AnonymousClass5.<clinit>():void");
        }
    }

    public enum AccessibilityFeature {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4);
        
        public final int value;

        /* access modifiers changed from: public */
        AccessibilityFeature(int i2) {
            this.value = i2;
        }
    }

    public enum Action {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
        SET_TEXT(2097152);
        
        public final int value;

        /* access modifiers changed from: public */
        Action(int i2) {
            this.value = i2;
        }
    }

    public static class CustomAccessibilityAction {
        public String hint;
        public int id = -1;
        public String label;
        public int overrideId = -1;
        public int resourceId = -1;
    }

    public enum Flag {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(65536),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304),
        IS_SLIDER(8388608),
        IS_KEYBOARD_KEY(16777216);
        
        public final int value;

        /* access modifiers changed from: public */
        Flag(int i2) {
            this.value = i2;
        }
    }

    public static class LocaleStringAttribute extends StringAttribute {
        public String locale;

        public LocaleStringAttribute() {
            super();
        }
    }

    public interface OnAccessibilityChangeListener {
        void onAccessibilityChanged(boolean z, boolean z2);
    }

    public static class SemanticsNode {
        public final AccessibilityBridge accessibilityBridge;
        public int actions;
        public float bottom;
        public List<SemanticsNode> childrenInHitTestOrder = new ArrayList();
        public List<SemanticsNode> childrenInTraversalOrder = new ArrayList();
        public int currentValueLength;
        public List<CustomAccessibilityAction> customAccessibilityActions;
        public String decreasedValue;
        public List<StringAttribute> decreasedValueAttributes;
        public int flags;
        public boolean globalGeometryDirty = true;
        public Rect globalRect;
        public float[] globalTransform;
        public boolean hadPreviousConfig = false;
        public String hint;
        public List<StringAttribute> hintAttributes;
        public int id = -1;
        public String increasedValue;
        public List<StringAttribute> increasedValueAttributes;
        public float[] inverseTransform;
        public boolean inverseTransformDirty = true;
        public String label;
        public List<StringAttribute> labelAttributes;
        public float left;
        public int maxValueLength;
        public CustomAccessibilityAction onLongPressOverride;
        public CustomAccessibilityAction onTapOverride;
        public SemanticsNode parent;
        public int platformViewId;
        public int previousActions;
        public int previousFlags;
        public String previousLabel;
        public int previousNodeId = -1;
        public float previousScrollExtentMax;
        public float previousScrollExtentMin;
        public float previousScrollPosition;
        public int previousTextSelectionBase;
        public int previousTextSelectionExtent;
        public String previousValue;
        public float right;
        public int scrollChildren;
        public float scrollExtentMax;
        public float scrollExtentMin;
        public int scrollIndex;
        public float scrollPosition;
        public TextDirection textDirection;
        public int textSelectionBase;
        public int textSelectionExtent;
        @Nullable
        public String tooltip;
        public float top;
        public float[] transform;
        public String value;
        public List<StringAttribute> valueAttributes;

        public SemanticsNode(@NonNull AccessibilityBridge accessibilityBridge2) {
            this.accessibilityBridge = accessibilityBridge2;
        }

        public static /* synthetic */ int access$2112(SemanticsNode semanticsNode, int i2) {
            int i3 = semanticsNode.textSelectionExtent + i2;
            semanticsNode.textSelectionExtent = i3;
            return i3;
        }

        public static /* synthetic */ int access$2120(SemanticsNode semanticsNode, int i2) {
            int i3 = semanticsNode.textSelectionExtent - i2;
            semanticsNode.textSelectionExtent = i3;
            return i3;
        }

        /* access modifiers changed from: private */
        public void collectRoutes(List<SemanticsNode> list) {
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                list.add(this);
            }
            for (SemanticsNode collectRoutes : this.childrenInTraversalOrder) {
                collectRoutes.collectRoutes(list);
            }
        }

        @RequiresApi(21)
        @TargetApi(21)
        private SpannableString createSpannableString(String str, List<StringAttribute> list) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            if (list != null) {
                for (StringAttribute next : list) {
                    int i2 = AnonymousClass5.$SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType[next.type.ordinal()];
                    if (i2 == 1) {
                        spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), next.start, next.end, 0);
                    } else if (i2 == 2) {
                        spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((LocaleStringAttribute) next).locale)), next.start, next.end, 0);
                    }
                }
            }
            return spannableString;
        }

        /* access modifiers changed from: private */
        public boolean didChangeLabel() {
            String str;
            if (this.label == null && this.previousLabel == null) {
                return false;
            }
            String str2 = this.label;
            if (str2 == null || (str = this.previousLabel) == null || !str2.equals(str)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public boolean didScroll() {
            return !Float.isNaN(this.scrollPosition) && !Float.isNaN(this.previousScrollPosition) && this.previousScrollPosition != this.scrollPosition;
        }

        private void ensureInverseTransform() {
            if (this.inverseTransformDirty) {
                this.inverseTransformDirty = false;
                if (this.inverseTransform == null) {
                    this.inverseTransform = new float[16];
                }
                if (!Matrix.invertM(this.inverseTransform, 0, this.transform, 0)) {
                    Arrays.fill(this.inverseTransform, 0.0f);
                }
            }
        }

        private SemanticsNode getAncestor(Predicate<SemanticsNode> predicate) {
            for (SemanticsNode semanticsNode = this.parent; semanticsNode != null; semanticsNode = semanticsNode.parent) {
                if (predicate.test(semanticsNode)) {
                    return semanticsNode;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public Rect getGlobalRect() {
            return this.globalRect;
        }

        /* access modifiers changed from: private */
        public String getRouteName() {
            String str;
            if (hasFlag(Flag.NAMES_ROUTE) && (str = this.label) != null && !str.isEmpty()) {
                return this.label;
            }
            for (SemanticsNode routeName : this.childrenInTraversalOrder) {
                String routeName2 = routeName.getRouteName();
                if (routeName2 != null && !routeName2.isEmpty()) {
                    return routeName2;
                }
            }
            return null;
        }

        private List<StringAttribute> getStringAttributesFromBuffer(@NonNull ByteBuffer byteBuffer, @NonNull ByteBuffer[] byteBufferArr) {
            int i2 = byteBuffer.getInt();
            if (i2 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = byteBuffer.getInt();
                int i5 = byteBuffer.getInt();
                StringAttributeType stringAttributeType = StringAttributeType.values()[byteBuffer.getInt()];
                int i6 = AnonymousClass5.$SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType[stringAttributeType.ordinal()];
                if (i6 == 1) {
                    byteBuffer.getInt();
                    SpellOutStringAttribute spellOutStringAttribute = new SpellOutStringAttribute();
                    spellOutStringAttribute.start = i4;
                    spellOutStringAttribute.end = i5;
                    spellOutStringAttribute.type = stringAttributeType;
                    arrayList.add(spellOutStringAttribute);
                } else if (i6 == 2) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    LocaleStringAttribute localeStringAttribute = new LocaleStringAttribute();
                    localeStringAttribute.start = i4;
                    localeStringAttribute.end = i5;
                    localeStringAttribute.type = stringAttributeType;
                    localeStringAttribute.locale = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                    arrayList.add(localeStringAttribute);
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public CharSequence getValueLabelHint() {
            CharSequence charSequence = null;
            for (CharSequence charSequence2 : Build.VERSION.SDK_INT < 21 ? new CharSequence[]{this.value, this.label, this.hint} : new CharSequence[]{createSpannableString(this.value, this.valueAttributes), createSpannableString(this.label, this.labelAttributes), createSpannableString(this.hint, this.hintAttributes)}) {
                if (charSequence2 != null && charSequence2.length() > 0) {
                    charSequence = (charSequence == null || charSequence.length() == 0) ? charSequence2 : TextUtils.concat(new CharSequence[]{charSequence, StringUtil.ARRAY_ELEMENT_SEPARATOR, charSequence2});
                }
            }
            return charSequence;
        }

        /* access modifiers changed from: private */
        public boolean hadAction(@NonNull Action action) {
            return (action.value & this.previousActions) != 0;
        }

        /* access modifiers changed from: private */
        public boolean hadFlag(@NonNull Flag flag) {
            return (flag.value & this.previousFlags) != 0;
        }

        /* access modifiers changed from: private */
        public boolean hasAction(@NonNull Action action) {
            return (action.value & this.actions) != 0;
        }

        /* access modifiers changed from: private */
        public boolean hasFlag(@NonNull Flag flag) {
            return (flag.value & this.flags) != 0;
        }

        /* access modifiers changed from: private */
        public SemanticsNode hitTest(float[] fArr) {
            float f = fArr[3];
            float f2 = fArr[0] / f;
            float f3 = fArr[1] / f;
            if (f2 < this.left || f2 >= this.right || f3 < this.top || f3 >= this.bottom) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (SemanticsNode next : this.childrenInHitTestOrder) {
                if (!next.hasFlag(Flag.IS_HIDDEN)) {
                    next.ensureInverseTransform();
                    Matrix.multiplyMV(fArr2, 0, next.inverseTransform, 0, fArr, 0);
                    SemanticsNode hitTest = next.hitTest(fArr2);
                    if (hitTest != null) {
                        return hitTest;
                    }
                }
            }
            if (isFocusable()) {
                return this;
            }
            return null;
        }

        /* access modifiers changed from: private */
        public boolean isFocusable() {
            String str;
            String str2;
            String str3;
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                return false;
            }
            if (!hasFlag(Flag.IS_FOCUSABLE) && (this.actions & (~AccessibilityBridge.SCROLLABLE_ACTIONS)) == 0 && (this.flags & AccessibilityBridge.FOCUSABLE_FLAGS) == 0 && (((str = this.label) == null || str.isEmpty()) && (((str2 = this.value) == null || str2.isEmpty()) && ((str3 = this.hint) == null || str3.isEmpty())))) {
                return false;
            }
            return true;
        }

        private void log(@NonNull String str, boolean z) {
        }

        private float max(float f, float f2, float f3, float f4) {
            return Math.max(f, Math.max(f2, Math.max(f3, f4)));
        }

        private float min(float f, float f2, float f3, float f4) {
            return Math.min(f, Math.min(f2, Math.min(f3, f4)));
        }

        public static boolean nullableHasAncestor(SemanticsNode semanticsNode, Predicate<SemanticsNode> predicate) {
            return (semanticsNode == null || semanticsNode.getAncestor(predicate) == null) ? false : true;
        }

        private void transformPoint(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f = fArr[3];
            fArr[0] = fArr[0] / f;
            fArr[1] = fArr[1] / f;
            fArr[2] = fArr[2] / f;
            fArr[3] = 0.0f;
        }

        /* access modifiers changed from: private */
        public void updateRecursively(float[] fArr, Set<SemanticsNode> set, boolean z) {
            set.add(this);
            if (this.globalGeometryDirty) {
                z = true;
            }
            if (z) {
                if (this.globalTransform == null) {
                    this.globalTransform = new float[16];
                }
                Matrix.multiplyMM(this.globalTransform, 0, fArr, 0, this.transform, 0);
                float[] fArr2 = new float[4];
                fArr2[2] = 0.0f;
                fArr2[3] = 1.0f;
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                fArr2[0] = this.left;
                fArr2[1] = this.top;
                transformPoint(fArr3, this.globalTransform, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.top;
                transformPoint(fArr4, this.globalTransform, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.bottom;
                transformPoint(fArr5, this.globalTransform, fArr2);
                fArr2[0] = this.left;
                fArr2[1] = this.bottom;
                transformPoint(fArr6, this.globalTransform, fArr2);
                if (this.globalRect == null) {
                    this.globalRect = new Rect();
                }
                this.globalRect.set(Math.round(min(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(min(fArr3[1], fArr4[1], fArr5[1], fArr6[1])), Math.round(max(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(max(fArr3[1], fArr4[1], fArr5[1], fArr6[1])));
                this.globalGeometryDirty = false;
            }
            int i2 = -1;
            for (SemanticsNode next : this.childrenInTraversalOrder) {
                next.previousNodeId = i2;
                i2 = next.id;
                next.updateRecursively(this.globalTransform, set, z);
            }
        }

        /* access modifiers changed from: private */
        public void updateWith(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr, @NonNull ByteBuffer[] byteBufferArr) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            this.hadPreviousConfig = true;
            this.previousValue = this.value;
            this.previousLabel = this.label;
            this.previousFlags = this.flags;
            this.previousActions = this.actions;
            this.previousTextSelectionBase = this.textSelectionBase;
            this.previousTextSelectionExtent = this.textSelectionExtent;
            this.previousScrollPosition = this.scrollPosition;
            this.previousScrollExtentMax = this.scrollExtentMax;
            this.previousScrollExtentMin = this.scrollExtentMin;
            this.flags = byteBuffer.getInt();
            this.actions = byteBuffer.getInt();
            this.maxValueLength = byteBuffer.getInt();
            this.currentValueLength = byteBuffer.getInt();
            this.textSelectionBase = byteBuffer.getInt();
            this.textSelectionExtent = byteBuffer.getInt();
            this.platformViewId = byteBuffer.getInt();
            this.scrollChildren = byteBuffer.getInt();
            this.scrollIndex = byteBuffer.getInt();
            this.scrollPosition = byteBuffer.getFloat();
            this.scrollExtentMax = byteBuffer.getFloat();
            this.scrollExtentMin = byteBuffer.getFloat();
            int i2 = byteBuffer.getInt();
            if (i2 == -1) {
                str = null;
            } else {
                str = strArr[i2];
            }
            this.label = str;
            this.labelAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i3 = byteBuffer.getInt();
            if (i3 == -1) {
                str2 = null;
            } else {
                str2 = strArr[i3];
            }
            this.value = str2;
            this.valueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i4 = byteBuffer.getInt();
            if (i4 == -1) {
                str3 = null;
            } else {
                str3 = strArr[i4];
            }
            this.increasedValue = str3;
            this.increasedValueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i5 = byteBuffer.getInt();
            if (i5 == -1) {
                str4 = null;
            } else {
                str4 = strArr[i5];
            }
            this.decreasedValue = str4;
            this.decreasedValueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i6 = byteBuffer.getInt();
            if (i6 == -1) {
                str5 = null;
            } else {
                str5 = strArr[i6];
            }
            this.hint = str5;
            this.hintAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i7 = byteBuffer.getInt();
            if (i7 == -1) {
                str6 = null;
            } else {
                str6 = strArr[i7];
            }
            this.tooltip = str6;
            this.textDirection = TextDirection.fromInt(byteBuffer.getInt());
            this.left = byteBuffer.getFloat();
            this.top = byteBuffer.getFloat();
            this.right = byteBuffer.getFloat();
            this.bottom = byteBuffer.getFloat();
            if (this.transform == null) {
                this.transform = new float[16];
            }
            for (int i8 = 0; i8 < 16; i8++) {
                this.transform[i8] = byteBuffer.getFloat();
            }
            this.inverseTransformDirty = true;
            this.globalGeometryDirty = true;
            int i9 = byteBuffer.getInt();
            this.childrenInTraversalOrder.clear();
            this.childrenInHitTestOrder.clear();
            for (int i10 = 0; i10 < i9; i10++) {
                SemanticsNode access$6600 = this.accessibilityBridge.getOrCreateSemanticsNode(byteBuffer.getInt());
                access$6600.parent = this;
                this.childrenInTraversalOrder.add(access$6600);
            }
            for (int i11 = 0; i11 < i9; i11++) {
                SemanticsNode access$66002 = this.accessibilityBridge.getOrCreateSemanticsNode(byteBuffer.getInt());
                access$66002.parent = this;
                this.childrenInHitTestOrder.add(access$66002);
            }
            int i12 = byteBuffer.getInt();
            if (i12 == 0) {
                this.customAccessibilityActions = null;
                return;
            }
            List<CustomAccessibilityAction> list = this.customAccessibilityActions;
            if (list == null) {
                this.customAccessibilityActions = new ArrayList(i12);
            } else {
                list.clear();
            }
            for (int i13 = 0; i13 < i12; i13++) {
                CustomAccessibilityAction access$6700 = this.accessibilityBridge.getOrCreateAccessibilityAction(byteBuffer.getInt());
                if (access$6700.overrideId == Action.TAP.value) {
                    this.onTapOverride = access$6700;
                } else if (access$6700.overrideId == Action.LONG_PRESS.value) {
                    this.onLongPressOverride = access$6700;
                } else {
                    this.customAccessibilityActions.add(access$6700);
                }
                this.customAccessibilityActions.add(access$6700);
            }
        }
    }

    public static class SpellOutStringAttribute extends StringAttribute {
        public SpellOutStringAttribute() {
            super();
        }
    }

    public static class StringAttribute {
        public int end;
        public int start;
        public StringAttributeType type;

        public StringAttribute() {
        }
    }

    public enum StringAttributeType {
        SPELLOUT,
        LOCALE
    }

    public enum TextDirection {
        UNKNOWN,
        LTR,
        RTL;

        public static TextDirection fromInt(int i2) {
            if (i2 == 1) {
                return RTL;
            }
            if (i2 != 2) {
                return UNKNOWN;
            }
            return LTR;
        }
    }

    public AccessibilityBridge(@NonNull View view, @NonNull AccessibilityChannel accessibilityChannel2, @NonNull AccessibilityManager accessibilityManager2, @NonNull ContentResolver contentResolver2, PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate2) {
        this(view, accessibilityChannel2, accessibilityManager2, contentResolver2, new AccessibilityViewEmbedder(view, 65536), platformViewsAccessibilityDelegate2);
    }

    public static /* synthetic */ int access$1172(AccessibilityBridge accessibilityBridge, int i2) {
        int i3 = i2 & accessibilityBridge.accessibilityFeatureFlags;
        accessibilityBridge.accessibilityFeatureFlags = i3;
        return i3;
    }

    public static /* synthetic */ int access$1176(AccessibilityBridge accessibilityBridge, int i2) {
        int i3 = i2 | accessibilityBridge.accessibilityFeatureFlags;
        accessibilityBridge.accessibilityFeatureFlags = i3;
        return i3;
    }

    private AccessibilityEvent createTextChangedEvent(int i2, String str, String str2) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i2, 16);
        obtainAccessibilityEvent.setBeforeText(str);
        obtainAccessibilityEvent.getText().add(str2);
        int i3 = 0;
        while (i3 < str.length() && i3 < str2.length() && str.charAt(i3) == str2.charAt(i3)) {
            i3++;
        }
        if (i3 >= str.length() && i3 >= str2.length()) {
            return null;
        }
        obtainAccessibilityEvent.setFromIndex(i3);
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        while (length >= i3 && length2 >= i3 && str.charAt(length) == str2.charAt(length2)) {
            length--;
            length2--;
        }
        obtainAccessibilityEvent.setRemovedCount((length - i3) + 1);
        obtainAccessibilityEvent.setAddedCount((length2 - i3) + 1);
        return obtainAccessibilityEvent;
    }

    @RequiresApi(28)
    @TargetApi(28)
    private boolean doesLayoutInDisplayCutoutModeRequireLeftInset() {
        Activity activity = ViewUtils.getActivity(this.rootAccessibilityView.getContext());
        if (activity == null || activity.getWindow() == null) {
            return false;
        }
        int i2 = activity.getWindow().getAttributes().layoutInDisplayCutoutMode;
        if (i2 == 2 || i2 == 0) {
            return true;
        }
        return false;
    }

    private Rect getBoundsInScreen(Rect rect) {
        Rect rect2 = new Rect(rect);
        int[] iArr = new int[2];
        this.rootAccessibilityView.getLocationOnScreen(iArr);
        rect2.offset(iArr[0], iArr[1]);
        return rect2;
    }

    /* access modifiers changed from: private */
    public CustomAccessibilityAction getOrCreateAccessibilityAction(int i2) {
        CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i2));
        if (customAccessibilityAction != null) {
            return customAccessibilityAction;
        }
        CustomAccessibilityAction customAccessibilityAction2 = new CustomAccessibilityAction();
        int unused = customAccessibilityAction2.id = i2;
        int unused2 = customAccessibilityAction2.resourceId = FIRST_RESOURCE_ID + i2;
        this.customAccessibilityActions.put(Integer.valueOf(i2), customAccessibilityAction2);
        return customAccessibilityAction2;
    }

    /* access modifiers changed from: private */
    public SemanticsNode getOrCreateSemanticsNode(int i2) {
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i2));
        if (semanticsNode != null) {
            return semanticsNode;
        }
        SemanticsNode semanticsNode2 = new SemanticsNode(this);
        int unused = semanticsNode2.id = i2;
        this.flutterSemanticsTree.put(Integer.valueOf(i2), semanticsNode2);
        return semanticsNode2;
    }

    private SemanticsNode getRootSemanticsNode() {
        return this.flutterSemanticsTree.get(0);
    }

    private void handleTouchExploration(float f, float f2) {
        SemanticsNode access$4300;
        if (!this.flutterSemanticsTree.isEmpty() && (access$4300 = getRootSemanticsNode().hitTest(new float[]{f, f2, 0.0f, 1.0f})) != this.hoveredObject) {
            if (access$4300 != null) {
                sendAccessibilityEvent(access$4300.id, 128);
            }
            SemanticsNode semanticsNode = this.hoveredObject;
            if (semanticsNode != null) {
                sendAccessibilityEvent(semanticsNode.id, 256);
            }
            this.hoveredObject = access$4300;
        }
    }

    /* access modifiers changed from: private */
    public AccessibilityEvent obtainAccessibilityEvent(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        obtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtain.setSource(this.rootAccessibilityView, i2);
        return obtain;
    }

    /* access modifiers changed from: private */
    public void onTouchExplorationExit() {
        SemanticsNode semanticsNode = this.hoveredObject;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, 256);
            this.hoveredObject = null;
        }
    }

    private void onWindowNameChange(@NonNull SemanticsNode semanticsNode) {
        String access$6400 = semanticsNode.getRouteName();
        if (access$6400 == null) {
            access$6400 = " ";
        }
        if (Build.VERSION.SDK_INT >= 28) {
            setAccessibilityPaneTitle(access$6400);
            return;
        }
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode.id, 32);
        obtainAccessibilityEvent.getText().add(access$6400);
        sendAccessibilityEvent(obtainAccessibilityEvent);
    }

    @RequiresApi(18)
    @TargetApi(18)
    private boolean performCursorMoveAction(@NonNull SemanticsNode semanticsNode, int i2, @NonNull Bundle bundle, boolean z) {
        int i3 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT);
        boolean z2 = bundle.getBoolean(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN);
        predictCursorMovement(semanticsNode, i3, z, z2);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 4 || i3 == 8 || i3 == 16) {
                    return true;
                }
                return false;
            } else if (z && semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_WORD)) {
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.MOVE_CURSOR_FORWARD_BY_WORD, Boolean.valueOf(z2));
                return true;
            } else if (z || !semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                return false;
            } else {
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.MOVE_CURSOR_BACKWARD_BY_WORD, Boolean.valueOf(z2));
                return true;
            }
        } else if (z && semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
            this.accessibilityChannel.dispatchSemanticsAction(i2, Action.MOVE_CURSOR_FORWARD_BY_CHARACTER, Boolean.valueOf(z2));
            return true;
        } else if (z || !semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
            return false;
        } else {
            this.accessibilityChannel.dispatchSemanticsAction(i2, Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER, Boolean.valueOf(z2));
            return true;
        }
    }

    @RequiresApi(21)
    @TargetApi(21)
    private boolean performSetText(SemanticsNode semanticsNode, int i2, @NonNull Bundle bundle) {
        String string = (bundle == null || !bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE)) ? "" : bundle.getString(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE);
        this.accessibilityChannel.dispatchSemanticsAction(i2, Action.SET_TEXT, string);
        String unused = semanticsNode.value = string;
        return true;
    }

    private void predictCursorMovement(@NonNull SemanticsNode semanticsNode, int i2, boolean z, boolean z2) {
        if (semanticsNode.textSelectionExtent >= 0 && semanticsNode.textSelectionBase >= 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 4) {
                        if (i2 == 8 || i2 == 16) {
                            if (z) {
                                int unused = semanticsNode.textSelectionExtent = semanticsNode.value.length();
                            } else {
                                int unused2 = semanticsNode.textSelectionExtent = 0;
                            }
                        }
                    } else if (z && semanticsNode.textSelectionExtent < semanticsNode.value.length()) {
                        Matcher matcher = Pattern.compile("(?!^)(\\n)").matcher(semanticsNode.value.substring(semanticsNode.textSelectionExtent));
                        if (matcher.find()) {
                            SemanticsNode.access$2112(semanticsNode, matcher.start(1));
                        } else {
                            int unused3 = semanticsNode.textSelectionExtent = semanticsNode.value.length();
                        }
                    } else if (!z && semanticsNode.textSelectionExtent > 0) {
                        Matcher matcher2 = Pattern.compile("(?s:.*)(\\n)").matcher(semanticsNode.value.substring(0, semanticsNode.textSelectionExtent));
                        if (matcher2.find()) {
                            int unused4 = semanticsNode.textSelectionExtent = matcher2.start(1);
                        } else {
                            int unused5 = semanticsNode.textSelectionExtent = 0;
                        }
                    }
                } else if (z && semanticsNode.textSelectionExtent < semanticsNode.value.length()) {
                    Matcher matcher3 = Pattern.compile("\\p{L}(\\b)").matcher(semanticsNode.value.substring(semanticsNode.textSelectionExtent));
                    matcher3.find();
                    if (matcher3.find()) {
                        SemanticsNode.access$2112(semanticsNode, matcher3.start(1));
                    } else {
                        int unused6 = semanticsNode.textSelectionExtent = semanticsNode.value.length();
                    }
                } else if (!z && semanticsNode.textSelectionExtent > 0) {
                    Matcher matcher4 = Pattern.compile("(?s:.*)(\\b)\\p{L}").matcher(semanticsNode.value.substring(0, semanticsNode.textSelectionExtent));
                    if (matcher4.find()) {
                        int unused7 = semanticsNode.textSelectionExtent = matcher4.start(1);
                    }
                }
            } else if (z && semanticsNode.textSelectionExtent < semanticsNode.value.length()) {
                SemanticsNode.access$2112(semanticsNode, 1);
            } else if (!z && semanticsNode.textSelectionExtent > 0) {
                SemanticsNode.access$2120(semanticsNode, 1);
            }
            if (!z2) {
                int unused8 = semanticsNode.textSelectionBase = semanticsNode.textSelectionExtent;
            }
        }
    }

    public static /* synthetic */ boolean qw(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
        return semanticsNode2 == semanticsNode;
    }

    /* access modifiers changed from: private */
    public void sendAccessibilityEvent(int i2, int i3) {
        if (this.accessibilityManager.isEnabled()) {
            sendAccessibilityEvent(obtainAccessibilityEvent(i2, i3));
        }
    }

    /* access modifiers changed from: private */
    public void sendLatestAccessibilityFlagsToFlutter() {
        this.accessibilityChannel.setAccessibilityFeatures(this.accessibilityFeatureFlags);
    }

    private void sendWindowContentChangeEvent(int i2) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i2, 2048);
        if (Build.VERSION.SDK_INT >= 19) {
            obtainAccessibilityEvent.setContentChangeTypes(1);
        }
        sendAccessibilityEvent(obtainAccessibilityEvent);
    }

    @RequiresApi(28)
    @TargetApi(28)
    private void setAccessibilityPaneTitle(String str) {
        this.rootAccessibilityView.setAccessibilityPaneTitle(str);
    }

    private boolean shouldSetCollectionInfo(SemanticsNode semanticsNode) {
        return semanticsNode.scrollChildren > 0 && (SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, new qw(semanticsNode)) || !SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, ad.qw));
    }

    @RequiresApi(19)
    @TargetApi(19)
    private void willRemoveSemanticsNode(SemanticsNode semanticsNode) {
        View platformViewById;
        Integer num;
        SemanticsNode unused = semanticsNode.parent = null;
        if (!(semanticsNode.platformViewId == -1 || (num = this.embeddedAccessibilityFocusedNodeId) == null || this.accessibilityViewEmbedder.platformViewOfNode(num.intValue()) != this.platformViewsAccessibilityDelegate.getPlatformViewById(Integer.valueOf(semanticsNode.platformViewId)))) {
            sendAccessibilityEvent(this.embeddedAccessibilityFocusedNodeId.intValue(), 65536);
            this.embeddedAccessibilityFocusedNodeId = null;
        }
        if (!(semanticsNode.platformViewId == -1 || this.platformViewsAccessibilityDelegate.usesVirtualDisplay(Integer.valueOf(semanticsNode.platformViewId)) || (platformViewById = this.platformViewsAccessibilityDelegate.getPlatformViewById(Integer.valueOf(semanticsNode.platformViewId))) == null)) {
            platformViewById.setImportantForAccessibility(4);
        }
        SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode2 == semanticsNode) {
            sendAccessibilityEvent(semanticsNode2.id, 65536);
            this.accessibilityFocusedSemanticsNode = null;
        }
        if (this.inputFocusedSemanticsNode == semanticsNode) {
            this.inputFocusedSemanticsNode = null;
        }
        if (this.hoveredObject == semanticsNode) {
            this.hoveredObject = null;
        }
    }

    @SuppressLint({"NewApi"})
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
        int i3;
        SemanticsNode semanticsNode;
        if (i2 >= 65536) {
            return this.accessibilityViewEmbedder.createAccessibilityNodeInfo(i2);
        }
        boolean z = false;
        if (i2 == -1) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.rootAccessibilityView);
            this.rootAccessibilityView.onInitializeAccessibilityNodeInfo(obtain);
            if (this.flutterSemanticsTree.containsKey(0)) {
                obtain.addChild(this.rootAccessibilityView, 0);
            }
            return obtain;
        }
        SemanticsNode semanticsNode2 = this.flutterSemanticsTree.get(Integer.valueOf(i2));
        if (semanticsNode2 == null) {
            return null;
        }
        if (semanticsNode2.platformViewId != -1) {
            View platformViewById = this.platformViewsAccessibilityDelegate.getPlatformViewById(Integer.valueOf(semanticsNode2.platformViewId));
            if (this.platformViewsAccessibilityDelegate.usesVirtualDisplay(Integer.valueOf(semanticsNode2.platformViewId))) {
                return this.accessibilityViewEmbedder.getRootNode(platformViewById, semanticsNode2.id, semanticsNode2.getGlobalRect());
            }
        }
        AccessibilityNodeInfo obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(this.rootAccessibilityView, i2);
        String str = "";
        if (Build.VERSION.SDK_INT >= 18) {
            obtainAccessibilityNodeInfo.setViewIdResourceName(str);
        }
        obtainAccessibilityNodeInfo.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtainAccessibilityNodeInfo.setClassName("android.view.View");
        obtainAccessibilityNodeInfo.setSource(this.rootAccessibilityView, i2);
        obtainAccessibilityNodeInfo.setFocusable(semanticsNode2.isFocusable());
        SemanticsNode semanticsNode3 = this.inputFocusedSemanticsNode;
        if (semanticsNode3 != null) {
            obtainAccessibilityNodeInfo.setFocused(semanticsNode3.id == i2);
        }
        SemanticsNode semanticsNode4 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode4 != null) {
            obtainAccessibilityNodeInfo.setAccessibilityFocused(semanticsNode4.id == i2);
        }
        if (semanticsNode2.hasFlag(Flag.IS_TEXT_FIELD)) {
            obtainAccessibilityNodeInfo.setPassword(semanticsNode2.hasFlag(Flag.IS_OBSCURED));
            if (!semanticsNode2.hasFlag(Flag.IS_READ_ONLY)) {
                obtainAccessibilityNodeInfo.setClassName("android.widget.EditText");
            }
            if (Build.VERSION.SDK_INT >= 18) {
                obtainAccessibilityNodeInfo.setEditable(!semanticsNode2.hasFlag(Flag.IS_READ_ONLY));
                if (!(semanticsNode2.textSelectionBase == -1 || semanticsNode2.textSelectionExtent == -1)) {
                    obtainAccessibilityNodeInfo.setTextSelection(semanticsNode2.textSelectionBase, semanticsNode2.textSelectionExtent);
                }
                if (Build.VERSION.SDK_INT > 18 && (semanticsNode = this.accessibilityFocusedSemanticsNode) != null && semanticsNode.id == i2) {
                    obtainAccessibilityNodeInfo.setLiveRegion(1);
                }
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                obtainAccessibilityNodeInfo.addAction(256);
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                obtainAccessibilityNodeInfo.addAction(512);
                i3 |= 1;
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_FORWARD_BY_WORD)) {
                obtainAccessibilityNodeInfo.addAction(256);
                i3 |= 2;
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                obtainAccessibilityNodeInfo.addAction(512);
                i3 |= 2;
            }
            obtainAccessibilityNodeInfo.setMovementGranularities(i3);
            if (Build.VERSION.SDK_INT >= 21 && semanticsNode2.maxValueLength >= 0) {
                int length = semanticsNode2.value == null ? 0 : semanticsNode2.value.length();
                int unused = semanticsNode2.currentValueLength;
                int unused2 = semanticsNode2.maxValueLength;
                obtainAccessibilityNodeInfo.setMaxTextLength((length - semanticsNode2.currentValueLength) + semanticsNode2.maxValueLength);
            }
        }
        if (Build.VERSION.SDK_INT > 18) {
            if (semanticsNode2.hasAction(Action.SET_SELECTION)) {
                obtainAccessibilityNodeInfo.addAction(131072);
            }
            if (semanticsNode2.hasAction(Action.COPY)) {
                obtainAccessibilityNodeInfo.addAction(16384);
            }
            if (semanticsNode2.hasAction(Action.CUT)) {
                obtainAccessibilityNodeInfo.addAction(65536);
            }
            if (semanticsNode2.hasAction(Action.PASTE)) {
                obtainAccessibilityNodeInfo.addAction(32768);
            }
        }
        if (Build.VERSION.SDK_INT >= 21 && semanticsNode2.hasAction(Action.SET_TEXT)) {
            obtainAccessibilityNodeInfo.addAction(2097152);
        }
        if (semanticsNode2.hasFlag(Flag.IS_BUTTON) || semanticsNode2.hasFlag(Flag.IS_LINK)) {
            obtainAccessibilityNodeInfo.setClassName(Chip.BUTTON_ACCESSIBILITY_CLASS_NAME);
        }
        if (semanticsNode2.hasFlag(Flag.IS_IMAGE)) {
            obtainAccessibilityNodeInfo.setClassName("android.widget.ImageView");
        }
        if (Build.VERSION.SDK_INT > 18 && semanticsNode2.hasAction(Action.DISMISS)) {
            obtainAccessibilityNodeInfo.setDismissable(true);
            obtainAccessibilityNodeInfo.addAction(1048576);
        }
        if (semanticsNode2.parent != null) {
            obtainAccessibilityNodeInfo.setParent(this.rootAccessibilityView, semanticsNode2.parent.id);
        } else {
            obtainAccessibilityNodeInfo.setParent(this.rootAccessibilityView);
        }
        if (semanticsNode2.previousNodeId != -1 && Build.VERSION.SDK_INT >= 22) {
            obtainAccessibilityNodeInfo.setTraversalAfter(this.rootAccessibilityView, semanticsNode2.previousNodeId);
        }
        Rect access$1700 = semanticsNode2.getGlobalRect();
        if (semanticsNode2.parent != null) {
            Rect access$17002 = semanticsNode2.parent.getGlobalRect();
            Rect rect = new Rect(access$1700);
            rect.offset(-access$17002.left, -access$17002.top);
            obtainAccessibilityNodeInfo.setBoundsInParent(rect);
        } else {
            obtainAccessibilityNodeInfo.setBoundsInParent(access$1700);
        }
        obtainAccessibilityNodeInfo.setBoundsInScreen(getBoundsInScreen(access$1700));
        obtainAccessibilityNodeInfo.setVisibleToUser(true);
        obtainAccessibilityNodeInfo.setEnabled(!semanticsNode2.hasFlag(Flag.HAS_ENABLED_STATE) || semanticsNode2.hasFlag(Flag.IS_ENABLED));
        if (semanticsNode2.hasAction(Action.TAP)) {
            if (Build.VERSION.SDK_INT < 21 || semanticsNode2.onTapOverride == null) {
                obtainAccessibilityNodeInfo.addAction(16);
                obtainAccessibilityNodeInfo.setClickable(true);
            } else {
                obtainAccessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, semanticsNode2.onTapOverride.hint));
                obtainAccessibilityNodeInfo.setClickable(true);
            }
        }
        if (semanticsNode2.hasAction(Action.LONG_PRESS)) {
            if (Build.VERSION.SDK_INT < 21 || semanticsNode2.onLongPressOverride == null) {
                obtainAccessibilityNodeInfo.addAction(32);
                obtainAccessibilityNodeInfo.setLongClickable(true);
            } else {
                obtainAccessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, semanticsNode2.onLongPressOverride.hint));
                obtainAccessibilityNodeInfo.setLongClickable(true);
            }
        }
        if (semanticsNode2.hasAction(Action.SCROLL_LEFT) || semanticsNode2.hasAction(Action.SCROLL_UP) || semanticsNode2.hasAction(Action.SCROLL_RIGHT) || semanticsNode2.hasAction(Action.SCROLL_DOWN)) {
            obtainAccessibilityNodeInfo.setScrollable(true);
            if (semanticsNode2.hasFlag(Flag.HAS_IMPLICIT_SCROLLING)) {
                if (semanticsNode2.hasAction(Action.SCROLL_LEFT) || semanticsNode2.hasAction(Action.SCROLL_RIGHT)) {
                    if (Build.VERSION.SDK_INT <= 19 || !shouldSetCollectionInfo(semanticsNode2)) {
                        obtainAccessibilityNodeInfo.setClassName("android.widget.HorizontalScrollView");
                    } else {
                        obtainAccessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, semanticsNode2.scrollChildren, false));
                    }
                } else if (Build.VERSION.SDK_INT <= 18 || !shouldSetCollectionInfo(semanticsNode2)) {
                    obtainAccessibilityNodeInfo.setClassName("android.widget.ScrollView");
                } else {
                    obtainAccessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(semanticsNode2.scrollChildren, 0, false));
                }
            }
            if (semanticsNode2.hasAction(Action.SCROLL_LEFT) || semanticsNode2.hasAction(Action.SCROLL_UP)) {
                obtainAccessibilityNodeInfo.addAction(4096);
            }
            if (semanticsNode2.hasAction(Action.SCROLL_RIGHT) || semanticsNode2.hasAction(Action.SCROLL_DOWN)) {
                obtainAccessibilityNodeInfo.addAction(8192);
            }
        }
        if (semanticsNode2.hasAction(Action.INCREASE) || semanticsNode2.hasAction(Action.DECREASE)) {
            obtainAccessibilityNodeInfo.setClassName("android.widget.SeekBar");
            if (semanticsNode2.hasAction(Action.INCREASE)) {
                obtainAccessibilityNodeInfo.addAction(4096);
            }
            if (semanticsNode2.hasAction(Action.DECREASE)) {
                obtainAccessibilityNodeInfo.addAction(8192);
            }
        }
        if (semanticsNode2.hasFlag(Flag.IS_LIVE_REGION) && Build.VERSION.SDK_INT > 18) {
            obtainAccessibilityNodeInfo.setLiveRegion(1);
        }
        if (semanticsNode2.hasFlag(Flag.IS_TEXT_FIELD)) {
            obtainAccessibilityNodeInfo.setText(semanticsNode2.getValueLabelHint());
        } else if (!semanticsNode2.hasFlag(Flag.SCOPES_ROUTE)) {
            CharSequence access$3100 = semanticsNode2.getValueLabelHint();
            String str2 = access$3100;
            if (Build.VERSION.SDK_INT < 28) {
                str2 = access$3100;
                if (semanticsNode2.tooltip != null) {
                    if (access$3100 != null) {
                        str = access$3100;
                    }
                    str2 = str + StringUtils.LF + semanticsNode2.tooltip;
                }
            }
            if (str2 != null) {
                obtainAccessibilityNodeInfo.setContentDescription(str2);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && semanticsNode2.tooltip != null) {
            obtainAccessibilityNodeInfo.setTooltipText(semanticsNode2.tooltip);
        }
        boolean access$1900 = semanticsNode2.hasFlag(Flag.HAS_CHECKED_STATE);
        boolean access$19002 = semanticsNode2.hasFlag(Flag.HAS_TOGGLED_STATE);
        if (access$1900 || access$19002) {
            z = true;
        }
        obtainAccessibilityNodeInfo.setCheckable(z);
        if (access$1900) {
            obtainAccessibilityNodeInfo.setChecked(semanticsNode2.hasFlag(Flag.IS_CHECKED));
            if (semanticsNode2.hasFlag(Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP)) {
                obtainAccessibilityNodeInfo.setClassName("android.widget.RadioButton");
            } else {
                obtainAccessibilityNodeInfo.setClassName("android.widget.CheckBox");
            }
        } else if (access$19002) {
            obtainAccessibilityNodeInfo.setChecked(semanticsNode2.hasFlag(Flag.IS_TOGGLED));
            obtainAccessibilityNodeInfo.setClassName(SwitchCompat.ACCESSIBILITY_EVENT_CLASS_NAME);
        }
        obtainAccessibilityNodeInfo.setSelected(semanticsNode2.hasFlag(Flag.IS_SELECTED));
        if (Build.VERSION.SDK_INT >= 28) {
            obtainAccessibilityNodeInfo.setHeading(semanticsNode2.hasFlag(Flag.IS_HEADER));
        }
        SemanticsNode semanticsNode5 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode5 == null || semanticsNode5.id != i2) {
            obtainAccessibilityNodeInfo.addAction(64);
        } else {
            obtainAccessibilityNodeInfo.addAction(128);
        }
        if (Build.VERSION.SDK_INT >= 21 && semanticsNode2.customAccessibilityActions != null) {
            for (CustomAccessibilityAction customAccessibilityAction : semanticsNode2.customAccessibilityActions) {
                obtainAccessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(customAccessibilityAction.resourceId, customAccessibilityAction.label));
            }
        }
        for (SemanticsNode semanticsNode6 : semanticsNode2.childrenInTraversalOrder) {
            if (!semanticsNode6.hasFlag(Flag.IS_HIDDEN)) {
                if (semanticsNode6.platformViewId != -1) {
                    View platformViewById2 = this.platformViewsAccessibilityDelegate.getPlatformViewById(Integer.valueOf(semanticsNode6.platformViewId));
                    if (!this.platformViewsAccessibilityDelegate.usesVirtualDisplay(Integer.valueOf(semanticsNode6.platformViewId))) {
                        obtainAccessibilityNodeInfo.addChild(platformViewById2);
                    }
                }
                obtainAccessibilityNodeInfo.addChild(this.rootAccessibilityView, semanticsNode6.id);
            }
        }
        return obtainAccessibilityNodeInfo;
    }

    public boolean externalViewRequestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (!this.accessibilityViewEmbedder.requestSendAccessibilityEvent(view, view2, accessibilityEvent) || (recordFlutterId = this.accessibilityViewEmbedder.getRecordFlutterId(view, accessibilityEvent)) == null) {
            return false;
        }
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 8) {
            this.embeddedInputFocusedNodeId = recordFlutterId;
            this.inputFocusedSemanticsNode = null;
            return true;
        } else if (eventType == 128) {
            this.hoveredObject = null;
            return true;
        } else if (eventType == 32768) {
            this.embeddedAccessibilityFocusedNodeId = recordFlutterId;
            this.accessibilityFocusedSemanticsNode = null;
            return true;
        } else if (eventType != 65536) {
            return true;
        } else {
            this.embeddedInputFocusedNodeId = null;
            this.embeddedAccessibilityFocusedNodeId = null;
            return true;
        }
    }

    public AccessibilityNodeInfo findFocus(int i2) {
        if (i2 == 1) {
            SemanticsNode semanticsNode = this.inputFocusedSemanticsNode;
            if (semanticsNode != null) {
                return createAccessibilityNodeInfo(semanticsNode.id);
            }
            Integer num = this.embeddedInputFocusedNodeId;
            if (num != null) {
                return createAccessibilityNodeInfo(num.intValue());
            }
        } else if (i2 != 2) {
            return null;
        }
        SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode2 != null) {
            return createAccessibilityNodeInfo(semanticsNode2.id);
        }
        Integer num2 = this.embeddedAccessibilityFocusedNodeId;
        if (num2 != null) {
            return createAccessibilityNodeInfo(num2.intValue());
        }
        return null;
    }

    @VisibleForTesting
    public int getHoveredObjectId() {
        return this.hoveredObject.id;
    }

    public boolean isAccessibilityEnabled() {
        return this.accessibilityManager.isEnabled();
    }

    public boolean isTouchExplorationEnabled() {
        return this.accessibilityManager.isTouchExplorationEnabled();
    }

    @VisibleForTesting
    public AccessibilityNodeInfo obtainAccessibilityNodeInfo(View view, int i2) {
        return AccessibilityNodeInfo.obtain(view, i2);
    }

    public boolean onAccessibilityHoverEvent(MotionEvent motionEvent) {
        if (!this.accessibilityManager.isTouchExplorationEnabled() || this.flutterSemanticsTree.isEmpty()) {
            return false;
        }
        SemanticsNode access$4300 = getRootSemanticsNode().hitTest(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f});
        if (access$4300 != null && access$4300.platformViewId != -1) {
            return this.accessibilityViewEmbedder.onAccessibilityHoverEvent(access$4300.id, motionEvent);
        }
        if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
            handleTouchExploration(motionEvent.getX(), motionEvent.getY());
        } else if (motionEvent.getAction() == 10) {
            onTouchExplorationExit();
        } else {
            Log.d("flutter", "unexpected accessibility hover event: " + motionEvent);
            return false;
        }
        return true;
    }

    public boolean performAction(int i2, int i3, @Nullable Bundle bundle) {
        if (i2 >= 65536) {
            boolean performAction = this.accessibilityViewEmbedder.performAction(i2, i3, bundle);
            if (performAction && i3 == 128) {
                this.embeddedAccessibilityFocusedNodeId = null;
            }
            return performAction;
        }
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i2));
        boolean z = false;
        if (semanticsNode == null) {
            return false;
        }
        switch (i3) {
            case 16:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.TAP);
                return true;
            case 32:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.LONG_PRESS);
                return true;
            case 64:
                if (this.accessibilityFocusedSemanticsNode == null) {
                    this.rootAccessibilityView.invalidate();
                }
                this.accessibilityFocusedSemanticsNode = semanticsNode;
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.DID_GAIN_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(i2, 32768);
                if (semanticsNode.hasAction(Action.INCREASE) || semanticsNode.hasAction(Action.DECREASE)) {
                    sendAccessibilityEvent(i2, 4);
                }
                return true;
            case 128:
                SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
                if (semanticsNode2 != null && semanticsNode2.id == i2) {
                    this.accessibilityFocusedSemanticsNode = null;
                }
                Integer num = this.embeddedAccessibilityFocusedNodeId;
                if (num != null && num.intValue() == i2) {
                    this.embeddedAccessibilityFocusedNodeId = null;
                }
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.DID_LOSE_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(i2, 65536);
                return true;
            case 256:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return performCursorMoveAction(semanticsNode, i2, bundle, true);
            case 512:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return performCursorMoveAction(semanticsNode, i2, bundle, false);
            case 4096:
                if (semanticsNode.hasAction(Action.SCROLL_UP)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i2, Action.SCROLL_UP);
                } else if (semanticsNode.hasAction(Action.SCROLL_LEFT)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i2, Action.SCROLL_LEFT);
                } else if (!semanticsNode.hasAction(Action.INCREASE)) {
                    return false;
                } else {
                    String unused = semanticsNode.value = semanticsNode.increasedValue;
                    List unused2 = semanticsNode.valueAttributes = semanticsNode.increasedValueAttributes;
                    sendAccessibilityEvent(i2, 4);
                    this.accessibilityChannel.dispatchSemanticsAction(i2, Action.INCREASE);
                }
                return true;
            case 8192:
                if (semanticsNode.hasAction(Action.SCROLL_DOWN)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i2, Action.SCROLL_DOWN);
                } else if (semanticsNode.hasAction(Action.SCROLL_RIGHT)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i2, Action.SCROLL_RIGHT);
                } else if (!semanticsNode.hasAction(Action.DECREASE)) {
                    return false;
                } else {
                    String unused3 = semanticsNode.value = semanticsNode.decreasedValue;
                    List unused4 = semanticsNode.valueAttributes = semanticsNode.decreasedValueAttributes;
                    sendAccessibilityEvent(i2, 4);
                    this.accessibilityChannel.dispatchSemanticsAction(i2, Action.DECREASE);
                }
                return true;
            case 16384:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.COPY);
                return true;
            case 32768:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.PASTE);
                return true;
            case 65536:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.CUT);
                return true;
            case 131072:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                HashMap hashMap = new HashMap();
                if (bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT) && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT)) {
                    z = true;
                }
                if (z) {
                    hashMap.put("base", Integer.valueOf(bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT)));
                    hashMap.put("extent", Integer.valueOf(bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT)));
                } else {
                    hashMap.put("base", Integer.valueOf(semanticsNode.textSelectionExtent));
                    hashMap.put("extent", Integer.valueOf(semanticsNode.textSelectionExtent));
                }
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.SET_SELECTION, hashMap);
                SemanticsNode semanticsNode3 = this.flutterSemanticsTree.get(Integer.valueOf(i2));
                int unused5 = semanticsNode3.textSelectionBase = ((Integer) hashMap.get("base")).intValue();
                int unused6 = semanticsNode3.textSelectionExtent = ((Integer) hashMap.get("extent")).intValue();
                return true;
            case 1048576:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.DISMISS);
                return true;
            case 2097152:
                if (Build.VERSION.SDK_INT < 21) {
                    return false;
                }
                return performSetText(semanticsNode, i2, bundle);
            case ACTION_SHOW_ON_SCREEN /*16908342*/:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.SHOW_ON_SCREEN);
                return true;
            default:
                CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i3 - FIRST_RESOURCE_ID));
                if (customAccessibilityAction == null) {
                    return false;
                }
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.CUSTOM_ACTION, Integer.valueOf(customAccessibilityAction.id));
                return true;
        }
    }

    public void release() {
        this.isReleased = true;
        PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate2 = this.platformViewsAccessibilityDelegate;
        if (platformViewsAccessibilityDelegate2 != null) {
            platformViewsAccessibilityDelegate2.detachAccessibiltyBridge();
        }
        setOnAccessibilityChangeListener((OnAccessibilityChangeListener) null);
        this.accessibilityManager.removeAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
        if (Build.VERSION.SDK_INT >= 19) {
            this.accessibilityManager.removeTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        }
        this.contentResolver.unregisterContentObserver(this.animationScaleObserver);
        this.accessibilityChannel.setAccessibilityMessageHandler((AccessibilityChannel.AccessibilityMessageHandler) null);
    }

    public void reset() {
        this.flutterSemanticsTree.clear();
        SemanticsNode semanticsNode = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, 65536);
        }
        this.accessibilityFocusedSemanticsNode = null;
        this.hoveredObject = null;
        sendWindowContentChangeEvent(0);
    }

    public void setOnAccessibilityChangeListener(@Nullable OnAccessibilityChangeListener onAccessibilityChangeListener2) {
        this.onAccessibilityChangeListener = onAccessibilityChangeListener2;
    }

    public void updateCustomAccessibilityActions(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr) {
        String str;
        while (byteBuffer.hasRemaining()) {
            CustomAccessibilityAction orCreateAccessibilityAction = getOrCreateAccessibilityAction(byteBuffer.getInt());
            int unused = orCreateAccessibilityAction.overrideId = byteBuffer.getInt();
            int i2 = byteBuffer.getInt();
            String str2 = null;
            if (i2 == -1) {
                str = null;
            } else {
                str = strArr[i2];
            }
            String unused2 = orCreateAccessibilityAction.label = str;
            int i3 = byteBuffer.getInt();
            if (i3 != -1) {
                str2 = strArr[i3];
            }
            String unused3 = orCreateAccessibilityAction.hint = str2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: io.flutter.view.AccessibilityBridge$SemanticsNode} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateSemantics(@androidx.annotation.NonNull java.nio.ByteBuffer r9, @androidx.annotation.NonNull java.lang.String[] r10, @androidx.annotation.NonNull java.nio.ByteBuffer[] r11) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0005:
            boolean r1 = r9.hasRemaining()
            r2 = 0
            if (r1 == 0) goto L_0x005e
            int r1 = r9.getInt()
            io.flutter.view.AccessibilityBridge$SemanticsNode r1 = r8.getOrCreateSemanticsNode(r1)
            r1.updateWith(r9, r10, r11)
            io.flutter.view.AccessibilityBridge$Flag r3 = io.flutter.view.AccessibilityBridge.Flag.IS_HIDDEN
            boolean r3 = r1.hasFlag(r3)
            if (r3 == 0) goto L_0x0020
            goto L_0x0005
        L_0x0020:
            io.flutter.view.AccessibilityBridge$Flag r3 = io.flutter.view.AccessibilityBridge.Flag.IS_FOCUSED
            boolean r3 = r1.hasFlag(r3)
            if (r3 == 0) goto L_0x002a
            r8.inputFocusedSemanticsNode = r1
        L_0x002a:
            boolean r3 = r1.hadPreviousConfig
            if (r3 == 0) goto L_0x0033
            r0.add(r1)
        L_0x0033:
            int r3 = r1.platformViewId
            r4 = -1
            if (r3 == r4) goto L_0x0005
            io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate r3 = r8.platformViewsAccessibilityDelegate
            int r4 = r1.platformViewId
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r3 = r3.usesVirtualDisplay(r4)
            if (r3 != 0) goto L_0x0005
            io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate r3 = r8.platformViewsAccessibilityDelegate
            int r1 = r1.platformViewId
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            android.view.View r1 = r3.getPlatformViewById(r1)
            if (r1 == 0) goto L_0x0005
            r1.setImportantForAccessibility(r2)
            goto L_0x0005
        L_0x005e:
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
            io.flutter.view.AccessibilityBridge$SemanticsNode r10 = r8.getRootSemanticsNode()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r1 = 1
            if (r10 == 0) goto L_0x00bf
            r3 = 16
            float[] r3 = new float[r3]
            android.opengl.Matrix.setIdentityM(r3, r2)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r4 < r5) goto L_0x00b9
            r5 = 28
            if (r4 < r5) goto L_0x0085
            boolean r4 = r8.doesLayoutInDisplayCutoutModeRequireLeftInset()
            goto L_0x0086
        L_0x0085:
            r4 = 1
        L_0x0086:
            if (r4 == 0) goto L_0x00b9
            android.view.View r4 = r8.rootAccessibilityView
            android.view.WindowInsets r4 = r4.getRootWindowInsets()
            if (r4 == 0) goto L_0x00b9
            java.lang.Integer r5 = r8.lastLeftFrameInset
            int r6 = r4.getSystemWindowInsetLeft()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00a6
            boolean unused = r10.globalGeometryDirty = r1
            boolean unused = r10.inverseTransformDirty = r1
        L_0x00a6:
            int r4 = r4.getSystemWindowInsetLeft()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r8.lastLeftFrameInset = r4
            int r4 = r4.intValue()
            float r4 = (float) r4
            r5 = 0
            android.opengl.Matrix.translateM(r3, r2, r4, r5, r5)
        L_0x00b9:
            r10.updateRecursively(r3, r9, r2)
            r10.collectRoutes(r11)
        L_0x00bf:
            java.util.Iterator r10 = r11.iterator()
            r3 = 0
            r4 = r3
        L_0x00c5:
            boolean r5 = r10.hasNext()
            if (r5 == 0) goto L_0x00e3
            java.lang.Object r5 = r10.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r5 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r5
            java.util.List<java.lang.Integer> r6 = r8.flutterNavigationStack
            int r7 = r5.id
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r6 = r6.contains(r7)
            if (r6 != 0) goto L_0x00c5
            r4 = r5
            goto L_0x00c5
        L_0x00e3:
            if (r4 != 0) goto L_0x00f7
            int r10 = r11.size()
            if (r10 <= 0) goto L_0x00f7
            int r10 = r11.size()
            int r10 = r10 - r1
            java.lang.Object r10 = r11.get(r10)
            r4 = r10
            io.flutter.view.AccessibilityBridge$SemanticsNode r4 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r4
        L_0x00f7:
            if (r4 == 0) goto L_0x0116
            int r10 = r4.id
            int r5 = r8.previousRouteId
            if (r10 != r5) goto L_0x010d
            int r10 = r11.size()
            java.util.List<java.lang.Integer> r5 = r8.flutterNavigationStack
            int r5 = r5.size()
            if (r10 == r5) goto L_0x0116
        L_0x010d:
            int r10 = r4.id
            r8.previousRouteId = r10
            r8.onWindowNameChange(r4)
        L_0x0116:
            java.util.List<java.lang.Integer> r10 = r8.flutterNavigationStack
            r10.clear()
            java.util.Iterator r10 = r11.iterator()
        L_0x011f:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0139
            java.lang.Object r11 = r10.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r11
            java.util.List<java.lang.Integer> r4 = r8.flutterNavigationStack
            int r11 = r11.id
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r4.add(r11)
            goto L_0x011f
        L_0x0139:
            java.util.Map<java.lang.Integer, io.flutter.view.AccessibilityBridge$SemanticsNode> r10 = r8.flutterSemanticsTree
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x0143:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0162
            java.lang.Object r11 = r10.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r11 = r11.getValue()
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r11
            boolean r4 = r9.contains(r11)
            if (r4 != 0) goto L_0x0143
            r8.willRemoveSemanticsNode(r11)
            r10.remove()
            goto L_0x0143
        L_0x0162:
            r8.sendWindowContentChangeEvent(r2)
            java.util.Iterator r9 = r0.iterator()
        L_0x0169:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x034c
            java.lang.Object r10 = r9.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r10 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r10
            boolean r11 = r10.didScroll()
            if (r11 == 0) goto L_0x023a
            int r11 = r10.id
            r0 = 4096(0x1000, float:5.74E-42)
            android.view.accessibility.AccessibilityEvent r11 = r8.obtainAccessibilityEvent(r11, r0)
            float r0 = r10.scrollPosition
            float r4 = r10.scrollExtentMax
            float r5 = r10.scrollExtentMax
            boolean r5 = java.lang.Float.isInfinite(r5)
            r6 = 1200142336(0x4788b800, float:70000.0)
            r7 = 1203982336(0x47c35000, float:100000.0)
            if (r5 == 0) goto L_0x01a7
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x01a4
            r0 = 1200142336(0x4788b800, float:70000.0)
        L_0x01a4:
            r4 = 1203982336(0x47c35000, float:100000.0)
        L_0x01a7:
            float r5 = r10.scrollExtentMin
            boolean r5 = java.lang.Float.isInfinite(r5)
            if (r5 == 0) goto L_0x01be
            float r4 = r4 + r7
            r5 = -947341312(0xffffffffc788b800, float:-70000.0)
            int r6 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r6 >= 0) goto L_0x01bc
            r0 = -947341312(0xffffffffc788b800, float:-70000.0)
        L_0x01bc:
            float r0 = r0 + r7
            goto L_0x01c8
        L_0x01be:
            float r5 = r10.scrollExtentMin
            float r4 = r4 - r5
            float r5 = r10.scrollExtentMin
            float r0 = r0 - r5
        L_0x01c8:
            io.flutter.view.AccessibilityBridge$Action r5 = io.flutter.view.AccessibilityBridge.Action.SCROLL_UP
            boolean r5 = r10.hadAction(r5)
            if (r5 != 0) goto L_0x01f2
            io.flutter.view.AccessibilityBridge$Action r5 = io.flutter.view.AccessibilityBridge.Action.SCROLL_DOWN
            boolean r5 = r10.hadAction(r5)
            if (r5 == 0) goto L_0x01d9
            goto L_0x01f2
        L_0x01d9:
            io.flutter.view.AccessibilityBridge$Action r5 = io.flutter.view.AccessibilityBridge.Action.SCROLL_LEFT
            boolean r5 = r10.hadAction(r5)
            if (r5 != 0) goto L_0x01e9
            io.flutter.view.AccessibilityBridge$Action r5 = io.flutter.view.AccessibilityBridge.Action.SCROLL_RIGHT
            boolean r5 = r10.hadAction(r5)
            if (r5 == 0) goto L_0x01fa
        L_0x01e9:
            int r0 = (int) r0
            r11.setScrollX(r0)
            int r0 = (int) r4
            r11.setMaxScrollX(r0)
            goto L_0x01fa
        L_0x01f2:
            int r0 = (int) r0
            r11.setScrollY(r0)
            int r0 = (int) r4
            r11.setMaxScrollY(r0)
        L_0x01fa:
            int r0 = r10.scrollChildren
            if (r0 <= 0) goto L_0x0237
            int r0 = r10.scrollChildren
            r11.setItemCount(r0)
            int r0 = r10.scrollIndex
            r11.setFromIndex(r0)
            java.util.List r0 = r10.childrenInHitTestOrder
            java.util.Iterator r0 = r0.iterator()
            r4 = 0
        L_0x0217:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x022e
            java.lang.Object r5 = r0.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r5 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r5
            io.flutter.view.AccessibilityBridge$Flag r6 = io.flutter.view.AccessibilityBridge.Flag.IS_HIDDEN
            boolean r5 = r5.hasFlag(r6)
            if (r5 != 0) goto L_0x0217
            int r4 = r4 + 1
            goto L_0x0217
        L_0x022e:
            int r0 = r10.scrollIndex
            int r0 = r0 + r4
            int r0 = r0 - r1
            r11.setToIndex(r0)
        L_0x0237:
            r8.sendAccessibilityEvent(r11)
        L_0x023a:
            io.flutter.view.AccessibilityBridge$Flag r11 = io.flutter.view.AccessibilityBridge.Flag.IS_LIVE_REGION
            boolean r11 = r10.hasFlag(r11)
            if (r11 == 0) goto L_0x024f
            boolean r11 = r10.didChangeLabel()
            if (r11 == 0) goto L_0x024f
            int r11 = r10.id
            r8.sendWindowContentChangeEvent(r11)
        L_0x024f:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.accessibilityFocusedSemanticsNode
            if (r11 == 0) goto L_0x0284
            int r11 = r11.id
            int r0 = r10.id
            if (r11 != r0) goto L_0x0284
            io.flutter.view.AccessibilityBridge$Flag r11 = io.flutter.view.AccessibilityBridge.Flag.IS_SELECTED
            boolean r11 = r10.hadFlag(r11)
            if (r11 != 0) goto L_0x0284
            io.flutter.view.AccessibilityBridge$Flag r11 = io.flutter.view.AccessibilityBridge.Flag.IS_SELECTED
            boolean r11 = r10.hasFlag(r11)
            if (r11 == 0) goto L_0x0284
            int r11 = r10.id
            r0 = 4
            android.view.accessibility.AccessibilityEvent r11 = r8.obtainAccessibilityEvent(r11, r0)
            java.util.List r0 = r11.getText()
            java.lang.String r4 = r10.label
            r0.add(r4)
            r8.sendAccessibilityEvent(r11)
        L_0x0284:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.inputFocusedSemanticsNode
            if (r11 == 0) goto L_0x02b4
            int r11 = r11.id
            int r0 = r10.id
            if (r11 != r0) goto L_0x02b4
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.lastInputFocusedSemanticsNode
            if (r11 == 0) goto L_0x02a2
            int r11 = r11.id
            io.flutter.view.AccessibilityBridge$SemanticsNode r0 = r8.inputFocusedSemanticsNode
            int r0 = r0.id
            if (r11 == r0) goto L_0x02b4
        L_0x02a2:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.inputFocusedSemanticsNode
            r8.lastInputFocusedSemanticsNode = r11
            int r11 = r10.id
            r0 = 8
            android.view.accessibility.AccessibilityEvent r11 = r8.obtainAccessibilityEvent(r11, r0)
            r8.sendAccessibilityEvent(r11)
            goto L_0x02ba
        L_0x02b4:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.inputFocusedSemanticsNode
            if (r11 != 0) goto L_0x02ba
            r8.lastInputFocusedSemanticsNode = r3
        L_0x02ba:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.inputFocusedSemanticsNode
            if (r11 == 0) goto L_0x0169
            int r11 = r11.id
            int r0 = r10.id
            if (r11 != r0) goto L_0x0169
            io.flutter.view.AccessibilityBridge$Flag r11 = io.flutter.view.AccessibilityBridge.Flag.IS_TEXT_FIELD
            boolean r11 = r10.hadFlag(r11)
            if (r11 == 0) goto L_0x0169
            io.flutter.view.AccessibilityBridge$Flag r11 = io.flutter.view.AccessibilityBridge.Flag.IS_TEXT_FIELD
            boolean r11 = r10.hasFlag(r11)
            if (r11 == 0) goto L_0x0169
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.accessibilityFocusedSemanticsNode
            if (r11 == 0) goto L_0x02e8
            int r11 = r11.id
            io.flutter.view.AccessibilityBridge$SemanticsNode r0 = r8.inputFocusedSemanticsNode
            int r0 = r0.id
            if (r11 != r0) goto L_0x0169
        L_0x02e8:
            java.lang.String r11 = r10.previousValue
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x02f5
            java.lang.String r11 = r10.previousValue
            goto L_0x02f6
        L_0x02f5:
            r11 = r0
        L_0x02f6:
            java.lang.String r4 = r10.value
            if (r4 == 0) goto L_0x0300
            java.lang.String r0 = r10.value
        L_0x0300:
            int r4 = r10.id
            android.view.accessibility.AccessibilityEvent r11 = r8.createTextChangedEvent(r4, r11, r0)
            if (r11 == 0) goto L_0x030d
            r8.sendAccessibilityEvent(r11)
        L_0x030d:
            int r11 = r10.previousTextSelectionBase
            int r4 = r10.textSelectionBase
            if (r11 != r4) goto L_0x0321
            int r11 = r10.previousTextSelectionExtent
            int r4 = r10.textSelectionExtent
            if (r11 == r4) goto L_0x0169
        L_0x0321:
            int r11 = r10.id
            r4 = 8192(0x2000, float:1.14794E-41)
            android.view.accessibility.AccessibilityEvent r11 = r8.obtainAccessibilityEvent(r11, r4)
            java.util.List r4 = r11.getText()
            r4.add(r0)
            int r4 = r10.textSelectionBase
            r11.setFromIndex(r4)
            int r10 = r10.textSelectionExtent
            r11.setToIndex(r10)
            int r10 = r0.length()
            r11.setItemCount(r10)
            r8.sendAccessibilityEvent(r11)
            goto L_0x0169
        L_0x034c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityBridge.updateSemantics(java.nio.ByteBuffer, java.lang.String[], java.nio.ByteBuffer[]):void");
    }

    @VisibleForTesting
    public AccessibilityBridge(@NonNull View view, @NonNull AccessibilityChannel accessibilityChannel2, @NonNull final AccessibilityManager accessibilityManager2, @NonNull ContentResolver contentResolver2, @NonNull AccessibilityViewEmbedder accessibilityViewEmbedder2, PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate2) {
        this.flutterSemanticsTree = new HashMap();
        this.customAccessibilityActions = new HashMap();
        this.accessibilityFeatureFlags = 0;
        this.flutterNavigationStack = new ArrayList();
        this.previousRouteId = 0;
        this.lastLeftFrameInset = 0;
        this.isReleased = false;
        this.accessibilityMessageHandler = new AccessibilityChannel.AccessibilityMessageHandler() {
            public void announce(@NonNull String str) {
                AccessibilityBridge.this.rootAccessibilityView.announceForAccessibility(str);
            }

            public void onLongPress(int i2) {
                AccessibilityBridge.this.sendAccessibilityEvent(i2, 2);
            }

            public void onTap(int i2) {
                AccessibilityBridge.this.sendAccessibilityEvent(i2, 1);
            }

            public void onTooltip(@NonNull String str) {
                if (Build.VERSION.SDK_INT < 28) {
                    AccessibilityEvent access$300 = AccessibilityBridge.this.obtainAccessibilityEvent(0, 32);
                    access$300.getText().add(str);
                    AccessibilityBridge.this.sendAccessibilityEvent(access$300);
                }
            }

            public void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                AccessibilityBridge.this.updateCustomAccessibilityActions(byteBuffer, strArr);
            }

            public void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                for (ByteBuffer order : byteBufferArr) {
                    order.order(ByteOrder.LITTLE_ENDIAN);
                }
                AccessibilityBridge.this.updateSemantics(byteBuffer, strArr, byteBufferArr);
            }
        };
        this.accessibilityStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener() {
            public void onAccessibilityStateChanged(boolean z) {
                if (!AccessibilityBridge.this.isReleased) {
                    if (z) {
                        AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler(AccessibilityBridge.this.accessibilityMessageHandler);
                        AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityEnabled();
                    } else {
                        AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler((AccessibilityChannel.AccessibilityMessageHandler) null);
                        AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityDisabled();
                    }
                    if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                        AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(z, AccessibilityBridge.this.accessibilityManager.isTouchExplorationEnabled());
                    }
                }
            }
        };
        this.animationScaleObserver = new ContentObserver(new Handler()) {
            public void onChange(boolean z) {
                onChange(z, (Uri) null);
            }

            public void onChange(boolean z, Uri uri) {
                String str;
                if (!AccessibilityBridge.this.isReleased) {
                    if (Build.VERSION.SDK_INT < 17) {
                        str = null;
                    } else {
                        str = Settings.Global.getString(AccessibilityBridge.this.contentResolver, "transition_animation_scale");
                    }
                    if (str != null && str.equals("0")) {
                        AccessibilityBridge.access$1176(AccessibilityBridge.this, AccessibilityFeature.DISABLE_ANIMATIONS.value);
                    } else {
                        AccessibilityBridge.access$1172(AccessibilityBridge.this, ~AccessibilityFeature.DISABLE_ANIMATIONS.value);
                    }
                    AccessibilityBridge.this.sendLatestAccessibilityFlagsToFlutter();
                }
            }
        };
        this.rootAccessibilityView = view;
        this.accessibilityChannel = accessibilityChannel2;
        this.accessibilityManager = accessibilityManager2;
        this.contentResolver = contentResolver2;
        this.accessibilityViewEmbedder = accessibilityViewEmbedder2;
        this.platformViewsAccessibilityDelegate = platformViewsAccessibilityDelegate2;
        this.accessibilityStateChangeListener.onAccessibilityStateChanged(accessibilityManager2.isEnabled());
        this.accessibilityManager.addAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
        if (Build.VERSION.SDK_INT >= 19) {
            AnonymousClass4 r4 = new AccessibilityManager.TouchExplorationStateChangeListener() {
                public void onTouchExplorationStateChanged(boolean z) {
                    if (!AccessibilityBridge.this.isReleased) {
                        if (z) {
                            AccessibilityBridge.access$1176(AccessibilityBridge.this, AccessibilityFeature.ACCESSIBLE_NAVIGATION.value);
                        } else {
                            AccessibilityBridge.this.onTouchExplorationExit();
                            AccessibilityBridge.access$1172(AccessibilityBridge.this, ~AccessibilityFeature.ACCESSIBLE_NAVIGATION.value);
                        }
                        AccessibilityBridge.this.sendLatestAccessibilityFlagsToFlutter();
                        if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                            AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(accessibilityManager2.isEnabled(), z);
                        }
                    }
                }
            };
            this.touchExplorationStateChangeListener = r4;
            r4.onTouchExplorationStateChanged(accessibilityManager2.isTouchExplorationEnabled());
            this.accessibilityManager.addTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        } else {
            this.touchExplorationStateChangeListener = null;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.animationScaleObserver.onChange(false);
            this.contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, this.animationScaleObserver);
        }
        if (platformViewsAccessibilityDelegate2 != null) {
            platformViewsAccessibilityDelegate2.attachAccessibilityBridge(this);
        }
    }

    /* access modifiers changed from: private */
    public void sendAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        if (this.accessibilityManager.isEnabled()) {
            this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(this.rootAccessibilityView, accessibilityEvent);
        }
    }
}
