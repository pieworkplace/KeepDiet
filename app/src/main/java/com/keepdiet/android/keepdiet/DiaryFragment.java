package com.keepdiet.android.keepdiet;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiaryFragment extends Fragment {


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

    private class DiaryPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }
    }
}
