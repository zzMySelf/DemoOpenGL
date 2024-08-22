package com.baidu.apollon.restnet.http;

import androidx.core.app.FrameMetricsAggregator;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.searchbox.http.response.StatusCodeException;
import com.baidubce.http.StatusCodes;
import com.dxmpay.wallet.utils.StatHelper;
import okhttp3.internal.http.StatusLine;

public enum HttpStatus {
    CONTINUE(100, "Continue"),
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),
    PROCESSING(102, "Processing"),
    CHECKPOINT(103, "Checkpoint"),
    OK(200, StatHelper.SENSOR_OK),
    CREATED(201, "Created"),
    ACCEPTED(BindVerifyActivity.v, "Accepted"),
    NON_AUTHORITATIVE_INFORMATION(BindVerifyActivity.w, "Non-Authoritative Information"),
    NO_CONTENT(BindVerifyActivity.x, "No Content"),
    RESET_CONTENT(BindVerifyActivity.y, "Reset Content"),
    PARTIAL_CONTENT(BindVerifyActivity.z, "Partial Content"),
    MULTI_STATUS(207, "Multi-Status"),
    ALREADY_REPORTED(208, "Already Reported"),
    IM_USED(226, "IM Used"),
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    FOUND(302, "Found"),
    MOVED_TEMPORARILY(302, "Moved Temporarily"),
    SEE_OTHER(BindVerifyActivity.D, "See Other"),
    NOT_MODIFIED(BindVerifyActivity.E, "Not Modified"),
    USE_PROXY(BindVerifyActivity.F, "Use Proxy"),
    TEMPORARY_REDIRECT(StatusLine.HTTP_TEMP_REDIRECT, "Temporary Redirect"),
    RESUME_INCOMPLETE(StatusLine.HTTP_PERM_REDIRECT, "Resume Incomplete"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    PAYMENT_REQUIRED(BindVerifyActivity.J, "Payment Required"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(BindVerifyActivity.M, "Method Not Allowed"),
    NOT_ACCEPTABLE(BindVerifyActivity.N, "Not Acceptable"),
    PROXY_AUTHENTICATION_REQUIRED(BindVerifyActivity.O, "Proxy Authentication Required"),
    REQUEST_TIMEOUT(408, "Request Timeout"),
    CONFLICT(409, "Conflict"),
    GONE(410, "Gone"),
    LENGTH_REQUIRED(411, "Length Required"),
    PRECONDITION_FAILED(412, "Precondition Failed"),
    REQUEST_ENTITY_TOO_LARGE(413, "Request Entity Too Large"),
    REQUEST_URI_TOO_LONG(414, "Request-URI Too Long"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    REQUESTED_RANGE_NOT_SATISFIABLE(416, "Requested range not satisfiable"),
    EXPECTATION_FAILED(417, "Expectation Failed"),
    I_AM_A_TEAPOT(418, "I'm a teapot"),
    INSUFFICIENT_SPACE_ON_RESOURCE(419, "Insufficient Space On Resource"),
    METHOD_FAILURE(420, "Method Failure"),
    DESTINATION_LOCKED(421, "Destination Locked"),
    UNPROCESSABLE_ENTITY(422, "Unprocessable Entity"),
    LOCKED(423, "Locked"),
    FAILED_DEPENDENCY(424, "Failed Dependency"),
    UPGRADE_REQUIRED(426, "Upgrade Required"),
    PRECONDITION_REQUIRED(428, "Precondition Required"),
    TOO_MANY_REQUESTS(StatusCodeException.IGNORE_429_CODE, "Too Many Requests"),
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_IMPLEMENTED(IMPushPb.ActionType.REQUEST_VALUE, "Not Implemented"),
    BAD_GATEWAY(StatusCodes.BAD_GATEWAY, "Bad Gateway"),
    SERVICE_UNAVAILABLE(StatusCodes.SERVICE_UNAVAILABLE, "Service Unavailable"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    HTTP_VERSION_NOT_SUPPORTED(BindVerifyActivity.Q, "HTTP Version not supported"),
    VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates"),
    INSUFFICIENT_STORAGE(507, "Insufficient Storage"),
    LOOP_DETECTED(508, "Loop Detected"),
    BANDWIDTH_LIMIT_EXCEEDED(509, "Bandwidth Limit Exceeded"),
    NOT_EXTENDED(510, "Not Extended"),
    NETWORK_AUTHENTICATION_REQUIRED(FrameMetricsAggregator.EVERY_DURATION, "Network Authentication Required");
    
    public final String reasonPhrase;
    public final int value;

    public enum Series {
        INFORMATIONAL(1),
        SUCCESSFUL(2),
        REDIRECTION(3),
        CLIENT_ERROR(4),
        SERVER_ERROR(5);
        
        public final int value;

        /* access modifiers changed from: public */
        Series(int i2) {
            this.value = i2;
        }

        public int value() {
            return this.value;
        }

        public static Series valueOf(HttpStatus httpStatus) {
            int value2 = httpStatus.value() / 100;
            for (Series series : values()) {
                if (series.value == value2) {
                    return series;
                }
            }
            throw new IllegalArgumentException("No matching constant for [" + httpStatus + "]");
        }
    }

    /* access modifiers changed from: public */
    HttpStatus(int i2, String str) {
        this.value = i2;
        this.reasonPhrase = str;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public Series series() {
        return Series.valueOf(this);
    }

    public String toString() {
        return Integer.toString(this.value);
    }

    public int value() {
        return this.value;
    }

    public static HttpStatus valueOf(int i2) {
        for (HttpStatus httpStatus : values()) {
            if (httpStatus.value == i2) {
                return httpStatus;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + i2 + "]");
    }
}
