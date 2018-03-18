package com.keepdiet.android.keepdiet;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.keepdiet.android.keepdiet.userData.Diary;
import com.keepdiet.android.keepdiet.userData.Exercise;
import com.keepdiet.android.keepdiet.userData.Food;
import com.keepdiet.android.keepdiet.utils.ItemListAdapter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static com.keepdiet.android.keepdiet.EditExerciseActivity.DELETE_RESULT_OK;
import static com.keepdiet.android.keepdiet.EditFoodActivity.EDIT_RESULT_OK;


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

        //get diary data
        Diary diary = ((MainActivity) getActivity()).getDiary();

        //inflate target table
        View view = inflater.inflate(R.layout.fragment_diary, container, false);

        //set data of the target only
        setTargetData(view);

        //set lists
        setListData(view, R.id.diary_breakfast_header, R.id.diary_breakfast_footer, R.id.diary_breakfast, diary.getBreakfastList(), diary.getBreakfastTotalCalory(), R.string.diary_food_breakfast, R.string.diary_add_food);
        setListData(view, R.id.diary_lunch_header, R.id.diary_lunch_footer, R.id.diary_lunch, diary.getLunchList(), diary.getLunchTotalCalory(), R.string.diary_food_lunch, R.string.diary_add_food);
        setListData(view, R.id.diary_dinner_header, R.id.diary_dinner_footer, R.id.diary_dinner, diary.getDinnerList(), diary.getDinnerTotalCalory(), R.string.diary_food_dinner, R.string.diary_add_food);
        setListData(view, R.id.diary_snack_header, R.id.diary_snack_footer, R.id.diary_snack, diary.getSnackList(), diary.getSnackTotalCalory(), R.string.diary_food_snacks, R.string.diary_add_food);
        setListData(view, R.id.diary_exercise_header, R.id.diary_exercise_footer, R.id.diary_exercise, diary.getExerciseList(), diary.getExerciseTotalCalory(), R.string.diary_exercise, R.string.diary_add_exercise);

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //set toolbar
        LocalDate localDate = ((MainActivity) getActivity()).getDiary().getDate();
        String dateText = localDate.toString();
        final TextView toolbarText = ((TextView) (view.findViewById(R.id.diary_fragment_toolbar_text)));
        toolbarText.setText(dateText);
        toolbarText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocalDate currentDate = ((MainActivity) getActivity()).getDiary().getDate();
                Dialog dialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        //TODO change this later
                        ((MainActivity) getActivity()).getDiary().setDate((new Date(i - 1900, i1, i2).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
                        String dateText = ((MainActivity) getActivity()).getDiary().getDate().toString();
                        toolbarText.setText(dateText);
                    }
                }, currentDate.getYear(), currentDate.getMonthValue() - 1, currentDate.getDayOfMonth());
                dialog.show();
            }
        });

    }

    private void setTargetData(View view) {
        Diary diary = ((MainActivity) getActivity()).getDiary();
        ((TextView) view.findViewById(R.id.diary_target_number)).setText(String.format("%,d", diary.getCaloryGoal()));
        ((TextView) view.findViewById(R.id.diary_food_number)).setText(String.format("%,d", diary.getCaloryConsumed()));
        ((TextView) view.findViewById(R.id.diary_exercise_number)).setText(String.format("%,d", diary.getCaloryBurned()));
        ((TextView) view.findViewById(R.id.diary_remain_number)).setText(String.format("%,d", diary.getCaloryRemaining()));
    }

    private void setListData(View view, int R_id_header, int R_id_footer, int R_id_item, final List<?> itemList, int totalCalory, final int R_string_item, int R_string_add_item) {
        //get diary data
        Diary diary = ((MainActivity) getActivity()).getDiary();

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
        ItemListAdapter itemListAdapter = new ItemListAdapter(new ArrayList<Object>(itemList));
        itemListAdapter.setOnItemClickListner(new ItemListAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int position) {
                Intent intent;
                switch (R_string_item) {
                    case R.string.diary_food_breakfast:
                        intent = new Intent(getActivity(), EditFoodActivity.class);
                        intent.putExtra("position", position);
                        intent.putExtra("Food", (Food) itemList.get(position));
                        startActivityForResult(intent, REQUEST_ADD_BREAKFAST);
                        break;
                    case R.string.diary_food_lunch:
                        intent = new Intent(getActivity(), EditFoodActivity.class);
                        intent.putExtra("position", position);
                        intent.putExtra("Food", (Food) itemList.get(position));
                        startActivityForResult(intent, REQUEST_ADD_LUNCH);
                        break;
                    case R.string.diary_food_dinner:
                        intent = new Intent(getActivity(), EditFoodActivity.class);
                        intent.putExtra("position", position);
                        intent.putExtra("Food", (Food) itemList.get(position));
                        startActivityForResult(intent, REQUEST_ADD_DINNER);
                        break;
                    case R.string.diary_food_snacks:
                        intent = new Intent(getActivity(), EditFoodActivity.class);
                        intent.putExtra("position", position);
                        intent.putExtra("Food", (Food) itemList.get(position));
                        startActivityForResult(intent, REQUEST_ADD_SNACKS);
                        break;
                    case R.string.diary_exercise:
                        intent = new Intent(getActivity(), EditExerciseActivity.class);
                        intent.putExtra("position", position);
                        intent.putExtra("Exercise", (Exercise) itemList.get(position));
                        startActivityForResult(intent, REQUEST_ADD_EXERCISE);
                        break;
                }
            }
        });
        listViewItem.setAdapter(itemListAdapter);


        //set footer (add button)
        footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (R_string_item) {
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
        Diary diary = ((MainActivity) getActivity()).getDiary();
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_ADD_BREAKFAST:
                    diary.addBreakfastList((Food) data.getSerializableExtra("Food"));
                    break;
                case REQUEST_ADD_LUNCH:
                    diary.addLunchList((Food) data.getSerializableExtra("Food"));
                    break;
                case REQUEST_ADD_DINNER:
                    diary.addDinnerList((Food) data.getSerializableExtra("Food"));
                    break;
                case REQUEST_ADD_SNACKS:
                    diary.addSnackList((Food) data.getSerializableExtra("Food"));
                    break;
                case REQUEST_ADD_EXERCISE:
                    diary.addExerciseList((Exercise) data.getSerializableExtra("Exercise"));
                    break;
            }
        } else if (resultCode == EDIT_RESULT_OK) {
            int position = data.getIntExtra("position", -1);
            switch (requestCode) {
                case REQUEST_ADD_BREAKFAST:
                    diary.editBreakfastList(position, (Food) data.getSerializableExtra("Food"));
                    break;
                case REQUEST_ADD_LUNCH:
                    diary.editLunchList(position, (Food) data.getSerializableExtra("Food"));
                    break;
                case REQUEST_ADD_DINNER:
                    diary.editDinnerList(position, (Food) data.getSerializableExtra("Food"));
                    break;
                case REQUEST_ADD_SNACKS:
                    diary.editSnackList(position, (Food) data.getSerializableExtra("Food"));
                    break;
                case REQUEST_ADD_EXERCISE:
                    diary.editExerciseList(position, (Exercise) data.getSerializableExtra("Exercise"));
                    break;
            }
        } else if (resultCode == DELETE_RESULT_OK) {
            int position = data.getIntExtra("position", -1);
            switch (requestCode) {
                case REQUEST_ADD_BREAKFAST:
                    diary.removeBreakfastList(position);
                    break;
                case REQUEST_ADD_LUNCH:
                    diary.removeLunchList(position);
                    break;
                case REQUEST_ADD_DINNER:
                    diary.removeDinnerList(position);
                    break;
                case REQUEST_ADD_SNACKS:
                    diary.removeSnackList(position);
                    break;
                case REQUEST_ADD_EXERCISE:
                    diary.removeExerciseList(position);
                    break;
            }
        }
        getFragmentManager().beginTransaction().detach(this).attach(this).commit();
    }
}
