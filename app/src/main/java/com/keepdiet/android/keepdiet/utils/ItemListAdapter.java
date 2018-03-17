package com.keepdiet.android.keepdiet.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.keepdiet.android.keepdiet.R;
import com.keepdiet.android.keepdiet.userData.Exercise;
import com.keepdiet.android.keepdiet.userData.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu Junlin on 2018/3/16.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {

    private List<?> itemList = new ArrayList<>();

    public ItemListAdapter(List<?> itemList) {
        this.itemList = itemList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.diary_content, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (itemList.isEmpty()) {

        } else if (itemList.get(0) instanceof Food) {
            holder.title.setText(((Food) itemList.get(position)).getFoodTitle());
            holder.value.setText(Integer.toString(((Food) itemList.get(position)).getCaloryPerUnit()));
            holder.amount.setText(Double.toString(((Food) itemList.get(position)).getUnitNumber()) + " " + ((Food) itemList.get(position)).getUnitName());
        } else {
            holder.title.setText(((Exercise) itemList.get(position)).getExerciseTitle());
            holder.value.setText(Integer.toString(((Exercise) itemList.get(position)).getCaloryPerUnit()));
            holder.amount.setText(Double.toString(((Exercise) itemList.get(position)).getUnitNumber()) + " " + ((Exercise) itemList.get(position)).getUnitName());
        }
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

//    private List<?> itemList = new ArrayList<>();
//    private Context context;
//
//    public ItemListAdapter(Context context, List<?> itemList) {
//        this.itemList = itemList;
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        return itemList.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return itemList.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        if (view == null) {
//            view = ((LayoutInflater) (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))).inflate(R.layout.diary_content, null);
//        }
//        if (itemList.isEmpty()){
//
//        }else if (itemList.get(0) instanceof Food){
//            ((TextView) view.findViewById(R.id.diary_content_title)).setText(((Food)itemList.get(i)).getFoodTitle());
//            ((TextView) view.findViewById(R.id.diary_content_value)).setText(Integer.toString(((Food)itemList.get(i)).getCaloryPerUnit()));
//            ((TextView) view.findViewById(R.id.diary_content_amount)).setText(Double.toString(((Food)itemList.get(i)).getUnitNumber()) + " " + ((Food)itemList.get(i)).getUnitName());
//        }else{
//            ((TextView) view.findViewById(R.id.diary_content_title)).setText(((Exercise)itemList.get(i)).getExerciseTitle());
//            ((TextView) view.findViewById(R.id.diary_content_value)).setText(Integer.toString(((Exercise)itemList.get(i)).getCaloryPerUnit()));
//            ((TextView) view.findViewById(R.id.diary_content_amount)).setText(Double.toString(((Exercise)itemList.get(i)).getUnitNumber()) + " " + ((Exercise)itemList.get(i)).getUnitName());
//        }
//       return view;
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView value;
        TextView amount;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.diary_content_title);
            value = itemView.findViewById(R.id.diary_content_value);
            amount = itemView.findViewById(R.id.diary_content_amount);
        }
    }
}
