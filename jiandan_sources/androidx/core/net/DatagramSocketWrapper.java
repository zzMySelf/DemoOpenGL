package androidx.core.net;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;

public class DatagramSocketWrapper extends Socket {

    public static class DatagramSocketImplWrapper extends SocketImpl {
        public DatagramSocketImplWrapper(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) {
            this.localport = datagramSocket.getLocalPort();
            this.fd = fileDescriptor;
        }

        public void accept(SocketImpl socketImpl) throws IOException {
            throw new UnsupportedOperationException();
        }

        public int available() throws IOException {
            throw new UnsupportedOperationException();
        }

        public void bind(InetAddress inetAddress, int i2) throws IOException {
            throw new UnsupportedOperationException();
        }

        public void close() throws IOException {
            throw new UnsupportedOperationException();
        }

        public void connect(String str, int i2) throws IOException {
            throw new UnsupportedOperationException();
        }

        public void create(boolean z) throws IOException {
            throw new UnsupportedOperationException();
        }

        public InputStream getInputStream() throws IOException {
            throw new UnsupportedOperationException();
        }

        public Object getOption(int i2) throws SocketException {
            throw new UnsupportedOperationException();
        }

        public OutputStream getOutputStream() throws IOException {
            throw new UnsupportedOperationException();
        }

        public void listen(int i2) throws IOException {
            throw new UnsupportedOperationException();
        }

        public void sendUrgentData(int i2) throws IOException {
            throw new UnsupportedOperationException();
        }

        public void setOption(int i2, Object obj) throws SocketException {
            throw new UnsupportedOperationException();
        }

        public void connect(InetAddress inetAddress, int i2) throws IOException {
            throw new UnsupportedOperationException();
        }

        public void connect(SocketAddress socketAddress, int i2) throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    public DatagramSocketWrapper(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) throws SocketException {
        super(new DatagramSocketImplWrapper(datagramSocket, fileDescriptor));
    }
}
