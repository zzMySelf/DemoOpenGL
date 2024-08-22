package com.xiaomi.push;

import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.pushsdk.BuildConfig;
import com.vivo.push.PushClientConstants;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class hg {

    /* renamed from: a  reason: collision with root package name */
    private static int f7098a;

    /* renamed from: a  reason: collision with other field name */
    private static Vector<String> f499a = new Vector<>();

    /* renamed from: b  reason: collision with root package name */
    private static int f7099b;

    /* renamed from: c  reason: collision with root package name */
    private static int f7100c = UnitedSchemeMainDispatcher.SCHEME_TIME_LIMIT;

    /* renamed from: d  reason: collision with root package name */
    private static int f7101d = 330000;

    static {
        InputStream inputStream;
        f7098a = 5000;
        f7099b = 330000;
        try {
            for (ClassLoader resources : a()) {
                Enumeration<URL> resources2 = resources.getResources("META-INF/smack-config.xml");
                while (resources2.hasMoreElements()) {
                    inputStream = null;
                    try {
                        InputStream openStream = resources2.nextElement().openStream();
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        newPullParser.setInput(openStream, "UTF-8");
                        int eventType = newPullParser.getEventType();
                        do {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals(PushClientConstants.TAG_CLASS_NAME)) {
                                    a(newPullParser);
                                } else if (newPullParser.getName().equals("packetReplyTimeout")) {
                                    f7098a = a(newPullParser, f7098a);
                                } else if (newPullParser.getName().equals("keepAliveInterval")) {
                                    f7099b = a(newPullParser, f7099b);
                                } else if (newPullParser.getName().equals("mechName")) {
                                    f499a.add(newPullParser.nextText());
                                }
                            }
                            eventType = newPullParser.next();
                        } while (eventType != 1);
                        try {
                            openStream.close();
                        } catch (Exception e2) {
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        inputStream.close();
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (Exception e5) {
            }
            throw th2;
        }
    }

    private hg() {
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m8587a() {
        return BuildConfig.VERSION_NAME;
    }

    public static int a() {
        return f7099b;
    }

    public static int b() {
        return f7100c;
    }

    private static void a(XmlPullParser xmlPullParser) {
        String nextText = xmlPullParser.nextText();
        try {
            Class.forName(nextText);
        } catch (ClassNotFoundException e2) {
            System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: " + nextText);
        }
    }

    private static int a(XmlPullParser xmlPullParser, int i2) {
        try {
            return Integer.parseInt(xmlPullParser.nextText());
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return i2;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static ClassLoader[] m8588a() {
        ClassLoader[] classLoaderArr = {hg.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            ClassLoader classLoader = classLoaderArr[i2];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }
}
