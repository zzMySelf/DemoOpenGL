package fe.pf.qw.rg;

import com.getkeepsafe.relinker.elf.Elf;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class i extends Elf.fe {
    public i(rg rgVar, Elf.ad adVar, int i2) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(adVar.qw ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.qw = rgVar.m294switch(allocate, adVar.f4378de + ((long) (i2 * adVar.f4381th)) + 44);
    }
}
