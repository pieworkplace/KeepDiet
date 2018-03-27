package com.keepdiet.android.keepdiet.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.keepdiet.android.keepdiet.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Liu Junlin on 2018/3/26.
 */

public class GroupInformationAdapter extends RecyclerView.Adapter<GroupInformationAdapter.GroupInformationViewHolder> {
    List<List<String>> info;

    public GroupInformationAdapter(List<List<String>> groupInfo) {
        info = groupInfo;
    }

    @Override
    public GroupInformationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_information_tag, parent,false);
        return new GroupInformationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GroupInformationViewHolder holder, int position) {
        holder.groupItem.setText(info.get(position).get(1));
        holder.groupItemTitle.setText(info.get(position).get(0));
    }

    @Override
    public int getItemCount() {
        return info == null ? 0 : info.size();
    }

    class GroupInformationViewHolder extends RecyclerView.ViewHolder {
        TextView groupItem;
        TextView groupItemTitle;
        GroupInformationViewHolder(View itemView) {
            super(itemView);
            groupItem = itemView.findViewById(R.id.group_item);
            groupItemTitle = itemView.findViewById(R.id.group_item_title);
        }
    }
}
