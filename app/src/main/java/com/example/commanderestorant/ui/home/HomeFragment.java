package com.example.commanderestorant.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.commanderestorant.R;
import com.example.commanderestorant.pojo.CategoryMainModel;
import com.example.commanderestorant.databinding.FragmentHomeBinding;
import com.example.commanderestorant.pojo.FeaturedDataModel;
import com.example.commanderestorant.ui.home.Adapter.CategoryAdapter;
import com.example.commanderestorant.ui.home.Adapter.FeaturedAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    CategoryAdapter categoryAdapter;
    FeaturedAdapter featuredAdapter;
    private List<CategoryMainModel> categoryMains = new ArrayList<>();
    private List<FeaturedDataModel> featuredDataModels = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        categoryMains.add(new CategoryMainModel(1, "Restorent"));
        categoryMains.add(new CategoryMainModel(1, "Restorent"));
        categoryMains.add(new CategoryMainModel(1, "Restorent"));
        categoryMains.add(new CategoryMainModel(1, "Restorent"));
        categoryAdapter = new CategoryAdapter(getActivity(), categoryMains);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerCategory.setLayoutManager(linearLayoutManager);
        binding.recyclerCategory.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerCategory.setAdapter(categoryAdapter);


        featuredDataModels.add(new FeaturedDataModel(R.drawable.image_food2, "1.92 km", 5, "Kintaki Restaurent"));
        featuredDataModels.add(new FeaturedDataModel(R.drawable.image_food, "1.92 km", 3, "Kintaki Restaurent"));
        featuredDataModels.add(new FeaturedDataModel(R.drawable.image_food2, "1.92 km", 2, "Kintaki Restaurent"));
        featuredDataModels.add(new FeaturedDataModel(R.drawable.image_food2, "1.92 km", 1, "Kintaki Restaurent"));
        featuredAdapter = new FeaturedAdapter(getActivity(), featuredDataModels);


        LinearLayoutManager linearLayoutManagerFeatured = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerFeaturedA.setLayoutManager(linearLayoutManagerFeatured);
        binding.recyclerFeaturedA.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerFeaturedA.setAdapter(featuredAdapter);

        LinearLayoutManager linearLayoutManagerBest = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        binding.recyclerBest.setLayoutManager(linearLayoutManagerBest);
        binding.recyclerBest.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerBest.setAdapter(featuredAdapter);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}