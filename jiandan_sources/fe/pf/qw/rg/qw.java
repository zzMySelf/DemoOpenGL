package fe.pf.qw.rg;

import com.getkeepsafe.relinker.elf.Elf;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class qw extends Elf.qw {
    public qw(rg rgVar, Elf.ad adVar, long j, int i2) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(adVar.qw ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + ((long) (i2 * 8));
        this.qw = rgVar.m294switch(allocate, j2);
        this.f4385ad = rgVar.m294switch(allocate, j2 + 4);
    }
}
