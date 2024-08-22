package fe.pf.qw.rg;

import com.getkeepsafe.relinker.elf.Elf;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class de extends Elf.ad {

    /* renamed from: yj  reason: collision with root package name */
    public final rg f4642yj;

    public de(boolean z, rg rgVar) throws IOException {
        this.qw = z;
        this.f4642yj = rgVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        rgVar.yj(allocate, 16);
        this.f4377ad = rgVar.m294switch(allocate, 28);
        this.f4378de = rgVar.m294switch(allocate, 32);
        this.f4379fe = rgVar.yj(allocate, 42);
        this.f4380rg = rgVar.yj(allocate, 44);
        this.f4381th = rgVar.yj(allocate, 46);
        rgVar.yj(allocate, 48);
        rgVar.yj(allocate, 50);
    }

    public Elf.de ad(long j) throws IOException {
        return new th(this.f4642yj, this, j);
    }

    public Elf.fe de(int i2) throws IOException {
        return new uk(this.f4642yj, this, i2);
    }

    public Elf.qw qw(long j, int i2) throws IOException {
        return new qw(this.f4642yj, this, j, i2);
    }
}
