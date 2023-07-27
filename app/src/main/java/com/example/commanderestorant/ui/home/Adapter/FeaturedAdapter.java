package com.example.commanderestorant.ui.home.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.commanderestorant.R;
import com.example.commanderestorant.pojo.CategoryMainModel;
import com.example.commanderestorant.interfaces.ItemClickLisener;
import com.example.commanderestorant.pojo.FeaturedDataModel;

import java.util.List;


public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.MyViewHolder> {

    private List<FeaturedDataModel> featuredDataModels;
    private Activity activity;
    private ItemClickLisener itemClickLisener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
        public TextView restaurant_name ,rating_MaterialRatingBar ,location_km;
        public ImageView featuredImage;
        private ItemClickLisener itemClickLisener;

        public MyViewHolder(View view) {
            super(view);
            restaurant_name = view.findViewById(R.id.restaurant_name);
        //    rating_MaterialRatingBar = view.findViewById(R.id.rating_MaterialRatingBar);
            location_km = view.findViewById(R.id.location_km);
            featuredImage = view.findViewById(R.id.featuredImage);

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

    public FeaturedAdapter(Activity activity, List<FeaturedDataModel> featuredDataModels) {
        this.featuredDataModels =  featuredDataModels;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_featured, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final FeaturedDataModel categoryMainModel = featuredDataModels.get(position);

        holder.restaurant_name.setText(categoryMainModel.getName());
//        holder.rating_MaterialRatingBar.setText(categoryMainModel.getRating());
        holder.location_km.setText(categoryMainModel.getKm());
        holder.featuredImage.setImageResource(R.drawable.image_food);
       // holder.restaurant_name.setText(categoryMainModel.getName());

        holder.setItemClickListener(new ItemClickLisener() {
            @Override
            public void onClick(View view, int Position, boolean isLongClick) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return featuredDataModels.size();
    }
}