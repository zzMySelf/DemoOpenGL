package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fe.de.qw.qw.Cif;
import fe.de.qw.qw.yj;
import java.util.List;

public interface PurchasesUpdatedListener {
    void fe(@NonNull yj yjVar, @Nullable List<Cif> list);
}
