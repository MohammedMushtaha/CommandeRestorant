package com.example.commanderestorant.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.commanderestorant.R;
import com.example.commanderestorant.interfaces.ItemClickLisener;
import com.example.commanderestorant.pojo.LiveOrderModel;

import java.util.ArrayList;
import java.util.List;

public class AdapterLiveOrder extends RecyclerView.Adapter<AdapterLiveOrder.PostViewHolder> {
    private List<LiveOrderModel> dataWorks = new ArrayList<>();
    private RecyclerView.RecycledViewPool viewPool2 = new RecyclerView.RecycledViewPool();

    Activity activity;

    public AdapterLiveOrder(Activity activity, List<LiveOrderModel> dataWorks) {
        this.dataWorks = dataWorks;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_live_order, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        final LiveOrderModel liveOrderModel = dataWorks.get(position);

        holder.txtId.setText(liveOrderModel.getId());
        holder.txtItem.setText(liveOrderModel.getName());
        holder.txtRider.setText(liveOrderModel.getAssigned());
        holder.txtTimer.setText(liveOrderModel.getTimer());

        holder.setItemClickListener(new ItemClickLisener() {
            @Override
            public void onClick(View view, int Position, boolean isLongClick) {

            }
        });
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(
                holder.resyclerMeals.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );



    }

    @Override
    public int getItemCount() {
        return dataWorks.size();
    }

    public void setList(Activity activity, List<LiveOrderModel> moviesList) {
        this.dataWorks = moviesList;
        this.activity = activity;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
        private TextView txtId ,txtItem, txtRider, txtTimer;
        private RecyclerView resyclerMeals;
        private ItemClickLisener itemClickLisener;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            txtId = itemView.findViewById(R.id.txtId);
            txtItem = itemView.findViewById(R.id.txtItem);
            txtRider = itemView.findViewById(R.id.txtRider);
            txtTimer = itemView.findViewById(R.id.txtTimer);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListener(ItemClickLisener itemClickLicener) {
            this.itemClickLisener = itemClickLicener;
        }

        @Override
        public void onClick(View v) {
            itemClickLisener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickLisener.onClick(v, getAdapterPosition(), true);
            return true;
        }
    }
}
