package fe.pf.qw.rg;

import com.getkeepsafe.relinker.elf.Elf;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class yj extends Elf.de {
    public yj(rg rgVar, Elf.ad adVar, long j) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(adVar.qw ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = adVar.f4377ad + (j * ((long) adVar.f4379fe));
        this.qw = rgVar.m294switch(allocate, j2);
        this.f4382ad = rgVar.uk(allocate, 8 + j2);
        this.f4383de = rgVar.uk(allocate, 16 + j2);
        this.f4384fe = rgVar.uk(allocate, j2 + 40);
    }
}
