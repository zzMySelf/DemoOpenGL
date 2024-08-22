package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class zzw implements Continuation<Void, List<TResult>> {
    public final /* synthetic */ Collection zzae;

    public zzw(Collection collection) {
        this.zzae = collection;
    }

    public final /* synthetic */ Object then(@NonNull Task task) throws Exception {
        if (this.zzae.size() == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Task result : this.zzae) {
            arrayList.add(result.getResult());
        }
        return arrayList;
    }
}
