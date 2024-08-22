package org.apache.http.entity.mime.content;

import com.baidubce.util.Mimetypes;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.entity.mime.MIME;

public class ByteArrayBody extends AbstractContentBody {
    public final byte[] data;
    public final String filename;

    public ByteArrayBody(byte[] bArr, String str, String str2) {
        super(str);
        if (bArr != null) {
            this.data = bArr;
            this.filename = str2;
            return;
        }
        throw new IllegalArgumentException("byte[] may not be null");
    }

    public String getCharset() {
        return null;
    }

    public long getContentLength() {
        return (long) this.data.length;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.data);
    }

    public ByteArrayBody(byte[] bArr, String str) {
        this(bArr, Mimetypes.MIMETYPE_OCTET_STREAM, str);
    }
}
