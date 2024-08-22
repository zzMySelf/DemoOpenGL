package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;

public interface IUserDebugger {
    String getRootPath();

    void putDebugExtra(Bundle bundle);

    void setDebugParams(Bundle bundle);
}
