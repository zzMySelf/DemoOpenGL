package com.baidu.searchbox.elasticthread.statistic;

public interface Recordable {

    public enum RecordStatus {
        UNINITIATED,
        RECORDING,
        RECORD_END
    }
}
