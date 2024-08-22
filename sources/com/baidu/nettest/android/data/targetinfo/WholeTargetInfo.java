package com.baidu.nettest.android.data.targetinfo;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import com.baidu.nettest.android.common.Constants;
import com.baidu.nettest.android.common.WebAddress;
import com.baidu.nettest.android.data.testresult.TestRes;
import com.baidu.nettest.android.data.testresult.WholeTestRes;
import com.baidu.searchbox.net.update.UpdateConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.net.UnknownHostException;
import org.json.JSONException;
import org.json.JSONObject;

public class WholeTargetInfo implements TargetInfo {
    private static final boolean DEBUG = Constants.DEBUG;
    private static final String TAG = "WholeTargetInfo";
    public static final String TEST_TYPE = "3";
    final int connectTimeout = 30000;
    String mHost;
    private String mProxy;
    String mUa;
    String mUrl;
    final int readTimeout = 50000;
    SocketAddress socketAddress;

    public void parseTargetInfo(Context context, JSONObject json) throws JSONException {
        this.mUrl = json.getString("url");
        this.mHost = json.getString("host");
        this.mUa = json.getString("ua");
        ConnectManager cm = new ConnectManager(context);
        if (cm.isWapNetwork()) {
            this.mProxy = cm.getProxy();
        } else {
            this.mProxy = null;
        }
    }

    public TestRes execute() {
        return null;
    }

    public TestRes executeCommand(WholeTestRes testRes) {
        String nextUrl = new WebAddress(this.mUrl).toString();
        int count = 5;
        while (!TextUtils.isEmpty(nextUrl) && count > 0) {
            OneTestRes oneTestRes = new OneTestRes();
            try {
                oneTestRes.url = nextUrl;
                oneTestRes.headHost = this.mHost;
                oneTestRes.headUA = this.mUa;
                setDNSParseSpend(oneTestRes);
                this.socketAddress = getInetSocketAddress(oneTestRes);
                nextUrl = setGrabDataInfo(setConnectSpend(oneTestRes), oneTestRes);
                testRes.addOneTestRes(oneTestRes);
                if (DEBUG) {
                    Log.d(TAG, oneTestRes.toString());
                }
                count--;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return testRes;
    }

    public String getTestType() {
        return "3";
    }

    public String toString() {
        return "TargetInfo [url=" + this.mUrl + ", host=" + this.mHost + ", ua=" + this.mUa + RhetoricalTagUtilKt.TAG_END_SYMBOL;
    }

    private void setDNSParseSpend(OneTestRes oneTestRes) {
        long startTime = System.currentTimeMillis();
        try {
            InetAddress.getByName(new URL(oneTestRes.url).getHost());
            oneTestRes.dnsSpend = (short) ((int) (System.currentTimeMillis() - startTime));
        } catch (UnknownHostException e2) {
            oneTestRes.dnsSpend = -1;
            e2.printStackTrace();
        } catch (MalformedURLException e3) {
            e3.printStackTrace();
        }
    }

    public Socket setConnectSpend(OneTestRes oneTestRes) {
        return null;
    }

    private InetSocketAddress getInetSocketAddress(OneTestRes oneTestRes) {
        try {
            if (this.mProxy != null) {
                InetSocketAddress socketAdress = new InetSocketAddress(this.mProxy, 80);
                oneTestRes.conIp = this.mProxy;
                return socketAdress;
            }
            URL url = new URL(oneTestRes.url);
            int port = url.getPort();
            if (port == -1) {
                port = url.getDefaultPort();
            }
            InetAddress address = InetAddress.getByName(url.getHost());
            if (address == null) {
                return null;
            }
            oneTestRes.conIp = address.getHostAddress();
            return new InetSocketAddress(address, port);
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private String setGrabDataInfo(Socket socket, OneTestRes oneTestRes) {
        if (socket == null || oneTestRes == null) {
            return null;
        }
        String nextUrl = null;
        try {
            sendHttpHeader(socket, oneTestRes);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            char[] buffer = new char[1024];
            long startTime = System.currentTimeMillis();
            int len = reader.read(buffer);
            oneTestRes.firstPacketSpend = (short) ((int) (System.currentTimeMillis() - startTime));
            int totalSize = 1 + len;
            nextUrl = setReturnCode(oneTestRes, buffer);
            while (true) {
                int read = reader.read(buffer);
                int len2 = read;
                if (read == -1) {
                    break;
                }
                totalSize += len2;
            }
            oneTestRes.spendTime = System.currentTimeMillis() - startTime;
            oneTestRes.len = totalSize;
            try {
                socket.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (IOException e1) {
            oneTestRes.spendTime = -1;
            oneTestRes.len = -1;
            e1.printStackTrace();
            socket.close();
        } catch (Throwable th2) {
            try {
                socket.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            throw th2;
        }
        return nextUrl;
    }

    private String setReturnCode(OneTestRes oneTestRes, char[] firstPacketBuf) {
        String nextUrl = null;
        if (firstPacketBuf != null) {
            String firstPacketStr = String.valueOf(firstPacketBuf);
            try {
                oneTestRes.returnCode = Short.parseShort(firstPacketStr.substring(9, 12));
                if (oneTestRes.returnCode == 302) {
                    BufferedReader br = new BufferedReader(new StringReader(firstPacketStr));
                    while (true) {
                        try {
                            String readLine = br.readLine();
                            String line = readLine;
                            if (readLine == null) {
                                break;
                            } else if (line.startsWith("Location")) {
                                String sub = line.substring(line.indexOf(58) + 1);
                                if (!TextUtils.isEmpty(sub)) {
                                    nextUrl = sub.trim();
                                }
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (DEBUG) {
                        Log.d(TAG, "302, " + nextUrl);
                    }
                }
            } catch (NumberFormatException e3) {
                oneTestRes.returnCode = -1;
                e3.printStackTrace();
            }
        }
        return nextUrl;
    }

    private void sendHttpHeader(Socket socket, OneTestRes oneTestRes) throws IOException {
        StringBuffer sb = new StringBuffer();
        String file = "/";
        String host = oneTestRes.headHost;
        try {
            URL url = new URL(oneTestRes.url);
            if (TextUtils.isEmpty(host)) {
                host = url.getHost();
            }
            file = url.getFile();
        } catch (MalformedURLException e2) {
            if (DEBUG) {
                Log.w(TAG, "sendHttpHeader, " + e2.getMessage());
            }
        }
        if (TextUtils.isEmpty(host)) {
            host = "www.baidu.com";
        }
        if (this.mProxy != null) {
            file = oneTestRes.url;
        }
        sb.append("GET " + file + " HTTP/1.1\r\n");
        sb.append("Host: " + host + "\r\n");
        sb.append("Accept-Encoding: gzip\r\n");
        if (!TextUtils.isEmpty(oneTestRes.headUA)) {
            sb.append("User-Agent: " + oneTestRes.headUA + "\r\n");
        }
        sb.append("Accept: */*\r\n");
        sb.append("Connection: Close \r\n");
        sb.append("\r\n");
        byte[] sedndata = sb.toString().getBytes();
        OutputStream os = socket.getOutputStream();
        os.write(sedndata);
        os.flush();
    }

    public static class OneTestRes {
        short buildConSpend;
        String conIp;
        short dnsSpend;
        short firstPacketSpend;
        String headHost;
        String headUA;
        int len;
        short returnCode;
        long spendTime;
        short sslHandshakeSpend;
        String url;

        public JSONObject getOneTestRes() throws JSONException {
            JSONObject res = new JSONObject();
            res.put("url", this.url);
            res.put("dns_time", this.dnsSpend);
            res.put("build_con_time", this.buildConSpend);
            res.put("ssl_handshake_time", this.sslHandshakeSpend);
            res.put("first_packet_time", this.firstPacketSpend);
            res.put("len", this.len);
            res.put(UpdateConstants.UBC_SPEND_KEY, this.spendTime);
            res.put("return_code", this.returnCode);
            res.put("host", this.headHost);
            res.put("ua", this.headUA);
            res.put("con_ip", this.conIp);
            return res;
        }

        public String toString() {
            return "TestRes [url=" + this.url + ", dnsSpend=" + this.dnsSpend + ", buildConSpend=" + this.buildConSpend + ", sslHandshakeSpend=" + this.sslHandshakeSpend + ", firstPacketSpend=" + this.firstPacketSpend + ", len=" + this.len + ", spendTime=" + this.spendTime + ", returnCode=" + this.returnCode + ", headHost=" + this.headHost + ", headUA=" + this.headUA + ", con_ip=" + this.conIp + RhetoricalTagUtilKt.TAG_END_SYMBOL;
        }
    }
}
