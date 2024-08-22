package com.tera.scan.component.base.ui.widget.bottomsheets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import fe.mmm.qw.th.qw.rg.fe.qw.ad;
import java.util.List;

public class SheetsItemAdapter extends RecyclerView.Adapter<qw> {
    public List<ad> qw;

    public static class qw extends RecyclerView.ViewHolder {

        /* renamed from: ad  reason: collision with root package name */
        public TextView f6857ad;
        public ImageView qw;

        public qw(View view) {
            super(view);
            this.qw = (ImageView) view.findViewById(R.id.sheets_item_left_icon);
            this.f6857ad = (TextView) view.findViewById(R.id.sheets_item_text);
        }
    }

    public SheetsItemAdapter(List<ad> list) {
        this.qw = list;
    }

    public int getItemCount() {
        List<ad> list = this.qw;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void onBindViewHolder(qw qwVar, int i2) {
        ad adVar = this.qw.get(i2);
        if (adVar.de() != 0) {
            qwVar.qw.setVisibility(0);
            qwVar.qw.setImageResource(adVar.de());
        } else {
            qwVar.qw.setVisibility(8);
        }
        qwVar.f6857ad.setText(adVar.ad());
        qwVar.itemView.setOnClickListener(adVar.qw());
    }

    public qw onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new qw(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sheets_list_item_layout, viewGroup, false));
    }
}
