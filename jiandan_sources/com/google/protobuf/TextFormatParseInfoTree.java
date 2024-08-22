package com.google.protobuf;

import com.google.protobuf.Descriptors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextFormatParseInfoTree {
    public Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
    public Map<Descriptors.FieldDescriptor, List<TextFormatParseInfoTree>> subtreesFromField;

    public static class Builder {
        public Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
        public Map<Descriptors.FieldDescriptor, List<Builder>> subtreeBuildersFromField;

        public TextFormatParseInfoTree build() {
            return new TextFormatParseInfoTree(this.locationsFromField, this.subtreeBuildersFromField);
        }

        public Builder getBuilderForSubMessageField(Descriptors.FieldDescriptor fieldDescriptor) {
            List list = this.subtreeBuildersFromField.get(fieldDescriptor);
            if (list == null) {
                list = new ArrayList();
                this.subtreeBuildersFromField.put(fieldDescriptor, list);
            }
            Builder builder = new Builder();
            list.add(builder);
            return builder;
        }

        public Builder setLocation(Descriptors.FieldDescriptor fieldDescriptor, TextFormatParseLocation textFormatParseLocation) {
            List list = this.locationsFromField.get(fieldDescriptor);
            if (list == null) {
                list = new ArrayList();
                this.locationsFromField.put(fieldDescriptor, list);
            }
            list.add(textFormatParseLocation);
            return this;
        }

        public Builder() {
            this.locationsFromField = new HashMap();
            this.subtreeBuildersFromField = new HashMap();
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static <T> T getFromList(List<T> list, int i2, Descriptors.FieldDescriptor fieldDescriptor) {
        String str;
        if (i2 < list.size() && i2 >= 0) {
            return list.get(i2);
        }
        Object[] objArr = new Object[2];
        if (fieldDescriptor == null) {
            str = "<null>";
        } else {
            str = fieldDescriptor.getName();
        }
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i2);
        throw new IllegalArgumentException(String.format("Illegal index field: %s, index %d", objArr));
    }

    public TextFormatParseLocation getLocation(Descriptors.FieldDescriptor fieldDescriptor, int i2) {
        return (TextFormatParseLocation) getFromList(getLocations(fieldDescriptor), i2, fieldDescriptor);
    }

    public List<TextFormatParseLocation> getLocations(Descriptors.FieldDescriptor fieldDescriptor) {
        List<TextFormatParseLocation> list = this.locationsFromField.get(fieldDescriptor);
        return list == null ? Collections.emptyList() : list;
    }

    public TextFormatParseInfoTree getNestedTree(Descriptors.FieldDescriptor fieldDescriptor, int i2) {
        return (TextFormatParseInfoTree) getFromList(getNestedTrees(fieldDescriptor), i2, fieldDescriptor);
    }

    public List<TextFormatParseInfoTree> getNestedTrees(Descriptors.FieldDescriptor fieldDescriptor) {
        List<TextFormatParseInfoTree> list = this.subtreesFromField.get(fieldDescriptor);
        return list == null ? Collections.emptyList() : list;
    }

    public TextFormatParseInfoTree(Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> map, Map<Descriptors.FieldDescriptor, List<Builder>> map2) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(next.getKey(), Collections.unmodifiableList((List) next.getValue()));
        }
        this.locationsFromField = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        for (Map.Entry next2 : map2.entrySet()) {
            ArrayList arrayList = new ArrayList();
            for (Builder build : (List) next2.getValue()) {
                arrayList.add(build.build());
            }
            hashMap2.put(next2.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.subtreesFromField = Collections.unmodifiableMap(hashMap2);
    }
}
