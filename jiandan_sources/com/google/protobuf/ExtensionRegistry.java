package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Extension;
import com.google.protobuf.GeneratedMessage;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExtensionRegistry extends ExtensionRegistryLite {
    public static final ExtensionRegistry EMPTY_REGISTRY = new ExtensionRegistry(true);
    public final Map<String, ExtensionInfo> immutableExtensionsByName;
    public final Map<DescriptorIntPair, ExtensionInfo> immutableExtensionsByNumber;
    public final Map<String, ExtensionInfo> mutableExtensionsByName;
    public final Map<DescriptorIntPair, ExtensionInfo> mutableExtensionsByNumber;

    /* renamed from: com.google.protobuf.ExtensionRegistry$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Extension$ExtensionType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.protobuf.Extension$ExtensionType[] r0 = com.google.protobuf.Extension.ExtensionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$Extension$ExtensionType = r0
                com.google.protobuf.Extension$ExtensionType r1 = com.google.protobuf.Extension.ExtensionType.IMMUTABLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$Extension$ExtensionType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.Extension$ExtensionType r1 = com.google.protobuf.Extension.ExtensionType.MUTABLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ExtensionRegistry.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class DescriptorIntPair {
        public final Descriptors.Descriptor descriptor;
        public final int number;

        public DescriptorIntPair(Descriptors.Descriptor descriptor2, int i2) {
            this.descriptor = descriptor2;
            this.number = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof DescriptorIntPair)) {
                return false;
            }
            DescriptorIntPair descriptorIntPair = (DescriptorIntPair) obj;
            if (this.descriptor == descriptorIntPair.descriptor && this.number == descriptorIntPair.number) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.descriptor.hashCode() * 65535) + this.number;
        }
    }

    public static final class ExtensionInfo {
        public final Message defaultInstance;
        public final Descriptors.FieldDescriptor descriptor;

        public /* synthetic */ ExtensionInfo(Descriptors.FieldDescriptor fieldDescriptor, Message message, AnonymousClass1 r3) {
            this(fieldDescriptor, message);
        }

        public ExtensionInfo(Descriptors.FieldDescriptor fieldDescriptor) {
            this.descriptor = fieldDescriptor;
            this.defaultInstance = null;
        }

        public ExtensionInfo(Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            this.descriptor = fieldDescriptor;
            this.defaultInstance = message;
        }
    }

    public ExtensionRegistry() {
        this.immutableExtensionsByName = new HashMap();
        this.mutableExtensionsByName = new HashMap();
        this.immutableExtensionsByNumber = new HashMap();
        this.mutableExtensionsByNumber = new HashMap();
    }

    public static ExtensionRegistry getEmptyRegistry() {
        return EMPTY_REGISTRY;
    }

    public static ExtensionInfo newExtensionInfo(Extension<?, ?> extension) {
        if (extension.getDescriptor().getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            return new ExtensionInfo(extension.getDescriptor(), (Message) null, (AnonymousClass1) null);
        }
        if (extension.getMessageDefaultInstance() != null) {
            return new ExtensionInfo(extension.getDescriptor(), extension.getMessageDefaultInstance(), (AnonymousClass1) null);
        }
        throw new IllegalStateException("Registered message-type extension had null default instance: " + extension.getDescriptor().getFullName());
    }

    public static ExtensionRegistry newInstance() {
        return new ExtensionRegistry();
    }

    public void add(Extension<?, ?> extension) {
        if (extension.getExtensionType() == Extension.ExtensionType.IMMUTABLE || extension.getExtensionType() == Extension.ExtensionType.MUTABLE) {
            add(newExtensionInfo(extension), extension.getExtensionType());
        }
    }

    @Deprecated
    public ExtensionInfo findExtensionByName(String str) {
        return findImmutableExtensionByName(str);
    }

    @Deprecated
    public ExtensionInfo findExtensionByNumber(Descriptors.Descriptor descriptor, int i2) {
        return findImmutableExtensionByNumber(descriptor, i2);
    }

    public ExtensionInfo findImmutableExtensionByName(String str) {
        return this.immutableExtensionsByName.get(str);
    }

    public ExtensionInfo findImmutableExtensionByNumber(Descriptors.Descriptor descriptor, int i2) {
        return this.immutableExtensionsByNumber.get(new DescriptorIntPair(descriptor, i2));
    }

    public ExtensionInfo findMutableExtensionByName(String str) {
        return this.mutableExtensionsByName.get(str);
    }

    public ExtensionInfo findMutableExtensionByNumber(Descriptors.Descriptor descriptor, int i2) {
        return this.mutableExtensionsByNumber.get(new DescriptorIntPair(descriptor, i2));
    }

    public Set<ExtensionInfo> getAllImmutableExtensionsByExtendedType(String str) {
        HashSet hashSet = new HashSet();
        for (DescriptorIntPair next : this.immutableExtensionsByNumber.keySet()) {
            if (next.descriptor.getFullName().equals(str)) {
                hashSet.add(this.immutableExtensionsByNumber.get(next));
            }
        }
        return hashSet;
    }

    public Set<ExtensionInfo> getAllMutableExtensionsByExtendedType(String str) {
        HashSet hashSet = new HashSet();
        for (DescriptorIntPair next : this.mutableExtensionsByNumber.keySet()) {
            if (next.descriptor.getFullName().equals(str)) {
                hashSet.add(this.mutableExtensionsByNumber.get(next));
            }
        }
        return hashSet;
    }

    public ExtensionRegistry getUnmodifiable() {
        return new ExtensionRegistry(this);
    }

    public void add(GeneratedMessage.GeneratedExtension<?, ?> generatedExtension) {
        add((Extension<?, ?>) generatedExtension);
    }

    public void add(Descriptors.FieldDescriptor fieldDescriptor) {
        if (fieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            ExtensionInfo extensionInfo = new ExtensionInfo(fieldDescriptor, (Message) null, (AnonymousClass1) null);
            add(extensionInfo, Extension.ExtensionType.IMMUTABLE);
            add(extensionInfo, Extension.ExtensionType.MUTABLE);
            return;
        }
        throw new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
    }

    public ExtensionRegistry(ExtensionRegistry extensionRegistry) {
        super((ExtensionRegistryLite) extensionRegistry);
        this.immutableExtensionsByName = Collections.unmodifiableMap(extensionRegistry.immutableExtensionsByName);
        this.mutableExtensionsByName = Collections.unmodifiableMap(extensionRegistry.mutableExtensionsByName);
        this.immutableExtensionsByNumber = Collections.unmodifiableMap(extensionRegistry.immutableExtensionsByNumber);
        this.mutableExtensionsByNumber = Collections.unmodifiableMap(extensionRegistry.mutableExtensionsByNumber);
    }

    public void add(Descriptors.FieldDescriptor fieldDescriptor, Message message) {
        if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            add(new ExtensionInfo(fieldDescriptor, message, (AnonymousClass1) null), Extension.ExtensionType.IMMUTABLE);
            return;
        }
        throw new IllegalArgumentException("ExtensionRegistry.add() provided a default instance for a non-message extension.");
    }

    public ExtensionRegistry(boolean z) {
        super(ExtensionRegistryLite.EMPTY_REGISTRY_LITE);
        this.immutableExtensionsByName = Collections.emptyMap();
        this.mutableExtensionsByName = Collections.emptyMap();
        this.immutableExtensionsByNumber = Collections.emptyMap();
        this.mutableExtensionsByNumber = Collections.emptyMap();
    }

    private void add(ExtensionInfo extensionInfo, Extension.ExtensionType extensionType) {
        Map<String, ExtensionInfo> map;
        Map<DescriptorIntPair, ExtensionInfo> map2;
        if (extensionInfo.descriptor.isExtension()) {
            int i2 = AnonymousClass1.$SwitchMap$com$google$protobuf$Extension$ExtensionType[extensionType.ordinal()];
            if (i2 == 1) {
                map = this.immutableExtensionsByName;
                map2 = this.immutableExtensionsByNumber;
            } else if (i2 == 2) {
                map = this.mutableExtensionsByName;
                map2 = this.mutableExtensionsByNumber;
            } else {
                return;
            }
            map.put(extensionInfo.descriptor.getFullName(), extensionInfo);
            map2.put(new DescriptorIntPair(extensionInfo.descriptor.getContainingType(), extensionInfo.descriptor.getNumber()), extensionInfo);
            Descriptors.FieldDescriptor fieldDescriptor = extensionInfo.descriptor;
            if (fieldDescriptor.getContainingType().getOptions().getMessageSetWireFormat() && fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && fieldDescriptor.isOptional() && fieldDescriptor.getExtensionScope() == fieldDescriptor.getMessageType()) {
                map.put(fieldDescriptor.getMessageType().getFullName(), extensionInfo);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
    }
}
