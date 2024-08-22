package com.baidu.searchbox.comment.list;

public class CommonData {
    private Object object;
    private int type;

    public CommonData() {
    }

    public CommonData(int type2, Object object2) {
        this.type = type2;
        this.object = object2;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type2) {
        this.type = type2;
    }

    public Object getObject() {
        return this.object;
    }

    public void setObject(Object object2) {
        this.object = object2;
    }
}
