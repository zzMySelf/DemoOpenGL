package com.baidu.fsg.face.liveness.utils.enums;

public enum LivenessRecogType {
    RECOG_TYPE_BDUSS("recog_type_bduss", 1),
    RECOG_TYPE_AUTHTOKEN("recog_type_authtoken", 2),
    RECOG_TYPE_CERTINFO("recog_type_certinfo", 3),
    RECOG_TYPE_FACEDETECT("recog_type_facedetect", 4),
    RECOG_TYPE_OUTER("recog_type_outer", 5);
    
    private String recogTypeName;
    private int recogTypeNum;

    private LivenessRecogType(String recogTypeName2, int recogTypeNum2) {
        this.recogTypeName = recogTypeName2;
        this.recogTypeNum = recogTypeNum2;
    }

    public String getRecogTypeName() {
        return this.recogTypeName;
    }

    public int getRecogTypeNum() {
        return this.recogTypeNum;
    }
}
