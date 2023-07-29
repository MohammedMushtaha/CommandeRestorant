package com.example.commanderestorant.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.commanderestorant.MainNavigationActivity;
import com.example.commanderestorant.R;
import com.example.commanderestorant.SharedPreferanse.SharedPreferanse;
import com.example.commanderestorant.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel galleryViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferanse.write(SharedPreferanse.isShowToolBar,1);
                Intent intent =new Intent(getActivity(), MainNavigationActivity.class);
                startActivity(intent);
                getActivity().finish();


            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onDestroy() {
        SharedPreferanse.write(SharedPreferanse.isShowToolBar,1);
        Toast.makeText(getContext(), "3", Toast.LENGTH_SHORT).show();

        super.onDestroy();
    }

    @Override
    public void onDetach() {
        SharedPreferanse.write(SharedPreferanse.isShowToolBar,1);
        Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT).show();

        super.onDetach();
    }

    @Override
    public void onStop() {
        SharedPreferanse.write(SharedPreferanse.isShowToolBar,1);
        Toast.makeText(getContext(), "1", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

}