package com.mars.kotlin.database.extension;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.MutableLiveData;
import androidx.loader.content.CursorLoader;
import com.dlife.ctaccountapi.v;
import com.mars.kotlin.database.Query;
import com.mars.kotlin.database.QueryParams;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BE\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\n\u0012\u0019\b\u0001\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\b\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005R'\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\b\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR!\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/mars/kotlin/database/extension/FetchLoader;", "T", "Landroidx/loader/content/CursorLoader;", "Landroid/database/Cursor;", "onLoadInBackground", "()Landroid/database/Cursor;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "factory", "Lkotlin/Function1;", "Landroidx/lifecycle/MutableLiveData;", "liveData", "Landroidx/lifecycle/MutableLiveData;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "Landroid/content/Context;", "context", "Lcom/mars/kotlin/database/QueryParams;", "params", "<init>", "(Landroid/content/Context;Lcom/mars/kotlin/database/Query;Landroidx/lifecycle/MutableLiveData;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@Tag("FetchLoader")
public final class FetchLoader<T> extends CursorLoader {
    public final Function1<Cursor, T> factory;
    @NotNull
    public final MutableLiveData<T> liveData;

    public /* synthetic */ FetchLoader(Context context, Query query, MutableLiveData mutableLiveData, @WorkerThread Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, query, mutableLiveData, function1);
    }

    @NotNull
    public final MutableLiveData<T> getLiveData() {
        return this.liveData;
    }

    public FetchLoader(Context context, Query query, MutableLiveData<T> mutableLiveData, Function1<? super Cursor, ? extends T> function1) {
        super(context, QueryParams.m682buildUriimpl(((QueryParams) LoggerKt.d(Intrinsics.checkNotNullParameter(query, v.d), "params")).m692unboximpl()), QueryParams.m687projectionimpl(query), QueryParams.m690whereimpl(query), QueryParams.m691whereArgsimpl(query), QueryParams.m688sortimpl(query));
        this.liveData = mutableLiveData;
        this.factory = function1;
    }

    @Nullable
    public Cursor onLoadInBackground() {
        Either either;
        T invoke;
        try {
            LoggerKt.d$default("before super.onLoadInBackground", (Object) null, 1, (Object) null);
            Object onLoadInBackground = super.onLoadInBackground();
            Cursor cursor = (Cursor) onLoadInBackground;
            StringBuilder sb = new StringBuilder();
            sb.append("id:");
            sb.append(getId());
            sb.append(" uri:");
            sb.append(getUri());
            sb.append(" projection:");
            sb.append(getProjection());
            sb.append(" selection:");
            sb.append(getSelection());
            sb.append(" args:");
            sb.append(getSelectionArgs());
            sb.append(" order:");
            sb.append(getSortOrder());
            sb.append(" end super.onLoadInBackground ");
            sb.append(cursor != null ? Integer.valueOf(cursor.getCount()) : null);
            LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
            either = ExpectKt.success((Cursor) onLoadInBackground);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
        Cursor cursor2 = (Cursor) ExpectKt.successOrNull(either);
        if (cursor2 != null) {
            MutableLiveData<T> mutableLiveData = this.liveData;
            synchronized (this.factory) {
                invoke = this.factory.invoke(cursor2);
            }
            mutableLiveData.postValue(invoke);
            return cursor2;
        }
        this.liveData.postValue(null);
        return null;
    }
}
