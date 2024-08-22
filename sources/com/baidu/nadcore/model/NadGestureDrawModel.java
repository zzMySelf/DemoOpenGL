package com.baidu.nadcore.model;

import android.graphics.PointF;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.nadcore.dazzle.NadDazzleModelKt;
import com.baidu.nadcore.safe.JSONUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 =2\u00020\u0001:\u0002=>B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR \u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001aR\u001a\u00107\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0012\"\u0004\b9\u0010\u0014R\u001a\u0010:\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010\u001a¨\u0006?"}, d2 = {"Lcom/baidu/nadcore/model/NadGestureDrawModel;", "", "()V", "board", "Lcom/baidu/nadcore/model/NadGestureDrawModel$NadGestureBoardModel;", "getBoard", "()Lcom/baidu/nadcore/model/NadGestureDrawModel$NadGestureBoardModel;", "setBoard", "(Lcom/baidu/nadcore/model/NadGestureDrawModel$NadGestureBoardModel;)V", "cmd", "", "getCmd", "()Ljava/lang/String;", "setCmd", "(Ljava/lang/String;)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "height", "", "getHeight", "()D", "setHeight", "(D)V", "lineColor", "getLineColor", "setLineColor", "lineWidth", "getLineWidth", "setLineWidth", "lottie", "getLottie", "setLottie", "maskColor", "getMaskColor", "setMaskColor", "points", "", "Landroid/graphics/PointF;", "getPoints", "()Ljava/util/List;", "setPoints", "(Ljava/util/List;)V", "recognitionType", "", "getRecognitionType", "()I", "setRecognitionType", "(I)V", "similarity", "getSimilarity", "setSimilarity", "startTime", "getStartTime", "setStartTime", "width", "getWidth", "setWidth", "Companion", "NadGestureBoardModel", "nadcore-lib-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadGestureDrawModel.kt */
public final class NadGestureDrawModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private NadGestureBoardModel board;
    private String cmd = "";
    private long duration = -1;
    private double height;
    private String lineColor = "#FFFFFFFF";
    private double lineWidth = 5.0d;
    private String lottie = "";
    private String maskColor = "";
    private List<PointF> points = new ArrayList();
    private int recognitionType;
    private double similarity = 1.0d;
    private long startTime = -1;
    private double width;

    @JvmStatic
    public static final NadGestureDrawModel fromJson(String str) {
        return Companion.fromJson(str);
    }

    @JvmStatic
    public static final List<PointF> getPoints(String str) {
        return Companion.getPoints(str);
    }

    @JvmStatic
    public static final boolean isValid(NadGestureDrawModel nadGestureDrawModel) {
        return Companion.isValid(nadGestureDrawModel);
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(long j2) {
        this.startTime = j2;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j2) {
        this.duration = j2;
    }

    public final double getWidth() {
        return this.width;
    }

    public final void setWidth(double d2) {
        this.width = d2;
    }

    public final double getHeight() {
        return this.height;
    }

    public final void setHeight(double d2) {
        this.height = d2;
    }

    public final NadGestureBoardModel getBoard() {
        return this.board;
    }

    public final void setBoard(NadGestureBoardModel nadGestureBoardModel) {
        this.board = nadGestureBoardModel;
    }

    public final String getMaskColor() {
        return this.maskColor;
    }

    public final void setMaskColor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.maskColor = str;
    }

    public final double getLineWidth() {
        return this.lineWidth;
    }

    public final void setLineWidth(double d2) {
        this.lineWidth = d2;
    }

    public final String getLineColor() {
        return this.lineColor;
    }

    public final void setLineColor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lineColor = str;
    }

    public final int getRecognitionType() {
        return this.recognitionType;
    }

    public final void setRecognitionType(int i2) {
        this.recognitionType = i2;
    }

    public final double getSimilarity() {
        return this.similarity;
    }

    public final void setSimilarity(double d2) {
        this.similarity = d2;
    }

    public final List<PointF> getPoints() {
        return this.points;
    }

    public final void setPoints(List<PointF> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.points = list;
    }

    public final String getLottie() {
        return this.lottie;
    }

    public final void setLottie(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lottie = str;
    }

    public final String getCmd() {
        return this.cmd;
    }

    public final void setCmd(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cmd = str;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007¨\u0006\u000e"}, d2 = {"Lcom/baidu/nadcore/model/NadGestureDrawModel$Companion;", "", "()V", "fromJson", "Lcom/baidu/nadcore/model/NadGestureDrawModel;", "jsonString", "", "getPoints", "", "Landroid/graphics/PointF;", "pointString", "isValid", "", "model", "nadcore-lib-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NadGestureDrawModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NadGestureDrawModel fromJson(String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            JSONObject json = JSONUtils.newJSONObject(jsonString);
            Intrinsics.checkNotNullExpressionValue(json, "newJSONObject(jsonString)");
            NadGestureDrawModel nadGestureDrawModel = new NadGestureDrawModel();
            NadGestureDrawModel $this$fromJson_u24lambda_u2d0 = nadGestureDrawModel;
            $this$fromJson_u24lambda_u2d0.setStartTime(json.optLong("start_time", -1));
            $this$fromJson_u24lambda_u2d0.setDuration(json.optLong("duration", -1));
            $this$fromJson_u24lambda_u2d0.setWidth(json.optDouble("width", 0.0d));
            $this$fromJson_u24lambda_u2d0.setHeight(json.optDouble("height", 0.0d));
            NadGestureBoardModel.Companion companion = NadGestureBoardModel.Companion;
            String optString = json.optString(HttpConstants.HTTP_BOARD);
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"board\")");
            $this$fromJson_u24lambda_u2d0.setBoard(companion.fromJson(optString));
            String optString2 = json.optString(NadDazzleModelKt.MASK_COLOR, "");
            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"mask_color\", \"\")");
            $this$fromJson_u24lambda_u2d0.setMaskColor(optString2);
            $this$fromJson_u24lambda_u2d0.setLineWidth(json.optDouble("line_width", 5.0d));
            String optString3 = json.optString("line_color", "#FFFFFFFF");
            Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"line_color\", LINE_DEFAULT_COLOR)");
            $this$fromJson_u24lambda_u2d0.setLineColor(optString3);
            $this$fromJson_u24lambda_u2d0.setRecognitionType(json.optInt("recognition_type", 0));
            $this$fromJson_u24lambda_u2d0.setSimilarity(json.optDouble("similarity", 1.0d));
            Companion companion2 = NadGestureDrawModel.Companion;
            String optString4 = json.optString("points");
            Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"points\")");
            $this$fromJson_u24lambda_u2d0.setPoints(companion2.getPoints(optString4));
            String optString5 = json.optString("lottie", "");
            Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(\"lottie\", \"\")");
            $this$fromJson_u24lambda_u2d0.setLottie(optString5);
            String optString6 = json.optString("cmd", "");
            Intrinsics.checkNotNullExpressionValue(optString6, "json.optString(\"cmd\", \"\")");
            $this$fromJson_u24lambda_u2d0.setCmd(optString6);
            return nadGestureDrawModel;
        }

        @JvmStatic
        public final List<PointF> getPoints(String pointString) {
            String str = pointString;
            Intrinsics.checkNotNullParameter(str, "pointString");
            List pointsList = new ArrayList();
            if (StringsKt.isBlank(str)) {
                return pointsList;
            }
            List<String> splitPoint = StringsKt.split$default((CharSequence) str, new String[]{"|"}, false, 0, 6, (Object) null);
            if (splitPoint.size() <= 1) {
                return pointsList;
            }
            for (String it : splitPoint) {
                List pointStr = StringsKt.split$default((CharSequence) it, new String[]{"_"}, false, 0, 6, (Object) null);
                if (pointStr.size() == 2) {
                    PointF point = new PointF();
                    PointF $this$getPoints_u24lambda_u2d2_u24lambda_u2d1 = point;
                    Float floatOrNull = StringsKt.toFloatOrNull((String) pointStr.get(0));
                    if (floatOrNull != null) {
                        $this$getPoints_u24lambda_u2d2_u24lambda_u2d1.x = floatOrNull.floatValue();
                        Float floatOrNull2 = StringsKt.toFloatOrNull((String) pointStr.get(1));
                        if (floatOrNull2 != null) {
                            $this$getPoints_u24lambda_u2d2_u24lambda_u2d1.y = floatOrNull2.floatValue();
                            pointsList.add(point);
                        }
                    }
                }
            }
            return pointsList;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
            r0 = r0.getImageUrl();
         */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean isValid(com.baidu.nadcore.model.NadGestureDrawModel r8) {
            /*
                r7 = this;
                java.lang.String r0 = "model"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                com.baidu.nadcore.model.NadGestureDrawModel$NadGestureBoardModel r0 = r8.getBoard()
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L_0x001e
                java.lang.String r0 = r0.getImageUrl()
                if (r0 == 0) goto L_0x001e
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = kotlin.text.StringsKt.isBlank(r0)
                r0 = r0 ^ r2
                if (r0 != r2) goto L_0x001e
                r0 = r2
                goto L_0x001f
            L_0x001e:
                r0 = r1
            L_0x001f:
                if (r0 == 0) goto L_0x006b
                java.util.List r0 = r8.getPoints()
                int r0 = r0.size()
                if (r0 <= r2) goto L_0x006b
                java.lang.String r0 = r8.getLottie()
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = kotlin.text.StringsKt.isBlank(r0)
                r0 = r0 ^ r2
                if (r0 == 0) goto L_0x006b
                double r3 = r8.getWidth()
                r5 = 0
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 <= 0) goto L_0x006b
                double r3 = r8.getHeight()
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 <= 0) goto L_0x006b
                long r3 = r8.getStartTime()
                r5 = 0
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 < 0) goto L_0x006b
                long r3 = r8.getDuration()
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 <= 0) goto L_0x006b
                java.lang.String r0 = r8.getCmd()
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = kotlin.text.StringsKt.isBlank(r0)
                r0 = r0 ^ r2
                if (r0 == 0) goto L_0x006b
                r1 = r2
                goto L_0x006c
            L_0x006b:
            L_0x006c:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.model.NadGestureDrawModel.Companion.isValid(com.baidu.nadcore.model.NadGestureDrawModel):boolean");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lcom/baidu/nadcore/model/NadGestureDrawModel$NadGestureBoardModel;", "", "()V", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "text", "getText", "setText", "Companion", "nadcore-lib-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NadGestureDrawModel.kt */
    public static final class NadGestureBoardModel {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String imageUrl = "";
        private String text = "";

        @JvmStatic
        public static final NadGestureBoardModel fromJson(String str) {
            return Companion.fromJson(str);
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final void setImageUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imageUrl = str;
        }

        public final String getText() {
            return this.text;
        }

        public final void setText(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/baidu/nadcore/model/NadGestureDrawModel$NadGestureBoardModel$Companion;", "", "()V", "fromJson", "Lcom/baidu/nadcore/model/NadGestureDrawModel$NadGestureBoardModel;", "jsonString", "", "nadcore-lib-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: NadGestureDrawModel.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final NadGestureBoardModel fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                JSONObject json = JSONUtils.newJSONObject(jsonString);
                Intrinsics.checkNotNullExpressionValue(json, "newJSONObject(jsonString)");
                NadGestureBoardModel nadGestureBoardModel = new NadGestureBoardModel();
                NadGestureBoardModel $this$fromJson_u24lambda_u2d0 = nadGestureBoardModel;
                String optString = json.optString("image_url");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"image_url\")");
                $this$fromJson_u24lambda_u2d0.setImageUrl(optString);
                String optString2 = json.optString("text");
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"text\")");
                $this$fromJson_u24lambda_u2d0.setText(optString2);
                return nadGestureBoardModel;
            }
        }
    }
}
