package com.baidu.searchbox.debug.block;

import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.searchbox.config.AppConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BlockReportManager {
    private static int[][] BLOCK_DURATION_RANGE = {new int[]{50, 100}, new int[]{100, 200}, new int[]{200, 500}, new int[]{500, Integer.MAX_VALUE}};

    public static void saveTempFile(String content) {
        File tempDir = BlockDebugUtils.getTempDir();
        if (tempDir != null) {
            BlockDebugUtils.saveFile(BlockDebugUtils.createFile(tempDir, "temp_" + Build.MANUFACTURER + "_" + Build.MODEL, ".txt"), content);
        }
    }

    public static void deleteTempFiles() {
        File[] files;
        File tempDir = BlockDebugUtils.getTempDir();
        if (tempDir != null && (files = tempDir.listFiles()) != null && files.length > 0) {
            for (File file : files) {
                file.delete();
            }
        }
    }

    public static String readReport() {
        return BlockDebugUtils.readFile(getReportFile());
    }

    public static File getReportFile() {
        File reportDir = BlockDebugUtils.getDir(AppConfig.AppInfo.getVersionName());
        if (reportDir == null) {
            return null;
        }
        return new File(reportDir, "report_" + Build.MANUFACTURER + "_" + Build.MODEL + ".html");
    }

    public static boolean createAndSaveReport() {
        int i2;
        File tempDir;
        int blockCount;
        File file;
        BlockInfo info;
        File tempDir2 = BlockDebugUtils.getTempDir();
        if (tempDir2 == null) {
            return false;
        }
        File[] files = tempDir2.listFiles();
        if (files == null) {
            return false;
        } else if (files.length <= 0) {
            File file2 = tempDir2;
            return false;
        } else {
            int[][] blockRange = BLOCK_DURATION_RANGE;
            int[] blockCountArr = new int[blockRange.length];
            SparseArray<BlockInfo> map = new SparseArray<>();
            int length = files.length;
            int i3 = 0;
            int blockTime = 0;
            int blockCount2 = 0;
            while (i3 < length) {
                File file3 = files[i3];
                try {
                    JSONArray array = new JSONArray(BlockDebugUtils.readFile(file3));
                    blockCount2 += array.length();
                    int i4 = 0;
                    while (i4 < array.length()) {
                        try {
                            JSONObject object = array.optJSONObject(i4);
                            int startTime = object.optInt("s");
                            int duration = object.optInt("d");
                            blockTime += duration;
                            JSONArray array2 = array;
                            int pos = 0;
                            while (true) {
                                tempDir = tempDir2;
                                try {
                                    blockCount = blockCount2;
                                    if (pos >= blockRange.length) {
                                        break;
                                    }
                                    try {
                                        int min = blockRange[pos][0];
                                        int max = blockRange[pos][1];
                                        if (duration < min) {
                                        } else if (duration < max) {
                                            blockCountArr[pos] = blockCountArr[pos] + 1;
                                            break;
                                        }
                                        pos++;
                                        tempDir2 = tempDir;
                                        blockCount2 = blockCount;
                                    } catch (JSONException e2) {
                                        e = e2;
                                        i2 = length;
                                        File file4 = file3;
                                        blockCount2 = blockCount;
                                        e.printStackTrace();
                                        i3++;
                                        tempDir2 = tempDir;
                                        length = i2;
                                    }
                                } catch (JSONException e3) {
                                    e = e3;
                                    int i5 = blockCount2;
                                    i2 = length;
                                    File file5 = file3;
                                    e.printStackTrace();
                                    i3++;
                                    tempDir2 = tempDir;
                                    length = i2;
                                }
                            }
                            try {
                                String stackTrace = object.optString("st");
                                String msgInfo = object.optString("info");
                                int hasCode = msgInfo.hashCode();
                                i2 = length;
                                BlockInfo info2 = map.get(hasCode);
                                if (info2 == null) {
                                    try {
                                        info = new BlockInfo();
                                        info.appendDuration(duration);
                                        file = file3;
                                    } catch (JSONException e4) {
                                        e = e4;
                                        File file6 = file3;
                                        blockCount2 = blockCount;
                                        e.printStackTrace();
                                        i3++;
                                        tempDir2 = tempDir;
                                        length = i2;
                                    }
                                    try {
                                        info.appendCount(1);
                                        info.setStartTime(startTime);
                                        info.setStackTrace(stackTrace);
                                        info.setMsgInfo(msgInfo);
                                        map.put(hasCode, info);
                                    } catch (JSONException e5) {
                                        e = e5;
                                        blockCount2 = blockCount;
                                        e.printStackTrace();
                                        i3++;
                                        tempDir2 = tempDir;
                                        length = i2;
                                    }
                                } else {
                                    file = file3;
                                    info2.appendDuration(duration);
                                    info2.appendCount(1);
                                    info2.setStartTime(startTime);
                                }
                                i4++;
                                tempDir2 = tempDir;
                                array = array2;
                                blockCount2 = blockCount;
                                length = i2;
                                file3 = file;
                            } catch (JSONException e6) {
                                e = e6;
                                i2 = length;
                                File file62 = file3;
                                blockCount2 = blockCount;
                                e.printStackTrace();
                                i3++;
                                tempDir2 = tempDir;
                                length = i2;
                            }
                        } catch (JSONException e7) {
                            e = e7;
                            tempDir = tempDir2;
                            int i6 = blockCount2;
                            i2 = length;
                            File file7 = file3;
                            e.printStackTrace();
                            i3++;
                            tempDir2 = tempDir;
                            length = i2;
                        }
                    }
                    JSONArray jSONArray = array;
                    tempDir = tempDir2;
                    int i7 = blockCount2;
                    i2 = length;
                    File file8 = file3;
                } catch (JSONException e8) {
                    e = e8;
                    tempDir = tempDir2;
                    i2 = length;
                    File file9 = file3;
                    e.printStackTrace();
                    i3++;
                    tempDir2 = tempDir;
                    length = i2;
                }
                i3++;
                tempDir2 = tempDir;
                length = i2;
            }
            return createHtmlReport(map, files.length, blockCount2 / files.length, blockTime / files.length, blockCountArr, blockRange);
        }
    }

    private static boolean createHtmlReport(SparseArray<BlockInfo> map, int launchCount, int avgCount, int avgTime, int[] blockCountArr, int[][] blockRange) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> </head><body>").append(createReportPart1(launchCount, avgCount, avgTime, blockCountArr, blockRange)).append(createReportPart2(map)).append("</body></html>");
        if (BlockDebugUtils.getDir(AppConfig.AppInfo.getVersionName()) == null) {
            return false;
        }
        BlockDebugUtils.saveFile(getReportFile(), sb.toString());
        return true;
    }

    private static String createReportPart1(int launchCount, int avgCount, int avgTime, int[] blockCountArr, int[][] blockRange) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=\"1\">");
        sb.append(toHtmlTableRow(new Object[]{"监控时长", "卡顿阈值", "总启动次数", "平均卡顿次数", "平均卡顿耗时"}));
        sb.append(toHtmlTableRow(new Object[]{Integer.valueOf(BlockDebugProxy.getWorkDuration()), Integer.valueOf(BlockDebugProxy.getBlockThresholdMillis()), Integer.valueOf(launchCount), Integer.valueOf(avgCount), Integer.valueOf(avgTime)}));
        sb.append("</table>");
        sb.append("<table border=\"1\">");
        Object[] table2Row1 = new Object[blockCountArr.length];
        for (int i2 = 0; i2 < blockCountArr.length; i2++) {
            table2Row1[i2] = "卡顿次数[" + blockRange[i2][0] + "," + (blockRange[i2][1] == Integer.MAX_VALUE ? "+∞" : Integer.valueOf(blockRange[i2][1])) + ")";
        }
        sb.append(toHtmlTableRow(table2Row1));
        Object[] table2Row2 = new Object[blockCountArr.length];
        for (int i3 = 0; i3 < blockCountArr.length; i3++) {
            table2Row2[i3] = Integer.valueOf(blockCountArr[i3]);
        }
        sb.append(toHtmlTableRow(table2Row2));
        sb.append("</table>");
        return sb.toString();
    }

    private static String createReportPart2(SparseArray<BlockInfo> map) {
        List<BlockInfo> list = new ArrayList<>(map.size());
        for (int i2 = 0; i2 < map.size(); i2++) {
            list.add(map.valueAt(i2));
        }
        Collections.sort(list, new Comparator<BlockInfo>() {
            public int compare(BlockInfo t1, BlockInfo t2) {
                return t2.getAvgDuration() - t1.getAvgDuration();
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=\"1\">");
        sb.append(toHtmlTableRow(new Object[]{"排序", "平均耗时", "重复次数", "距离手百App启动时间", "卡顿信息", "卡顿堆栈"}));
        for (int i3 = 0; i3 < list.size(); i3++) {
            BlockInfo info = list.get(i3);
            StringBuilder startTimeRangeSb = new StringBuilder();
            startTimeRangeSb.append(info.getMinStartTime());
            if (info.getMinStartTime() < info.getMaxStartTime()) {
                startTimeRangeSb.append(" - ").append(info.getMaxStartTime());
            }
            sb.append(toHtmlTableRow(new Object[]{Integer.valueOf(i3 + 1), Integer.valueOf(info.getAvgDuration()), Integer.valueOf(info.getAllCount() - 1), startTimeRangeSb, info.getMsgInfo(), info.getStackTrace()}));
        }
        sb.append("</table>");
        return sb.toString();
    }

    public static String toHtmlTableRow(Object[] elements) {
        return toHtmlTableRow(elements, (String[]) null);
    }

    public static String toHtmlTableRow(Object[] elements, String[] formats) {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>");
        if (formats != null && elements.length != formats.length) {
            return null;
        }
        for (int i2 = 0; i2 < elements.length; i2++) {
            sb.append("<th>");
            String format = null;
            if (formats != null) {
                format = formats[i2];
            }
            if (!TextUtils.isEmpty(format)) {
                sb.append(String.format(format, new Object[]{elements[i2]}));
            } else {
                sb.append(elements[i2]);
            }
            sb.append("</th>");
        }
        sb.append("</tr>");
        return sb.toString();
    }
}
