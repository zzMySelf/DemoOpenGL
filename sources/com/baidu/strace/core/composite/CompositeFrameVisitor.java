package com.baidu.strace.core.composite;

import com.baidu.strace.core.FrameVisitor;

public class CompositeFrameVisitor extends FrameVisitor {
    private FrameVisitor[] mVisitors;

    public CompositeFrameVisitor(FrameVisitor... visitors) {
        this.mVisitors = visitors;
    }

    public void visitBegin() {
        for (FrameVisitor visitor : this.mVisitors) {
            visitor.visitBegin();
        }
    }

    public void visitMethodEnter(String methodName, int threadId, long timestampNs) {
        for (FrameVisitor visitor : this.mVisitors) {
            visitor.visitMethodEnter(methodName, threadId, timestampNs);
        }
    }

    public void visitMethodExit(String methodName, int threadId, long timestampNs) {
        for (FrameVisitor visitor : this.mVisitors) {
            visitor.visitMethodExit(methodName, threadId, timestampNs);
        }
    }

    public void visitEnd() {
        for (FrameVisitor visitor : this.mVisitors) {
            visitor.visitEnd();
        }
    }
}
