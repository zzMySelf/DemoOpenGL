package fe.i.qw.th.qw;

import com.dxmpay.apollon.restnet.converter.AbstractHttpMessageConverter;
import com.dxmpay.apollon.restnet.rest.e;
import com.dxmpay.apollon.utils.FileCopyUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class qw extends AbstractHttpMessageConverter<byte[]> {
    /* renamed from: yj */
    public byte[] rg(Class<?> cls, e eVar) throws IOException {
        long th2 = eVar.c().th();
        if (th2 < 0) {
            return FileCopyUtils.copyToByteArray(eVar.b());
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) th2);
        FileCopyUtils.copy(eVar.b(), (OutputStream) byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
