package com.keepdiet.android.keepdiet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.keepdiet.android.keepdiet.userData.Group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindGroupResult extends Activity {

    public Group group1 = new Group(5, 0001, "KeepDiet", new ArrayList<Integer>(Arrays.asList(1001, 1002, 1003)), "Atlanta", "Lose Weight");
    public Group group2 = new Group(3, 0002, "DietKeep", new ArrayList<Integer>(Arrays.asList(1011, 1012, 1013)), "Atlanta", "Build Muscle");
    List<Group> groupList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_group_result);

        ListView groupListView = (ListView) findViewById((R.id.group_list_view));

        groupList.add(group1);
        groupList.add(group2);

        ListView listView = findViewById(R.id.group_list_view);
        listView.setAdapter(new GroupListAdapter(groupList));

//        findViewById(R.id.group).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(FindGroupResult.this, GroupInformation.class
//                ));
//            }
//        });
    }

    public class GroupListAdapter extends BaseAdapter{

        List<Group> myGroups;

        public GroupListAdapter(List<Group> groupList){
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

        @SuppressLint({"ViewHolder", "InflateParams"})
        @Override
        public View getView(final int position, View view, ViewGroup viewGroup) {


            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (layoutInflater != null) {
                view = layoutInflater.inflate(R.layout.find_group_result, null);
            }

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(FindGroupResult.this, "yeah", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FindGroupResult.this, GroupInformation.class);

                    intent.putExtra("Group", groupList.get(position));
                    startActivity(intent);
                }
            });

            //ImageView groupIconImageView = view.findViewById(R.id.groupIcon);
            TextView groupNameTextView = view.findViewById((R.id.group_name));
            TextView groupTargetTextView = view.findViewById((R.id.group_target));

            groupNameTextView.setText(myGroups.get(position).getName());
            groupTargetTextView.setText(myGroups.get(position).getGroupTarget());

            return view;
        }
    }
}
