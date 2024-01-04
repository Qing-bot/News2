package com.example.news2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigation;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    private Fragment homeFragment = new HomeFragment();
    private Fragment profileFragment = new ProfileFragment();
    private Fragment activeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navigation = findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, profileFragment)
                .hide(profileFragment)
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, homeFragment)
                .commit();

        activeFragment = homeFragment;


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_menu_home:
                fragmentManager.beginTransaction()
                        .hide(activeFragment)
                        .show(homeFragment)
                        .commit();
                activeFragment = homeFragment;
                return true;

            case R.id.nav_menu_profile:
                fragmentManager.beginTransaction()
                        .hide(activeFragment)
                        .show(profileFragment)
                        .commit();
                activeFragment = profileFragment;

        }

        return false;

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}