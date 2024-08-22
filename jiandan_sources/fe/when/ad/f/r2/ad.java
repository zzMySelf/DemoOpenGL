package fe.when.ad.f.r2;

import androidx.multidex.MultiDexExtractor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.pdf.hyphenation.Hyphen;
import com.itextpdf.text.pdf.hyphenation.PatternConsumer;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import fe.when.ad.g.ad.de;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class ad implements SimpleXMLDocHandler, PatternConsumer {

    /* renamed from: ad  reason: collision with root package name */
    public int f9743ad;

    /* renamed from: i  reason: collision with root package name */
    public char f9744i = '-';

    /* renamed from: th  reason: collision with root package name */
    public PatternConsumer f9745th;

    /* renamed from: uk  reason: collision with root package name */
    public ArrayList<Object> f9746uk;

    /* renamed from: yj  reason: collision with root package name */
    public StringBuffer f9747yj = new StringBuffer();

    public static String uk(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isDigit(str.charAt(i2))) {
                stringBuffer.append(str.charAt(i2));
            }
        }
        return stringBuffer.toString();
    }

    public static String yj(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = str + "a";
        int length = str2.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = str2.charAt(i2);
            if (Character.isDigit(charAt)) {
                stringBuffer.append(charAt);
                i2++;
            } else {
                stringBuffer.append('0');
            }
            i2++;
        }
        return stringBuffer.toString();
    }

    public void ad() {
    }

    public void addClass(String str) {
        PrintStream printStream = System.out;
        printStream.println("class: " + str);
    }

    public void addException(String str, ArrayList<Object> arrayList) {
        PrintStream printStream = System.out;
        printStream.println("exception: " + str + " : " + arrayList.toString());
    }

    public void addPattern(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println("pattern: " + str + " : " + str2);
    }

    public void de(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int i2 = this.f9743ad;
            if (i2 == 1) {
                this.f9745th.addClass(nextToken);
            } else if (i2 == 2) {
                this.f9746uk.add(nextToken);
                ArrayList<Object> i3 = i(this.f9746uk);
                this.f9746uk = i3;
                this.f9745th.addException(th(i3), (ArrayList) this.f9746uk.clone());
                this.f9746uk.clear();
            } else if (i2 == 3) {
                this.f9745th.addPattern(uk(nextToken), yj(nextToken));
            }
        }
    }

    public void fe(String str) {
        if (this.f9747yj.length() > 0) {
            String stringBuffer = this.f9747yj.toString();
            int i2 = this.f9743ad;
            if (i2 == 1) {
                this.f9745th.addClass(stringBuffer);
            } else if (i2 == 2) {
                this.f9746uk.add(stringBuffer);
                ArrayList<Object> i3 = i(this.f9746uk);
                this.f9746uk = i3;
                this.f9745th.addException(th(i3), (ArrayList) this.f9746uk.clone());
            } else if (i2 == 3) {
                this.f9745th.addPattern(uk(stringBuffer), yj(stringBuffer));
            }
            if (this.f9743ad != 4) {
                this.f9747yj.setLength(0);
            }
        }
        if (this.f9743ad == 4) {
            this.f9743ad = 2;
        } else {
            this.f9743ad = 0;
        }
    }

    public ArrayList<Object> i(ArrayList<Object> arrayList) {
        ArrayList<Object> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Object obj = arrayList.get(i2);
            if (obj instanceof String) {
                String str = (String) obj;
                StringBuffer stringBuffer = new StringBuffer();
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char charAt = str.charAt(i3);
                    if (charAt != this.f9744i) {
                        stringBuffer.append(charAt);
                    } else {
                        arrayList2.add(stringBuffer.toString());
                        stringBuffer.setLength(0);
                        arrayList2.add(new Hyphen(new String(new char[]{this.f9744i}), (String) null, (String) null));
                    }
                }
                if (stringBuffer.length() > 0) {
                    arrayList2.add(stringBuffer.toString());
                }
            } else {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public void o(InputStream inputStream, PatternConsumer patternConsumer) {
        this.f9745th = patternConsumer;
        try {
            de.yj(this, inputStream);
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (Exception unused2) {
            }
            throw th2;
        }
    }

    public void qw() {
    }

    public void rg(String str, Map<String, String> map) {
        if (str.equals("hyphen-char")) {
            String str2 = map.get("value");
            if (str2 != null && str2.length() == 1) {
                this.f9744i = str2.charAt(0);
            }
        } else if (str.equals(MultiDexExtractor.DEX_PREFIX)) {
            this.f9743ad = 1;
        } else if (str.equals("patterns")) {
            this.f9743ad = 3;
        } else if (str.equals("exceptions")) {
            this.f9743ad = 2;
            this.f9746uk = new ArrayList<>();
        } else if (str.equals("hyphen")) {
            if (this.f9747yj.length() > 0) {
                this.f9746uk.add(this.f9747yj.toString());
            }
            this.f9746uk.add(new Hyphen(map.get("pre"), map.get("no"), map.get("post")));
            this.f9743ad = 4;
        }
        this.f9747yj.setLength(0);
    }

    public String th(ArrayList<Object> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Object obj = arrayList.get(i2);
            if (obj instanceof String) {
                stringBuffer.append((String) obj);
            } else {
                String str = ((Hyphen) obj).noBreak;
                if (str != null) {
                    stringBuffer.append(str);
                }
            }
        }
        return stringBuffer.toString();
    }
}
