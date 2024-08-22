package com.baidu.searchbox.padhome.ioc;

import android.content.Context;
import com.baidu.searchbox.padhome.IPadHomeEventListener;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/padhome/ioc/IPadHomeApp;", "", "getListeners", "", "Lcom/baidu/searchbox/padhome/IPadHomeEventListener;", "context", "Landroid/content/Context;", "pad-home-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IPadHomeApp.kt */
public interface IPadHomeApp {
    List<IPadHomeEventListener> getListeners(Context context);
}
