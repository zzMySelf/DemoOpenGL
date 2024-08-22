package com.baidu.searchbox.record.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.searchbox.record.R;

public class LyrebirdPicDialog extends Dialog {
    private TextView mChooseAlbumBtn = null;
    private TextView mChooseCameraBtn = null;
    private TextView mChooseCancelBtn = null;

    public LyrebirdPicDialog(Context context) {
        super(context, R.style.record_LyrebirdDialog);
        init(context);
    }

    private void init(Context context) {
        View view2 = View.inflate(context, R.layout.record_dialog_pic, (ViewGroup) null);
        this.mChooseCameraBtn = (TextView) view2.findViewById(R.id.choose_camera_btn);
        this.mChooseAlbumBtn = (TextView) view2.findViewById(R.id.choose_album_btn);
        TextView textView = (TextView) view2.findViewById(R.id.choose_pic_cancel_btn);
        this.mChooseCancelBtn = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view2) {
                LyrebirdPicDialog.this.dismiss();
            }
        });
        setContentView(view2);
        Window win = getWindow();
        if (win != null) {
            WindowManager.LayoutParams lp = win.getAttributes();
            lp.width = -1;
            lp.height = -2;
            win.setAttributes(lp);
            win.setGravity(80);
        }
    }

    public void setCameraOnClickListener(View.OnClickListener listener) {
        this.mChooseCameraBtn.setOnClickListener(listener);
    }

    public void setAlbumOnClickListener(View.OnClickListener listener) {
        this.mChooseAlbumBtn.setOnClickListener(listener);
    }
}
