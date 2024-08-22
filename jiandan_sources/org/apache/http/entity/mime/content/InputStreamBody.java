package org.apache.http.entity.mime.content;

import com.baidubce.util.Mimetypes;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.mime.MIME;

public class InputStreamBody extends AbstractContentBody {
    public final String filename;
    public final InputStream in;

    public InputStreamBody(InputStream inputStream, String str, String str2) {
        super(str);
        if (inputStream != null) {
            this.in = inputStream;
            this.filename = str2;
            return;
        }
        throw new IllegalArgumentException("Input stream may not be null");
    }

    public String getCharset() {
        return null;
    }

    public long getContentLength() {
        return -1;
    }

    public String getFilename() {
        return this.filename;
    }

    public InputStream getInputStream() {
        return this.in;
    }

    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = this.in.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        return;
                    }
                }
            } finally {
                this.in.close();
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }

    public InputStreamBody(InputStream inputStream, String str) {
        this(inputStream, Mimetypes.MIMETYPE_OCTET_STREAM, str);
    }
}
