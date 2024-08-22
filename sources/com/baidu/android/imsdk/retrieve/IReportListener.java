package com.baidu.android.imsdk.retrieve;

public interface IReportListener {
    void onFailure();

    void onSuccess(ReportResult reportResult);
}
