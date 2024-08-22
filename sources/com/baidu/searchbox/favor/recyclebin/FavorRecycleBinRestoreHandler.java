package com.baidu.searchbox.favor.recyclebin;

import com.baidu.searchbox.bdprecyclebin.face.IRecycleBinRestoreHandler;
import com.baidu.searchbox.bdprecyclebin.face.model.RecycleBinModel;
import com.baidu.searchbox.favor.IFavorList;
import com.baidu.searchbox.favor.callback.FavorDataCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/favor/recyclebin/FavorRecycleBinRestoreHandler;", "Lcom/baidu/searchbox/bdprecyclebin/face/IRecycleBinRestoreHandler;", "()V", "mFavorListManager", "Lcom/baidu/searchbox/favor/IFavorList;", "getMFavorListManager", "()Lcom/baidu/searchbox/favor/IFavorList;", "mFavorListManager$delegate", "Lkotlin/Lazy;", "getBusinessType", "", "restoreRecords", "", "modelsWillRecover", "", "Lcom/baidu/searchbox/bdprecyclebin/face/model/RecycleBinModel;", "callback", "Lcom/baidu/searchbox/bdprecyclebin/face/IRecycleBinRestoreHandler$IRecordsRestoreCallback;", "RecycleBinFavorListRecoverListener", "lib-favor_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FavorRecycleBinRestoreHandler.kt */
public final class FavorRecycleBinRestoreHandler implements IRecycleBinRestoreHandler {
    private final Lazy mFavorListManager$delegate = LazyKt.lazy(FavorRecycleBinRestoreHandler$mFavorListManager$2.INSTANCE);

    private final IFavorList getMFavorListManager() {
        return (IFavorList) this.mFavorListManager$delegate.getValue();
    }

    public String getBusinessType() {
        return "favorite";
    }

    public void restoreRecords(List<RecycleBinModel> modelsWillRecover, IRecycleBinRestoreHandler.IRecordsRestoreCallback callback) {
        Intrinsics.checkNotNullParameter(modelsWillRecover, "modelsWillRecover");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Collection destination$iv$iv = new ArrayList();
        for (RecycleBinModel it : modelsWillRecover) {
            Object it$iv$iv = it.getUniqueId();
            if (it$iv$iv != null) {
                destination$iv$iv.add(it$iv$iv);
            }
        }
        List favorUKeysForRecover = (List) destination$iv$iv;
        IFavorList mFavorListManager = getMFavorListManager();
        if (mFavorListManager != null) {
            mFavorListManager.operateRecycleList(0, favorUKeysForRecover, new RecycleBinFavorListRecoverListener(modelsWillRecover, callback));
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/favor/recyclebin/FavorRecycleBinRestoreHandler$RecycleBinFavorListRecoverListener;", "Lcom/baidu/searchbox/favor/callback/FavorDataCallback;", "", "mModelsToRecover", "", "Lcom/baidu/searchbox/bdprecyclebin/face/model/RecycleBinModel;", "mCallback", "Lcom/baidu/searchbox/bdprecyclebin/face/IRecycleBinRestoreHandler$IRecordsRestoreCallback;", "(Ljava/util/List;Lcom/baidu/searchbox/bdprecyclebin/face/IRecycleBinRestoreHandler$IRecordsRestoreCallback;)V", "onResult", "", "data", "(Ljava/lang/Boolean;)V", "onUIBack", "lib-favor_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FavorRecycleBinRestoreHandler.kt */
    private static final class RecycleBinFavorListRecoverListener extends FavorDataCallback<Boolean> {
        private final IRecycleBinRestoreHandler.IRecordsRestoreCallback mCallback;
        private final List<RecycleBinModel> mModelsToRecover;

        public RecycleBinFavorListRecoverListener(List<RecycleBinModel> mModelsToRecover2, IRecycleBinRestoreHandler.IRecordsRestoreCallback mCallback2) {
            Intrinsics.checkNotNullParameter(mModelsToRecover2, "mModelsToRecover");
            Intrinsics.checkNotNullParameter(mCallback2, "mCallback");
            this.mModelsToRecover = mModelsToRecover2;
            this.mCallback = mCallback2;
        }

        public void onResult(Boolean data) {
            Iterable<RecycleBinModel> $this$map$iv = this.mModelsToRecover;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (RecycleBinModel modelToRecover : $this$map$iv) {
                destination$iv$iv.add(new IRecycleBinRestoreHandler.RecycleBinRecoverResult(modelToRecover, data != null ? data.booleanValue() : false));
            }
            this.mCallback.completion((List) destination$iv$iv);
        }

        public boolean onUIBack() {
            return true;
        }
    }
}
