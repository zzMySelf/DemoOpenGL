package com.baidu.swan.games.view.recommend.listmode;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.game.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class ListRecommendViewHolder extends RecyclerView.ViewHolder {
    public TextView detail;
    public SimpleDraweeView icon;
    public TextView name;
    public Button play;

    public ListRecommendViewHolder(View itemView) {
        super(itemView);
        this.icon = (SimpleDraweeView) itemView.findViewById(R.id.swangame_recommend_item_icon);
        this.name = (TextView) itemView.findViewById(R.id.swangame_recommend_item_name);
        this.detail = (TextView) itemView.findViewById(R.id.swangame_recommend_item_detail);
        this.play = (Button) itemView.findViewById(R.id.swangame_recommend_item_play);
    }
}
