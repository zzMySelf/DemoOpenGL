package com.baidu.searchbox.permission;

public class PlayerUserPermissionManager_Factory {
    private static volatile PlayerUserPermissionManager instance;

    private PlayerUserPermissionManager_Factory() {
    }

    public static synchronized PlayerUserPermissionManager get() {
        PlayerUserPermissionManager playerUserPermissionManager;
        synchronized (PlayerUserPermissionManager_Factory.class) {
            if (instance == null) {
                instance = new PlayerUserPermissionManager();
            }
            playerUserPermissionManager = instance;
        }
        return playerUserPermissionManager;
    }
}
