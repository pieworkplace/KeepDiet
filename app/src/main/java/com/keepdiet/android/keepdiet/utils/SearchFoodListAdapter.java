package com.keepdiet.android.keepdiet.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.keepdiet.android.keepdiet.AddFoodActivity;
import com.keepdiet.android.keepdiet.EditFoodActivity;
import com.keepdiet.android.keepdiet.R;
import com.keepdiet.android.keepdiet.SearchFoodActivity;
import com.keepdiet.android.keepdiet.userData.Food;

import java.util.ArrayList;
import java.util.List;

import static com.keepdiet.android.keepdiet.SearchFoodActivity.CREATE_FOOD_IN_SEARCH;

/**
 * Created by Liu Junlin on 2018/3/16.
 */

public class SearchFoodListAdapter extends BaseAdapter{
    private List<Food> foodList = new ArrayList<>();
    private Context context;

    public SearchFoodListAdapter(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = ((LayoutInflater)(context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))).inflate(R.layout.diary_content, null);
        }
        ((TextView) view.findViewById(R.id.diary_content_title)).setText(foodList.get(i).getFoodTitle());
        ((TextView) view.findViewById(R.id.diary_content_value)).setText(Integer.toString(foodList.get(i).getCaloryPerUnit()));
        ((TextView) view.findViewById(R.id.diary_content_amount)).setText(Double.toString(foodList.get(i).getUnitNumber()) + " " + foodList.get(i).getUnitName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddFoodActivity.class);
                intent.putExtra("Food", foodList.get(i));
                ((SearchFoodActivity)context).startActivityForResult(intent, CREATE_FOOD_IN_SEARCH);
            }
        });
        return view;
    }
}
