package com.baidu.android.imsdk.upload.action.pb;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class IMPushPb {

    public static final class Ack extends GeneratedMessageLite implements AckOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 5;
        public static final int EXT_FIELD_NUMBER = 4;
        public static final Parser<Ack> PARSER = new AbstractParser<Ack>() {
            public Ack parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Ack(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TIMESTAMP_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 2;
        public static final Ack defaultInstance;
        public static final long serialVersionUID = 0;
        public long aliasId;
        public int bitField0;
        public Object ext;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public long timestamp;
        public Object type;
        public Object value;

        public static final class Builder extends GeneratedMessageLite.Builder<Ack, Builder> implements AckOrBuilder {
            public long aliasId;
            public int bitField0;
            public Object ext = "";
            public long timestamp;
            public Object type = "";
            public Object value = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAliasId() {
                this.bitField0 &= -17;
                this.aliasId = 0;
                return this;
            }

            public Builder clearExt() {
                this.bitField0 &= -9;
                this.ext = Ack.getDefaultInstance().getExt();
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0 &= -5;
                this.timestamp = 0;
                return this;
            }

            public Builder clearType() {
                this.bitField0 &= -2;
                this.type = Ack.getDefaultInstance().getType();
                return this;
            }

            public Builder clearValue() {
                this.bitField0 &= -3;
                this.value = Ack.getDefaultInstance().getValue();
                return this;
            }

            public long getAliasId() {
                return this.aliasId;
            }

            public String getExt() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ext = stringUtf8;
                return stringUtf8;
            }

            public ByteString getExtBytes() {
                Object obj = this.ext;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext = copyFromUtf8;
                return copyFromUtf8;
            }

            public long getTimestamp() {
                return this.timestamp;
            }

            public String getType() {
                Object obj = this.type;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.type = stringUtf8;
                return stringUtf8;
            }

            public ByteString getTypeBytes() {
                Object obj = this.type;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getValue() {
                Object obj = this.value;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.value = stringUtf8;
                return stringUtf8;
            }

            public ByteString getValueBytes() {
                Object obj = this.value;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.value = copyFromUtf8;
                return copyFromUtf8;
            }

            public boolean hasAliasId() {
                return (this.bitField0 & 16) == 16;
            }

            public boolean hasExt() {
                return (this.bitField0 & 8) == 8;
            }

            public boolean hasTimestamp() {
                return (this.bitField0 & 4) == 4;
            }

            public boolean hasType() {
                return (this.bitField0 & 1) == 1;
            }

            public boolean hasValue() {
                return (this.bitField0 & 2) == 2;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setAliasId(long j) {
                this.bitField0 |= 16;
                this.aliasId = j;
                return this;
            }

            public Builder setExt(String str) {
                if (str != null) {
                    this.bitField0 |= 8;
                    this.ext = str;
                    return this;
                }
                throw null;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 8;
                    this.ext = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setTimestamp(long j) {
                this.bitField0 |= 4;
                this.timestamp = j;
                return this;
            }

            public Builder setType(String str) {
                if (str != null) {
                    this.bitField0 |= 1;
                    this.type = str;
                    return this;
                }
                throw null;
            }

            public Builder setTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 1;
                    this.type = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setValue(String str) {
                if (str != null) {
                    this.bitField0 |= 2;
                    this.value = str;
                    return this;
                }
                throw null;
            }

            public Builder setValueBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 2;
                    this.value = byteString;
                    return this;
                }
                throw null;
            }

            public Ack build() {
                Ack buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Ack buildPartial() {
                Ack ack = new Ack((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                Object unused = ack.type = this.type;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Object unused2 = ack.value = this.value;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                long unused3 = ack.timestamp = this.timestamp;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                Object unused4 = ack.ext = this.ext;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                long unused5 = ack.aliasId = this.aliasId;
                int unused6 = ack.bitField0 = i3;
                return ack;
            }

            public Builder clear() {
                super.clear();
                this.type = "";
                int i2 = this.bitField0 & -2;
                this.bitField0 = i2;
                this.value = "";
                int i3 = i2 & -3;
                this.bitField0 = i3;
                this.timestamp = 0;
                int i4 = i3 & -5;
                this.bitField0 = i4;
                this.ext = "";
                int i5 = i4 & -9;
                this.bitField0 = i5;
                this.aliasId = 0;
                this.bitField0 = i5 & -17;
                return this;
            }

            public Ack getDefaultInstanceForType() {
                return Ack.getDefaultInstance();
            }

            public Builder mergeFrom(Ack ack) {
                if (ack == Ack.getDefaultInstance()) {
                    return this;
                }
                if (ack.hasType()) {
                    this.bitField0 |= 1;
                    this.type = ack.type;
                }
                if (ack.hasValue()) {
                    this.bitField0 |= 2;
                    this.value = ack.value;
                }
                if (ack.hasTimestamp()) {
                    setTimestamp(ack.getTimestamp());
                }
                if (ack.hasExt()) {
                    this.bitField0 |= 8;
                    this.ext = ack.ext;
                }
                if (ack.hasAliasId()) {
                    setAliasId(ack.getAliasId());
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Ack ack;
                Ack ack2 = null;
                try {
                    Ack parsePartialFrom = Ack.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    ack = (Ack) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    ack2 = ack;
                }
                if (ack2 != null) {
                    mergeFrom(ack2);
                }
                throw th;
            }
        }

        static {
            Ack ack = new Ack(true);
            defaultInstance = ack;
            ack.initFields();
        }

        public static Ack getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.type = "";
            this.value = "";
            this.timestamp = 0;
            this.ext = "";
            this.aliasId = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Ack parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Ack parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public long getAliasId() {
            return this.aliasId;
        }

        public String getExt() {
            Object obj = this.ext;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getExtBytes() {
            Object obj = this.ext;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ext = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<Ack> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeBytesSize(1, getTypeBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                i3 += CodedOutputStream.computeBytesSize(2, getValueBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                i3 += CodedOutputStream.computeInt64Size(3, this.timestamp);
            }
            if ((this.bitField0 & 8) == 8) {
                i3 += CodedOutputStream.computeBytesSize(4, getExtBytes());
            }
            if ((this.bitField0 & 16) == 16) {
                i3 += CodedOutputStream.computeInt64Size(5, this.aliasId);
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public String getType() {
            Object obj = this.type;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.type = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getTypeBytes() {
            Object obj = this.type;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.type = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getValue() {
            Object obj = this.value;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.value = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getValueBytes() {
            Object obj = this.value;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.value = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasAliasId() {
            return (this.bitField0 & 16) == 16;
        }

        public boolean hasExt() {
            return (this.bitField0 & 8) == 8;
        }

        public boolean hasTimestamp() {
            return (this.bitField0 & 4) == 4;
        }

        public boolean hasType() {
            return (this.bitField0 & 1) == 1;
        }

        public boolean hasValue() {
            return (this.bitField0 & 2) == 2;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getTypeBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getValueBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeInt64(3, this.timestamp);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeBytes(4, getExtBytes());
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeInt64(5, this.aliasId);
            }
        }

        public static Builder newBuilder(Ack ack) {
            return newBuilder().mergeFrom(ack);
        }

        public static Ack parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Ack parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Ack getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Ack(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Ack parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Ack parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Ack parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public Ack(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Ack parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Ack parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Ack parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Ack(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.bitField0 |= 1;
                            this.type = codedInputStream.readBytes();
                        } else if (readTag == 18) {
                            this.bitField0 |= 2;
                            this.value = codedInputStream.readBytes();
                        } else if (readTag == 24) {
                            this.bitField0 |= 4;
                            this.timestamp = codedInputStream.readInt64();
                        } else if (readTag == 34) {
                            this.bitField0 |= 8;
                            this.ext = codedInputStream.readBytes();
                        } else if (readTag == 40) {
                            this.bitField0 |= 16;
                            this.aliasId = codedInputStream.readInt64();
                        } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    makeExtensionsImmutable();
                    throw th2;
                }
            }
            makeExtensionsImmutable();
        }
    }

    public interface AckOrBuilder extends MessageLiteOrBuilder {
        long getAliasId();

        String getExt();

        ByteString getExtBytes();

        long getTimestamp();

        String getType();

        ByteString getTypeBytes();

        String getValue();

        ByteString getValueBytes();

        boolean hasAliasId();

        boolean hasExt();

        boolean hasTimestamp();

        boolean hasType();

        boolean hasValue();
    }

    public static final class Action extends GeneratedMessageLite implements ActionOrBuilder {
        public static final int ACK_FIELD_NUMBER = 7;
        public static final int ACTION_TYPE_FIELD_NUMBER = 1;
        public static final int CONNECTION_FIELD_NUMBER = 5;
        public static final int CRASH_FIELD_NUMBER = 3;
        public static final int DB_FIELD_NUMBER = 4;
        public static final int MSG_FIELD_NUMBER = 8;
        public static final Parser<Action> PARSER = new AbstractParser<Action>() {
            public Action parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Action(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int REQUEST_FIELD_NUMBER = 6;
        public static final int UI_FIELD_NUMBER = 2;
        public static final Action defaultInstance;
        public static final long serialVersionUID = 0;
        public Ack ack;
        public ActionType actionType;
        public int bitField0;
        public Connection connection;
        public Crash crash;
        public Db db;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Msg msg;
        public Request request;
        public Ui ui;

        public static final class Builder extends GeneratedMessageLite.Builder<Action, Builder> implements ActionOrBuilder {
            public Ack ack = Ack.getDefaultInstance();
            public ActionType actionType = ActionType.UI;
            public int bitField0;
            public Connection connection = Connection.getDefaultInstance();
            public Crash crash = Crash.getDefaultInstance();
            public Db db = Db.getDefaultInstance();
            public Msg msg = Msg.getDefaultInstance();
            public Request request = Request.getDefaultInstance();
            public Ui ui = Ui.getDefaultInstance();

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAck() {
                this.ack = Ack.getDefaultInstance();
                this.bitField0 &= -65;
                return this;
            }

            public Builder clearActionType() {
                this.bitField0 &= -2;
                this.actionType = ActionType.UI;
                return this;
            }

            public Builder clearConnection() {
                this.connection = Connection.getDefaultInstance();
                this.bitField0 &= -17;
                return this;
            }

            public Builder clearCrash() {
                this.crash = Crash.getDefaultInstance();
                this.bitField0 &= -5;
                return this;
            }

            public Builder clearDb() {
                this.db = Db.getDefaultInstance();
                this.bitField0 &= -9;
                return this;
            }

            public Builder clearMsg() {
                this.msg = Msg.getDefaultInstance();
                this.bitField0 &= -129;
                return this;
            }

            public Builder clearRequest() {
                this.request = Request.getDefaultInstance();
                this.bitField0 &= -33;
                return this;
            }

            public Builder clearUi() {
                this.ui = Ui.getDefaultInstance();
                this.bitField0 &= -3;
                return this;
            }

            public Ack getAck() {
                return this.ack;
            }

            public ActionType getActionType() {
                return this.actionType;
            }

            public Connection getConnection() {
                return this.connection;
            }

            public Crash getCrash() {
                return this.crash;
            }

            public Db getDb() {
                return this.db;
            }

            public Msg getMsg() {
                return this.msg;
            }

            public Request getRequest() {
                return this.request;
            }

            public Ui getUi() {
                return this.ui;
            }

            public boolean hasAck() {
                return (this.bitField0 & 64) == 64;
            }

            public boolean hasActionType() {
                return (this.bitField0 & 1) == 1;
            }

            public boolean hasConnection() {
                return (this.bitField0 & 16) == 16;
            }

            public boolean hasCrash() {
                return (this.bitField0 & 4) == 4;
            }

            public boolean hasDb() {
                return (this.bitField0 & 8) == 8;
            }

            public boolean hasMsg() {
                return (this.bitField0 & 128) == 128;
            }

            public boolean hasRequest() {
                return (this.bitField0 & 32) == 32;
            }

            public boolean hasUi() {
                return (this.bitField0 & 2) == 2;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeAck(Ack ack2) {
                if ((this.bitField0 & 64) != 64 || this.ack == Ack.getDefaultInstance()) {
                    this.ack = ack2;
                } else {
                    this.ack = Ack.newBuilder(this.ack).mergeFrom(ack2).buildPartial();
                }
                this.bitField0 |= 64;
                return this;
            }

            public Builder mergeConnection(Connection connection2) {
                if ((this.bitField0 & 16) != 16 || this.connection == Connection.getDefaultInstance()) {
                    this.connection = connection2;
                } else {
                    this.connection = Connection.newBuilder(this.connection).mergeFrom(connection2).buildPartial();
                }
                this.bitField0 |= 16;
                return this;
            }

            public Builder mergeCrash(Crash crash2) {
                if ((this.bitField0 & 4) != 4 || this.crash == Crash.getDefaultInstance()) {
                    this.crash = crash2;
                } else {
                    this.crash = Crash.newBuilder(this.crash).mergeFrom(crash2).buildPartial();
                }
                this.bitField0 |= 4;
                return this;
            }

            public Builder mergeDb(Db db2) {
                if ((this.bitField0 & 8) != 8 || this.db == Db.getDefaultInstance()) {
                    this.db = db2;
                } else {
                    this.db = Db.newBuilder(this.db).mergeFrom(db2).buildPartial();
                }
                this.bitField0 |= 8;
                return this;
            }

            public Builder mergeMsg(Msg msg2) {
                if ((this.bitField0 & 128) != 128 || this.msg == Msg.getDefaultInstance()) {
                    this.msg = msg2;
                } else {
                    this.msg = Msg.newBuilder(this.msg).mergeFrom(msg2).buildPartial();
                }
                this.bitField0 |= 128;
                return this;
            }

            public Builder mergeRequest(Request request2) {
                if ((this.bitField0 & 32) != 32 || this.request == Request.getDefaultInstance()) {
                    this.request = request2;
                } else {
                    this.request = Request.newBuilder(this.request).mergeFrom(request2).buildPartial();
                }
                this.bitField0 |= 32;
                return this;
            }

            public Builder mergeUi(Ui ui2) {
                if ((this.bitField0 & 2) != 2 || this.ui == Ui.getDefaultInstance()) {
                    this.ui = ui2;
                } else {
                    this.ui = Ui.newBuilder(this.ui).mergeFrom(ui2).buildPartial();
                }
                this.bitField0 |= 2;
                return this;
            }

            public Builder setAck(Ack ack2) {
                if (ack2 != null) {
                    this.ack = ack2;
                    this.bitField0 |= 64;
                    return this;
                }
                throw null;
            }

            public Builder setActionType(ActionType actionType2) {
                if (actionType2 != null) {
                    this.bitField0 |= 1;
                    this.actionType = actionType2;
                    return this;
                }
                throw null;
            }

            public Builder setConnection(Connection connection2) {
                if (connection2 != null) {
                    this.connection = connection2;
                    this.bitField0 |= 16;
                    return this;
                }
                throw null;
            }

            public Builder setCrash(Crash crash2) {
                if (crash2 != null) {
                    this.crash = crash2;
                    this.bitField0 |= 4;
                    return this;
                }
                throw null;
            }

            public Builder setDb(Db db2) {
                if (db2 != null) {
                    this.db = db2;
                    this.bitField0 |= 8;
                    return this;
                }
                throw null;
            }

            public Builder setMsg(Msg msg2) {
                if (msg2 != null) {
                    this.msg = msg2;
                    this.bitField0 |= 128;
                    return this;
                }
                throw null;
            }

            public Builder setRequest(Request request2) {
                if (request2 != null) {
                    this.request = request2;
                    this.bitField0 |= 32;
                    return this;
                }
                throw null;
            }

            public Builder setUi(Ui ui2) {
                if (ui2 != null) {
                    this.ui = ui2;
                    this.bitField0 |= 2;
                    return this;
                }
                throw null;
            }

            public Action build() {
                Action buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Action buildPartial() {
                Action action = new Action((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                ActionType unused = action.actionType = this.actionType;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Ui unused2 = action.ui = this.ui;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                Crash unused3 = action.crash = this.crash;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                Db unused4 = action.db = this.db;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                Connection unused5 = action.connection = this.connection;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                Request unused6 = action.request = this.request;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                Ack unused7 = action.ack = this.ack;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                Msg unused8 = action.msg = this.msg;
                int unused9 = action.bitField0 = i3;
                return action;
            }

            public Builder clear() {
                super.clear();
                this.actionType = ActionType.UI;
                this.bitField0 &= -2;
                this.ui = Ui.getDefaultInstance();
                this.bitField0 &= -3;
                this.crash = Crash.getDefaultInstance();
                this.bitField0 &= -5;
                this.db = Db.getDefaultInstance();
                this.bitField0 &= -9;
                this.connection = Connection.getDefaultInstance();
                this.bitField0 &= -17;
                this.request = Request.getDefaultInstance();
                this.bitField0 &= -33;
                this.ack = Ack.getDefaultInstance();
                this.bitField0 &= -65;
                this.msg = Msg.getDefaultInstance();
                this.bitField0 &= -129;
                return this;
            }

            public Action getDefaultInstanceForType() {
                return Action.getDefaultInstance();
            }

            public Builder mergeFrom(Action action) {
                if (action == Action.getDefaultInstance()) {
                    return this;
                }
                if (action.hasActionType()) {
                    setActionType(action.getActionType());
                }
                if (action.hasUi()) {
                    mergeUi(action.getUi());
                }
                if (action.hasCrash()) {
                    mergeCrash(action.getCrash());
                }
                if (action.hasDb()) {
                    mergeDb(action.getDb());
                }
                if (action.hasConnection()) {
                    mergeConnection(action.getConnection());
                }
                if (action.hasRequest()) {
                    mergeRequest(action.getRequest());
                }
                if (action.hasAck()) {
                    mergeAck(action.getAck());
                }
                if (action.hasMsg()) {
                    mergeMsg(action.getMsg());
                }
                return this;
            }

            public Builder setAck(Ack.Builder builder) {
                this.ack = builder.build();
                this.bitField0 |= 64;
                return this;
            }

            public Builder setConnection(Connection.Builder builder) {
                this.connection = builder.build();
                this.bitField0 |= 16;
                return this;
            }

            public Builder setCrash(Crash.Builder builder) {
                this.crash = builder.build();
                this.bitField0 |= 4;
                return this;
            }

            public Builder setDb(Db.Builder builder) {
                this.db = builder.build();
                this.bitField0 |= 8;
                return this;
            }

            public Builder setMsg(Msg.Builder builder) {
                this.msg = builder.build();
                this.bitField0 |= 128;
                return this;
            }

            public Builder setRequest(Request.Builder builder) {
                this.request = builder.build();
                this.bitField0 |= 32;
                return this;
            }

            public Builder setUi(Ui.Builder builder) {
                this.ui = builder.build();
                this.bitField0 |= 2;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Action action;
                Action action2 = null;
                try {
                    Action parsePartialFrom = Action.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    action = (Action) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    action2 = action;
                }
                if (action2 != null) {
                    mergeFrom(action2);
                }
                throw th;
            }
        }

        static {
            Action action = new Action(true);
            defaultInstance = action;
            action.initFields();
        }

        public static Action getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.actionType = ActionType.UI;
            this.ui = Ui.getDefaultInstance();
            this.crash = Crash.getDefaultInstance();
            this.db = Db.getDefaultInstance();
            this.connection = Connection.getDefaultInstance();
            this.request = Request.getDefaultInstance();
            this.ack = Ack.getDefaultInstance();
            this.msg = Msg.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Action parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Action parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public Ack getAck() {
            return this.ack;
        }

        public ActionType getActionType() {
            return this.actionType;
        }

        public Connection getConnection() {
            return this.connection;
        }

        public Crash getCrash() {
            return this.crash;
        }

        public Db getDb() {
            return this.db;
        }

        public Msg getMsg() {
            return this.msg;
        }

        public Parser<Action> getParserForType() {
            return PARSER;
        }

        public Request getRequest() {
            return this.request;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeEnumSize(1, this.actionType.getNumber());
            }
            if ((this.bitField0 & 2) == 2) {
                i3 += CodedOutputStream.computeMessageSize(2, this.ui);
            }
            if ((this.bitField0 & 4) == 4) {
                i3 += CodedOutputStream.computeMessageSize(3, this.crash);
            }
            if ((this.bitField0 & 8) == 8) {
                i3 += CodedOutputStream.computeMessageSize(4, this.db);
            }
            if ((this.bitField0 & 16) == 16) {
                i3 += CodedOutputStream.computeMessageSize(5, this.connection);
            }
            if ((this.bitField0 & 32) == 32) {
                i3 += CodedOutputStream.computeMessageSize(6, this.request);
            }
            if ((this.bitField0 & 64) == 64) {
                i3 += CodedOutputStream.computeMessageSize(7, this.ack);
            }
            if ((this.bitField0 & 128) == 128) {
                i3 += CodedOutputStream.computeMessageSize(8, this.msg);
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public Ui getUi() {
            return this.ui;
        }

        public boolean hasAck() {
            return (this.bitField0 & 64) == 64;
        }

        public boolean hasActionType() {
            return (this.bitField0 & 1) == 1;
        }

        public boolean hasConnection() {
            return (this.bitField0 & 16) == 16;
        }

        public boolean hasCrash() {
            return (this.bitField0 & 4) == 4;
        }

        public boolean hasDb() {
            return (this.bitField0 & 8) == 8;
        }

        public boolean hasMsg() {
            return (this.bitField0 & 128) == 128;
        }

        public boolean hasRequest() {
            return (this.bitField0 & 32) == 32;
        }

        public boolean hasUi() {
            return (this.bitField0 & 2) == 2;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeEnum(1, this.actionType.getNumber());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeMessage(2, this.ui);
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeMessage(3, this.crash);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeMessage(4, this.db);
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeMessage(5, this.connection);
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeMessage(6, this.request);
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeMessage(7, this.ack);
            }
            if ((this.bitField0 & 128) == 128) {
                codedOutputStream.writeMessage(8, this.msg);
            }
        }

        public static Builder newBuilder(Action action) {
            return newBuilder().mergeFrom(action);
        }

        public static Action parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Action parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Action getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Action(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Action parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Action parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Action parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public Action(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Action parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Action parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Action parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.baidu.android.imsdk.upload.action.pb.IMPushPb$Ui$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.baidu.android.imsdk.upload.action.pb.IMPushPb$Crash$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: com.baidu.android.imsdk.upload.action.pb.IMPushPb$Db$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: com.baidu.android.imsdk.upload.action.pb.IMPushPb$Connection$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: com.baidu.android.imsdk.upload.action.pb.IMPushPb$Request$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: com.baidu.android.imsdk.upload.action.pb.IMPushPb$Ack$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: com.baidu.android.imsdk.upload.action.pb.IMPushPb$Msg$Builder} */
        /* JADX WARNING: type inference failed for: r5v0 */
        /* JADX WARNING: type inference failed for: r5v15 */
        /* JADX WARNING: type inference failed for: r5v16 */
        /* JADX WARNING: type inference failed for: r5v17 */
        /* JADX WARNING: type inference failed for: r5v18 */
        /* JADX WARNING: type inference failed for: r5v19 */
        /* JADX WARNING: type inference failed for: r5v20 */
        /* JADX WARNING: type inference failed for: r5v21 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Action(com.google.protobuf.CodedInputStream r7, com.google.protobuf.ExtensionRegistryLite r8) throws com.google.protobuf.InvalidProtocolBufferException {
            /*
                r6 = this;
                r6.<init>()
                r0 = -1
                r6.memoizedIsInitialized = r0
                r6.memoizedSerializedSize = r0
                r6.initFields()
                r0 = 0
            L_0x000c:
                if (r0 != 0) goto L_0x0189
                int r1 = r7.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r2 = 1
                if (r1 == 0) goto L_0x016b
                r3 = 8
                if (r1 == r3) goto L_0x0158
                r4 = 18
                r5 = 0
                if (r1 == r4) goto L_0x0130
                r4 = 26
                if (r1 == r4) goto L_0x0108
                r4 = 34
                if (r1 == r4) goto L_0x00e1
                r3 = 42
                if (r1 == r3) goto L_0x00b8
                r3 = 50
                if (r1 == r3) goto L_0x008f
                r3 = 58
                if (r1 == r3) goto L_0x0066
                r3 = 66
                if (r1 == r3) goto L_0x003e
                boolean r1 = r6.parseUnknownField(r7, r8, r1)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                if (r1 != 0) goto L_0x000c
                goto L_0x016b
            L_0x003e:
                int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r2 = 128(0x80, float:1.794E-43)
                r1 = r1 & r2
                if (r1 != r2) goto L_0x004b
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Msg r1 = r6.msg     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Msg$Builder r5 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
            L_0x004b:
                com.google.protobuf.Parser<com.baidu.android.imsdk.upload.action.pb.IMPushPb$Msg> r1 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.Msg.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.google.protobuf.MessageLite r1 = r7.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r8)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Msg r1 = (com.baidu.android.imsdk.upload.action.pb.IMPushPb.Msg) r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r6.msg = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                if (r5 == 0) goto L_0x0060
                r5.mergeFrom((com.baidu.android.imsdk.upload.action.pb.IMPushPb.Msg) r1)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Msg r1 = r5.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r6.msg = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
            L_0x0060:
                int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r1 = r1 | r2
                r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                goto L_0x000c
            L_0x0066:
                int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r2 = 64
                r1 = r1 & r2
                if (r1 != r2) goto L_0x0073
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Ack r1 = r6.ack     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Ack$Builder r5 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
            L_0x0073:
                com.google.protobuf.Parser<com.baidu.android.imsdk.upload.action.pb.IMPushPb$Ack> r1 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.Ack.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.google.protobuf.MessageLite r1 = r7.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r8)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Ack r1 = (com.baidu.android.imsdk.upload.action.pb.IMPushPb.Ack) r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r6.ack = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                if (r5 == 0) goto L_0x0088
                r5.mergeFrom((com.baidu.android.imsdk.upload.action.pb.IMPushPb.Ack) r1)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Ack r1 = r5.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r6.ack = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
            L_0x0088:
                int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r1 = r1 | r2
                r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                goto L_0x000c
            L_0x008f:
                int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r2 = 32
                r1 = r1 & r2
                if (r1 != r2) goto L_0x009c
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Request r1 = r6.request     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Request$Builder r5 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
            L_0x009c:
                com.google.protobuf.Parser<com.baidu.android.imsdk.upload.action.pb.IMPushPb$Request> r1 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.Request.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.google.protobuf.MessageLite r1 = r7.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r8)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Request r1 = (com.baidu.android.imsdk.upload.action.pb.IMPushPb.Request) r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r6.request = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                if (r5 == 0) goto L_0x00b1
                r5.mergeFrom((com.baidu.android.imsdk.upload.action.pb.IMPushPb.Request) r1)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Request r1 = r5.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r6.request = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
            L_0x00b1:
                int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r1 = r1 | r2
                r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                goto L_0x000c
            L_0x00b8:
                int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r2 = 16
                r1 = r1 & r2
                if (r1 != r2) goto L_0x00c5
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Connection r1 = r6.connection     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Connection$Builder r5 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
            L_0x00c5:
                com.google.protobuf.Parser<com.baidu.android.imsdk.upload.action.pb.IMPushPb$Connection> r1 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.Connection.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.google.protobuf.MessageLite r1 = r7.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r8)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Connection r1 = (com.baidu.android.imsdk.upload.action.pb.IMPushPb.Connection) r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r6.connection = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                if (r5 == 0) goto L_0x00da
                r5.mergeFrom((com.baidu.android.imsdk.upload.action.pb.IMPushPb.Connection) r1)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Connection r1 = r5.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r6.connection = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
            L_0x00da:
                int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r1 = r1 | r2
                r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                goto L_0x000c
            L_0x00e1:
                int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r1 = r1 & r3
                if (r1 != r3) goto L_0x00ec
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Db r1 = r6.db     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Db$Builder r5 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
            L_0x00ec:
                com.google.protobuf.Parser<com.baidu.android.imsdk.upload.action.pb.IMPushPb$Db> r1 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.Db.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.google.protobuf.MessageLite r1 = r7.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r8)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Db r1 = (com.baidu.android.imsdk.upload.action.pb.IMPushPb.Db) r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r6.db = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                if (r5 == 0) goto L_0x0101
                r5.mergeFrom((com.baidu.android.imsdk.upload.action.pb.IMPushPb.Db) r1)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Db r1 = r5.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r6.db = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
            L_0x0101:
                int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r1 = r1 | r3
                r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                goto L_0x000c
            L_0x0108:
                int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r2 = 4
                r1 = r1 & r2
                if (r1 != r2) goto L_0x0114
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Crash r1 = r6.crash     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Crash$Builder r5 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
            L_0x0114:
                com.google.protobuf.Parser<com.baidu.android.imsdk.upload.action.pb.IMPushPb$Crash> r1 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.Crash.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.google.protobuf.MessageLite r1 = r7.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r8)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Crash r1 = (com.baidu.android.imsdk.upload.action.pb.IMPushPb.Crash) r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r6.crash = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                if (r5 == 0) goto L_0x0129
                r5.mergeFrom((com.baidu.android.imsdk.upload.action.pb.IMPushPb.Crash) r1)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Crash r1 = r5.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r6.crash = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
            L_0x0129:
                int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r1 = r1 | r2
                r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                goto L_0x000c
            L_0x0130:
                int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r2 = 2
                r1 = r1 & r2
                if (r1 != r2) goto L_0x013c
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Ui r1 = r6.ui     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Ui$Builder r5 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
            L_0x013c:
                com.google.protobuf.Parser<com.baidu.android.imsdk.upload.action.pb.IMPushPb$Ui> r1 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.Ui.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.google.protobuf.MessageLite r1 = r7.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r8)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Ui r1 = (com.baidu.android.imsdk.upload.action.pb.IMPushPb.Ui) r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r6.ui = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                if (r5 == 0) goto L_0x0151
                r5.mergeFrom((com.baidu.android.imsdk.upload.action.pb.IMPushPb.Ui) r1)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Ui r1 = r5.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r6.ui = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
            L_0x0151:
                int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r1 = r1 | r2
                r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                goto L_0x000c
            L_0x0158:
                int r1 = r7.readEnum()     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$ActionType r1 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionType.valueOf((int) r1)     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                if (r1 == 0) goto L_0x000c
                int r3 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r2 = r2 | r3
                r6.bitField0 = r2     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                r6.actionType = r1     // Catch:{ InvalidProtocolBufferException -> 0x017f, IOException -> 0x0170 }
                goto L_0x000c
            L_0x016b:
                r0 = 1
                goto L_0x000c
            L_0x016e:
                r7 = move-exception
                goto L_0x0185
            L_0x0170:
                r7 = move-exception
                com.google.protobuf.InvalidProtocolBufferException r8 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x016e }
                java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x016e }
                r8.<init>((java.lang.String) r7)     // Catch:{ all -> 0x016e }
                com.google.protobuf.InvalidProtocolBufferException r7 = r8.setUnfinishedMessage(r6)     // Catch:{ all -> 0x016e }
                throw r7     // Catch:{ all -> 0x016e }
            L_0x017f:
                r7 = move-exception
                com.google.protobuf.InvalidProtocolBufferException r7 = r7.setUnfinishedMessage(r6)     // Catch:{ all -> 0x016e }
                throw r7     // Catch:{ all -> 0x016e }
            L_0x0185:
                r6.makeExtensionsImmutable()
                throw r7
            L_0x0189:
                r6.makeExtensionsImmutable()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Action.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
        }
    }

    public interface ActionOrBuilder extends MessageLiteOrBuilder {
        Ack getAck();

        ActionType getActionType();

        Connection getConnection();

        Crash getCrash();

        Db getDb();

        Msg getMsg();

        Request getRequest();

        Ui getUi();

        boolean hasAck();

        boolean hasActionType();

        boolean hasConnection();

        boolean hasCrash();

        boolean hasDb();

        boolean hasMsg();

        boolean hasRequest();

        boolean hasUi();
    }

    public enum ActionType implements Internal.EnumLite {
        UI(0, 101),
        CRASH(1, 201),
        DB(2, 301),
        CONNECTION(3, 401),
        REQUEST(4, REQUEST_VALUE),
        ACK(5, 601),
        MSG(6, MSG_VALUE);
        
        public static final int ACK_VALUE = 601;
        public static final int CONNECTION_VALUE = 401;
        public static final int CRASH_VALUE = 201;
        public static final int DB_VALUE = 301;
        public static final int MSG_VALUE = 701;
        public static final int REQUEST_VALUE = 501;
        public static final int UI_VALUE = 101;
        public static Internal.EnumLiteMap<ActionType> internalValueMap;
        public final int value;

        /* access modifiers changed from: public */
        static {
            internalValueMap = new Internal.EnumLiteMap<ActionType>() {
                public ActionType findValueByNumber(int i2) {
                    return ActionType.valueOf(i2);
                }
            };
        }

        /* access modifiers changed from: public */
        ActionType(int i2, int i3) {
            this.value = i3;
        }

        public static Internal.EnumLiteMap<ActionType> internalGetValueMap() {
            return internalValueMap;
        }

        public final int getNumber() {
            return this.value;
        }

        public static ActionType valueOf(int i2) {
            if (i2 == 101) {
                return UI;
            }
            if (i2 == 201) {
                return CRASH;
            }
            if (i2 == 301) {
                return DB;
            }
            if (i2 == 401) {
                return CONNECTION;
            }
            if (i2 == 501) {
                return REQUEST;
            }
            if (i2 == 601) {
                return ACK;
            }
            if (i2 != 701) {
                return null;
            }
            return MSG;
        }
    }

    public static final class AppInfo extends GeneratedMessageLite implements AppInfoOrBuilder {
        public static final int APP_CHANNEL_FIELD_NUMBER = 3;
        public static final int APP_NAME_FIELD_NUMBER = 1;
        public static final int APP_VERSION_FIELD_NUMBER = 2;
        public static final Parser<AppInfo> PARSER = new AbstractParser<AppInfo>() {
            public AppInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AppInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final AppInfo defaultInstance;
        public static final long serialVersionUID = 0;
        public Object appChannel;
        public Object appName;
        public Object appVersion;
        public int bitField0;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;

        public static final class Builder extends GeneratedMessageLite.Builder<AppInfo, Builder> implements AppInfoOrBuilder {
            public Object appChannel = "";
            public Object appName = "";
            public Object appVersion = "";
            public int bitField0;

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAppChannel() {
                this.bitField0 &= -5;
                this.appChannel = AppInfo.getDefaultInstance().getAppChannel();
                return this;
            }

            public Builder clearAppName() {
                this.bitField0 &= -2;
                this.appName = AppInfo.getDefaultInstance().getAppName();
                return this;
            }

            public Builder clearAppVersion() {
                this.bitField0 &= -3;
                this.appVersion = AppInfo.getDefaultInstance().getAppVersion();
                return this;
            }

            public String getAppChannel() {
                Object obj = this.appChannel;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.appChannel = stringUtf8;
                return stringUtf8;
            }

            public ByteString getAppChannelBytes() {
                Object obj = this.appChannel;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appChannel = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getAppName() {
                Object obj = this.appName;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.appName = stringUtf8;
                return stringUtf8;
            }

            public ByteString getAppNameBytes() {
                Object obj = this.appName;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appName = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getAppVersion() {
                Object obj = this.appVersion;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.appVersion = stringUtf8;
                return stringUtf8;
            }

            public ByteString getAppVersionBytes() {
                Object obj = this.appVersion;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appVersion = copyFromUtf8;
                return copyFromUtf8;
            }

            public boolean hasAppChannel() {
                return (this.bitField0 & 4) == 4;
            }

            public boolean hasAppName() {
                return (this.bitField0 & 1) == 1;
            }

            public boolean hasAppVersion() {
                return (this.bitField0 & 2) == 2;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setAppChannel(String str) {
                if (str != null) {
                    this.bitField0 |= 4;
                    this.appChannel = str;
                    return this;
                }
                throw null;
            }

            public Builder setAppChannelBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 4;
                    this.appChannel = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setAppName(String str) {
                if (str != null) {
                    this.bitField0 |= 1;
                    this.appName = str;
                    return this;
                }
                throw null;
            }

            public Builder setAppNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 1;
                    this.appName = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setAppVersion(String str) {
                if (str != null) {
                    this.bitField0 |= 2;
                    this.appVersion = str;
                    return this;
                }
                throw null;
            }

            public Builder setAppVersionBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 2;
                    this.appVersion = byteString;
                    return this;
                }
                throw null;
            }

            public AppInfo build() {
                AppInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public AppInfo buildPartial() {
                AppInfo appInfo = new AppInfo((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                Object unused = appInfo.appName = this.appName;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Object unused2 = appInfo.appVersion = this.appVersion;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                Object unused3 = appInfo.appChannel = this.appChannel;
                int unused4 = appInfo.bitField0 = i3;
                return appInfo;
            }

            public Builder clear() {
                super.clear();
                this.appName = "";
                int i2 = this.bitField0 & -2;
                this.bitField0 = i2;
                this.appVersion = "";
                int i3 = i2 & -3;
                this.bitField0 = i3;
                this.appChannel = "";
                this.bitField0 = i3 & -5;
                return this;
            }

            public AppInfo getDefaultInstanceForType() {
                return AppInfo.getDefaultInstance();
            }

            public Builder mergeFrom(AppInfo appInfo) {
                if (appInfo == AppInfo.getDefaultInstance()) {
                    return this;
                }
                if (appInfo.hasAppName()) {
                    this.bitField0 |= 1;
                    this.appName = appInfo.appName;
                }
                if (appInfo.hasAppVersion()) {
                    this.bitField0 |= 2;
                    this.appVersion = appInfo.appVersion;
                }
                if (appInfo.hasAppChannel()) {
                    this.bitField0 |= 4;
                    this.appChannel = appInfo.appChannel;
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AppInfo appInfo;
                AppInfo appInfo2 = null;
                try {
                    AppInfo parsePartialFrom = AppInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    appInfo = (AppInfo) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    appInfo2 = appInfo;
                }
                if (appInfo2 != null) {
                    mergeFrom(appInfo2);
                }
                throw th;
            }
        }

        static {
            AppInfo appInfo = new AppInfo(true);
            defaultInstance = appInfo;
            appInfo.initFields();
        }

        public static AppInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.appName = "";
            this.appVersion = "";
            this.appChannel = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static AppInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static AppInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public String getAppChannel() {
            Object obj = this.appChannel;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.appChannel = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getAppChannelBytes() {
            Object obj = this.appChannel;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.appChannel = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getAppName() {
            Object obj = this.appName;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.appName = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getAppNameBytes() {
            Object obj = this.appName;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.appName = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getAppVersion() {
            Object obj = this.appVersion;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.appVersion = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getAppVersionBytes() {
            Object obj = this.appVersion;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.appVersion = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<AppInfo> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeBytesSize(1, getAppNameBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                i3 += CodedOutputStream.computeBytesSize(2, getAppVersionBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                i3 += CodedOutputStream.computeBytesSize(3, getAppChannelBytes());
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public boolean hasAppChannel() {
            return (this.bitField0 & 4) == 4;
        }

        public boolean hasAppName() {
            return (this.bitField0 & 1) == 1;
        }

        public boolean hasAppVersion() {
            return (this.bitField0 & 2) == 2;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getAppNameBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getAppVersionBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeBytes(3, getAppChannelBytes());
            }
        }

        public static Builder newBuilder(AppInfo appInfo) {
            return newBuilder().mergeFrom(appInfo);
        }

        public static AppInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static AppInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public AppInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public AppInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static AppInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AppInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AppInfo parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public AppInfo(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static AppInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static AppInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static AppInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public AppInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.bitField0 |= 1;
                            this.appName = codedInputStream.readBytes();
                        } else if (readTag == 18) {
                            this.bitField0 |= 2;
                            this.appVersion = codedInputStream.readBytes();
                        } else if (readTag == 26) {
                            this.bitField0 |= 4;
                            this.appChannel = codedInputStream.readBytes();
                        } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    makeExtensionsImmutable();
                    throw th2;
                }
            }
            makeExtensionsImmutable();
        }
    }

    public interface AppInfoOrBuilder extends MessageLiteOrBuilder {
        String getAppChannel();

        ByteString getAppChannelBytes();

        String getAppName();

        ByteString getAppNameBytes();

        String getAppVersion();

        ByteString getAppVersionBytes();

        boolean hasAppChannel();

        boolean hasAppName();

        boolean hasAppVersion();
    }

    public static final class Common extends GeneratedMessageLite implements CommonOrBuilder {
        public static final int APP_INFO_FIELD_NUMBER = 21;
        public static final int DEVICE_ID_FIELD_NUMBER = 7;
        public static final int MODULE_NAME_FIELD_NUMBER = 2;
        public static final int NET_INFO_FIELD_NUMBER = 22;
        public static final Parser<Common> PARSER = new AbstractParser<Common>() {
            public Common parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Common(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PRODUCT_NAME_FIELD_NUMBER = 1;
        public static final int TERMINAL_INFO_FIELD_NUMBER = 20;
        public static final int TIMESTAMP_FIELD_NUMBER = 10;
        public static final int USER_TIMESTAMP_FIELD_NUMBER = 12;
        public static final Common defaultInstance;
        public static final long serialVersionUID = 0;
        public AppInfo appInfo;
        public int bitField0;
        public DeviceID deviceId;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object moduleName;
        public NetInfo netInfo;
        public Object productName;
        public TerminalInfo terminalInfo;
        public long timestamp;
        public long userTimestamp;

        public static final class Builder extends GeneratedMessageLite.Builder<Common, Builder> implements CommonOrBuilder {
            public AppInfo appInfo = AppInfo.getDefaultInstance();
            public int bitField0;
            public DeviceID deviceId = DeviceID.getDefaultInstance();
            public Object moduleName = "";
            public NetInfo netInfo = NetInfo.getDefaultInstance();
            public Object productName = "";
            public TerminalInfo terminalInfo = TerminalInfo.getDefaultInstance();
            public long timestamp;
            public long userTimestamp;

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAppInfo() {
                this.appInfo = AppInfo.getDefaultInstance();
                this.bitField0 &= -65;
                return this;
            }

            public Builder clearDeviceId() {
                this.deviceId = DeviceID.getDefaultInstance();
                this.bitField0 &= -5;
                return this;
            }

            public Builder clearModuleName() {
                this.bitField0 &= -3;
                this.moduleName = Common.getDefaultInstance().getModuleName();
                return this;
            }

            public Builder clearNetInfo() {
                this.netInfo = NetInfo.getDefaultInstance();
                this.bitField0 &= -129;
                return this;
            }

            public Builder clearProductName() {
                this.bitField0 &= -2;
                this.productName = Common.getDefaultInstance().getProductName();
                return this;
            }

            public Builder clearTerminalInfo() {
                this.terminalInfo = TerminalInfo.getDefaultInstance();
                this.bitField0 &= -33;
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0 &= -9;
                this.timestamp = 0;
                return this;
            }

            public Builder clearUserTimestamp() {
                this.bitField0 &= -17;
                this.userTimestamp = 0;
                return this;
            }

            public AppInfo getAppInfo() {
                return this.appInfo;
            }

            public DeviceID getDeviceId() {
                return this.deviceId;
            }

            public String getModuleName() {
                Object obj = this.moduleName;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.moduleName = stringUtf8;
                return stringUtf8;
            }

            public ByteString getModuleNameBytes() {
                Object obj = this.moduleName;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.moduleName = copyFromUtf8;
                return copyFromUtf8;
            }

            public NetInfo getNetInfo() {
                return this.netInfo;
            }

            public String getProductName() {
                Object obj = this.productName;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.productName = stringUtf8;
                return stringUtf8;
            }

            public ByteString getProductNameBytes() {
                Object obj = this.productName;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.productName = copyFromUtf8;
                return copyFromUtf8;
            }

            public TerminalInfo getTerminalInfo() {
                return this.terminalInfo;
            }

            public long getTimestamp() {
                return this.timestamp;
            }

            public long getUserTimestamp() {
                return this.userTimestamp;
            }

            public boolean hasAppInfo() {
                return (this.bitField0 & 64) == 64;
            }

            public boolean hasDeviceId() {
                return (this.bitField0 & 4) == 4;
            }

            public boolean hasModuleName() {
                return (this.bitField0 & 2) == 2;
            }

            public boolean hasNetInfo() {
                return (this.bitField0 & 128) == 128;
            }

            public boolean hasProductName() {
                return (this.bitField0 & 1) == 1;
            }

            public boolean hasTerminalInfo() {
                return (this.bitField0 & 32) == 32;
            }

            public boolean hasTimestamp() {
                return (this.bitField0 & 8) == 8;
            }

            public boolean hasUserTimestamp() {
                return (this.bitField0 & 16) == 16;
            }

            public final boolean isInitialized() {
                if (!hasTimestamp()) {
                    return false;
                }
                if (!hasDeviceId() || getDeviceId().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeAppInfo(AppInfo appInfo2) {
                if ((this.bitField0 & 64) != 64 || this.appInfo == AppInfo.getDefaultInstance()) {
                    this.appInfo = appInfo2;
                } else {
                    this.appInfo = AppInfo.newBuilder(this.appInfo).mergeFrom(appInfo2).buildPartial();
                }
                this.bitField0 |= 64;
                return this;
            }

            public Builder mergeDeviceId(DeviceID deviceID) {
                if ((this.bitField0 & 4) != 4 || this.deviceId == DeviceID.getDefaultInstance()) {
                    this.deviceId = deviceID;
                } else {
                    this.deviceId = DeviceID.newBuilder(this.deviceId).mergeFrom(deviceID).buildPartial();
                }
                this.bitField0 |= 4;
                return this;
            }

            public Builder mergeNetInfo(NetInfo netInfo2) {
                if ((this.bitField0 & 128) != 128 || this.netInfo == NetInfo.getDefaultInstance()) {
                    this.netInfo = netInfo2;
                } else {
                    this.netInfo = NetInfo.newBuilder(this.netInfo).mergeFrom(netInfo2).buildPartial();
                }
                this.bitField0 |= 128;
                return this;
            }

            public Builder mergeTerminalInfo(TerminalInfo terminalInfo2) {
                if ((this.bitField0 & 32) != 32 || this.terminalInfo == TerminalInfo.getDefaultInstance()) {
                    this.terminalInfo = terminalInfo2;
                } else {
                    this.terminalInfo = TerminalInfo.newBuilder(this.terminalInfo).mergeFrom(terminalInfo2).buildPartial();
                }
                this.bitField0 |= 32;
                return this;
            }

            public Builder setAppInfo(AppInfo appInfo2) {
                if (appInfo2 != null) {
                    this.appInfo = appInfo2;
                    this.bitField0 |= 64;
                    return this;
                }
                throw null;
            }

            public Builder setDeviceId(DeviceID deviceID) {
                if (deviceID != null) {
                    this.deviceId = deviceID;
                    this.bitField0 |= 4;
                    return this;
                }
                throw null;
            }

            public Builder setModuleName(String str) {
                if (str != null) {
                    this.bitField0 |= 2;
                    this.moduleName = str;
                    return this;
                }
                throw null;
            }

            public Builder setModuleNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 2;
                    this.moduleName = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setNetInfo(NetInfo netInfo2) {
                if (netInfo2 != null) {
                    this.netInfo = netInfo2;
                    this.bitField0 |= 128;
                    return this;
                }
                throw null;
            }

            public Builder setProductName(String str) {
                if (str != null) {
                    this.bitField0 |= 1;
                    this.productName = str;
                    return this;
                }
                throw null;
            }

            public Builder setProductNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 1;
                    this.productName = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setTerminalInfo(TerminalInfo terminalInfo2) {
                if (terminalInfo2 != null) {
                    this.terminalInfo = terminalInfo2;
                    this.bitField0 |= 32;
                    return this;
                }
                throw null;
            }

            public Builder setTimestamp(long j) {
                this.bitField0 |= 8;
                this.timestamp = j;
                return this;
            }

            public Builder setUserTimestamp(long j) {
                this.bitField0 |= 16;
                this.userTimestamp = j;
                return this;
            }

            public Common build() {
                Common buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Common buildPartial() {
                Common common = new Common((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                Object unused = common.productName = this.productName;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Object unused2 = common.moduleName = this.moduleName;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                DeviceID unused3 = common.deviceId = this.deviceId;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                long unused4 = common.timestamp = this.timestamp;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                long unused5 = common.userTimestamp = this.userTimestamp;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                TerminalInfo unused6 = common.terminalInfo = this.terminalInfo;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                AppInfo unused7 = common.appInfo = this.appInfo;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                NetInfo unused8 = common.netInfo = this.netInfo;
                int unused9 = common.bitField0 = i3;
                return common;
            }

            public Builder clear() {
                super.clear();
                this.productName = "";
                int i2 = this.bitField0 & -2;
                this.bitField0 = i2;
                this.moduleName = "";
                this.bitField0 = i2 & -3;
                this.deviceId = DeviceID.getDefaultInstance();
                int i3 = this.bitField0 & -5;
                this.bitField0 = i3;
                this.timestamp = 0;
                int i4 = i3 & -9;
                this.bitField0 = i4;
                this.userTimestamp = 0;
                this.bitField0 = i4 & -17;
                this.terminalInfo = TerminalInfo.getDefaultInstance();
                this.bitField0 &= -33;
                this.appInfo = AppInfo.getDefaultInstance();
                this.bitField0 &= -65;
                this.netInfo = NetInfo.getDefaultInstance();
                this.bitField0 &= -129;
                return this;
            }

            public Common getDefaultInstanceForType() {
                return Common.getDefaultInstance();
            }

            public Builder mergeFrom(Common common) {
                if (common == Common.getDefaultInstance()) {
                    return this;
                }
                if (common.hasProductName()) {
                    this.bitField0 |= 1;
                    this.productName = common.productName;
                }
                if (common.hasModuleName()) {
                    this.bitField0 |= 2;
                    this.moduleName = common.moduleName;
                }
                if (common.hasDeviceId()) {
                    mergeDeviceId(common.getDeviceId());
                }
                if (common.hasTimestamp()) {
                    setTimestamp(common.getTimestamp());
                }
                if (common.hasUserTimestamp()) {
                    setUserTimestamp(common.getUserTimestamp());
                }
                if (common.hasTerminalInfo()) {
                    mergeTerminalInfo(common.getTerminalInfo());
                }
                if (common.hasAppInfo()) {
                    mergeAppInfo(common.getAppInfo());
                }
                if (common.hasNetInfo()) {
                    mergeNetInfo(common.getNetInfo());
                }
                return this;
            }

            public Builder setAppInfo(AppInfo.Builder builder) {
                this.appInfo = builder.build();
                this.bitField0 |= 64;
                return this;
            }

            public Builder setDeviceId(DeviceID.Builder builder) {
                this.deviceId = builder.build();
                this.bitField0 |= 4;
                return this;
            }

            public Builder setNetInfo(NetInfo.Builder builder) {
                this.netInfo = builder.build();
                this.bitField0 |= 128;
                return this;
            }

            public Builder setTerminalInfo(TerminalInfo.Builder builder) {
                this.terminalInfo = builder.build();
                this.bitField0 |= 32;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Common common;
                Common common2 = null;
                try {
                    Common parsePartialFrom = Common.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    common = (Common) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    common2 = common;
                }
                if (common2 != null) {
                    mergeFrom(common2);
                }
                throw th;
            }
        }

        static {
            Common common = new Common(true);
            defaultInstance = common;
            common.initFields();
        }

        public static Common getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.productName = "";
            this.moduleName = "";
            this.deviceId = DeviceID.getDefaultInstance();
            this.timestamp = 0;
            this.userTimestamp = 0;
            this.terminalInfo = TerminalInfo.getDefaultInstance();
            this.appInfo = AppInfo.getDefaultInstance();
            this.netInfo = NetInfo.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Common parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Common parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public AppInfo getAppInfo() {
            return this.appInfo;
        }

        public DeviceID getDeviceId() {
            return this.deviceId;
        }

        public String getModuleName() {
            Object obj = this.moduleName;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.moduleName = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getModuleNameBytes() {
            Object obj = this.moduleName;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.moduleName = copyFromUtf8;
            return copyFromUtf8;
        }

        public NetInfo getNetInfo() {
            return this.netInfo;
        }

        public Parser<Common> getParserForType() {
            return PARSER;
        }

        public String getProductName() {
            Object obj = this.productName;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.productName = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getProductNameBytes() {
            Object obj = this.productName;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.productName = copyFromUtf8;
            return copyFromUtf8;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeBytesSize(1, getProductNameBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                i3 += CodedOutputStream.computeBytesSize(2, getModuleNameBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                i3 += CodedOutputStream.computeMessageSize(7, this.deviceId);
            }
            if ((this.bitField0 & 8) == 8) {
                i3 += CodedOutputStream.computeInt64Size(10, this.timestamp);
            }
            if ((this.bitField0 & 16) == 16) {
                i3 += CodedOutputStream.computeInt64Size(12, this.userTimestamp);
            }
            if ((this.bitField0 & 32) == 32) {
                i3 += CodedOutputStream.computeMessageSize(20, this.terminalInfo);
            }
            if ((this.bitField0 & 64) == 64) {
                i3 += CodedOutputStream.computeMessageSize(21, this.appInfo);
            }
            if ((this.bitField0 & 128) == 128) {
                i3 += CodedOutputStream.computeMessageSize(22, this.netInfo);
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public TerminalInfo getTerminalInfo() {
            return this.terminalInfo;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public long getUserTimestamp() {
            return this.userTimestamp;
        }

        public boolean hasAppInfo() {
            return (this.bitField0 & 64) == 64;
        }

        public boolean hasDeviceId() {
            return (this.bitField0 & 4) == 4;
        }

        public boolean hasModuleName() {
            return (this.bitField0 & 2) == 2;
        }

        public boolean hasNetInfo() {
            return (this.bitField0 & 128) == 128;
        }

        public boolean hasProductName() {
            return (this.bitField0 & 1) == 1;
        }

        public boolean hasTerminalInfo() {
            return (this.bitField0 & 32) == 32;
        }

        public boolean hasTimestamp() {
            return (this.bitField0 & 8) == 8;
        }

        public boolean hasUserTimestamp() {
            return (this.bitField0 & 16) == 16;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            if (!hasTimestamp()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasDeviceId() || getDeviceId().isInitialized()) {
                this.memoizedIsInitialized = 1;
                return true;
            } else {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }

        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getProductNameBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getModuleNameBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeMessage(7, this.deviceId);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(10, this.timestamp);
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeInt64(12, this.userTimestamp);
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeMessage(20, this.terminalInfo);
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeMessage(21, this.appInfo);
            }
            if ((this.bitField0 & 128) == 128) {
                codedOutputStream.writeMessage(22, this.netInfo);
            }
        }

        public static Builder newBuilder(Common common) {
            return newBuilder().mergeFrom(common);
        }

        public static Common parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Common parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Common getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Common(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Common parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Common parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Common parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public Common(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Common parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Common parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Common parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.baidu.android.imsdk.upload.action.pb.IMPushPb$DeviceID$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.baidu.android.imsdk.upload.action.pb.IMPushPb$TerminalInfo$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.baidu.android.imsdk.upload.action.pb.IMPushPb$AppInfo$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: com.baidu.android.imsdk.upload.action.pb.IMPushPb$NetInfo$Builder} */
        /* JADX WARNING: type inference failed for: r4v0 */
        /* JADX WARNING: type inference failed for: r4v9 */
        /* JADX WARNING: type inference failed for: r4v10 */
        /* JADX WARNING: type inference failed for: r4v11 */
        /* JADX WARNING: type inference failed for: r4v12 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Common(com.google.protobuf.CodedInputStream r6, com.google.protobuf.ExtensionRegistryLite r7) throws com.google.protobuf.InvalidProtocolBufferException {
            /*
                r5 = this;
                r5.<init>()
                r0 = -1
                r5.memoizedIsInitialized = r0
                r5.memoizedSerializedSize = r0
                r5.initFields()
                r0 = 0
            L_0x000c:
                if (r0 != 0) goto L_0x0135
                int r1 = r6.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r2 = 1
                if (r1 == 0) goto L_0x0117
                r3 = 10
                if (r1 == r3) goto L_0x010a
                r3 = 18
                if (r1 == r3) goto L_0x00fc
                r3 = 58
                r4 = 0
                if (r1 == r3) goto L_0x00d4
                r3 = 80
                if (r1 == r3) goto L_0x00c6
                r3 = 96
                if (r1 == r3) goto L_0x00b8
                r3 = 162(0xa2, float:2.27E-43)
                if (r1 == r3) goto L_0x008f
                r3 = 170(0xaa, float:2.38E-43)
                if (r1 == r3) goto L_0x0066
                r3 = 178(0xb2, float:2.5E-43)
                if (r1 == r3) goto L_0x003e
                boolean r1 = r5.parseUnknownField(r6, r7, r1)     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                if (r1 != 0) goto L_0x000c
                goto L_0x0117
            L_0x003e:
                int r1 = r5.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r2 = 128(0x80, float:1.794E-43)
                r1 = r1 & r2
                if (r1 != r2) goto L_0x004b
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$NetInfo r1 = r5.netInfo     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$NetInfo$Builder r4 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
            L_0x004b:
                com.google.protobuf.Parser<com.baidu.android.imsdk.upload.action.pb.IMPushPb$NetInfo> r1 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.google.protobuf.MessageLite r1 = r6.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r7)     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$NetInfo r1 = (com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfo) r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r5.netInfo = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                if (r4 == 0) goto L_0x0060
                r4.mergeFrom((com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfo) r1)     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$NetInfo r1 = r4.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r5.netInfo = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
            L_0x0060:
                int r1 = r5.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r1 = r1 | r2
                r5.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                goto L_0x000c
            L_0x0066:
                int r1 = r5.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r2 = 64
                r1 = r1 & r2
                if (r1 != r2) goto L_0x0073
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$AppInfo r1 = r5.appInfo     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$AppInfo$Builder r4 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
            L_0x0073:
                com.google.protobuf.Parser<com.baidu.android.imsdk.upload.action.pb.IMPushPb$AppInfo> r1 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.google.protobuf.MessageLite r1 = r6.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r7)     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$AppInfo r1 = (com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfo) r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r5.appInfo = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                if (r4 == 0) goto L_0x0088
                r4.mergeFrom((com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfo) r1)     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$AppInfo r1 = r4.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r5.appInfo = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
            L_0x0088:
                int r1 = r5.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r1 = r1 | r2
                r5.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                goto L_0x000c
            L_0x008f:
                int r1 = r5.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r2 = 32
                r1 = r1 & r2
                if (r1 != r2) goto L_0x009c
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$TerminalInfo r1 = r5.terminalInfo     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$TerminalInfo$Builder r4 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
            L_0x009c:
                com.google.protobuf.Parser<com.baidu.android.imsdk.upload.action.pb.IMPushPb$TerminalInfo> r1 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.google.protobuf.MessageLite r1 = r6.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r7)     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$TerminalInfo r1 = (com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfo) r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r5.terminalInfo = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                if (r4 == 0) goto L_0x00b1
                r4.mergeFrom((com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfo) r1)     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$TerminalInfo r1 = r4.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r5.terminalInfo = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
            L_0x00b1:
                int r1 = r5.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r1 = r1 | r2
                r5.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                goto L_0x000c
            L_0x00b8:
                int r1 = r5.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r1 = r1 | 16
                r5.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                long r1 = r6.readInt64()     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r5.userTimestamp = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                goto L_0x000c
            L_0x00c6:
                int r1 = r5.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r1 = r1 | 8
                r5.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                long r1 = r6.readInt64()     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r5.timestamp = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                goto L_0x000c
            L_0x00d4:
                int r1 = r5.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r2 = 4
                r1 = r1 & r2
                if (r1 != r2) goto L_0x00e0
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$DeviceID r1 = r5.deviceId     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$DeviceID$Builder r4 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
            L_0x00e0:
                com.google.protobuf.Parser<com.baidu.android.imsdk.upload.action.pb.IMPushPb$DeviceID> r1 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceID.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.google.protobuf.MessageLite r1 = r6.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r7)     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$DeviceID r1 = (com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceID) r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r5.deviceId = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                if (r4 == 0) goto L_0x00f5
                r4.mergeFrom((com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceID) r1)     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$DeviceID r1 = r4.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r5.deviceId = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
            L_0x00f5:
                int r1 = r5.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r1 = r1 | r2
                r5.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                goto L_0x000c
            L_0x00fc:
                int r1 = r5.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r1 = r1 | 2
                r5.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.google.protobuf.ByteString r1 = r6.readBytes()     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r5.moduleName = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                goto L_0x000c
            L_0x010a:
                int r1 = r5.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r1 = r1 | r2
                r5.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                com.google.protobuf.ByteString r1 = r6.readBytes()     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                r5.productName = r1     // Catch:{ InvalidProtocolBufferException -> 0x012b, IOException -> 0x011c }
                goto L_0x000c
            L_0x0117:
                r0 = 1
                goto L_0x000c
            L_0x011a:
                r6 = move-exception
                goto L_0x0131
            L_0x011c:
                r6 = move-exception
                com.google.protobuf.InvalidProtocolBufferException r7 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x011a }
                java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x011a }
                r7.<init>((java.lang.String) r6)     // Catch:{ all -> 0x011a }
                com.google.protobuf.InvalidProtocolBufferException r6 = r7.setUnfinishedMessage(r5)     // Catch:{ all -> 0x011a }
                throw r6     // Catch:{ all -> 0x011a }
            L_0x012b:
                r6 = move-exception
                com.google.protobuf.InvalidProtocolBufferException r6 = r6.setUnfinishedMessage(r5)     // Catch:{ all -> 0x011a }
                throw r6     // Catch:{ all -> 0x011a }
            L_0x0131:
                r5.makeExtensionsImmutable()
                throw r6
            L_0x0135:
                r5.makeExtensionsImmutable()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Common.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
        }
    }

    public interface CommonOrBuilder extends MessageLiteOrBuilder {
        AppInfo getAppInfo();

        DeviceID getDeviceId();

        String getModuleName();

        ByteString getModuleNameBytes();

        NetInfo getNetInfo();

        String getProductName();

        ByteString getProductNameBytes();

        TerminalInfo getTerminalInfo();

        long getTimestamp();

        long getUserTimestamp();

        boolean hasAppInfo();

        boolean hasDeviceId();

        boolean hasModuleName();

        boolean hasNetInfo();

        boolean hasProductName();

        boolean hasTerminalInfo();

        boolean hasTimestamp();

        boolean hasUserTimestamp();
    }

    public static final class Connection extends GeneratedMessageLite implements ConnectionOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 7;
        public static final int EXT_FIELD_NUMBER = 6;
        public static final Parser<Connection> PARSER = new AbstractParser<Connection>() {
            public Connection parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Connection(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int REASON_FIELD_NUMBER = 3;
        public static final int RETRY_COUNT_FIELD_NUMBER = 5;
        public static final int RETRY_TIME_FIELD_NUMBER = 4;
        public static final int START_TIME_FIELD_NUMBER = 1;
        public static final int STOP_TIME_FIELD_NUMBER = 2;
        public static final Connection defaultInstance;
        public static final long serialVersionUID = 0;
        public long aliasId;
        public int bitField0;
        public Object ext;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object reason;
        public long retryCount;
        public long retryTime;
        public long startTime;
        public long stopTime;

        public static final class Builder extends GeneratedMessageLite.Builder<Connection, Builder> implements ConnectionOrBuilder {
            public long aliasId;
            public int bitField0;
            public Object ext = "";
            public Object reason = "";
            public long retryCount;
            public long retryTime;
            public long startTime;
            public long stopTime;

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAliasId() {
                this.bitField0 &= -65;
                this.aliasId = 0;
                return this;
            }

            public Builder clearExt() {
                this.bitField0 &= -33;
                this.ext = Connection.getDefaultInstance().getExt();
                return this;
            }

            public Builder clearReason() {
                this.bitField0 &= -5;
                this.reason = Connection.getDefaultInstance().getReason();
                return this;
            }

            public Builder clearRetryCount() {
                this.bitField0 &= -17;
                this.retryCount = 0;
                return this;
            }

            public Builder clearRetryTime() {
                this.bitField0 &= -9;
                this.retryTime = 0;
                return this;
            }

            public Builder clearStartTime() {
                this.bitField0 &= -2;
                this.startTime = 0;
                return this;
            }

            public Builder clearStopTime() {
                this.bitField0 &= -3;
                this.stopTime = 0;
                return this;
            }

            public long getAliasId() {
                return this.aliasId;
            }

            public String getExt() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ext = stringUtf8;
                return stringUtf8;
            }

            public ByteString getExtBytes() {
                Object obj = this.ext;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getReason() {
                Object obj = this.reason;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.reason = stringUtf8;
                return stringUtf8;
            }

            public ByteString getReasonBytes() {
                Object obj = this.reason;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.reason = copyFromUtf8;
                return copyFromUtf8;
            }

            public long getRetryCount() {
                return this.retryCount;
            }

            public long getRetryTime() {
                return this.retryTime;
            }

            public long getStartTime() {
                return this.startTime;
            }

            public long getStopTime() {
                return this.stopTime;
            }

            public boolean hasAliasId() {
                return (this.bitField0 & 64) == 64;
            }

            public boolean hasExt() {
                return (this.bitField0 & 32) == 32;
            }

            public boolean hasReason() {
                return (this.bitField0 & 4) == 4;
            }

            public boolean hasRetryCount() {
                return (this.bitField0 & 16) == 16;
            }

            public boolean hasRetryTime() {
                return (this.bitField0 & 8) == 8;
            }

            public boolean hasStartTime() {
                return (this.bitField0 & 1) == 1;
            }

            public boolean hasStopTime() {
                return (this.bitField0 & 2) == 2;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setAliasId(long j) {
                this.bitField0 |= 64;
                this.aliasId = j;
                return this;
            }

            public Builder setExt(String str) {
                if (str != null) {
                    this.bitField0 |= 32;
                    this.ext = str;
                    return this;
                }
                throw null;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 32;
                    this.ext = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setReason(String str) {
                if (str != null) {
                    this.bitField0 |= 4;
                    this.reason = str;
                    return this;
                }
                throw null;
            }

            public Builder setReasonBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 4;
                    this.reason = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setRetryCount(long j) {
                this.bitField0 |= 16;
                this.retryCount = j;
                return this;
            }

            public Builder setRetryTime(long j) {
                this.bitField0 |= 8;
                this.retryTime = j;
                return this;
            }

            public Builder setStartTime(long j) {
                this.bitField0 |= 1;
                this.startTime = j;
                return this;
            }

            public Builder setStopTime(long j) {
                this.bitField0 |= 2;
                this.stopTime = j;
                return this;
            }

            public Connection build() {
                Connection buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Connection buildPartial() {
                Connection connection = new Connection((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                long unused = connection.startTime = this.startTime;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                long unused2 = connection.stopTime = this.stopTime;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                Object unused3 = connection.reason = this.reason;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                long unused4 = connection.retryTime = this.retryTime;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                long unused5 = connection.retryCount = this.retryCount;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                Object unused6 = connection.ext = this.ext;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                long unused7 = connection.aliasId = this.aliasId;
                int unused8 = connection.bitField0 = i3;
                return connection;
            }

            public Builder clear() {
                super.clear();
                this.startTime = 0;
                int i2 = this.bitField0 & -2;
                this.bitField0 = i2;
                this.stopTime = 0;
                int i3 = i2 & -3;
                this.bitField0 = i3;
                this.reason = "";
                int i4 = i3 & -5;
                this.bitField0 = i4;
                this.retryTime = 0;
                int i5 = i4 & -9;
                this.bitField0 = i5;
                this.retryCount = 0;
                int i6 = i5 & -17;
                this.bitField0 = i6;
                this.ext = "";
                int i7 = i6 & -33;
                this.bitField0 = i7;
                this.aliasId = 0;
                this.bitField0 = i7 & -65;
                return this;
            }

            public Connection getDefaultInstanceForType() {
                return Connection.getDefaultInstance();
            }

            public Builder mergeFrom(Connection connection) {
                if (connection == Connection.getDefaultInstance()) {
                    return this;
                }
                if (connection.hasStartTime()) {
                    setStartTime(connection.getStartTime());
                }
                if (connection.hasStopTime()) {
                    setStopTime(connection.getStopTime());
                }
                if (connection.hasReason()) {
                    this.bitField0 |= 4;
                    this.reason = connection.reason;
                }
                if (connection.hasRetryTime()) {
                    setRetryTime(connection.getRetryTime());
                }
                if (connection.hasRetryCount()) {
                    setRetryCount(connection.getRetryCount());
                }
                if (connection.hasExt()) {
                    this.bitField0 |= 32;
                    this.ext = connection.ext;
                }
                if (connection.hasAliasId()) {
                    setAliasId(connection.getAliasId());
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Connection connection;
                Connection connection2 = null;
                try {
                    Connection parsePartialFrom = Connection.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    connection = (Connection) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    connection2 = connection;
                }
                if (connection2 != null) {
                    mergeFrom(connection2);
                }
                throw th;
            }
        }

        static {
            Connection connection = new Connection(true);
            defaultInstance = connection;
            connection.initFields();
        }

        public static Connection getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.startTime = 0;
            this.stopTime = 0;
            this.reason = "";
            this.retryTime = 0;
            this.retryCount = 0;
            this.ext = "";
            this.aliasId = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Connection parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Connection parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public long getAliasId() {
            return this.aliasId;
        }

        public String getExt() {
            Object obj = this.ext;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getExtBytes() {
            Object obj = this.ext;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ext = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<Connection> getParserForType() {
            return PARSER;
        }

        public String getReason() {
            Object obj = this.reason;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.reason = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getReasonBytes() {
            Object obj = this.reason;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.reason = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getRetryCount() {
            return this.retryCount;
        }

        public long getRetryTime() {
            return this.retryTime;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeInt64Size(1, this.startTime);
            }
            if ((this.bitField0 & 2) == 2) {
                i3 += CodedOutputStream.computeInt64Size(2, this.stopTime);
            }
            if ((this.bitField0 & 4) == 4) {
                i3 += CodedOutputStream.computeBytesSize(3, getReasonBytes());
            }
            if ((this.bitField0 & 8) == 8) {
                i3 += CodedOutputStream.computeInt64Size(4, this.retryTime);
            }
            if ((this.bitField0 & 16) == 16) {
                i3 += CodedOutputStream.computeInt64Size(5, this.retryCount);
            }
            if ((this.bitField0 & 32) == 32) {
                i3 += CodedOutputStream.computeBytesSize(6, getExtBytes());
            }
            if ((this.bitField0 & 64) == 64) {
                i3 += CodedOutputStream.computeInt64Size(7, this.aliasId);
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public long getStartTime() {
            return this.startTime;
        }

        public long getStopTime() {
            return this.stopTime;
        }

        public boolean hasAliasId() {
            return (this.bitField0 & 64) == 64;
        }

        public boolean hasExt() {
            return (this.bitField0 & 32) == 32;
        }

        public boolean hasReason() {
            return (this.bitField0 & 4) == 4;
        }

        public boolean hasRetryCount() {
            return (this.bitField0 & 16) == 16;
        }

        public boolean hasRetryTime() {
            return (this.bitField0 & 8) == 8;
        }

        public boolean hasStartTime() {
            return (this.bitField0 & 1) == 1;
        }

        public boolean hasStopTime() {
            return (this.bitField0 & 2) == 2;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeInt64(1, this.startTime);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeInt64(2, this.stopTime);
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeBytes(3, getReasonBytes());
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(4, this.retryTime);
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeInt64(5, this.retryCount);
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeBytes(6, getExtBytes());
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeInt64(7, this.aliasId);
            }
        }

        public static Builder newBuilder(Connection connection) {
            return newBuilder().mergeFrom(connection);
        }

        public static Connection parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Connection parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Connection getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Connection(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Connection parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Connection parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Connection parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public Connection(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Connection parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Connection parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Connection parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Connection(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0 |= 1;
                            this.startTime = codedInputStream.readInt64();
                        } else if (readTag == 16) {
                            this.bitField0 |= 2;
                            this.stopTime = codedInputStream.readInt64();
                        } else if (readTag == 26) {
                            this.bitField0 |= 4;
                            this.reason = codedInputStream.readBytes();
                        } else if (readTag == 32) {
                            this.bitField0 |= 8;
                            this.retryTime = codedInputStream.readInt64();
                        } else if (readTag == 40) {
                            this.bitField0 |= 16;
                            this.retryCount = codedInputStream.readInt64();
                        } else if (readTag == 50) {
                            this.bitField0 |= 32;
                            this.ext = codedInputStream.readBytes();
                        } else if (readTag == 56) {
                            this.bitField0 |= 64;
                            this.aliasId = codedInputStream.readInt64();
                        } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    makeExtensionsImmutable();
                    throw th2;
                }
            }
            makeExtensionsImmutable();
        }
    }

    public interface ConnectionOrBuilder extends MessageLiteOrBuilder {
        long getAliasId();

        String getExt();

        ByteString getExtBytes();

        String getReason();

        ByteString getReasonBytes();

        long getRetryCount();

        long getRetryTime();

        long getStartTime();

        long getStopTime();

        boolean hasAliasId();

        boolean hasExt();

        boolean hasReason();

        boolean hasRetryCount();

        boolean hasRetryTime();

        boolean hasStartTime();

        boolean hasStopTime();
    }

    public static final class Crash extends GeneratedMessageLite implements CrashOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 4;
        public static final int EXCEPTION_FIELD_NUMBER = 1;
        public static final int EXT_FIELD_NUMBER = 3;
        public static final Parser<Crash> PARSER = new AbstractParser<Crash>() {
            public Crash parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Crash(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        public static final Crash defaultInstance;
        public static final long serialVersionUID = 0;
        public long aliasId;
        public int bitField0;
        public Object exception;
        public Object ext;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public long timestamp;

        public static final class Builder extends GeneratedMessageLite.Builder<Crash, Builder> implements CrashOrBuilder {
            public long aliasId;
            public int bitField0;
            public Object exception = "";
            public Object ext = "";
            public long timestamp;

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAliasId() {
                this.bitField0 &= -9;
                this.aliasId = 0;
                return this;
            }

            public Builder clearException() {
                this.bitField0 &= -2;
                this.exception = Crash.getDefaultInstance().getException();
                return this;
            }

            public Builder clearExt() {
                this.bitField0 &= -5;
                this.ext = Crash.getDefaultInstance().getExt();
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0 &= -3;
                this.timestamp = 0;
                return this;
            }

            public long getAliasId() {
                return this.aliasId;
            }

            public String getException() {
                Object obj = this.exception;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.exception = stringUtf8;
                return stringUtf8;
            }

            public ByteString getExceptionBytes() {
                Object obj = this.exception;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.exception = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getExt() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ext = stringUtf8;
                return stringUtf8;
            }

            public ByteString getExtBytes() {
                Object obj = this.ext;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext = copyFromUtf8;
                return copyFromUtf8;
            }

            public long getTimestamp() {
                return this.timestamp;
            }

            public boolean hasAliasId() {
                return (this.bitField0 & 8) == 8;
            }

            public boolean hasException() {
                return (this.bitField0 & 1) == 1;
            }

            public boolean hasExt() {
                return (this.bitField0 & 4) == 4;
            }

            public boolean hasTimestamp() {
                return (this.bitField0 & 2) == 2;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setAliasId(long j) {
                this.bitField0 |= 8;
                this.aliasId = j;
                return this;
            }

            public Builder setException(String str) {
                if (str != null) {
                    this.bitField0 |= 1;
                    this.exception = str;
                    return this;
                }
                throw null;
            }

            public Builder setExceptionBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 1;
                    this.exception = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setExt(String str) {
                if (str != null) {
                    this.bitField0 |= 4;
                    this.ext = str;
                    return this;
                }
                throw null;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 4;
                    this.ext = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setTimestamp(long j) {
                this.bitField0 |= 2;
                this.timestamp = j;
                return this;
            }

            public Crash build() {
                Crash buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Crash buildPartial() {
                Crash crash = new Crash((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                Object unused = crash.exception = this.exception;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                long unused2 = crash.timestamp = this.timestamp;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                Object unused3 = crash.ext = this.ext;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                long unused4 = crash.aliasId = this.aliasId;
                int unused5 = crash.bitField0 = i3;
                return crash;
            }

            public Builder clear() {
                super.clear();
                this.exception = "";
                int i2 = this.bitField0 & -2;
                this.bitField0 = i2;
                this.timestamp = 0;
                int i3 = i2 & -3;
                this.bitField0 = i3;
                this.ext = "";
                int i4 = i3 & -5;
                this.bitField0 = i4;
                this.aliasId = 0;
                this.bitField0 = i4 & -9;
                return this;
            }

            public Crash getDefaultInstanceForType() {
                return Crash.getDefaultInstance();
            }

            public Builder mergeFrom(Crash crash) {
                if (crash == Crash.getDefaultInstance()) {
                    return this;
                }
                if (crash.hasException()) {
                    this.bitField0 |= 1;
                    this.exception = crash.exception;
                }
                if (crash.hasTimestamp()) {
                    setTimestamp(crash.getTimestamp());
                }
                if (crash.hasExt()) {
                    this.bitField0 |= 4;
                    this.ext = crash.ext;
                }
                if (crash.hasAliasId()) {
                    setAliasId(crash.getAliasId());
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Crash crash;
                Crash crash2 = null;
                try {
                    Crash parsePartialFrom = Crash.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    crash = (Crash) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    crash2 = crash;
                }
                if (crash2 != null) {
                    mergeFrom(crash2);
                }
                throw th;
            }
        }

        static {
            Crash crash = new Crash(true);
            defaultInstance = crash;
            crash.initFields();
        }

        public static Crash getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.exception = "";
            this.timestamp = 0;
            this.ext = "";
            this.aliasId = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Crash parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Crash parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public long getAliasId() {
            return this.aliasId;
        }

        public String getException() {
            Object obj = this.exception;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.exception = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getExceptionBytes() {
            Object obj = this.exception;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.exception = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getExt() {
            Object obj = this.ext;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getExtBytes() {
            Object obj = this.ext;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ext = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<Crash> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeBytesSize(1, getExceptionBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                i3 += CodedOutputStream.computeInt64Size(2, this.timestamp);
            }
            if ((this.bitField0 & 4) == 4) {
                i3 += CodedOutputStream.computeBytesSize(3, getExtBytes());
            }
            if ((this.bitField0 & 8) == 8) {
                i3 += CodedOutputStream.computeInt64Size(4, this.aliasId);
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public boolean hasAliasId() {
            return (this.bitField0 & 8) == 8;
        }

        public boolean hasException() {
            return (this.bitField0 & 1) == 1;
        }

        public boolean hasExt() {
            return (this.bitField0 & 4) == 4;
        }

        public boolean hasTimestamp() {
            return (this.bitField0 & 2) == 2;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getExceptionBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeInt64(2, this.timestamp);
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeBytes(3, getExtBytes());
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(4, this.aliasId);
            }
        }

        public static Builder newBuilder(Crash crash) {
            return newBuilder().mergeFrom(crash);
        }

        public static Crash parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Crash parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Crash getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Crash(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Crash parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Crash parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Crash parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public Crash(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Crash parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Crash parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Crash parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Crash(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.bitField0 |= 1;
                            this.exception = codedInputStream.readBytes();
                        } else if (readTag == 16) {
                            this.bitField0 |= 2;
                            this.timestamp = codedInputStream.readInt64();
                        } else if (readTag == 26) {
                            this.bitField0 |= 4;
                            this.ext = codedInputStream.readBytes();
                        } else if (readTag == 32) {
                            this.bitField0 |= 8;
                            this.aliasId = codedInputStream.readInt64();
                        } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    makeExtensionsImmutable();
                    throw th2;
                }
            }
            makeExtensionsImmutable();
        }
    }

    public interface CrashOrBuilder extends MessageLiteOrBuilder {
        long getAliasId();

        String getException();

        ByteString getExceptionBytes();

        String getExt();

        ByteString getExtBytes();

        long getTimestamp();

        boolean hasAliasId();

        boolean hasException();

        boolean hasExt();

        boolean hasTimestamp();
    }

    public static final class Db extends GeneratedMessageLite implements DbOrBuilder {
        public static final int ACTION_FIELD_NUMBER = 4;
        public static final int ALIAS_ID_FIELD_NUMBER = 9;
        public static final int CLASS_NAME_FIELD_NUMBER = 2;
        public static final int DURATION_FIELD_NUMBER = 7;
        public static final int END_TIME_FIELD_NUMBER = 6;
        public static final int EXT_FIELD_NUMBER = 8;
        public static final int METHOD_FIELD_NUMBER = 3;
        public static final Parser<Db> PARSER = new AbstractParser<Db>() {
            public Db parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Db(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int START_TIME_FIELD_NUMBER = 5;
        public static final int TABLE_FIELD_NUMBER = 1;
        public static final Db defaultInstance;
        public static final long serialVersionUID = 0;
        public Object action;
        public long aliasId;
        public int bitField0;
        public Object className;
        public long duration;
        public long endTime;
        public Object ext;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object method;
        public long startTime;
        public Object table;

        public static final class Builder extends GeneratedMessageLite.Builder<Db, Builder> implements DbOrBuilder {
            public Object action = "";
            public long aliasId;
            public int bitField0;
            public Object className = "";
            public long duration;
            public long endTime;
            public Object ext = "";
            public Object method = "";
            public long startTime;
            public Object table = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAction() {
                this.bitField0 &= -9;
                this.action = Db.getDefaultInstance().getAction();
                return this;
            }

            public Builder clearAliasId() {
                this.bitField0 &= -257;
                this.aliasId = 0;
                return this;
            }

            public Builder clearClassName() {
                this.bitField0 &= -3;
                this.className = Db.getDefaultInstance().getClassName();
                return this;
            }

            public Builder clearDuration() {
                this.bitField0 &= -65;
                this.duration = 0;
                return this;
            }

            public Builder clearEndTime() {
                this.bitField0 &= -33;
                this.endTime = 0;
                return this;
            }

            public Builder clearExt() {
                this.bitField0 &= -129;
                this.ext = Db.getDefaultInstance().getExt();
                return this;
            }

            public Builder clearMethod() {
                this.bitField0 &= -5;
                this.method = Db.getDefaultInstance().getMethod();
                return this;
            }

            public Builder clearStartTime() {
                this.bitField0 &= -17;
                this.startTime = 0;
                return this;
            }

            public Builder clearTable() {
                this.bitField0 &= -2;
                this.table = Db.getDefaultInstance().getTable();
                return this;
            }

            public String getAction() {
                Object obj = this.action;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.action = stringUtf8;
                return stringUtf8;
            }

            public ByteString getActionBytes() {
                Object obj = this.action;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.action = copyFromUtf8;
                return copyFromUtf8;
            }

            public long getAliasId() {
                return this.aliasId;
            }

            public String getClassName() {
                Object obj = this.className;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.className = stringUtf8;
                return stringUtf8;
            }

            public ByteString getClassNameBytes() {
                Object obj = this.className;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.className = copyFromUtf8;
                return copyFromUtf8;
            }

            public long getDuration() {
                return this.duration;
            }

            public long getEndTime() {
                return this.endTime;
            }

            public String getExt() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ext = stringUtf8;
                return stringUtf8;
            }

            public ByteString getExtBytes() {
                Object obj = this.ext;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getMethod() {
                Object obj = this.method;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.method = stringUtf8;
                return stringUtf8;
            }

            public ByteString getMethodBytes() {
                Object obj = this.method;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.method = copyFromUtf8;
                return copyFromUtf8;
            }

            public long getStartTime() {
                return this.startTime;
            }

            public String getTable() {
                Object obj = this.table;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.table = stringUtf8;
                return stringUtf8;
            }

            public ByteString getTableBytes() {
                Object obj = this.table;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.table = copyFromUtf8;
                return copyFromUtf8;
            }

            public boolean hasAction() {
                return (this.bitField0 & 8) == 8;
            }

            public boolean hasAliasId() {
                return (this.bitField0 & 256) == 256;
            }

            public boolean hasClassName() {
                return (this.bitField0 & 2) == 2;
            }

            public boolean hasDuration() {
                return (this.bitField0 & 64) == 64;
            }

            public boolean hasEndTime() {
                return (this.bitField0 & 32) == 32;
            }

            public boolean hasExt() {
                return (this.bitField0 & 128) == 128;
            }

            public boolean hasMethod() {
                return (this.bitField0 & 4) == 4;
            }

            public boolean hasStartTime() {
                return (this.bitField0 & 16) == 16;
            }

            public boolean hasTable() {
                return (this.bitField0 & 1) == 1;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setAction(String str) {
                if (str != null) {
                    this.bitField0 |= 8;
                    this.action = str;
                    return this;
                }
                throw null;
            }

            public Builder setActionBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 8;
                    this.action = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setAliasId(long j) {
                this.bitField0 |= 256;
                this.aliasId = j;
                return this;
            }

            public Builder setClassName(String str) {
                if (str != null) {
                    this.bitField0 |= 2;
                    this.className = str;
                    return this;
                }
                throw null;
            }

            public Builder setClassNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 2;
                    this.className = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setDuration(long j) {
                this.bitField0 |= 64;
                this.duration = j;
                return this;
            }

            public Builder setEndTime(long j) {
                this.bitField0 |= 32;
                this.endTime = j;
                return this;
            }

            public Builder setExt(String str) {
                if (str != null) {
                    this.bitField0 |= 128;
                    this.ext = str;
                    return this;
                }
                throw null;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 128;
                    this.ext = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setMethod(String str) {
                if (str != null) {
                    this.bitField0 |= 4;
                    this.method = str;
                    return this;
                }
                throw null;
            }

            public Builder setMethodBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 4;
                    this.method = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setStartTime(long j) {
                this.bitField0 |= 16;
                this.startTime = j;
                return this;
            }

            public Builder setTable(String str) {
                if (str != null) {
                    this.bitField0 |= 1;
                    this.table = str;
                    return this;
                }
                throw null;
            }

            public Builder setTableBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 1;
                    this.table = byteString;
                    return this;
                }
                throw null;
            }

            public Db build() {
                Db buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Db buildPartial() {
                Db db = new Db((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                Object unused = db.table = this.table;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Object unused2 = db.className = this.className;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                Object unused3 = db.method = this.method;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                Object unused4 = db.action = this.action;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                long unused5 = db.startTime = this.startTime;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                long unused6 = db.endTime = this.endTime;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                long unused7 = db.duration = this.duration;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                Object unused8 = db.ext = this.ext;
                if ((i2 & 256) == 256) {
                    i3 |= 256;
                }
                long unused9 = db.aliasId = this.aliasId;
                int unused10 = db.bitField0 = i3;
                return db;
            }

            public Builder clear() {
                super.clear();
                this.table = "";
                int i2 = this.bitField0 & -2;
                this.bitField0 = i2;
                this.className = "";
                int i3 = i2 & -3;
                this.bitField0 = i3;
                this.method = "";
                int i4 = i3 & -5;
                this.bitField0 = i4;
                this.action = "";
                int i5 = i4 & -9;
                this.bitField0 = i5;
                this.startTime = 0;
                int i6 = i5 & -17;
                this.bitField0 = i6;
                this.endTime = 0;
                int i7 = i6 & -33;
                this.bitField0 = i7;
                this.duration = 0;
                int i8 = i7 & -65;
                this.bitField0 = i8;
                this.ext = "";
                int i9 = i8 & -129;
                this.bitField0 = i9;
                this.aliasId = 0;
                this.bitField0 = i9 & -257;
                return this;
            }

            public Db getDefaultInstanceForType() {
                return Db.getDefaultInstance();
            }

            public Builder mergeFrom(Db db) {
                if (db == Db.getDefaultInstance()) {
                    return this;
                }
                if (db.hasTable()) {
                    this.bitField0 |= 1;
                    this.table = db.table;
                }
                if (db.hasClassName()) {
                    this.bitField0 |= 2;
                    this.className = db.className;
                }
                if (db.hasMethod()) {
                    this.bitField0 |= 4;
                    this.method = db.method;
                }
                if (db.hasAction()) {
                    this.bitField0 |= 8;
                    this.action = db.action;
                }
                if (db.hasStartTime()) {
                    setStartTime(db.getStartTime());
                }
                if (db.hasEndTime()) {
                    setEndTime(db.getEndTime());
                }
                if (db.hasDuration()) {
                    setDuration(db.getDuration());
                }
                if (db.hasExt()) {
                    this.bitField0 |= 128;
                    this.ext = db.ext;
                }
                if (db.hasAliasId()) {
                    setAliasId(db.getAliasId());
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Db db;
                Db db2 = null;
                try {
                    Db parsePartialFrom = Db.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    db = (Db) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    db2 = db;
                }
                if (db2 != null) {
                    mergeFrom(db2);
                }
                throw th;
            }
        }

        static {
            Db db = new Db(true);
            defaultInstance = db;
            db.initFields();
        }

        public static Db getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.table = "";
            this.className = "";
            this.method = "";
            this.action = "";
            this.startTime = 0;
            this.endTime = 0;
            this.duration = 0;
            this.ext = "";
            this.aliasId = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Db parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Db parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public String getAction() {
            Object obj = this.action;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.action = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getActionBytes() {
            Object obj = this.action;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.action = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getAliasId() {
            return this.aliasId;
        }

        public String getClassName() {
            Object obj = this.className;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.className = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getClassNameBytes() {
            Object obj = this.className;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.className = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getDuration() {
            return this.duration;
        }

        public long getEndTime() {
            return this.endTime;
        }

        public String getExt() {
            Object obj = this.ext;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getExtBytes() {
            Object obj = this.ext;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ext = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getMethod() {
            Object obj = this.method;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.method = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getMethodBytes() {
            Object obj = this.method;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.method = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<Db> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeBytesSize(1, getTableBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                i3 += CodedOutputStream.computeBytesSize(2, getClassNameBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                i3 += CodedOutputStream.computeBytesSize(3, getMethodBytes());
            }
            if ((this.bitField0 & 8) == 8) {
                i3 += CodedOutputStream.computeBytesSize(4, getActionBytes());
            }
            if ((this.bitField0 & 16) == 16) {
                i3 += CodedOutputStream.computeInt64Size(5, this.startTime);
            }
            if ((this.bitField0 & 32) == 32) {
                i3 += CodedOutputStream.computeInt64Size(6, this.endTime);
            }
            if ((this.bitField0 & 64) == 64) {
                i3 += CodedOutputStream.computeInt64Size(7, this.duration);
            }
            if ((this.bitField0 & 128) == 128) {
                i3 += CodedOutputStream.computeBytesSize(8, getExtBytes());
            }
            if ((this.bitField0 & 256) == 256) {
                i3 += CodedOutputStream.computeInt64Size(9, this.aliasId);
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public long getStartTime() {
            return this.startTime;
        }

        public String getTable() {
            Object obj = this.table;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.table = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getTableBytes() {
            Object obj = this.table;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.table = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasAction() {
            return (this.bitField0 & 8) == 8;
        }

        public boolean hasAliasId() {
            return (this.bitField0 & 256) == 256;
        }

        public boolean hasClassName() {
            return (this.bitField0 & 2) == 2;
        }

        public boolean hasDuration() {
            return (this.bitField0 & 64) == 64;
        }

        public boolean hasEndTime() {
            return (this.bitField0 & 32) == 32;
        }

        public boolean hasExt() {
            return (this.bitField0 & 128) == 128;
        }

        public boolean hasMethod() {
            return (this.bitField0 & 4) == 4;
        }

        public boolean hasStartTime() {
            return (this.bitField0 & 16) == 16;
        }

        public boolean hasTable() {
            return (this.bitField0 & 1) == 1;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getTableBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getClassNameBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeBytes(3, getMethodBytes());
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeBytes(4, getActionBytes());
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeInt64(5, this.startTime);
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeInt64(6, this.endTime);
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeInt64(7, this.duration);
            }
            if ((this.bitField0 & 128) == 128) {
                codedOutputStream.writeBytes(8, getExtBytes());
            }
            if ((this.bitField0 & 256) == 256) {
                codedOutputStream.writeInt64(9, this.aliasId);
            }
        }

        public static Builder newBuilder(Db db) {
            return newBuilder().mergeFrom(db);
        }

        public static Db parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Db parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Db getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Db(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Db parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Db parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Db parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public Db(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Db parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Db parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Db parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Db(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.bitField0 |= 1;
                            this.table = codedInputStream.readBytes();
                        } else if (readTag == 18) {
                            this.bitField0 |= 2;
                            this.className = codedInputStream.readBytes();
                        } else if (readTag == 26) {
                            this.bitField0 |= 4;
                            this.method = codedInputStream.readBytes();
                        } else if (readTag == 34) {
                            this.bitField0 |= 8;
                            this.action = codedInputStream.readBytes();
                        } else if (readTag == 40) {
                            this.bitField0 |= 16;
                            this.startTime = codedInputStream.readInt64();
                        } else if (readTag == 48) {
                            this.bitField0 |= 32;
                            this.endTime = codedInputStream.readInt64();
                        } else if (readTag == 56) {
                            this.bitField0 |= 64;
                            this.duration = codedInputStream.readInt64();
                        } else if (readTag == 66) {
                            this.bitField0 |= 128;
                            this.ext = codedInputStream.readBytes();
                        } else if (readTag == 72) {
                            this.bitField0 |= 256;
                            this.aliasId = codedInputStream.readInt64();
                        } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    makeExtensionsImmutable();
                    throw th2;
                }
            }
            makeExtensionsImmutable();
        }
    }

    public interface DbOrBuilder extends MessageLiteOrBuilder {
        String getAction();

        ByteString getActionBytes();

        long getAliasId();

        String getClassName();

        ByteString getClassNameBytes();

        long getDuration();

        long getEndTime();

        String getExt();

        ByteString getExtBytes();

        String getMethod();

        ByteString getMethodBytes();

        long getStartTime();

        String getTable();

        ByteString getTableBytes();

        boolean hasAction();

        boolean hasAliasId();

        boolean hasClassName();

        boolean hasDuration();

        boolean hasEndTime();

        boolean hasExt();

        boolean hasMethod();

        boolean hasStartTime();

        boolean hasTable();
    }

    public static final class DeviceID extends GeneratedMessageLite implements DeviceIDOrBuilder {
        public static final int CUID_FIELD_NUMBER = 4;
        public static final Parser<DeviceID> PARSER = new AbstractParser<DeviceID>() {
            public DeviceID parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new DeviceID(codedInputStream, extensionRegistryLite);
            }
        };
        public static final DeviceID defaultInstance;
        public static final long serialVersionUID = 0;
        public int bitField0;
        public Object cuid;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;

        public static final class Builder extends GeneratedMessageLite.Builder<DeviceID, Builder> implements DeviceIDOrBuilder {
            public int bitField0;
            public Object cuid = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearCuid() {
                this.bitField0 &= -2;
                this.cuid = DeviceID.getDefaultInstance().getCuid();
                return this;
            }

            public String getCuid() {
                Object obj = this.cuid;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.cuid = stringUtf8;
                return stringUtf8;
            }

            public ByteString getCuidBytes() {
                Object obj = this.cuid;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.cuid = copyFromUtf8;
                return copyFromUtf8;
            }

            public boolean hasCuid() {
                return (this.bitField0 & 1) == 1;
            }

            public final boolean isInitialized() {
                return hasCuid();
            }

            public Builder setCuid(String str) {
                if (str != null) {
                    this.bitField0 |= 1;
                    this.cuid = str;
                    return this;
                }
                throw null;
            }

            public Builder setCuidBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 1;
                    this.cuid = byteString;
                    return this;
                }
                throw null;
            }

            public DeviceID build() {
                DeviceID buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public DeviceID buildPartial() {
                DeviceID deviceID = new DeviceID((GeneratedMessageLite.Builder) this);
                int i2 = 1;
                if ((this.bitField0 & 1) != 1) {
                    i2 = 0;
                }
                Object unused = deviceID.cuid = this.cuid;
                int unused2 = deviceID.bitField0 = i2;
                return deviceID;
            }

            public Builder clear() {
                super.clear();
                this.cuid = "";
                this.bitField0 &= -2;
                return this;
            }

            public DeviceID getDefaultInstanceForType() {
                return DeviceID.getDefaultInstance();
            }

            public Builder mergeFrom(DeviceID deviceID) {
                if (deviceID != DeviceID.getDefaultInstance() && deviceID.hasCuid()) {
                    this.bitField0 |= 1;
                    this.cuid = deviceID.cuid;
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                DeviceID deviceID;
                DeviceID deviceID2 = null;
                try {
                    DeviceID parsePartialFrom = DeviceID.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    deviceID = (DeviceID) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    deviceID2 = deviceID;
                }
                if (deviceID2 != null) {
                    mergeFrom(deviceID2);
                }
                throw th;
            }
        }

        static {
            DeviceID deviceID = new DeviceID(true);
            defaultInstance = deviceID;
            deviceID.initFields();
        }

        public static DeviceID getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.cuid = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static DeviceID parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static DeviceID parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public String getCuid() {
            Object obj = this.cuid;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.cuid = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getCuidBytes() {
            Object obj = this.cuid;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.cuid = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<DeviceID> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeBytesSize(4, getCuidBytes());
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public boolean hasCuid() {
            return (this.bitField0 & 1) == 1;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            if (!hasCuid()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(4, getCuidBytes());
            }
        }

        public static Builder newBuilder(DeviceID deviceID) {
            return newBuilder().mergeFrom(deviceID);
        }

        public static DeviceID parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static DeviceID parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public DeviceID getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public DeviceID(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static DeviceID parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static DeviceID parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static DeviceID parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public DeviceID(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static DeviceID parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static DeviceID parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static DeviceID parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public DeviceID(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 34) {
                            this.bitField0 |= 1;
                            this.cuid = codedInputStream.readBytes();
                        } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    makeExtensionsImmutable();
                    throw th2;
                }
            }
            makeExtensionsImmutable();
        }
    }

    public interface DeviceIDOrBuilder extends MessageLiteOrBuilder {
        String getCuid();

        ByteString getCuidBytes();

        boolean hasCuid();
    }

    public static final class MetaData extends GeneratedMessageLite implements MetaDataOrBuilder {
        public static final int LOG_MODULE_ID_FIELD_NUMBER = 1;
        public static final int LOG_NAME_FIELD_NUMBER = 2;
        public static final Parser<MetaData> PARSER = new AbstractParser<MetaData>() {
            public MetaData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MetaData(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PRODUCT_NAME_FIELD_NUMBER = 3;
        public static final MetaData defaultInstance;
        public static final long serialVersionUID = 0;
        public int bitField0;
        public int logModuleId;
        public Object logName;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object productName;

        public static final class Builder extends GeneratedMessageLite.Builder<MetaData, Builder> implements MetaDataOrBuilder {
            public int bitField0;
            public int logModuleId = 7399;
            public Object logName = "push_im_client";
            public Object productName = "phonebaidu";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearLogModuleId() {
                this.bitField0 &= -2;
                this.logModuleId = 7399;
                return this;
            }

            public Builder clearLogName() {
                this.bitField0 &= -3;
                this.logName = MetaData.getDefaultInstance().getLogName();
                return this;
            }

            public Builder clearProductName() {
                this.bitField0 &= -5;
                this.productName = MetaData.getDefaultInstance().getProductName();
                return this;
            }

            public int getLogModuleId() {
                return this.logModuleId;
            }

            public String getLogName() {
                Object obj = this.logName;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.logName = stringUtf8;
                return stringUtf8;
            }

            public ByteString getLogNameBytes() {
                Object obj = this.logName;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.logName = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getProductName() {
                Object obj = this.productName;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.productName = stringUtf8;
                return stringUtf8;
            }

            public ByteString getProductNameBytes() {
                Object obj = this.productName;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.productName = copyFromUtf8;
                return copyFromUtf8;
            }

            public boolean hasLogModuleId() {
                return (this.bitField0 & 1) == 1;
            }

            public boolean hasLogName() {
                return (this.bitField0 & 2) == 2;
            }

            public boolean hasProductName() {
                return (this.bitField0 & 4) == 4;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setLogModuleId(int i2) {
                this.bitField0 |= 1;
                this.logModuleId = i2;
                return this;
            }

            public Builder setLogName(String str) {
                if (str != null) {
                    this.bitField0 |= 2;
                    this.logName = str;
                    return this;
                }
                throw null;
            }

            public Builder setLogNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 2;
                    this.logName = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setProductName(String str) {
                if (str != null) {
                    this.bitField0 |= 4;
                    this.productName = str;
                    return this;
                }
                throw null;
            }

            public Builder setProductNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 4;
                    this.productName = byteString;
                    return this;
                }
                throw null;
            }

            public MetaData build() {
                MetaData buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public MetaData buildPartial() {
                MetaData metaData = new MetaData((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                int unused = metaData.logModuleId = this.logModuleId;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Object unused2 = metaData.logName = this.logName;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                Object unused3 = metaData.productName = this.productName;
                int unused4 = metaData.bitField0 = i3;
                return metaData;
            }

            public Builder clear() {
                super.clear();
                this.logModuleId = 7399;
                int i2 = this.bitField0 & -2;
                this.bitField0 = i2;
                this.logName = "push_im_client";
                int i3 = i2 & -3;
                this.bitField0 = i3;
                this.productName = "phonebaidu";
                this.bitField0 = i3 & -5;
                return this;
            }

            public MetaData getDefaultInstanceForType() {
                return MetaData.getDefaultInstance();
            }

            public Builder mergeFrom(MetaData metaData) {
                if (metaData == MetaData.getDefaultInstance()) {
                    return this;
                }
                if (metaData.hasLogModuleId()) {
                    setLogModuleId(metaData.getLogModuleId());
                }
                if (metaData.hasLogName()) {
                    this.bitField0 |= 2;
                    this.logName = metaData.logName;
                }
                if (metaData.hasProductName()) {
                    this.bitField0 |= 4;
                    this.productName = metaData.productName;
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                MetaData metaData;
                MetaData metaData2 = null;
                try {
                    MetaData parsePartialFrom = MetaData.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    metaData = (MetaData) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    metaData2 = metaData;
                }
                if (metaData2 != null) {
                    mergeFrom(metaData2);
                }
                throw th;
            }
        }

        static {
            MetaData metaData = new MetaData(true);
            defaultInstance = metaData;
            metaData.initFields();
        }

        public static MetaData getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.logModuleId = 7399;
            this.logName = "push_im_client";
            this.productName = "phonebaidu";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static MetaData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static MetaData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public int getLogModuleId() {
            return this.logModuleId;
        }

        public String getLogName() {
            Object obj = this.logName;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.logName = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getLogNameBytes() {
            Object obj = this.logName;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.logName = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<MetaData> getParserForType() {
            return PARSER;
        }

        public String getProductName() {
            Object obj = this.productName;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.productName = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getProductNameBytes() {
            Object obj = this.productName;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.productName = copyFromUtf8;
            return copyFromUtf8;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeInt32Size(1, this.logModuleId);
            }
            if ((this.bitField0 & 2) == 2) {
                i3 += CodedOutputStream.computeBytesSize(2, getLogNameBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                i3 += CodedOutputStream.computeBytesSize(3, getProductNameBytes());
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public boolean hasLogModuleId() {
            return (this.bitField0 & 1) == 1;
        }

        public boolean hasLogName() {
            return (this.bitField0 & 2) == 2;
        }

        public boolean hasProductName() {
            return (this.bitField0 & 4) == 4;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeInt32(1, this.logModuleId);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getLogNameBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeBytes(3, getProductNameBytes());
            }
        }

        public static Builder newBuilder(MetaData metaData) {
            return newBuilder().mergeFrom(metaData);
        }

        public static MetaData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static MetaData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public MetaData getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public MetaData(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static MetaData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static MetaData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static MetaData parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public MetaData(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static MetaData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static MetaData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static MetaData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public MetaData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0 |= 1;
                            this.logModuleId = codedInputStream.readInt32();
                        } else if (readTag == 18) {
                            this.bitField0 |= 2;
                            this.logName = codedInputStream.readBytes();
                        } else if (readTag == 26) {
                            this.bitField0 |= 4;
                            this.productName = codedInputStream.readBytes();
                        } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    makeExtensionsImmutable();
                    throw th2;
                }
            }
            makeExtensionsImmutable();
        }
    }

    public interface MetaDataOrBuilder extends MessageLiteOrBuilder {
        int getLogModuleId();

        String getLogName();

        ByteString getLogNameBytes();

        String getProductName();

        ByteString getProductNameBytes();

        boolean hasLogModuleId();

        boolean hasLogName();

        boolean hasProductName();
    }

    public static final class Msg extends GeneratedMessageLite implements MsgOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 6;
        public static final int DURATION_FIELD_NUMBER = 3;
        public static final int END_MSGID_FIELD_NUMBER = 4;
        public static final int EXT_FIELD_NUMBER = 5;
        public static final int MSG_COUNT_FIELD_NUMBER = 1;
        public static final Parser<Msg> PARSER = new AbstractParser<Msg>() {
            public Msg parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Msg(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int ROOM_ID_FIELD_NUMBER = 2;
        public static final int START_MSGID_FIELD_NUMBER = 7;
        public static final Msg defaultInstance;
        public static final long serialVersionUID = 0;
        public long aliasId;
        public int bitField0;
        public long duration;
        public long endMsgid;
        public Object ext;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public long msgCount;
        public Object roomId;
        public long startMsgid;

        public static final class Builder extends GeneratedMessageLite.Builder<Msg, Builder> implements MsgOrBuilder {
            public long aliasId;
            public int bitField0;
            public long duration;
            public long endMsgid;
            public Object ext = "";
            public long msgCount;
            public Object roomId = "";
            public long startMsgid;

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAliasId() {
                this.bitField0 &= -33;
                this.aliasId = 0;
                return this;
            }

            public Builder clearDuration() {
                this.bitField0 &= -5;
                this.duration = 0;
                return this;
            }

            public Builder clearEndMsgid() {
                this.bitField0 &= -9;
                this.endMsgid = 0;
                return this;
            }

            public Builder clearExt() {
                this.bitField0 &= -17;
                this.ext = Msg.getDefaultInstance().getExt();
                return this;
            }

            public Builder clearMsgCount() {
                this.bitField0 &= -2;
                this.msgCount = 0;
                return this;
            }

            public Builder clearRoomId() {
                this.bitField0 &= -3;
                this.roomId = Msg.getDefaultInstance().getRoomId();
                return this;
            }

            public Builder clearStartMsgid() {
                this.bitField0 &= -65;
                this.startMsgid = 0;
                return this;
            }

            public long getAliasId() {
                return this.aliasId;
            }

            public long getDuration() {
                return this.duration;
            }

            public long getEndMsgid() {
                return this.endMsgid;
            }

            public String getExt() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ext = stringUtf8;
                return stringUtf8;
            }

            public ByteString getExtBytes() {
                Object obj = this.ext;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext = copyFromUtf8;
                return copyFromUtf8;
            }

            public long getMsgCount() {
                return this.msgCount;
            }

            public String getRoomId() {
                Object obj = this.roomId;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.roomId = stringUtf8;
                return stringUtf8;
            }

            public ByteString getRoomIdBytes() {
                Object obj = this.roomId;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.roomId = copyFromUtf8;
                return copyFromUtf8;
            }

            public long getStartMsgid() {
                return this.startMsgid;
            }

            public boolean hasAliasId() {
                return (this.bitField0 & 32) == 32;
            }

            public boolean hasDuration() {
                return (this.bitField0 & 4) == 4;
            }

            public boolean hasEndMsgid() {
                return (this.bitField0 & 8) == 8;
            }

            public boolean hasExt() {
                return (this.bitField0 & 16) == 16;
            }

            public boolean hasMsgCount() {
                return (this.bitField0 & 1) == 1;
            }

            public boolean hasRoomId() {
                return (this.bitField0 & 2) == 2;
            }

            public boolean hasStartMsgid() {
                return (this.bitField0 & 64) == 64;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setAliasId(long j) {
                this.bitField0 |= 32;
                this.aliasId = j;
                return this;
            }

            public Builder setDuration(long j) {
                this.bitField0 |= 4;
                this.duration = j;
                return this;
            }

            public Builder setEndMsgid(long j) {
                this.bitField0 |= 8;
                this.endMsgid = j;
                return this;
            }

            public Builder setExt(String str) {
                if (str != null) {
                    this.bitField0 |= 16;
                    this.ext = str;
                    return this;
                }
                throw null;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 16;
                    this.ext = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setMsgCount(long j) {
                this.bitField0 |= 1;
                this.msgCount = j;
                return this;
            }

            public Builder setRoomId(String str) {
                if (str != null) {
                    this.bitField0 |= 2;
                    this.roomId = str;
                    return this;
                }
                throw null;
            }

            public Builder setRoomIdBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 2;
                    this.roomId = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setStartMsgid(long j) {
                this.bitField0 |= 64;
                this.startMsgid = j;
                return this;
            }

            public Msg build() {
                Msg buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Msg buildPartial() {
                Msg msg = new Msg((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                long unused = msg.msgCount = this.msgCount;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Object unused2 = msg.roomId = this.roomId;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                long unused3 = msg.duration = this.duration;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                long unused4 = msg.endMsgid = this.endMsgid;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                Object unused5 = msg.ext = this.ext;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                long unused6 = msg.aliasId = this.aliasId;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                long unused7 = msg.startMsgid = this.startMsgid;
                int unused8 = msg.bitField0 = i3;
                return msg;
            }

            public Builder clear() {
                super.clear();
                this.msgCount = 0;
                int i2 = this.bitField0 & -2;
                this.bitField0 = i2;
                this.roomId = "";
                int i3 = i2 & -3;
                this.bitField0 = i3;
                this.duration = 0;
                int i4 = i3 & -5;
                this.bitField0 = i4;
                this.endMsgid = 0;
                int i5 = i4 & -9;
                this.bitField0 = i5;
                this.ext = "";
                int i6 = i5 & -17;
                this.bitField0 = i6;
                this.aliasId = 0;
                int i7 = i6 & -33;
                this.bitField0 = i7;
                this.startMsgid = 0;
                this.bitField0 = i7 & -65;
                return this;
            }

            public Msg getDefaultInstanceForType() {
                return Msg.getDefaultInstance();
            }

            public Builder mergeFrom(Msg msg) {
                if (msg == Msg.getDefaultInstance()) {
                    return this;
                }
                if (msg.hasMsgCount()) {
                    setMsgCount(msg.getMsgCount());
                }
                if (msg.hasRoomId()) {
                    this.bitField0 |= 2;
                    this.roomId = msg.roomId;
                }
                if (msg.hasDuration()) {
                    setDuration(msg.getDuration());
                }
                if (msg.hasEndMsgid()) {
                    setEndMsgid(msg.getEndMsgid());
                }
                if (msg.hasExt()) {
                    this.bitField0 |= 16;
                    this.ext = msg.ext;
                }
                if (msg.hasAliasId()) {
                    setAliasId(msg.getAliasId());
                }
                if (msg.hasStartMsgid()) {
                    setStartMsgid(msg.getStartMsgid());
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Msg msg;
                Msg msg2 = null;
                try {
                    Msg parsePartialFrom = Msg.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    msg = (Msg) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    msg2 = msg;
                }
                if (msg2 != null) {
                    mergeFrom(msg2);
                }
                throw th;
            }
        }

        static {
            Msg msg = new Msg(true);
            defaultInstance = msg;
            msg.initFields();
        }

        public static Msg getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.msgCount = 0;
            this.roomId = "";
            this.duration = 0;
            this.endMsgid = 0;
            this.ext = "";
            this.aliasId = 0;
            this.startMsgid = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Msg parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Msg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public long getAliasId() {
            return this.aliasId;
        }

        public long getDuration() {
            return this.duration;
        }

        public long getEndMsgid() {
            return this.endMsgid;
        }

        public String getExt() {
            Object obj = this.ext;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getExtBytes() {
            Object obj = this.ext;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ext = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getMsgCount() {
            return this.msgCount;
        }

        public Parser<Msg> getParserForType() {
            return PARSER;
        }

        public String getRoomId() {
            Object obj = this.roomId;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.roomId = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getRoomIdBytes() {
            Object obj = this.roomId;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.roomId = copyFromUtf8;
            return copyFromUtf8;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeInt64Size(1, this.msgCount);
            }
            if ((this.bitField0 & 2) == 2) {
                i3 += CodedOutputStream.computeBytesSize(2, getRoomIdBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                i3 += CodedOutputStream.computeInt64Size(3, this.duration);
            }
            if ((this.bitField0 & 8) == 8) {
                i3 += CodedOutputStream.computeInt64Size(4, this.endMsgid);
            }
            if ((this.bitField0 & 16) == 16) {
                i3 += CodedOutputStream.computeBytesSize(5, getExtBytes());
            }
            if ((this.bitField0 & 32) == 32) {
                i3 += CodedOutputStream.computeInt64Size(6, this.aliasId);
            }
            if ((this.bitField0 & 64) == 64) {
                i3 += CodedOutputStream.computeInt64Size(7, this.startMsgid);
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public long getStartMsgid() {
            return this.startMsgid;
        }

        public boolean hasAliasId() {
            return (this.bitField0 & 32) == 32;
        }

        public boolean hasDuration() {
            return (this.bitField0 & 4) == 4;
        }

        public boolean hasEndMsgid() {
            return (this.bitField0 & 8) == 8;
        }

        public boolean hasExt() {
            return (this.bitField0 & 16) == 16;
        }

        public boolean hasMsgCount() {
            return (this.bitField0 & 1) == 1;
        }

        public boolean hasRoomId() {
            return (this.bitField0 & 2) == 2;
        }

        public boolean hasStartMsgid() {
            return (this.bitField0 & 64) == 64;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeInt64(1, this.msgCount);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getRoomIdBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeInt64(3, this.duration);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(4, this.endMsgid);
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeBytes(5, getExtBytes());
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeInt64(6, this.aliasId);
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeInt64(7, this.startMsgid);
            }
        }

        public static Builder newBuilder(Msg msg) {
            return newBuilder().mergeFrom(msg);
        }

        public static Msg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Msg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Msg getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Msg(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Msg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Msg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Msg parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public Msg(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Msg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Msg parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Msg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Msg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0 |= 1;
                            this.msgCount = codedInputStream.readInt64();
                        } else if (readTag == 18) {
                            this.bitField0 |= 2;
                            this.roomId = codedInputStream.readBytes();
                        } else if (readTag == 24) {
                            this.bitField0 |= 4;
                            this.duration = codedInputStream.readInt64();
                        } else if (readTag == 32) {
                            this.bitField0 |= 8;
                            this.endMsgid = codedInputStream.readInt64();
                        } else if (readTag == 42) {
                            this.bitField0 |= 16;
                            this.ext = codedInputStream.readBytes();
                        } else if (readTag == 48) {
                            this.bitField0 |= 32;
                            this.aliasId = codedInputStream.readInt64();
                        } else if (readTag == 56) {
                            this.bitField0 |= 64;
                            this.startMsgid = codedInputStream.readInt64();
                        } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    makeExtensionsImmutable();
                    throw th2;
                }
            }
            makeExtensionsImmutable();
        }
    }

    public interface MsgOrBuilder extends MessageLiteOrBuilder {
        long getAliasId();

        long getDuration();

        long getEndMsgid();

        String getExt();

        ByteString getExtBytes();

        long getMsgCount();

        String getRoomId();

        ByteString getRoomIdBytes();

        long getStartMsgid();

        boolean hasAliasId();

        boolean hasDuration();

        boolean hasEndMsgid();

        boolean hasExt();

        boolean hasMsgCount();

        boolean hasRoomId();

        boolean hasStartMsgid();
    }

    public static final class NetInfo extends GeneratedMessageLite implements NetInfoOrBuilder {
        public static final int NET_APN_FIELD_NUMBER = 2;
        public static final int NET_TYPE_FIELD_NUMBER = 1;
        public static final Parser<NetInfo> PARSER = new AbstractParser<NetInfo>() {
            public NetInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new NetInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final NetInfo defaultInstance;
        public static final long serialVersionUID = 0;
        public int bitField0;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object netApn;
        public Object netType;

        public static final class Builder extends GeneratedMessageLite.Builder<NetInfo, Builder> implements NetInfoOrBuilder {
            public int bitField0;
            public Object netApn = "";
            public Object netType = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearNetApn() {
                this.bitField0 &= -3;
                this.netApn = NetInfo.getDefaultInstance().getNetApn();
                return this;
            }

            public Builder clearNetType() {
                this.bitField0 &= -2;
                this.netType = NetInfo.getDefaultInstance().getNetType();
                return this;
            }

            public String getNetApn() {
                Object obj = this.netApn;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.netApn = stringUtf8;
                return stringUtf8;
            }

            public ByteString getNetApnBytes() {
                Object obj = this.netApn;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.netApn = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getNetType() {
                Object obj = this.netType;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.netType = stringUtf8;
                return stringUtf8;
            }

            public ByteString getNetTypeBytes() {
                Object obj = this.netType;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.netType = copyFromUtf8;
                return copyFromUtf8;
            }

            public boolean hasNetApn() {
                return (this.bitField0 & 2) == 2;
            }

            public boolean hasNetType() {
                return (this.bitField0 & 1) == 1;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setNetApn(String str) {
                if (str != null) {
                    this.bitField0 |= 2;
                    this.netApn = str;
                    return this;
                }
                throw null;
            }

            public Builder setNetApnBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 2;
                    this.netApn = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setNetType(String str) {
                if (str != null) {
                    this.bitField0 |= 1;
                    this.netType = str;
                    return this;
                }
                throw null;
            }

            public Builder setNetTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 1;
                    this.netType = byteString;
                    return this;
                }
                throw null;
            }

            public NetInfo build() {
                NetInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public NetInfo buildPartial() {
                NetInfo netInfo = new NetInfo((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                Object unused = netInfo.netType = this.netType;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Object unused2 = netInfo.netApn = this.netApn;
                int unused3 = netInfo.bitField0 = i3;
                return netInfo;
            }

            public Builder clear() {
                super.clear();
                this.netType = "";
                int i2 = this.bitField0 & -2;
                this.bitField0 = i2;
                this.netApn = "";
                this.bitField0 = i2 & -3;
                return this;
            }

            public NetInfo getDefaultInstanceForType() {
                return NetInfo.getDefaultInstance();
            }

            public Builder mergeFrom(NetInfo netInfo) {
                if (netInfo == NetInfo.getDefaultInstance()) {
                    return this;
                }
                if (netInfo.hasNetType()) {
                    this.bitField0 |= 1;
                    this.netType = netInfo.netType;
                }
                if (netInfo.hasNetApn()) {
                    this.bitField0 |= 2;
                    this.netApn = netInfo.netApn;
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                NetInfo netInfo;
                NetInfo netInfo2 = null;
                try {
                    NetInfo parsePartialFrom = NetInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    netInfo = (NetInfo) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    netInfo2 = netInfo;
                }
                if (netInfo2 != null) {
                    mergeFrom(netInfo2);
                }
                throw th;
            }
        }

        static {
            NetInfo netInfo = new NetInfo(true);
            defaultInstance = netInfo;
            netInfo.initFields();
        }

        public static NetInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.netType = "";
            this.netApn = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static NetInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static NetInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public String getNetApn() {
            Object obj = this.netApn;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.netApn = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNetApnBytes() {
            Object obj = this.netApn;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.netApn = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getNetType() {
            Object obj = this.netType;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.netType = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNetTypeBytes() {
            Object obj = this.netType;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.netType = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<NetInfo> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeBytesSize(1, getNetTypeBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                i3 += CodedOutputStream.computeBytesSize(2, getNetApnBytes());
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public boolean hasNetApn() {
            return (this.bitField0 & 2) == 2;
        }

        public boolean hasNetType() {
            return (this.bitField0 & 1) == 1;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getNetTypeBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getNetApnBytes());
            }
        }

        public static Builder newBuilder(NetInfo netInfo) {
            return newBuilder().mergeFrom(netInfo);
        }

        public static NetInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static NetInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public NetInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public NetInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static NetInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static NetInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static NetInfo parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public NetInfo(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static NetInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static NetInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static NetInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public NetInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.bitField0 |= 1;
                            this.netType = codedInputStream.readBytes();
                        } else if (readTag == 18) {
                            this.bitField0 |= 2;
                            this.netApn = codedInputStream.readBytes();
                        } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    makeExtensionsImmutable();
                    throw th2;
                }
            }
            makeExtensionsImmutable();
        }
    }

    public interface NetInfoOrBuilder extends MessageLiteOrBuilder {
        String getNetApn();

        ByteString getNetApnBytes();

        String getNetType();

        ByteString getNetTypeBytes();

        boolean hasNetApn();

        boolean hasNetType();
    }

    public enum OSType implements Internal.EnumLite {
        OS_TYPE_UNKNWON(0, 0),
        IOS(1, 1),
        ANDROID(2, 2),
        WINDOWSPHONE(3, 3);
        
        public static final int ANDROID_VALUE = 2;
        public static final int IOS_VALUE = 1;
        public static final int OS_TYPE_UNKNWON_VALUE = 0;
        public static final int WINDOWSPHONE_VALUE = 3;
        public static Internal.EnumLiteMap<OSType> internalValueMap;
        public final int value;

        /* access modifiers changed from: public */
        static {
            internalValueMap = new Internal.EnumLiteMap<OSType>() {
                public OSType findValueByNumber(int i2) {
                    return OSType.valueOf(i2);
                }
            };
        }

        /* access modifiers changed from: public */
        OSType(int i2, int i3) {
            this.value = i3;
        }

        public static Internal.EnumLiteMap<OSType> internalGetValueMap() {
            return internalValueMap;
        }

        public final int getNumber() {
            return this.value;
        }

        public static OSType valueOf(int i2) {
            if (i2 == 0) {
                return OS_TYPE_UNKNWON;
            }
            if (i2 == 1) {
                return IOS;
            }
            if (i2 == 2) {
                return ANDROID;
            }
            if (i2 != 3) {
                return null;
            }
            return WINDOWSPHONE;
        }
    }

    public static final class PushImClient extends GeneratedMessageLite implements PushImClientOrBuilder {
        public static final int ACTIONS_FIELD_NUMBER = 132;
        public static final int COMMON_FIELD_NUMBER = 41;
        public static final int METADATA_FIELD_NUMBER = 25;
        public static final Parser<PushImClient> PARSER = new AbstractParser<PushImClient>() {
            public PushImClient parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PushImClient(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int SDK_NAME_FIELD_NUMBER = 130;
        public static final int SDK_VERSION_FIELD_NUMBER = 131;
        public static final PushImClient defaultInstance;
        public static final long serialVersionUID = 0;
        public List<Action> actions;
        public int bitField0;
        public Common common;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public MetaData metadata;
        public Object sdkName;
        public long sdkVersion;

        public static final class Builder extends GeneratedMessageLite.Builder<PushImClient, Builder> implements PushImClientOrBuilder {
            public List<Action> actions = Collections.emptyList();
            public int bitField0;
            public Common common = Common.getDefaultInstance();
            public MetaData metadata = MetaData.getDefaultInstance();
            public Object sdkName = "";
            public long sdkVersion;

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void ensureActionsIsMutable() {
                if ((this.bitField0 & 16) != 16) {
                    this.actions = new ArrayList(this.actions);
                    this.bitField0 |= 16;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder addActions(Action action) {
                if (action != null) {
                    ensureActionsIsMutable();
                    this.actions.add(action);
                    return this;
                }
                throw null;
            }

            public Builder addAllActions(Iterable<? extends Action> iterable) {
                ensureActionsIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.actions);
                return this;
            }

            public Builder clearActions() {
                this.actions = Collections.emptyList();
                this.bitField0 &= -17;
                return this;
            }

            public Builder clearCommon() {
                this.common = Common.getDefaultInstance();
                this.bitField0 &= -3;
                return this;
            }

            public Builder clearMetadata() {
                this.metadata = MetaData.getDefaultInstance();
                this.bitField0 &= -2;
                return this;
            }

            public Builder clearSdkName() {
                this.bitField0 &= -5;
                this.sdkName = PushImClient.getDefaultInstance().getSdkName();
                return this;
            }

            public Builder clearSdkVersion() {
                this.bitField0 &= -9;
                this.sdkVersion = 0;
                return this;
            }

            public Action getActions(int i2) {
                return this.actions.get(i2);
            }

            public int getActionsCount() {
                return this.actions.size();
            }

            public List<Action> getActionsList() {
                return Collections.unmodifiableList(this.actions);
            }

            public Common getCommon() {
                return this.common;
            }

            public MetaData getMetadata() {
                return this.metadata;
            }

            public String getSdkName() {
                Object obj = this.sdkName;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.sdkName = stringUtf8;
                return stringUtf8;
            }

            public ByteString getSdkNameBytes() {
                Object obj = this.sdkName;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sdkName = copyFromUtf8;
                return copyFromUtf8;
            }

            public long getSdkVersion() {
                return this.sdkVersion;
            }

            public boolean hasCommon() {
                return (this.bitField0 & 2) == 2;
            }

            public boolean hasMetadata() {
                return (this.bitField0 & 1) == 1;
            }

            public boolean hasSdkName() {
                return (this.bitField0 & 4) == 4;
            }

            public boolean hasSdkVersion() {
                return (this.bitField0 & 8) == 8;
            }

            public final boolean isInitialized() {
                if (hasCommon() && getCommon().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeCommon(Common common2) {
                if ((this.bitField0 & 2) != 2 || this.common == Common.getDefaultInstance()) {
                    this.common = common2;
                } else {
                    this.common = Common.newBuilder(this.common).mergeFrom(common2).buildPartial();
                }
                this.bitField0 |= 2;
                return this;
            }

            public Builder mergeMetadata(MetaData metaData) {
                if ((this.bitField0 & 1) != 1 || this.metadata == MetaData.getDefaultInstance()) {
                    this.metadata = metaData;
                } else {
                    this.metadata = MetaData.newBuilder(this.metadata).mergeFrom(metaData).buildPartial();
                }
                this.bitField0 |= 1;
                return this;
            }

            public Builder removeActions(int i2) {
                ensureActionsIsMutable();
                this.actions.remove(i2);
                return this;
            }

            public Builder setActions(int i2, Action action) {
                if (action != null) {
                    ensureActionsIsMutable();
                    this.actions.set(i2, action);
                    return this;
                }
                throw null;
            }

            public Builder setCommon(Common common2) {
                if (common2 != null) {
                    this.common = common2;
                    this.bitField0 |= 2;
                    return this;
                }
                throw null;
            }

            public Builder setMetadata(MetaData metaData) {
                if (metaData != null) {
                    this.metadata = metaData;
                    this.bitField0 |= 1;
                    return this;
                }
                throw null;
            }

            public Builder setSdkName(String str) {
                if (str != null) {
                    this.bitField0 |= 4;
                    this.sdkName = str;
                    return this;
                }
                throw null;
            }

            public Builder setSdkNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 4;
                    this.sdkName = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setSdkVersion(long j) {
                this.bitField0 |= 8;
                this.sdkVersion = j;
                return this;
            }

            public PushImClient build() {
                PushImClient buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public PushImClient buildPartial() {
                PushImClient pushImClient = new PushImClient((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                MetaData unused = pushImClient.metadata = this.metadata;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Common unused2 = pushImClient.common = this.common;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                Object unused3 = pushImClient.sdkName = this.sdkName;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                long unused4 = pushImClient.sdkVersion = this.sdkVersion;
                if ((this.bitField0 & 16) == 16) {
                    this.actions = Collections.unmodifiableList(this.actions);
                    this.bitField0 &= -17;
                }
                List unused5 = pushImClient.actions = this.actions;
                int unused6 = pushImClient.bitField0 = i3;
                return pushImClient;
            }

            public Builder clear() {
                super.clear();
                this.metadata = MetaData.getDefaultInstance();
                this.bitField0 &= -2;
                this.common = Common.getDefaultInstance();
                int i2 = this.bitField0 & -3;
                this.bitField0 = i2;
                this.sdkName = "";
                int i3 = i2 & -5;
                this.bitField0 = i3;
                this.sdkVersion = 0;
                this.bitField0 = i3 & -9;
                this.actions = Collections.emptyList();
                this.bitField0 &= -17;
                return this;
            }

            public PushImClient getDefaultInstanceForType() {
                return PushImClient.getDefaultInstance();
            }

            public Builder addActions(int i2, Action action) {
                if (action != null) {
                    ensureActionsIsMutable();
                    this.actions.add(i2, action);
                    return this;
                }
                throw null;
            }

            public Builder mergeFrom(PushImClient pushImClient) {
                if (pushImClient == PushImClient.getDefaultInstance()) {
                    return this;
                }
                if (pushImClient.hasMetadata()) {
                    mergeMetadata(pushImClient.getMetadata());
                }
                if (pushImClient.hasCommon()) {
                    mergeCommon(pushImClient.getCommon());
                }
                if (pushImClient.hasSdkName()) {
                    this.bitField0 |= 4;
                    this.sdkName = pushImClient.sdkName;
                }
                if (pushImClient.hasSdkVersion()) {
                    setSdkVersion(pushImClient.getSdkVersion());
                }
                if (!pushImClient.actions.isEmpty()) {
                    if (this.actions.isEmpty()) {
                        this.actions = pushImClient.actions;
                        this.bitField0 &= -17;
                    } else {
                        ensureActionsIsMutable();
                        this.actions.addAll(pushImClient.actions);
                    }
                }
                return this;
            }

            public Builder setActions(int i2, Action.Builder builder) {
                ensureActionsIsMutable();
                this.actions.set(i2, builder.build());
                return this;
            }

            public Builder setCommon(Common.Builder builder) {
                this.common = builder.build();
                this.bitField0 |= 2;
                return this;
            }

            public Builder setMetadata(MetaData.Builder builder) {
                this.metadata = builder.build();
                this.bitField0 |= 1;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder addActions(Action.Builder builder) {
                ensureActionsIsMutable();
                this.actions.add(builder.build());
                return this;
            }

            public Builder addActions(int i2, Action.Builder builder) {
                ensureActionsIsMutable();
                this.actions.add(i2, builder.build());
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                PushImClient pushImClient;
                PushImClient pushImClient2 = null;
                try {
                    PushImClient parsePartialFrom = PushImClient.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    pushImClient = (PushImClient) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    pushImClient2 = pushImClient;
                }
                if (pushImClient2 != null) {
                    mergeFrom(pushImClient2);
                }
                throw th;
            }
        }

        static {
            PushImClient pushImClient = new PushImClient(true);
            defaultInstance = pushImClient;
            pushImClient.initFields();
        }

        public static PushImClient getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.metadata = MetaData.getDefaultInstance();
            this.common = Common.getDefaultInstance();
            this.sdkName = "";
            this.sdkVersion = 0;
            this.actions = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static PushImClient parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static PushImClient parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public Action getActions(int i2) {
            return this.actions.get(i2);
        }

        public int getActionsCount() {
            return this.actions.size();
        }

        public List<Action> getActionsList() {
            return this.actions;
        }

        public ActionOrBuilder getActionsOrBuilder(int i2) {
            return this.actions.get(i2);
        }

        public List<? extends ActionOrBuilder> getActionsOrBuilderList() {
            return this.actions;
        }

        public Common getCommon() {
            return this.common;
        }

        public MetaData getMetadata() {
            return this.metadata;
        }

        public Parser<PushImClient> getParserForType() {
            return PARSER;
        }

        public String getSdkName() {
            Object obj = this.sdkName;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.sdkName = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getSdkNameBytes() {
            Object obj = this.sdkName;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.sdkName = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getSdkVersion() {
            return this.sdkVersion;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeMessageSize = (this.bitField0 & 1) == 1 ? CodedOutputStream.computeMessageSize(25, this.metadata) + 0 : 0;
            if ((this.bitField0 & 2) == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(41, this.common);
            }
            if ((this.bitField0 & 4) == 4) {
                computeMessageSize += CodedOutputStream.computeBytesSize(130, getSdkNameBytes());
            }
            if ((this.bitField0 & 8) == 8) {
                computeMessageSize += CodedOutputStream.computeInt64Size(131, this.sdkVersion);
            }
            for (int i3 = 0; i3 < this.actions.size(); i3++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(132, this.actions.get(i3));
            }
            this.memoizedSerializedSize = computeMessageSize;
            return computeMessageSize;
        }

        public boolean hasCommon() {
            return (this.bitField0 & 2) == 2;
        }

        public boolean hasMetadata() {
            return (this.bitField0 & 1) == 1;
        }

        public boolean hasSdkName() {
            return (this.bitField0 & 4) == 4;
        }

        public boolean hasSdkVersion() {
            return (this.bitField0 & 8) == 8;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            if (!hasCommon()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!getCommon().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
        }

        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeMessage(25, this.metadata);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeMessage(41, this.common);
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeBytes(130, getSdkNameBytes());
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(131, this.sdkVersion);
            }
            for (int i2 = 0; i2 < this.actions.size(); i2++) {
                codedOutputStream.writeMessage(132, this.actions.get(i2));
            }
        }

        public static Builder newBuilder(PushImClient pushImClient) {
            return newBuilder().mergeFrom(pushImClient);
        }

        public static PushImClient parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static PushImClient parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public PushImClient getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public PushImClient(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static PushImClient parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static PushImClient parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static PushImClient parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public PushImClient(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static PushImClient parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static PushImClient parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static PushImClient parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.baidu.android.imsdk.upload.action.pb.IMPushPb$MetaData$Builder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.baidu.android.imsdk.upload.action.pb.IMPushPb$Common$Builder} */
        /* JADX WARNING: type inference failed for: r6v0 */
        /* JADX WARNING: type inference failed for: r6v5 */
        /* JADX WARNING: type inference failed for: r6v6 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PushImClient(com.google.protobuf.CodedInputStream r8, com.google.protobuf.ExtensionRegistryLite r9) throws com.google.protobuf.InvalidProtocolBufferException {
            /*
                r7 = this;
                r7.<init>()
                r0 = -1
                r7.memoizedIsInitialized = r0
                r7.memoizedSerializedSize = r0
                r7.initFields()
                r0 = 0
                r1 = 0
            L_0x000d:
                r2 = 16
                if (r0 != 0) goto L_0x00e3
                int r3 = r8.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r4 = 1
                if (r3 == 0) goto L_0x00b9
                r5 = 202(0xca, float:2.83E-43)
                r6 = 0
                if (r3 == r5) goto L_0x0092
                r5 = 330(0x14a, float:4.62E-43)
                if (r3 == r5) goto L_0x006a
                r5 = 1042(0x412, float:1.46E-42)
                if (r3 == r5) goto L_0x005d
                r5 = 1048(0x418, float:1.469E-42)
                if (r3 == r5) goto L_0x0050
                r5 = 1058(0x422, float:1.483E-42)
                if (r3 == r5) goto L_0x0035
                boolean r2 = r7.parseUnknownField(r8, r9, r3)     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                if (r2 != 0) goto L_0x000d
                goto L_0x00b9
            L_0x0035:
                r3 = r1 & 16
                if (r3 == r2) goto L_0x0042
                java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r3.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r7.actions = r3     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r1 = r1 | 16
            L_0x0042:
                java.util.List<com.baidu.android.imsdk.upload.action.pb.IMPushPb$Action> r3 = r7.actions     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                com.google.protobuf.Parser<com.baidu.android.imsdk.upload.action.pb.IMPushPb$Action> r4 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.Action.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                com.google.protobuf.MessageLite r4 = r8.readMessage(r4, (com.google.protobuf.ExtensionRegistryLite) r9)     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Action r4 = (com.baidu.android.imsdk.upload.action.pb.IMPushPb.Action) r4     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r3.add(r4)     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                goto L_0x000d
            L_0x0050:
                int r3 = r7.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r3 = r3 | 8
                r7.bitField0 = r3     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                long r3 = r8.readInt64()     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r7.sdkVersion = r3     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                goto L_0x000d
            L_0x005d:
                int r3 = r7.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r3 = r3 | 4
                r7.bitField0 = r3     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                com.google.protobuf.ByteString r3 = r8.readBytes()     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r7.sdkName = r3     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                goto L_0x000d
            L_0x006a:
                int r3 = r7.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r4 = 2
                r3 = r3 & r4
                if (r3 != r4) goto L_0x0076
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Common r3 = r7.common     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Common$Builder r6 = r3.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
            L_0x0076:
                com.google.protobuf.Parser<com.baidu.android.imsdk.upload.action.pb.IMPushPb$Common> r3 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.Common.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                com.google.protobuf.MessageLite r3 = r8.readMessage(r3, (com.google.protobuf.ExtensionRegistryLite) r9)     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Common r3 = (com.baidu.android.imsdk.upload.action.pb.IMPushPb.Common) r3     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r7.common = r3     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                if (r6 == 0) goto L_0x008b
                r6.mergeFrom((com.baidu.android.imsdk.upload.action.pb.IMPushPb.Common) r3)     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$Common r3 = r6.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r7.common = r3     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
            L_0x008b:
                int r3 = r7.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r3 = r3 | r4
                r7.bitField0 = r3     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                goto L_0x000d
            L_0x0092:
                int r3 = r7.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r3 = r3 & r4
                if (r3 != r4) goto L_0x009d
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$MetaData r3 = r7.metadata     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$MetaData$Builder r6 = r3.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
            L_0x009d:
                com.google.protobuf.Parser<com.baidu.android.imsdk.upload.action.pb.IMPushPb$MetaData> r3 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaData.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                com.google.protobuf.MessageLite r3 = r8.readMessage(r3, (com.google.protobuf.ExtensionRegistryLite) r9)     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$MetaData r3 = (com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaData) r3     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r7.metadata = r3     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                if (r6 == 0) goto L_0x00b2
                r6.mergeFrom((com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaData) r3)     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$MetaData r3 = r6.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r7.metadata = r3     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
            L_0x00b2:
                int r3 = r7.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                r3 = r3 | r4
                r7.bitField0 = r3     // Catch:{ InvalidProtocolBufferException -> 0x00cd, IOException -> 0x00be }
                goto L_0x000d
            L_0x00b9:
                r0 = 1
                goto L_0x000d
            L_0x00bc:
                r8 = move-exception
                goto L_0x00d3
            L_0x00be:
                r8 = move-exception
                com.google.protobuf.InvalidProtocolBufferException r9 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x00bc }
                java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x00bc }
                r9.<init>((java.lang.String) r8)     // Catch:{ all -> 0x00bc }
                com.google.protobuf.InvalidProtocolBufferException r8 = r9.setUnfinishedMessage(r7)     // Catch:{ all -> 0x00bc }
                throw r8     // Catch:{ all -> 0x00bc }
            L_0x00cd:
                r8 = move-exception
                com.google.protobuf.InvalidProtocolBufferException r8 = r8.setUnfinishedMessage(r7)     // Catch:{ all -> 0x00bc }
                throw r8     // Catch:{ all -> 0x00bc }
            L_0x00d3:
                r9 = r1 & 16
                if (r9 != r2) goto L_0x00df
                java.util.List<com.baidu.android.imsdk.upload.action.pb.IMPushPb$Action> r9 = r7.actions
                java.util.List r9 = java.util.Collections.unmodifiableList(r9)
                r7.actions = r9
            L_0x00df:
                r7.makeExtensionsImmutable()
                throw r8
            L_0x00e3:
                r8 = r1 & 16
                if (r8 != r2) goto L_0x00ef
                java.util.List<com.baidu.android.imsdk.upload.action.pb.IMPushPb$Action> r8 = r7.actions
                java.util.List r8 = java.util.Collections.unmodifiableList(r8)
                r7.actions = r8
            L_0x00ef:
                r7.makeExtensionsImmutable()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClient.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
        }
    }

    public interface PushImClientOrBuilder extends MessageLiteOrBuilder {
        Action getActions(int i2);

        int getActionsCount();

        List<Action> getActionsList();

        Common getCommon();

        MetaData getMetadata();

        String getSdkName();

        ByteString getSdkNameBytes();

        long getSdkVersion();

        boolean hasCommon();

        boolean hasMetadata();

        boolean hasSdkName();

        boolean hasSdkVersion();
    }

    public static final class Request extends GeneratedMessageLite implements RequestOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 7;
        public static final int ERROR_CODE_FIELD_NUMBER = 5;
        public static final int EXT_FIELD_NUMBER = 6;
        public static final int METHOD_FIELD_NUMBER = 1;
        public static final Parser<Request> PARSER = new AbstractParser<Request>() {
            public Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Request(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int REQUEST_ID_FIELD_NUMBER = 2;
        public static final int RESPONSE_TIME_FIELD_NUMBER = 4;
        public static final int TIMESTAMP_FIELD_NUMBER = 3;
        public static final Request defaultInstance;
        public static final long serialVersionUID = 0;
        public long aliasId;
        public int bitField0;
        public long errorCode;
        public Object ext;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object method;
        public Object requestId;
        public long responseTime;
        public long timestamp;

        public static final class Builder extends GeneratedMessageLite.Builder<Request, Builder> implements RequestOrBuilder {
            public long aliasId;
            public int bitField0;
            public long errorCode;
            public Object ext = "";
            public Object method = "";
            public Object requestId = "";
            public long responseTime;
            public long timestamp;

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAliasId() {
                this.bitField0 &= -65;
                this.aliasId = 0;
                return this;
            }

            public Builder clearErrorCode() {
                this.bitField0 &= -17;
                this.errorCode = 0;
                return this;
            }

            public Builder clearExt() {
                this.bitField0 &= -33;
                this.ext = Request.getDefaultInstance().getExt();
                return this;
            }

            public Builder clearMethod() {
                this.bitField0 &= -2;
                this.method = Request.getDefaultInstance().getMethod();
                return this;
            }

            public Builder clearRequestId() {
                this.bitField0 &= -3;
                this.requestId = Request.getDefaultInstance().getRequestId();
                return this;
            }

            public Builder clearResponseTime() {
                this.bitField0 &= -9;
                this.responseTime = 0;
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0 &= -5;
                this.timestamp = 0;
                return this;
            }

            public long getAliasId() {
                return this.aliasId;
            }

            public long getErrorCode() {
                return this.errorCode;
            }

            public String getExt() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ext = stringUtf8;
                return stringUtf8;
            }

            public ByteString getExtBytes() {
                Object obj = this.ext;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getMethod() {
                Object obj = this.method;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.method = stringUtf8;
                return stringUtf8;
            }

            public ByteString getMethodBytes() {
                Object obj = this.method;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.method = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getRequestId() {
                Object obj = this.requestId;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.requestId = stringUtf8;
                return stringUtf8;
            }

            public ByteString getRequestIdBytes() {
                Object obj = this.requestId;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.requestId = copyFromUtf8;
                return copyFromUtf8;
            }

            public long getResponseTime() {
                return this.responseTime;
            }

            public long getTimestamp() {
                return this.timestamp;
            }

            public boolean hasAliasId() {
                return (this.bitField0 & 64) == 64;
            }

            public boolean hasErrorCode() {
                return (this.bitField0 & 16) == 16;
            }

            public boolean hasExt() {
                return (this.bitField0 & 32) == 32;
            }

            public boolean hasMethod() {
                return (this.bitField0 & 1) == 1;
            }

            public boolean hasRequestId() {
                return (this.bitField0 & 2) == 2;
            }

            public boolean hasResponseTime() {
                return (this.bitField0 & 8) == 8;
            }

            public boolean hasTimestamp() {
                return (this.bitField0 & 4) == 4;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setAliasId(long j) {
                this.bitField0 |= 64;
                this.aliasId = j;
                return this;
            }

            public Builder setErrorCode(long j) {
                this.bitField0 |= 16;
                this.errorCode = j;
                return this;
            }

            public Builder setExt(String str) {
                if (str != null) {
                    this.bitField0 |= 32;
                    this.ext = str;
                    return this;
                }
                throw null;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 32;
                    this.ext = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setMethod(String str) {
                if (str != null) {
                    this.bitField0 |= 1;
                    this.method = str;
                    return this;
                }
                throw null;
            }

            public Builder setMethodBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 1;
                    this.method = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setRequestId(String str) {
                if (str != null) {
                    this.bitField0 |= 2;
                    this.requestId = str;
                    return this;
                }
                throw null;
            }

            public Builder setRequestIdBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 2;
                    this.requestId = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setResponseTime(long j) {
                this.bitField0 |= 8;
                this.responseTime = j;
                return this;
            }

            public Builder setTimestamp(long j) {
                this.bitField0 |= 4;
                this.timestamp = j;
                return this;
            }

            public Request build() {
                Request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Request buildPartial() {
                Request request = new Request((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                Object unused = request.method = this.method;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Object unused2 = request.requestId = this.requestId;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                long unused3 = request.timestamp = this.timestamp;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                long unused4 = request.responseTime = this.responseTime;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                long unused5 = request.errorCode = this.errorCode;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                Object unused6 = request.ext = this.ext;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                long unused7 = request.aliasId = this.aliasId;
                int unused8 = request.bitField0 = i3;
                return request;
            }

            public Builder clear() {
                super.clear();
                this.method = "";
                int i2 = this.bitField0 & -2;
                this.bitField0 = i2;
                this.requestId = "";
                int i3 = i2 & -3;
                this.bitField0 = i3;
                this.timestamp = 0;
                int i4 = i3 & -5;
                this.bitField0 = i4;
                this.responseTime = 0;
                int i5 = i4 & -9;
                this.bitField0 = i5;
                this.errorCode = 0;
                int i6 = i5 & -17;
                this.bitField0 = i6;
                this.ext = "";
                int i7 = i6 & -33;
                this.bitField0 = i7;
                this.aliasId = 0;
                this.bitField0 = i7 & -65;
                return this;
            }

            public Request getDefaultInstanceForType() {
                return Request.getDefaultInstance();
            }

            public Builder mergeFrom(Request request) {
                if (request == Request.getDefaultInstance()) {
                    return this;
                }
                if (request.hasMethod()) {
                    this.bitField0 |= 1;
                    this.method = request.method;
                }
                if (request.hasRequestId()) {
                    this.bitField0 |= 2;
                    this.requestId = request.requestId;
                }
                if (request.hasTimestamp()) {
                    setTimestamp(request.getTimestamp());
                }
                if (request.hasResponseTime()) {
                    setResponseTime(request.getResponseTime());
                }
                if (request.hasErrorCode()) {
                    setErrorCode(request.getErrorCode());
                }
                if (request.hasExt()) {
                    this.bitField0 |= 32;
                    this.ext = request.ext;
                }
                if (request.hasAliasId()) {
                    setAliasId(request.getAliasId());
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Request request;
                Request request2 = null;
                try {
                    Request parsePartialFrom = Request.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    request = (Request) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    request2 = request;
                }
                if (request2 != null) {
                    mergeFrom(request2);
                }
                throw th;
            }
        }

        static {
            Request request = new Request(true);
            defaultInstance = request;
            request.initFields();
        }

        public static Request getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.method = "";
            this.requestId = "";
            this.timestamp = 0;
            this.responseTime = 0;
            this.errorCode = 0;
            this.ext = "";
            this.aliasId = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public long getAliasId() {
            return this.aliasId;
        }

        public long getErrorCode() {
            return this.errorCode;
        }

        public String getExt() {
            Object obj = this.ext;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getExtBytes() {
            Object obj = this.ext;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ext = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getMethod() {
            Object obj = this.method;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.method = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getMethodBytes() {
            Object obj = this.method;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.method = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<Request> getParserForType() {
            return PARSER;
        }

        public String getRequestId() {
            Object obj = this.requestId;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.requestId = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getRequestIdBytes() {
            Object obj = this.requestId;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.requestId = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getResponseTime() {
            return this.responseTime;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeBytesSize(1, getMethodBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                i3 += CodedOutputStream.computeBytesSize(2, getRequestIdBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                i3 += CodedOutputStream.computeInt64Size(3, this.timestamp);
            }
            if ((this.bitField0 & 8) == 8) {
                i3 += CodedOutputStream.computeInt64Size(4, this.responseTime);
            }
            if ((this.bitField0 & 16) == 16) {
                i3 += CodedOutputStream.computeInt64Size(5, this.errorCode);
            }
            if ((this.bitField0 & 32) == 32) {
                i3 += CodedOutputStream.computeBytesSize(6, getExtBytes());
            }
            if ((this.bitField0 & 64) == 64) {
                i3 += CodedOutputStream.computeInt64Size(7, this.aliasId);
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public boolean hasAliasId() {
            return (this.bitField0 & 64) == 64;
        }

        public boolean hasErrorCode() {
            return (this.bitField0 & 16) == 16;
        }

        public boolean hasExt() {
            return (this.bitField0 & 32) == 32;
        }

        public boolean hasMethod() {
            return (this.bitField0 & 1) == 1;
        }

        public boolean hasRequestId() {
            return (this.bitField0 & 2) == 2;
        }

        public boolean hasResponseTime() {
            return (this.bitField0 & 8) == 8;
        }

        public boolean hasTimestamp() {
            return (this.bitField0 & 4) == 4;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getMethodBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getRequestIdBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeInt64(3, this.timestamp);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(4, this.responseTime);
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeInt64(5, this.errorCode);
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeBytes(6, getExtBytes());
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeInt64(7, this.aliasId);
            }
        }

        public static Builder newBuilder(Request request) {
            return newBuilder().mergeFrom(request);
        }

        public static Request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Request getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Request(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Request parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public Request(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Request(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.bitField0 |= 1;
                            this.method = codedInputStream.readBytes();
                        } else if (readTag == 18) {
                            this.bitField0 |= 2;
                            this.requestId = codedInputStream.readBytes();
                        } else if (readTag == 24) {
                            this.bitField0 |= 4;
                            this.timestamp = codedInputStream.readInt64();
                        } else if (readTag == 32) {
                            this.bitField0 |= 8;
                            this.responseTime = codedInputStream.readInt64();
                        } else if (readTag == 40) {
                            this.bitField0 |= 16;
                            this.errorCode = codedInputStream.readInt64();
                        } else if (readTag == 50) {
                            this.bitField0 |= 32;
                            this.ext = codedInputStream.readBytes();
                        } else if (readTag == 56) {
                            this.bitField0 |= 64;
                            this.aliasId = codedInputStream.readInt64();
                        } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    makeExtensionsImmutable();
                    throw th2;
                }
            }
            makeExtensionsImmutable();
        }
    }

    public interface RequestOrBuilder extends MessageLiteOrBuilder {
        long getAliasId();

        long getErrorCode();

        String getExt();

        ByteString getExtBytes();

        String getMethod();

        ByteString getMethodBytes();

        String getRequestId();

        ByteString getRequestIdBytes();

        long getResponseTime();

        long getTimestamp();

        boolean hasAliasId();

        boolean hasErrorCode();

        boolean hasExt();

        boolean hasMethod();

        boolean hasRequestId();

        boolean hasResponseTime();

        boolean hasTimestamp();
    }

    public static final class TerminalInfo extends GeneratedMessageLite implements TerminalInfoOrBuilder {
        public static final int MANUFACTURER_FIELD_NUMBER = 3;
        public static final int OS_FIELD_NUMBER = 1;
        public static final int OS_VERSION_FIELD_NUMBER = 2;
        public static final Parser<TerminalInfo> PARSER = new AbstractParser<TerminalInfo>() {
            public TerminalInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TerminalInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PPI_FIELD_NUMBER = 7;
        public static final int RESOLUTION_H_FIELD_NUMBER = 5;
        public static final int RESOLUTION_V_FIELD_NUMBER = 6;
        public static final int TERMINAL_TYPE_FIELD_NUMBER = 4;
        public static final TerminalInfo defaultInstance;
        public static final long serialVersionUID = 0;
        public int bitField0;
        public Object manufacturer;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public OSType os;
        public Object osVersion;
        public int ppi;
        public int resolutionH;
        public int resolutionV;
        public Object terminalType;

        public static final class Builder extends GeneratedMessageLite.Builder<TerminalInfo, Builder> implements TerminalInfoOrBuilder {
            public int bitField0;
            public Object manufacturer = "";
            public OSType os = OSType.OS_TYPE_UNKNWON;
            public Object osVersion = "";
            public int ppi;
            public int resolutionH;
            public int resolutionV;
            public Object terminalType = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearManufacturer() {
                this.bitField0 &= -5;
                this.manufacturer = TerminalInfo.getDefaultInstance().getManufacturer();
                return this;
            }

            public Builder clearOs() {
                this.bitField0 &= -2;
                this.os = OSType.OS_TYPE_UNKNWON;
                return this;
            }

            public Builder clearOsVersion() {
                this.bitField0 &= -3;
                this.osVersion = TerminalInfo.getDefaultInstance().getOsVersion();
                return this;
            }

            public Builder clearPpi() {
                this.bitField0 &= -65;
                this.ppi = 0;
                return this;
            }

            public Builder clearResolutionH() {
                this.bitField0 &= -17;
                this.resolutionH = 0;
                return this;
            }

            public Builder clearResolutionV() {
                this.bitField0 &= -33;
                this.resolutionV = 0;
                return this;
            }

            public Builder clearTerminalType() {
                this.bitField0 &= -9;
                this.terminalType = TerminalInfo.getDefaultInstance().getTerminalType();
                return this;
            }

            public String getManufacturer() {
                Object obj = this.manufacturer;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.manufacturer = stringUtf8;
                return stringUtf8;
            }

            public ByteString getManufacturerBytes() {
                Object obj = this.manufacturer;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.manufacturer = copyFromUtf8;
                return copyFromUtf8;
            }

            public OSType getOs() {
                return this.os;
            }

            public String getOsVersion() {
                Object obj = this.osVersion;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.osVersion = stringUtf8;
                return stringUtf8;
            }

            public ByteString getOsVersionBytes() {
                Object obj = this.osVersion;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.osVersion = copyFromUtf8;
                return copyFromUtf8;
            }

            public int getPpi() {
                return this.ppi;
            }

            public int getResolutionH() {
                return this.resolutionH;
            }

            public int getResolutionV() {
                return this.resolutionV;
            }

            public String getTerminalType() {
                Object obj = this.terminalType;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.terminalType = stringUtf8;
                return stringUtf8;
            }

            public ByteString getTerminalTypeBytes() {
                Object obj = this.terminalType;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.terminalType = copyFromUtf8;
                return copyFromUtf8;
            }

            public boolean hasManufacturer() {
                return (this.bitField0 & 4) == 4;
            }

            public boolean hasOs() {
                return (this.bitField0 & 1) == 1;
            }

            public boolean hasOsVersion() {
                return (this.bitField0 & 2) == 2;
            }

            public boolean hasPpi() {
                return (this.bitField0 & 64) == 64;
            }

            public boolean hasResolutionH() {
                return (this.bitField0 & 16) == 16;
            }

            public boolean hasResolutionV() {
                return (this.bitField0 & 32) == 32;
            }

            public boolean hasTerminalType() {
                return (this.bitField0 & 8) == 8;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setManufacturer(String str) {
                if (str != null) {
                    this.bitField0 |= 4;
                    this.manufacturer = str;
                    return this;
                }
                throw null;
            }

            public Builder setManufacturerBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 4;
                    this.manufacturer = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setOs(OSType oSType) {
                if (oSType != null) {
                    this.bitField0 |= 1;
                    this.os = oSType;
                    return this;
                }
                throw null;
            }

            public Builder setOsVersion(String str) {
                if (str != null) {
                    this.bitField0 |= 2;
                    this.osVersion = str;
                    return this;
                }
                throw null;
            }

            public Builder setOsVersionBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 2;
                    this.osVersion = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setPpi(int i2) {
                this.bitField0 |= 64;
                this.ppi = i2;
                return this;
            }

            public Builder setResolutionH(int i2) {
                this.bitField0 |= 16;
                this.resolutionH = i2;
                return this;
            }

            public Builder setResolutionV(int i2) {
                this.bitField0 |= 32;
                this.resolutionV = i2;
                return this;
            }

            public Builder setTerminalType(String str) {
                if (str != null) {
                    this.bitField0 |= 8;
                    this.terminalType = str;
                    return this;
                }
                throw null;
            }

            public Builder setTerminalTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 8;
                    this.terminalType = byteString;
                    return this;
                }
                throw null;
            }

            public TerminalInfo build() {
                TerminalInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public TerminalInfo buildPartial() {
                TerminalInfo terminalInfo = new TerminalInfo((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                OSType unused = terminalInfo.os = this.os;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Object unused2 = terminalInfo.osVersion = this.osVersion;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                Object unused3 = terminalInfo.manufacturer = this.manufacturer;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                Object unused4 = terminalInfo.terminalType = this.terminalType;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                int unused5 = terminalInfo.resolutionH = this.resolutionH;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                int unused6 = terminalInfo.resolutionV = this.resolutionV;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                int unused7 = terminalInfo.ppi = this.ppi;
                int unused8 = terminalInfo.bitField0 = i3;
                return terminalInfo;
            }

            public Builder clear() {
                super.clear();
                this.os = OSType.OS_TYPE_UNKNWON;
                int i2 = this.bitField0 & -2;
                this.bitField0 = i2;
                this.osVersion = "";
                int i3 = i2 & -3;
                this.bitField0 = i3;
                this.manufacturer = "";
                int i4 = i3 & -5;
                this.bitField0 = i4;
                this.terminalType = "";
                int i5 = i4 & -9;
                this.bitField0 = i5;
                this.resolutionH = 0;
                int i6 = i5 & -17;
                this.bitField0 = i6;
                this.resolutionV = 0;
                int i7 = i6 & -33;
                this.bitField0 = i7;
                this.ppi = 0;
                this.bitField0 = i7 & -65;
                return this;
            }

            public TerminalInfo getDefaultInstanceForType() {
                return TerminalInfo.getDefaultInstance();
            }

            public Builder mergeFrom(TerminalInfo terminalInfo) {
                if (terminalInfo == TerminalInfo.getDefaultInstance()) {
                    return this;
                }
                if (terminalInfo.hasOs()) {
                    setOs(terminalInfo.getOs());
                }
                if (terminalInfo.hasOsVersion()) {
                    this.bitField0 |= 2;
                    this.osVersion = terminalInfo.osVersion;
                }
                if (terminalInfo.hasManufacturer()) {
                    this.bitField0 |= 4;
                    this.manufacturer = terminalInfo.manufacturer;
                }
                if (terminalInfo.hasTerminalType()) {
                    this.bitField0 |= 8;
                    this.terminalType = terminalInfo.terminalType;
                }
                if (terminalInfo.hasResolutionH()) {
                    setResolutionH(terminalInfo.getResolutionH());
                }
                if (terminalInfo.hasResolutionV()) {
                    setResolutionV(terminalInfo.getResolutionV());
                }
                if (terminalInfo.hasPpi()) {
                    setPpi(terminalInfo.getPpi());
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TerminalInfo terminalInfo;
                TerminalInfo terminalInfo2 = null;
                try {
                    TerminalInfo parsePartialFrom = TerminalInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    terminalInfo = (TerminalInfo) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    terminalInfo2 = terminalInfo;
                }
                if (terminalInfo2 != null) {
                    mergeFrom(terminalInfo2);
                }
                throw th;
            }
        }

        static {
            TerminalInfo terminalInfo = new TerminalInfo(true);
            defaultInstance = terminalInfo;
            terminalInfo.initFields();
        }

        public static TerminalInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.os = OSType.OS_TYPE_UNKNWON;
            this.osVersion = "";
            this.manufacturer = "";
            this.terminalType = "";
            this.resolutionH = 0;
            this.resolutionV = 0;
            this.ppi = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static TerminalInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static TerminalInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public String getManufacturer() {
            Object obj = this.manufacturer;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.manufacturer = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getManufacturerBytes() {
            Object obj = this.manufacturer;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.manufacturer = copyFromUtf8;
            return copyFromUtf8;
        }

        public OSType getOs() {
            return this.os;
        }

        public String getOsVersion() {
            Object obj = this.osVersion;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.osVersion = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getOsVersionBytes() {
            Object obj = this.osVersion;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.osVersion = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<TerminalInfo> getParserForType() {
            return PARSER;
        }

        public int getPpi() {
            return this.ppi;
        }

        public int getResolutionH() {
            return this.resolutionH;
        }

        public int getResolutionV() {
            return this.resolutionV;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeEnumSize(1, this.os.getNumber());
            }
            if ((this.bitField0 & 2) == 2) {
                i3 += CodedOutputStream.computeBytesSize(2, getOsVersionBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                i3 += CodedOutputStream.computeBytesSize(3, getManufacturerBytes());
            }
            if ((this.bitField0 & 8) == 8) {
                i3 += CodedOutputStream.computeBytesSize(4, getTerminalTypeBytes());
            }
            if ((this.bitField0 & 16) == 16) {
                i3 += CodedOutputStream.computeInt32Size(5, this.resolutionH);
            }
            if ((this.bitField0 & 32) == 32) {
                i3 += CodedOutputStream.computeInt32Size(6, this.resolutionV);
            }
            if ((this.bitField0 & 64) == 64) {
                i3 += CodedOutputStream.computeInt32Size(7, this.ppi);
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public String getTerminalType() {
            Object obj = this.terminalType;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.terminalType = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getTerminalTypeBytes() {
            Object obj = this.terminalType;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.terminalType = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasManufacturer() {
            return (this.bitField0 & 4) == 4;
        }

        public boolean hasOs() {
            return (this.bitField0 & 1) == 1;
        }

        public boolean hasOsVersion() {
            return (this.bitField0 & 2) == 2;
        }

        public boolean hasPpi() {
            return (this.bitField0 & 64) == 64;
        }

        public boolean hasResolutionH() {
            return (this.bitField0 & 16) == 16;
        }

        public boolean hasResolutionV() {
            return (this.bitField0 & 32) == 32;
        }

        public boolean hasTerminalType() {
            return (this.bitField0 & 8) == 8;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeEnum(1, this.os.getNumber());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getOsVersionBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeBytes(3, getManufacturerBytes());
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeBytes(4, getTerminalTypeBytes());
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeInt32(5, this.resolutionH);
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeInt32(6, this.resolutionV);
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeInt32(7, this.ppi);
            }
        }

        public static Builder newBuilder(TerminalInfo terminalInfo) {
            return newBuilder().mergeFrom(terminalInfo);
        }

        public static TerminalInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static TerminalInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public TerminalInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public TerminalInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static TerminalInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static TerminalInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static TerminalInfo parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public TerminalInfo(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static TerminalInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static TerminalInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static TerminalInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public TerminalInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            OSType valueOf = OSType.valueOf(codedInputStream.readEnum());
                            if (valueOf != null) {
                                this.bitField0 = 1 | this.bitField0;
                                this.os = valueOf;
                            }
                        } else if (readTag == 18) {
                            this.bitField0 |= 2;
                            this.osVersion = codedInputStream.readBytes();
                        } else if (readTag == 26) {
                            this.bitField0 |= 4;
                            this.manufacturer = codedInputStream.readBytes();
                        } else if (readTag == 34) {
                            this.bitField0 |= 8;
                            this.terminalType = codedInputStream.readBytes();
                        } else if (readTag == 40) {
                            this.bitField0 |= 16;
                            this.resolutionH = codedInputStream.readInt32();
                        } else if (readTag == 48) {
                            this.bitField0 |= 32;
                            this.resolutionV = codedInputStream.readInt32();
                        } else if (readTag == 56) {
                            this.bitField0 |= 64;
                            this.ppi = codedInputStream.readInt32();
                        } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    makeExtensionsImmutable();
                    throw th2;
                }
            }
            makeExtensionsImmutable();
        }
    }

    public interface TerminalInfoOrBuilder extends MessageLiteOrBuilder {
        String getManufacturer();

        ByteString getManufacturerBytes();

        OSType getOs();

        String getOsVersion();

        ByteString getOsVersionBytes();

        int getPpi();

        int getResolutionH();

        int getResolutionV();

        String getTerminalType();

        ByteString getTerminalTypeBytes();

        boolean hasManufacturer();

        boolean hasOs();

        boolean hasOsVersion();

        boolean hasPpi();

        boolean hasResolutionH();

        boolean hasResolutionV();

        boolean hasTerminalType();
    }

    public static final class Ui extends GeneratedMessageLite implements UiOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 7;
        public static final int CATEGORY_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 5;
        public static final int END_TIME_FIELD_NUMBER = 4;
        public static final int EXT_FIELD_NUMBER = 6;
        public static final int PAGE_FIELD_NUMBER = 2;
        public static final Parser<Ui> PARSER = new AbstractParser<Ui>() {
            public Ui parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Ui(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int START_TIME_FIELD_NUMBER = 3;
        public static final Ui defaultInstance;
        public static final long serialVersionUID = 0;
        public long aliasId;
        public int bitField0;
        public Object category;
        public long duration;
        public long endTime;
        public Object ext;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object page;
        public long startTime;

        public static final class Builder extends GeneratedMessageLite.Builder<Ui, Builder> implements UiOrBuilder {
            public long aliasId;
            public int bitField0;
            public Object category = "";
            public long duration;
            public long endTime;
            public Object ext = "";
            public Object page = "";
            public long startTime;

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAliasId() {
                this.bitField0 &= -65;
                this.aliasId = 0;
                return this;
            }

            public Builder clearCategory() {
                this.bitField0 &= -2;
                this.category = Ui.getDefaultInstance().getCategory();
                return this;
            }

            public Builder clearDuration() {
                this.bitField0 &= -17;
                this.duration = 0;
                return this;
            }

            public Builder clearEndTime() {
                this.bitField0 &= -9;
                this.endTime = 0;
                return this;
            }

            public Builder clearExt() {
                this.bitField0 &= -33;
                this.ext = Ui.getDefaultInstance().getExt();
                return this;
            }

            public Builder clearPage() {
                this.bitField0 &= -3;
                this.page = Ui.getDefaultInstance().getPage();
                return this;
            }

            public Builder clearStartTime() {
                this.bitField0 &= -5;
                this.startTime = 0;
                return this;
            }

            public long getAliasId() {
                return this.aliasId;
            }

            public String getCategory() {
                Object obj = this.category;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.category = stringUtf8;
                return stringUtf8;
            }

            public ByteString getCategoryBytes() {
                Object obj = this.category;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.category = copyFromUtf8;
                return copyFromUtf8;
            }

            public long getDuration() {
                return this.duration;
            }

            public long getEndTime() {
                return this.endTime;
            }

            public String getExt() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ext = stringUtf8;
                return stringUtf8;
            }

            public ByteString getExtBytes() {
                Object obj = this.ext;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getPage() {
                Object obj = this.page;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.page = stringUtf8;
                return stringUtf8;
            }

            public ByteString getPageBytes() {
                Object obj = this.page;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.page = copyFromUtf8;
                return copyFromUtf8;
            }

            public long getStartTime() {
                return this.startTime;
            }

            public boolean hasAliasId() {
                return (this.bitField0 & 64) == 64;
            }

            public boolean hasCategory() {
                return (this.bitField0 & 1) == 1;
            }

            public boolean hasDuration() {
                return (this.bitField0 & 16) == 16;
            }

            public boolean hasEndTime() {
                return (this.bitField0 & 8) == 8;
            }

            public boolean hasExt() {
                return (this.bitField0 & 32) == 32;
            }

            public boolean hasPage() {
                return (this.bitField0 & 2) == 2;
            }

            public boolean hasStartTime() {
                return (this.bitField0 & 4) == 4;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setAliasId(long j) {
                this.bitField0 |= 64;
                this.aliasId = j;
                return this;
            }

            public Builder setCategory(String str) {
                if (str != null) {
                    this.bitField0 |= 1;
                    this.category = str;
                    return this;
                }
                throw null;
            }

            public Builder setCategoryBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 1;
                    this.category = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setDuration(long j) {
                this.bitField0 |= 16;
                this.duration = j;
                return this;
            }

            public Builder setEndTime(long j) {
                this.bitField0 |= 8;
                this.endTime = j;
                return this;
            }

            public Builder setExt(String str) {
                if (str != null) {
                    this.bitField0 |= 32;
                    this.ext = str;
                    return this;
                }
                throw null;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 32;
                    this.ext = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setPage(String str) {
                if (str != null) {
                    this.bitField0 |= 2;
                    this.page = str;
                    return this;
                }
                throw null;
            }

            public Builder setPageBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 2;
                    this.page = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setStartTime(long j) {
                this.bitField0 |= 4;
                this.startTime = j;
                return this;
            }

            public Ui build() {
                Ui buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Ui buildPartial() {
                Ui ui = new Ui((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                Object unused = ui.category = this.category;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Object unused2 = ui.page = this.page;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                long unused3 = ui.startTime = this.startTime;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                long unused4 = ui.endTime = this.endTime;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                long unused5 = ui.duration = this.duration;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                Object unused6 = ui.ext = this.ext;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                long unused7 = ui.aliasId = this.aliasId;
                int unused8 = ui.bitField0 = i3;
                return ui;
            }

            public Builder clear() {
                super.clear();
                this.category = "";
                int i2 = this.bitField0 & -2;
                this.bitField0 = i2;
                this.page = "";
                int i3 = i2 & -3;
                this.bitField0 = i3;
                this.startTime = 0;
                int i4 = i3 & -5;
                this.bitField0 = i4;
                this.endTime = 0;
                int i5 = i4 & -9;
                this.bitField0 = i5;
                this.duration = 0;
                int i6 = i5 & -17;
                this.bitField0 = i6;
                this.ext = "";
                int i7 = i6 & -33;
                this.bitField0 = i7;
                this.aliasId = 0;
                this.bitField0 = i7 & -65;
                return this;
            }

            public Ui getDefaultInstanceForType() {
                return Ui.getDefaultInstance();
            }

            public Builder mergeFrom(Ui ui) {
                if (ui == Ui.getDefaultInstance()) {
                    return this;
                }
                if (ui.hasCategory()) {
                    this.bitField0 |= 1;
                    this.category = ui.category;
                }
                if (ui.hasPage()) {
                    this.bitField0 |= 2;
                    this.page = ui.page;
                }
                if (ui.hasStartTime()) {
                    setStartTime(ui.getStartTime());
                }
                if (ui.hasEndTime()) {
                    setEndTime(ui.getEndTime());
                }
                if (ui.hasDuration()) {
                    setDuration(ui.getDuration());
                }
                if (ui.hasExt()) {
                    this.bitField0 |= 32;
                    this.ext = ui.ext;
                }
                if (ui.hasAliasId()) {
                    setAliasId(ui.getAliasId());
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Ui ui;
                Ui ui2 = null;
                try {
                    Ui parsePartialFrom = Ui.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    ui = (Ui) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    ui2 = ui;
                }
                if (ui2 != null) {
                    mergeFrom(ui2);
                }
                throw th;
            }
        }

        static {
            Ui ui = new Ui(true);
            defaultInstance = ui;
            ui.initFields();
        }

        public static Ui getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.category = "";
            this.page = "";
            this.startTime = 0;
            this.endTime = 0;
            this.duration = 0;
            this.ext = "";
            this.aliasId = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Ui parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Ui parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public long getAliasId() {
            return this.aliasId;
        }

        public String getCategory() {
            Object obj = this.category;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.category = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getCategoryBytes() {
            Object obj = this.category;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.category = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getDuration() {
            return this.duration;
        }

        public long getEndTime() {
            return this.endTime;
        }

        public String getExt() {
            Object obj = this.ext;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getExtBytes() {
            Object obj = this.ext;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ext = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getPage() {
            Object obj = this.page;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.page = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getPageBytes() {
            Object obj = this.page;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.page = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<Ui> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeBytesSize(1, getCategoryBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                i3 += CodedOutputStream.computeBytesSize(2, getPageBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                i3 += CodedOutputStream.computeInt64Size(3, this.startTime);
            }
            if ((this.bitField0 & 8) == 8) {
                i3 += CodedOutputStream.computeInt64Size(4, this.endTime);
            }
            if ((this.bitField0 & 16) == 16) {
                i3 += CodedOutputStream.computeInt64Size(5, this.duration);
            }
            if ((this.bitField0 & 32) == 32) {
                i3 += CodedOutputStream.computeBytesSize(6, getExtBytes());
            }
            if ((this.bitField0 & 64) == 64) {
                i3 += CodedOutputStream.computeInt64Size(7, this.aliasId);
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public long getStartTime() {
            return this.startTime;
        }

        public boolean hasAliasId() {
            return (this.bitField0 & 64) == 64;
        }

        public boolean hasCategory() {
            return (this.bitField0 & 1) == 1;
        }

        public boolean hasDuration() {
            return (this.bitField0 & 16) == 16;
        }

        public boolean hasEndTime() {
            return (this.bitField0 & 8) == 8;
        }

        public boolean hasExt() {
            return (this.bitField0 & 32) == 32;
        }

        public boolean hasPage() {
            return (this.bitField0 & 2) == 2;
        }

        public boolean hasStartTime() {
            return (this.bitField0 & 4) == 4;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getCategoryBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getPageBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeInt64(3, this.startTime);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(4, this.endTime);
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeInt64(5, this.duration);
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeBytes(6, getExtBytes());
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeInt64(7, this.aliasId);
            }
        }

        public static Builder newBuilder(Ui ui) {
            return newBuilder().mergeFrom(ui);
        }

        public static Ui parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Ui parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Ui getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Ui(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Ui parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Ui parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Ui parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public Ui(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public static Ui parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Ui parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Ui parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Ui(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.bitField0 |= 1;
                            this.category = codedInputStream.readBytes();
                        } else if (readTag == 18) {
                            this.bitField0 |= 2;
                            this.page = codedInputStream.readBytes();
                        } else if (readTag == 24) {
                            this.bitField0 |= 4;
                            this.startTime = codedInputStream.readInt64();
                        } else if (readTag == 32) {
                            this.bitField0 |= 8;
                            this.endTime = codedInputStream.readInt64();
                        } else if (readTag == 40) {
                            this.bitField0 |= 16;
                            this.duration = codedInputStream.readInt64();
                        } else if (readTag == 50) {
                            this.bitField0 |= 32;
                            this.ext = codedInputStream.readBytes();
                        } else if (readTag == 56) {
                            this.bitField0 |= 64;
                            this.aliasId = codedInputStream.readInt64();
                        } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th2) {
                    makeExtensionsImmutable();
                    throw th2;
                }
            }
            makeExtensionsImmutable();
        }
    }

    public interface UiOrBuilder extends MessageLiteOrBuilder {
        long getAliasId();

        String getCategory();

        ByteString getCategoryBytes();

        long getDuration();

        long getEndTime();

        String getExt();

        ByteString getExtBytes();

        String getPage();

        ByteString getPageBytes();

        long getStartTime();

        boolean hasAliasId();

        boolean hasCategory();

        boolean hasDuration();

        boolean hasEndTime();

        boolean hasExt();

        boolean hasPage();

        boolean hasStartTime();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
