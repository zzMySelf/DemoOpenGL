package com.terascan.algo;

import java.util.ArrayList;

public class DocumentResult {
    public int code;
    public ArrayList<Point> points;

    public int getCode() {
        return this.code;
    }

    public ArrayList<Point> getPoints() {
        return this.points;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setPoints(ArrayList<Point> arrayList) {
        this.points = arrayList;
    }
}
