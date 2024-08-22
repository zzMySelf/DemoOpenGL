package fe.de.qw.qw;

import org.json.JSONException;
import org.json.JSONObject;

public final class p {
    public p(JSONObject jSONObject) throws JSONException {
        jSONObject.getInt("commitmentPaymentsCount");
        jSONObject.optInt("subsequentCommitmentPaymentsCount");
    }
}
