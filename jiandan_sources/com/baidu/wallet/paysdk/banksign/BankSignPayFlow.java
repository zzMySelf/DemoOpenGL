package com.baidu.wallet.paysdk.banksign;

import android.content.Context;

public class BankSignPayFlow {
    public Action a;
    public a b;

    /* renamed from: com.baidu.wallet.paysdk.banksign.BankSignPayFlow$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.baidu.wallet.paysdk.banksign.BankSignPayFlow$Action[] r0 = com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.baidu.wallet.paysdk.banksign.BankSignPayFlow$Action r1 = com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action.ShowGuide     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.wallet.paysdk.banksign.BankSignPayFlow$Action r1 = com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action.Fail     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.wallet.paysdk.banksign.BankSignPayFlow$Action r1 = com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action.Unknown     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.baidu.wallet.paysdk.banksign.BankSignPayFlow$Action r1 = com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action.JumpResign     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.baidu.wallet.paysdk.banksign.BankSignPayFlow$Action r1 = com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action.Pay     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.baidu.wallet.paysdk.banksign.BankSignPayFlow$Action r1 = com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action.BindCard     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.baidu.wallet.paysdk.banksign.BankSignPayFlow$Action r1 = com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action.Cancel     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.baidu.wallet.paysdk.banksign.BankSignPayFlow$Action r1 = com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action.FirstFail     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.baidu.wallet.paysdk.banksign.BankSignPayFlow$Action r1 = com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action.ChangePayType     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.banksign.BankSignPayFlow.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Action {
        Null,
        ShowGuide,
        FirstFail,
        Fail,
        Unknown,
        JumpResign,
        Pay,
        Cancel,
        ChangePayType,
        BindCard
    }

    public static class a {
        public static BankSignPayFlow a = new BankSignPayFlow((AnonymousClass1) null);
    }

    public /* synthetic */ BankSignPayFlow(AnonymousClass1 r1) {
        this();
    }

    public static BankSignPayFlow a() {
        return a.a;
    }

    public BankSignPayFlow() {
        this.a = Action.Null;
        this.b = new b();
    }

    public void a(Action action) {
        if (action == null) {
            action = Action.Null;
        }
        this.a = action;
    }

    public void a(Context context) {
        Action action;
        if (this.b != null && (action = this.a) != null && Action.Null != action) {
            switch (AnonymousClass1.a[action.ordinal()]) {
                case 1:
                    this.b.f(context);
                    return;
                case 2:
                case 3:
                case 4:
                    this.b.b(context);
                    return;
                case 5:
                    this.b.c(context);
                    return;
                case 6:
                    this.b.d(context);
                    this.a = Action.Cancel;
                    return;
                case 7:
                case 8:
                    this.b.a(context);
                    return;
                case 9:
                    this.b.e(context);
                    this.a = Action.Cancel;
                    return;
                default:
                    return;
            }
        }
    }
}
