package com.baidu.ubc.bypass;

public enum BypassConstants$Funnel {
    INIT_START("initStart"),
    INIT_SUCCESS("initSuccess"),
    INIT_FAIL("initFailed"),
    INIT_THREAD_SUCC("initThreadSucc"),
    INIT_UPLOAD_THREAD_SUCC("initUpThreadSucc"),
    INIT_INNER_START("initInnerStart"),
    INIT_DATABASE_UPLOADER_SUCCESS("initDbUpSucc"),
    INIT_RULE_MANAGER_SUCCESS("initRuleSucc"),
    INIT_TIMING_MANAGER_SUCCESS("initTimingSucc"),
    CALL_ON_EVENT("onEvent"),
    CALL_ON_FLOW("onFlow"),
    INNER_EVENT("innerEvent"),
    INNER_EVENT_ERROR("innerEventErr"),
    INNER_FLOW("innerFlow"),
    INNER_FLOW_ERROR("innerFlowErr"),
    SAMPLE_EVENT("sampleEvent"),
    SAMPLE_FLOW("sampleFlow"),
    CACHE_EVENT("cacheEvent"),
    DB_SUCCESS_EVENT("dbsuccEvent"),
    DB_ERROR_EVENT("dberrEvent"),
    DB_SUCCESS_FLOW("dbsuccFlow"),
    DB_ERROR_FLOW("dberrFlow"),
    PACKAGE_QUERY("package"),
    PACKAGE_QUERY_EVENT("packageEvent"),
    PACKAGE_QUERY_FLOW("packageFlow"),
    PACKAGE_TO_FILE("packageToFile"),
    PACKAGE_TO_FILE_EVENT("packageToFileEvent"),
    PACKAGE_TO_FILE_FLOW("packageToFileFlow"),
    UPLOAD_START("upst"),
    UPLOAD_SUCCESS("upsucc"),
    UPLOAD_ERROR("uperr");
    
    public final String name;

    /* access modifiers changed from: public */
    BypassConstants$Funnel(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
