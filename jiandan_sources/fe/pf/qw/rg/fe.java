package fe.pf.qw.rg;

import com.getkeepsafe.relinker.elf.Elf;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class fe extends Elf.ad {

    /* renamed from: yj  reason: collision with root package name */
    public final rg f4643yj;

    public fe(boolean z, rg rgVar) throws IOException {
        this.qw = z;
        this.f4643yj = rgVar;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        rgVar.yj(allocate, 16);
        this.f4377ad = rgVar.uk(allocate, 32);
        this.f4378de = rgVar.uk(allocate, 40);
        this.f4379fe = rgVar.yj(allocate, 54);
        this.f4380rg = rgVar.yj(allocate, 56);
        this.f4381th = rgVar.yj(allocate, 58);
        rgVar.yj(allocate, 60);
        rgVar.yj(allocate, 62);
    }

    public Elf.de ad(long j) throws IOException {
        return new yj(this.f4643yj, this, j);
    }

    public Elf.fe de(int i2) throws IOException {
        return new i(this.f4643yj, this, i2);
    }

    public Elf.qw qw(long j, int i2) throws IOException {
        return new ad(this.f4643yj, this, j, i2);
    }
}
