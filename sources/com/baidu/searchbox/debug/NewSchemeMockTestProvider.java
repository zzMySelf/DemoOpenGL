package com.baidu.searchbox.debug;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewSchemeMockTestProvider extends DebugDataGroupProvider {
    private static final String TAG = "schemeTest";
    private View.OnClickListener testClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            new ArrayList();
            ArrayList schemeList = NewSchemeMockTestProvider.this.readsdcard();
            for (int i2 = 0; i2 < schemeList.size(); i2++) {
                String scheme = (String) schemeList.get(i2);
                try {
                    Router.invokeScheme(v.getContext(), Uri.parse(scheme), "inside");
                } catch (Exception e2) {
                    Log.d(NewSchemeMockTestProvider.TAG, "scheme：" + scheme);
                    Log.d(NewSchemeMockTestProvider.TAG, "start to print log!");
                    e2.printStackTrace();
                    Log.d(NewSchemeMockTestProvider.TAG, "end to print log!");
                }
            }
        }
    };
    private View.OnClickListener uriAppointedClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            NewSchemeMockTestProvider.this.gotoDebugSchemeActivity(v.getContext());
        }
    };

    /* access modifiers changed from: private */
    public void gotoDebugSchemeActivity(Context context) {
        ActivityUtils.startActivitySafely(context, new Intent("android.intent.action.schemeTest_debugscheme"));
    }

    /* access modifiers changed from: private */
    public ArrayList<String> readsdcard() {
        ArrayList schemeList = new ArrayList();
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                InputStream instream = new FileInputStream(new File(Environment.getExternalStorageDirectory(), "scheme_list.txt"));
                InputStreamReader inputreader = new InputStreamReader(instream);
                BufferedReader buffreader = new BufferedReader(inputreader);
                while (true) {
                    String readLine = buffreader.readLine();
                    String line = readLine;
                    if (readLine == null) {
                        break;
                    }
                    Log.d(TAG, line);
                    schemeList.add(line);
                }
                instream.close();
                inputreader.close();
                buffreader.close();
            }
            return schemeList;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void downLoad(String path, Context context) {
        final Context c2 = context;
        final String p = path;
        new Thread(new Runnable() {
            public void run() {
                try {
                    InputStream is = new URL(p).openStream();
                    OutputStream os = c2.openFileOutput("scheme_list.txt", 0);
                    byte[] buffer = new byte[1024];
                    while (true) {
                        int read = is.read(buffer);
                        int len = read;
                        if (read > 0) {
                            new String(buffer);
                            os.write(buffer, 0, len);
                        } else {
                            is.close();
                            os.close();
                            return;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }).start();
    }

    public List<DebugItemInfo> getChildItemList() {
        return getUnitedSchemeUriTestItemList();
    }

    public String getGroupName() {
        return "新增端能力异常测试";
    }

    private List<DebugItemInfo> getUnitedSchemeUriTestItemList() {
        List<DebugItemInfo> itemList = new ArrayList<>();
        itemList.add(new TextItemInfo((String) null, "点击进入demo测试页面", this.uriAppointedClickListener));
        return itemList;
    }
}
