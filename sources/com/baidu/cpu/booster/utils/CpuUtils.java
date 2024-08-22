package com.baidu.cpu.booster.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.cpu.booster.info.CpuConstants;
import com.baidu.cpu.booster.info.CpuFreqPair;
import com.baidu.cpu.booster.info.CpuInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class CpuUtils implements CpuConstants {
    private static final String CPU_FILE_PREFIX = "/sys/devices/system/cpu";
    private static final SparseArray<CpuFreqPair> FREQ_PAIRS_CACHE = new SparseArray<>();
    private static int sCpuCoreNum = -1;
    private static CpuInfo sCpuInfo;
    private static CpuType sCpuType;

    public static int getCpuCoreNum() {
        int i2 = sCpuCoreNum;
        if (i2 != -1) {
            return i2;
        }
        int cores = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
        if (cores != -1) {
            sCpuCoreNum = cores;
            return cores;
        }
        int cores2 = getCoresFromFileInfo("/sys/devices/system/cpu/present");
        if (cores2 != -1) {
            sCpuCoreNum = cores2;
            return cores2;
        }
        int cores3 = getCoresFromCPUFileList();
        if (cores3 == -1) {
            cores3 = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        sCpuCoreNum = cores3;
        return cores3;
    }

    public static int getCurrentCpuFrequency(int coreIndex) {
        return getFreqFromFile("/sys/devices/system/cpu/cpu" + coreIndex + "/cpufreq/scaling_cur_freq");
    }

    public static CpuFreqPair getCoreFreqPair(int cpuCoreIndex) {
        SparseArray<CpuFreqPair> sparseArray = FREQ_PAIRS_CACHE;
        CpuFreqPair pair = sparseArray.get(cpuCoreIndex);
        if (pair != null) {
            return pair;
        }
        try {
            CpuFreqPair pair2 = new CpuFreqPair(cpuCoreIndex, getFreqFromFile("/sys/devices/system/cpu/cpu" + cpuCoreIndex + "/cpufreq/cpuinfo_min_freq"), getFreqFromFile("/sys/devices/system/cpu/cpu" + cpuCoreIndex + "/cpufreq/cpuinfo_max_freq"));
            sparseArray.put(cpuCoreIndex, pair2);
            return pair2;
        } catch (Exception e2) {
            return new CpuFreqPair(cpuCoreIndex, -1, -1);
        }
    }

    private static int getCoresFromFileInfo(String fileLocation) {
        InputStream is;
        try {
            is = new FileInputStream(fileLocation);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            String fileContents = buf.readLine();
            buf.close();
            int coresFromFileString = getCoresFromFileString(fileContents);
            is.close();
            return coresFromFileString;
        } catch (Exception e2) {
            return -1;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private static int getCoresFromFileString(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int indexOf = str.indexOf(45);
        if (indexOf != -1) {
            int count = safeParseInt(str.substring(indexOf + 1));
            if (count != -1) {
                return count + 1;
            }
            return -1;
        } else if (TextUtils.isDigitsOnly(str)) {
            return safeParseInt(str) + 1;
        } else {
            return -1;
        }
    }

    private static int safeParseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e2) {
            return -1;
        }
    }

    public static int getFreqFromFile(String str) {
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            return -1;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            return safeParseInt(pickDigits(readLine));
        } catch (Exception e2) {
            return -1;
        }
    }

    private static String pickDigits(String str) {
        if (str == null) {
            return str;
        }
        int endIndex = 0;
        int length = str.length();
        while (endIndex < length && Character.isDigit(str.charAt(endIndex))) {
            endIndex++;
        }
        return str.substring(0, endIndex);
    }

    private static int getCoresFromCPUFileList() {
        File[] files = new File(CPU_FILE_PREFIX).listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                String path = pathname.getName();
                if (!path.startsWith("cpu")) {
                    return false;
                }
                int pathLength = path.length();
                for (int i2 = "cpu".length(); i2 < pathLength; i2++) {
                    if (!Character.isDigit(path.charAt(i2))) {
                        return false;
                    }
                }
                return true;
            }
        });
        if (files == null || files.length <= 0) {
            return -1;
        }
        return files.length;
    }

    public static CpuInfo getCpuInfo() {
        CpuInfo cpuInfo = sCpuInfo;
        if (cpuInfo != null) {
            return cpuInfo;
        }
        int cores = getCpuCoreNum();
        if (cores <= 0) {
            return new CpuInfo();
        }
        if (cores == 1) {
            CpuInfo info = new CpuInfo();
            info.isBigLittle = false;
            info.cpuCoreNum = cores;
            info.notBLCpuFreqPair = getCoreFreqPair(0);
            sCpuInfo = info;
            return info;
        }
        ArrayList<CpuFreqPair> arrayList = new ArrayList<>(cores);
        for (int i2 = 0; i2 < cores; i2++) {
            arrayList.add(getCoreFreqPair(i2));
        }
        SparseArray<CpuFreqPair> pairMap = new SparseArray<>();
        SparseIntArray countMap = new SparseIntArray();
        ArrayList arrayList2 = new ArrayList();
        for (CpuFreqPair pair : arrayList) {
            if (pair.isValid()) {
                int maxFreq = pair.maxFreq;
                if (pairMap.get(maxFreq) != null) {
                    countMap.put(maxFreq, countMap.get(maxFreq) + 1);
                } else {
                    pairMap.put(maxFreq, pair);
                    arrayList2.add(pair);
                    countMap.put(maxFreq, 1);
                }
            }
        }
        Collections.sort(arrayList2);
        CpuInfo info2 = new CpuInfo();
        info2.cpuCoreNum = cores;
        info2.isBigLittle = arrayList2.size() > 1;
        if (!info2.isBigLittle) {
            info2.notBLCpuFreqPair = (CpuFreqPair) (arrayList2.size() <= 0 ? arrayList.get(0) : arrayList2.get(0));
            sCpuInfo = info2;
            return info2;
        }
        info2.littleFreqPair = (CpuFreqPair) arrayList2.get(0);
        info2.littleCoreIndex = ((CpuFreqPair) arrayList2.get(0)).index;
        info2.littleCoreNum = countMap.get(info2.littleFreqPair.maxFreq);
        info2.bigFreqPair = (CpuFreqPair) arrayList2.get(1);
        info2.bigCoreIndex = ((CpuFreqPair) arrayList2.get(1)).index;
        info2.bigCoreNum = countMap.get(info2.bigFreqPair.maxFreq);
        if (arrayList2.size() > 2) {
            info2.superFrePair = (CpuFreqPair) arrayList2.get(2);
            info2.superCoreIndex = ((CpuFreqPair) arrayList2.get(2)).index;
            info2.superCoreNum = countMap.get(info2.superFrePair.maxFreq);
        }
        sCpuInfo = info2;
        return info2;
    }

    public static String getCpuModel() {
        String str = SystemPropertiesWrapper.get("ro.board.platform");
        if (TextUtils.isEmpty(str)) {
            str = Build.HARDWARE;
        }
        if (str != null) {
            return str.trim();
        }
        return str;
    }

    public static CpuType getCpuType() {
        CpuType cpuType = sCpuType;
        if (cpuType != null) {
            return cpuType;
        }
        return getCpuType(getCpuModel());
    }

    private static CpuType getCpuType(String str) {
        if (TextUtils.isEmpty(str)) {
            CpuType cpuType = CpuType.Unknown;
            sCpuType = cpuType;
            return cpuType;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("kirin") || lowerCase.startsWith("hi")) {
            CpuType cpuType2 = CpuType.Hisilicon;
            sCpuType = cpuType2;
            return cpuType2;
        } else if (lowerCase.startsWith("qcom") || lowerCase.startsWith("kona") || lowerCase.startsWith("lahaina") || lowerCase.startsWith("msm") || lowerCase.startsWith("sdm") || lowerCase.startsWith("apq") || lowerCase.startsWith("sm")) {
            CpuType cpuType3 = CpuType.QualComm;
            sCpuType = cpuType3;
            return cpuType3;
        } else if (lowerCase.startsWith("mt")) {
            CpuType cpuType4 = CpuType.Mtk;
            sCpuType = cpuType4;
            return cpuType4;
        } else {
            CpuType cpuType5 = CpuType.Unknown;
            sCpuType = cpuType5;
            return cpuType5;
        }
    }
}
