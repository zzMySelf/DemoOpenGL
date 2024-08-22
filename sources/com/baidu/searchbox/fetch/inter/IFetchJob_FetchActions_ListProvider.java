package com.baidu.searchbox.fetch.inter;

import com.baidu.pyramid.annotation.Provider;
import com.baidu.searchbox.fetch.file.FetchFileJob;
import com.baidu.searchbox.fetch.log.FetchLogJob;
import java.util.ArrayList;

public class IFetchJob_FetchActions_ListProvider implements Provider {
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FetchFileJob());
        arrayList.add(new FetchLogJob());
        return arrayList;
    }
}
