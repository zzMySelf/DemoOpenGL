package com.baidu.searchbox.feed.payment.column.viewmodel;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J'\u0010\u0007\u001a\u0002H\b\"\n\b\u0000\u0010\b*\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/feed/payment/column/viewmodel/SpColumnViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getApplication", "()Landroid/app/Application;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnViewModelHelper.kt */
public final class SpColumnViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static SpColumnViewModelFactory mInstance;
    private final Application application;

    @JvmStatic
    public static final SpColumnViewModelFactory getInstance(Application application2) {
        return Companion.getInstance(application2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpColumnViewModelFactory(Application application2) {
        super(application2);
        Intrinsics.checkNotNullParameter(application2, "application");
        this.application = application2;
    }

    public final Application getApplication() {
        return this.application;
    }

    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (SpColumnDetailViewModel.class.isAssignableFrom(modelClass)) {
            return (ViewModel) new SpColumnDetailViewModel(this.application);
        }
        if (SpColumnListViewModel.class.isAssignableFrom(modelClass)) {
            return (ViewModel) new SpColumnListViewModel(this.application);
        }
        return super.create(modelClass);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/feed/payment/column/viewmodel/SpColumnViewModelFactory$Companion;", "", "()V", "mInstance", "Lcom/baidu/searchbox/feed/payment/column/viewmodel/SpColumnViewModelFactory;", "getInstance", "application", "Landroid/app/Application;", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SpColumnViewModelHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SpColumnViewModelFactory getInstance(Application application) {
            Intrinsics.checkNotNullParameter(application, "application");
            if (SpColumnViewModelFactory.mInstance == null) {
                SpColumnViewModelFactory.mInstance = new SpColumnViewModelFactory(application);
            }
            SpColumnViewModelFactory access$getMInstance$cp = SpColumnViewModelFactory.mInstance;
            Intrinsics.checkNotNull(access$getMInstance$cp);
            return access$getMInstance$cp;
        }
    }
}
