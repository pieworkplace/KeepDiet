package com.keepdiet.android.keepdiet;


import android.content.Intent;
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

import static android.app.Activity.RESULT_OK;
import static com.keepdiet.android.keepdiet.MainActivity.DIARY;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiaryFoodFragment extends Fragment {


    public static final int REQUEST_ADD_BREAKFAST = 11;
    public static final int REQUEST_ADD_LUNCH = 12;
    public static final int REQUEST_ADD_DINNER = 13;
    public static final int REQUEST_ADD_SNACKS = 14;

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

    private void setMealView(LinearLayout linearLayout, final int diary_food_, int diary_add_food, List<Food> mealList) {
        View mealView = getLayoutInflater().inflate(R.layout.diary_tag, null);
        ((TextView) mealView.findViewById(R.id.diary_tag_title)).setText(getString(diary_food_));
        TextView addButton = ((TextView) mealView.findViewById(R.id.diary_add_button));
        addButton.setText(getString(diary_add_food));
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int requestCode = 0;
                switch (diary_food_){
                    case R.string.diary_food_breakfast:
                        requestCode = REQUEST_ADD_BREAKFAST;
                        break;
                    case R.string.diary_food_lunch:
                        requestCode = REQUEST_ADD_LUNCH;
                        break;
                    case R.string.diary_food_dinner:
                        requestCode = REQUEST_ADD_DINNER;
                        break;
                    case R.string.diary_food_snacks:
                        requestCode = REQUEST_ADD_SNACKS;
                }
                startActivityForResult(new Intent(getActivity(), AddFoodActivity.class), requestCode);
            }
        });

        LinearLayout contentView = mealView.findViewById(R.id.diary_tag_content);
        for (Food food : mealList) {
            setContentView(food, contentView);
        }
        linearLayout.addView(mealView);
    }

    private void setContentView(Food food, LinearLayout contentView) {
        View contentItem = getLayoutInflater().inflate(R.layout.diary_content, null);
        ((TextView) contentItem.findViewById(R.id.diary_content_title)).setText(food.getFoodTitle());
        ((TextView) contentItem.findViewById(R.id.diary_content_value)).setText(Double.toString(food.getCaloryPerUnit() * food.getUnitNumber()));
        ((TextView) contentItem.findViewById(R.id.diary_content_amount)).setText(Double.toString(food.getUnitNumber()) + food.getUnitName());
        contentView.addView(contentItem);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Food food = (Food) data.getSerializableExtra("Food");
            User user = ((MainActivity)getActivity()).getUser();
            switch (requestCode){
                case REQUEST_ADD_BREAKFAST:
                    user.addBreakfastList(food);
                    break;
                case REQUEST_ADD_LUNCH:
                    user.addLunchList(food);
                    break;
                case REQUEST_ADD_DINNER:
                    user.addDinnerList(food);
                    break;
                case REQUEST_ADD_SNACKS:
                    user.addSnackList(food);
                    break;
            }
            Fragment diaryFragment = getFragmentManager().findFragmentByTag(DIARY);
            getFragmentManager().beginTransaction().detach(diaryFragment).attach(diaryFragment).commit();
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }
}
