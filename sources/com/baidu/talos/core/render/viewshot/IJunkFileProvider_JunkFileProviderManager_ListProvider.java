package com.baidu.talos.core.render.viewshot;

import com.baidu.pyramid.annotation.Provider;
import com.baidu.searchbox.talos.modules.chatroom.AudioJunkFileProvider;
import java.util.ArrayList;

public class IJunkFileProvider_JunkFileProviderManager_ListProvider implements Provider {
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AudioJunkFileProvider());
        arrayList.add(new ViewShotJunkFileProvider());
        return arrayList;
    }
}
