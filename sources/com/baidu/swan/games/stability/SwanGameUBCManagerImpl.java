package com.baidu.swan.games.stability;

import com.baidu.swan.apps.adaptation.game.interfaces.ISwanGameUBCManager;

public class SwanGameUBCManagerImpl implements ISwanGameUBCManager {
    public void doPerformanceUBC(String eventId) {
        SwanGameUBCUtils.doPerformanceUBC(eventId);
    }
}
