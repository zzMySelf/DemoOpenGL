package com.baidu.talos.core.render.views.viewpager;

import com.baidu.nadcore.model.NadRotationPopModelKt;
import com.baidu.searchbox.datadebug.constant.DataType;
import com.baidu.talos.core.render.ViewManagerPropertyUpdater;
import com.baidu.talos.core.render.ViewProps;
import java.util.Map;

public class ReactViewPagerManager$$PropsSetter implements ViewManagerPropertyUpdater.ViewManagerSetter<ReactViewPagerManager, ReactViewPager> {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(com.baidu.talos.core.render.views.viewpager.ReactViewPagerManager r6, com.baidu.talos.core.render.views.viewpager.ReactViewPager r7, java.lang.String r8, com.baidu.talos.core.render.ReactStylesDiffMap r9) {
        /*
            r5 = this;
            int r0 = r8.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -2005472885: goto L_0x01d2;
                case -1721943862: goto L_0x01c6;
                case -1721943861: goto L_0x01ba;
                case -1702963415: goto L_0x01b0;
                case -1422466648: goto L_0x01a4;
                case -1351902487: goto L_0x0198;
                case -1267206133: goto L_0x018c;
                case -1151046732: goto L_0x0180;
                case -1137857885: goto L_0x0174;
                case -908189618: goto L_0x0167;
                case -908189617: goto L_0x015a;
                case -781597262: goto L_0x014d;
                case -731417480: goto L_0x0140;
                case -80891667: goto L_0x0133;
                case -61833202: goto L_0x0126;
                case -40300674: goto L_0x0119;
                case -4379043: goto L_0x010d;
                case 3211051: goto L_0x0101;
                case 36255470: goto L_0x00f6;
                case 71235917: goto L_0x00e9;
                case 123673758: goto L_0x00dc;
                case 332797073: goto L_0x00cf;
                case 348919063: goto L_0x00c2;
                case 454217397: goto L_0x00b5;
                case 640435319: goto L_0x00aa;
                case 746986311: goto L_0x009d;
                case 1018014185: goto L_0x0090;
                case 1052666732: goto L_0x0083;
                case 1097821469: goto L_0x0076;
                case 1146842694: goto L_0x006b;
                case 1287124693: goto L_0x0060;
                case 1292595405: goto L_0x0055;
                case 1427464783: goto L_0x004a;
                case 1493674762: goto L_0x003d;
                case 1666471017: goto L_0x0032;
                case 1690949434: goto L_0x0025;
                case 1732445090: goto L_0x0018;
                case 1950390299: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x01de
        L_0x000b:
            java.lang.String r0 = "onTouchEnd"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 21
            goto L_0x01df
        L_0x0018:
            java.lang.String r0 = "onTouchStart"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 23
            goto L_0x01df
        L_0x0025:
            java.lang.String r0 = "onTouchCancel"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 20
            goto L_0x01df
        L_0x0032:
            java.lang.String r0 = "backgroundRepeat"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 6
            goto L_0x01df
        L_0x003d:
            java.lang.String r0 = "onPressOut"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 19
            goto L_0x01df
        L_0x004a:
            java.lang.String r0 = "backgroundSize"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 7
            goto L_0x01df
        L_0x0055:
            java.lang.String r0 = "backgroundImage"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 4
            goto L_0x01df
        L_0x0060:
            java.lang.String r0 = "backgroundColor"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 3
            goto L_0x01df
        L_0x006b:
            java.lang.String r0 = "accessibilityLabel"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = r1
            goto L_0x01df
        L_0x0076:
            java.lang.String r0 = "pageMargin"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 25
            goto L_0x01df
        L_0x0083:
            java.lang.String r0 = "transform"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 32
            goto L_0x01df
        L_0x0090:
            java.lang.String r0 = "onPressIn"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 18
            goto L_0x01df
        L_0x009d:
            java.lang.String r0 = "importantForAccessibility"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 10
            goto L_0x01df
        L_0x00aa:
            java.lang.String r0 = "backgroundPosition"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 5
            goto L_0x01df
        L_0x00b5:
            java.lang.String r0 = "viewTag"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 36
            goto L_0x01df
        L_0x00c2:
            java.lang.String r0 = "onInterceptPullUpEvent"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 15
            goto L_0x01df
        L_0x00cf:
            java.lang.String r0 = "onTouchMove"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 22
            goto L_0x01df
        L_0x00dc:
            java.lang.String r0 = "onInterceptTouchEvent"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 16
            goto L_0x01df
        L_0x00e9:
            java.lang.String r0 = "onLongClick"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 17
            goto L_0x01df
        L_0x00f6:
            java.lang.String r0 = "accessibilityLiveRegion"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 2
            goto L_0x01df
        L_0x0101:
            java.lang.String r0 = "href"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 9
            goto L_0x01df
        L_0x010d:
            java.lang.String r0 = "elevation"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 8
            goto L_0x01df
        L_0x0119:
            java.lang.String r0 = "rotation"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 27
            goto L_0x01df
        L_0x0126:
            java.lang.String r0 = "onAttachedToWindow"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 12
            goto L_0x01df
        L_0x0133:
            java.lang.String r0 = "renderToHardwareTextureAndroid"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 26
            goto L_0x01df
        L_0x0140:
            java.lang.String r0 = "zIndex"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 37
            goto L_0x01df
        L_0x014d:
            java.lang.String r0 = "transformOrigin"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 33
            goto L_0x01df
        L_0x015a:
            java.lang.String r0 = "scaleY"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 29
            goto L_0x01df
        L_0x0167:
            java.lang.String r0 = "scaleX"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 28
            goto L_0x01df
        L_0x0174:
            java.lang.String r0 = "nestedScrollingEnabled"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 11
            goto L_0x01df
        L_0x0180:
            java.lang.String r0 = "scrollEnabled"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 30
            goto L_0x01df
        L_0x018c:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 24
            goto L_0x01df
        L_0x0198:
            java.lang.String r0 = "onClick"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 13
            goto L_0x01df
        L_0x01a4:
            java.lang.String r0 = "testTag"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 31
            goto L_0x01df
        L_0x01b0:
            java.lang.String r0 = "accessibilityComponentType"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = r2
            goto L_0x01df
        L_0x01ba:
            java.lang.String r0 = "translateY"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 35
            goto L_0x01df
        L_0x01c6:
            java.lang.String r0 = "translateX"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 34
            goto L_0x01df
        L_0x01d2:
            java.lang.String r0 = "onDetachedFromWindow"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 14
            goto L_0x01df
        L_0x01de:
            r0 = -1
        L_0x01df:
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            switch(r0) {
                case 0: goto L_0x0339;
                case 1: goto L_0x0331;
                case 2: goto L_0x0329;
                case 3: goto L_0x0321;
                case 4: goto L_0x0319;
                case 5: goto L_0x0311;
                case 6: goto L_0x0309;
                case 7: goto L_0x0301;
                case 8: goto L_0x02f9;
                case 9: goto L_0x02f1;
                case 10: goto L_0x02e9;
                case 11: goto L_0x02e1;
                case 12: goto L_0x02d9;
                case 13: goto L_0x02d0;
                case 14: goto L_0x02c7;
                case 15: goto L_0x02be;
                case 16: goto L_0x02b5;
                case 17: goto L_0x02ac;
                case 18: goto L_0x02a3;
                case 19: goto L_0x029a;
                case 20: goto L_0x0291;
                case 21: goto L_0x0288;
                case 22: goto L_0x027f;
                case 23: goto L_0x0276;
                case 24: goto L_0x026d;
                case 25: goto L_0x0264;
                case 26: goto L_0x025b;
                case 27: goto L_0x0252;
                case 28: goto L_0x0249;
                case 29: goto L_0x0240;
                case 30: goto L_0x0237;
                case 31: goto L_0x022e;
                case 32: goto L_0x0225;
                case 33: goto L_0x021c;
                case 34: goto L_0x0213;
                case 35: goto L_0x020a;
                case 36: goto L_0x0201;
                case 37: goto L_0x01f8;
                default: goto L_0x01e5;
            }
        L_0x01e5:
            if (r8 == 0) goto L_0x0340
            java.lang.String r0 = "_na"
            boolean r0 = r8.startsWith(r0)
            if (r0 == 0) goto L_0x0340
            int r0 = r9.getInt(r8, r2)
            r6.setEventFlag(r7, r8, r0)
            goto L_0x0340
        L_0x01f8:
            float r0 = r9.getFloat(r8, r4)
            r6.setZIndex(r7, r0)
            goto L_0x0340
        L_0x0201:
            java.lang.String r0 = r9.getString(r8)
            r6.setViewTag(r7, r0)
            goto L_0x0340
        L_0x020a:
            float r0 = r9.getFloat(r8, r4)
            r6.setTranslateY(r7, r0)
            goto L_0x0340
        L_0x0213:
            float r0 = r9.getFloat(r8, r4)
            r6.setTranslateX(r7, r0)
            goto L_0x0340
        L_0x021c:
            java.lang.String r0 = r9.getString(r8)
            r6.setTransformOrigin(r7, r0)
            goto L_0x0340
        L_0x0225:
            com.baidu.talos.core.data.ParamArray r0 = r9.getArray(r8)
            r6.setTransform(r7, r0)
            goto L_0x0340
        L_0x022e:
            java.lang.String r0 = r9.getString(r8)
            r6.setTestTag(r7, r0)
            goto L_0x0340
        L_0x0237:
            boolean r0 = r9.getBoolean(r8, r1)
            r6.setScrollEnabled(r7, r0)
            goto L_0x0340
        L_0x0240:
            float r0 = r9.getFloat(r8, r3)
            r6.setScaleY(r7, r0)
            goto L_0x0340
        L_0x0249:
            float r0 = r9.getFloat(r8, r3)
            r6.setScaleX(r7, r0)
            goto L_0x0340
        L_0x0252:
            float r0 = r9.getFloat(r8, r4)
            r6.setRotation(r7, r0)
            goto L_0x0340
        L_0x025b:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setRenderToHardwareTexture(r7, r0)
            goto L_0x0340
        L_0x0264:
            float r0 = r9.getFloat(r8, r4)
            r6.setPageMargin(r7, r0)
            goto L_0x0340
        L_0x026d:
            float r0 = r9.getFloat(r8, r3)
            r6.setOpacity(r7, r0)
            goto L_0x0340
        L_0x0276:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setTouchDown(r7, r0)
            goto L_0x0340
        L_0x027f:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setTouchMove(r7, r0)
            goto L_0x0340
        L_0x0288:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setTouchEnd(r7, r0)
            goto L_0x0340
        L_0x0291:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setTouchCancel(r7, r0)
            goto L_0x0340
        L_0x029a:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setPressOutable(r7, r0)
            goto L_0x0340
        L_0x02a3:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setPressInable(r7, r0)
            goto L_0x0340
        L_0x02ac:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setLongClickable(r7, r0)
            goto L_0x0340
        L_0x02b5:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setOnInterceptTouchEvent(r7, r0)
            goto L_0x0340
        L_0x02be:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setOnInterceptPullUpEvent(r7, r0)
            goto L_0x0340
        L_0x02c7:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setDetachToWindow(r7, r0)
            goto L_0x0340
        L_0x02d0:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setClickable(r7, r0)
            goto L_0x0340
        L_0x02d9:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setAttachToWindow(r7, r0)
            goto L_0x0340
        L_0x02e1:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setNestedScrollingEnabled(r7, r0)
            goto L_0x0340
        L_0x02e9:
            java.lang.String r0 = r9.getString(r8)
            r6.setImportantForAccessibility(r7, r0)
            goto L_0x0340
        L_0x02f1:
            java.lang.String r0 = r9.getString(r8)
            r6.setHref(r7, r0)
            goto L_0x0340
        L_0x02f9:
            float r0 = r9.getFloat(r8, r4)
            r6.setElevation(r7, r0)
            goto L_0x0340
        L_0x0301:
            com.baidu.talos.core.data.ParamMap r0 = r9.getMap(r8)
            r6.setBackgroundSize(r7, r0)
            goto L_0x0340
        L_0x0309:
            com.baidu.talos.core.data.ParamMap r0 = r9.getMap(r8)
            r6.setBackgroundRepeat(r7, r0)
            goto L_0x0340
        L_0x0311:
            com.baidu.talos.core.data.ParamMap r0 = r9.getMap(r8)
            r6.setBackgroundPosition(r7, r0)
            goto L_0x0340
        L_0x0319:
            com.baidu.talos.core.data.ParamArray r0 = r9.getArray(r8)
            r6.setBackgroundImage(r7, r0)
            goto L_0x0340
        L_0x0321:
            com.baidu.talos.core.data.Dynamic r0 = r9.getDynamic(r8)
            r6.setBackgroundColor(r7, r0)
            goto L_0x0340
        L_0x0329:
            java.lang.String r0 = r9.getString(r8)
            r6.setAccessibilityLiveRegion(r7, r0)
            goto L_0x0340
        L_0x0331:
            java.lang.String r0 = r9.getString(r8)
            r6.setAccessibilityLabel(r7, r0)
            goto L_0x0340
        L_0x0339:
            java.lang.String r0 = r9.getString(r8)
            r6.setAccessibilityComponentType(r7, r0)
        L_0x0340:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.talos.core.render.views.viewpager.ReactViewPagerManager$$PropsSetter.setProperty(com.baidu.talos.core.render.views.viewpager.ReactViewPagerManager, com.baidu.talos.core.render.views.viewpager.ReactViewPager, java.lang.String, com.baidu.talos.core.render.ReactStylesDiffMap):void");
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
        props.put("pageMargin", "number");
        props.put("renderToHardwareTextureAndroid", DataType.BOOLEAN);
        props.put(NadRotationPopModelKt.ROTATION, "number");
        props.put("scaleX", "number");
        props.put("scaleY", "number");
        props.put("scrollEnabled", DataType.BOOLEAN);
        props.put("testTag", "String");
        props.put("transform", "Array");
        props.put("transformOrigin", "String");
        props.put("translateX", "number");
        props.put("translateY", "number");
        props.put("viewTag", "String");
        props.put(ViewProps.PROP_Z_INDEX, "number");
    }
}
