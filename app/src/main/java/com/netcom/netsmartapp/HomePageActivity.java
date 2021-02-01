package com.netcom.netsmartapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.netcom.netsmartapp.homePageFragments.analytics_fragment;
import com.netcom.netsmartapp.homePageFragments.bookmarks_fragment;
import com.netcom.netsmartapp.homePageFragments.home_fragment;
import com.netcom.netsmartapp.homePageFragments.profile_fragment;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation_tab);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new home_fragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment=null;

            switch (item.getItemId())
            {
                case R.id.home_tab:
                    selectedFragment =new home_fragment();
                    break;
                case R.id.analytics_tab:
                    selectedFragment =new analytics_fragment();
                    break;
                case R.id.bookmarks_tab:
                    selectedFragment =new bookmarks_fragment();
                    break;
                case R.id.person_tab:
                    selectedFragment =new profile_fragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };
}