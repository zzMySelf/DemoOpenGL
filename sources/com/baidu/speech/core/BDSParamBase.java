package com.baidu.speech.core;

import com.baidu.searchbox.datadebug.constant.DataType;

public abstract class BDSParamBase {
    public String iParamType;

    public static class BDSObjectParam extends BDSParamBase {
        public Object iValue;

        public BDSObjectParam(Object value) {
            this.iParamType = "object";
            this.iValue = value;
        }
    }

    public static class BDSIntParam extends BDSParamBase {
        public int iValue;

        public BDSIntParam(int value) {
            this.iParamType = "int";
            this.iValue = value;
        }
    }

    public static class BDSBooleanParam extends BDSParamBase {
        public boolean iValue;

        public BDSBooleanParam(boolean value) {
            this.iParamType = DataType.BOOLEAN;
            this.iValue = value;
        }
    }

    public static class BDSFloatParam extends BDSParamBase {
        public float iValue;

        public BDSFloatParam(float value) {
            this.iParamType = "float";
            this.iValue = value;
        }
    }

    public static BDSIntParam intParam(int withValue) {
        return new BDSIntParam(withValue);
    }

    public static BDSBooleanParam boolParam(boolean withValue) {
        return new BDSBooleanParam(withValue);
    }

    public static BDSFloatParam floatParam(float withValue) {
        return new BDSFloatParam(withValue);
    }

    public static BDSObjectParam objectParam(Object withObject, String ofType) {
        BDSObjectParam p = new BDSObjectParam(withObject);
        if (ofType.length() > 0) {
            p.iParamType = ofType;
        }
        return p;
    }
}
