package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;

public final class zad implements View.OnClickListener {
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ Intent zasa;

    public zad(Context context, Intent intent) {
        this.val$context = context;
        this.zasa = intent;
    }

    public final void onClick(View view) {
        try {
            this.val$context.startActivity(this.zasa);
        } catch (ActivityNotFoundException unused) {
        }
    }
}
