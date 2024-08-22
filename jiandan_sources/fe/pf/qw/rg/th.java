package fe.pf.qw.rg;

import com.getkeepsafe.relinker.elf.Elf;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class th extends Elf.de {
    public th(rg rgVar, Elf.ad adVar, long j) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(adVar.qw ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = adVar.f4377ad + (j * ((long) adVar.f4379fe));
        this.qw = rgVar.m294switch(allocate, j2);
        this.f4382ad = rgVar.m294switch(allocate, 4 + j2);
        this.f4383de = rgVar.m294switch(allocate, 8 + j2);
        this.f4384fe = rgVar.m294switch(allocate, j2 + 20);
    }
}
