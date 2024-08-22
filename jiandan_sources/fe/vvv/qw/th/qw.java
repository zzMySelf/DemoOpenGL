package fe.vvv.qw.th;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.AudioCodec;
import com.otaliastudios.cameraview.controls.Engine;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Grid;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.Preview;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.controls.WhiteBalance;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public int f9087ad;

    /* renamed from: de  reason: collision with root package name */
    public int f9088de;

    /* renamed from: fe  reason: collision with root package name */
    public int f9089fe;

    /* renamed from: i  reason: collision with root package name */
    public int f9090i;

    /* renamed from: if  reason: not valid java name */
    public int f392if;

    /* renamed from: o  reason: collision with root package name */
    public int f9091o;

    /* renamed from: pf  reason: collision with root package name */
    public int f9092pf;
    public int qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f9093rg;

    /* renamed from: th  reason: collision with root package name */
    public int f9094th;

    /* renamed from: uk  reason: collision with root package name */
    public int f9095uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f9096yj;

    public qw(@NonNull Context context, @NonNull TypedArray typedArray) {
        this.qw = typedArray.getInteger(37, Preview.DEFAULT.value());
        this.f9087ad = typedArray.getInteger(7, Facing.defaultValue(context).value());
        this.f9088de = typedArray.getInteger(9, Flash.DEFAULT.value());
        this.f9089fe = typedArray.getInteger(20, Grid.DEFAULT.value());
        this.f9093rg = typedArray.getInteger(57, WhiteBalance.DEFAULT.value());
        this.f9094th = typedArray.getInteger(23, Mode.DEFAULT.value());
        this.f9096yj = typedArray.getInteger(22, Hdr.DEFAULT.value());
        this.f9095uk = typedArray.getInteger(0, Audio.DEFAULT.value());
        this.f9090i = typedArray.getInteger(45, VideoCodec.DEFAULT.value());
        this.f9091o = typedArray.getInteger(2, AudioCodec.DEFAULT.value());
        this.f9092pf = typedArray.getInteger(5, Engine.DEFAULT.value());
        this.f392if = typedArray.getInteger(24, PictureFormat.DEFAULT.value());
    }

    @NonNull
    public AudioCodec ad() {
        return AudioCodec.fromValue(this.f9091o);
    }

    @NonNull
    public Engine de() {
        return Engine.fromValue(this.f9092pf);
    }

    @NonNull
    public Facing fe() {
        return Facing.fromValue(this.f9087ad);
    }

    @NonNull
    public PictureFormat i() {
        return PictureFormat.fromValue(this.f392if);
    }

    @NonNull
    /* renamed from: if  reason: not valid java name */
    public WhiteBalance m1040if() {
        return WhiteBalance.fromValue(this.f9093rg);
    }

    @NonNull
    public Preview o() {
        return Preview.fromValue(this.qw);
    }

    @NonNull
    public VideoCodec pf() {
        return VideoCodec.fromValue(this.f9090i);
    }

    @NonNull
    public Audio qw() {
        return Audio.fromValue(this.f9095uk);
    }

    @NonNull
    public Flash rg() {
        return Flash.fromValue(this.f9088de);
    }

    @NonNull
    public Grid th() {
        return Grid.fromValue(this.f9089fe);
    }

    @NonNull
    public Mode uk() {
        return Mode.fromValue(this.f9094th);
    }

    @NonNull
    public Hdr yj() {
        return Hdr.fromValue(this.f9096yj);
    }
}
