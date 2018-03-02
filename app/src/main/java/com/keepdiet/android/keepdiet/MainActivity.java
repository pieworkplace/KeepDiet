package com.keepdiet.android.keepdiet;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.keepdiet.android.keepdiet.utils.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //forbid bottom navigation view shifting mode
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        addDiaryFragment();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_navigation_bar_item_diary:
                    case R.id.bottom_navigation_bar_item_feed:
                    case R.id.bottom_navigation_bar_item_group:
                    case R.id.bottom_navigation_bar_item_more:
                }
                return true;
            }
        });
    }

    private void addDiaryFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        DiaryFragment diaryFragment = new DiaryFragment();
        transaction.add(R.id.diary_fragment_layout, diaryFragment);
        transaction.commit();
    }
}
