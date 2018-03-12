package com.keepdiet.android.keepdiet;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.keepdiet.android.keepdiet.userData.Food;
import com.keepdiet.android.keepdiet.userData.User;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiaryFoodFragment extends Fragment {


    public DiaryFoodFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //get user data
        User user = ((MainActivity) getActivity()).getUser();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diary_food, container, false);

        //Inflate food page structure and update data
        LinearLayout linearLayout = view.findViewById(R.id.diary_food_fragment_layout);

        //inflate 4 meals
        setMealView(linearLayout, R.string.diary_food_breakfast, R.string.diary_add_food, user.getBreakfastList());
        setMealView(linearLayout, R.string.diary_food_lunch, R.string.diary_add_food, user.getLunchList());
        setMealView(linearLayout, R.string.diary_food_dinner, R.string.diary_add_food, user.getDinnerList());
        setMealView(linearLayout, R.string.diary_food_snacks, R.string.diary_add_food, user.getSnackList());

        return view;
    }

    private void setMealView(LinearLayout linearLayout, int diary_food_, int diary_add_food, List<Food> mealList) {
        View mealView = getLayoutInflater().inflate(R.layout.diary_tag, null);
        ((TextView) mealView.findViewById(R.id.diary_tag_title)).setText(getString(diary_food_));
        ((TextView) mealView.findViewById(R.id.diary_add_button)).setText(getString(diary_add_food));
        LinearLayout contentView = mealView.findViewById(R.id.diary_tag_content);
        for (Food food : mealList) {
            setContentView(food, contentView);
        }
        linearLayout.addView(mealView);
    }

    private void setContentView(Food food, LinearLayout contentView) {
        View contentItem = getLayoutInflater().inflate(R.layout.diary_content, null);
        ((TextView) contentItem.findViewById(R.id.diary_content_title)).setText(food.getFoodTitle());
        ((TextView) contentItem.findViewById(R.id.diary_content_value)).setText(Integer.toString(food.getCaloryPerUnit() * food.getUnitNumber()));
        ((TextView) contentItem.findViewById(R.id.diary_content_amount)).setText(Integer.toString(food.getUnitNumber()) + food.getUnitName());
        contentView.addView(contentItem);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
