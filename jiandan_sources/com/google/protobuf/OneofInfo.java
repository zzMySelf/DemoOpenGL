package com.google.protobuf;

import java.lang.reflect.Field;

public final class OneofInfo {
    public final Field caseField;
    public final int id;
    public final Field valueField;

    public OneofInfo(int i2, Field field, Field field2) {
        this.id = i2;
        this.caseField = field;
        this.valueField = field2;
    }

    public Field getCaseField() {
        return this.caseField;
    }

    public int getId() {
        return this.id;
    }

    public Field getValueField() {
        return this.valueField;
    }
}
