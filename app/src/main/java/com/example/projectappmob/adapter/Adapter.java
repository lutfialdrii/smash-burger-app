package com.example.projectappmob.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectappmob.R;
import com.example.projectappmob.model.history.DataItem;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.HolderData>{
    private Context context;
    private List<DataItem> listData;
    private int id_transaksi;



    public Adapter(Context context, List<DataItem> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataItem dataItem = listData.get(position);

        holder.tv_id.setText(dataItem.getIdTransaksi());
        holder.tvAlamat.setText("Tujuan : "+dataItem.getAlamat());
        holder.tvKuantitas.setText("Total Item : "+dataItem.getKuantitas());
        holder.tvHarga.setText("Total Transaksi : Rp."+dataItem.getTotalHarga());
        holder.tvWaktu.setText("Waktu Transaksi : "+dataItem.getWaktu());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tv_id, tvHarga, tvWaktu, tvKuantitas, tvAlamat;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tv_id);
            tvHarga = itemView.findViewById(R.id.tvHarga);
            tvWaktu = itemView.findViewById(R.id.tvWaktu);
            tvKuantitas = itemView.findViewById(R.id.tvKuantitas);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
        }
    }

}
