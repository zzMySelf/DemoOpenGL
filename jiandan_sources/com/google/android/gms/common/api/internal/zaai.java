package com.google.android.gms.common.api.internal;

public final class zaai extends zabd {
    public final /* synthetic */ zaaf zafy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaai(zaaf zaaf, zabb zabb) {
        super(zabb);
        this.zafy = zaaf;
    }

    public final void zaal() {
        this.zafy.onConnectionSuspended(1);
    }
}
