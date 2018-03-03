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
        LinearLayout linearLayout = view.findViewById(R.id.diary_food_fragment_layout);
        for (int i = 0; i < 4; i++) {
            View smallView = getLayoutInflater().inflate(R.layout.diary_tag, null);
            ((TextView)smallView.findViewById(R.id.diary_add_button)).setText(R.string.diary_add_food);
            TextView title = smallView.findViewById(R.id.diary_tag_title);
            switch (i){
                case 0:
                    title.setText(R.string.diary_food_breakfast);
                    break;
                case 1:
                    title.setText(R.string.diary_food_lunch);
                    break;
                case 2:
                    title.setText(R.string.diary_food_dinner);
                    break;
                case 3:
                    title.setText(R.string.diary_food_snacks);
            }
            linearLayout.addView(smallView);
        }
        View buttonView = getLayoutInflater().inflate(R.layout.diary_tag_button, null);
        ((TextView) buttonView.findViewById(R.id.diary_add_button)).setText(R.string.diary_food_summary);
        linearLayout.addView(buttonView);
        buttonView = getLayoutInflater().inflate(R.layout.diary_tag_button, null);
        ((TextView) buttonView.findViewById(R.id.diary_add_button)).setText(R.string.diary_food_summary);
        linearLayout.addView(buttonView);
        buttonView = getLayoutInflater().inflate(R.layout.diary_tag_button, null);
        ((TextView) buttonView.findViewById(R.id.diary_add_button)).setText(R.string.diary_food_summary);
        linearLayout.addView(buttonView);
        buttonView = getLayoutInflater().inflate(R.layout.diary_tag_button, null);
        ((TextView) buttonView.findViewById(R.id.diary_add_button)).setText(R.string.diary_food_summary);
        linearLayout.addView(buttonView);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
