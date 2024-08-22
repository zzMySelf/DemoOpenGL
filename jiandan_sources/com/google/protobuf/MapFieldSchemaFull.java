package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import java.util.Map;

public class MapFieldSchemaFull implements MapFieldSchema {
    public static <K, V> int getSerializedSizeFull(int i2, Object obj, Object obj2) {
        int i3 = 0;
        if (obj == null) {
            return 0;
        }
        Map map = ((MapField) obj).getMap();
        MapEntry mapEntry = (MapEntry) obj2;
        if (map.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : map.entrySet()) {
            i3 += CodedOutputStream.computeTagSize(i2) + CodedOutputStream.computeLengthDelimitedFieldSize(MapEntryLite.computeSerializedSize(mapEntry.getMetadata(), entry.getKey(), entry.getValue()));
        }
        return i3;
    }

    public static <K, V> Object mergeFromFull(Object obj, Object obj2) {
        MapField mapField = (MapField) obj;
        MapField mapField2 = (MapField) obj2;
        if (!mapField.isMutable()) {
            mapField.copy();
        }
        mapField.mergeFrom(mapField2);
        return mapField;
    }

    public Map<?, ?> forMapData(Object obj) {
        return ((MapField) obj).getMap();
    }

    public MapEntryLite.Metadata<?, ?> forMapMetadata(Object obj) {
        return ((MapEntry) obj).getMetadata();
    }

    public Map<?, ?> forMutableMapData(Object obj) {
        return ((MapField) obj).getMutableMap();
    }

    public int getSerializedSize(int i2, Object obj, Object obj2) {
        return getSerializedSizeFull(i2, obj, obj2);
    }

    public boolean isImmutable(Object obj) {
        return !((MapField) obj).isMutable();
    }

    public Object mergeFrom(Object obj, Object obj2) {
        return mergeFromFull(obj, obj2);
    }

    public Object newMapField(Object obj) {
        return MapField.newMapField((MapEntry) obj);
    }

    public Object toImmutable(Object obj) {
        ((MapField) obj).makeImmutable();
        return obj;
    }
}
