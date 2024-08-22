package com.google.protobuf.util;

import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.result.GetUserAttrInfoResult;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.protobuf.Any;
import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.Duration;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.FieldMask;
import com.google.protobuf.FloatValue;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Int64Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.NullValue;
import com.google.protobuf.StringValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.protobuf.UInt32Value;
import com.google.protobuf.UInt64Value;
import com.google.protobuf.Value;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

public class JsonFormat {
    public static final Logger logger = Logger.getLogger(JsonFormat.class.getName());

    /* renamed from: com.google.protobuf.util.JsonFormat$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.Descriptors$FieldDescriptor$Type[] r0 = com.google.protobuf.Descriptors.FieldDescriptor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r0
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.INT32     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SINT32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.INT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SINT64     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.BOOL     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.FLOAT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.DOUBLE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.UINT32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.FIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.UINT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.FIXED64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.STRING     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.ENUM     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.util.JsonFormat.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class CompactTextGenerator implements TextGenerator {
        public final Appendable output;

        public /* synthetic */ CompactTextGenerator(Appendable appendable, AnonymousClass1 r2) {
            this(appendable);
        }

        public void indent() {
        }

        public void outdent() {
        }

        public void print(CharSequence charSequence) throws IOException {
            this.output.append(charSequence);
        }

        public CompactTextGenerator(Appendable appendable) {
            this.output = appendable;
        }
    }

    public static class Parser {
        public static final int DEFAULT_RECURSION_LIMIT = 100;
        public final boolean ignoringUnknownFields;
        public final TypeRegistry oldRegistry;
        public final int recursionLimit;
        public final com.google.protobuf.TypeRegistry registry;

        public /* synthetic */ Parser(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, boolean z, int i2, AnonymousClass1 r5) {
            this(typeRegistry, typeRegistry2, z, i2);
        }

        public Parser ignoringUnknownFields() {
            return new Parser(this.registry, this.oldRegistry, true, this.recursionLimit);
        }

        public void merge(String str, Message.Builder builder) throws InvalidProtocolBufferException {
            new ParserImpl(this.registry, this.oldRegistry, this.ignoringUnknownFields, this.recursionLimit).merge(str, builder);
        }

        public Parser usingRecursionLimit(int i2) {
            return new Parser(this.registry, this.oldRegistry, this.ignoringUnknownFields, i2);
        }

        public Parser usingTypeRegistry(TypeRegistry typeRegistry) {
            if (this.oldRegistry == TypeRegistry.getEmptyTypeRegistry() && this.registry == com.google.protobuf.TypeRegistry.getEmptyTypeRegistry()) {
                return new Parser(com.google.protobuf.TypeRegistry.getEmptyTypeRegistry(), typeRegistry, this.ignoringUnknownFields, this.recursionLimit);
            }
            throw new IllegalArgumentException("Only one registry is allowed.");
        }

        public Parser(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, boolean z, int i2) {
            this.registry = typeRegistry;
            this.oldRegistry = typeRegistry2;
            this.ignoringUnknownFields = z;
            this.recursionLimit = i2;
        }

        public void merge(Reader reader, Message.Builder builder) throws IOException {
            new ParserImpl(this.registry, this.oldRegistry, this.ignoringUnknownFields, this.recursionLimit).merge(reader, builder);
        }

        public Parser usingTypeRegistry(com.google.protobuf.TypeRegistry typeRegistry) {
            if (this.oldRegistry == TypeRegistry.getEmptyTypeRegistry() && this.registry == com.google.protobuf.TypeRegistry.getEmptyTypeRegistry()) {
                return new Parser(typeRegistry, this.oldRegistry, this.ignoringUnknownFields, this.recursionLimit);
            }
            throw new IllegalArgumentException("Only one registry is allowed.");
        }
    }

    public static final class PrettyTextGenerator implements TextGenerator {
        public boolean atStartOfLine;
        public final StringBuilder indent;
        public final Appendable output;

        public /* synthetic */ PrettyTextGenerator(Appendable appendable, AnonymousClass1 r2) {
            this(appendable);
        }

        private void write(CharSequence charSequence) throws IOException {
            if (charSequence.length() != 0) {
                if (this.atStartOfLine) {
                    this.atStartOfLine = false;
                    this.output.append(this.indent);
                }
                this.output.append(charSequence);
            }
        }

        public void indent() {
            this.indent.append("  ");
        }

        public void outdent() {
            int length = this.indent.length();
            if (length >= 2) {
                this.indent.delete(length - 2, length);
                return;
            }
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }

        public void print(CharSequence charSequence) throws IOException {
            int length = charSequence.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (charSequence.charAt(i3) == 10) {
                    int i4 = i3 + 1;
                    write(charSequence.subSequence(i2, i4));
                    this.atStartOfLine = true;
                    i2 = i4;
                }
            }
            write(charSequence.subSequence(i2, length));
        }

        public PrettyTextGenerator(Appendable appendable) {
            this.indent = new StringBuilder();
            this.atStartOfLine = true;
            this.output = appendable;
        }
    }

    public static class Printer {
        public boolean alwaysOutputDefaultValueFields;
        public Set<Descriptors.FieldDescriptor> includingDefaultValueFields;
        public final TypeRegistry oldRegistry;
        public final boolean omittingInsignificantWhitespace;
        public final boolean preservingProtoFieldNames;
        public final boolean printingEnumsAsInts;
        public final com.google.protobuf.TypeRegistry registry;
        public final boolean sortingMapKeys;

        public /* synthetic */ Printer(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, boolean z, Set set, boolean z2, boolean z3, boolean z4, boolean z5, AnonymousClass1 r9) {
            this(typeRegistry, typeRegistry2, z, set, z2, z3, z4, z5);
        }

        private void checkUnsetIncludingDefaultValueFields() {
            if (this.alwaysOutputDefaultValueFields || !this.includingDefaultValueFields.isEmpty()) {
                throw new IllegalStateException("JsonFormat includingDefaultValueFields has already been set.");
            }
        }

        private void checkUnsetPrintingEnumsAsInts() {
            if (this.printingEnumsAsInts) {
                throw new IllegalStateException("JsonFormat printingEnumsAsInts has already been set.");
            }
        }

        public void appendTo(MessageOrBuilder messageOrBuilder, Appendable appendable) throws IOException {
            new PrinterImpl(this.registry, this.oldRegistry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, appendable, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys).print(messageOrBuilder);
        }

        public Printer includingDefaultValueFields() {
            checkUnsetIncludingDefaultValueFields();
            return new Printer(this.registry, this.oldRegistry, true, Collections.emptySet(), this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
        }

        public Printer omittingInsignificantWhitespace() {
            return new Printer(this.registry, this.oldRegistry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, true, this.printingEnumsAsInts, this.sortingMapKeys);
        }

        public Printer preservingProtoFieldNames() {
            return new Printer(this.registry, this.oldRegistry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, true, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
        }

        public String print(MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
            try {
                StringBuilder sb = new StringBuilder();
                appendTo(messageOrBuilder, sb);
                return sb.toString();
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public Printer printingEnumsAsInts() {
            checkUnsetPrintingEnumsAsInts();
            return new Printer(this.registry, this.oldRegistry, this.alwaysOutputDefaultValueFields, Collections.emptySet(), this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, true, this.sortingMapKeys);
        }

        public Printer sortingMapKeys() {
            return new Printer(this.registry, this.oldRegistry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, true);
        }

        public Printer usingTypeRegistry(TypeRegistry typeRegistry) {
            if (this.oldRegistry == TypeRegistry.getEmptyTypeRegistry() && this.registry == com.google.protobuf.TypeRegistry.getEmptyTypeRegistry()) {
                return new Printer(com.google.protobuf.TypeRegistry.getEmptyTypeRegistry(), typeRegistry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
            }
            throw new IllegalArgumentException("Only one registry is allowed.");
        }

        public Printer(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, boolean z, Set<Descriptors.FieldDescriptor> set, boolean z2, boolean z3, boolean z4, boolean z5) {
            this.registry = typeRegistry;
            this.oldRegistry = typeRegistry2;
            this.alwaysOutputDefaultValueFields = z;
            this.includingDefaultValueFields = set;
            this.preservingProtoFieldNames = z2;
            this.omittingInsignificantWhitespace = z3;
            this.printingEnumsAsInts = z4;
            this.sortingMapKeys = z5;
        }

        public Printer includingDefaultValueFields(Set<Descriptors.FieldDescriptor> set) {
            Preconditions.checkArgument(set != null && !set.isEmpty(), "Non-empty Set must be supplied for includingDefaultValueFields.");
            checkUnsetIncludingDefaultValueFields();
            return new Printer(this.registry, this.oldRegistry, false, Collections.unmodifiableSet(new HashSet(set)), this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
        }

        public Printer usingTypeRegistry(com.google.protobuf.TypeRegistry typeRegistry) {
            if (this.oldRegistry == TypeRegistry.getEmptyTypeRegistry() && this.registry == com.google.protobuf.TypeRegistry.getEmptyTypeRegistry()) {
                return new Printer(typeRegistry, this.oldRegistry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
            }
            throw new IllegalArgumentException("Only one registry is allowed.");
        }
    }

    public static final class PrinterImpl {
        public static final Map<String, WellKnownTypePrinter> wellKnownTypePrinters = buildWellKnownTypePrinters();
        public final boolean alwaysOutputDefaultValueFields;
        public final CharSequence blankOrNewLine;
        public final CharSequence blankOrSpace;
        public final TextGenerator generator;
        public final Gson gson = GsonHolder.DEFAULT_GSON;
        public final Set<Descriptors.FieldDescriptor> includingDefaultValueFields;
        public final TypeRegistry oldRegistry;
        public final boolean preservingProtoFieldNames;
        public final boolean printingEnumsAsInts;
        public final com.google.protobuf.TypeRegistry registry;
        public final boolean sortingMapKeys;

        public static class GsonHolder {
            public static final Gson DEFAULT_GSON = new GsonBuilder().create();
        }

        public interface WellKnownTypePrinter {
            void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws IOException;
        }

        public PrinterImpl(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, boolean z, Set<Descriptors.FieldDescriptor> set, boolean z2, Appendable appendable, boolean z3, boolean z4, boolean z5) {
            this.registry = typeRegistry;
            this.oldRegistry = typeRegistry2;
            this.alwaysOutputDefaultValueFields = z;
            this.includingDefaultValueFields = set;
            this.preservingProtoFieldNames = z2;
            this.printingEnumsAsInts = z4;
            this.sortingMapKeys = z5;
            if (z3) {
                this.generator = new CompactTextGenerator(appendable, (AnonymousClass1) null);
                this.blankOrSpace = "";
                this.blankOrNewLine = "";
                return;
            }
            this.generator = new PrettyTextGenerator(appendable, (AnonymousClass1) null);
            this.blankOrSpace = " ";
            this.blankOrNewLine = StringUtils.LF;
        }

        public static Map<String, WellKnownTypePrinter> buildWellKnownTypePrinters() {
            HashMap hashMap = new HashMap();
            hashMap.put(Any.getDescriptor().getFullName(), new WellKnownTypePrinter() {
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws IOException {
                    printerImpl.printAny(messageOrBuilder);
                }
            });
            AnonymousClass2 r1 = new WellKnownTypePrinter() {
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws IOException {
                    printerImpl.printWrapper(messageOrBuilder);
                }
            };
            hashMap.put(BoolValue.getDescriptor().getFullName(), r1);
            hashMap.put(Int32Value.getDescriptor().getFullName(), r1);
            hashMap.put(UInt32Value.getDescriptor().getFullName(), r1);
            hashMap.put(Int64Value.getDescriptor().getFullName(), r1);
            hashMap.put(UInt64Value.getDescriptor().getFullName(), r1);
            hashMap.put(StringValue.getDescriptor().getFullName(), r1);
            hashMap.put(BytesValue.getDescriptor().getFullName(), r1);
            hashMap.put(FloatValue.getDescriptor().getFullName(), r1);
            hashMap.put(DoubleValue.getDescriptor().getFullName(), r1);
            hashMap.put(Timestamp.getDescriptor().getFullName(), new WellKnownTypePrinter() {
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws IOException {
                    printerImpl.printTimestamp(messageOrBuilder);
                }
            });
            hashMap.put(Duration.getDescriptor().getFullName(), new WellKnownTypePrinter() {
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws IOException {
                    printerImpl.printDuration(messageOrBuilder);
                }
            });
            hashMap.put(FieldMask.getDescriptor().getFullName(), new WellKnownTypePrinter() {
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws IOException {
                    printerImpl.printFieldMask(messageOrBuilder);
                }
            });
            hashMap.put(Struct.getDescriptor().getFullName(), new WellKnownTypePrinter() {
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws IOException {
                    printerImpl.printStruct(messageOrBuilder);
                }
            });
            hashMap.put(Value.getDescriptor().getFullName(), new WellKnownTypePrinter() {
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws IOException {
                    printerImpl.printValue(messageOrBuilder);
                }
            });
            hashMap.put(ListValue.getDescriptor().getFullName(), new WellKnownTypePrinter() {
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws IOException {
                    printerImpl.printListValue(messageOrBuilder);
                }
            });
            return hashMap;
        }

        /* access modifiers changed from: private */
        public void printAny(MessageOrBuilder messageOrBuilder) throws IOException {
            if (Any.getDefaultInstance().equals(messageOrBuilder)) {
                this.generator.print(StringUtil.EMPTY_ARRAY);
                return;
            }
            Descriptors.Descriptor descriptorForType = messageOrBuilder.getDescriptorForType();
            Descriptors.FieldDescriptor findFieldByName = descriptorForType.findFieldByName("type_url");
            Descriptors.FieldDescriptor findFieldByName2 = descriptorForType.findFieldByName("value");
            if (findFieldByName == null || findFieldByName2 == null || findFieldByName.getType() != Descriptors.FieldDescriptor.Type.STRING || findFieldByName2.getType() != Descriptors.FieldDescriptor.Type.BYTES) {
                throw new InvalidProtocolBufferException("Invalid Any type.");
            }
            String str = (String) messageOrBuilder.getField(findFieldByName);
            Descriptors.Descriptor descriptorForTypeUrl = this.registry.getDescriptorForTypeUrl(str);
            if (descriptorForTypeUrl == null && (descriptorForTypeUrl = this.oldRegistry.getDescriptorForTypeUrl(str)) == null) {
                throw new InvalidProtocolBufferException("Cannot find type for url: " + str);
            }
            Message parseFrom = DynamicMessage.getDefaultInstance(descriptorForTypeUrl).getParserForType().parseFrom((ByteString) messageOrBuilder.getField(findFieldByName2));
            WellKnownTypePrinter wellKnownTypePrinter = wellKnownTypePrinters.get(JsonFormat.getTypeName(str));
            if (wellKnownTypePrinter != null) {
                TextGenerator textGenerator = this.generator;
                textGenerator.print(StringUtil.ARRAY_START + this.blankOrNewLine);
                this.generator.indent();
                TextGenerator textGenerator2 = this.generator;
                textGenerator2.print("\"@type\":" + this.blankOrSpace + this.gson.toJson((Object) str) + "," + this.blankOrNewLine);
                TextGenerator textGenerator3 = this.generator;
                StringBuilder sb = new StringBuilder();
                sb.append("\"value\":");
                sb.append(this.blankOrSpace);
                textGenerator3.print(sb.toString());
                wellKnownTypePrinter.print(this, parseFrom);
                this.generator.print(this.blankOrNewLine);
                this.generator.outdent();
                this.generator.print("}");
                return;
            }
            print(parseFrom, str);
        }

        /* access modifiers changed from: private */
        public void printDuration(MessageOrBuilder messageOrBuilder) throws IOException {
            Duration parseFrom = Duration.parseFrom(toByteString(messageOrBuilder));
            TextGenerator textGenerator = this.generator;
            textGenerator.print("\"" + Durations.toString(parseFrom) + "\"");
        }

        private void printField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) throws IOException {
            if (this.preservingProtoFieldNames) {
                TextGenerator textGenerator = this.generator;
                textGenerator.print("\"" + fieldDescriptor.getName() + "\":" + this.blankOrSpace);
            } else {
                TextGenerator textGenerator2 = this.generator;
                textGenerator2.print("\"" + fieldDescriptor.getJsonName() + "\":" + this.blankOrSpace);
            }
            if (fieldDescriptor.isMapField()) {
                printMapFieldValue(fieldDescriptor, obj);
            } else if (fieldDescriptor.isRepeated()) {
                printRepeatedFieldValue(fieldDescriptor, obj);
            } else {
                printSingleFieldValue(fieldDescriptor, obj);
            }
        }

        /* access modifiers changed from: private */
        public void printFieldMask(MessageOrBuilder messageOrBuilder) throws IOException {
            FieldMask parseFrom = FieldMask.parseFrom(toByteString(messageOrBuilder));
            TextGenerator textGenerator = this.generator;
            textGenerator.print("\"" + FieldMaskUtil.toJsonString(parseFrom) + "\"");
        }

        /* access modifiers changed from: private */
        public void printListValue(MessageOrBuilder messageOrBuilder) throws IOException {
            Descriptors.FieldDescriptor findFieldByName = messageOrBuilder.getDescriptorForType().findFieldByName(SavedStateHandle.VALUES);
            if (findFieldByName != null) {
                printRepeatedFieldValue(findFieldByName, messageOrBuilder.getField(findFieldByName));
                return;
            }
            throw new InvalidProtocolBufferException("Invalid ListValue type.");
        }

        private void printMapFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj) throws IOException {
            Descriptors.Descriptor messageType = fieldDescriptor.getMessageType();
            Descriptors.FieldDescriptor findFieldByName = messageType.findFieldByName("key");
            Descriptors.FieldDescriptor findFieldByName2 = messageType.findFieldByName("value");
            if (findFieldByName == null || findFieldByName2 == null) {
                throw new InvalidProtocolBufferException("Invalid map field.");
            }
            TextGenerator textGenerator = this.generator;
            textGenerator.print(StringUtil.ARRAY_START + this.blankOrNewLine);
            this.generator.indent();
            Collection<Message> collection = (List) obj;
            if (this.sortingMapKeys && !collection.isEmpty()) {
                AnonymousClass9 r1 = null;
                if (findFieldByName.getType() == Descriptors.FieldDescriptor.Type.STRING) {
                    r1 = new Comparator<Object>() {
                        public int compare(Object obj, Object obj2) {
                            return ByteString.unsignedLexicographicalComparator().compare(ByteString.copyFromUtf8((String) obj), ByteString.copyFromUtf8((String) obj2));
                        }
                    };
                }
                TreeMap treeMap = new TreeMap(r1);
                for (Object next : collection) {
                    treeMap.put(((Message) next).getField(findFieldByName), next);
                }
                collection = treeMap.values();
            }
            boolean z = false;
            for (Message message : collection) {
                Object field = message.getField(findFieldByName);
                Object field2 = message.getField(findFieldByName2);
                if (z) {
                    TextGenerator textGenerator2 = this.generator;
                    textGenerator2.print("," + this.blankOrNewLine);
                } else {
                    z = true;
                }
                printSingleFieldValue(findFieldByName, field, true);
                TextGenerator textGenerator3 = this.generator;
                textGenerator3.print(":" + this.blankOrSpace);
                printSingleFieldValue(findFieldByName2, field2);
            }
            if (z) {
                this.generator.print(this.blankOrNewLine);
            }
            this.generator.outdent();
            this.generator.print("}");
        }

        private void printRepeatedFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj) throws IOException {
            this.generator.print("[");
            boolean z = false;
            for (Object next : (List) obj) {
                if (z) {
                    TextGenerator textGenerator = this.generator;
                    textGenerator.print("," + this.blankOrSpace);
                } else {
                    z = true;
                }
                printSingleFieldValue(fieldDescriptor, next);
            }
            this.generator.print("]");
        }

        private void printSingleFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj) throws IOException {
            printSingleFieldValue(fieldDescriptor, obj, false);
        }

        /* access modifiers changed from: private */
        public void printStruct(MessageOrBuilder messageOrBuilder) throws IOException {
            Descriptors.FieldDescriptor findFieldByName = messageOrBuilder.getDescriptorForType().findFieldByName(GetUserAttrInfoResult.KEY_DATA_FIELDS);
            if (findFieldByName != null) {
                printMapFieldValue(findFieldByName, messageOrBuilder.getField(findFieldByName));
                return;
            }
            throw new InvalidProtocolBufferException("Invalid Struct type.");
        }

        /* access modifiers changed from: private */
        public void printTimestamp(MessageOrBuilder messageOrBuilder) throws IOException {
            Timestamp parseFrom = Timestamp.parseFrom(toByteString(messageOrBuilder));
            TextGenerator textGenerator = this.generator;
            textGenerator.print("\"" + Timestamps.toString(parseFrom) + "\"");
        }

        /* access modifiers changed from: private */
        public void printValue(MessageOrBuilder messageOrBuilder) throws IOException {
            Map<Descriptors.FieldDescriptor, Object> allFields = messageOrBuilder.getAllFields();
            if (allFields.isEmpty()) {
                this.generator.print(StringUtil.NULL_STRING);
            } else if (allFields.size() == 1) {
                for (Map.Entry next : allFields.entrySet()) {
                    printSingleFieldValue((Descriptors.FieldDescriptor) next.getKey(), next.getValue());
                }
            } else {
                throw new InvalidProtocolBufferException("Invalid Value type.");
            }
        }

        /* access modifiers changed from: private */
        public void printWrapper(MessageOrBuilder messageOrBuilder) throws IOException {
            Descriptors.FieldDescriptor findFieldByName = messageOrBuilder.getDescriptorForType().findFieldByName("value");
            if (findFieldByName != null) {
                printSingleFieldValue(findFieldByName, messageOrBuilder.getField(findFieldByName));
                return;
            }
            throw new InvalidProtocolBufferException("Invalid Wrapper type.");
        }

        private ByteString toByteString(MessageOrBuilder messageOrBuilder) {
            if (messageOrBuilder instanceof Message) {
                return ((Message) messageOrBuilder).toByteString();
            }
            return ((Message.Builder) messageOrBuilder).build().toByteString();
        }

        public void print(MessageOrBuilder messageOrBuilder) throws IOException {
            WellKnownTypePrinter wellKnownTypePrinter = wellKnownTypePrinters.get(messageOrBuilder.getDescriptorForType().getFullName());
            if (wellKnownTypePrinter != null) {
                wellKnownTypePrinter.print(this, messageOrBuilder);
            } else {
                print(messageOrBuilder, (String) null);
            }
        }

        private void printSingleFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[fieldDescriptor.getType().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    if (z) {
                        this.generator.print("\"");
                    }
                    this.generator.print(((Integer) obj).toString());
                    if (z) {
                        this.generator.print("\"");
                        return;
                    }
                    return;
                case 4:
                case 5:
                case 6:
                    TextGenerator textGenerator = this.generator;
                    textGenerator.print("\"" + ((Long) obj).toString() + "\"");
                    return;
                case 7:
                    if (z) {
                        this.generator.print("\"");
                    }
                    if (((Boolean) obj).booleanValue()) {
                        this.generator.print("true");
                    } else {
                        this.generator.print("false");
                    }
                    if (z) {
                        this.generator.print("\"");
                        return;
                    }
                    return;
                case 8:
                    Float f = (Float) obj;
                    if (f.isNaN()) {
                        this.generator.print("\"NaN\"");
                        return;
                    } else if (!f.isInfinite()) {
                        if (z) {
                            this.generator.print("\"");
                        }
                        this.generator.print(f.toString());
                        if (z) {
                            this.generator.print("\"");
                            return;
                        }
                        return;
                    } else if (f.floatValue() < 0.0f) {
                        this.generator.print("\"-Infinity\"");
                        return;
                    } else {
                        this.generator.print("\"Infinity\"");
                        return;
                    }
                case 9:
                    Double d = (Double) obj;
                    if (d.isNaN()) {
                        this.generator.print("\"NaN\"");
                        return;
                    } else if (!d.isInfinite()) {
                        if (z) {
                            this.generator.print("\"");
                        }
                        this.generator.print(d.toString());
                        if (z) {
                            this.generator.print("\"");
                            return;
                        }
                        return;
                    } else if (d.doubleValue() < 0.0d) {
                        this.generator.print("\"-Infinity\"");
                        return;
                    } else {
                        this.generator.print("\"Infinity\"");
                        return;
                    }
                case 10:
                case 11:
                    if (z) {
                        this.generator.print("\"");
                    }
                    this.generator.print(JsonFormat.unsignedToString(((Integer) obj).intValue()));
                    if (z) {
                        this.generator.print("\"");
                        return;
                    }
                    return;
                case 12:
                case 13:
                    TextGenerator textGenerator2 = this.generator;
                    textGenerator2.print("\"" + JsonFormat.unsignedToString(((Long) obj).longValue()) + "\"");
                    return;
                case 14:
                    this.generator.print(this.gson.toJson(obj));
                    return;
                case 15:
                    this.generator.print("\"");
                    this.generator.print(BaseEncoding.base64().encode(((ByteString) obj).toByteArray()));
                    this.generator.print("\"");
                    return;
                case 16:
                    if (fieldDescriptor.getEnumType().getFullName().equals("google.protobuf.NullValue")) {
                        if (z) {
                            this.generator.print("\"");
                        }
                        this.generator.print(StringUtil.NULL_STRING);
                        if (z) {
                            this.generator.print("\"");
                            return;
                        }
                        return;
                    }
                    if (!this.printingEnumsAsInts) {
                        Descriptors.EnumValueDescriptor enumValueDescriptor = (Descriptors.EnumValueDescriptor) obj;
                        if (enumValueDescriptor.getIndex() != -1) {
                            TextGenerator textGenerator3 = this.generator;
                            textGenerator3.print("\"" + enumValueDescriptor.getName() + "\"");
                            return;
                        }
                    }
                    this.generator.print(String.valueOf(((Descriptors.EnumValueDescriptor) obj).getNumber()));
                    return;
                case 17:
                case 18:
                    print((Message) obj);
                    return;
                default:
                    return;
            }
        }

        private void print(MessageOrBuilder messageOrBuilder, String str) throws IOException {
            boolean z;
            Map<Descriptors.FieldDescriptor, Object> map;
            TextGenerator textGenerator = this.generator;
            textGenerator.print(StringUtil.ARRAY_START + this.blankOrNewLine);
            this.generator.indent();
            if (str != null) {
                TextGenerator textGenerator2 = this.generator;
                textGenerator2.print("\"@type\":" + this.blankOrSpace + this.gson.toJson((Object) str));
                z = true;
            } else {
                z = false;
            }
            if (this.alwaysOutputDefaultValueFields || !this.includingDefaultValueFields.isEmpty()) {
                TreeMap treeMap = new TreeMap(messageOrBuilder.getAllFields());
                for (Descriptors.FieldDescriptor next : messageOrBuilder.getDescriptorForType().getFields()) {
                    if ((!next.isOptional() || ((next.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE || messageOrBuilder.hasField(next)) && (next.getContainingOneof() == null || messageOrBuilder.hasField(next)))) && !treeMap.containsKey(next)) {
                        if (this.alwaysOutputDefaultValueFields || this.includingDefaultValueFields.contains(next)) {
                            treeMap.put(next, messageOrBuilder.getField(next));
                        }
                    }
                }
                map = treeMap;
            } else {
                map = messageOrBuilder.getAllFields();
            }
            for (Map.Entry next2 : map.entrySet()) {
                if (z) {
                    TextGenerator textGenerator3 = this.generator;
                    textGenerator3.print("," + this.blankOrNewLine);
                } else {
                    z = true;
                }
                printField((Descriptors.FieldDescriptor) next2.getKey(), next2.getValue());
            }
            if (z) {
                this.generator.print(this.blankOrNewLine);
            }
            this.generator.outdent();
            this.generator.print("}");
        }
    }

    public interface TextGenerator {
        void indent();

        void outdent();

        void print(CharSequence charSequence) throws IOException;
    }

    public static class TypeRegistry {
        public final Map<String, Descriptors.Descriptor> types;

        public static class Builder {
            public final Set<String> files;
            public Map<String, Descriptors.Descriptor> types;

            public /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private void addFile(Descriptors.FileDescriptor fileDescriptor) {
                if (this.files.add(fileDescriptor.getFullName())) {
                    for (Descriptors.FileDescriptor addFile : fileDescriptor.getDependencies()) {
                        addFile(addFile);
                    }
                    for (Descriptors.Descriptor addMessage : fileDescriptor.getMessageTypes()) {
                        addMessage(addMessage);
                    }
                }
            }

            private void addMessage(Descriptors.Descriptor descriptor) {
                for (Descriptors.Descriptor addMessage : descriptor.getNestedTypes()) {
                    addMessage(addMessage);
                }
                if (this.types.containsKey(descriptor.getFullName())) {
                    Logger access$600 = JsonFormat.logger;
                    access$600.warning("Type " + descriptor.getFullName() + " is added multiple times.");
                    return;
                }
                this.types.put(descriptor.getFullName(), descriptor);
            }

            @CanIgnoreReturnValue
            public Builder add(Descriptors.Descriptor descriptor) {
                if (this.types != null) {
                    addFile(descriptor.getFile());
                    return this;
                }
                throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
            }

            public TypeRegistry build() {
                TypeRegistry typeRegistry = new TypeRegistry(this.types, (AnonymousClass1) null);
                this.types = null;
                return typeRegistry;
            }

            public Builder() {
                this.files = new HashSet();
                this.types = new HashMap();
            }

            @CanIgnoreReturnValue
            public Builder add(Iterable<Descriptors.Descriptor> iterable) {
                if (this.types != null) {
                    for (Descriptors.Descriptor file : iterable) {
                        addFile(file.getFile());
                    }
                    return this;
                }
                throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
            }
        }

        public static class EmptyTypeRegistryHolder {
            public static final TypeRegistry EMPTY = new TypeRegistry(Collections.emptyMap(), (AnonymousClass1) null);
        }

        public /* synthetic */ TypeRegistry(Map map, AnonymousClass1 r2) {
            this(map);
        }

        public static TypeRegistry getEmptyTypeRegistry() {
            return EmptyTypeRegistryHolder.EMPTY;
        }

        public static Builder newBuilder() {
            return new Builder((AnonymousClass1) null);
        }

        public Descriptors.Descriptor find(String str) {
            return this.types.get(str);
        }

        public Descriptors.Descriptor getDescriptorForTypeUrl(String str) throws InvalidProtocolBufferException {
            return find(JsonFormat.getTypeName(str));
        }

        public TypeRegistry(Map<String, Descriptors.Descriptor> map) {
            this.types = map;
        }
    }

    public static String getTypeName(String str) throws InvalidProtocolBufferException {
        String[] split = str.split("/");
        if (split.length != 1) {
            return split[split.length - 1];
        }
        throw new InvalidProtocolBufferException("Invalid type url found: " + str);
    }

    public static Parser parser() {
        return new Parser(com.google.protobuf.TypeRegistry.getEmptyTypeRegistry(), TypeRegistry.getEmptyTypeRegistry(), false, 100, (AnonymousClass1) null);
    }

    public static Printer printer() {
        return new Printer(com.google.protobuf.TypeRegistry.getEmptyTypeRegistry(), TypeRegistry.getEmptyTypeRegistry(), false, Collections.emptySet(), false, false, false, false, (AnonymousClass1) null);
    }

    public static String unsignedToString(int i2) {
        if (i2 >= 0) {
            return Integer.toString(i2);
        }
        return Long.toString(((long) i2) & 4294967295L);
    }

    public static String unsignedToString(long j) {
        if (j >= 0) {
            return Long.toString(j);
        }
        return BigInteger.valueOf(j & Long.MAX_VALUE).setBit(63).toString();
    }

    public static class ParserImpl {
        public static final double EPSILON = 1.0E-6d;
        public static final BigDecimal MAX_DOUBLE = new BigDecimal(String.valueOf(Double.MAX_VALUE)).multiply(MORE_THAN_ONE);
        public static final BigInteger MAX_UINT64 = new BigInteger("FFFFFFFFFFFFFFFF", 16);
        public static final BigDecimal MIN_DOUBLE = new BigDecimal(String.valueOf(-1.7976931348623157E308d)).multiply(MORE_THAN_ONE);
        public static final BigDecimal MORE_THAN_ONE = new BigDecimal(String.valueOf(1.000001d));
        public static final Map<String, WellKnownTypeParser> wellKnownTypeParsers = buildWellKnownTypeParsers();
        public int currentDepth;
        public final Map<Descriptors.Descriptor, Map<String, Descriptors.FieldDescriptor>> fieldNameMaps = new HashMap();
        public final boolean ignoringUnknownFields;
        public final JsonParser jsonParser;
        public final TypeRegistry oldRegistry;
        public final int recursionLimit;
        public final com.google.protobuf.TypeRegistry registry;

        public interface WellKnownTypeParser {
            void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException;
        }

        public ParserImpl(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, boolean z, int i2) {
            this.registry = typeRegistry;
            this.oldRegistry = typeRegistry2;
            this.ignoringUnknownFields = z;
            this.jsonParser = new JsonParser();
            this.recursionLimit = i2;
            this.currentDepth = 0;
        }

        public static Map<String, WellKnownTypeParser> buildWellKnownTypeParsers() {
            HashMap hashMap = new HashMap();
            hashMap.put(Any.getDescriptor().getFullName(), new WellKnownTypeParser() {
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeAny(jsonElement, builder);
                }
            });
            AnonymousClass2 r1 = new WellKnownTypeParser() {
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeWrapper(jsonElement, builder);
                }
            };
            hashMap.put(BoolValue.getDescriptor().getFullName(), r1);
            hashMap.put(Int32Value.getDescriptor().getFullName(), r1);
            hashMap.put(UInt32Value.getDescriptor().getFullName(), r1);
            hashMap.put(Int64Value.getDescriptor().getFullName(), r1);
            hashMap.put(UInt64Value.getDescriptor().getFullName(), r1);
            hashMap.put(StringValue.getDescriptor().getFullName(), r1);
            hashMap.put(BytesValue.getDescriptor().getFullName(), r1);
            hashMap.put(FloatValue.getDescriptor().getFullName(), r1);
            hashMap.put(DoubleValue.getDescriptor().getFullName(), r1);
            hashMap.put(Timestamp.getDescriptor().getFullName(), new WellKnownTypeParser() {
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeTimestamp(jsonElement, builder);
                }
            });
            hashMap.put(Duration.getDescriptor().getFullName(), new WellKnownTypeParser() {
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeDuration(jsonElement, builder);
                }
            });
            hashMap.put(FieldMask.getDescriptor().getFullName(), new WellKnownTypeParser() {
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeFieldMask(jsonElement, builder);
                }
            });
            hashMap.put(Struct.getDescriptor().getFullName(), new WellKnownTypeParser() {
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeStruct(jsonElement, builder);
                }
            });
            hashMap.put(ListValue.getDescriptor().getFullName(), new WellKnownTypeParser() {
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeListValue(jsonElement, builder);
                }
            });
            hashMap.put(Value.getDescriptor().getFullName(), new WellKnownTypeParser() {
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeValue(jsonElement, builder);
                }
            });
            return hashMap;
        }

        private Map<String, Descriptors.FieldDescriptor> getFieldNameMap(Descriptors.Descriptor descriptor) {
            if (this.fieldNameMaps.containsKey(descriptor)) {
                return this.fieldNameMaps.get(descriptor);
            }
            HashMap hashMap = new HashMap();
            for (Descriptors.FieldDescriptor next : descriptor.getFields()) {
                hashMap.put(next.getName(), next);
                hashMap.put(next.getJsonName(), next);
            }
            this.fieldNameMaps.put(descriptor, hashMap);
            return hashMap;
        }

        /* access modifiers changed from: private */
        public void mergeAny(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            Descriptors.Descriptor descriptorForType = builder.getDescriptorForType();
            Descriptors.FieldDescriptor findFieldByName = descriptorForType.findFieldByName("type_url");
            Descriptors.FieldDescriptor findFieldByName2 = descriptorForType.findFieldByName("value");
            if (findFieldByName == null || findFieldByName2 == null || findFieldByName.getType() != Descriptors.FieldDescriptor.Type.STRING || findFieldByName2.getType() != Descriptors.FieldDescriptor.Type.BYTES) {
                throw new InvalidProtocolBufferException("Invalid Any type.");
            } else if (jsonElement instanceof JsonObject) {
                JsonObject jsonObject = (JsonObject) jsonElement;
                if (!jsonObject.entrySet().isEmpty()) {
                    JsonElement jsonElement2 = jsonObject.get("@type");
                    if (jsonElement2 != null) {
                        String asString = jsonElement2.getAsString();
                        Descriptors.Descriptor descriptorForTypeUrl = this.registry.getDescriptorForTypeUrl(asString);
                        if (descriptorForTypeUrl == null && (descriptorForTypeUrl = this.oldRegistry.getDescriptorForTypeUrl(asString)) == null) {
                            throw new InvalidProtocolBufferException("Cannot resolve type: " + asString);
                        }
                        builder.setField(findFieldByName, asString);
                        DynamicMessage.Builder newBuilderForType = DynamicMessage.getDefaultInstance(descriptorForTypeUrl).newBuilderForType();
                        WellKnownTypeParser wellKnownTypeParser = wellKnownTypeParsers.get(descriptorForTypeUrl.getFullName());
                        if (wellKnownTypeParser != null) {
                            JsonElement jsonElement3 = jsonObject.get("value");
                            if (jsonElement3 != null) {
                                wellKnownTypeParser.merge(this, jsonElement3, newBuilderForType);
                            }
                        } else {
                            mergeMessage(jsonElement, newBuilderForType, true);
                        }
                        builder.setField(findFieldByName2, newBuilderForType.build().toByteString());
                        return;
                    }
                    throw new InvalidProtocolBufferException("Missing type url when parsing: " + jsonElement);
                }
            } else {
                throw new InvalidProtocolBufferException("Expect message object but got: " + jsonElement);
            }
        }

        /* access modifiers changed from: private */
        public void mergeDuration(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            try {
                builder.mergeFrom(Durations.parse(jsonElement.getAsString()).toByteString());
            } catch (ParseException unused) {
                throw new InvalidProtocolBufferException("Failed to parse duration: " + jsonElement);
            }
        }

        private void mergeField(Descriptors.FieldDescriptor fieldDescriptor, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            if (fieldDescriptor.isRepeated()) {
                if (builder.getRepeatedFieldCount(fieldDescriptor) > 0) {
                    throw new InvalidProtocolBufferException("Field " + fieldDescriptor.getFullName() + " has already been set.");
                }
            } else if (builder.hasField(fieldDescriptor)) {
                throw new InvalidProtocolBufferException("Field " + fieldDescriptor.getFullName() + " has already been set.");
            }
            if (fieldDescriptor.isRepeated() && (jsonElement instanceof JsonNull)) {
                return;
            }
            if (fieldDescriptor.isMapField()) {
                mergeMapField(fieldDescriptor, jsonElement, builder);
            } else if (fieldDescriptor.isRepeated()) {
                mergeRepeatedField(fieldDescriptor, jsonElement, builder);
            } else if (fieldDescriptor.getContainingOneof() != null) {
                mergeOneofField(fieldDescriptor, jsonElement, builder);
            } else {
                Object parseFieldValue = parseFieldValue(fieldDescriptor, jsonElement, builder);
                if (parseFieldValue != null) {
                    builder.setField(fieldDescriptor, parseFieldValue);
                }
            }
        }

        /* access modifiers changed from: private */
        public void mergeFieldMask(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            builder.mergeFrom(FieldMaskUtil.fromJsonString(jsonElement.getAsString()).toByteString());
        }

        /* access modifiers changed from: private */
        public void mergeListValue(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            Descriptors.FieldDescriptor findFieldByName = builder.getDescriptorForType().findFieldByName(SavedStateHandle.VALUES);
            if (findFieldByName != null) {
                mergeRepeatedField(findFieldByName, jsonElement, builder);
                return;
            }
            throw new InvalidProtocolBufferException("Invalid ListValue type.");
        }

        private void mergeMapField(Descriptors.FieldDescriptor fieldDescriptor, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            if (jsonElement instanceof JsonObject) {
                Descriptors.Descriptor messageType = fieldDescriptor.getMessageType();
                Descriptors.FieldDescriptor findFieldByName = messageType.findFieldByName("key");
                Descriptors.FieldDescriptor findFieldByName2 = messageType.findFieldByName("value");
                if (findFieldByName == null || findFieldByName2 == null) {
                    throw new InvalidProtocolBufferException("Invalid map field: " + fieldDescriptor.getFullName());
                }
                for (Map.Entry next : ((JsonObject) jsonElement).entrySet()) {
                    Message.Builder newBuilderForField = builder.newBuilderForField(fieldDescriptor);
                    Object parseFieldValue = parseFieldValue(findFieldByName, new JsonPrimitive((String) next.getKey()), newBuilderForField);
                    Object parseFieldValue2 = parseFieldValue(findFieldByName2, (JsonElement) next.getValue(), newBuilderForField);
                    if (parseFieldValue2 != null) {
                        newBuilderForField.setField(findFieldByName, parseFieldValue);
                        newBuilderForField.setField(findFieldByName2, parseFieldValue2);
                        builder.addRepeatedField(fieldDescriptor, newBuilderForField.build());
                    } else if (!this.ignoringUnknownFields || findFieldByName2.getType() != Descriptors.FieldDescriptor.Type.ENUM) {
                        throw new InvalidProtocolBufferException("Map value cannot be null.");
                    }
                }
                return;
            }
            throw new InvalidProtocolBufferException("Expect a map object but found: " + jsonElement);
        }

        private void mergeMessage(JsonElement jsonElement, Message.Builder builder, boolean z) throws InvalidProtocolBufferException {
            if (jsonElement instanceof JsonObject) {
                Map<String, Descriptors.FieldDescriptor> fieldNameMap = getFieldNameMap(builder.getDescriptorForType());
                for (Map.Entry next : ((JsonObject) jsonElement).entrySet()) {
                    if (!z || !((String) next.getKey()).equals("@type")) {
                        Descriptors.FieldDescriptor fieldDescriptor = fieldNameMap.get(next.getKey());
                        if (fieldDescriptor != null) {
                            mergeField(fieldDescriptor, (JsonElement) next.getValue(), builder);
                        } else if (!this.ignoringUnknownFields) {
                            throw new InvalidProtocolBufferException("Cannot find field: " + ((String) next.getKey()) + " in message " + builder.getDescriptorForType().getFullName());
                        }
                    }
                }
                return;
            }
            throw new InvalidProtocolBufferException("Expect message object but got: " + jsonElement);
        }

        private void mergeOneofField(Descriptors.FieldDescriptor fieldDescriptor, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            Object parseFieldValue = parseFieldValue(fieldDescriptor, jsonElement, builder);
            if (parseFieldValue != null) {
                if (builder.getOneofFieldDescriptor(fieldDescriptor.getContainingOneof()) == null) {
                    builder.setField(fieldDescriptor, parseFieldValue);
                    return;
                }
                throw new InvalidProtocolBufferException("Cannot set field " + fieldDescriptor.getFullName() + " because another field " + builder.getOneofFieldDescriptor(fieldDescriptor.getContainingOneof()).getFullName() + " belonging to the same oneof has already been set ");
            }
        }

        private void mergeRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            if (jsonElement instanceof JsonArray) {
                JsonArray jsonArray = (JsonArray) jsonElement;
                for (int i2 = 0; i2 < jsonArray.size(); i2++) {
                    Object parseFieldValue = parseFieldValue(fieldDescriptor, jsonArray.get(i2), builder);
                    if (parseFieldValue != null) {
                        builder.addRepeatedField(fieldDescriptor, parseFieldValue);
                    } else if (!this.ignoringUnknownFields || fieldDescriptor.getType() != Descriptors.FieldDescriptor.Type.ENUM) {
                        throw new InvalidProtocolBufferException("Repeated field elements cannot be null in field: " + fieldDescriptor.getFullName());
                    }
                }
                return;
            }
            throw new InvalidProtocolBufferException("Expect an array but found: " + jsonElement);
        }

        /* access modifiers changed from: private */
        public void mergeStruct(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            Descriptors.FieldDescriptor findFieldByName = builder.getDescriptorForType().findFieldByName(GetUserAttrInfoResult.KEY_DATA_FIELDS);
            if (findFieldByName != null) {
                mergeMapField(findFieldByName, jsonElement, builder);
                return;
            }
            throw new InvalidProtocolBufferException("Invalid Struct type.");
        }

        /* access modifiers changed from: private */
        public void mergeTimestamp(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            try {
                builder.mergeFrom(Timestamps.parse(jsonElement.getAsString()).toByteString());
            } catch (ParseException unused) {
                throw new InvalidProtocolBufferException("Failed to parse timestamp: " + jsonElement);
            }
        }

        /* access modifiers changed from: private */
        public void mergeValue(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            Descriptors.Descriptor descriptorForType = builder.getDescriptorForType();
            if (jsonElement instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
                if (jsonPrimitive.isBoolean()) {
                    builder.setField(descriptorForType.findFieldByName("bool_value"), Boolean.valueOf(jsonPrimitive.getAsBoolean()));
                } else if (jsonPrimitive.isNumber()) {
                    builder.setField(descriptorForType.findFieldByName("number_value"), Double.valueOf(jsonPrimitive.getAsDouble()));
                } else {
                    builder.setField(descriptorForType.findFieldByName("string_value"), jsonPrimitive.getAsString());
                }
            } else if (jsonElement instanceof JsonObject) {
                Descriptors.FieldDescriptor findFieldByName = descriptorForType.findFieldByName("struct_value");
                Message.Builder newBuilderForField = builder.newBuilderForField(findFieldByName);
                merge(jsonElement, newBuilderForField);
                builder.setField(findFieldByName, newBuilderForField.build());
            } else if (jsonElement instanceof JsonArray) {
                Descriptors.FieldDescriptor findFieldByName2 = descriptorForType.findFieldByName("list_value");
                Message.Builder newBuilderForField2 = builder.newBuilderForField(findFieldByName2);
                merge(jsonElement, newBuilderForField2);
                builder.setField(findFieldByName2, newBuilderForField2.build());
            } else if (jsonElement instanceof JsonNull) {
                builder.setField(descriptorForType.findFieldByName("null_value"), NullValue.NULL_VALUE.getValueDescriptor());
            } else {
                throw new IllegalStateException("Unexpected json data: " + jsonElement);
            }
        }

        /* access modifiers changed from: private */
        public void mergeWrapper(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            Descriptors.Descriptor descriptorForType = builder.getDescriptorForType();
            Descriptors.FieldDescriptor findFieldByName = descriptorForType.findFieldByName("value");
            if (findFieldByName != null) {
                builder.setField(findFieldByName, parseFieldValue(findFieldByName, jsonElement, builder));
                return;
            }
            throw new InvalidProtocolBufferException("Invalid wrapper type: " + descriptorForType.getFullName());
        }

        private boolean parseBool(JsonElement jsonElement) throws InvalidProtocolBufferException {
            if (jsonElement.getAsString().equals("true")) {
                return true;
            }
            if (jsonElement.getAsString().equals("false")) {
                return false;
            }
            throw new InvalidProtocolBufferException("Invalid bool value: " + jsonElement);
        }

        private ByteString parseBytes(JsonElement jsonElement) throws InvalidProtocolBufferException {
            try {
                return ByteString.copyFrom(BaseEncoding.base64().decode(jsonElement.getAsString()));
            } catch (IllegalArgumentException unused) {
                return ByteString.copyFrom(BaseEncoding.base64Url().decode(jsonElement.getAsString()));
            }
        }

        private double parseDouble(JsonElement jsonElement) throws InvalidProtocolBufferException {
            if (jsonElement.getAsString().equals("NaN")) {
                return Double.NaN;
            }
            if (jsonElement.getAsString().equals("Infinity")) {
                return Double.POSITIVE_INFINITY;
            }
            if (jsonElement.getAsString().equals("-Infinity")) {
                return Double.NEGATIVE_INFINITY;
            }
            try {
                BigDecimal bigDecimal = new BigDecimal(jsonElement.getAsString());
                if (bigDecimal.compareTo(MAX_DOUBLE) <= 0 && bigDecimal.compareTo(MIN_DOUBLE) >= 0) {
                    return bigDecimal.doubleValue();
                }
                throw new InvalidProtocolBufferException("Out of range double value: " + jsonElement);
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (Exception unused) {
                throw new InvalidProtocolBufferException("Not an double value: " + jsonElement);
            }
        }

        private Descriptors.EnumValueDescriptor parseEnum(Descriptors.EnumDescriptor enumDescriptor, JsonElement jsonElement) throws InvalidProtocolBufferException {
            Descriptors.EnumValueDescriptor enumValueDescriptor;
            String asString = jsonElement.getAsString();
            Descriptors.EnumValueDescriptor findValueByName = enumDescriptor.findValueByName(asString);
            if (findValueByName == null) {
                try {
                    int parseInt32 = parseInt32(jsonElement);
                    if (enumDescriptor.getFile().getSyntax() == Descriptors.FileDescriptor.Syntax.PROTO3) {
                        enumValueDescriptor = enumDescriptor.findValueByNumberCreatingIfUnknown(parseInt32);
                    } else {
                        enumValueDescriptor = enumDescriptor.findValueByNumber(parseInt32);
                    }
                    findValueByName = enumValueDescriptor;
                } catch (InvalidProtocolBufferException unused) {
                }
                if (findValueByName == null && !this.ignoringUnknownFields) {
                    throw new InvalidProtocolBufferException("Invalid enum value: " + asString + " for enum type: " + enumDescriptor.getFullName());
                }
            }
            return findValueByName;
        }

        private Object parseFieldValue(Descriptors.FieldDescriptor fieldDescriptor, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            if (jsonElement instanceof JsonNull) {
                if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE && fieldDescriptor.getMessageType().getFullName().equals(Value.getDescriptor().getFullName())) {
                    return builder.newBuilderForField(fieldDescriptor).mergeFrom(Value.newBuilder().setNullValueValue(0).build().toByteString()).build();
                } else if (fieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM || !fieldDescriptor.getEnumType().getFullName().equals(NullValue.getDescriptor().getFullName())) {
                    return null;
                } else {
                    return fieldDescriptor.getEnumType().findValueByNumber(0);
                }
            } else if (!(jsonElement instanceof JsonObject) || fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE || fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.GROUP) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[fieldDescriptor.getType().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        return Integer.valueOf(parseInt32(jsonElement));
                    case 4:
                    case 5:
                    case 6:
                        return Long.valueOf(parseInt64(jsonElement));
                    case 7:
                        return Boolean.valueOf(parseBool(jsonElement));
                    case 8:
                        return Float.valueOf(parseFloat(jsonElement));
                    case 9:
                        return Double.valueOf(parseDouble(jsonElement));
                    case 10:
                    case 11:
                        return Integer.valueOf(parseUint32(jsonElement));
                    case 12:
                    case 13:
                        return Long.valueOf(parseUint64(jsonElement));
                    case 14:
                        return parseString(jsonElement);
                    case 15:
                        return parseBytes(jsonElement);
                    case 16:
                        return parseEnum(fieldDescriptor.getEnumType(), jsonElement);
                    case 17:
                    case 18:
                        int i2 = this.currentDepth;
                        if (i2 < this.recursionLimit) {
                            this.currentDepth = i2 + 1;
                            Message.Builder newBuilderForField = builder.newBuilderForField(fieldDescriptor);
                            merge(jsonElement, newBuilderForField);
                            this.currentDepth--;
                            return newBuilderForField.build();
                        }
                        throw new InvalidProtocolBufferException("Hit recursion limit.");
                    default:
                        throw new InvalidProtocolBufferException("Invalid field type: " + fieldDescriptor.getType());
                }
            } else {
                throw new InvalidProtocolBufferException(String.format("Invalid value: %s for expected type: %s", new Object[]{jsonElement, fieldDescriptor.getType()}));
            }
        }

        private float parseFloat(JsonElement jsonElement) throws InvalidProtocolBufferException {
            if (jsonElement.getAsString().equals("NaN")) {
                return Float.NaN;
            }
            if (jsonElement.getAsString().equals("Infinity")) {
                return Float.POSITIVE_INFINITY;
            }
            if (jsonElement.getAsString().equals("-Infinity")) {
                return Float.NEGATIVE_INFINITY;
            }
            try {
                double parseDouble = Double.parseDouble(jsonElement.getAsString());
                if (parseDouble <= 3.402826869208755E38d && parseDouble >= -3.402826869208755E38d) {
                    return (float) parseDouble;
                }
                throw new InvalidProtocolBufferException("Out of range float value: " + jsonElement);
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (Exception unused) {
                throw new InvalidProtocolBufferException("Not a float value: " + jsonElement);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
            return new java.math.BigDecimal(r4.getAsString()).intValueExact();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
            throw new com.google.protobuf.InvalidProtocolBufferException("Not an int32 value: " + r4);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0009 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int parseInt32(com.google.gson.JsonElement r4) throws com.google.protobuf.InvalidProtocolBufferException {
            /*
                r3 = this;
                java.lang.String r0 = r4.getAsString()     // Catch:{ Exception -> 0x0009 }
                int r4 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0009 }
                return r4
            L_0x0009:
                java.math.BigDecimal r0 = new java.math.BigDecimal     // Catch:{ Exception -> 0x0017 }
                java.lang.String r1 = r4.getAsString()     // Catch:{ Exception -> 0x0017 }
                r0.<init>(r1)     // Catch:{ Exception -> 0x0017 }
                int r4 = r0.intValueExact()     // Catch:{ Exception -> 0x0017 }
                return r4
            L_0x0017:
                com.google.protobuf.InvalidProtocolBufferException r0 = new com.google.protobuf.InvalidProtocolBufferException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Not an int32 value: "
                r1.append(r2)
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                r0.<init>((java.lang.String) r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.util.JsonFormat.ParserImpl.parseInt32(com.google.gson.JsonElement):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
            return new java.math.BigDecimal(r4.getAsString()).longValueExact();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
            throw new com.google.protobuf.InvalidProtocolBufferException("Not an int64 value: " + r4);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0009 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private long parseInt64(com.google.gson.JsonElement r4) throws com.google.protobuf.InvalidProtocolBufferException {
            /*
                r3 = this;
                java.lang.String r0 = r4.getAsString()     // Catch:{ Exception -> 0x0009 }
                long r0 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x0009 }
                return r0
            L_0x0009:
                java.math.BigDecimal r0 = new java.math.BigDecimal     // Catch:{ Exception -> 0x0017 }
                java.lang.String r1 = r4.getAsString()     // Catch:{ Exception -> 0x0017 }
                r0.<init>(r1)     // Catch:{ Exception -> 0x0017 }
                long r0 = r0.longValueExact()     // Catch:{ Exception -> 0x0017 }
                return r0
            L_0x0017:
                com.google.protobuf.InvalidProtocolBufferException r0 = new com.google.protobuf.InvalidProtocolBufferException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Not an int64 value: "
                r1.append(r2)
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                r0.<init>((java.lang.String) r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.util.JsonFormat.ParserImpl.parseInt64(com.google.gson.JsonElement):long");
        }

        private String parseString(JsonElement jsonElement) {
            return jsonElement.getAsString();
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0030 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int parseUint32(com.google.gson.JsonElement r7) throws com.google.protobuf.InvalidProtocolBufferException {
            /*
                r6 = this;
                java.lang.String r0 = "Out of range uint32 value: "
                java.lang.String r1 = r7.getAsString()     // Catch:{ InvalidProtocolBufferException -> 0x0085, Exception -> 0x0030 }
                long r1 = java.lang.Long.parseLong(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0085, Exception -> 0x0030 }
                r3 = 0
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 < 0) goto L_0x001b
                r3 = 4294967295(0xffffffff, double:2.1219957905E-314)
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 > 0) goto L_0x001b
                int r7 = (int) r1     // Catch:{ InvalidProtocolBufferException -> 0x0085, Exception -> 0x0030 }
                return r7
            L_0x001b:
                com.google.protobuf.InvalidProtocolBufferException r1 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ InvalidProtocolBufferException -> 0x0085, Exception -> 0x0030 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0085, Exception -> 0x0030 }
                r2.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0085, Exception -> 0x0030 }
                r2.append(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0085, Exception -> 0x0030 }
                r2.append(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0085, Exception -> 0x0030 }
                java.lang.String r2 = r2.toString()     // Catch:{ InvalidProtocolBufferException -> 0x0085, Exception -> 0x0030 }
                r1.<init>((java.lang.String) r2)     // Catch:{ InvalidProtocolBufferException -> 0x0085, Exception -> 0x0030 }
                throw r1     // Catch:{ InvalidProtocolBufferException -> 0x0085, Exception -> 0x0030 }
            L_0x0030:
                java.math.BigDecimal r1 = new java.math.BigDecimal     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                java.lang.String r2 = r7.getAsString()     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                r1.<init>(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                java.math.BigInteger r1 = r1.toBigIntegerExact()     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                int r2 = r1.signum()     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                if (r2 < 0) goto L_0x0057
                java.math.BigInteger r2 = new java.math.BigInteger     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                java.lang.String r3 = "FFFFFFFF"
                r4 = 16
                r2.<init>(r3, r4)     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                int r2 = r1.compareTo(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                if (r2 > 0) goto L_0x0057
                int r7 = r1.intValue()     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                return r7
            L_0x0057:
                com.google.protobuf.InvalidProtocolBufferException r1 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                r2.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                r2.append(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                r2.append(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                java.lang.String r0 = r2.toString()     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                r1.<init>((java.lang.String) r0)     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
                throw r1     // Catch:{ InvalidProtocolBufferException -> 0x0083, Exception -> 0x006c }
            L_0x006c:
                com.google.protobuf.InvalidProtocolBufferException r0 = new com.google.protobuf.InvalidProtocolBufferException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Not an uint32 value: "
                r1.append(r2)
                r1.append(r7)
                java.lang.String r7 = r1.toString()
                r0.<init>((java.lang.String) r7)
                throw r0
            L_0x0083:
                r7 = move-exception
                throw r7
            L_0x0085:
                r7 = move-exception
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.util.JsonFormat.ParserImpl.parseUint32(com.google.gson.JsonElement):int");
        }

        private long parseUint64(JsonElement jsonElement) throws InvalidProtocolBufferException {
            try {
                BigInteger bigIntegerExact = new BigDecimal(jsonElement.getAsString()).toBigIntegerExact();
                if (bigIntegerExact.compareTo(BigInteger.ZERO) >= 0 && bigIntegerExact.compareTo(MAX_UINT64) <= 0) {
                    return bigIntegerExact.longValue();
                }
                throw new InvalidProtocolBufferException("Out of range uint64 value: " + jsonElement);
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (Exception unused) {
                throw new InvalidProtocolBufferException("Not an uint64 value: " + jsonElement);
            }
        }

        public void merge(Reader reader, Message.Builder builder) throws IOException {
            try {
                JsonReader jsonReader = new JsonReader(reader);
                jsonReader.setLenient(false);
                merge(this.jsonParser.parse(jsonReader), builder);
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (JsonIOException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw new InvalidProtocolBufferException(e2.getMessage());
            } catch (Exception e3) {
                throw new InvalidProtocolBufferException(e3.getMessage());
            }
        }

        public void merge(String str, Message.Builder builder) throws InvalidProtocolBufferException {
            try {
                JsonReader jsonReader = new JsonReader(new StringReader(str));
                jsonReader.setLenient(false);
                merge(this.jsonParser.parse(jsonReader), builder);
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (Exception e2) {
                throw new InvalidProtocolBufferException(e2.getMessage());
            }
        }

        private void merge(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            WellKnownTypeParser wellKnownTypeParser = wellKnownTypeParsers.get(builder.getDescriptorForType().getFullName());
            if (wellKnownTypeParser != null) {
                wellKnownTypeParser.merge(this, jsonElement, builder);
            } else {
                mergeMessage(jsonElement, builder, false);
            }
        }
    }
}
