package com.keepdiet.android.keepdiet;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.keepdiet.android.keepdiet.userData.Exercise;
import com.keepdiet.android.keepdiet.userData.Food;
import com.keepdiet.android.keepdiet.userData.User;
import com.keepdiet.android.keepdiet.utils.ItemListAdapter;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //get user data
        User user = ((MainActivity) getActivity()).getUser();

        //inflate target table
        View view = inflater.inflate(R.layout.fragment_diary, container, false);

        //set data of the target only
        setTargetData(view);

        //set lists
        setListData(view, R.id.diary_breakfast_header, R.id.diary_breakfast_footer, R.id.diary_breakfast, user.getBreakfastList(), user.getBreakfastTotalCalory(), R.string.diary_food_breakfast, R.string.diary_add_food);
        setListData(view, R.id.diary_lunch_header, R.id.diary_lunch_footer, R.id.diary_lunch, user.getLunchList(), user.getLunchTotalCalory(), R.string.diary_food_lunch, R.string.diary_add_food);
        setListData(view, R.id.diary_dinner_header, R.id.diary_dinner_footer, R.id.diary_dinner, user.getDinnerList(), user.getDinnerTotalCalory(), R.string.diary_food_dinner, R.string.diary_add_food);
        setListData(view, R.id.diary_snack_header, R.id.diary_snack_footer, R.id.diary_snack, user.getSnackList(), user.getSnackTotalCalory(), R.string.diary_food_snacks, R.string.diary_add_food);
        setListData(view, R.id.diary_exercise_header, R.id.diary_exercise_footer, R.id.diary_exercise, user.getExerciseList(), user.getExerciseTotalCalory(), R.string.diary_exercise, R.string.diary_add_exercise);

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

    private void setListData(View view, int R_id_header, int R_id_footer, int R_id_item, List<?> itemList, int totalCalory, final int R_string_item, int R_string_add_item) {
        //get user data
        User user = ((MainActivity) getActivity()).getUser();

        View header = getLayoutInflater().inflate(R.layout.diary_tag_header, null);
        View footer = getLayoutInflater().inflate(R.layout.diary_tag_footer, null);
        ((TextView) header.findViewById(R.id.diary_tag_title)).setText(R_string_item);
        ((TextView) header.findViewById(R.id.diary_tag_value)).setText(Integer.toString(totalCalory));
        ((TextView) footer.findViewById(R.id.diary_add_button)).setText(R_string_add_item);
        ((FrameLayout) view.findViewById(R_id_header)).addView(header);
        ((FrameLayout) view.findViewById(R_id_footer)).addView(footer);

        RecyclerView listViewItem = view.findViewById(R_id_item);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        listViewItem.setLayoutManager(layoutManager);
        listViewItem.setAdapter(new ItemListAdapter(itemList));

        //set footer (add button)
        footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (R_string_item){
                    case R.string.diary_food_breakfast:
                        startActivityForResult(new Intent(getActivity(), SearchFoodActivity.class), REQUEST_ADD_BREAKFAST);
                        break;
                    case R.string.diary_food_lunch:
                        startActivityForResult(new Intent(getActivity(), SearchFoodActivity.class), REQUEST_ADD_LUNCH);
                        break;
                    case R.string.diary_food_dinner:
                        startActivityForResult(new Intent(getActivity(), SearchFoodActivity.class), REQUEST_ADD_DINNER);
                        break;
                    case R.string.diary_food_snacks:
                        startActivityForResult(new Intent(getActivity(), SearchFoodActivity.class), REQUEST_ADD_SNACKS);
                        break;
                    case R.string.diary_exercise:
                        startActivityForResult(new Intent(getActivity(), AddExerciseActivity.class), REQUEST_ADD_EXERCISE);
                        break;
                }
            }
        });

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
                    break;
            }
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }

}
