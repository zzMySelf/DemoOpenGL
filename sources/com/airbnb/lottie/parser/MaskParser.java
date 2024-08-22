package com.airbnb.lottie.parser;

class MaskParser {
    private MaskParser() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0096, code lost:
        if (r5.equals("a") != false) goto L_0x009a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.Mask parse(com.airbnb.lottie.parser.moshi.JsonReader r12, com.airbnb.lottie.LottieComposition r13) throws java.io.IOException {
        /*
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r12.beginObject()
        L_0x0007:
            boolean r4 = r12.hasNext()
            if (r4 == 0) goto L_0x00d0
            java.lang.String r4 = r12.nextName()
            int r5 = r4.hashCode()
            r6 = 0
            r7 = 3
            r8 = 1
            r9 = 2
            r10 = -1
            switch(r5) {
                case 111: goto L_0x003e;
                case 3588: goto L_0x0033;
                case 104433: goto L_0x0029;
                case 3357091: goto L_0x001e;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0049
        L_0x001e:
            java.lang.String r5 = "mode"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x001d
            r5 = r6
            goto L_0x004a
        L_0x0029:
            java.lang.String r5 = "inv"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x001d
            r5 = r7
            goto L_0x004a
        L_0x0033:
            java.lang.String r5 = "pt"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x001d
            r5 = r8
            goto L_0x004a
        L_0x003e:
            java.lang.String r5 = "o"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x001d
            r5 = r9
            goto L_0x004a
        L_0x0049:
            r5 = r10
        L_0x004a:
            switch(r5) {
                case 0: goto L_0x0064;
                case 1: goto L_0x005e;
                case 2: goto L_0x0058;
                case 3: goto L_0x0052;
                default: goto L_0x004d;
            }
        L_0x004d:
            r12.skipValue()
            goto L_0x00ce
        L_0x0052:
            boolean r3 = r12.nextBoolean()
            goto L_0x00ce
        L_0x0058:
            com.airbnb.lottie.model.animatable.AnimatableIntegerValue r2 = com.airbnb.lottie.parser.AnimatableValueParser.parseInteger(r12, r13)
            goto L_0x00ce
        L_0x005e:
            com.airbnb.lottie.model.animatable.AnimatableShapeValue r1 = com.airbnb.lottie.parser.AnimatableValueParser.parseShapeData(r12, r13)
            goto L_0x00ce
        L_0x0064:
            java.lang.String r5 = r12.nextString()
            int r11 = r5.hashCode()
            switch(r11) {
                case 97: goto L_0x0090;
                case 105: goto L_0x0086;
                case 110: goto L_0x007b;
                case 115: goto L_0x0070;
                default: goto L_0x006f;
            }
        L_0x006f:
            goto L_0x0099
        L_0x0070:
            java.lang.String r6 = "s"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x006f
            r6 = r8
            goto L_0x009a
        L_0x007b:
            java.lang.String r6 = "n"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x006f
            r6 = r9
            goto L_0x009a
        L_0x0086:
            java.lang.String r6 = "i"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x006f
            r6 = r7
            goto L_0x009a
        L_0x0090:
            java.lang.String r7 = "a"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x006f
            goto L_0x009a
        L_0x0099:
            r6 = r10
        L_0x009a:
            switch(r6) {
                case 0: goto L_0x00ca;
                case 1: goto L_0x00c7;
                case 2: goto L_0x00c4;
                case 3: goto L_0x00bc;
                default: goto L_0x009d;
            }
        L_0x009d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Unknown mask mode "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r5 = r5.append(r4)
            java.lang.String r6 = ". Defaulting to Add."
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.airbnb.lottie.utils.Logger.warning(r5)
            com.airbnb.lottie.model.content.Mask$MaskMode r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_ADD
            goto L_0x00cd
        L_0x00bc:
            java.lang.String r5 = "Animation contains intersect masks. They are not supported but will be treated like add masks."
            r13.addWarning(r5)
            com.airbnb.lottie.model.content.Mask$MaskMode r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_INTERSECT
            goto L_0x00cd
        L_0x00c4:
            com.airbnb.lottie.model.content.Mask$MaskMode r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_NONE
            goto L_0x00cd
        L_0x00c7:
            com.airbnb.lottie.model.content.Mask$MaskMode r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_SUBTRACT
            goto L_0x00cd
        L_0x00ca:
            com.airbnb.lottie.model.content.Mask$MaskMode r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_ADD
        L_0x00cd:
        L_0x00ce:
            goto L_0x0007
        L_0x00d0:
            r12.endObject()
            com.airbnb.lottie.model.content.Mask r4 = new com.airbnb.lottie.model.content.Mask
            r4.<init>(r0, r1, r2, r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.MaskParser.parse(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.content.Mask");
    }
}
