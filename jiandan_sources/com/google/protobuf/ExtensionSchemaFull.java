package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ExtensionSchemaFull extends ExtensionSchema<Descriptors.FieldDescriptor> {
    public static final long EXTENSION_FIELD_OFFSET = getExtensionsFieldOffset();

    /* renamed from: com.google.protobuf.ExtensionSchemaFull$1  reason: invalid class name */
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
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x006c }
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
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0084 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ExtensionSchemaFull.AnonymousClass1.<clinit>():void");
        }
    }

    public static <T> long getExtensionsFieldOffset() {
        try {
            return UnsafeUtil.objectFieldOffset(GeneratedMessageV3.ExtendableMessage.class.getDeclaredField("extensions"));
        } catch (Throwable unused) {
            throw new IllegalStateException("Unable to lookup extension field offset");
        }
    }

    public int extensionNumber(Map.Entry<?, ?> entry) {
        return ((Descriptors.FieldDescriptor) entry.getKey()).getNumber();
    }

    public Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i2) {
        return ((ExtensionRegistry) extensionRegistryLite).findExtensionByNumber(((Message) messageLite).getDescriptorForType(), i2);
    }

    public FieldSet<Descriptors.FieldDescriptor> getExtensions(Object obj) {
        return (FieldSet) UnsafeUtil.getObject(obj, EXTENSION_FIELD_OFFSET);
    }

    public FieldSet<Descriptors.FieldDescriptor> getMutableExtensions(Object obj) {
        FieldSet<Descriptors.FieldDescriptor> extensions = getExtensions(obj);
        if (!extensions.isImmutable()) {
            return extensions;
        }
        FieldSet<Descriptors.FieldDescriptor> clone = extensions.clone();
        setExtensions(obj, clone);
        return clone;
    }

    public boolean hasExtensions(MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageV3.ExtendableMessage;
    }

    public void makeImmutable(Object obj) {
        getExtensions(obj).makeImmutable();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00f1, code lost:
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f2, code lost:
        r8.setField(r6.descriptor, r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <UT, UB> UB parseExtension(com.google.protobuf.Reader r5, java.lang.Object r6, com.google.protobuf.ExtensionRegistryLite r7, com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> r8, UB r9, com.google.protobuf.UnknownFieldSchema<UT, UB> r10) throws java.io.IOException {
        /*
            r4 = this;
            com.google.protobuf.ExtensionRegistry$ExtensionInfo r6 = (com.google.protobuf.ExtensionRegistry.ExtensionInfo) r6
            com.google.protobuf.Descriptors$FieldDescriptor r0 = r6.descriptor
            int r0 = r0.getNumber()
            com.google.protobuf.Descriptors$FieldDescriptor r1 = r6.descriptor
            boolean r1 = r1.isRepeated()
            if (r1 == 0) goto L_0x00f9
            com.google.protobuf.Descriptors$FieldDescriptor r1 = r6.descriptor
            boolean r1 = r1.isPacked()
            if (r1 == 0) goto L_0x00f9
            int[] r7 = com.google.protobuf.ExtensionSchemaFull.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType
            com.google.protobuf.Descriptors$FieldDescriptor r1 = r6.descriptor
            com.google.protobuf.WireFormat$FieldType r1 = r1.getLiteType()
            int r1 = r1.ordinal()
            r7 = r7[r1]
            switch(r7) {
                case 1: goto L_0x00e9;
                case 2: goto L_0x00e0;
                case 3: goto L_0x00d7;
                case 4: goto L_0x00ce;
                case 5: goto L_0x00c5;
                case 6: goto L_0x00bc;
                case 7: goto L_0x00b3;
                case 8: goto L_0x00aa;
                case 9: goto L_0x00a1;
                case 10: goto L_0x0098;
                case 11: goto L_0x008f;
                case 12: goto L_0x0086;
                case 13: goto L_0x007c;
                case 14: goto L_0x0046;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Type cannot be packed: "
            r7.append(r8)
            com.google.protobuf.Descriptors$FieldDescriptor r6 = r6.descriptor
            com.google.protobuf.WireFormat$FieldType r6 = r6.getLiteType()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.<init>(r6)
            throw r5
        L_0x0046:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.readEnumList(r7)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x0057:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x00f2
            java.lang.Object r1 = r7.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            com.google.protobuf.Descriptors$FieldDescriptor r2 = r6.descriptor
            com.google.protobuf.Descriptors$EnumDescriptor r2 = r2.getEnumType()
            com.google.protobuf.Descriptors$EnumValueDescriptor r2 = r2.findValueByNumber((int) r1)
            if (r2 == 0) goto L_0x0077
            r5.add(r2)
            goto L_0x0057
        L_0x0077:
            java.lang.Object r9 = com.google.protobuf.SchemaUtil.storeUnknownEnum(r0, r1, r9, r10)
            goto L_0x0057
        L_0x007c:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.readSInt64List(r7)
            goto L_0x00f1
        L_0x0086:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.readSInt32List(r7)
            goto L_0x00f1
        L_0x008f:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.readSFixed64List(r7)
            goto L_0x00f1
        L_0x0098:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.readSFixed32List(r7)
            goto L_0x00f1
        L_0x00a1:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.readUInt32List(r7)
            goto L_0x00f1
        L_0x00aa:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.readBoolList(r7)
            goto L_0x00f1
        L_0x00b3:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.readFixed32List(r7)
            goto L_0x00f1
        L_0x00bc:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.readFixed64List(r7)
            goto L_0x00f1
        L_0x00c5:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.readInt32List(r7)
            goto L_0x00f1
        L_0x00ce:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.readUInt64List(r7)
            goto L_0x00f1
        L_0x00d7:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.readInt64List(r7)
            goto L_0x00f1
        L_0x00e0:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.readFloatList(r7)
            goto L_0x00f1
        L_0x00e9:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r5.readDoubleList(r7)
        L_0x00f1:
            r5 = r7
        L_0x00f2:
            com.google.protobuf.Descriptors$FieldDescriptor r6 = r6.descriptor
            r8.setField(r6, r5)
            goto L_0x0203
        L_0x00f9:
            r1 = 0
            com.google.protobuf.Descriptors$FieldDescriptor r2 = r6.descriptor
            com.google.protobuf.WireFormat$FieldType r2 = r2.getLiteType()
            com.google.protobuf.WireFormat$FieldType r3 = com.google.protobuf.WireFormat.FieldType.ENUM
            if (r2 != r3) goto L_0x0119
            int r5 = r5.readInt32()
            com.google.protobuf.Descriptors$FieldDescriptor r7 = r6.descriptor
            com.google.protobuf.Descriptors$EnumDescriptor r7 = r7.getEnumType()
            com.google.protobuf.Descriptors$EnumValueDescriptor r1 = r7.findValueByNumber((int) r5)
            if (r1 != 0) goto L_0x01cd
            java.lang.Object r5 = com.google.protobuf.SchemaUtil.storeUnknownEnum(r0, r5, r9, r10)
            return r5
        L_0x0119:
            int[] r10 = com.google.protobuf.ExtensionSchemaFull.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType
            com.google.protobuf.Descriptors$FieldDescriptor r0 = r6.descriptor
            com.google.protobuf.WireFormat$FieldType r0 = r0.getLiteType()
            int r0 = r0.ordinal()
            r10 = r10[r0]
            switch(r10) {
                case 1: goto L_0x01c5;
                case 2: goto L_0x01bc;
                case 3: goto L_0x01b3;
                case 4: goto L_0x01aa;
                case 5: goto L_0x01a1;
                case 6: goto L_0x0198;
                case 7: goto L_0x018f;
                case 8: goto L_0x0186;
                case 9: goto L_0x017d;
                case 10: goto L_0x0174;
                case 11: goto L_0x016b;
                case 12: goto L_0x0162;
                case 13: goto L_0x0158;
                case 14: goto L_0x0150;
                case 15: goto L_0x014a;
                case 16: goto L_0x0144;
                case 17: goto L_0x0138;
                case 18: goto L_0x012c;
                default: goto L_0x012a;
            }
        L_0x012a:
            goto L_0x01cd
        L_0x012c:
            com.google.protobuf.Message r10 = r6.defaultInstance
            java.lang.Class r10 = r10.getClass()
            java.lang.Object r1 = r5.readMessage(r10, r7)
            goto L_0x01cd
        L_0x0138:
            com.google.protobuf.Message r10 = r6.defaultInstance
            java.lang.Class r10 = r10.getClass()
            java.lang.Object r1 = r5.readGroup(r10, r7)
            goto L_0x01cd
        L_0x0144:
            java.lang.String r1 = r5.readString()
            goto L_0x01cd
        L_0x014a:
            com.google.protobuf.ByteString r1 = r5.readBytes()
            goto L_0x01cd
        L_0x0150:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Shouldn't reach here."
            r5.<init>(r6)
            throw r5
        L_0x0158:
            long r0 = r5.readSInt64()
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
            goto L_0x01cd
        L_0x0162:
            int r5 = r5.readSInt32()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            goto L_0x01cd
        L_0x016b:
            long r0 = r5.readSFixed64()
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
            goto L_0x01cd
        L_0x0174:
            int r5 = r5.readSFixed32()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            goto L_0x01cd
        L_0x017d:
            int r5 = r5.readUInt32()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            goto L_0x01cd
        L_0x0186:
            boolean r5 = r5.readBool()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r5)
            goto L_0x01cd
        L_0x018f:
            int r5 = r5.readFixed32()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            goto L_0x01cd
        L_0x0198:
            long r0 = r5.readFixed64()
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
            goto L_0x01cd
        L_0x01a1:
            int r5 = r5.readInt32()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            goto L_0x01cd
        L_0x01aa:
            long r0 = r5.readUInt64()
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
            goto L_0x01cd
        L_0x01b3:
            long r0 = r5.readInt64()
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
            goto L_0x01cd
        L_0x01bc:
            float r5 = r5.readFloat()
            java.lang.Float r1 = java.lang.Float.valueOf(r5)
            goto L_0x01cd
        L_0x01c5:
            double r0 = r5.readDouble()
            java.lang.Double r1 = java.lang.Double.valueOf(r0)
        L_0x01cd:
            com.google.protobuf.Descriptors$FieldDescriptor r5 = r6.descriptor
            boolean r5 = r5.isRepeated()
            if (r5 == 0) goto L_0x01db
            com.google.protobuf.Descriptors$FieldDescriptor r5 = r6.descriptor
            r8.addRepeatedField(r5, r1)
            goto L_0x0203
        L_0x01db:
            int[] r5 = com.google.protobuf.ExtensionSchemaFull.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType
            com.google.protobuf.Descriptors$FieldDescriptor r7 = r6.descriptor
            com.google.protobuf.WireFormat$FieldType r7 = r7.getLiteType()
            int r7 = r7.ordinal()
            r5 = r5[r7]
            r7 = 17
            if (r5 == r7) goto L_0x01f2
            r7 = 18
            if (r5 == r7) goto L_0x01f2
            goto L_0x01fe
        L_0x01f2:
            com.google.protobuf.Descriptors$FieldDescriptor r5 = r6.descriptor
            java.lang.Object r5 = r8.getField(r5)
            if (r5 == 0) goto L_0x01fe
            java.lang.Object r1 = com.google.protobuf.Internal.mergeMessage(r5, r1)
        L_0x01fe:
            com.google.protobuf.Descriptors$FieldDescriptor r5 = r6.descriptor
            r8.setField(r5, r1)
        L_0x0203:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ExtensionSchemaFull.parseExtension(com.google.protobuf.Reader, java.lang.Object, com.google.protobuf.ExtensionRegistryLite, com.google.protobuf.FieldSet, java.lang.Object, com.google.protobuf.UnknownFieldSchema):java.lang.Object");
    }

    public void parseLengthPrefixedMessageSetItem(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> fieldSet) throws IOException {
        ExtensionRegistry.ExtensionInfo extensionInfo = (ExtensionRegistry.ExtensionInfo) obj;
        if (ExtensionRegistryLite.isEagerlyParseMessageSets()) {
            fieldSet.setField(extensionInfo.descriptor, reader.readMessage(extensionInfo.defaultInstance.getClass(), extensionRegistryLite));
            return;
        }
        fieldSet.setField(extensionInfo.descriptor, new LazyField(extensionInfo.defaultInstance, extensionRegistryLite, reader.readBytes()));
    }

    public void parseMessageSetItem(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> fieldSet) throws IOException {
        ExtensionRegistry.ExtensionInfo extensionInfo = (ExtensionRegistry.ExtensionInfo) obj;
        Message buildPartial = extensionInfo.defaultInstance.newBuilderForType().buildPartial();
        if (ExtensionRegistryLite.isEagerlyParseMessageSets()) {
            BinaryReader newInstance = BinaryReader.newInstance(ByteBuffer.wrap(byteString.toByteArray()), true);
            Protobuf.getInstance().mergeFrom(buildPartial, newInstance, extensionRegistryLite);
            fieldSet.setField(extensionInfo.descriptor, buildPartial);
            if (newInstance.getFieldNumber() != Integer.MAX_VALUE) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
            return;
        }
        fieldSet.setField(extensionInfo.descriptor, new LazyField(extensionInfo.defaultInstance, extensionRegistryLite, byteString));
    }

    public void serializeExtension(Writer writer, Map.Entry<?, ?> entry) throws IOException {
        Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) entry.getKey();
        if (fieldDescriptor.isRepeated()) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldDescriptor.getLiteType().ordinal()]) {
                case 1:
                    SchemaUtil.writeDoubleList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 2:
                    SchemaUtil.writeFloatList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 3:
                    SchemaUtil.writeInt64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 4:
                    SchemaUtil.writeUInt64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 5:
                    SchemaUtil.writeInt32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 6:
                    SchemaUtil.writeFixed64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 7:
                    SchemaUtil.writeFixed32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 8:
                    SchemaUtil.writeBoolList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 9:
                    SchemaUtil.writeUInt32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 10:
                    SchemaUtil.writeSFixed32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 11:
                    SchemaUtil.writeSFixed64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 12:
                    SchemaUtil.writeSInt32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 13:
                    SchemaUtil.writeSInt64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 14:
                    ArrayList arrayList = new ArrayList();
                    for (Descriptors.EnumValueDescriptor number : (List) entry.getValue()) {
                        arrayList.add(Integer.valueOf(number.getNumber()));
                    }
                    SchemaUtil.writeInt32List(fieldDescriptor.getNumber(), arrayList, writer, fieldDescriptor.isPacked());
                    return;
                case 15:
                    SchemaUtil.writeBytesList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 16:
                    SchemaUtil.writeStringList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 17:
                    SchemaUtil.writeGroupList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 18:
                    SchemaUtil.writeMessageList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                default:
                    return;
            }
        } else {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldDescriptor.getLiteType().ordinal()]) {
                case 1:
                    writer.writeDouble(fieldDescriptor.getNumber(), ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    writer.writeFloat(fieldDescriptor.getNumber(), ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    writer.writeInt64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    writer.writeUInt64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    writer.writeInt32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    writer.writeFixed64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    writer.writeFixed32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    writer.writeBool(fieldDescriptor.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    writer.writeUInt32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    writer.writeSFixed32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    writer.writeSFixed64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    writer.writeSInt32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    writer.writeSInt64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    writer.writeInt32(fieldDescriptor.getNumber(), ((Descriptors.EnumValueDescriptor) entry.getValue()).getNumber());
                    return;
                case 15:
                    writer.writeBytes(fieldDescriptor.getNumber(), (ByteString) entry.getValue());
                    return;
                case 16:
                    writer.writeString(fieldDescriptor.getNumber(), (String) entry.getValue());
                    return;
                case 17:
                    writer.writeGroup(fieldDescriptor.getNumber(), entry.getValue());
                    return;
                case 18:
                    writer.writeMessage(fieldDescriptor.getNumber(), entry.getValue());
                    return;
                default:
                    return;
            }
        }
    }

    public void setExtensions(Object obj, FieldSet<Descriptors.FieldDescriptor> fieldSet) {
        UnsafeUtil.putObject(obj, EXTENSION_FIELD_OFFSET, (Object) fieldSet);
    }
}
