package com.pichillilorenzo.flutter_inappwebview.types;

import androidx.annotation.Nullable;
import java.util.List;

public class WebMessage {
    @Nullable
    public String data;
    @Nullable
    public List<WebMessagePort> ports;

    public WebMessage(@Nullable String str, @Nullable List<WebMessagePort> list) {
        this.data = str;
        this.ports = list;
    }

    public void dispose() {
        List<WebMessagePort> list = this.ports;
        if (list != null) {
            list.clear();
        }
    }
}
