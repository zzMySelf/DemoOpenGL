package com.baidu.searchbox.novel.main.youth.holder;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.searchbox.discovery.novel.utils.NovelLottieUtils;
import com.baidu.searchbox.novel.R;
import com.baidu.searchbox.novel.main.utils.NovelInvokeUtils;
import com.baidu.searchbox.novel.main.utils.NovelUIUtil;
import com.baidu.searchbox.novel.main.youth.bean.NovelHomePageRecommendBaseData;
import com.baidu.searchbox.novel.main.youth.bean.NovelHomePageRecommendNewUserData;
import com.baidu.searchbox.novel.main.youth.manager.NovelHomePageRecommendTabManager;
import com.baidu.searchbox.novel.stat.ubc.NovelCustomUbc;
import com.baidu.searchbox.novel.stat.ubc.NovelUbcStatUtils;
import com.baidu.searchbox.noveladapter.settingcore.NovelFontSizeSettingsWrapper;
import com.baidu.searchbox.skin.NightModeHelper;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;

public class NovelHomePageNewUserHolder extends NovelHomePageBaseHolder<NovelHomePageRecommendBaseData> implements View.OnClickListener {
    private static final float BOOK_NAME_TEXT_SIZE = 14.0f;
    private static final String LOTTIE_JSON = "lottie/novel_recommend_new_user.json";
    private static final float TITLE_TEXT_SIZE = 12.0f;
    private View bookFour;
    private SimpleDraweeView bookFourCover;
    private TextView bookFourTitle;
    private View bookOne;
    private SimpleDraweeView bookOneCover;
    private TextView bookOneTitle;
    private View bookThree;
    private SimpleDraweeView bookThreeCover;
    private TextView bookThreeTitle;
    private View bookTwo;
    private SimpleDraweeView bookTwoCover;
    private TextView bookTwoTitle;
    private LottieAnimationView buttonView;
    private View nightMaskView;
    private View realButtonView;
    private ImageView titleImageView;
    private TextView titleTextView;

    public NovelHomePageNewUserHolder(NovelHomePageRecommendTabManager manager, View itemView) {
        super(manager, itemView);
        if (itemView != null) {
            this.titleImageView = (ImageView) itemView.findViewById(R.id.title_image);
            this.titleTextView = (TextView) itemView.findViewById(R.id.title_text);
            View findViewById = itemView.findViewById(R.id.book_1);
            this.bookOne = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(this);
            }
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.book_1_cover);
            this.bookOneCover = simpleDraweeView;
            cancelAutoNight(simpleDraweeView);
            this.bookOneTitle = (TextView) itemView.findViewById(R.id.book_1_title);
            View findViewById2 = itemView.findViewById(R.id.book_2);
            this.bookTwo = findViewById2;
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(this);
            }
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) itemView.findViewById(R.id.book_2_cover);
            this.bookTwoCover = simpleDraweeView2;
            cancelAutoNight(simpleDraweeView2);
            this.bookTwoTitle = (TextView) itemView.findViewById(R.id.book_2_title);
            View findViewById3 = itemView.findViewById(R.id.book_3);
            this.bookThree = findViewById3;
            if (findViewById3 != null) {
                findViewById3.setOnClickListener(this);
            }
            SimpleDraweeView simpleDraweeView3 = (SimpleDraweeView) itemView.findViewById(R.id.book_3_cover);
            this.bookThreeCover = simpleDraweeView3;
            cancelAutoNight(simpleDraweeView3);
            this.bookThreeTitle = (TextView) itemView.findViewById(R.id.book_3_title);
            View findViewById4 = itemView.findViewById(R.id.book_4);
            this.bookFour = findViewById4;
            if (findViewById4 != null) {
                findViewById4.setOnClickListener(this);
            }
            SimpleDraweeView simpleDraweeView4 = (SimpleDraweeView) itemView.findViewById(R.id.book_4_cover);
            this.bookFourCover = simpleDraweeView4;
            cancelAutoNight(simpleDraweeView4);
            this.bookFourTitle = (TextView) itemView.findViewById(R.id.book_4_title);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) itemView.findViewById(R.id.button_container);
            this.buttonView = lottieAnimationView;
            if (lottieAnimationView != null) {
                NovelLottieUtils.loadLottie(lottieAnimationView, LOTTIE_JSON, 0);
                this.buttonView.post(new NovelHomePageNewUserHolder$$ExternalSyntheticLambda0(this));
            }
            View findViewById5 = itemView.findViewById(R.id.real_button_area);
            this.realButtonView = findViewById5;
            if (findViewById5 != null) {
                findViewById5.setOnClickListener(this);
                this.realButtonView.setOnTouchListener(new NovelHomePageNewUserHolder$$ExternalSyntheticLambda1(this));
            }
            this.nightMaskView = itemView.findViewById(R.id.night_mask);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-baidu-searchbox-novel-main-youth-holder-NovelHomePageNewUserHolder  reason: not valid java name */
    public /* synthetic */ void m1738lambda$new$0$combaidusearchboxnovelmainyouthholderNovelHomePageNewUserHolder() {
        LottieAnimationView lottieAnimationView = this.buttonView;
        if (lottieAnimationView != null) {
            int width = lottieAnimationView.getWidth();
            ViewGroup.LayoutParams layoutParams = this.buttonView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = width / 8;
                this.buttonView.setLayoutParams(layoutParams);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$com-baidu-searchbox-novel-main-youth-holder-NovelHomePageNewUserHolder  reason: not valid java name */
    public /* synthetic */ boolean m1739lambda$new$1$combaidusearchboxnovelmainyouthholderNovelHomePageNewUserHolder(View view2, MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
            case 11:
                LottieAnimationView lottieAnimationView = this.buttonView;
                if (lottieAnimationView == null) {
                    return false;
                }
                lottieAnimationView.setAlpha(0.8f);
                return false;
            case 1:
            case 12:
                LottieAnimationView lottieAnimationView2 = this.buttonView;
                if (lottieAnimationView2 != null) {
                    lottieAnimationView2.setAlpha(1.0f);
                }
                if (view2 == null) {
                    return false;
                }
                view2.performClick();
                return false;
            case 3:
                LottieAnimationView lottieAnimationView3 = this.buttonView;
                if (lottieAnimationView3 == null) {
                    return false;
                }
                lottieAnimationView3.setAlpha(1.0f);
                return false;
            default:
                return false;
        }
    }

    public static View getView(Context context) {
        return View.inflate(context, R.layout.novel_home_page_recommend_new_user, (ViewGroup) null);
    }

    public void bindData(NovelHomePageRecommendBaseData data) {
        if (data instanceof NovelHomePageRecommendNewUserData) {
            NovelHomePageRecommendNewUserData userData = (NovelHomePageRecommendNewUserData) data;
            ImageView imageView = this.titleImageView;
            if (imageView != null) {
                NovelFontSizeSettingsWrapper.setScaledViewSize(imageView, (float) NovelUIUtil.getDimension(imageView.getContext(), R.dimen.novel_dimens_86dp, 258), (float) NovelUIUtil.getDimension(this.titleImageView.getContext(), R.dimen.novel_dimens_18dp, 54));
            }
            TextView textView = this.titleTextView;
            if (textView != null) {
                textView.setText(userData.getModuleTitle());
                NovelFontSizeSettingsWrapper.setTextViewScaledSize(this.titleTextView, 12.0f);
            }
            int i2 = 0;
            NovelHomePageRecommendNewUserData.BookData bookData = userData.getBookData(0);
            View view2 = this.bookOne;
            if (view2 != null) {
                if (bookData != null) {
                    view2.setVisibility(0);
                    bindBookData(this.bookOne, bookData);
                    SimpleDraweeView simpleDraweeView = this.bookOneCover;
                    if (simpleDraweeView != null) {
                        simpleDraweeView.setImageURI(bookData.getCoverUrl());
                    }
                    TextView textView2 = this.bookOneTitle;
                    if (textView2 != null) {
                        textView2.setText(bookData.getTitle());
                        NovelFontSizeSettingsWrapper.setTextViewScaledSize(this.bookOneTitle, 14.0f);
                    }
                } else {
                    view2.setVisibility(4);
                }
            }
            NovelHomePageRecommendNewUserData.BookData bookData2 = userData.getBookData(1);
            View view3 = this.bookTwo;
            if (view3 != null) {
                if (bookData2 != null) {
                    view3.setVisibility(0);
                    bindBookData(this.bookTwo, bookData2);
                    SimpleDraweeView simpleDraweeView2 = this.bookTwoCover;
                    if (simpleDraweeView2 != null) {
                        simpleDraweeView2.setImageURI(bookData2.getCoverUrl());
                    }
                    TextView textView3 = this.bookTwoTitle;
                    if (textView3 != null) {
                        textView3.setText(bookData2.getTitle());
                        NovelFontSizeSettingsWrapper.setTextViewScaledSize(this.bookTwoTitle, 14.0f);
                    }
                } else {
                    view3.setVisibility(4);
                }
            }
            NovelHomePageRecommendNewUserData.BookData bookData3 = userData.getBookData(2);
            View view4 = this.bookThree;
            if (view4 != null) {
                if (bookData3 != null) {
                    view4.setVisibility(0);
                    bindBookData(this.bookThree, bookData3);
                    SimpleDraweeView simpleDraweeView3 = this.bookThreeCover;
                    if (simpleDraweeView3 != null) {
                        simpleDraweeView3.setImageURI(bookData3.getCoverUrl());
                    }
                    TextView textView4 = this.bookThreeTitle;
                    if (textView4 != null) {
                        textView4.setText(bookData3.getTitle());
                        NovelFontSizeSettingsWrapper.setTextViewScaledSize(this.bookThreeTitle, 14.0f);
                    }
                } else {
                    view4.setVisibility(4);
                }
            }
            NovelHomePageRecommendNewUserData.BookData bookData4 = userData.getBookData(3);
            View view5 = this.bookFour;
            if (view5 != null) {
                if (bookData4 != null) {
                    view5.setVisibility(0);
                    bindBookData(this.bookFour, bookData4);
                    SimpleDraweeView simpleDraweeView4 = this.bookFourCover;
                    if (simpleDraweeView4 != null) {
                        simpleDraweeView4.setImageURI(bookData4.getCoverUrl());
                    }
                    TextView textView5 = this.bookFourTitle;
                    if (textView5 != null) {
                        textView5.setText(bookData4.getTitle());
                        NovelFontSizeSettingsWrapper.setTextViewScaledSize(this.bookFourTitle, 14.0f);
                    }
                } else {
                    view5.setVisibility(4);
                }
            }
            View view6 = this.nightMaskView;
            if (view6 != null) {
                if (!NightModeHelper.isNightMode()) {
                    i2 = 8;
                }
                view6.setVisibility(i2);
            }
        }
    }

    public void ubcShow() {
        if (isTabShow()) {
            NovelUbcStatUtils.ubc5958("novel", "show", "select", NovelCustomUbc.Source.SOURCE_NOVEL_HOME_PAGE_NEW_USER, "");
        }
    }

    public void onClick(View view2) {
        NovelHomePageRecommendNewUserData.BookData bookData = null;
        String source = "";
        if (view2 == this.realButtonView) {
            bookData = getBookData(this.bookOne);
            source = "button";
        } else {
            View view3 = this.bookOne;
            if (view2 == view3) {
                bookData = getBookData(view3);
                source = "book";
            } else {
                View view4 = this.bookTwo;
                if (view2 == view4) {
                    bookData = getBookData(view4);
                    source = "book";
                } else {
                    View view5 = this.bookThree;
                    if (view2 == view5) {
                        bookData = getBookData(view5);
                        source = "book";
                    } else {
                        View view6 = this.bookFour;
                        if (view2 == view6) {
                            bookData = getBookData(view6);
                            source = "book";
                        }
                    }
                }
            }
        }
        if (bookData != null) {
            NovelInvokeUtils.invoke(bookData.getCmd());
        }
        if (!TextUtils.isEmpty(source)) {
            ubcClick(source);
        }
    }

    private void bindBookData(View view2, NovelHomePageRecommendNewUserData.BookData data) {
        if (view2 != null && data != null) {
            view2.setTag(data);
        }
    }

    private NovelHomePageRecommendNewUserData.BookData getBookData(View view2) {
        if (view2 == null) {
            return null;
        }
        Object tag = view2.getTag();
        if (tag instanceof NovelHomePageRecommendNewUserData.BookData) {
            return (NovelHomePageRecommendNewUserData.BookData) tag;
        }
        return null;
    }

    private void cancelAutoNight(SimpleDraweeView view2) {
        GenericDraweeHierarchy hierarchy;
        if (view2 != null && (hierarchy = (GenericDraweeHierarchy) view2.getHierarchy()) != null) {
            hierarchy.setUseGlobalColorFilter(false);
        }
    }

    private void ubcClick(String source) {
        NovelUbcStatUtils.ubc5958("novel", "click", "select", source, "");
    }
}
