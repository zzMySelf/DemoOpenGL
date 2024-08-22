package com.baidu.android.pushservice.z.m;

public enum l {
    MSG_TYPE_INVALID(-1),
    MSG_TYPE_SINGLE_PRIVATE(0),
    MSG_TYPE_MULTI_PRIVATE(1),
    MSG_TYPE_SINGLE_PUBLIC(2),
    MSG_TYPE_MULTI_PUBLIC(3),
    MSG_TYPE_MULTI_PRIVATE_NOTIFICATION(5),
    MSG_TYPE_PRIVATE_MESSAGE(6),
    MSG_TYPE_CLEAR_MESSAGE(8),
    MSG_TYPE_APP_PRIORITY(30),
    MSG_TYPE_LOCAL_PUSH_MESSAGE(31),
    MSG_TYPE_ICON_BADGE_MESSAGE(32),
    MSG_TYPE_INNERBIND(101),
    MSG_TYPE_APPSTAT_COMMAND(104);
    

    /* renamed from: a  reason: collision with root package name */
    public int f8884a;

    /* access modifiers changed from: public */
    l(int i2) {
        this.f8884a = i2;
    }

    public static l a(int i2) {
        if (i2 == 5) {
            return MSG_TYPE_MULTI_PRIVATE_NOTIFICATION;
        }
        if (i2 == 6) {
            return MSG_TYPE_PRIVATE_MESSAGE;
        }
        if (i2 == 8) {
            return MSG_TYPE_CLEAR_MESSAGE;
        }
        if (i2 == 101) {
            return MSG_TYPE_INNERBIND;
        }
        if (i2 == 104) {
            return MSG_TYPE_APPSTAT_COMMAND;
        }
        switch (i2) {
            case 0:
                return MSG_TYPE_SINGLE_PRIVATE;
            case 1:
                return MSG_TYPE_MULTI_PRIVATE;
            case 2:
                return MSG_TYPE_SINGLE_PUBLIC;
            case 3:
                return MSG_TYPE_MULTI_PUBLIC;
            default:
                switch (i2) {
                    case 30:
                        return MSG_TYPE_APP_PRIORITY;
                    case 31:
                        return MSG_TYPE_LOCAL_PUSH_MESSAGE;
                    case 32:
                        return MSG_TYPE_ICON_BADGE_MESSAGE;
                    default:
                        return MSG_TYPE_INVALID;
                }
        }
    }

    public int a() {
        return this.f8884a;
    }
}
