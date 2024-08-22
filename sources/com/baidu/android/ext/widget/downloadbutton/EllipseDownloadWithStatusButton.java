package com.baidu.android.ext.widget.downloadbutton;

import android.net.Uri;
import com.baidu.searchbox.download.business.util.DownloadCenterUtils;
import com.baidu.searchbox.download.unified.DownloadInfoData;
import com.baidu.searchbox.download.unified.DownloadInfoDatasCallback;
import com.baidu.searchbox.download.unified.DownloadUnifiedManager;
import java.util.List;

public class EllipseDownloadWithStatusButton extends EllipseDownloadButton {
    public EllipseDownloadWithStatusButton(AbsDownloadView downloadView) {
        super(downloadView);
    }

    public void initDownloadStatus(String url, Uri uri, IDownloadButtonHandler downloadHandler, IDownloadClickListener downloadClickListener) {
        super.initDownloadStatus(url, uri, downloadHandler, downloadClickListener);
        if (uri != null) {
            initButtonStatusAsync(uri);
        }
    }

    public void initButtonStatusAsync(final Uri uri) {
        if (uri != null) {
            DownloadUnifiedManager.getInstance().queryDownloadInfoDataAsync(uri, (DownloadInfoDatasCallback) new DownloadInfoDatasCallback() {
                public void callback(List<DownloadInfoData> list) {
                    if (list != null && list.size() > 0) {
                        int i2 = 0;
                        if (list.get(0) != null) {
                            DownloadInfoData data = list.get(0);
                            switch (data.getStatus()) {
                                case 1:
                                    EllipseDownloadWithStatusButton.this.onPending(data.getId());
                                    break;
                                case 2:
                                    EllipseDownloadWithStatusButton ellipseDownloadWithStatusButton = EllipseDownloadWithStatusButton.this;
                                    long id = data.getId();
                                    if (data.getTotalSize() > 0) {
                                        i2 = (int) ((data.getCurrentSize() / data.getTotalSize()) * 100);
                                    }
                                    ellipseDownloadWithStatusButton.onProgressChanged(id, i2);
                                    break;
                                case 4:
                                    EllipseDownloadWithStatusButton ellipseDownloadWithStatusButton2 = EllipseDownloadWithStatusButton.this;
                                    long id2 = data.getId();
                                    if (data.getTotalSize() > 0) {
                                        i2 = (int) ((data.getCurrentSize() / data.getTotalSize()) * 100);
                                    }
                                    ellipseDownloadWithStatusButton2.onPause(id2, i2);
                                    break;
                                case 8:
                                    EllipseDownloadWithStatusButton.this.onSuccessForInit(data.getId(), data.getTotalSize());
                                    break;
                                case 16:
                                    EllipseDownloadWithStatusButton.this.onFailed(data.getId(), data.getErrorReason());
                                    break;
                            }
                            if (data.getStatus() != 8) {
                                DownloadCenterUtils.registerAppDownloadListener(uri, EllipseDownloadWithStatusButton.this);
                            }
                        }
                    }
                }
            });
        }
    }

    public void onPending(long id) {
    }

    public void onFailed(long id, int errorReason) {
    }

    public void onSuccessForInit(long id, long totalBytes) {
        setSuccessStatus();
    }
}
