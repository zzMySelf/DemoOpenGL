package com.google.protobuf;

import com.google.protobuf.Descriptors;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class TypeRegistry {
    public static final Logger logger = Logger.getLogger(TypeRegistry.class.getName());
    public final Map<String, Descriptors.Descriptor> types;

    public static final class Builder {
        public final Set<String> files;
        public Map<String, Descriptors.Descriptor> types;

        private void addFile(Descriptors.FileDescriptor fileDescriptor) {
            if (this.files.add(fileDescriptor.getFullName())) {
                for (Descriptors.FileDescriptor addFile : fileDescriptor.getDependencies()) {
                    addFile(addFile);
                }
                for (Descriptors.Descriptor addMessage : fileDescriptor.getMessageTypes()) {
                    addMessage(addMessage);
                }
            }
        }

        private void addMessage(Descriptors.Descriptor descriptor) {
            for (Descriptors.Descriptor addMessage : descriptor.getNestedTypes()) {
                addMessage(addMessage);
            }
            if (this.types.containsKey(descriptor.getFullName())) {
                Logger access$200 = TypeRegistry.logger;
                access$200.warning("Type " + descriptor.getFullName() + " is added multiple times.");
                return;
            }
            this.types.put(descriptor.getFullName(), descriptor);
        }

        public Builder add(Descriptors.Descriptor descriptor) {
            if (this.types != null) {
                addFile(descriptor.getFile());
                return this;
            }
            throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
        }

        public TypeRegistry build() {
            TypeRegistry typeRegistry = new TypeRegistry(this.types);
            this.types = null;
            return typeRegistry;
        }

        public Builder() {
            this.files = new HashSet();
            this.types = new HashMap();
        }

        public Builder add(Iterable<Descriptors.Descriptor> iterable) {
            if (this.types != null) {
                for (Descriptors.Descriptor file : iterable) {
                    addFile(file.getFile());
                }
                return this;
            }
            throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
        }
    }

    public static class EmptyTypeRegistryHolder {
        public static final TypeRegistry EMPTY = new TypeRegistry(Collections.emptyMap());
    }

    public TypeRegistry(Map<String, Descriptors.Descriptor> map) {
        this.types = map;
    }

    public static TypeRegistry getEmptyTypeRegistry() {
        return EmptyTypeRegistryHolder.EMPTY;
    }

    public static String getTypeName(String str) throws InvalidProtocolBufferException {
        String[] split = str.split("/");
        if (split.length != 1) {
            return split[split.length - 1];
        }
        throw new InvalidProtocolBufferException("Invalid type url found: " + str);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Descriptors.Descriptor find(String str) {
        return this.types.get(str);
    }

    public final Descriptors.Descriptor getDescriptorForTypeUrl(String str) throws InvalidProtocolBufferException {
        return find(getTypeName(str));
    }
}
