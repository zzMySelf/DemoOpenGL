package com.baidu.sapi2.share.face;

public class FaceLoginModel implements Comparable<FaceLoginModel> {
    public String livingUname;
    public long time;

    public FaceLoginModel(String str, long j) {
        this.livingUname = str;
        this.time = j;
    }

    public int compareTo(FaceLoginModel faceLoginModel) {
        long j = faceLoginModel.time;
        long j2 = this.time;
        if (j - j2 > 0) {
            return -1;
        }
        return j - j2 == 0 ? 0 : 1;
    }
}
