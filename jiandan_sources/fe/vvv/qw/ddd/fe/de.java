package fe.vvv.qw.ddd.fe;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;
import java.util.Random;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public static final Random f8892ad = new Random();
    public final ByteBuffer qw;

    public de(@NonNull qw qwVar) {
        Objects.requireNonNull(qwVar);
        this.qw = ByteBuffer.allocateDirect(qwVar.th() * 1).order(ByteOrder.nativeOrder());
        double d = 0.0d;
        double th2 = 3.141592653589793d / (((double) qwVar.th()) / 2.0d);
        while (this.qw.hasRemaining()) {
            d += 1.0d;
            short sin = (short) ((int) (Math.sin(d * th2) * 10.0d));
            this.qw.put((byte) sin);
            this.qw.put((byte) (sin >> 8));
        }
        this.qw.rewind();
    }

    public void qw(@NonNull ByteBuffer byteBuffer) {
        this.qw.clear();
        if (this.qw.capacity() == byteBuffer.remaining()) {
            this.qw.position(0);
        } else {
            ByteBuffer byteBuffer2 = this.qw;
            byteBuffer2.position(f8892ad.nextInt(byteBuffer2.capacity() - byteBuffer.remaining()));
        }
        ByteBuffer byteBuffer3 = this.qw;
        byteBuffer3.limit(byteBuffer3.position() + byteBuffer.remaining());
        byteBuffer.put(this.qw);
    }
}
