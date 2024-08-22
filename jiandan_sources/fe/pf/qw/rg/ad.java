package fe.pf.qw.rg;

import com.getkeepsafe.relinker.elf.Elf;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ad extends Elf.qw {
    public ad(rg rgVar, Elf.ad adVar, long j, int i2) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(adVar.qw ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + ((long) (i2 * 16));
        this.qw = rgVar.uk(allocate, j2);
        this.f4385ad = rgVar.uk(allocate, j2 + 8);
    }
}
