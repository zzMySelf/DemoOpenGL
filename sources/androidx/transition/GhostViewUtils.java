package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

class GhostViewUtils {
    static GhostViewImpl addGhost(View view2, ViewGroup viewGroup, Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 21) {
            return GhostViewApi21.addGhost(view2, viewGroup, matrix);
        }
        return GhostViewApi14.addGhost(view2, viewGroup);
    }

    static void removeGhost(View view2) {
        if (Build.VERSION.SDK_INT >= 21) {
            GhostViewApi21.removeGhost(view2);
        } else {
            GhostViewApi14.removeGhost(view2);
        }
    }

    private GhostViewUtils() {
    }
}
