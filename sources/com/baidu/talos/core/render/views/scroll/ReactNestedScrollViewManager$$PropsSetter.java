package com.baidu.talos.core.render.views.scroll;

import com.baidu.nadcore.model.NadRotationPopModelKt;
import com.baidu.searchbox.datadebug.constant.DataType;
import com.baidu.talos.core.render.ReactClippingViewGroupHelper;
import com.baidu.talos.core.render.ViewManagerPropertyUpdater;
import com.baidu.talos.core.render.ViewProps;
import java.util.Map;

public class ReactNestedScrollViewManager$$PropsSetter implements ViewManagerPropertyUpdater.ViewManagerSetter<ReactNestedScrollViewManager, ReactNestedScrollView> {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(com.baidu.talos.core.render.views.scroll.ReactNestedScrollViewManager r6, com.baidu.talos.core.render.views.scroll.ReactNestedScrollView r7, java.lang.String r8, com.baidu.talos.core.render.ReactStylesDiffMap r9) {
        /*
            r5 = this;
            int r0 = r8.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -2005472885: goto L_0x026b;
                case -1721943862: goto L_0x025f;
                case -1721943861: goto L_0x0253;
                case -1702963415: goto L_0x0249;
                case -1553096443: goto L_0x023e;
                case -1422466648: goto L_0x0232;
                case -1351902487: goto L_0x0226;
                case -1267206133: goto L_0x021a;
                case -1151046732: goto L_0x020e;
                case -1137857885: goto L_0x0201;
                case -1066305222: goto L_0x01f4;
                case -950131236: goto L_0x01e8;
                case -929764952: goto L_0x01dc;
                case -922092170: goto L_0x01cf;
                case -908189618: goto L_0x01c2;
                case -908189617: goto L_0x01b5;
                case -849694523: goto L_0x01a8;
                case -781597262: goto L_0x019b;
                case -731417480: goto L_0x018e;
                case -339763633: goto L_0x0181;
                case -252105751: goto L_0x0174;
                case -220307356: goto L_0x0167;
                case -80891667: goto L_0x015a;
                case -61833202: goto L_0x014d;
                case -45003020: goto L_0x0140;
                case -40300674: goto L_0x0133;
                case -4379043: goto L_0x0127;
                case 3211051: goto L_0x011b;
                case 36255470: goto L_0x0110;
                case 71235917: goto L_0x0103;
                case 123673758: goto L_0x00f6;
                case 332797073: goto L_0x00e9;
                case 348919063: goto L_0x00dc;
                case 454217397: goto L_0x00cf;
                case 640435319: goto L_0x00c4;
                case 692181369: goto L_0x00b7;
                case 746986311: goto L_0x00aa;
                case 1018014185: goto L_0x009d;
                case 1052666732: goto L_0x0090;
                case 1146842694: goto L_0x0085;
                case 1287124693: goto L_0x007a;
                case 1292595405: goto L_0x006f;
                case 1379637717: goto L_0x0062;
                case 1427464783: goto L_0x0057;
                case 1493674762: goto L_0x004a;
                case 1666471017: goto L_0x003f;
                case 1690949434: goto L_0x0032;
                case 1732445090: goto L_0x0025;
                case 1950390299: goto L_0x0018;
                case 2094237769: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0277
        L_0x000b:
            java.lang.String r0 = "onScrollerChange"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 27
            goto L_0x0278
        L_0x0018:
            java.lang.String r0 = "onTouchEnd"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 30
            goto L_0x0278
        L_0x0025:
            java.lang.String r0 = "onTouchStart"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 32
            goto L_0x0278
        L_0x0032:
            java.lang.String r0 = "onTouchCancel"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 29
            goto L_0x0278
        L_0x003f:
            java.lang.String r0 = "backgroundRepeat"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 6
            goto L_0x0278
        L_0x004a:
            java.lang.String r0 = "onPressOut"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 26
            goto L_0x0278
        L_0x0057:
            java.lang.String r0 = "backgroundSize"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 7
            goto L_0x0278
        L_0x0062:
            java.lang.String r0 = "onEndReachedThreshold"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 19
            goto L_0x0278
        L_0x006f:
            java.lang.String r0 = "backgroundImage"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 4
            goto L_0x0278
        L_0x007a:
            java.lang.String r0 = "backgroundColor"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 3
            goto L_0x0278
        L_0x0085:
            java.lang.String r0 = "accessibilityLabel"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = r1
            goto L_0x0278
        L_0x0090:
            java.lang.String r0 = "transform"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 44
            goto L_0x0278
        L_0x009d:
            java.lang.String r0 = "onPressIn"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 25
            goto L_0x0278
        L_0x00aa:
            java.lang.String r0 = "importantForAccessibility"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 13
            goto L_0x0278
        L_0x00b7:
            java.lang.String r0 = "sendMomentumEvents"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 41
            goto L_0x0278
        L_0x00c4:
            java.lang.String r0 = "backgroundPosition"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 5
            goto L_0x0278
        L_0x00cf:
            java.lang.String r0 = "viewTag"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 48
            goto L_0x0278
        L_0x00dc:
            java.lang.String r0 = "onInterceptPullUpEvent"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 20
            goto L_0x0278
        L_0x00e9:
            java.lang.String r0 = "onTouchMove"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 31
            goto L_0x0278
        L_0x00f6:
            java.lang.String r0 = "onInterceptTouchEvent"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 21
            goto L_0x0278
        L_0x0103:
            java.lang.String r0 = "onLongClick"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 24
            goto L_0x0278
        L_0x0110:
            java.lang.String r0 = "accessibilityLiveRegion"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 2
            goto L_0x0278
        L_0x011b:
            java.lang.String r0 = "href"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 12
            goto L_0x0278
        L_0x0127:
            java.lang.String r0 = "elevation"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 8
            goto L_0x0278
        L_0x0133:
            java.lang.String r0 = "rotation"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 36
            goto L_0x0278
        L_0x0140:
            java.lang.String r0 = "onListEndReached"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 22
            goto L_0x0278
        L_0x014d:
            java.lang.String r0 = "onAttachedToWindow"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 15
            goto L_0x0278
        L_0x015a:
            java.lang.String r0 = "renderToHardwareTextureAndroid"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 35
            goto L_0x0278
        L_0x0167:
            java.lang.String r0 = "scrollPerfTag"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 40
            goto L_0x0278
        L_0x0174:
            java.lang.String r0 = "removeClippedSubviews"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 34
            goto L_0x0278
        L_0x0181:
            java.lang.String r0 = "onTopReachedThreshold"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 28
            goto L_0x0278
        L_0x018e:
            java.lang.String r0 = "zIndex"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 49
            goto L_0x0278
        L_0x019b:
            java.lang.String r0 = "transformOrigin"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 45
            goto L_0x0278
        L_0x01a8:
            java.lang.String r0 = "onBDScrollStateDisable"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 16
            goto L_0x0278
        L_0x01b5:
            java.lang.String r0 = "scaleY"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 38
            goto L_0x0278
        L_0x01c2:
            java.lang.String r0 = "scaleX"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 37
            goto L_0x0278
        L_0x01cf:
            java.lang.String r0 = "showsVerticalScrollIndicator"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 42
            goto L_0x0278
        L_0x01dc:
            java.lang.String r0 = "forceHandleVerticalSlide"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 10
            goto L_0x0278
        L_0x01e8:
            java.lang.String r0 = "hasPullRefresh"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 11
            goto L_0x0278
        L_0x01f4:
            java.lang.String r0 = "onListTopReached"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 23
            goto L_0x0278
        L_0x0201:
            java.lang.String r0 = "nestedScrollingEnabled"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 14
            goto L_0x0278
        L_0x020e:
            java.lang.String r0 = "scrollEnabled"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 39
            goto L_0x0278
        L_0x021a:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 33
            goto L_0x0278
        L_0x0226:
            java.lang.String r0 = "onClick"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 17
            goto L_0x0278
        L_0x0232:
            java.lang.String r0 = "testTag"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 43
            goto L_0x0278
        L_0x023e:
            java.lang.String r0 = "endFillColor"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 9
            goto L_0x0278
        L_0x0249:
            java.lang.String r0 = "accessibilityComponentType"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = r2
            goto L_0x0278
        L_0x0253:
            java.lang.String r0 = "translateY"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 47
            goto L_0x0278
        L_0x025f:
            java.lang.String r0 = "translateX"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 46
            goto L_0x0278
        L_0x026b:
            java.lang.String r0 = "onDetachedFromWindow"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 18
            goto L_0x0278
        L_0x0277:
            r0 = -1
        L_0x0278:
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            switch(r0) {
                case 0: goto L_0x043e;
                case 1: goto L_0x0436;
                case 2: goto L_0x042e;
                case 3: goto L_0x0426;
                case 4: goto L_0x041e;
                case 5: goto L_0x0416;
                case 6: goto L_0x040e;
                case 7: goto L_0x0406;
                case 8: goto L_0x03fe;
                case 9: goto L_0x03f6;
                case 10: goto L_0x03ee;
                case 11: goto L_0x03e6;
                case 12: goto L_0x03de;
                case 13: goto L_0x03d5;
                case 14: goto L_0x03cc;
                case 15: goto L_0x03c3;
                case 16: goto L_0x03ba;
                case 17: goto L_0x03b1;
                case 18: goto L_0x03a8;
                case 19: goto L_0x039f;
                case 20: goto L_0x0396;
                case 21: goto L_0x038d;
                case 22: goto L_0x0384;
                case 23: goto L_0x037b;
                case 24: goto L_0x0372;
                case 25: goto L_0x0369;
                case 26: goto L_0x0360;
                case 27: goto L_0x0357;
                case 28: goto L_0x034e;
                case 29: goto L_0x0345;
                case 30: goto L_0x033c;
                case 31: goto L_0x0333;
                case 32: goto L_0x032a;
                case 33: goto L_0x0321;
                case 34: goto L_0x0318;
                case 35: goto L_0x030f;
                case 36: goto L_0x0306;
                case 37: goto L_0x02fd;
                case 38: goto L_0x02f4;
                case 39: goto L_0x02eb;
                case 40: goto L_0x02e2;
                case 41: goto L_0x02d9;
                case 42: goto L_0x02d0;
                case 43: goto L_0x02c7;
                case 44: goto L_0x02be;
                case 45: goto L_0x02b5;
                case 46: goto L_0x02ac;
                case 47: goto L_0x02a3;
                case 48: goto L_0x029a;
                case 49: goto L_0x0291;
                default: goto L_0x027e;
            }
        L_0x027e:
            if (r8 == 0) goto L_0x0445
            java.lang.String r0 = "_na"
            boolean r0 = r8.startsWith(r0)
            if (r0 == 0) goto L_0x0445
            int r0 = r9.getInt(r8, r2)
            r6.setEventFlag(r7, r8, r0)
            goto L_0x0445
        L_0x0291:
            float r0 = r9.getFloat(r8, r4)
            r6.setZIndex(r7, r0)
            goto L_0x0445
        L_0x029a:
            java.lang.String r0 = r9.getString(r8)
            r6.setViewTag(r7, r0)
            goto L_0x0445
        L_0x02a3:
            float r0 = r9.getFloat(r8, r4)
            r6.setTranslateY(r7, r0)
            goto L_0x0445
        L_0x02ac:
            float r0 = r9.getFloat(r8, r4)
            r6.setTranslateX(r7, r0)
            goto L_0x0445
        L_0x02b5:
            java.lang.String r0 = r9.getString(r8)
            r6.setTransformOrigin(r7, r0)
            goto L_0x0445
        L_0x02be:
            com.baidu.talos.core.data.ParamArray r0 = r9.getArray(r8)
            r6.setTransform(r7, r0)
            goto L_0x0445
        L_0x02c7:
            java.lang.String r0 = r9.getString(r8)
            r6.setTestTag(r7, r0)
            goto L_0x0445
        L_0x02d0:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setShowsVerticalScrollIndicator(r7, r0)
            goto L_0x0445
        L_0x02d9:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setSendMomentumEvents(r7, r0)
            goto L_0x0445
        L_0x02e2:
            java.lang.String r0 = r9.getString(r8)
            r6.setScrollPerfTag(r7, r0)
            goto L_0x0445
        L_0x02eb:
            boolean r0 = r9.getBoolean(r8, r1)
            r6.setScrollEnabled(r7, r0)
            goto L_0x0445
        L_0x02f4:
            float r0 = r9.getFloat(r8, r3)
            r6.setScaleY(r7, r0)
            goto L_0x0445
        L_0x02fd:
            float r0 = r9.getFloat(r8, r3)
            r6.setScaleX(r7, r0)
            goto L_0x0445
        L_0x0306:
            float r0 = r9.getFloat(r8, r4)
            r6.setRotation(r7, r0)
            goto L_0x0445
        L_0x030f:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setRenderToHardwareTexture(r7, r0)
            goto L_0x0445
        L_0x0318:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setRemoveClippedSubviews(r7, r0)
            goto L_0x0445
        L_0x0321:
            float r0 = r9.getFloat(r8, r3)
            r6.setOpacity(r7, r0)
            goto L_0x0445
        L_0x032a:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setTouchDown(r7, r0)
            goto L_0x0445
        L_0x0333:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setTouchMove(r7, r0)
            goto L_0x0445
        L_0x033c:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setTouchEnd(r7, r0)
            goto L_0x0445
        L_0x0345:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setTouchCancel(r7, r0)
            goto L_0x0445
        L_0x034e:
            int r0 = r9.getInt(r8, r2)
            r6.setTopReachedThreshold(r7, r0)
            goto L_0x0445
        L_0x0357:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setScrollerChangeEnable(r7, r0)
            goto L_0x0445
        L_0x0360:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setPressOutable(r7, r0)
            goto L_0x0445
        L_0x0369:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setPressInable(r7, r0)
            goto L_0x0445
        L_0x0372:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setLongClickable(r7, r0)
            goto L_0x0445
        L_0x037b:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setTopReachedFlag(r7, r0)
            goto L_0x0445
        L_0x0384:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setEndReachedFlag(r7, r0)
            goto L_0x0445
        L_0x038d:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setOnInterceptTouchEvent(r7, r0)
            goto L_0x0445
        L_0x0396:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setOnInterceptPullUpEvent(r7, r0)
            goto L_0x0445
        L_0x039f:
            int r0 = r9.getInt(r8, r2)
            r6.setEndReachedThreshold(r7, r0)
            goto L_0x0445
        L_0x03a8:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setDetachToWindow(r7, r0)
            goto L_0x0445
        L_0x03b1:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setClickable(r7, r0)
            goto L_0x0445
        L_0x03ba:
            boolean r0 = r9.getBoolean(r8, r1)
            r6.setBDScrollStateDisable(r7, r0)
            goto L_0x0445
        L_0x03c3:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setAttachToWindow(r7, r0)
            goto L_0x0445
        L_0x03cc:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setNestedScrollingEnabled(r7, r0)
            goto L_0x0445
        L_0x03d5:
            java.lang.String r0 = r9.getString(r8)
            r6.setImportantForAccessibility(r7, r0)
            goto L_0x0445
        L_0x03de:
            java.lang.String r0 = r9.getString(r8)
            r6.setHref(r7, r0)
            goto L_0x0445
        L_0x03e6:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setHasPullRefresh(r7, r0)
            goto L_0x0445
        L_0x03ee:
            boolean r0 = r9.getBoolean(r8, r2)
            r6.setForceHandleVerticalSlide(r7, r0)
            goto L_0x0445
        L_0x03f6:
            int r0 = r9.getInt(r8, r2)
            r6.setBottomFillColor(r7, r0)
            goto L_0x0445
        L_0x03fe:
            float r0 = r9.getFloat(r8, r4)
            r6.setElevation(r7, r0)
            goto L_0x0445
        L_0x0406:
            com.baidu.talos.core.data.ParamMap r0 = r9.getMap(r8)
            r6.setBackgroundSize(r7, r0)
            goto L_0x0445
        L_0x040e:
            com.baidu.talos.core.data.ParamMap r0 = r9.getMap(r8)
            r6.setBackgroundRepeat(r7, r0)
            goto L_0x0445
        L_0x0416:
            com.baidu.talos.core.data.ParamMap r0 = r9.getMap(r8)
            r6.setBackgroundPosition(r7, r0)
            goto L_0x0445
        L_0x041e:
            com.baidu.talos.core.data.ParamArray r0 = r9.getArray(r8)
            r6.setBackgroundImage(r7, r0)
            goto L_0x0445
        L_0x0426:
            com.baidu.talos.core.data.Dynamic r0 = r9.getDynamic(r8)
            r6.setBackgroundColor(r7, r0)
            goto L_0x0445
        L_0x042e:
            java.lang.String r0 = r9.getString(r8)
            r6.setAccessibilityLiveRegion(r7, r0)
            goto L_0x0445
        L_0x0436:
            java.lang.String r0 = r9.getString(r8)
            r6.setAccessibilityLabel(r7, r0)
            goto L_0x0445
        L_0x043e:
            java.lang.String r0 = r9.getString(r8)
            r6.setAccessibilityComponentType(r7, r0)
        L_0x0445:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.talos.core.render.views.scroll.ReactNestedScrollViewManager$$PropsSetter.setProperty(com.baidu.talos.core.render.views.scroll.ReactNestedScrollViewManager, com.baidu.talos.core.render.views.scroll.ReactNestedScrollView, java.lang.String, com.baidu.talos.core.render.ReactStylesDiffMap):void");
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
        props.put("endFillColor", "Color");
        props.put("forceHandleVerticalSlide", DataType.BOOLEAN);
        props.put("hasPullRefresh", DataType.BOOLEAN);
        props.put("href", "String");
        props.put("importantForAccessibility", "String");
        props.put("nestedScrollingEnabled", DataType.BOOLEAN);
        props.put("onAttachedToWindow", DataType.BOOLEAN);
        props.put("onBDScrollStateDisable", DataType.BOOLEAN);
        props.put("onClick", DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_DETACHED_FROM_WINDOW, DataType.BOOLEAN);
        props.put("onEndReachedThreshold", "number");
        props.put(ViewProps.PROP_ON_INTERCEPT_PULL_UP_EVENT, DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_INTERCEPT_TOUCH_EVENT, DataType.BOOLEAN);
        props.put("onListEndReached", DataType.BOOLEAN);
        props.put("onListTopReached", DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_LONG_CLICK, DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_PRESS_IN, DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_PRESS_OUT, DataType.BOOLEAN);
        props.put("onScrollerChange", DataType.BOOLEAN);
        props.put("onTopReachedThreshold", "number");
        props.put(ViewProps.PROP_ON_TOUCH_CANCEL, DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_TOUCH_END, DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_TOUCH_MOVE, DataType.BOOLEAN);
        props.put(ViewProps.PROP_ON_TOUCH_START, DataType.BOOLEAN);
        props.put("opacity", "number");
        props.put(ReactClippingViewGroupHelper.PROP_REMOVE_CLIPPED_SUBVIEWS, DataType.BOOLEAN);
        props.put("renderToHardwareTextureAndroid", DataType.BOOLEAN);
        props.put(NadRotationPopModelKt.ROTATION, "number");
        props.put("scaleX", "number");
        props.put("scaleY", "number");
        props.put("scrollEnabled", DataType.BOOLEAN);
        props.put("scrollPerfTag", "String");
        props.put("sendMomentumEvents", DataType.BOOLEAN);
        props.put("showsVerticalScrollIndicator", DataType.BOOLEAN);
        props.put("testTag", "String");
        props.put("transform", "Array");
        props.put("transformOrigin", "String");
        props.put("translateX", "number");
        props.put("translateY", "number");
        props.put("viewTag", "String");
        props.put(ViewProps.PROP_Z_INDEX, "number");
    }
}
