package com.google.protobuf;

import com.google.common.base.Ascii;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

public final class ArrayDecoders {

    /* renamed from: com.google.protobuf.ArrayDecoders$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.WireFormat$FieldType[] r0 = com.google.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.AnonymousClass1.<clinit>():void");
        }
    }

    public static int decodeBoolList(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i3, registers);
        booleanArrayList.addBoolean(registers.long1 != 0);
        while (decodeVarint64 < i4) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i2 != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            booleanArrayList.addBoolean(registers.long1 != 0);
        }
        return decodeVarint64;
    }

    public static int decodeBytes(byte[] bArr, int i2, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i3 = registers.int1;
        if (i3 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i3 > bArr.length - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        } else if (i3 == 0) {
            registers.object1 = ByteString.EMPTY;
            return decodeVarint32;
        } else {
            registers.object1 = ByteString.copyFrom(bArr, decodeVarint32, i3);
            return decodeVarint32 + i3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x004d A[EDGE_INSN: B:30:0x004d->B:22:0x004d ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int decodeBytesList(int r2, byte[] r3, int r4, int r5, com.google.protobuf.Internal.ProtobufList<?> r6, com.google.protobuf.ArrayDecoders.Registers r7) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r4 = decodeVarint32(r3, r4, r7)
            int r0 = r7.int1
            if (r0 < 0) goto L_0x0053
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x004e
            if (r0 != 0) goto L_0x0014
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L_0x001c
        L_0x0014:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
        L_0x001b:
            int r4 = r4 + r0
        L_0x001c:
            if (r4 >= r5) goto L_0x004d
            int r0 = decodeVarint32(r3, r4, r7)
            int r1 = r7.int1
            if (r2 == r1) goto L_0x0027
            goto L_0x004d
        L_0x0027:
            int r4 = decodeVarint32(r3, r0, r7)
            int r0 = r7.int1
            if (r0 < 0) goto L_0x0048
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x0043
            if (r0 != 0) goto L_0x003b
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L_0x001c
        L_0x003b:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
            goto L_0x001b
        L_0x0043:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r2
        L_0x0048:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r2
        L_0x004d:
            return r4
        L_0x004e:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r2
        L_0x0053:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.decodeBytesList(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    public static double decodeDouble(byte[] bArr, int i2) {
        return Double.longBitsToDouble(decodeFixed64(bArr, i2));
    }

    public static int decodeDoubleList(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        doubleArrayList.addDouble(decodeDouble(bArr, i3));
        int i5 = i3 + 8;
        while (i5 < i4) {
            int decodeVarint32 = decodeVarint32(bArr, i5, registers);
            if (i2 != registers.int1) {
                break;
            }
            doubleArrayList.addDouble(decodeDouble(bArr, decodeVarint32));
            i5 = decodeVarint32 + 8;
        }
        return i5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01f4, code lost:
        r9 = r9 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01ff, code lost:
        r9 = r9 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int decodeExtension(int r7, byte[] r8, int r9, int r10, com.google.protobuf.GeneratedMessageLite.ExtendableMessage<?, ?> r11, com.google.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?> r12, com.google.protobuf.UnknownFieldSchema<com.google.protobuf.UnknownFieldSetLite, com.google.protobuf.UnknownFieldSetLite> r13, com.google.protobuf.ArrayDecoders.Registers r14) throws java.io.IOException {
        /*
            com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor> r0 = r11.extensions
            int r7 = r7 >>> 3
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r1 = r12.descriptor
            boolean r1 = r1.isRepeated()
            r2 = 0
            if (r1 == 0) goto L_0x00fb
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r1 = r12.descriptor
            boolean r1 = r1.isPacked()
            if (r1 == 0) goto L_0x00fb
            int[] r10 = com.google.protobuf.ArrayDecoders.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType
            com.google.protobuf.WireFormat$FieldType r1 = r12.getLiteType()
            int r1 = r1.ordinal()
            r10 = r10[r1]
            switch(r10) {
                case 1: goto L_0x00eb;
                case 2: goto L_0x00db;
                case 3: goto L_0x00cb;
                case 4: goto L_0x00cb;
                case 5: goto L_0x00bb;
                case 6: goto L_0x00bb;
                case 7: goto L_0x00ab;
                case 8: goto L_0x00ab;
                case 9: goto L_0x009b;
                case 10: goto L_0x009b;
                case 11: goto L_0x008b;
                case 12: goto L_0x007b;
                case 13: goto L_0x006b;
                case 14: goto L_0x0041;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Type cannot be packed: "
            r8.append(r9)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            com.google.protobuf.WireFormat$FieldType r9 = r9.getLiteType()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0041:
            com.google.protobuf.IntArrayList r10 = new com.google.protobuf.IntArrayList
            r10.<init>()
            int r8 = decodePackedVarint32List(r8, r9, r10, r14)
            com.google.protobuf.UnknownFieldSetLite r9 = r11.unknownFields
            com.google.protobuf.UnknownFieldSetLite r14 = com.google.protobuf.UnknownFieldSetLite.getDefaultInstance()
            if (r9 != r14) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r2 = r9
        L_0x0054:
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            com.google.protobuf.Internal$EnumLiteMap r9 = r9.getEnumType()
            java.lang.Object r7 = com.google.protobuf.SchemaUtil.filterUnknownEnumList((int) r7, (java.util.List<java.lang.Integer>) r10, (com.google.protobuf.Internal.EnumLiteMap<?>) r9, r2, r13)
            com.google.protobuf.UnknownFieldSetLite r7 = (com.google.protobuf.UnknownFieldSetLite) r7
            if (r7 == 0) goto L_0x0064
            r11.unknownFields = r7
        L_0x0064:
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.descriptor
            r0.setField(r7, r10)
            goto L_0x0234
        L_0x006b:
            com.google.protobuf.LongArrayList r7 = new com.google.protobuf.LongArrayList
            r7.<init>()
            int r8 = decodePackedSInt64List(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            goto L_0x0234
        L_0x007b:
            com.google.protobuf.IntArrayList r7 = new com.google.protobuf.IntArrayList
            r7.<init>()
            int r8 = decodePackedSInt32List(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            goto L_0x0234
        L_0x008b:
            com.google.protobuf.BooleanArrayList r7 = new com.google.protobuf.BooleanArrayList
            r7.<init>()
            int r8 = decodePackedBoolList(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            goto L_0x0234
        L_0x009b:
            com.google.protobuf.IntArrayList r7 = new com.google.protobuf.IntArrayList
            r7.<init>()
            int r8 = decodePackedFixed32List(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            goto L_0x0234
        L_0x00ab:
            com.google.protobuf.LongArrayList r7 = new com.google.protobuf.LongArrayList
            r7.<init>()
            int r8 = decodePackedFixed64List(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            goto L_0x0234
        L_0x00bb:
            com.google.protobuf.IntArrayList r7 = new com.google.protobuf.IntArrayList
            r7.<init>()
            int r8 = decodePackedVarint32List(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            goto L_0x0234
        L_0x00cb:
            com.google.protobuf.LongArrayList r7 = new com.google.protobuf.LongArrayList
            r7.<init>()
            int r8 = decodePackedVarint64List(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            goto L_0x0234
        L_0x00db:
            com.google.protobuf.FloatArrayList r7 = new com.google.protobuf.FloatArrayList
            r7.<init>()
            int r8 = decodePackedFloatList(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            goto L_0x0234
        L_0x00eb:
            com.google.protobuf.DoubleArrayList r7 = new com.google.protobuf.DoubleArrayList
            r7.<init>()
            int r8 = decodePackedDoubleList(r8, r9, r7, r14)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            goto L_0x0234
        L_0x00fb:
            com.google.protobuf.WireFormat$FieldType r1 = r12.getLiteType()
            com.google.protobuf.WireFormat$FieldType r3 = com.google.protobuf.WireFormat.FieldType.ENUM
            if (r1 != r3) goto L_0x0131
            int r9 = decodeVarint32(r8, r9, r14)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r12.descriptor
            com.google.protobuf.Internal$EnumLiteMap r8 = r8.getEnumType()
            int r10 = r14.int1
            com.google.protobuf.Internal$EnumLite r8 = r8.findValueByNumber(r10)
            if (r8 != 0) goto L_0x0129
            com.google.protobuf.UnknownFieldSetLite r8 = r11.unknownFields
            com.google.protobuf.UnknownFieldSetLite r10 = com.google.protobuf.UnknownFieldSetLite.getDefaultInstance()
            if (r8 != r10) goto L_0x0123
            com.google.protobuf.UnknownFieldSetLite r8 = com.google.protobuf.UnknownFieldSetLite.newInstance()
            r11.unknownFields = r8
        L_0x0123:
            int r10 = r14.int1
            com.google.protobuf.SchemaUtil.storeUnknownEnum(r7, r10, r8, r13)
            return r9
        L_0x0129:
            int r7 = r14.int1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0201
        L_0x0131:
            int[] r11 = com.google.protobuf.ArrayDecoders.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType
            com.google.protobuf.WireFormat$FieldType r13 = r12.getLiteType()
            int r13 = r13.ordinal()
            r11 = r11[r13]
            switch(r11) {
                case 1: goto L_0x01f7;
                case 2: goto L_0x01ec;
                case 3: goto L_0x01e1;
                case 4: goto L_0x01e1;
                case 5: goto L_0x01d6;
                case 6: goto L_0x01d6;
                case 7: goto L_0x01cd;
                case 8: goto L_0x01cd;
                case 9: goto L_0x01c4;
                case 10: goto L_0x01c4;
                case 11: goto L_0x01b0;
                case 12: goto L_0x01a1;
                case 13: goto L_0x0192;
                case 14: goto L_0x018a;
                case 15: goto L_0x0182;
                case 16: goto L_0x017a;
                case 17: goto L_0x015a;
                case 18: goto L_0x0142;
                default: goto L_0x0140;
            }
        L_0x0140:
            goto L_0x0201
        L_0x0142:
            com.google.protobuf.Protobuf r7 = com.google.protobuf.Protobuf.getInstance()
            com.google.protobuf.MessageLite r11 = r12.getMessageDefaultInstance()
            java.lang.Class r11 = r11.getClass()
            com.google.protobuf.Schema r7 = r7.schemaFor(r11)
            int r9 = decodeMessageField(r7, r8, r9, r10, r14)
            java.lang.Object r2 = r14.object1
            goto L_0x0201
        L_0x015a:
            int r7 = r7 << 3
            r5 = r7 | 4
            com.google.protobuf.Protobuf r7 = com.google.protobuf.Protobuf.getInstance()
            com.google.protobuf.MessageLite r11 = r12.getMessageDefaultInstance()
            java.lang.Class r11 = r11.getClass()
            com.google.protobuf.Schema r1 = r7.schemaFor(r11)
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r14
            int r9 = decodeGroupField(r1, r2, r3, r4, r5, r6)
            java.lang.Object r2 = r14.object1
            goto L_0x0201
        L_0x017a:
            int r9 = decodeString(r8, r9, r14)
            java.lang.Object r2 = r14.object1
            goto L_0x0201
        L_0x0182:
            int r9 = decodeBytes(r8, r9, r14)
            java.lang.Object r2 = r14.object1
            goto L_0x0201
        L_0x018a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Shouldn't reach here."
            r7.<init>(r8)
            throw r7
        L_0x0192:
            int r9 = decodeVarint64(r8, r9, r14)
            long r7 = r14.long1
            long r7 = com.google.protobuf.CodedInputStream.decodeZigZag64(r7)
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            goto L_0x0201
        L_0x01a1:
            int r9 = decodeVarint32(r8, r9, r14)
            int r7 = r14.int1
            int r7 = com.google.protobuf.CodedInputStream.decodeZigZag32(r7)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0201
        L_0x01b0:
            int r9 = decodeVarint64(r8, r9, r14)
            long r7 = r14.long1
            r10 = 0
            int r13 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r13 == 0) goto L_0x01be
            r7 = 1
            goto L_0x01bf
        L_0x01be:
            r7 = 0
        L_0x01bf:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r7)
            goto L_0x0201
        L_0x01c4:
            int r7 = decodeFixed32(r8, r9)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x01f4
        L_0x01cd:
            long r7 = decodeFixed64(r8, r9)
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            goto L_0x01ff
        L_0x01d6:
            int r9 = decodeVarint32(r8, r9, r14)
            int r7 = r14.int1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0201
        L_0x01e1:
            int r9 = decodeVarint64(r8, r9, r14)
            long r7 = r14.long1
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            goto L_0x0201
        L_0x01ec:
            float r7 = decodeFloat(r8, r9)
            java.lang.Float r2 = java.lang.Float.valueOf(r7)
        L_0x01f4:
            int r9 = r9 + 4
            goto L_0x0201
        L_0x01f7:
            double r7 = decodeDouble(r8, r9)
            java.lang.Double r2 = java.lang.Double.valueOf(r7)
        L_0x01ff:
            int r9 = r9 + 8
        L_0x0201:
            boolean r7 = r12.isRepeated()
            if (r7 == 0) goto L_0x020d
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.descriptor
            r0.addRepeatedField(r7, r2)
            goto L_0x0233
        L_0x020d:
            int[] r7 = com.google.protobuf.ArrayDecoders.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType
            com.google.protobuf.WireFormat$FieldType r8 = r12.getLiteType()
            int r8 = r8.ordinal()
            r7 = r7[r8]
            r8 = 17
            if (r7 == r8) goto L_0x0222
            r8 = 18
            if (r7 == r8) goto L_0x0222
            goto L_0x022e
        L_0x0222:
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.descriptor
            java.lang.Object r7 = r0.getField(r7)
            if (r7 == 0) goto L_0x022e
            java.lang.Object r2 = com.google.protobuf.Internal.mergeMessage(r7, r2)
        L_0x022e:
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.descriptor
            r0.setField(r7, r2)
        L_0x0233:
            r8 = r9
        L_0x0234:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.decodeExtension(int, byte[], int, int, com.google.protobuf.GeneratedMessageLite$ExtendableMessage, com.google.protobuf.GeneratedMessageLite$GeneratedExtension, com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    public static int decodeExtensionOrUnknownField(int i2, byte[] bArr, int i3, int i4, Object obj, MessageLite messageLite, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        GeneratedMessageLite.GeneratedExtension findLiteExtensionByNumber = registers.extensionRegistry.findLiteExtensionByNumber(messageLite, i2 >>> 3);
        if (findLiteExtensionByNumber == null) {
            return decodeUnknownField(i2, bArr, i3, i4, MessageSchema.getMutableUnknownFields(obj), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.ensureExtensionsAreMutable();
        return decodeExtension(i2, bArr, i3, i4, extendableMessage, findLiteExtensionByNumber, unknownFieldSchema, registers);
    }

    public static int decodeFixed32(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << Ascii.CAN) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << Ascii.DLE);
    }

    public static int decodeFixed32List(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        intArrayList.addInt(decodeFixed32(bArr, i3));
        int i5 = i3 + 4;
        while (i5 < i4) {
            int decodeVarint32 = decodeVarint32(bArr, i5, registers);
            if (i2 != registers.int1) {
                break;
            }
            intArrayList.addInt(decodeFixed32(bArr, decodeVarint32));
            i5 = decodeVarint32 + 4;
        }
        return i5;
    }

    public static long decodeFixed64(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    public static int decodeFixed64List(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        longArrayList.addLong(decodeFixed64(bArr, i3));
        int i5 = i3 + 8;
        while (i5 < i4) {
            int decodeVarint32 = decodeVarint32(bArr, i5, registers);
            if (i2 != registers.int1) {
                break;
            }
            longArrayList.addLong(decodeFixed64(bArr, decodeVarint32));
            i5 = decodeVarint32 + 8;
        }
        return i5;
    }

    public static float decodeFloat(byte[] bArr, int i2) {
        return Float.intBitsToFloat(decodeFixed32(bArr, i2));
    }

    public static int decodeFloatList(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        floatArrayList.addFloat(decodeFloat(bArr, i3));
        int i5 = i3 + 4;
        while (i5 < i4) {
            int decodeVarint32 = decodeVarint32(bArr, i5, registers);
            if (i2 != registers.int1) {
                break;
            }
            floatArrayList.addFloat(decodeFloat(bArr, decodeVarint32));
            i5 = decodeVarint32 + 4;
        }
        return i5;
    }

    public static int decodeGroupField(Schema schema, byte[] bArr, int i2, int i3, int i4, Registers registers) throws IOException {
        MessageSchema messageSchema = (MessageSchema) schema;
        Object newInstance = messageSchema.newInstance();
        int parseProto2Message = messageSchema.parseProto2Message(newInstance, bArr, i2, i3, i4, registers);
        messageSchema.makeImmutable(newInstance);
        registers.object1 = newInstance;
        return parseProto2Message;
    }

    public static int decodeGroupList(Schema schema, int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int i5 = (i2 & -8) | 4;
        int decodeGroupField = decodeGroupField(schema, bArr, i3, i4, i5, registers);
        protobufList.add(registers.object1);
        while (decodeGroupField < i4) {
            int decodeVarint32 = decodeVarint32(bArr, decodeGroupField, registers);
            if (i2 != registers.int1) {
                break;
            }
            decodeGroupField = decodeGroupField(schema, bArr, decodeVarint32, i4, i5, registers);
            protobufList.add(registers.object1);
        }
        return decodeGroupField;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int decodeMessageField(com.google.protobuf.Schema r6, byte[] r7, int r8, int r9, com.google.protobuf.ArrayDecoders.Registers r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = decodeVarint32(r8, r7, r0, r10)
            int r8 = r10.int1
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.newInstance()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.mergeFrom(r1, r2, r3, r4, r5)
            r6.makeImmutable(r9)
            r10.object1 = r9
            return r8
        L_0x0025:
            com.google.protobuf.InvalidProtocolBufferException r6 = com.google.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.decodeMessageField(com.google.protobuf.Schema, byte[], int, int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    public static int decodeMessageList(Schema<?> schema, int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int decodeMessageField = decodeMessageField(schema, bArr, i3, i4, registers);
        protobufList.add(registers.object1);
        while (decodeMessageField < i4) {
            int decodeVarint32 = decodeVarint32(bArr, decodeMessageField, registers);
            if (i2 != registers.int1) {
                break;
            }
            decodeMessageField = decodeMessageField(schema, bArr, decodeVarint32, i4, registers);
            protobufList.add(registers.object1);
        }
        return decodeMessageField;
    }

    public static int decodePackedBoolList(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i3 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i3) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            booleanArrayList.addBoolean(registers.long1 != 0);
        }
        if (decodeVarint32 == i3) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedDoubleList(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i3 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i3) {
            doubleArrayList.addDouble(decodeDouble(bArr, decodeVarint32));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == i3) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed32List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i3 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i3) {
            intArrayList.addInt(decodeFixed32(bArr, decodeVarint32));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == i3) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed64List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i3 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i3) {
            longArrayList.addLong(decodeFixed64(bArr, decodeVarint32));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == i3) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFloatList(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i3 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i3) {
            floatArrayList.addFloat(decodeFloat(bArr, decodeVarint32));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == i3) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt32List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i3 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i3) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        if (decodeVarint32 == i3) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt64List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i3 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i3) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        if (decodeVarint32 == i3) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint32List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i3 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i3) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, registers);
            intArrayList.addInt(registers.int1);
        }
        if (decodeVarint32 == i3) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint64List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i3 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i3) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        if (decodeVarint32 == i3) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodeSInt32List(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i3, registers);
        intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        while (decodeVarint32 < i4) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (i2 != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        return decodeVarint32;
    }

    public static int decodeSInt64List(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i3, registers);
        longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        while (decodeVarint64 < i4) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i2 != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        return decodeVarint64;
    }

    public static int decodeString(byte[] bArr, int i2, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i3 = registers.int1;
        if (i3 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i3 == 0) {
            registers.object1 = "";
            return decodeVarint32;
        } else {
            registers.object1 = new String(bArr, decodeVarint32, i3, Internal.UTF_8);
            return decodeVarint32 + i3;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[EDGE_INSN: B:21:0x0044->B:17:0x0044 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    public static int decodeStringList(int r4, byte[] r5, int r6, int r7, com.google.protobuf.Internal.ProtobufList<?> r8, com.google.protobuf.ArrayDecoders.Registers r9) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r6 = decodeVarint32(r5, r6, r9)
            int r0 = r9.int1
            if (r0 < 0) goto L_0x0045
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r8.add(r1)
            goto L_0x001b
        L_0x0010:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.Internal.UTF_8
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
        L_0x001a:
            int r6 = r6 + r0
        L_0x001b:
            if (r6 >= r7) goto L_0x0044
            int r0 = decodeVarint32(r5, r6, r9)
            int r2 = r9.int1
            if (r4 == r2) goto L_0x0026
            goto L_0x0044
        L_0x0026:
            int r6 = decodeVarint32(r5, r0, r9)
            int r0 = r9.int1
            if (r0 < 0) goto L_0x003f
            if (r0 != 0) goto L_0x0034
            r8.add(r1)
            goto L_0x001b
        L_0x0034:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.Internal.UTF_8
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
            goto L_0x001a
        L_0x003f:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r4
        L_0x0044:
            return r6
        L_0x0045:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.decodeStringList(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        r2 = r7 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (com.google.protobuf.Utf8.isValidUtf8(r6, r7, r2) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        r9.add(new java.lang.String(r6, r7, r0, com.google.protobuf.Internal.UTF_8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059 A[EDGE_INSN: B:28:0x0059->B:23:0x0059 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int decodeStringListRequireUtf8(int r5, byte[] r6, int r7, int r8, com.google.protobuf.Internal.ProtobufList<?> r9, com.google.protobuf.ArrayDecoders.Registers r10) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r7 = decodeVarint32(r6, r7, r10)
            int r0 = r10.int1
            if (r0 < 0) goto L_0x005f
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r9.add(r1)
            goto L_0x0023
        L_0x0010:
            int r2 = r7 + r0
            boolean r3 = com.google.protobuf.Utf8.isValidUtf8(r6, r7, r2)
            if (r3 == 0) goto L_0x005a
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.protobuf.Internal.UTF_8
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
        L_0x0022:
            r7 = r2
        L_0x0023:
            if (r7 >= r8) goto L_0x0059
            int r0 = decodeVarint32(r6, r7, r10)
            int r2 = r10.int1
            if (r5 == r2) goto L_0x002e
            goto L_0x0059
        L_0x002e:
            int r7 = decodeVarint32(r6, r0, r10)
            int r0 = r10.int1
            if (r0 < 0) goto L_0x0054
            if (r0 != 0) goto L_0x003c
            r9.add(r1)
            goto L_0x0023
        L_0x003c:
            int r2 = r7 + r0
            boolean r3 = com.google.protobuf.Utf8.isValidUtf8(r6, r7, r2)
            if (r3 == 0) goto L_0x004f
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.protobuf.Internal.UTF_8
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
            goto L_0x0022
        L_0x004f:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.invalidUtf8()
            throw r5
        L_0x0054:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r5
        L_0x0059:
            return r7
        L_0x005a:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.invalidUtf8()
            throw r5
        L_0x005f:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.decodeStringListRequireUtf8(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    public static int decodeStringRequireUtf8(byte[] bArr, int i2, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i3 = registers.int1;
        if (i3 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i3 == 0) {
            registers.object1 = "";
            return decodeVarint32;
        } else {
            registers.object1 = Utf8.decodeUtf8(bArr, decodeVarint32, i3);
            return decodeVarint32 + i3;
        }
    }

    public static int decodeUnknownField(int i2, byte[] bArr, int i3, int i4, UnknownFieldSetLite unknownFieldSetLite, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i2) != 0) {
            int tagWireType = WireFormat.getTagWireType(i2);
            if (tagWireType == 0) {
                int decodeVarint64 = decodeVarint64(bArr, i3, registers);
                unknownFieldSetLite.storeField(i2, Long.valueOf(registers.long1));
                return decodeVarint64;
            } else if (tagWireType == 1) {
                unknownFieldSetLite.storeField(i2, Long.valueOf(decodeFixed64(bArr, i3)));
                return i3 + 8;
            } else if (tagWireType == 2) {
                int decodeVarint32 = decodeVarint32(bArr, i3, registers);
                int i5 = registers.int1;
                if (i5 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                } else if (i5 <= bArr.length - decodeVarint32) {
                    if (i5 == 0) {
                        unknownFieldSetLite.storeField(i2, ByteString.EMPTY);
                    } else {
                        unknownFieldSetLite.storeField(i2, ByteString.copyFrom(bArr, decodeVarint32, i5));
                    }
                    return decodeVarint32 + i5;
                } else {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } else if (tagWireType == 3) {
                UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
                int i6 = (i2 & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int decodeVarint322 = decodeVarint32(bArr, i3, registers);
                    int i8 = registers.int1;
                    if (i8 == i6) {
                        i7 = i8;
                        i3 = decodeVarint322;
                        break;
                    }
                    i7 = i8;
                    i3 = decodeUnknownField(i8, bArr, decodeVarint322, i4, newInstance, registers);
                }
                if (i3 > i4 || i7 != i6) {
                    throw InvalidProtocolBufferException.parseFailure();
                }
                unknownFieldSetLite.storeField(i2, newInstance);
                return i3;
            } else if (tagWireType == 5) {
                unknownFieldSetLite.storeField(i2, Integer.valueOf(decodeFixed32(bArr, i3)));
                return i3 + 4;
            } else {
                throw InvalidProtocolBufferException.invalidTag();
            }
        } else {
            throw InvalidProtocolBufferException.invalidTag();
        }
    }

    public static int decodeVarint32(byte[] bArr, int i2, Registers registers) {
        int i3 = i2 + 1;
        byte b = bArr[i2];
        if (b < 0) {
            return decodeVarint32(b, bArr, i3, registers);
        }
        registers.int1 = b;
        return i3;
    }

    public static int decodeVarint32List(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i3, registers);
        intArrayList.addInt(registers.int1);
        while (decodeVarint32 < i4) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (i2 != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
            intArrayList.addInt(registers.int1);
        }
        return decodeVarint32;
    }

    public static int decodeVarint64(byte[] bArr, int i2, Registers registers) {
        int i3 = i2 + 1;
        long j = (long) bArr[i2];
        if (j < 0) {
            return decodeVarint64(j, bArr, i3, registers);
        }
        registers.long1 = j;
        return i3;
    }

    public static int decodeVarint64List(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i3, registers);
        longArrayList.addLong(registers.long1);
        while (decodeVarint64 < i4) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i2 != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        return decodeVarint64;
    }

    public static int skipField(int i2, byte[] bArr, int i3, int i4, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i2) != 0) {
            int tagWireType = WireFormat.getTagWireType(i2);
            if (tagWireType == 0) {
                return decodeVarint64(bArr, i3, registers);
            }
            if (tagWireType == 1) {
                return i3 + 8;
            }
            if (tagWireType == 2) {
                return decodeVarint32(bArr, i3, registers) + registers.int1;
            }
            if (tagWireType == 3) {
                int i5 = (i2 & -8) | 4;
                int i6 = 0;
                while (i3 < i4) {
                    i3 = decodeVarint32(bArr, i3, registers);
                    i6 = registers.int1;
                    if (i6 == i5) {
                        break;
                    }
                    i3 = skipField(i6, bArr, i3, i4, registers);
                }
                if (i3 <= i4 && i6 == i5) {
                    return i3;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } else if (tagWireType == 5) {
                return i3 + 4;
            } else {
                throw InvalidProtocolBufferException.invalidTag();
            }
        } else {
            throw InvalidProtocolBufferException.invalidTag();
        }
    }

    public static final class Registers {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;

        public Registers() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        public Registers(ExtensionRegistryLite extensionRegistryLite) {
            if (extensionRegistryLite != null) {
                this.extensionRegistry = extensionRegistryLite;
                return;
            }
            throw null;
        }
    }

    public static int decodeVarint32(int i2, byte[] bArr, int i3, Registers registers) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b = bArr[i3];
        if (b >= 0) {
            registers.int1 = i4 | (b << 7);
            return i5;
        }
        int i6 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i7 = i5 + 1;
        byte b2 = bArr[i5];
        if (b2 >= 0) {
            registers.int1 = i6 | (b2 << 14);
            return i7;
        }
        int i8 = i6 | ((b2 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b3 = bArr[i7];
        if (b3 >= 0) {
            registers.int1 = i8 | (b3 << Ascii.NAK);
            return i9;
        }
        int i10 = i8 | ((b3 & Byte.MAX_VALUE) << Ascii.NAK);
        int i11 = i9 + 1;
        byte b4 = bArr[i9];
        if (b4 >= 0) {
            registers.int1 = i10 | (b4 << Ascii.FS);
            return i11;
        }
        int i12 = i10 | ((b4 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] < 0) {
                i11 = i13;
            } else {
                registers.int1 = i12;
                return i13;
            }
        }
    }

    public static int decodeVarint64(long j, byte[] bArr, int i2, Registers registers) {
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            byte b3 = b2;
            i3 = i5;
            b = b3;
        }
        registers.long1 = j2;
        return i3;
    }
}
