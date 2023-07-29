package com.example.commanderestorant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.commanderestorant.SharedPreferanse.SharedPreferanse;
import com.example.commanderestorant.auth.Login.LoginActivity;
import com.example.commanderestorant.ui.profile.ProfileFragment;
import com.example.commanderestorant.ui.home.HomeFragment;
import com.example.commanderestorant.ui.slideshow.SlideshowFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.appcompat.app.AppCompatActivity;

import com.example.commanderestorant.databinding.ActivityMainNavigationBinding;

import java.util.ArrayList;
import java.util.Arrays;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class MainNavigationActivity extends AppCompatActivity implements DuoMenuView.OnMenuClickListener {

    private AppBarConfiguration mAppBarConfiguration;
    ActivityMainNavigationBinding binding;

    private MenuAdapter mMenuAdapter;
    private ViewHolder mViewHolder;

    private ArrayList<String> mTitles = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        Toast.makeText(this, "E", Toast.LENGTH_SHORT).show();

        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "E", Toast.LENGTH_SHORT).show();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_navigation);

        mTitles = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.menuOptions)));

        ImageView button = findViewById(R.id.btn_menu);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewHolder.mDuoDrawerLayout.openDrawer();
            }
        });
        // Initialize the views
        mViewHolder = new ViewHolder();

        // Handle toolbar actions
        handleToolbar();

        // Handle menu actions
        handleMenu();

        // Handle drawer actions
        handleDrawer();

        // Show main fragment in container
        goToFragment(new HomeFragment(), false);


        // mMenuAdapter.setViewSelected(0, true);
        setTitle(mTitles.get(0));
        // mMenuAdapter.getItem()

    }


    private void handleToolbar() {
        setSupportActionBar(mViewHolder.mToolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }


    private void handleDrawer() {
        DuoDrawerToggle duoDrawerToggle = new DuoDrawerToggle(this,
                mViewHolder.mDuoDrawerLayout,
                mViewHolder.mToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        mViewHolder.mDuoDrawerLayout.setDrawerListener(duoDrawerToggle);
        duoDrawerToggle.syncState();

    }


    private void handleMenu() {

        mMenuAdapter = new MenuAdapter(mTitles);
        mViewHolder.mDuoMenuView.setOnMenuClickListener(this);
        mViewHolder.mDuoMenuView.setAdapter(mMenuAdapter);

    }

    @Override
    public void onFooterClicked() {
        Toast.makeText(this, "onFooterClicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openOptionsMenu() {
        super.openOptionsMenu();
    }

    @Override
    public void onHeaderClicked() {
        Toast.makeText(this, "onHeaderClicked", Toast.LENGTH_SHORT).show();
    }

    private void goToFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }

        transaction.replace(R.id.container, fragment).commit();
    }

    @Override
    public void onOptionClicked(int position, Object objectClicked) {
        // Set the toolbar title
        setTitle(mTitles.get(position));


        // Set the right options selected
        mMenuAdapter.setViewSelected(position, true);

        // Navigate to the right fragment
        switch (position) {
            case 0:


                break;

            case 1:
                //toolBarVisibility(0);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ProfileFragment()).addToBackStack(null).commit();

                break;

            case 2:

                Toast.makeText(this, "A" + position, Toast.LENGTH_SHORT).show();

                goToFragment(new SlideshowFragment(), false);
                break;

            case 3:

                Toast.makeText(this, "B" + position, Toast.LENGTH_SHORT).show();
                goToFragment(new ProfileFragment(), false);
                break;

            case 4:

                Toast.makeText(this, "C" + position, Toast.LENGTH_SHORT).show();
                goToFragment(new ProfileFragment(), false);
                break;

            default:

                Toast.makeText(this, "D" + position, Toast.LENGTH_SHORT).show();
                goToFragment(new ProfileFragment(), false);
                break;
        }

        // Close the drawer
        mViewHolder.mDuoDrawerLayout.closeDrawer();
    }

    private class ViewHolder {
        private DuoDrawerLayout mDuoDrawerLayout;
        private DuoMenuView mDuoMenuView;
        private Toolbar mToolbar;

        ViewHolder() {
            mDuoDrawerLayout = (DuoDrawerLayout) findViewById(R.id.drawer);
            mDuoMenuView = (DuoMenuView) mDuoDrawerLayout.getMenuView();
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
        }
    }

    public void toolBarVisibility(int isVisibility) {
        if (isVisibility == 1) {
            binding.toolbarCustom.setVisibility(View.VISIBLE);

        } else {
            binding.toolbarCustom.setVisibility(View.GONE);

        }

    }

    @Override
    protected void onResume() {
        Toast.makeText(this, "C", Toast.LENGTH_SHORT).show();

        super.onResume();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();

        super.onRestart();
    }

    @Override
    protected void onStart() {
        Toast.makeText(this, "A", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        Toast.makeText(this, "D", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
