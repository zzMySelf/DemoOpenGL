package com.google.protobuf;

import com.google.common.base.Ascii;
import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class SchemaUtil {
    public static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    public static final Class<?> GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
    public static final UnknownFieldSchema<?, ?> PROTO2_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(false);
    public static final UnknownFieldSchema<?, ?> PROTO3_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(true);
    public static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();

    public static int computeSizeBoolList(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(size);
        }
        return size * CodedOutputStream.computeBoolSize(i2, true);
    }

    public static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    public static int computeSizeByteStringList(int i2, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = size * CodedOutputStream.computeTagSize(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            computeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i3));
        }
        return computeTagSize;
    }

    public static int computeSizeEnumList(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeEnumListNoTag = computeSizeEnumListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeEnumListNoTag);
        }
        return computeSizeEnumListNoTag + (size * CodedOutputStream.computeTagSize(i2));
    }

    public static int computeSizeEnumListNoTag(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.computeEnumSizeNoTag(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static int computeSizeFixed32List(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 4);
        }
        return size * CodedOutputStream.computeFixed32Size(i2, 0);
    }

    public static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    public static int computeSizeFixed64List(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 8);
        }
        return size * CodedOutputStream.computeFixed64Size(i2, 0);
    }

    public static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    public static int computeSizeGroupList(int i2, List<MessageLite> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += CodedOutputStream.computeGroupSize(i2, list.get(i4));
        }
        return i3;
    }

    public static int computeSizeInt32List(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeInt32ListNoTag = computeSizeInt32ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt32ListNoTag);
        }
        return computeSizeInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i2));
    }

    public static int computeSizeInt32ListNoTag(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.computeInt32SizeNoTag(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static int computeSizeInt64List(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int computeSizeInt64ListNoTag = computeSizeInt64ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt64ListNoTag);
        }
        return computeSizeInt64ListNoTag + (list.size() * CodedOutputStream.computeTagSize(i2));
    }

    public static int computeSizeInt64ListNoTag(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.computeInt64SizeNoTag(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static int computeSizeMessage(int i2, Object obj, Schema schema) {
        if (obj instanceof LazyFieldLite) {
            return CodedOutputStream.computeLazyFieldSize(i2, (LazyFieldLite) obj);
        }
        return CodedOutputStream.computeMessageSize(i2, (MessageLite) obj, schema);
    }

    public static int computeSizeMessageList(int i2, List<?> list) {
        int i3;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i2) * size;
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = list.get(i4);
            if (obj instanceof LazyFieldLite) {
                i3 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                i3 = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            }
            computeTagSize += i3;
        }
        return computeTagSize;
    }

    public static int computeSizeSInt32List(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt32ListNoTag = computeSizeSInt32ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt32ListNoTag);
        }
        return computeSizeSInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i2));
    }

    public static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.computeSInt32SizeNoTag(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static int computeSizeSInt64List(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt64ListNoTag = computeSizeSInt64ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt64ListNoTag);
        }
        return computeSizeSInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i2));
    }

    public static int computeSizeSInt64ListNoTag(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.computeSInt64SizeNoTag(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static int computeSizeStringList(int i2, List<?> list) {
        int i3;
        int i4;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i2) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i5 < size) {
                Object raw = lazyStringList.getRaw(i5);
                if (raw instanceof ByteString) {
                    i4 = CodedOutputStream.computeBytesSizeNoTag((ByteString) raw);
                } else {
                    i4 = CodedOutputStream.computeStringSizeNoTag((String) raw);
                }
                computeTagSize += i4;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof ByteString) {
                    i3 = CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                } else {
                    i3 = CodedOutputStream.computeStringSizeNoTag((String) obj);
                }
                computeTagSize += i3;
                i5++;
            }
        }
        return computeTagSize;
    }

    public static int computeSizeUInt32List(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt32ListNoTag = computeSizeUInt32ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt32ListNoTag);
        }
        return computeSizeUInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i2));
    }

    public static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.computeUInt32SizeNoTag(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static int computeSizeUInt64List(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt64ListNoTag = computeSizeUInt64ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt64ListNoTag);
        }
        return computeSizeUInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i2));
    }

    public static int computeSizeUInt64ListNoTag(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + CodedOutputStream.computeUInt64SizeNoTag(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static <UT, UB> UB filterUnknownEnumList(int i2, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = list.get(i4).intValue();
                if (enumLiteMap.findValueByNumber(intValue) != null) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    ub = storeUnknownEnum(i2, intValue, ub, unknownFieldSchema);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (enumLiteMap.findValueByNumber(intValue2) == null) {
                    ub = storeUnknownEnum(i2, intValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static Class<?> getGeneratedMessageClass() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object getMapDefaultEntry(Class<?> cls, String str) {
        try {
            Field[] declaredFields = Class.forName(cls.getName() + "$" + toCamelCase(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length == 1) {
                return UnsafeUtil.getStaticObject(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th2) {
            throw new RuntimeException(th2);
        }
    }

    public static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema(boolean z) {
        try {
            Class<?> unknownFieldSetSchemaClass = getUnknownFieldSetSchemaClass();
            if (unknownFieldSetSchemaClass == null) {
                return null;
            }
            return (UnknownFieldSchema) unknownFieldSetSchemaClass.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> getUnknownFieldSetSchemaClass() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> extensionSchema, T t, T t2) {
        FieldSet<FT> extensions = extensionSchema.getExtensions(t2);
        if (!extensions.isEmpty()) {
            extensionSchema.getMutableExtensions(t).mergeFrom(extensions);
        }
    }

    public static <T> void mergeMap(MapFieldSchema mapFieldSchema, T t, T t2, long j) {
        UnsafeUtil.putObject((Object) t, j, mapFieldSchema.mergeFrom(UnsafeUtil.getObject((Object) t, j), UnsafeUtil.getObject((Object) t2, j)));
    }

    public static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, T t2) {
        unknownFieldSchema.setToMessage(t, unknownFieldSchema.merge(unknownFieldSchema.getFromMessage(t), unknownFieldSchema.getFromMessage(t2)));
    }

    public static UnknownFieldSchema<?, ?> proto2UnknownFieldSetSchema() {
        return PROTO2_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> proto3UnknownFieldSetSchema() {
        return PROTO3_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = GENERATED_MESSAGE_CLASS) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean safeEquals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean shouldUseTableSwitch(int i2, int i3, int i4) {
        if (i3 < 40) {
            return true;
        }
        long j = (long) i4;
        return ((((long) i3) - ((long) i2)) + 1) + 9 <= ((2 * j) + 3) + ((j + 3) * 3);
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fieldInfoArr) {
        if (fieldInfoArr.length == 0) {
            return false;
        }
        return shouldUseTableSwitch(fieldInfoArr[0].getFieldNumber(), fieldInfoArr[fieldInfoArr.length - 1].getFieldNumber(), fieldInfoArr.length);
    }

    public static <UT, UB> UB storeUnknownEnum(int i2, int i3, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.newBuilder();
        }
        unknownFieldSchema.addVarint(ub, i2, (long) i3);
        return ub;
    }

    public static String toCamelCase(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ('a' > charAt || charAt > 'z') {
                if ('A' > charAt || charAt > 'Z') {
                    if ('0' <= charAt && charAt <= '9') {
                        sb.append(charAt);
                    }
                    z = true;
                } else if (i2 != 0 || z) {
                    sb.append(charAt);
                } else {
                    sb.append((char) (charAt + Ascii.CASE_MASK));
                }
            } else if (z) {
                sb.append((char) (charAt - ' '));
            } else {
                sb.append(charAt);
            }
            z = false;
        }
        return sb.toString();
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    public static void writeBool(int i2, boolean z, Writer writer) throws IOException {
        if (z) {
            writer.writeBool(i2, true);
        }
    }

    public static void writeBoolList(int i2, List<Boolean> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBoolList(i2, list, z);
        }
    }

    public static void writeBytes(int i2, ByteString byteString, Writer writer) throws IOException {
        if (byteString != null && !byteString.isEmpty()) {
            writer.writeBytes(i2, byteString);
        }
    }

    public static void writeBytesList(int i2, List<ByteString> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBytesList(i2, list);
        }
    }

    public static void writeDouble(int i2, double d, Writer writer) throws IOException {
        if (Double.compare(d, 0.0d) != 0) {
            writer.writeDouble(i2, d);
        }
    }

    public static void writeDoubleList(int i2, List<Double> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeDoubleList(i2, list, z);
        }
    }

    public static void writeEnum(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.writeEnum(i2, i3);
        }
    }

    public static void writeEnumList(int i2, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeEnumList(i2, list, z);
        }
    }

    public static void writeFixed32(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.writeFixed32(i2, i3);
        }
    }

    public static void writeFixed32List(int i2, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed32List(i2, list, z);
        }
    }

    public static void writeFixed64(int i2, long j, Writer writer) throws IOException {
        if (j != 0) {
            writer.writeFixed64(i2, j);
        }
    }

    public static void writeFixed64List(int i2, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed64List(i2, list, z);
        }
    }

    public static void writeFloat(int i2, float f, Writer writer) throws IOException {
        if (Float.compare(f, 0.0f) != 0) {
            writer.writeFloat(i2, f);
        }
    }

    public static void writeFloatList(int i2, List<Float> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFloatList(i2, list, z);
        }
    }

    public static void writeGroupList(int i2, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeGroupList(i2, list);
        }
    }

    public static void writeInt32(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.writeInt32(i2, i3);
        }
    }

    public static void writeInt32List(int i2, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt32List(i2, list, z);
        }
    }

    public static void writeInt64(int i2, long j, Writer writer) throws IOException {
        if (j != 0) {
            writer.writeInt64(i2, j);
        }
    }

    public static void writeInt64List(int i2, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt64List(i2, list, z);
        }
    }

    public static void writeLazyFieldList(int i2, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                ((LazyFieldLite) it.next()).writeTo(writer, i2);
            }
        }
    }

    public static void writeMessage(int i2, Object obj, Writer writer) throws IOException {
        if (obj != null) {
            writer.writeMessage(i2, obj);
        }
    }

    public static void writeMessageList(int i2, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeMessageList(i2, list);
        }
    }

    public static void writeSFixed32(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.writeSFixed32(i2, i3);
        }
    }

    public static void writeSFixed32List(int i2, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed32List(i2, list, z);
        }
    }

    public static void writeSFixed64(int i2, long j, Writer writer) throws IOException {
        if (j != 0) {
            writer.writeSFixed64(i2, j);
        }
    }

    public static void writeSFixed64List(int i2, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed64List(i2, list, z);
        }
    }

    public static void writeSInt32(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.writeSInt32(i2, i3);
        }
    }

    public static void writeSInt32List(int i2, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt32List(i2, list, z);
        }
    }

    public static void writeSInt64(int i2, long j, Writer writer) throws IOException {
        if (j != 0) {
            writer.writeSInt64(i2, j);
        }
    }

    public static void writeSInt64List(int i2, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt64List(i2, list, z);
        }
    }

    public static void writeString(int i2, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writeStringInternal(i2, (String) obj, writer);
        } else {
            writeBytes(i2, (ByteString) obj, writer);
        }
    }

    public static void writeStringInternal(int i2, String str, Writer writer) throws IOException {
        if (str != null && !str.isEmpty()) {
            writer.writeString(i2, str);
        }
    }

    public static void writeStringList(int i2, List<String> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeStringList(i2, list);
        }
    }

    public static void writeUInt32(int i2, int i3, Writer writer) throws IOException {
        if (i3 != 0) {
            writer.writeUInt32(i2, i3);
        }
    }

    public static void writeUInt32List(int i2, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt32List(i2, list, z);
        }
    }

    public static void writeUInt64(int i2, long j, Writer writer) throws IOException {
        if (j != 0) {
            writer.writeUInt64(i2, j);
        }
    }

    public static void writeUInt64List(int i2, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt64List(i2, list, z);
        }
    }

    public static int computeSizeGroupList(int i2, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += CodedOutputStream.computeGroupSize(i2, list.get(i4), schema);
        }
        return i3;
    }

    public static void writeGroupList(int i2, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeGroupList(i2, list, schema);
        }
    }

    public static void writeMessageList(int i2, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeMessageList(i2, list, schema);
        }
    }

    public static int computeSizeMessageList(int i2, List<?> list, Schema schema) {
        int i3;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i2) * size;
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = list.get(i4);
            if (obj instanceof LazyFieldLite) {
                i3 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                i3 = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj, schema);
            }
            computeTagSize += i3;
        }
        return computeTagSize;
    }

    public static <UT, UB> UB filterUnknownEnumList(int i2, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = list.get(i4).intValue();
                if (enumVerifier.isInRange(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    ub = storeUnknownEnum(i2, intValue, ub, unknownFieldSchema);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!enumVerifier.isInRange(intValue2)) {
                    ub = storeUnknownEnum(i2, intValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }
}
