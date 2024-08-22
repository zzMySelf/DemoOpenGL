package com.baidu.sofire.face.api;

public class FaceEnum {

    public enum FaceType {
        LIVE,
        IDCARD,
        WATERMARK,
        CERT,
        INFRARED
    }

    public enum ImageType {
        BASE64,
        URL,
        FACE_TOKEN
    }

    public enum LivenessControl {
        NONE,
        LOW,
        NORMAL,
        HIGH
    }

    public enum QualityControl {
        NONE,
        LOW,
        NORMAL,
        HIGH
    }

    public enum SpoofingControl {
        NONE,
        LOW,
        NORMAL,
        HIGH
    }
}
