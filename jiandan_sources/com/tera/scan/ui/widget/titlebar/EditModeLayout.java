package com.tera.scan.ui.widget.titlebar;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.aiscan.R;

public class EditModeLayout {

    /* renamed from: ad  reason: collision with root package name */
    public Button f7430ad;

    /* renamed from: de  reason: collision with root package name */
    public Button f7431de;

    /* renamed from: fe  reason: collision with root package name */
    public TextView f7432fe;
    public View qw;

    /* renamed from: rg  reason: collision with root package name */
    public ITitleBarSelectedModeListener f7433rg;

    /* renamed from: th  reason: collision with root package name */
    public final Activity f7434th;

    /* renamed from: yj  reason: collision with root package name */
    public Boolean f7435yj = Boolean.FALSE;

    public interface EditModeLayoutVisibleListener {
    }

    public class ad implements View.OnClickListener {
        public ad() {
        }

        public void onClick(View view) {
            if (EditModeLayout.this.f7433rg != null) {
                EditModeLayout.this.f7433rg.ad();
            }
        }
    }

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
            if (EditModeLayout.this.f7433rg != null) {
                EditModeLayout.this.f7433rg.qw();
            }
        }
    }

    public EditModeLayout(Activity activity, ViewGroup viewGroup, Boolean bool) {
        this.f7435yj = bool;
        this.f7434th = activity;
        ad(((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.title_bar_edit_mode_layout, viewGroup));
    }

    public final void ad(View view) {
        View findViewById = view.findViewById(R.id.edit_mode_layout);
        this.qw = findViewById;
        findViewById.setVisibility(8);
        this.f7430ad = (Button) view.findViewById(R.id.edit_left_button);
        Button button = (Button) view.findViewById(R.id.edit_right_button);
        this.f7431de = button;
        button.setText(R.string.select_all);
        this.f7432fe = (TextView) view.findViewById(R.id.edit_title);
        Button button2 = this.f7430ad;
        if (button2 != null) {
            button2.setOnClickListener(new qw());
        }
        Button button3 = this.f7431de;
        if (button3 != null) {
            button3.setOnClickListener(new ad());
        }
        if (this.f7435yj.booleanValue()) {
            this.qw.setBackgroundColor(0);
            Button button4 = this.f7430ad;
            if (button4 != null) {
                button4.setTextColor(-1);
            }
            this.f7432fe.setTextColor(-1);
            Button button5 = this.f7431de;
            if (button5 != null) {
                button5.setTextColor(-1);
            }
        }
    }
}
