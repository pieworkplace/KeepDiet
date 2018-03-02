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

    public static final String DIARY = "diary";
    public static final String FEED = "feed";
    public static final String GROUP = "group";
    public static final String MORE = "more";

    //disable back button
    @Override
    public void onBackPressed(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //disable bottom navigation view shifting mode
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        addFragments();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                DiaryFragment diaryFragment = (DiaryFragment) fragmentManager.findFragmentByTag(DIARY);
                FeedFragment feedFragment = (FeedFragment) fragmentManager.findFragmentByTag(FEED);
                GroupFragment groupFragment = (GroupFragment) fragmentManager.findFragmentByTag(GROUP);
                MoreFragment moreFragment = (MoreFragment) fragmentManager.findFragmentByTag(MORE);
                transaction.hide(diaryFragment);
                transaction.hide(feedFragment);
                transaction.hide(groupFragment);
                transaction.hide(moreFragment);

                switch (item.getItemId()){
                    case R.id.bottom_navigation_bar_item_diary:
                        transaction.show(diaryFragment);
                        break;
                    case R.id.bottom_navigation_bar_item_feed:
                        transaction.show(feedFragment);
                        break;
                    case R.id.bottom_navigation_bar_item_group:
                        transaction.show(groupFragment);
                        break;
                    case R.id.bottom_navigation_bar_item_more:
                        transaction.show(moreFragment);
                }
                transaction.commit();
                return true;
            }
        });
    }

    private void addFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        DiaryFragment diaryFragment = new DiaryFragment();
        FeedFragment feedFragment = new FeedFragment();
        GroupFragment groupFragment = new GroupFragment();
        MoreFragment moreFragment = new MoreFragment();
        transaction.add(R.id.diary_fragment_layout, diaryFragment, DIARY);
        transaction.add(R.id.feed_fragment_layout, feedFragment, FEED);
        transaction.add(R.id.group_fragment_layout, groupFragment, GROUP);
        transaction.add(R.id.more_fragment_layout, moreFragment, MORE);
        transaction.hide(feedFragment);
        transaction.hide(groupFragment);
        transaction.hide(moreFragment);
        transaction.commit();
    }
}
