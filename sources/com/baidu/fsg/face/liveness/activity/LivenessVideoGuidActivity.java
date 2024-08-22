package com.baidu.fsg.face.liveness.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.R;
import com.baidu.fsg.face.base.c.f;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.d;
import com.baidu.fsg.face.liveness.datamodel.VideoGetPortraitModel;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class LivenessVideoGuidActivity extends LivenessBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private Button f12232a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f12233b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ImageView f12234c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public View f12235d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public View f12236e;

    /* renamed from: f  reason: collision with root package name */
    private LivenessRecogCallback f12237f;

    /* renamed from: g  reason: collision with root package name */
    private VideoGetPortraitModel f12238g;

    /* renamed from: h  reason: collision with root package name */
    private View f12239h;

    /* renamed from: i  reason: collision with root package name */
    private View f12240i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public ViewPager f12241j;
    private List<View> k;
    private Handler l;
    /* access modifiers changed from: private */
    public AtomicBoolean m = new AtomicBoolean(false);

    public void onCreate(Bundle savedInstanceState) {
        Object data;
        super.onCreate(savedInstanceState);
        if (!(getIntent().getExtras() == null || (data = getIntent().getExtras().getSerializable(LivenessVideoLoadingActivity.KEY_VIDEOGETPORTRAITMODEL)) == null || !(data instanceof VideoGetPortraitModel))) {
            this.f12238g = (VideoGetPortraitModel) data;
        }
        setContentView(R.layout.layout_sapi_liveness_video_guide_page);
        d();
        a();
        this.l.postDelayed(new Runnable() {
            public void run() {
                LivenessVideoGuidActivity.this.f12235d.post(new Runnable() {
                    public void run() {
                        if (LivenessVideoGuidActivity.this.f12241j.getCurrentItem() == 0) {
                            LivenessVideoGuidActivity.this.m.set(true);
                            LivenessVideoGuidActivity.this.f12241j.setCurrentItem(1, true);
                        }
                    }
                });
            }
        }, 3000);
        try {
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            mScroller.set(this.f12241j, new a(this.f12241j.getContext(), new LinearInterpolator()));
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e2) {
        }
    }

    private void a() {
        c();
        b();
        this.f12235d = findViewById(R.id.rim_face_guide_indicator_1);
        this.f12236e = findViewById(R.id.rim_face_guide_indicator_2);
        this.f12235d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LivenessVideoGuidActivity.this.f12241j.setCurrentItem(0);
            }
        });
        this.f12236e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LivenessVideoGuidActivity.this.f12241j.setCurrentItem(1);
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.sapi_bio_title_btn_left);
        this.f12233b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view2) {
                LivenessVideoGuidActivity.this.onBackPressed();
            }
        });
        ViewPager viewPager = (ViewPager) findViewById(R.id.rim_face_video_guide_vp);
        this.f12241j = viewPager;
        viewPager.setAdapter(new ViewPagerAdapter(this.k));
        this.f12241j.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                if (LivenessVideoGuidActivity.this.m.get()) {
                    RimStatisticsUtil.onEvent(d.K);
                    LivenessVideoGuidActivity.this.m.set(false);
                } else {
                    RimStatisticsUtil.onEvent(d.L);
                }
                switch (position) {
                    case 0:
                        LivenessVideoGuidActivity.this.f12235d.setBackgroundDrawable(LivenessVideoGuidActivity.this.getResources().getDrawable(R.drawable.rim_face_indicator_circle_select));
                        LivenessVideoGuidActivity.this.f12236e.setBackgroundDrawable(LivenessVideoGuidActivity.this.getResources().getDrawable(R.drawable.rim_face_indicator_circle_normal));
                        return;
                    case 1:
                        LivenessVideoGuidActivity.this.f12235d.setBackgroundDrawable(LivenessVideoGuidActivity.this.getResources().getDrawable(R.drawable.rim_face_indicator_circle_normal));
                        LivenessVideoGuidActivity.this.f12236e.setBackgroundDrawable(LivenessVideoGuidActivity.this.getResources().getDrawable(R.drawable.rim_face_indicator_circle_select));
                        return;
                    default:
                        return;
                }
            }

            public void onPageScrollStateChanged(int state) {
            }
        });
        f.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
    }

    private void b() {
        final LinearLayout contentView = (LinearLayout) this.f12240i.findViewById(R.id.rim_face_guide_video_page2);
        final LinearLayout ll = (LinearLayout) this.f12240i.findViewById(R.id.rim_face_guide_indicator2_wrapper);
        this.f12240i.findViewById(R.id.btn_start_photo).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RimStatisticsUtil.onEvent(d.M);
                LogUtil.d("hello", "onEvent(StatServiceEvent.ENTERLIVENESS):  用户点击立即验证");
                LivenessVideoGuidActivity.this.e();
            }
        });
        contentView.post(new Runnable() {
            public void run() {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(contentView.getWidth(), (int) (((double) contentView.getHeight()) * 0.68d));
                params.gravity = 17;
                ll.setLayoutParams(params);
            }
        });
        TextView mReadContentTv = (TextView) this.f12240i.findViewById(R.id.rim_face_guide_indicator2_content);
        TextView mIndicator2TitleHintTv = (TextView) this.f12240i.findViewById(R.id.rim_face_video_guide_indicator2_title_hint);
        VideoGetPortraitModel videoGetPortraitModel = this.f12238g;
        if (videoGetPortraitModel != null && !TextUtils.isEmpty(videoGetPortraitModel.guideContent)) {
            mReadContentTv.setText(this.f12238g.guideContent);
        }
        String content = mIndicator2TitleHintTv.getText().toString();
        ForegroundColorSpan span = new ForegroundColorSpan(getResources().getColor(R.color.sapi_liveness_video_guide_tip_color));
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(content);
        int startIndex = content.indexOf("普");
        if (startIndex > 0) {
            stringBuilder.setSpan(span, startIndex, startIndex + 3, 33);
        }
        mIndicator2TitleHintTv.setText(stringBuilder);
    }

    private void c() {
        final LinearLayout content = (LinearLayout) this.f12239h.findViewById(R.id.rim_face_guide_video_page1);
        final LinearLayout ll = (LinearLayout) this.f12239h.findViewById(R.id.rim_face_guide_indicator1_wrapper);
        content.post(new Runnable() {
            public void run() {
                int wrapperWidth = content.getWidth();
                int wrapperHeight = (int) (((double) content.getHeight()) * 0.68d);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(wrapperWidth, wrapperHeight);
                params.gravity = 17;
                ll.setLayoutParams(params);
                LivenessVideoGuidActivity livenessVideoGuidActivity = LivenessVideoGuidActivity.this;
                livenessVideoGuidActivity.a(wrapperWidth, wrapperHeight, livenessVideoGuidActivity.f12234c);
            }
        });
        TextView nameTv = (TextView) this.f12239h.findViewById(R.id.tv_name);
        ImageView imageView = (ImageView) this.f12239h.findViewById(R.id.guide_imageview);
        this.f12234c = imageView;
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.rim_face_loading_indicator1_bg));
        String displayName = "";
        VideoGetPortraitModel videoGetPortraitModel = this.f12238g;
        if (videoGetPortraitModel != null) {
            displayName = videoGetPortraitModel.display_name;
        }
        if (this.livenessRecogDTO != null && this.livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_CERTINFO && !TextUtils.isEmpty(this.livenessRecogDTO.realName)) {
            displayName = this.livenessRecogDTO.realName;
        }
        if (!TextUtils.isEmpty(displayName)) {
            String livenessRecogTip = String.format(getString(R.string.sapi_liveness_guide_photo_tip), new Object[]{displayName});
            SpannableStringBuilder stringBuilder = new SpannableStringBuilder(livenessRecogTip);
            ForegroundColorSpan span = new ForegroundColorSpan(getResources().getColor(R.color.sapi_liveness_video_guide_tip_color));
            if (livenessRecogTip.indexOf("*") > 0) {
                stringBuilder.setSpan(span, livenessRecogTip.indexOf("*"), livenessRecogTip.indexOf("*") + displayName.length(), 33);
            } else {
                stringBuilder.setSpan(span, livenessRecogTip.indexOf(displayName), livenessRecogTip.indexOf(displayName) + displayName.length(), 33);
            }
            nameTv.setText(stringBuilder);
            return;
        }
        nameTv.setText(String.format(getString(R.string.sapi_liveness_guide_photo_tip), new Object[]{""}));
    }

    private void d() {
        this.f12237f = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
        this.k = new ArrayList();
        this.f12239h = LayoutInflater.from(getActivity()).inflate(R.layout.rim_face_video_loading_indicator1, (ViewGroup) null);
        this.f12240i = LayoutInflater.from(getActivity()).inflate(R.layout.rim_face_video_loading_indicator2, (ViewGroup) null);
        this.k.add(this.f12239h);
        this.k.add(this.f12240i);
        this.l = new Handler();
    }

    /* access modifiers changed from: private */
    public void e() {
        Intent intent = new Intent(this, LivenessVideoActivity.class);
        intent.putExtra(LivenessVideoLoadingActivity.KEY_VIDEOGETPORTRAITMODEL, this.f12238g);
        startActivityForResult(intent, 1001);
        System.gc();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == 0) {
            finish();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.f12237f != null) {
            LivenessRecogResult recogResult = new LivenessRecogResult();
            recogResult.setResultMsg(LivenessRecogResult.ERROR_MSG_USER_CANCEL);
            recogResult.setResultCode(-204);
            this.f12237f.b(recogResult);
        }
        RimStatisticsUtil.onEvent(d.R);
        RimStatisticsUtil.getInstance().triggerSending();
    }

    public class ViewPagerAdapter extends PagerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private List<View> f12256b;

        public ViewPagerAdapter(List<View> views) {
            this.f12256b = views;
        }

        public int getCount() {
            List<View> list = this.f12256b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public boolean isViewFromObject(View view2, Object object) {
            return view2 == object;
        }

        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(this.f12256b.get(position));
            return this.f12256b.get(position);
        }

        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(this.f12256b.get(position));
        }
    }

    /* access modifiers changed from: private */
    public void a(int sWidth, int sHeight, ImageView imageView) {
        int width;
        int height;
        int sWidth2 = (int) (((double) sWidth) * 0.8d);
        int sHeight2 = (int) (((double) sHeight) * 0.8d);
        Drawable drawable = imageView.getDrawable();
        int dWidth = drawable.getIntrinsicWidth();
        int dHeight = drawable.getIntrinsicHeight();
        float sScale = ((float) sWidth2) / ((float) sHeight2);
        float dScale = ((float) dWidth) / ((float) dHeight);
        if (sScale > dScale) {
            height = sHeight2;
            width = (int) (((float) dWidth) / (((float) dHeight) / ((float) sHeight2)));
        } else if (sScale < dScale) {
            width = sWidth2;
            height = (int) (((float) dHeight) / (((float) dWidth) / ((float) sWidth2)));
        } else {
            width = sWidth2;
            height = sHeight2;
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        params.gravity = 1;
        imageView.setLayoutParams(params);
    }

    public class a extends Scroller {

        /* renamed from: b  reason: collision with root package name */
        private int f12258b = 300;

        public a(Context context) {
            super(context);
        }

        public a(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public a(Context context, Interpolator interpolator, boolean flywheel) {
            super(context, interpolator, flywheel);
        }

        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, this.f12258b);
        }

        public void startScroll(int startX, int startY, int dx, int dy) {
            super.startScroll(startX, startY, dx, dy, this.f12258b);
        }
    }
}
