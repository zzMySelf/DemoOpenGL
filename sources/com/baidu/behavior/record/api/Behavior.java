package com.baidu.behavior.record.api;

public class Behavior {
    private int behaviorType = 0;
    private String infoName;
    private String purpose = "";
    private String scene = "";
    private int useCount = 1;

    public Behavior() {
    }

    public Behavior(int behaviorType2, String infoNameId, String purposeId, String scene2) {
        this.behaviorType = behaviorType2;
        this.infoName = infoNameId;
        this.purpose = purposeId;
        this.scene = scene2;
    }

    public int getBehaviorType() {
        return this.behaviorType;
    }

    public Behavior setBehaviorType(int behaviorType2) {
        this.behaviorType = behaviorType2;
        return this;
    }

    public String getInfoName() {
        return this.infoName;
    }

    public Behavior setInfoName(String infoName2) {
        this.infoName = infoName2;
        return this;
    }

    public String getPurpose() {
        return this.purpose;
    }

    public Behavior setPurpose(String purpose2) {
        this.purpose = purpose2;
        return this;
    }

    public String getScene() {
        return this.scene;
    }

    public Behavior setScene(String scene2) {
        this.scene = scene2;
        return this;
    }

    public int getUseCount() {
        return this.useCount;
    }

    public Behavior setUseCount(int useCount2) {
        this.useCount = useCount2;
        return this;
    }
}
