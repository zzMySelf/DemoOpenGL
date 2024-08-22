package okhttp3;

import java.io.IOException;
import pf.qw;

public interface Authenticator {
    public static final Authenticator NONE = qw.qw;

    Request authenticate(Route route, Response response) throws IOException;
}
