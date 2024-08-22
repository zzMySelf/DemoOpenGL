package com.baidu.talos.core.render.views.modal;

import com.baidu.nadcore.model.NadRotationPopModelKt;
import com.baidu.searchbox.datadebug.constant.DataType;
import com.baidu.talos.core.render.ViewManagerPropertyUpdater;
import com.baidu.talos.core.render.ViewProps;
import java.util.Map;

public class ReactModalHostManager$$PropsSetter implements ViewManagerPropertyUpdater.ViewManagerSetter<ReactModalHostManager, ReactModalHostView> {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(com.baidu.talos.core.render.views.modal.ReactModalHostManager r5, com.baidu.talos.core.render.views.modal.ReactModalHostView r6, java.lang.String r7, com.baidu.talos.core.render.ReactStylesDiffMap r8) {
        /*
            r4 = this;
            int r0 = r7.hashCode()
            r1 = 0
            switch(r0) {
                case -2005472885: goto L_0x01f6;
                case -1726194350: goto L_0x01ea;
                case -1721943862: goto L_0x01de;
                case -1721943861: goto L_0x01d2;
                case -1702963415: goto L_0x01c8;
                case -1422466648: goto L_0x01bc;
                case -1351902487: goto L_0x01b0;
                case -1267206133: goto L_0x01a4;
                case -1156137512: goto L_0x0198;
                case -1137857885: goto L_0x018b;
                case -908189618: goto L_0x017e;
                case -908189617: goto L_0x0171;
                case -781597262: goto L_0x0164;
                case -764178990: goto L_0x0157;
                case -731417480: goto L_0x014a;
                case -80891667: goto L_0x013d;
                case -61833202: goto L_0x0130;
                case -40300674: goto L_0x0123;
                case -4379043: goto L_0x0117;
                case 3211051: goto L_0x010b;
                case 36255470: goto L_0x0100;
                case 71235917: goto L_0x00f3;
                case 123673758: goto L_0x00e6;
                case 332797073: goto L_0x00d9;
                case 348919063: goto L_0x00cc;
                case 454217397: goto L_0x00bf;
                case 640435319: goto L_0x00b4;
                case 746986311: goto L_0x00a7;
                case 1018014185: goto L_0x009a;
                case 1052666732: goto L_0x008d;
                case 1146842694: goto L_0x0082;
                case 1195991583: goto L_0x0076;
                case 1287124693: goto L_0x006b;
                case 1292595405: goto L_0x0060;
                case 1427464783: goto L_0x0054;
                case 1493674762: goto L_0x0047;
                case 1666471017: goto L_0x003c;
                case 1690949434: goto L_0x002f;
                case 1732445090: goto L_0x0022;
                case 1950390299: goto L_0x0015;
                case 2031205598: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0202
        L_0x000a:
            java.lang.String r0 = "animationType"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 3
            goto L_0x0203
        L_0x0015:
            java.lang.String r0 = "onTouchEnd"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 23
            goto L_0x0203
        L_0x0022:
            java.lang.String r0 = "onTouchStart"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 25
            goto L_0x0203
        L_0x002f:
            java.lang.String r0 = "onTouchCancel"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 22
            goto L_0x0203
        L_0x003c:
            java.lang.String r0 = "backgroundRepeat"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 7
            goto L_0x0203
        L_0x0047:
            java.lang.String r0 = "onPressOut"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 21
            goto L_0x0203
        L_0x0054:
            java.lang.String r0 = "backgroundSize"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 8
            goto L_0x0203
        L_0x0060:
            java.lang.String r0 = "backgroundImage"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 5
            goto L_0x0203
        L_0x006b:
            java.lang.String r0 = "backgroundColor"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 4
            goto L_0x0203
        L_0x0076:
            java.lang.String r0 = "hardwareAccelerated"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 10
            goto L_0x0203
        L_0x0082:
            java.lang.String r0 = "accessibilityLabel"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 1
            goto L_0x0203
        L_0x008d:
            java.lang.String r0 = "transform"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 33
            goto L_0x0203
        L_0x009a:
            java.lang.String r0 = "onPressIn"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 20
            goto L_0x0203
        L_0x00a7:
            java.lang.String r0 = "importantForAccessibility"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 12
            goto L_0x0203
        L_0x00b4:
            java.lang.String r0 = "backgroundPosition"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 6
            goto L_0x0203
        L_0x00bf:
            java.lang.String r0 = "viewTag"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 39
            goto L_0x0203
        L_0x00cc:
            java.lang.String r0 = "onInterceptPullUpEvent"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 17
            goto L_0x0203
        L_0x00d9:
            java.lang.String r0 = "onTouchMove"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 24
            goto L_0x0203
        L_0x00e6:
            java.lang.String r0 = "onInterceptTouchEvent"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 18
            goto L_0x0203
        L_0x00f3:
            java.lang.String r0 = "onLongClick"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 19
            goto L_0x0203
        L_0x0100:
            java.lang.String r0 = "accessibilityLiveRegion"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 2
            goto L_0x0203
        L_0x010b:
            java.lang.String r0 = "href"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 11
            goto L_0x0203
        L_0x0117:
            java.lang.String r0 = "elevation"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 9
            goto L_0x0203
        L_0x0123:
            java.lang.String r0 = "rotation"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 28
            goto L_0x0203
        L_0x0130:
            java.lang.String r0 = "onAttachedToWindow"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 14
            goto L_0x0203
        L_0x013d:
            java.lang.String r0 = "renderToHardwareTextureAndroid"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 27
            goto L_0x0203
        L_0x014a:
            java.lang.String r0 = "zIndex"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 40
            goto L_0x0203
        L_0x0157:
            java.lang.String r0 = "useLifecycleActivity"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 38
            goto L_0x0203
        L_0x0164:
            java.lang.String r0 = "transformOrigin"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 34
            goto L_0x0203
        L_0x0171:
            java.lang.String r0 = "scaleY"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 30
            goto L_0x0203
        L_0x017e:
            java.lang.String r0 = "scaleX"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 29
            goto L_0x0203
        L_0x018b:
            java.lang.String r0 = "nestedScrollingEnabled"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 13
            goto L_0x0203
        L_0x0198:
            java.lang.String r0 = "statusBarTranslucent"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 31
            goto L_0x0203
        L_0x01a4:
            java.lang.String r0 = "opacity"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 26
            goto L_0x0203
        L_0x01b0:
            java.lang.String r0 = "onClick"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 15
            goto L_0x0203
        L_0x01bc:
            java.lang.String r0 = "testTag"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 32
            goto L_0x0203
        L_0x01c8:
            java.lang.String r0 = "accessibilityComponentType"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = r1
            goto L_0x0203
        L_0x01d2:
            java.lang.String r0 = "translateY"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 36
            goto L_0x0203
        L_0x01de:
            java.lang.String r0 = "translateX"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 35
            goto L_0x0203
        L_0x01ea:
            java.lang.String r0 = "transparent"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 37
            goto L_0x0203
        L_0x01f6:
            java.lang.String r0 = "onDetachedFromWindow"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = 16
            goto L_0x0203
        L_0x0202:
            r0 = -1
        L_0x0203:
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            switch(r0) {
                case 0: goto L_0x0378;
                case 1: goto L_0x0370;
                case 2: goto L_0x0368;
                case 3: goto L_0x0360;
                case 4: goto L_0x0358;
                case 5: goto L_0x0350;
                case 6: goto L_0x0348;
                case 7: goto L_0x0340;
                case 8: goto L_0x0338;
                case 9: goto L_0x0330;
                case 10: goto L_0x0328;
                case 11: goto L_0x0320;
                case 12: goto L_0x0318;
                case 13: goto L_0x030f;
                case 14: goto L_0x0306;
                case 15: goto L_0x02fd;
                case 16: goto L_0x02f4;
                case 17: goto L_0x02eb;
                case 18: goto L_0x02e2;
                case 19: goto L_0x02d9;
                case 20: goto L_0x02d0;
                case 21: goto L_0x02c7;
                case 22: goto L_0x02be;
                case 23: goto L_0x02b5;
                case 24: goto L_0x02ac;
                case 25: goto L_0x02a3;
                case 26: goto L_0x029a;
                case 27: goto L_0x0291;
                case 28: goto L_0x0288;
                case 29: goto L_0x027f;
                case 30: goto L_0x0276;
                case 31: goto L_0x026d;
                case 32: goto L_0x0264;
                case 33: goto L_0x025b;
                case 34: goto L_0x0252;
                case 35: goto L_0x0249;
                case 36: goto L_0x0240;
                case 37: goto L_0x0237;
                case 38: goto L_0x022e;
                case 39: goto L_0x0225;
                case 40: goto L_0x021c;
                default: goto L_0x0209;
            }
        L_0x0209:
            if (r7 == 0) goto L_0x037f
            java.lang.String r0 = "_na"
            boolean r0 = r7.startsWith(r0)
            if (r0 == 0) goto L_0x037f
            int r0 = r8.getInt(r7, r1)
            r5.setEventFlag(r6, r7, r0)
            goto L_0x037f
        L_0x021c:
            float r0 = r8.getFloat(r7, r3)
            r5.setZIndex(r6, r0)
            goto L_0x037f
        L_0x0225:
            java.lang.String r0 = r8.getString(r7)
            r5.setViewTag(r6, r0)
            goto L_0x037f
        L_0x022e:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.useLifecycleActivity(r6, r0)
            goto L_0x037f
        L_0x0237:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setTransparent(r6, r0)
            goto L_0x037f
        L_0x0240:
            float r0 = r8.getFloat(r7, r3)
            r5.setTranslateY(r6, r0)
            goto L_0x037f
        L_0x0249:
            float r0 = r8.getFloat(r7, r3)
            r5.setTranslateX(r6, r0)
            goto L_0x037f
        L_0x0252:
            java.lang.String r0 = r8.getString(r7)
            r5.setTransformOrigin(r6, r0)
            goto L_0x037f
        L_0x025b:
            com.baidu.talos.core.data.ParamArray r0 = r8.getArray(r7)
            r5.setTransform(r6, r0)
            goto L_0x037f
        L_0x0264:
            java.lang.String r0 = r8.getString(r7)
            r5.setTestTag(r6, r0)
            goto L_0x037f
        L_0x026d:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setStatusBarTranslucent(r6, r0)
            goto L_0x037f
        L_0x0276:
            float r0 = r8.getFloat(r7, r2)
            r5.setScaleY(r6, r0)
            goto L_0x037f
        L_0x027f:
            float r0 = r8.getFloat(r7, r2)
            r5.setScaleX(r6, r0)
            goto L_0x037f
        L_0x0288:
            float r0 = r8.getFloat(r7, r3)
            r5.setRotation(r6, r0)
            goto L_0x037f
        L_0x0291:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setRenderToHardwareTexture(r6, r0)
            goto L_0x037f
        L_0x029a:
            float r0 = r8.getFloat(r7, r2)
            r5.setOpacity(r6, r0)
            goto L_0x037f
        L_0x02a3:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setTouchDown(r6, r0)
            goto L_0x037f
        L_0x02ac:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setTouchMove(r6, r0)
            goto L_0x037f
        L_0x02b5:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setTouchEnd(r6, r0)
            goto L_0x037f
        L_0x02be:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setTouchCancel(r6, r0)
            goto L_0x037f
        L_0x02c7:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setPressOutable(r6, r0)
            goto L_0x037f
        L_0x02d0:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setPressInable(r6, r0)
            goto L_0x037f
        L_0x02d9:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setLongClickable(r6, r0)
            goto L_0x037f
        L_0x02e2:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setOnInterceptTouchEvent(r6, r0)
            goto L_0x037f
        L_0x02eb:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setOnInterceptPullUpEvent(r6, r0)
            goto L_0x037f
        L_0x02f4:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setDetachToWindow(r6, r0)
            goto L_0x037f
        L_0x02fd:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setClickable(r6, r0)
            goto L_0x037f
        L_0x0306:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setAttachToWindow(r6, r0)
            goto L_0x037f
        L_0x030f:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setNestedScrollingEnabled(r6, r0)
            goto L_0x037f
        L_0x0318:
            java.lang.String r0 = r8.getString(r7)
            r5.setImportantForAccessibility(r6, r0)
            goto L_0x037f
        L_0x0320:
            java.lang.String r0 = r8.getString(r7)
            r5.setHref(r6, r0)
            goto L_0x037f
        L_0x0328:
            boolean r0 = r8.getBoolean(r7, r1)
            r5.setHardwareAccelerated(r6, r0)
            goto L_0x037f
        L_0x0330:
            float r0 = r8.getFloat(r7, r3)
            r5.setElevation(r6, r0)
            goto L_0x037f
        L_0x0338:
            com.baidu.talos.core.data.ParamMap r0 = r8.getMap(r7)
            r5.setBackgroundSize(r6, r0)
            goto L_0x037f
        L_0x0340:
            com.baidu.talos.core.data.ParamMap r0 = r8.getMap(r7)
            r5.setBackgroundRepeat(r6, r0)
            goto L_0x037f
        L_0x0348:
            com.baidu.talos.core.data.ParamMap r0 = r8.getMap(r7)
            r5.setBackgroundPosition(r6, r0)
            goto L_0x037f
        L_0x0350:
            com.baidu.talos.core.data.ParamArray r0 = r8.getArray(r7)
            r5.setBackgroundImage(r6, r0)
            goto L_0x037f
        L_0x0358:
            com.baidu.talos.core.data.Dynamic r0 = r8.getDynamic(r7)
            r5.setBackgroundColor(r6, r0)
            goto L_0x037f
        L_0x0360:
            java.lang.String r0 = r8.getString(r7)
            r5.setAnimationType(r6, r0)
            goto L_0x037f
        L_0x0368:
            java.lang.String r0 = r8.getString(r7)
            r5.setAccessibilityLiveRegion(r6, r0)
            goto L_0x037f
        L_0x0370:
            java.lang.String r0 = r8.getString(r7)
            r5.setAccessibilityLabel(r6, r0)
            goto L_0x037f
        L_0x0378:
            java.lang.String r0 = r8.getString(r7)
            r5.setAccessibilityComponentType(r6, r0)
        L_0x037f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.talos.core.render.views.modal.ReactModalHostManager$$PropsSetter.setProperty(com.baidu.talos.core.render.views.modal.ReactModalHostManager, com.baidu.talos.core.render.views.modal.ReactModalHostView, java.lang.String, com.baidu.talos.core.render.ReactStylesDiffMap):void");
    }

    public void getProperties(Map<String, String> props) {
        props.put("accessibilityComponentType", "String");
        props.put("accessibilityLabel", "String");
        props.put("accessibilityLiveRegion", "String");
        props.put("animationType", "String");
        props.put("backgroundColor", "Dynamic");
        props.put(ViewProps.BACKGROUND_IMG, "Array");
        props.put(ViewProps.BACKGROUND_POSITION, "Map");
        props.put(ViewProps.BACKGROUND_REPEAT, "Map");
        props.put(ViewProps.BACKGROUND_SIZE, "Map");
        props.put("elevation", "number");
        props.put("hardwareAccelerated", DataType.BOOLEAN);
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
        props.put("statusBarTranslucent", DataType.BOOLEAN);
        props.put("testTag", "String");
        props.put("transform", "Array");
        props.put("transformOrigin", "String");
        props.put("translateX", "number");
        props.put("translateY", "number");
        props.put("transparent", DataType.BOOLEAN);
        props.put("useLifecycleActivity", DataType.BOOLEAN);
        props.put("viewTag", "String");
        props.put(ViewProps.PROP_Z_INDEX, "number");
    }
}
