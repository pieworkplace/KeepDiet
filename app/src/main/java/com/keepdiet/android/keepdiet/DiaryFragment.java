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

import com.keepdiet.android.keepdiet.userData.Exercise;
import com.keepdiet.android.keepdiet.userData.Food;
import com.keepdiet.android.keepdiet.userData.User;

import java.util.List;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiaryFragment extends Fragment {

    public static final int REQUEST_ADD_BREAKFAST = 11;
    public static final int REQUEST_ADD_LUNCH = 12;
    public static final int REQUEST_ADD_DINNER = 13;
    public static final int REQUEST_ADD_SNACKS = 14;
    public static final int REQUEST_ADD_EXERCISE = 15;

    public DiaryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //get user data
        User user = ((MainActivity) getActivity()).getUser();

        //inflate itself (target table)
        View view = inflater.inflate(R.layout.fragment_diary, container, false);

        //set data of the target only
        setTargetData(view);

        //Inflate inner content
        LinearLayout linearLayout = view.findViewById(R.id.diary_content_fragment_layout);

        //draw 4 meals
        setItemView(linearLayout, R.string.diary_food_breakfast, R.string.diary_add_food, user.getBreakfastList());
        setItemView(linearLayout, R.string.diary_food_lunch, R.string.diary_add_food, user.getLunchList());
        setItemView(linearLayout, R.string.diary_food_dinner, R.string.diary_add_food, user.getDinnerList());
        setItemView(linearLayout, R.string.diary_food_snacks, R.string.diary_add_food, user.getSnackList());

        //draw exercise
        setItemView(linearLayout, R.string.diary_exercise, R.string.diary_create_exercise, user.getExerciseList());

        //draw index
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void setTargetData(View view) {
        User user = ((MainActivity) getActivity()).getUser();
        ((TextView) view.findViewById(R.id.diary_target_number)).setText(String.format("%,d",user.getCaloryGoal()));
        ((TextView) view.findViewById(R.id.diary_food_number)).setText(String.format("%,d", user.getCaloryConsumed()));
        ((TextView) view.findViewById(R.id.diary_exercise_number)).setText(String.format("%,d", user.getCaloryBurned()));
        ((TextView) view.findViewById(R.id.diary_remain_number)).setText(String.format("%,d", user.getCaloryRemaining()));
    }

    private void setItemView(LinearLayout linearLayout, final int diary_item, int diary_add_food, List<?> itemList) {
        final User user = ((MainActivity) getActivity()).getUser();
        final View itemView = getLayoutInflater().inflate(R.layout.diary_tag, null);
        ((TextView) itemView.findViewById(R.id.diary_tag_title)).setText(getString(diary_item));
        TextView addButton = itemView.findViewById(R.id.diary_add_button);
        addButton.setText(getString(diary_add_food));
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int requestCode = 0;
                switch (diary_item){
                    case R.string.diary_food_breakfast:
                        requestCode = REQUEST_ADD_BREAKFAST;
                        ((TextView) itemView.findViewById(R.id.diary_tag_value)).setText(Integer.toString(user.getBreakfastTotalCalory()));
//                        startActivityForResult(new Intent(getActivity(), AddFoodActivity.class), requestCode);
                        startActivity(new Intent(getActivity(), SearchFoodActivity.class));
                        break;
                    case R.string.diary_food_lunch:
                        requestCode = REQUEST_ADD_LUNCH;
                        ((TextView) itemView.findViewById(R.id.diary_tag_value)).setText(Integer.toString(user.getLunchTotalCalory()));
                        startActivityForResult(new Intent(getActivity(), AddFoodActivity.class), requestCode);
                        break;
                    case R.string.diary_food_dinner:
                        requestCode = REQUEST_ADD_DINNER;
                        ((TextView) itemView.findViewById(R.id.diary_tag_value)).setText(Integer.toString(user.getDinnerTotalCalory()));
                        startActivityForResult(new Intent(getActivity(), AddFoodActivity.class), requestCode);
                        break;
                    case R.string.diary_food_snacks:
                        requestCode = REQUEST_ADD_SNACKS;
                        ((TextView) itemView.findViewById(R.id.diary_tag_value)).setText(Integer.toString(user.getSnackTotalCalory()));
                        startActivityForResult(new Intent(getActivity(), AddFoodActivity.class), requestCode);
                        break;
                    case R.string.diary_exercise:
                        requestCode = REQUEST_ADD_EXERCISE;
                        ((TextView) itemView.findViewById(R.id.diary_tag_value)).setText(Integer.toString(user.getExerciseTotalCalory()));
                        startActivityForResult(new Intent(getActivity(), AddExerciseActivity.class), requestCode);
                }

            }
        });

        LinearLayout contentView = itemView.findViewById(R.id.diary_tag_content);
        for (Object item : itemList) {
            setContentView(item, contentView);
        }
        switch (diary_item){
            case R.string.diary_food_breakfast:
                ((TextView) itemView.findViewById(R.id.diary_tag_value)).setText(Integer.toString(user.getBreakfastTotalCalory()));
                break;
            case R.string.diary_food_lunch:
                ((TextView) itemView.findViewById(R.id.diary_tag_value)).setText(Integer.toString(user.getLunchTotalCalory()));
                break;
            case R.string.diary_food_dinner:
                ((TextView) itemView.findViewById(R.id.diary_tag_value)).setText(Integer.toString(user.getDinnerTotalCalory()));
                break;
            case R.string.diary_food_snacks:
                ((TextView) itemView.findViewById(R.id.diary_tag_value)).setText(Integer.toString(user.getSnackTotalCalory()));
                break;
            case R.string.diary_exercise:
                ((TextView) itemView.findViewById(R.id.diary_tag_value)).setText(Integer.toString(user.getExerciseTotalCalory()));
                break;
        }
        linearLayout.addView(itemView);
    }

    private void setContentView(Object item, LinearLayout contentView) {
        View contentItem = getLayoutInflater().inflate(R.layout.diary_content, null);
        if (item instanceof Food){
            Food food = (Food) item;
            ((TextView) contentItem.findViewById(R.id.diary_content_title)).setText(food.getFoodTitle());
            ((TextView) contentItem.findViewById(R.id.diary_content_value)).setText(Integer.toString(food.getTotalCalory()));
            ((TextView) contentItem.findViewById(R.id.diary_content_amount)).setText(Double.toString(food.getUnitNumber()) + " " + food.getUnitName());
        }
        else if (item instanceof Exercise){
            Exercise exercise = (Exercise) item;
            ((TextView) contentItem.findViewById(R.id.diary_content_title)).setText(exercise.getExerciseTitle());
            ((TextView) contentItem.findViewById(R.id.diary_content_value)).setText(Integer.toString(exercise.getCaloryBurned()));
            ((TextView) contentItem.findViewById(R.id.diary_content_amount)).setText(Double.toString(exercise.getUnitNumber()) + " " + exercise.getUnitName());
        }
        contentView.addView(contentItem);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            User user = ((MainActivity)getActivity()).getUser();
            switch (requestCode){
                case REQUEST_ADD_BREAKFAST:
                    user.addBreakfastList((Food) data.getSerializableExtra("Food"));
                    break;
                case REQUEST_ADD_LUNCH:
                    user.addLunchList((Food) data.getSerializableExtra("Food"));
                    break;
                case REQUEST_ADD_DINNER:
                    user.addDinnerList((Food) data.getSerializableExtra("Food"));
                    break;
                case REQUEST_ADD_SNACKS:
                    user.addSnackList((Food) data.getSerializableExtra("Food"));
                    break;
                case REQUEST_ADD_EXERCISE:
                    user.addExerciseList((Exercise) data.getSerializableExtra("Exercise"));
            }
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }

}
