package com.kejaksaan.pemantauan.Pegawai.ui.laporan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.admin.ui.home.DetailLaporanActivity;
import com.kejaksaan.pemantauan.databinding.ItemLaporanBinding;
import com.tdn.data.persistensi.MyUser;
import com.tdn.domain.model.LaporanModel;

import java.util.ArrayList;
import java.util.List;

public class AdapterListLaporanPegawai extends RecyclerView.Adapter<AdapterListLaporanPegawai.MyViewHolder> {
    private List<LaporanModel> data = new ArrayList<>();
    private Context context;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLaporanBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_laporan, parent, false);
        context = parent.getContext();
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.tvNama.setText(data.get(position).getNamaLengkap());
        holder.binding.tvKetnrp.setText("NRP : " + data.get(position).getNrp() + "\nKet : " + data.get(position).getDeskripsi() + "\nKODE : " + data.get(position).getKodeLaporan());
        holder.binding.tvTanggal.setText(data.get(position).created_at_to_date());
        holder.binding.btnDetail.setOnClickListener(v -> {
            MyUser.getInstance(context).setKeyLastLaporan(data.get(position));
            context.startActivity(new Intent(context, DetailLaporanPegawaiActivity.class));
        });
    }

    public void setdata(List<LaporanModel> namaList) {
        if (this.data == null) {
            this.data = namaList;
        } else {
            this.data.clear();
            this.data.addAll(namaList);
        }
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemLaporanBinding binding;

        public MyViewHolder(@NonNull ItemLaporanBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
