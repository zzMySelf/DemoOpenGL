package com.tera.scan.file.selector.ui.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.baidu.aiscan.R;
import com.google.common.base.Ascii;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.SequenceKt;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import com.tera.scan.file.selector.ui.LocalImageSelectActivity;
import fe.mmm.qw.th.qw.fe.ad;
import fe.mmm.qw.th.qw.th.i;
import i.qw.Cif;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u000b\u001a\u00020\tH\u0002J6\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, d2 = {"Lcom/tera/scan/file/selector/ui/viewmodel/LocalImageSelectViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "handleJump", "", "activity", "Landroid/app/Activity;", "list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "router", "onReqGalleryOkBusiness", "Lcom/tera/scan/file/selector/ui/LocalImageSelectActivity;", "maxSize", "", "ubcSource", "reportDoubleListAlbum", "context", "Landroid/content/Context;", "business-file-selector_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("LocalImageSelectActivity")
public final class LocalImageSelectViewModel extends ViewModel {

    public static final class qw implements Observer<ArrayList<String>> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ i f6915ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ LocalImageSelectActivity f6916th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ String f6917uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ LocalImageSelectViewModel f6918yj;

        public qw(i iVar, LocalImageSelectActivity localImageSelectActivity, LocalImageSelectViewModel localImageSelectViewModel, String str) {
            this.f6915ad = iVar;
            this.f6916th = localImageSelectActivity;
            this.f6918yj = localImageSelectViewModel;
            this.f6917uk = str;
        }

        public void onComplete() {
            LoggerKt.d$default("onComplete ", (Object) null, 1, (Object) null);
        }

        public void onError(@NotNull Throwable th2) {
            Intrinsics.checkNotNullParameter(th2, "e");
            LoggerKt.d$default("onError " + th2, (Object) null, 1, (Object) null);
            this.f6915ad.fe();
            this.f6916th.finish();
        }

        public void onSubscribe(@NotNull Disposable disposable) {
            Intrinsics.checkNotNullParameter(disposable, "d");
            LoggerKt.d$default("onSubscribe ", (Object) null, 1, (Object) null);
        }

        /* renamed from: qw */
        public void onNext(@NotNull ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "destPathList");
            boolean z = true;
            LoggerKt.d$default("destPathList " + arrayList + Ascii.CASE_MASK, (Object) null, 1, (Object) null);
            this.f6915ad.fe();
            if (this.f6916th.jumpRouter.length() <= 0) {
                z = false;
            }
            if (z) {
                LocalImageSelectViewModel localImageSelectViewModel = this.f6918yj;
                LocalImageSelectActivity localImageSelectActivity = this.f6916th;
                localImageSelectViewModel.qw(localImageSelectActivity, arrayList, localImageSelectActivity.jumpRouter);
                return;
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra("extra_result_files", arrayList);
            intent.putExtra("extra_ubc_source", this.f6917uk);
            this.f6916th.setResult(-1, intent);
            this.f6916th.finish();
        }
    }

    public final void onReqGalleryOkBusiness(@NotNull LocalImageSelectActivity localImageSelectActivity, int i2, @NotNull ArrayList<String> arrayList, @NotNull String str) {
        LocalImageSelectActivity localImageSelectActivity2 = localImageSelectActivity;
        int i3 = i2;
        ArrayList<String> arrayList2 = arrayList;
        String str2 = str;
        Intrinsics.checkNotNullParameter(localImageSelectActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(arrayList2, "list");
        Intrinsics.checkNotNullParameter(str2, "ubcSource");
        String yj2 = new fe.mmm.qw.h.de.qw().yj(localImageSelectActivity);
        if (yj2 != null) {
            i iVar = new i(localImageSelectActivity);
            iVar.rg(R.string.loading_text);
            if (i3 <= 0) {
                Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new LocalImageSelectViewModel$onReqGalleryOkBusiness$1(localImageSelectActivity, this, str, iVar, arrayList, yj2, (Continuation<? super LocalImageSelectViewModel$onReqGalleryOkBusiness$1>) null), 3, (Object) null);
                return;
            }
            fe.mmm.qw.h.fe.qw.rg(arrayList2, SequenceKt.toArrayList(SequencesKt___SequencesKt.mapIndexed(CollectionsKt___CollectionsKt.asSequence(arrayList), new LocalImageSelectViewModel$onReqGalleryOkBusiness$outPutPathList$1(yj2))), i2, i2, new qw(iVar, localImageSelectActivity, this, str2));
        }
    }

    public final void qw(Activity activity, ArrayList<String> arrayList, String str) {
        Object obj;
        try {
            ad.fe(ad.qw, str, (fe.mmm.qw.th.qw.fe.qw) null, (Integer) null, new LocalImageSelectViewModel$handleJump$1$1(arrayList), 6, (Object) null);
            activity.finish();
            obj = ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            obj = ExpectKt.failure(th2);
        }
        if (obj instanceof Either.Left) {
            Throwable th3 = (Throwable) ((Either.Left) obj).getValue();
            LoggerKt.d$default("router跳转失败，" + str, (Object) null, 1, (Object) null);
            activity.finish();
            new Either.Left(Unit.INSTANCE);
        } else if (!(obj instanceof Either.Right)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void reportDoubleListAlbum(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new LocalImageSelectViewModel$reportDoubleListAlbum$1(context, (Continuation<? super LocalImageSelectViewModel$reportDoubleListAlbum$1>) null), 3, (Object) null);
    }
}
