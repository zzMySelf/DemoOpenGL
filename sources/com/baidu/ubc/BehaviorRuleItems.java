package com.baidu.ubc;

import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;

public class BehaviorRuleItems {
    public HashSet<String> abtestIdSet = new HashSet<>();
    public HashMap<String, BizParamData> bizParamDataMap = new HashMap<>();
    public HashMap<String, JSONArray> bizParamMapName = new HashMap<>();
    public HashSet<String> closedIdSet = new HashSet<>();
    public HashMap<String, ControlData> controlIds = new HashMap<>();
    public DefaultConfig defaultConfig = new DefaultConfig();
    public HashMap<String, Integer> gFlowSet = new HashMap<>();
    public HashMap<String, String> idCatMap = new HashMap<>();
    public HashSet<String> idTypeSet = new HashSet<>();
    public HashMap<String, Integer> localCacheMap = new HashMap<>();
    public HashSet<String> noCacheSet = new HashSet<>();
    public HashSet<String> nonRealTimeIdSet = new HashSet<>();
    public HashSet<String> openedSet = new HashSet<>();
    public HashSet<String> realTimeIdSet = new HashSet<>();
    public HashMap<String, Integer> sampleIdMap = new HashMap<>();
    public HashMap<String, Integer> uploadTypeMap = new HashMap<>();
}
