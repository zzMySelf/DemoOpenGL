package com.baidu.talos.core.render.views.art;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import com.baidu.talos.core.Debug;
import com.baidu.talos.core.layout.ILayoutContext;
import com.baidu.talos.core.render.IUIViewUpdater;
import com.baidu.talos.core.render.LayoutShadowNode;

public class ARTSurfaceViewShadowNode extends LayoutShadowNode {
    public ARTSurfaceViewShadowNode(ILayoutContext environment) {
        super(environment);
    }

    public boolean isVirtual() {
        return false;
    }

    public boolean isVirtualAnchor() {
        return true;
    }

    public void onCollectExtraUpdates(IUIViewUpdater uiUpdater) {
        super.onCollectExtraUpdates(uiUpdater);
        Object drawObject = drawOutput();
        if (this.mCellNodeTag == 0) {
            uiUpdater.enqueueUpdateExtraData(getReactTag(), drawObject);
        } else {
            this.mExtra1 = drawObject;
        }
    }

    private Object drawOutput() {
        int width = (int) getLayoutWidth();
        int height = (int) getLayoutHeight();
        if (width > 0 && height > 0) {
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                ARTVirtualNode child = (ARTVirtualNode) getChildAt(i2);
                child.draw(canvas, paint, 1.0f);
                child.markUpdateSeen();
            }
            return bitmap;
        } else if (!Debug.isDebug()) {
            return null;
        } else {
            Log.e("ARTSurfaceViewNode", "drawOutput fail width=" + width + " height=" + height);
            return null;
        }
    }
}
