package com.baidu.searchbox.feedback.log;

import com.baidu.pyramid.annotation.component.DefaultListHolder;
import com.baidu.pyramid.annotation.component.ListHolder;
import com.baidu.searchbox.config.AppConfig;

public class FeedbackLogAction {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "FeedbackLogAction";
    ListHolder<ILogAction> mLogActionList;

    public void initmLogActionList() {
        DefaultListHolder create = DefaultListHolder.create();
        this.mLogActionList = create;
        create.setList(new ILogAction_FeedbackLogAction_ListProvider());
    }

    /* synthetic */ FeedbackLogAction(AnonymousClass1 x0) {
        this();
        initmLogActionList();
    }

    private FeedbackLogAction() {
    }

    private static class Inner {
        /* access modifiers changed from: private */
        public static final FeedbackLogAction sInstance = new FeedbackLogAction((AnonymousClass1) null);

        private Inner() {
        }
    }

    public static FeedbackLogAction getInstance() {
        return Inner.sInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatch(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            r1 = 1
            java.lang.String r2 = " json="
            r3 = 0
            java.lang.String r4 = "FeedbackLogAction"
            if (r0 != 0) goto L_0x009c
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L_0x009c
            com.baidu.pyramid.annotation.component.ListHolder<com.baidu.searchbox.feedback.log.ILogAction> r0 = r9.mLogActionList
            if (r0 == 0) goto L_0x009c
            java.util.List r0 = r0.getList()
            if (r0 == 0) goto L_0x009c
            com.baidu.pyramid.annotation.component.ListHolder<com.baidu.searchbox.feedback.log.ILogAction> r0 = r9.mLogActionList
            java.util.List r0 = r0.getList()
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0029
            goto L_0x009c
        L_0x0029:
            com.baidu.pyramid.annotation.component.ListHolder<com.baidu.searchbox.feedback.log.ILogAction> r0 = r9.mLogActionList
            java.util.List r0 = r0.getList()
            java.util.Iterator r5 = r0.iterator()
        L_0x0033:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0079
            java.lang.Object r6 = r5.next()
            com.baidu.searchbox.feedback.log.ILogAction r6 = (com.baidu.searchbox.feedback.log.ILogAction) r6
            java.lang.String r7 = r6.getType()
            boolean r8 = android.text.TextUtils.equals(r7, r10)
            if (r8 != 0) goto L_0x0053
            java.lang.String r8 = "allType"
            boolean r8 = android.text.TextUtils.equals(r7, r8)
            if (r8 == 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            goto L_0x0033
        L_0x0053:
            r6.dispatch(r11)
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x0078
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "function dispatch pass: type="
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.StringBuilder r3 = r3.append(r10)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.StringBuilder r2 = r2.append(r11)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r4, r2)
        L_0x0078:
            return r1
        L_0x0079:
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x009b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "function dispatch params not found : type="
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.StringBuilder r1 = r1.append(r10)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r4, r1)
        L_0x009b:
            return r3
        L_0x009c:
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x00da
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "function dispatch mLogActionList is null = "
            java.lang.StringBuilder r0 = r0.append(r5)
            com.baidu.pyramid.annotation.component.ListHolder<com.baidu.searchbox.feedback.log.ILogAction> r5 = r9.mLogActionList
            if (r5 != 0) goto L_0x00b0
            goto L_0x00b1
        L_0x00b0:
            r1 = r3
        L_0x00b1:
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r4, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "function dispatch params error: type="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r4, r0)
        L_0x00da:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feedback.log.FeedbackLogAction.dispatch(java.lang.String, java.lang.String):boolean");
    }
}
