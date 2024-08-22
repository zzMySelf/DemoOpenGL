package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.MessageOrBuilder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RepeatedFieldBuilderV3<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {
    public List<SingleFieldBuilderV3<MType, BType, IType>> builders;
    public BuilderExternalList<MType, BType, IType> externalBuilderList;
    public MessageExternalList<MType, BType, IType> externalMessageList;
    public MessageOrBuilderExternalList<MType, BType, IType> externalMessageOrBuilderList;
    public boolean isClean;
    public boolean isMessagesListMutable;
    public List<MType> messages;
    public AbstractMessage.BuilderParent parent;

    public static class BuilderExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<BType> implements List<BType> {
        public RepeatedFieldBuilderV3<MType, BType, IType> builder;

        public BuilderExternalList(RepeatedFieldBuilderV3<MType, BType, IType> repeatedFieldBuilderV3) {
            this.builder = repeatedFieldBuilderV3;
        }

        public void incrementModCount() {
            this.modCount++;
        }

        public int size() {
            return this.builder.getCount();
        }

        public BType get(int i2) {
            return this.builder.getBuilder(i2);
        }
    }

    public static class MessageExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<MType> implements List<MType> {
        public RepeatedFieldBuilderV3<MType, BType, IType> builder;

        public MessageExternalList(RepeatedFieldBuilderV3<MType, BType, IType> repeatedFieldBuilderV3) {
            this.builder = repeatedFieldBuilderV3;
        }

        public void incrementModCount() {
            this.modCount++;
        }

        public int size() {
            return this.builder.getCount();
        }

        public MType get(int i2) {
            return this.builder.getMessage(i2);
        }
    }

    public static class MessageOrBuilderExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<IType> implements List<IType> {
        public RepeatedFieldBuilderV3<MType, BType, IType> builder;

        public MessageOrBuilderExternalList(RepeatedFieldBuilderV3<MType, BType, IType> repeatedFieldBuilderV3) {
            this.builder = repeatedFieldBuilderV3;
        }

        public void incrementModCount() {
            this.modCount++;
        }

        public int size() {
            return this.builder.getCount();
        }

        public IType get(int i2) {
            return this.builder.getMessageOrBuilder(i2);
        }
    }

    public RepeatedFieldBuilderV3(List<MType> list, boolean z, AbstractMessage.BuilderParent builderParent, boolean z2) {
        this.messages = list;
        this.isMessagesListMutable = z;
        this.parent = builderParent;
        this.isClean = z2;
    }

    private void ensureBuilders() {
        if (this.builders == null) {
            this.builders = new ArrayList(this.messages.size());
            for (int i2 = 0; i2 < this.messages.size(); i2++) {
                this.builders.add((Object) null);
            }
        }
    }

    private void ensureMutableMessageList() {
        if (!this.isMessagesListMutable) {
            this.messages = new ArrayList(this.messages);
            this.isMessagesListMutable = true;
        }
    }

    private void incrementModCounts() {
        MessageExternalList<MType, BType, IType> messageExternalList = this.externalMessageList;
        if (messageExternalList != null) {
            messageExternalList.incrementModCount();
        }
        BuilderExternalList<MType, BType, IType> builderExternalList = this.externalBuilderList;
        if (builderExternalList != null) {
            builderExternalList.incrementModCount();
        }
        MessageOrBuilderExternalList<MType, BType, IType> messageOrBuilderExternalList = this.externalMessageOrBuilderList;
        if (messageOrBuilderExternalList != null) {
            messageOrBuilderExternalList.incrementModCount();
        }
    }

    private void onChanged() {
        AbstractMessage.BuilderParent builderParent;
        if (this.isClean && (builderParent = this.parent) != null) {
            builderParent.markDirty();
            this.isClean = false;
        }
    }

    public RepeatedFieldBuilderV3<MType, BType, IType> addAllMessages(Iterable<? extends MType> iterable) {
        Iterator<? extends MType> it = iterable.iterator();
        while (it.hasNext()) {
            Internal.checkNotNull((AbstractMessage) it.next());
        }
        int i2 = -1;
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() == 0) {
                return this;
            }
            i2 = collection.size();
        }
        ensureMutableMessageList();
        if (i2 >= 0) {
            List<MType> list = this.messages;
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + i2);
            }
        }
        Iterator<? extends MType> it2 = iterable.iterator();
        while (it2.hasNext()) {
            addMessage((AbstractMessage) it2.next());
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public BType addBuilder(MType mtype) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilderV3 singleFieldBuilderV3 = new SingleFieldBuilderV3(mtype, this, this.isClean);
        this.messages.add((Object) null);
        this.builders.add(singleFieldBuilderV3);
        onChanged();
        incrementModCounts();
        return singleFieldBuilderV3.getBuilder();
    }

    public RepeatedFieldBuilderV3<MType, BType, IType> addMessage(MType mtype) {
        Internal.checkNotNull(mtype);
        ensureMutableMessageList();
        this.messages.add(mtype);
        List<SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
        if (list != null) {
            list.add((Object) null);
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public List<MType> build() {
        boolean z;
        this.isClean = true;
        if (!this.isMessagesListMutable && this.builders == null) {
            return this.messages;
        }
        if (!this.isMessagesListMutable) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.messages.size()) {
                    z = true;
                    break;
                }
                Message message = (Message) this.messages.get(i2);
                SingleFieldBuilderV3 singleFieldBuilderV3 = this.builders.get(i2);
                if (singleFieldBuilderV3 != null && singleFieldBuilderV3.build() != message) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                return this.messages;
            }
        }
        ensureMutableMessageList();
        for (int i3 = 0; i3 < this.messages.size(); i3++) {
            this.messages.set(i3, getMessage(i3, true));
        }
        List<MType> unmodifiableList = Collections.unmodifiableList(this.messages);
        this.messages = unmodifiableList;
        this.isMessagesListMutable = false;
        return unmodifiableList;
    }

    public void clear() {
        this.messages = Collections.emptyList();
        this.isMessagesListMutable = false;
        List<SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
        if (list != null) {
            for (SingleFieldBuilderV3 next : list) {
                if (next != null) {
                    next.dispose();
                }
            }
            this.builders = null;
        }
        onChanged();
        incrementModCounts();
    }

    public void dispose() {
        this.parent = null;
    }

    public BType getBuilder(int i2) {
        ensureBuilders();
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.builders.get(i2);
        if (singleFieldBuilderV3 == null) {
            SingleFieldBuilderV3 singleFieldBuilderV32 = new SingleFieldBuilderV3((AbstractMessage) this.messages.get(i2), this, this.isClean);
            this.builders.set(i2, singleFieldBuilderV32);
            singleFieldBuilderV3 = singleFieldBuilderV32;
        }
        return singleFieldBuilderV3.getBuilder();
    }

    public List<BType> getBuilderList() {
        if (this.externalBuilderList == null) {
            this.externalBuilderList = new BuilderExternalList<>(this);
        }
        return this.externalBuilderList;
    }

    public int getCount() {
        return this.messages.size();
    }

    public MType getMessage(int i2) {
        return getMessage(i2, false);
    }

    public List<MType> getMessageList() {
        if (this.externalMessageList == null) {
            this.externalMessageList = new MessageExternalList<>(this);
        }
        return this.externalMessageList;
    }

    public IType getMessageOrBuilder(int i2) {
        List<SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
        if (list == null) {
            return (MessageOrBuilder) this.messages.get(i2);
        }
        SingleFieldBuilderV3 singleFieldBuilderV3 = list.get(i2);
        if (singleFieldBuilderV3 == null) {
            return (MessageOrBuilder) this.messages.get(i2);
        }
        return singleFieldBuilderV3.getMessageOrBuilder();
    }

    public List<IType> getMessageOrBuilderList() {
        if (this.externalMessageOrBuilderList == null) {
            this.externalMessageOrBuilderList = new MessageOrBuilderExternalList<>(this);
        }
        return this.externalMessageOrBuilderList;
    }

    public boolean isEmpty() {
        return this.messages.isEmpty();
    }

    public void markDirty() {
        onChanged();
    }

    public void remove(int i2) {
        SingleFieldBuilderV3 remove;
        ensureMutableMessageList();
        this.messages.remove(i2);
        List<SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
        if (!(list == null || (remove = list.remove(i2)) == null)) {
            remove.dispose();
        }
        onChanged();
        incrementModCounts();
    }

    public RepeatedFieldBuilderV3<MType, BType, IType> setMessage(int i2, MType mtype) {
        SingleFieldBuilderV3 singleFieldBuilderV3;
        Internal.checkNotNull(mtype);
        ensureMutableMessageList();
        this.messages.set(i2, mtype);
        List<SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
        if (!(list == null || (singleFieldBuilderV3 = list.set(i2, (Object) null)) == null)) {
            singleFieldBuilderV3.dispose();
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    private MType getMessage(int i2, boolean z) {
        List<SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
        if (list == null) {
            return (AbstractMessage) this.messages.get(i2);
        }
        SingleFieldBuilderV3 singleFieldBuilderV3 = list.get(i2);
        if (singleFieldBuilderV3 == null) {
            return (AbstractMessage) this.messages.get(i2);
        }
        return z ? singleFieldBuilderV3.build() : singleFieldBuilderV3.getMessage();
    }

    public RepeatedFieldBuilderV3<MType, BType, IType> addMessage(int i2, MType mtype) {
        Internal.checkNotNull(mtype);
        ensureMutableMessageList();
        this.messages.add(i2, mtype);
        List<SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
        if (list != null) {
            list.add(i2, (Object) null);
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public BType addBuilder(int i2, MType mtype) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilderV3 singleFieldBuilderV3 = new SingleFieldBuilderV3(mtype, this, this.isClean);
        this.messages.add(i2, (Object) null);
        this.builders.add(i2, singleFieldBuilderV3);
        onChanged();
        incrementModCounts();
        return singleFieldBuilderV3.getBuilder();
    }
}
