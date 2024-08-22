package fe.when.ad.f;

import com.itextpdf.text.pdf.BadPdfFormatException;
import fe.when.ad.c.qw;
import fe.when.ad.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class i0 extends v1 {
    public s0 qqq = null;

    public i0(i iVar, String str, l0 l0Var) throws BadPdfFormatException {
        String str2;
        InputStream inputStream = null;
        if (str == null) {
            r(iVar);
        } else {
            this.qqq = new s0(str);
        }
        h(s0.K5, s0.v6);
        h(s0.b5, s0.c2);
        h(s0.l6, new v0(iVar.rrr()));
        h(s0.Q1, new v0(iVar.ggg()));
        if (iVar.O() != null) {
            h(s0.s3, iVar.O().fe());
        }
        if (iVar.i0() && (iVar.u() == 1 || iVar.u() > 255)) {
            h(s0.d2, l.f9519i);
        }
        if (l0Var != null) {
            if (iVar.m0()) {
                h(s0.N4, l0Var);
            } else {
                h(s0.V2, l0Var);
            }
        }
        if (iVar.i0() && iVar.h0()) {
            h(s0.o0, new q0("[1 0]"));
        }
        if (iVar.g0()) {
            h(s0.j2, l.f9519i);
        }
        try {
            int[] X = iVar.X();
            if (X != null && !iVar.i0() && l0Var == null) {
                StringBuilder sb = new StringBuilder("[");
                for (int append : X) {
                    sb.append(append);
                    sb.append(" ");
                }
                sb.append("]");
                h(s0.V2, new q0(sb.toString()));
            }
            if (iVar.e0()) {
                int w = iVar.w();
                byte[] R = iVar.R();
                this.f9852ad = R;
                h(s0.F2, new v0(R.length));
                int u = iVar.u();
                if (u > 255) {
                    if (!iVar.i0()) {
                        h(s0.T, s0.v0);
                    }
                    h(s0.p, new v0(1));
                    h(s0.e1, s0.G);
                    int i2 = u - 257;
                    x xVar = new x();
                    if (i2 != 0) {
                        xVar.h(s0.s2, new v0(i2));
                    }
                    if ((w & 1) != 0) {
                        xVar.h(s0.r, l.f9519i);
                    }
                    if ((w & 2) != 0) {
                        xVar.h(s0.O0, l.f9519i);
                    }
                    if ((w & 4) != 0) {
                        xVar.h(s0.U0, l.f9519i);
                    }
                    if ((w & 8) != 0) {
                        xVar.h(s0.T0, l.f9520o);
                    }
                    xVar.h(s0.Y, new v0(iVar.rrr()));
                    xVar.h(s0.x4, new v0(iVar.ggg()));
                    h(s0.p0, xVar);
                    return;
                }
                if (w == 1) {
                    h(s0.T, s0.v0);
                    if (iVar.h0()) {
                        h(s0.o0, new q0("[1 0]"));
                    }
                } else if (w != 3) {
                    h(s0.T, s0.x0);
                    if (iVar.h0()) {
                        h(s0.o0, new q0("[1 0 1 0 1 0 1 0]"));
                    }
                } else {
                    h(s0.T, s0.w0);
                    if (iVar.h0()) {
                        h(s0.o0, new q0("[1 0 1 0 1 0]"));
                    }
                }
                x r = iVar.r();
                if (r != null) {
                    j(r);
                }
                if (iVar.i0() && (iVar.u() == 1 || iVar.u() > 8)) {
                    k(s0.T);
                }
                h(s0.p, new v0(iVar.u()));
                if (iVar.d0()) {
                    h(s0.e1, s0.p1);
                } else {
                    l(iVar.x());
                }
            } else {
                if (iVar.R() == null) {
                    inputStream = iVar.Y().openStream();
                    str2 = iVar.Y().toString();
                } else {
                    inputStream = new ByteArrayInputStream(iVar.R());
                    str2 = "Byte array";
                }
                int type = iVar.type();
                if (type == 32) {
                    h(s0.e1, s0.m0);
                    if (iVar.v() == 0) {
                        x xVar2 = new x();
                        xVar2.h(s0.U, new v0(0));
                        h(s0.p0, xVar2);
                    }
                    int w2 = iVar.w();
                    if (w2 == 1) {
                        h(s0.T, s0.v0);
                    } else if (w2 != 3) {
                        h(s0.T, s0.x0);
                        if (iVar.h0()) {
                            h(s0.o0, new q0("[1 0 1 0 1 0 1 0]"));
                        }
                    } else {
                        h(s0.T, s0.w0);
                    }
                    h(s0.p, new v0(8));
                    if (iVar.R() != null) {
                        byte[] R2 = iVar.R();
                        this.f9852ad = R2;
                        h(s0.F2, new v0(R2.length));
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        this.ppp = byteArrayOutputStream;
                        t(inputStream, byteArrayOutputStream, -1);
                    }
                } else if (type == 33) {
                    h(s0.e1, s0.p2);
                    if (iVar.w() > 0) {
                        int w3 = iVar.w();
                        if (w3 == 1) {
                            h(s0.T, s0.v0);
                        } else if (w3 != 3) {
                            h(s0.T, s0.x0);
                        } else {
                            h(s0.T, s0.w0);
                        }
                        h(s0.p, new v0(iVar.u()));
                    }
                    if (iVar.R() != null) {
                        byte[] R3 = iVar.R();
                        this.f9852ad = R3;
                        h(s0.F2, new v0(R3.length));
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return;
                            } catch (Exception unused2) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        this.ppp = byteArrayOutputStream2;
                        t(inputStream, byteArrayOutputStream2, -1);
                    }
                } else if (type == 36) {
                    h(s0.e1, s0.n2);
                    h(s0.T, s0.v0);
                    h(s0.p, new v0(1));
                    if (iVar.R() != null) {
                        byte[] R4 = iVar.R();
                        this.f9852ad = R4;
                        h(s0.F2, new v0(R4.length));
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return;
                            } catch (Exception unused3) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                        this.ppp = byteArrayOutputStream3;
                        t(inputStream, byteArrayOutputStream3, -1);
                    }
                } else {
                    throw new BadPdfFormatException(qw.ad("1.is.an.unknown.image.format", str2));
                }
                if (iVar.x() > 0) {
                    l(iVar.x());
                }
                h(s0.F2, new v0(this.ppp.size()));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused4) {
                    }
                }
            }
        } catch (IOException e) {
            throw new BadPdfFormatException(e.getMessage());
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused5) {
                }
            }
            throw th2;
        }
    }

    public static void t(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        byte[] bArr = new byte[4096];
        if (i2 < 0) {
            i2 = 2147418112;
        }
        while (i2 != 0) {
            int read = inputStream.read(bArr, 0, Math.min(i2, 4096));
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
                i2 -= read;
            } else {
                return;
            }
        }
    }

    public final void r(i iVar) {
        this.qqq = new s0("img" + Long.toHexString(iVar.P().longValue()));
    }

    public s0 s() {
        return this.qqq;
    }
}
