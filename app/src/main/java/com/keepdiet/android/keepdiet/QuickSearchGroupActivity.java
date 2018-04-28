package com.keepdiet.android.keepdiet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.keepdiet.android.keepdiet.userData.Group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSearchGroupActivity extends AppCompatActivity {

    public Group group1 = new Group();
    public Group group2 = new Group();
    List<Group> groupList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_search);
        Toolbar toolbar = findViewById(R.id.toolbar_search_group);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ListView groupListView = (ListView) findViewById((R.id.group_list_view));

        group1.setName("MuscleGain");
        groupList.add(group1);
        groupList.add(group2);

        ListView listView = findViewById(R.id.search_group_result);
        listView.setAdapter(new GroupListAdapter(groupList));

    }

    public class GroupListAdapter extends BaseAdapter {

        List<Group> myGroups;

        GroupListAdapter(List<Group> groupList){
            myGroups = groupList;
        }
        @Override
        public int getCount() {
            return myGroups.size();
        }

        @Override
        public Object getItem(int position) {
            return myGroups.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (layoutInflater != null) {
                view = layoutInflater.inflate(R.layout.find_group_result, null);
            }

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(QuickSearchGroupActivity.this, GroupInformationActivity.class);
                    intent.putExtra("Group", groupList.get(position));
                    intent.putExtra("joinOrDelete", "join");
                    startActivity(intent);
                }
            });

            TextView groupNameTextView = view.findViewById((R.id.group_name));
            TextView groupTargetTextView = view.findViewById((R.id.group_detail));

            groupNameTextView.setText(myGroups.get(position).getName());
            groupTargetTextView.setText(myGroups.get(position).getGroupGoal().toString());

            return view;
        }
    }
}
