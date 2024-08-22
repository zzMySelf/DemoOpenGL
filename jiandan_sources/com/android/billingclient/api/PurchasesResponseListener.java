package com.android.billingclient.api;

import androidx.annotation.NonNull;
import fe.de.qw.qw.Cif;
import fe.de.qw.qw.yj;
import java.util.List;

public interface PurchasesResponseListener {
    void qw(@NonNull yj yjVar, @NonNull List<Cif> list);
}
