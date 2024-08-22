package fe.vvv.qw;

import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.AudioCodec;
import com.otaliastudios.cameraview.controls.Control;
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
import fe.vvv.qw.xxx.qw;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class ad {

    /* renamed from: ad  reason: collision with root package name */
    public Set<Facing> f8865ad = new HashSet(2);

    /* renamed from: de  reason: collision with root package name */
    public Set<Flash> f8866de = new HashSet(4);

    /* renamed from: fe  reason: collision with root package name */
    public Set<Hdr> f8867fe = new HashSet(2);
    public float ggg;

    /* renamed from: i  reason: collision with root package name */
    public Set<PictureFormat> f8868i = new HashSet(2);

    /* renamed from: if  reason: not valid java name */
    public boolean f361if;

    /* renamed from: o  reason: collision with root package name */
    public Set<Integer> f8869o = new HashSet(2);

    /* renamed from: pf  reason: collision with root package name */
    public boolean f8870pf;
    public boolean ppp;
    public Set<WhiteBalance> qw = new HashSet(5);

    /* renamed from: rg  reason: collision with root package name */
    public Set<fe.vvv.qw.xxx.ad> f8871rg = new HashSet(15);

    /* renamed from: switch  reason: not valid java name */
    public float f362switch;

    /* renamed from: th  reason: collision with root package name */
    public Set<fe.vvv.qw.xxx.ad> f8872th = new HashSet(5);

    /* renamed from: uk  reason: collision with root package name */
    public Set<qw> f8873uk = new HashSet(3);
    public float vvv;
    public float when;

    /* renamed from: yj  reason: collision with root package name */
    public Set<qw> f8874yj = new HashSet(4);

    public final float ad() {
        return this.f362switch;
    }

    public final float de() {
        return this.vvv;
    }

    public final float fe() {
        return this.ggg;
    }

    public final boolean ggg(@NonNull Control control) {
        return rg(control.getClass()).contains(control);
    }

    @NonNull
    public final Collection<PictureFormat> i() {
        return Collections.unmodifiableSet(this.f8868i);
    }

    @NonNull
    /* renamed from: if  reason: not valid java name */
    public final Collection<WhiteBalance> m1024if() {
        return Collections.unmodifiableSet(this.qw);
    }

    @NonNull
    public final Collection<fe.vvv.qw.xxx.ad> o() {
        return Collections.unmodifiableSet(this.f8871rg);
    }

    @NonNull
    public final Collection<fe.vvv.qw.xxx.ad> pf() {
        return Collections.unmodifiableSet(this.f8872th);
    }

    public final boolean ppp() {
        return this.f8870pf;
    }

    public final float qw() {
        return this.when;
    }

    @NonNull
    public final <T extends Control> Collection<T> rg(@NonNull Class<T> cls) {
        if (cls.equals(Audio.class)) {
            return Arrays.asList(Audio.values());
        }
        if (cls.equals(Facing.class)) {
            return th();
        }
        if (cls.equals(Flash.class)) {
            return yj();
        }
        if (cls.equals(Grid.class)) {
            return Arrays.asList(Grid.values());
        }
        if (cls.equals(Hdr.class)) {
            return uk();
        }
        if (cls.equals(Mode.class)) {
            return Arrays.asList(Mode.values());
        }
        if (cls.equals(VideoCodec.class)) {
            return Arrays.asList(VideoCodec.values());
        }
        if (cls.equals(AudioCodec.class)) {
            return Arrays.asList(AudioCodec.values());
        }
        if (cls.equals(WhiteBalance.class)) {
            return m1024if();
        }
        if (cls.equals(Engine.class)) {
            return Arrays.asList(Engine.values());
        }
        if (cls.equals(Preview.class)) {
            return Arrays.asList(Preview.values());
        }
        if (cls.equals(PictureFormat.class)) {
            return i();
        }
        return Collections.emptyList();
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m1025switch() {
        return this.ppp;
    }

    @NonNull
    public final Collection<Facing> th() {
        return Collections.unmodifiableSet(this.f8865ad);
    }

    @NonNull
    public final Collection<Hdr> uk() {
        return Collections.unmodifiableSet(this.f8867fe);
    }

    public final boolean when() {
        return this.f361if;
    }

    @NonNull
    public final Collection<Flash> yj() {
        return Collections.unmodifiableSet(this.f8866de);
    }
}
