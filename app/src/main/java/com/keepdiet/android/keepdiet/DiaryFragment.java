package com.keepdiet.android.keepdiet;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiaryFragment extends Fragment {


    private DiaryFoodFragment foodView = null;
    private DiaryExerciseFragment exerciseView = null;
    private DiaryIndexFragment indexView = null;

    public DiaryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diary, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //set view pager and its tabs
        ViewPager viewPager = view.findViewById(R.id.diary_viewpager);
        viewPager.setAdapter(new DiaryPagerAdapter(getFragmentManager()));
        TabLayout tabLayout = view.findViewById(R.id.diary_table_layout);
        tabLayout.setupWithViewPager(viewPager);
        //create pages in view pager
        foodView = new DiaryFoodFragment();
        exerciseView = new DiaryExerciseFragment();
        indexView = new DiaryIndexFragment();
        //set data of the target only
        setData(view);
    }

    private void setData(View view) {
        int target = 2000;
        ((TextView) view.findViewById(R.id.diary_target_number)).setText(String.format("%,d",target));
        int food = 800;
        ((TextView) view.findViewById(R.id.diary_food_number)).setText(String.format("%,d", food));
        int exercise = 500;
        ((TextView) view.findViewById(R.id.diary_exercise_number)).setText(String.format("%,d", exercise));
        int remain = target - food + exercise;
        ((TextView) view.findViewById(R.id.diary_remain_number)).setText(String.format("%,d", remain));
    }

    private class DiaryPagerAdapter extends FragmentPagerAdapter {

        public DiaryPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return foodView;
                case 1:
                    return exerciseView;
                case 2:
                    return indexView;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return getString(R.string.diary_viewpager_food);
                case 1:
                    return getString(R.string.diary_viewpager_exercise);
                case 2:
                    return getString(R.string.diary_viewpager_index);
            }
            return null;
        }
    }
}
