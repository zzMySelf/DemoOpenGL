package com.mars.kotlin.service;

import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/mars/kotlin/service/IHandlable;", "T", "Lkotlin/Any;", "Landroid/content/Intent;", "intent", "", "onHandle", "(Landroid/content/Intent;)V", "service_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public interface IHandlable<T> {
    void onHandle(@NotNull Intent intent);
}
