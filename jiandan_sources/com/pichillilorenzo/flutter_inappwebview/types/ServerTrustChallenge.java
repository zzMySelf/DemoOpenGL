package com.pichillilorenzo.flutter_inappwebview.types;

public class ServerTrustChallenge extends URLAuthenticationChallenge {
    public ServerTrustChallenge(URLProtectionSpace uRLProtectionSpace) {
        super(uRLProtectionSpace);
    }

    public String toString() {
        return "ServerTrustChallenge{} " + super.toString();
    }
}
