package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class UnpackingSoSource extends DirectorySoSource {
    private static final String DEPS_FILE_NAME = "dso_deps";
    private static final String INSTANCE_LOCK_FILE_NAME = "dso_instance_lock";
    private static final String LOCK_FILE_NAME = "dso_lock";
    private static final String MANIFEST_FILE_NAME = "dso_manifest";
    private static final byte MANIFEST_VERSION = 1;
    protected static final byte STATE_CLEAN = 1;
    protected static final byte STATE_DIRTY = 0;
    private static final String STATE_FILE_NAME = "dso_state";
    private static final String TAG = "fb-UnpackingSoSource";
    @Nullable
    private String[] mAbis;
    protected final Context mContext;
    @Nullable
    protected String mCorruptedLib;
    @Nullable
    protected FileLocker mInstanceLock;
    private final Map<String, Object> mLibsBeingLoaded = new HashMap();

    protected interface InputDso extends Closeable {
        int available() throws IOException;

        Dso getDso();

        String getFileName();

        InputStream getStream();

        void write(DataOutput dataOutput, byte[] bArr) throws IOException;
    }

    /* access modifiers changed from: protected */
    public abstract Unpacker makeUnpacker(byte b2) throws IOException;

    protected UnpackingSoSource(Context context, String name) {
        super(getSoStorePath(context, name), 1);
        this.mContext = context;
    }

    protected UnpackingSoSource(Context context, File storePath) {
        super(storePath, 1);
        this.mContext = context;
    }

    public static File getSoStorePath(Context context, String name) {
        return new File(context.getApplicationInfo().dataDir + "/" + name);
    }

    public String[] getSoSourceAbis() {
        String[] strArr = this.mAbis;
        if (strArr == null) {
            return super.getSoSourceAbis();
        }
        return strArr;
    }

    public void setSoSourceAbis(String[] abis) {
        this.mAbis = abis;
    }

    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String name2, String hash2) {
            this.name = name2;
            this.hash = hash2;
        }
    }

    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsos2) {
            this.dsos = dsos2;
        }

        static final DsoManifest read(DataInput xdi) throws IOException {
            if (xdi.readByte() == 1) {
                int nrDso = xdi.readInt();
                if (nrDso >= 0) {
                    Dso[] dsos2 = new Dso[nrDso];
                    for (int i2 = 0; i2 < nrDso; i2++) {
                        dsos2[i2] = new Dso(xdi.readUTF(), xdi.readUTF());
                    }
                    return new DsoManifest(dsos2);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void write(DataOutput xdo) throws IOException {
            xdo.writeByte(1);
            xdo.writeInt(this.dsos.length);
            int i2 = 0;
            while (true) {
                Dso[] dsoArr = this.dsos;
                if (i2 < dsoArr.length) {
                    xdo.writeUTF(dsoArr[i2].name);
                    xdo.writeUTF(this.dsos[i2].hash);
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public static class InputDsoStream implements InputDso {
        private final InputStream content;
        private final Dso dso;

        public InputDsoStream(Dso dso2, InputStream content2) {
            this.dso = dso2;
            this.content = content2;
        }

        public void write(DataOutput out, byte[] ioBuffer) throws IOException {
            SysUtil.copyBytes(out, this.content, Integer.MAX_VALUE, ioBuffer);
        }

        public Dso getDso() {
            return this.dso;
        }

        public String getFileName() {
            return this.dso.name;
        }

        public int available() throws IOException {
            return this.content.available();
        }

        public InputStream getStream() {
            return this.content;
        }

        public void close() throws IOException {
            this.content.close();
        }
    }

    protected static abstract class InputDsoIterator implements Closeable {
        public abstract boolean hasNext();

        @Nullable
        public abstract InputDso next() throws IOException;

        protected InputDsoIterator() {
        }

        public void close() throws IOException {
        }
    }

    protected static abstract class Unpacker implements Closeable {
        public abstract DsoManifest getDsoManifest() throws IOException;

        public abstract InputDsoIterator openDsoIterator() throws IOException;

        protected Unpacker() {
        }

        public void close() throws IOException {
        }
    }

    /* access modifiers changed from: private */
    public static void writeState(File stateFileName, byte state) throws IOException {
        RandomAccessFile stateFile;
        try {
            stateFile = new RandomAccessFile(stateFileName, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
            stateFile.seek(0);
            stateFile.write(state);
            stateFile.setLength(stateFile.getFilePointer());
            stateFile.getFD().sync();
            stateFile.close();
            return;
        } catch (SyncFailedException e2) {
            Log.w(TAG, "state file sync failed", e2);
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    /* access modifiers changed from: protected */
    public String getSoNameFromFileName(String fileName) {
        return fileName;
    }

    private void deleteUnmentionedFiles(Dso[] dsos) throws IOException {
        String[] existingFiles = this.soDirectory.list();
        if (existingFiles != null) {
            for (String fileName : existingFiles) {
                if (!fileName.equals(STATE_FILE_NAME) && !fileName.equals(LOCK_FILE_NAME) && !fileName.equals(INSTANCE_LOCK_FILE_NAME) && !fileName.equals(DEPS_FILE_NAME) && !fileName.equals(MANIFEST_FILE_NAME)) {
                    boolean found = false;
                    int j2 = 0;
                    while (!found && j2 < dsos.length) {
                        if (dsos[j2].name.equals(getSoNameFromFileName(fileName))) {
                            found = true;
                        }
                        j2++;
                    }
                    if (!found) {
                        File fileNameToDelete = new File(this.soDirectory, fileName);
                        Log.v(TAG, "deleting unaccounted-for file " + fileNameToDelete);
                        SysUtil.dumbDeleteRecursive(fileNameToDelete);
                    }
                }
            }
            return;
        }
        throw new IOException("unable to list directory " + this.soDirectory);
    }

    /* Debug info: failed to restart local var, previous not found, register: 7 */
    private void extractDso(InputDso iDso, byte[] ioBuffer) throws IOException {
        boolean writable;
        Log.i(TAG, "extracting DSO " + iDso.getDso().name);
        try {
            if (this.soDirectory.setWritable(true)) {
                extractDsoImpl(iDso, ioBuffer);
                if (writable) {
                    return;
                }
                return;
            }
            throw new IOException("cannot make directory writable for us: " + this.soDirectory);
        } finally {
            if (!this.soDirectory.setWritable(false)) {
                Log.w(TAG, "error removing " + this.soDirectory.getCanonicalPath() + " write permission");
            }
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 11 */
    private void extractDsoImpl(InputDso iDso, byte[] ioBuffer) throws IOException {
        File dsoFileName = new File(this.soDirectory, iDso.getFileName());
        RandomAccessFile dsoFile = null;
        try {
            if (dsoFileName.exists() && !dsoFileName.setWritable(true)) {
                Log.w(TAG, "error adding write permission to: " + dsoFileName);
            }
            try {
                dsoFile = new RandomAccessFile(dsoFileName, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
            } catch (IOException ex) {
                Log.w(TAG, "error overwriting " + dsoFileName + " trying to delete and start over", ex);
                SysUtil.dumbDeleteRecursive(dsoFileName);
                dsoFile = new RandomAccessFile(dsoFileName, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
            }
            int sizeHint = iDso.available();
            if (sizeHint > 1) {
                SysUtil.fallocateIfSupported(dsoFile.getFD(), (long) sizeHint);
            }
            iDso.write(dsoFile, ioBuffer);
            dsoFile.setLength(dsoFile.getFilePointer());
            if (dsoFileName.setExecutable(true, false)) {
                if (dsoFileName.setWritable(false) == 0) {
                    Log.w(TAG, "error removing " + dsoFileName + " write permission");
                }
                dsoFile.close();
                return;
            }
            throw new IOException("cannot make file executable: " + dsoFileName);
        } catch (IOException e2) {
            SysUtil.dumbDeleteRecursive(dsoFileName);
            throw e2;
        } catch (Throwable th2) {
            if (!dsoFileName.setWritable(false)) {
                Log.w(TAG, "error removing " + dsoFileName + " write permission");
            }
            if (dsoFile != null) {
                dsoFile.close();
            }
            throw th2;
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 11 */
    private void regenerate(byte state, DsoManifest desiredManifest, InputDsoIterator dsoIterator) throws IOException {
        InputDso iDso;
        Log.v(TAG, "regenerating DSO store " + getClass().getName());
        RandomAccessFile manifestFile = new RandomAccessFile(new File(this.soDirectory, MANIFEST_FILE_NAME), VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
        DsoManifest existingManifest = null;
        if (state == 1) {
            try {
                existingManifest = DsoManifest.read(manifestFile);
            } catch (Exception ex) {
                try {
                    Log.i(TAG, "error reading existing DSO manifest", ex);
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
        }
        if (existingManifest == null) {
            existingManifest = new DsoManifest(new Dso[0]);
        }
        deleteUnmentionedFiles(desiredManifest.dsos);
        byte[] ioBuffer = new byte[32768];
        while (dsoIterator.hasNext()) {
            iDso = dsoIterator.next();
            boolean obsolete = true;
            int i2 = 0;
            while (obsolete) {
                if (i2 >= existingManifest.dsos.length) {
                    break;
                }
                if (existingManifest.dsos[i2].name.equals(iDso.getDso().name) && existingManifest.dsos[i2].hash.equals(iDso.getDso().hash)) {
                    obsolete = false;
                }
                i2++;
            }
            if (!new File(this.soDirectory, iDso.getFileName()).exists()) {
                obsolete = true;
            }
            if (obsolete) {
                extractDso(iDso, ioBuffer);
            }
            if (iDso != null) {
                iDso.close();
            }
        }
        manifestFile.close();
        Log.v(TAG, "Finished regenerating DSO store " + getClass().getName());
        return;
        throw th;
        throw th;
    }

    /* access modifiers changed from: protected */
    public boolean depsChanged(byte[] existingDeps, byte[] deps) {
        return !Arrays.equals(existingDeps, deps);
    }

    /* Debug info: failed to restart local var, previous not found, register: 15 */
    /* access modifiers changed from: protected */
    public boolean refreshLocked(FileLocker lock, int flags, byte[] deps) throws IOException {
        byte state;
        Throwable th2;
        byte state2;
        DsoManifest desiredManifest;
        Throwable th3;
        InputDsoIterator idi;
        Throwable th4;
        Throwable th5;
        File stateFileName = new File(this.soDirectory, STATE_FILE_NAME);
        RandomAccessFile stateFile = new RandomAccessFile(stateFileName, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
        try {
            byte state3 = stateFile.readByte();
            if (state3 != 1) {
                Log.v(TAG, "dso store " + this.soDirectory + " regeneration interrupted: wiping clean");
                state3 = 0;
            }
            state = state3;
        } catch (EOFException e2) {
            state = 0;
        } catch (Throwable th6) {
            th5.addSuppressed(th6);
        }
        stateFile.close();
        File depsFileName = new File(this.soDirectory, DEPS_FILE_NAME);
        RandomAccessFile depsFile = new RandomAccessFile(depsFileName, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
        try {
            byte[] existingDeps = new byte[((int) depsFile.length())];
            if (depsFile.read(existingDeps) != existingDeps.length) {
                Log.v(TAG, "short read of so store deps file: marking unclean");
                state = 0;
            }
            try {
                if (depsChanged(existingDeps, deps)) {
                    Log.v(TAG, "deps mismatch on deps store: regenerating");
                    state2 = 0;
                } else {
                    state2 = state;
                }
                if (state2 == 0 || (flags & 2) != 0) {
                    try {
                        Log.v(TAG, "so store dirty: regenerating");
                        writeState(stateFileName, (byte) 0);
                        Unpacker u = makeUnpacker(state2);
                        try {
                            DsoManifest desiredManifest2 = u.getDsoManifest();
                            idi = u.openDsoIterator();
                            regenerate(state2, desiredManifest2, idi);
                            if (idi != null) {
                                idi.close();
                            }
                            if (u != null) {
                                u.close();
                            }
                            desiredManifest = desiredManifest2;
                        } catch (Throwable th7) {
                            th3 = th7;
                            if (u != null) {
                                u.close();
                            }
                            throw th3;
                        }
                    } catch (Throwable th8) {
                        th2 = th8;
                        byte b2 = state2;
                        try {
                            depsFile.close();
                        } catch (Throwable th9) {
                            th2.addSuppressed(th9);
                        }
                        throw th2;
                    }
                } else {
                    desiredManifest = null;
                }
                depsFile.close();
                if (desiredManifest == null) {
                    return false;
                }
                DsoManifest manifest = desiredManifest;
                if ((flags & 4) != 0) {
                    return true;
                }
                Runnable syncer = createSyncer(lock, deps, stateFileName, depsFileName, manifest, false);
                if ((flags & 1) != 0) {
                    new Thread(syncer, "SoSync:" + this.soDirectory.getName()).start();
                } else {
                    syncer.run();
                }
                return true;
            } catch (Throwable th10) {
                th = th10;
                th2 = th;
                depsFile.close();
                throw th2;
            }
        } catch (Throwable th11) {
            th = th11;
            byte[] bArr = deps;
            th2 = th;
            depsFile.close();
            throw th2;
        }
        throw th4;
        throw th5;
    }

    private Runnable createSyncer(FileLocker lock, byte[] deps, File stateFileName, File depsFileName, DsoManifest manifest, Boolean quietly) {
        final File file = depsFileName;
        final byte[] bArr = deps;
        final DsoManifest dsoManifest = manifest;
        final File file2 = stateFileName;
        final FileLocker fileLocker = lock;
        final Boolean bool = quietly;
        return new Runnable() {
            /* Debug info: failed to restart local var, previous not found, register: 7 */
            public void run() {
                RandomAccessFile depsFile;
                RandomAccessFile manifestFile;
                try {
                    Log.v(UnpackingSoSource.TAG, "starting syncer worker");
                    depsFile = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
                    depsFile.write(bArr);
                    depsFile.setLength(depsFile.getFilePointer());
                    depsFile.close();
                    manifestFile = new RandomAccessFile(new File(UnpackingSoSource.this.soDirectory, UnpackingSoSource.MANIFEST_FILE_NAME), VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
                    dsoManifest.write(manifestFile);
                    manifestFile.close();
                    SysUtil.fsyncRecursive(UnpackingSoSource.this.soDirectory);
                    UnpackingSoSource.writeState(file2, (byte) 1);
                    try {
                        Log.v(UnpackingSoSource.TAG, "releasing dso store lock for " + UnpackingSoSource.this.soDirectory + " (from syncer thread)");
                        fileLocker.close();
                        return;
                    } catch (IOException ex) {
                        if (!bool.booleanValue()) {
                            throw new RuntimeException(ex);
                        }
                        return;
                    }
                    throw th;
                    throw th;
                } catch (Throwable th2) {
                    Log.v(UnpackingSoSource.TAG, "releasing dso store lock for " + UnpackingSoSource.this.soDirectory + " (from syncer thread)");
                    fileLocker.close();
                    throw th2;
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public byte[] getDepsBlock() throws IOException {
        Parcel parcel = Parcel.obtain();
        Unpacker u = makeUnpacker((byte) 1);
        try {
            Dso[] dsos = u.getDsoManifest().dsos;
            parcel.writeByte((byte) 1);
            parcel.writeInt(dsos.length);
            for (int i2 = 0; i2 < dsos.length; i2++) {
                parcel.writeString(dsos[i2].name);
                parcel.writeString(dsos[i2].hash);
            }
            if (u != null) {
                u.close();
            }
            byte[] depsBlock = parcel.marshall();
            parcel.recycle();
            return depsBlock;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public FileLocker getOrCreateLock(File lockFileName, boolean blocking) throws IOException {
        return SysUtil.getOrCreateLockOnDir(this.soDirectory, lockFileName, blocking);
    }

    /* access modifiers changed from: protected */
    public void prepare(int flags) throws IOException {
        SysUtil.mkdirOrThrow(this.soDirectory);
        boolean dirCanWrite = this.soDirectory.canWrite();
        FileLocker lock = null;
        if (!dirCanWrite) {
            try {
                if (!this.soDirectory.setWritable(true)) {
                    Log.w(TAG, "error adding " + this.soDirectory.getCanonicalPath() + " write permission");
                }
            } catch (Throwable th2) {
                if (!dirCanWrite && !this.soDirectory.setWritable(false)) {
                    Log.w(TAG, "error removing " + this.soDirectory.getCanonicalPath() + " write permission");
                }
                if (lock != null) {
                    Log.v(TAG, "releasing dso store lock for " + this.soDirectory);
                    lock.close();
                } else {
                    Log.v(TAG, "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
                }
                throw th2;
            }
        }
        FileLocker lock2 = getOrCreateLock(new File(this.soDirectory, LOCK_FILE_NAME), true);
        if (this.mInstanceLock == null) {
            this.mInstanceLock = getOrCreateLock(new File(this.soDirectory, INSTANCE_LOCK_FILE_NAME), false);
        }
        Log.v(TAG, "locked dso store " + this.soDirectory);
        if (refreshLocked(lock2, flags, getDepsBlock())) {
            lock2 = null;
        } else {
            Log.i(TAG, "dso store is up-to-date: " + this.soDirectory);
        }
        if (!dirCanWrite && !this.soDirectory.setWritable(false)) {
            Log.w(TAG, "error removing " + this.soDirectory.getCanonicalPath() + " write permission");
        }
        if (lock2 != null) {
            Log.v(TAG, "releasing dso store lock for " + this.soDirectory);
            lock2.close();
            return;
        }
        Log.v(TAG, "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
    }

    private Object getLibraryLock(String soName) {
        Object lock;
        synchronized (this.mLibsBeingLoaded) {
            lock = this.mLibsBeingLoaded.get(soName);
            if (lock == null) {
                lock = new Object();
                this.mLibsBeingLoaded.put(soName, lock);
            }
        }
        return lock;
    }

    @Nullable
    public String getLibraryPath(String soName) throws IOException {
        File soFile = getSoFileByName(soName);
        if (soFile == null) {
            return null;
        }
        return soFile.getCanonicalPath();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0012, code lost:
        r1 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void prepare(java.lang.String r3) throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.Object r0 = r2.getLibraryLock(r3)     // Catch:{ all -> 0x0014 }
            monitor-enter(r0)     // Catch:{ all -> 0x0014 }
            r2.mCorruptedLib = r3     // Catch:{ all -> 0x000f }
            r1 = 2
            r2.prepare((int) r1)     // Catch:{ all -> 0x000f }
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            monitor-exit(r2)
            return
        L_0x000f:
            r1 = move-exception
        L_0x0010:
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            throw r1     // Catch:{ all -> 0x0014 }
        L_0x0012:
            r1 = move-exception
            goto L_0x0010
        L_0x0014:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.prepare(java.lang.String):void");
    }

    public int loadLibrary(String soName, int loadFlags, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int loadLibraryFrom;
        synchronized (getLibraryLock(soName)) {
            loadLibraryFrom = loadLibraryFrom(soName, loadFlags, this.soDirectory, threadPolicy);
        }
        return loadLibraryFrom;
    }
}
