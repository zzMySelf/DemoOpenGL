package fe.mmm.qw.nn.de.pf;

import com.google.gson.annotations.SerializedName;
import com.mars.kotlin.service.ErrorCode;
import com.mars.kotlin.service.ErrorMessage;

public abstract class de {
    public static final int DEFAULT_ERROR_NUMBER = -1;
    public static final int NEED_VERIFY_CODE = -19;
    public static final int PROMPT_TYPE_DIALOG = 1;
    public static final int PROMPT_TYPE_FEEDBACK_DIALOG = 2;
    @SerializedName("show_msg")
    public String alertmsg;
    @SerializedName("errmsg")
    @ErrorMessage
    public String errmsg;
    @SerializedName("errno")
    @ErrorCode(noError = 0)
    public int errno;
    @SerializedName("prompt_type")
    public int promptType;

    public boolean isSuccess() {
        return this.errno == 0;
    }

    public boolean needVcode() {
        return this.errno == -19;
    }

    public String toString() {
        return "Response [errno=" + this.errno + "]";
    }
}
