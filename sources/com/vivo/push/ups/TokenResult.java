package com.vivo.push.ups;

public class TokenResult extends CodeResult {
    String token;

    public TokenResult(int returnCode, String token2) {
        super(returnCode);
        this.token = token2;
    }

    public String getToken() {
        return this.token;
    }
}
