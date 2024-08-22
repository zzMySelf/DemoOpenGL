package com.baidu.talos.devtools.runtime;

import android.content.DialogInterface;
import com.baidu.talos.devtools.runtime.RuntimeListAdapter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RuntimeListAdapter$ItemViewHolder$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ String f$0;

    public /* synthetic */ RuntimeListAdapter$ItemViewHolder$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        RuntimeListAdapter.ItemViewHolder.lambda$showDestroyDialog$0(this.f$0, dialogInterface, i2);
    }
}
