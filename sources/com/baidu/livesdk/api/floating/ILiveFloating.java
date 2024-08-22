package com.baidu.livesdk.api.floating;

import android.view.View;
import com.baidu.livesdk.api.player.Player;

public interface ILiveFloating {
    void dismissFloating(boolean z);

    boolean hasFloatingPermission();

    boolean isFloatShowing();

    void showFloating(Player player, View view2, String str, FloatingCallback floatingCallback);

    void switchNormal();
}
