package com.baidu.swan.card.render.view.same;

import com.baidu.nadcore.model.NadRotationPopModelKt;
import com.baidu.searchbox.datadebug.constant.DataType;
import com.baidu.talos.core.render.ViewManagerPropertyUpdater;
import com.baidu.talos.core.render.ViewProps;
import java.util.Map;

public class SwanNASameLayerManager$$PropsSetter implements ViewManagerPropertyUpdater.ViewManagerSetter<SwanNASameLayerManager, SwanNASameLayerView> {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(com.baidu.swan.card.render.view.same.SwanNASameLayerManager r5, com.baidu.swan.card.render.view.same.SwanNASameLayerView r6, java.lang.String r7, com.baidu.talos.core.render.ReactStylesDiffMap r8) {
        /*
            r4 = this;
            int r0 = r7.hashCode()
            r1 = 0
            switch(r0) {
                case -2005472885: goto L_0x01c2;
                case -1721943862: goto L_0x01b6;
                case -1721943861: goto L_0x01aa;
                case -1702963415: goto L_0x01a0;
                case -1422466648: goto L_0x0194;
                case -1351902487: goto L_0x0188;
                case -1267206133: goto L_0x017c;
                case -1137857885: goto L_0x0170;
                case -985933064: goto L_0x0165;
                case -908189618: goto L_0x0158;
                case -908189617: goto L_0x014b;
                case -781597262: goto L_0x013e;
                case -731417480: goto L_0x0131;
                case -80891667: goto L_0x0124;
                case -61833202: goto L_0x0117;
                case -40300674: goto L_0x010a;
                case -4379043: goto L_0x00fe;
                case 3211051: goto L_0x00f2;
                case 36255470: goto L_0x00e7;
                case 71235917: goto L_0x00da;
                case 123673758: goto L_0x00cd;
                case 332797073: goto L_0x00c0;
                case 348919063: goto L_0x00b3;
                case 454217397: goto L_0x00a6;
                case 640435319: goto L_0x009b;
                case 746986311: goto L_0x008f;
                case 1018014185: goto L_0x0082;
                case 1052666732: goto L_0x0075;
                case 1146842694: goto L_0x006a;
                case 1287124693: goto L_0x005f;
                case 1292595405: goto L_0x0054;
                case 1427464783: goto L_0x0049;
                case 1493674762: goto L_0x003c;
                case 1666471017: goto L_0x0031;
                case 1690949434: goto L_0x0024;
                case 1732445090: goto L_0x0017;
                case 1950390299: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x01ce
        L_0x000a:
            java.lang.String r0 = "onTouchEnd"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 22
            goto L_0x01cf
        L_0x0017:
            java.lang.String r0 = "onTouchStart"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 24
            goto L_0x01cf
        L_0x0024:
            java.lang.String r0 = "onTouchCancel"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 21
            goto L_0x01cf
        L_0x0031:
            java.lang.String r0 = "backgroundRepeat"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 6
            goto L_0x01cf
        L_0x003c:
            java.lang.String r0 = "onPressOut"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 20
            goto L_0x01cf
        L_0x0049:
            java.lang.String r0 = "backgroundSize"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 7
            goto L_0x01cf
        L_0x0054:
            java.lang.String r0 = "backgroundImage"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 4
            goto L_0x01cf
        L_0x005f:
            java.lang.String r0 = "backgroundColor"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 3
            goto L_0x01cf
        L_0x006a:
            java.lang.String r0 = "accessibilityLabel"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 1
            goto L_0x01cf
        L_0x0075:
            java.lang.String r0 = "transform"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 31
            goto L_0x01cf
        L_0x0082:
            java.lang.String r0 = "onPressIn"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 19
            goto L_0x01cf
        L_0x008f:
            java.lang.String r0 = "importantForAccessibility"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 11
            goto L_0x01cf
        L_0x009b:
            java.lang.String r0 = "backgroundPosition"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 5
            goto L_0x01cf
        L_0x00a6:
            java.lang.String r0 = "viewTag"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 35
            goto L_0x01cf
        L_0x00b3:
            java.lang.String r0 = "onInterceptPullUpEvent"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 16
            goto L_0x01cf
        L_0x00c0:
            java.lang.String r0 = "onTouchMove"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 23
            goto L_0x01cf
        L_0x00cd:
            java.lang.String r0 = "onInterceptTouchEvent"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 17
            goto L_0x01cf
        L_0x00da:
            java.lang.String r0 = "onLongClick"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 18
            goto L_0x01cf
        L_0x00e7:
            java.lang.String r0 = "accessibilityLiveRegion"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 2
            goto L_0x01cf
        L_0x00f2:
            java.lang.String r0 = "href"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 10
            goto L_0x01cf
        L_0x00fe:
            java.lang.String r0 = "elevation"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 9
            goto L_0x01cf
        L_0x010a:
            java.lang.String r0 = "rotation"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 27
            goto L_0x01cf
        L_0x0117:
            java.lang.String r0 = "onAttachedToWindow"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 13
            goto L_0x01cf
        L_0x0124:
            java.lang.String r0 = "renderToHardwareTextureAndroid"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 26
            goto L_0x01cf
        L_0x0131:
            java.lang.String r0 = "zIndex"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 36
            goto L_0x01cf
        L_0x013e:
            java.lang.String r0 = "transformOrigin"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 32
            goto L_0x01cf
        L_0x014b:
            java.lang.String r0 = "scaleY"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 29
            goto L_0x01cf
        L_0x0158:
            java.lang.String r0 = "scaleX"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 28
            goto L_0x01cf
        L_0x0165:
            java.lang.String r0 = "componentId"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 8
            goto L_0x01cf
        L_0x0170:
            java.lang.String r0 = "nestedScrollingEnabled"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 12
            goto L_0x01cf
        L_0x017c:
            java.lang.String r0 = "opacity"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 25
            goto L_0x01cf
        L_0x0188:
            java.lang.String r0 = "onClick"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 14
            goto L_0x01cf
        L_0x0194:
            java.lang.String r0 = "testTag"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 30
            goto L_0x01cf
        L_0x01a0:
            java.lang.String r0 = "accessibilityComponentType"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = r1
            goto L_0x01cf
        L_0x01aa:
            java.lang.String r0 = "translateY"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 34
            goto L_0x01cf
        L_0x01b6:
            java.lang.String r0 = "translateX"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 33
            goto L_0x01cf
        L_0x01c2:
            java.lang.String r0 = "onDetachedFromWindow"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 15
            goto L_0x01cf
        L_0x01ce:
            r0 = -1
        L_0x01cf:
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            switch(r0) {
                case 0: goto L_0x0320;
                case 1: goto L_0x0318;
                case 2: goto L_0x0310;
                case 3: goto L_0x0308;
                case 4: goto L_0x0300;
                case 5: goto L_0x02f8;
                case 6: goto L_0x02f0;
                case 7: goto L_0x02e8;
                case 8: goto L_0x02e0;
                case 9: goto L_0x02d8;
                case 10: goto L_0x02d0;
                case 11: goto L_0x02c8;
                case 12: goto L_0x02c0;
                case 13: goto L_0x02b7;
                case 14: goto L_0x02ae;
                case 15: goto L_0x02a5;
                case 16: goto L_0x029c;
                case 17: goto L_0x0293;
                case 18: goto L_0x028a;
                case 19: goto L_0x0281;
                case 20: goto L_0x0278;
                case 21: goto L_0x026f;
                case 22: goto L_0x0266;
                case 23: goto L_0x025d;
                case 24: goto L_0x0254;
                case 25: goto L_0x024b;
                case 26: goto L_0x0242;
                case 27: goto L_0x0239;
                case 28: goto L_0x0230;
                case 29: goto L_0x0227;
                case 30: goto L_0x021e;
                case 31: goto L_0x0215;
                case 32: goto L_0x020c;
                case 33: goto L_0x0203;
                case 34: goto L_0x01fa;
                case 35: goto L_0x01f1;
                case 36: goto L_0x01e8;
                default: goto L_0x01d5;
            }
        L_0x01d5:
            if (r7 == 0) goto L_0x0327
            java.lang.String r0 = "_na"
            boolean r0 = r7.startsWith(r0)
            if (r0 == 0) goto L_0x0327
            int r0 = r8.getInt(r7, r1)
            r5.setEventFlag(r6, r7, r0)
            goto L_0x0327
        L_0x01e8:
            float r0 = r8.getFloat(r7, r3)
            r5.setZIndex(r6, r0)
            goto L_0x0327
        L_0x01f1:
            java.lang.String r0 = r8.getString(r7)
            r5.setViewTag(r6, r0)
            goto L_0x0327
        L_0x01fa:
            float r0 = r8.getFloat(r7, r3)
            r5.setTranslateY(r6, r0)
            goto L_0x0327
        L_0x0203:
            float r0 = r8.getFloat(r7, r3)
            r5.setTranslateX(r6, r0)
            goto L_0x0327
        L_0x020c:
            java.lang.String r0 = r8.getString(r7)
            r5.setTransformOrigin(r6, r0)
            goto L_0x0327
        L_0x0215:
            com.baidu.talos.core.data.ParamArray r0 = r8.getArray(r7)
            r5.setTransform(r6, r0)
            goto L_0x0327
        L_0x021e:
            java.lang.String r0 = r8.getString(r7)
            r5.setTestTag(r6, r0)
            goto L_0x0327
        L_0x0227:
            float r0 = r8.getFloat(r7, r2)
            r5.setScaleY(r6, r0)
            goto L_0x0327
        L_0x0230:
            float r0 = r8.getFloat(r7, r2)
            r5.setScaleX(r6, r0)
            goto L_0x0327
        L_0x0239:
            float r0 = r8.getFloat(r7, r3)
            r5.setRotation(r6, r0)
            goto L_0x0327
        L_0x0242:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setRenderToHardwareTexture(r6, r0)
            goto L_0x0327
        L_0x024b:
            float r0 = r8.getFloat(r7, r2)
            r5.setOpacity(r6, r0)
            goto L_0x0327
        L_0x0254:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setTouchDown(r6, r0)
            goto L_0x0327
        L_0x025d:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setTouchMove(r6, r0)
            goto L_0x0327
        L_0x0266:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setTouchEnd(r6, r0)
            goto L_0x0327
        L_0x026f:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setTouchCancel(r6, r0)
            goto L_0x0327
        L_0x0278:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setPressOutable(r6, r0)
            goto L_0x0327
        L_0x0281:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setPressInable(r6, r0)
            goto L_0x0327
        L_0x028a:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setLongClickable(r6, r0)
            goto L_0x0327
        L_0x0293:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setOnInterceptTouchEvent(r6, r0)
            goto L_0x0327
        L_0x029c:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setOnInterceptPullUpEvent(r6, r0)
            goto L_0x0327
        L_0x02a5:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setDetachToWindow(r6, r0)
            goto L_0x0327
        L_0x02ae:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setClickable(r6, r0)
            goto L_0x0327
        L_0x02b7:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setAttachToWindow(r6, r0)
            goto L_0x0327
        L_0x02c0:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setNestedScrollingEnabled(r6, r0)
            goto L_0x0327
        L_0x02c8:
            java.lang.String r0 = r8.getString(r7)
            r5.setImportantForAccessibility(r6, r0)
            goto L_0x0327
        L_0x02d0:
            java.lang.String r0 = r8.getString(r7)
            r5.setHref(r6, r0)
            goto L_0x0327
        L_0x02d8:
            float r0 = r8.getFloat(r7, r3)
            r5.setElevation(r6, r0)
            goto L_0x0327
        L_0x02e0:
            java.lang.String r0 = r8.getString(r7)
            r5.setComponentId(r6, r0)
            goto L_0x0327
        L_0x02e8:
            com.baidu.talos.core.data.ParamMap r0 = r8.getMap(r7)
            r5.setBackgroundSize(r6, r0)
            goto L_0x0327
        L_0x02f0:
            com.baidu.talos.core.data.ParamMap r0 = r8.getMap(r7)
            r5.setBackgroundRepeat(r6, r0)
            goto L_0x0327
        L_0x02f8:
            com.baidu.talos.core.data.ParamMap r0 = r8.getMap(r7)
            r5.setBackgroundPosition(r6, r0)
            goto L_0x0327
        L_0x0300:
            com.baidu.talos.core.data.ParamArray r0 = r8.getArray(r7)
            r5.setBackgroundImage(r6, r0)
            goto L_0x0327
        L_0x0308:
            com.baidu.talos.core.data.Dynamic r0 = r8.getDynamic(r7)
            r5.setBackgroundColor(r6, r0)
            goto L_0x0327
        L_0x0310:
            java.lang.String r0 = r8.getString(r7)
            r5.setAccessibilityLiveRegion(r6, r0)
            goto L_0x0327
        L_0x0318:
            java.lang.String r0 = r8.getString(r7)
            r5.setAccessibilityLabel(r6, r0)
            goto L_0x0327
        L_0x0320:
            java.lang.String r0 = r8.getString(r7)
            r5.setAccessibilityComponentType(r6, r0)
        L_0x0327:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.card.render.view.same.SwanNASameLayerManager$$PropsSetter.setProperty(com.baidu.swan.card.render.view.same.SwanNASameLayerManager, com.baidu.swan.card.render.view.same.SwanNASameLayerView, java.lang.String, com.baidu.talos.core.render.ReactStylesDiffMap):void");
    }

    public void getProperties(Map<String, String> props) {
        props.put("accessibilityComponentType", "String");
        props.put("accessibilityLabel", "String");
        props.put("accessibilityLiveRegion", "String");
        props.put("backgroundColor", "Dynamic");
        props.put(ViewProps.BACKGROUND_IMG, "Array");
        props.put(ViewProps.BACKGROUND_POSITION, "Map");
        props.put(ViewProps.BACKGROUND_REPEAT, "Map");
        props.put(ViewProps.BACKGROUND_SIZE, "Map");
        props.put("componentId", "String");
        props.put("elevation", "number");
        props.put("href", "String");
        props.put("importantForAccessibility", "String");
        props.put("nestedScrollingEnabled", DataType.BOOLEAN);
        props.put("onAttachedToWindow", DataType.BOOLEAN);
        props.put("onClick", DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_DETACHED_FROM_WINDOW, DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_INTERCEPT_PULL_UP_EVENT, DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_INTERCEPT_TOUCH_EVENT, DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_LONG_CLICK, DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_PRESS_IN, DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_PRESS_OUT, DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_TOUCH_CANCEL, DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_TOUCH_END, DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_TOUCH_MOVE, DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_TOUCH_START, DataType.BOOLEAN);
        props.put("opacity", "number");
        props.put("renderToHardwareTextureAndroid", DataType.BOOLEAN);
        props.put(NadRotationPopModelKt.ROTATION, "number");
        props.put("scaleX", "number");
        props.put("scaleY", "number");
        props.put("testTag", "String");
        props.put("transform", "Array");
        props.put("transformOrigin", "String");
        props.put("translateX", "number");
        props.put("translateY", "number");
        props.put("viewTag", "String");
        props.put(ViewProps.PROP_Z_INDEX, "number");
    }
}
