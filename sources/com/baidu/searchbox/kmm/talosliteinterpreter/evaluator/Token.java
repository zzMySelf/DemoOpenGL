package com.baidu.searchbox.kmm.talosliteinterpreter.evaluator;

import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0001\u0007\b\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token;", "", "Bracket", "FunctionCall", "Operand", "Operator", "SelectCall", "VariableCall", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operand;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$FunctionCall;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$FunctionCall$Delimiter;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$SelectCall;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$VariableCall;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Bracket;", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Token.kt */
public interface Token {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operand;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token;", "Boolean", "Constant", "Number", "Variable", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operand$Number;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operand$Boolean;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operand$Variable;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operand$Constant;", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Token.kt */
    public interface Operand extends Token {

        @JvmInline
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0014\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0007J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operand$Number;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operand;", "value", "", "constructor-impl", "(I)D", "", "(D)D", "getValue", "()D", "equals", "", "other", "", "equals-impl", "(DLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(D)I", "toString", "", "toString-impl", "(D)Ljava/lang/String;", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Number implements Operand {
            private final double value;

            /* renamed from: box-impl  reason: not valid java name */
            public static final /* synthetic */ Number m20655boximpl(double d2) {
                return new Number(d2);
            }

            /* renamed from: constructor-impl  reason: not valid java name */
            public static double m20656constructorimpl(double d2) {
                return d2;
            }

            /* renamed from: equals-impl  reason: not valid java name */
            public static boolean m20658equalsimpl(double d2, Object obj) {
                if (!(obj instanceof Number)) {
                    return false;
                }
                return Intrinsics.areEqual((Object) Double.valueOf(d2), (Object) Double.valueOf(((Number) obj).m20662unboximpl()));
            }

            /* renamed from: equals-impl0  reason: not valid java name */
            public static final boolean m20659equalsimpl0(double d2, double d3) {
                return Intrinsics.areEqual((Object) Double.valueOf(d2), (Object) Double.valueOf(d3));
            }

            /* renamed from: hashCode-impl  reason: not valid java name */
            public static int m20660hashCodeimpl(double d2) {
                return Double.hashCode(d2);
            }

            /* renamed from: toString-impl  reason: not valid java name */
            public static String m20661toStringimpl(double d2) {
                return "Number(value=" + d2 + ')';
            }

            public boolean equals(Object obj) {
                return m20658equalsimpl(this.value, obj);
            }

            public int hashCode() {
                return m20660hashCodeimpl(this.value);
            }

            public String toString() {
                return m20661toStringimpl(this.value);
            }

            /* renamed from: unbox-impl  reason: not valid java name */
            public final /* synthetic */ double m20662unboximpl() {
                return this.value;
            }

            private /* synthetic */ Number(double value2) {
                this.value = value2;
            }

            public final double getValue() {
                return this.value;
            }

            /* renamed from: constructor-impl  reason: not valid java name */
            public static double m20657constructorimpl(int value2) {
                return m20656constructorimpl((double) value2);
            }
        }

        @JvmInline
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operand$Boolean;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operand;", "value", "", "constructor-impl", "(Z)Z", "getValue", "()Z", "equals", "other", "", "equals-impl", "(ZLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Z)I", "toString", "", "toString-impl", "(Z)Ljava/lang/String;", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Boolean implements Operand {
            private final boolean value;

            /* renamed from: box-impl  reason: not valid java name */
            public static final /* synthetic */ Boolean m20641boximpl(boolean z) {
                return new Boolean(z);
            }

            /* renamed from: constructor-impl  reason: not valid java name */
            public static boolean m20642constructorimpl(boolean z) {
                return z;
            }

            /* renamed from: equals-impl  reason: not valid java name */
            public static boolean m20643equalsimpl(boolean z, Object obj) {
                return (obj instanceof Boolean) && z == ((Boolean) obj).m20647unboximpl();
            }

            /* renamed from: equals-impl0  reason: not valid java name */
            public static final boolean m20644equalsimpl0(boolean z, boolean z2) {
                return z == z2;
            }

            /* renamed from: hashCode-impl  reason: not valid java name */
            public static int m20645hashCodeimpl(boolean z) {
                if (z) {
                    return 1;
                }
                return z ? 1 : 0;
            }

            /* renamed from: toString-impl  reason: not valid java name */
            public static String m20646toStringimpl(boolean z) {
                return "Boolean(value=" + z + ')';
            }

            public boolean equals(Object obj) {
                return m20643equalsimpl(this.value, obj);
            }

            public int hashCode() {
                return m20645hashCodeimpl(this.value);
            }

            public String toString() {
                return m20646toStringimpl(this.value);
            }

            /* renamed from: unbox-impl  reason: not valid java name */
            public final /* synthetic */ boolean m20647unboximpl() {
                return this.value;
            }

            private /* synthetic */ Boolean(boolean value2) {
                this.value = value2;
            }

            public final boolean getValue() {
                return this.value;
            }
        }

        @JvmInline
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operand$Variable;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operand;", "value", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Variable implements Operand {
            private final String value;

            /* renamed from: box-impl  reason: not valid java name */
            public static final /* synthetic */ Variable m20663boximpl(String str) {
                return new Variable(str);
            }

            /* renamed from: constructor-impl  reason: not valid java name */
            public static String m20664constructorimpl(String str) {
                Intrinsics.checkNotNullParameter(str, "value");
                return str;
            }

            /* renamed from: equals-impl  reason: not valid java name */
            public static boolean m20665equalsimpl(String str, Object obj) {
                return (obj instanceof Variable) && Intrinsics.areEqual((Object) str, (Object) ((Variable) obj).m20669unboximpl());
            }

            /* renamed from: equals-impl0  reason: not valid java name */
            public static final boolean m20666equalsimpl0(String str, String str2) {
                return Intrinsics.areEqual((Object) str, (Object) str2);
            }

            /* renamed from: hashCode-impl  reason: not valid java name */
            public static int m20667hashCodeimpl(String str) {
                return str.hashCode();
            }

            /* renamed from: toString-impl  reason: not valid java name */
            public static String m20668toStringimpl(String str) {
                return "Variable(value=" + str + ')';
            }

            public boolean equals(Object obj) {
                return m20665equalsimpl(this.value, obj);
            }

            public int hashCode() {
                return m20667hashCodeimpl(this.value);
            }

            public String toString() {
                return m20668toStringimpl(this.value);
            }

            /* renamed from: unbox-impl  reason: not valid java name */
            public final /* synthetic */ String m20669unboximpl() {
                return this.value;
            }

            private /* synthetic */ Variable(String value2) {
                this.value = value2;
            }

            public final String getValue() {
                return this.value;
            }
        }

        @JvmInline
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operand$Constant;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operand;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "equals", "", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Constant implements Operand {
            private final Object value;

            /* renamed from: box-impl  reason: not valid java name */
            public static final /* synthetic */ Constant m20648boximpl(Object obj) {
                return new Constant(obj);
            }

            /* renamed from: constructor-impl  reason: not valid java name */
            public static Object m20649constructorimpl(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "value");
                return obj;
            }

            /* renamed from: equals-impl  reason: not valid java name */
            public static boolean m20650equalsimpl(Object obj, Object obj2) {
                return (obj2 instanceof Constant) && Intrinsics.areEqual(obj, ((Constant) obj2).m20654unboximpl());
            }

            /* renamed from: equals-impl0  reason: not valid java name */
            public static final boolean m20651equalsimpl0(Object obj, Object obj2) {
                return Intrinsics.areEqual(obj, obj2);
            }

            /* renamed from: hashCode-impl  reason: not valid java name */
            public static int m20652hashCodeimpl(Object obj) {
                return obj.hashCode();
            }

            /* renamed from: toString-impl  reason: not valid java name */
            public static String m20653toStringimpl(Object obj) {
                return "Constant(value=" + obj + ')';
            }

            public boolean equals(Object obj) {
                return m20650equalsimpl(this.value, obj);
            }

            public int hashCode() {
                return m20652hashCodeimpl(this.value);
            }

            public String toString() {
                return m20653toStringimpl(this.value);
            }

            /* renamed from: unbox-impl  reason: not valid java name */
            public final /* synthetic */ Object m20654unboximpl() {
                return this.value;
            }

            private /* synthetic */ Constant(Object value2) {
                this.value = value2;
            }

            public final Object getValue() {
                return this.value;
            }
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0015\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0001\u0015\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+¨\u0006,"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token;", "And", "Division", "DoubleNot", "Equal", "GreaterEqualThan", "GreaterThan", "LessEqualThan", "LessThan", "Minus", "Modulo", "Multiplication", "Not", "NotEqual", "Or", "Plus", "Power", "TernaryElse", "TernaryIf", "TernaryIfElse", "UnaryMinus", "UnaryPlus", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Plus;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Minus;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Multiplication;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Division;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Modulo;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Power;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$UnaryMinus;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$UnaryPlus;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$And;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Or;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Not;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$DoubleNot;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$GreaterThan;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$GreaterEqualThan;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$LessThan;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$LessEqualThan;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Equal;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$NotEqual;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$TernaryIf;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$TernaryElse;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$TernaryIfElse;", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Token.kt */
    public interface Operator extends Token {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Plus;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Plus implements Operator {
            public static final Plus INSTANCE = new Plus();

            private Plus() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Minus;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Minus implements Operator {
            public static final Minus INSTANCE = new Minus();

            private Minus() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Multiplication;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Multiplication implements Operator {
            public static final Multiplication INSTANCE = new Multiplication();

            private Multiplication() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Division;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Division implements Operator {
            public static final Division INSTANCE = new Division();

            private Division() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Modulo;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Modulo implements Operator {
            public static final Modulo INSTANCE = new Modulo();

            private Modulo() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Power;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Power implements Operator {
            public static final Power INSTANCE = new Power();

            private Power() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$UnaryMinus;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class UnaryMinus implements Operator {
            public static final UnaryMinus INSTANCE = new UnaryMinus();

            private UnaryMinus() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$UnaryPlus;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class UnaryPlus implements Operator {
            public static final UnaryPlus INSTANCE = new UnaryPlus();

            private UnaryPlus() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$And;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class And implements Operator {
            public static final And INSTANCE = new And();

            private And() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Or;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Or implements Operator {
            public static final Or INSTANCE = new Or();

            private Or() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Not;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Not implements Operator {
            public static final Not INSTANCE = new Not();

            private Not() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$DoubleNot;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class DoubleNot implements Operator {
            public static final DoubleNot INSTANCE = new DoubleNot();

            private DoubleNot() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$GreaterThan;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class GreaterThan implements Operator {
            public static final GreaterThan INSTANCE = new GreaterThan();

            private GreaterThan() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$GreaterEqualThan;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class GreaterEqualThan implements Operator {
            public static final GreaterEqualThan INSTANCE = new GreaterEqualThan();

            private GreaterEqualThan() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$LessThan;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class LessThan implements Operator {
            public static final LessThan INSTANCE = new LessThan();

            private LessThan() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$LessEqualThan;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class LessEqualThan implements Operator {
            public static final LessEqualThan INSTANCE = new LessEqualThan();

            private LessEqualThan() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$Equal;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Equal implements Operator {
            public static final Equal INSTANCE = new Equal();

            private Equal() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$NotEqual;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class NotEqual implements Operator {
            public static final NotEqual INSTANCE = new NotEqual();

            private NotEqual() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$TernaryIf;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class TernaryIf implements Operator {
            public static final TernaryIf INSTANCE = new TernaryIf();

            private TernaryIf() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$TernaryElse;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class TernaryElse implements Operator {
            public static final TernaryElse INSTANCE = new TernaryElse();

            private TernaryElse() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator$TernaryIfElse;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Operator;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class TernaryIfElse implements Operator {
            public static final TernaryIfElse INSTANCE = new TernaryIfElse();

            private TernaryIfElse() {
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\u0017\u0010\u0013\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015H\u0002J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$FunctionCall;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token;", "argsCount", "", "function", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Function;", "(ILcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Function;)V", "getArgsCount", "()I", "getFunction", "()Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Function;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "invoke", "args", "", "toString", "", "Delimiter", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Token.kt */
    public static final class FunctionCall implements Token {
        private final int argsCount;
        private final Function function;

        public static /* synthetic */ FunctionCall copy$default(FunctionCall functionCall, int i2, Function function2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = functionCall.argsCount;
            }
            if ((i3 & 2) != 0) {
                function2 = functionCall.function;
            }
            return functionCall.copy(i2, function2);
        }

        public final int component1() {
            return this.argsCount;
        }

        public final Function component2() {
            return this.function;
        }

        public final FunctionCall copy(int i2, Function function2) {
            Intrinsics.checkNotNullParameter(function2, "function");
            return new FunctionCall(i2, function2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FunctionCall)) {
                return false;
            }
            FunctionCall functionCall = (FunctionCall) obj;
            return this.argsCount == functionCall.argsCount && Intrinsics.areEqual((Object) this.function, (Object) functionCall.function);
        }

        public int hashCode() {
            return (Integer.hashCode(this.argsCount) * 31) + this.function.hashCode();
        }

        public String toString() {
            return "FunctionCall(argsCount=" + this.argsCount + ", function=" + this.function + ')';
        }

        public FunctionCall(int argsCount2, Function function2) {
            Intrinsics.checkNotNullParameter(function2, "function");
            this.argsCount = argsCount2;
            this.function = function2;
        }

        public final int getArgsCount() {
            return this.argsCount;
        }

        public final Function getFunction() {
            return this.function;
        }

        public final Object invoke(List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(args, "args");
            Function function2 = this.function;
            Object[] array = args.toArray(new Object[0]);
            if (array != null) {
                return function2.invoke(Arrays.copyOf(array, array.length));
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$FunctionCall$Delimiter;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Delimiter implements Token {
            public static final Delimiter INSTANCE = new Delimiter();

            private Delimiter() {
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$SelectCall;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token;", "expression", "", "(Ljava/lang/String;)V", "getExpression", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "length", "litter", "toString", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Token.kt */
    public static final class SelectCall implements Token {
        private final String expression;

        public static /* synthetic */ SelectCall copy$default(SelectCall selectCall, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = selectCall.expression;
            }
            return selectCall.copy(str);
        }

        public final String component1() {
            return this.expression;
        }

        public final SelectCall copy(String str) {
            Intrinsics.checkNotNullParameter(str, "expression");
            return new SelectCall(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SelectCall) && Intrinsics.areEqual((Object) this.expression, (Object) ((SelectCall) obj).expression);
        }

        public int hashCode() {
            return this.expression.hashCode();
        }

        public String toString() {
            return "SelectCall(expression=" + this.expression + ')';
        }

        public SelectCall(String expression2) {
            Intrinsics.checkNotNullParameter(expression2, "expression");
            this.expression = expression2;
        }

        public final String getExpression() {
            return this.expression;
        }

        public final String litter() {
            return StringsKt.trim((CharSequence) '.' + this.expression).toString();
        }

        public final int length() {
            return this.expression.length();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u000eJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$VariableCall;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token;", "variableStr", "", "(Ljava/lang/String;)V", "getVariableStr", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "length", "toString", "variableKey", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Token.kt */
    public static final class VariableCall implements Token {
        private final String variableStr;

        public static /* synthetic */ VariableCall copy$default(VariableCall variableCall, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = variableCall.variableStr;
            }
            return variableCall.copy(str);
        }

        public final String component1() {
            return this.variableStr;
        }

        public final VariableCall copy(String str) {
            Intrinsics.checkNotNullParameter(str, "variableStr");
            return new VariableCall(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VariableCall) && Intrinsics.areEqual((Object) this.variableStr, (Object) ((VariableCall) obj).variableStr);
        }

        public int hashCode() {
            return this.variableStr.hashCode();
        }

        public String toString() {
            return "VariableCall(variableStr=" + this.variableStr + ')';
        }

        public VariableCall(String variableStr2) {
            Intrinsics.checkNotNullParameter(variableStr2, "variableStr");
            this.variableStr = variableStr2;
        }

        public final String getVariableStr() {
            return this.variableStr;
        }

        public final String variableKey() {
            return StringsKt.trim((CharSequence) StringsKt.substringAfter$default(this.variableStr, "$args", (String) null, 2, (Object) null)).toString();
        }

        public final int length() {
            return this.variableStr.length();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Bracket;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token;", "()V", "Left", "Right", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Bracket$Left;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Bracket$Right;", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Token.kt */
    public static abstract class Bracket implements Token {
        public /* synthetic */ Bracket(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Bracket$Left;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Bracket;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Left extends Bracket {
            public static final Left INSTANCE = new Left();

            private Left() {
                super((DefaultConstructorMarker) null);
            }
        }

        private Bracket() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Bracket$Right;", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Token$Bracket;", "()V", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Right extends Bracket {
            public static final Right INSTANCE = new Right();

            private Right() {
                super((DefaultConstructorMarker) null);
            }
        }
    }
}
