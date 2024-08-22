package com.tera.scan.main.importfile.viewmodel;

import com.tera.scan.filetype.FileType;
import fe.mmm.qw.j.mmm.ad;
import fe.mmm.qw.xxx.uk.when.qw;
import fe.mmm.qw.xxx.when.fe;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/tera/scan/main/importfile/data/ImportFile;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.main.importfile.viewmodel.ImportDocFileViewModel$getLocalDocFileList$2", f = "ImportDocFileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImportDocFileViewModel$getLocalDocFileList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends qw>>, Object> {
    public int label;
    public final /* synthetic */ ImportDocFileViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImportDocFileViewModel$getLocalDocFileList$2(ImportDocFileViewModel importDocFileViewModel, Continuation<? super ImportDocFileViewModel$getLocalDocFileList$2> continuation) {
        super(2, continuation);
        this.this$0 = importDocFileViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ImportDocFileViewModel$getLocalDocFileList$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<qw>> continuation) {
        return ((ImportDocFileViewModel$getLocalDocFileList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        fe.mmm.qw.xxx.uk.ppp.qw qwVar;
        File[] fileArr;
        File[] fileArr2;
        qw qwVar2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ad qw = ad.qw(this.this$0.qw);
            Intrinsics.checkNotNullExpressionValue(qw, "createDevicesStorageManager(application)");
            if (Intrinsics.areEqual((Object) FileType.PDF.name(), (Object) this.this$0.f287if)) {
                qwVar = new fe.mmm.qw.xxx.uk.ppp.ad();
            } else {
                qwVar = new fe.mmm.qw.xxx.uk.ppp.qw();
            }
            if (!qw.rg() || !qw.yj()) {
                fileArr = null;
            } else {
                File ad2 = qw.ad();
                Intrinsics.checkNotNullExpressionValue(ad2, "deviceStorageManager.defaultStorageFile");
                fileArr = ad2.listFiles(qwVar);
            }
            if (!qw.th() || !qw.uk()) {
                fileArr2 = null;
            } else {
                File fe2 = qw.fe();
                Intrinsics.checkNotNullExpressionValue(fe2, "deviceStorageManager.secondaryStorageFile");
                fileArr2 = fe2.listFiles(qwVar);
            }
            if (fileArr == null && fileArr2 == null) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            if (fileArr != null && fileArr2 != null) {
                File[] fileArr3 = new File[(fileArr.length + fileArr2.length)];
                System.arraycopy(fileArr, 0, fileArr3, 0, fileArr.length);
                System.arraycopy(fileArr2, 0, fileArr3, fileArr.length, fileArr2.length);
                fileArr = fileArr3;
            } else if (fileArr == null) {
                fileArr = fileArr2;
            }
            ArrayList<File> arrayList = new ArrayList<>();
            this.this$0.th(fileArr, arrayList, qwVar);
            Collections.sort(arrayList, new fe());
            ArrayList arrayList2 = new ArrayList();
            for (File file : arrayList) {
                if (file == null) {
                    qwVar2 = null;
                } else {
                    qwVar2 = new qw(file);
                }
                if (qwVar2 != null) {
                    arrayList2.add(qwVar2);
                }
            }
            return arrayList2;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
