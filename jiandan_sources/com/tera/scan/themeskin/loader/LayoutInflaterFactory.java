package com.tera.scan.themeskin.loader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import fe.mmm.qw.d.de.rg;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J,\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/tera/scan/themeskin/loader/LayoutInflaterFactory;", "Landroid/view/LayoutInflater$Factory2;", "()V", "mIntercepts", "Ljava/util/ArrayList;", "Lcom/tera/scan/themeskin/loader/LayoutInflaterIntercept;", "Lkotlin/collections/ArrayList;", "addIntercept", "", "intercept", "onCreateView", "Landroid/view/View;", "parent", "name", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "lib-themeskin_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LayoutInflaterFactory implements LayoutInflater.Factory2 {
    @NotNull
    public ArrayList<LayoutInflaterIntercept> mIntercepts = new ArrayList<>();

    public final void addIntercept(@NotNull LayoutInflaterIntercept layoutInflaterIntercept) {
        Intrinsics.checkNotNullParameter(layoutInflaterIntercept, "intercept");
        this.mIntercepts.add(layoutInflaterIntercept);
    }

    @Nullable
    public View onCreateView(@Nullable View view, @NotNull String str, @NotNull Context context, @NotNull AttributeSet attributeSet) {
        View view2;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        if (context instanceof AppCompatActivity) {
            AppCompatDelegate delegate = ((AppCompatActivity) context).getDelegate();
            Intrinsics.checkNotNullExpressionValue(delegate, "context.delegate");
            view2 = delegate.createView(view, str, context, attributeSet);
        } else {
            view2 = null;
        }
        if (view2 == null) {
            view2 = rg.ad(context, str, attributeSet);
        }
        Iterator<LayoutInflaterIntercept> it = this.mIntercepts.iterator();
        while (it.hasNext()) {
            it.next().qw(view2, context, attributeSet);
        }
        return view2;
    }

    @Nullable
    public View onCreateView(@NotNull String str, @NotNull Context context, @NotNull AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        return null;
    }
}
