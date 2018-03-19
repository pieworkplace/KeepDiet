package com.keepdiet.android.keepdiet;

import android.app.DatePickerDialog;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.DatePicker;

import com.keepdiet.android.keepdiet.userData.Group;
import com.keepdiet.android.keepdiet.userData.Target;
import com.keepdiet.android.keepdiet.userData.User;
import com.keepdiet.android.keepdiet.utils.BottomNavigationViewHelper;

import java.util.ArrayList;
import java.util.Arrays;

import com.keepdiet.android.keepdiet.userData.Diary;
import com.keepdiet.android.keepdiet.utils.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity{

    public static final String DIARY = "diary";
    public static final String FEED = "feed";
    public static final String GROUP = "group";
    public static final String MORE = "more";

    public Target target1 = new Target("Eat less than 1700 Cal", false);
    public Target target2 = new Target("Jogging 5 miles", false);
    public Target target3 = new Target("30 push-ups", false);
    public Target target4 = new Target("Swimming 1 mile", false);
    public Target target5 = new Target("Walk 20000 steps", false);

    public User user = new User();
    public Group group;// = new Group(5, 0001, "KeepDiet", new ArrayList<Integer>(Arrays.asList(1001, 1002, 1003)), "Atlanta", "Lose Weight");

    public Diary diary = new Diary();

    //    public Group group1 = new Group(5, 0001, "KeepDiet", new ArrayList<Integer>(Arrays.asList(1001, 1002, 1003)), "Atlanta", "Lose Weight");
//    public Group group2 = new Group(3, 0002, "DietKeep", new ArrayList<Integer>(Arrays.asList(1011, 1012, 1013)), "Atlanta", "Build Muscle");
//    public User user1 = new User();
//    public User user2 = new User();
    //disable back button2
    @Override
    public void onBackPressed(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //disable bottom navigation view shifting mode
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


        //add fragments
        addFragments();

        //set bottom bar listener
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

    public Diary getDiary() {
        return diary;
    }

}
