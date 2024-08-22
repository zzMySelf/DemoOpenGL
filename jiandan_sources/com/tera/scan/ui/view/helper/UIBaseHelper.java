package com.tera.scan.ui.view.helper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import com.baidu.apollon.utils.ResUtils;
import com.tera.scan.app.R$styleable;
import fe.mmm.qw.f.ad.fe.ad;
import fe.mmm.qw.f.ad.fe.qw;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0017\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0003\b\u0001\b\u0016\u0018\u0000 µ\u0002*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002µ\u0002B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\b\u0010x\u001a\u00020yH\u0002J\u0006\u0010z\u001a\u00020yJ\u0018\u0010{\u001a\u00020y2\u0006\u0010|\u001a\u00020f2\u0006\u0010}\u001a\u00020=H\u0002J\u0019\u0010~\u001a\u00020y2\t\u0010\u001a\u0005\u0018\u00010\u0001H\u0010¢\u0006\u0003\b\u0001J\"\u0010\u0001\u001a\u00020y2\u0007\u0010\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001J\u0007\u0010\u0001\u001a\u00020\tJ\t\u0010\u0001\u001a\u0004\u0018\u00010\u0018J\u0007\u0010\u0001\u001a\u00020\tJ\t\u0010\u0001\u001a\u0004\u0018\u00010\u0018J\u0007\u0010\u0001\u001a\u00020\tJ\t\u0010\u0001\u001a\u0004\u0018\u00010\u0018J\u0007\u0010\u0001\u001a\u00020\tJ\t\u0010\u0001\u001a\u0004\u0018\u00010\u0018J\u0007\u0010\u0001\u001a\u00020\tJ\t\u0010\u0001\u001a\u0004\u0018\u00010\u0018J\t\u0010\u0001\u001a\u0004\u0018\u00010\u0015J\t\u0010\u0001\u001a\u0004\u0018\u00010\u0015J\t\u0010\u0001\u001a\u0004\u0018\u00010\u0015J\t\u0010\u0001\u001a\u0004\u0018\u00010\u0015J\t\u0010\u0001\u001a\u0004\u0018\u00010\u0015J*\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030o2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\tH\u0002¢\u0006\u0003\u0010\u0001J\u0007\u0010\u0001\u001a\u00020\tJ\u0007\u0010\u0001\u001a\u00020\tJ\u0007\u0010\u0001\u001a\u00020\tJ\u0007\u0010\u0001\u001a\u00020\tJ\u0007\u0010\u0001\u001a\u00020\tJ\u0007\u0010\u0001\u001a\u000200J\u0007\u0010 \u0001\u001a\u000200J\u0007\u0010¡\u0001\u001a\u00020\tJ\u0007\u0010¢\u0001\u001a\u00020\tJ\u0007\u0010£\u0001\u001a\u00020\tJ\u0007\u0010¤\u0001\u001a\u00020\tJ\u0007\u0010¥\u0001\u001a\u00020\tJ\t\u0010¦\u0001\u001a\u000200H\u0016J\t\u0010§\u0001\u001a\u000200H\u0016J\t\u0010¨\u0001\u001a\u000200H\u0016J\t\u0010©\u0001\u001a\u000200H\u0016J\t\u0010ª\u0001\u001a\u000200H\u0016J\u0007\u0010«\u0001\u001a\u000200J\u0007\u0010¬\u0001\u001a\u000200J\u0013\u0010­\u0001\u001a\u00020L2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0007\u0010®\u0001\u001a\u000200J\u0007\u0010¯\u0001\u001a\u00020\tJ\u0007\u0010°\u0001\u001a\u00020\tJ\u0007\u0010±\u0001\u001a\u00020\tJ\u0007\u0010²\u0001\u001a\u00020\tJ\u0007\u0010³\u0001\u001a\u000200J,\u0010´\u0001\u001a\u00020y2\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010µ\u0001\u001a\u0005\u0018\u00010¶\u00012\u0007\u0010·\u0001\u001a\u00020\tH\u0010¢\u0006\u0003\b¸\u0001J\u0013\u0010¹\u0001\u001a\u00020y2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010º\u0001\u001a\u00020y2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010»\u0001\u001a\u00020y2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010¼\u0001\u001a\u00020y2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010½\u0001\u001a\u00020y2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010¾\u0001\u001a\u00020yH\u0002J\u0013\u0010¿\u0001\u001a\u00020y2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010À\u0001\u001a\u00020y2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010Á\u0001\u001a\u00020y2\b\u0010\u0001\u001a\u00030\u0001H\u0002J!\u0010Â\u0001\u001a\u00020\f2\u0007\u0010Ã\u0001\u001a\u00020\t2\u0007\u0010Ä\u0001\u001a\u00020\tH\u0000¢\u0006\u0003\bÅ\u0001J\u001a\u0010Æ\u0001\u001a\u00020y2\t\b\u0001\u0010Ç\u0001\u001a\u00020\tH\u0010¢\u0006\u0003\bÈ\u0001J\u001a\u0010É\u0001\u001a\u00020y2\t\b\u0001\u0010Ê\u0001\u001a\u00020\tH\u0010¢\u0006\u0003\bË\u0001J!\u0010Ì\u0001\u001a\u00020\u00182\u0007\u0010Í\u0001\u001a\u00020\t2\u0007\u0010Î\u0001\u001a\u00020\tH\u0010¢\u0006\u0003\bÏ\u0001J\u000f\u0010Ð\u0001\u001a\u00020yH\u0010¢\u0006\u0003\bÑ\u0001J\t\u0010Ò\u0001\u001a\u00020yH\u0002J\u001b\u0010Ó\u0001\u001a\u00020y2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tJ\u0012\u0010Ô\u0001\u001a\u00020y2\t\b\u0001\u0010Õ\u0001\u001a\u00020\tJ\u0010\u0010Ö\u0001\u001a\u00020y2\u0007\u0010×\u0001\u001a\u00020\u0018J\u0012\u0010Ø\u0001\u001a\u00020y2\t\b\u0001\u0010Ù\u0001\u001a\u00020\tJ\u0010\u0010Ú\u0001\u001a\u00020y2\u0007\u0010Û\u0001\u001a\u00020\u0018J\u0012\u0010Ü\u0001\u001a\u00020y2\t\b\u0001\u0010Ý\u0001\u001a\u00020\tJ\u0010\u0010Þ\u0001\u001a\u00020y2\u0007\u0010ß\u0001\u001a\u00020\u0018J\u0012\u0010à\u0001\u001a\u00020y2\t\b\u0001\u0010á\u0001\u001a\u00020\tJ\u0010\u0010â\u0001\u001a\u00020y2\u0007\u0010ã\u0001\u001a\u00020\u0018J\u0012\u0010ä\u0001\u001a\u00020y2\t\b\u0001\u0010å\u0001\u001a\u00020\tJ\u0010\u0010æ\u0001\u001a\u00020y2\u0007\u0010ç\u0001\u001a\u00020\u0018J\u0010\u0010è\u0001\u001a\u00020y2\u0007\u0010é\u0001\u001a\u00020\u0015J\u0010\u0010ê\u0001\u001a\u00020y2\u0007\u0010ë\u0001\u001a\u00020\u0015J\u0010\u0010ì\u0001\u001a\u00020y2\u0007\u0010í\u0001\u001a\u00020\u0015J\u0010\u0010î\u0001\u001a\u00020y2\u0007\u0010ï\u0001\u001a\u00020\u0015J\u0010\u0010ð\u0001\u001a\u00020y2\u0007\u0010ñ\u0001\u001a\u00020\u0015J\t\u0010ò\u0001\u001a\u00020yH\u0002J\t\u0010ó\u0001\u001a\u00020yH\u0002J\t\u0010ô\u0001\u001a\u00020yH\u0002J>\u0010õ\u0001\u001a\u00020y2\t\b\u0001\u0010ö\u0001\u001a\u00020\t2\t\b\u0001\u0010÷\u0001\u001a\u00020\t2\t\b\u0001\u0010ø\u0001\u001a\u00020\t2\t\b\u0001\u0010ù\u0001\u001a\u00020\t2\t\b\u0001\u0010ú\u0001\u001a\u00020\tJ\u0012\u0010û\u0001\u001a\u00020y2\t\b\u0001\u0010Ç\u0001\u001a\u00020\tJ\u0012\u0010ü\u0001\u001a\u00020y2\t\b\u0001\u0010Ç\u0001\u001a\u00020\tJ\u0012\u0010ý\u0001\u001a\u00020y2\t\b\u0001\u0010Ç\u0001\u001a\u00020\tJ\u0012\u0010þ\u0001\u001a\u00020y2\t\b\u0001\u0010Ç\u0001\u001a\u00020\tJ\u0012\u0010ÿ\u0001\u001a\u00020y2\t\b\u0001\u0010Ç\u0001\u001a\u00020\tJ\u0019\u0010\u0002\u001a\u00020y2\u0007\u0010\u0002\u001a\u0002002\u0007\u0010\u0002\u001a\u000200J\u0010\u0010\u0002\u001a\u00020y2\u0007\u0010\u0002\u001a\u000200J\u0010\u0010\u0002\u001a\u00020y2\u0007\u0010\u0002\u001a\u000200J\t\u0010\u0002\u001a\u00020yH\u0002J\t\u0010\u0002\u001a\u00020yH\u0002J\t\u0010\u0002\u001a\u00020yH\u0002J\t\u0010\u0002\u001a\u00020yH\u0002J4\u0010\u0002\u001a\u00020y2\u0007\u0010ö\u0001\u001a\u00020\t2\u0007\u0010÷\u0001\u001a\u00020\t2\u0007\u0010ø\u0001\u001a\u00020\t2\u0007\u0010ù\u0001\u001a\u00020\t2\u0007\u0010ú\u0001\u001a\u00020\tJ\u0010\u0010\u0002\u001a\u00020y2\u0007\u0010\u0002\u001a\u00020\tJ\u0010\u0010\u0002\u001a\u00020y2\u0007\u0010\u0002\u001a\u00020\tJ\u0010\u0010\u0002\u001a\u00020y2\u0007\u0010\u0002\u001a\u00020\tJ\u0010\u0010\u0002\u001a\u00020y2\u0007\u0010\u0002\u001a\u00020\tJ\u0010\u0010\u0002\u001a\u00020y2\u0007\u0010\u0002\u001a\u00020\tJ!\u0010\u0002\u001a\u0004\u0018\u00010\u00132\t\u0010\u0002\u001a\u0004\u0018\u00010\u00132\t\u0010\u0002\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u0002\u001a\u00020y2\u0007\u0010\u0002\u001a\u000200H\u0016J-\u0010\u0002\u001a\u00020y2\u0007\u0010\u0002\u001a\u0002002\u0007\u0010\u0002\u001a\u0002002\u0007\u0010\u0002\u001a\u0002002\u0007\u0010\u0002\u001a\u000200H\u0016J\u0012\u0010\u0002\u001a\u00020y2\u0007\u0010\u0002\u001a\u000200H\u0016J\u0012\u0010\u0002\u001a\u00020y2\u0007\u0010\u0002\u001a\u000200H\u0016J\u0012\u0010\u0002\u001a\u00020y2\u0007\u0010\u0002\u001a\u000200H\u0016J\u0012\u0010\u0002\u001a\u00020y2\u0007\u0010\u0002\u001a\u000200H\u0016J\t\u0010\u0002\u001a\u00020yH\u0002J\t\u0010\u0002\u001a\u00020yH\u0002J\u000f\u0010\u0002\u001a\u00020y2\u0006\u0010I\u001a\u000200J\u000f\u0010 \u0002\u001a\u00020y2\u0006\u0010J\u001a\u000200J\u0010\u0010¡\u0002\u001a\u00020y2\u0007\u0010¢\u0002\u001a\u00020LJ\u000f\u0010£\u0002\u001a\u00020y2\u0006\u0010M\u001a\u000200J\u000f\u0010¤\u0002\u001a\u00020y2\u0006\u0010N\u001a\u00020\tJ\t\u0010¥\u0002\u001a\u00020yH\u0002J\t\u0010¦\u0002\u001a\u00020yH\u0002J\u000f\u0010§\u0002\u001a\u00020y2\u0006\u0010a\u001a\u00020\tJ\u000f\u0010¨\u0002\u001a\u00020y2\u0006\u0010b\u001a\u00020\tJ\u000f\u0010©\u0002\u001a\u00020y2\u0006\u0010c\u001a\u00020\tJ\u000f\u0010ª\u0002\u001a\u00020y2\u0006\u0010j\u001a\u000200J4\u0010«\u0002\u001a\u00020y2\u0007\u0010ö\u0001\u001a\u00020\u00152\u0007\u0010÷\u0001\u001a\u00020\u00152\u0007\u0010ø\u0001\u001a\u00020\u00152\u0007\u0010ù\u0001\u001a\u00020\u00152\u0007\u0010ú\u0001\u001a\u00020\u0015J>\u0010«\u0002\u001a\u00020y2\t\b\u0001\u0010ö\u0001\u001a\u00020\t2\t\b\u0001\u0010÷\u0001\u001a\u00020\t2\t\b\u0001\u0010ø\u0001\u001a\u00020\t2\t\b\u0001\u0010ù\u0001\u001a\u00020\t2\t\b\u0001\u0010ú\u0001\u001a\u00020\tJ4\u0010¬\u0002\u001a\u00020y2\u0007\u0010­\u0002\u001a\u00020\u00182\u0007\u0010®\u0002\u001a\u00020\u00182\u0007\u0010¯\u0002\u001a\u00020\u00182\u0007\u0010°\u0002\u001a\u00020\u00182\u0007\u0010±\u0002\u001a\u00020\u0018J\t\u0010²\u0002\u001a\u00020yH\u0002J\t\u0010³\u0002\u001a\u00020yH\u0002J\t\u0010´\u0002\u001a\u00020\fH\u0002R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000f\"\u0004\b;\u0010\u0011R\u000e\u0010<\u001a\u00020=X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u000e\u0010D\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020=X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010l\u001a\u0004\u0018\u00010mX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180oX\u0004¢\u0006\u0004\n\u0002\u0010pR\u000e\u0010q\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00028\u0000X\u000e¢\u0006\u0010\n\u0002\u0010v\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0010\u0010w\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006¶\u0002"}, d2 = {"Lcom/tera/scan/ui/view/helper/UIBaseHelper;", "T", "Landroid/view/View;", "", "context", "Landroid/content/Context;", "uiView", "(Landroid/content/Context;Landroid/view/View;)V", "aspectRatioX", "", "aspectRatioY", "value", "", "autoState", "getAutoState", "()Z", "setAutoState", "(Z)V", "backgroundChecked", "Landroid/graphics/drawable/GradientDrawable;", "backgroundCheckedBmp", "Landroid/graphics/drawable/Drawable;", "backgroundColorChecked", "backgroundColorCheckedArray", "", "backgroundColorNormal", "backgroundColorNormalArray", "backgroundColorPressed", "backgroundColorPressedArray", "backgroundColorSelected", "backgroundColorSelectedArray", "backgroundColorUnable", "backgroundColorUnableArray", "backgroundDrawable", "backgroundNormal", "backgroundNormalBmp", "backgroundPressed", "backgroundPressedBmp", "backgroundSelected", "backgroundSelectedBmp", "backgroundUnable", "backgroundUnableBmp", "borderColorChecked", "borderColorNormal", "borderColorPressed", "borderColorSelected", "borderColorUnable", "borderDashGap", "", "borderDashWidth", "borderRadii", "", "borderWidthChecked", "borderWidthNormal", "borderWidthPressed", "borderWidthSelected", "borderWidthUnable", "clipCorners", "getClipCorners", "setClipCorners", "clipPath", "Landroid/graphics/Path;", "clipRect", "Landroid/graphics/Rect;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "cornerRadius", "cornerRadiusBottomLeft", "cornerRadiusBottomRight", "cornerRadiusTopLeft", "cornerRadiusTopRight", "gradientCenterX", "gradientCenterY", "gradientOrientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "gradientRadius", "gradientType", "hasCheckedBgBmp", "hasCheckedBgColor", "hasCheckedBorderColor", "hasCheckedBorderWidth", "hasNormalBgBmp", "hasNormalBgColor", "hasPressedBgBmp", "hasPressedBgColor", "hasPressedBorderColor", "hasPressedBorderWidth", "hasSelectedBgBmp", "hasSelectedBgColor", "hasSelectedBorderColor", "hasSelectedBorderWidth", "hasUnableBgBmp", "hasUnableBgColor", "hasUnableBorderColor", "hasUnableBorderWidth", "shadowColor", "shadowDx", "shadowDy", "shadowPath", "shadowPathBottomLeftRectF", "Landroid/graphics/RectF;", "shadowPathBottomRightRectF", "shadowPathTopLeftRectF", "shadowPathTopRightRectF", "shadowRadius", "shadowRectF", "stateBackground", "Landroid/graphics/drawable/StateListDrawable;", "states", "", "[[I", "touchSlop", "getUiView", "()Landroid/view/View;", "setUiView", "(Landroid/view/View;)V", "Landroid/view/View;", "viewBackground", "addOnGlobalLayoutListener", "", "cleanDefaultBackground", "computeCornerPath", "rectF", "path", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchDraw$component_ui_widget_aiscanConfigRelease", "drawShadow", "paint", "Landroid/graphics/Paint;", "drawShadow$component_ui_widget_aiscanConfigRelease", "getBackgroundColorChecked", "getBackgroundColorCheckedArray", "getBackgroundColorNormal", "getBackgroundColorNormalArray", "getBackgroundColorPressed", "getBackgroundColorPressedArray", "getBackgroundColorSelected", "getBackgroundColorSelectedArray", "getBackgroundColorUnable", "getBackgroundColorUnableArray", "getBackgroundDrawableChecked", "getBackgroundDrawableNormal", "getBackgroundDrawablePressed", "getBackgroundDrawableSelected", "getBackgroundDrawableUnable", "getBackgroundInfo", "a", "Landroid/content/res/TypedArray;", "styleableRes", "(Landroid/content/res/TypedArray;I)[Ljava/lang/Object;", "getBorderColorChecked", "getBorderColorNormal", "getBorderColorPressed", "getBorderColorSelected", "getBorderColorUnable", "getBorderDashGap", "getBorderDashWidth", "getBorderWidthChecked", "getBorderWidthNormal", "getBorderWidthPressed", "getBorderWidthSelected", "getBorderWidthUnable", "getCornerRadius", "getCornerRadiusBottomLeft", "getCornerRadiusBottomRight", "getCornerRadiusTopLeft", "getCornerRadiusTopRight", "getGradientCenterX", "getGradientCenterY", "getGradientOrientation", "getGradientRadius", "getGradientType", "getShadowColor", "getShadowDx", "getShadowDy", "getShadowRadius", "initAttr", "attr", "Landroid/util/AttributeSet;", "defStyleAttr", "initAttr$component_ui_widget_aiscanConfigRelease", "initAutoStateAttr", "initBgAttr", "initBorderAttr", "initClipCorners", "initCornerAttr", "initDefaultBackground", "initFixedAspectRatioAttr", "initGradientAttr", "initShadowAttr", "isOutsideView", "x", "y", "isOutsideView$component_ui_widget_aiscanConfigRelease", "onBackgroundColorSet", "color", "onBackgroundColorSet$component_ui_widget_aiscanConfigRelease", "onBackgroundDrawableSet", "resid", "onBackgroundDrawableSet$component_ui_widget_aiscanConfigRelease", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onMeasure$component_ui_widget_aiscanConfigRelease", "refreshState", "refreshState$component_ui_widget_aiscanConfigRelease", "refreshStateListDrawable", "setAspectRatio", "setBackgroundColorChecked", "colorChecked", "setBackgroundColorCheckedArray", "colorCheckedArray", "setBackgroundColorNormal", "colorNormal", "setBackgroundColorNormalArray", "colorNormalArray", "setBackgroundColorPressed", "colorPressed", "setBackgroundColorPressedArray", "colorPressedArray", "setBackgroundColorSelected", "colorSelected", "setBackgroundColorSelectedArray", "colorSelectedArray", "setBackgroundColorUnable", "colorUnable", "setBackgroundColorUnableArray", "colorUnableArray", "setBackgroundDrawableChecked", "drawableChecked", "setBackgroundDrawableNormal", "drawableNormal", "setBackgroundDrawablePressed", "drawablePressed", "setBackgroundDrawableSelected", "drawableSelected", "setBackgroundDrawableUnable", "drawableUnable", "setBackgroundState", "setBorder", "setBorderChecked", "setBorderColor", "normal", "pressed", "unable", "checked", "selected", "setBorderColorChecked", "setBorderColorNormal", "setBorderColorPressed", "setBorderColorSelected", "setBorderColorUnable", "setBorderDash", "dashWidth", "dashGap", "setBorderDashGap", "setBorderDashWidth", "setBorderNormal", "setBorderPressed", "setBorderSelected", "setBorderUnable", "setBorderWidth", "setBorderWidthChecked", "width", "setBorderWidthNormal", "setBorderWidthPressed", "setBorderWidthSelected", "setBorderWidthUnable", "setColors", "drawable", "colors", "setCornerRadius", "radius", "topLeft", "topRight", "bottomRight", "bottomLeft", "setCornerRadiusBottomLeft", "setCornerRadiusBottomRight", "setCornerRadiusTopLeft", "setCornerRadiusTopRight", "setDefaultBackground", "setGradient", "setGradientCenterX", "setGradientCenterY", "setGradientOrientation", "orientation", "setGradientRadius", "setGradientType", "setRadiusUI", "setRadiusValue", "setShadowColor", "setShadowDx", "setShadowDy", "setShadowRadius", "setStateBackgroundColor", "setStateBackgroundColorArray", "normalArray", "pressedArray", "unableArray", "checkedArray", "selectedArray", "setup", "updatePropertyFlags", "useShadow", "Companion", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class UIBaseHelper<T extends View> {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public float H;
    public float I;
    public float J;
    public float K;
    public float L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;
    @Nullable
    public Drawable a;
    public boolean a0;
    @Nullable
    public GradientDrawable aaa;
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public T f7368ad;
    @Nullable
    public Drawable b;
    public boolean b0;
    @Nullable
    public Drawable c;
    public boolean c0;
    @Nullable
    public Drawable d;
    public boolean d0;
    @Nullable
    public int[] ddd;

    /* renamed from: de  reason: collision with root package name */
    public int f7369de;
    @Nullable
    public Drawable e;
    public boolean e0;
    @Nullable
    public GradientDrawable eee;
    public int f;
    @NotNull
    public final Rect f0;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public Drawable f7370fe;
    public float g;
    @NotNull
    public final Path g0;
    public int ggg;
    public float h;

    /* renamed from: i  reason: collision with root package name */
    public int f7371i;

    /* renamed from: if  reason: not valid java name */
    public int f314if;
    public float j;
    @NotNull
    public GradientDrawable.Orientation k;
    public int l;
    public int m;
    @Nullable
    public int[] mmm;
    public int n;
    @Nullable
    public int[] nn;

    /* renamed from: o  reason: collision with root package name */
    public int f7372o;
    public float p;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f7373pf;
    public int ppp;
    @NotNull
    public final RectF q;
    @Nullable
    public GradientDrawable qqq;
    @NotNull
    public Context qw;
    @NotNull
    public final Path r;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public Drawable f7374rg;
    @Nullable
    public GradientDrawable rrr;
    @NotNull
    public final RectF s;

    /* renamed from: switch  reason: not valid java name */
    public int f315switch;
    @NotNull
    public final RectF t;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final int[][] f7375th = new int[6][];
    @Nullable
    public GradientDrawable tt;
    @NotNull
    public final RectF u;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final float[] f7376uk = new float[8];
    public float v;
    @Nullable
    public int[] vvv;
    public float w;
    public int when;
    public int x;
    @Nullable
    public int[] xxx;
    public int y;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public StateListDrawable f7377yj;
    public int z;

    public UIBaseHelper(@NotNull Context context, @NotNull T t2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(t2, "uiView");
        this.qw = context;
        this.f7368ad = t2;
        this.f7369de = ViewConfiguration.get(context).getScaledTouchSlop();
        de();
        this.k = GradientDrawable.Orientation.TOP_BOTTOM;
        this.q = new RectF();
        this.r = new Path();
        this.s = new RectF();
        new RectF();
        this.t = new RectF();
        this.u = new RectF();
        this.f0 = new Rect();
        this.g0 = new Path();
    }

    public final void a(boolean z2) {
        this.f7373pf = z2;
        rrr();
    }

    public void aaa(@ColorInt int i2) {
        this.f7370fe = this.f7368ad.getBackground();
        if (!this.M) {
            this.f314if = i2;
        }
        j();
        d();
    }

    public final void b(@ColorInt int i2) {
        this.f314if = i2;
        this.M = true;
        if (!this.N) {
            if (this.R) {
                i2 = this.ppp;
            }
            this.f315switch = i2;
            GradientDrawable gradientDrawable = this.qqq;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(i2);
            }
        }
        if (!this.P) {
            int i3 = this.f314if;
            this.when = i3;
            GradientDrawable gradientDrawable2 = this.eee;
            if (gradientDrawable2 != null) {
                gradientDrawable2.setColor(i3);
            }
        }
        if (!this.R) {
            int i4 = this.f314if;
            this.ppp = i4;
            GradientDrawable gradientDrawable3 = this.rrr;
            if (gradientDrawable3 != null) {
                gradientDrawable3.setColor(i4);
            }
        }
        if (!this.S) {
            int i5 = this.f314if;
            this.ggg = i5;
            GradientDrawable gradientDrawable4 = this.tt;
            if (gradientDrawable4 != null) {
                gradientDrawable4.setColor(i5);
            }
        }
        GradientDrawable gradientDrawable5 = this.aaa;
        if (gradientDrawable5 != null) {
            gradientDrawable5.setColor(this.f314if);
        }
        d();
    }

    public final void c(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "colorNormalArray");
        this.vvv = iArr;
        this.M = true;
        if (!this.N) {
            if (this.R) {
                iArr = this.nn;
            }
            this.xxx = iArr;
            this.qqq = g(this.qqq, iArr);
        }
        if (!this.P) {
            int[] iArr2 = this.vvv;
            this.ddd = iArr2;
            this.eee = g(this.eee, iArr2);
        }
        if (!this.R) {
            int[] iArr3 = this.vvv;
            this.nn = iArr3;
            this.rrr = g(this.rrr, iArr3);
        }
        if (!this.S) {
            int[] iArr4 = this.vvv;
            this.mmm = iArr4;
            this.tt = g(this.tt, iArr4);
        }
        this.aaa = g(this.aaa, this.vvv);
        e();
        m();
        k();
        d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r6 = this;
            int r0 = r6.f314if
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0018
            int r0 = r6.when
            if (r0 != 0) goto L_0x0018
            int r0 = r6.f315switch
            if (r0 != 0) goto L_0x0018
            int r0 = r6.ppp
            if (r0 != 0) goto L_0x0018
            int r0 = r6.ggg
            if (r0 != 0) goto L_0x0018
            r0 = 1
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            int[] r3 = r6.vvv
            if (r3 != 0) goto L_0x002f
            int[] r3 = r6.ddd
            if (r3 != 0) goto L_0x002f
            int[] r3 = r6.xxx
            if (r3 != 0) goto L_0x002f
            int[] r3 = r6.nn
            if (r3 != 0) goto L_0x002f
            int[] r3 = r6.mmm
            if (r3 != 0) goto L_0x002f
            r3 = 1
            goto L_0x0030
        L_0x002f:
            r3 = 0
        L_0x0030:
            android.graphics.drawable.Drawable r4 = r6.a
            if (r4 != 0) goto L_0x0046
            android.graphics.drawable.Drawable r4 = r6.b
            if (r4 != 0) goto L_0x0046
            android.graphics.drawable.Drawable r4 = r6.c
            if (r4 != 0) goto L_0x0046
            android.graphics.drawable.Drawable r4 = r6.d
            if (r4 != 0) goto L_0x0046
            android.graphics.drawable.Drawable r4 = r6.e
            if (r4 != 0) goto L_0x0046
            r4 = 1
            goto L_0x0047
        L_0x0046:
            r4 = 0
        L_0x0047:
            if (r0 == 0) goto L_0x0050
            if (r3 == 0) goto L_0x0050
            if (r4 != 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            r0 = 0
            goto L_0x0051
        L_0x0050:
            r0 = 1
        L_0x0051:
            float r3 = r6.v
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x005a
            r3 = 1
            goto L_0x005b
        L_0x005a:
            r3 = 0
        L_0x005b:
            if (r3 == 0) goto L_0x0093
            float r3 = r6.w
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0065
            r3 = 1
            goto L_0x0066
        L_0x0065:
            r3 = 0
        L_0x0066:
            if (r3 == 0) goto L_0x0093
            int r3 = r6.x
            if (r3 != 0) goto L_0x0093
            int r3 = r6.y
            if (r3 != 0) goto L_0x0093
            int r3 = r6.z
            if (r3 != 0) goto L_0x0093
            int r3 = r6.A
            if (r3 != 0) goto L_0x0093
            int r3 = r6.B
            if (r3 != 0) goto L_0x0093
            int r3 = r6.C
            if (r3 != 0) goto L_0x0093
            int r3 = r6.D
            if (r3 != 0) goto L_0x0093
            int r3 = r6.E
            if (r3 != 0) goto L_0x0093
            int r3 = r6.F
            if (r3 != 0) goto L_0x0093
            int r3 = r6.G
            if (r3 == 0) goto L_0x0091
            goto L_0x0093
        L_0x0091:
            r3 = 0
            goto L_0x0094
        L_0x0093:
            r3 = 1
        L_0x0094:
            float r5 = r6.H
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x009c
            r5 = 1
            goto L_0x009d
        L_0x009c:
            r5 = 0
        L_0x009d:
            if (r5 == 0) goto L_0x00ce
            float r5 = r6.I
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x00a7
            r5 = 1
            goto L_0x00a8
        L_0x00a7:
            r5 = 0
        L_0x00a8:
            if (r5 == 0) goto L_0x00ce
            float r5 = r6.J
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x00b2
            r5 = 1
            goto L_0x00b3
        L_0x00b2:
            r5 = 0
        L_0x00b3:
            if (r5 == 0) goto L_0x00ce
            float r5 = r6.K
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x00bd
            r5 = 1
            goto L_0x00be
        L_0x00bd:
            r5 = 0
        L_0x00be:
            if (r5 == 0) goto L_0x00ce
            float r5 = r6.L
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x00c8
            r4 = 1
            goto L_0x00c9
        L_0x00c8:
            r4 = 0
        L_0x00c9:
            if (r4 != 0) goto L_0x00cc
            goto L_0x00ce
        L_0x00cc:
            r4 = 0
            goto L_0x00cf
        L_0x00ce:
            r4 = 1
        L_0x00cf:
            if (r0 != 0) goto L_0x00d7
            if (r4 != 0) goto L_0x00d7
            if (r3 == 0) goto L_0x00d6
            goto L_0x00d7
        L_0x00d6:
            r1 = 0
        L_0x00d7:
            if (r1 != 0) goto L_0x00dc
            android.graphics.drawable.Drawable r0 = r6.f7370fe
            goto L_0x00de
        L_0x00dc:
            android.graphics.drawable.StateListDrawable r0 = r6.f7377yj
        L_0x00de:
            r6.f7374rg = r0
            T r1 = r6.f7368ad
            r1.setBackground(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.ui.view.helper.UIBaseHelper.d():void");
    }

    public final void ddd(TypedArray typedArray) {
        this.f = typedArray.getInt(30, 0);
        this.k = i(typedArray);
        this.g = (float) typedArray.getDimensionPixelSize(29, -1);
        this.h = typedArray.getFloat(26, 0.5f);
        this.j = typedArray.getFloat(27, 0.5f);
    }

    public final void de() {
        this.f7368ad.getViewTreeObserver().addOnGlobalLayoutListener(new UIBaseHelper$addOnGlobalLayoutListener$1(this));
    }

    public final void e() {
        GradientDrawable gradientDrawable = this.aaa;
        if (gradientDrawable != null) {
            gradientDrawable.setStroke(this.x, this.C, this.v, this.w);
        }
        GradientDrawable gradientDrawable2 = this.qqq;
        if (gradientDrawable2 != null) {
            gradientDrawable2.setStroke(this.y, this.D, this.v, this.w);
        }
        GradientDrawable gradientDrawable3 = this.eee;
        if (gradientDrawable3 != null) {
            gradientDrawable3.setStroke(this.z, this.E, this.v, this.w);
        }
        GradientDrawable gradientDrawable4 = this.rrr;
        if (gradientDrawable4 != null) {
            gradientDrawable4.setStroke(this.A, this.F, this.v, this.w);
        }
        GradientDrawable gradientDrawable5 = this.tt;
        if (gradientDrawable5 != null) {
            gradientDrawable5.setStroke(this.B, this.G, this.v, this.w);
        }
        d();
    }

    @NotNull
    public int[] eee(int i2, int i3) {
        int[] iArr = new int[2];
        if (this.f7371i <= 0 || this.f7372o <= 0) {
            iArr[0] = i2;
            iArr[1] = i3;
        } else {
            int size = View.MeasureSpec.getSize(i2);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((size * this.f7372o) / this.f7371i, View.MeasureSpec.getMode(i3));
            iArr[0] = i2;
            iArr[1] = makeMeasureSpec;
        }
        return iArr;
    }

    public final void f(boolean z2) {
        this.e0 = z2;
    }

    public final void fe(RectF rectF, Path path) {
        path.reset();
        path.moveTo(rectF.left + this.f7376uk[0], rectF.top);
        path.lineTo(rectF.right - this.f7376uk[2], rectF.top);
        RectF rectF2 = this.s;
        float f2 = rectF.right;
        float[] fArr = this.f7376uk;
        float f3 = (float) 2;
        rectF2.left = f2 - (fArr[2] * f3);
        rectF2.right = f2;
        rectF2.top = rectF.top;
        rectF2.bottom = rectF.top + (fArr[3] * f3);
        path.arcTo(rectF2, 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f7376uk[5]);
        RectF rectF3 = this.u;
        float f4 = rectF.right;
        float[] fArr2 = this.f7376uk;
        rectF3.left = f4 - (fArr2[4] * f3);
        rectF3.right = f4;
        float f5 = rectF.bottom;
        rectF3.top = f5 - (fArr2[5] * f3);
        rectF3.bottom = f5;
        path.arcTo(rectF3, 0.0f, 90.0f);
        path.lineTo(rectF.left - this.f7376uk[6], rectF.bottom);
        RectF rectF4 = this.t;
        rectF4.left = rectF.left;
        float f6 = rectF.left;
        float[] fArr3 = this.f7376uk;
        rectF4.right = f6 + (fArr3[6] * f3);
        float f7 = rectF.bottom;
        rectF4.top = f7 - (fArr3[7] * f3);
        rectF4.bottom = f7;
        path.arcTo(rectF4, 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f7376uk[1]);
        RectF rectF5 = this.s;
        rectF5.left = rectF.left;
        float f8 = rectF.left;
        float[] fArr4 = this.f7376uk;
        rectF5.right = f8 + (fArr4[0] * f3);
        rectF5.top = rectF.top;
        rectF5.bottom = rectF.top + (fArr4[1] * f3);
        path.arcTo(rectF5, 180.0f, 90.0f);
    }

    public final GradientDrawable g(GradientDrawable gradientDrawable, int[] iArr) {
        if (gradientDrawable == null) {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setOrientation(this.k);
        gradientDrawable.setColors(iArr);
        return gradientDrawable;
    }

    public final void ggg(TypedArray typedArray) {
        this.H = (float) typedArray.getDimensionPixelSize(21, 0);
        this.I = (float) typedArray.getDimensionPixelSize(24, 0);
        this.J = (float) typedArray.getDimensionPixelSize(25, 0);
        this.K = (float) typedArray.getDimensionPixelSize(22, 0);
        this.L = (float) typedArray.getDimensionPixelSize(23, 0);
    }

    public void h(float f2) {
        this.H = f2;
        n();
    }

    public final GradientDrawable.Orientation i(TypedArray typedArray) {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        switch (typedArray.getInt(28, 0)) {
            case 0:
                return GradientDrawable.Orientation.TOP_BOTTOM;
            case 1:
                return GradientDrawable.Orientation.TR_BL;
            case 2:
                return GradientDrawable.Orientation.RIGHT_LEFT;
            case 3:
                return GradientDrawable.Orientation.BR_TL;
            case 4:
                return GradientDrawable.Orientation.BOTTOM_TOP;
            case 5:
                return GradientDrawable.Orientation.BL_TR;
            case 6:
                return GradientDrawable.Orientation.LEFT_RIGHT;
            case 7:
                return GradientDrawable.Orientation.TL_BR;
            default:
                return orientation;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m921if(TypedArray typedArray) {
        a(typedArray.getBoolean(2, false));
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j() {
        /*
            r4 = this;
            boolean r0 = r4.N
            if (r0 != 0) goto L_0x000c
            int r0 = r4.f314if
            r4.f315switch = r0
            int[] r0 = r4.vvv
            r4.xxx = r0
        L_0x000c:
            boolean r0 = r4.O
            if (r0 != 0) goto L_0x0014
            android.graphics.drawable.Drawable r0 = r4.a
            r4.b = r0
        L_0x0014:
            boolean r0 = r4.P
            if (r0 != 0) goto L_0x0020
            int r0 = r4.f314if
            r4.when = r0
            int[] r0 = r4.vvv
            r4.ddd = r0
        L_0x0020:
            boolean r0 = r4.Q
            if (r0 != 0) goto L_0x0028
            android.graphics.drawable.Drawable r0 = r4.a
            r4.c = r0
        L_0x0028:
            boolean r0 = r4.R
            if (r0 != 0) goto L_0x0034
            int r0 = r4.f314if
            r4.ppp = r0
            int[] r0 = r4.vvv
            r4.nn = r0
        L_0x0034:
            boolean r0 = r4.U
            if (r0 != 0) goto L_0x003c
            android.graphics.drawable.Drawable r0 = r4.a
            r4.d = r0
        L_0x003c:
            boolean r0 = r4.S
            if (r0 != 0) goto L_0x0048
            int r0 = r4.f314if
            r4.ggg = r0
            int[] r0 = r4.vvv
            r4.mmm = r0
        L_0x0048:
            boolean r0 = r4.V
            if (r0 != 0) goto L_0x0050
            android.graphics.drawable.Drawable r0 = r4.a
            r4.e = r0
        L_0x0050:
            int[] r0 = r4.vvv
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0061
            int r0 = r0.length
            if (r0 != 0) goto L_0x005b
            r0 = 1
            goto L_0x005c
        L_0x005b:
            r0 = 0
        L_0x005c:
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x0061
            r0 = 1
            goto L_0x0062
        L_0x0061:
            r0 = 0
        L_0x0062:
            if (r0 == 0) goto L_0x006f
            android.graphics.drawable.GradientDrawable r0 = r4.aaa
            int[] r3 = r4.vvv
            android.graphics.drawable.GradientDrawable r0 = r4.g(r0, r3)
            r4.aaa = r0
            goto L_0x0078
        L_0x006f:
            android.graphics.drawable.GradientDrawable r0 = r4.aaa
            if (r0 == 0) goto L_0x0078
            int r3 = r4.f314if
            r0.setColor(r3)
        L_0x0078:
            int[] r0 = r4.xxx
            if (r0 == 0) goto L_0x0087
            int r0 = r0.length
            if (r0 != 0) goto L_0x0081
            r0 = 1
            goto L_0x0082
        L_0x0081:
            r0 = 0
        L_0x0082:
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x0087
            r0 = 1
            goto L_0x0088
        L_0x0087:
            r0 = 0
        L_0x0088:
            if (r0 == 0) goto L_0x0095
            android.graphics.drawable.GradientDrawable r0 = r4.qqq
            int[] r3 = r4.xxx
            android.graphics.drawable.GradientDrawable r0 = r4.g(r0, r3)
            r4.qqq = r0
            goto L_0x009e
        L_0x0095:
            android.graphics.drawable.GradientDrawable r0 = r4.qqq
            if (r0 == 0) goto L_0x009e
            int r3 = r4.f315switch
            r0.setColor(r3)
        L_0x009e:
            int[] r0 = r4.ddd
            if (r0 == 0) goto L_0x00ad
            int r0 = r0.length
            if (r0 != 0) goto L_0x00a7
            r0 = 1
            goto L_0x00a8
        L_0x00a7:
            r0 = 0
        L_0x00a8:
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x00ad
            r0 = 1
            goto L_0x00ae
        L_0x00ad:
            r0 = 0
        L_0x00ae:
            if (r0 == 0) goto L_0x00bb
            android.graphics.drawable.GradientDrawable r0 = r4.eee
            int[] r3 = r4.ddd
            android.graphics.drawable.GradientDrawable r0 = r4.g(r0, r3)
            r4.eee = r0
            goto L_0x00c4
        L_0x00bb:
            android.graphics.drawable.GradientDrawable r0 = r4.eee
            if (r0 == 0) goto L_0x00c4
            int r3 = r4.when
            r0.setColor(r3)
        L_0x00c4:
            int[] r0 = r4.nn
            if (r0 == 0) goto L_0x00d3
            int r0 = r0.length
            if (r0 != 0) goto L_0x00cd
            r0 = 1
            goto L_0x00ce
        L_0x00cd:
            r0 = 0
        L_0x00ce:
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x00d3
            r0 = 1
            goto L_0x00d4
        L_0x00d3:
            r0 = 0
        L_0x00d4:
            if (r0 == 0) goto L_0x00e1
            android.graphics.drawable.GradientDrawable r0 = r4.rrr
            int[] r3 = r4.nn
            android.graphics.drawable.GradientDrawable r0 = r4.g(r0, r3)
            r4.rrr = r0
            goto L_0x00ea
        L_0x00e1:
            android.graphics.drawable.GradientDrawable r0 = r4.rrr
            if (r0 == 0) goto L_0x00ea
            int r3 = r4.ppp
            r0.setColor(r3)
        L_0x00ea:
            int[] r0 = r4.mmm
            if (r0 == 0) goto L_0x00f8
            int r0 = r0.length
            if (r0 != 0) goto L_0x00f3
            r0 = 1
            goto L_0x00f4
        L_0x00f3:
            r0 = 0
        L_0x00f4:
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x00f8
            r1 = 1
        L_0x00f8:
            if (r1 == 0) goto L_0x0105
            android.graphics.drawable.GradientDrawable r0 = r4.tt
            int[] r1 = r4.mmm
            android.graphics.drawable.GradientDrawable r0 = r4.g(r0, r1)
            r4.tt = r0
            goto L_0x010e
        L_0x0105:
            android.graphics.drawable.GradientDrawable r0 = r4.tt
            if (r0 == 0) goto L_0x010e
            int r1 = r4.ggg
            r0.setColor(r1)
        L_0x010e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.ui.view.helper.UIBaseHelper.j():void");
    }

    public final void k() {
        GradientDrawable gradientDrawable = this.aaa;
        if (gradientDrawable != null) {
            gradientDrawable.setGradientType(this.f);
        }
        GradientDrawable gradientDrawable2 = this.aaa;
        if (gradientDrawable2 != null) {
            gradientDrawable2.setGradientRadius(this.g);
        }
        GradientDrawable gradientDrawable3 = this.aaa;
        if (gradientDrawable3 != null) {
            gradientDrawable3.setGradientCenter(this.h, this.j);
        }
        GradientDrawable gradientDrawable4 = this.qqq;
        if (gradientDrawable4 != null) {
            gradientDrawable4.setGradientType(this.f);
        }
        GradientDrawable gradientDrawable5 = this.qqq;
        if (gradientDrawable5 != null) {
            gradientDrawable5.setGradientRadius(this.g);
        }
        GradientDrawable gradientDrawable6 = this.qqq;
        if (gradientDrawable6 != null) {
            gradientDrawable6.setGradientCenter(this.h, this.j);
        }
        GradientDrawable gradientDrawable7 = this.eee;
        if (gradientDrawable7 != null) {
            gradientDrawable7.setGradientType(this.f);
        }
        GradientDrawable gradientDrawable8 = this.eee;
        if (gradientDrawable8 != null) {
            gradientDrawable8.setGradientRadius(this.g);
        }
        GradientDrawable gradientDrawable9 = this.eee;
        if (gradientDrawable9 != null) {
            gradientDrawable9.setGradientCenter(this.h, this.j);
        }
        GradientDrawable gradientDrawable10 = this.rrr;
        if (gradientDrawable10 != null) {
            gradientDrawable10.setGradientType(this.f);
        }
        GradientDrawable gradientDrawable11 = this.rrr;
        if (gradientDrawable11 != null) {
            gradientDrawable11.setGradientRadius(this.g);
        }
        GradientDrawable gradientDrawable12 = this.rrr;
        if (gradientDrawable12 != null) {
            gradientDrawable12.setGradientCenter(this.h, this.j);
        }
        GradientDrawable gradientDrawable13 = this.tt;
        if (gradientDrawable13 != null) {
            gradientDrawable13.setGradientType(this.f);
        }
        GradientDrawable gradientDrawable14 = this.tt;
        if (gradientDrawable14 != null) {
            gradientDrawable14.setGradientRadius(this.g);
        }
        GradientDrawable gradientDrawable15 = this.tt;
        if (gradientDrawable15 != null) {
            gradientDrawable15.setGradientCenter(this.h, this.j);
        }
    }

    public final void l(float f2) {
        this.g = f2;
        k();
        d();
    }

    public final void m() {
        GradientDrawable gradientDrawable = this.aaa;
        if (gradientDrawable != null) {
            gradientDrawable.setCornerRadii(this.f7376uk);
        }
        GradientDrawable gradientDrawable2 = this.qqq;
        if (gradientDrawable2 != null) {
            gradientDrawable2.setCornerRadii(this.f7376uk);
        }
        GradientDrawable gradientDrawable3 = this.eee;
        if (gradientDrawable3 != null) {
            gradientDrawable3.setCornerRadii(this.f7376uk);
        }
        GradientDrawable gradientDrawable4 = this.rrr;
        if (gradientDrawable4 != null) {
            gradientDrawable4.setCornerRadii(this.f7376uk);
        }
        GradientDrawable gradientDrawable5 = this.tt;
        if (gradientDrawable5 != null) {
            gradientDrawable5.setCornerRadii(this.f7376uk);
        }
        d();
    }

    public final boolean mmm(int i2, int i3) {
        if (i2 >= 0 - this.f7369de) {
            int width = this.f7368ad.getWidth();
            int i4 = this.f7369de;
            if (i2 >= width + i4 || i3 < 0 - i4 || i3 >= this.f7368ad.getHeight() + this.f7369de) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final void n() {
        float f2 = this.H;
        if (f2 > 0.0f) {
            float[] fArr = this.f7376uk;
            fArr[0] = f2;
            fArr[1] = f2;
            fArr[2] = f2;
            fArr[3] = f2;
            fArr[4] = f2;
            fArr[5] = f2;
            fArr[6] = f2;
            fArr[7] = f2;
            m();
        } else if (f2 <= 0.0f) {
            float[] fArr2 = this.f7376uk;
            float f3 = this.I;
            fArr2[0] = f3;
            fArr2[1] = f3;
            float f4 = this.J;
            fArr2[2] = f4;
            fArr2[3] = f4;
            float f5 = this.L;
            fArr2[4] = f5;
            fArr2[5] = f5;
            float f6 = this.K;
            fArr2[6] = f6;
            fArr2[7] = f6;
            m();
        }
    }

    public final void nn(TypedArray typedArray) {
        this.l = typedArray.getDimensionPixelSize(32, 0);
        this.m = typedArray.getDimensionPixelSize(33, 0);
        this.n = typedArray.getColor(31, 865704345);
        this.p = (float) typedArray.getDimensionPixelSize(34, -1);
    }

    @NotNull
    public final T o() {
        return this.f7368ad;
    }

    public final void p() {
        this.aaa = new GradientDrawable();
        this.qqq = new GradientDrawable();
        this.eee = new GradientDrawable();
        this.rrr = new GradientDrawable();
        this.tt = new GradientDrawable();
        this.f7370fe = this.f7368ad.getBackground();
        this.f7377yj = new StateListDrawable();
        j();
        k();
        int[][] iArr = this.f7375th;
        iArr[0] = new int[]{-16842910};
        iArr[1] = new int[]{16842908};
        iArr[2] = new int[]{16842919};
        iArr[3] = new int[]{16842912};
        iArr[4] = new int[]{16842913};
        iArr[5] = new int[]{16842910};
        StateListDrawable stateListDrawable = this.f7377yj;
        if (stateListDrawable != null) {
            int[] iArr2 = iArr[0];
            Drawable drawable = this.c;
            if (drawable == null) {
                drawable = this.eee;
            }
            stateListDrawable.addState(iArr2, drawable);
        }
        StateListDrawable stateListDrawable2 = this.f7377yj;
        if (stateListDrawable2 != null) {
            int[] iArr3 = this.f7375th[1];
            Drawable drawable2 = this.b;
            if (drawable2 == null) {
                drawable2 = this.qqq;
            }
            stateListDrawable2.addState(iArr3, drawable2);
        }
        StateListDrawable stateListDrawable3 = this.f7377yj;
        if (stateListDrawable3 != null) {
            int[] iArr4 = this.f7375th[2];
            Drawable drawable3 = this.b;
            if (drawable3 == null) {
                drawable3 = this.qqq;
            }
            stateListDrawable3.addState(iArr4, drawable3);
        }
        StateListDrawable stateListDrawable4 = this.f7377yj;
        if (stateListDrawable4 != null) {
            int[] iArr5 = this.f7375th[3];
            Drawable drawable4 = this.d;
            if (drawable4 == null) {
                drawable4 = this.rrr;
            }
            stateListDrawable4.addState(iArr5, drawable4);
        }
        StateListDrawable stateListDrawable5 = this.f7377yj;
        if (stateListDrawable5 != null) {
            int[] iArr6 = this.f7375th[4];
            Drawable drawable5 = this.e;
            if (drawable5 == null) {
                drawable5 = this.tt;
            }
            stateListDrawable5.addState(iArr6, drawable5);
        }
        StateListDrawable stateListDrawable6 = this.f7377yj;
        if (stateListDrawable6 != null) {
            int[] iArr7 = this.f7375th[5];
            Drawable drawable6 = this.a;
            if (drawable6 == null) {
                drawable6 = this.aaa;
            }
            stateListDrawable6.addState(iArr7, drawable6);
        }
        if (!this.a0) {
            this.y = this.x;
        }
        if (!this.b0) {
            this.z = this.x;
        }
        if (!this.c0) {
            this.A = this.x;
        }
        if (!this.d0) {
            this.B = this.x;
        }
        if (!this.W) {
            this.D = this.C;
        }
        if (!this.X) {
            this.E = this.C;
        }
        if (!this.Y) {
            this.F = this.C;
        }
        if (!this.Z) {
            this.G = this.C;
        }
        e();
        n();
    }

    public void pf(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (attributeSet == null) {
            p();
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.UIView, i2, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr….UIView, defStyleAttr, 0)");
        xxx(obtainStyledAttributes);
        m921if(obtainStyledAttributes);
        ppp(obtainStyledAttributes);
        ggg(obtainStyledAttributes);
        when(obtainStyledAttributes);
        m922switch(obtainStyledAttributes);
        ddd(obtainStyledAttributes);
        nn(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        q();
        vvv();
        p();
    }

    public final void ppp(TypedArray typedArray) {
        this.e0 = typedArray.getBoolean(20, false);
    }

    public final void q() {
        boolean z2 = false;
        this.M = (this.f314if == 0 && this.vvv == null) ? false : true;
        this.N = (this.f315switch == 0 && this.xxx == null) ? false : true;
        this.P = (this.when == 0 && this.ddd == null) ? false : true;
        this.R = (this.ppp == 0 && this.nn == null) ? false : true;
        this.S = (this.ggg == 0 && this.mmm == null) ? false : true;
        this.T = this.a != null;
        this.O = this.b != null;
        this.Q = this.c != null;
        this.U = this.d != null;
        this.V = this.e != null;
        this.W = this.D != 0;
        this.X = this.E != 0;
        this.Y = this.F != 0;
        this.Z = this.G != 0;
        this.a0 = this.y != 0;
        this.b0 = this.z != 0;
        this.c0 = this.A != 0;
        if (this.B != 0) {
            z2 = true;
        }
        this.d0 = z2;
    }

    public void qqq(@IdRes int i2) {
        this.f7370fe = this.f7368ad.getBackground();
        if (!this.T) {
            this.a = qw.qw.ad(this.qw, i2);
        }
        j();
        d();
    }

    public final boolean r() {
        return this.p > 0.0f;
    }

    public void rg(@Nullable Canvas canvas) {
        if (this.e0) {
            this.f7368ad.getDrawingRect(this.f0);
            fe(new RectF(this.f0), this.g0);
            if (canvas != null) {
                canvas.clipPath(this.g0);
            }
        }
    }

    public void rrr() {
        if (!this.f7373pf) {
            return;
        }
        if (!this.f7368ad.isEnabled()) {
            this.f7368ad.setAlpha(0.4f);
        } else if (!this.f7368ad.isPressed() || !this.f7368ad.isClickable()) {
            this.f7368ad.setAlpha(1.0f);
        } else {
            this.f7368ad.setAlpha(0.6f);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m922switch(TypedArray typedArray) {
        Object[] yj2 = yj(typedArray, 4);
        Object obj = yj2[1];
        if (obj != null) {
            this.f314if = ((Integer) obj).intValue();
            this.vvv = (int[]) yj2[2];
            this.a = (Drawable) yj2[3];
            Object[] yj3 = yj(typedArray, 5);
            Object obj2 = yj3[1];
            if (obj2 != null) {
                this.f315switch = ((Integer) obj2).intValue();
                this.xxx = (int[]) yj3[2];
                this.b = (Drawable) yj3[3];
                Object[] yj4 = yj(typedArray, 7);
                Object obj3 = yj4[1];
                if (obj3 != null) {
                    this.when = ((Integer) obj3).intValue();
                    this.ddd = (int[]) yj4[2];
                    this.c = (Drawable) yj4[3];
                    Object[] yj5 = yj(typedArray, 3);
                    Object obj4 = yj5[1];
                    if (obj4 != null) {
                        this.ppp = ((Integer) obj4).intValue();
                        this.nn = (int[]) yj5[2];
                        this.d = (Drawable) yj5[3];
                        Object[] yj6 = yj(typedArray, 6);
                        Object obj5 = yj6[1];
                        if (obj5 != null) {
                            this.ggg = ((Integer) obj5).intValue();
                            this.mmm = (int[]) yj6[2];
                            this.e = (Drawable) yj6[3];
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void th(@NotNull Canvas canvas, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (!qw.qw.fe() && r() && this.f7368ad.getVisibility() == 0) {
            RectF rectF = this.q;
            rectF.left = (float) this.f7368ad.getLeft();
            rectF.right = (float) this.f7368ad.getRight();
            rectF.top = (float) this.f7368ad.getTop();
            rectF.bottom = (float) this.f7368ad.getBottom();
            paint.setShadowLayer(this.p, (float) this.l, (float) this.m, this.n);
            paint.setColor(this.n);
            fe(rectF, this.r);
            canvas.drawPath(this.r, paint);
        }
    }

    public final void tt(int i2, int i3) {
        this.f7371i = i2;
        this.f7372o = i3;
        this.f7368ad.postInvalidate();
    }

    @NotNull
    public final Context uk() {
        return this.qw;
    }

    public final void vvv() {
        Drawable background = this.f7368ad.getBackground();
        if (background instanceof ColorDrawable) {
            if (!this.M) {
                this.f314if = ((ColorDrawable) background).getColor();
            }
        } else if (!this.T) {
            if (background == null) {
                background = this.a;
            }
            this.a = background;
        }
    }

    public final void when(TypedArray typedArray) {
        this.v = (float) typedArray.getDimensionPixelSize(14, 0);
        this.w = (float) typedArray.getDimensionPixelSize(13, 0);
        this.x = typedArray.getDimensionPixelSize(16, 0);
        this.y = typedArray.getDimensionPixelSize(17, 0);
        this.z = typedArray.getDimensionPixelSize(19, 0);
        this.A = typedArray.getDimensionPixelSize(15, 0);
        this.B = typedArray.getDimensionPixelSize(18, 0);
        this.C = ad.qw(typedArray, 9, 0);
        this.D = ad.qw(typedArray, 10, 0);
        this.E = ad.qw(typedArray, 12, 0);
        this.F = ad.qw(typedArray, 8, 0);
        this.G = ad.qw(typedArray, 11, 0);
    }

    public final void xxx(TypedArray typedArray) {
        this.f7371i = typedArray.getInteger(0, 0);
        this.f7372o = typedArray.getInteger(1, 0);
    }

    public final Object[] yj(TypedArray typedArray, int i2) {
        Drawable drawable;
        int i3;
        int i4;
        int resourceId = typedArray.getResourceId(i2, 0);
        int[] iArr = null;
        if (resourceId == 0) {
            i3 = ad.qw(typedArray, i2, 0);
        } else {
            String resourceTypeName = this.qw.getResources().getResourceTypeName(resourceId);
            Intrinsics.checkNotNullExpressionValue(resourceTypeName, "context.resources.getResourceTypeName(resId)");
            if (Intrinsics.areEqual((Object) "array", (Object) resourceTypeName)) {
                String[] stringArray = this.qw.getResources().getStringArray(resourceId);
                Intrinsics.checkNotNullExpressionValue(stringArray, "context.resources.getStringArray(resId)");
                int[] intArray = this.qw.getResources().getIntArray(resourceId);
                Intrinsics.checkNotNullExpressionValue(intArray, "context.resources.getIntArray(resId)");
                int min = Math.min(intArray.length, stringArray.length);
                int[] iArr2 = new int[min];
                for (int i5 = 0; i5 < min; i5++) {
                    String str = stringArray[i5];
                    int i6 = intArray[i5];
                    if (!TextUtils.isEmpty(str)) {
                        i6 = Color.parseColor(str);
                    }
                    iArr2[i5] = i6;
                }
                drawable = null;
                iArr = iArr2;
                i3 = 0;
                i4 = 2;
            } else if (Intrinsics.areEqual((Object) ResUtils.f, (Object) resourceTypeName)) {
                i3 = ad.qw(typedArray, i2, 0);
            } else if (Intrinsics.areEqual((Object) "mipmap", (Object) resourceTypeName) || Intrinsics.areEqual((Object) ResUtils.e, (Object) resourceTypeName)) {
                drawable = ad.ad(typedArray, i2);
                i3 = 0;
                i4 = 3;
            } else {
                drawable = null;
                i3 = 0;
                i4 = 1;
            }
            return new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), iArr, drawable};
        }
        drawable = null;
        i4 = 1;
        return new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), iArr, drawable};
    }
}
