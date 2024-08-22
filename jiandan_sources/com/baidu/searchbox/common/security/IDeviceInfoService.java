package com.baidu.searchbox.common.security;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IDeviceInfoService extends IInterface {

    public static class Default implements IDeviceInfoService {
        public IBinder asBinder() {
            return null;
        }

        public DeviceIdBag getAndroidId(String str, String str2) throws RemoteException {
            return null;
        }

        public DeviceIdBagMap getDeviceInfos(String str, String str2, int i2, boolean z) throws RemoteException {
            return null;
        }

        public DeviceIdBag getHarmonyVersion(String str, String str2) throws RemoteException {
            return null;
        }

        public DeviceIdBag getIMEI(String str, String str2, boolean z) throws RemoteException {
            return null;
        }

        public DeviceIdBag getMacAddress(String str, String str2) throws RemoteException {
            return null;
        }

        public DeviceIdBag getManufacturer(String str, String str2) throws RemoteException {
            return null;
        }

        public DeviceIdBag getModel(String str, String str2) throws RemoteException {
            return null;
        }

        public DeviceIdBag getOAID(String str, String str2) throws RemoteException {
            return null;
        }

        public DeviceIdBag getOperator(String str, String str2, boolean z) throws RemoteException {
            return null;
        }

        public DeviceIdBag getOsVersion(String str, String str2) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDeviceInfoService {
        public static final String DESCRIPTOR = "com.baidu.searchbox.common.security.IDeviceInfoService";
        public static final int TRANSACTION_getAndroidId = 4;
        public static final int TRANSACTION_getDeviceInfos = 1;
        public static final int TRANSACTION_getHarmonyVersion = 9;
        public static final int TRANSACTION_getIMEI = 3;
        public static final int TRANSACTION_getMacAddress = 2;
        public static final int TRANSACTION_getManufacturer = 10;
        public static final int TRANSACTION_getModel = 6;
        public static final int TRANSACTION_getOAID = 5;
        public static final int TRANSACTION_getOperator = 8;
        public static final int TRANSACTION_getOsVersion = 7;

        public static class Proxy implements IDeviceInfoService {
            public static IDeviceInfoService sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public DeviceIdBag getAndroidId(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAndroidId(str, str2);
                    }
                    obtain2.readException();
                    DeviceIdBag createFromParcel = obtain2.readInt() != 0 ? DeviceIdBag.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DeviceIdBagMap getDeviceInfos(String str, String str2, int i2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDeviceInfos(str, str2, i2, z);
                    }
                    obtain2.readException();
                    DeviceIdBagMap qw = obtain2.readInt() != 0 ? DeviceIdBagMap.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return qw;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DeviceIdBag getHarmonyVersion(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getHarmonyVersion(str, str2);
                    }
                    obtain2.readException();
                    DeviceIdBag createFromParcel = obtain2.readInt() != 0 ? DeviceIdBag.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DeviceIdBag getIMEI(String str, String str2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getIMEI(str, str2, z);
                    }
                    obtain2.readException();
                    DeviceIdBag createFromParcel = obtain2.readInt() != 0 ? DeviceIdBag.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public DeviceIdBag getMacAddress(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMacAddress(str, str2);
                    }
                    obtain2.readException();
                    DeviceIdBag createFromParcel = obtain2.readInt() != 0 ? DeviceIdBag.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DeviceIdBag getManufacturer(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getManufacturer(str, str2);
                    }
                    obtain2.readException();
                    DeviceIdBag createFromParcel = obtain2.readInt() != 0 ? DeviceIdBag.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DeviceIdBag getModel(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getModel(str, str2);
                    }
                    obtain2.readException();
                    DeviceIdBag createFromParcel = obtain2.readInt() != 0 ? DeviceIdBag.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DeviceIdBag getOAID(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOAID(str, str2);
                    }
                    obtain2.readException();
                    DeviceIdBag createFromParcel = obtain2.readInt() != 0 ? DeviceIdBag.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DeviceIdBag getOperator(String str, String str2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOperator(str, str2, z);
                    }
                    obtain2.readException();
                    DeviceIdBag createFromParcel = obtain2.readInt() != 0 ? DeviceIdBag.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DeviceIdBag getOsVersion(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOsVersion(str, str2);
                    }
                    obtain2.readException();
                    DeviceIdBag createFromParcel = obtain2.readInt() != 0 ? DeviceIdBag.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDeviceInfoService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceInfoService)) {
                return new Proxy(iBinder);
            }
            return (IDeviceInfoService) queryLocalInterface;
        }

        public static IDeviceInfoService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDeviceInfoService iDeviceInfoService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iDeviceInfoService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iDeviceInfoService;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1598968902) {
                switch (i2) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        DeviceIdBagMap deviceInfos = getDeviceInfos(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        if (deviceInfos != null) {
                            parcel2.writeInt(1);
                            deviceInfos.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        DeviceIdBag macAddress = getMacAddress(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (macAddress != null) {
                            parcel2.writeInt(1);
                            macAddress.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        DeviceIdBag imei = getIMEI(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        if (imei != null) {
                            parcel2.writeInt(1);
                            imei.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        DeviceIdBag androidId = getAndroidId(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (androidId != null) {
                            parcel2.writeInt(1);
                            androidId.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        DeviceIdBag oaid = getOAID(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (oaid != null) {
                            parcel2.writeInt(1);
                            oaid.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        DeviceIdBag model = getModel(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (model != null) {
                            parcel2.writeInt(1);
                            model.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        DeviceIdBag osVersion = getOsVersion(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (osVersion != null) {
                            parcel2.writeInt(1);
                            osVersion.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        DeviceIdBag operator = getOperator(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        if (operator != null) {
                            parcel2.writeInt(1);
                            operator.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        DeviceIdBag harmonyVersion = getHarmonyVersion(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (harmonyVersion != null) {
                            parcel2.writeInt(1);
                            harmonyVersion.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        DeviceIdBag manufacturer = getManufacturer(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (manufacturer != null) {
                            parcel2.writeInt(1);
                            manufacturer.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
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

    DeviceIdBag getAndroidId(String str, String str2) throws RemoteException;

    DeviceIdBagMap getDeviceInfos(String str, String str2, int i2, boolean z) throws RemoteException;

    DeviceIdBag getHarmonyVersion(String str, String str2) throws RemoteException;

    DeviceIdBag getIMEI(String str, String str2, boolean z) throws RemoteException;

    DeviceIdBag getMacAddress(String str, String str2) throws RemoteException;

    DeviceIdBag getManufacturer(String str, String str2) throws RemoteException;

    DeviceIdBag getModel(String str, String str2) throws RemoteException;

    DeviceIdBag getOAID(String str, String str2) throws RemoteException;

    DeviceIdBag getOperator(String str, String str2, boolean z) throws RemoteException;

    DeviceIdBag getOsVersion(String str, String str2) throws RemoteException;
}
