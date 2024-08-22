package com.baidu.swan.apps.component.container.interfaces;

import com.baidu.swan.apps.component.base.SwanAppBaseComponent;
import com.baidu.swan.apps.component.diff.DiffResult;

public interface ISwanAppComponentsContainer {
    boolean insertComponent(SwanAppBaseComponent swanAppBaseComponent);

    boolean removeComponent(SwanAppBaseComponent swanAppBaseComponent);

    boolean updateComponent(SwanAppBaseComponent swanAppBaseComponent, DiffResult diffResult);
}
