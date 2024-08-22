package com.google.protobuf.util;

import com.baidu.android.common.others.IStringUtil;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.protobuf.Descriptors;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Message;
import com.google.protobuf.util.FieldMaskUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Logger;

public final class FieldMaskTree {
    public static final String FIELD_PATH_SEPARATOR_REGEX = "\\.";
    public static final Logger logger = Logger.getLogger(FieldMaskTree.class.getName());
    public final Node root = new Node();

    public static final class Node {
        public final SortedMap<String, Node> children;

        public Node() {
            this.children = new TreeMap();
        }
    }

    public FieldMaskTree() {
    }

    private void getFieldPaths(Node node, String str, List<String> list) {
        String str2;
        if (node.children.isEmpty()) {
            list.add(str);
            return;
        }
        for (Map.Entry next : node.children.entrySet()) {
            if (str.isEmpty()) {
                str2 = (String) next.getKey();
            } else {
                str2 = str + IStringUtil.CURRENT_PATH + ((String) next.getKey());
            }
            getFieldPaths((Node) next.getValue(), str2, list);
        }
    }

    @CanIgnoreReturnValue
    public FieldMaskTree addFieldPath(String str) {
        String[] split = str.split("\\.");
        if (split.length == 0) {
            return this;
        }
        Node node = this.root;
        boolean z = false;
        for (String str2 : split) {
            if (!z && node != this.root && node.children.isEmpty()) {
                return this;
            }
            if (node.children.containsKey(str2)) {
                node = (Node) node.children.get(str2);
            } else {
                Node node2 = new Node();
                node.children.put(str2, node2);
                node = node2;
                z = true;
            }
        }
        node.children.clear();
        return this;
    }

    public void intersectFieldPath(String str, FieldMaskTree fieldMaskTree) {
        if (!this.root.children.isEmpty()) {
            String[] split = str.split("\\.");
            if (split.length != 0) {
                Node node = this.root;
                int length = split.length;
                int i2 = 0;
                while (i2 < length) {
                    String str2 = split[i2];
                    if (node != this.root && node.children.isEmpty()) {
                        fieldMaskTree.addFieldPath(str);
                        return;
                    } else if (node.children.containsKey(str2)) {
                        node = (Node) node.children.get(str2);
                        i2++;
                    } else {
                        return;
                    }
                }
                ArrayList<String> arrayList = new ArrayList<>();
                getFieldPaths(node, str, arrayList);
                for (String addFieldPath : arrayList) {
                    fieldMaskTree.addFieldPath(addFieldPath);
                }
            }
        }
    }

    public void merge(Message message, Message.Builder builder, FieldMaskUtil.MergeOptions mergeOptions) {
        if (message.getDescriptorForType() != builder.getDescriptorForType()) {
            throw new IllegalArgumentException("Cannot merge messages of different types.");
        } else if (!this.root.children.isEmpty()) {
            merge(this.root, "", message, builder, mergeOptions);
        }
    }

    @CanIgnoreReturnValue
    public FieldMaskTree mergeFromFieldMask(FieldMask fieldMask) {
        for (String addFieldPath : fieldMask.getPathsList()) {
            addFieldPath(addFieldPath);
        }
        return this;
    }

    public FieldMask toFieldMask() {
        if (this.root.children.isEmpty()) {
            return FieldMask.getDefaultInstance();
        }
        ArrayList arrayList = new ArrayList();
        getFieldPaths(this.root, "", arrayList);
        return FieldMask.newBuilder().addAllPaths(arrayList).build();
    }

    public String toString() {
        return FieldMaskUtil.toString(toFieldMask());
    }

    public FieldMaskTree(FieldMask fieldMask) {
        mergeFromFieldMask(fieldMask);
    }

    private void merge(Node node, String str, Message message, Message.Builder builder, FieldMaskUtil.MergeOptions mergeOptions) {
        String str2;
        if (message.getDescriptorForType() == builder.getDescriptorForType()) {
            Descriptors.Descriptor descriptorForType = message.getDescriptorForType();
            for (Map.Entry next : node.children.entrySet()) {
                Descriptors.FieldDescriptor findFieldByName = descriptorForType.findFieldByName((String) next.getKey());
                if (findFieldByName == null) {
                    logger.warning("Cannot find field \"" + ((String) next.getKey()) + "\" in message type " + descriptorForType.getFullName());
                } else if (!((Node) next.getValue()).children.isEmpty()) {
                    if (findFieldByName.isRepeated() || findFieldByName.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        logger.warning("Field \"" + findFieldByName.getFullName() + "\" is not a singular message field and cannot have sub-fields.");
                    } else if (message.hasField(findFieldByName) || builder.hasField(findFieldByName)) {
                        if (str.isEmpty()) {
                            str2 = (String) next.getKey();
                        } else {
                            str2 = str + IStringUtil.CURRENT_PATH + ((String) next.getKey());
                        }
                        String str3 = str2;
                        Message.Builder builder2 = ((Message) builder.getField(findFieldByName)).toBuilder();
                        merge((Node) next.getValue(), str3, (Message) message.getField(findFieldByName), builder2, mergeOptions);
                        builder.setField(findFieldByName, builder2.buildPartial());
                    }
                } else if (findFieldByName.isRepeated()) {
                    if (mergeOptions.replaceRepeatedFields()) {
                        builder.setField(findFieldByName, message.getField(findFieldByName));
                    } else {
                        for (Object addRepeatedField : (List) message.getField(findFieldByName)) {
                            builder.addRepeatedField(findFieldByName, addRepeatedField);
                        }
                    }
                } else if (findFieldByName.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    if (mergeOptions.replaceMessageFields()) {
                        if (!message.hasField(findFieldByName)) {
                            builder.clearField(findFieldByName);
                        } else {
                            builder.setField(findFieldByName, message.getField(findFieldByName));
                        }
                    } else if (message.hasField(findFieldByName)) {
                        builder.setField(findFieldByName, ((Message) builder.getField(findFieldByName)).toBuilder().mergeFrom((Message) message.getField(findFieldByName)).build());
                    }
                } else if (message.hasField(findFieldByName) || !mergeOptions.replacePrimitiveFields()) {
                    builder.setField(findFieldByName, message.getField(findFieldByName));
                } else {
                    builder.clearField(findFieldByName);
                }
            }
            return;
        }
        throw new IllegalArgumentException(String.format("source (%s) and destination (%s) descriptor must be equal", new Object[]{message.getDescriptorForType(), builder.getDescriptorForType()}));
    }
}
