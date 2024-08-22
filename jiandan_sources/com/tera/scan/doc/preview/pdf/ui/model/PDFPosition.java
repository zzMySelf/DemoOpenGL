package com.tera.scan.doc.preview.pdf.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class PDFPosition implements Parcelable {
    public static final Parcelable.Creator<PDFPosition> CREATOR = new qw();
    @SerializedName("offset_x")
    public float mOffsetX;
    @SerializedName("offset_y")
    public float mOffsetY;
    @SerializedName("page")
    public int mPage;
    @SerializedName("swipe_vertical")
    public boolean mSwipeVertical;
    @SerializedName("zoom")
    public float mZoom;

    public class qw implements Parcelable.Creator<PDFPosition> {
        /* renamed from: ad */
        public PDFPosition[] newArray(int i2) {
            return new PDFPosition[i2];
        }

        /* renamed from: qw */
        public PDFPosition createFromParcel(Parcel parcel) {
            return new PDFPosition(parcel);
        }
    }

    public PDFPosition() {
    }

    public int describeContents() {
        return 0;
    }

    public float getOffsetX() {
        return this.mOffsetX;
    }

    public float getOffsetY() {
        return this.mOffsetY;
    }

    public int getPage() {
        return this.mPage;
    }

    public float getZoom() {
        return this.mZoom;
    }

    public boolean isSwipeVertical() {
        return this.mSwipeVertical;
    }

    public void setOffsetX(float f) {
        this.mOffsetX = f;
    }

    public void setOffsetY(float f) {
        this.mOffsetY = f;
    }

    public void setPage(int i2) {
        this.mPage = i2;
    }

    public void setSwipeVertical(boolean z) {
        this.mSwipeVertical = z;
    }

    public void setZoom(float f) {
        this.mZoom = f;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.mSwipeVertical ? (byte) 1 : 0);
        parcel.writeInt(this.mPage);
        parcel.writeFloat(this.mZoom);
        parcel.writeFloat(this.mOffsetX);
        parcel.writeFloat(this.mOffsetY);
    }

    public PDFPosition(Parcel parcel) {
        this.mSwipeVertical = parcel.readByte() != 0;
        this.mPage = parcel.readInt();
        this.mZoom = parcel.readFloat();
        this.mOffsetX = parcel.readFloat();
        this.mOffsetY = parcel.readFloat();
    }
}
