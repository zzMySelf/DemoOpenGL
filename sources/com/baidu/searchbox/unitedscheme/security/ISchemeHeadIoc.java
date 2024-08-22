package com.baidu.searchbox.unitedscheme.security;

import java.util.ArrayList;
import java.util.List;

public interface ISchemeHeadIoc {
    String getSchemeHead();

    List<String> getSchemeHeadListOutside() {
        List<String> schemeHeadList = new ArrayList<>();
        schemeHeadList.add("baiduboxapp");
        return schemeHeadList;
    }
}
