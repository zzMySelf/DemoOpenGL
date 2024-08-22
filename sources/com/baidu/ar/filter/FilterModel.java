package com.baidu.ar.filter;

import java.util.List;

public class FilterModel {

    /* renamed from: a  reason: collision with root package name */
    private String f9507a;

    /* renamed from: b  reason: collision with root package name */
    private String f9508b;

    /* renamed from: c  reason: collision with root package name */
    private List<Object> f9509c;

    public String getFilterName() {
        return this.f9508b;
    }

    public String getFilterType() {
        return this.f9507a;
    }

    public List<Object> getUniformList() {
        return this.f9509c;
    }

    public void setFilterName(String str) {
        this.f9508b = str;
    }

    public void setFilterType(String str) {
        this.f9507a = str;
    }

    public void setUniformList(List<Object> list) {
        this.f9509c = list;
    }
}
