package com.baidu.searchbox.ui.animview.praise.layout;

import android.graphics.Rect;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ui.animview.base.IAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy;
import java.util.Map;

public abstract class BaseLayoutStrategy implements ILayoutStrategy {
    private static final float ERUPTION_SIZE_DP = 313.0f;
    private static final float PRAISELEVEL_SIZE_DP = 170.0f;
    private static final float PRAISENUM_FACTOR_HEIGHT_BASED_PRAISELEVEL = 0.25f;
    private static final float PRAISENUM_FACTOR_POS_X_BASED_PRAISELEVEL = 0.1f;
    private static final float PRAISENUM_FACTOR_POS_Y_BASED_PRAISELEVEL = 0.15f;
    private static final float PRAISENUM_RATIO_BASED_PRAISENUM = 0.61f;
    private static final float SHAKE_SIZE_DP = 21.0f;
    private static final float WAVE_SIZE_DP = 116.0f;
    private Rect mBaseRect;
    private ILayoutStrategy.ICallback mCallback = new ILayoutStrategy.ICallback() {
        public void init(IAnimatedElement element, int x, int y, int width, int height, IResourceProvider provider, Object... otherParams) {
            if (element != null) {
                if (otherParams == null) {
                    element.init(x, y, width, height, provider, new Object[0]);
                    return;
                }
                element.init(x, y, width, height, provider, otherParams);
            }
        }
    };
    private int mCanvasHeight;
    private int mCanvasWidth;
    private IResourceProvider mProvider;

    /* access modifiers changed from: protected */
    public abstract float getPraiseLevelFactorPosX();

    public BaseLayoutStrategy(Rect baseRect, int canvasWidth, int canvasHeight, IResourceProvider provider) {
        this.mBaseRect = baseRect;
        this.mProvider = provider;
        this.mCanvasWidth = canvasWidth;
        this.mCanvasHeight = canvasHeight;
    }

    /* access modifiers changed from: protected */
    public int getPraiseLevelSize() {
        return DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), PRAISELEVEL_SIZE_DP);
    }

    /* access modifiers changed from: protected */
    public float getPraiseNumFactorHeight() {
        return 0.25f;
    }

    /* access modifiers changed from: protected */
    public float getPraiseNumRatio() {
        return PRAISENUM_RATIO_BASED_PRAISENUM;
    }

    /* access modifiers changed from: protected */
    public float getPraiseNumFactorPosX() {
        return 0.1f;
    }

    /* access modifiers changed from: protected */
    public float getPraiseNumFactorPosY() {
        return PRAISENUM_FACTOR_POS_Y_BASED_PRAISELEVEL;
    }

    /* access modifiers changed from: protected */
    public float getPraiseNumFactorDeltaX() {
        return 0.1f;
    }

    public void layout(int elementType, Map<Integer, IAnimatedElement> elementMap) {
        layout(elementType, elementMap, (ILayoutStrategy.ICallback) null);
    }

    public void layout(int elementType, Map<Integer, IAnimatedElement> elementMap, ILayoutStrategy.ICallback cb) {
        ILayoutStrategy.ICallback cb2;
        IAnimatedElement currentElement;
        int outLeft;
        int outTop;
        int i2 = elementType;
        Map<Integer, IAnimatedElement> map = elementMap;
        if (cb == null) {
            cb2 = this.mCallback;
        } else {
            cb2 = cb;
        }
        if (map != null && elementMap.size() > 0 && (currentElement = map.get(Integer.valueOf(elementType))) != null) {
            int[] sizeArray = new int[2];
            getSize(i2, map, sizeArray);
            switch (i2) {
                case 0:
                case 1:
                    int outLeft2 = this.mBaseRect.centerX() - (sizeArray[0] / 2);
                    outTop = this.mBaseRect.centerY() - (sizeArray[1] / 2);
                    outLeft = outLeft2;
                    break;
                case 2:
                    outLeft = (int) ((((float) this.mBaseRect.centerX()) - (((float) sizeArray[0]) * getPraiseLevelFactorPosX())) + 0.5f);
                    outTop = (int) (((float) (this.mBaseRect.centerY() - sizeArray[1])) + 0.5f);
                    break;
                case 3:
                    IAnimatedElement tmpElement = map.get(2);
                    if (tmpElement != null) {
                        int outLeft3 = ((tmpElement.getLeft() + (tmpElement.getWidth() / 2)) - ((int) ((getPraiseNumFactorPosX() * ((float) tmpElement.getWidth())) + 0.5f))) - sizeArray[0];
                        int outTop2 = (int) (((((float) (tmpElement.getTop() + tmpElement.getHeight())) - (((float) tmpElement.getHeight()) * getPraiseNumFactorPosY())) - ((float) sizeArray[1])) + 0.5f);
                        int deltaX = (int) ((getPraiseNumFactorDeltaX() * ((float) tmpElement.getWidth())) + 0.5f);
                        int i3 = sizeArray[0];
                        int i4 = sizeArray[1];
                        IResourceProvider iResourceProvider = this.mProvider;
                        int i5 = deltaX;
                        cb2.init(currentElement, outLeft3, outTop2, i3, i4, iResourceProvider, Integer.valueOf(deltaX));
                        int i6 = outLeft3;
                        int i7 = outTop2;
                        return;
                    }
                    return;
                case 4:
                    outTop = (this.mBaseRect.centerY() - sizeArray[1]) + DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 2.0f);
                    outLeft = this.mBaseRect.centerX() - (sizeArray[0] / 2);
                    break;
                default:
                    return;
            }
            cb2.init(currentElement, outLeft, outTop, sizeArray[0], sizeArray[1], this.mProvider, new Object[0]);
        }
    }

    public void getSize(int elementType, Map<Integer, IAnimatedElement> elementMap, int[] outArr) {
        if (outArr != null && outArr.length >= 2 && elementMap != null && elementMap.size() > 0) {
            switch (elementType) {
                case 0:
                    outArr[0] = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), WAVE_SIZE_DP);
                    outArr[1] = outArr[0];
                    return;
                case 1:
                    outArr[0] = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 21.0f);
                    outArr[1] = outArr[0];
                    return;
                case 2:
                    outArr[0] = getPraiseLevelSize();
                    outArr[1] = outArr[0];
                    return;
                case 3:
                    IAnimatedElement tmpElement = elementMap.get(2);
                    if (tmpElement != null) {
                        outArr[1] = (int) ((((float) tmpElement.getHeight()) * getPraiseNumFactorHeight()) + 0.5f);
                    }
                    outArr[0] = (int) ((((float) outArr[1]) * getPraiseNumRatio()) + 0.5f);
                    return;
                case 4:
                    outArr[0] = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), ERUPTION_SIZE_DP);
                    outArr[1] = outArr[0];
                    return;
                default:
                    return;
            }
        }
    }
}
