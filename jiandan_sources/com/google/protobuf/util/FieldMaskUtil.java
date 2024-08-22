package com.google.protobuf.util;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.protobuf.Descriptors;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import java.util.ArrayList;
import java.util.Arrays;

public class FieldMaskUtil {
    public static final String FIELD_PATH_SEPARATOR = ",";
    public static final String FIELD_PATH_SEPARATOR_REGEX = ",";
    public static final String FIELD_SEPARATOR_REGEX = "\\.";

    public static final class MergeOptions {
        public boolean replaceMessageFields = false;
        public boolean replacePrimitiveFields = false;
        public boolean replaceRepeatedFields = false;

        public boolean replaceMessageFields() {
            return this.replaceMessageFields;
        }

        public boolean replacePrimitiveFields() {
            return this.replacePrimitiveFields;
        }

        public boolean replaceRepeatedFields() {
            return this.replaceRepeatedFields;
        }

        @CanIgnoreReturnValue
        public MergeOptions setReplaceMessageFields(boolean z) {
            this.replaceMessageFields = z;
            return this;
        }

        @CanIgnoreReturnValue
        public MergeOptions setReplacePrimitiveFields(boolean z) {
            this.replacePrimitiveFields = z;
            return this;
        }

        @CanIgnoreReturnValue
        public MergeOptions setReplaceRepeatedFields(boolean z) {
            this.replaceRepeatedFields = z;
            return this;
        }
    }

    public static FieldMask fromFieldNumbers(Class<? extends Message> cls, int... iArr) {
        return fromFieldNumbers(cls, (Iterable<Integer>) Ints.asList(iArr));
    }

    public static FieldMask fromJsonString(String str) {
        Iterable<String> split = Splitter.on(",").split(str);
        FieldMask.Builder newBuilder = FieldMask.newBuilder();
        for (String next : split) {
            if (!next.isEmpty()) {
                newBuilder.addPaths(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, next));
            }
        }
        return newBuilder.build();
    }

    public static FieldMask fromString(String str) {
        return fromStringList((Class<? extends Message>) null, Arrays.asList(str.split(",")));
    }

    public static FieldMask fromStringList(Class<? extends Message> cls, Iterable<String> iterable) {
        FieldMask.Builder newBuilder = FieldMask.newBuilder();
        for (String next : iterable) {
            if (!next.isEmpty()) {
                if (cls == null || isValid(cls, next)) {
                    newBuilder.addPaths(next);
                } else {
                    throw new IllegalArgumentException(next + " is not a valid path for " + cls);
                }
            }
        }
        return newBuilder.build();
    }

    public static FieldMask intersection(FieldMask fieldMask, FieldMask fieldMask2) {
        FieldMaskTree fieldMaskTree = new FieldMaskTree(fieldMask);
        FieldMaskTree fieldMaskTree2 = new FieldMaskTree();
        for (String intersectFieldPath : fieldMask2.getPathsList()) {
            fieldMaskTree.intersectFieldPath(intersectFieldPath, fieldMaskTree2);
        }
        return fieldMaskTree2.toFieldMask();
    }

    public static boolean isValid(Class<? extends Message> cls, FieldMask fieldMask) {
        return isValid(((Message) Internal.getDefaultInstance(cls)).getDescriptorForType(), fieldMask);
    }

    public static void merge(FieldMask fieldMask, Message message, Message.Builder builder, MergeOptions mergeOptions) {
        new FieldMaskTree(fieldMask).merge(message, builder, mergeOptions);
    }

    public static FieldMask normalize(FieldMask fieldMask) {
        return new FieldMaskTree(fieldMask).toFieldMask();
    }

    public static String toJsonString(FieldMask fieldMask) {
        ArrayList arrayList = new ArrayList(fieldMask.getPathsCount());
        for (String str : fieldMask.getPathsList()) {
            if (!str.isEmpty()) {
                arrayList.add(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str));
            }
        }
        return Joiner.on(",").join((Iterable<?>) arrayList);
    }

    public static String toString(FieldMask fieldMask) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : fieldMask.getPathsList()) {
            if (!str.isEmpty()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static FieldMask union(FieldMask fieldMask, FieldMask fieldMask2, FieldMask... fieldMaskArr) {
        FieldMaskTree mergeFromFieldMask = new FieldMaskTree(fieldMask).mergeFromFieldMask(fieldMask2);
        for (FieldMask mergeFromFieldMask2 : fieldMaskArr) {
            mergeFromFieldMask.mergeFromFieldMask(mergeFromFieldMask2);
        }
        return mergeFromFieldMask.toFieldMask();
    }

    public static FieldMask fromFieldNumbers(Class<? extends Message> cls, Iterable<Integer> iterable) {
        Descriptors.Descriptor descriptorForType = ((Message) Internal.getDefaultInstance(cls)).getDescriptorForType();
        FieldMask.Builder newBuilder = FieldMask.newBuilder();
        for (Integer next : iterable) {
            Descriptors.FieldDescriptor findFieldByNumber = descriptorForType.findFieldByNumber(next.intValue());
            Preconditions.checkArgument(findFieldByNumber != null, String.format("%s is not a valid field number for %s.", new Object[]{next, cls}));
            newBuilder.addPaths(findFieldByNumber.getName());
        }
        return newBuilder.build();
    }

    public static FieldMask fromString(Class<? extends Message> cls, String str) {
        return fromStringList(cls, Arrays.asList(str.split(",")));
    }

    public static void merge(FieldMask fieldMask, Message message, Message.Builder builder) {
        merge(fieldMask, message, builder, new MergeOptions());
    }

    public static boolean isValid(Descriptors.Descriptor descriptor, FieldMask fieldMask) {
        for (String isValid : fieldMask.getPathsList()) {
            if (!isValid(descriptor, isValid)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(Class<? extends Message> cls, String str) {
        return isValid(((Message) Internal.getDefaultInstance(cls)).getDescriptorForType(), str);
    }

    public static boolean isValid(Descriptors.Descriptor descriptor, String str) {
        Descriptors.FieldDescriptor findFieldByName;
        String[] split = str.split("\\.");
        if (split.length == 0) {
            return false;
        }
        for (String str2 : split) {
            if (descriptor == null || (findFieldByName = descriptor.findFieldByName(str2)) == null) {
                return false;
            }
            descriptor = (findFieldByName.isRepeated() || findFieldByName.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) ? null : findFieldByName.getMessageType();
        }
        return true;
    }
}
