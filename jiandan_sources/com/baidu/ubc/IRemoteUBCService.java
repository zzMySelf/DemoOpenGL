package com.baidu.ubc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IRemoteUBCService extends IInterface {

    public static class Default implements IRemoteUBCService {
        public IBinder asBinder() {
            return null;
        }

        public void flowAddEvent(Flow flow, String str, String str2) throws RemoteException {
        }

        public void flowAddEventWithTime(Flow flow, String str, String str2, long j) throws RemoteException {
        }

        public void flowCancel(Flow flow) throws RemoteException {
        }

        public void flowEnd(Flow flow) throws RemoteException {
        }

        public void flowEndSlot(Flow flow, String str) throws RemoteException {
        }

        public void flowSetValue(Flow flow, String str) throws RemoteException {
        }

        public void flowSetValueWithDuration(Flow flow, String str) throws RemoteException {
        }

        public void flowStartSlot(Flow flow, String str, String str2) throws RemoteException {
        }

        public void flush() throws RemoteException {
        }

        public String getUploadType(String str) throws RemoteException {
            return null;
        }

        public Flow ubcBeginFlow(String str, String str2, int i2) throws RemoteException {
            return null;
        }

        public Flow ubcBeginFlowWithBizInfo(String str, String str2, int i2, String str3) throws RemoteException {
            return null;
        }

        public void ubcOnEvent(String str, String str2, int i2) throws RemoteException {
        }

        public void ubcOnEventWithBizInfo(String str, String str2, int i2, String str3) throws RemoteException {
        }

        public void upload() throws RemoteException {
        }

        public void uploadFailedData() throws RemoteException {
        }

        public void uploadLocalDatas() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IRemoteUBCService {
        public static final String DESCRIPTOR = "com.baidu.ubc.IRemoteUBCService";
        public static final int TRANSACTION_flowAddEvent = 5;
        public static final int TRANSACTION_flowAddEventWithTime = 6;
        public static final int TRANSACTION_flowCancel = 11;
        public static final int TRANSACTION_flowEnd = 12;
        public static final int TRANSACTION_flowEndSlot = 10;
        public static final int TRANSACTION_flowSetValue = 7;
        public static final int TRANSACTION_flowSetValueWithDuration = 8;
        public static final int TRANSACTION_flowStartSlot = 9;
        public static final int TRANSACTION_flush = 17;
        public static final int TRANSACTION_getUploadType = 14;
        public static final int TRANSACTION_ubcBeginFlow = 3;
        public static final int TRANSACTION_ubcBeginFlowWithBizInfo = 4;
        public static final int TRANSACTION_ubcOnEvent = 1;
        public static final int TRANSACTION_ubcOnEventWithBizInfo = 2;
        public static final int TRANSACTION_upload = 15;
        public static final int TRANSACTION_uploadFailedData = 16;
        public static final int TRANSACTION_uploadLocalDatas = 13;

        public static class Proxy implements IRemoteUBCService {
            public static IRemoteUBCService sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void flowAddEvent(Flow flow, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().flowAddEvent(flow, str, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void flowAddEventWithTime(Flow flow, String str, String str2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().flowAddEventWithTime(flow, str, str2, j);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void flowCancel(Flow flow) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().flowCancel(flow);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void flowEnd(Flow flow) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(12, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().flowEnd(flow);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void flowEndSlot(Flow flow, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().flowEndSlot(flow, str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void flowSetValue(Flow flow, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().flowSetValue(flow, str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void flowSetValueWithDuration(Flow flow, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().flowSetValueWithDuration(flow, str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void flowStartSlot(Flow flow, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flow != null) {
                        obtain.writeInt(1);
                        flow.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().flowStartSlot(flow, str, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void flush() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(17, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().flush();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public String getUploadType(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUploadType(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Flow ubcBeginFlow(String str, String str2, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().ubcBeginFlow(str, str2, i2);
                    }
                    obtain2.readException();
                    Flow createFromParcel = obtain2.readInt() != 0 ? Flow.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Flow ubcBeginFlowWithBizInfo(String str, String str2, int i2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeString(str3);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().ubcBeginFlowWithBizInfo(str, str2, i2, str3);
                    }
                    obtain2.readException();
                    Flow createFromParcel = obtain2.readInt() != 0 ? Flow.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void ubcOnEvent(String str, String str2, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().ubcOnEvent(str, str2, i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void ubcOnEventWithBizInfo(String str, String str2, int i2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeString(str3);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().ubcOnEventWithBizInfo(str, str2, i2, str3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void upload() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(15, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().upload();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void uploadFailedData() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(16, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().uploadFailedData();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void uploadLocalDatas() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().uploadLocalDatas();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteUBCService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteUBCService)) {
                return new Proxy(iBinder);
            }
            return (IRemoteUBCService) queryLocalInterface;
        }

        public static IRemoteUBCService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteUBCService iRemoteUBCService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iRemoteUBCService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iRemoteUBCService;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1598968902) {
                Flow flow = null;
                switch (i2) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        ubcOnEvent(parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        ubcOnEventWithBizInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        Flow ubcBeginFlow = ubcBeginFlow(parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        if (ubcBeginFlow != null) {
                            parcel2.writeInt(1);
                            ubcBeginFlow.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        Flow ubcBeginFlowWithBizInfo = ubcBeginFlowWithBizInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        if (ubcBeginFlowWithBizInfo != null) {
                            parcel2.writeInt(1);
                            ubcBeginFlowWithBizInfo.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            flow = Flow.CREATOR.createFromParcel(parcel);
                        }
                        flowAddEvent(flow, parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            flow = Flow.CREATOR.createFromParcel(parcel);
                        }
                        flowAddEventWithTime(flow, parcel.readString(), parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            flow = Flow.CREATOR.createFromParcel(parcel);
                        }
                        flowSetValue(flow, parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            flow = Flow.CREATOR.createFromParcel(parcel);
                        }
                        flowSetValueWithDuration(flow, parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            flow = Flow.CREATOR.createFromParcel(parcel);
                        }
                        flowStartSlot(flow, parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            flow = Flow.CREATOR.createFromParcel(parcel);
                        }
                        flowEndSlot(flow, parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            flow = Flow.CREATOR.createFromParcel(parcel);
                        }
                        flowCancel(flow);
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            flow = Flow.CREATOR.createFromParcel(parcel);
                        }
                        flowEnd(flow);
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        uploadLocalDatas();
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        String uploadType = getUploadType(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(uploadType);
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        upload();
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        uploadFailedData();
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface(DESCRIPTOR);
                        flush();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void flowAddEvent(Flow flow, String str, String str2) throws RemoteException;

    void flowAddEventWithTime(Flow flow, String str, String str2, long j) throws RemoteException;

    void flowCancel(Flow flow) throws RemoteException;

    void flowEnd(Flow flow) throws RemoteException;

    void flowEndSlot(Flow flow, String str) throws RemoteException;

    void flowSetValue(Flow flow, String str) throws RemoteException;

    void flowSetValueWithDuration(Flow flow, String str) throws RemoteException;

    void flowStartSlot(Flow flow, String str, String str2) throws RemoteException;

    void flush() throws RemoteException;

    String getUploadType(String str) throws RemoteException;

    Flow ubcBeginFlow(String str, String str2, int i2) throws RemoteException;

    Flow ubcBeginFlowWithBizInfo(String str, String str2, int i2, String str3) throws RemoteException;

    void ubcOnEvent(String str, String str2, int i2) throws RemoteException;

    void ubcOnEventWithBizInfo(String str, String str2, int i2, String str3) throws RemoteException;

    void upload() throws RemoteException;

    void uploadFailedData() throws RemoteException;

    void uploadLocalDatas() throws RemoteException;
}
