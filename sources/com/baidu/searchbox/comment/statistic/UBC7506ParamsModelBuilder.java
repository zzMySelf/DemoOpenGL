package com.baidu.searchbox.comment.statistic;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/comment/statistic/UBC7506ParamsModelBuilder;", "", "()V", "component_type", "", "getUrlNum", "page", "reportUrl", "result", "type", "value", "build", "Lcom/baidu/searchbox/comment/statistic/UBC7506ParamsModel;", "setComponentType", "setPage", "setReportUrl", "setResult", "setType", "setUrlNum", "setValue", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UBC7506ParamsModel.kt */
public final class UBC7506ParamsModelBuilder {
    private String component_type;
    private String getUrlNum;
    private String page;
    private String reportUrl;
    private String result;
    private String type;
    private String value;

    public final UBC7506ParamsModelBuilder setPage(String page2) {
        this.page = page2;
        return this;
    }

    public final UBC7506ParamsModelBuilder setValue(String value2) {
        this.value = value2;
        return this;
    }

    public final UBC7506ParamsModelBuilder setType(String type2) {
        this.type = type2;
        return this;
    }

    public final UBC7506ParamsModelBuilder setUrlNum(String page2) {
        this.getUrlNum = page2;
        return this;
    }

    public final UBC7506ParamsModelBuilder setResult(String page2) {
        this.result = page2;
        return this;
    }

    public final UBC7506ParamsModelBuilder setReportUrl(String page2) {
        this.reportUrl = page2;
        return this;
    }

    public final UBC7506ParamsModelBuilder setComponentType(String page2) {
        this.component_type = page2;
        return this;
    }

    public final UBC7506ParamsModel build() {
        return new UBC7506ParamsModel(this.page, this.value, this.type, this.getUrlNum, this.result, this.reportUrl, this.component_type);
    }
}
