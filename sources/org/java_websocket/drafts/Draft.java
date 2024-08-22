package org.java_websocket.drafts;

import com.baidu.talos.core.archivers.tar.TarConstants;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.framing.BinaryFrame;
import org.java_websocket.framing.ContinuousFrame;
import org.java_websocket.framing.DataFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.TextFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.HandshakeImpl1Server;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Charsetfunctions;

public abstract class Draft {
    public static int INITIAL_FAMESIZE = 64;
    public static int MAX_FAME_SIZE = 1000;
    protected Framedata.Opcode continuousFrameType = null;
    protected WebSocket.Role role = null;

    public enum CloseHandshakeType {
        NONE,
        ONEWAY,
        TWOWAY
    }

    public enum HandshakeState {
        MATCHED,
        NOT_MATCHED
    }

    public abstract HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidHandshakeException;

    public abstract HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) throws InvalidHandshakeException;

    public abstract Draft copyInstance();

    public abstract ByteBuffer createBinaryFrame(Framedata framedata);

    public abstract List<Framedata> createFrames(String str, boolean z);

    public abstract List<Framedata> createFrames(ByteBuffer byteBuffer, boolean z);

    public abstract CloseHandshakeType getCloseHandshakeType();

    public abstract ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException;

    public abstract HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException;

    public abstract void processFrame(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException;

    public abstract void reset();

    public abstract List<Framedata> translateFrame(ByteBuffer byteBuffer) throws InvalidDataException;

    public static ByteBuffer readLine(ByteBuffer buf) {
        ByteBuffer sbuf = ByteBuffer.allocate(buf.remaining());
        byte cur = TarConstants.LF_NORMAL;
        while (buf.hasRemaining()) {
            byte prev = cur;
            cur = buf.get();
            sbuf.put(cur);
            if (prev == 13 && cur == 10) {
                sbuf.limit(sbuf.position() - 2);
                sbuf.position(0);
                return sbuf;
            }
        }
        buf.position(buf.position() - sbuf.position());
        return null;
    }

    public static String readStringLine(ByteBuffer buf) {
        ByteBuffer b2 = readLine(buf);
        if (b2 == null) {
            return null;
        }
        return Charsetfunctions.stringAscii(b2.array(), 0, b2.limit());
    }

    public static HandshakeBuilder translateHandshakeHttp(ByteBuffer buf, WebSocket.Role role2) throws InvalidHandshakeException, IncompleteHandshakeException {
        HandshakeImpl1Server handshake;
        String line = readStringLine(buf);
        if (line != null) {
            String[] firstLineTokens = line.split(" ", 3);
            if (firstLineTokens.length == 3) {
                if (role2 == WebSocket.Role.CLIENT) {
                    if (!"101".equals(firstLineTokens[1])) {
                        throw new InvalidHandshakeException("Invalid status code received: " + firstLineTokens[1] + " Status line: " + line);
                    } else if ("HTTP/1.1".equalsIgnoreCase(firstLineTokens[0])) {
                        HandshakeImpl1Server handshakeImpl1Server = new HandshakeImpl1Server();
                        ServerHandshakeBuilder serverhandshake = handshakeImpl1Server;
                        serverhandshake.setHttpStatus(Short.parseShort(firstLineTokens[1]));
                        serverhandshake.setHttpStatusMessage(firstLineTokens[2]);
                        handshake = handshakeImpl1Server;
                    } else {
                        throw new InvalidHandshakeException("Invalid status line received: " + firstLineTokens[0] + " Status line: " + line);
                    }
                } else if (!"GET".equalsIgnoreCase(firstLineTokens[0])) {
                    throw new InvalidHandshakeException("Invalid request method received: " + firstLineTokens[0] + " Status line: " + line);
                } else if ("HTTP/1.1".equalsIgnoreCase(firstLineTokens[2])) {
                    HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
                    handshakeImpl1Client.setResourceDescriptor(firstLineTokens[1]);
                    HandshakeImpl1Client handshakeImpl1Client2 = handshakeImpl1Client;
                    handshake = handshakeImpl1Client;
                } else {
                    throw new InvalidHandshakeException("Invalid status line received: " + firstLineTokens[2] + " Status line: " + line);
                }
                String line2 = readStringLine(buf);
                while (line2 != null && line2.length() > 0) {
                    String[] pair = line2.split(":", 2);
                    if (pair.length == 2) {
                        if (handshake.hasFieldValue(pair[0])) {
                            handshake.put(pair[0], handshake.getFieldValue(pair[0]) + "; " + pair[1].replaceFirst("^ +", ""));
                        } else {
                            handshake.put(pair[0], pair[1].replaceFirst("^ +", ""));
                        }
                        line2 = readStringLine(buf);
                    } else {
                        throw new InvalidHandshakeException("not an http header");
                    }
                }
                if (line2 != null) {
                    return handshake;
                }
                throw new IncompleteHandshakeException();
            }
            throw new InvalidHandshakeException();
        }
        throw new IncompleteHandshakeException(buf.capacity() + 128);
    }

    /* access modifiers changed from: protected */
    public boolean basicAccept(Handshakedata handshakedata) {
        return handshakedata.getFieldValue("Upgrade").equalsIgnoreCase("websocket") && handshakedata.getFieldValue("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public List<Framedata> continuousFrame(Framedata.Opcode op, ByteBuffer buffer, boolean fin) {
        if (op == Framedata.Opcode.BINARY || op == Framedata.Opcode.TEXT) {
            DataFrame bui = null;
            if (this.continuousFrameType != null) {
                bui = new ContinuousFrame();
            } else {
                this.continuousFrameType = op;
                if (op == Framedata.Opcode.BINARY) {
                    bui = new BinaryFrame();
                } else if (op == Framedata.Opcode.TEXT) {
                    bui = new TextFrame();
                }
            }
            bui.setPayload(buffer);
            bui.setFin(fin);
            try {
                bui.isValid();
                if (fin) {
                    this.continuousFrameType = null;
                } else {
                    this.continuousFrameType = op;
                }
                return Collections.singletonList(bui);
            } catch (InvalidDataException e2) {
                throw new IllegalArgumentException(e2);
            }
        } else {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
    }

    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, WebSocket.Role ownrole) {
        return createHandshake(handshakedata, ownrole, true);
    }

    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, WebSocket.Role ownrole, boolean withcontent) {
        StringBuilder bui = new StringBuilder(100);
        if (handshakedata instanceof ClientHandshake) {
            bui.append("GET ");
            bui.append(((ClientHandshake) handshakedata).getResourceDescriptor());
            bui.append(" HTTP/1.1");
        } else if (handshakedata instanceof ServerHandshake) {
            bui.append("HTTP/1.1 101 ").append(((ServerHandshake) handshakedata).getHttpStatusMessage());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        bui.append("\r\n");
        Iterator<String> it = handshakedata.iterateHttpFields();
        while (it.hasNext()) {
            String fieldname = it.next();
            String fieldvalue = handshakedata.getFieldValue(fieldname);
            bui.append(fieldname);
            bui.append(": ");
            bui.append(fieldvalue);
            bui.append("\r\n");
        }
        bui.append("\r\n");
        byte[] httpheader = Charsetfunctions.asciiBytes(bui.toString());
        byte[] content = withcontent ? handshakedata.getContent() : null;
        ByteBuffer bytebuffer = ByteBuffer.allocate((content == null ? 0 : content.length) + httpheader.length);
        bytebuffer.put(httpheader);
        if (content != null) {
            bytebuffer.put(content);
        }
        bytebuffer.flip();
        return Collections.singletonList(bytebuffer);
    }

    public Handshakedata translateHandshake(ByteBuffer buf) throws InvalidHandshakeException {
        return translateHandshakeHttp(buf, this.role);
    }

    public int checkAlloc(int bytecount) throws LimitExedeedException, InvalidDataException {
        if (bytecount >= 0) {
            return bytecount;
        }
        throw new InvalidDataException(1002, "Negative count");
    }

    /* access modifiers changed from: package-private */
    public int readVersion(Handshakedata handshakedata) {
        String vers = handshakedata.getFieldValue("Sec-WebSocket-Version");
        if (vers.length() <= 0) {
            return -1;
        }
        try {
            return new Integer(vers.trim()).intValue();
        } catch (NumberFormatException e2) {
            return -1;
        }
    }

    public void setParseMode(WebSocket.Role role2) {
        this.role = role2;
    }

    public WebSocket.Role getRole() {
        return this.role;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
