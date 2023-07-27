package com.example.commanderestorant.ui.home.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.example.commanderestorant.R;
import com.example.commanderestorant.pojo.CategoryMainModel;
import com.example.commanderestorant.interfaces.ItemClickLisener;

import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private List<CategoryMainModel> categoryMainModels;
    private Activity activity;
    private ItemClickLisener itemClickLisener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
        public Button nameCatrgory;
        private ItemClickLisener itemClickLisener;

        public MyViewHolder(View view) {
            super(view);
            nameCatrgory = view.findViewById(R.id.textCategory);

            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickLisener.onClick(v, getAdapterPosition(), false);

        }

        public void setItemClickListener(ItemClickLisener itemClickLicener) {
            this.itemClickLisener = itemClickLicener;
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickLisener.onClick(v, getAdapterPosition(), true);

            return true;
        }

    }

    public CategoryAdapter(Activity activity, List<CategoryMainModel> categoryMainModels) {
        this.categoryMainModels = categoryMainModels;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main_categoury, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final CategoryMainModel current_model = categoryMainModels.get(position);

        holder.nameCatrgory.setText(current_model.getName());

        holder.setItemClickListener(new ItemClickLisener() {
            @Override
            public void onClick(View view, int Position, boolean isLongClick) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryMainModels.size();
    }

}