package com.baidu.searchbox.music.ext.album.detail.comp.songlist.item.cover.album;

import android.content.DialogInterface;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.music.ext.R;
import com.baidu.searchbox.music.ext.album.detail.comp.songlist.item.cover.base.BaseCoverComp;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import com.facebook.drawee.view.SimpleDraweeView;

public class AlbumCoverComp extends BaseCoverComp<AlbumCoverData, AlbumCoverViewModel> {
    private static final boolean DEBUG = AppConfig.isDebug();
    private int iconPadding = DeviceUtil.ScreenInfo.dp2px(getContext(), 8.0f);
    private int iconWH = DeviceUtil.ScreenInfo.dp2px(getContext(), 12.0f);
    /* access modifiers changed from: private */
    public ImageView imgAlbumCollectIcon;
    /* access modifiers changed from: private */
    public SimpleDraweeView imgAlbumCover;
    /* access modifiers changed from: private */
    public ImageView imgEdit;
    /* access modifiers changed from: private */
    public View layoutAlbumCollect;
    /* access modifiers changed from: private */
    public LinearLayout llTitle;
    /* access modifiers changed from: private */
    public TextView tvAlbumCollectTip;
    /* access modifiers changed from: private */
    public TextView tvAlbumDescription;
    /* access modifiers changed from: private */
    public TextView tvCreateTime;
    private TextView tvTitleFirstLine;
    private TextView tvTitleSecondLine;

    public AlbumCoverComp(LifecycleOwner owner, View itemView) {
        super(owner, itemView);
        this.imgAlbumCover = (SimpleDraweeView) itemView.findViewById(R.id.imgAlbumCover);
        this.llTitle = (LinearLayout) itemView.findViewById(R.id.llTitle);
        this.tvTitleFirstLine = (TextView) itemView.findViewById(R.id.tvTitleFirstLine);
        this.tvTitleSecondLine = (TextView) itemView.findViewById(R.id.tvTitleSecondLine);
        this.tvCreateTime = (TextView) itemView.findViewById(R.id.tvAlbumCreateTime);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imgEdit);
        this.imgEdit = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((AlbumCoverViewModel) AlbumCoverComp.this.getViewModel()).editAlbum(v);
            }
        });
        this.tvAlbumDescription = (TextView) itemView.findViewById(R.id.tvAlbumDescription);
        this.layoutAlbumCollect = itemView.findViewById(R.id.layoutAlbumCollect);
        this.imgAlbumCollectIcon = (ImageView) itemView.findViewById(R.id.imgCollectIcon);
        this.tvAlbumCollectTip = (TextView) itemView.findViewById(R.id.tvCollectTip);
        this.layoutAlbumCollect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlbumCoverComp.this.onAlbumCollectChange();
            }
        });
    }

    public void onCreateView(View view2) {
    }

    public void onNightModeChange(boolean isNightMode) {
        super.onNightModeChange(isNightMode);
        ResWrapper.setTextColor(this.tvTitleFirstLine, R.color.search_music_font_b);
        ResWrapper.setTextColor(this.tvTitleSecondLine, R.color.search_music_font_b);
        ResWrapper.setTextColor(this.tvCreateTime, R.color.search_music_font_h);
        ResWrapper.setTextColor(this.tvAlbumDescription, R.color.SC287);
        ResWrapper.setImageDrawable(this.imgEdit, R.drawable.search_music_album_title_edit);
        ResWrapper.setBackground(this.layoutAlbumCollect, R.drawable.search_music_album_collect_bg);
    }

    public AlbumCoverViewModel onCreateViewModel() {
        return new AlbumCoverViewModel();
    }

    public void onBindViewModel(AlbumCoverViewModel viewModel, LifecycleOwner owner) {
        super.onBindViewModel(viewModel, owner);
        bindAlbumCover(viewModel);
        bindAlbumTitleParams(viewModel);
        bindAlbumCreateTime(viewModel);
        bindEditState(viewModel);
        bindAlbumDescription(viewModel);
        bindCollectTips(viewModel);
        bindCollectShowState(viewModel);
    }

    private void bindCollectShowState(AlbumCoverViewModel viewModel) {
        viewModel.showCollect.observe(getLifecycleOwner(), new Observer<Boolean>() {
            public void onChanged(Boolean isShow) {
                AlbumCoverComp.this.layoutAlbumCollect.setVisibility(Boolean.TRUE.equals(isShow) ? 0 : 8);
            }
        });
    }

    private void bindCollectTips(AlbumCoverViewModel viewModel) {
        viewModel.isCollected.observe(getLifecycleOwner(), new Observer<Boolean>() {
            public void onChanged(Boolean isCollected) {
                boolean status = Boolean.TRUE.equals(isCollected);
                AlbumCoverComp.this.tvAlbumCollectTip.setText(status ? "已收藏" : "收藏歌单");
                AlbumCoverComp.this.imgAlbumCollectIcon.setVisibility(status ? 8 : 0);
                float f2 = 0.5f;
                AlbumCoverComp.this.tvAlbumCollectTip.setAlpha(status ? 0.5f : 1.0f);
                View access$100 = AlbumCoverComp.this.layoutAlbumCollect;
                if (!status) {
                    f2 = 1.0f;
                }
                access$100.setAlpha(f2);
            }
        });
    }

    private void bindAlbumDescription(AlbumCoverViewModel viewModel) {
        viewModel.description.observe(getLifecycleOwner(), new Observer<String>() {
            public void onChanged(String des) {
                AlbumCoverComp.this.tvAlbumDescription.setVisibility(TextUtils.isEmpty(des) ? 8 : 0);
                AlbumCoverComp.this.tvAlbumDescription.setText(des);
            }
        });
    }

    private void bindAlbumCover(AlbumCoverViewModel viewModel) {
        viewModel.coverLink.observe(getLifecycleOwner(), new Observer<String>() {
            public void onChanged(String cover) {
                AlbumCoverComp.this.imgAlbumCover.setImageURI(cover);
            }
        });
    }

    private void bindAlbumTitleParams(AlbumCoverViewModel viewModel) {
        viewModel.albumTitleParams.observe(getLifecycleOwner(), new Observer<Pair<String, Boolean>>() {
            public void onChanged(final Pair<String, Boolean> params) {
                if (params != null) {
                    if (AlbumCoverComp.this.llTitle.getWidth() == 0) {
                        AlbumCoverComp.this.llTitle.post(new Runnable() {
                            public void run() {
                                AlbumCoverComp.this.updateAlbumTitle((String) params.first, ((Boolean) params.second).booleanValue());
                            }
                        });
                    } else {
                        AlbumCoverComp.this.updateAlbumTitle((String) params.first, ((Boolean) params.second).booleanValue());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateAlbumTitle(String title, boolean isShowEdit) {
        try {
            int i2 = 0;
            this.imgEdit.setVisibility(isShowEdit ? 0 : 8);
            updateTitleLayoutPadding(0);
            updateTitleEdit(0);
            if (TextUtils.isEmpty(title)) {
                updateTitle("", "");
                return;
            }
            int contentWidth = (this.tvTitleFirstLine.getWidth() - this.tvTitleFirstLine.getPaddingLeft()) - this.tvTitleFirstLine.getPaddingRight();
            if (isShowEdit) {
                i2 = this.iconPadding + this.iconWH;
            }
            int bufferSpace = i2;
            TextPaint paint = this.tvTitleFirstLine.getPaint();
            if (!tryToLayoutSingleLine(paint, title, contentWidth, bufferSpace)) {
                dynamicLayoutTitle(paint, title, contentWidth, bufferSpace);
            }
        } catch (Throwable e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private boolean tryToLayoutSingleLine(TextPaint paint, String title, int contentWidth, int bufferSpace) {
        int textWidth = (int) (((double) paint.measureText(title)) + 0.5d);
        if ((contentWidth - bufferSpace) - textWidth < 0) {
            return false;
        }
        updateTitle(title, "");
        updateTitleEdit(this.iconPadding + textWidth);
        return true;
    }

    private void dynamicLayoutTitle(TextPaint paint, String title, int contentWidth, int bufferSpace) {
        try {
            DynamicLayout layout = new DynamicLayout(title, paint, contentWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            if (layout.getLineCount() <= 1) {
                updateTitle(title, "");
                updateTitleLayoutPadding(ViewExKt.getDp(23));
                return;
            }
            String firstLineText = title.substring(0, Math.min(title.length(), Math.max(0, layout.getLineEnd(0))));
            String ellipsizeStr = TextUtils.ellipsize(title.substring(firstLineText.length()), paint, (float) (contentWidth - bufferSpace), TextUtils.TruncateAt.END).toString();
            updateTitle(firstLineText, ellipsizeStr);
            updateTitleEdit(((int) paint.measureText(ellipsizeStr)) + this.iconPadding);
        } catch (Throwable throwable) {
            if (DEBUG) {
                throwable.printStackTrace();
            }
        }
    }

    private void updateTitleLayoutPadding(int bottomPadding) {
        this.llTitle.setPadding(0, 0, 0, bottomPadding);
    }

    private void updateTitle(String firstLine, String secondLine) {
        this.tvTitleFirstLine.setText(firstLine);
        this.tvTitleSecondLine.setText(secondLine);
        int i2 = 8;
        this.tvTitleFirstLine.setVisibility(TextUtils.isEmpty(firstLine) ? 8 : 0);
        TextView textView = this.tvTitleSecondLine;
        if (!TextUtils.isEmpty(secondLine)) {
            i2 = 0;
        }
        textView.setVisibility(i2);
    }

    private void updateTitleEdit(int leftMargin) {
        if (this.imgEdit.getVisibility() == 0 && (this.imgEdit.getLayoutParams() instanceof ConstraintLayout.LayoutParams)) {
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) this.imgEdit.getLayoutParams();
            params.leftMargin = leftMargin;
            this.imgEdit.setLayoutParams(params);
        }
    }

    private void bindAlbumCreateTime(AlbumCoverViewModel viewModel) {
        viewModel.createTime.observe(getLifecycleOwner(), new Observer<String>() {
            public void onChanged(String time) {
                AlbumCoverComp.this.tvCreateTime.setText(time);
            }
        });
    }

    private void bindEditState(AlbumCoverViewModel viewModel) {
        viewModel.showEdit.observe(getLifecycleOwner(), new Observer<Boolean>() {
            public void onChanged(Boolean isShow) {
                AlbumCoverComp.this.imgEdit.setVisibility(Boolean.TRUE.equals(isShow) ? 0 : 8);
            }
        });
    }

    public void onBgColorChanged(int bgColor) {
        super.onBgColorChanged(bgColor);
        this.imgAlbumCollectIcon.setColorFilter(bgColor);
        this.tvAlbumCollectTip.setTextColor(bgColor);
    }

    /* access modifiers changed from: private */
    public void onAlbumCollectChange() {
        if (((AlbumCoverViewModel) getViewModel()).isAlbumCollected()) {
            new BoxAlertDialog.Builder(getContext()).setTitle(R.string.search_music_delete_dialog_title).setMessage("确定取消收藏该歌单么?").setNegativeButton(R.string.search_music_delete_dialog_cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            }).setPositiveButton(R.string.search_music_delete_dialog_ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    ((AlbumCoverViewModel) AlbumCoverComp.this.getViewModel()).toggleAlbumCollect(AlbumCoverComp.this.getContext());
                }
            }).show();
        } else {
            ((AlbumCoverViewModel) getViewModel()).toggleAlbumCollect(getContext());
        }
    }
}
