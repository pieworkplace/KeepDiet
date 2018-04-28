package com.keepdiet.android.keepdiet;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.keepdiet.android.keepdiet.userData.CaloriesGroupGoal;
import com.keepdiet.android.keepdiet.userData.Group;
import com.keepdiet.android.keepdiet.userData.GroupGoal;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends Fragment {


    public GroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group, container, false);
        if (((MainActivity)getActivity()).group == null){
            // inflate error alert
            View errorAlertView = inflater.inflate(R.layout.no_group_error_message, container, false);
            ((FrameLayout) view.findViewById(R.id.group_fragment_no_group_error)).addView(errorAlertView);
            view.findViewById(R.id.join_group).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(), FindGroupActivity.class));
                }
            });
            view.findViewById(R.id.start_group_in_group_find_error).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(), StartGroupActivity.class));
                }
            });
        }
        else
        {
//            Group group1 = new Group();
//            Group group2 = new Group();

//            group1.setName("Super Stomach");
//            group2.setName("Keep Running");
//            group1.setGroupGoal(new CaloriesGroupGoal(false, 4000));
//            group2.setGroupGoal(new GroupGoal() {
//                @Override
//                public String toString() {
//                    return "Keep running for 30 mins/day.";
//                }
//            });
//            groupList.add(group1);
//            groupList.add(group2);
            List<Group> groupList= new ArrayList<>();
            ListView listView = view.findViewById(R.id.group_fragment_groups);
            listView.setAdapter(new GroupListAdapter(groupList));

            View errorAlertView = inflater.inflate(R.layout.no_group_error_message, container, false);
            ((FrameLayout) view.findViewById(R.id.group_fragment_no_group_error)).addView(errorAlertView);
            view.findViewById(R.id.join_group).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(), FindGroupActivity.class));
                }
            });
            view.findViewById(R.id.start_group_in_group_find_error).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(), StartGroupActivity.class));
                }
            });
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private class GroupListAdapter extends BaseAdapter {

        List<Group> myGroups;

        GroupListAdapter(List<Group> groupList) {
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
            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (layoutInflater != null) {
                view = layoutInflater.inflate(R.layout.find_group_result, null);
            }

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), GroupInformationActivity.class);
                    intent.putExtra("Group", myGroups.get(position));
                    intent.putExtra("joinOrDelete", "quit");
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

