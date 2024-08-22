package com.baidu.talos.devtools.bundle.infoloader;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import com.baidu.talos.core.deploy.TLSBundleVersionInfo;
import com.baidu.talos.core.deploy.TLSBundleVersionManager;
import com.baidu.talos.core.deploy.TLSDeployUtil;
import com.baidu.talos.devtools.treeview.holder.CheckableNodeHolder;
import com.baidu.talos.devtools.treeview.holder.ItemNodeHolder;
import com.baidu.talos.devtools.treeview.holder.TitleNodeHolder;
import com.baidu.talos.devtools.treeview.model.TreeNode;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class DpmBundleInfoLoader extends AbsBundleInfoLoader {
    public TreeNode loadBundleInfo(Context context, TreeNode.TreeNodeSelectedListener listener) {
        SimpleDateFormat df;
        File dpmBundleFile;
        String dpmBundleDir;
        String[] bizNames;
        long ts;
        Context context2 = context;
        TreeNode rootNode = generateRootNode(context);
        if (context2 == null) {
            return rootNode;
        }
        String dpmBundleDir2 = TLSDeployUtil.getTalosDPMBundleRootDir();
        if (TextUtils.isEmpty(dpmBundleDir2)) {
            return rootNode;
        }
        File dpmBundleFile2 = new File(dpmBundleDir2);
        if (!dpmBundleFile2.exists()) {
            return rootNode;
        }
        String[] bizNames2 = dpmBundleFile2.list();
        if (bizNames2 == null) {
            TreeNode.TreeNodeSelectedListener treeNodeSelectedListener = listener;
            String str = dpmBundleDir2;
            File file = dpmBundleFile2;
            String[] strArr = bizNames2;
        } else if (bizNames2.length <= 0) {
            TreeNode.TreeNodeSelectedListener treeNodeSelectedListener2 = listener;
            String str2 = dpmBundleDir2;
            File file2 = dpmBundleFile2;
            String[] strArr2 = bizNames2;
        } else {
            SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            int index = 0;
            int length = bizNames2.length;
            int i2 = 0;
            while (i2 < length) {
                String bizName = bizNames2[i2];
                List<TLSBundleVersionInfo> bundleVersionInfos = TLSBundleVersionManager.getInstance().getBizAllVersionsInOrder(bizName);
                if (bundleVersionInfos == null) {
                    TreeNode.TreeNodeSelectedListener treeNodeSelectedListener3 = listener;
                    dpmBundleDir = dpmBundleDir2;
                    dpmBundleFile = dpmBundleFile2;
                    bizNames = bizNames2;
                    df = df2;
                } else if (bundleVersionInfos.size() <= 0) {
                    TreeNode.TreeNodeSelectedListener treeNodeSelectedListener4 = listener;
                    dpmBundleDir = dpmBundleDir2;
                    dpmBundleFile = dpmBundleFile2;
                    bizNames = bizNames2;
                    df = df2;
                } else {
                    index++;
                    TreeNode mainBizNode = new TreeNode(getTitleValue(index, bizName)).setViewHolder(new TitleNodeHolder(context2)).setTag(bizName);
                    rootNode.addChild(mainBizNode);
                    for (TLSBundleVersionInfo info : bundleVersionInfos) {
                        if (TextUtils.isDigitsOnly(info.version)) {
                            long ts2 = Long.parseLong(info.version);
                            String dpmBundleDir3 = dpmBundleDir2;
                            File dpmBundleFile3 = dpmBundleFile2;
                            if (info.version.length() == 10) {
                                ts = ts2 * 1000;
                            } else {
                                ts = ts2;
                            }
                            String[] bizNames3 = bizNames2;
                            int index2 = index;
                            TreeNode mainBizVersionNode = new TreeNode(info.version + "  [" + df2.format(new Date(ts)) + RhetoricalTagUtilKt.TAG_END_SYMBOL).setViewHolder(new CheckableNodeHolder(context2)).setTag(info.version).setSelectedListener(listener);
                            mainBizNode.addChild(mainBizVersionNode);
                            for (Iterator<String> it = info.subBizVersionMap.keySet().iterator(); it.hasNext(); it = it) {
                                long ts3 = ts;
                                String subBizName = it.next();
                                mainBizVersionNode.addChild(new TreeNode(subBizName + " " + info.subBizVersionMap.get(subBizName)).setViewHolder(new ItemNodeHolder(context2)));
                                df2 = df2;
                                ts = ts3;
                            }
                            SimpleDateFormat simpleDateFormat = df2;
                            bizNames2 = bizNames3;
                            dpmBundleDir2 = dpmBundleDir3;
                            dpmBundleFile2 = dpmBundleFile3;
                            index = index2;
                        }
                    }
                    TreeNode.TreeNodeSelectedListener treeNodeSelectedListener5 = listener;
                    dpmBundleDir = dpmBundleDir2;
                    dpmBundleFile = dpmBundleFile2;
                    bizNames = bizNames2;
                    df = df2;
                    int i3 = index;
                }
                i2++;
                bizNames2 = bizNames;
                dpmBundleDir2 = dpmBundleDir;
                dpmBundleFile2 = dpmBundleFile;
                df2 = df;
            }
            return rootNode;
        }
        return rootNode;
    }

    public String getDisplayText() {
        return "新协议多Bundle";
    }

    /* access modifiers changed from: package-private */
    public String getLoaderType() {
        return AbsBundleInfoLoader.DPM_BUNDLE_TYPE;
    }
}
