package fe.mmm.qw.nn.qw.qw.pf;

import com.tera.scan.network.network.parser.IApiResultParseable;
import fe.mmm.qw.nn.de.pf.de;

public class qw<T extends de> implements IApiResultParseable<T> {
    public Class<T> qw;

    public qw(Class<T> cls) {
        this.qw = cls;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0065, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006f, code lost:
        throw new org.json.JSONException(r5.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0070, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007a, code lost:
        throw new org.json.JSONException(r5.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007b, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0085, code lost:
        throw new java.io.IOException(r5.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0086, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0087, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0099, code lost:
        throw fe.mmm.qw.nn.de.th.qw(r5, (java.lang.String) null, (fe.mmm.qw.nn.de.pf.de) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a3, code lost:
        throw new org.json.JSONException(r0.getMessage());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0065 A[ExcHandler: IllegalArgumentException (r5v11 'e' java.lang.IllegalArgumentException A[CUSTOM_DECLARE]), Splitter:B:1:0x0003] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070 A[ExcHandler: JsonParseException (r5v9 'e' com.google.gson.JsonParseException A[CUSTOM_DECLARE]), Splitter:B:1:0x0003] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b A[ExcHandler: JsonIOException (r5v7 'e' com.google.gson.JsonIOException A[CUSTOM_DECLARE]), Splitter:B:1:0x0003] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a  */
    /* renamed from: ad */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T qw(fe.mmm.qw.nn.de.pf.ad r5) throws org.json.JSONException, com.tera.scan.network.network.exception.RemoteException, java.io.IOException {
        /*
            r4 = this;
            java.lang.String r0 = "NormalGsonParser"
            r1 = 0
            java.lang.String r5 = r5.qw()     // Catch:{ JsonSyntaxException -> 0x0086, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            fe.mmm.qw.nn.rg.qw r2 = fe.mmm.qw.nn.rg.qw.qw     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            r2.qw(r5)     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            r2.<init>()     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            java.lang.String r3 = "data = "
            r2.append(r3)     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            r2.append(r5)     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            java.lang.String r3 = "target:"
            r2.append(r3)     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            java.lang.Class<T> r3 = r4.qw     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            r2.append(r3)     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            java.lang.String r2 = r2.toString()     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            fe.mmm.qw.i.qw.ad(r0, r2)     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            r2.<init>()     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            java.lang.Class<T> r3 = r4.qw     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            java.lang.Object r2 = r2.fromJson((java.lang.String) r5, r3)     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            fe.mmm.qw.nn.de.pf.de r2 = (fe.mmm.qw.nn.de.pf.de) r2     // Catch:{ JsonSyntaxException -> 0x0063, JsonIOException -> 0x007b, JsonParseException -> 0x0070, IllegalArgumentException -> 0x0065 }
            if (r2 == 0) goto L_0x005b
            int r5 = r2.errno
            if (r5 != 0) goto L_0x0056
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = "Parse result = "
            r5.append(r1)
            java.lang.String r1 = r2.toString()
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            fe.mmm.qw.i.qw.ad(r0, r5)
            return r2
        L_0x0056:
            com.tera.scan.network.network.exception.RemoteException r5 = fe.mmm.qw.nn.de.th.qw(r5, r1, r1)
            throw r5
        L_0x005b:
            org.json.JSONException r5 = new org.json.JSONException
            java.lang.String r0 = "NormalGsonParser JsonParser is null."
            r5.<init>(r0)
            throw r5
        L_0x0063:
            r0 = move-exception
            goto L_0x0088
        L_0x0065:
            r5 = move-exception
            org.json.JSONException r0 = new org.json.JSONException
            java.lang.String r5 = r5.getMessage()
            r0.<init>(r5)
            throw r0
        L_0x0070:
            r5 = move-exception
            org.json.JSONException r0 = new org.json.JSONException
            java.lang.String r5 = r5.getMessage()
            r0.<init>(r5)
            throw r0
        L_0x007b:
            r5 = move-exception
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r5 = r5.getMessage()
            r0.<init>(r5)
            throw r0
        L_0x0086:
            r0 = move-exception
            r5 = r1
        L_0x0088:
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>(r5)
            java.lang.String r5 = "errno"
            int r5 = r2.optInt(r5)
            if (r5 == 0) goto L_0x009a
            com.tera.scan.network.network.exception.RemoteException r5 = fe.mmm.qw.nn.de.th.qw(r5, r1, r1)
            throw r5
        L_0x009a:
            org.json.JSONException r5 = new org.json.JSONException
            java.lang.String r0 = r0.getMessage()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.nn.qw.qw.pf.qw.qw(fe.mmm.qw.nn.de.pf.ad):fe.mmm.qw.nn.de.pf.de");
    }
}
