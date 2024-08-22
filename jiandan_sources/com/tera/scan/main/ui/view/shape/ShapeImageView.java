package com.tera.scan.main.ui.view.shape;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.text.TextUtilsCompat;
import com.tera.scan.app.R$styleable;
import com.tera.scan.ui.widget.RotateProgress;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00012\u00020\u0001:\u0006\u0001 \u0001¡\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010M\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010N\u001a\u00020JH\u0014J\u0006\u0010O\u001a\u00020\nJ\u0006\u0010P\u001a\u00020\nJ\u0006\u0010Q\u001a\u00020\nJ\u0006\u0010R\u001a\u00020\nJ\u0006\u0010S\u001a\u00020\nJ\u0006\u0010T\u001a\u00020\nJ\u0006\u0010U\u001a\u00020\u0007J\b\u0010V\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010W\u001a\u00020\nJ\u0006\u0010X\u001a\u00020\nJ\u0006\u0010Y\u001a\u00020\nJ\u0006\u0010Z\u001a\u00020\nJ\u0006\u0010[\u001a\u00020\nJ\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010]J\b\u0010^\u001a\u0004\u0018\u00010)J\b\u0010_\u001a\u00020`H\u0016J\u0006\u0010a\u001a\u00020\nJ\u0006\u0010b\u001a\u00020\nJ\u0006\u0010c\u001a\u00020\nJ\u0006\u0010d\u001a\u00020\nJ\u0006\u0010e\u001a\u00020\u001aJ\u0006\u0010f\u001a\u00020\nJ\u0006\u0010g\u001a\u00020\nJ\b\u0010h\u001a\u00020JH\u0002J\u0006\u0010,\u001a\u00020+J\u0006\u0010i\u001a\u00020+J\u0010\u0010j\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0015J(\u0010k\u001a\u00020J2\u0006\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u00072\u0006\u0010o\u001a\u00020\u0007H\u0014J\u000e\u0010p\u001a\u00020J2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010q\u001a\u00020J2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010r\u001a\u00020J2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010s\u001a\u00020J2\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010t\u001a\u00020J2\u0006\u0010u\u001a\u00020\nJ&\u0010t\u001a\u00020J2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nJ&\u0010v\u001a\u00020J2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010w\u001a\u00020J2\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010x\u001a\u00020J2\u0006\u0010\u0016\u001a\u00020\nJ\u0010\u0010y\u001a\u00020J2\b\b\u0001\u0010\u0017\u001a\u00020\u0007J\u0010\u0010z\u001a\u00020J2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010{\u001a\u00020J2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010|\u001a\u00020J2\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010}\u001a\u00020J2\u0006\u0010\u001c\u001a\u00020\nJ\u000e\u0010~\u001a\u00020J2\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010\u001a\u00020J2\u0006\u0010\u001f\u001a\u00020\nJ-\u0010\u0001\u001a\u00020+2\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0014J\u0010\u0010\u0001\u001a\u00020J2\u0007\u0010\u0001\u001a\u00020+J\u000f\u0010\u0001\u001a\u00020J2\u0006\u0010 \u001a\u00020\nJ\u0011\u0010\u0001\u001a\u00020J2\b\u0010(\u001a\u0004\u0018\u00010)J\u000f\u0010\u0001\u001a\u00020J2\u0006\u0010*\u001a\u00020+J\u0015\u0010\u0001\u001a\u00020J2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020J2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u0015\u0010\u0001\u001a\u00020J2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u000f\u0010\u0001\u001a\u00020J2\u0006\u0010.\u001a\u00020\nJ\u000f\u0010\u0001\u001a\u00020J2\u0006\u0010/\u001a\u00020\nJ\u0010\u0010\u0001\u001a\u00020J2\u0007\u0010\u0001\u001a\u00020\u0007J'\u0010\u0001\u001a\u00020J2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007J'\u0010\u0001\u001a\u00020J2\u0006\u0010H\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007J\u000f\u0010\u0001\u001a\u00020J2\u0006\u0010>\u001a\u00020\nJ\u000f\u0010\u0001\u001a\u00020J2\u0006\u0010?\u001a\u00020\nJ\u0012\u0010\u0001\u001a\u00020J2\u0007\u0010@\u001a\u00030\u0001H\u0016J\u000f\u0010\u0001\u001a\u00020J2\u0006\u0010F\u001a\u00020\u001aJ\u000f\u0010\u0001\u001a\u00020J2\u0006\u0010G\u001a\u00020\nJ\u000f\u0010\u0001\u001a\u00020J2\u0006\u0010H\u001a\u00020\nJ\t\u0010\u0001\u001a\u00020+H\u0002R$\u0010\t\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\"X\u0004¢\u0006\u0002\n\u0000R\"\u0010%\u001a\u0004\u0018\u00010$2\b\u0010#\u001a\u0004\u0018\u00010$@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R(\u0010A\u001a\u0004\u0018\u00010=2\b\u0010@\u001a\u0004\u0018\u00010=8F@FX\u000e¢\u0006\f\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u000e\u0010F\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006¢\u0001"}, d2 = {"Lcom/tera/scan/main/ui/view/shape/ShapeImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoCropHeightWidthRatio", "", "getAutoCropHeightWidthRatio", "()F", "setAutoCropHeightWidthRatio", "(F)V", "bgEndBottomRadius", "bgEndTopRadius", "bgLeftBottomRadius", "bgLeftTopRadius", "bgPaintWidth", "getBgPaintWidth", "bgRightBottomRadius", "bgRightTopRadius", "bgShapeColor", "Landroid/content/res/ColorStateList;", "bgShapeType", "Lcom/tera/scan/main/ui/view/shape/ShapeImageView$ShapeType;", "bgStartBottomRadius", "bgStartTopRadius", "curBgShapeColor", "endBottomRadius", "endTopRadius", "gradientAngle", "gradientColorStates", "", "<set-?>", "", "gradientColors", "getGradientColors", "()[I", "gradientPositions", "", "gradientRtlAngle", "", "isGradient", "isRtl", "leftBottomRadius", "leftTopRadius", "mAttacher", "Lcom/tera/scan/main/ui/view/shape/ShapeImageViewAttacher;", "mAutoCropHeightWidthRatio", "mBgPaint", "Landroid/graphics/Paint;", "mBgRectF", "Landroid/graphics/RectF;", "mDrawBgPath", "Landroid/graphics/Path;", "mDrawPath", "mDrawRectF", "mImagePaint", "mPendingScaleType", "Lcom/tera/scan/main/ui/view/shape/ShapeImageView$ShapeScaleType;", "rightBottomRadius", "rightTopRadius", "scaleType", "shapeScaleType", "getShapeScaleType", "()Lcom/tera/scan/main/ui/view/shape/ShapeImageView$ShapeScaleType;", "setShapeScaleType", "(Lcom/tera/scan/main/ui/view/shape/ShapeImageView$ShapeScaleType;)V", "shapeType", "startBottomRadius", "startTopRadius", "clipPadding", "", "canvas", "Landroid/graphics/Canvas;", "drawBgShape", "drawableStateChanged", "getBgEndBottomRadius", "getBgEndTopRadius", "getBgLeftBottomRadius", "getBgLeftTopRadius", "getBgRightBottomRadius", "getBgRightTopRadius", "getBgShapeColor", "getBgShapeType", "getBgStartBottomRadius", "getBgStartTopRadius", "getEndBottomRadius", "getEndTopRadius", "getGradientAngle", "getGradientColorStates", "", "getGradientPositions", "getImageMatrix", "Landroid/graphics/Matrix;", "getLeftBottomRadius", "getLeftTopRadius", "getRightBottomRadius", "getRightTopRadius", "getShapeType", "getStartBottomRadius", "getStartTopRadius", "init", "isGradientRtlAngle", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setBgEndBottomRadius", "setBgEndTopRadius", "setBgLeftBottomRadius", "setBgLeftTopRadius", "setBgRadius", "bgRadius", "setBgRelativeRadius", "setBgRightBottomRadius", "setBgRightTopRadius", "setBgShapeColor", "setBgShapeColors", "setBgShapeType", "setBgStartBottomRadius", "setBgStartTopRadius", "setEndBottomRadius", "setEndTopRadius", "setFrame", "l", "t", "r", "b", "setGradient", "gradient", "setGradientAngle", "setGradientPositions", "setGradientRtlAngle", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setImageResource", "resId", "setImageURI", "uri", "Landroid/net/Uri;", "setLeftBottomRadius", "setLeftTopRadius", "setRadius", "radius", "setRelativeRadius", "setRightBottomRadius", "setRightTopRadius", "setScaleType", "Landroid/widget/ImageView$ScaleType;", "setShapeType", "setStartBottomRadius", "setStartTopRadius", "updateColors", "Companion", "ShapeScaleType", "ShapeType", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShapeImageView extends AppCompatImageView {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public static final PorterDuffXfermode SRC_IN = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    public float bgEndBottomRadius;
    public float bgEndTopRadius;
    public float bgLeftBottomRadius;
    public float bgLeftTopRadius;
    public final float bgPaintWidth;
    public float bgRightBottomRadius;
    public float bgRightTopRadius;
    @Nullable
    public ColorStateList bgShapeColor;
    @Nullable
    public ShapeType bgShapeType;
    public float bgStartBottomRadius;
    public float bgStartTopRadius;
    public int curBgShapeColor;
    public float endBottomRadius;
    public float endTopRadius;
    public float gradientAngle;
    @NotNull
    public final List<ColorStateList> gradientColorStates;
    @Nullable
    public int[] gradientColors;
    @Nullable
    public float[] gradientPositions;
    public boolean gradientRtlAngle;
    public boolean isGradient;
    public boolean isRtl;
    public float leftBottomRadius;
    public float leftTopRadius;
    @Nullable
    public ShapeImageViewAttacher mAttacher;
    public float mAutoCropHeightWidthRatio;
    @Nullable
    public final Paint mBgPaint;
    @Nullable
    public RectF mBgRectF;
    @NotNull
    public final Path mDrawBgPath;
    @NotNull
    public final Path mDrawPath;
    @Nullable
    public RectF mDrawRectF;
    @NotNull
    public final Paint mImagePaint;
    @Nullable
    public ShapeScaleType mPendingScaleType;
    public float rightBottomRadius;
    public float rightTopRadius;
    @NotNull
    public ShapeType shapeType;
    public float startBottomRadius;
    public float startTopRadius;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/tera/scan/main/ui/view/shape/ShapeImageView$ShapeScaleType;", "", "Ljava/io/Serializable;", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "FIT_XY", "FIT_START", "FIT_CENTER", "FIT_END", "CENTER", "CENTER_CROP", "CENTER_INSIDE", "START_CROP", "END_CROP", "AUTO_START_CENTER_CROP", "AUTO_END_CENTER_CROP", "Companion", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ShapeScaleType implements Serializable {
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4),
        CENTER(5),
        CENTER_CROP(6),
        CENTER_INSIDE(7),
        START_CROP(8),
        END_CROP(9),
        AUTO_START_CENTER_CROP(10),
        AUTO_END_CENTER_CROP(11);
        
        @NotNull
        public static final qw Companion = null;
        public final int type;

        public static final class qw {
            public qw() {
            }

            public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Nullable
            public final ShapeScaleType ad(int i2) {
                switch (i2) {
                    case 1:
                        return ShapeScaleType.FIT_XY;
                    case 2:
                        return ShapeScaleType.FIT_START;
                    case 3:
                        return ShapeScaleType.FIT_CENTER;
                    case 4:
                        return ShapeScaleType.FIT_END;
                    case 5:
                        return ShapeScaleType.CENTER;
                    case 6:
                        return ShapeScaleType.CENTER_CROP;
                    case 7:
                        return ShapeScaleType.CENTER_INSIDE;
                    case 8:
                        return ShapeScaleType.START_CROP;
                    case 9:
                        return ShapeScaleType.END_CROP;
                    case 10:
                        return ShapeScaleType.AUTO_START_CENTER_CROP;
                    case 11:
                        return ShapeScaleType.AUTO_END_CENTER_CROP;
                    default:
                        return null;
                }
            }

            @Nullable
            public final ShapeScaleType de(@NotNull ImageView.ScaleType scaleType) {
                Intrinsics.checkNotNullParameter(scaleType, "scaleType");
                if (scaleType == ImageView.ScaleType.FIT_XY) {
                    return ShapeScaleType.FIT_XY;
                }
                if (scaleType == ImageView.ScaleType.FIT_START) {
                    return ShapeScaleType.FIT_START;
                }
                if (scaleType == ImageView.ScaleType.FIT_CENTER) {
                    return ShapeScaleType.FIT_CENTER;
                }
                if (scaleType == ImageView.ScaleType.FIT_END) {
                    return ShapeScaleType.FIT_END;
                }
                if (scaleType == ImageView.ScaleType.CENTER) {
                    return ShapeScaleType.CENTER;
                }
                if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                    return ShapeScaleType.CENTER_CROP;
                }
                if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                    return ShapeScaleType.CENTER_INSIDE;
                }
                return null;
            }

            @JvmStatic
            @Nullable
            public final ImageView.ScaleType qw(@NotNull ShapeScaleType shapeScaleType) {
                Intrinsics.checkNotNullParameter(shapeScaleType, "scaleType");
                if (shapeScaleType == ShapeScaleType.FIT_XY) {
                    return ImageView.ScaleType.FIT_XY;
                }
                if (shapeScaleType == ShapeScaleType.FIT_START) {
                    return ImageView.ScaleType.FIT_START;
                }
                if (shapeScaleType == ShapeScaleType.FIT_CENTER) {
                    return ImageView.ScaleType.FIT_CENTER;
                }
                if (shapeScaleType == ShapeScaleType.FIT_END) {
                    return ImageView.ScaleType.FIT_END;
                }
                if (shapeScaleType == ShapeScaleType.CENTER) {
                    return ImageView.ScaleType.CENTER;
                }
                if (shapeScaleType == ShapeScaleType.CENTER_CROP) {
                    return ImageView.ScaleType.CENTER_CROP;
                }
                if (shapeScaleType == ShapeScaleType.CENTER_INSIDE) {
                    return ImageView.ScaleType.CENTER_INSIDE;
                }
                return null;
            }
        }

        /* access modifiers changed from: public */
        static {
            Companion = new qw((DefaultConstructorMarker) null);
        }

        /* access modifiers changed from: public */
        ShapeScaleType(int i2) {
            this.type = i2;
        }

        @JvmStatic
        @Nullable
        public static final ImageView.ScaleType getScaleType(@NotNull ShapeScaleType shapeScaleType) {
            return Companion.qw(shapeScaleType);
        }

        public final int getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/tera/scan/main/ui/view/shape/ShapeImageView$ShapeType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "NONE", "RECTANGLE", "OVAL", "Companion", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ShapeType {
        NONE(0),
        RECTANGLE(1),
        OVAL(2);
        
        @NotNull
        public static final qw Companion = null;
        public final int type;

        public static final class qw {
            public qw() {
            }

            public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final ShapeType qw(int i2) {
                if (i2 == 1) {
                    return ShapeType.RECTANGLE;
                }
                if (i2 != 2) {
                    return ShapeType.NONE;
                }
                return ShapeType.OVAL;
            }
        }

        /* access modifiers changed from: public */
        static {
            Companion = new qw((DefaultConstructorMarker) null);
        }

        /* access modifiers changed from: public */
        ShapeType(int i2) {
            this.type = i2;
        }

        public final int getType() {
            return this.type;
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShapeImageView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShapeImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShapeImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.gradientColorStates = new ArrayList();
        this.mDrawPath = new Path();
        this.mDrawBgPath = new Path();
        this.isRtl = TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShapeImageView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…styleable.ShapeImageView)");
        this.mPendingScaleType = ShapeScaleType.Companion.ad(obtainStyledAttributes.getInt(2, 0));
        this.mAutoCropHeightWidthRatio = obtainStyledAttributes.getFloat(0, 2.0f);
        float dimension = obtainStyledAttributes.getDimension(25, 0.0f);
        this.leftTopRadius = obtainStyledAttributes.getDimension(24, dimension);
        this.leftBottomRadius = obtainStyledAttributes.getDimension(23, dimension);
        this.rightTopRadius = obtainStyledAttributes.getDimension(27, dimension);
        this.rightBottomRadius = obtainStyledAttributes.getDimension(26, dimension);
        this.startTopRadius = obtainStyledAttributes.getDimension(29, dimension);
        this.startBottomRadius = obtainStyledAttributes.getDimension(28, dimension);
        this.endTopRadius = obtainStyledAttributes.getDimension(22, dimension);
        this.endBottomRadius = obtainStyledAttributes.getDimension(21, dimension);
        this.shapeType = ShapeType.Companion.qw(obtainStyledAttributes.getInt(1, 1));
        this.bgShapeType = ShapeType.Companion.qw(obtainStyledAttributes.getInt(3, 0));
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(17);
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(5);
        ColorStateList colorStateList3 = obtainStyledAttributes.getColorStateList(7);
        this.bgShapeColor = obtainStyledAttributes.getColorStateList(6);
        this.gradientAngle = obtainStyledAttributes.getFloat(4, 0.0f);
        this.gradientRtlAngle = obtainStyledAttributes.getBoolean(16, false);
        this.isGradient = obtainStyledAttributes.getBoolean(10, false);
        this.bgPaintWidth = obtainStyledAttributes.getDimension(20, 1.0f);
        float dimension2 = obtainStyledAttributes.getDimension(13, 0.0f);
        this.bgLeftTopRadius = obtainStyledAttributes.getDimension(12, dimension2);
        this.bgLeftBottomRadius = obtainStyledAttributes.getDimension(11, dimension2);
        this.bgRightTopRadius = obtainStyledAttributes.getDimension(15, dimension2);
        this.bgRightBottomRadius = obtainStyledAttributes.getDimension(14, dimension2);
        this.bgStartTopRadius = obtainStyledAttributes.getDimension(19, dimension2);
        this.bgStartBottomRadius = obtainStyledAttributes.getDimension(18, dimension2);
        this.bgEndTopRadius = obtainStyledAttributes.getDimension(9, dimension2);
        this.bgEndBottomRadius = obtainStyledAttributes.getDimension(8, dimension2);
        obtainStyledAttributes.recycle();
        if (colorStateList != null) {
            this.gradientColorStates.add(colorStateList);
        }
        if (colorStateList2 != null) {
            this.gradientColorStates.add(colorStateList2);
        }
        if (colorStateList3 != null) {
            this.gradientColorStates.add(colorStateList3);
        }
        if (this.gradientColorStates.size() == 1) {
            List<ColorStateList> list = this.gradientColorStates;
            ColorStateList valueOf = ColorStateList.valueOf(0);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(Color.TRANSPARENT)");
            list.add(valueOf);
        }
        if (this.bgShapeColor == null) {
            this.bgShapeColor = ColorStateList.valueOf(-16777216);
        }
        updateColors();
        Paint paint = new Paint(1);
        this.mBgPaint = paint;
        paint.setColor(this.curBgShapeColor);
        this.mBgPaint.setStrokeWidth(this.bgPaintWidth);
        this.mBgPaint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.mImagePaint = paint2;
        paint2.setXfermode((Xfermode) null);
        init();
    }

    private final void clipPadding(Canvas canvas) {
        ShapeImageViewAttacher shapeImageViewAttacher = this.mAttacher;
        Intrinsics.checkNotNull(shapeImageViewAttacher);
        ShapeScaleType shapeScaleType = shapeImageViewAttacher.getShapeScaleType();
        boolean z = shapeScaleType == ShapeScaleType.START_CROP || shapeScaleType == ShapeScaleType.END_CROP || shapeScaleType == ShapeScaleType.AUTO_START_CENTER_CROP || shapeScaleType == ShapeScaleType.AUTO_END_CENTER_CROP || getScaleType() == ImageView.ScaleType.CENTER || getScaleType() == ImageView.ScaleType.CENTER_CROP;
        int ad2 = fe.mmm.qw.xxx.p032if.th.de.qw.ad(this);
        int de2 = fe.mmm.qw.xxx.p032if.th.de.qw.de(this);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (!z) {
            return;
        }
        if (ad2 > 0 || de2 > 0 || paddingTop > 0 || paddingBottom > 0) {
            RectF rectF = this.mDrawRectF;
            Intrinsics.checkNotNull(rectF);
            canvas.clipRect(rectF);
        }
    }

    private final void drawBgShape(Canvas canvas) {
        float f;
        float f2;
        float signum;
        float signum2;
        ShapeType shapeType2 = this.bgShapeType;
        if (shapeType2 != null && shapeType2 != ShapeType.NONE) {
            int height = getHeight();
            int width = getWidth();
            RectF rectF = this.mBgRectF;
            if (rectF == null) {
                float f3 = this.bgPaintWidth;
                float f4 = (float) 2;
                this.mBgRectF = new RectF(f3 / f4, f3 / f4, ((float) width) - (f3 / f4), ((float) height) - (f3 / f4));
            } else {
                Intrinsics.checkNotNull(rectF);
                float f5 = this.bgPaintWidth;
                float f6 = (float) 2;
                rectF.set(f5 / f6, f5 / f6, ((float) width) - (f5 / f6), ((float) height) - (f5 / f6));
            }
            if (this.isGradient && this.gradientColors != null) {
                float f7 = this.gradientAngle;
                if (this.gradientRtlAngle && this.isRtl) {
                    f7 = -f7;
                }
                float f8 = (float) RotateProgress.FULL_DEGREE;
                float f9 = f7 % f8;
                if (f9 < 0.0f) {
                    f9 += f8;
                }
                int i2 = 180;
                if ((f9 < 0.0f || f9 >= 90.0f) && (f9 < 180.0f || f9 >= 270.0f)) {
                    float f10 = (float) height;
                    float f11 = ((float) 180) - f9;
                    int i3 = (f9 > 180.0f ? 1 : (f9 == 180.0f ? 0 : -1));
                    float signum3 = (float) (((double) (f10 / 2.0f)) + (((double) ((Math.signum(f11) * ((float) width)) / 2.0f)) * Math.tan(Math.toRadians((double) (f9 - ((float) (i3 < 0 ? 90 : 270)))))));
                    if (signum3 >= f10 || signum3 <= 0.0f) {
                        signum3 = (float) (i3 < 0 ? height : 0);
                        signum2 = (float) (((double) (width / 2)) + (((double) ((Math.signum(f11) * f10) / 2.0f)) * Math.tan(Math.toRadians((double) (((float) (i3 < 0 ? 180 : RotateProgress.FULL_DEGREE)) - f9)))));
                    } else {
                        signum2 = (float) (i3 < 0 ? width : 0);
                    }
                    f2 = signum2;
                    f = signum3;
                } else {
                    double d = (double) (width / 2);
                    float f12 = ((float) 90) - f9;
                    double signum4 = (double) ((Math.signum(f12) * ((float) height)) / 2.0f);
                    int i4 = (f9 > 180.0f ? 1 : (f9 == 180.0f ? 0 : -1));
                    if (i4 < 0) {
                        i2 = 0;
                    }
                    float tan = (float) (d + (signum4 * Math.tan(Math.toRadians((double) (f9 - ((float) i2))))));
                    float f13 = (float) width;
                    if (tan >= f13 || tan <= 0.0f) {
                        tan = (float) (f9 < 90.0f ? width : 0);
                        signum = (float) (((double) (height / 2)) - (((double) ((Math.signum(f12) * f13) / 2.0f)) * Math.tan(Math.toRadians((double) (((float) (i4 >= 0 ? 270 : 90)) - f9)))));
                    } else {
                        signum = (float) (f9 < 90.0f ? 0 : height);
                    }
                    f = signum;
                    f2 = tan;
                }
                int[] iArr = this.gradientColors;
                Intrinsics.checkNotNull(iArr);
                LinearGradient linearGradient = new LinearGradient(f2, f, ((float) width) - f2, ((float) height) - f, iArr, this.gradientPositions, Shader.TileMode.CLAMP);
                Paint paint = this.mBgPaint;
                Intrinsics.checkNotNull(paint);
                paint.setShader(linearGradient);
            }
            this.mDrawBgPath.reset();
            if (this.bgShapeType == ShapeType.OVAL) {
                Path path = this.mDrawBgPath;
                RectF rectF2 = this.mBgRectF;
                Intrinsics.checkNotNull(rectF2);
                path.addOval(rectF2, Path.Direction.CCW);
            } else {
                float qw2 = fe.mmm.qw.xxx.p032if.th.de.qw.qw.qw(this.isRtl ? this.bgEndTopRadius : this.bgStartTopRadius, this.bgLeftTopRadius);
                float qw3 = fe.mmm.qw.xxx.p032if.th.de.qw.qw.qw(this.isRtl ? this.bgStartTopRadius : this.bgEndTopRadius, this.bgRightTopRadius);
                float qw4 = fe.mmm.qw.xxx.p032if.th.de.qw.qw.qw(this.isRtl ? this.bgStartBottomRadius : this.bgEndBottomRadius, this.bgRightBottomRadius);
                float qw5 = fe.mmm.qw.xxx.p032if.th.de.qw.qw.qw(this.isRtl ? this.bgEndBottomRadius : this.bgStartBottomRadius, this.bgLeftBottomRadius);
                float[] fArr = {qw2, qw2, qw3, qw3, qw4, qw4, qw5, qw5};
                Path path2 = this.mDrawBgPath;
                RectF rectF3 = this.mBgRectF;
                Intrinsics.checkNotNull(rectF3);
                path2.addRoundRect(rectF3, fArr, Path.Direction.CCW);
            }
            Path path3 = this.mDrawBgPath;
            Paint paint2 = this.mBgPaint;
            Intrinsics.checkNotNull(paint2);
            canvas.drawPath(path3, paint2);
        }
    }

    private final void init() {
        ShapeImageViewAttacher shapeImageViewAttacher = new ShapeImageViewAttacher(this);
        this.mAttacher = shapeImageViewAttacher;
        Intrinsics.checkNotNull(shapeImageViewAttacher);
        shapeImageViewAttacher.setAutoCropHeightWidthRatio(this.mAutoCropHeightWidthRatio);
        if (this.mPendingScaleType != null) {
            super.setScaleType(ImageView.ScaleType.MATRIX);
            setShapeScaleType(this.mPendingScaleType);
            this.mPendingScaleType = null;
            return;
        }
        ShapeScaleType.qw qwVar = ShapeScaleType.Companion;
        ImageView.ScaleType scaleType = getScaleType();
        Intrinsics.checkNotNullExpressionValue(scaleType, "scaleType");
        setShapeScaleType(qwVar.de(scaleType));
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean updateColors() {
        /*
            r9 = this;
            int[] r0 = r9.getDrawableState()
            android.content.res.ColorStateList r1 = r9.bgShapeColor
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r2 = 0
            int r1 = r1.getColorForState(r0, r2)
            int r3 = r9.curBgShapeColor
            r4 = 1
            if (r1 == r3) goto L_0x001e
            r9.curBgShapeColor = r1
            android.graphics.Paint r3 = r9.mBgPaint
            if (r3 == 0) goto L_0x001c
            r3.setColor(r1)
        L_0x001c:
            r1 = 1
            goto L_0x001f
        L_0x001e:
            r1 = 0
        L_0x001f:
            java.util.List<android.content.res.ColorStateList> r3 = r9.gradientColorStates
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x0078
            java.util.List<android.content.res.ColorStateList> r3 = r9.gradientColorStates
            int r3 = r3.size()
            int[] r5 = new int[r3]
            java.util.List<android.content.res.ColorStateList> r6 = r9.gradientColorStates
            int r6 = r6.size()
            r7 = 0
        L_0x0037:
            if (r7 >= r6) goto L_0x004a
            java.util.List<android.content.res.ColorStateList> r8 = r9.gradientColorStates
            java.lang.Object r8 = r8.get(r7)
            android.content.res.ColorStateList r8 = (android.content.res.ColorStateList) r8
            int r8 = r8.getColorForState(r0, r2)
            r5[r7] = r8
            int r7 = r7 + 1
            goto L_0x0037
        L_0x004a:
            int[] r0 = r9.gradientColors
            if (r0 != 0) goto L_0x0051
            r9.gradientColors = r5
            goto L_0x0079
        L_0x0051:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.length
            if (r0 == r3) goto L_0x005a
            r9.gradientColors = r5
            goto L_0x0079
        L_0x005a:
            int[] r0 = r9.gradientColors
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.length
            r3 = 0
        L_0x0061:
            if (r3 >= r0) goto L_0x0072
            int[] r6 = r9.gradientColors
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r6 = r6[r3]
            r7 = r5[r3]
            if (r6 == r7) goto L_0x006f
            goto L_0x0073
        L_0x006f:
            int r3 = r3 + 1
            goto L_0x0061
        L_0x0072:
            r2 = 1
        L_0x0073:
            if (r2 != 0) goto L_0x0078
            r9.gradientColors = r5
            goto L_0x0079
        L_0x0078:
            r4 = r1
        L_0x0079:
            if (r4 == 0) goto L_0x007e
            r9.invalidate()
        L_0x007e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.ui.view.shape.ShapeImageView.updateColors():boolean");
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

    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateColors();
    }

    public final float getAutoCropHeightWidthRatio() {
        return this.mAutoCropHeightWidthRatio;
    }

    public final float getBgEndBottomRadius() {
        return this.bgEndBottomRadius;
    }

    public final float getBgEndTopRadius() {
        return this.bgEndTopRadius;
    }

    public final float getBgLeftBottomRadius() {
        return this.bgLeftBottomRadius;
    }

    public final float getBgLeftTopRadius() {
        return this.bgLeftTopRadius;
    }

    public final float getBgPaintWidth() {
        return this.bgPaintWidth;
    }

    public final float getBgRightBottomRadius() {
        return this.bgRightBottomRadius;
    }

    public final float getBgRightTopRadius() {
        return this.bgRightTopRadius;
    }

    public final int getBgShapeColor() {
        return this.curBgShapeColor;
    }

    @Nullable
    public final ShapeType getBgShapeType() {
        return this.bgShapeType;
    }

    public final float getBgStartBottomRadius() {
        return this.bgStartBottomRadius;
    }

    public final float getBgStartTopRadius() {
        return this.bgStartTopRadius;
    }

    public final float getEndBottomRadius() {
        return this.endBottomRadius;
    }

    public final float getEndTopRadius() {
        return this.endTopRadius;
    }

    public final float getGradientAngle() {
        return this.gradientAngle;
    }

    @Nullable
    public final List<ColorStateList> getGradientColorStates() {
        return this.gradientColorStates;
    }

    @Nullable
    public final int[] getGradientColors() {
        return this.gradientColors;
    }

    @Nullable
    public final float[] getGradientPositions() {
        return this.gradientPositions;
    }

    @NotNull
    public Matrix getImageMatrix() {
        ShapeImageViewAttacher shapeImageViewAttacher = this.mAttacher;
        Intrinsics.checkNotNull(shapeImageViewAttacher);
        return shapeImageViewAttacher.getImageMatrix();
    }

    public final float getLeftBottomRadius() {
        return this.leftBottomRadius;
    }

    public final float getLeftTopRadius() {
        return this.leftTopRadius;
    }

    public final float getRightBottomRadius() {
        return this.rightBottomRadius;
    }

    public final float getRightTopRadius() {
        return this.rightTopRadius;
    }

    @Nullable
    public final ShapeScaleType getShapeScaleType() {
        ShapeImageViewAttacher shapeImageViewAttacher = this.mAttacher;
        Intrinsics.checkNotNull(shapeImageViewAttacher);
        return shapeImageViewAttacher.getShapeScaleType();
    }

    @NotNull
    public final ShapeType getShapeType() {
        return this.shapeType;
    }

    public final float getStartBottomRadius() {
        return this.startBottomRadius;
    }

    public final float getStartTopRadius() {
        return this.startTopRadius;
    }

    public final boolean isGradient() {
        return this.isGradient;
    }

    public final boolean isGradientRtlAngle() {
        return this.gradientRtlAngle;
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        drawBgShape(canvas);
        clipPadding(canvas);
        this.mDrawPath.reset();
        ShapeType shapeType2 = this.shapeType;
        if (shapeType2 == ShapeType.OVAL) {
            Path path = this.mDrawPath;
            RectF rectF = this.mDrawRectF;
            Intrinsics.checkNotNull(rectF);
            path.addOval(rectF, Path.Direction.CCW);
        } else if (shapeType2 == ShapeType.RECTANGLE) {
            float qw2 = fe.mmm.qw.xxx.p032if.th.de.qw.qw.qw(this.isRtl ? this.endTopRadius : this.startTopRadius, this.leftTopRadius);
            float qw3 = fe.mmm.qw.xxx.p032if.th.de.qw.qw.qw(this.isRtl ? this.startTopRadius : this.endTopRadius, this.rightTopRadius);
            float qw4 = fe.mmm.qw.xxx.p032if.th.de.qw.qw.qw(this.isRtl ? this.startBottomRadius : this.endBottomRadius, this.rightBottomRadius);
            float qw5 = fe.mmm.qw.xxx.p032if.th.de.qw.qw.qw(this.isRtl ? this.endBottomRadius : this.startBottomRadius, this.leftBottomRadius);
            float[] fArr = {qw2, qw2, qw3, qw3, qw4, qw4, qw5, qw5};
            Path path2 = this.mDrawPath;
            RectF rectF2 = this.mDrawRectF;
            Intrinsics.checkNotNull(rectF2);
            path2.addRoundRect(rectF2, fArr, Path.Direction.CCW);
        }
        ShapeType shapeType3 = this.shapeType;
        if (shapeType3 == ShapeType.OVAL || shapeType3 == ShapeType.RECTANGLE) {
            canvas.saveLayer(this.mDrawRectF, this.mImagePaint, 31);
            canvas.drawPath(this.mDrawPath, this.mImagePaint);
            this.mImagePaint.setXfermode(SRC_IN);
            canvas.saveLayer(this.mDrawRectF, this.mImagePaint, 31);
            super.onDraw(canvas);
            canvas.restore();
            this.mImagePaint.setXfermode((Xfermode) null);
            return;
        }
        super.onDraw(canvas);
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.mDrawRectF = new RectF((float) fe.mmm.qw.xxx.p032if.th.de.qw.ad(this), (float) getPaddingTop(), (float) (i2 - fe.mmm.qw.xxx.p032if.th.de.qw.de(this)), (float) (i3 - getPaddingBottom()));
    }

    public final void setAutoCropHeightWidthRatio(float f) {
        this.mAutoCropHeightWidthRatio = f;
        ShapeImageViewAttacher shapeImageViewAttacher = this.mAttacher;
        if (shapeImageViewAttacher != null) {
            Intrinsics.checkNotNull(shapeImageViewAttacher);
            shapeImageViewAttacher.setAutoCropHeightWidthRatio(f);
            ShapeImageViewAttacher shapeImageViewAttacher2 = this.mAttacher;
            Intrinsics.checkNotNull(shapeImageViewAttacher2);
            shapeImageViewAttacher2.update();
        }
    }

    public final void setBgEndBottomRadius(float f) {
        this.bgEndBottomRadius = f;
        invalidate();
    }

    public final void setBgEndTopRadius(float f) {
        this.bgEndTopRadius = f;
        invalidate();
    }

    public final void setBgLeftBottomRadius(float f) {
        this.bgLeftBottomRadius = f;
        invalidate();
    }

    public final void setBgLeftTopRadius(float f) {
        this.bgLeftTopRadius = f;
        invalidate();
    }

    public final void setBgRadius(float f) {
        this.bgLeftTopRadius = f;
        this.bgLeftBottomRadius = f;
        this.bgRightTopRadius = f;
        this.bgRightBottomRadius = f;
        invalidate();
    }

    public final void setBgRelativeRadius(float f, float f2, float f3, float f4) {
        this.bgStartTopRadius = f;
        this.bgEndTopRadius = f2;
        this.bgEndBottomRadius = f3;
        this.bgStartBottomRadius = f4;
        invalidate();
    }

    public final void setBgRightBottomRadius(float f) {
        this.bgRightBottomRadius = f;
        invalidate();
    }

    public final void setBgRightTopRadius(float f) {
        this.bgRightTopRadius = f;
        invalidate();
    }

    public final void setBgShapeColor(@ColorInt int i2) {
        setBgShapeColors(ColorStateList.valueOf(i2));
    }

    public final void setBgShapeColors(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.bgShapeColor = colorStateList;
            updateColors();
        }
    }

    public final void setBgShapeType(@Nullable ShapeType shapeType2) {
        this.bgShapeType = shapeType2;
        invalidate();
    }

    public final void setBgStartBottomRadius(float f) {
        this.bgStartBottomRadius = f;
        invalidate();
    }

    public final void setBgStartTopRadius(float f) {
        this.bgStartTopRadius = f;
        invalidate();
    }

    public final void setEndBottomRadius(float f) {
        this.endBottomRadius = f;
        invalidate();
    }

    public final void setEndTopRadius(float f) {
        this.endTopRadius = f;
        invalidate();
    }

    public boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        if (frame) {
            ShapeImageViewAttacher shapeImageViewAttacher = this.mAttacher;
            Intrinsics.checkNotNull(shapeImageViewAttacher);
            shapeImageViewAttacher.update();
        }
        return frame;
    }

    public final void setGradient(boolean z) {
        this.isGradient = z;
        invalidate();
    }

    public final void setGradientAngle(float f) {
        this.gradientAngle = f;
        invalidate();
    }

    public final void setGradientPositions(@Nullable float[] fArr) {
        this.gradientPositions = fArr;
        invalidate();
    }

    public final void setGradientRtlAngle(boolean z) {
        this.gradientRtlAngle = z;
        invalidate();
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        ShapeImageViewAttacher shapeImageViewAttacher = this.mAttacher;
        if (shapeImageViewAttacher != null) {
            Intrinsics.checkNotNull(shapeImageViewAttacher);
            shapeImageViewAttacher.update();
        }
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        ShapeImageViewAttacher shapeImageViewAttacher = this.mAttacher;
        if (shapeImageViewAttacher != null) {
            Intrinsics.checkNotNull(shapeImageViewAttacher);
            shapeImageViewAttacher.update();
        }
    }

    public void setImageURI(@Nullable Uri uri) {
        super.setImageURI(uri);
        ShapeImageViewAttacher shapeImageViewAttacher = this.mAttacher;
        if (shapeImageViewAttacher != null) {
            Intrinsics.checkNotNull(shapeImageViewAttacher);
            shapeImageViewAttacher.update();
        }
    }

    public final void setLeftBottomRadius(float f) {
        this.leftBottomRadius = f;
        invalidate();
    }

    public final void setLeftTopRadius(float f) {
        this.leftTopRadius = f;
        invalidate();
    }

    public final void setRadius(int i2) {
        float f = (float) i2;
        this.leftTopRadius = f;
        this.rightTopRadius = f;
        this.leftBottomRadius = f;
        this.rightBottomRadius = f;
        invalidate();
    }

    public final void setRelativeRadius(int i2, int i3, int i4, int i5) {
        this.startTopRadius = (float) i2;
        this.endTopRadius = (float) i3;
        this.endBottomRadius = (float) i4;
        this.startBottomRadius = (float) i5;
        invalidate();
    }

    public final void setRightBottomRadius(float f) {
        this.rightBottomRadius = f;
        invalidate();
    }

    public final void setRightTopRadius(float f) {
        this.rightTopRadius = f;
        invalidate();
    }

    public void setScaleType(@NotNull ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        super.setScaleType(scaleType);
    }

    public final void setShapeScaleType(@Nullable ShapeScaleType shapeScaleType) {
        ShapeImageViewAttacher shapeImageViewAttacher = this.mAttacher;
        if (shapeImageViewAttacher == null) {
            this.mPendingScaleType = shapeScaleType;
        } else if (shapeScaleType != null) {
            Intrinsics.checkNotNull(shapeImageViewAttacher);
            shapeImageViewAttacher.setScaleType(shapeScaleType);
        }
    }

    public final void setShapeType(@NotNull ShapeType shapeType2) {
        Intrinsics.checkNotNullParameter(shapeType2, "shapeType");
        this.shapeType = shapeType2;
        invalidate();
    }

    public final void setStartBottomRadius(float f) {
        this.startBottomRadius = f;
        invalidate();
    }

    public final void setStartTopRadius(float f) {
        this.startTopRadius = f;
        invalidate();
    }

    public final void setBgRadius(float f, float f2, float f3, float f4) {
        this.bgLeftTopRadius = f;
        this.bgRightTopRadius = f2;
        this.bgRightBottomRadius = f3;
        this.bgLeftBottomRadius = f4;
        invalidate();
    }

    public final void setRadius(int i2, int i3, int i4, int i5) {
        this.leftTopRadius = (float) i2;
        this.rightTopRadius = (float) i3;
        this.rightBottomRadius = (float) i4;
        this.leftBottomRadius = (float) i5;
        invalidate();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShapeImageView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
