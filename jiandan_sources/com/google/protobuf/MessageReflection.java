package com.google.protobuf;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MessageReflection {

    /* renamed from: com.google.protobuf.MessageReflection$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.protobuf.Descriptors$FieldDescriptor$Type[] r0 = com.google.protobuf.Descriptors.FieldDescriptor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r0
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.MESSAGE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.ENUM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageReflection.AnonymousClass1.<clinit>():void");
        }
    }

    public static class BuilderAdapter implements MergeTarget {
        public final Message.Builder builder;

        public BuilderAdapter(Message.Builder builder2) {
            this.builder = builder2;
        }

        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.builder.addRepeatedField(fieldDescriptor, obj);
            return this;
        }

        public MergeTarget clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            this.builder.clearField(fieldDescriptor);
            return this;
        }

        public MergeTarget clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            this.builder.clearOneof(oneofDescriptor);
            return this;
        }

        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry extensionRegistry, String str) {
            return extensionRegistry.findImmutableExtensionByName(str);
        }

        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry extensionRegistry, Descriptors.Descriptor descriptor, int i2) {
            return extensionRegistry.findImmutableExtensionByNumber(descriptor, i2);
        }

        public Object finish() {
            return this.builder.buildPartial();
        }

        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.MESSAGE;
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return this.builder.getDescriptorForType();
        }

        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.builder.getField(fieldDescriptor);
        }

        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor) {
            return this.builder.getOneofFieldDescriptor(oneofDescriptor);
        }

        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.needsUtf8Check()) {
                return WireFormat.Utf8Validation.STRICT;
            }
            if (fieldDescriptor.isRepeated() || !(this.builder instanceof GeneratedMessage.Builder)) {
                return WireFormat.Utf8Validation.LOOSE;
            }
            return WireFormat.Utf8Validation.LAZY;
        }

        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.builder.hasField(fieldDescriptor);
        }

        public boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return this.builder.hasOneof(oneofDescriptor);
        }

        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            Message.Builder builder2;
            if (message != null) {
                builder2 = message.newBuilderForType();
            } else {
                builder2 = this.builder.newBuilderForField(fieldDescriptor);
            }
            return new BuilderAdapter(builder2);
        }

        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            Message.Builder builder2;
            Message message2;
            if (message != null) {
                builder2 = message.newBuilderForType();
            } else {
                builder2 = this.builder.newBuilderForField(fieldDescriptor);
            }
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                builder2.mergeFrom(message2);
            }
            return new BuilderAdapter(builder2);
        }

        public Object parseGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException {
            Message.Builder builder2;
            Message message2;
            if (message != null) {
                builder2 = message.newBuilderForType();
            } else {
                builder2 = this.builder.newBuilderForField(fieldDescriptor);
            }
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                builder2.mergeFrom(message2);
            }
            codedInputStream.readGroup(fieldDescriptor.getNumber(), (MessageLite.Builder) builder2, extensionRegistryLite);
            return builder2.buildPartial();
        }

        public Object parseMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException {
            Message.Builder builder2;
            Message message2;
            if (message != null) {
                builder2 = message.newBuilderForType();
            } else {
                builder2 = this.builder.newBuilderForField(fieldDescriptor);
            }
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                builder2.mergeFrom(message2);
            }
            codedInputStream.readMessage((MessageLite.Builder) builder2, extensionRegistryLite);
            return builder2.buildPartial();
        }

        public Object parseMessageFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException {
            Message.Builder builder2;
            Message message2;
            if (message != null) {
                builder2 = message.newBuilderForType();
            } else {
                builder2 = this.builder.newBuilderForField(fieldDescriptor);
            }
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                builder2.mergeFrom(message2);
            }
            builder2.mergeFrom(byteString, extensionRegistryLite);
            return builder2.buildPartial();
        }

        public MergeTarget setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.builder.setField(fieldDescriptor, obj);
            return this;
        }

        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i2, Object obj) {
            this.builder.setRepeatedField(fieldDescriptor, i2, obj);
            return this;
        }
    }

    public static class ExtensionAdapter implements MergeTarget {
        public final FieldSet<Descriptors.FieldDescriptor> extensions;

        public ExtensionAdapter(FieldSet<Descriptors.FieldDescriptor> fieldSet) {
            this.extensions = fieldSet;
        }

        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.extensions.addRepeatedField(fieldDescriptor, obj);
            return this;
        }

        public MergeTarget clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            this.extensions.clearField(fieldDescriptor);
            return this;
        }

        public MergeTarget clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return this;
        }

        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry extensionRegistry, String str) {
            return extensionRegistry.findImmutableExtensionByName(str);
        }

        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry extensionRegistry, Descriptors.Descriptor descriptor, int i2) {
            return extensionRegistry.findImmutableExtensionByNumber(descriptor, i2);
        }

        public Object finish() {
            throw new UnsupportedOperationException("finish() called on FieldSet object");
        }

        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.EXTENSION_SET;
        }

        public Descriptors.Descriptor getDescriptorForType() {
            throw new UnsupportedOperationException("getDescriptorForType() called on FieldSet object");
        }

        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.extensions.getField(fieldDescriptor);
        }

        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor) {
            return null;
        }

        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.needsUtf8Check()) {
                return WireFormat.Utf8Validation.STRICT;
            }
            return WireFormat.Utf8Validation.LOOSE;
        }

        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.extensions.hasField(fieldDescriptor);
        }

        public boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return false;
        }

        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
        }

        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
        }

        public Object parseGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException {
            Message message2;
            Message.Builder newBuilderForType = message.newBuilderForType();
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                newBuilderForType.mergeFrom(message2);
            }
            codedInputStream.readGroup(fieldDescriptor.getNumber(), (MessageLite.Builder) newBuilderForType, extensionRegistryLite);
            return newBuilderForType.buildPartial();
        }

        public Object parseMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException {
            Message message2;
            Message.Builder newBuilderForType = message.newBuilderForType();
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                newBuilderForType.mergeFrom(message2);
            }
            codedInputStream.readMessage((MessageLite.Builder) newBuilderForType, extensionRegistryLite);
            return newBuilderForType.buildPartial();
        }

        public Object parseMessageFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException {
            Message message2;
            Message.Builder newBuilderForType = message.newBuilderForType();
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                newBuilderForType.mergeFrom(message2);
            }
            newBuilderForType.mergeFrom(byteString, extensionRegistryLite);
            return newBuilderForType.buildPartial();
        }

        public MergeTarget setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.extensions.setField(fieldDescriptor, obj);
            return this;
        }

        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i2, Object obj) {
            this.extensions.setRepeatedField(fieldDescriptor, i2, obj);
            return this;
        }
    }

    public interface MergeTarget {

        public enum ContainerType {
            MESSAGE,
            EXTENSION_SET
        }

        MergeTarget addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        MergeTarget clearField(Descriptors.FieldDescriptor fieldDescriptor);

        MergeTarget clearOneof(Descriptors.OneofDescriptor oneofDescriptor);

        ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry extensionRegistry, String str);

        ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry extensionRegistry, Descriptors.Descriptor descriptor, int i2);

        Object finish();

        ContainerType getContainerType();

        Descriptors.Descriptor getDescriptorForType();

        Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor);

        WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor fieldDescriptor);

        boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor);

        MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message);

        MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message);

        Object parseGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException;

        Object parseMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException;

        Object parseMessageFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException;

        MergeTarget setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        MergeTarget setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i2, Object obj);
    }

    public static String delimitWithCommas(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String next : list) {
            if (sb.length() > 0) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(next);
        }
        return sb.toString();
    }

    public static void eagerlyMergeMessageSetExtension(CodedInputStream codedInputStream, ExtensionRegistry.ExtensionInfo extensionInfo, ExtensionRegistryLite extensionRegistryLite, MergeTarget mergeTarget) throws IOException {
        Descriptors.FieldDescriptor fieldDescriptor = extensionInfo.descriptor;
        mergeTarget.setField(fieldDescriptor, mergeTarget.parseMessage(codedInputStream, extensionRegistryLite, fieldDescriptor, extensionInfo.defaultInstance));
    }

    public static void findMissingFields(MessageOrBuilder messageOrBuilder, String str, List<String> list) {
        for (Descriptors.FieldDescriptor next : messageOrBuilder.getDescriptorForType().getFields()) {
            if (next.isRequired() && !messageOrBuilder.hasField(next)) {
                list.add(str + next.getName());
            }
        }
        for (Map.Entry next2 : messageOrBuilder.getAllFields().entrySet()) {
            Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) next2.getKey();
            Object value = next2.getValue();
            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (fieldDescriptor.isRepeated()) {
                    int i2 = 0;
                    for (MessageOrBuilder findMissingFields : (List) value) {
                        findMissingFields(findMissingFields, subMessagePrefix(str, fieldDescriptor, i2), list);
                        i2++;
                    }
                } else if (messageOrBuilder.hasField(fieldDescriptor)) {
                    findMissingFields((MessageOrBuilder) value, subMessagePrefix(str, fieldDescriptor, -1), list);
                }
            }
        }
    }

    public static int getSerializedSize(Message message, Map<Descriptors.FieldDescriptor, Object> map) {
        int i2;
        int i3;
        boolean messageSetWireFormat = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
        int i4 = 0;
        for (Map.Entry next : map.entrySet()) {
            Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) next.getKey();
            Object value = next.getValue();
            if (!messageSetWireFormat || !fieldDescriptor.isExtension() || fieldDescriptor.getType() != Descriptors.FieldDescriptor.Type.MESSAGE || fieldDescriptor.isRepeated()) {
                i3 = FieldSet.computeFieldSize(fieldDescriptor, value);
            } else {
                i3 = CodedOutputStream.computeMessageSetExtensionSize(fieldDescriptor.getNumber(), (Message) value);
            }
            i4 += i3;
        }
        UnknownFieldSet unknownFields = message.getUnknownFields();
        if (messageSetWireFormat) {
            i2 = unknownFields.getSerializedSizeAsMessageSet();
        } else {
            i2 = unknownFields.getSerializedSize();
        }
        return i4 + i2;
    }

    public static boolean isInitialized(MessageOrBuilder messageOrBuilder) {
        for (Descriptors.FieldDescriptor next : messageOrBuilder.getDescriptorForType().getFields()) {
            if (next.isRequired() && !messageOrBuilder.hasField(next)) {
                return false;
            }
        }
        for (Map.Entry next2 : messageOrBuilder.getAllFields().entrySet()) {
            Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) next2.getKey();
            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (fieldDescriptor.isRepeated()) {
                    for (Message isInitialized : (List) next2.getValue()) {
                        if (!isInitialized.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (!((Message) next2.getValue()).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean mergeFieldFrom(com.google.protobuf.CodedInputStream r7, com.google.protobuf.UnknownFieldSet.Builder r8, com.google.protobuf.ExtensionRegistryLite r9, com.google.protobuf.Descriptors.Descriptor r10, com.google.protobuf.MessageReflection.MergeTarget r11, int r12) throws java.io.IOException {
        /*
            com.google.protobuf.DescriptorProtos$MessageOptions r0 = r10.getOptions()
            boolean r0 = r0.getMessageSetWireFormat()
            r1 = 1
            if (r0 == 0) goto L_0x0013
            int r0 = com.google.protobuf.WireFormat.MESSAGE_SET_ITEM_TAG
            if (r12 != r0) goto L_0x0013
            mergeMessageSetExtensionFromCodedStream(r7, r8, r9, r10, r11)
            return r1
        L_0x0013:
            int r0 = com.google.protobuf.WireFormat.getTagWireType(r12)
            int r2 = com.google.protobuf.WireFormat.getTagFieldNumber(r12)
            boolean r3 = r10.isExtensionNumber(r2)
            r4 = 0
            if (r3 == 0) goto L_0x005d
            boolean r3 = r9 instanceof com.google.protobuf.ExtensionRegistry
            if (r3 == 0) goto L_0x006d
            r3 = r9
            com.google.protobuf.ExtensionRegistry r3 = (com.google.protobuf.ExtensionRegistry) r3
            com.google.protobuf.ExtensionRegistry$ExtensionInfo r10 = r11.findExtensionByNumber(r3, r10, r2)
            if (r10 != 0) goto L_0x0030
            goto L_0x006d
        L_0x0030:
            com.google.protobuf.Descriptors$FieldDescriptor r3 = r10.descriptor
            com.google.protobuf.Message r4 = r10.defaultInstance
            if (r4 != 0) goto L_0x005a
            com.google.protobuf.Descriptors$FieldDescriptor$JavaType r10 = r3.getJavaType()
            com.google.protobuf.Descriptors$FieldDescriptor$JavaType r5 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE
            if (r10 == r5) goto L_0x003f
            goto L_0x005a
        L_0x003f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Message-typed extension lacked default instance: "
            r8.append(r9)
            java.lang.String r9 = r3.getFullName()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x005a:
            r10 = r4
            r4 = r3
            goto L_0x006e
        L_0x005d:
            com.google.protobuf.MessageReflection$MergeTarget$ContainerType r3 = r11.getContainerType()
            com.google.protobuf.MessageReflection$MergeTarget$ContainerType r5 = com.google.protobuf.MessageReflection.MergeTarget.ContainerType.MESSAGE
            if (r3 != r5) goto L_0x006d
            com.google.protobuf.Descriptors$FieldDescriptor r10 = r10.findFieldByNumber(r2)
            r6 = r4
            r4 = r10
            r10 = r6
            goto L_0x006e
        L_0x006d:
            r10 = r4
        L_0x006e:
            r3 = 0
            if (r4 != 0) goto L_0x0074
        L_0x0071:
            r0 = 0
            r3 = 1
            goto L_0x0091
        L_0x0074:
            com.google.protobuf.WireFormat$FieldType r5 = r4.getLiteType()
            int r5 = com.google.protobuf.FieldSet.getWireFormatForFieldType(r5, r3)
            if (r0 != r5) goto L_0x0080
            r0 = 0
            goto L_0x0091
        L_0x0080:
            boolean r5 = r4.isPackable()
            if (r5 == 0) goto L_0x0071
            com.google.protobuf.WireFormat$FieldType r5 = r4.getLiteType()
            int r5 = com.google.protobuf.FieldSet.getWireFormatForFieldType(r5, r1)
            if (r0 != r5) goto L_0x0071
            r0 = 1
        L_0x0091:
            if (r3 == 0) goto L_0x009f
            if (r8 == 0) goto L_0x009a
            boolean r7 = r8.mergeFieldFrom(r12, r7)
            return r7
        L_0x009a:
            boolean r7 = r7.skipField(r12)
            return r7
        L_0x009f:
            if (r0 == 0) goto L_0x00ff
            int r9 = r7.readRawVarint32()
            int r9 = r7.pushLimit(r9)
            com.google.protobuf.WireFormat$FieldType r10 = r4.getLiteType()
            com.google.protobuf.WireFormat$FieldType r12 = com.google.protobuf.WireFormat.FieldType.ENUM
            if (r10 != r12) goto L_0x00e5
        L_0x00b1:
            int r10 = r7.getBytesUntilLimit()
            if (r10 <= 0) goto L_0x00fb
            int r10 = r7.readEnum()
            com.google.protobuf.Descriptors$FileDescriptor r12 = r4.getFile()
            boolean r12 = r12.supportsUnknownEnumValue()
            if (r12 == 0) goto L_0x00d1
            com.google.protobuf.Descriptors$EnumDescriptor r12 = r4.getEnumType()
            com.google.protobuf.Descriptors$EnumValueDescriptor r10 = r12.findValueByNumberCreatingIfUnknown(r10)
            r11.addRepeatedField(r4, r10)
            goto L_0x00b1
        L_0x00d1:
            com.google.protobuf.Descriptors$EnumDescriptor r12 = r4.getEnumType()
            com.google.protobuf.Descriptors$EnumValueDescriptor r12 = r12.findValueByNumber((int) r10)
            if (r12 != 0) goto L_0x00e1
            if (r8 == 0) goto L_0x00b1
            r8.mergeVarintField(r2, r10)
            goto L_0x00b1
        L_0x00e1:
            r11.addRepeatedField(r4, r12)
            goto L_0x00b1
        L_0x00e5:
            int r8 = r7.getBytesUntilLimit()
            if (r8 <= 0) goto L_0x00fb
            com.google.protobuf.WireFormat$FieldType r8 = r4.getLiteType()
            com.google.protobuf.WireFormat$Utf8Validation r10 = r11.getUtf8Validation(r4)
            java.lang.Object r8 = com.google.protobuf.WireFormat.readPrimitiveField(r7, r8, r10)
            r11.addRepeatedField(r4, r8)
            goto L_0x00e5
        L_0x00fb:
            r7.popLimit(r9)
            goto L_0x015f
        L_0x00ff:
            int[] r12 = com.google.protobuf.MessageReflection.AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type
            com.google.protobuf.Descriptors$FieldDescriptor$Type r0 = r4.getType()
            int r0 = r0.ordinal()
            r12 = r12[r0]
            if (r12 == r1) goto L_0x014e
            r0 = 2
            if (r12 == r0) goto L_0x0149
            r9 = 3
            if (r12 == r9) goto L_0x0120
            com.google.protobuf.WireFormat$FieldType r8 = r4.getLiteType()
            com.google.protobuf.WireFormat$Utf8Validation r9 = r11.getUtf8Validation(r4)
            java.lang.Object r7 = com.google.protobuf.WireFormat.readPrimitiveField(r7, r8, r9)
            goto L_0x0152
        L_0x0120:
            int r7 = r7.readEnum()
            com.google.protobuf.Descriptors$FileDescriptor r9 = r4.getFile()
            boolean r9 = r9.supportsUnknownEnumValue()
            if (r9 == 0) goto L_0x0137
            com.google.protobuf.Descriptors$EnumDescriptor r8 = r4.getEnumType()
            com.google.protobuf.Descriptors$EnumValueDescriptor r7 = r8.findValueByNumberCreatingIfUnknown(r7)
            goto L_0x0152
        L_0x0137:
            com.google.protobuf.Descriptors$EnumDescriptor r9 = r4.getEnumType()
            com.google.protobuf.Descriptors$EnumValueDescriptor r9 = r9.findValueByNumber((int) r7)
            if (r9 != 0) goto L_0x0147
            if (r8 == 0) goto L_0x0146
            r8.mergeVarintField(r2, r7)
        L_0x0146:
            return r1
        L_0x0147:
            r7 = r9
            goto L_0x0152
        L_0x0149:
            java.lang.Object r7 = r11.parseMessage(r7, r9, r4, r10)
            goto L_0x0152
        L_0x014e:
            java.lang.Object r7 = r11.parseGroup(r7, r9, r4, r10)
        L_0x0152:
            boolean r8 = r4.isRepeated()
            if (r8 == 0) goto L_0x015c
            r11.addRepeatedField(r4, r7)
            goto L_0x015f
        L_0x015c:
            r11.setField(r4, r7)
        L_0x015f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageReflection.mergeFieldFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.UnknownFieldSet$Builder, com.google.protobuf.ExtensionRegistryLite, com.google.protobuf.Descriptors$Descriptor, com.google.protobuf.MessageReflection$MergeTarget, int):boolean");
    }

    public static void mergeMessageSetExtensionFromBytes(ByteString byteString, ExtensionRegistry.ExtensionInfo extensionInfo, ExtensionRegistryLite extensionRegistryLite, MergeTarget mergeTarget) throws IOException {
        Descriptors.FieldDescriptor fieldDescriptor = extensionInfo.descriptor;
        if (mergeTarget.hasField(fieldDescriptor) || ExtensionRegistryLite.isEagerlyParseMessageSets()) {
            mergeTarget.setField(fieldDescriptor, mergeTarget.parseMessageFromBytes(byteString, extensionRegistryLite, fieldDescriptor, extensionInfo.defaultInstance));
        } else {
            mergeTarget.setField(fieldDescriptor, new LazyField(extensionInfo.defaultInstance, extensionRegistryLite, byteString));
        }
    }

    public static void mergeMessageSetExtensionFromCodedStream(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, Descriptors.Descriptor descriptor, MergeTarget mergeTarget) throws IOException {
        int i2 = 0;
        ByteString byteString = null;
        ExtensionRegistry.ExtensionInfo extensionInfo = null;
        while (true) {
            int readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                i2 = codedInputStream.readUInt32();
                if (i2 != 0 && (extensionRegistryLite instanceof ExtensionRegistry)) {
                    extensionInfo = mergeTarget.findExtensionByNumber((ExtensionRegistry) extensionRegistryLite, descriptor, i2);
                }
            } else if (readTag == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                if (i2 == 0 || extensionInfo == null || !ExtensionRegistryLite.isEagerlyParseMessageSets()) {
                    byteString = codedInputStream.readBytes();
                } else {
                    eagerlyMergeMessageSetExtension(codedInputStream, extensionInfo, extensionRegistryLite, mergeTarget);
                    byteString = null;
                }
            } else if (!codedInputStream.skipField(readTag)) {
                break;
            }
        }
        codedInputStream.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
        if (byteString != null && i2 != 0) {
            if (extensionInfo != null) {
                mergeMessageSetExtensionFromBytes(byteString, extensionInfo, extensionRegistryLite, mergeTarget);
            } else if (byteString != null && builder != null) {
                builder.mergeField(i2, UnknownFieldSet.Field.newBuilder().addLengthDelimited(byteString).build());
            }
        }
    }

    public static String subMessagePrefix(String str, Descriptors.FieldDescriptor fieldDescriptor, int i2) {
        StringBuilder sb = new StringBuilder(str);
        if (fieldDescriptor.isExtension()) {
            sb.append('(');
            sb.append(fieldDescriptor.getFullName());
            sb.append(')');
        } else {
            sb.append(fieldDescriptor.getName());
        }
        if (i2 != -1) {
            sb.append('[');
            sb.append(i2);
            sb.append(']');
        }
        sb.append('.');
        return sb.toString();
    }

    public static void writeMessageTo(Message message, Map<Descriptors.FieldDescriptor, Object> map, CodedOutputStream codedOutputStream, boolean z) throws IOException {
        boolean messageSetWireFormat = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
        if (z) {
            TreeMap treeMap = new TreeMap(map);
            for (Descriptors.FieldDescriptor next : message.getDescriptorForType().getFields()) {
                if (next.isRequired() && !treeMap.containsKey(next)) {
                    treeMap.put(next, message.getField(next));
                }
            }
            map = treeMap;
        }
        for (Map.Entry next2 : map.entrySet()) {
            Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) next2.getKey();
            Object value = next2.getValue();
            if (!messageSetWireFormat || !fieldDescriptor.isExtension() || fieldDescriptor.getType() != Descriptors.FieldDescriptor.Type.MESSAGE || fieldDescriptor.isRepeated()) {
                FieldSet.writeField(fieldDescriptor, value, codedOutputStream);
            } else {
                codedOutputStream.writeMessageSetExtension(fieldDescriptor.getNumber(), (Message) value);
            }
        }
        UnknownFieldSet unknownFields = message.getUnknownFields();
        if (messageSetWireFormat) {
            unknownFields.writeAsMessageSetTo(codedOutputStream);
        } else {
            unknownFields.writeTo(codedOutputStream);
        }
    }

    public static List<String> findMissingFields(MessageOrBuilder messageOrBuilder) {
        ArrayList arrayList = new ArrayList();
        findMissingFields(messageOrBuilder, "", arrayList);
        return arrayList;
    }
}
