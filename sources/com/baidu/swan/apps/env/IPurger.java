package com.baidu.swan.apps.env;

import java.util.List;

public interface IPurger {
    void clearAllVersionSubPackageInfo(String str);

    void clearData(List<String> list);

    void deleteDbItem(String str);

    void deletePkgFile(String str);

    void resetAccredit(List<String> list);
}
