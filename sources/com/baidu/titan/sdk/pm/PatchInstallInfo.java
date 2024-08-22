package com.baidu.titan.sdk.pm;

import android.os.Build;
import com.baidu.nps.manifest.ManifestManager;
import com.baidu.searchbox.video.search.tc.TCJSON;
import com.baidu.titan.sdk.internal.util.Closes;
import com.baidu.titan.sdk.internal.util.EncodeUtils;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PatchInstallInfo {
    private File mPatchDir;
    private FileLock mShareFileLock;
    private FileLock mWriteFileLock;

    public PatchInstallInfo(File patchDir) {
        this.mPatchDir = patchDir;
    }

    public String getId() {
        return this.mPatchDir.getName();
    }

    public boolean exist() {
        return this.mPatchDir.exists() && this.mPatchDir.isDirectory() && this.mPatchDir.list() != null;
    }

    public File getPatchFile() {
        return new File(this.mPatchDir, "patch.apk");
    }

    public File getStatusFile() {
        return new File(this.mPatchDir, "status");
    }

    public File getLockFile() {
        File lockFile = new File(this.mPatchDir, ".lock");
        if (!lockFile.exists()) {
            try {
                lockFile.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return lockFile;
    }

    public FileLock getShareLock() {
        return this.mShareFileLock;
    }

    public boolean shareLock() {
        try {
            FileLock fileLock = new RandomAccessFile(getLockFile(), TCJSON.KEY.R).getChannel().tryLock(0, 0, true);
            this.mShareFileLock = fileLock;
            if (fileLock != null) {
                return true;
            }
            return false;
        } catch (IOException e2) {
            return false;
        }
    }

    public boolean releaseShareLock() {
        if (this.mShareFileLock == null) {
            return false;
        }
        try {
            this.mShareFileLock.release();
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean releaseWriteLock() {
        FileLock fileLock = this.mWriteFileLock;
        if (fileLock == null) {
            return false;
        }
        try {
            fileLock.release();
            Closes.closeQuiet((Closeable) fileLock.channel());
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean writeLock() {
        try {
            FileLock fileLock = new RandomAccessFile(getLockFile(), VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth).getChannel().tryLock(0, 0, false);
            this.mWriteFileLock = fileLock;
            if (fileLock != null) {
                return true;
            }
            return false;
        } catch (IOException e2) {
            return false;
        }
    }

    public FileLock getWriteLock() {
        return this.mWriteFileLock;
    }

    public String getDexPath() {
        if (Build.VERSION.SDK_INT > 19 || getDexCount() <= 1) {
            return getPatchFile().getAbsolutePath();
        }
        List<File> dexs = getOrderedDexList();
        if (dexs == null || dexs.size() == 0) {
            return "";
        }
        StringBuilder dexPathBuilder = new StringBuilder();
        Iterator<File> it = dexs.iterator();
        while (it.hasNext()) {
            dexPathBuilder.append(it.next().getAbsoluteFile());
            if (it.hasNext()) {
                dexPathBuilder.append(File.pathSeparator);
            }
        }
        return dexPathBuilder.toString();
    }

    public List<File> getOrderedDexList() {
        List<File> dexs = new ArrayList<>();
        File mainDex = new File(this.mPatchDir, "classes.jar");
        if (mainDex.exists()) {
            dexs.add(mainDex);
        }
        int idx = 2;
        while (true) {
            File secDex = new File(this.mPatchDir, ManifestManager.TAG_CLASSES + idx + ".jar");
            if (!secDex.exists()) {
                return dexs;
            }
            dexs.add(secDex);
            idx++;
        }
    }

    public File getDexOptDir() {
        return new File(this.mPatchDir, "dexopt");
    }

    public boolean finished() {
        if (getStatusFile().exists()) {
            return true;
        }
        return false;
    }

    public File getPatchDir() {
        return this.mPatchDir;
    }

    public void prepare() {
        this.mPatchDir.mkdirs();
    }

    public void cleanIfNeed() {
        deleteFile(this.mPatchDir);
    }

    private void deleteFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] sub = file.listFiles();
            if (sub != null) {
                for (File f2 : sub) {
                    deleteFile(f2);
                }
            }
            file.delete();
        }
    }

    public boolean saveOptFileDigests(File dexOptDir) {
        try {
            FileWriter fw = new FileWriter(new File(getPatchDir(), ".opt_dig"));
            File[] optFiles = dexOptDir.listFiles();
            for (File file : optFiles) {
                if (!file.isDirectory()) {
                    String sha256 = EncodeUtils.bytesToHex(EncodeUtils.sha256(file));
                    fw.write(file.getName());
                    fw.write(":");
                    fw.write(sha256);
                    fw.write("\n");
                }
            }
            fw.flush();
            Closes.closeQuiet((Closeable) fw);
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            Closes.closeQuiet((Closeable) null);
            return false;
        } catch (Throwable th2) {
            Closes.closeQuiet((Closeable) null);
            throw th2;
        }
    }

    public HashMap<String, String> readOptDigests() {
        File optDigest = new File(getPatchDir(), ".opt_dig");
        HashMap<String, String> digestMap = new HashMap<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(optDigest)));
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] array = line.trim().split(":");
                if (array.length == 2) {
                    digestMap.put(array[0], array[1]);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            Closes.closeQuiet((Reader) null);
            throw th2;
        }
        Closes.closeQuiet((Reader) br);
        return digestMap;
    }

    public boolean saveDexCount(int dexCount) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(new File(this.mPatchDir, ".dexCount")));
            dos.writeInt(dexCount);
            Closes.closeQuiet((OutputStream) dos);
            return true;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (Throwable th2) {
            Closes.closeQuiet((OutputStream) dos);
            throw th2;
        }
        Closes.closeQuiet((OutputStream) dos);
        return false;
    }

    public int getDexCount() {
        DataInputStream dis = null;
        int dexCount = -1;
        try {
            dis = new DataInputStream(new FileInputStream(new File(this.mPatchDir, ".dexCount")));
            dexCount = dis.readInt();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (Throwable th2) {
            Closes.closeQuiet((InputStream) null);
            throw th2;
        }
        Closes.closeQuiet((InputStream) dis);
        return dexCount;
    }
}
