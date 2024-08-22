package com.baidu.searchbox.gamecore.widget.dialog.newguide;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.base.widget.BaseDialog;
import com.baidu.searchbox.gamecore.R;
import com.baidu.searchbox.gamecore.config.GameConfigDataManager;
import com.baidu.searchbox.gamecore.config.data.model.GameGuideData;
import com.baidu.searchbox.gamecore.ubc.GameCenterUBCUtil;
import com.baidu.searchbox.gamecore.ubc.GameUBCConst;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.facebook.drawee.view.SimpleDraweeView;

public class NewGuideDialog extends BaseDialog {
    private static final String NEW_GAME_CENTER_SCHEME = "baiduboxapp://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/home/index?_baiduboxapp=%7B%22from%22%3A%221241009500000000%22%2C%22ext%22%3A%7B%7D%7D";
    private static final String TAG = "NewGuideDialog";
    private ImageView mClose;
    private TextView mEnter;
    private GameGuideData mGuideData;
    private SimpleDraweeView mImage;
    /* access modifiers changed from: private */
    public String mScheme = NEW_GAME_CENTER_SCHEME;

    public NewGuideDialog(Context context) {
        super(context, R.style.NoTitleDialog);
        init();
    }

    private void init() {
        setCancelable(true);
        setContentView(R.layout.game_new_guide_dialog);
        this.mImage = (SimpleDraweeView) findViewById(R.id.image_top);
        this.mEnter = (TextView) findViewById(R.id.text_enter);
        this.mClose = (ImageView) findViewById(R.id.image_close);
        GameGuideData guideData = GameConfigDataManager.getInstance().getGuideData();
        this.mGuideData = guideData;
        if (guideData != null) {
            if (!TextUtils.isEmpty(guideData.getText())) {
                this.mEnter.setText(this.mGuideData.getText());
            }
            if (!TextUtils.isEmpty(this.mGuideData.getImage())) {
                this.mImage.setImageURI(this.mGuideData.getImage());
            }
            if (!TextUtils.isEmpty(this.mGuideData.getScheme())) {
                this.mScheme = this.mGuideData.getScheme();
            }
        }
        this.mEnter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view2) {
                SchemeRouter.invokeSchemeForInner(NewGuideDialog.this.getContext(), Uri.parse(NewGuideDialog.this.mScheme));
                GameCenterUBCUtil.gameEvent(GameUBCConst.DISCOVERY_SHOW_CLICK_ID, "click", GameUBCConst.VALUE_NEW_CENTER, GameUBCConst.PAGE_FIND_PAGE);
                NewGuideDialog.this.dismiss();
            }
        });
        this.mClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view2) {
                NewGuideDialog.this.cancel();
            }
        });
        setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                GameCenterUBCUtil.gameEvent(GameUBCConst.DISCOVERY_SHOW_CLICK_ID, "click", GameUBCConst.VALUE_NEW_CENTER_CLOSE, GameUBCConst.PAGE_FIND_PAGE);
            }
        });
        setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                GameCenterUBCUtil.gameEvent(GameUBCConst.DISCOVERY_SHOW_CLICK_ID, "show", GameUBCConst.VALUE_NEW_CENTER, GameUBCConst.PAGE_FIND_PAGE);
            }
        });
    }
}
