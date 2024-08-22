package com.baidu.searchbox.download.center.debug;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.template.card.presenter.ViewTypePresenter;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.builder.BubbleJumpArrowBuilder;
import com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder;
import com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager;
import com.baidu.searchbox.ui.bubble.manager.BubbleTextManager;

public class BubbleTestActivity extends BaseActivity {
    public static final String BUBBLE_TYPE = "key_bubble_type";
    public static final String TYPE_JUMP_ARROW = "JumpArrowBubble";
    public static final String TYPE_TEXT = "textBubble";
    private static final String[] dummyText = {"文", "文本", "文本气", "文本气泡", "文本气泡，", "文本气泡，点", "文本气泡，点我", "文本气泡，点我关", "文本气泡，点我关闭", "文本气泡，点我关闭文本气泡，点我关闭文本气泡，点我关闭文本气泡，点我关闭文本气泡，点我关闭文本气泡，点我关闭"};
    private int centerIndex = 0;
    private int index = 0;
    /* access modifiers changed from: private */
    public int mBgColorDay = -1;
    /* access modifiers changed from: private */
    public int mBgColorNight = -1;
    /* access modifiers changed from: private */
    public BubbleBaseManager mBubbleManager;
    /* access modifiers changed from: private */
    public int mTextColorDay = -1;
    /* access modifiers changed from: private */
    public int mTextColorNight = -1;
    /* access modifiers changed from: private */
    public BubbleManager.BubbleStyle style = BubbleManager.BubbleStyle.TextOnly;
    private int textIndex = 0;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().hasExtra(BUBBLE_TYPE)) {
            String type = getIntent().getStringExtra(BUBBLE_TYPE);
            if (TYPE_TEXT.equalsIgnoreCase(type)) {
                this.style = BubbleManager.BubbleStyle.TextOnly;
            } else if (TYPE_JUMP_ARROW.equalsIgnoreCase(type)) {
                this.style = BubbleManager.BubbleStyle.TextWithJumpArrow;
            }
        }
        initDefaultColor();
        LinearLayout root = new LinearLayout(this);
        LinearLayout.LayoutParams flp = new LinearLayout.LayoutParams(-1, -1);
        root.setBackgroundColor(-1);
        root.setLayoutParams(flp);
        root.setOrientation(1);
        root.addView(addDiectionTest());
        root.addView(addColorTest());
        setContentView(root);
    }

    private RelativeLayout addDiectionTest() {
        int margin = DeviceUtil.ScreenInfo.dp2px(this, 10.0f);
        int size = DeviceUtil.ScreenInfo.dp2px(this, 200.0f);
        RelativeLayout content = new RelativeLayout(this);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(-1, size);
        content.setBackgroundColor(-1);
        rlp.setMargins(margin, margin, margin, margin);
        content.setLayoutParams(rlp);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(-2, -2);
        lp.alignWithParent = true;
        lp.addRule(9);
        lp.addRule(10);
        lp.setMargins(margin, margin, margin, margin);
        TextView textView = createTextView(BubblePosition.DOWN);
        textView.setLayoutParams(lp);
        content.addView(textView);
        RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(-2, -2);
        lp2.alignWithParent = true;
        lp2.addRule(9);
        lp2.addRule(12);
        lp2.setMargins(margin, margin, margin, margin);
        TextView textView2 = createTextView(BubblePosition.UP);
        textView2.setLayoutParams(lp2);
        content.addView(textView2);
        RelativeLayout.LayoutParams lp3 = new RelativeLayout.LayoutParams(-2, -2);
        lp3.alignWithParent = true;
        lp3.addRule(11);
        lp3.addRule(10);
        lp3.setMargins(margin, margin, margin, margin);
        TextView textView3 = createTextView(BubblePosition.DOWN);
        textView3.setLayoutParams(lp3);
        content.addView(textView3);
        RelativeLayout.LayoutParams lp4 = new RelativeLayout.LayoutParams(-2, -2);
        lp4.alignWithParent = true;
        lp4.addRule(11);
        lp4.addRule(12);
        lp4.setMargins(margin, margin, margin, margin);
        TextView textView4 = createTextView(BubblePosition.UP);
        textView4.setLayoutParams(lp4);
        content.addView(textView4);
        RelativeLayout.LayoutParams lp5 = new RelativeLayout.LayoutParams(-2, -2);
        lp5.alignWithParent = true;
        lp5.addRule(13);
        lp5.setMargins(margin, margin, margin, margin);
        TextView textView5 = createTextView(BubblePosition.UP);
        textView5.setLayoutParams(lp5);
        textView5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BubbleTestActivity.this.showBubble(v);
            }
        });
        content.addView(textView5);
        RelativeLayout.LayoutParams lp6 = new RelativeLayout.LayoutParams(-2, -2);
        lp6.alignWithParent = true;
        lp6.addRule(14);
        lp6.addRule(12);
        lp6.setMargins(margin, margin, margin, margin);
        TextView textView6 = createTextView("测试新气泡不可点");
        textView6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int unused = BubbleTestActivity.this.mTextColorDay = -1;
                int unused2 = BubbleTestActivity.this.mTextColorNight = -1;
                BubbleTestActivity.this.showBubbleNotClickable(v, BubblePosition.DOWN);
            }
        });
        textView6.setLayoutParams(lp6);
        content.addView(textView6);
        return content;
    }

    private TextView createTextView(final BubblePosition dire) {
        TextView textView = new TextView(this);
        textView.setBackgroundColor(ViewTypePresenter.DEFAULT_COLOR_NIGHT);
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        StringBuilder append = new StringBuilder().append("气泡");
        int i2 = this.index;
        this.index = i2 + 1;
        textView.setText(append.append(i2).toString());
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BubbleTestActivity.this.showBubble(v, dire);
            }
        });
        return textView;
    }

    private TextView createTextView(String text) {
        TextView textView = new TextView(this);
        textView.setBackgroundColor(ViewTypePresenter.DEFAULT_COLOR_NIGHT);
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setText(text);
        return textView;
    }

    /* access modifiers changed from: private */
    public String randText(BubbleManager.BubbleStyle style2) {
        int i2 = this.textIndex;
        this.textIndex = i2 + 1;
        String[] strArr = dummyText;
        return strArr[Math.abs(i2 % strArr.length)];
    }

    /* access modifiers changed from: private */
    public void showBubble(View anchorView) {
        BubblePosition[] dirList = {BubblePosition.UP, BubblePosition.DOWN, BubblePosition.LEFT, BubblePosition.RIGHT};
        int i2 = this.centerIndex;
        this.centerIndex = i2 + 1;
        int dirIndex = i2 % dirList.length;
        if (dirIndex < 0 || dirIndex >= dirList.length) {
            showBubble(anchorView);
        } else {
            showBubble(anchorView, dirList[dirIndex]);
        }
    }

    /* access modifiers changed from: private */
    public void showBubble(View anchorView, BubblePosition position) {
        if (this.style == BubbleManager.BubbleStyle.TextOnly) {
            BubbleTextManager build = ((BubbleTextBuilder) BubbleManager.newBuilder(BubbleTextBuilder.class)).setText(randText(this.style)).setTextColor(this.mTextColorDay, this.mTextColorNight).setFontSize(1, 12.0f).setBackgroundColor(this.mBgColorDay, this.mBgColorNight).setAnchorView(anchorView).setAutoDismiss(true).setAutoDismissInterval(7000).enableAnimation(true).setForceShowPosition(position).build();
            this.mBubbleManager = build;
            build.showBubble();
            return;
        }
        BubbleTextManager build2 = ((BubbleJumpArrowBuilder) BubbleManager.newBuilder(BubbleJumpArrowBuilder.class)).setText(randText(this.style)).setTextColor(this.mTextColorDay, this.mTextColorNight).setFontSize(1, 12.0f).setBackgroundColor(this.mBgColorDay, this.mBgColorNight).setAnchorView(anchorView).setAutoDismiss(true).setAutoDismissInterval(7000).setForceShowPosition(position).enableAnimation(true).setOnBubbleEventListener((BubbleManager.OnBubbleEventListener) new BubbleManager.OnBubbleEventListener() {
            public void onBubbleDismiss() {
            }

            public void onBubbleShow() {
            }

            public void onBubbleClick() {
                BubbleTestActivity.this.mBubbleManager.dismissBubble();
                UniversalToast.makeText((Context) BubbleTestActivity.this, (CharSequence) "气泡被点击了").showToast();
            }
        }).build();
        this.mBubbleManager = build2;
        build2.showBubble();
    }

    private void showBubble(View anchorView, int time) {
        if (this.style == BubbleManager.BubbleStyle.TextOnly) {
            BubbleTextManager build = ((BubbleTextBuilder) BubbleManager.newBuilder(BubbleTextBuilder.class)).setText(randText(this.style)).setTextColor(this.mTextColorDay, this.mTextColorNight).setFontSize(1, 12.0f).setBackgroundColor(this.mBgColorDay, this.mBgColorNight).setAnchorView(anchorView).setAutoDismiss(true).setAutoDismissInterval(time).enableAnimation(true).build();
            this.mBubbleManager = build;
            build.showBubble();
            return;
        }
        BubbleTextManager build2 = ((BubbleJumpArrowBuilder) BubbleManager.newBuilder(BubbleJumpArrowBuilder.class)).setText(randText(this.style)).setTextColor(this.mTextColorDay, this.mTextColorNight).setFontSize(1, 12.0f).setBackgroundColor(this.mBgColorDay, this.mBgColorNight).setAnchorView(anchorView).setAutoDismiss(true).setAutoDismissInterval(time).enableAnimation(true).build();
        this.mBubbleManager = build2;
        build2.showBubble();
    }

    /* access modifiers changed from: private */
    public void showBubbleNotClickable(View anchorView, BubblePosition position) {
        if (this.style == BubbleManager.BubbleStyle.TextOnly) {
            BubbleTextManager build = ((BubbleTextBuilder) BubbleManager.newBuilder(BubbleTextBuilder.class)).setText(randText(this.style)).setTextColor(this.mTextColorDay, this.mTextColorNight).setFontSize(1, 12.0f).setBackgroundColor(this.mBgColorDay, this.mBgColorNight).setAnchorView(anchorView).setAutoDismiss(true).enableClkDismiss(false).setAutoDismissInterval(7000).enableAnimation(true).setForceShowPosition(position).build();
            this.mBubbleManager = build;
            build.showBubble();
            return;
        }
        BubbleTextManager build2 = ((BubbleJumpArrowBuilder) BubbleManager.newBuilder(BubbleJumpArrowBuilder.class)).setText(randText(this.style)).setTextColor(this.mTextColorDay, this.mTextColorNight).setFontSize(1, 12.0f).setBackgroundColor(this.mBgColorDay, this.mBgColorNight).setAnchorView(anchorView).setAutoDismiss(true).enableClkDismiss(false).setAutoDismissInterval(7000).setForceShowPosition(position).enableAnimation(true).setOnBubbleEventListener((BubbleManager.OnBubbleEventListener) new BubbleManager.OnBubbleEventListener() {
            public void onBubbleDismiss() {
            }

            public void onBubbleShow() {
            }

            public void onBubbleClick() {
                BubbleTestActivity.this.mBubbleManager.dismissBubble();
                UniversalToast.makeText((Context) BubbleTestActivity.this, (CharSequence) "气泡被点击了").showToast();
            }
        }).build();
        this.mBubbleManager = build2;
        build2.showBubble();
    }

    private LinearLayout addColorTest() {
        int margin = DeviceUtil.ScreenInfo.dp2px(this, 10.0f);
        int size = DeviceUtil.ScreenInfo.dp2px(this, 390.0f);
        LinearLayout content = new LinearLayout(this);
        LinearLayout.LayoutParams rlp = new LinearLayout.LayoutParams(-1, size);
        content.setBackgroundColor(-1);
        rlp.setMargins(margin, margin, margin, margin);
        content.setLayoutParams(rlp);
        content.setOrientation(1);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-2, -2);
        lp.setMargins(margin, margin, margin, margin);
        TextView textView = createTextView("文字默认色");
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int unused = BubbleTestActivity.this.mTextColorDay = -1;
                int unused2 = BubbleTestActivity.this.mTextColorNight = -1;
                BubbleTestActivity.this.showBubble(v, BubblePosition.RIGHT);
            }
        });
        textView.setLayoutParams(lp);
        content.addView(textView);
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(-2, -2);
        lp2.setMargins(margin, margin, margin, margin);
        TextView textView2 = createTextView("背景默认色");
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BubbleTestActivity.this.initDefaultColor();
                BubbleTestActivity.this.showBubble(v, BubblePosition.RIGHT);
            }
        });
        textView2.setLayoutParams(lp2);
        content.addView(textView2);
        LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(-2, -2);
        lp3.setMargins(margin, margin, margin, margin);
        TextView textView3 = createTextView("文字红色");
        textView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int unused = BubbleTestActivity.this.mTextColorDay = SupportMenu.CATEGORY_MASK;
                int unused2 = BubbleTestActivity.this.mTextColorNight = SupportMenu.CATEGORY_MASK;
                BubbleTestActivity.this.showBubble(v, BubblePosition.RIGHT);
            }
        });
        textView3.setLayoutParams(lp3);
        content.addView(textView3);
        LinearLayout.LayoutParams lp4 = new LinearLayout.LayoutParams(-2, -2);
        lp4.setMargins(margin, margin, margin, margin);
        TextView textView4 = createTextView("背景绿色");
        textView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int unused = BubbleTestActivity.this.mBgColorDay = -16711936;
                int unused2 = BubbleTestActivity.this.mBgColorNight = -16711936;
                BubbleTestActivity.this.showBubble(v, BubblePosition.RIGHT);
            }
        });
        textView4.setLayoutParams(lp4);
        content.addView(textView4);
        LinearLayout.LayoutParams lp5 = new LinearLayout.LayoutParams(-2, -2);
        lp5.setMargins(margin, margin, margin, margin);
        TextView textView5 = createTextView("部分文字变色");
        textView5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BubbleTestActivity bubbleTestActivity = BubbleTestActivity.this;
                String text = bubbleTestActivity.randText(bubbleTestActivity.style);
                if (text.length() < 2) {
                    text = text + text + text;
                }
                SpannableStringBuilder spannableString = new SpannableStringBuilder();
                spannableString.append(text);
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#009ad6")), 0, 2, 34);
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#d600a6")), text.length() - 2, text.length(), 34);
                spannableString.setSpan(new AbsoluteSizeSpan(20, true), (text.length() / 2) - 1, text.length() / 2, 34);
                BubbleTestActivity.this.showBubbleColorText(v, BubblePosition.RIGHT, text, spannableString);
            }
        });
        textView5.setLayoutParams(lp5);
        content.addView(textView5);
        LinearLayout.LayoutParams lp6 = new LinearLayout.LayoutParams(-2, -2);
        lp6.setMargins(margin, margin, margin, margin);
        TextView textView6 = createTextView("测试老气泡");
        textView6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int unused = BubbleTestActivity.this.mTextColorDay = -1;
                int unused2 = BubbleTestActivity.this.mTextColorNight = -1;
                BubbleTestActivity.this.testOldBubble(v);
            }
        });
        textView6.setLayoutParams(lp6);
        content.addView(textView6);
        LinearLayout.LayoutParams lp7 = new LinearLayout.LayoutParams(-2, -2);
        lp7.setMargins(margin, margin, margin, margin);
        TextView textView7 = createTextView("测试老气泡带按钮");
        textView7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int unused = BubbleTestActivity.this.mTextColorDay = -1;
                int unused2 = BubbleTestActivity.this.mTextColorNight = -1;
                BubbleTestActivity.this.testOldBubbleWithButton(v);
            }
        });
        textView7.setLayoutParams(lp7);
        content.addView(textView7);
        LinearLayout.LayoutParams lp8 = new LinearLayout.LayoutParams(-2, -2);
        lp8.setMargins(margin, margin, margin, margin);
        TextView textView8 = createTextView("测试老气泡不可点");
        textView8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int unused = BubbleTestActivity.this.mTextColorDay = -1;
                int unused2 = BubbleTestActivity.this.mTextColorNight = -1;
                BubbleTestActivity.this.testOldBubbleNotClickable(v);
            }
        });
        textView8.setLayoutParams(lp8);
        content.addView(textView8);
        return content;
    }

    /* access modifiers changed from: private */
    public void testOldBubble(View view2) {
        BubbleManager.getBuilder().setText("老气泡内容").setAutoDismissInterval(5000).setPaddingBetweenAnchor(1.0f).setAnchor(view2).setForceShowPosition(BubblePosition.UP).enableClkDismiss(true).enableAnimation(true).setOffsetOfArrow(-10.0f).build().showBubble();
    }

    /* access modifiers changed from: private */
    public void testOldBubbleWithButton(View view2) {
        BubbleManager.getBuilder().setText("老气泡内容").setAutoDismissInterval(5000).setPaddingBetweenAnchor(1.0f).setAnchor(view2).setForceShowPosition(BubblePosition.UP).enableClkDismiss(true).enableAnimation(true).setOffsetOfArrow(-10.0f).setBtnText("知道了").build().showBubble();
    }

    /* access modifiers changed from: private */
    public void testOldBubbleNotClickable(View view2) {
        BubbleManager.getBuilder().setText("老气泡内容").setAutoDismissInterval(5000).setPaddingBetweenAnchor(1.0f).setAnchor(view2).setForceShowPosition(BubblePosition.UP).enableClkDismiss(false).enableAnimation(true).setOffsetOfArrow(-10.0f).build().showBubble();
    }

    private void testOldBubbleTwice(View view2) {
        final BubbleManager bubbleManager = BubbleManager.getBuilder().setText("老气泡内容").setAutoDismissInterval(5000).setPaddingBetweenAnchor(1.0f).setAnchor(view2).setForceShowPosition(BubblePosition.UP).enableClkDismiss(true).enableAnimation(true).setOffsetOfArrow(-10.0f).build();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                bubbleManager.showBubble();
            }
        }).start();
        bubbleManager.showBubble();
    }

    /* access modifiers changed from: private */
    public void showBubbleColorText(View anchorView, BubblePosition position, String text, SpannableStringBuilder span) {
        if (this.style == BubbleManager.BubbleStyle.TextOnly) {
            BubbleTextManager build = ((BubbleTextBuilder) BubbleManager.newBuilder(BubbleTextBuilder.class)).setText(text).setTextColor(this.mTextColorDay, this.mTextColorNight).setFontSize(1, 12.0f).setSpan(span).setBackgroundColor(this.mBgColorDay, this.mBgColorNight).setAnchorView(anchorView).setAutoDismiss(true).setAutoDismissInterval(7000).enableAnimation(true).setForceShowPosition(position).build();
            this.mBubbleManager = build;
            build.showBubble();
            return;
        }
        BubbleTextManager build2 = ((BubbleJumpArrowBuilder) BubbleManager.newBuilder(BubbleJumpArrowBuilder.class)).setText(text).setTextColor(this.mTextColorDay, this.mTextColorNight).setFontSize(1, 12.0f).setSpan(span).setBackgroundColor(this.mBgColorDay, this.mBgColorNight).setAnchorView(anchorView).setAutoDismiss(true).setAutoDismissInterval(7000).enableAnimation(true).setForceShowPosition(position).setOnBubbleEventListener((BubbleManager.OnBubbleEventListener) new BubbleManager.OnBubbleEventListener() {
            public void onBubbleDismiss() {
            }

            public void onBubbleShow() {
            }

            public void onBubbleClick() {
                BubbleTestActivity.this.mBubbleManager.dismissBubble();
                UniversalToast.makeText((Context) BubbleTestActivity.this, (CharSequence) "气泡被点击了").showToast();
            }
        }).build();
        this.mBubbleManager = build2;
        build2.showBubble();
    }

    /* access modifiers changed from: private */
    public void initDefaultColor() {
        int color = AppRuntime.getAppContext().getResources().getColor(R.color.GC28);
        this.mBgColorDay = color;
        this.mBgColorNight = color;
    }
}
