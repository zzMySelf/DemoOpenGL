package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class zzx implements Continuation<Void, Task<List<Task<?>>>> {
    public final /* synthetic */ Collection zzae;

    public zzx(Collection collection) {
        this.zzae = collection;
    }

    public final /* synthetic */ Object then(@NonNull Task task) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zzae);
        return Tasks.forResult(arrayList);
    }
}
