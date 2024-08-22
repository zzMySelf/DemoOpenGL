package com.baidu.wallet.base.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.apollon.utils.ResUtils;

public class WalletDialog extends Dialog {
    public ViewGroup a;
    public Adapter b;
    public LayoutInflater c;
    public ViewHolder d;
    public Context mContext;

    public static abstract class Adapter<VH extends ViewHolder> {
        public final void bindViewHolder(VH vh) {
            onBindViewHolder(vh);
        }

        public final VH createViewHolder(ViewGroup viewGroup) {
            return onCreateViewHolder(viewGroup);
        }

        public abstract void onBindViewHolder(VH vh);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup);
    }

    public static abstract class ViewHolder {
        public final View a;

        public ViewHolder(View view) {
            if (view != null) {
                this.a = view;
                return;
            }
            throw new IllegalArgumentException("contentView may not be null");
        }
    }

    public WalletDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        LayoutInflater from = LayoutInflater.from(this.mContext);
        this.c = from;
        ViewGroup viewGroup = (ViewGroup) from.inflate(ResUtils.layout(this.mContext, "wallet_base_layout_dialog"), (ViewGroup) null);
        this.a = viewGroup;
        setContentView(viewGroup);
        ViewHolder createViewHolder = this.b.createViewHolder(this.a);
        this.d = createViewHolder;
        this.a.addView(createViewHolder.a);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void onStart() {
        ViewHolder viewHolder;
        super.onStart();
        Adapter adapter = this.b;
        if (adapter != null && this.a != null && (viewHolder = this.d) != null) {
            adapter.bindViewHolder(viewHolder);
        }
    }

    public void setAdapter(Adapter adapter) {
        this.b = adapter;
    }

    public WalletDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mContext = context;
    }

    public WalletDialog(Context context, int i2) {
        super(context, i2);
        this.mContext = context;
    }
}
