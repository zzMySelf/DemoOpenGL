package com.tera.scan.file.selector.ui.viewmodel;

import fe.mmm.qw.h.de.qw;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.file.selector.ui.viewmodel.LocalImageSelectViewModel$onReqGalleryOkBusiness$1$selectedList$1", f = "LocalImageSelectViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LocalImageSelectViewModel$onReqGalleryOkBusiness$1$selectedList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<String>>, Object> {
    public final /* synthetic */ String $imgCompressDir;
    public final /* synthetic */ ArrayList<String> $list;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocalImageSelectViewModel$onReqGalleryOkBusiness$1$selectedList$1(ArrayList<String> arrayList, String str, Continuation<? super LocalImageSelectViewModel$onReqGalleryOkBusiness$1$selectedList$1> continuation) {
        super(2, continuation);
        this.$list = arrayList;
        this.$imgCompressDir = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LocalImageSelectViewModel$onReqGalleryOkBusiness$1$selectedList$1(this.$list, this.$imgCompressDir, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ArrayList<String>> continuation) {
        return ((LocalImageSelectViewModel$onReqGalleryOkBusiness$1$selectedList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList<String> arrayList = this.$list;
            String str = this.$imgCompressDir;
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            int i2 = 0;
            for (T next : arrayList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                arrayList2.add(FilesKt__UtilsKt.copyTo$default(new File((String) next), new File(new qw().th(str, i2)), false, 0, 6, (Object) null).getPath());
                i2 = i3;
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            return arrayList3;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
