package com.baidu.talos.core.data;

import android.util.Log;
import com.baidu.talos.TalosAdapterManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public class ParamArrayImpl implements ParamArray {
    private static final boolean DEBUG = TalosAdapterManager.getHostConfig().isDebug();
    private static final String TAG = "ParamArrayImpl";
    private List<Object> mList;

    public ParamArrayImpl() {
        this.mList = new LinkedList();
    }

    public ParamArrayImpl(List<Object> list) {
        this.mList = list;
    }

    public List<Object> getList() {
        return this.mList;
    }

    public int size() {
        return this.mList.size();
    }

    public boolean isNull(int index) {
        if (this.mList.size() > index && this.mList.get(index) != null) {
            return false;
        }
        return true;
    }

    public boolean getBoolean(int index) {
        Object value = this.mList.get(index);
        if (value == null) {
            return false;
        }
        if (value instanceof Boolean) {
            return ((Boolean) value).booleanValue();
        }
        if (value instanceof Dynamic) {
            return ((Dynamic) value).asBoolean();
        }
        if (DEBUG) {
            Log.e(TAG, "[getBoolean] Property " + index + " must be boolean, but not. " + value);
        }
        return false;
    }

    public double getDouble(int index) {
        Object value = this.mList.get(index);
        if (value == null) {
            return 0.0d;
        }
        if (value instanceof Double) {
            return ((Double) value).doubleValue();
        }
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        if (value instanceof Dynamic) {
            return ((Dynamic) value).asDouble();
        }
        if (DEBUG) {
            Log.e(TAG, "[getDouble] Property " + index + " must be number, but not. " + value);
        }
        return 0.0d;
    }

    public int getInteger(int index) {
        Object value = this.mList.get(index);
        if (value == null) {
            return 0;
        }
        if (value instanceof Integer) {
            return ((Integer) value).intValue();
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        if (value instanceof Dynamic) {
            return ((Dynamic) value).asInt();
        }
        if (DEBUG) {
            Log.e(TAG, "[getInteger] Property " + index + " must be number, but not. " + value);
        }
        return 0;
    }

    public long getLong(int index) {
        Object value = this.mList.get(index);
        if (value == null) {
            return 0;
        }
        if (value instanceof Long) {
            return ((Long) value).longValue();
        }
        if (value instanceof Number) {
            return ((Number) value).longValue();
        }
        if (value instanceof Dynamic) {
            return ((Dynamic) value).asLong();
        }
        if (DEBUG) {
            Log.e(TAG, "[getLong] Property " + index + " must be number, but not. " + value);
        }
        return 0;
    }

    public String getString(int index) {
        Object value = this.mList.get(index);
        if (value == null) {
            return null;
        }
        if (value instanceof String) {
            return (String) value;
        }
        if (value instanceof Dynamic) {
            return ((Dynamic) value).asString();
        }
        if (DEBUG) {
            Log.e(TAG, "[getString] Property " + index + " must be String, but not. " + value);
        }
        return String.valueOf(value);
    }

    public ParamArray getArray(int index) {
        Object o = this.mList.get(index);
        if (o instanceof ParamArray) {
            return (ParamArray) o;
        }
        if (o instanceof Dynamic) {
            return ((Dynamic) o).asArray();
        }
        return new ParamArrayImpl(new ArrayList());
    }

    public ParamMap getMap(int index) {
        Object o = this.mList.get(index);
        if (o instanceof ParamMap) {
            return (ParamMap) o;
        }
        if (o instanceof Dynamic) {
            return ((Dynamic) o).asMap();
        }
        return new ParamMapImpl(new HashMap());
    }

    public Dynamic getDynamic(int index) {
        Object o = this.mList.get(index);
        if (o instanceof Dynamic) {
            return (Dynamic) o;
        }
        return new DynamicImpl(o);
    }

    public Object getObject(int index) {
        return this.mList.get(index);
    }

    public ParamType getType(int index) {
        Object object = this.mList.get(index);
        if (object == null) {
            return ParamType.Null;
        }
        if (object instanceof Boolean) {
            return ParamType.Boolean;
        }
        if ((object instanceof Double) || (object instanceof Float) || (object instanceof Integer) || (object instanceof Long)) {
            return ParamType.Number;
        }
        if (object instanceof String) {
            return ParamType.String;
        }
        if (object instanceof ParamArray) {
            return ParamType.Array;
        }
        if (object instanceof ParamMap) {
            return ParamType.Map;
        }
        if (object instanceof Dynamic) {
            return ParamType.Dynamic;
        }
        return ParamType.Undefine;
    }

    public void pushNull() {
        this.mList.add((Object) null);
    }

    public void pushBoolean(boolean value) {
        this.mList.add(Boolean.valueOf(value));
    }

    public void pushDouble(double value) {
        this.mList.add(Double.valueOf(value));
    }

    public void pushInteger(int value) {
        this.mList.add(Integer.valueOf(value));
    }

    public void pushLong(long value) {
        this.mList.add(Long.valueOf(value));
    }

    public void pushString(String value) {
        this.mList.add(value);
    }

    public void pushArray(ParamArray value) {
        this.mList.add(value);
    }

    public void pushMap(ParamMap value) {
        this.mList.add(value);
    }

    public void pushObject(Object value) {
        this.mList.add(value);
    }

    public void putDynamic(Dynamic value) {
        if (value.getType() == ParamType.Number) {
            pushDouble(value.asDouble());
        } else if (value.getType() == ParamType.String) {
            pushString(value.asString());
        } else if (value.getType() == ParamType.Boolean) {
            pushBoolean(value.asBoolean());
        } else if (value.getType() == ParamType.Map) {
            pushMap(value.asMap());
        } else if (value.getType() == ParamType.Array) {
            pushArray(value.asArray());
        } else {
            pushNull();
        }
    }

    public String toString() {
        try {
            JSONArray jsonArray = DataBufferConverUtils.convertToJSONArray(this.mList);
            if (jsonArray == null) {
                return null;
            }
            return jsonArray.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
