package com.keepdiet.android.keepdiet;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diary_food, container, false);

        //Inflate food page structure and update data
        LinearLayout linearLayout = view.findViewById(R.id.diary_food_fragment_layout);
        for (int i = 0; i < 4; i++) {
            View smallView = getLayoutInflater().inflate(R.layout.diary_tag, null);
            ((TextView)smallView.findViewById(R.id.diary_add_button)).setText(R.string.diary_add_food);
            TextView title = smallView.findViewById(R.id.diary_tag_title);
            TextView value = smallView.findViewById(R.id.diary_tag_value);
            LinearLayout content = smallView.findViewById(R.id.diary_tag_content);
            switch (i){
                //TODO change fake data
                case 0:
                    title.setText(R.string.diary_food_breakfast);
                    value.setText("300");
                    for (int j = 0; j < 2; j++){
                        View contentView = getLayoutInflater().inflate(R.layout.diary_content, null);
                        ((TextView) contentView.findViewById(R.id.diary_content_title)).setText("Fried Chicken");
                        ((TextView) contentView.findViewById(R.id.diary_content_value)).setText("200");
                        ((TextView) contentView.findViewById(R.id.diary_content_amount)).setText("1 pound");
                        content.addView(contentView);
                    }
                    break;
                case 1:
                    title.setText(R.string.diary_food_lunch);
                    value.setText("250");
                    for (int j = 0; j < 2; j++){
                        View contentView = getLayoutInflater().inflate(R.layout.diary_content, null);
                        ((TextView) contentView.findViewById(R.id.diary_content_title)).setText("Grand Big Mac");
                        ((TextView) contentView.findViewById(R.id.diary_content_value)).setText("200");
                        ((TextView) contentView.findViewById(R.id.diary_content_amount)).setText("1 serving");
                        content.addView(contentView);
                    }
                    break;
                case 2:
                    title.setText(R.string.diary_food_dinner);
                    value.setText("500");
                    for (int j = 0; j < 1; j++){
                        View contentView = getLayoutInflater().inflate(R.layout.diary_content, null);
                        ((TextView) contentView.findViewById(R.id.diary_content_title)).setText("Fried Chicken");
                        ((TextView) contentView.findViewById(R.id.diary_content_value)).setText("200");
                        ((TextView) contentView.findViewById(R.id.diary_content_amount)).setText("1 pound");
                        content.addView(contentView);
                    }
                    break;
                case 3:
                    title.setText(R.string.diary_food_snacks);
                    value.setText("50");
                    for (int j = 0; j < 4; j++){
                        View contentView = getLayoutInflater().inflate(R.layout.diary_content, null);
                        ((TextView) contentView.findViewById(R.id.diary_content_title)).setText("Fried Chicken");
                        ((TextView) contentView.findViewById(R.id.diary_content_value)).setText("200");
                        ((TextView) contentView.findViewById(R.id.diary_content_amount)).setText("1 pound");
                        content.addView(contentView);
                    }
            }
            linearLayout.addView(smallView);
        }
        View buttonView = getLayoutInflater().inflate(R.layout.diary_tag_button, null);
        ((TextView) buttonView.findViewById(R.id.diary_add_button)).setText(R.string.diary_food_summary);
        linearLayout.addView(buttonView);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
