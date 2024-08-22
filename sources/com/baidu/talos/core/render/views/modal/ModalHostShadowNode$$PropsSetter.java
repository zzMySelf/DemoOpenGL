package com.baidu.talos.core.render.views.modal;

import com.baidu.searchbox.datadebug.constant.DataType;
import com.baidu.talos.core.render.ViewManagerPropertyUpdater;
import com.baidu.talos.core.render.ViewProps;
import java.util.Map;

public class ModalHostShadowNode$$PropsSetter implements ViewManagerPropertyUpdater.ShadowNodeSetter<ModalHostShadowNode> {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(com.baidu.talos.core.render.views.modal.ModalHostShadowNode r11, java.lang.String r12, com.baidu.talos.core.render.ReactStylesDiffMap r13) {
        /*
            r10 = this;
            int r0 = r12.hashCode()
            r1 = 5
            r2 = 6
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            switch(r0) {
                case -1971292586: goto L_0x0238;
                case -1906103182: goto L_0x022c;
                case -1783760955: goto L_0x0221;
                case -1501175880: goto L_0x0215;
                case -1452542531: goto L_0x020b;
                case -1383228885: goto L_0x0200;
                case -1375815020: goto L_0x01f4;
                case -1290574193: goto L_0x01ea;
                case -1221029593: goto L_0x01df;
                case -1081309778: goto L_0x01d2;
                case -1063257157: goto L_0x01c7;
                case -1044792121: goto L_0x01ba;
                case -975171706: goto L_0x01ae;
                case -906066005: goto L_0x01a1;
                case -806339567: goto L_0x0194;
                case -752601676: goto L_0x0189;
                case -359890155: goto L_0x017c;
                case -296855924: goto L_0x0170;
                case -289173127: goto L_0x0163;
                case -223992013: goto L_0x0158;
                case -133587431: goto L_0x014b;
                case 115029: goto L_0x013e;
                case 3145721: goto L_0x0132;
                case 3317767: goto L_0x0125;
                case 90130308: goto L_0x0118;
                case 108511772: goto L_0x010b;
                case 113126854: goto L_0x00fe;
                case 202355100: goto L_0x00f1;
                case 400381634: goto L_0x00e4;
                case 529642498: goto L_0x00d7;
                case 713848971: goto L_0x00ca;
                case 741115130: goto L_0x00be;
                case 747804969: goto L_0x00b1;
                case 975087886: goto L_0x00a4;
                case 1031115618: goto L_0x0098;
                case 1092174483: goto L_0x008d;
                case 1261807112: goto L_0x0080;
                case 1288688105: goto L_0x0073;
                case 1343645351: goto L_0x0066;
                case 1389864897: goto L_0x005a;
                case 1431421764: goto L_0x004d;
                case 1743739820: goto L_0x0041;
                case 1744216035: goto L_0x0035;
                case 1767100401: goto L_0x002a;
                case 1860657097: goto L_0x001d;
                case 1970934485: goto L_0x0010;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0242
        L_0x0010:
            java.lang.String r0 = "marginLeft"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 24
            goto L_0x0243
        L_0x001d:
            java.lang.String r0 = "justifyContent"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 19
            goto L_0x0243
        L_0x002a:
            java.lang.String r0 = "alignSelf"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = r5
            goto L_0x0243
        L_0x0035:
            java.lang.String r0 = "flexWrap"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 17
            goto L_0x0243
        L_0x0041:
            java.lang.String r0 = "flexGrow"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 15
            goto L_0x0243
        L_0x004d:
            java.lang.String r0 = "marginVertical"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 27
            goto L_0x0243
        L_0x005a:
            java.lang.String r0 = "fillRootWidth"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 11
            goto L_0x0243
        L_0x0066:
            java.lang.String r0 = "paddingVertical"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 40
            goto L_0x0243
        L_0x0073:
            java.lang.String r0 = "onLayout"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 32
            goto L_0x0243
        L_0x0080:
            java.lang.String r0 = "patchProps"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 41
            goto L_0x0243
        L_0x008d:
            java.lang.String r0 = "aspectRatio"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = r4
            goto L_0x0243
        L_0x0098:
            java.lang.String r0 = "flexShrink"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 16
            goto L_0x0243
        L_0x00a4:
            java.lang.String r0 = "marginRight"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 25
            goto L_0x0243
        L_0x00b1:
            java.lang.String r0 = "position"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 42
            goto L_0x0243
        L_0x00be:
            java.lang.String r0 = "borderWidth"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 8
            goto L_0x0243
        L_0x00ca:
            java.lang.String r0 = "paddingRight"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 38
            goto L_0x0243
        L_0x00d7:
            java.lang.String r0 = "overflow"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 33
            goto L_0x0243
        L_0x00e4:
            java.lang.String r0 = "maxWidth"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 29
            goto L_0x0243
        L_0x00f1:
            java.lang.String r0 = "paddingBottom"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 35
            goto L_0x0243
        L_0x00fe:
            java.lang.String r0 = "width"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 45
            goto L_0x0243
        L_0x010b:
            java.lang.String r0 = "right"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 43
            goto L_0x0243
        L_0x0118:
            java.lang.String r0 = "paddingTop"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 39
            goto L_0x0243
        L_0x0125:
            java.lang.String r0 = "left"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 20
            goto L_0x0243
        L_0x0132:
            java.lang.String r0 = "flex"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 12
            goto L_0x0243
        L_0x013e:
            java.lang.String r0 = "top"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 44
            goto L_0x0243
        L_0x014b:
            java.lang.String r0 = "minHeight"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 30
            goto L_0x0243
        L_0x0158:
            java.lang.String r0 = "borderLeftWidth"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = r1
            goto L_0x0243
        L_0x0163:
            java.lang.String r0 = "marginBottom"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 22
            goto L_0x0243
        L_0x0170:
            java.lang.String r0 = "fillRootHeight"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 10
            goto L_0x0243
        L_0x017c:
            java.lang.String r0 = "paddingHorizontal"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 36
            goto L_0x0243
        L_0x0189:
            java.lang.String r0 = "alignContent"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = r7
            goto L_0x0243
        L_0x0194:
            java.lang.String r0 = "padding"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 34
            goto L_0x0243
        L_0x01a1:
            java.lang.String r0 = "maxHeight"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 28
            goto L_0x0243
        L_0x01ae:
            java.lang.String r0 = "flexDirection"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 14
            goto L_0x0243
        L_0x01ba:
            java.lang.String r0 = "marginTop"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 26
            goto L_0x0243
        L_0x01c7:
            java.lang.String r0 = "alignItems"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = r6
            goto L_0x0243
        L_0x01d2:
            java.lang.String r0 = "margin"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 21
            goto L_0x0243
        L_0x01df:
            java.lang.String r0 = "height"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 18
            goto L_0x0243
        L_0x01ea:
            java.lang.String r0 = "borderBottomWidth"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = r3
            goto L_0x0243
        L_0x01f4:
            java.lang.String r0 = "minWidth"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 31
            goto L_0x0243
        L_0x0200:
            java.lang.String r0 = "bottom"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 9
            goto L_0x0243
        L_0x020b:
            java.lang.String r0 = "borderTopWidth"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 7
            goto L_0x0243
        L_0x0215:
            java.lang.String r0 = "paddingLeft"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 37
            goto L_0x0243
        L_0x0221:
            java.lang.String r0 = "flexBasis"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 13
            goto L_0x0243
        L_0x022c:
            java.lang.String r0 = "marginHorizontal"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = 23
            goto L_0x0243
        L_0x0238:
            java.lang.String r0 = "borderRightWidth"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x000e
            r0 = r2
            goto L_0x0243
        L_0x0242:
            r0 = -1
        L_0x0243:
            r8 = 0
            r9 = 2143289344(0x7fc00000, float:NaN)
            switch(r0) {
                case 0: goto L_0x03d4;
                case 1: goto L_0x03cc;
                case 2: goto L_0x03c4;
                case 3: goto L_0x03bc;
                case 4: goto L_0x03b4;
                case 5: goto L_0x03ac;
                case 6: goto L_0x03a4;
                case 7: goto L_0x039c;
                case 8: goto L_0x0394;
                case 9: goto L_0x038c;
                case 10: goto L_0x0384;
                case 11: goto L_0x037c;
                case 12: goto L_0x0374;
                case 13: goto L_0x036b;
                case 14: goto L_0x0362;
                case 15: goto L_0x0359;
                case 16: goto L_0x0350;
                case 17: goto L_0x0347;
                case 18: goto L_0x033e;
                case 19: goto L_0x0335;
                case 20: goto L_0x032c;
                case 21: goto L_0x0323;
                case 22: goto L_0x031a;
                case 23: goto L_0x0311;
                case 24: goto L_0x0308;
                case 25: goto L_0x02ff;
                case 26: goto L_0x02f6;
                case 27: goto L_0x02ed;
                case 28: goto L_0x02e4;
                case 29: goto L_0x02db;
                case 30: goto L_0x02d2;
                case 31: goto L_0x02c9;
                case 32: goto L_0x02c0;
                case 33: goto L_0x02b7;
                case 34: goto L_0x02ae;
                case 35: goto L_0x02a5;
                case 36: goto L_0x029c;
                case 37: goto L_0x0293;
                case 38: goto L_0x028a;
                case 39: goto L_0x0281;
                case 40: goto L_0x0278;
                case 41: goto L_0x026f;
                case 42: goto L_0x0266;
                case 43: goto L_0x025d;
                case 44: goto L_0x0254;
                case 45: goto L_0x024b;
                default: goto L_0x0249;
            }
        L_0x0249:
            goto L_0x03dc
        L_0x024b:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setWidth(r0)
            goto L_0x03dc
        L_0x0254:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setPositionValues(r5, r0)
            goto L_0x03dc
        L_0x025d:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setPositionValues(r6, r0)
            goto L_0x03dc
        L_0x0266:
            java.lang.String r0 = r13.getString(r12)
            r11.setPosition(r0)
            goto L_0x03dc
        L_0x026f:
            com.baidu.talos.core.data.ParamArray r0 = r13.getArray(r12)
            r11.setPatchProps(r0)
            goto L_0x03dc
        L_0x0278:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setPaddings(r6, r0)
            goto L_0x03dc
        L_0x0281:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setPaddings(r1, r0)
            goto L_0x03dc
        L_0x028a:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setPaddings(r3, r0)
            goto L_0x03dc
        L_0x0293:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setPaddings(r4, r0)
            goto L_0x03dc
        L_0x029c:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setPaddings(r5, r0)
            goto L_0x03dc
        L_0x02a5:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setPaddings(r2, r0)
            goto L_0x03dc
        L_0x02ae:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setPaddings(r7, r0)
            goto L_0x03dc
        L_0x02b7:
            java.lang.String r0 = r13.getString(r12)
            r11.setOverflow(r0)
            goto L_0x03dc
        L_0x02c0:
            boolean r0 = r13.getBoolean(r12, r7)
            r11.setShouldNotifyOnLayout(r0)
            goto L_0x03dc
        L_0x02c9:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setMinWidth(r0)
            goto L_0x03dc
        L_0x02d2:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setMinHeight(r0)
            goto L_0x03dc
        L_0x02db:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setMaxWidth(r0)
            goto L_0x03dc
        L_0x02e4:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setMaxHeight(r0)
            goto L_0x03dc
        L_0x02ed:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setMargins(r6, r0)
            goto L_0x03dc
        L_0x02f6:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setMargins(r1, r0)
            goto L_0x03dc
        L_0x02ff:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setMargins(r3, r0)
            goto L_0x03dc
        L_0x0308:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setMargins(r4, r0)
            goto L_0x03dc
        L_0x0311:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setMargins(r5, r0)
            goto L_0x03dc
        L_0x031a:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setMargins(r2, r0)
            goto L_0x03dc
        L_0x0323:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setMargins(r7, r0)
            goto L_0x03dc
        L_0x032c:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setPositionValues(r7, r0)
            goto L_0x03dc
        L_0x0335:
            java.lang.String r0 = r13.getString(r12)
            r11.setJustifyContent(r0)
            goto L_0x03dc
        L_0x033e:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setHeight(r0)
            goto L_0x03dc
        L_0x0347:
            java.lang.String r0 = r13.getString(r12)
            r11.setFlexWrap(r0)
            goto L_0x03dc
        L_0x0350:
            float r0 = r13.getFloat(r12, r8)
            r11.setFlexShrink(r0)
            goto L_0x03dc
        L_0x0359:
            float r0 = r13.getFloat(r12, r8)
            r11.setFlexGrow(r0)
            goto L_0x03dc
        L_0x0362:
            java.lang.String r0 = r13.getString(r12)
            r11.setFlexDirection(r0)
            goto L_0x03dc
        L_0x036b:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setFlexBasis(r0)
            goto L_0x03dc
        L_0x0374:
            float r0 = r13.getFloat(r12, r8)
            r11.setFlex(r0)
            goto L_0x03dc
        L_0x037c:
            boolean r0 = r13.getBoolean(r12, r7)
            r11.setShouldFillRootWidth(r0)
            goto L_0x03dc
        L_0x0384:
            boolean r0 = r13.getBoolean(r12, r7)
            r11.setShouldFillRootHeight(r0)
            goto L_0x03dc
        L_0x038c:
            com.baidu.talos.core.data.Dynamic r0 = r13.getDynamic(r12)
            r11.setPositionValues(r4, r0)
            goto L_0x03dc
        L_0x0394:
            float r0 = r13.getFloat(r12, r9)
            r11.setBorderWidths(r7, r0)
            goto L_0x03dc
        L_0x039c:
            float r0 = r13.getFloat(r12, r9)
            r11.setBorderWidths(r4, r0)
            goto L_0x03dc
        L_0x03a4:
            float r0 = r13.getFloat(r12, r9)
            r11.setBorderWidths(r5, r0)
            goto L_0x03dc
        L_0x03ac:
            float r0 = r13.getFloat(r12, r9)
            r11.setBorderWidths(r6, r0)
            goto L_0x03dc
        L_0x03b4:
            float r0 = r13.getFloat(r12, r9)
            r11.setBorderWidths(r3, r0)
            goto L_0x03dc
        L_0x03bc:
            float r0 = r13.getFloat(r12, r9)
            r11.setAspectRatio(r0)
            goto L_0x03dc
        L_0x03c4:
            java.lang.String r0 = r13.getString(r12)
            r11.setAlignSelf(r0)
            goto L_0x03dc
        L_0x03cc:
            java.lang.String r0 = r13.getString(r12)
            r11.setAlignItems(r0)
            goto L_0x03dc
        L_0x03d4:
            java.lang.String r0 = r13.getString(r12)
            r11.setAlignContent(r0)
        L_0x03dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.talos.core.render.views.modal.ModalHostShadowNode$$PropsSetter.setProperty(com.baidu.talos.core.render.views.modal.ModalHostShadowNode, java.lang.String, com.baidu.talos.core.render.ReactStylesDiffMap):void");
    }

    public void getProperties(Map<String, String> props) {
        props.put(ViewProps.ALIGN_CONTENT, "String");
        props.put(ViewProps.ALIGN_ITEMS, "String");
        props.put(ViewProps.ALIGN_SELF, "String");
        props.put(ViewProps.ASPECT_RATIO, "number");
        props.put(ViewProps.BORDER_BOTTOM_WIDTH, "number");
        props.put(ViewProps.BORDER_LEFT_WIDTH, "number");
        props.put(ViewProps.BORDER_RIGHT_WIDTH, "number");
        props.put(ViewProps.BORDER_TOP_WIDTH, "number");
        props.put("borderWidth", "number");
        props.put("bottom", "Dynamic");
        props.put("fillRootHeight", DataType.BOOLEAN);
        props.put("fillRootWidth", DataType.BOOLEAN);
        props.put("flex", "number");
        props.put(ViewProps.FLEX_BASIS, "Dynamic");
        props.put(ViewProps.FLEX_DIRECTION, "String");
        props.put(ViewProps.FLEX_GROW, "number");
        props.put(ViewProps.FLEX_SHRINK, "number");
        props.put(ViewProps.FLEX_WRAP, "String");
        props.put("height", "Dynamic");
        props.put(ViewProps.JUSTIFY_CONTENT, "String");
        props.put("left", "Dynamic");
        props.put("margin", "Dynamic");
        props.put(ViewProps.MARGIN_BOTTOM, "Dynamic");
        props.put(ViewProps.MARGIN_HORIZONTAL, "Dynamic");
        props.put(ViewProps.MARGIN_LEFT, "Dynamic");
        props.put(ViewProps.MARGIN_RIGHT, "Dynamic");
        props.put(ViewProps.MARGIN_TOP, "Dynamic");
        props.put(ViewProps.MARGIN_VERTICAL, "Dynamic");
        props.put(ViewProps.MAX_HEIGHT, "Dynamic");
        props.put(ViewProps.MAX_WIDTH, "Dynamic");
        props.put("minHeight", "Dynamic");
        props.put("minWidth", "Dynamic");
        props.put("onLayout", DataType.BOOLEAN);
        props.put(ViewProps.OVERFLOW, "String");
        props.put("padding", "Dynamic");
        props.put(ViewProps.PADDING_BOTTOM, "Dynamic");
        props.put(ViewProps.PADDING_HORIZONTAL, "Dynamic");
        props.put(ViewProps.PADDING_LEFT, "Dynamic");
        props.put(ViewProps.PADDING_RIGHT, "Dynamic");
        props.put(ViewProps.PADDING_TOP, "Dynamic");
        props.put(ViewProps.PADDING_VERTICAL, "Dynamic");
        props.put(ViewProps.KEY_PATCH_PROPS, "Array");
        props.put("position", "String");
        props.put("right", "Dynamic");
        props.put("top", "Dynamic");
        props.put("width", "Dynamic");
    }
}
